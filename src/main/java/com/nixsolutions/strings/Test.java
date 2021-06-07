package com.nixsolutions.strings;

import com.nixsolutions.strings.StringExercises;
import com.nixsolutions.strings.StringUtils;

/**
 * @author Elena Yevsiukova
 */
public class Test {
    private final StringUtils util;

    private Test() {
        this.util = new StringExercises();
    }

    private void fromCamelCase() {
        util.fromCamelCase("HelloWORLDJAVA");
    }
    private void toCamelCase() {
        util.toCamelCase("hEllo, w oRL d J Av a");
    }

    private void alphabet(){
        util.alphabet();
    }

    private void convertIp(){
        util.convertIp("1.1.1.1");
    }
     private void uri2Array(){
        util.uri2Array("https://localhost:8080/prodpat/admin/page1");
     }

    public static void main(String[] args) {
        Test show = new Test();
        show.fromCamelCase();
        show.toCamelCase();
        show.alphabet();
        show.uri2Array();
        show.convertIp();
    }
}
