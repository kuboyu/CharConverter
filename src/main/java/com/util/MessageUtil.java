package com.util;

public class MessageUtil {

    public static String createResultMessage(String processing, boolean isFalse) {

        StringBuilder sb = new StringBuilder();
        sb.append(processing);
        if (!isFalse) {
            sb.append(" Is Failed. ");
        } else {
            sb.append(" Is Success. ");
        }

        return sb.toString();
    }

    public static String createResultMessage(String processing, boolean isFalse, String charSet) {

        StringBuilder sb = new StringBuilder();
        sb.append(processing);
        if (!isFalse) {
            sb.append(" Is Failed. ");
        } else {
            sb.append(" Is Success. ");
        }
        sb.append("[");
        sb.append(charSet);
        sb.append("]");

        return sb.toString();
    }

}
