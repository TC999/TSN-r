package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: Timeout.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class t {

    /* renamed from: d  reason: collision with root package name */
    public static final t f839d = new a();

    /* renamed from: a  reason: collision with root package name */
    private boolean f840a;

    /* renamed from: b  reason: collision with root package name */
    private long f841b;

    /* renamed from: c  reason: collision with root package name */
    private long f842c;

    /* compiled from: Timeout.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    static class a extends t {
        a() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t
        public t a(long j4) {
            return this;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t
        public t a(long j4, TimeUnit timeUnit) {
            return this;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t
        public void e() throws IOException {
        }
    }

    public t a(long j4, TimeUnit timeUnit) {
        if (j4 >= 0) {
            if (timeUnit != null) {
                this.f842c = timeUnit.toNanos(j4);
                return this;
            }
            throw new IllegalArgumentException("unit == null");
        }
        throw new IllegalArgumentException("timeout < 0: " + j4);
    }

    public t b() {
        this.f842c = 0L;
        return this;
    }

    public long c() {
        if (this.f840a) {
            return this.f841b;
        }
        throw new IllegalStateException("No deadline");
    }

    public boolean d() {
        return this.f840a;
    }

    public void e() throws IOException {
        if (!Thread.interrupted()) {
            if (this.f840a && this.f841b - System.nanoTime() <= 0) {
                throw new InterruptedIOException("deadline reached");
            }
            return;
        }
        Thread.currentThread().interrupt();
        throw new InterruptedIOException("interrupted");
    }

    public long f() {
        return this.f842c;
    }

    public t a(long j4) {
        this.f840a = true;
        this.f841b = j4;
        return this;
    }

    public t a() {
        this.f840a = false;
        return this;
    }
}
