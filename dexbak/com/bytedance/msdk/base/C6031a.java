package com.bytedance.msdk.base;

import android.text.TextUtils;
import com.kwad.components.offline.api.explore.model.ExploreConstants;

/* compiled from: Const.java */
/* renamed from: com.bytedance.msdk.base.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6031a {
    /* renamed from: a */
    public static int m37437a(String str) {
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

    /* renamed from: b */
    public static String m37436b(int i) {
        switch (i) {
            case 1:
                return "Banner";
            case 2:
                return ExploreConstants.SCENE_INTERSTITIAL;
            case 3:
            case 4:
                return ExploreConstants.SCENE_SPLASH;
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

    /* renamed from: c */
    public static String m37435c(int i, int i2) {
        switch (i) {
            case 1:
                return "Banner";
            case 2:
                return ExploreConstants.SCENE_INTERSTITIAL;
            case 3:
            case 4:
                return ExploreConstants.SCENE_SPLASH;
            case 5:
                return i2 == 1 ? "Native-模板渲染" : "Native";
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

    /* renamed from: d */
    public static String m37434d(int i) {
        return i == 3 ? "gdt" : i == 2 ? "admob" : i == 1 ? "pangle" : i == 4 ? "mintegral" : i == 5 ? "unity" : i == 6 ? "baidu" : i == 7 ? "ks" : i == 8 ? "sigmob" : i == 9 ? "klevin" : "";
    }

    /* renamed from: e */
    public static String m37433e(String str) {
        return TextUtils.isEmpty(str) ? str : str.equalsIgnoreCase("gdt") ? "gdt" : str.equalsIgnoreCase("admob") ? "admob" : str.equalsIgnoreCase("pangle") ? "pangle" : str.equalsIgnoreCase("mintegral") ? "mintegral" : str.equalsIgnoreCase("unity") ? "unity" : str.equalsIgnoreCase("baidu") ? "baidu" : str.equalsIgnoreCase("ks") ? "ks" : str.equalsIgnoreCase("sigmob") ? "sigmob" : str.equalsIgnoreCase("klevin") ? "klevin" : str;
    }
}
