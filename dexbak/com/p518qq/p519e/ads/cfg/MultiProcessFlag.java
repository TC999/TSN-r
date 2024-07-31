package com.p518qq.p519e.ads.cfg;

import com.p518qq.p519e.comm.util.GDTLogger;

/* renamed from: com.qq.e.ads.cfg.MultiProcessFlag */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MultiProcessFlag {

    /* renamed from: a */
    private static boolean f32747a;

    /* renamed from: b */
    private static boolean f32748b;

    public static boolean isMultiProcess() {
        return f32747a;
    }

    public static void setMultiProcess(boolean z) {
        if (f32748b) {
            GDTLogger.m20304w("MultiProcessFlag已经设置过，再次设置无效");
            return;
        }
        f32748b = true;
        f32747a = z;
    }
}
