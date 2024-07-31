package com.alibaba.fastjson.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public @interface JSONPOJOBuilder {
    String buildMethod() default "build";

    String withPrefix() default "with";
}
