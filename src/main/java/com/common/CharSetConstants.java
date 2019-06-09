package com.common;

public enum CharSetConstants {

    SHIFT_JIS(
            "Shift-JIS"),
    BASE64(
            "Base64"),
    BASE64_MIME(
            "Base64_MIME"),
    HEXA_DECIMAL(
            "HexaDecimal"),
    BYTE(
            "byte");

    private String charSet;

    private CharSetConstants(String charSet) {
        this.charSet = charSet;
    }

    public String getValue() {
        return this.charSet;
    }

    public static CharSetConstants getEnumName(String charSet) {
        for (CharSetConstants cc : values()) {
            if (cc.getValue().equals(charSet)) {
                return cc;
            }
        }
        throw new IllegalArgumentException("undefined : " + charSet);
    }

}
