package com.ss.android.socialbase.downloader.ux;

import com.ss.android.socialbase.downloader.gd.f;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class xv implements w {

    /* renamed from: c  reason: collision with root package name */
    private final InputStream f50182c;

    /* renamed from: w  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.f.c f50183w;

    public xv(InputStream inputStream, int i4) {
        this.f50182c = inputStream;
        this.f50183w = new com.ss.android.socialbase.downloader.f.c(i4);
    }

    @Override // com.ss.android.socialbase.downloader.ux.w
    public com.ss.android.socialbase.downloader.f.c c() throws IOException {
        com.ss.android.socialbase.downloader.f.c cVar = this.f50183w;
        cVar.xv = this.f50182c.read(cVar.f49599c);
        return this.f50183w;
    }

    @Override // com.ss.android.socialbase.downloader.ux.w
    public void c(com.ss.android.socialbase.downloader.f.c cVar) {
    }

    @Override // com.ss.android.socialbase.downloader.ux.w
    public void w() {
        f.c(this.f50182c);
    }
}
