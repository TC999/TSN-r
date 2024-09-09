package com.baidu.liantian.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* compiled from: HandlerHelper.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class l {

    /* renamed from: c  reason: collision with root package name */
    private static final l f12135c = new l();

    /* renamed from: a  reason: collision with root package name */
    private HandlerThread f12136a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f12137b;

    private l() {
        HandlerThread handlerThread = new HandlerThread("rp_th", 10);
        this.f12136a = handlerThread;
        handlerThread.start();
        this.f12137b = new Handler(this.f12136a.getLooper());
    }

    public static Looper a() {
        return f12135c.f12137b.getLooper();
    }
}
