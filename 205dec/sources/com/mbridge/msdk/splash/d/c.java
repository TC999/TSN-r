package com.mbridge.msdk.splash.d;

import android.app.Activity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.al;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.out.MBSplashLoadListener;
import com.mbridge.msdk.out.MBSplashShowListener;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.ZoomOutTypeEnum;
import com.mbridge.msdk.splash.view.MBSplashPopView;
import com.mbridge.msdk.splash.view.MBSplashView;
import com.mbridge.msdk.splash.view.MBSplashWebview;

/* compiled from: SplashProvider.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {

    /* renamed from: b  reason: collision with root package name */
    private static String f40652b = "SplashProvider";
    private Activity A;
    private boolean B;
    private CampaignEx C;
    private MBSplashPopView D;

    /* renamed from: c  reason: collision with root package name */
    private String f40654c;

    /* renamed from: d  reason: collision with root package name */
    private String f40655d;

    /* renamed from: e  reason: collision with root package name */
    private MBridgeIds f40656e;

    /* renamed from: g  reason: collision with root package name */
    private long f40658g;

    /* renamed from: h  reason: collision with root package name */
    private com.mbridge.msdk.splash.c.c f40659h;

    /* renamed from: i  reason: collision with root package name */
    private com.mbridge.msdk.splash.c.d f40660i;

    /* renamed from: j  reason: collision with root package name */
    private b f40661j;

    /* renamed from: k  reason: collision with root package name */
    private MBSplashShowListener f40662k;

    /* renamed from: l  reason: collision with root package name */
    private d f40663l;

    /* renamed from: m  reason: collision with root package name */
    private MBSplashView f40664m;

    /* renamed from: n  reason: collision with root package name */
    private MBSplashWebview f40665n;

    /* renamed from: o  reason: collision with root package name */
    private ViewGroup f40666o;

    /* renamed from: p  reason: collision with root package name */
    private View f40667p;

    /* renamed from: q  reason: collision with root package name */
    private com.mbridge.msdk.c.d f40668q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f40669r;

    /* renamed from: s  reason: collision with root package name */
    private ViewGroup f40670s;

    /* renamed from: t  reason: collision with root package name */
    private com.mbridge.msdk.c.c f40671t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f40672u;

    /* renamed from: f  reason: collision with root package name */
    private int f40657f = 5;

    /* renamed from: v  reason: collision with root package name */
    private int f40673v = 1;

    /* renamed from: w  reason: collision with root package name */
    private int f40674w = t.x(com.mbridge.msdk.foundation.controller.a.f().j());

    /* renamed from: x  reason: collision with root package name */
    private int f40675x = t.y(com.mbridge.msdk.foundation.controller.a.f().j());

    /* renamed from: y  reason: collision with root package name */
    private Object f40676y = new Object();

    /* renamed from: z  reason: collision with root package name */
    private Object f40677z = new Object();

    /* renamed from: a  reason: collision with root package name */
    public boolean f40653a = false;
    private boolean E = false;

    public c(Activity activity, String str, String str2) {
        this.f40655d = str;
        this.f40654c = str2;
        this.f40656e = new MBridgeIds(str, str2);
        this.A = activity;
        if (this.f40660i == null) {
            if (activity != null) {
                this.f40660i = new com.mbridge.msdk.splash.c.d(activity, this.f40655d, this.f40654c);
            } else {
                this.f40660i = new com.mbridge.msdk.splash.c.d(com.mbridge.msdk.foundation.controller.a.f().j(), this.f40655d, this.f40654c);
            }
        }
        if (this.f40665n == null) {
            try {
                if (activity != null) {
                    this.f40665n = new MBSplashWebview(activity);
                } else {
                    this.f40665n = new MBSplashWebview(com.mbridge.msdk.foundation.controller.a.f().j());
                }
            } catch (Exception unused) {
            }
            MBSplashWebview mBSplashWebview = this.f40665n;
            if (mBSplashWebview != null) {
                mBSplashWebview.setWebViewClient(new com.mbridge.msdk.splash.view.a(this.f40654c, this.f40660i.a()));
            }
        }
        if (this.f40664m == null) {
            if (activity != null) {
                this.f40664m = new MBSplashView(activity);
            } else {
                this.f40664m = new MBSplashView(com.mbridge.msdk.foundation.controller.a.f().j());
            }
            this.f40664m.setSplashWebview(this.f40665n);
        }
        if (this.f40671t == null) {
            this.f40671t = new com.mbridge.msdk.c.c();
        }
        this.f40671t.a(com.mbridge.msdk.foundation.controller.a.f().j(), com.mbridge.msdk.foundation.controller.a.f().k(), com.mbridge.msdk.foundation.controller.a.f().l(), this.f40654c);
    }

    public final long b() {
        return this.f40658g;
    }

    public final boolean c() {
        return this.f40672u;
    }

    public final int d() {
        return this.f40657f;
    }

    public final String e() {
        if (!this.f40653a) {
            com.mbridge.msdk.splash.c.c cVar = this.f40659h;
            return cVar != null ? cVar.a() : "";
        }
        com.mbridge.msdk.splash.c.d dVar = this.f40660i;
        return dVar != null ? dVar.b() : "";
    }

    public final void f() {
        this.E = true;
        MBSplashPopView mBSplashPopView = this.D;
        if (mBSplashPopView != null) {
            mBSplashPopView.startCountDown();
        }
    }

    public final void g() {
        this.E = false;
        MBSplashShowListener mBSplashShowListener = this.f40662k;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onZoomOutPlayFinish(new MBridgeIds(this.f40655d, this.f40654c));
        }
        MBSplashPopView mBSplashPopView = this.D;
        if (mBSplashPopView != null) {
            mBSplashPopView.release();
        }
    }

    public final void h() {
        com.mbridge.msdk.splash.c.d dVar = this.f40660i;
        if (dVar != null) {
            dVar.d();
        }
        MBSplashPopView mBSplashPopView = this.D;
        if (mBSplashPopView == null || !this.E) {
            return;
        }
        mBSplashPopView.reStartCountDown();
    }

    public final void i() {
        com.mbridge.msdk.splash.c.d dVar = this.f40660i;
        if (dVar != null) {
            dVar.e();
        }
        MBSplashPopView mBSplashPopView = this.D;
        if (mBSplashPopView == null || !this.E) {
            return;
        }
        mBSplashPopView.pauseCountDown();
    }

    public final void j() {
        this.C = null;
        if (this.f40662k != null) {
            this.f40662k = null;
        }
        if (this.f40661j != null) {
            this.f40661j = null;
        }
        if (this.f40663l != null) {
            this.f40663l = null;
        }
        com.mbridge.msdk.splash.c.c cVar = this.f40659h;
        if (cVar != null) {
            cVar.b();
        }
        com.mbridge.msdk.splash.c.d dVar = this.f40660i;
        if (dVar != null) {
            dVar.c();
        }
        if (this.A != null) {
            this.A = null;
        }
    }

    public final void a(ViewGroup viewGroup) {
        this.f40670s = viewGroup;
    }

    public final void b(String str) {
        a(str, 1);
    }

    public final boolean c(String str) {
        return com.mbridge.msdk.splash.c.b.a(this.f40664m, this.f40655d, this.f40654c, str, this.f40672u, this.f40657f, false, true) != null;
    }

    public final void d(String str, ViewGroup viewGroup) {
        this.f40666o = viewGroup;
        MBSplashView mBSplashView = this.f40664m;
        if (mBSplashView != null) {
            mBSplashView.setDevContainer(viewGroup);
        }
        CampaignEx a4 = com.mbridge.msdk.splash.c.b.a(this.f40664m, this.f40655d, this.f40654c, str, this.f40672u, this.f40657f, true, false);
        if (a4 != null) {
            if (this.f40668q == null) {
                this.f40668q = com.mbridge.msdk.c.b.a().c(com.mbridge.msdk.foundation.controller.a.f().k(), this.f40654c);
            }
            this.f40663l = new d(this, this.f40662k, this.f40668q.e(), a4);
            x.a(f40652b, "show start");
            if (this.f40674w != 0 && this.f40675x != 0) {
                int i4 = this.f40657f;
                if (i4 >= 2 && i4 <= 10) {
                    a(a4, this.f40668q.o(), false);
                    return;
                }
                d dVar = this.f40663l;
                if (dVar != null) {
                    MBridgeIds mBridgeIds = this.f40656e;
                    dVar.a(mBridgeIds, "countDownTime must in 2 - 10 ,but now is " + this.f40657f);
                    return;
                }
                return;
            }
            d dVar2 = this.f40663l;
            if (dVar2 != null) {
                dVar2.a(this.f40656e, "width or height is 0  or width or height is too small");
                return;
            }
            return;
        }
        MBSplashShowListener mBSplashShowListener = this.f40662k;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onShowFailed(this.f40656e, "campaignEx is vali");
        }
    }

    public final boolean a() {
        return this.f40669r;
    }

    public final void b(String str, ViewGroup viewGroup) {
        this.f40666o = viewGroup;
        MBSplashView mBSplashView = this.f40664m;
        if (mBSplashView != null) {
            mBSplashView.setDevContainer(viewGroup);
        }
        a(str, 2);
    }

    public final void c(String str, ViewGroup viewGroup) {
        if (TextUtils.isEmpty(str)) {
            MBSplashShowListener mBSplashShowListener = this.f40662k;
            if (mBSplashShowListener != null) {
                mBSplashShowListener.onShowFailed(this.f40656e, "token is null or empty");
                return;
            }
            return;
        }
        d(str, viewGroup);
    }

    public final void a(boolean z3) {
        this.f40669r = z3;
    }

    public final void a(int i4) {
        this.f40673v = i4;
    }

    public final void a(long j4) {
        this.f40658g = j4;
    }

    public final void a(MBSplashLoadListener mBSplashLoadListener) {
        if (this.f40661j == null) {
            this.f40661j = new b(this, this.f40656e);
        }
        this.f40661j.a(mBSplashLoadListener);
    }

    public final void b(boolean z3) {
        this.f40672u = z3;
    }

    public final void c(boolean z3) {
        this.B = z3;
    }

    public final void b(int i4) {
        this.f40657f = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final CampaignEx campaignEx, final int i4, final boolean z3) {
        if (!com.mbridge.msdk.splash.c.b.a(this.f40664m, campaignEx)) {
            if (i4 > 0) {
                this.f40660i.f40595a.postDelayed(new Runnable() { // from class: com.mbridge.msdk.splash.d.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.this.b(campaignEx, i4 - 1, z3);
                    }
                }, 1L);
                return;
            }
            d dVar = this.f40663l;
            if (dVar != null) {
                dVar.a(this.f40656e, "campaignEx is not ready");
                return;
            }
            return;
        }
        d(true);
        ViewGroup.LayoutParams layoutParams = this.f40666o.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        } else {
            layoutParams.height = -1;
            layoutParams.width = -1;
        }
        this.f40666o.setLayoutParams(layoutParams);
        this.f40666o.removeAllViews();
        this.f40660i.a(this.f40657f);
        this.f40660i.a(this.f40670s);
        this.f40660i.a(this.f40663l);
        x.d(f40652b, "start show process");
        ViewGroup viewGroup = this.f40666o;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            al.a(this.f40664m);
            this.f40666o.addView(this.f40664m);
        }
        this.f40660i.a(this.f40672u);
        this.f40660i.a(campaignEx, this.f40664m);
    }

    public final void a(MBSplashShowListener mBSplashShowListener) {
        this.f40662k = mBSplashShowListener;
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            b bVar = this.f40661j;
            if (bVar != null) {
                bVar.a("token is null or empty", 1);
                return;
            }
            return;
        }
        a(str, 1);
    }

    public final void a(String str, ViewGroup viewGroup) {
        if (TextUtils.isEmpty(str)) {
            b bVar = this.f40661j;
            if (bVar != null) {
                bVar.a("token is null or empty", 1);
                return;
            }
            return;
        }
        b(str, viewGroup);
    }

    public final void a(int i4, int i5) {
        b(i5, i4);
    }

    public final void d(final boolean z3) {
        MBSplashWebview mBSplashWebview = this.f40665n;
        if (mBSplashWebview != null) {
            mBSplashWebview.setOnTouchListener(new View.OnTouchListener() { // from class: com.mbridge.msdk.splash.d.c.2
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return !z3;
                }
            });
        }
        MBSplashView mBSplashView = this.f40664m;
        if (mBSplashView != null) {
            mBSplashView.setOnTouchListener(new View.OnTouchListener() { // from class: com.mbridge.msdk.splash.d.c.3
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return !z3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(CampaignEx campaignEx, int i4, boolean z3) {
        if (campaignEx != null && z3) {
            if (this.f40668q == null) {
                this.f40668q = com.mbridge.msdk.c.b.a().c(com.mbridge.msdk.foundation.controller.a.f().k(), this.f40654c);
            }
            this.f40663l = new d(this, this.f40662k, this.f40668q.e(), campaignEx);
        }
        this.C = campaignEx;
        ViewGroup viewGroup = this.f40666o;
        if (viewGroup == null) {
            d dVar = this.f40663l;
            if (dVar != null) {
                dVar.a(this.f40656e, "container is null");
                return;
            }
            return;
        }
        if (this.f40660i == null) {
            this.f40660i = new com.mbridge.msdk.splash.c.d(viewGroup.getContext(), this.f40655d, this.f40654c);
        }
        b(campaignEx, i4, z3);
    }

    private void a(String str, int i4) {
        synchronized (this.f40676y) {
            if (this.f40669r) {
                b bVar = this.f40661j;
                if (bVar != null) {
                    bVar.a("current unit is loading", i4);
                    this.f40669r = true;
                }
                return;
            }
            this.f40669r = true;
            int i5 = this.f40657f;
            if (i5 >= 2 && i5 <= 10) {
                if (this.f40674w != 0 && this.f40675x != 0) {
                    boolean z3 = false;
                    try {
                        z3 = com.mbridge.msdk.mbjscommon.webEnvCheck.a.a(com.mbridge.msdk.foundation.controller.a.f().j());
                    } catch (Exception unused) {
                    }
                    if (!z3) {
                        b bVar2 = this.f40661j;
                        if (bVar2 != null) {
                            bVar2.a("WebView is not available", i4);
                            return;
                        }
                        return;
                    }
                    this.f40664m.clearResState();
                    this.f40668q = com.mbridge.msdk.c.b.a().c(com.mbridge.msdk.foundation.controller.a.f().k(), this.f40654c);
                    if (this.f40659h == null) {
                        this.f40659h = new com.mbridge.msdk.splash.c.c(this.f40655d, this.f40654c, this.f40658g * 1000);
                    }
                    b bVar3 = this.f40661j;
                    if (bVar3 != null) {
                        bVar3.a(str);
                        this.f40659h.a(this.f40661j);
                    }
                    this.f40664m.resetLoadState();
                    this.f40659h.a(this.f40657f);
                    this.f40659h.a(this.f40664m);
                    this.f40659h.a(this.f40668q);
                    this.f40659h.a(this.f40674w, this.f40675x);
                    this.f40659h.a(this.f40672u);
                    this.f40659h.b(this.f40673v);
                    this.f40659h.a(str, i4);
                    return;
                }
                b bVar4 = this.f40661j;
                if (bVar4 != null) {
                    bVar4.a("width or height is 0  or width or height is too small", i4);
                    return;
                }
                return;
            }
            b bVar5 = this.f40661j;
            if (bVar5 != null) {
                bVar5.a("countDownTime must in 2 - 10 ,but now is " + this.f40657f, i4);
            }
        }
    }

    private void b(int i4, int i5) {
        int x3 = t.x(com.mbridge.msdk.foundation.controller.a.f().j());
        int y3 = t.y(com.mbridge.msdk.foundation.controller.a.f().j());
        int i6 = this.f40673v;
        if (i6 == 1) {
            if (y3 >= i5 * 4) {
                this.f40675x = y3 - i5;
                this.f40674w = x3;
                return;
            }
            this.f40675x = 0;
            this.f40674w = 0;
        } else if (i6 == 2) {
            if (x3 >= i4 * 4) {
                this.f40674w = x3 - i4;
                this.f40675x = y3;
                return;
            }
            this.f40675x = 0;
            this.f40674w = 0;
        }
    }

    public final void a(View view, RelativeLayout.LayoutParams layoutParams) {
        this.f40667p = view;
        if (view != null) {
            b(layoutParams.width, layoutParams.height);
            MBSplashView mBSplashView = this.f40664m;
            if (mBSplashView != null) {
                mBSplashView.setIconVg(view, layoutParams);
            }
        }
    }

    public final ViewGroup a(ZoomOutTypeEnum zoomOutTypeEnum) {
        MBSplashPopView mBSplashPopView = new MBSplashPopView(com.mbridge.msdk.foundation.controller.a.f().j(), new MBSplashPopView.a(this.f40655d, this.f40654c, zoomOutTypeEnum.getIndex(), this.C), this.f40663l);
        this.D = mBSplashPopView;
        return mBSplashPopView;
    }
}
