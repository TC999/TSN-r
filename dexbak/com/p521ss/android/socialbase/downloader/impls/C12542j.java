package com.p521ss.android.socialbase.downloader.impls;

import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z;

/* renamed from: com.ss.android.socialbase.downloader.impls.j */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12542j {

    /* renamed from: a */
    private static volatile InterfaceC12522z f35217a;

    /* renamed from: ok */
    private static volatile InterfaceC12522z f35218ok;

    /* renamed from: ok */
    public static InterfaceC12522z m17583ok(boolean z) {
        if (z && C12490bl.m17764qx()) {
            if (f35217a == null) {
                synchronized (C12542j.class) {
                    if (f35217a == null) {
                        f35217a = C12490bl.m17756tr().mo17625a();
                    }
                }
            }
            return f35217a;
        }
        if (f35218ok == null) {
            synchronized (C12542j.class) {
                if (f35218ok == null) {
                    f35218ok = new C12541i();
                }
            }
        }
        return f35218ok;
    }
}
