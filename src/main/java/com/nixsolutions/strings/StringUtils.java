package com.nixsolutions.strings;

public interface StringUtils {

    byte[] ip2Bytes(String ip);

    String convertIp(String ip);

    StringBuilder alphabet();

    String[] uri2Array(String uri);

    String toCamelCase(String str);

    String fromCamelCase(String camelStr);


}
