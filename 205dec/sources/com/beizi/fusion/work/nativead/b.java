package com.beizi.fusion.work.nativead;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.beizi.ad.NativeAdListener;
import com.beizi.ad.NativeAdResponse;
import com.beizi.ad.UnifiedCustomAd;
import com.beizi.ad.internal.nativead.NativeAdEventListener;
import com.beizi.ad.internal.nativead.NativeAdShownListener;
import com.beizi.ad.internal.nativead.NativeAdUtil;
import com.beizi.ad.internal.utilities.ImageManager;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.ag;
import com.beizi.fusion.g.al;
import com.beizi.fusion.g.aq;
import com.beizi.fusion.g.at;
import com.beizi.fusion.g.av;
import com.beizi.fusion.g.ax;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.dialog.dislike.a;
import com.beizi.fusion.work.splash.SplashContainer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BaseBeiZiNativeWorker.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class b extends com.beizi.fusion.work.a implements com.beizi.fusion.d.c {
    protected ag A;
    protected AdSpacesBean.BuyerBean.DislikeConfigBean D;
    protected AdSpacesBean.BuyerBean.DislikeConfigBean E;
    protected NativeAdResponse K;

    /* renamed from: L  reason: collision with root package name */
    protected UnifiedCustomAd f15792L;
    protected View M;
    protected AdSpacesBean.ComplainBean N;

    /* renamed from: n  reason: collision with root package name */
    protected Context f15793n;

    /* renamed from: o  reason: collision with root package name */
    protected String f15794o;

    /* renamed from: p  reason: collision with root package name */
    protected long f15795p;

    /* renamed from: q  reason: collision with root package name */
    protected long f15796q;

    /* renamed from: r  reason: collision with root package name */
    protected float f15797r;

    /* renamed from: s  reason: collision with root package name */
    protected float f15798s;

    /* renamed from: t  reason: collision with root package name */
    protected ViewGroup f15799t;

    /* renamed from: u  reason: collision with root package name */
    protected View f15800u;

    /* renamed from: v  reason: collision with root package name */
    protected List<AdSpacesBean.RenderViewBean> f15801v;

    /* renamed from: w  reason: collision with root package name */
    protected AdSpacesBean.RenderViewBean f15802w;

    /* renamed from: x  reason: collision with root package name */
    protected List<Pair<String, Integer>> f15803x;

    /* renamed from: y  reason: collision with root package name */
    protected AdSpacesBean.BuyerBean.ShakeViewBean f15804y;

    /* renamed from: z  reason: collision with root package name */
    protected AdSpacesBean.BuyerBean.CoolShakeViewBean f15805z;
    protected String B = null;
    protected boolean C = false;
    protected float F = 0.0f;
    protected float G = 0.0f;
    protected float H = 0.0f;
    protected float I = 0.0f;
    protected String J = null;
    protected String O = null;
    protected boolean P = false;
    protected boolean Q = false;

    public b(Context context, String str, long j4, long j5, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.d.e eVar, float f4, float f5) {
        this.f15793n = context;
        this.f15794o = str;
        this.f15795p = j4;
        this.f15796q = j5;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        this.f15797r = f4;
        this.f15798s = f5;
        this.f15799t = new SplashContainer(context);
        r();
    }

    private boolean aN() {
        try {
            return System.currentTimeMillis() - this.f15793n.getPackageManager().getPackageInfo(this.f15793n.getPackageName(), 0).firstInstallTime < this.f15805z.getUserProtectTime();
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    private void aO() {
        AdSpacesBean.BuyerBean.DislikeConfigBean b4;
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfig = this.f15368e.getDislikeConfig();
        this.D = dislikeConfig;
        if (dislikeConfig == null || (b4 = b(dislikeConfig.getOrderData(), this.f15792L.getAdId())) == null) {
            return;
        }
        this.E = b4;
    }

    private boolean aP() {
        try {
            AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean = this.E;
            if (dislikeConfigBean != null) {
                return dislikeConfigBean.getIsShowDialog() == 1;
            }
            AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean2 = this.D;
            return dislikeConfigBean2 != null && dislikeConfigBean2.getIsShowDialog() == 1;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return false;
    }

    private boolean aQ() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.f15804y;
        if (shakeViewBean == null) {
            return false;
        }
        return al.a(shakeViewBean.getRenderRate());
    }

    @Override // com.beizi.fusion.work.a
    protected void A() {
        if (!z() || this.f15792L == null) {
            return;
        }
        al();
    }

    public void a(NativeAdResponse nativeAdResponse) {
    }

    public void aG() {
        try {
            if (Y()) {
                com.beizi.fusion.d.e eVar = this.f15367d;
                if (eVar == null) {
                    return;
                }
                Map<String, com.beizi.fusion.work.a> r3 = eVar.r();
                Log.d("BeiZis", g() + " NativeAdWorker:" + r3.toString());
                Z();
                com.beizi.fusion.d.h hVar = this.f15370g;
                if (hVar == com.beizi.fusion.d.h.SUCCESS) {
                    if (this.f15800u != null) {
                        this.f15367d.a(g(), this.f15800u);
                    } else {
                        this.f15367d.a(10140);
                    }
                } else if (hVar == com.beizi.fusion.d.h.FAIL) {
                    Log.d("BeiZis", "other worker shown," + g() + " remove");
                }
            } else {
                O();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void aH() {
        View view;
        try {
            NativeAdResponse nativeAdResponse = this.K;
            if (nativeAdResponse != null && (view = this.M) != null) {
                NativeAdUtil.registerTracking(nativeAdResponse, view, new NativeAdEventListener() { // from class: com.beizi.fusion.work.nativead.b.5

                    /* renamed from: a  reason: collision with root package name */
                    boolean f15813a = false;

                    @Override // com.beizi.ad.internal.nativead.NativeAdEventListener
                    public void onAdWasClicked() {
                        Log.d("BeiZis", "showBeiZiNativeAd onAdWasClicked");
                        b bVar = b.this;
                        if (bVar.P && ((com.beizi.fusion.work.a) bVar).f15368e != null) {
                            ((com.beizi.fusion.work.a) b.this).f15365b.P(((com.beizi.fusion.work.a) b.this).f15368e.getCallBackStrategyUuid());
                            b.this.au();
                        }
                        b.this.F();
                        b bVar2 = b.this;
                        if (!bVar2.P || bVar2.Q) {
                            if (((com.beizi.fusion.work.a) bVar2).f15367d != null && ((com.beizi.fusion.work.a) b.this).f15367d.s() != 2) {
                                ((com.beizi.fusion.work.a) b.this).f15367d.d(b.this.g());
                            }
                            b.this.E();
                            b.this.ai();
                            UnifiedCustomAd unifiedCustomAd = b.this.f15792L;
                            if (unifiedCustomAd != null) {
                                unifiedCustomAd.setTouchAreaNormal();
                            }
                        }
                    }

                    @Override // com.beizi.ad.internal.nativead.NativeAdEventListener
                    public void onAdWillLeaveApplication() {
                        Log.d("BeiZis", "showBeiZiNativeAd onAdWillLeaveApplication");
                    }
                });
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void aI() {
        View view;
        try {
            NativeAdResponse nativeAdResponse = this.K;
            if (nativeAdResponse != null && (view = this.M) != null) {
                NativeAdUtil.registerShow(nativeAdResponse, view, new NativeAdShownListener() { // from class: com.beizi.fusion.work.nativead.b.6
                    @Override // com.beizi.ad.internal.nativead.NativeAdShownListener
                    public void onAdShown() {
                        Log.d("BeiZis", "showBeiZiNativeAd onAdShown()");
                        ((com.beizi.fusion.work.a) b.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
                        if (((com.beizi.fusion.work.a) b.this).f15367d != null && ((com.beizi.fusion.work.a) b.this).f15367d.s() != 2) {
                            ((com.beizi.fusion.work.a) b.this).f15367d.b(b.this.g());
                        }
                        b.this.C();
                        b.this.D();
                        b.this.ah();
                    }
                });
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public boolean aJ() {
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean = this.E;
        if (dislikeConfigBean != null) {
            return dislikeConfigBean.getIsHide() == 0;
        }
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean2 = this.D;
        return dislikeConfigBean2 != null && dislikeConfigBean2.getIsHide() == 0;
    }

    public boolean aK() {
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean = this.E;
        if (dislikeConfigBean != null) {
            return al.a(dislikeConfigBean.getRandomNum());
        }
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean2 = this.D;
        if (dislikeConfigBean2 != null) {
            return al.a(dislikeConfigBean2.getRandomNum());
        }
        return false;
    }

    public boolean aL() {
        long longValue = ((Long) at.b(this.f15793n, this.J, 0L)).longValue();
        return this.D == null || longValue == 0 || System.currentTimeMillis() - longValue >= this.D.getCoolTime();
    }

    public void aM() {
        try {
            if (!aP()) {
                com.beizi.fusion.d.e eVar = this.f15367d;
                if (eVar != null && eVar.s() != 2) {
                    this.f15367d.b(g(), this.f15800u);
                }
                G();
                return;
            }
            a.C0149a c0149a = new a.C0149a(this.f15793n);
            c0149a.a(new a.c() { // from class: com.beizi.fusion.work.nativead.b.9
                @Override // com.beizi.fusion.widget.dialog.dislike.a.c
                public void a() {
                    try {
                        if (((com.beizi.fusion.work.a) b.this).f15367d != null && ((com.beizi.fusion.work.a) b.this).f15367d.s() != 2) {
                            ((com.beizi.fusion.work.a) b.this).f15367d.b(b.this.g(), b.this.f15800u);
                        }
                        b.this.G();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            });
            c0149a.a().show();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void b() {
    }

    @Override // com.beizi.fusion.work.a
    public void f() {
    }

    @Override // com.beizi.fusion.work.a
    public String g() {
        return "BEIZI";
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0065, code lost:
        r7.Q = com.beizi.fusion.g.al.a(java.lang.Integer.parseInt(r4.getRate()));
     */
    @Override // com.beizi.fusion.work.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d() {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.work.nativead.b.d():void");
    }

    @Override // com.beizi.fusion.work.a
    public com.beizi.fusion.f.a i() {
        return this.f15373j;
    }

    @Override // com.beizi.fusion.work.a
    public String j() {
        UnifiedCustomAd unifiedCustomAd = this.f15792L;
        if (unifiedCustomAd == null) {
            return null;
        }
        return unifiedCustomAd.getPrice();
    }

    @Override // com.beizi.fusion.work.a
    public AdSpacesBean.BuyerBean k() {
        return this.f15368e;
    }

    @Override // com.beizi.fusion.work.a
    protected void l() {
        w();
        ag();
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView = this.f15368e.getShakeView();
        this.f15804y = shakeView;
        if (shakeView != null) {
            this.f15805z = shakeView.getCoolShakeView();
        }
        this.A = new ag(this.f15793n);
        this.B = "cool_" + this.f15372i;
        this.J = "dl_cool_" + this.f15372i;
        if (this.f15797r <= 0.0f) {
            this.f15797r = av.j(this.f15793n);
        }
        if (this.f15798s <= 0.0f) {
            this.f15798s = 0.0f;
        }
        UnifiedCustomAd unifiedCustomAd = new UnifiedCustomAd(this.f15793n, this.f15372i, new NativeAdListener() { // from class: com.beizi.fusion.work.nativead.b.2
            @Override // com.beizi.ad.NativeAdListener
            public void onAdClick() {
                Log.d("BeiZis", "showBeiZiNativeUnifiedAd onAdClick()");
            }

            @Override // com.beizi.ad.NativeAdListener
            public void onAdFailed(int i4) {
                Log.d("BeiZis", "showBeiZiNativeUnifiedAd onAdFailed: " + i4);
                b.this.a(String.valueOf(i4), i4);
            }

            @Override // com.beizi.ad.NativeAdListener
            public void onAdLoaded(NativeAdResponse nativeAdResponse) {
                Log.d("BeiZis", "showBeiZiNativeUnifiedAd onAdLoaded()");
                ((com.beizi.fusion.work.a) b.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                if (b.this.f15792L.getPrice() != null) {
                    try {
                        b bVar = b.this;
                        bVar.a(Double.parseDouble(bVar.f15792L.getPrice()));
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                b.this.y();
                if (nativeAdResponse == null) {
                    b.this.c(-991);
                    return;
                }
                b bVar2 = b.this;
                bVar2.K = nativeAdResponse;
                bVar2.b();
            }
        });
        this.f15792L = unifiedCustomAd;
        unifiedCustomAd.openAdInNativeBrowser(true);
        this.f15792L.loadAd();
    }

    @Override // com.beizi.fusion.work.a
    public void m() {
        UnifiedCustomAd unifiedCustomAd = this.f15792L;
        if (unifiedCustomAd != null) {
            unifiedCustomAd.cancel();
        }
        ag agVar = this.A;
        if (agVar != null) {
            agVar.c();
        }
    }

    @Override // com.beizi.fusion.work.a
    public View o() {
        return this.f15800u;
    }

    private boolean b(final AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        long longValue = ((Long) at.b(this.f15793n, this.B, 0L)).longValue();
        if (longValue != 0) {
            long currentTimeMillis = System.currentTimeMillis() - longValue;
            if (currentTimeMillis < this.f15805z.getCoolTime()) {
                new Handler().postDelayed(new Runnable() { // from class: com.beizi.fusion.work.nativead.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.A.a(shakeViewBean);
                    }
                }, this.f15805z.getCoolTime() - currentTimeMillis);
                return true;
            }
            aq.a().a(this.B);
        }
        return false;
    }

    public void a(final TextView textView, final ImageView imageView) {
        ArrayList<String> texts;
        try {
            NativeAdResponse nativeAdResponse = this.K;
            if (nativeAdResponse == null) {
                return;
            }
            String callToAction = nativeAdResponse.getCallToAction();
            if (TextUtils.isEmpty(callToAction) && (texts = this.K.getTexts()) != null && texts.size() >= 3) {
                callToAction = texts.get(2);
            }
            if (TextUtils.isEmpty(callToAction)) {
                if (textView != null) {
                    textView.setVisibility(8);
                }
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
            } else if (callToAction.startsWith("http")) {
                ImageManager.with(null).getBitmap(callToAction, new ImageManager.BitmapLoadedListener() { // from class: com.beizi.fusion.work.nativead.b.3
                    @Override // com.beizi.ad.internal.utilities.ImageManager.BitmapLoadedListener
                    public void onBitmapLoadFailed() {
                    }

                    @Override // com.beizi.ad.internal.utilities.ImageManager.BitmapLoadedListener
                    public void onBitmapLoaded(Bitmap bitmap) {
                        try {
                            TextView textView2 = textView;
                            if (textView2 != null) {
                                textView2.setVisibility(8);
                            }
                            ImageView imageView2 = imageView;
                            if (imageView2 != null) {
                                imageView2.setVisibility(0);
                                imageView.setImageBitmap(bitmap);
                            }
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                });
            } else {
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                if (textView != null) {
                    textView.setVisibility(0);
                    textView.setText(callToAction);
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private AdSpacesBean.BuyerBean.DislikeConfigBean b(List<AdSpacesBean.BuyerBean.OrderDataDislikeConfigBean> list, String str) {
        AdSpacesBean.BuyerBean.DislikeConfigBean dislike;
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataDislikeConfigBean orderDataDislikeConfigBean : list) {
                List<String> orderList = orderDataDislikeConfigBean.getOrderList();
                if (orderList != null && orderList.contains(str) && (dislike = orderDataDislikeConfigBean.getDislike()) != null) {
                    return dislike;
                }
            }
        }
        return null;
    }

    public void a(final View view) {
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean;
        try {
            int a4 = av.a(this.f15793n, this.f15797r);
            float f4 = this.f15798s;
            int a5 = f4 > 0.0f ? av.a(this.f15793n, f4) : -2;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a4, a5);
            ViewGroup viewGroup = this.f15799t;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                StringBuilder sb = new StringBuilder();
                sb.append("mNativeAd != null ? ");
                boolean z3 = true;
                sb.append(this.f15792L != null);
                sb.append(",renderViewBean != null ? ");
                if (this.f15802w == null) {
                    z3 = false;
                }
                sb.append(z3);
                af.a("BeiZis", sb.toString());
                this.f15799t.addView(this.M, layoutParams);
                this.M.measure(0, 0);
                a(this.K, a4, a5, this.M.getMeasuredHeight());
                aO();
                com.beizi.fusion.b.b bVar = this.f15365b;
                if (bVar != null && (dislikeConfigBean = this.D) != null) {
                    bVar.Q(dislikeConfigBean.getDislikeUuid());
                    au();
                }
                if (aJ()) {
                    a(this.K);
                }
                ViewGroup viewGroup2 = this.f15799t;
                this.f15800u = viewGroup2;
                this.A.a(viewGroup2);
            }
            UnifiedCustomAd unifiedCustomAd = this.f15792L;
            if (unifiedCustomAd == null || this.f15802w == null) {
                return;
            }
            unifiedCustomAd.setOrderOptimizeList(this.f15803x);
            this.f15792L.setAdOptimizePercent(this.f15802w.getOptimizePercent());
            af.a("BeiZis", "percent = " + this.f15802w.getOptimizePercent());
            this.f15799t.post(new Runnable() { // from class: com.beizi.fusion.work.nativead.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b bVar2 = b.this;
                    UnifiedCustomAd unifiedCustomAd2 = bVar2.f15792L;
                    int optimizeSize = bVar2.f15802w.getOptimizeSize();
                    View view2 = view;
                    b bVar3 = b.this;
                    unifiedCustomAd2.optimizeClickArea(optimizeSize, view2, bVar3.f15799t, bVar3.f15802w.getDirection());
                }
            });
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private AdSpacesBean.BuyerBean.OrderDataShakeViewBean a(List<AdSpacesBean.BuyerBean.OrderDataShakeViewBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataShakeViewBean orderDataShakeViewBean : list) {
                List<String> orderList = orderDataShakeViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataShakeViewBean;
                }
            }
        }
        return null;
    }

    private void a(final NativeAdResponse nativeAdResponse, final int i4, final int i5, int i6) {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean;
        try {
            if (!aQ() || (shakeViewBean = this.f15804y) == null || this.A == null || shakeViewBean.getPosition() == null) {
                return;
            }
            com.beizi.fusion.b.b bVar = this.f15365b;
            if (bVar != null) {
                bVar.G(this.f15804y.getShakeViewUuid());
                au();
            }
            AdSpacesBean.BuyerBean.OrderDataShakeViewBean a4 = a(this.f15804y.getOrderData(), this.f15792L.getAdId());
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = null;
            if (a4 != null && a4.getShakeView() != null) {
                shakeViewBean2 = a4.getShakeView();
            }
            if (i5 <= 0) {
                i5 = i6;
            }
            View a5 = this.A.a(av.b(this.f15793n, i4), av.b(this.f15793n, i5), this.f15804y.getPosition());
            if (a5 != null) {
                ViewGroup.LayoutParams layoutParams = a5.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                    layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                    layoutParams2.topMargin = marginLayoutParams.topMargin;
                    AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean3 = this.f15804y;
                    if (shakeViewBean3 != null && shakeViewBean3.getIsHideAnim() == 0) {
                        this.f15799t.addView(a5, layoutParams2);
                    }
                }
            }
            a(shakeViewBean2);
            this.A.a(new ag.a() { // from class: com.beizi.fusion.work.nativead.b.7
                @Override // com.beizi.fusion.g.ag.a
                public void a() {
                    AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean;
                    if (ax.a(b.this.f15800u)) {
                        int[] iArr = new int[2];
                        b.this.f15800u.getLocationOnScreen(iArr);
                        int[] a6 = al.a(i4 / 2, i5 / 2);
                        NativeAdUtil.handleClick(nativeAdResponse, b.this.f15800u, String.valueOf(a6[0]), String.valueOf(a6[1]), String.valueOf(a6[0] + iArr[0]), String.valueOf(a6[1] + iArr[1]), 2);
                        b bVar2 = b.this;
                        if (!bVar2.C || (coolShakeViewBean = bVar2.f15805z) == null) {
                            return;
                        }
                        bVar2.C = false;
                        bVar2.A.a(coolShakeViewBean);
                        b bVar3 = b.this;
                        at.a(bVar3.f15793n, bVar3.B, Long.valueOf(System.currentTimeMillis()));
                        aq.a().a(b.this.B, System.currentTimeMillis());
                    }
                }
            });
            AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean = this.f15805z;
            if (coolShakeViewBean != null) {
                this.A.a(coolShakeViewBean, this.B);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean == null) {
            shakeViewBean = this.f15804y;
        }
        if (this.f15805z == null) {
            this.C = true;
            this.A.a(shakeViewBean);
        } else if (b(shakeViewBean)) {
            this.A.a(this.f15805z);
        } else if (aN()) {
            this.A.a(this.f15805z);
        } else {
            this.C = true;
            this.A.a(shakeViewBean);
        }
    }
}
