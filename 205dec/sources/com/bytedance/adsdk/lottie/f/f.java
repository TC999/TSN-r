package com.bytedance.adsdk.lottie.f;

import android.view.Choreographer;
import com.bytedance.adsdk.lottie.s;
import com.bytedance.component.sdk.annotation.FloatRange;
import com.bytedance.component.sdk.annotation.MainThread;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends a implements Choreographer.FrameCallback {

    /* renamed from: l  reason: collision with root package name */
    private com.bytedance.adsdk.lottie.e f25621l;

    /* renamed from: d  reason: collision with root package name */
    private float f25613d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    private boolean f25614e = false;

    /* renamed from: f  reason: collision with root package name */
    private long f25615f = 0;

    /* renamed from: g  reason: collision with root package name */
    private float f25616g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    private float f25617h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    private int f25618i = 0;

    /* renamed from: j  reason: collision with root package name */
    private float f25619j = -2.1474836E9f;

    /* renamed from: k  reason: collision with root package name */
    private float f25620k = 2.1474836E9f;

    /* renamed from: m  reason: collision with root package name */
    protected boolean f25622m = false;

    /* renamed from: n  reason: collision with root package name */
    private boolean f25623n = false;

    private boolean C() {
        return x() < 0.0f;
    }

    private float r() {
        com.bytedance.adsdk.lottie.e eVar = this.f25621l;
        if (eVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / eVar.j()) / Math.abs(this.f25613d);
    }

    private void t() {
        if (this.f25621l == null) {
            return;
        }
        float f4 = this.f25617h;
        if (f4 < this.f25619j || f4 > this.f25620k) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f25619j), Float.valueOf(this.f25620k), Float.valueOf(this.f25617h)));
        }
    }

    @MainThread
    protected void A(boolean z3) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z3) {
            this.f25622m = false;
        }
    }

    @MainThread
    public void B() {
        this.f25622m = true;
        u();
        this.f25615f = 0L;
        if (C() && y() == G()) {
            k(q());
        } else if (!C() && y() == q()) {
            k(G());
        }
        e();
    }

    public void D(float f4) {
        l(this.f25619j, f4);
    }

    public void E(float f4) {
        this.f25613d = f4;
    }

    public void F(boolean z3) {
        this.f25623n = z3;
    }

    public float G() {
        com.bytedance.adsdk.lottie.e eVar = this.f25621l;
        if (eVar == null) {
            return 0.0f;
        }
        float f4 = this.f25619j;
        return f4 == -2.1474836E9f ? eVar.k() : f4;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        w();
        z();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j4) {
        u();
        if (this.f25621l == null || !isRunning()) {
            return;
        }
        s.b("LottieValueAnimator#doFrame");
        long j5 = this.f25615f;
        float r3 = ((float) (j5 != 0 ? j4 - j5 : 0L)) / r();
        float f4 = this.f25616g;
        if (C()) {
            r3 = -r3;
        }
        float f5 = f4 + r3;
        boolean z3 = !d.j(f5, G(), q());
        float f6 = this.f25616g;
        float h4 = d.h(f5, G(), q());
        this.f25616g = h4;
        if (this.f25623n) {
            h4 = (float) Math.floor(h4);
        }
        this.f25617h = h4;
        this.f25615f = j4;
        if (!this.f25623n || this.f25616g != f6) {
            h();
        }
        if (z3) {
            if (getRepeatCount() != -1 && this.f25618i >= getRepeatCount()) {
                float G = this.f25613d < 0.0f ? G() : q();
                this.f25616g = G;
                this.f25617h = G;
                z();
                f(C());
            } else {
                a();
                this.f25618i++;
                if (getRepeatMode() == 2) {
                    this.f25614e = !this.f25614e;
                    s();
                } else {
                    float q3 = C() ? q() : G();
                    this.f25616g = q3;
                    this.f25617h = q3;
                }
                this.f25615f = j4;
            }
        }
        t();
        s.d("LottieValueAnimator#doFrame");
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedFraction() {
        float G;
        float q3;
        float G2;
        if (this.f25621l == null) {
            return 0.0f;
        }
        if (C()) {
            G = q() - this.f25617h;
            q3 = q();
            G2 = G();
        } else {
            G = this.f25617h - G();
            q3 = q();
            G2 = G();
        }
        return G / (q3 - G2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(p());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        com.bytedance.adsdk.lottie.e eVar = this.f25621l;
        if (eVar == null) {
            return 0L;
        }
        return eVar.q();
    }

    @MainThread
    public void i() {
        z();
        f(C());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f25622m;
    }

    @MainThread
    public void j() {
        z();
        d();
    }

    public void k(float f4) {
        if (this.f25616g == f4) {
            return;
        }
        float h4 = d.h(f4, G(), q());
        this.f25616g = h4;
        if (this.f25623n) {
            h4 = (float) Math.floor(h4);
        }
        this.f25617h = h4;
        this.f25615f = 0L;
        h();
    }

    public void l(float f4, float f5) {
        if (f4 <= f5) {
            com.bytedance.adsdk.lottie.e eVar = this.f25621l;
            float k4 = eVar == null ? -3.4028235E38f : eVar.k();
            com.bytedance.adsdk.lottie.e eVar2 = this.f25621l;
            float o4 = eVar2 == null ? Float.MAX_VALUE : eVar2.o();
            float h4 = d.h(f4, k4, o4);
            float h5 = d.h(f5, k4, o4);
            if (h4 == this.f25619j && h5 == this.f25620k) {
                return;
            }
            this.f25619j = h4;
            this.f25620k = h5;
            k((int) d.h(this.f25617h, h4, h5));
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f4), Float.valueOf(f5)));
    }

    public void m(int i4) {
        l(i4, (int) this.f25620k);
    }

    public void n(com.bytedance.adsdk.lottie.e eVar) {
        boolean z3 = this.f25621l == null;
        this.f25621l = eVar;
        if (z3) {
            l(Math.max(this.f25619j, eVar.k()), Math.min(this.f25620k, eVar.o()));
        } else {
            l((int) eVar.k(), (int) eVar.o());
        }
        float f4 = this.f25617h;
        this.f25617h = 0.0f;
        this.f25616g = 0.0f;
        k((int) f4);
        h();
    }

    public void o() {
        this.f25621l = null;
        this.f25619j = -2.1474836E9f;
        this.f25620k = 2.1474836E9f;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float p() {
        com.bytedance.adsdk.lottie.e eVar = this.f25621l;
        if (eVar == null) {
            return 0.0f;
        }
        return (this.f25617h - eVar.k()) / (this.f25621l.o() - this.f25621l.k());
    }

    public float q() {
        com.bytedance.adsdk.lottie.e eVar = this.f25621l;
        if (eVar == null) {
            return 0.0f;
        }
        float f4 = this.f25620k;
        return f4 == 2.1474836E9f ? eVar.o() : f4;
    }

    public void s() {
        E(-x());
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i4) {
        super.setRepeatMode(i4);
        if (i4 == 2 || !this.f25614e) {
            return;
        }
        this.f25614e = false;
        s();
    }

    protected void u() {
        if (isRunning()) {
            A(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    public void v() {
        this.f25622m = true;
        b(C());
        k((int) (C() ? q() : G()));
        this.f25615f = 0L;
        this.f25618i = 0;
        u();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.lottie.f.a
    public void w() {
        super.w();
        f(C());
    }

    public float x() {
        return this.f25613d;
    }

    public float y() {
        return this.f25617h;
    }

    @MainThread
    protected void z() {
        A(true);
    }
}
