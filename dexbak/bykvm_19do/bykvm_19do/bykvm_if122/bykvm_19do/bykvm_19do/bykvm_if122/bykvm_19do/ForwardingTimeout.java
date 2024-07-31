package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.i */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ForwardingTimeout extends Timeout {

    /* renamed from: e */
    private Timeout f813e;

    public ForwardingTimeout(Timeout timeout) {
        if (timeout != null) {
            this.f813e = timeout;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    /* renamed from: a */
    public final ForwardingTimeout m58935a(Timeout timeout) {
        if (timeout != null) {
            this.f813e = timeout;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Timeout
    /* renamed from: b */
    public Timeout mo58875b() {
        return this.f813e.mo58875b();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Timeout
    /* renamed from: c */
    public long mo58874c() {
        return this.f813e.mo58874c();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Timeout
    /* renamed from: d */
    public boolean mo58873d() {
        return this.f813e.mo58873d();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Timeout
    /* renamed from: e */
    public void mo58869e() throws IOException {
        this.f813e.mo58869e();
    }

    /* renamed from: g */
    public final Timeout m58934g() {
        return this.f813e;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Timeout
    /* renamed from: a */
    public Timeout mo58870a(long j, TimeUnit timeUnit) {
        return this.f813e.mo58870a(j, timeUnit);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Timeout
    /* renamed from: a */
    public Timeout mo58871a(long j) {
        return this.f813e.mo58871a(j);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Timeout
    /* renamed from: a */
    public Timeout mo58876a() {
        return this.f813e.mo58876a();
    }
}
