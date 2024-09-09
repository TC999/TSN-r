package com.bytedance.sdk.component.xv.c;

import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class ev implements fz {

    /* renamed from: c  reason: collision with root package name */
    private final fz f30679c;

    public ev(fz fzVar) {
        if (fzVar != null) {
            this.f30679c = fzVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // com.bytedance.sdk.component.xv.c.fz
    public long c(xv xvVar, long j4) throws IOException {
        return this.f30679c.c(xvVar, j4);
    }

    @Override // com.bytedance.sdk.component.xv.c.fz, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f30679c.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f30679c.toString() + ")";
    }

    public final fz w() {
        return this.f30679c;
    }

    @Override // com.bytedance.sdk.component.xv.c.fz
    public u c() {
        return this.f30679c.c();
    }
}
