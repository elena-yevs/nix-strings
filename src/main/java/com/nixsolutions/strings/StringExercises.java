package com.nixsolutions.strings;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Character.toLowerCase;
import static java.lang.Character.toUpperCase;
import static java.lang.String.format;


public class StringExercises implements StringUtils {
    private static final int IP_OCTET_AMOUNT = 4;
    private static final int ALPHABET_LENGTH = 26;
    private static final Logger LOG = LogManager.getLogger(StringExercises.class);

    @Override
    public byte[] ip2Bytes(String ip) {
        return new byte[0];
    }

    @Override
    public String convertIp(String ip) {
        Pattern pattern = Pattern.compile(
                "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$"
        );
        Matcher matcher = pattern.matcher(ip);
        if (!matcher.matches()) {
            return null;
        }
        int[] octet = new int[IP_OCTET_AMOUNT];
        for (int g = 1; g <= IP_OCTET_AMOUNT; g++) {
            String octetStr = matcher.group(g);
            octet[g - 1] = Integer.parseInt(octetStr);
        }
        return format("%03d.%03d.%03d.%03d", octet[0], octet[1], octet[2], octet[3]);
    }

    /**
     * Создает строку символов английского алфавита "A..Z", где четные буквы upper case, а нечетные в low case.
     *
     * @return английский алфавит, где четная буква в upperCase
     */
    @Override
    public StringBuilder alphabet() {
        String registr = "";
        //LOG.debug("Setting the alphabet in a different case ...");
        char[] alpha = new char[ALPHABET_LENGTH];
        for (int i = 0; i < ALPHABET_LENGTH; i++) {
            alpha[i] = (char) (97 + i);
        }
        for (int i = 0; i < 26; i++) {
            if (i % 2 != 0) {
                registr = registr + valueOf(alpha).substring(i, i + 1).toUpperCase();
            } else {
                registr = registr + valueOf(alpha).substring(i, i + 1).toLowerCase();
            }
        }
        StringBuilder output = new StringBuilder(registr);
        //LOG.debug("Alphabet: {}.", output);
        System.out.println("Alphabet: " + output);
        return output;
    }

    /**
     * Преобразует url в массив составляющих.
     *
     * <p>Если во входной строке какая-то составлящая отсутствует,
     *
     * <p>соответсвующее значение в выходном массиве пустое.
     *
     * @param uri входной url
     * @return массив строк
     */
    @Override
    public String[] uri2Array(String uri) {
        String input = uri;
        String[] splitUrl = uri.split("[^A-Za-z0-9]");
        System.out.println(java.util.Arrays.toString(splitUrl));
        String output = java.util.Arrays.toString(splitUrl);
        //LOG.debug("Converted: {}.", output);
        return new String[0];
    }

    /**
     * Преобразует словосочетание в CamelCase независимо от оригинального регистра букв.
     *
     * <p>Регистр первой остается нетронутым.
     *
     * <p>Разделителем слов служат пробелы и запятые.
     *
     * @param str словосочетание в разном регисте
     * @return словосочетание в CamelCase ил null, если строка пустая
     */
    @Override
    public String toCamelCase(String str) {
        System.out.println("Converting a string to CamelCase ..." + str);
        //LOG.debug("Converting a string to CamelCase ...", str);
        String input = str;
        String lowerCase = input.toLowerCase();
        String capitalLetter = lowerCase.substring(0, 1).toUpperCase();
        for (int i = 1; i < lowerCase.length(); i++) {
            // смотрим, был ли слева пробел:
            if (" ".equals(lowerCase.substring(i - 1, i)))
                capitalLetter = capitalLetter + lowerCase.substring(i, i + 1).toUpperCase();
            else
                capitalLetter = capitalLetter + lowerCase.substring(i, i + 1);
        }
        String symbolsRemove = capitalLetter.replaceAll("[^a-zA-Z ]", ""); //удалит все небуквенные символы
        String output = symbolsRemove.replaceAll("\\s", ""); //удалить пробелы
        System.out.println("Converted: " + output);
        if (str == null) {
            return null;
        }
        return output;

    }

    /**
     * Преобразует CamelCase строку в словосочетания в нижнем регистре.
     *
     * <p>Первая буква остается заглавной.
     *
     * @param camelStr входная строка
     * @return строка с заглавной первой буквой
     */
    @Override
    public String fromCamelCase(String camelStr) {
        System.out.println("Converting a string from CamelCase ..." + camelStr);
        //LOG.debug("Converting a string from CamelCase ...", camelStr);
        String input = camelStr;
        String lowerCase = input.toLowerCase();
        String capitalLetter = lowerCase.substring(0, 1).toUpperCase() + lowerCase.substring(1);
        String output = capitalLetter.replaceAll(".....(?!$)", "$0 ");
        System.out.println("Converted : " + output);
        // LOG.debug("Converted: {}.", output);
        return output;
    }
}
