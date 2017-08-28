package com.pipi.base.annotation;

import java.lang.annotation.*;

/**
 * Created by pipi on 2017/8/28.
 */
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    String author() default "pipi";
    String date();
    int version() default 1;
    String comment();
}
