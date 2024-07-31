package com.bxkj.base.p085v2.common.ext;

import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import retrofit2.HttpException;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u0002*\u00060\u0000j\u0002`\u0001¨\u0006\u0004"}, m12616d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "", "a", "base_release"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.common.ext.e */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class ExceptionExt {
    /* renamed from: a */
    public static final boolean m43845a(@NotNull Exception exc) {
        C14342f0.m8184p(exc, "<this>");
        if (exc instanceof HttpException) {
            HttpException httpException = (HttpException) exc;
            if (httpException.code() == 502 || httpException.code() == 503) {
                return true;
            }
        }
        return false;
    }
}
