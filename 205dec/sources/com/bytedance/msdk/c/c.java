package com.bytedance.msdk.c;

import android.text.TextUtils;
import com.bytedance.msdk.core.k.p;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c {
    public static String c(int i4) {
        return i4 == 3 ? "gdt" : i4 == 2 ? "admob" : i4 == 1 ? "pangle" : i4 == 4 ? "mintegral" : i4 == 5 ? "unity" : i4 == 6 ? "baidu" : i4 == 7 ? "ks" : i4 == 8 ? "sigmob" : i4 == 9 ? "klevin" : i4 == -1 ? "custom" : "";
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
                return "Native";
            case 6:
            default:
                return null;
            case 7:
                return (i5 != 6 && i5 == 7) ? "FullVideo" : "RewardVideo";
            case 8:
                return "FullVideo";
            case 9:
                return "Draw";
            case 10:
                if (i5 == 1) {
                    return "Interstitial";
                }
                if (i5 == 2) {
                    return "FullVideo";
                }
                return null;
        }
    }

    public static String c(String str) {
        return TextUtils.isEmpty(str) ? str : str.equalsIgnoreCase("gdt") ? "gdt" : str.equalsIgnoreCase("admob") ? "admob" : str.equalsIgnoreCase("pangle") ? "pangle" : str.equalsIgnoreCase("mintegral") ? "mintegral" : str.equalsIgnoreCase("unity") ? "unity" : str.equalsIgnoreCase("baidu") ? "baidu" : str.equalsIgnoreCase("ks") ? "ks" : str.equalsIgnoreCase("sigmob") ? "sigmob" : str.equalsIgnoreCase("klevin") ? "klevin" : str;
    }

    public static int w(String str) {
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
        return str.equalsIgnoreCase("klevin") ? 9 : -1;
    }

    public static String w(int i4) {
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
                return "UnKnow";
            case 7:
                return "RewardVideo";
            case 8:
                return "FullVideo";
            case 9:
                return "Draw";
            case 10:
                return "InterstitialFull";
        }
    }

    public static String c(int i4, int i5, p pVar) {
        switch (i4) {
            case 1:
                return "Banner";
            case 2:
                return "Interstitial";
            case 3:
            case 4:
                return "Splash";
            case 5:
                return (pVar == null || pVar.gd() != 1) ? "Native-\u81ea\u6e32\u67d3" : "Native-\u6a21\u677f\u6e32\u67d3";
            case 6:
            default:
                return null;
            case 7:
                return (i5 != 6 && i5 == 7) ? "Reward_FullVideo" : "Reward_RewardVideo";
            case 8:
                return "FullVideo";
            case 9:
                return "NativeDraw";
            case 10:
                if (i5 == 1) {
                    return "InterstitialFull\u2014Interstitial";
                }
                if (i5 == 2) {
                    return "InterstitialFull\u2014FullVideo";
                }
                return null;
        }
    }
}
