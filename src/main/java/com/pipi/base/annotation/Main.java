package com.pipi.base.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by pipi on 2017/8/28.
 */
public class Main {

    public static void main(String[] args) {
        try {
            for (Method method : Main.class
                    .getClassLoader()
                    .loadClass(("com.pipi.base.annotation.AnnotationExample"))
                    .getMethods()) {
                // checks if MethodInfo annotation is present for the method
                if (method.isAnnotationPresent(MethodInfo.class)) {
                    try {
                        // iterates all the annotations available in the method
                        for (Annotation anno : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in Method "+ method + " : " + anno);
                        }
                        MethodInfo methodAnno = method.getAnnotation(MethodInfo.class);
                        if (methodAnno.version() == 1) {
                            System.out.println("Method with revision no 1 = "+ method);
                        }

                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
