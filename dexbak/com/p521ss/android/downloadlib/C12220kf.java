package com.p521ss.android.downloadlib;

import com.p521ss.android.download.api.config.InterfaceC11960kf;

/* renamed from: com.ss.android.downloadlib.kf */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12220kf {

    /* renamed from: ok */
    private static volatile C12220kf f34496ok;

    /* renamed from: a */
    private InterfaceC11960kf f34497a = null;

    private C12220kf() {
    }

    /* renamed from: ok */
    public static C12220kf m18669ok() {
        if (f34496ok == null) {
            synchronized (C12220kf.class) {
                if (f34496ok == null) {
                    f34496ok = new C12220kf();
                }
            }
        }
        return f34496ok;
    }

    /* renamed from: a */
    public InterfaceC11960kf m18670a() {
        return this.f34497a;
    }
}
