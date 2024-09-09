package com.qq.e.comm.plugin.rewardvideo;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.fs.e.c;
import com.qq.e.comm.plugin.fs.f.e.d.g;
import com.qq.e.comm.plugin.g0.f0;
import com.qq.e.comm.plugin.i.h;
import com.qq.e.comm.plugin.r0.i;
import com.qq.e.comm.plugin.rewardvideo.g;
import com.qq.e.comm.plugin.util.c2;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.j0;
import com.qq.e.comm.plugin.util.l1;
import com.qq.e.comm.plugin.util.m0;
import com.qq.e.comm.plugin.util.n0;
import com.qq.e.comm.plugin.util.n1;
import com.qq.e.comm.plugin.util.o2;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.plugin.util.z;
import java.util.Locale;
import org.json.JSONArray;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class h implements ACTD, com.qq.e.comm.plugin.q0.f, g.a {
    public static final String V = h.class.getSimpleName();
    private static final boolean W;
    private long B;
    private boolean C;
    private boolean D;
    private boolean E;
    private String F;
    private String G;
    private String H;
    private boolean I;
    private boolean J;
    private long K;

    /* renamed from: L  reason: collision with root package name */
    private long f45932L;
    private boolean M;
    private boolean N;
    private long O;
    private long P;

    /* renamed from: c  reason: collision with root package name */
    private final Activity f45933c;

    /* renamed from: d  reason: collision with root package name */
    private com.qq.e.comm.plugin.q0.h f45934d;

    /* renamed from: e  reason: collision with root package name */
    private long f45935e;

    /* renamed from: f  reason: collision with root package name */
    private long f45936f;

    /* renamed from: g  reason: collision with root package name */
    private String f45937g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f45938h;

    /* renamed from: i  reason: collision with root package name */
    private com.qq.e.comm.plugin.rewardvideo.g f45939i;

    /* renamed from: j  reason: collision with root package name */
    private c2 f45940j;

    /* renamed from: k  reason: collision with root package name */
    private Handler f45941k;

    /* renamed from: l  reason: collision with root package name */
    private int f45942l;

    /* renamed from: m  reason: collision with root package name */
    private com.qq.e.comm.plugin.rewardvideo.a f45943m;

    /* renamed from: o  reason: collision with root package name */
    private int f45945o;

    /* renamed from: p  reason: collision with root package name */
    private int f45946p;

    /* renamed from: q  reason: collision with root package name */
    private int f45947q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f45948r;

    /* renamed from: t  reason: collision with root package name */
    private String f45950t;

    /* renamed from: u  reason: collision with root package name */
    private f0 f45951u;

    /* renamed from: w  reason: collision with root package name */
    private ValueCallback<Uri[]> f45953w;

    /* renamed from: x  reason: collision with root package name */
    private ValueCallback<Uri> f45954x;

    /* renamed from: z  reason: collision with root package name */
    private com.qq.e.comm.plugin.i.d0.d f45956z;

    /* renamed from: n  reason: collision with root package name */
    private boolean f45944n = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f45949s = false;

    /* renamed from: v  reason: collision with root package name */
    private boolean f45952v = false;

    /* renamed from: y  reason: collision with root package name */
    private com.qq.e.comm.plugin.n0.c f45955y = new com.qq.e.comm.plugin.n0.c();
    private boolean A = true;
    private int Q = -1;
    private boolean R = false;
    private boolean S = false;
    private boolean T = false;
    private boolean U = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.f45934d == null || h.this.f45934d.a() == null) {
                return;
            }
            com.qq.e.comm.plugin.l0.c.a(com.qq.e.comm.plugin.e.a.a().c(h.this.f45934d.a()), h.this.f45951u, null, 10, null);
            l1.a(h.this.f45934d.a(), h.this.f45951u);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements g.b {
        b() {
        }

        @Override // com.qq.e.comm.plugin.rewardvideo.g.b
        public void b() {
            h.this.n();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.a(true);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.f45940j == null) {
                h.this.j();
            }
            if (h.this.f45952v) {
                return;
            }
            h.this.l();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class e extends com.qq.e.comm.plugin.i.d0.d {
        e(Context context) {
            super(context);
        }

        @Override // com.qq.e.comm.plugin.i.d0.d, com.qq.e.comm.plugin.i.d0.b
        public void b() {
            if (h.this.f45951u.X0()) {
                super.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class f implements i.f {
        f() {
        }

        @Override // com.qq.e.comm.plugin.r0.i.f
        public void onComplainSuccess() {
            com.qq.e.comm.plugin.fs.e.c.a().a(h.this.f45951u.K0(), 10016);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class g implements DialogInterface.OnDismissListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (h.this.f45940j != null) {
                h.this.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.rewardvideo.h$h  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class C0888h extends c2 {

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.rewardvideo.h$h$a */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (h.this.E) {
                    return;
                }
                d1.a(h.V, "\u8d70SDK\u515c\u5e95\u903b\u8f91\uff0c\u81ea\u52a8\u5b8c\u6210\u8bd5\u73a9\uff0c\u4e0b\u53d1\u5956\u52b1\u3002");
                h.this.b(true);
            }
        }

        C0888h(long j4, long j5) {
            super(j4, j5);
        }

        @Override // com.qq.e.comm.plugin.util.c2
        public void a(long j4) {
            int round = Math.round(((float) j4) / 1000.0f);
            if (round > 0) {
                h.this.f45939i.c(round);
            } else {
                if (!h.this.D || h.this.E) {
                    h.this.f45939i.a(h.this.F);
                } else {
                    h.this.o();
                }
                h.this.f45944n = false;
            }
            h.e(h.this);
            if (h.this.f45947q < h.this.f45946p * 2 || h.this.f45946p >= h.this.f45945o) {
                if (h.this.f45947q < h.this.f45945o * 2 || h.this.f45946p < h.this.f45945o) {
                    return;
                }
                h.this.c();
                return;
            }
            h.this.c();
        }

        @Override // com.qq.e.comm.plugin.util.c2
        public void d() {
            if (h.this.f45949s || h.this.f45940j == null || h.this.f45934d == null) {
                return;
            }
            n.b(h.this.f45951u, h.this.f45945o * 1000, h.this.h(), h.this.D, h.this.E);
            if (!h.this.D || h.this.E) {
                h.this.f();
            }
            if (h.this.D) {
                if (h.this.E) {
                    h.this.f45939i.a(h.this.F);
                } else {
                    h.this.o();
                    if (h.this.f45948r) {
                        p0.a(new a(), 5000L);
                    }
                }
            }
            h.this.f45949s = true;
            h.this.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            n.a(h.this.f45951u, h.this.f45945o * 1000, h.this.O, h.this.h(), h.this.P, h.this.D, h.this.E);
            com.qq.e.comm.plugin.fs.e.c.a().a(h.this.f45951u.K0(), 10004);
            h.this.f45933c.finish();
            h hVar = h.this;
            hVar.a(2050005, hVar.f45937g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.e();
            h.this.f45943m.cancel();
        }
    }

    static {
        W = com.qq.e.comm.plugin.d0.a.d().f().a("rpdtpsblr", 0) == 1;
    }

    public h(Activity activity) {
        this.f45933c = activity;
    }

    static /* synthetic */ int e(h hVar) {
        int i4 = hVar.f45947q + 1;
        hVar.f45947q = i4;
        return i4;
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void a() {
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void b(String str) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onActivityResult(int i4, int i5, Intent intent) {
        Uri data;
        if (1 == i4 && this.f45953w != null) {
            this.f45953w.onReceiveValue((i5 != -1 || intent == null || (data = intent.getData()) == null) ? null : new Uri[]{data});
            this.f45953w = null;
        } else if (2 != i4 || this.f45954x == null) {
        } else {
            this.f45954x.onReceiveValue((i5 != -1 || intent == null) ? null : intent.getData());
            this.f45954x = null;
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onAfterCreate(Bundle bundle) {
        Object obj;
        this.P = System.currentTimeMillis();
        this.f45933c.getWindow().setBackgroundDrawable(null);
        FrameLayout frameLayout = new FrameLayout(this.f45933c);
        frameLayout.setBackgroundColor(-16777216);
        this.f45933c.setContentView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
        Intent intent = this.f45933c.getIntent();
        this.f45935e = intent.getLongExtra("clickStartTime", System.currentTimeMillis());
        String stringExtra = intent.getStringExtra("objectId");
        this.f45950t = stringExtra;
        f0 f0Var = (f0) ((com.qq.e.comm.plugin.d0.b.b) com.qq.e.comm.plugin.d0.b.e.a(stringExtra, com.qq.e.comm.plugin.d0.b.b.class)).a();
        this.f45951u = f0Var;
        if (f0Var == null) {
            d1.a(V + " \u6fc0\u52b1\u6d4f\u89c8 Activity \u521b\u5efa\u5931\u8d25\uff0c\u5e7f\u544a\u6570\u636e\u4e3a\u7a7a");
            com.qq.e.comm.plugin.d0.b.e.a(com.qq.e.comm.plugin.d0.b.b.class);
            this.f45933c.finish();
            return;
        }
        a(f0Var);
        z.b(this.f45933c, z.a(this.f45951u));
        this.f45955y = com.qq.e.comm.plugin.n0.c.a(this.f45951u);
        com.qq.e.comm.plugin.fs.e.c.a().a(this.f45951u.K0(), 10001);
        if (!this.f45951u.s1()) {
            com.qq.e.comm.plugin.fs.e.c.a().a(this.f45951u.K0(), 10015, 5001);
            this.f45933c.finish();
            a(2050005, this.f45937g);
            return;
        }
        com.qq.e.comm.plugin.rewardvideo.g gVar = new com.qq.e.comm.plugin.rewardvideo.g(this.f45933c, this.f45951u);
        this.f45939i = gVar;
        gVar.a(new b());
        int applyDimension = (int) TypedValue.applyDimension(1, 45.0f, this.f45933c.getResources().getDisplayMetrics());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, applyDimension);
        layoutParams.gravity = 48;
        this.f45939i.setLayoutParams(layoutParams);
        this.f45939i.setBackgroundColor(-16777216);
        this.f45939i.a(new c());
        String r12 = this.f45951u.r1();
        this.G = r12;
        if (TextUtils.isEmpty(r12) || this.N) {
            this.G = this.D ? "\u5b8c\u6210\u4e92\u52a8" : "\u6d4f\u89c8\u9875\u9762";
        }
        this.f45939i.a(this.G, this.f45945o, this.I ? String.format("\u79d2\u83b7\u5f97%s", this.H) : String.format("\u79d2\u540e\u5373\u53ef\u83b7\u5f97%s", this.H));
        this.F = String.format("\u606d\u559c\u83b7\u5f97%s\uff01", this.H);
        if (this.f45946p <= 0) {
            this.f45939i.a().setVisibility(0);
        }
        frameLayout.addView(this.f45939i);
        Pair<com.qq.e.comm.plugin.q0.h, Boolean> a4 = k.a(this.f45951u.K0());
        if (a4 != null && (obj = a4.first) != null) {
            com.qq.e.comm.plugin.q0.h hVar = (com.qq.e.comm.plugin.q0.h) obj;
            this.f45934d = hVar;
            hVar.a(1);
            this.f45934d.a(this.f45933c);
            if (((Boolean) a4.second).booleanValue()) {
                l();
                m();
            }
        } else {
            com.qq.e.comm.plugin.q0.h a5 = new com.qq.e.comm.plugin.q0.d(this.f45933c, this.f45951u).a();
            this.f45934d = a5;
            a5.a(1);
            if (this.f45934d.c() != null) {
                this.f45934d.c().a("videoService", new com.qq.e.comm.plugin.rewardvideo.j());
            }
            if (W) {
                this.f45934d.f(this.J);
                this.f45934d.a(3);
            }
            this.f45934d.loadUrl(this.f45937g);
        }
        this.f45934d.a(this);
        this.f45934d.f(this.J);
        this.f45934d.a(2);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.topMargin = applyDimension;
        this.f45934d.a().setLayoutParams(layoutParams2);
        this.f45934d.c().a(new com.qq.e.comm.plugin.rewardvideo.i(this));
        com.qq.e.comm.plugin.fs.f.e.d.g gVar2 = new com.qq.e.comm.plugin.fs.f.e.d.g(this.f45951u, this.f45934d);
        gVar2.a(this);
        this.f45934d.a().setOnTouchListener(gVar2);
        this.f45934d.e(true);
        frameLayout.addView(this.f45934d.a());
        this.f45951u.c(10);
        com.qq.e.comm.plugin.e.a.a().a(this.f45934d.a(), this.f45951u);
        Handler handler = new Handler(Looper.getMainLooper());
        this.f45941k = handler;
        handler.postDelayed(new d(), this.f45942l * 1000);
        this.f45956z = new e(this.f45933c);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBackPressed() {
        a(false);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBeforeCreate(Bundle bundle) {
        this.f45933c.requestWindowFeature(1);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f45933c.getWindow().setStatusBarColor(-16777216);
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onDestroy() {
        this.f45952v = true;
        if (this.f45934d != null) {
            com.qq.e.comm.plugin.e.a.a().b(this.f45934d.a());
            this.f45934d.e();
            this.f45934d = null;
        }
        c2 c2Var = this.f45940j;
        if (c2Var != null) {
            c2Var.h();
            this.f45940j = null;
        }
        Handler handler = this.f45941k;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        f0 f0Var = this.f45951u;
        if (f0Var != null) {
            k.b(f0Var.K0());
        }
        com.qq.e.comm.plugin.d0.b.e.b(this.f45950t, com.qq.e.comm.plugin.d0.b.b.class);
        n.a(this.f45955y, System.currentTimeMillis() - this.B, this.C, this.f45937g);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onPause() {
        com.qq.e.comm.plugin.rewardvideo.a aVar;
        if (this.f45940j != null && ((aVar = this.f45943m) == null || !aVar.isShowing())) {
            d();
        }
        com.qq.e.comm.plugin.q0.h hVar = this.f45934d;
        if (hVar != null) {
            hVar.onPause();
        }
        this.f45938h = true;
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onResume() {
        com.qq.e.comm.plugin.rewardvideo.a aVar;
        if (this.f45940j != null && ((aVar = this.f45943m) == null || !aVar.isShowing())) {
            e();
        }
        if (this.f45938h) {
            com.qq.e.comm.plugin.q0.h hVar = this.f45934d;
            if (hVar != null) {
                hVar.onResume();
            }
            this.f45938h = false;
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onStop() {
    }

    private void d() {
        c2 c2Var = this.f45940j;
        if (c2Var != null) {
            c2Var.e();
            long currentTimeMillis = this.K + (System.currentTimeMillis() - this.f45932L);
            this.K = currentTimeMillis;
            n.a(this.f45951u, this.f45945o * 1000, 1, currentTimeMillis, this.D, this.E);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        c2 c2Var = this.f45940j;
        if (c2Var != null) {
            c2Var.f();
            this.f45932L = System.currentTimeMillis();
            n.a(this.f45951u, this.f45945o * 1000, 2, h(), this.D, this.E);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.O = System.currentTimeMillis();
        n.b(com.qq.e.comm.plugin.rewardvideo.f.PAGE, this.f45951u, -1L, h(), this.f45945o * 1000, null, this.D, this.E);
        com.qq.e.comm.plugin.fs.e.c a4 = com.qq.e.comm.plugin.fs.e.c.a();
        c.C0822c c0822c = new c.C0822c();
        c0822c.f43254a = this.f45951u.K0();
        c0822c.f43255b = new m(h(), this.f45945o * 1000, this.D ? 3 : 2, this.Q, -1);
        a4.a(this.f45951u.K0(), 10014, c0822c);
        this.C = true;
        a4.a(this.f45951u.K0(), 10012);
        this.f45944n = false;
        this.f45939i.a(this.F);
        if (!this.D) {
            n.a(com.qq.e.comm.plugin.rewardvideo.f.PAGE, this.f45951u, -1L, h(), this.f45945o * 1000, null, this.D, this.E);
        } else {
            n.a(this.f45951u, this.f45945o * 1000, h(), this.D, this.E);
        }
    }

    private String g() {
        View a4 = this.f45934d.a();
        com.qq.e.comm.plugin.e.a a5 = com.qq.e.comm.plugin.e.a.a();
        com.qq.e.comm.plugin.e.i.a d4 = a5.d(a4);
        if (d4 != null) {
            d4.a(5);
            a(d4);
        }
        return a5.a(a4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long h() {
        return (System.currentTimeMillis() - this.f45932L) + this.K;
    }

    private void i() {
        String str = "\u6d4f\u89c8\u9875\u9762 %d \u79d2\u5373\u53ef\u83b7\u5f97\u5956\u52b1\n\u786e\u8ba4\u8981\u79bb\u5f00\u5417\uff1f";
        if (this.D) {
            if (!this.E && !this.f45949s) {
                str = "\u4e92\u52a8 %d \u79d2\u540e\u5373\u53ef\u83b7\u5f97\u5956\u52b1\n\u786e\u8ba4\u8981\u79bb\u5f00\u5417\uff1f";
            } else if ((!this.E || this.f45949s) && !this.E) {
                str = "\u5b8c\u6210\u4e92\u52a8\u5373\u53ef\u83b7\u5f97\u5956\u52b1\n\u786e\u8ba4\u8981\u79bb\u5f00\u5417\uff1f";
            }
        }
        if (this.f45943m == null) {
            this.f45943m = new com.qq.e.comm.plugin.rewardvideo.a(this.f45933c);
        }
        this.f45943m.setCancelable(false);
        if (!this.f45943m.isShowing()) {
            boolean a4 = z.a(this.f45951u);
            z.d(this.f45933c, a4);
            this.f45943m.show();
            z.a(this.f45933c, a4, false);
            z.a(this.f45933c, a4);
        }
        LinearLayout a5 = this.f45943m.a(this.f45933c, false, String.format(Locale.getDefault(), str, Integer.valueOf(this.f45945o)), "\u6293\u4f4f\u5956\u52b1\u673a\u4f1a", "\u653e\u5f03\u5956\u52b1\u79bb\u5f00");
        this.f45943m.setContentView(a5);
        if (this.f45943m.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.f45943m.getWindow().getAttributes();
            a5.measure(0, 0);
            attributes.width = a5.getMeasuredWidth();
            attributes.height = a5.getMeasuredHeight();
            attributes.gravity = 17;
            this.f45943m.getWindow().setAttributes(attributes);
            this.f45943m.getWindow().getDecorView().setPadding(0, 0, 0, 0);
            this.f45943m.getWindow().setBackgroundDrawable(n1.a(f1.a((Context) this.f45933c, 10), -1, 255));
        }
        this.f45943m.a().setOnClickListener(new i());
        this.f45943m.b().setOnClickListener(new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        long currentTimeMillis = System.currentTimeMillis();
        this.B = currentTimeMillis;
        this.f45932L = currentTimeMillis;
        C0888h c0888h = new C0888h(this.f45945o * 1000, 500L);
        this.f45940j = c0888h;
        c0888h.g();
    }

    private boolean k() {
        return com.qq.e.comm.plugin.t.c.a("rpnsdbr", this.f45951u.q0(), 0, this.f45951u.p0()) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        com.qq.e.comm.plugin.r0.i iVar = new com.qq.e.comm.plugin.r0.i(this.f45933c, (com.qq.e.comm.plugin.g0.e) this.f45951u);
        iVar.a(new f());
        iVar.a(new g());
        iVar.i();
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.f45939i.a(this.G, "", this.I ? String.format("\u83b7\u53d6%s", this.H) : String.format("\u540e\u5373\u53ef\u83b7\u53d6%s", this.H));
    }

    public void l() {
        if (this.f45952v) {
            return;
        }
        n.a(com.qq.e.comm.plugin.rewardvideo.f.PAGE, this.f45955y);
        this.f45934d.a().post(new a());
        com.qq.e.comm.plugin.fs.e.c.a().a(this.f45951u.K0(), 10002);
        this.f45952v = true;
    }

    public void m() {
        if (this.f45940j == null) {
            j();
        }
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public boolean b(ValueCallback<Uri[]> valueCallback, Intent intent) {
        if (valueCallback == null || intent == null) {
            return false;
        }
        this.f45953w = valueCallback;
        this.f45933c.startActivityForResult(intent, 1);
        return true;
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void c(String str) {
        if (!this.R) {
            this.R = true;
            n.a(true, 0, (String) null, (String) null, this.f45955y);
            a(2050003, str);
        }
        com.qq.e.comm.plugin.q0.h hVar = this.f45934d;
        if (hVar == null || hVar.a() == null) {
            return;
        }
        l();
        m();
    }

    private void a(com.qq.e.comm.plugin.g0.e eVar) {
        String q02 = eVar.q0();
        com.qq.e.comm.plugin.d0.d.h f4 = com.qq.e.comm.plugin.d0.a.d().f();
        this.f45942l = com.qq.e.comm.plugin.t.c.a("rewardPageCountDelayTime", q02, 5, eVar.p0());
        this.M = f4.a("rpnaspl", q02, 1) == 1;
        this.f45946p = com.qq.e.comm.plugin.t.c.a("rewardPageCloseTime", q02, 0, eVar.p0());
        this.f45937g = this.f45951u.a();
        this.D = com.qq.e.comm.plugin.b.b.a(this.f45951u.b0());
        if (n0.a(q02, this.f45951u.G()) && this.D) {
            this.f45937g = n0.a(this.f45937g, "2");
        }
        if (this.D) {
            boolean z3 = f4.a("ritvfb", q02, 0) == 1;
            this.N = z3;
            this.D = (!z3) & this.D;
        }
        if (this.D) {
            this.f45948r = q.c(q02);
            this.f45945o = com.qq.e.comm.plugin.t.c.a("skrdct", eVar.q0(), 15, eVar.p0());
        } else {
            this.f45945o = com.qq.e.comm.plugin.t.c.a("rewardPageEffectiveTime", q02, 15, eVar.p0());
        }
        this.J = f4.a("dwajwl", q02, 0) == 1;
        Pair<String, Boolean> d4 = q.d(eVar);
        this.H = (String) d4.first;
        this.I = ((Boolean) d4.second).booleanValue();
    }

    @Override // com.qq.e.comm.plugin.fs.f.e.d.g.a
    public void b() {
        if (this.f45948r && this.f45949s && !this.E) {
            d1.a(V, "\u8d70SDK\u515c\u5e95\u903b\u8f91\uff0c\u7528\u6237\u5b8c\u6210\u89e6\u6478\u4ea4\u4e92\uff0c\u4e0b\u53d1\u5956\u52b1");
            b(false);
        }
    }

    public void b(boolean z3) {
        if (!this.E) {
            n.a(this.f45951u, this.f45945o * 1000, h());
            n.a(this.f45951u, System.currentTimeMillis() - this.B);
            this.E = true;
        }
        if (this.f45949s) {
            this.f45939i.a(this.F);
        } else {
            this.f45939i.b();
        }
        c();
        if (this.D) {
            this.Q = z3 ? -1 : 1;
        }
        if (!this.f45949s || this.C) {
            return;
        }
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f45944n = true;
        this.f45939i.a().setVisibility(0);
    }

    private void b(com.qq.e.comm.plugin.i.f fVar) {
        int i4;
        com.qq.e.comm.plugin.g0.e a4 = fVar.a();
        if (a4 == null) {
            d1.a("RewardPage onADClick adInfo is null", new Object[0]);
            return;
        }
        if (a4.q() != null) {
            i4 = com.qq.e.comm.plugin.apkmanager.k.e().b(a4.q().e());
        } else {
            i4 = 0;
        }
        d1.a("RewardPage onADClick status:" + i4 + " isFirstClickAd:" + this.A, new Object[0]);
        if ((i4 == 4 || i4 == 16 || i4 == 32 || i4 == 128) && !this.A) {
            return;
        }
        String g4 = g();
        com.qq.e.comm.plugin.i.g.a(new h.b(a4).a(g4).a(5).a(false).b(fVar.f44110g).a(), this.f45956z);
        l1.a(this.f45934d.a(), a4, g4);
        com.qq.e.comm.plugin.fs.e.c.a().a(a4.K0(), 10003);
        this.A = false;
    }

    private void b(int i4, String str, String str2) {
        if (this.M) {
            m0.a(i4, this.f45935e, this.f45955y, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z3) {
        if (!z3 && this.f45934d.canGoBack()) {
            this.f45934d.goBack();
        } else if ((!this.D && this.f45949s) || ((this.D && this.E && this.f45949s) || k())) {
            n.a(this.f45951u, this.f45945o * 1000, this.O, h(), this.P, this.D, this.E);
            com.qq.e.comm.plugin.fs.e.c.a().a(this.f45951u.K0(), 10004);
            this.f45933c.finish();
            a(2050005, this.f45937g);
        } else if (!this.f45944n || this.f45940j == null) {
        } else {
            d();
            i();
        }
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void a(String str, Bitmap bitmap) {
        if (this.T) {
            return;
        }
        this.T = true;
        a(2050002, str);
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void a(int i4, String str, String str2) {
        com.qq.e.comm.plugin.fs.e.c.a().a(this.f45951u.K0(), 10015, 5027);
        n.a(false, i4, str2, str, this.f45955y);
        this.f45933c.finish();
        if (this.U) {
            return;
        }
        this.U = true;
        b(2050004, str2, str);
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void a(String str) {
        this.f45937g = str;
        if (this.S) {
            return;
        }
        this.S = true;
        d1.a("302 to url:" + str, new Object[0]);
        this.f45936f = System.currentTimeMillis();
        d1.a("\u70b9\u51fb\u5230302\u8017\u65f6\uff1a" + (this.f45936f - this.f45935e), new Object[0]);
        a(2050001, str);
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void a(int i4) {
        if (i4 == 100) {
            this.f45939i.c();
        } else {
            this.f45939i.b(i4);
        }
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void a(ValueCallback<Uri> valueCallback, Intent intent) {
        if (valueCallback == null || intent == null) {
            return;
        }
        this.f45954x = valueCallback;
        this.f45933c.startActivityForResult(intent, 2);
    }

    private void a(com.qq.e.comm.plugin.e.i.a aVar) {
        ImageView a4 = this.f45939i.a();
        if (a4.getVisibility() != 0 || a4.getAlpha() == 0.0f) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        int[] iArr = new int[2];
        a4.getLocationOnScreen(iArr);
        j0 j0Var = new j0();
        j0Var.a("cvx", String.valueOf(com.qq.e.dl.j.f.b(iArr[0])));
        j0Var.a("cvy", String.valueOf(com.qq.e.dl.j.f.b(iArr[1])));
        j0Var.a("cvw", String.valueOf(com.qq.e.dl.j.f.b(a4.getWidth())));
        j0Var.a("cvh", String.valueOf(com.qq.e.dl.j.f.b(a4.getHeight())));
        j0Var.a("cvt", String.valueOf(1));
        j0Var.a("cvv", ((Boolean) o2.a(a4, 50, -1).first).booleanValue() ? "1" : "-1");
        jSONArray.put(j0Var.a());
        aVar.a(jSONArray);
    }

    @Override // com.qq.e.comm.plugin.fs.f.e.d.g.a
    public void a(com.qq.e.comm.plugin.i.f fVar) {
        com.qq.e.comm.plugin.q0.h hVar = this.f45934d;
        if (hVar == null || hVar.a() == null) {
            return;
        }
        this.f45934d.f(true);
        this.f45934d.a(4);
        com.qq.e.comm.plugin.e.a.a().a(this.f45934d.a(), this.f45951u, fVar.f44105b);
        b(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i4, String str) {
        b(i4, str, null);
    }
}
