package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class Timeout {

    /* renamed from: d */
    public static final Timeout f846d = new C1016a();

    /* renamed from: a */
    private boolean f847a;

    /* renamed from: b */
    private long f848b;

    /* renamed from: c */
    private long f849c;

    /* compiled from: Timeout.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static class C1016a extends Timeout {
        C1016a() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Timeout
        /* renamed from: a */
        public Timeout mo58871a(long j) {
            return this;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Timeout
        /* renamed from: a */
        public Timeout mo58870a(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Timeout
        /* renamed from: e */
        public void mo58869e() throws IOException {
        }
    }

    /* renamed from: a */
    public Timeout mo58870a(long j, TimeUnit timeUnit) {
        if (j >= 0) {
            if (timeUnit != null) {
                this.f849c = timeUnit.toNanos(j);
                return this;
            }
            throw new IllegalArgumentException("unit == null");
        }
        throw new IllegalArgumentException("timeout < 0: " + j);
    }

    /* renamed from: b */
    public Timeout mo58875b() {
        this.f849c = 0L;
        return this;
    }

    /* renamed from: c */
    public long mo58874c() {
        if (this.f847a) {
            return this.f848b;
        }
        throw new IllegalStateException("No deadline");
    }

    /* renamed from: d */
    public boolean mo58873d() {
        return this.f847a;
    }

    /* renamed from: e */
    public void mo58869e() throws IOException {
        if (!Thread.interrupted()) {
            if (this.f847a && this.f848b - System.nanoTime() <= 0) {
                throw new InterruptedIOException("deadline reached");
            }
            return;
        }
        Thread.currentThread().interrupt();
        throw new InterruptedIOException("interrupted");
    }

    /* renamed from: f */
    public long m58872f() {
        return this.f849c;
    }

    /* renamed from: a */
    public Timeout mo58871a(long j) {
        this.f847a = true;
        this.f848b = j;
        return this;
    }

    /* renamed from: a */
    public Timeout mo58876a() {
        this.f847a = false;
        return this;
    }
}
