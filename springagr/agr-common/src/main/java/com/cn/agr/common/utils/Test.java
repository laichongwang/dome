package com.cn.agr.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] agr) {

        /**
         String pt = "^[1][358][0-9][0-9]{8}$";
         String pt2 = "^[\\w]{3,10}\\@[\\w]{1,6}\\.(com|cn)$";
         String input2 = "6gjuiuihgh@qq.com";
         String input = "15823556512";
         //  matcherTest(pt2, input2);
         pl(input2.matches(pt2));
         */

        /**
         String input2 = "JavajavaJAvaJaVaIloveJavayouHateJAVAasasfddda";
         String pt2 = "[aj]+";// 匹配首尾空格的正则表达式
         pl(input2.matches(pt2));
         pl(input2.replaceAll(pt2,"0"));
         */

        /**
         String str ="Javaj avaJAvaJa    VaIloveJa vayou HateJAVAas asfddda";
         String ragex ="\\s+";
         String newStr ="*";
         String[] s = str.split(ragex);
         System.out.println(JSON.toJSONString(s));
         */

        String str = "public static voids main(String[] args) public static void main(String[] args)public static void main(String[] args)";
        String ragex = "\\b[a-zA-Z]+\\b";
        Pattern p = Pattern.compile(ragex);
        Matcher m = p.matcher(str);
        while (m.find()) {
            String s = m.group();
            System.out.println(s);
        }
    }


    public static void pl(Object obj) {
        System.out.println(obj);
    }

    public static void testFx() {
        List<String> arr = new ArrayList<String>();
        Test t = geta(Test.class);
    }

    public static <E> E geta(Class<E> obj) {
        try {
            return obj.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void matcherTest(String pattern, String input) {
        Pattern pt = Pattern.compile(pattern);
        Matcher m = pt.matcher(input);
        if (m.matches()) {
            pl("===========" + true);
        } else {
            pl("===========" + false);
        }
    }

}

