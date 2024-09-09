package com.bytedance.c.w.ux;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile HandlerThread f26610a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile Handler f26611b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile Handler f26612c;

    public static HandlerThread a() {
        if (f26610a == null) {
            synchronized (d.class) {
                if (f26610a == null) {
                    f26610a = new HandlerThread("default_npth_thread");
                    f26610a.start();
                    f26611b = new Handler(f26610a.getLooper());
                }
            }
        }
        return f26610a;
    }

    public static Handler b() {
        if (f26611b == null) {
            a();
        }
        return f26611b;
    }
}
