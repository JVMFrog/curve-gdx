package com.intkgc.curve.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * {@code Parameter} - is an annotation for saving fields to json file
 *
 * @author Kirbo
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Parameter {
    /**
     * Json key
     */
    String jsonKey();
}
