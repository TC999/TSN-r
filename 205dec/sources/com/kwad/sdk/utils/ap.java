package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ap {
    private static void a(RuntimeException runtimeException) {
        com.kwad.sdk.core.e.c.printStackTrace(runtimeException);
    }

    public static String ax(String str, @Nullable String str2) {
        if (TextUtils.isEmpty(str)) {
            a(new NullPointerException("Argument cannot be null " + str2));
        }
        return str;
    }

    public static void checkArgument(boolean z3, @Nullable Object obj) {
        if (z3) {
            return;
        }
        a(new IllegalArgumentException("Expression cannot be false " + obj));
    }

    public static <T> T checkNotNull(T t3) {
        return (T) g(t3, "");
    }

    public static void f(Object... objArr) {
        for (int i4 = 0; i4 < 2; i4++) {
            checkNotNull(objArr[i4]);
        }
    }

    public static <T> T g(T t3, @Nullable String str) {
        if (t3 == null) {
            a(new NullPointerException("Argument cannot be null " + str));
        }
        return t3;
    }

    public static String gH(String str) {
        return ax(str, "");
    }
}
