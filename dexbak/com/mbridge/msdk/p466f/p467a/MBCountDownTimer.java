package com.mbridge.msdk.p466f.p467a;

import android.os.CountDownTimer;

/* renamed from: com.mbridge.msdk.f.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class MBCountDownTimer {

    /* renamed from: a */
    private long f30192a = 0;

    /* renamed from: b */
    private long f30193b;

    /* renamed from: c */
    private CountDownListener f30194c;

    /* renamed from: d */
    private CountDownTimerC11247a f30195d;

    /* compiled from: MBCountDownTimer.java */
    /* renamed from: com.mbridge.msdk.f.a.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    private static class CountDownTimerC11247a extends CountDownTimer {

        /* renamed from: a */
        private CountDownListener f30196a;

        public CountDownTimerC11247a(long j, long j2) {
            super(j, j2);
        }

        /* renamed from: a */
        final void m22950a(CountDownListener countDownListener) {
            this.f30196a = countDownListener;
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            CountDownListener countDownListener = this.f30196a;
            if (countDownListener != null) {
                countDownListener.onFinish();
            }
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long j) {
            CountDownListener countDownListener = this.f30196a;
            if (countDownListener != null) {
                countDownListener.onTick(j);
            }
        }
    }

    /* renamed from: a */
    public final MBCountDownTimer m22954a(long j) {
        if (j < 0) {
            j = 1000;
        }
        this.f30193b = j;
        return this;
    }

    /* renamed from: b */
    public final MBCountDownTimer m22951b(long j) {
        this.f30192a = j;
        return this;
    }

    /* renamed from: a */
    public final MBCountDownTimer m22953a(CountDownListener countDownListener) {
        this.f30194c = countDownListener;
        return this;
    }

    /* renamed from: b */
    public final void m22952b() {
        CountDownTimerC11247a countDownTimerC11247a = this.f30195d;
        if (countDownTimerC11247a != null) {
            countDownTimerC11247a.cancel();
            this.f30195d = null;
        }
    }

    /* renamed from: a */
    public final void m22955a() {
        CountDownTimerC11247a countDownTimerC11247a = this.f30195d;
        if (countDownTimerC11247a == null) {
            if (countDownTimerC11247a != null) {
                countDownTimerC11247a.cancel();
                this.f30195d = null;
            }
            if (this.f30193b <= 0) {
                this.f30193b = this.f30192a + 1000;
            }
            CountDownTimerC11247a countDownTimerC11247a2 = new CountDownTimerC11247a(this.f30192a, this.f30193b);
            this.f30195d = countDownTimerC11247a2;
            countDownTimerC11247a2.m22950a(this.f30194c);
        }
        this.f30195d.start();
    }
}
