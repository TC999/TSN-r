package com.bytedance.sdk.openadsdk.ats;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public @interface ATSApi {
    String value() default "";
}
