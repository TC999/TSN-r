package com.kwad.components.core.video;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.video.p411a.p412a.C10519a;

/* renamed from: com.kwad.components.core.video.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8998i {

    /* renamed from: UT */
    private volatile boolean f29008UT;

    /* renamed from: UU */
    private long f29009UU;

    /* renamed from: UV */
    private C8999a f29010UV = new C8999a();

    /* renamed from: com.kwad.components.core.video.i$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8999a {

        /* renamed from: UW */
        private long f29011UW = 0;

        /* renamed from: UX */
        private int f29012UX = 0;

        public final void accumulate(long j) {
            this.f29011UW += j;
            this.f29012UX++;
        }

        /* renamed from: rW */
        public final int m29413rW() {
            return this.f29012UX;
        }

        /* renamed from: rX */
        public final long m29412rX() {
            return this.f29011UW;
        }

        public final void reset() {
            this.f29011UW = 0L;
            this.f29012UX = 0;
        }
    }

    /* renamed from: rR */
    public final void m29418rR() {
        if (this.f29008UT) {
            return;
        }
        this.f29008UT = true;
        this.f29009UU = SystemClock.elapsedRealtime();
        C10519a.m25561ev("videoStartBlock");
    }

    /* renamed from: rS */
    public final void m29417rS() {
        if (this.f29008UT) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f29009UU;
            this.f29010UV.accumulate(elapsedRealtime);
            this.f29008UT = false;
            C10519a.m25561ev("videoEndBlock");
            C10519a.m25561ev("videoBlockTime_" + elapsedRealtime);
        }
    }

    /* renamed from: rT */
    public final boolean m29416rT() {
        return this.f29008UT;
    }

    @NonNull
    /* renamed from: rU */
    public final C8999a m29415rU() {
        if (this.f29008UT) {
            this.f29010UV.accumulate(SystemClock.elapsedRealtime() - this.f29009UU);
            this.f29008UT = false;
        }
        return this.f29010UV;
    }

    /* renamed from: rV */
    public final long m29414rV() {
        return this.f29009UU;
    }

    public final void reset() {
        this.f29008UT = false;
        this.f29009UU = 0L;
        this.f29010UV.reset();
    }
}
