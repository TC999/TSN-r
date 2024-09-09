package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.Looper;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev {

    /* renamed from: c  reason: collision with root package name */
    private static volatile Handler f30187c;

    public static Handler c() {
        return com.bytedance.sdk.component.gd.w.c.c().w();
    }

    public static Handler w() {
        if (f30187c == null) {
            synchronized (ev.class) {
                if (f30187c == null) {
                    f30187c = new Handler(Looper.getMainLooper());
                }
            }
        }
        return f30187c;
    }
}
