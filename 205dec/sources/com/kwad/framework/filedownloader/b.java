package com.kwad.framework.filedownloader;

import android.os.SystemClock;
import com.kwad.framework.filedownloader.s;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b implements s.a, s.b {
    private long adJ;
    private long adK;
    private long adL;
    private int adM;
    private int adN = 1000;
    private long mStartTime;

    @Override // com.kwad.framework.filedownloader.s.b
    public final void N(long j4) {
        if (this.adN <= 0) {
            return;
        }
        boolean z3 = true;
        if (this.adJ != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.adJ;
            if (uptimeMillis >= this.adN || (this.adM == 0 && uptimeMillis > 0)) {
                int i4 = (int) ((j4 - this.adK) / uptimeMillis);
                this.adM = i4;
                this.adM = Math.max(0, i4);
            } else {
                z3 = false;
            }
        }
        if (z3) {
            this.adK = j4;
            this.adJ = SystemClock.uptimeMillis();
        }
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void end(long j4) {
        if (this.mStartTime <= 0) {
            return;
        }
        long j5 = j4 - this.adL;
        this.adJ = 0L;
        long uptimeMillis = SystemClock.uptimeMillis() - this.mStartTime;
        if (uptimeMillis <= 0) {
            this.adM = (int) j5;
        } else {
            this.adM = (int) (j5 / uptimeMillis);
        }
    }

    @Override // com.kwad.framework.filedownloader.s.a
    public final int getSpeed() {
        return this.adM;
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void reset() {
        this.adM = 0;
        this.adJ = 0L;
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void start(long j4) {
        this.mStartTime = SystemClock.uptimeMillis();
        this.adL = j4;
    }
}
