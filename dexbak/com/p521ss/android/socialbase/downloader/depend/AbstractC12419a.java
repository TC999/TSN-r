package com.p521ss.android.socialbase.downloader.depend;

import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.depend.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractC12419a implements InterfaceC12479ul {

    /* renamed from: ok */
    private boolean f35014ok = false;

    @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12479ul
    /* renamed from: ok */
    public void mo16638ok(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f35014ok = true;
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12479ul
    /* renamed from: ok */
    public boolean mo16639ok() {
        return this.f35014ok;
    }
}
