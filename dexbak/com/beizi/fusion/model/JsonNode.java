package com.beizi.fusion.model;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public @interface JsonNode {
    String description() default "";

    String key();
}
