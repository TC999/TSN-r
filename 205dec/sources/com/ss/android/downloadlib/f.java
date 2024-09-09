package com.ss.android.downloadlib;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    private static volatile f f48811c;

    /* renamed from: w  reason: collision with root package name */
    private com.ss.android.download.api.config.f f48812w = null;

    private f() {
    }

    public static f c() {
        if (f48811c == null) {
            synchronized (f.class) {
                if (f48811c == null) {
                    f48811c = new f();
                }
            }
        }
        return f48811c;
    }

    public com.ss.android.download.api.config.f w() {
        return this.f48812w;
    }
}
