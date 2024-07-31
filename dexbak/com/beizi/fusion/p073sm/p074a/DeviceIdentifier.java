package com.beizi.fusion.p073sm.p074a;

import android.app.Application;

/* renamed from: com.beizi.fusion.sm.a.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class DeviceIdentifier {

    /* renamed from: a */
    private static volatile boolean f11520a;

    /* renamed from: b */
    private static volatile String f11521b;

    /* renamed from: c */
    private static volatile String f11522c;

    private DeviceIdentifier() {
    }

    /* renamed from: a */
    public static void m48135a(Application application) {
        if (f11520a) {
            return;
        }
        synchronized (DeviceIdentifier.class) {
            if (!f11520a) {
                DeviceID.m48150a(application);
                f11520a = true;
            }
        }
    }
}
