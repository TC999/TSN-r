package com.ss.android.socialbase.downloader.impls;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static volatile com.ss.android.socialbase.downloader.downloader.z f49757a;
    private static volatile com.ss.android.socialbase.downloader.downloader.z ok;

    public static com.ss.android.socialbase.downloader.downloader.z ok(boolean z3) {
        if (z3 && com.ss.android.socialbase.downloader.downloader.bl.qx()) {
            if (f49757a == null) {
                synchronized (j.class) {
                    if (f49757a == null) {
                        f49757a = com.ss.android.socialbase.downloader.downloader.bl.tr().a();
                    }
                }
            }
            return f49757a;
        }
        if (ok == null) {
            synchronized (j.class) {
                if (ok == null) {
                    ok = new i();
                }
            }
        }
        return ok;
    }
}
