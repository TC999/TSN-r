package com.bytedance.sdk.component.xv.c;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd extends u {

    /* renamed from: c  reason: collision with root package name */
    private u f30684c;

    public gd(u uVar) {
        if (uVar != null) {
            this.f30684c = uVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // com.bytedance.sdk.component.xv.c.u
    public long A_() {
        return this.f30684c.A_();
    }

    public final u c() {
        return this.f30684c;
    }

    @Override // com.bytedance.sdk.component.xv.c.u
    public u f() {
        return this.f30684c.f();
    }

    @Override // com.bytedance.sdk.component.xv.c.u
    public void r() throws IOException {
        this.f30684c.r();
    }

    @Override // com.bytedance.sdk.component.xv.c.u
    public u ux() {
        return this.f30684c.ux();
    }

    @Override // com.bytedance.sdk.component.xv.c.u
    public boolean xv() {
        return this.f30684c.xv();
    }

    @Override // com.bytedance.sdk.component.xv.c.u
    public long z_() {
        return this.f30684c.z_();
    }

    public final gd c(u uVar) {
        if (uVar != null) {
            this.f30684c = uVar;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // com.bytedance.sdk.component.xv.c.u
    public u c(long j4, TimeUnit timeUnit) {
        return this.f30684c.c(j4, timeUnit);
    }

    @Override // com.bytedance.sdk.component.xv.c.u
    public u c(long j4) {
        return this.f30684c.c(j4);
    }
}
