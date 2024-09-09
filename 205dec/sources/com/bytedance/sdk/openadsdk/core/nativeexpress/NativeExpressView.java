package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.app.Dialog;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.component.video.api.sr.xv;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.adexpress.w.p;
import com.bytedance.sdk.component.p.c.w;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.w.sr;
import com.bytedance.sdk.openadsdk.core.wx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.control.interaction.view.InteractionCommon;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class NativeExpressView extends FrameLayout implements com.bytedance.sdk.component.adexpress.dynamic.sr, com.bytedance.sdk.component.adexpress.theme.c, com.bytedance.sdk.component.adexpress.w.ev, com.bytedance.sdk.component.adexpress.w.ys, p {

    /* renamed from: s  reason: collision with root package name */
    public static int f34019s = 500;

    /* renamed from: a  reason: collision with root package name */
    protected xv.InterfaceC0335xv f34020a;
    private float au;

    /* renamed from: b  reason: collision with root package name */
    private long f34021b;
    private final Runnable ba;
    private float bj;
    protected FrameLayout bk;
    private float bm;
    private com.bytedance.sdk.openadsdk.core.ugeno.w.sr bw;

    /* renamed from: c  reason: collision with root package name */
    private boolean f34022c;
    private final ViewTreeObserver.OnScrollChangedListener ck;
    private ThemeStatusBroadcastReceiver eq;
    protected String ev;

    /* renamed from: f  reason: collision with root package name */
    private ux f34023f;
    protected com.bytedance.sdk.component.adexpress.w.xv fp;
    protected boolean fz;
    private com.bytedance.sdk.openadsdk.ux.c gb;
    protected com.bytedance.sdk.openadsdk.ys.w.xv.w gd;
    private com.bytedance.sdk.component.adexpress.w.sr<? extends View> gw;

    /* renamed from: i  reason: collision with root package name */
    private final AtomicBoolean f34024i;
    protected boolean ia;

    /* renamed from: j  reason: collision with root package name */
    private float f34025j;

    /* renamed from: k  reason: collision with root package name */
    protected xv.sr f34026k;
    private float ls;

    /* renamed from: m  reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.w.gd f34027m;
    private ls me;
    private SparseArray<sr.c> mt;

    /* renamed from: n  reason: collision with root package name */
    private boolean f34028n;
    private float oo;

    /* renamed from: p  reason: collision with root package name */
    protected me f34029p;
    private com.bytedance.sdk.component.adexpress.w.f pr;

    /* renamed from: q  reason: collision with root package name */
    private String f34030q;

    /* renamed from: r  reason: collision with root package name */
    protected final Context f34031r;
    private Dialog sr;

    /* renamed from: t  reason: collision with root package name */
    protected boolean f34032t;

    /* renamed from: u  reason: collision with root package name */
    private f f34033u;
    private ys up;
    private c ux;
    private com.bytedance.sdk.component.adexpress.w.bk vc;

    /* renamed from: w  reason: collision with root package name */
    private int f34034w;
    private p.c wv;
    private com.bytedance.sdk.component.adexpress.w.w wx;

    /* renamed from: x  reason: collision with root package name */
    private volatile com.bytedance.sdk.component.adexpress.w.t f34035x;
    private List<com.bytedance.sdk.component.adexpress.w.p> xk;
    private com.bytedance.sdk.openadsdk.core.dislike.ui.c xv;

    /* renamed from: y  reason: collision with root package name */
    private final Runnable f34036y;
    protected boolean ys;
    private com.bytedance.sdk.component.adexpress.w.fp yu;

    /* renamed from: z  reason: collision with root package name */
    private final Runnable f34037z;

    public NativeExpressView(Context context, me meVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, String str) {
        super(context);
        this.f34022c = true;
        this.f34034w = 0;
        this.ev = "embeded_ad";
        this.f34024i = new AtomicBoolean(false);
        this.f34030q = null;
        this.ys = false;
        this.ia = false;
        this.fz = false;
        this.f34028n = false;
        this.ck = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.f34037z);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.f34037z, 500L);
            }
        };
        this.f34037z = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.2
            @Override // java.lang.Runnable
            public void run() {
                if (wx.c(NativeExpressView.this, 0, 5)) {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.sr(nativeExpressView.getVisibility());
                    return;
                }
                NativeExpressView.this.sr(8);
            }
        };
        this.ba = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.3
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.sr(0);
            }
        };
        this.f34036y = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.4
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.sr(8);
            }
        };
        this.mt = new SparseArray<>();
        this.oo = -1.0f;
        this.au = -1.0f;
        this.bj = -1.0f;
        this.bm = -1.0f;
        this.f34021b = 0L;
        this.ev = str;
        this.f34031r = context;
        this.f34029p = meVar;
        this.gd = wVar;
        k();
    }

    private void ba() {
        this.f34034w = this.f34029p.ld();
        if (z() && this.f34029p.y() == 1) {
            this.f34034w = 1000;
        }
        com.bytedance.sdk.openadsdk.core.k.c.c cVar = new com.bytedance.sdk.openadsdk.core.k.c.c(this.f34029p, new WeakReference(this));
        int i4 = this.f34034w;
        if (i4 == 3) {
            com.bytedance.sdk.component.adexpress.w.w wVar = new com.bytedance.sdk.component.adexpress.w.w(this.f34031r, this.vc, this.eq, this.fz, new com.bytedance.sdk.component.adexpress.dynamic.sr.r(), this, cVar);
            this.wx = wVar;
            this.xk.add(wVar);
        } else if (i4 == 7) {
            com.bytedance.sdk.openadsdk.core.ugeno.w.xv xvVar = new com.bytedance.sdk.openadsdk.core.ugeno.w.xv(this.f34031r, this.f34029p, (com.bytedance.sdk.openadsdk.core.ugeno.w.c) this.vc, this);
            this.f34028n = xvVar.w();
            com.bytedance.sdk.openadsdk.core.ugeno.w.sr srVar = new com.bytedance.sdk.openadsdk.core.ugeno.w.sr(this.f34031r, xvVar, this, this.vc);
            this.bw = srVar;
            this.xk.add(srVar);
        } else if (i4 != 1000) {
            ls lsVar = new ls(this.f34031r, this.vc, this.eq, this.gb, this.f34029p, this.f34027m);
            this.me = lsVar;
            com.bytedance.sdk.component.adexpress.w.fp fpVar = new com.bytedance.sdk.component.adexpress.w.fp(this.f34031r, this.vc, lsVar, this);
            this.yu = fpVar;
            this.xk.add(fpVar);
        }
        int nb = this.f34029p.nb();
        if (nb >= 1 && ls() && TextUtils.equals(this.ev, "embeded_ad")) {
            this.xk.add(new com.bytedance.sdk.openadsdk.core.ugeno.w.sr(this.f34031r, new com.bytedance.sdk.openadsdk.core.ugeno.c.xv(this.f34031r, this.f34029p, (com.bytedance.sdk.openadsdk.core.ugeno.w.c) this.vc, this), this, this.vc));
        } else {
            boolean z3 = nb == 1;
            this.f34022c = z3;
            if (!z3 && this.f34034w != 1000) {
                if (com.bytedance.sdk.openadsdk.core.ugeno.c.c.w(this.f34029p)) {
                    this.xk.add(new com.bytedance.sdk.openadsdk.core.ugeno.w.sr(this.f34031r, new com.bytedance.sdk.openadsdk.core.ugeno.c.xv(this.f34031r, this.f34029p, (com.bytedance.sdk.openadsdk.core.ugeno.w.c) this.vc, this), this, this.vc));
                }
            } else {
                com.bytedance.sdk.component.adexpress.w.f fVar = new com.bytedance.sdk.component.adexpress.w.f(this.f34031r, this.vc, new ia(this, this.eq, this.vc));
                this.pr = fVar;
                this.xk.add(fVar);
            }
        }
        this.wv = new com.bytedance.sdk.component.adexpress.w.a(this.xk, this.f34027m);
    }

    private boolean bk() {
        return z() && this.f34029p.y() == 1;
    }

    private com.bytedance.sdk.openadsdk.ux.c ck() {
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.a.r rVar = new com.bytedance.sdk.openadsdk.core.a.r(this.ev, this.f34029p, jSONObject);
        rVar.c(jSONObject, "webview_source", (Object) 1);
        return rVar;
    }

    private boolean eq() {
        me meVar = this.f34029p;
        return meVar != null && meVar.x() == 1 && me.w(this.f34029p);
    }

    private boolean gb() {
        return com.bytedance.sdk.openadsdk.core.ls.w().gd(wv.gd(this.f34029p)) == 4 && z();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01ae  */
    /* JADX WARN: Type inference failed for: r2v18, types: [com.bytedance.sdk.component.adexpress.w.bk$c] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void j() {
        /*
            Method dump skipped, instructions count: 442
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.j():void");
    }

    private boolean ls() {
        com.bytedance.sdk.openadsdk.ys.w.xv.w wVar = this.gd;
        return wVar != null && eq.f33190w >= 5900 && wVar.z();
    }

    private boolean n() {
        if (TextUtils.equals(this.ev, "rewarded_video") || TextUtils.equals(this.ev, "fullscreen_interstitial_ad")) {
            return this.f34029p.bx();
        }
        return true;
    }

    private void q() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.bytedance.openadsdk.themeTypeChangeReceiver");
            ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver = new ThemeStatusBroadcastReceiver();
            this.eq = themeStatusBroadcastReceiver;
            themeStatusBroadcastReceiver.c(this);
            this.f34031r.registerReceiver(this.eq, intentFilter, wv.ls(), null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void t() {
        com.bytedance.sdk.openadsdk.ys.w.xv.w wVar;
        float f4;
        float f5;
        if (TextUtils.equals(this.ev, "splash_ad") && (wVar = this.gd) != null && this.ls == wVar.gd() && this.f34025j == this.gd.ev()) {
            this.ls = xk.sr(this.f34031r, this.ls);
            int sr = xk.sr(this.f34031r);
            if (this.f34025j < sr) {
                this.f34025j = xk.sr(this.f34031r, f5);
            } else {
                this.f34025j = xk.sr(this.f34031r, f4);
            }
        }
    }

    private void xv(me meVar, Context context, String str) {
        if (meVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.eq.f.c(context, meVar, str);
    }

    private void y() {
        Dialog dialog = this.sr;
        if (dialog != null) {
            dialog.show();
            return;
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.c cVar = this.xv;
        if (cVar != null) {
            cVar.c();
        } else {
            TTDelegateActivity.c(getContext(), this.f34029p);
        }
    }

    private boolean z() {
        return TextUtils.equals(this.ev, "splash_ad") || TextUtils.equals(this.ev, "cache_splash_ad");
    }

    public int S_() {
        return 0;
    }

    public int T_() {
        return 0;
    }

    public void U_() {
    }

    public void V_() {
    }

    public void W_() {
    }

    public void X_() {
    }

    public void Y_() {
        if (ls() && TextUtils.equals(this.ev, "embeded_ad")) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            com.bytedance.sdk.openadsdk.core.dislike.xv.w wVar = new com.bytedance.sdk.openadsdk.core.dislike.xv.w(this.f34029p.mo());
            wVar.w(InteractionCommon.DISLIKE_TYPE_EXECUTION);
            com.bytedance.sdk.openadsdk.core.dislike.c.c.c().c(this.f34031r, wVar, "close_success");
        }
    }

    public void a() {
        ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver;
        try {
            removeAllViews();
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            for (com.bytedance.sdk.component.adexpress.w.p pVar : this.xk) {
                pVar.c();
            }
            this.xv = null;
            this.sr = null;
            this.gd = null;
            this.f34029p = null;
            this.f34023f = null;
            this.fp = null;
            this.f34033u = null;
            this.f34026k = null;
            this.f34020a = null;
            this.ux = null;
            Context context = this.f34031r;
            if (context == null || (themeStatusBroadcastReceiver = this.eq) == null) {
                return;
            }
            context.unregisterReceiver(themeStatusBroadcastReceiver);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.a.xv("NativeExpressView", "detach error", th);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.w.ys
    public void a_(final int i4) {
        if (!this.f34022c) {
            this.f34027m.fp();
        }
        this.f34027m.ia();
        com.bytedance.sdk.component.adexpress.w.gd gdVar = this.f34027m;
        if (gdVar instanceof gd) {
            ((gd) gdVar).fz();
        }
        if (this.ux != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.ux.c(this, com.bytedance.sdk.openadsdk.core.p.c(i4), i4);
            } else {
                com.bytedance.sdk.openadsdk.core.q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.5
                    @Override // java.lang.Runnable
                    public void run() {
                        NativeExpressView.this.ux.c(NativeExpressView.this, com.bytedance.sdk.openadsdk.core.p.c(i4), i4);
                    }
                });
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.theme.c
    public void b_(int i4) {
        com.bytedance.sdk.component.adexpress.w.sr<? extends View> srVar = this.gw;
        if (srVar == null || !(srVar instanceof a)) {
            return;
        }
        ((a) srVar).b_(i4);
    }

    public void c(float f4) {
    }

    public void c(float f4, float f5, float f6, float f7, int i4) {
    }

    public void c(int i4) {
    }

    public void c(int i4, String str) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i4;
        ux uxVar = this.f34023f;
        if (uxVar != null) {
            uxVar.w(motionEvent.getDeviceId());
            this.f34023f.c(motionEvent.getSource());
            this.f34023f.xv(motionEvent.getToolType(0));
        }
        f fVar = this.f34033u;
        if (fVar != null) {
            fVar.w(motionEvent.getDeviceId());
            this.f34033u.c(motionEvent.getSource());
            this.f34033u.xv(motionEvent.getToolType(0));
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.oo = motionEvent.getRawX();
            this.au = motionEvent.getRawY();
            this.f34021b = System.currentTimeMillis();
            i4 = 0;
        } else if (actionMasked == 1) {
            i4 = 3;
        } else if (actionMasked != 2) {
            i4 = actionMasked != 3 ? -1 : 4;
        } else {
            this.bj += Math.abs(motionEvent.getX() - this.oo);
            this.bm += Math.abs(motionEvent.getY() - this.au);
            this.oo = motionEvent.getX();
            this.au = motionEvent.getY();
            i4 = (System.currentTimeMillis() - this.f34021b <= 200 || (this.bj <= 8.0f && this.bm <= 8.0f)) ? 2 : 1;
        }
        SparseArray<sr.c> sparseArray = this.mt;
        if (sparseArray != null) {
            sparseArray.put(motionEvent.getActionMasked(), new sr.c(i4, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void ev() {
    }

    public void f() {
    }

    public void fp() {
        com.bytedance.sdk.openadsdk.ux.c cVar = this.gb;
        if (cVar instanceof com.bytedance.sdk.openadsdk.core.a.r) {
            ((com.bytedance.sdk.openadsdk.core.a.r) cVar).xv(this.vc.f());
        }
        this.gb.c();
        this.wv.c(this);
        this.wv.c();
    }

    public boolean fz() {
        com.bytedance.sdk.component.adexpress.w.sr<? extends View> srVar = this.gw;
        return srVar != null && srVar.xv() == 1;
    }

    public long getActualPlayDuration() {
        return 0L;
    }

    public ux getClickCreativeListener() {
        return this.f34023f;
    }

    public f getClickListener() {
        return this.f34033u;
    }

    public int getDynamicShowType() {
        com.bytedance.sdk.component.adexpress.w.sr<? extends View> srVar = this.gw;
        if (srVar != null) {
            return srVar.xv();
        }
        return 0;
    }

    public int getExpectExpressHeight() {
        return Float.valueOf(this.ls).intValue();
    }

    public int getExpectExpressWidth() {
        return Float.valueOf(this.f34025j).intValue();
    }

    public c getExpressInteractionListener() {
        return this.ux;
    }

    public com.bytedance.sdk.openadsdk.core.xk getJsObject() {
        ls lsVar = this.me;
        if (lsVar != null) {
            return lsVar.R_();
        }
        return null;
    }

    public int getRenderEngineCacheType() {
        r ys;
        com.bytedance.sdk.component.adexpress.w.sr<? extends View> srVar = this.gw;
        if (!(srVar instanceof ls) || (ys = ((ls) srVar).ys()) == null) {
            return 0;
        }
        return ys.c();
    }

    public View getVideoContainer() {
        return this.bk;
    }

    public com.bykv.vk.openvk.component.video.api.sr.xv getVideoController() {
        return null;
    }

    public SSWebView getWebView() {
        ls lsVar = this.me;
        if (lsVar == null) {
            return null;
        }
        return lsVar.c();
    }

    public Boolean i() {
        com.bytedance.sdk.component.adexpress.w.sr<? extends View> srVar = this.gw;
        if (srVar == null) {
            return null;
        }
        int xv = srVar.xv();
        if (xv != 0) {
            if (xv == 2 || xv == 3) {
                if (this.f34035x != null) {
                    return Boolean.valueOf(this.f34035x.fp());
                }
                return Boolean.FALSE;
            }
            return null;
        }
        com.bytedance.sdk.component.adexpress.w.sr<? extends View> srVar2 = this.gw;
        if (srVar2 instanceof ls) {
            com.bytedance.sdk.openadsdk.core.xk R_ = ((ls) srVar2).R_();
            if (R_ == null) {
                return Boolean.FALSE;
            }
            return Boolean.valueOf(R_.fz());
        }
        return null;
    }

    public void ia() {
        ls lsVar = this.me;
        if (lsVar == null || lsVar.r() == null) {
            return;
        }
        this.me.ux();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        this.xk = new ArrayList();
        com.bytedance.sdk.openadsdk.ys.w.xv.w wVar = this.gd;
        if (wVar != null) {
            this.f34025j = wVar.p();
            this.ls = this.gd.k();
            t();
            this.f34030q = this.gd.f();
        }
        if (!bk()) {
            setBackgroundColor(0);
            setBackgroundResource(17170445);
            q();
        }
        j();
        ba();
        com.bytedance.sdk.component.adexpress.w.fp fpVar = this.yu;
        if (fpVar != null) {
            this.me = (ls) fpVar.w();
        }
        if (ls()) {
            this.up = new ys(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.sdk.component.utils.a.f("webviewpool", "onAttachedToWindow+++");
        getViewTreeObserver().addOnScrollChangedListener(this.ck);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            com.bytedance.sdk.openadsdk.ux.c cVar = this.gb;
            if (cVar != null) {
                cVar.w(true);
            }
            getViewTreeObserver().removeOnScrollChangedListener(this.ck);
        } catch (Exception unused) {
        }
        com.bytedance.sdk.component.utils.a.f("webviewpool", "onDetachedFromWindow===");
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.bytedance.sdk.component.utils.a.f("webviewpool", "onFinishTemporaryDetach+++");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ys ysVar;
        if (ls() && (ysVar = this.up) != null) {
            return ysVar.c(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.bytedance.sdk.component.utils.a.f("webviewpool", "onStartTemporaryDetach===");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ys ysVar;
        if (ls() && (ysVar = this.up) != null) {
            return ysVar.w(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        if (Build.VERSION.SDK_INT < 28) {
            onWindowVisibilityChanged(z3 ? getVisibility() : 8);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i4) {
        super.onWindowVisibilityChanged(i4);
        removeCallbacks(this.f34036y);
        removeCallbacks(this.ba);
        if (i4 == 0) {
            postDelayed(this.ba, 50L);
        } else {
            postDelayed(this.f34036y, 50L);
        }
    }

    public void s() {
        try {
            FrameLayout frameLayout = this.bk;
            if (frameLayout == null || frameLayout.getParent() == null) {
                return;
            }
            removeView(this.bk);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.a.c("NativeExpressView", "backupDestroy remove video container error", th);
        }
    }

    public void setBackupListener(com.bytedance.sdk.component.adexpress.w.xv xvVar) {
        this.fp = xvVar;
        com.bytedance.sdk.component.adexpress.w.f fVar = this.pr;
        if (fVar != null) {
            fVar.c(xvVar);
        }
    }

    public void setClickCreativeListener(ux uxVar) {
        this.f34023f = uxVar;
    }

    public void setClickListener(f fVar) {
        this.f34033u = fVar;
    }

    public void setDislike(com.bytedance.sdk.openadsdk.core.dislike.ui.c cVar) {
        BackupView backupView;
        com.bytedance.sdk.component.adexpress.w.sr<? extends View> srVar = this.gw;
        if (srVar != null && (srVar instanceof ia) && (backupView = (BackupView) srVar.r()) != null) {
            backupView.setDislikeInner(cVar);
        }
        this.xv = cVar;
    }

    public void setExpressInteractionListener(c cVar) {
        this.ux = cVar;
    }

    public void setOuterDislike(Dialog dialog) {
        BackupView backupView;
        com.bytedance.sdk.component.adexpress.w.sr<? extends View> srVar = this.gw;
        if (srVar != null && (srVar instanceof ia) && (backupView = (BackupView) srVar.r()) != null) {
            backupView.setDislikeOuter(dialog);
        }
        this.sr = dialog;
    }

    public void setPauseFromExpressView(boolean z3) {
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.sr
    public void setSoundMute(boolean z3) {
        this.fz = z3;
        com.bytedance.sdk.component.adexpress.w.w wVar = this.wx;
        if (wVar != null && wVar.w() != null) {
            this.wx.w().setSoundMute(z3);
        }
        if (this.gw.xv() == 7) {
            com.bytedance.sdk.component.adexpress.w.sr<? extends View> srVar = this.gw;
            if (srVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.w.xv) {
                ((com.bytedance.sdk.component.adexpress.dynamic.sr) srVar).setSoundMute(z3);
            }
        }
    }

    public void setTimeUpdate(int i4) {
    }

    public void setVideoAdInteractionListener(xv.InterfaceC0335xv interfaceC0335xv) {
        this.f34020a = interfaceC0335xv;
    }

    public void setVideoAdListener(xv.sr srVar) {
        this.f34026k = srVar;
    }

    public void sr(int i4) {
        com.bytedance.sdk.component.adexpress.w.sr<? extends View> srVar = this.gw;
        if (srVar == null || !(srVar instanceof a)) {
            return;
        }
        ((a) srVar).w(i4);
    }

    public boolean u() {
        return this.f34028n;
    }

    public void ux(int i4) {
        this.vc.c(i4);
    }

    public void w(int i4) {
    }

    public long xv() {
        return 0L;
    }

    public void ys() {
        com.bytedance.sdk.component.adexpress.w.sr<? extends View> srVar = this.gw;
        if (srVar instanceof a) {
            ((a) srVar).ev();
        }
    }

    private void w(View view, com.bytedance.sdk.openadsdk.core.u.u uVar, com.bytedance.sdk.openadsdk.core.u.gd gdVar, int i4, String str, int i5) {
        f fVar = this.f34033u;
        if (fVar != null) {
            fVar.c(uVar);
            ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) this.f34033u.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).w(str);
            ((com.bytedance.sdk.openadsdk.core.w.c.c.w) this.f34033u.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).w(i4);
            this.f34033u.c(gdVar);
            ((com.bytedance.sdk.openadsdk.core.w.c.w.f) this.f34033u.c(com.bytedance.sdk.openadsdk.core.w.c.w.f.class)).c(uVar);
            ((com.bytedance.sdk.openadsdk.core.w.c.w.ux) this.f34033u.c(com.bytedance.sdk.openadsdk.core.w.c.w.ux.class)).c(uVar);
            this.f34033u.c(view, gdVar);
            com.bytedance.sdk.openadsdk.core.w.c.w.f.c(this.f34033u);
        }
        c cVar = this.ux;
        if (cVar != null) {
            cVar.c(this, i5);
        }
    }

    public void c(View view, int i4, com.bytedance.sdk.component.adexpress.xv xvVar) {
        com.bytedance.sdk.openadsdk.core.u.gd gdVar;
        int i5;
        ux uxVar;
        f fVar;
        if (i4 == -1 || xvVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.u.u uVar = (com.bytedance.sdk.openadsdk.core.u.u) xvVar;
        ux uxVar2 = this.f34023f;
        if (uxVar2 != null) {
            uxVar2.sr(getDynamicShowType());
        }
        f fVar2 = this.f34033u;
        if (fVar2 != null) {
            fVar2.sr(getDynamicShowType());
        }
        com.bytedance.sdk.openadsdk.core.w.c.xv.c cVar = null;
        if (i4 != 1 || (fVar = this.f34033u) == null) {
            gdVar = null;
        } else {
            com.bytedance.sdk.openadsdk.core.u.gd w3 = fVar.w();
            com.bytedance.sdk.openadsdk.core.w.c.xv.c cVar2 = (com.bytedance.sdk.openadsdk.core.w.c.xv.c) this.f34033u.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class);
            cVar2.w(cVar2.ux());
            gdVar = w3;
            cVar = cVar2;
        }
        if (i4 == 2 && (uxVar = this.f34023f) != null) {
            gdVar = uxVar.w();
            cVar = (com.bytedance.sdk.openadsdk.core.w.c.xv.c) this.f34023f.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class);
            cVar.w(cVar.ux());
        }
        try {
            Object obj = uVar.c().get("click_extra_map");
            if (cVar != null && (obj instanceof Map)) {
                cVar.w((Map) obj);
            }
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.core.u.gd gdVar2 = gdVar == null ? new com.bytedance.sdk.openadsdk.core.u.gd() : gdVar;
        gdVar2.c(uVar.f34827c);
        gdVar2.w(uVar.f34834w);
        gdVar2.xv(uVar.xv);
        gdVar2.sr(uVar.sr);
        gdVar2.c(uVar.ys);
        gdVar2.f(uVar.f34832s);
        gdVar2.c(com.bytedance.sdk.openadsdk.core.u.fz.sr(this.f34029p, uVar.ia));
        gdVar2.w(uVar.ia);
        SparseArray<sr.c> sparseArray = uVar.fp;
        if (sparseArray == null || sparseArray.size() == 0) {
            sparseArray = this.mt;
        }
        gdVar2.c(sparseArray);
        JSONObject c4 = uVar.c();
        try {
            boolean z3 = c4.getBoolean("openPlayableLandingPage");
            i5 = z3;
            if (!com.bytedance.sdk.openadsdk.core.u.wx.ux(this.f34029p)) {
                i5 = z3 ? 3 : 2;
            }
        } catch (JSONException unused2) {
            i5 = Integer.MIN_VALUE;
        }
        gdVar2.xv(c4.optBoolean("is_compliant_download"));
        String optString = c4.optString("uchain_event_name");
        gdVar2.xv(optString);
        int optInt = c4.optInt("convertActionType", Integer.MIN_VALUE);
        if (optInt == 1) {
            if (i4 == 2) {
                this.f34023f.xv();
            } else {
                this.f34033u.xv();
            }
        } else if (optInt == 2) {
            if (i4 == 2) {
                this.f34023f.sr();
            } else {
                this.f34033u.sr();
            }
        }
        View view2 = view == null ? this : view;
        String str = uVar.f34829k;
        w(this.ev);
        me meVar = this.f34029p;
        int v3 = meVar != null ? meVar.v() : 0;
        switch (i4) {
            case 1:
                FrameLayout frameLayout = this.bk;
                if (frameLayout != null) {
                    frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                w(view2, uVar, gdVar2, i5, str, v3);
                return;
            case 2:
                c(view2, uVar, gdVar2, i5, str, v3);
                return;
            case 3:
                y();
                return;
            case 4:
                FrameLayout frameLayout2 = this.bk;
                if (frameLayout2 != null) {
                    frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                com.bytedance.sdk.component.utils.a.w("ClickCreativeListener", "\u521b\u610f....mAdType=" + this.ev + ",!mVideoPause=" + (true ^ this.f34032t) + "\uff0cisAutoPlay=" + wv.s(this.f34029p));
                if ("embeded_ad".equals(this.ev) && eq() && !this.f34032t && wv.s(this.f34029p)) {
                    com.bytedance.sdk.component.utils.a.w("ClickCreativeListener", "\u521b\u610f....");
                    c(view2, uVar, gdVar2, i5, str, v3);
                    return;
                }
                com.bytedance.sdk.component.utils.a.w("ClickCreativeListener", "\u666e\u901a....");
                w(view2, uVar, gdVar2, i5, str, v3);
                return;
            case 5:
                a_(!this.fz);
                return;
            case 6:
                X_();
                return;
            case 7:
                if (c(optString)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.eq.f.c(this.f34031r, this.f34029p);
                return;
            case 8:
                Y_();
                return;
            case 9:
                w(this.f34029p, this.f34031r, this.ev);
                return;
            case 10:
                c(this.f34029p, this.f34031r, this.ev);
                return;
            case 11:
            default:
                return;
            case 12:
                xv(this.f34029p, this.f34031r, this.ev);
                return;
        }
    }

    public void a_(boolean z3) {
        if (this.gw.xv() == 7) {
            com.bytedance.sdk.component.adexpress.w.sr<? extends View> srVar = this.gw;
            if (srVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.w.xv) {
                ((com.bytedance.sdk.component.adexpress.dynamic.sr) srVar).setSoundMute(z3);
            }
        }
    }

    private void w(View view, int i4, com.bytedance.sdk.openadsdk.core.u.u uVar, com.bytedance.sdk.openadsdk.core.u.gd gdVar, int i5) {
        ux uxVar = this.f34023f;
        if (uxVar != null) {
            c(((com.bytedance.sdk.openadsdk.core.w.c.c.w) uxVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(), i4);
            this.f34023f.c(uVar);
            this.f34023f.c(gdVar);
            this.f34023f.c(view, gdVar);
        }
        c cVar = this.ux;
        if (cVar != null) {
            cVar.c(this, i5);
        }
    }

    private void w(String str) {
        if (this.f34029p == null || TextUtils.isEmpty(str) || !str.equals("feed_video_middle_page")) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.a.xv.w(this.f34029p, "feed_video_middle_page", "middle_page_click");
    }

    private void w(me meVar, Context context, String str) {
        if (meVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.eq.f.c(meVar, context, str);
    }

    public void w(int i4, String str) {
        com.bytedance.sdk.openadsdk.core.xk R_;
        com.bytedance.sdk.component.adexpress.w.sr<? extends View> srVar = this.gw;
        if (srVar == null || !(srVar instanceof ls) || (R_ = ((ls) srVar).R_()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("time", i4);
            jSONObject.put("flag", str);
            R_.c("onVideoPaused", jSONObject);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    public NativeExpressView(boolean z3, Context context, me meVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, String str, boolean z4) {
        super(context);
        this.f34022c = true;
        this.f34034w = 0;
        this.ev = "embeded_ad";
        this.f34024i = new AtomicBoolean(false);
        this.f34030q = null;
        this.ys = false;
        this.ia = false;
        this.fz = false;
        this.f34028n = false;
        this.ck = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.f34037z);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.f34037z, 500L);
            }
        };
        this.f34037z = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.2
            @Override // java.lang.Runnable
            public void run() {
                if (wx.c(NativeExpressView.this, 0, 5)) {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.sr(nativeExpressView.getVisibility());
                    return;
                }
                NativeExpressView.this.sr(8);
            }
        };
        this.ba = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.3
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.sr(0);
            }
        };
        this.f34036y = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.4
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.sr(8);
            }
        };
        this.mt = new SparseArray<>();
        this.oo = -1.0f;
        this.au = -1.0f;
        this.bj = -1.0f;
        this.bm = -1.0f;
        this.f34021b = 0L;
        this.ev = str;
        this.f34031r = context;
        this.f34029p = meVar;
        this.gd = wVar;
        this.ys = z3;
        this.fz = z4;
        k();
    }

    public NativeExpressView(Context context, me meVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, String str, boolean z3) {
        super(context);
        this.f34022c = true;
        this.f34034w = 0;
        this.ev = "embeded_ad";
        this.f34024i = new AtomicBoolean(false);
        this.f34030q = null;
        this.ys = false;
        this.ia = false;
        this.fz = false;
        this.f34028n = false;
        this.ck = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.f34037z);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.f34037z, 500L);
            }
        };
        this.f34037z = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.2
            @Override // java.lang.Runnable
            public void run() {
                if (wx.c(NativeExpressView.this, 0, 5)) {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.sr(nativeExpressView.getVisibility());
                    return;
                }
                NativeExpressView.this.sr(8);
            }
        };
        this.ba = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.3
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.sr(0);
            }
        };
        this.f34036y = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.4
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.sr(8);
            }
        };
        this.mt = new SparseArray<>();
        this.oo = -1.0f;
        this.au = -1.0f;
        this.bj = -1.0f;
        this.bm = -1.0f;
        this.f34021b = 0L;
        this.ev = str;
        this.f34031r = context;
        this.f34029p = meVar;
        this.gd = wVar;
        this.fz = z3;
        if (wVar.q() == 9) {
            this.ys = wVar.ia() == 2;
        }
        k();
    }

    private void c(View view, com.bytedance.sdk.openadsdk.core.u.u uVar, com.bytedance.sdk.openadsdk.core.u.gd gdVar, int i4, String str, int i5) {
        ux uxVar = this.f34023f;
        if (uxVar != null) {
            uxVar.c(uVar);
            ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) this.f34023f.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).w(str);
            ((com.bytedance.sdk.openadsdk.core.w.c.c.w) this.f34023f.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).w(i4);
            this.f34023f.c(gdVar);
            ((com.bytedance.sdk.openadsdk.core.w.c.w.f) this.f34023f.c(com.bytedance.sdk.openadsdk.core.w.c.w.f.class)).c(uVar);
            ((com.bytedance.sdk.openadsdk.core.w.c.w.ux) this.f34023f.c(com.bytedance.sdk.openadsdk.core.w.c.w.ux.class)).c(uVar);
            this.f34023f.c(view, gdVar);
            com.bytedance.sdk.openadsdk.core.w.c.w.f.c(this.f34023f);
        }
        c cVar = this.ux;
        if (cVar != null) {
            cVar.c(this, i5);
        }
    }

    public void c(View view, int i4, com.bytedance.sdk.component.adexpress.xv xvVar, int i5) {
        if (i4 == -1 || xvVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.u.u uVar = (com.bytedance.sdk.openadsdk.core.u.u) xvVar;
        com.bytedance.sdk.openadsdk.core.u.gd gdVar = new com.bytedance.sdk.openadsdk.core.u.gd();
        gdVar.c(uVar.fp);
        gdVar.c(uVar.f34827c);
        gdVar.w(uVar.f34834w);
        gdVar.xv(uVar.xv);
        gdVar.sr(uVar.sr);
        gdVar.c(uVar.ys);
        JSONObject c4 = uVar.c();
        int optInt = c4.optInt("convertActionType", Integer.MIN_VALUE);
        gdVar.xv(c4.optBoolean("is_compliant_download"));
        if (optInt == 1) {
            if (i4 == 2) {
                this.f34023f.xv();
            } else {
                this.f34033u.xv();
            }
        } else if (optInt == 2) {
            if (i4 == 2) {
                this.f34023f.sr();
            } else {
                this.f34033u.sr();
            }
        }
        View view2 = view == null ? this : view;
        ux uxVar = this.f34023f;
        if (uxVar != null) {
            uxVar.sr(getDynamicShowType());
        }
        f fVar = this.f34033u;
        if (fVar != null) {
            fVar.sr(getDynamicShowType());
        }
        me meVar = this.f34029p;
        int v3 = meVar != null ? meVar.v() : 0;
        switch (i4) {
            case 1:
                FrameLayout frameLayout = this.bk;
                if (frameLayout != null) {
                    frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                c(view2, i5, uVar, gdVar, v3);
                return;
            case 2:
                w(view2, i5, uVar, gdVar, v3);
                return;
            case 3:
                y();
                return;
            case 4:
                FrameLayout frameLayout2 = this.bk;
                if (frameLayout2 != null) {
                    frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                StringBuilder sb = new StringBuilder();
                sb.append("\u521b\u610f....mAdType=");
                sb.append(this.ev);
                sb.append(",!mVideoPause=");
                sb.append(!this.f34032t);
                sb.append("\uff0cisAutoPlay=");
                sb.append(wv.s(this.f34029p));
                com.bytedance.sdk.component.utils.a.w("ClickCreativeListener", sb.toString());
                if ("embeded_ad".equals(this.ev) && eq() && !this.f34032t && wv.s(this.f34029p)) {
                    com.bytedance.sdk.component.utils.a.w("ClickCreativeListener", "\u521b\u610f....");
                    w(view2, i5, uVar, gdVar, v3);
                    return;
                }
                com.bytedance.sdk.component.utils.a.w("ClickListener", "\u666e\u901a....");
                c(view2, i5, uVar, gdVar, v3);
                return;
            case 5:
                a_(!this.fz);
                return;
            case 6:
                X_();
                return;
            case 7:
            default:
                return;
            case 8:
                Y_();
                return;
        }
    }

    private boolean c(String str) {
        if (this.f34029p.dd() || TextUtils.isEmpty(str)) {
            return false;
        }
        wv.gb();
        HashMap hashMap = new HashMap();
        hashMap.put("material_meta", this.f34029p);
        hashMap.put("context", this.f34031r);
        new w.c(str).c(this.f34029p.mo()).c(hashMap).c().c();
        return true;
    }

    private void c(View view, int i4, com.bytedance.sdk.openadsdk.core.u.u uVar, com.bytedance.sdk.openadsdk.core.u.gd gdVar, int i5) {
        f fVar = this.f34033u;
        if (fVar != null) {
            c(((com.bytedance.sdk.openadsdk.core.w.c.c.w) fVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(), i4);
            this.f34033u.c(uVar);
            this.f34033u.c(gdVar);
            this.f34033u.c(view, gdVar);
        }
        c cVar = this.ux;
        if (cVar != null) {
            cVar.c(this, i5);
        }
    }

    private void c(com.bytedance.sdk.openadsdk.core.p.w.xv xvVar, int i4) {
        if (xvVar != null && (xvVar instanceof com.bytedance.sdk.openadsdk.core.p.xv.f)) {
            com.bytedance.sdk.openadsdk.core.p.xv.xv.xv c4 = ((com.bytedance.sdk.openadsdk.core.p.xv.f) xvVar).c();
            c4.w(true);
            c4.c(i4);
        }
    }

    public void c(com.bytedance.sdk.component.adexpress.w.sr<? extends View> srVar, com.bytedance.sdk.component.adexpress.w.t tVar) {
        try {
            this.gw = srVar;
            this.f34035x = tVar;
            if (srVar.xv() != 1) {
                View r3 = srVar.r();
                if (r3.getParent() != null) {
                    ((ViewGroup) r3.getParent()).removeView(r3);
                }
                addView(r3);
            }
            com.bytedance.sdk.component.adexpress.w.gd gdVar = this.f34027m;
            if (gdVar instanceof gd) {
                ((gd) gdVar).fz();
            }
            if (this.gb != null && srVar.xv() != 0) {
                this.gb.c(srVar.xv(), tVar.k(), tVar.p());
            }
            c cVar = this.ux;
            if (cVar != null) {
                cVar.c(this, (float) tVar.sr(), (float) tVar.ux());
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.a.w("NativeExpressView", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.sr
    public void c(CharSequence charSequence, int i4, int i5, boolean z3) {
        c(Integer.parseInt(String.valueOf(charSequence)), i4, z3);
    }

    protected void c(int i4, int i5, boolean z3) {
        int ux;
        if (TextUtils.equals(this.ev, "fullscreen_interstitial_ad")) {
            ux = com.bytedance.sdk.openadsdk.core.xk.c(this.gd.q(), this.f34029p) ? 0 : com.bytedance.sdk.openadsdk.core.ls.w().f(Integer.parseInt(this.f34030q));
        } else if (!TextUtils.equals(this.ev, "rewarded_video")) {
            return;
        } else {
            ux = com.bytedance.sdk.openadsdk.core.ls.w().ux(Integer.parseInt(this.f34030q));
        }
        int i6 = i5 >= ux ? 1 : 0;
        int i7 = i5 <= ux ? ux - i5 : 0;
        com.bytedance.sdk.component.adexpress.w.w wVar = this.wx;
        if (wVar != null && wVar.w() != null) {
            this.wx.w().c(String.valueOf(i4), z3 ? 1 : i6, i7, z3);
        }
        if (this.gw.xv() == 7) {
            com.bytedance.sdk.component.adexpress.w.sr<? extends View> srVar = this.gw;
            if (srVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.w.xv) {
                ((com.bytedance.sdk.component.adexpress.dynamic.sr) srVar).c(String.valueOf(i4), z3 ? 1 : i6, i7, z3);
            }
        }
    }

    private void c(me meVar, Context context, String str) {
        if (meVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.eq.f.w(meVar, context, str);
    }
}
