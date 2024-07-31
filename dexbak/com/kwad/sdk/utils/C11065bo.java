package com.kwad.sdk.utils;

import android.text.TextUtils;

/* renamed from: com.kwad.sdk.utils.bo */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11065bo {
    /* renamed from: az */
    public static boolean m23855az(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            for (int i = 0; i < split.length && i < split2.length; i++) {
                try {
                    int parseInt = Integer.parseInt(split[i]) - Integer.parseInt(split2[i]);
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
