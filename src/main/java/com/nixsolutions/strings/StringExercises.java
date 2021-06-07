package com.nixsolutions.strings;


import com.nixsolutions.strings.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;

import static java.lang.Character.toLowerCase;
import static java.lang.Character.toUpperCase;
import static java.lang.String.valueOf;


public class StringExercises implements StringUtils {
    private static final Logger LOG = LogManager.getLogger(StringExercises.class);

    @Override
    public byte[] ip2Bytes(String ip) {
        return new byte[0];
    }

    @Override
    public String convertIp(String ip) {
        String input = ip;
        String regex = ("(^[0-9])([0-9])([0-9])(\\s|-|.)([0-9])([0-9])([0-9])(\\s|-|.)([0-9])([0-9])([0-9])(\\s|-|.)([0-9])([0-9])([0-9])$");
        boolean condition = input.matches(regex);
        if(condition !=true){
            String output = input.replaceAll("...", "000.");
            System.out.println("result " + output);
        }
        else{
            System.out.println(input.matches(regex) + input);
        }

        return null;


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
        char[] alpha = new char[26];
        for (int i = 0; i < 26; i++) {
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

    @Override
    public String toCamelCase(String str) {
        System.out.println("Converting a string to CamelCase ..." + str);
        //LOG.debug("Converting a string to CamelCase ...", str);
        String input = str;
        String spaceRemove = input.replaceAll("\\s", "");
        String[] Res = spaceRemove.split("");
        String output1 = valueOf(Res);
        String output = output1.substring(0, 1).toUpperCase();
        // String upperCase = spaceRemove.toUpperCase();
        // String output = upperCase.substring(1, 4).toLowerCase()+upperCase.substring(7, 10).toLowerCase()+upperCase.substring(12, 14).toLowerCase();
        System.out.println("Converted: " + output);
        //LOG.debug("Converted: {}.", output);
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
