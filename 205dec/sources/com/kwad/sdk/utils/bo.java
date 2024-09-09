package com.kwad.sdk.utils;

import android.text.TextUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class bo {
    public static boolean az(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            for (int i4 = 0; i4 < split.length && i4 < split2.length; i4++) {
                try {
                    int parseInt = Integer.parseInt(split[i4]) - Integer.parseInt(split2[i4]);
                    if (parseInt > 0) {
                        return true;
                    }
                    if (parseInt < 0) {
                        return false;
                    }
                } catch (NumberFormatException unused) {
                    return false;
                }
            }
            if (split.length >= split2.length) {
                return true;
            }
        }
        return false;
    }
}
