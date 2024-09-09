package com.bykv.vk.component.ttvideo.player;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public @interface CalledByNative {
    String value() default "";
}
