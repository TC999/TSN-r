package com.beizi.fusion.p072g;

import android.os.Handler;
import android.os.Looper;

/* renamed from: com.beizi.fusion.g.aa */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class HandlerUtil {

    /* renamed from: a */
    private static final Handler f11225a = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    public static void m48514a(Runnable runnable, long j) {
        f11225a.postDelayed(runnable, j);
    }
}
