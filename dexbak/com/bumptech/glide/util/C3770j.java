package com.bumptech.glide.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;

/* compiled from: Preconditions.java */
/* renamed from: com.bumptech.glide.util.j */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C3770j {
    private C3770j() {
    }

    /* renamed from: a */
    public static void m44395a(boolean z, @NonNull String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    @NonNull
    /* renamed from: b */
    public static String m44394b(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        return str;
    }

    @NonNull
    /* renamed from: c */
    public static <T extends Collection<Y>, Y> T m44393c(@NonNull T t) {
        if (t.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        return t;
    }

    @NonNull
    /* renamed from: d */
    public static <T> T m44392d(@Nullable T t) {
        return (T) m44391e(t, "Argument must not be null");
    }

    @NonNull
    /* renamed from: e */
    public static <T> T m44391e(@Nullable T t, @NonNull String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }
}
