package com.kwad.sdk.utils;

import android.os.SystemClock;

/* renamed from: com.kwad.sdk.utils.bm */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11063bm {
    private long aQU;
    private long aQV;
    private boolean aQW;

    public C11063bm() {
        reset();
    }

    private void reset() {
        this.aQU = 0L;
        this.aQV = -1L;
    }

    /* renamed from: No */
    public final void m23866No() {
        if (this.aQW && this.aQV < 0) {
            this.aQV = SystemClock.elapsedRealtime();
        }
    }

    /* renamed from: Np */
    public final void m23865Np() {
        if (this.aQW && this.aQV > 0) {
            this.aQU += SystemClock.elapsedRealtime() - this.aQV;
            this.aQV = -1L;
        }
    }

    /* renamed from: Nq */
    public final long m23864Nq() {
        if (this.aQW) {
            this.aQW = false;
            if (this.aQV > 0) {
                this.aQU += SystemClock.elapsedRealtime() - this.aQV;
                this.aQV = -1L;
            }
            return this.aQU;
        }
        return 0L;
    }

    public final long getTime() {
        if (this.aQV > 0) {
            return (this.aQU + SystemClock.elapsedRealtime()) - this.aQV;
        }
        return this.aQU;
    }

    public final void startTiming() {
        reset();
        this.aQW = true;
        this.aQV = SystemClock.elapsedRealtime();
    }
}
