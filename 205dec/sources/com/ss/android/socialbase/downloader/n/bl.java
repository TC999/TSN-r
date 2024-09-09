package com.ss.android.socialbase.downloader.n;

import com.ss.android.socialbase.downloader.q.kf;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class bl implements a {

    /* renamed from: a  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.kf.ok f49990a;
    private final InputStream ok;

    public bl(InputStream inputStream, int i4) {
        this.ok = inputStream;
        this.f49990a = new com.ss.android.socialbase.downloader.kf.ok(i4);
    }

    @Override // com.ss.android.socialbase.downloader.n.a
    public void a() {
        kf.ok(this.ok);
    }

    @Override // com.ss.android.socialbase.downloader.n.a
    public com.ss.android.socialbase.downloader.kf.ok ok() throws IOException {
        com.ss.android.socialbase.downloader.kf.ok okVar = this.f49990a;
        okVar.bl = this.ok.read(okVar.ok);
        return this.f49990a;
    }

    @Override // com.ss.android.socialbase.downloader.n.a
    public void ok(com.ss.android.socialbase.downloader.kf.ok okVar) {
    }
}
