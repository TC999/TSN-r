package com.ss.android.downloadlib;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class kf {
    private static volatile kf ok;

    /* renamed from: a  reason: collision with root package name */
    private com.ss.android.download.api.config.kf f48848a = null;

    private kf() {
    }

    public static kf ok() {
        if (ok == null) {
            synchronized (kf.class) {
                if (ok == null) {
                    ok = new kf();
                }
            }
        }
        return ok;
    }

    public com.ss.android.download.api.config.kf a() {
        return this.f48848a;
    }
}
