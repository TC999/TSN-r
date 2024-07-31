package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.p397e.C10331c;

/* renamed from: com.kwad.sdk.utils.ap */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11023ap {
    /* renamed from: a */
    private static void m24090a(RuntimeException runtimeException) {
        C10331c.printStackTrace(runtimeException);
    }

    /* renamed from: ax */
    public static String m24089ax(String str, @Nullable String str2) {
        if (TextUtils.isEmpty(str)) {
            m24090a(new NullPointerException("Argument cannot be null " + str2));
        }
        return str;
    }

    public static void checkArgument(boolean z, @Nullable Object obj) {
        if (z) {
            return;
        }
        m24090a(new IllegalArgumentException("Expression cannot be false " + obj));
    }

    public static <T> T checkNotNull(T t) {
        return (T) m24087g(t, "");
    }

    /* renamed from: f */
    public static void m24088f(Object... objArr) {
        for (int i = 0; i < 2; i++) {
            checkNotNull(objArr[i]);
        }
    }

    /* renamed from: g */
    public static <T> T m24087g(T t, @Nullable String str) {
        if (t == null) {
            m24090a(new NullPointerException("Argument cannot be null " + str));
        }
        return t;
    }

    /* renamed from: gH */
    public static String m24086gH(String str) {
        return m24089ax(str, "");
    }
}
