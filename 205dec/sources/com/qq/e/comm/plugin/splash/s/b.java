package com.qq.e.comm.plugin.splash.s;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qq.e.comm.plugin.f0.g;
import com.qq.e.comm.plugin.g0.b0;
import com.qq.e.comm.plugin.g0.c0;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.o0.h.f;
import com.qq.e.comm.plugin.util.c2;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.lang.ref.WeakReference;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public interface b {

    /* renamed from: b  reason: collision with root package name */
    public static final FrameLayout.LayoutParams f46186b = new FrameLayout.LayoutParams(-1, -1, 17);

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a extends FrameLayout {

        /* renamed from: c  reason: collision with root package name */
        com.qq.e.comm.plugin.splash.h f46187c;

        /* renamed from: d  reason: collision with root package name */
        com.qq.e.comm.plugin.o0.h.f f46188d;

        /* renamed from: e  reason: collision with root package name */
        private final int f46189e;

        /* renamed from: f  reason: collision with root package name */
        private final int f46190f;

        /* renamed from: g  reason: collision with root package name */
        private Runnable f46191g;

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.splash.s.b$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        private static class RunnableC0894a implements Runnable {

            /* renamed from: c  reason: collision with root package name */
            private WeakReference<c2> f46192c;

            RunnableC0894a(c2 c2Var) {
                this.f46192c = new WeakReference<>(c2Var);
            }

            @Override // java.lang.Runnable
            public void run() {
                c2 c2Var = this.f46192c.get();
                if (c2Var != null) {
                    c2Var.f();
                }
            }
        }

        public a(com.qq.e.comm.plugin.splash.h hVar) {
            super(hVar.f46089a);
            String q02;
            b0 p02;
            this.f46187c = hVar;
            c0 b4 = hVar.b();
            if (b4 == null) {
                p02 = com.qq.e.comm.plugin.t.a.b().a(com.qq.e.comm.plugin.b.g.SPLASH.c());
                q02 = "";
            } else {
                q02 = b4.q0();
                p02 = b4.p0();
            }
            this.f46189e = com.qq.e.comm.plugin.t.c.a("stpto", q02, -1, p02);
            this.f46190f = com.qq.e.comm.plugin.t.c.a("stfbt", q02, 0, p02);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            this.f46187c = null;
            this.f46188d = null;
            Runnable runnable = this.f46191g;
            if (runnable != null) {
                p0.e(runnable);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (this.f46187c != null) {
                GDTLogger.d("SplashAdView dispatchTouchEvent");
                com.qq.e.comm.plugin.e.i.a d4 = com.qq.e.comm.plugin.e.a.a().d(this);
                if (d4 != null) {
                    d4.a(motionEvent, false);
                }
            }
            return super.dispatchTouchEvent(motionEvent);
        }

        @Override // android.view.View
        protected void onVisibilityChanged(View view, int i4) {
            long max;
            super.onVisibilityChanged(view, i4);
            com.qq.e.comm.plugin.splash.h hVar = this.f46187c;
            if (hVar == null) {
                return;
            }
            GDTLogger.d("\u5f00\u5c4f\u5bb9\u5668\u53ef\u89c1\u6027\u53d1\u751f\u6539\u53d8:" + i4);
            com.qq.e.comm.plugin.o0.h.f fVar = this.f46188d;
            c2 c2Var = this.f46189e < 0 ? null : hVar.B;
            if (i4 == 0) {
                if (c2Var != null) {
                    int i5 = this.f46190f;
                    if (i5 > 0) {
                        max = i5 + c2Var.c();
                    } else {
                        max = i5 < 0 ? Math.max(c2Var.c(), this.f46190f * (-1)) : 0L;
                    }
                    if (max > 0) {
                        c2Var.b(Math.min(c2Var.b(), max));
                    }
                    c2Var.f();
                    v.a(1013024, hVar.c(), Integer.valueOf(this.f46189e), Integer.valueOf(this.f46190f), null);
                }
                Runnable runnable = this.f46191g;
                if (runnable != null) {
                    p0.e(runnable);
                    this.f46191g = null;
                }
                if (fVar == null || fVar.isPlaying() || fVar.getVideoState() == f.t.END) {
                    return;
                }
                GDTLogger.d("\u64ad\u653e\u5bb9\u5668\u53ef\u89c1\uff0c\u64ad\u653e\u89c6\u9891");
                fVar.play();
                return;
            }
            if (c2Var != null) {
                if (this.f46189e > 0) {
                    RunnableC0894a runnableC0894a = new RunnableC0894a(c2Var);
                    this.f46191g = runnableC0894a;
                    p0.a(runnableC0894a, this.f46189e * 60 * 1000);
                }
                c2Var.e();
            }
            v.a(1013023, hVar.c(), Integer.valueOf(this.f46189e), Integer.valueOf(this.f46190f), null);
            if (fVar == null || !fVar.isPlaying()) {
                return;
            }
            GDTLogger.d("\u64ad\u653e\u5bb9\u5668\u4e0d\u53ef\u89c1\uff0c\u6682\u505c\u89c6\u9891");
            fVar.pause();
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.splash.s.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface InterfaceC0895b extends g.b {
        @Deprecated
        void a(int i4, @Deprecated int i5, int i6);

        void b(com.qq.e.comm.plugin.splash.r.a aVar);
    }

    ViewGroup a();

    void a(long j4);

    void a(File file);

    void a(String str, f.o oVar);

    void a(boolean z3);

    com.qq.e.comm.plugin.o0.h.f b();

    void d();
}
