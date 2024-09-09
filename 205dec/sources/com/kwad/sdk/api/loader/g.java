package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.api.loader.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class g {
    static String amm = "autoRevert";

    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public interface a {
        void a(a.b bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean K(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        if (TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
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
            return split.length > split2.length;
        }
        return true;
    }

    public static String aA(Context context) {
        return getVersion(context, "newversion");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String aB(Context context) {
        return getVersion(context, "apiversion");
    }

    public static String az(Context context) {
        return getVersion(context, "curversion");
    }

    private static void d(Context context, String str, String str2) {
        t.b(context, str, str2);
    }

    private static String getVersion(Context context, String str) {
        return t.c(context, str, "");
    }

    public static void m(Context context, String str) {
        d(context, "curversion", str);
    }

    public static void n(Context context, String str) {
        d(context, "newversion", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void o(Context context, String str) {
        d(context, "apiversion", str);
    }
}
