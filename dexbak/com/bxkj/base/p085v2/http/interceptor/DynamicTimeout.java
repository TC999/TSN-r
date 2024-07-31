package com.bxkj.base.p085v2.http.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* compiled from: DynamicTimeout.kt */
@Target({ElementType.METHOD})
@Metadata(m12617d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, m12616d2 = {"Lcom/bxkj/base/v2/http/interceptor/DynamicTimeout;", "", "timeout", "", "()I", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1}, m12612xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER})
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
/* renamed from: com.bxkj.base.v2.http.interceptor.DynamicTimeout */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public @interface DynamicTimeout {
    int timeout();
}
