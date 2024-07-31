package com.bytedance.pangle.util;

import androidx.annotation.Nullable;

/* renamed from: com.bytedance.pangle.util.d */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6248d {
    /* renamed from: a */
    public static <T> boolean m36906a(@Nullable T[] tArr) {
        return tArr == null || tArr.length == 0;
    }

    /* renamed from: a */
    public static <T> boolean m36904a(@Nullable T[] tArr, T[] tArr2) {
        if (tArr2 == null) {
            return true;
        }
        for (T t : tArr2) {
            if (!m36905a(tArr, t)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static <T> boolean m36905a(@Nullable T[] tArr, T t) {
        int i;
        if (tArr != null) {
            i = 0;
            while (i < tArr.length) {
                if (tArr[i] == t || (tArr[i] != null && tArr[i].equals(t))) {
                    break;
                }
                i++;
            }
        }
        i = -1;
        return i != -1;
    }
}
