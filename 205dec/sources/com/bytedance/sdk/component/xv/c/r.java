package com.bytedance.sdk.component.xv.c;

import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class r implements s {

    /* renamed from: c  reason: collision with root package name */
    private final s f30692c;

    public r(s sVar) {
        if (sVar != null) {
            this.f30692c = sVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // com.bytedance.sdk.component.xv.c.s
    public void a_(xv xvVar, long j4) throws IOException {
        this.f30692c.a_(xvVar, j4);
    }

    @Override // com.bytedance.sdk.component.xv.c.s
    public u c() {
        return this.f30692c.c();
    }

    @Override // com.bytedance.sdk.component.xv.c.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f30692c.close();
    }

    @Override // com.bytedance.sdk.component.xv.c.s, java.io.Flushable
    public void flush() throws IOException {
        this.f30692c.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f30692c.toString() + ")";
    }
}
