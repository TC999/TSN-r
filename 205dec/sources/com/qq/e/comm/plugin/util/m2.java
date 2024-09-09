package com.qq.e.comm.plugin.util;

import android.os.Build;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class m2 {
    public static boolean a() {
        try {
            Class.forName("com.qq.e.ads.cfg.VideoOption");
            return Build.VERSION.SDK_INT >= 14;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean b() {
        try {
            Class.forName("com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener");
            return Build.VERSION.SDK_INT >= 14;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
