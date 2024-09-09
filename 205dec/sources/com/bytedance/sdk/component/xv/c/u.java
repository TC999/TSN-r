package com.bytedance.sdk.component.xv.c;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class u {
    public static final u xv = new u() { // from class: com.bytedance.sdk.component.xv.c.u.1
        @Override // com.bytedance.sdk.component.xv.c.u
        public u c(long j4) {
            return this;
        }

        @Override // com.bytedance.sdk.component.xv.c.u
        public u c(long j4, TimeUnit timeUnit) {
            return this;
        }

        @Override // com.bytedance.sdk.component.xv.c.u
        public void r() throws IOException {
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private boolean f30696c;
    private long sr;

    /* renamed from: w  reason: collision with root package name */
    private long f30697w;

    public long A_() {
        if (this.f30696c) {
            return this.f30697w;
        }
        throw new IllegalStateException("No deadline");
    }

    public u c(long j4, TimeUnit timeUnit) {
        if (j4 >= 0) {
            if (timeUnit != null) {
                this.sr = timeUnit.toNanos(j4);
                return this;
            }
            throw new IllegalArgumentException("unit == null");
        }
        throw new IllegalArgumentException("timeout < 0: " + j4);
    }

    public u f() {
        this.f30696c = false;
        return this;
    }

    public void r() throws IOException {
        if (!Thread.interrupted()) {
            if (this.f30696c && this.f30697w - System.nanoTime() <= 0) {
                throw new InterruptedIOException("deadline reached");
            }
            return;
        }
        Thread.currentThread().interrupt();
        throw new InterruptedIOException("interrupted");
    }

    public u ux() {
        this.sr = 0L;
        return this;
    }

    public boolean xv() {
        return this.f30696c;
    }

    public long z_() {
        return this.sr;
    }

    public u c(long j4) {
        this.f30696c = true;
        this.f30697w = j4;
        return this;
    }
}
