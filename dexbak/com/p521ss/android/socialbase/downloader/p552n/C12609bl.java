package com.p521ss.android.socialbase.downloader.p552n;

import com.p521ss.android.socialbase.downloader.p551kf.C12582ok;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.ss.android.socialbase.downloader.n.bl */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12609bl implements InterfaceC12608a {

    /* renamed from: a */
    private final C12582ok f35528a;

    /* renamed from: ok */
    private final InputStream f35529ok;

    public C12609bl(InputStream inputStream, int i) {
        this.f35529ok = inputStream;
        this.f35528a = new C12582ok(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.p552n.InterfaceC12608a
    /* renamed from: a */
    public void mo16977a() {
        C12713kf.m16531ok(this.f35529ok);
    }

    @Override // com.p521ss.android.socialbase.downloader.p552n.InterfaceC12608a
    /* renamed from: ok */
    public C12582ok mo16969ok() throws IOException {
        C12582ok c12582ok = this.f35528a;
        c12582ok.f35342bl = this.f35529ok.read(c12582ok.f35343ok);
        return this.f35528a;
    }

    @Override // com.p521ss.android.socialbase.downloader.p552n.InterfaceC12608a
    /* renamed from: ok */
    public void mo16968ok(C12582ok c12582ok) {
    }
}
