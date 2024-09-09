package com.beizi.fusion.sm.a;

import android.app.Application;

/* compiled from: DeviceIdentifier.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f15070a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile String f15071b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile String f15072c;

    private b() {
    }

    public static void a(Application application) {
        if (f15070a) {
            return;
        }
        synchronized (b.class) {
            if (!f15070a) {
                a.a(application);
                f15070a = true;
            }
        }
    }
}
