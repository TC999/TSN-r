package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: ForwardingTimeout.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class i extends t {

    /* renamed from: e  reason: collision with root package name */
    private t f806e;

    public i(t tVar) {
        if (tVar != null) {
            this.f806e = tVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final i a(t tVar) {
        if (tVar != null) {
            this.f806e = tVar;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t
    public t b() {
        return this.f806e.b();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t
    public long c() {
        return this.f806e.c();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t
    public boolean d() {
        return this.f806e.d();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t
    public void e() throws IOException {
        this.f806e.e();
    }

    public final t g() {
        return this.f806e;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t
    public t a(long j4, TimeUnit timeUnit) {
        return this.f806e.a(j4, timeUnit);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t
    public t a(long j4) {
        return this.f806e.a(j4);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t
    public t a() {
        return this.f806e.a();
    }
}
