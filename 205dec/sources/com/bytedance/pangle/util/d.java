package com.bytedance.pangle.util;

import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class d {
    public static <T> boolean a(@Nullable T[] tArr) {
        return tArr == null || tArr.length == 0;
    }

    public static <T> boolean a(@Nullable T[] tArr, T[] tArr2) {
        if (tArr2 == null) {
            return true;
        }
        for (T t3 : tArr2) {
            if (!a(tArr, t3)) {
                return false;
            }
        }
        return true;
    }

    private static <T> boolean a(@Nullable T[] tArr, T t3) {
        int i4;
        if (tArr != null) {
            i4 = 0;
            while (i4 < tArr.length) {
                if (tArr[i4] == t3 || (tArr[i4] != null && tArr[i4].equals(t3))) {
                    break;
                }
                i4++;
            }
        }
        i4 = -1;
        return i4 != -1;
    }
}
