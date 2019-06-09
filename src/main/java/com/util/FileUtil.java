package com.util;

import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

    public static void exportFile(String filePath, String fileName, String sourceText,
            String convertedText) throws IOException {
        FileWriter fw = new FileWriter(createFilePath(filePath, fileName));
        fw.write(createMessage(sourceText, convertedText));
        fw.close();
    }

    private static String createFilePath(String filePath, String fileName) {

        StringBuilder sb = new StringBuilder();
        sb.append(filePath);
        sb.append("\\");
        sb.append(fileName);
        sb.append(".log");

        return sb.toString();
    }

    private static String createMessage(String sourceText, String convertedText) {

        StringBuilder sb = new StringBuilder();
        sb.append("[Source Text]");
        sb.append("\n");
        sb.append(sourceText);
        sb.append("\n");
        sb.append("[Converted Text]");
        sb.append("\n");
        sb.append(convertedText);
        sb.append("\n");

        return sb.toString();
    }
}
