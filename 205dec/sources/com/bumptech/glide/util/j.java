package com.bumptech.glide.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: Preconditions.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class j {
    private j() {
    }

    public static void a(boolean z3, @NonNull String str) {
        if (!z3) {
            throw new IllegalArgumentException(str);
        }
    }

    @NonNull
    public static String b(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        return str;
    }

    @NonNull
    public static <T extends Collection<Y>, Y> T c(@NonNull T t3) {
        if (t3.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        return t3;
    }

    @NonNull
    public static <T> T d(@Nullable T t3) {
        return (T) e(t3, "Argument must not be null");
    }

    @NonNull
    public static <T> T e(@Nullable T t3, @NonNull String str) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(str);
    }
}
