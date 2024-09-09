package com.mbridge.msdk.f.a;

import android.os.CountDownTimer;

/* compiled from: MBCountDownTimer.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private long f39019a = 0;

    /* renamed from: b  reason: collision with root package name */
    private long f39020b;

    /* renamed from: c  reason: collision with root package name */
    private com.mbridge.msdk.f.a.a f39021c;

    /* renamed from: d  reason: collision with root package name */
    private a f39022d;

    /* compiled from: MBCountDownTimer.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    private static class a extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        private com.mbridge.msdk.f.a.a f39023a;

        public a(long j4, long j5) {
            super(j4, j5);
        }

        final void a(com.mbridge.msdk.f.a.a aVar) {
            this.f39023a = aVar;
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            com.mbridge.msdk.f.a.a aVar = this.f39023a;
            if (aVar != null) {
                aVar.onFinish();
            }
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long j4) {
            com.mbridge.msdk.f.a.a aVar = this.f39023a;
            if (aVar != null) {
                aVar.onTick(j4);
            }
        }
    }

    public final b a(long j4) {
        if (j4 < 0) {
            j4 = 1000;
        }
        this.f39020b = j4;
        return this;
    }

    public final b b(long j4) {
        this.f39019a = j4;
        return this;
    }

    public final b a(com.mbridge.msdk.f.a.a aVar) {
        this.f39021c = aVar;
        return this;
    }

    public final void b() {
        a aVar = this.f39022d;
        if (aVar != null) {
            aVar.cancel();
            this.f39022d = null;
        }
    }

    public final void a() {
        a aVar = this.f39022d;
        if (aVar == null) {
            if (aVar != null) {
                aVar.cancel();
                this.f39022d = null;
            }
            if (this.f39020b <= 0) {
                this.f39020b = this.f39019a + 1000;
            }
            a aVar2 = new a(this.f39019a, this.f39020b);
            this.f39022d = aVar2;
            aVar2.a(this.f39021c);
        }
        this.f39022d.start();
    }
}
