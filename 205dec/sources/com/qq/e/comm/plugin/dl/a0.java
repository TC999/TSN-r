package com.qq.e.comm.plugin.dl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.comm.plugin.adview.video.VideoCallback;
import com.qq.e.comm.plugin.dl.e;
import com.qq.e.comm.plugin.dl.e0;
import com.qq.e.comm.plugin.dl.h0;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.dl.k.n;
import com.qq.e.dl.l.h;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a0 extends com.qq.e.dl.l.a<d> {

    /* renamed from: x  reason: collision with root package name */
    private h0 f42311x;

    /* renamed from: y  reason: collision with root package name */
    private e0 f42312y;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b implements h.e {
        @Override // com.qq.e.dl.l.h.e
        public com.qq.e.dl.l.h a(com.qq.e.dl.a aVar) {
            return new a0(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public com.qq.e.dl.k.j f42313a;

        /* renamed from: b  reason: collision with root package name */
        public com.qq.e.dl.k.j f42314b;

        /* renamed from: c  reason: collision with root package name */
        public com.qq.e.dl.k.j f42315c;

        /* renamed from: d  reason: collision with root package name */
        public com.qq.e.dl.k.j f42316d;

        /* renamed from: e  reason: collision with root package name */
        public com.qq.e.dl.k.j f42317e;

        /* renamed from: f  reason: collision with root package name */
        public com.qq.e.dl.k.j f42318f;

        /* renamed from: g  reason: collision with root package name */
        public com.qq.e.dl.k.j f42319g;

        /* renamed from: h  reason: collision with root package name */
        public com.qq.e.dl.k.j f42320h;

        /* renamed from: i  reason: collision with root package name */
        public com.qq.e.dl.k.j f42321i;

        /* renamed from: j  reason: collision with root package name */
        public com.qq.e.dl.k.j f42322j;

        /* renamed from: k  reason: collision with root package name */
        public com.qq.e.dl.k.j f42323k;

        private c() {
        }

        public boolean a() {
            return this.f42317e.b(new JSONObject[0]) == 1;
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class d extends FrameLayout implements com.qq.e.dl.l.e<a0>, com.qq.e.comm.plugin.h.f {
        private final com.qq.e.comm.plugin.h.e A;
        private boolean B;
        private boolean C;
        private long D;

        /* renamed from: c  reason: collision with root package name */
        private a0 f42324c;

        /* renamed from: d  reason: collision with root package name */
        private final h0.b f42325d;

        /* renamed from: e  reason: collision with root package name */
        private final WebView f42326e;

        /* renamed from: f  reason: collision with root package name */
        private final com.qq.e.comm.plugin.q0.h f42327f;

        /* renamed from: g  reason: collision with root package name */
        private final ImageView f42328g;

        /* renamed from: h  reason: collision with root package name */
        private final FrameLayout.LayoutParams f42329h;

        /* renamed from: i  reason: collision with root package name */
        private final e0.e f42330i;

        /* renamed from: j  reason: collision with root package name */
        private final FrameLayout.LayoutParams f42331j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f42332k;

        /* renamed from: l  reason: collision with root package name */
        private com.qq.e.comm.plugin.g0.e f42333l;

        /* renamed from: m  reason: collision with root package name */
        private int f42334m;

        /* renamed from: n  reason: collision with root package name */
        private int f42335n;

        /* renamed from: o  reason: collision with root package name */
        private int f42336o;

        /* renamed from: p  reason: collision with root package name */
        private float f42337p;

        /* renamed from: q  reason: collision with root package name */
        private float f42338q;

        /* renamed from: r  reason: collision with root package name */
        private boolean f42339r;

        /* renamed from: s  reason: collision with root package name */
        private boolean f42340s;

        /* renamed from: t  reason: collision with root package name */
        private boolean f42341t;

        /* renamed from: u  reason: collision with root package name */
        private boolean f42342u;

        /* renamed from: v  reason: collision with root package name */
        private c f42343v;

        /* renamed from: w  reason: collision with root package name */
        private com.qq.e.comm.plugin.dl.e f42344w;

        /* renamed from: x  reason: collision with root package name */
        private h.d f42345x;

        /* renamed from: y  reason: collision with root package name */
        private ValueAnimator f42346y;

        /* renamed from: z  reason: collision with root package name */
        private LandingPageCallback f42347z;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public class a extends AnimatorListenerAdapter {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f42348c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ boolean f42349d;

            a(int i4, boolean z3) {
                this.f42348c = i4;
                this.f42349d = z3;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                d.this.f42326e.animate().setListener(null);
                if (this.f42348c > 0) {
                    d.this.f42339r = false;
                }
                if (this.f42349d) {
                    d.this.f42326e.scrollTo(0, 0);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            b() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.f42331j.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                d.this.f42325d.setLayoutParams(d.this.f42331j);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f42330i.setVisibility(0);
            }
        }

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.dl.a0$d$d  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class C0800d extends com.qq.e.comm.plugin.q0.j {
            C0800d() {
            }

            @Override // com.qq.e.comm.plugin.q0.j, com.qq.e.comm.plugin.q0.f
            public void c(String str) {
                super.c(str);
                if (d.this.f42328g.getVisibility() == 0) {
                    d.this.f42328g.setVisibility(8);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public class e extends com.qq.e.comm.plugin.h.d<Void> {
            e(com.qq.e.comm.plugin.h.f fVar) {
                super(fVar);
            }

            @Override // com.qq.e.comm.plugin.h.d
            /* renamed from: a */
            public void b(Void r22) {
                d.this.b();
                d.this.f42332k = false;
                d.this.b(false);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public class f extends com.qq.e.comm.plugin.h.d<Void> {
            f(com.qq.e.comm.plugin.h.f fVar) {
                super(fVar);
            }

            @Override // com.qq.e.comm.plugin.h.d
            /* renamed from: a */
            public void b(Void r22) {
                d.this.C = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public class g extends com.qq.e.comm.plugin.h.d<Void> {
            g(com.qq.e.comm.plugin.h.f fVar) {
                super(fVar);
            }

            @Override // com.qq.e.comm.plugin.h.d
            /* renamed from: a */
            public void b(Void r22) {
                d dVar = d.this;
                dVar.a(dVar.f42347z);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public class h extends com.qq.e.comm.plugin.h.d<Long> {
            h(com.qq.e.comm.plugin.h.f fVar) {
                super(fVar);
            }

            @Override // com.qq.e.comm.plugin.h.d
            /* renamed from: a */
            public void b(Long l4) {
                if (l4 == null || !d.this.C || d.this.f42347z == null) {
                    return;
                }
                if (l4.longValue() >= d.this.D) {
                    d.this.b();
                    d.this.b(true);
                    d.this.f42347z.u().a();
                    return;
                }
                d.this.f42347z.n().b(Integer.valueOf(((int) ((d.this.D - l4.longValue()) / 1000)) + 1));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public class i implements n.c {
            i() {
            }

            @Override // com.qq.e.dl.k.n.c
            public void a(int i4) {
                d.this.f42330i.setBackgroundColor(i4);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public class j implements e.f {
            j() {
            }

            @Override // com.qq.e.comm.plugin.dl.e.f
            public void a() {
                d.this.f42325d.setVisibility(8);
            }

            @Override // com.qq.e.comm.plugin.dl.e.f
            public void b() {
                if (d.this.f42340s) {
                    return;
                }
                d.this.f42341t = false;
                int i4 = -d.this.f42334m;
                if (d.this.f42343v != null && d.this.f42343v.a()) {
                    i4 += d.this.f42336o;
                }
                d.this.a(i4, 300, false, true);
                d.this.f42324c.f42311x.a(new int[]{0, 0, 0, 0});
                if (d.this.f42347z != null) {
                    d.this.f42347z.K().a();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public class k implements Runnable {
            k() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f42328g.setVisibility(8);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public class l extends AnimatorListenerAdapter {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f42361c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ boolean f42362d;

            l(int i4, boolean z3) {
                this.f42361c = i4;
                this.f42362d = z3;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (this.f42361c > 0) {
                    d.this.f42339r = false;
                }
                d.this.f42325d.animate().setListener(null);
                if (this.f42362d) {
                    d.this.f42326e.scrollTo(0, 0);
                }
            }
        }

        public d(Context context, e0.e eVar, h0.b bVar) {
            super(context);
            this.f42329h = new FrameLayout.LayoutParams(-1, -1);
            this.f42331j = new FrameLayout.LayoutParams(-1, -1, 1);
            this.f42332k = false;
            this.f42337p = -1.0f;
            this.f42339r = false;
            this.f42340s = false;
            this.f42341t = false;
            this.f42342u = false;
            this.A = new com.qq.e.comm.plugin.h.e();
            this.B = false;
            this.C = false;
            this.f42325d = bVar;
            this.f42330i = eVar;
            com.qq.e.comm.plugin.q0.h a4 = new com.qq.e.comm.plugin.q0.d(getContext()).a();
            this.f42327f = a4;
            this.f42326e = (WebView) a4.a();
            ImageView imageView = new ImageView(getContext());
            this.f42328g = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            com.qq.e.comm.plugin.b0.b.a().a("https://qzs.gdtimg.com/union/res/union_cdn/page/temp_v2/webview-cover.png", this.f42328g);
            this.f42327f.a(new C0800d());
        }

        @Override // com.qq.e.comm.plugin.h.f
        public boolean isDestroyed() {
            return this.B;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            this.B = true;
            p0.a((Object) null);
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0012, code lost:
            if (r0 != 3) goto L12;
         */
        @Override // android.view.ViewGroup
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
            /*
                r5 = this;
                boolean r0 = r5.f42339r
                r1 = 1
                if (r0 == 0) goto L6
                return r1
            L6:
                int r0 = r6.getAction()
                if (r0 == 0) goto L66
                if (r0 == r1) goto L55
                r2 = 2
                if (r0 == r2) goto L15
                r1 = 3
                if (r0 == r1) goto L55
                goto L6e
            L15:
                float r0 = r6.getY()
                float r2 = r5.f42337p
                float r2 = r0 - r2
                int r3 = r5.f42334m
                if (r3 == 0) goto L50
                int r3 = r5.a()
                int r4 = r5.f42334m
                if (r3 != r4) goto L2e
                r3 = 0
                int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                if (r2 <= 0) goto L50
            L2e:
                android.webkit.WebView r2 = r5.f42326e
                int r2 = r2.getScrollY()
                if (r2 > 0) goto L50
                android.webkit.WebView r2 = r5.f42326e
                float r2 = r2.getY()
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 < 0) goto L50
                com.qq.e.comm.plugin.dl.e r0 = r5.f42344w
                if (r0 == 0) goto L4a
                int r0 = r0.b()
                if (r0 != 0) goto L50
            L4a:
                boolean r0 = r5.f42340s
                if (r0 == 0) goto L4f
                goto L50
            L4f:
                return r1
            L50:
                boolean r6 = super.onInterceptTouchEvent(r6)
                return r6
            L55:
                float r0 = r5.f42337p
                android.webkit.WebView r1 = r5.f42326e
                float r1 = r1.getY()
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 < 0) goto L6e
                r0 = 0
                r5.b(r0)
                goto L6e
            L66:
                float r0 = r6.getY()
                int r0 = (int) r0
                float r0 = (float) r0
                r5.f42337p = r0
            L6e:
                boolean r6 = super.onInterceptTouchEvent(r6)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.dl.a0.d.onInterceptTouchEvent(android.view.MotionEvent):boolean");
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i4, int i5) {
            super.onMeasure(i4, i5);
            c();
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (this.f42339r) {
                return true;
            }
            int action = motionEvent.getAction();
            if (action == 1) {
                f();
                b(false);
            } else if (action == 2) {
                float y3 = motionEvent.getY();
                this.f42337p = y3;
                if (a(y3 - this.f42337p)) {
                    return true;
                }
            } else if (action == 3) {
                b(false);
            }
            return super.onTouchEvent(motionEvent);
        }

        @Override // android.view.View
        protected void onVisibilityChanged(View view, int i4) {
            this.f42324c.a(view, i4);
        }

        @Override // com.qq.e.comm.plugin.h.f
        public com.qq.e.comm.plugin.h.e g() {
            return this.A;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(boolean z3) {
            if (this.f42332k || this.f42345x == null) {
                return;
            }
            this.f42332k = true;
            this.f42327f.f(true);
            com.qq.e.dl.l.j.c cVar = new com.qq.e.dl.l.j.c(1, "adClick");
            cVar.a("ca", 3);
            cVar.a("sld", 4);
            if (z3) {
                cVar.a("sld", 8);
            }
            this.f42345x.b(this.f42324c, cVar);
        }

        private void c() {
            com.qq.e.comm.plugin.g0.e eVar;
            if (this.f42342u || this.f42343v == null || (eVar = this.f42333l) == null || !(eVar instanceof com.qq.e.comm.plugin.g0.u)) {
                return;
            }
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                int height = viewGroup.getHeight();
                int width = viewGroup.getWidth();
                if (height <= 0 || height < width) {
                    return;
                }
                this.f42342u = true;
                int R0 = this.f42333l.R0();
                int N0 = this.f42333l.N0();
                this.f42331j.height = this.f42343v.f42315c.a(new JSONObject[0]);
                this.f42335n = this.f42331j.height;
                float d4 = this.f42343v.f42313a.d(new JSONObject[0]);
                int i4 = this.f42335n;
                int i5 = (int) (d4 * i4);
                this.f42336o = i5;
                this.f42334m = i5 - i4;
                if (!this.f42343v.a()) {
                    height -= this.f42336o;
                }
                FrameLayout.LayoutParams layoutParams = this.f42329h;
                layoutParams.height = height;
                layoutParams.topMargin = this.f42335n;
                if (this.f42344w == null) {
                    int a4 = this.f42343v.f42318f.a(new JSONObject[0]);
                    int i6 = ((int) (((a4 * 1.0f) / R0) * N0)) + 2;
                    int a5 = this.f42343v.f42319g.a(new JSONObject[0]);
                    int a6 = this.f42343v.f42320h.a(new JSONObject[0]);
                    int a7 = this.f42343v.f42321i.a(new JSONObject[0]);
                    int a8 = this.f42343v.f42322j.a(new JSONObject[0]);
                    if (a5 <= a7) {
                        a5 = (com.qq.e.dl.j.f.b() - a4) - a7;
                    }
                    if (a6 <= a8) {
                        a6 = (com.qq.e.dl.j.f.a() - i6) - a8;
                    }
                    com.qq.e.comm.plugin.dl.e eVar2 = new com.qq.e.comm.plugin.dl.e(this.f42325d);
                    this.f42344w = eVar2;
                    eVar2.a(a4, i6).a(new Point(a5, a6)).a(new j());
                }
            }
        }

        private void e() {
            this.f42330i.setVisibility(8);
            this.f42330i.postDelayed(new c(), 300L);
            this.f42344w.e();
            int a4 = com.qq.e.dl.j.f.a(8.0d);
            this.f42324c.f42311x.a(new int[]{a4, a4, a4, a4});
        }

        private void f() {
            int a4;
            boolean z3 = false;
            if (a() >= this.f42334m * this.f42338q) {
                a4 = -a();
            } else if (this.f42343v.a()) {
                a4 = (this.f42334m - a()) - this.f42336o;
                z3 = true;
            } else {
                a4 = this.f42334m - a();
            }
            a(a4, 300, z3, true);
        }

        protected void d() {
            FrameLayout.LayoutParams layoutParams;
            WebView webView = this.f42326e;
            if (webView != null && webView.getParent() == null && (layoutParams = this.f42329h) != null) {
                addView(this.f42326e, layoutParams);
                addView(this.f42328g, this.f42329h);
                p0.a(new k(), 5000L);
            }
            if (this.f42325d.getParent() == null) {
                addView(this.f42325d, this.f42331j);
            }
            e0.e eVar = this.f42330i;
            if (eVar == null || eVar.getParent() != null) {
                return;
            }
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, com.qq.e.dl.j.f.a(2.0d));
            layoutParams2.gravity = 80;
            this.f42325d.addView(this.f42330i, layoutParams2);
        }

        public void a(c cVar) {
            this.f42343v = cVar;
            if (cVar.f42314b.d(new JSONObject[0]) == 0.0f) {
                this.f42338q = 0.3f;
            } else {
                this.f42338q = this.f42343v.f42314b.d(new JSONObject[0]);
            }
        }

        public void a(com.qq.e.comm.plugin.g0.e eVar) {
            this.f42333l = eVar;
            this.f42327f.f(com.qq.e.comm.plugin.d0.a.d().f().a("dwajwl", this.f42333l.q0(), 0) == 1);
            this.f42327f.loadUrl(((com.qq.e.comm.plugin.g0.u) this.f42333l).a());
            LandingPageCallback landingPageCallback = (LandingPageCallback) com.qq.e.comm.plugin.h.a.b(this.f42333l.l0(), LandingPageCallback.class);
            this.f42347z = landingPageCallback;
            landingPageCallback.F().a(new e(this));
            this.f42347z.q().a(new f(this));
            VideoCallback videoCallback = (VideoCallback) com.qq.e.comm.plugin.h.a.b(this.f42333l.l0(), VideoCallback.class);
            videoCallback.onStart().a(new g(this));
            videoCallback.z().a(new h(this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            a((this.f42334m - a()) - this.f42336o, 300, true, true);
            this.C = false;
        }

        private void b(float f4, int i4, boolean z3, boolean z4) {
            if (i4 > 0) {
                this.f42339r = true;
            }
            float a4 = a() + f4;
            this.f42326e.animate().cancel();
            long j4 = i4;
            this.f42326e.animate().translationYBy(f4).setDuration(j4).setListener(new a(i4, z4)).start();
            if (this.f42328g.getVisibility() == 0) {
                this.f42328g.animate().cancel();
                this.f42328g.animate().translationYBy(f4).setDuration(j4).start();
            }
            int i5 = (int) (this.f42335n + a4);
            ValueAnimator valueAnimator = this.f42346y;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            if (!z3) {
                ValueAnimator ofInt = ValueAnimator.ofInt(this.f42331j.height, i5);
                this.f42346y = ofInt;
                ofInt.addUpdateListener(new b());
                this.f42346y.setDuration(j4).start();
            } else if (this.f42344w != null) {
                e();
            }
        }

        public void a(int i4) {
            this.f42330i.a(i4);
        }

        public void a(com.qq.e.dl.k.g gVar) {
            com.qq.e.dl.k.n.a(gVar, ((com.qq.e.dl.l.h) this.f42324c).f47073k.c(), new i());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(float f4, int i4, boolean z3, boolean z4) {
            if (this.f42341t) {
                return;
            }
            if (z3) {
                this.f42341t = true;
            }
            c cVar = this.f42343v;
            if ((cVar != null ? cVar.f42316d.b(new JSONObject[0]) : 1) != 1) {
                b(f4, i4, z3, z4);
            } else {
                c(f4, i4, z3, z4);
            }
        }

        private void c(float f4, int i4, boolean z3, boolean z4) {
            if (i4 > 0) {
                this.f42339r = true;
            }
            this.f42325d.animate().cancel();
            if (!z3) {
                this.f42325d.animate().translationYBy(f4).setDuration(i4).start();
            } else if (this.f42344w != null) {
                e();
            }
            this.f42326e.animate().cancel();
            long j4 = i4;
            this.f42326e.animate().translationYBy(f4).setDuration(j4).setListener(new l(i4, z4)).start();
            if (this.f42328g.getVisibility() == 0) {
                this.f42328g.animate().cancel();
                this.f42328g.animate().translationYBy(f4).setDuration(j4).start();
            }
        }

        private boolean a(float f4) {
            float a4 = a() + f4;
            if (a4 >= 0.0f || a4 <= this.f42334m) {
                return false;
            }
            a(f4, 0, false, false);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z3) {
            h.d dVar;
            this.f42325d.a();
            this.f42340s = true;
            if (this.f42341t && (dVar = this.f42345x) != null && !z3) {
                dVar.b(this.f42324c, new com.qq.e.dl.l.j.c(1, "forceCloseAd"));
                return;
            }
            com.qq.e.comm.plugin.dl.e eVar = this.f42344w;
            if (eVar != null) {
                eVar.a();
            }
            int a4 = this.f42334m - a();
            c cVar = this.f42343v;
            if (cVar != null && !cVar.a()) {
                this.f42329h.height += this.f42336o;
            }
            a(a4 - this.f42336o, 300, false, true);
            LandingPageCallback landingPageCallback = this.f42347z;
            if (landingPageCallback != null) {
                landingPageCallback.u().a();
            }
            this.C = false;
            this.f42341t = true;
        }

        private int a() {
            WebView webView = this.f42326e;
            if (webView == null) {
                return 0;
            }
            return (int) webView.getTranslationY();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(LandingPageCallback landingPageCallback) {
            c cVar;
            com.qq.e.comm.plugin.g0.e eVar = this.f42333l;
            if (eVar != null && eVar.M0() >= 0 && (cVar = this.f42343v) != null) {
                long b4 = cVar.f42323k.b(new JSONObject[0]) * 1000;
                this.D = b4;
                if (b4 > 0) {
                    int a4 = com.qq.e.comm.plugin.t.c.a("lpvnafst", this.f42333l.q0(), -1, this.f42333l.p0());
                    if (a4 >= 0) {
                        this.D = a4 * 1000;
                    }
                    if (com.qq.e.comm.plugin.fs.e.b.a(this.f42333l.M0() * 1000, com.qq.e.comm.plugin.t.c.a("restpl", this.f42333l.q0(), 0, this.f42333l.p0())) - this.D <= 3000) {
                        landingPageCallback.q().a();
                        return;
                    } else {
                        this.C = true;
                        return;
                    }
                }
            }
            landingPageCallback.q().a();
        }

        @Override // com.qq.e.dl.l.e
        public void a(a0 a0Var) {
            this.f42324c = a0Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.h
    public void u() {
        this.f42311x.u();
        super.u();
        com.qq.e.dl.l.i.b bVar = this.f47079q;
        if (bVar != null && bVar.a() && m() != null) {
            m().setWillNotDraw(false);
        }
        ((d) this.f47039w).d();
    }

    private a0(com.qq.e.dl.a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.a
    /* renamed from: b */
    public d a(com.qq.e.dl.a aVar) {
        h0 h0Var = (h0) new h0.a().a(aVar);
        this.f42311x = h0Var;
        h0Var.a("initVideo", (JSONObject) null);
        this.f42312y = (e0) new e0.d().a(aVar);
        return new d(aVar.b(), (e0.e) this.f42312y.m(), (h0.b) this.f42311x.m());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.h
    public boolean a(String str, com.qq.e.dl.k.g gVar) {
        char c4;
        int hashCode = str.hashCode();
        if (hashCode == -1780721904) {
            if (str.equals("barColor")) {
                c4 = 1;
            }
            c4 = '\uffff';
        } else if (hashCode == -1001078227) {
            if (str.equals("progress")) {
                c4 = 0;
            }
            c4 = '\uffff';
        } else if (hashCode != 1262235062) {
            if (hashCode == 1263797899 && str.equals("barBgColor")) {
                c4 = 2;
            }
            c4 = '\uffff';
        } else {
            if (str.equals("extraParams")) {
                c4 = 3;
            }
            c4 = '\uffff';
        }
        if (c4 == 0) {
            ((d) this.f47039w).a(gVar.b(new JSONObject[0]));
            return true;
        } else if (c4 == 1) {
            this.f42312y.c(gVar);
            return true;
        } else if (c4 == 2) {
            ((d) this.f47039w).a(gVar);
            return true;
        } else if (c4 != 3) {
            if ("adModel".equals(str)) {
                ((d) this.f47039w).a((com.qq.e.comm.plugin.g0.e) gVar.c(new JSONObject[0]));
            }
            if (this.f42311x.c(str, gVar)) {
                return true;
            }
            return super.a(str, gVar);
        } else {
            c cVar = new c();
            try {
                JSONObject jSONObject = new JSONObject(gVar.toString());
                cVar.f42313a = com.qq.e.dl.k.l.c((Object) jSONObject.optString("videoShowMinSpace"));
                cVar.f42314b = com.qq.e.dl.k.l.c((Object) jSONObject.optString("videoAbsorbRatio"));
                cVar.f42315c = com.qq.e.dl.k.l.c((Object) jSONObject.optString("verticalVideoHeight"));
                cVar.f42316d = com.qq.e.dl.k.l.c((Object) jSONObject.optString("videoMoveType"));
                cVar.f42317e = com.qq.e.dl.k.l.c((Object) jSONObject.optString("videoWindowEnable"));
                cVar.f42318f = com.qq.e.dl.k.l.c((Object) jSONObject.optString("videoWindowWidth"));
                cVar.f42319g = com.qq.e.dl.k.l.c((Object) jSONObject.optString("videoWindowLeft"));
                cVar.f42320h = com.qq.e.dl.k.l.c((Object) jSONObject.optString("videoWindowTop"));
                cVar.f42321i = com.qq.e.dl.k.l.c((Object) jSONObject.optString("videoWindowRight"));
                cVar.f42322j = com.qq.e.dl.k.l.c((Object) jSONObject.optString("videoWindowBottom"));
                ((d) this.f47039w).a(cVar);
                cVar.f42323k = com.qq.e.dl.k.l.c((Object) jSONObject.optString("autoFSTime"));
            } catch (JSONException unused) {
            }
            return true;
        }
    }

    @Override // com.qq.e.dl.l.h
    public void a(String str, JSONObject jSONObject) {
        char c4;
        super.a(str, jSONObject);
        int hashCode = str.hashCode();
        if (hashCode != -2070199965) {
            if (hashCode == 1487219122 && str.equals("closeVideoAuto")) {
                c4 = 0;
            }
            c4 = '\uffff';
        } else {
            if (str.equals("closeVideo")) {
                c4 = 1;
            }
            c4 = '\uffff';
        }
        if (c4 == 0) {
            ((d) this.f47039w).a(true);
        } else if (c4 != 1) {
        } else {
            ((d) this.f47039w).a(false);
        }
    }

    @Override // com.qq.e.dl.l.h
    public void a(h.d dVar) {
        ((d) this.f47039w).f42345x = dVar;
    }
}
