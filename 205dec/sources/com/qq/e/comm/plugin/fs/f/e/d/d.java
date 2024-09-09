package com.qq.e.comm.plugin.fs.f.e.d;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qq.e.comm.plugin.b.k;
import com.qq.e.comm.plugin.f0.g;
import com.qq.e.comm.plugin.g0.u;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.o0.h.f;
import com.qq.e.comm.plugin.rewardvideo.q;
import com.qq.e.comm.plugin.util.b0;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.m1;
import com.qq.e.comm.plugin.util.n0;
import com.qq.e.comm.plugin.util.z;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d extends RelativeLayout implements f, View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.comm.plugin.g0.e f43410c;

    /* renamed from: d  reason: collision with root package name */
    private final com.qq.e.comm.plugin.fs.d.d.a f43411d;

    /* renamed from: e  reason: collision with root package name */
    private final com.qq.e.comm.plugin.q0.h f43412e;

    /* renamed from: f  reason: collision with root package name */
    private i f43413f;

    /* renamed from: g  reason: collision with root package name */
    private final ImageView f43414g;

    /* renamed from: h  reason: collision with root package name */
    private com.qq.e.comm.plugin.fs.f.e.d.a f43415h;

    /* renamed from: i  reason: collision with root package name */
    private CountDownTimer f43416i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f43417j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f43418k;

    /* renamed from: l  reason: collision with root package name */
    private com.qq.e.comm.plugin.fs.f.e.d.c f43419l;

    /* renamed from: m  reason: collision with root package name */
    private final com.qq.e.comm.plugin.n0.c f43420m;

    /* renamed from: n  reason: collision with root package name */
    private final com.qq.e.comm.plugin.n0.d f43421n;

    /* renamed from: o  reason: collision with root package name */
    private final String f43422o;

    /* renamed from: p  reason: collision with root package name */
    private final int f43423p;

    /* renamed from: q  reason: collision with root package name */
    private int f43424q;

    /* renamed from: r  reason: collision with root package name */
    private volatile boolean f43425r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f43426s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f43427t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f43428u;

    /* renamed from: v  reason: collision with root package name */
    private final int f43429v;

    /* renamed from: w  reason: collision with root package name */
    private final int f43430w;

    /* renamed from: x  reason: collision with root package name */
    private Boolean f43431x;

    /* renamed from: y  reason: collision with root package name */
    private k.b f43432y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f43433z;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements com.qq.e.comm.plugin.q0.f {

        /* renamed from: c  reason: collision with root package name */
        long f43434c;

        a() {
        }

        @Override // com.qq.e.comm.plugin.q0.f
        public void a() {
            d1.a("EndCardView onLeftApplication", new Object[0]);
        }

        @Override // com.qq.e.comm.plugin.q0.f
        public void b(String str) {
            d1.a("EndCardView onReceivedTitle : " + str, new Object[0]);
        }

        @Override // com.qq.e.comm.plugin.q0.f
        public void c(String str) {
            d1.a("EndCardView onPageFinished", new Object[0]);
            d.this.f43425r = false;
            if (d.this.f43417j) {
                return;
            }
            if (d.this.f43413f != null) {
                d.this.f43413f.a();
            }
            if (d.this.f43431x == null) {
                d.this.f43431x = Boolean.TRUE;
                com.qq.e.comm.plugin.fs.e.a.a(d.this.f43422o, "EndCard", d.this.f43423p, System.currentTimeMillis() - this.f43434c, str, null, d.this.f43420m);
                if (d.this.f43422o.equals("Interstitial")) {
                    d.this.f43421n.a("wu", str);
                    v.a(1030018, d.this.f43420m, Integer.valueOf(d.this.f43423p), d.this.f43421n);
                } else if (d.this.f43422o.equals("Reward")) {
                    v.a(1020030, d.this.f43420m, Integer.valueOf(d.this.f43423p));
                }
                b0.d(d.this.f43420m, d.this.f43423p);
            }
        }

        @Override // com.qq.e.comm.plugin.q0.f
        public void a(String str, Bitmap bitmap) {
            d1.a("EndCardView onPageStarted", new Object[0]);
            this.f43434c = System.currentTimeMillis();
        }

        @Override // com.qq.e.comm.plugin.q0.f
        public boolean b(ValueCallback<Uri[]> valueCallback, Intent intent) {
            d1.a("EndCardView onShowFileChooser", new Object[0]);
            return false;
        }

        @Override // com.qq.e.comm.plugin.q0.f
        public void a(int i4, String str, String str2) {
            d1.a("EndCardView onReceivedError : " + str, new Object[0]);
            if (d.this.f43417j) {
                if (!com.qq.e.comm.plugin.fs.f.e.d.c.a(d.this.f43423p) || d.this.f43419l == null) {
                    return;
                }
                d1.a("EndCardView show fallbackView ", new Object[0]);
                d.this.f43419l.setVisibility(0);
                return;
            }
            d.this.f43417j = true;
            if (!d.this.f43418k) {
                if (d.this.f43412e != null) {
                    d.this.f43412e.loadUrl(str2);
                }
                d.this.f43418k = true;
            }
            if (d.this.f43413f != null) {
                d.this.f43413f.a();
            }
            if (d.this.f43415h != null) {
                d.this.f43415h.b();
            }
            if (d.this.f43431x == null) {
                d.this.f43431x = Boolean.FALSE;
                com.qq.e.comm.plugin.fs.e.a.a(d.this.f43422o, "EndCard", d.this.f43423p, System.currentTimeMillis() - this.f43434c, str2, str, d.this.f43420m);
                if (d.this.f43422o.equals("Interstitial")) {
                    d.this.f43421n.a("wu", str2);
                    v.a(1030019, d.this.f43420m, Integer.valueOf(d.this.f43423p), d.this.f43421n);
                } else if (d.this.f43422o.equals("Reward")) {
                    v.a(1020017, d.this.f43420m, Integer.valueOf(d.this.f43423p), d.this.b(str2));
                }
                b0.a(d.this.f43420m, d.this.f43423p, i4, d.this.b(str2));
                if (d.this.f43423p == 2) {
                    v.b(1140004, d.this.f43420m, 0, d.this.b(str2));
                }
            }
        }

        @Override // com.qq.e.comm.plugin.q0.f
        public void a(String str) {
            d1.a("EndCardView onOverrideUrlLoading", new Object[0]);
        }

        @Override // com.qq.e.comm.plugin.q0.f
        public void a(int i4) {
            d1.a("EndCardView onProgressChanged : " + i4, new Object[0]);
        }

        @Override // com.qq.e.comm.plugin.q0.f
        public void a(ValueCallback<Uri> valueCallback, Intent intent) {
            d1.a("EndCardView openFileChooser", new Object[0]);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.qq.e.comm.plugin.e.a a4 = com.qq.e.comm.plugin.e.a.a();
            com.qq.e.comm.plugin.e.i.a d4 = a4.d(d.this.f43419l);
            if (d4 != null) {
                d4.d(0);
            }
            String a5 = a4.a(d.this.f43419l);
            com.qq.e.comm.plugin.i.f fVar = new com.qq.e.comm.plugin.i.f(d.this.f43410c);
            fVar.f44110g = 0;
            fVar.f44105b = a5;
            if (d.this.f43415h != null) {
                d.this.f43415h.a(fVar, false);
            }
            v.a(9120027, d.this.f43420m, Integer.valueOf(d.this.f43432y.f42017b));
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
            if (d.this.f43414g != null) {
                d.this.f43414g.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.fs.f.e.d.d$d  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class RunnableC0833d implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f43438c;

        RunnableC0833d(int i4) {
            this.f43438c = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            d1.a("EndCardView webview time out setting:" + this.f43438c + "ms isWebViewTimeOut:" + d.this.f43425r, new Object[0]);
            if (!d.this.f43425r || d.this.f43419l == null) {
                return;
            }
            d.this.f43419l.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class e extends CountDownTimer {
        e(long j4, long j5) {
            super(j4, j5);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (d.this.f43413f != null) {
                d.this.f43413f.a();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context, com.qq.e.comm.plugin.g0.e eVar, String str, int i4, com.qq.e.comm.plugin.fs.d.d.a aVar) {
        super(context);
        this.f43425r = true;
        this.f43430w = com.qq.e.comm.plugin.d0.a.d().f().a("rewardVideoDemoGamePreloadTime", 3);
        setBackgroundColor(-16777216);
        this.f43422o = str;
        this.f43423p = i4;
        this.f43411d = aVar;
        this.f43421n = new com.qq.e.comm.plugin.n0.d();
        this.f43410c = eVar;
        this.f43429v = q.c(eVar);
        this.f43420m = com.qq.e.comm.plugin.n0.c.a(this.f43410c);
        a();
        com.qq.e.comm.plugin.q0.h a4 = new com.qq.e.comm.plugin.q0.d(context, eVar, true).a();
        this.f43412e = a4;
        a4.c().a(new g.c(this.f43410c));
        this.f43412e.a(new a());
        addView(this.f43412e.a(), new RelativeLayout.LayoutParams(-1, -1));
        z.b(this, 0);
        if (com.qq.e.comm.plugin.fs.f.e.d.c.a(this.f43423p)) {
            com.qq.e.comm.plugin.fs.f.e.d.c cVar = new com.qq.e.comm.plugin.fs.f.e.d.c(context, eVar);
            this.f43419l = cVar;
            cVar.setVisibility(8);
            addView(this.f43419l, new RelativeLayout.LayoutParams(-1, -1));
            this.f43419l.setOnClickListener(new b());
        }
        ImageView imageView = new ImageView(context);
        this.f43414g = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        k.b a5 = k.a(k.c.END_CARD, this.f43410c);
        this.f43432y = a5;
        this.f43414g.setPadding(a5.f42016a, a5.f42017b, a5.f42018c, a5.f42019d);
        this.f43414g.setImageBitmap(m1.a("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"));
        this.f43414g.setOnClickListener(this);
        int a6 = f1.a(context, 30);
        int a7 = f1.a(context, 20);
        k.b bVar = this.f43432y;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(bVar.f42016a + a6 + bVar.f42018c, a6 + bVar.f42017b + bVar.f42019d);
        layoutParams.addRule(11, -1);
        k.b bVar2 = this.f43432y;
        layoutParams.leftMargin = -bVar2.f42016a;
        layoutParams.rightMargin = a7 - bVar2.f42018c;
        layoutParams.topMargin = a7 - bVar2.f42017b;
        layoutParams.bottomMargin = -bVar2.f42019d;
        addView(this.f43414g, layoutParams);
        this.f43414g.setVisibility(this.f43424q <= 0 ? 0 : 8);
        this.f43412e.a().setBackgroundColor(0);
        if (this.f43423p == 1) {
            i iVar = new i(getContext());
            this.f43413f = iVar;
            addView(iVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.qq.e.comm.plugin.fs.f.e.d.a aVar;
        if (view != this.f43414g || (aVar = this.f43415h) == null) {
            return;
        }
        aVar.a();
        v.a(1403014, this.f43420m);
    }

    @Override // com.qq.e.comm.plugin.fs.f.e.d.f
    public void onDestroy() {
        com.qq.e.comm.plugin.q0.h hVar = this.f43412e;
        if (hVar != null) {
            hVar.e();
        }
        CountDownTimer countDownTimer = this.f43416i;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f43416i = null;
        }
        if (this.f43431x == null) {
            b0.a(this.f43420m, this.f43423p);
        }
        if (!this.f43426s || this.f43427t) {
            return;
        }
        b0.e(this.f43420m, this.f43423p);
    }

    @Override // com.qq.e.comm.plugin.fs.f.e.d.f
    public void show() {
        a(true);
    }

    @Override // com.qq.e.comm.plugin.fs.f.e.d.f
    public void e() {
        com.qq.e.comm.plugin.fs.f.e.d.a aVar = this.f43415h;
        if (aVar != null) {
            aVar.c();
        }
        show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.qq.e.comm.plugin.n0.d b(String str) {
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        if (str != null) {
            dVar.a("rs", str);
        }
        return dVar;
    }

    @Override // com.qq.e.comm.plugin.fs.f.e.d.f
    public void c() {
        setVisibility(4);
    }

    private void a() {
        com.qq.e.comm.plugin.d0.d.h f4 = com.qq.e.comm.plugin.d0.a.d().f();
        if (this.f43422o.equals("Interstitial")) {
            this.f43424q = f4.a("iecst", 0);
        } else if (this.f43422o.equals("Reward")) {
            this.f43424q = f4.a("recst", 0);
        }
    }

    @Override // com.qq.e.comm.plugin.fs.f.e.d.f
    public void a(com.qq.e.comm.plugin.fs.f.e.d.a aVar) {
        this.f43415h = aVar;
        this.f43412e.c().a("videoService", new com.qq.e.comm.plugin.fs.f.e.d.e(this.f43410c, this.f43415h));
    }

    public void a(boolean z3) {
        com.qq.e.comm.plugin.fs.f.e.d.c cVar;
        com.qq.e.comm.plugin.fs.f.e.d.c cVar2;
        if (this.f43433z) {
            return;
        }
        this.f43433z = true;
        b0.b(this.f43420m, this.f43423p);
        if (this.f43418k && this.f43417j && ((cVar2 = this.f43419l) == null || cVar2.getVisibility() == 8)) {
            if (this.f43415h != null) {
                d1.a("EndCardView", "onEndCardCloseClick");
                this.f43415h.a();
            }
            b0.b(this.f43420m, this.f43423p, 9001, null);
            return;
        }
        bringToFront();
        invalidate();
        setVisibility(0);
        this.f43427t = true;
        if (!this.f43426s) {
            d1.a("EndCardView", "show EndCard but has not load, do load..");
            if (TextUtils.isEmpty(((u) this.f43410c).e()) && (cVar = this.f43419l) != null) {
                cVar.setVisibility(0);
            } else {
                a(((u) this.f43410c).e());
            }
            this.f43426s = true;
        }
        com.qq.e.comm.plugin.fs.f.e.d.a aVar = this.f43415h;
        if (aVar != null) {
            aVar.d();
        }
        if (!z3) {
            this.f43414g.setVisibility(8);
        } else {
            ImageView imageView = this.f43414g;
            if (imageView != null && this.f43424q > 0) {
                imageView.postDelayed(new c(), this.f43424q * 1000);
            }
        }
        if (this.f43422o.equals("Reward")) {
            v.a(1020071, this.f43420m, Integer.valueOf(this.f43423p));
        } else if (this.f43422o.equals("Interstitial")) {
            v.a(1030030, this.f43420m, Integer.valueOf(this.f43423p));
        }
        b0.f(this.f43420m, this.f43423p);
        v.a(9120026, this.f43420m, Integer.valueOf(this.f43432y.f42017b));
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            d1.a("EndCardView loadUrl url is null");
            return;
        }
        if (n0.a(this.f43410c.q0(), this.f43410c.G())) {
            str = n0.a(str, "2");
        }
        if (this.f43426s) {
            return;
        }
        this.f43426s = true;
        if (this.f43412e != null) {
            b0.c(this.f43420m, this.f43423p);
            this.f43412e.loadUrl(str);
            this.f43425r = true;
            if (com.qq.e.comm.plugin.fs.f.e.d.c.a(this.f43423p)) {
                int b4 = com.qq.e.comm.plugin.fs.f.e.d.c.b() * 1000;
                postDelayed(new RunnableC0833d(b4), b4);
            }
            i iVar = this.f43413f;
            if (iVar != null) {
                iVar.setVisibility(0);
                this.f43416i = new e(3000L, 3000L).start();
            }
        }
    }

    @Override // com.qq.e.comm.plugin.fs.f.e.d.f
    public void a(ViewGroup viewGroup) {
        if (getParent() == null) {
            viewGroup.addView(this, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.qq.e.comm.plugin.fs.f.d.a
    public boolean a(f.t tVar, long j4, long j5) {
        if (tVar == f.t.UNINITIALIZED) {
            return true;
        }
        if (this.f43410c instanceof u) {
            if (!this.f43426s) {
                a(j4, j5);
            }
            if (tVar == f.t.STOP || tVar == f.t.ERROR || tVar == f.t.END) {
                d1.a("EndCardView", "show");
                if (!this.f43428u) {
                    show();
                    this.f43428u = true;
                }
            }
            return true;
        }
        return false;
    }

    private void a(long j4, long j5) {
        d1.a("EndCardView", "preload, demoGameEntryShowTime : " + this.f43429v + ", preloadRelativeTime : " + this.f43430w);
        if (((u) this.f43410c).f()) {
            long min = Math.min(com.qq.e.comm.plugin.fs.e.b.a(j4, this.f43411d), this.f43429v * 1000) - (this.f43430w * 1000);
            if (min <= 0) {
                min = 0;
            }
            if (j5 >= min) {
                d1.a("EndCardView", "preload DemoGame");
                a(((u) this.f43410c).e());
                this.f43426s = true;
                return;
            }
            return;
        }
        d1.a("EndCardView", "preload EndCard");
        a(((u) this.f43410c).e());
        this.f43426s = true;
    }
}
