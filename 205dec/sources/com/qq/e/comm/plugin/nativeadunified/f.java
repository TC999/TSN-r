package com.qq.e.comm.plugin.nativeadunified;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.CustomizeVideo;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.NativeUnifiedADDataAdapter;
import com.qq.e.ads.nativ.VideoPreloadListener;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.ads.nativ.widget.ViewStatusListener;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADEventListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import com.qq.e.comm.plugin.callback.biz.DialogStateCallback;
import com.qq.e.comm.plugin.g0.b0;
import com.qq.e.comm.plugin.g0.y;
import com.qq.e.comm.plugin.gdtnativead.p.a;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.o0.g.b;
import com.qq.e.comm.plugin.o0.h.f;
import com.qq.e.comm.plugin.r0.i;
import com.qq.e.comm.plugin.util.a1;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.c0;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.k2;
import com.qq.e.comm.plugin.util.l1;
import com.qq.e.comm.plugin.util.l2;
import com.qq.e.comm.plugin.util.o1;
import com.qq.e.comm.plugin.util.o2;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f implements NativeUnifiedADData, com.qq.e.comm.plugin.apkmanager.w.a, a.d, ADEventListener, com.qq.e.comm.plugin.e0.b, com.qq.e.comm.plugin.util.v2.e {

    /* renamed from: u0  reason: collision with root package name */
    private static final String f44845u0 = f.class.getCanonicalName();
    private final boolean A;
    private final boolean B;
    private final boolean C;
    private volatile String E;
    private long G;
    private long H;
    private volatile int I;
    private volatile boolean J;
    private com.qq.e.comm.plugin.util.v2.b K;

    /* renamed from: L  reason: collision with root package name */
    private ADListener f44846L;
    ImageView M;
    private String N;
    private final com.qq.e.comm.plugin.n0.c P;
    private long Q;
    private com.qq.e.comm.plugin.nativeadunified.e S;
    private boolean T;
    private List<ImageView> V;
    long W;
    long X;
    private boolean Y;
    private String Z;

    /* renamed from: a0  reason: collision with root package name */
    private String f44847a0;

    /* renamed from: b0  reason: collision with root package name */
    private long f44848b0;

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.comm.plugin.nativeadunified.i f44849c;

    /* renamed from: c0  reason: collision with root package name */
    private final int f44850c0;

    /* renamed from: d  reason: collision with root package name */
    private Context f44851d;

    /* renamed from: d0  reason: collision with root package name */
    private com.qq.e.comm.plugin.k0.e.b f44852d0;

    /* renamed from: e  reason: collision with root package name */
    private final com.qq.e.comm.plugin.nativeadunified.g f44853e;

    /* renamed from: e0  reason: collision with root package name */
    private long f44854e0;

    /* renamed from: f  reason: collision with root package name */
    ViewGroup f44855f;

    /* renamed from: f0  reason: collision with root package name */
    private final boolean f44856f0;

    /* renamed from: g  reason: collision with root package name */
    boolean f44857g;

    /* renamed from: g0  reason: collision with root package name */
    private boolean f44858g0;

    /* renamed from: h0  reason: collision with root package name */
    private boolean f44860h0;

    /* renamed from: i  reason: collision with root package name */
    MediaView f44861i;

    /* renamed from: i0  reason: collision with root package name */
    private boolean f44862i0;

    /* renamed from: j  reason: collision with root package name */
    private com.qq.e.comm.plugin.nativeadunified.p.b f44863j;

    /* renamed from: j0  reason: collision with root package name */
    private boolean f44864j0;

    /* renamed from: k0  reason: collision with root package name */
    private long f44866k0;

    /* renamed from: l  reason: collision with root package name */
    private long f44867l;

    /* renamed from: l0  reason: collision with root package name */
    private final int f44868l0;

    /* renamed from: m  reason: collision with root package name */
    private int f44869m;

    /* renamed from: p0  reason: collision with root package name */
    private final boolean f44876p0;

    /* renamed from: q0  reason: collision with root package name */
    private final boolean f44878q0;

    /* renamed from: r  reason: collision with root package name */
    private boolean f44879r;

    /* renamed from: r0  reason: collision with root package name */
    private final boolean f44880r0;

    /* renamed from: s  reason: collision with root package name */
    private boolean f44881s;

    /* renamed from: s0  reason: collision with root package name */
    private final int f44882s0;

    /* renamed from: t  reason: collision with root package name */
    private boolean f44883t;

    /* renamed from: y  reason: collision with root package name */
    private volatile boolean f44889y;

    /* renamed from: z  reason: collision with root package name */
    boolean f44890z;

    /* renamed from: h  reason: collision with root package name */
    private int f44859h = 0;

    /* renamed from: k  reason: collision with root package name */
    private com.qq.e.comm.plugin.nativeadunified.c f44865k = com.qq.e.comm.plugin.nativeadunified.c.INIT;

    /* renamed from: n  reason: collision with root package name */
    private int f44871n = 1;

    /* renamed from: o  reason: collision with root package name */
    int f44873o = 1;

    /* renamed from: p  reason: collision with root package name */
    int f44875p = 1;

    /* renamed from: q  reason: collision with root package name */
    private int f44877q = 1;

    /* renamed from: u  reason: collision with root package name */
    private int f44885u = com.qq.e.comm.plugin.util.c.a();

    /* renamed from: v  reason: collision with root package name */
    private boolean f44886v = false;

    /* renamed from: w  reason: collision with root package name */
    private boolean f44887w = false;

    /* renamed from: x  reason: collision with root package name */
    boolean f44888x = false;
    private volatile com.qq.e.comm.plugin.nativeadunified.o D = com.qq.e.comm.plugin.nativeadunified.o.f44987c;
    private AtomicBoolean F = new AtomicBoolean(false);
    private final t O = new t(Looper.getMainLooper());
    private boolean R = false;
    private boolean U = false;

    /* renamed from: m0  reason: collision with root package name */
    private long f44870m0 = 0;

    /* renamed from: n0  reason: collision with root package name */
    private float f44872n0 = 0.0f;

    /* renamed from: o0  reason: collision with root package name */
    private boolean f44874o0 = false;

    /* renamed from: t0  reason: collision with root package name */
    private List<com.qq.e.comm.plugin.nativeadunified.l> f44884t0 = new ArrayList();

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class c implements CustomizeVideo {
        c() {
        }

        @Override // com.qq.e.ads.nativ.CustomizeVideo
        public String getVideoUrl() {
            return f.this.f44853e.L0();
        }

        @Override // com.qq.e.ads.nativ.CustomizeVideo
        public void reportVideoCompleted() {
            d1.a(f.f44845u0, "reportVideoCompleted");
        }

        @Override // com.qq.e.ads.nativ.CustomizeVideo
        public void reportVideoError(long j4, int i4, int i5) {
            d1.a(f.f44845u0, "reportVideoError position=%d, errorWhat=%d, errorExtra=%d", Long.valueOf(j4), Integer.valueOf(i4), Integer.valueOf(i5));
        }

        @Override // com.qq.e.ads.nativ.CustomizeVideo
        public void reportVideoPause(long j4) {
            d1.a(f.f44845u0, "reportVideoPause %d", Long.valueOf(j4));
        }

        @Override // com.qq.e.ads.nativ.CustomizeVideo
        public void reportVideoPreload() {
            d1.a(f.f44845u0, "reportVideoPreload");
        }

        @Override // com.qq.e.ads.nativ.CustomizeVideo
        public void reportVideoResume(long j4) {
            d1.a(f.f44845u0, "reportVideoResume %d", Long.valueOf(j4));
        }

        @Override // com.qq.e.ads.nativ.CustomizeVideo
        public void reportVideoStart() {
            d1.a(f.f44845u0, "reportVideoStart");
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
            f.this.H();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.nativeadunified.f$f  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class RunnableC0859f implements Runnable {
        RunnableC0859f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.H();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f44863j != null) {
                f.this.f44863j.g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.qq.e.comm.plugin.l0.c.a(com.qq.e.comm.plugin.e.a.a().c(f.this.f44855f), f.this.f44853e, f.this.Z, f.this.f44853e.u0(), null);
            f fVar = f.this;
            l1.b(fVar.f44855f, fVar.f44853e, 1);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f44863j != null) {
                f.this.f44863j.a(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class j implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f44907c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Object[] f44908d;

        j(int i4, Object[] objArr) {
            this.f44907c = i4;
            this.f44908d = objArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.b(this.f44907c, this.f44908d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static /* synthetic */ class k {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f44910a;

        static {
            int[] iArr = new int[com.qq.e.comm.plugin.nativeadunified.c.values().length];
            f44910a = iArr;
            try {
                iArr[com.qq.e.comm.plugin.nativeadunified.c.AUTO_PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f44910a[com.qq.e.comm.plugin.nativeadunified.c.PLAYING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f44910a[com.qq.e.comm.plugin.nativeadunified.c.INIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f44910a[com.qq.e.comm.plugin.nativeadunified.c.MANUAL_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f44910a[com.qq.e.comm.plugin.nativeadunified.c.DEV_PAUSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f44910a[com.qq.e.comm.plugin.nativeadunified.c.DEV_STOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f44910a[com.qq.e.comm.plugin.nativeadunified.c.END.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class l implements View.OnAttachStateChangeListener {
        l() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            d1.a("Container has attached to window", new Object[0]);
            f.this.L();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            d1.a("Container has detached to window", new Object[0]);
            f.this.N();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class m implements com.qq.e.comm.plugin.b0.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f44912a;

        m(List list) {
            this.f44912a = list;
        }

        @Override // com.qq.e.comm.plugin.b0.c
        public void a(String str, int i4, Exception exc) {
        }

        @Override // com.qq.e.comm.plugin.b0.c
        public void a(String str, ImageView imageView, com.qq.e.comm.plugin.b0.f fVar) {
            f.this.U = true;
            f.this.a(this.f44912a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class n implements com.qq.e.comm.plugin.b0.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicInteger f44914a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f44915b;

        n(AtomicInteger atomicInteger, List list) {
            this.f44914a = atomicInteger;
            this.f44915b = list;
        }

        @Override // com.qq.e.comm.plugin.b0.c
        public void a(String str, int i4, Exception exc) {
        }

        @Override // com.qq.e.comm.plugin.b0.c
        public void a(String str, ImageView imageView, com.qq.e.comm.plugin.b0.f fVar) {
            if (this.f44914a.decrementAndGet() == 0) {
                f.this.U = true;
                f.this.a(this.f44915b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class o implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f44917c;

        o(List list) {
            this.f44917c = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.T) {
                return;
            }
            View[] viewArr = new View[this.f44917c.size()];
            this.f44917c.toArray(viewArr);
            f fVar = f.this;
            fVar.T = com.qq.e.comm.plugin.nativeadunified.n.a(fVar.P, viewArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class p implements ViewStatusListener {
        p() {
        }

        @Override // com.qq.e.ads.nativ.widget.ViewStatusListener
        public void onAttachToWindow() {
            d1.a("Container has attached to window", new Object[0]);
            f.this.L();
            ImageView imageView = f.this.M;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        }

        @Override // com.qq.e.ads.nativ.widget.ViewStatusListener
        public void onDetachFromWindow() {
            d1.a("Container has detached to window", new Object[0]);
            f.this.N();
            ImageView imageView = f.this.M;
            if (imageView != null) {
                imageView.setVisibility(4);
            }
        }

        @Override // com.qq.e.ads.nativ.widget.ViewStatusListener
        public void onDispatchTouchEvent(MotionEvent motionEvent) {
            com.qq.e.comm.plugin.e.i.a d4 = com.qq.e.comm.plugin.e.a.a().d(f.this.f44855f);
            if (d4 != null) {
                d4.a(motionEvent, false);
            }
        }

        @Override // com.qq.e.ads.nativ.widget.ViewStatusListener
        public void onWindowFocusChanged(boolean z3) {
        }

        @Override // com.qq.e.ads.nativ.widget.ViewStatusListener
        public void onWindowVisibilityChanged(int i4) {
            d1.a("Container visibility changed visibility: " + i4, new Object[0]);
            if (i4 == 0) {
                f.this.L();
            } else {
                f.this.N();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class q implements View.OnClickListener {
        q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.K();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class r implements i.f {
        r() {
        }

        @Override // com.qq.e.comm.plugin.r0.i.f
        public void onComplainSuccess() {
            f.this.b(304, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class s implements DialogInterface.OnDismissListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ DialogStateCallback f44922c;

        s(f fVar, DialogStateCallback dialogStateCallback) {
            this.f44922c = dialogStateCallback;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            this.f44922c.onDismiss().b(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class t extends Handler {
        t(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (f.this.g()) {
                        f fVar = f.this;
                        fVar.a((View) fVar.f44855f);
                        return;
                    }
                    sendEmptyMessageDelayed(1, f.this.A() ? 100L : 1000L);
                    return;
                case 2:
                default:
                    return;
                case 3:
                    d1.a("MSG_CHECK_VISIBILITY, mMediaStatus = " + f.this.f44865k, new Object[0]);
                    boolean D = f.this.D();
                    f.this.d(D);
                    f.this.c(D);
                    f.this.k(D);
                    f.this.O.sendEmptyMessageDelayed(3, 200L);
                    return;
                case 4:
                    if (f.this.f44863j != null) {
                        f.this.f44863j.a(message.arg1);
                        if (message.arg1 == 100) {
                            f.this.f44863j.i();
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (f.this.f44863j != null) {
                        f.this.f44863j.a(true);
                        break;
                    }
                    break;
                case 6:
                    f.this.D = com.qq.e.comm.plugin.nativeadunified.o.f44990f;
                    Object obj = message.obj;
                    if (obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) {
                        f.this.b(212, new Object[0]);
                    }
                    f fVar2 = f.this;
                    if (fVar2.f44890z) {
                        fVar2.H();
                        return;
                    }
                    return;
                case 7:
                    Object obj2 = message.obj;
                    if (obj2 instanceof Boolean ? ((Boolean) obj2).booleanValue() : false) {
                        f.this.b(213, 5002);
                    }
                    f fVar3 = f.this;
                    if (fVar3.f44890z) {
                        fVar3.f44871n = 2;
                        f.this.D = com.qq.e.comm.plugin.nativeadunified.o.f44991g;
                        f.this.i();
                        f.this.a(107, 5002);
                        return;
                    }
                    return;
                case 8:
                    break;
            }
            if (f.this.f44863j != null) {
                f.this.f44863j.i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(JSONObject jSONObject, com.qq.e.comm.plugin.nativeadunified.i iVar) {
        boolean z3 = false;
        this.f44847a0 = iVar.e();
        com.qq.e.comm.plugin.nativeadunified.g gVar = new com.qq.e.comm.plugin.nativeadunified.g(iVar.b(), this.f44847a0, iVar.h(), iVar.a(), jSONObject, iVar.c());
        this.f44853e = gVar;
        this.f44848b0 = com.qq.e.comm.plugin.util.c.b(gVar);
        y i02 = this.f44853e.i0();
        if (i02 != null) {
            this.f44853e.c(3);
        } else {
            this.f44853e.c(0);
        }
        this.f44849c = iVar;
        com.qq.e.comm.plugin.d0.d.h f4 = com.qq.e.comm.plugin.d0.a.d().f();
        this.A = f4.a("nativeCheckWindowFocus", 1) == 1;
        this.B = f4.a("nacvp", 1) == 1;
        this.f44856f0 = com.qq.e.comm.plugin.t.c.a("nucve", this.f44853e.q0(), 0, this.f44853e.p0()) == 1;
        this.C = (A() || !((f4.a("nunrcfg", this.f44847a0, 3) & 2) == 2) || i02 == null || this.f44853e.o1() == 3) ? false : true;
        this.P = com.qq.e.comm.plugin.n0.c.a(this.f44853e);
        com.qq.e.comm.plugin.apkmanager.k.e().a(this.f44853e.v1(), this);
        com.qq.e.comm.plugin.util.v2.b bVar = new com.qq.e.comm.plugin.util.v2.b(this.f44853e, this);
        this.K = bVar;
        if (bVar.e()) {
            this.E = com.qq.e.comm.plugin.p0.e.a().c(this.f44853e.L0(), this.f44853e.o().f42000e);
        } else {
            this.E = com.qq.e.comm.plugin.p0.e.a().a(this.f44853e.L0());
        }
        if (TextUtils.isEmpty(this.E)) {
            this.K.h();
        }
        if (A() && f4.a("nativeUnifiedPreloadVideo", 1) == 1) {
            preloadVideo();
        }
        x();
        this.f44850c0 = com.qq.e.comm.plugin.d0.a.d().f().a("ecvcr", this.f44847a0, 0);
        this.f44868l0 = f4.a("dptvd", this.f44847a0, 5000);
        this.f44876p0 = com.qq.e.comm.plugin.t.c.a("nuaac", this.f44847a0, 0, (b0) null) == 1;
        this.f44878q0 = com.qq.e.comm.plugin.t.c.a("nuoac", this.f44847a0, 0, (b0) null) == 1;
        if (i02 != null && (i02.o() == 1 || i02.o() == 2)) {
            z3 = true;
        }
        this.f44880r0 = z3;
        this.f44882s0 = com.qq.e.comm.plugin.dl.l.a(this.f44853e);
    }

    private boolean B() {
        File c4 = b1.c(this.f44853e.L0());
        if (c4 == null || !c4.exists()) {
            return false;
        }
        this.f44867l = (int) (c4.length() >> 10);
        return true;
    }

    private boolean C() {
        int i4 = this.f44850c0;
        if (i4 <= 0) {
            return false;
        }
        return ((Boolean) o2.a(this.f44855f, i4).first).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean D() {
        return o2.b(this.f44851d, this.f44855f, c0.a(com.qq.e.comm.plugin.b.g.NATIVEUNIFIEDAD, this.f44847a0), this.A);
    }

    private void E() {
        MediaView mediaView;
        if (this.T || (mediaView = this.f44861i) == null) {
            return;
        }
        this.T = com.qq.e.comm.plugin.nativeadunified.n.a(this.P, mediaView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        j(true);
    }

    private void I() {
        if (this.T) {
            return;
        }
        E();
        a(this.V);
    }

    private void J() {
        com.qq.e.comm.plugin.nativeadunified.p.b bVar = this.f44863j;
        if (bVar != null) {
            bVar.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        com.qq.e.comm.plugin.r0.i iVar = new com.qq.e.comm.plugin.r0.i(this.f44851d, this.f44853e);
        iVar.a(new r());
        DialogStateCallback dialogStateCallback = (DialogStateCallback) com.qq.e.comm.plugin.h.a.b(this.f44853e.l0(), DialogStateCallback.class);
        iVar.a(new s(this, dialogStateCallback));
        dialogStateCallback.d().b(1);
        iVar.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        if (!this.f44862i0) {
            this.O.sendEmptyMessage(3);
        }
        if (this.f44857g) {
            return;
        }
        this.O.sendEmptyMessage(1);
    }

    private void M() {
        if (this.f44852d0 == null) {
            return;
        }
        this.f44872n0 = com.qq.e.comm.plugin.k0.c.b();
        this.f44852d0.a(new a());
        this.f44852d0.start();
    }

    private void O() {
        i();
        a(206, new Object[0]);
    }

    private void setVideoOption(VideoOption videoOption) {
        com.qq.e.comm.plugin.d0.d.h f4 = com.qq.e.comm.plugin.d0.a.d().f();
        if (f4 != null) {
            String c4 = f4.c("shouldMuteVideo");
            if (TextUtils.isEmpty(c4)) {
                b(videoOption);
            } else {
                this.f44881s = "1".equals(c4);
            }
            String c5 = f4.c("videoAutoPlayPolicy", n());
            if (!TextUtils.isEmpty(c5)) {
                try {
                    this.f44885u = Integer.parseInt(c5);
                } catch (Exception e4) {
                    d1.a(e4.getMessage());
                }
            } else {
                c(videoOption);
            }
        } else {
            b(videoOption);
            c(videoOption);
        }
        int i4 = this.f44885u;
        if (i4 < 0 || i4 > 2) {
            this.f44885u = com.qq.e.comm.plugin.util.c.a();
        }
        if (videoOption != null) {
            this.f44888x = videoOption.isEnableUserControl();
        }
    }

    private void setVolumeOn(boolean z3) {
        com.qq.e.comm.plugin.nativeadunified.p.b bVar;
        if (this.f44861i == null || (bVar = this.f44863j) == null) {
            return;
        }
        if (z3) {
            bVar.c();
        } else {
            bVar.a();
        }
    }

    private void x() {
        if (com.qq.e.comm.plugin.d0.a.d().f().a("nusupsak", n(), 0) == 0) {
            return;
        }
        this.f44854e0 = com.qq.e.comm.plugin.k0.c.a(n());
        this.f44852d0 = new com.qq.e.comm.plugin.k0.e.b(com.qq.e.comm.plugin.k0.c.e(this.f44853e), com.qq.e.comm.plugin.k0.c.d(this.f44853e));
    }

    private boolean y() {
        return this.f44885u == 1 || com.qq.e.comm.plugin.d0.e.d.WIFI == com.qq.e.comm.plugin.d0.a.d().c().n();
    }

    private boolean z() {
        com.qq.e.comm.plugin.nativeadunified.g gVar = this.f44853e;
        if (gVar == null || TextUtils.isEmpty(gVar.y())) {
            return false;
        }
        int a4 = com.qq.e.comm.plugin.d0.a.d().f().a("nalca", this.f44847a0, 0);
        if (a4 > 10000) {
            a4 = com.qq.e.comm.plugin.t.a.b().a(this.f44853e.p0(), String.valueOf(a4), 0);
        }
        return a4 == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean A() {
        return this.f44853e.l1();
    }

    public void F() {
        File c4 = b1.c(this.f44853e.L0());
        String absolutePath = c4 != null ? c4.getAbsolutePath() : null;
        if (absolutePath == null && TextUtils.isEmpty(this.E)) {
            GDTLogger.e("\u64ad\u653e\u89c6\u9891\u5931\u8d25\uff0c\u89c6\u9891\u64ad\u653e\u6587\u4ef6\u4e0d\u5b58\u5728");
            return;
        }
        a(com.qq.e.comm.plugin.nativeadunified.c.PLAYING);
        if (this.f44863j != null) {
            this.O.post(new g());
            if (TextUtils.isEmpty(this.f44863j.f()) || !this.J) {
                if (TextUtils.isEmpty(absolutePath)) {
                    this.f44863j.a(this.E);
                } else {
                    this.K.h();
                    this.f44863j.a(absolutePath);
                }
            }
            if (this.Q == 0) {
                this.Q = System.currentTimeMillis();
            }
            this.f44863j.play();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String G() {
        return a(-999, 0);
    }

    protected void N() {
        com.qq.e.comm.plugin.nativeadunified.p.b bVar;
        boolean z3 = false;
        d1.a("Container has detach from window", new Object[0]);
        this.O.removeMessages(1);
        this.O.removeMessages(3);
        this.f44862i0 = false;
        if (!this.B ? !(this.f44863j == null || this.f44865k != com.qq.e.comm.plugin.nativeadunified.c.PLAYING) : !((bVar = this.f44863j) == null || !bVar.isPlaying())) {
            z3 = true;
        }
        if (z3) {
            this.f44863j.pause();
            a(com.qq.e.comm.plugin.nativeadunified.c.AUTO_PAUSE);
        }
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.a.d
    public void a(boolean z3) {
    }

    @Override // com.qq.e.comm.plugin.o0.h.b.a
    public void b() {
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToCustomVideo(ViewGroup viewGroup, Context context, List<View> list, List<View> list2) {
        if (!this.f44856f0) {
            com.qq.e.comm.plugin.nativeadunified.n.a(this.P, 9004, "");
        } else if (a(context, viewGroup)) {
        } else {
            this.f44853e.c(0);
            this.P.b(0);
            this.f44851d = context;
            this.S = new com.qq.e.comm.plugin.nativeadunified.e(this, this.f44853e, context, this.P);
            a(viewGroup);
            a(list, list2, true);
            com.qq.e.comm.plugin.e.a.a().a(this.f44855f, this.f44853e);
            M();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list) {
        bindAdToView(context, nativeAdContainer, layoutParams, list, null);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindCTAViews(List<View> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            View view = list.get(i4);
            if (view != null) {
                view.setOnClickListener(new com.qq.e.comm.plugin.nativeadunified.d(this, this.f44853e));
                if (this.f44856f0) {
                    view.setOnTouchListener(new com.qq.e.comm.plugin.nativeadunified.m(this.f44855f));
                }
            }
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindImageViews(List<ImageView> list, byte[] bArr) {
        v.a(1060025, this.P);
        if (list != null && !list.isEmpty()) {
            this.V = list;
            a(list, com.qq.e.comm.plugin.util.t.a(bArr));
            return;
        }
        GDTLogger.e("\u4f20\u5165\u7684ImageView\u5217\u8868\u4e3a\u7a7a");
        v.a(1060024, this.P);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindMediaView(MediaView mediaView, VideoOption videoOption, NativeADMediaListener nativeADMediaListener) {
        boolean z3 = this.f44890z;
        this.f44890z = false;
        if (this.f44879r && this.D == com.qq.e.comm.plugin.nativeadunified.o.f44988d) {
            l();
        }
        d1.a("NativeUnifiedADController bindMediaView", new Object[0]);
        if (mediaView == null) {
            GDTLogger.e("bindMediaView\u53d1\u751f\u9519\u8bef\uff0cMediaView\u4e3a\u7a7a");
            com.qq.e.comm.plugin.nativeadunified.n.a(this.P, 4001, "mediaView == null");
        } else if (mediaView.getVisibility() != 0) {
            GDTLogger.e("bindMediaView\u53d1\u751f\u9519\u8bef\uff0cMediaView\u4e0d\u53ef\u89c1");
            com.qq.e.comm.plugin.nativeadunified.n.a(this.P, 4001, "mediaView inVisible");
        } else if (Build.VERSION.SDK_INT < 16) {
            GDTLogger.e("bindMediaView\u53d1\u751f\u9519\u8bef\uff0c\u4e0d\u652f\u63014.1\u4ee5\u4e0b\u624b\u673a");
            com.qq.e.comm.plugin.n0.c cVar = this.P;
            com.qq.e.comm.plugin.nativeadunified.n.a(cVar, 4001, "sdk version = " + Build.VERSION.SDK_INT);
        } else if (getAdPatternType() != 2) {
            GDTLogger.e("bindMediaView\u53d1\u751f\u9519\u8bef\uff0c\u8be5\u5e7f\u544a\u4e0d\u662f\u89c6\u9891\u5e7f\u544a");
            com.qq.e.comm.plugin.nativeadunified.n.a(this.P, 4001, "no video");
        } else if (!a(this.f44855f, mediaView)) {
            GDTLogger.e("bindMediaView\u53d1\u751f\u9519\u8bef\uff0cMediaView\u672a\u5728container\u4e2d");
            com.qq.e.comm.plugin.nativeadunified.n.a(this.P, 4001, "MediaView is not in container");
        } else if (this.f44889y) {
            GDTLogger.e("bindMediaView\u53d1\u751f\u9519\u8bef\uff0c\u5f53\u524d\u5bf9\u8c61\u5df2\u9500\u6bc1");
            com.qq.e.comm.plugin.nativeadunified.n.a(this.P, 9003, "");
        } else if (r()) {
            GDTLogger.e("bindMediaView\u53d1\u751f\u9519\u8bef\uff0c\u5e7f\u544a\u5df2\u8fc7\u671f");
            com.qq.e.comm.plugin.nativeadunified.n.a(this.P, 5012, "");
        } else {
            if (!z3) {
                com.qq.e.comm.plugin.nativeadunified.n.h(this.P);
                com.qq.e.comm.plugin.nativeadunified.n.a(this.P, nativeADMediaListener != null);
            }
            this.f44890z = true;
            this.f44861i = mediaView;
            setVideoOption(videoOption);
            a(videoOption);
            setVolumeOn(this.f44881s);
            if (!B()) {
                this.D = com.qq.e.comm.plugin.nativeadunified.o.f44987c;
            } else {
                this.D = com.qq.e.comm.plugin.nativeadunified.o.f44990f;
            }
            if (y() && !this.C) {
                i(false);
            }
            if (this.C) {
                k();
            }
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void destroy() {
        ViewParent parent;
        this.f44889y = true;
        com.qq.e.comm.plugin.k0.e.b bVar = this.f44852d0;
        if (bVar != null) {
            bVar.stop();
        }
        this.O.removeCallbacksAndMessages(null);
        if (this.f44853e != null) {
            com.qq.e.comm.plugin.fs.e.c.a().a(this.f44853e.y());
        }
        if (this.f44884t0.size() > 0) {
            for (com.qq.e.comm.plugin.nativeadunified.l lVar : this.f44884t0) {
                lVar.a();
            }
            this.f44884t0.clear();
        }
        com.qq.e.comm.plugin.util.v2.b bVar2 = this.K;
        com.qq.e.comm.plugin.nativeadunified.p.b bVar3 = this.f44863j;
        bVar2.a(bVar3 == null ? null : bVar3.b());
        com.qq.e.comm.plugin.nativeadunified.p.b bVar4 = this.f44863j;
        if (bVar4 != null) {
            bVar4.destroy();
            this.f44863j = null;
        }
        MediaView mediaView = this.f44861i;
        if (mediaView != null) {
            mediaView.removeAllViews();
            this.f44861i = null;
        }
        ImageView imageView = this.M;
        if (imageView != null && (parent = imageView.getParent()) != null) {
            ((ViewGroup) parent).removeView(imageView);
        }
        this.f44851d = null;
        com.qq.e.comm.plugin.e.a.a().b(this.f44855f);
        if (this.W > 0) {
            com.qq.e.comm.plugin.nativeadunified.n.c(this.P, System.currentTimeMillis() - this.W);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean equalsAdData(NativeUnifiedADData nativeUnifiedADData) {
        if (nativeUnifiedADData != null && (nativeUnifiedADData instanceof NativeUnifiedADDataAdapter)) {
            NativeUnifiedADData adData = ((NativeUnifiedADDataAdapter) nativeUnifiedADData).getAdData();
            if (adData instanceof f) {
                f fVar = (f) adData;
                if (q() == null) {
                    return fVar.q() == null;
                }
                return q().equals(fVar.q());
            }
            return false;
        }
        return false;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAdPatternType() {
        if (this.C) {
            return 2;
        }
        return this.f44853e.o1();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        com.qq.e.comm.plugin.nativeadunified.g gVar = this.f44853e;
        if (gVar != null) {
            return gVar.r();
        }
        return null;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public NativeUnifiedADAppMiitInfo getAppMiitInfo() {
        com.qq.e.comm.plugin.g0.b q3;
        com.qq.e.comm.plugin.nativeadunified.n.d(this.P);
        com.qq.e.comm.plugin.nativeadunified.g gVar = this.f44853e;
        if (gVar == null || (q3 = gVar.q()) == null) {
            return null;
        }
        return new com.qq.e.comm.plugin.nativeadunified.a().a(q3);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public double getAppPrice() {
        return this.f44853e.p1();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppScore() {
        return this.f44853e.q1();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppStatus() {
        return this.f44853e.r1();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getButtonText() {
        v.a(1060026, this.P);
        if (this.f44853e.X0()) {
            int r12 = this.f44853e.r1();
            if (r12 != 1) {
                if (r12 != 4) {
                    if (r12 == 8) {
                        return this.f44853e.s().a();
                    }
                    if (r12 == 32) {
                        return this.f44853e.s().b();
                    }
                    if (r12 != 128) {
                        return this.f44853e.B();
                    }
                }
                return this.f44853e.s().c() + " " + this.f44859h + "%";
            }
            return this.f44853e.s().e();
        }
        return this.f44853e.B();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getCTAText() {
        return this.f44853e.s1();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public CustomizeVideo getCustomizeVideo() {
        if (this.f44856f0) {
            return new c();
        }
        return null;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getDesc() {
        return this.f44853e.F();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public long getDownloadCount() {
        return this.f44853e.t1();
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        return this.f44853e.J();
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        if (TextUtils.isEmpty(this.N)) {
            return this.f44853e.W0();
        }
        return this.N;
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        return this.f44853e.R();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getIconUrl() {
        return com.qq.e.comm.plugin.util.g.e().d(this.f44853e.Y());
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public List<String> getImgList() {
        return this.f44853e.u1();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getImgUrl() {
        return com.qq.e.comm.plugin.util.g.e().d(this.f44853e.X());
    }

    @Override // com.qq.e.comm.plugin.e0.b
    public int getMediationPrice() {
        return this.f44853e.h0();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureHeight() {
        return this.f44853e.n0();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureWidth() {
        return this.f44853e.o0();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getProgress() {
        return this.f44859h;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getTitle() {
        return this.f44853e.J0();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoCurrentPosition() {
        com.qq.e.comm.plugin.nativeadunified.p.b bVar = this.f44863j;
        if (bVar != null) {
            return bVar.getCurrentPosition();
        }
        GDTLogger.e("getVideoCurrentPosition\u8c03\u7528\u5931\u8d25\uff0c\u8bf7\u786e\u5b9a\u662f\u5426\u662f\u89c6\u9891\u5e7f\u544a");
        return -1;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoDuration() {
        if (this.C) {
            return this.f44868l0;
        }
        return this.f44853e.M0() * 1000;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isAppAd() {
        return this.f44853e.X0();
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        return !r();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isWeChatCanvasAd() {
        return this.f44853e.m1();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void negativeFeedback() {
        if (TextUtils.isEmpty(this.f44853e.j0())) {
            return;
        }
        a1.a(this.f44853e.j0());
    }

    @Override // com.qq.e.comm.plugin.o0.h.b.a
    public void onVideoComplete() {
        d1.a("onVideoComplete", new Object[0]);
        O();
        this.f44877q = 3;
        a(com.qq.e.comm.plugin.nativeadunified.c.END);
        J();
    }

    @Override // com.qq.e.comm.plugin.o0.h.b.a
    public void onVideoPause() {
        d1.a("onVideoPause", new Object[0]);
        a(204, new Object[0]);
        if (!this.R) {
            i();
        }
        this.R = false;
    }

    @Override // com.qq.e.comm.plugin.o0.h.b.a
    public void onVideoReady() {
        com.qq.e.comm.plugin.nativeadunified.p.b bVar;
        d1.a("onVideoReady", new Object[0]);
        this.f44871n = 0;
        if (this.f44861i != null && (bVar = this.f44863j) != null) {
            this.f44869m = bVar.getDuration();
            d1.a("duration = " + this.f44869m, new Object[0]);
        }
        a(210, Integer.valueOf(this.f44869m));
    }

    @Override // com.qq.e.comm.plugin.o0.h.b.a
    public void onVideoResume() {
        d1.a("onVideoResume", new Object[0]);
        this.f44877q = 2;
        a(203, new Object[0]);
        this.O.sendEmptyMessage(8);
    }

    @Override // com.qq.e.comm.plugin.o0.h.b.a
    public void onVideoStart() {
        d1.a("onVideoStart", new Object[0]);
        E();
        if (!this.f44857g) {
            j();
        }
        this.J = true;
        a(202, new Object[0]);
        if (this.Q > 0) {
            l2.b(System.currentTimeMillis() - this.Q, (int) this.f44867l, this.f44853e.L0(), this.P);
            com.qq.e.comm.plugin.nativeadunified.n.a(true, this.P, 0);
            this.Q = -1L;
        }
        L();
        this.O.sendEmptyMessage(8);
        if (!TextUtils.isEmpty(this.E)) {
            com.qq.e.comm.plugin.nativeadunified.n.a(this.P, this.I, this.H, this.G);
        }
        if (this.W > 0 && !this.Y) {
            com.qq.e.comm.plugin.nativeadunified.n.d(this.P, System.currentTimeMillis() - this.W);
            this.Y = true;
        }
        com.qq.e.comm.plugin.nativeadunified.p.b bVar = this.f44863j;
        if (bVar != null) {
            bVar.d();
            this.f44863j.j();
        }
        this.K.g();
    }

    @Override // com.qq.e.comm.plugin.o0.h.b.a
    public void onVideoStop() {
        d1.a("onVideoStop", new Object[0]);
        i();
        a(205, new Object[0]);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void pauseAppDownload() {
        ApkDownloadTask c4;
        if (isAppAd() && com.qq.e.comm.plugin.apkmanager.w.d.e(getAppStatus()) && (c4 = com.qq.e.comm.plugin.apkmanager.k.e().c(o().q().e())) != null) {
            com.qq.e.comm.plugin.n0.w.b.b(4001004, c4, 1, 103);
            com.qq.e.comm.plugin.apkmanager.k.e().a(c4);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void pauseVideo() {
        e(true);
    }

    public void preloadVideo(VideoPreloadListener videoPreloadListener) {
        if (A()) {
            b(212, new Object[0]);
        } else {
            GDTLogger.e("preloadVideo\u8c03\u7528\u5931\u8d25\uff0c\u8bf7\u786e\u5b9a\u662f\u5426\u662f\u89c6\u9891\u5e7f\u544a");
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resume() {
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resumeAppDownload() {
        if (isAppAd() && com.qq.e.comm.plugin.apkmanager.w.d.b(getAppStatus())) {
            String e4 = o().q().e();
            ApkDownloadTask c4 = com.qq.e.comm.plugin.apkmanager.k.e().c(e4);
            if (c4 != null) {
                c4.a(o());
                com.qq.e.comm.plugin.apkmanager.x.f a4 = com.qq.e.comm.plugin.n0.w.b.a(e4);
                a4.f44821a = false;
                a4.f44822b = 2;
                com.qq.e.comm.plugin.n0.w.b.b(4001005, c4, 1, 103);
            }
            com.qq.e.comm.plugin.apkmanager.k.e().b(c4);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resumeVideo() {
        g(true);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i4, int i5, String str) {
        com.qq.e.comm.plugin.util.r.b(i4, i5, str, this.f44847a0, this.f44853e, this.P, this);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i4) {
        com.qq.e.comm.plugin.util.r.a(i4, this.f44853e, this.f44847a0, this.P, this);
    }

    @Override // com.qq.e.comm.adevent.ADEventListener
    public void setAdListener(ADListener aDListener) {
        this.f44846L = aDListener;
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i4) {
        try {
            this.Z = com.qq.e.comm.plugin.util.r.a(i4);
        } catch (o1.d unused) {
            d1.a("pack price error");
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        com.qq.e.comm.plugin.nativeadunified.g gVar = this.f44853e;
        if (gVar != null && downloadConfirmListener != null) {
            String e02 = gVar.e0();
            d1.a("setDownloadConfirmListener native trace id:" + e02 + " listener:" + downloadConfirmListener, new Object[0]);
            com.qq.e.comm.plugin.b.j.b().a(e02, downloadConfirmListener);
            return;
        }
        GDTLogger.e("setDownloadConfirmListener\u9519\u8bef\u5e7f\u544a\u6570\u636e\u6216listener\u4e3a\u7a7a");
    }

    @Override // com.qq.e.comm.plugin.e0.b
    public void setMediationId(String str) {
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void setNativeAdEventListener(NativeADEventListener nativeADEventListener) {
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void setVideoMute(boolean z3) {
        if (this.f44863j != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(z3 ? CampaignEx.JSON_NATIVE_VIDEO_MUTE : "sound");
            sb.append(" by developer");
            d1.a(sb.toString(), new Object[0]);
            setVolumeOn(z3);
            this.f44881s = z3;
        } else {
            GDTLogger.e("setVideoMute\u8c03\u7528\u5931\u8d25\uff0c\u8bf7\u786e\u5b9a\u662f\u5426\u662f\u89c6\u9891\u5e7f\u544a");
        }
        this.f44883t = true;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void startVideo() {
        g(true);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void stopVideo() {
        com.qq.e.comm.plugin.nativeadunified.c cVar;
        com.qq.e.comm.plugin.nativeadunified.p.b bVar = this.f44863j;
        if (bVar != null && (bVar.isPlaying() || (cVar = this.f44865k) == com.qq.e.comm.plugin.nativeadunified.c.DEV_PAUSE || cVar == com.qq.e.comm.plugin.nativeadunified.c.MANUAL_PAUSE)) {
            this.f44863j.stop();
            this.O.postDelayed(new i(), 100L);
            a(com.qq.e.comm.plugin.nativeadunified.c.DEV_STOP);
            return;
        }
        GDTLogger.e("stopVideo\u8c03\u7528\u5931\u8d25\uff0c\u8bf7\u786e\u5b9a\u662f\u5426\u662f\u89c6\u9891\u5e7f\u544a");
    }

    private void i(boolean z3) {
        if (B()) {
            d1.a("video exists!", new Object[0]);
            if (z3) {
                b(212, new Object[0]);
                StringBuilder sb = new StringBuilder();
                sb.append("preloadVideo, video already cached, cl : ");
                com.qq.e.comm.plugin.nativeadunified.g gVar = this.f44853e;
                sb.append(gVar == null ? "" : gVar.k());
                d1.a(sb.toString(), new Object[0]);
                return;
            }
            this.D = com.qq.e.comm.plugin.nativeadunified.o.f44990f;
            this.O.post(new d());
        } else if (this.D == com.qq.e.comm.plugin.nativeadunified.o.f44987c) {
            if (!z3) {
                c();
                com.qq.e.comm.plugin.nativeadunified.p.b bVar = this.f44863j;
                if (bVar != null) {
                    bVar.g();
                }
            } else {
                d1.a("preloadVideo, cl : " + this.f44853e.k(), new Object[0]);
            }
            h(z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z3) {
        if (this.f44889y) {
            d1.a("native unified ad has destroyed", new Object[0]);
        } else if (!h()) {
            com.qq.e.comm.plugin.nativeadunified.p.b bVar = this.f44863j;
            if (bVar != null && z3) {
                bVar.h();
            }
            d1.a("can't play now, auto = " + this.f44885u + ", curr = " + com.qq.e.comm.plugin.d0.a.d().c().n().b());
        } else if (this.f44871n == 0) {
            d1.a("readyToPlayOnUIThread, but already play", new Object[0]);
        } else {
            com.qq.e.comm.plugin.nativeadunified.c cVar = this.f44865k;
            if (cVar != com.qq.e.comm.plugin.nativeadunified.c.END && cVar != com.qq.e.comm.plugin.nativeadunified.c.MANUAL_PAUSE && cVar != com.qq.e.comm.plugin.nativeadunified.c.DEV_PAUSE && cVar != com.qq.e.comm.plugin.nativeadunified.c.DEV_STOP) {
                a(com.qq.e.comm.plugin.nativeadunified.c.AUTO_PAUSE);
            }
            k();
            if (D()) {
                this.f44871n = 0;
                F();
                return;
            }
            L();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.f44860h0) {
            return;
        }
        this.f44860h0 = true;
        a(211, new Object[0]);
    }

    private ImageView p() {
        for (int i4 = 0; i4 < this.f44855f.getChildCount(); i4++) {
            View childAt = this.f44855f.getChildAt(i4);
            if (childAt instanceof com.qq.e.comm.plugin.r0.j) {
                return (com.qq.e.comm.plugin.r0.j) childAt;
            }
        }
        return null;
    }

    private String q() {
        return this.f44853e.k();
    }

    private boolean r() {
        return com.qq.e.comm.plugin.util.c.a(this.f44848b0);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        if (a(context, nativeAdContainer)) {
            return;
        }
        this.f44851d = context;
        this.S = new com.qq.e.comm.plugin.nativeadunified.e(this, this.f44853e, context, this.P);
        a(nativeAdContainer);
        a(layoutParams);
        a(list, list2, false);
        com.qq.e.comm.plugin.e.a.a().a(this.f44855f, this.f44853e);
        M();
    }

    public void h(boolean z3) {
        double d4;
        double H = this.f44853e.H();
        if (!TextUtils.isEmpty(this.E)) {
            if (z3) {
                if (com.qq.e.comm.plugin.util.v2.a.a(H)) {
                    return;
                }
                d1.a("NativeUnifiedAdController", "CDN switch on download whole video");
                this.K.h();
            } else {
                d4 = this.K.b();
                a(z3, d4);
            }
        }
        d4 = 1.0d;
        a(z3, d4);
    }

    void k() {
        if (this.f44858g0) {
            return;
        }
        this.f44858g0 = true;
        Object[] objArr = new Object[1];
        com.qq.e.comm.plugin.nativeadunified.p.b bVar = this.f44863j;
        objArr[0] = Integer.valueOf(bVar == null ? -1 : bVar.getDuration());
        a(201, objArr);
    }

    String n() {
        return this.f44849c.e();
    }

    public com.qq.e.comm.plugin.nativeadunified.g o() {
        return this.f44853e;
    }

    int s() {
        com.qq.e.comm.plugin.nativeadunified.p.b bVar = this.f44863j;
        if (bVar != null) {
            return bVar.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(Map<String, Object> map) {
        com.qq.e.comm.plugin.util.r.a(map, this.f44847a0, this.f44853e, this.P, this);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        com.qq.e.comm.plugin.util.r.a(map, this.f44853e, this.f44847a0, this.P, this);
    }

    public String t() {
        return this.f44853e.S();
    }

    public String u() {
        return this.f44853e.U0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int v() {
        return this.f44853e.r0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w() {
        this.f44886v = true;
        if (!B()) {
            i(false);
            return;
        }
        com.qq.e.comm.plugin.nativeadunified.p.b bVar = this.f44863j;
        if (bVar != null) {
            if (bVar.isPlaying()) {
                e(false);
            } else {
                g(false);
            }
            a(208, new Object[0]);
            return;
        }
        GDTLogger.e("VideoView\u672a\u521d\u59cb\u5316\u5b8c\u6210\uff0c\u65e0\u6cd5\u64ad\u653e\u6216\u6682\u505c");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class e implements com.qq.e.comm.plugin.p.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f44898a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f44899b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f44900c;

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.j(false);
            }
        }

        e(long j4, boolean z3, String str) {
            this.f44898a = j4;
            this.f44899b = z3;
            this.f44900c = str;
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a() {
            d1.a("onStarted", new Object[0]);
            f.this.D = com.qq.e.comm.plugin.nativeadunified.o.f44988d;
            f.this.l();
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void b() {
            d1.a("onCanceled", new Object[0]);
            f.this.D = com.qq.e.comm.plugin.nativeadunified.o.f44991g;
            f.this.O.sendEmptyMessage(5);
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(long j4, boolean z3) {
            f.this.f44867l = j4 >> 10;
            f fVar = f.this;
            if (fVar.f44890z && !TextUtils.isEmpty(fVar.E)) {
                f.this.O.post(new a());
            }
            f.this.F.set(true);
            d1.a("onConnected isRangeSupport: " + z3 + ", total: " + j4, new Object[0]);
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(long j4, long j5, int i4) {
            d1.a("downloading[" + f.this.getTitle() + "] video ---> Progress: " + i4 + "%", new Object[0]);
            Message obtain = Message.obtain();
            obtain.what = 4;
            obtain.arg1 = i4;
            f.this.O.sendMessage(obtain);
            f.this.G = j5;
            f.this.H = j4;
            f.this.I = i4;
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(File file, long j4) {
            f.this.X = System.currentTimeMillis();
            d1.a("onCompleted", new Object[0]);
            long currentTimeMillis = System.currentTimeMillis() - this.f44898a;
            d1.a("download time: " + currentTimeMillis + "ms", new Object[0]);
            d1.a("download speed: " + (f.this.f44867l / currentTimeMillis) + "kb/s", new Object[0]);
            if (f.this.f44889y) {
                d1.a("download complete after destroyed", new Object[0]);
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 6;
            obtain.obj = Boolean.valueOf(this.f44899b);
            f.this.O.sendMessage(obtain);
            l2.a(j4, (int) f.this.f44867l, this.f44900c, f.this.P);
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(boolean z3) {
            d1.a("onPaused " + z3, new Object[0]);
            f.this.D = com.qq.e.comm.plugin.nativeadunified.o.f44989e;
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(com.qq.e.comm.plugin.p.d dVar) {
            GDTLogger.e("\u89c6\u9891\u4e0b\u8f7d\u5931\u8d25, code: " + dVar.a() + ", msg: " + dVar.b());
            Message obtain = Message.obtain();
            obtain.what = 7;
            obtain.obj = Boolean.valueOf(this.f44899b);
            f.this.O.sendMessage(obtain);
            f.this.O.sendEmptyMessage(5);
        }
    }

    private void e(boolean z3) {
        com.qq.e.comm.plugin.nativeadunified.p.b bVar = this.f44863j;
        if (bVar == null) {
            GDTLogger.e("pauseVideo\u8c03\u7528\u5931\u8d25\uff0c\u8bf7\u786e\u5b9a\u662f\u5426\u662f\u89c6\u9891\u5e7f\u544a");
        } else if (!bVar.isPlaying()) {
            GDTLogger.i("\u89c6\u9891\u4e0d\u5728\u64ad\u653e\uff0c\u91cd\u590d\u8c03\u7528\u6682\u505c");
        } else {
            d1.a("pauseVideo by developer", new Object[0]);
            this.f44863j.pause();
            this.f44863j.a(false);
            a(com.qq.e.comm.plugin.nativeadunified.c.DEV_PAUSE);
        }
    }

    private void g(boolean z3) {
        if (this.f44863j != null && D()) {
            if (this.f44863j.isPlaying()) {
                GDTLogger.i("\u89c6\u9891\u6b63\u5728\u64ad\u653e\uff0c\u91cd\u590d\u8c03\u7528\u64ad\u653e");
                return;
            }
            if (z3) {
                this.f44887w = true;
                if (!B() && (TextUtils.isEmpty(this.E) || !this.F.get())) {
                    i(false);
                    return;
                }
            }
            d1.a("startVideo by developer", new Object[0]);
            this.f44873o = 0;
            F();
            return;
        }
        GDTLogger.e("startVideo\u8c03\u7528\u5931\u8d25\uff0c\u8bf7\u786e\u5b9a\u662f\u5426\u662f\u89c6\u9891\u5e7f\u544a\u5e76\u4e14\u89c6\u9891\u5bb9\u5668\u53ef\u89c1");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(boolean z3) {
        if (this.f44861i == null) {
            d1.a("\u672a\u7ed1\u5b9aMediaView\u7ec4\u4ef6\uff0c\u4e0d\u4e0a\u62a5\u89c6\u9891\u64ad\u653e\u6548\u679c\uff01", new Object[0]);
            return;
        }
        com.qq.e.comm.plugin.l0.c.a(this.f44873o, this.f44875p, this.f44877q, z3 ? 3 : this.f44871n, this.f44871n == 0 ? s() : 0, this.f44871n == 0 ? this.f44869m : 0, this.f44853e, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b extends com.qq.e.comm.plugin.o0.h.d {
        b(com.qq.e.comm.plugin.g0.e eVar, boolean z3) {
            super(eVar, z3);
        }

        @Override // com.qq.e.comm.plugin.o0.h.d, com.qq.e.comm.plugin.o0.h.f.p
        public void a(int i4, int i5) {
            super.a(i4, i5);
            f.this.K.a(i4, i5, f.this.I);
        }

        @Override // com.qq.e.comm.plugin.o0.h.d, com.qq.e.comm.plugin.o0.h.f.p
        public boolean a(int i4, f.t tVar, float f4) {
            super.a(i4, tVar, f4);
            f.this.K.a(i4, tVar);
            return true;
        }
    }

    private void c(VideoOption videoOption) {
        if (videoOption != null) {
            this.f44885u = videoOption.getAutoPlayPolicy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z3) {
        if (A()) {
            if (this.D == com.qq.e.comm.plugin.nativeadunified.o.f44990f || !TextUtils.isEmpty(this.E)) {
                int i4 = k.f44910a[this.f44865k.ordinal()];
                if (i4 == 1) {
                    if (z3) {
                        this.f44873o = 1;
                        F();
                    }
                } else if (i4 == 2 && !z3) {
                    a(com.qq.e.comm.plugin.nativeadunified.c.AUTO_PAUSE);
                    com.qq.e.comm.plugin.nativeadunified.p.b bVar = this.f44863j;
                    if (bVar != null) {
                        bVar.pause();
                    }
                }
            }
        }
    }

    private void b(VideoOption videoOption) {
        if (this.f44883t) {
            return;
        }
        if (videoOption != null) {
            this.f44881s = videoOption.getAutoPlayMuted();
        } else {
            this.f44881s = true;
        }
    }

    private void c() {
        com.qq.e.comm.plugin.nativeadunified.p.b bVar = this.f44863j;
        if (bVar == null) {
            return;
        }
        bVar.e();
    }

    private void preloadVideo() {
        if (A()) {
            this.f44879r = true;
            i(true);
            return;
        }
        GDTLogger.e("preloadVideo\u8c03\u7528\u89c6\u9891\uff0c\u8bf7\u786e\u8ba4\u662f\u5426\u662f\u89c6\u9891\u5e7f\u544a");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements com.qq.e.comm.plugin.k0.e.a {

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.nativeadunified.f$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class RunnableC0858a implements Runnable {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ float[] f44892c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ long f44893d;

            RunnableC0858a(float[] fArr, long j4) {
                this.f44892c = fArr;
                this.f44893d = j4;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = f.this;
                fVar.a(this.f44892c, this.f44893d - fVar.f44870m0);
            }
        }

        a() {
        }

        @Override // com.qq.e.comm.plugin.k0.e.a
        public void a() {
        }

        @Override // com.qq.e.comm.plugin.k0.e.a
        public void a(float f4) {
            if (f4 >= f.this.f44872n0) {
                if (f.this.f44874o0) {
                    return;
                }
                f.this.f44874o0 = true;
                f.this.f44870m0 = System.currentTimeMillis();
                d1.a("gdt_tag_sensor", "onShakeProgress mMotionStartTime = " + f.this.f44870m0);
                return;
            }
            f.this.f44874o0 = false;
        }

        @Override // com.qq.e.comm.plugin.k0.e.a
        public void a(float[] fArr) {
            long currentTimeMillis = System.currentTimeMillis();
            d1.a("gdt_tag_sensor", "onShakeComplete motionEndTime = " + currentTimeMillis);
            p0.d(new RunnableC0858a(fArr, currentTimeMillis));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(float[] fArr, long j4) {
        Object tag;
        com.qq.e.comm.plugin.k0.e.b bVar = this.f44852d0;
        if (bVar == null) {
            return false;
        }
        bVar.reset();
        if (this.S == null || (tag = this.f44855f.getTag(2131755009)) == null || !(tag instanceof Integer) || ((Integer) tag).intValue() != hashCode() || com.qq.e.comm.plugin.k0.c.a(this.f44854e0) || !D() || C()) {
            return false;
        }
        k2.a();
        com.qq.e.comm.plugin.e.i.a d4 = com.qq.e.comm.plugin.e.a.a().d(this.f44855f);
        if (d4 != null) {
            d4.a(fArr);
            d4.a(j4);
        }
        this.S.b();
        com.qq.e.comm.plugin.k0.c.d();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z3) {
        com.qq.e.comm.plugin.k0.e.b bVar = this.f44852d0;
        if (bVar == null) {
            return;
        }
        if (z3) {
            bVar.resume();
        } else if (bVar.pause()) {
            this.f44852d0.reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(boolean z3) {
        if (this.C && this.f44857g && this.f44864j0) {
            long j4 = this.f44866k0 + 200;
            this.f44866k0 = j4;
            int i4 = this.f44868l0;
            if (j4 >= i4 && j4 < i4 + 200) {
                a(206, new Object[0]);
            }
        }
        this.f44864j0 = z3;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindImageViews(List<ImageView> list, int i4) {
        v.a(1060025, this.P);
        if (list != null && !list.isEmpty()) {
            this.V = list;
            a(list, com.qq.e.comm.plugin.util.t.a(this.f44851d, i4));
            return;
        }
        GDTLogger.e("\u4f20\u5165\u7684ImageView\u5217\u8868\u4e3a\u7a7a");
        v.a(1060024, this.P);
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.a.d
    public void b(boolean z3) {
        d1.a("onPlayPauseButtonClicked mMediaStatus: " + this.f44865k, new Object[0]);
        if (!z3) {
            this.f44873o = 0;
        }
        a(z3 ? com.qq.e.comm.plugin.nativeadunified.c.MANUAL_PAUSE : com.qq.e.comm.plugin.nativeadunified.c.PLAYING);
        if (this.f44888x) {
            w();
        } else {
            this.S.c();
        }
    }

    private boolean h() {
        return (this.f44885u == 0 && com.qq.e.comm.plugin.d0.e.d.WIFI == com.qq.e.comm.plugin.d0.a.d().c().n()) || this.f44885u == 1 || this.f44886v || this.f44887w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i4, Object... objArr) {
        ADListener aDListener = this.f44846L;
        if (aDListener != null) {
            aDListener.onADEvent(new ADEvent(i4, objArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        return o2.b(this.f44851d, this.f44855f, c0.a(this.f44847a0), this.A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        f(false);
    }

    void j() {
        MediaView mediaView = this.f44861i;
        if (mediaView == null) {
            GDTLogger.e("\u672a\u7ed1\u5b9aMediaView\u7ec4\u4ef6\uff0c\u4e0d\u4e0a\u62a5\u5e7f\u544a\u66dd\u5149\uff01");
        } else if (!mediaView.getGlobalVisibleRect(new Rect())) {
            GDTLogger.e("MediaView\u4e0d\u53ef\u89c1\uff0c\u4e0d\u4e0a\u62a5\u5e7f\u544a\u66dd\u5149\uff01");
        } else {
            d1.a("on video ad exposed", new Object[0]);
            a((View) this.f44855f);
        }
    }

    @Override // com.qq.e.comm.plugin.apkmanager.w.a
    public void a(String str, int i4, int i5, long j4) {
        com.qq.e.comm.plugin.nativeadunified.g gVar = this.f44853e;
        if (gVar != null) {
            gVar.d(i4);
            if (this.f44853e.q() != null) {
                this.f44853e.q().c(i4);
                this.f44853e.q().a(i5);
            }
        }
        this.f44859h = i5;
        a(111, new Object[0]);
    }

    private boolean a(Context context, ViewGroup viewGroup) {
        if (this.S == null) {
            com.qq.e.comm.plugin.nativeadunified.n.g(this.P);
        }
        d1.a("NativeUnifiedADController bindAdToView", new Object[0]);
        com.qq.e.comm.plugin.util.u2.e.b().a(this.f44849c.e(), com.qq.e.comm.plugin.b.g.NATIVEUNIFIEDAD.d());
        if (viewGroup == null) {
            GDTLogger.e("bindAdToView\u53d1\u751f\u9519\u8bef\uff0cNativeAdContainer\u4e3a\u7a7a");
            if (this.S == null) {
                com.qq.e.comm.plugin.nativeadunified.n.a(this.P, 4001, "container == null");
            }
            return true;
        } else if (context == null) {
            GDTLogger.e("bindAdToView\u53d1\u751f\u9519\u8bef\uff0cContext\u4e3a\u7a7a");
            if (this.S == null) {
                com.qq.e.comm.plugin.nativeadunified.n.a(this.P, 4001, "context == null");
            }
            return true;
        } else if (this.f44889y) {
            GDTLogger.e("NativeUnifiedADData has been destroyed");
            if (this.S == null) {
                com.qq.e.comm.plugin.nativeadunified.n.a(this.P, 9003, "");
            }
            return true;
        } else if (r()) {
            GDTLogger.e("bindAdToView\u53d1\u751f\u9519\u8bef\uff0c\u5e7f\u544a\u5df2\u8fc7\u671f");
            com.qq.e.comm.plugin.nativeadunified.n.a(this.P, 5012, "");
            return true;
        } else {
            if (!A() && this.S == null) {
                com.qq.e.comm.plugin.nativeadunified.n.h(this.P);
            }
            return false;
        }
    }

    private void a(ViewGroup viewGroup) {
        this.f44855f = viewGroup;
        viewGroup.setTag(2131755009, Integer.valueOf(hashCode()));
        this.f44855f.addOnAttachStateChangeListener(new l());
        L();
    }

    private void a(List<ImageView> list, Bitmap bitmap) {
        StringBuilder sb;
        String str;
        int size = list.size();
        int adPatternType = getAdPatternType();
        if (adPatternType == 4 || adPatternType == 1) {
            if (size > 1) {
                v.b(1060022, this.P, Integer.valueOf(size));
                GDTLogger.e("\u53ea\u6709\u4e00\u5f20\u56fe\u7247\u4f46\u662f\u4f20\u5165\u4e86 " + size + "\u4e2aImageView\uff0c\u53ea\u6709\u7b2c\u4e00\u4e2aImageView\u4f1a\u5c55\u793a\u56fe\u7247");
            }
            com.qq.e.comm.plugin.b0.b.a().a(this.f44853e.X(), list.get(0), new m(list), bitmap);
        } else if (adPatternType == 3) {
            int size2 = this.f44853e.u1().size();
            int min = Math.min(size2, size);
            if (size2 != size) {
                v.b(1060023, this.P, Integer.valueOf(size));
                if (size2 > size) {
                    sb = new StringBuilder();
                    sb.append("\u53ea\u6709\u524d");
                    sb.append(min);
                    str = "\u4e2a\u56fe\u7247\u80fd\u6b63\u786e\u5c55\u793a";
                } else {
                    sb = new StringBuilder();
                    sb.append("\u53ea\u6709\u524d");
                    sb.append(min);
                    str = "\u4e2aImageView\u4f1a\u5c55\u793a\u56fe\u7247";
                }
                sb.append(str);
                String sb2 = sb.toString();
                GDTLogger.e("\u56fe\u7247\u4e2a\u6570\u4e0eImageView\u4e2a\u6570\u4e0d\u7b26\uff0c\u56fe\u7247\u4e2a\u6570\u4e3a " + size2 + "\uff0c\u800c\u4f20\u5165\u7684ImageView\u4e2a\u6570\u4e3a " + size + "\uff0c" + sb2);
            }
            AtomicInteger atomicInteger = new AtomicInteger(min);
            for (int i4 = 0; i4 < min; i4++) {
                com.qq.e.comm.plugin.b0.b.a().a(this.f44853e.u1().get(i4), list.get(i4), new n(atomicInteger, list), bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<ImageView> list) {
        if (this.T || !this.U || list == null || list.size() <= 0) {
            return;
        }
        p0.a((Runnable) new o(list));
    }

    private void a(List<View> list, List<View> list2, boolean z3) {
        boolean z4 = this.f44876p0;
        if (list != null && list.size() > 0) {
            for (View view : list) {
                a(view, new com.qq.e.comm.plugin.nativeadunified.e(this, this.f44853e, this.f44851d, this.P), z3);
                if (this.f44855f == view) {
                    z4 = false;
                }
            }
        }
        if (z4) {
            a(this.f44855f, new com.qq.e.comm.plugin.nativeadunified.e(this, this.f44853e, this.f44851d, this.P), z3);
        }
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        for (View view2 : list2) {
            a(view2, new com.qq.e.comm.plugin.nativeadunified.e(this, this.f44853e, this.f44851d, this.P, true), z3);
        }
    }

    private void a(View view, com.qq.e.comm.plugin.nativeadunified.e eVar, boolean z3) {
        if (view == null) {
            return;
        }
        view.setOnClickListener(eVar);
        if (z3) {
            view.setOnTouchListener(new com.qq.e.comm.plugin.nativeadunified.m(this.f44855f));
        } else if (this.f44880r0 || this.f44878q0) {
            com.qq.e.comm.plugin.nativeadunified.l lVar = new com.qq.e.comm.plugin.nativeadunified.l(this.f44853e, this.f44882s0);
            this.f44884t0.add(lVar);
            view.setOnTouchListener(lVar);
        }
    }

    private void a(NativeAdContainer nativeAdContainer) {
        ViewGroup viewGroup = this.f44855f;
        if (viewGroup instanceof NativeAdContainer) {
            ((NativeAdContainer) viewGroup).setViewStatusListener(null);
        }
        this.f44855f = nativeAdContainer;
        nativeAdContainer.setTag(2131755009, Integer.valueOf(hashCode()));
        nativeAdContainer.setViewStatusListener(new p());
    }

    private void a(FrameLayout.LayoutParams layoutParams) {
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(com.qq.e.comm.plugin.util.l.b(), com.qq.e.comm.plugin.util.l.a());
            layoutParams.gravity = 8388693;
            int a4 = f1.a(this.f44851d, 4);
            layoutParams.rightMargin = a4;
            layoutParams.bottomMargin = a4;
        }
        ImageView p3 = p();
        this.M = p3;
        if (p3 == null) {
            com.qq.e.comm.plugin.r0.j jVar = new com.qq.e.comm.plugin.r0.j(this.f44851d);
            this.M = jVar;
            this.f44855f.addView(jVar, layoutParams);
        } else {
            p3.setLayoutParams(layoutParams);
            this.M.bringToFront();
        }
        if (z()) {
            com.qq.e.comm.plugin.util.l.a(this.M, true);
            this.M.setOnClickListener(new q());
            return;
        }
        com.qq.e.comm.plugin.util.l.a(this.M, false);
        this.M.setOnClickListener(new com.qq.e.comm.plugin.nativeadunified.e(this, this.f44853e, this.f44851d, this.P));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(View view, View view2) {
        if (view2 != null && view != null) {
            if (view == view2) {
                return true;
            }
            for (ViewParent parent = view2.getParent(); parent != null; parent = parent.getParent()) {
                if (parent == view) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(VideoOption videoOption) {
        boolean z3 = this.f44863j == null;
        this.f44861i.removeAllViews();
        if (this.f44863j == null) {
            com.qq.e.comm.plugin.nativeadunified.l lVar = this.f44878q0 ? new com.qq.e.comm.plugin.nativeadunified.l(this.f44853e, this.f44882s0) : null;
            if (lVar != null) {
                this.f44884t0.add(lVar);
            }
            Context context = this.f44851d;
            com.qq.e.comm.plugin.nativeadunified.g gVar = this.f44853e;
            this.f44863j = com.qq.e.comm.plugin.nativeadunified.p.c.a(context, gVar, videoOption, this, new b(gVar, this.K.e()), new com.qq.e.comm.plugin.nativeadunified.e(this, this.f44853e, this.f44851d, this.P), lVar, this.f44861i);
        }
        this.f44863j.a(this.f44861i);
        if (z3) {
            a(com.qq.e.comm.plugin.nativeadunified.c.INIT);
            a(209, new Object[0]);
        }
    }

    @Override // com.qq.e.comm.plugin.util.v2.e
    public void a(com.qq.e.comm.plugin.util.v2.c cVar, double d4) {
        a(false, d4);
    }

    private void a(boolean z3, double d4) {
        d1.a("NativeUnifiedAdController", "downloadVideoWithRatio preload = %b, ratio = %.4f", Boolean.valueOf(z3), Double.valueOf(d4));
        File p3 = b1.p();
        if (p3 == null) {
            a(107, 5002);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String L0 = this.f44853e.L0();
        com.qq.e.comm.plugin.o0.g.a.a().a(new b.C0867b().a(d4).d(L0).a(b1.d(L0)).a(p3).d(TextUtils.isEmpty(this.E)).c(this.K.d()).a(this.P).a(), new e(currentTimeMillis, z3, L0));
        if (this.F.get() && this.f44890z && !TextUtils.isEmpty(this.E)) {
            this.O.post(new RunnableC0859f());
        }
    }

    void a(View view) {
        I();
        if (this.f44857g) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.W = currentTimeMillis;
        com.qq.e.comm.plugin.nativeadunified.n.a(this.P, currentTimeMillis - this.f44849c.f44948s);
        view.post(new h());
        a(103, new Object[0]);
        if (this.C) {
            a(202, new Object[0]);
        }
        this.f44857g = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(int i4, int i5) {
        com.qq.e.comm.plugin.e.a a4 = com.qq.e.comm.plugin.e.a.a();
        com.qq.e.comm.plugin.e.i.a d4 = a4.d(this.f44855f);
        if (d4 != null) {
            d4.a(i4);
            d4.d(i5);
        }
        return a4.a(this.f44855f);
    }

    public void a(com.qq.e.comm.plugin.nativeadunified.c cVar) {
        d1.a("NativeUnifiedADController setMediaStatus: " + this.f44865k + "-->" + cVar, new Object[0]);
        this.f44865k = cVar;
    }

    @Override // com.qq.e.comm.plugin.o0.h.b.a
    public void a(int i4, Exception exc) {
        d1.a("onVideoError", new Object[0]);
        this.f44871n = 2;
        a(207, 5003);
        i();
        com.qq.e.comm.plugin.nativeadunified.n.a(false, this.P, i4);
        if (!TextUtils.isEmpty(this.E)) {
            com.qq.e.comm.plugin.nativeadunified.n.b(this.P, this.I, this.H, this.G);
        }
        J();
        this.K.f();
    }

    public void a(String str) {
        this.N = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i4, Object... objArr) {
        this.O.post(new j(i4, objArr));
    }
}
