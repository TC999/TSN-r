package com.bxkj.base.v2.common.ext;

import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import retrofit2.HttpException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ExceptionExt.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u0002*\u00060\u0000j\u0002`\u0001\u00a8\u0006\u0004"}, d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "", "a", "base_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class e {
    public static final boolean a(@NotNull Exception exc) {
        f0.p(exc, "<this>");
        if (exc instanceof HttpException) {
            HttpException httpException = (HttpException) exc;
            if (httpException.code() == 502 || httpException.code() == 503) {
                return true;
            }
        }
        return false;
    }
}
