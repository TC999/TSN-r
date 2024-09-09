package com.bytedance.msdk.base;

import android.text.TextUtils;

/* compiled from: Const.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class a {
    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.startsWith("gdt")) {
            return 3;
        }
        if (str.startsWith("admob")) {
            return 2;
        }
        if (str.equalsIgnoreCase("pangle")) {
            return 1;
        }
        if (str.equalsIgnoreCase("mintegral")) {
            return 4;
        }
        if (str.equalsIgnoreCase("unity")) {
            return 5;
        }
        if (str.equalsIgnoreCase("baidu")) {
            return 6;
        }
        if (str.equalsIgnoreCase("ks")) {
            return 7;
        }
        if (str.equalsIgnoreCase("sigmob")) {
            return 8;
        }
        return str.equalsIgnoreCase("klevin") ? 9 : 0;
    }

    public static String b(int i4) {
        switch (i4) {
            case 1:
                return "Banner";
            case 2:
                return "Interstitial";
            case 3:
            case 4:
                return "Splash";
            case 5:
                return "Native";
            case 6:
            default:
                return null;
            case 7:
                return "RewardVideo";
            case 8:
                return "FullVideo";
            case 9:
                return "NativeDraw";
        }
    }

    public static String c(int i4, int i5) {
        switch (i4) {
            case 1:
                return "Banner";
            case 2:
                return "Interstitial";
            case 3:
            case 4:
                return "Splash";
            case 5:
                return i5 == 1 ? "Native-\u6a21\u677f\u6e32\u67d3" : "Native";
            case 6:
            default:
                return null;
            case 7:
                return "RewardVideo";
            case 8:
                return "FullVideo";
            case 9:
                return "NativeDraw";
        }
    }

    public static String d(int i4) {
        return i4 == 3 ? "gdt" : i4 == 2 ? "admob" : i4 == 1 ? "pangle" : i4 == 4 ? "mintegral" : i4 == 5 ? "unity" : i4 == 6 ? "baidu" : i4 == 7 ? "ks" : i4 == 8 ? "sigmob" : i4 == 9 ? "klevin" : "";
    }

    public static String e(String str) {
        return TextUtils.isEmpty(str) ? str : str.equalsIgnoreCase("gdt") ? "gdt" : str.equalsIgnoreCase("admob") ? "admob" : str.equalsIgnoreCase("pangle") ? "pangle" : str.equalsIgnoreCase("mintegral") ? "mintegral" : str.equalsIgnoreCase("unity") ? "unity" : str.equalsIgnoreCase("baidu") ? "baidu" : str.equalsIgnoreCase("ks") ? "ks" : str.equalsIgnoreCase("sigmob") ? "sigmob" : str.equalsIgnoreCase("klevin") ? "klevin" : str;
    }
}
