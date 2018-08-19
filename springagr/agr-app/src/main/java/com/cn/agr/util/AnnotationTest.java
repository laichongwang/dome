package com.cn.agr.util;


import java.lang.annotation.Annotation;
import java.lang.reflect.Proxy;

@Deprecated
public class AnnotationTest {

    public void getAnnotations() {

        Annotation[] annotations = AnnotationTest.class.getAnnotations();

        Deprecated annotation = AnnotationTest.class.getAnnotation(Deprecated.class);

    }

}
