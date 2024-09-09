package com.qq.e.comm.plugin.gdtnativead;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import com.mbridge.msdk.MBridgeConstans;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.NEADVI;
import com.qq.e.comm.plugin.gdtnativead.p.a;
import com.qq.e.comm.plugin.i.b;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.o0.g.b;
import com.qq.e.comm.plugin.q0.h;
import com.qq.e.comm.plugin.util.a1;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.c0;
import com.qq.e.comm.plugin.util.c2;
import com.qq.e.comm.plugin.util.d0;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.l1;
import com.qq.e.comm.plugin.util.l2;
import com.qq.e.comm.plugin.util.m2;
import com.qq.e.comm.plugin.util.o1;
import com.qq.e.comm.plugin.util.o2;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.plugin.util.r;
import com.qq.e.comm.plugin.util.u0;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class j implements NEADVI, com.qq.e.comm.plugin.q0.g, com.qq.e.comm.plugin.q0.t.b, a.d, com.qq.e.comm.plugin.q0.f, View.OnClickListener, h.a {

    /* renamed from: o0  reason: collision with root package name */
    private static final String f43818o0;

    /* renamed from: p0  reason: collision with root package name */
    private static final String f43819p0;

    /* renamed from: q0  reason: collision with root package name */
    private static final String f43820q0;
    private int D;
    private com.qq.e.comm.plugin.gdtnativead.p.a F;
    private com.qq.e.comm.plugin.r0.a G;

    /* renamed from: L  reason: collision with root package name */
    FrameLayout f43821L;
    private final ViewGroup M;
    private View N;
    private boolean O;
    Context Q;
    private volatile String T;
    private volatile boolean U;
    private long X;
    private long Y;
    private int Z;

    /* renamed from: b0  reason: collision with root package name */
    private long f43823b0;

    /* renamed from: c  reason: collision with root package name */
    private long f43824c;

    /* renamed from: c0  reason: collision with root package name */
    private int f43825c0;

    /* renamed from: d  reason: collision with root package name */
    private final com.qq.e.comm.plugin.b.g f43826d;

    /* renamed from: d0  reason: collision with root package name */
    private com.qq.e.comm.plugin.gdtnativead.l f43827d0;

    /* renamed from: e  reason: collision with root package name */
    com.qq.e.comm.plugin.q0.h f43828e;

    /* renamed from: e0  reason: collision with root package name */
    private com.qq.e.comm.plugin.i.d0.d f43829e0;

    /* renamed from: f  reason: collision with root package name */
    private ADListener f43830f;

    /* renamed from: g  reason: collision with root package name */
    private ADSize f43832g;

    /* renamed from: g0  reason: collision with root package name */
    private long f43833g0;

    /* renamed from: h  reason: collision with root package name */
    ViewGroup f43834h;

    /* renamed from: h0  reason: collision with root package name */
    private long f43835h0;

    /* renamed from: i  reason: collision with root package name */
    private int f43836i;

    /* renamed from: i0  reason: collision with root package name */
    private boolean f43837i0;

    /* renamed from: j  reason: collision with root package name */
    private int f43838j;

    /* renamed from: j0  reason: collision with root package name */
    private boolean f43839j0;

    /* renamed from: k  reason: collision with root package name */
    com.qq.e.comm.plugin.g0.e f43840k;

    /* renamed from: k0  reason: collision with root package name */
    private String f43841k0;

    /* renamed from: l  reason: collision with root package name */
    private String f43842l;

    /* renamed from: l0  reason: collision with root package name */
    private String f43843l0;

    /* renamed from: m  reason: collision with root package name */
    private HashMap<String, Object> f43844m;

    /* renamed from: m0  reason: collision with root package name */
    private boolean f43845m0;

    /* renamed from: n  reason: collision with root package name */
    private String f43846n;

    /* renamed from: r  reason: collision with root package name */
    private com.qq.e.comm.plugin.gdtnativead.g f43851r;

    /* renamed from: t  reason: collision with root package name */
    Context f43853t;

    /* renamed from: u  reason: collision with root package name */
    MediaView f43854u;

    /* renamed from: v  reason: collision with root package name */
    p f43855v;

    /* renamed from: w  reason: collision with root package name */
    private com.qq.e.comm.plugin.r0.b f43856w;

    /* renamed from: x  reason: collision with root package name */
    private c2 f43857x;

    /* renamed from: o  reason: collision with root package name */
    boolean f43848o = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f43849p = false;

    /* renamed from: q  reason: collision with root package name */
    private Boolean f43850q = null;

    /* renamed from: s  reason: collision with root package name */
    private int f43852s = -2;

    /* renamed from: y  reason: collision with root package name */
    int f43858y = 1;

    /* renamed from: z  reason: collision with root package name */
    private int f43859z = 1;
    private int A = 1;
    private int B = 1;
    private int C = 0;
    private RectF E = new RectF();
    private boolean H = true;
    private int I = com.qq.e.comm.plugin.util.c.a();
    private boolean J = false;
    private boolean K = false;
    private int P = -1;
    private boolean R = false;
    private boolean S = false;
    private volatile boolean V = false;
    private volatile boolean W = false;

    /* renamed from: a0  reason: collision with root package name */
    com.qq.e.comm.plugin.n0.c f43822a0 = new com.qq.e.comm.plugin.n0.c();

    /* renamed from: f0  reason: collision with root package name */
    private boolean f43831f0 = false;

    /* renamed from: n0  reason: collision with root package name */
    private Runnable f43847n0 = new o();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f43860c;

        a(boolean z3) {
            this.f43860c = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.qq.e.comm.plugin.q0.h hVar = j.this.f43828e;
            if (hVar == null) {
                return;
            }
            if (this.f43860c) {
                hVar.setVisibility(0);
                j.this.f43828e.a("mtaid.setPlayIconVisibility(true)");
                return;
            }
            hVar.a("mtaid.setPlayIconVisibility(false)");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.a(false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String c4 = com.qq.e.comm.plugin.e.a.a().c(j.this.f43821L);
            j.this.f43833g0 = System.currentTimeMillis();
            j jVar = j.this;
            com.qq.e.comm.plugin.l0.c.a(c4, jVar.f43840k, jVar.f43841k0, 1, null);
            j jVar2 = j.this;
            l1.a(jVar2.f43821L, jVar2.f43840k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class e implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f43871c;

        e(boolean z3) {
            this.f43871c = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.a(this.f43871c, false);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static /* synthetic */ class f {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f43873a;

        static {
            int[] iArr = new int[com.qq.e.comm.plugin.q0.t.c.values().length];
            f43873a = iArr;
            try {
                iArr[com.qq.e.comm.plugin.q0.t.c.ADReady.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43873a[com.qq.e.comm.plugin.q0.t.c.ADLoadFail.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f43873a[com.qq.e.comm.plugin.q0.t.c.Exposured.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f43873a[com.qq.e.comm.plugin.q0.t.c.ADSpecMeasured.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f43873a[com.qq.e.comm.plugin.q0.t.c.Clicked.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f43873a[com.qq.e.comm.plugin.q0.t.c.ADClosed.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f43873a[com.qq.e.comm.plugin.q0.t.c.ADLeftApplication.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f43873a[com.qq.e.comm.plugin.q0.t.c.ADOpenOverlay.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f43873a[com.qq.e.comm.plugin.q0.t.c.ADCloseOverlay.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class g extends FrameLayout {
        g(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            j.this.a(motionEvent);
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class h implements NativeExpressADView.ViewBindStatusListener {
        h() {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressADView.ViewBindStatusListener
        public void onAttachedToWindow() {
            j.this.h();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressADView.ViewBindStatusListener
        public void onDetachedFromWindow() {
            j.this.H();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressADView.ViewBindStatusListener
        public void onFinishTemporaryDetach() {
            j.this.h();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressADView.ViewBindStatusListener
        public void onStartTemporaryDetach() {
            j.this.H();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.gdtnativead.j$j  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class RunnableC0840j implements Runnable {
        RunnableC0840j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent;
            if (j.this.R) {
                return;
            }
            p pVar = j.this.f43855v;
            if (pVar != null && (parent = pVar.getParent()) != null) {
                ((ViewGroup) parent).removeView(j.this.f43855v);
            }
            j.this.F();
            j.this.o();
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
            if (j.this.R) {
                p pVar = j.this.f43855v;
                if (pVar != null) {
                    if (pVar.getParent() == null) {
                        j jVar = j.this;
                        jVar.f43854u.addView(jVar.f43855v);
                    }
                    if (j.this.C == 6) {
                        j.this.M();
                    }
                }
                j.this.I();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class l implements Runnable {
        l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j jVar = j.this;
            if (jVar.f43854u != null) {
                jVar.f43855v.i();
                j.this.f43854u.removeAllViews();
                j jVar2 = j.this;
                jVar2.f43854u = null;
                jVar2.f43855v = null;
            }
            if (j.this.F != null) {
                j.this.F.i();
                j.this.F.removeAllViews();
                j.this.F = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class m implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f43881c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Object[] f43882d;

        m(int i4, Object[] objArr) {
            this.f43881c = i4;
            this.f43882d = objArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.this.f43851r == null || j.this.f43851r.k() == null) {
                return;
            }
            j.this.f43851r.k().onADEvent(new ADEvent(this.f43881c, this.f43882d));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class n implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f43884c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Object[] f43885d;

        n(int i4, Object[] objArr) {
            this.f43884c = i4;
            this.f43885d = objArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.this.f43830f != null) {
                j.this.f43830f.onADEvent(new ADEvent(this.f43884c, this.f43885d));
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class o implements Runnable {
        o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder sb = new StringBuilder();
            sb.append("onContentChanged from view ");
            com.qq.e.comm.plugin.q0.h hVar = j.this.f43828e;
            sb.append(hVar != null ? Integer.valueOf(hVar.a().hashCode()) : null);
            d1.a(sb.toString(), new Object[0]);
            j.this.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class p extends com.qq.e.comm.plugin.o0.h.f {
        public p(Context context) {
            super(context);
        }

        public void b(boolean z3) {
            super.pause();
            if (z3) {
                j.this.C = 4;
            } else {
                j.this.C = 6;
            }
        }

        @Override // com.qq.e.comm.plugin.o0.h.f, com.qq.e.comm.plugin.o0.h.e
        public void pause() {
            b(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class q extends c2 {

        /* renamed from: h  reason: collision with root package name */
        private final WeakReference<j> f43889h;

        public q(j jVar) {
            super(Long.MAX_VALUE, 200L);
            this.f43889h = new WeakReference<>(jVar);
        }

        @Override // com.qq.e.comm.plugin.util.c2
        public void a(long j4) {
            j jVar = this.f43889h.get();
            if (jVar != null) {
                jVar.o();
            }
        }

        @Override // com.qq.e.comm.plugin.util.c2
        public void d() {
        }
    }

    static {
        String a4 = com.qq.e.comm.plugin.gdtnativead.d.a();
        f43818o0 = a4;
        f43819p0 = a(a4, "1.1.0") ? f43818o0 : "1.1.0";
        f43820q0 = "<script src=\"" + String.format("https://qzonestyle.gtimg.cn/qzone/biz/gdt/mob/sdk/v2/android03/js-release/%s/native.js", f43819p0) + "\"></script>\n";
    }

    public j(NEADI neadi, Context context, ViewGroup viewGroup, ADSize aDSize, String str, String str2, JSONObject jSONObject, HashMap<String, Object> hashMap) {
        this.f43839j0 = false;
        this.f43843l0 = str2;
        this.f43832g = aDSize;
        this.f43834h = viewGroup;
        if (neadi instanceof com.qq.e.comm.plugin.gdtnativead.g) {
            com.qq.e.comm.plugin.gdtnativead.g gVar = (com.qq.e.comm.plugin.gdtnativead.g) neadi;
            this.f43851r = gVar;
            this.f43826d = gVar.c();
            this.f43839j0 = this.f43851r.p();
        } else {
            this.f43826d = null;
        }
        this.f43844m = hashMap;
        this.f43821L = new g(context);
        viewGroup.addView(this.f43821L, new FrameLayout.LayoutParams(-1, -1));
        this.M = viewGroup;
        try {
            if (viewGroup instanceof NativeExpressADView) {
                ((NativeExpressADView) viewGroup).setViewBindStatusListener(new h());
            }
        } catch (NullPointerException unused) {
        }
        this.f43853t = context.getApplicationContext();
        this.Q = context;
        a(jSONObject);
        a(this.f43853t);
        N();
        if (((this.f43826d == com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD && com.qq.e.comm.plugin.gdtnativead.d.b()) || B()) && A()) {
            p();
        }
        x();
        this.f43840k.c(1);
        com.qq.e.comm.plugin.e.a.a().a(this.f43821L, this.f43840k);
    }

    private boolean A() {
        int i4 = this.f43858y;
        if (i4 == 3 || i4 == 4) {
            return true;
        }
        boolean z3 = com.qq.e.comm.plugin.d0.a.d().c().n() == com.qq.e.comm.plugin.d0.e.d.WIFI;
        int i5 = this.I;
        return i5 != 0 ? i5 != 2 : z3 || C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean B() {
        return this.f43826d == com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL;
    }

    private boolean C() {
        File c4 = b1.c(this.f43842l);
        if (c4 == null || !c4.exists()) {
            return false;
        }
        this.f43825c0 = (int) (c4.length() >> 10);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        com.qq.e.comm.plugin.q0.h hVar = this.f43828e;
        if (hVar != null) {
            hVar.a("mtaid.measureAdSpec()");
        }
    }

    private void E() {
        O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        c2 c2Var = this.f43857x;
        if (c2Var != null) {
            c2Var.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        this.R = false;
        p0.a((Runnable) new RunnableC0840j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        c2 c2Var = this.f43857x;
        if (c2Var != null) {
            c2Var.f();
        }
    }

    private void J() {
        a(103, new Object[]{this.f43834h});
        this.f43848o = true;
        this.f43821L.post(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        d(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        p pVar;
        if (this.f43858y != 1 || (pVar = this.f43855v) == null) {
            return;
        }
        if (this.H) {
            pVar.c();
        } else {
            pVar.a();
        }
    }

    private void N() {
        ViewGroup viewGroup = this.f43834h;
        if (viewGroup != null) {
            viewGroup.setTag(v());
        }
    }

    private void O() {
        if (this.f43857x == null) {
            this.f43857x = new q(this);
        }
        this.f43857x.g();
    }

    private void P() {
        c2 c2Var = this.f43857x;
        if (c2Var != null) {
            c2Var.h();
        }
    }

    private void x() {
        i iVar = new i(this.f43834h.getContext());
        this.f43829e0 = iVar;
        this.f43827d0 = new com.qq.e.comm.plugin.gdtnativead.l(this, iVar);
    }

    private void y() {
        int width;
        int a4;
        int a5;
        int a6;
        boolean z3 = B() && com.qq.e.comm.plugin.gdtnativead.d.d();
        this.O = z3;
        if (z3 && (width = this.f43821L.getWidth()) > 0 && this.N == null) {
            int a7 = f1.a(this.Q, 200);
            int i4 = 12;
            if (this.f43840k.o0() > this.f43840k.n0()) {
                a4 = f1.a(this.Q, 12);
            } else {
                a4 = f1.a(this.Q, 25);
            }
            if (a7 < width) {
                a5 = f1.a(this.Q, 32);
                a6 = f1.a(this.Q, 200);
            } else {
                a5 = f1.a(this.Q, 32);
                a6 = f1.a(this.Q, 144);
                i4 = 10;
            }
            this.N = com.qq.e.comm.plugin.f0.f.a(this.Q, a5, i4, this.f43840k.X0());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a6, a5);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = a4;
            this.f43821L.addView(this.N, layoutParams);
            this.N.bringToFront();
            this.N.setOnClickListener(this);
        }
    }

    private void z() {
        JSONObject a4 = com.qq.e.comm.plugin.gdtnativead.d.a(q());
        this.H = a4.optBoolean("autoPlayMuted", true);
        this.I = a4.optInt("autoPlayPolicy", com.qq.e.comm.plugin.util.c.a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String G() {
        if (this.f43828e == null) {
            d1.a("prepareAntiSpam view == null!!");
            return null;
        }
        com.qq.e.comm.plugin.e.a a4 = com.qq.e.comm.plugin.e.a.a();
        com.qq.e.comm.plugin.e.i.a d4 = a4.d(this.f43821L);
        if (this.O && d4 != null) {
            d4.a(12);
        }
        return a4.a(this.f43821L);
    }

    protected void K() {
        if (this.f43848o) {
            return;
        }
        J();
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void a(int i4) {
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void a(int i4, String str, String str2) {
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void a(ValueCallback<Uri> valueCallback, Intent intent) {
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void a(String str) {
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void a(String str, Bitmap bitmap) {
    }

    @Override // com.qq.e.comm.plugin.o0.h.b.a
    public void b() {
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void b(String str) {
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public boolean b(ValueCallback<Uri[]> valueCallback, Intent intent) {
        return false;
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void c(String str) {
    }

    @Override // com.qq.e.comm.pi.NEADVI
    public void destroy() {
        if (this.K) {
            return;
        }
        this.K = true;
        if (this.C == 1) {
            L();
        }
        P();
        if (this.f43855v != null) {
            p0.a((Runnable) new l());
        }
        com.qq.e.comm.plugin.q0.h hVar = this.f43828e;
        if (hVar != null) {
            hVar.e();
            this.f43828e = null;
        }
        com.qq.e.comm.plugin.e.a.a().b(this.f43821L);
        if (this.f43833g0 > 0) {
            com.qq.e.comm.plugin.gdtnativead.e.d(this.f43822a0, System.currentTimeMillis() - this.f43833g0);
        }
        if (this.f43850q == null && this.f43849p) {
            com.qq.e.comm.plugin.gdtnativead.e.f(this.f43822a0);
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        com.qq.e.comm.plugin.g0.e eVar = this.f43840k;
        if (eVar != null) {
            return eVar.r();
        }
        return null;
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        return this.f43840k.J();
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        return this.f43840k.W0();
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        return this.f43840k.R();
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        return !r();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.O) {
            com.qq.e.comm.plugin.gdtnativead.e.a(com.qq.e.comm.plugin.n0.c.a(this.f43840k), view == this.N);
        }
        if (!this.O || view == this.N) {
            c(new JSONObject());
        }
        if (view != this.f43854u || this.f43855v == null) {
            return;
        }
        int i4 = this.f43858y;
        if (i4 == 3 || i4 == 4) {
            this.f43855v.E();
        }
    }

    @Override // com.qq.e.comm.plugin.o0.h.b.a
    public void onVideoComplete() {
        this.C = 3;
        L();
        this.f43859z = 3;
        p pVar = this.f43855v;
        if (pVar != null) {
            pVar.setVisibility(4);
            com.qq.e.comm.plugin.o0.h.a.a(this.f43854u);
        }
        b(206, new Object[]{this.f43834h});
    }

    @Override // com.qq.e.comm.plugin.o0.h.b.a
    public void onVideoPause() {
        L();
        b(204, new Object[]{this.f43834h});
    }

    @Override // com.qq.e.comm.plugin.o0.h.b.a
    public void onVideoReady() {
        p pVar;
        this.A = 0;
        if (this.f43854u != null && (pVar = this.f43855v) != null) {
            this.D = pVar.getDuration();
            d1.a("duration = " + this.D, new Object[0]);
            com.qq.e.comm.plugin.o0.h.a.a(this.f43854u, this.f43840k.X(), this.f43855v);
        }
        b(210, new Object[]{this.f43834h, Integer.valueOf(this.D)});
    }

    @Override // com.qq.e.comm.plugin.o0.h.b.a
    public void onVideoResume() {
        this.f43859z = 2;
        this.C = 1;
        b(202, new Object[]{this.f43834h});
    }

    @Override // com.qq.e.comm.plugin.o0.h.b.a
    public void onVideoStart() {
        if (!this.f43837i0 && this.f43835h0 > 0) {
            com.qq.e.comm.plugin.gdtnativead.e.e(this.f43822a0, System.currentTimeMillis() - this.f43835h0);
            this.f43837i0 = true;
        }
        this.C = 1;
        String P0 = this.f43840k.P0();
        d1.a("call onVideoExpose", new Object[0]);
        u0.a(P0);
        if (!this.f43848o) {
            K();
        }
        p pVar = this.f43855v;
        if (pVar != null && pVar.getVisibility() != 0) {
            this.f43855v.setVisibility(0);
            com.qq.e.comm.plugin.o0.h.a.b(this.f43854u);
        }
        b(202, new Object[]{this.f43834h});
        com.qq.e.comm.plugin.gdtnativead.e.a(this.f43826d, true, this.f43822a0, 0, null);
        if (this.f43823b0 != 0) {
            l2.b(System.currentTimeMillis() - this.f43823b0, this.f43825c0, this.f43842l, this.f43822a0);
        }
        com.qq.e.comm.plugin.r0.b bVar = this.f43856w;
        if (bVar != null) {
            bVar.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.T)) {
            return;
        }
        com.qq.e.comm.plugin.gdtnativead.e.b(this.f43822a0, this.Z, this.Y, this.X);
    }

    @Override // com.qq.e.comm.plugin.o0.h.b.a
    public void onVideoStop() {
        this.C = 5;
        L();
        p pVar = this.f43855v;
        if (pVar != null) {
            pVar.setVisibility(4);
            com.qq.e.comm.plugin.o0.h.a.a(this.f43854u);
        }
        b(206, new Object[]{this.f43834h});
    }

    @Override // com.qq.e.comm.pi.NEADVI
    public void preloadVideo() {
        com.qq.e.comm.plugin.gdtnativead.e.e(this.f43822a0);
        p();
    }

    @Override // com.qq.e.comm.pi.NEADVI
    public void render() {
        this.f43835h0 = System.currentTimeMillis();
        if (this.f43826d == com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD) {
            com.qq.e.comm.plugin.util.u2.e.b().a(this.f43840k.q0(), com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD.d());
        }
        if (this.f43826d == com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD) {
            com.qq.e.comm.plugin.gdtnativead.e.b(this.f43822a0);
        }
        if (!this.f43849p && this.f43828e != null) {
            if (this.f43826d == com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD && r()) {
                b((com.qq.e.comm.plugin.q0.t.a) null);
                return;
            }
            com.qq.e.comm.plugin.q0.h hVar = this.f43828e;
            hVar.loadDataWithBaseURL(null, f43820q0 + this.f43846n, "text/html", "UTF-8", null);
            this.f43849p = true;
            com.qq.e.comm.plugin.gdtnativead.e.a(this.f43822a0);
            if (this.f43826d == com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD) {
                com.qq.e.comm.plugin.gdtnativead.e.d(this.f43822a0);
            }
        } else if (this.f43826d == com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD) {
            com.qq.e.comm.plugin.gdtnativead.e.c(this.f43822a0);
        }
    }

    @Override // com.qq.e.comm.pi.NEADVI
    public void reportAdNegative() {
        String j02 = this.f43840k.j0();
        if (!TextUtils.isEmpty(j02)) {
            a1.a(j02);
        } else {
            GDTLogger.e("reportAdNegative\u9519\u8bef negativeFeedbackUrl\u4e3a\u7a7a");
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i4, int i5, String str) {
        r.b(i4, i5, str, this.f43843l0, this.f43840k, this.f43822a0, this);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i4) {
        r.a(i4, this.f43840k, this.f43843l0, this.f43822a0, this);
    }

    @Override // com.qq.e.comm.pi.NEADVI
    public void setAdListener(ADListener aDListener) {
        this.f43830f = aDListener;
    }

    @Override // com.qq.e.comm.pi.NEADVI
    public void setAdSize(ADSize aDSize) {
        if (this.f43828e == null) {
            d1.a("Express AD View is null", (Throwable) null);
            return;
        }
        this.f43832g = aDSize;
        a(aDSize);
        ViewGroup.LayoutParams layoutParams = this.f43828e.a().getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = this.f43836i;
            layoutParams.height = this.f43838j;
        } else {
            layoutParams = new ViewGroup.LayoutParams(this.f43836i, this.f43838j);
        }
        this.f43828e.a().setLayoutParams(layoutParams);
        p0.a(this.f43847n0);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i4) {
        try {
            this.f43841k0 = r.a(i4);
        } catch (o1.d unused) {
            d1.a("pack price error");
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        com.qq.e.comm.plugin.g0.e eVar = this.f43840k;
        if (eVar != null && downloadConfirmListener != null) {
            String e02 = eVar.e0();
            d1.a("setDownloadConfirmListener express trace id:" + e02 + " listener:" + downloadConfirmListener, new Object[0]);
            com.qq.e.comm.plugin.b.j.b().a(e02, downloadConfirmListener);
            return;
        }
        GDTLogger.e("setDownloadConfirmListener\u9519\u8bef\u5e7f\u544a\u6570\u636e\u6216listener\u4e3a\u7a7a");
    }

    private void f(boolean z3) {
        if (C()) {
            File c4 = b1.c(this.f43842l);
            this.f43823b0 = System.currentTimeMillis();
            if (c4 != null) {
                this.f43855v.a(c4.getAbsolutePath());
            }
            com.qq.e.comm.plugin.r0.b bVar = this.f43856w;
            if (bVar != null) {
                bVar.setVisibility(8);
            }
            MediaView mediaView = this.f43854u;
            if (mediaView != null) {
                mediaView.setBackgroundColor(0);
                return;
            }
            return;
        }
        j();
        d0.f46406b.submit(new e(z3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.R = true;
        p0.a((Runnable) new k());
    }

    private void i() {
        MediaView mediaView = this.f43854u;
        if (mediaView == null || mediaView.getLayoutParams() == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f43854u.getLayoutParams();
        Context context = this.f43853t;
        RectF rectF = this.E;
        layoutParams.width = f1.a(context, (int) (rectF.right - rectF.left));
        Context context2 = this.f43853t;
        RectF rectF2 = this.E;
        layoutParams.height = f1.a(context2, (int) (rectF2.bottom - rectF2.top));
        layoutParams.leftMargin = f1.a(this.f43853t, (int) this.E.left);
        layoutParams.topMargin = f1.a(this.f43853t, (int) this.E.top);
        this.f43854u.setLayoutParams(layoutParams);
    }

    private void j() {
        e(false);
        if (this.f43856w == null) {
            this.f43856w = new com.qq.e.comm.plugin.r0.b(this.f43834h.getContext());
        }
        if (this.f43854u == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f1.a(this.f43853t, 46), f1.a(this.f43853t, 46));
        layoutParams.gravity = 17;
        this.f43854u.addView(this.f43856w, layoutParams);
        this.f43854u.setBackgroundColor(Color.parseColor("#40000000"));
    }

    private void k() {
        d1.a("callJsHeightMeasure view: " + this.f43828e.hashCode() + ", renderSuccess: " + this.f43850q + ", webViewWidth: " + this.P + ", adContentHeightInDp: " + this.f43852s, new Object[0]);
        if (!this.f43850q.booleanValue() || this.P <= 0) {
            return;
        }
        p0.a(this.f43847n0);
    }

    private void l() {
        MediaView mediaView;
        if (this.f43855v == null || (mediaView = this.f43854u) == null) {
            return;
        }
        if (!o2.a(this.f43853t, mediaView, 50, B())) {
            if (this.C == 1 && !this.f43831f0) {
                this.f43855v.b(false);
            }
            this.J = false;
            return;
        }
        int i4 = this.C;
        if (i4 != 0) {
            if (i4 != 3) {
                if (i4 != 4) {
                    if (i4 != 5) {
                        if (i4 == 6 && !this.f43855v.isPlaying()) {
                            this.f43855v.setVisibility(0);
                            com.qq.e.comm.plugin.o0.h.a.b(this.f43854u);
                            this.f43855v.play();
                        }
                    } else if (!this.f43855v.isPlaying() && A()) {
                        this.f43855v.setVisibility(0);
                        com.qq.e.comm.plugin.o0.h.a.b(this.f43854u);
                        this.f43855v.play();
                        M();
                        this.B = 1;
                    }
                } else if (this.f43858y == 1 && !this.f43855v.isPlaying()) {
                    this.f43855v.setVisibility(0);
                    com.qq.e.comm.plugin.o0.h.a.b(this.f43854u);
                    this.f43855v.play();
                }
            } else if (!this.J && !this.f43855v.isPlaying() && A()) {
                this.f43855v.setVisibility(0);
                com.qq.e.comm.plugin.o0.h.a.b(this.f43854u);
                this.f43855v.play();
                M();
                this.B = 1;
            }
        } else if (!this.f43855v.isPlaying() && A()) {
            this.f43855v.setVisibility(0);
            com.qq.e.comm.plugin.o0.h.a.b(this.f43854u);
            this.f43855v.play();
            M();
            this.B = 1;
        }
        this.J = true;
    }

    private void n() {
        if (!o2.a(this.f43853t, this.f43834h, c0.a(this.f43826d, this.f43843l0)) || this.f43848o || this.f43834h.getHeight() <= 1) {
            return;
        }
        if (!this.f43834h.hasWindowFocus()) {
            v.a(1040020, this.f43822a0);
        }
        J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (w()) {
            n();
            l();
            return;
        }
        n();
    }

    private void p() {
        if (TextUtils.isEmpty(this.f43842l) || this.S) {
            return;
        }
        this.S = true;
        if (C() && !this.f43845m0) {
            this.f43845m0 = true;
            if (!B()) {
                b(201, new Object[]{this.f43834h});
            } else if (!this.f43839j0) {
                this.f43851r.q();
            }
            d1.a("preloadVideo, video already cached, cl : " + this.f43840k.k(), new Object[0]);
            return;
        }
        d1.a("preloadVideo, cl : " + this.f43840k.k(), new Object[0]);
        d0.f46406b.submit(new b());
    }

    private boolean r() {
        return com.qq.e.comm.plugin.util.c.a(this.f43824c);
    }

    private int t() {
        p pVar = this.f43855v;
        if (pVar != null) {
            return pVar.getCurrentPosition();
        }
        return 0;
    }

    private int u() {
        return this.D;
    }

    @Override // com.qq.e.comm.plugin.q0.g
    public com.qq.e.comm.plugin.b.g g() {
        return com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD;
    }

    public String q() {
        return this.f43840k.q0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int s() {
        return this.O ? 12 : -999;
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(Map<String, Object> map) {
        r.a(map, this.f43843l0, this.f43840k, this.f43822a0, this);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        r.a(map, this.f43840k, this.f43843l0, this.f43822a0, this);
    }

    public Point v() {
        return new Point(this.f43840k.I0(), this.f43840k.F0());
    }

    protected boolean w() {
        return !TextUtils.isEmpty(this.f43842l);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c implements com.qq.e.comm.plugin.p.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f43863a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f43864b;

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.c();
            }
        }

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class b implements Runnable {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f43867c;

            b(int i4) {
                this.f43867c = i4;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (j.this.f43856w != null) {
                    j.this.f43856w.a(this.f43867c);
                    if (this.f43867c == 100) {
                        j.this.f43856w.setVisibility(8);
                        MediaView mediaView = j.this.f43854u;
                        if (mediaView != null) {
                            mediaView.setBackgroundColor(0);
                        }
                        j.this.e(true);
                    }
                }
                c.this.c();
            }
        }

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.gdtnativead.j$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class RunnableC0839c implements Runnable {
            RunnableC0839c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                j.this.A = 0;
                if (j.this.S && !j.this.f43845m0) {
                    j.this.f43845m0 = true;
                    if (j.this.B()) {
                        if (!j.this.f43839j0) {
                            j.this.f43851r.q();
                        }
                    } else {
                        j jVar = j.this;
                        jVar.b(201, new Object[]{jVar.f43834h});
                    }
                }
                File c4 = b1.c(j.this.f43842l);
                j jVar2 = j.this;
                if (jVar2.f43855v == null || c4 == null) {
                    return;
                }
                jVar2.f43823b0 = System.currentTimeMillis();
                if (TextUtils.isEmpty(c.this.f43863a) || !j.this.U) {
                    j.this.f43855v.a(c4.getAbsolutePath());
                    j.this.f43855v.play();
                }
                j.this.M();
                c cVar = c.this;
                if (cVar.f43864b) {
                    j.this.B = 1;
                } else {
                    j.this.B = 0;
                }
            }
        }

        c(String str, boolean z3) {
            this.f43863a = str;
            this.f43864b = z3;
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a() {
            d1.a("onStarted", new Object[0]);
            j.this.V = true;
            j jVar = j.this;
            jVar.b(211, new Object[]{jVar.f43834h});
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(boolean z3) {
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void b() {
        }

        void c() {
            if (j.this.f43855v == null || TextUtils.isEmpty(this.f43863a) || j.this.W) {
                return;
            }
            j.this.W = true;
            j.this.f43855v.a(this.f43863a);
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(long j4, boolean z3) {
            j.this.f43825c0 = (int) (j4 >> 10);
            p0.a((Runnable) new a());
            d1.a("onConnected isRangeSupport: " + z3 + ", total: " + j4, new Object[0]);
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(long j4, long j5, int i4) {
            d1.a("downloading video ---> Progress: " + i4 + "%", new Object[0]);
            j.this.X = j5;
            j.this.Y = j4;
            j.this.Z = i4;
            p0.a((Runnable) new b(i4));
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(File file, long j4) {
            d1.a("onCompleted", new Object[0]);
            d1.a("download time: " + j4 + "ms", new Object[0]);
            j.this.V = false;
            j.this.e(true);
            p0.a((Runnable) new RunnableC0839c());
            l2.a(j4, j.this.f43825c0, j.this.f43842l, j.this.f43822a0);
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(com.qq.e.comm.plugin.p.d dVar) {
            int a4 = dVar.a();
            GDTLogger.w("\u89c6\u9891\u4e0b\u8f7d\u5931\u8d25, code: " + a4 + ", msg: " + dVar.b(), null);
            j.this.V = false;
            j.this.A = 2;
            j.this.L();
            j jVar = j.this;
            jVar.b(207, new Object[]{jVar.f43834h, 5002});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z3) {
        p0.a((Runnable) new a(z3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class i extends com.qq.e.comm.plugin.i.d0.d {

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class a implements b.a {
            a() {
            }

            @Override // com.qq.e.comm.plugin.i.b.a
            public void a() {
                j jVar = j.this;
                jVar.a(1003, new Object[]{jVar.f43834h});
            }
        }

        i(Context context) {
            super(context);
        }

        @Override // com.qq.e.comm.plugin.i.d0.d, com.qq.e.comm.plugin.i.d0.b
        public boolean a(String str, com.qq.e.comm.plugin.g0.e eVar) {
            boolean a4 = super.a(str, eVar);
            if (a4) {
                j jVar = j.this;
                jVar.a(1002, new Object[]{jVar.f43834h});
                com.qq.e.comm.plugin.i.b.a(new a());
            }
            return a4;
        }

        @Override // com.qq.e.comm.plugin.i.d0.d, com.qq.e.comm.plugin.i.d0.b
        public void c() {
            super.c();
            j jVar = j.this;
            jVar.a(1007, new Object[]{jVar.f43834h});
        }

        @Override // com.qq.e.comm.plugin.i.d0.d, com.qq.e.comm.plugin.i.d0.b
        public void a(boolean z3) {
            if (z3) {
                j jVar = j.this;
                jVar.a(303, new Object[]{jVar.f43834h});
                j jVar2 = j.this;
                jVar2.a(1002, new Object[]{jVar2.f43834h});
            }
            super.a(z3);
        }
    }

    private void b(JSONObject jSONObject) {
        d1.a("Get AdSpecMeasured params\uff1a" + jSONObject.toString() + ", adContentHeightInDp: " + this.f43852s + ", view is " + this.f43828e.a().hashCode(), new Object[0]);
        this.f43852s = jSONObject.optInt("contentHeight");
        if (this.f43832g.getHeight() <= 0) {
            b(this.f43852s);
        }
        y();
        if (w() && m2.a()) {
            this.E.left = jSONObject.optInt("imgHolderLeft");
            this.E.top = jSONObject.optInt("imgHolderTop");
            this.E.right = jSONObject.optInt("imgHolderRight") + 1;
            this.E.bottom = jSONObject.optInt("imgHolderBottom") + 1;
            if (this.f43854u != null) {
                i();
            } else if (A()) {
                c(true);
            }
            View view = this.N;
            if (view != null) {
                view.bringToFront();
            }
        }
    }

    private void d(JSONObject jSONObject) {
        if (this.f43850q != null) {
            return;
        }
        com.qq.e.comm.plugin.gdtnativead.e.c(this.f43822a0, System.currentTimeMillis() - this.f43835h0);
        d1.a("renderSuccess view: " + this.f43828e.hashCode(), new Object[0]);
        this.f43850q = Boolean.TRUE;
        a(this.f43832g);
        this.f43821L.addView(this.f43828e.a(), new ViewGroup.LayoutParams(this.f43836i, this.f43838j));
        a(109, new Object[]{this.f43834h});
        k();
        com.qq.e.comm.plugin.gdtnativead.e.f(this.f43822a0, System.currentTimeMillis() - this.f43835h0);
        com.qq.e.comm.plugin.b.g gVar = this.f43826d;
        if (gVar == com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD || gVar == com.qq.e.comm.plugin.b.g.UNIFIED_BANNER) {
            com.qq.e.comm.plugin.gdtnativead.e.a(this.f43822a0, System.currentTimeMillis() - this.f43851r.f43794x);
        }
    }

    @Override // com.qq.e.comm.plugin.q0.h.a
    public void c() {
        int measuredWidth;
        StringBuilder sb = new StringBuilder();
        sb.append("webview onLayout: ");
        sb.append(this.f43821L.hashCode());
        sb.append(", view width: ");
        com.qq.e.comm.plugin.q0.h hVar = this.f43828e;
        sb.append(hVar != null ? Integer.valueOf(hVar.a().getMeasuredWidth()) : "null");
        d1.a(sb.toString(), new Object[0]);
        com.qq.e.comm.plugin.q0.h hVar2 = this.f43828e;
        if (hVar2 == null || (measuredWidth = hVar2.a().getMeasuredWidth()) == this.P) {
            return;
        }
        this.P = measuredWidth;
        k();
    }

    private static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return str2.substring(0, str2.lastIndexOf(".")).equals(str.substring(0, str.lastIndexOf(".")));
    }

    private void c(boolean z3) {
        if (this.f43854u == null) {
            Context context = this.f43853t;
            RectF rectF = this.E;
            int a4 = f1.a(context, (int) (rectF.right - rectF.left));
            Context context2 = this.f43853t;
            RectF rectF2 = this.E;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a4, f1.a(context2, (int) (rectF2.bottom - rectF2.top)));
            layoutParams.leftMargin = f1.a(this.f43853t, (int) this.E.left);
            layoutParams.topMargin = f1.a(this.f43853t, (int) this.E.top);
            MediaView mediaView = new MediaView(this.f43834h.getContext());
            this.f43854u = mediaView;
            mediaView.setLayoutParams(layoutParams);
            this.f43821L.addView(this.f43854u);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            layoutParams2.gravity = 17;
            p pVar = new p(this.f43834h.getContext());
            this.f43855v = pVar;
            pVar.a(this.f43840k);
            this.f43855v.b(this.f43840k.R0(), this.f43840k.N0());
            if (com.qq.e.comm.plugin.d0.a.d().f().a("disascon", q(), 1) != 1) {
                this.f43855v.setKeepScreenOn(true);
            }
            this.f43855v.setLayoutParams(layoutParams2);
            if (B()) {
                this.f43855v.a(this.f43840k.o0(), this.f43840k.n0());
            }
            this.f43854u.addView(this.f43855v);
            this.f43854u.setOnClickListener(this);
            com.qq.e.comm.plugin.gdtnativead.p.a aVar = new com.qq.e.comm.plugin.gdtnativead.p.a(this.f43834h.getContext(), this.f43858y, this.f43840k.X());
            this.F = aVar;
            aVar.a(this);
            this.f43855v.a(this.F);
            com.qq.e.comm.plugin.r0.a aVar2 = new com.qq.e.comm.plugin.r0.a(this.f43834h.getContext());
            this.G = aVar2;
            aVar2.setVisibility(4);
            int a5 = f1.a(this.f43853t, 46);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(a5, a5);
            layoutParams3.gravity = 17;
            this.f43854u.addView(this.G, layoutParams3);
            com.qq.e.comm.plugin.b.n a6 = com.qq.e.comm.plugin.gdtnativead.a.a(this.f43844m);
            if (a6 != null) {
                a6.a(new com.qq.e.comm.plugin.gdtnativead.o(this.f43855v));
            }
            b(209, new Object[]{this.f43834h});
            if (this.V && B()) {
                b(211, new Object[]{this.f43834h});
            }
            f(z3);
        }
    }

    private void a(Context context) {
        com.qq.e.comm.plugin.q0.h a4 = new com.qq.e.comm.plugin.q0.d(context, this.f43840k, this).a((com.qq.e.comm.plugin.q0.t.b) this).a((h.a) this).a(false).b(false).c(false).d(true).a();
        this.f43828e = a4;
        a4.d();
    }

    private void d(boolean z3) {
        com.qq.e.comm.plugin.l0.c.a(this.B, this.f43858y, this.f43859z, z3 ? 3 : this.A, this.A == 0 ? t() : 0, this.A == 0 ? u() : 0, this.f43840k, null);
    }

    private void a(JSONObject jSONObject) {
        com.qq.e.comm.plugin.g0.e eVar = (com.qq.e.comm.plugin.g0.e) this.f43844m.get("admodel");
        this.f43840k = eVar;
        this.f43824c = com.qq.e.comm.plugin.util.c.b(eVar);
        this.f43842l = this.f43840k.L0();
        this.f43822a0 = com.qq.e.comm.plugin.n0.c.a(this.f43840k);
        if (jSONObject != null) {
            this.f43846n = jSONObject.optString(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        }
        if (w() && m2.a()) {
            z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i4, Object[] objArr) {
        p0.a((Runnable) new n(i4, objArr));
    }

    private void b(com.qq.e.comm.plugin.q0.t.a aVar) {
        if (this.f43850q != null) {
            return;
        }
        this.f43850q = Boolean.FALSE;
        this.f43828e.setVisibility(8);
        a(110, new Object[]{this.f43834h});
        com.qq.e.comm.plugin.gdtnativead.e.a(this.f43822a0, 0, aVar == null ? "" : aVar.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MotionEvent motionEvent) {
        com.qq.e.comm.plugin.e.i.a d4 = com.qq.e.comm.plugin.e.a.a().d(this.f43821L);
        if (d4 != null) {
            d4.a(motionEvent, false);
        }
    }

    private void a(ADSize aDSize) {
        if (aDSize.getWidth() <= 0 && aDSize.getWidth() != -1) {
            GDTLogger.w("NativeExpressAD\u7684\u5bbd\u5ea6\u5fc5\u987b\u5927\u4e8e0\u6216\u8005\u4e3aADSize.FULL_WIDTH\uff0c\u5df2\u5c06\u5e7f\u544a\u5bbd\u5ea6\u8c03\u6574\u4e3aADSize.FULL_WIDTH", null);
        }
        if (aDSize.getHeight() <= 0 && aDSize.getHeight() != -2) {
            GDTLogger.w("NativeExpressAD\u7684\u9ad8\u5ea6\u5fc5\u987b\u5927\u4e8e0\u6216\u8005\u4e3aADSize.AUTO_HEIGHT\uff0c\u5df2\u7ecf\u5e7f\u544a\u9ad8\u5ea6\u8c03\u6574\u4e3aADSize.AUTO_HEIGHT", null);
        }
        this.f43836i = aDSize.getWidth() > 0 ? f1.a(this.f43853t, aDSize.getWidth()) : -1;
        this.f43838j = aDSize.getHeight() <= 0 ? 1 : f1.a(this.f43853t, aDSize.getHeight());
        int c4 = f1.c(this.f43853t);
        int a4 = f1.a(this.f43853t);
        if (this.f43836i > c4) {
            this.f43836i = c4;
        }
        if (this.f43838j > a4) {
            this.f43838j = a4;
        }
        d1.a("ExpressADView's width in pixel = " + this.f43836i + ", height in pixel = " + this.f43838j, new Object[0]);
    }

    private void b(int i4) {
        ADSize aDSize = new ADSize(this.f43832g.getWidth(), i4);
        ViewGroup.LayoutParams layoutParams = this.f43828e.a().getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        a(aDSize);
        int i5 = layoutParams.height;
        int i6 = this.f43838j;
        if (i5 != i6) {
            layoutParams.height = i6;
            this.f43828e.a().setLayoutParams(layoutParams);
        }
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.a.d
    public void b(boolean z3) {
        if (this.C == 3) {
            int i4 = this.f43858y;
            if (i4 == 3 || i4 == 4) {
                this.B = 0;
            }
        }
    }

    @Override // com.qq.e.comm.plugin.q0.t.b
    public void a(com.qq.e.comm.plugin.q0.t.a aVar) {
        d1.a("On AD LifeEvent: " + aVar.b(), new Object[0]);
        switch (f.f43873a[aVar.b().ordinal()]) {
            case 1:
                d(aVar.a());
                return;
            case 2:
                b(aVar);
                return;
            case 3:
                E();
                return;
            case 4:
                b(aVar.a());
                return;
            case 5:
                if (this.O) {
                    return;
                }
                c(aVar.a());
                return;
            case 6:
                a(106, new Object[]{this.f43834h});
                destroy();
                if (this.f43833g0 > 0) {
                    com.qq.e.comm.plugin.gdtnativead.e.a(this.f43822a0, u(), System.currentTimeMillis() - this.f43833g0);
                    return;
                }
                return;
            case 7:
                a(303, new Object[]{this.f43834h});
                return;
            case 8:
                a(1002, new Object[]{this.f43834h});
                this.f43831f0 = true;
                return;
            case 9:
                this.f43831f0 = false;
                return;
            default:
                return;
        }
    }

    private void c(JSONObject jSONObject) {
        if (this.f43833g0 > 0) {
            com.qq.e.comm.plugin.gdtnativead.e.b(this.f43822a0, System.currentTimeMillis() - this.f43833g0);
        }
        if (!TextUtils.isEmpty(this.f43842l)) {
            d(true);
        }
        this.f43827d0.a(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i4, Object[] objArr) {
        m mVar = new m(i4, objArr);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            p0.a((Runnable) mVar);
        } else {
            mVar.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z3, boolean z4) {
        double H = this.f43840k.H();
        b.C0867b c0867b = new b.C0867b();
        String a4 = com.qq.e.comm.plugin.p0.e.a().a(this.f43842l);
        boolean z5 = !TextUtils.isEmpty(a4);
        if (z4 && z5 && com.qq.e.comm.plugin.util.v2.a.a(H)) {
            if (!this.S || this.f43845m0) {
                return;
            }
            this.f43845m0 = true;
            if (!B()) {
                b(201, new Object[]{this.f43834h});
                return;
            } else if (this.f43839j0) {
                return;
            } else {
                this.f43851r.q();
                return;
            }
        }
        this.T = a4;
        com.qq.e.comm.plugin.o0.g.a.a().a(c0867b.d(this.f43842l).a(b1.d(this.f43842l)).a(b1.p()).d(!z5).c(com.qq.e.comm.plugin.util.v2.a.b("vcrn") + this.f43840k.o().d()).a(this.f43822a0).a(), new c(a4, z3));
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.a.d
    public void a(boolean z3) {
        com.qq.e.comm.plugin.r0.a aVar = this.G;
        if (aVar != null) {
            if (z3) {
                aVar.setVisibility(0);
                this.G.b();
                return;
            }
            aVar.c();
            this.G.setVisibility(4);
        }
    }

    @Override // com.qq.e.comm.plugin.o0.h.b.a
    public void a(int i4, Exception exc) {
        this.A = 2;
        L();
        b(207, new Object[]{this.f43834h, 5003});
        com.qq.e.comm.plugin.gdtnativead.e.a(this.f43826d, false, this.f43822a0, i4, exc);
        if (TextUtils.isEmpty(this.T)) {
            return;
        }
        com.qq.e.comm.plugin.gdtnativead.e.a(this.f43822a0, this.Z, this.Y, this.X);
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void a() {
        a(303, new Object[]{this.f43834h});
    }
}
