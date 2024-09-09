package com.qq.e.comm.plugin.d;

import android.os.Handler;
import android.os.HandlerThread;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        static final Handler f42178a;

        static {
            HandlerThread handlerThread = new HandlerThread("GDTAirbagThread");
            handlerThread.start();
            f42178a = new Handler(handlerThread.getLooper());
        }
    }

    public static Handler a() {
        return a.f42178a;
    }
}
