package com.p521ss.android.downloadlib.p527a;

import com.amap.api.services.core.AMapException;
import com.p521ss.android.downloadlib.C12265s;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.socialbase.downloader.p554ok.C12646ok;

/* renamed from: com.ss.android.downloadlib.a.n */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12015n implements C12646ok.InterfaceC12650ok {

    /* renamed from: ok */
    private long f34023ok;

    /* renamed from: com.ss.android.downloadlib.a.n$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C12017ok {

        /* renamed from: ok */
        private static C12015n f34027ok = new C12015n();
    }

    @Override // com.p521ss.android.socialbase.downloader.p554ok.C12646ok.InterfaceC12650ok
    /* renamed from: a */
    public void mo16836a() {
        this.f34023ok = System.currentTimeMillis();
    }

    @Override // com.p521ss.android.socialbase.downloader.p554ok.C12646ok.InterfaceC12650ok
    /* renamed from: bl */
    public void mo16835bl() {
    }

    private C12015n() {
        this.f34023ok = 0L;
        C12646ok.m16846ok().m16843ok(this);
    }

    /* renamed from: ok */
    public static C12015n m19390ok() {
        return C12017ok.f34027ok;
    }

    /* renamed from: a */
    public void m19391a(InterfaceC12024s interfaceC12024s) {
        if (interfaceC12024s == null) {
            return;
        }
        int i = AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS;
        int optInt = C12128r.m18946q().optInt("check_an_result_delay", AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS);
        if (optInt > 0) {
            i = optInt;
        }
        m19387ok(interfaceC12024s, i);
    }

    /* renamed from: ok */
    public void m19387ok(final InterfaceC12024s interfaceC12024s, final long j) {
        if (interfaceC12024s == null) {
            return;
        }
        C12265s.m18554ok().m18552ok(new Runnable() { // from class: com.ss.android.downloadlib.a.n.1
            @Override // java.lang.Runnable
            public void run() {
                if (C12646ok.m16846ok().m16851bl() && System.currentTimeMillis() - C12015n.this.f34023ok > j) {
                    interfaceC12024s.mo18606ok(false);
                } else {
                    interfaceC12024s.mo18606ok(true);
                }
            }
        }, j);
    }

    /* renamed from: ok */
    public void m19388ok(InterfaceC12024s interfaceC12024s) {
        m19387ok(interfaceC12024s, 5000L);
    }
}
