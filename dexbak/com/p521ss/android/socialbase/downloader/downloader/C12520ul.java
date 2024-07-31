package com.p521ss.android.socialbase.downloader.downloader;

import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.impls.C12563t;
import com.p521ss.android.socialbase.downloader.impls.ServiceConnectionC12557rh;
import com.p521ss.android.socialbase.downloader.p548a.ServiceConnectionC12388kf;

/* renamed from: com.ss.android.socialbase.downloader.downloader.ul */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class C12520ul implements C12490bl.InterfaceC12494ok {
    @Override // com.p521ss.android.socialbase.downloader.downloader.C12490bl.InterfaceC12494ok
    /* renamed from: a */
    public InterfaceC12522z mo17625a() {
        return new C12563t();
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12490bl.InterfaceC12494ok
    /* renamed from: ok */
    public InterfaceC12517t mo17624ok() {
        return new ServiceConnectionC12557rh();
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12490bl.InterfaceC12494ok
    /* renamed from: ok */
    public InterfaceC12519u mo17623ok(C12490bl.InterfaceC12494ok.InterfaceC12495ok interfaceC12495ok) {
        ServiceConnectionC12388kf serviceConnectionC12388kf = new ServiceConnectionC12388kf();
        serviceConnectionC12388kf.m17981ok(interfaceC12495ok);
        return serviceConnectionC12388kf;
    }
}
