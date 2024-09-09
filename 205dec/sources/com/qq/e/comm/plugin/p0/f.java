package com.qq.e.comm.plugin.p0;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class f extends c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, String str) {
        super(aVar, str);
    }

    @Override // com.qq.e.comm.plugin.p0.c, com.qq.e.comm.plugin.p0.j
    protected void a(OutputStream outputStream) throws IOException {
        outputStream.flush();
    }

    @Override // com.qq.e.comm.plugin.p0.j
    protected void c() throws k {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e4) {
            throw new k("Error waiting cache", e4);
        }
    }

    @Override // com.qq.e.comm.plugin.p0.j
    protected void a() throws k {
        if (this.f45319f.g()) {
            throw new k("download error when checkDownloadError", new Throwable("HttpRangeResultProxyCache"));
        }
    }
}
