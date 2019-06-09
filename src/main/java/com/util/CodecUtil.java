package com.util;

import java.nio.charset.Charset;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import com.common.CharSetConstants;

public class CodecUtil {

    private static String CHARACTER_SET = "";
    private static String SOURCE_TEXT = "";
    private static byte[] BINARY_DATA;
    private static char[] ENCODED_HEX_STRING;

    public static String convertString(String srcText, String charSet) throws DecoderException {
        CHARACTER_SET = charSet;
        SOURCE_TEXT = srcText;
        BINARY_DATA = SOURCE_TEXT.getBytes();
        ENCODED_HEX_STRING = Hex.encodeHex(BINARY_DATA);

        String encodedText = "";

        switch (CharSetConstants.getEnumName(CHARACTER_SET)) {
            case SHIFT_JIS:
                encodedText = convertToSjis();
                break;
            case BASE64:
                encodedText = convertToBase64();
                break;
            case BASE64_MIME:
                encodedText = convertToBase64Mime();
                break;
            case HEXA_DECIMAL:
                encodedText = convertToHexaDecimal();
                break;
            case BYTE:
                encodedText = convertToByte();
                break;
            default:
                encodedText = "";
                throw new DecoderException();
        }
        return encodedText;
    }

    private static String convertToSjis() {
        return new String(BINARY_DATA, Charset.forName(CHARACTER_SET));
    }

    private static String convertToBase64() {
        return Base64.encodeBase64String(BINARY_DATA);
    }

    private static String convertToBase64Mime() {
        return Base64.encodeBase64URLSafeString(BINARY_DATA);
    }

    private static String convertToHexaDecimal() {
        return new String(ENCODED_HEX_STRING);
    }

    private static String convertToByte() throws DecoderException {
        byte[] bytes = null;
        bytes = Hex.decodeHex(SOURCE_TEXT.toCharArray());
        return new String(bytes);
    }

}
