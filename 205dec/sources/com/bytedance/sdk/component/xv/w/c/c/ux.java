package com.bytedance.sdk.component.xv.w.c.c;

import com.bytedance.sdk.component.xv.c.r;
import com.bytedance.sdk.component.xv.c.s;
import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
class ux extends r {

    /* renamed from: c  reason: collision with root package name */
    private boolean f30762c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ux(s sVar) {
        super(sVar);
    }

    @Override // com.bytedance.sdk.component.xv.c.r, com.bytedance.sdk.component.xv.c.s
    public void a_(com.bytedance.sdk.component.xv.c.xv xvVar, long j4) throws IOException {
        if (this.f30762c) {
            xvVar.ev(j4);
            return;
        }
        try {
            super.a_(xvVar, j4);
        } catch (IOException e4) {
            this.f30762c = true;
            c(e4);
        }
    }

    protected void c(IOException iOException) {
    }

    @Override // com.bytedance.sdk.component.xv.c.r, com.bytedance.sdk.component.xv.c.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f30762c) {
            return;
        }
        try {
            super.close();
        } catch (IOException e4) {
            this.f30762c = true;
            c(e4);
        }
    }

    @Override // com.bytedance.sdk.component.xv.c.r, com.bytedance.sdk.component.xv.c.s, java.io.Flushable
    public void flush() throws IOException {
        if (this.f30762c) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e4) {
            this.f30762c = true;
            c(e4);
        }
    }
}
