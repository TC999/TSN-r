package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class MultiProcessFlag {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f41462a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f41463b;

    public static boolean isMultiProcess() {
        return f41462a;
    }

    public static void setMultiProcess(boolean z3) {
        if (f41463b) {
            GDTLogger.w("MultiProcessFlag\u5df2\u7ecf\u8bbe\u7f6e\u8fc7\uff0c\u518d\u6b21\u8bbe\u7f6e\u65e0\u6548");
            return;
        }
        f41463b = true;
        f41462a = z3;
    }
}
