package com.baidu.mobads.sdk.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public @interface Route {
    String name() default "";

    String path();
}
