package com.p521ss.android.socialbase.downloader.p551kf;

import androidx.annotation.NonNull;
import java.io.IOException;

/* renamed from: com.ss.android.socialbase.downloader.kf.p */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class C12583p implements InterfaceC12581n {

    /* renamed from: a */
    private final InterfaceC12581n f35345a;

    /* renamed from: ok */
    private final InterfaceC12581n f35346ok;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C12583p(InterfaceC12581n interfaceC12581n, InterfaceC12581n interfaceC12581n2) {
        this.f35346ok = interfaceC12581n;
        this.f35345a = interfaceC12581n2;
    }

    @Override // com.p521ss.android.socialbase.downloader.p551kf.InterfaceC12581n
    /* renamed from: a */
    public void mo17297a(@NonNull C12582ok c12582ok) throws IOException {
        c12582ok.f35341a = this.f35345a;
        this.f35346ok.mo17297a(c12582ok);
    }
}
