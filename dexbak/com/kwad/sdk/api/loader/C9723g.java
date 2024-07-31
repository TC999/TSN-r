package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.kwad.sdk.api.loader.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9723g {
    static String amm = "autoRevert";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: K */
    public static boolean m27937K(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        if (TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
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
            return split.length > split2.length;
        }
        return true;
    }

    /* renamed from: aA */
    public static String m27936aA(Context context) {
        return getVersion(context, "newversion");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: aB */
    public static String m27935aB(Context context) {
        return getVersion(context, "apiversion");
    }

    /* renamed from: az */
    public static String m27934az(Context context) {
        return getVersion(context, "curversion");
    }

    /* renamed from: d */
    private static void m27933d(Context context, String str, String str2) {
        C9757t.m27843b(context, str, str2);
    }

    private static String getVersion(Context context, String str) {
        return C9757t.m27841c(context, str, "");
    }

    /* renamed from: m */
    public static void m27932m(Context context, String str) {
        m27933d(context, "curversion", str);
    }

    /* renamed from: n */
    public static void m27931n(Context context, String str) {
        m27933d(context, "newversion", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public static void m27930o(Context context, String str) {
        m27933d(context, "apiversion", str);
    }
}
