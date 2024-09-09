package com.bytedance.sdk.component.xv.c;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class bk implements sr {

    /* renamed from: c  reason: collision with root package name */
    public final xv f30669c = new xv();

    /* renamed from: w  reason: collision with root package name */
    public final s f30670w;
    boolean xv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(s sVar) {
        if (sVar != null) {
            this.f30670w = sVar;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    @Override // com.bytedance.sdk.component.xv.c.sr
    public sr a(long j4) throws IOException {
        if (!this.xv) {
            this.f30669c.a(j4);
            return i();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.component.xv.c.s
    public void a_(xv xvVar, long j4) throws IOException {
        if (!this.xv) {
            this.f30669c.a_(xvVar, j4);
            i();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.component.xv.c.s
    public u c() {
        return this.f30670w.c();
    }

    @Override // com.bytedance.sdk.component.xv.c.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.xv) {
            return;
        }
        Throwable th = null;
        try {
            xv xvVar = this.f30669c;
            long j4 = xvVar.f30701w;
            if (j4 > 0) {
                this.f30670w.a_(xvVar, j4);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f30670w.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.xv = true;
        if (th != null) {
            i.c(th);
        }
    }

    @Override // com.bytedance.sdk.component.xv.c.sr
    public sr ev(int i4) throws IOException {
        if (!this.xv) {
            this.f30669c.ev(i4);
            return i();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.component.xv.c.sr, com.bytedance.sdk.component.xv.c.s, java.io.Flushable
    public void flush() throws IOException {
        if (!this.xv) {
            xv xvVar = this.f30669c;
            long j4 = xvVar.f30701w;
            if (j4 > 0) {
                this.f30670w.a_(xvVar, j4);
            }
            this.f30670w.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.component.xv.c.sr
    public sr gd(int i4) throws IOException {
        if (!this.xv) {
            this.f30669c.gd(i4);
            return i();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.component.xv.c.sr
    public sr i() throws IOException {
        if (!this.xv) {
            long r3 = this.f30669c.r();
            if (r3 > 0) {
                this.f30670w.a_(this.f30669c, r3);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.xv;
    }

    @Override // com.bytedance.sdk.component.xv.c.sr
    public sr k(long j4) throws IOException {
        if (!this.xv) {
            this.f30669c.k(j4);
            return i();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.component.xv.c.sr
    public sr r(int i4) throws IOException {
        if (!this.xv) {
            this.f30669c.r(i4);
            return i();
        }
        throw new IllegalStateException("closed");
    }

    public String toString() {
        return "buffer(" + this.f30670w + ")";
    }

    @Override // com.bytedance.sdk.component.xv.c.sr
    public sr w(f fVar) throws IOException {
        if (!this.xv) {
            this.f30669c.w(fVar);
            return i();
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.xv) {
            int write = this.f30669c.write(byteBuffer);
            i();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.component.xv.c.sr
    public xv xv() {
        return this.f30669c;
    }

    @Override // com.bytedance.sdk.component.xv.c.sr
    public sr xv(byte[] bArr) throws IOException {
        if (!this.xv) {
            this.f30669c.xv(bArr);
            return i();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.component.xv.c.sr
    public sr w(String str) throws IOException {
        if (!this.xv) {
            this.f30669c.w(str);
            return i();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.component.xv.c.sr
    public sr xv(byte[] bArr, int i4, int i5) throws IOException {
        if (!this.xv) {
            this.f30669c.xv(bArr, i4, i5);
            return i();
        }
        throw new IllegalStateException("closed");
    }
}
