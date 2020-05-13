package ru.vsu.cs.util;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ArrayUtils {

    public static int[] toPrimitive(Integer[] arr) {
        if (arr == null) {
            return null;
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            // автоматическая распаковка из объекта
            result[i] = arr[i];
        }
        return result;
    }

    public static double[] toPrimitive(Double[] arr) {
        if (arr == null) {
            return null;
        }
        double[] result = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            // автоматическая распаковка из объекта
            result[i] = arr[i];
        }
        return result;
    }

    /**
     * Чтение массива строк из консоли, признак окончания - пустая строка
     */
    public static String[] readLinesFromConsole() {
        Scanner scanner = new Scanner(System.in);
        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line == null || line.trim().length() == 0)
                break;
            lines.add(line);
        }
        return lines.toArray(new String[0]);
    }

    public static String[] readWordsFromFile(String fileName) throws Exception {
        String[] lines = readLinesFromFile(fileName);
        return lines[0].split("[.!?:;,]|[\\s]");
    }

    /**
     * Чтение всего текстового файла в массив строк
     */
    public static String[] readLinesFromFile(String fileName) throws Exception {
        List<String> lines;
        String line = "";
        try (Scanner scanner = new Scanner(new File(fileName), "UTF-8")) {
            lines = new ArrayList<>();
            int i = 0;
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
                line += lines.get(i);
                i++;
            }
            // обязательно, чтобы закрыть открытый файл
        }

        if (line.length() == 0) throw new Exception("File is empty.");
        return lines.toArray(new String[0]);
    }

    public static void writeWordsToFile(String fileName, String[] words, String itemFormat)
            throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(fileName)) {
            String text = "";
            for (String word : words) {
                text += word;
                text += itemFormat;
            }
            out.println(text);
        }
    }
}
