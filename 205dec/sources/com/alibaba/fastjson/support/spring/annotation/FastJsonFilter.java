package com.alibaba.fastjson.support.spring.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
@Target({ElementType.ANNOTATION_TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public @interface FastJsonFilter {
    Class<?> clazz();

    String[] props();
}
