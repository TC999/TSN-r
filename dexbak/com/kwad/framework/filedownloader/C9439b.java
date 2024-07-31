package com.kwad.framework.filedownloader;

import android.os.SystemClock;
import com.kwad.framework.filedownloader.InterfaceC9561s;

/* renamed from: com.kwad.framework.filedownloader.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9439b implements InterfaceC9561s.InterfaceC9562a, InterfaceC9561s.InterfaceC9563b {
    private long adJ;
    private long adK;
    private long adL;
    private int adM;
    private int adN = 1000;
    private long mStartTime;

    @Override // com.kwad.framework.filedownloader.InterfaceC9561s.InterfaceC9563b
    /* renamed from: N */
    public final void mo28413N(long j) {
        if (this.adN <= 0) {
            return;
        }
        boolean z = true;
        if (this.adJ != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.adJ;
            if (uptimeMillis >= this.adN || (this.adM == 0 && uptimeMillis > 0)) {
                int i = (int) ((j - this.adK) / uptimeMillis);
                this.adM = i;
                this.adM = Math.max(0, i);
            } else {
                z = false;
            }
        }
        if (z) {
            this.adK = j;
            this.adJ = SystemClock.uptimeMillis();
        }
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9561s.InterfaceC9563b
    public final void end(long j) {
        if (this.mStartTime <= 0) {
            return;
        }
        long j2 = j - this.adL;
        this.adJ = 0L;
        long uptimeMillis = SystemClock.uptimeMillis() - this.mStartTime;
        if (uptimeMillis <= 0) {
            this.adM = (int) j2;
        } else {
            this.adM = (int) (j2 / uptimeMillis);
        }
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9561s.InterfaceC9562a
    public final int getSpeed() {
        return this.adM;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9561s.InterfaceC9563b
    public final void reset() {
        this.adM = 0;
        this.adJ = 0L;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9561s.InterfaceC9563b
    public final void start(long j) {
        this.mStartTime = SystemClock.uptimeMillis();
        this.adL = j;
    }
}
