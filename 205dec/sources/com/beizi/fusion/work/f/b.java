package com.beizi.fusion.work.f;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.beizi.ad.NativeAdListener;
import com.beizi.ad.NativeAdResponse;
import com.beizi.ad.UnifiedCustomAd;
import com.beizi.ad.internal.nativead.NativeAdEventListener;
import com.beizi.ad.internal.nativead.NativeAdShownListener;
import com.beizi.ad.internal.nativead.NativeAdUtil;
import com.beizi.ad.internal.utilities.ViewUtil;
import com.beizi.fusion.d.w;
import com.beizi.fusion.g.ag;
import com.beizi.fusion.g.am;
import com.beizi.fusion.g.ar;
import com.beizi.fusion.g.au;
import com.beizi.fusion.g.aw;
import com.beizi.fusion.g.ay;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BeiZiNativeUnifiedWorker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class b extends a {
    private String A;
    private boolean B;
    private boolean C;
    private boolean D;
    private int E;
    private int F;
    private int G;
    private View H;
    private String I;
    private boolean J;
    private Boolean K;

    /* renamed from: v  reason: collision with root package name */
    private UnifiedCustomAd f15534v;

    /* renamed from: w  reason: collision with root package name */
    private NativeAdResponse f15535w;

    /* renamed from: x  reason: collision with root package name */
    private AdSpacesBean.BuyerBean.ShakeViewBean f15536x;

    /* renamed from: y  reason: collision with root package name */
    private AdSpacesBean.BuyerBean.CoolShakeViewBean f15537y;

    /* renamed from: z  reason: collision with root package name */
    private ag f15538z;

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003c, code lost:
        r0.D = com.beizi.fusion.g.am.a(java.lang.Integer.parseInt(r4.getRate()));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public b(android.content.Context r1, long r2, com.beizi.fusion.model.AdSpacesBean.BuyerBean r4, com.beizi.fusion.model.AdSpacesBean.ForwardBean r5, com.beizi.fusion.d.e r6, int r7, boolean r8) {
        /*
            r0 = this;
            r0.<init>(r1, r2, r4, r5, r6, r7)
            r2 = 0
            r0.A = r2
            r3 = 0
            r0.B = r3
            r0.C = r3
            r0.D = r3
            r0.G = r3
            r0.I = r2
            r0.J = r8
            com.beizi.fusion.model.AdSpacesBean$BuyerBean r2 = r0.f15368e     // Catch: java.lang.Exception -> L4e
            java.util.List r2 = r2.getCallBackStrategy()     // Catch: java.lang.Exception -> L4e
            if (r2 == 0) goto L52
            int r4 = r2.size()     // Catch: java.lang.Exception -> L4e
            if (r4 <= 0) goto L52
            r4 = 1
            r0.C = r4     // Catch: java.lang.Exception -> L4e
        L24:
            int r4 = r2.size()     // Catch: java.lang.Exception -> L4e
            if (r3 >= r4) goto L52
            java.lang.Object r4 = r2.get(r3)     // Catch: java.lang.Exception -> L4e
            com.beizi.fusion.model.AdSpacesBean$CallBackStrategyBean r4 = (com.beizi.fusion.model.AdSpacesBean.CallBackStrategyBean) r4     // Catch: java.lang.Exception -> L4e
            java.lang.String r5 = "290.300"
            java.lang.String r6 = r4.getEventCode()     // Catch: java.lang.Exception -> L4e
            boolean r5 = r5.equalsIgnoreCase(r6)     // Catch: java.lang.Exception -> L4e
            if (r5 == 0) goto L4b
            java.lang.String r2 = r4.getRate()     // Catch: java.lang.Exception -> L4e
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Exception -> L4e
            boolean r2 = com.beizi.fusion.g.am.a(r2)     // Catch: java.lang.Exception -> L4e
            r0.D = r2     // Catch: java.lang.Exception -> L4e
            goto L52
        L4b:
            int r3 = r3 + 1
            goto L24
        L4e:
            r2 = move-exception
            r2.printStackTrace()
        L52:
            com.beizi.fusion.model.AdSpacesBean$BuyerBean r2 = r0.f15368e
            com.beizi.fusion.model.AdSpacesBean$BuyerBean$ShakeViewBean r2 = r2.getShakeView()
            r0.f15536x = r2
            if (r2 == 0) goto L72
            com.beizi.fusion.model.AdSpacesBean$BuyerBean$CoolShakeViewBean r2 = r2.getCoolShakeView()
            r0.f15537y = r2
            com.beizi.fusion.model.AdSpacesBean$BuyerBean$ShakeViewBean r2 = r0.f15536x
            int r2 = r2.getClkremove()
            r0.G = r2
            com.beizi.fusion.model.AdSpacesBean$BuyerBean$ShakeViewBean r2 = r0.f15536x
            java.lang.String r2 = r2.getTitle()
            r0.I = r2
        L72:
            com.beizi.fusion.g.ag r2 = new com.beizi.fusion.g.ag
            r2.<init>(r1)
            r0.f15538z = r2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "cool_"
            r1.append(r2)
            java.lang.String r2 = r0.f15372i
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.A = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.work.f.b.<init>(android.content.Context, long, com.beizi.fusion.model.AdSpacesBean$BuyerBean, com.beizi.fusion.model.AdSpacesBean$ForwardBean, com.beizi.fusion.d.e, int, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU() {
        Log.d("BeiZis", "showNativeUnifiedAd Callback --> onAdShow()");
        float l4 = aw.l(((a) this).f15525n);
        if (this.E < l4 / 4.0f || this.F < l4 / 7.0f) {
            return;
        }
        this.f15373j = com.beizi.fusion.f.a.ADSHOW;
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar != null && eVar.s() != 2) {
            this.f15367d.b(g());
        }
        if (((a) this).f15531t) {
            return;
        }
        ((a) this).f15531t = true;
        az();
        C();
        D();
        ah();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV() {
        ag agVar;
        AdSpacesBean.BuyerBean buyerBean;
        try {
            if (this.C && (buyerBean = this.f15368e) != null) {
                this.f15365b.P(buyerBean.getCallBackStrategyUuid());
                au();
            }
            F();
            if (!this.C || this.D) {
                com.beizi.fusion.d.e eVar = this.f15367d;
                if (eVar != null && eVar.s() != 2) {
                    this.f15367d.d(g());
                }
                E();
                ai();
                if (this.G != 0 && (agVar = this.f15538z) != null && this.H != null) {
                    agVar.c();
                    this.H.setVisibility(8);
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private boolean aW() {
        try {
            return System.currentTimeMillis() - ((a) this).f15525n.getPackageManager().getPackageInfo(((a) this).f15525n.getPackageName(), 0).firstInstallTime < this.f15537y.getUserProtectTime();
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    private boolean aX() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.f15536x;
        if (shakeViewBean == null) {
            return false;
        }
        return am.a(shakeViewBean.getRenderRate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY() {
        View downloadTextView;
        try {
            NativeAdResponse nativeAdResponse = this.f15535w;
            if (nativeAdResponse == null || nativeAdResponse.getApkInfo() == null || (downloadTextView = NativeAdUtil.getDownloadTextView(((a) this).f15525n, this.f15535w)) == null) {
                return;
            }
            downloadTextView.setLayoutParams(new FrameLayout.LayoutParams((((a) this).f15530s.getLayoutParams().width * 2) / 3, -2));
            ((a) this).f15530s.addView(downloadTextView, new FrameLayout.LayoutParams(-2, -2, 51));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.a
    protected void A() {
        if (!z() || this.f15534v == null) {
            return;
        }
        al();
    }

    @Override // com.beizi.fusion.work.f.a
    public void aG() {
        if (!aw.a("com.beizi.ad.BeiZi")) {
            t();
            this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.f.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.c(10151);
                }
            }, 10L);
            Log.e("BeiZis", "BeiZi sdk not import , will do nothing");
            return;
        }
        u();
        w.a(((a) this).f15525n, this.f15371h);
        v();
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + ((a) this).f15526o);
        long j4 = ((a) this).f15526o;
        if (j4 > 0) {
            this.f15376m.sendEmptyMessageDelayed(1, j4);
            return;
        }
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar == null || eVar.t() >= 1 || this.f15367d.s() == 2) {
            return;
        }
        l();
    }

    @Override // com.beizi.fusion.work.f.a
    public void aH() {
        ((a) this).f15530s = new FrameLayout(((a) this).f15525n);
        UnifiedCustomAd unifiedCustomAd = new UnifiedCustomAd(((a) this).f15525n, this.f15372i, new NativeAdListener() { // from class: com.beizi.fusion.work.f.b.2
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
                b bVar = b.this;
                bVar.K = Boolean.valueOf(bVar.f15534v.isDownloadApp());
                if (b.this.f15534v.getPrice() != null) {
                    try {
                        b bVar2 = b.this;
                        bVar2.a(Double.parseDouble(bVar2.f15534v.getPrice()));
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                b.this.y();
                if (nativeAdResponse != null) {
                    b.this.f15535w = nativeAdResponse;
                    b.this.aT();
                    return;
                }
                b.this.c(-991);
            }
        });
        this.f15534v = unifiedCustomAd;
        unifiedCustomAd.openAdInNativeBrowser(true);
        this.f15534v.loadAd();
    }

    @Override // com.beizi.fusion.work.f.a
    public String aI() {
        ArrayList<String> texts;
        NativeAdResponse nativeAdResponse = this.f15535w;
        if (nativeAdResponse != null) {
            String headline = nativeAdResponse.getHeadline();
            return (!TextUtils.isEmpty(headline) || (texts = this.f15535w.getTexts()) == null || texts.size() < 1) ? headline : texts.get(0);
        }
        return null;
    }

    @Override // com.beizi.fusion.work.f.a
    public String aJ() {
        ArrayList<String> texts;
        NativeAdResponse nativeAdResponse = this.f15535w;
        if (nativeAdResponse == null || TextUtils.isEmpty(nativeAdResponse.getBody())) {
            return null;
        }
        String body = this.f15535w.getBody();
        return (!TextUtils.isEmpty(body) || (texts = this.f15535w.getTexts()) == null || texts.size() < 2) ? body : texts.get(1);
    }

    @Override // com.beizi.fusion.work.f.a
    public String aK() {
        NativeAdResponse nativeAdResponse = this.f15535w;
        if (nativeAdResponse == null || TextUtils.isEmpty(nativeAdResponse.getIconUrl())) {
            return null;
        }
        return this.f15535w.getIconUrl();
    }

    @Override // com.beizi.fusion.work.f.a
    public String aL() {
        NativeAdResponse nativeAdResponse = this.f15535w;
        if (nativeAdResponse == null || TextUtils.isEmpty(nativeAdResponse.getImageUrl())) {
            return null;
        }
        return this.f15535w.getImageUrl();
    }

    @Override // com.beizi.fusion.work.f.a
    public List<String> aM() {
        NativeAdResponse nativeAdResponse = this.f15535w;
        if (nativeAdResponse != null) {
            if ((nativeAdResponse.getImageUrls() != null) && (this.f15535w.getImageUrls().size() > 0)) {
                return this.f15535w.getImageUrls();
            }
            return null;
        }
        return null;
    }

    @Override // com.beizi.fusion.work.f.a
    public int aN() {
        return 1;
    }

    @Override // com.beizi.fusion.work.f.a
    public String aO() {
        String str;
        ArrayList<String> texts;
        NativeAdResponse nativeAdResponse = this.f15535w;
        if (nativeAdResponse != null) {
            str = nativeAdResponse.getCallToAction();
            if (TextUtils.isEmpty(str) && (texts = this.f15535w.getTexts()) != null && texts.size() >= 3) {
                str = texts.get(2);
            }
        } else {
            str = null;
        }
        return TextUtils.isEmpty(str) ? "\u67e5\u770b\u8be6\u60c5" : str;
    }

    @Override // com.beizi.fusion.work.f.a
    public boolean aP() {
        return false;
    }

    @Override // com.beizi.fusion.work.f.a
    public ViewGroup aQ() {
        return ((a) this).f15530s;
    }

    @Override // com.beizi.fusion.work.f.a
    public void aS() {
        try {
            if (this.f15535w == null || this.J) {
                return;
            }
            LinearLayout linearLayout = new LinearLayout(((a) this).f15525n);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            FrameLayout createLogoImageView = ViewUtil.createLogoImageView(((a) this).f15525n, this.f15535w.getlogoUrl());
            createLogoImageView.setVisibility(0);
            linearLayout.addView(createLogoImageView, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            FrameLayout createAdImageView = ViewUtil.createAdImageView(((a) this).f15525n, this.f15535w.getAdUrl());
            createAdImageView.setVisibility(0);
            linearLayout.addView(createAdImageView, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) createAdImageView.getLayoutParams();
            layoutParams.setMargins(5, 0, 0, 0);
            layoutParams.gravity = 17;
            createAdImageView.setLayoutParams(layoutParams);
            ((a) this).f15530s.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 85));
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            int a4 = aw.a(((a) this).f15525n, 6.0f);
            layoutParams2.setMargins(0, 0, a4, a4);
            linearLayout.setLayoutParams(layoutParams2);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.f.a, com.beizi.fusion.work.a
    public String g() {
        return "BEIZI";
    }

    @Override // com.beizi.fusion.work.a
    public void m() {
        UnifiedCustomAd unifiedCustomAd = this.f15534v;
        if (unifiedCustomAd != null) {
            unifiedCustomAd.cancel();
        }
        ag agVar = this.f15538z;
        if (agVar != null) {
            agVar.c();
        }
    }

    @Override // com.beizi.fusion.work.a
    public String j() {
        UnifiedCustomAd unifiedCustomAd = this.f15534v;
        if (unifiedCustomAd == null) {
            return null;
        }
        return unifiedCustomAd.getPrice();
    }

    private boolean b(final AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        long longValue = ((Long) au.b(((a) this).f15525n, this.A, 0L)).longValue();
        if (longValue != 0) {
            long currentTimeMillis = System.currentTimeMillis() - longValue;
            if (currentTimeMillis < this.f15537y.getCoolTime()) {
                new Handler().postDelayed(new Runnable() { // from class: com.beizi.fusion.work.f.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.f15538z.a(shakeViewBean);
                    }
                }, this.f15537y.getCoolTime() - currentTimeMillis);
                return true;
            }
            ar.a().a(this.A);
        }
        return false;
    }

    @Override // com.beizi.fusion.work.f.a
    public void a(List<View> list) {
        try {
            if (((a) this).f15530s != null) {
                aS();
                ((a) this).f15530s.post(new Runnable() { // from class: com.beizi.fusion.work.f.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b bVar = b.this;
                            if (((a) bVar).f15530s != null) {
                                bVar.aY();
                                b bVar2 = b.this;
                                bVar2.E = ((a) bVar2).f15530s.getWidth();
                                b bVar3 = b.this;
                                bVar3.F = ((a) bVar3).f15530s.getHeight();
                                b bVar4 = b.this;
                                bVar4.a(bVar4.E, b.this.F, b.this.F);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                if (list != null && list.size() > 0) {
                    NativeAdUtil.registerTracking(this.f15535w, ((a) this).f15530s, list, new NativeAdEventListener() { // from class: com.beizi.fusion.work.f.b.4
                        @Override // com.beizi.ad.internal.nativead.NativeAdEventListener
                        public void onAdWasClicked() {
                            b.this.aV();
                        }

                        @Override // com.beizi.ad.internal.nativead.NativeAdEventListener
                        public void onAdWillLeaveApplication() {
                            Log.d("BeiZis", "showBeiZiNativeUnifiedAd onAdWillLeaveApplication");
                        }
                    });
                } else {
                    NativeAdUtil.registerTracking(this.f15535w, ((a) this).f15530s, new NativeAdEventListener() { // from class: com.beizi.fusion.work.f.b.5
                        @Override // com.beizi.ad.internal.nativead.NativeAdEventListener
                        public void onAdWasClicked() {
                            b.this.aV();
                        }

                        @Override // com.beizi.ad.internal.nativead.NativeAdEventListener
                        public void onAdWillLeaveApplication() {
                            Log.d("BeiZis", "showBeiZiNativeUnifiedAd onAdWillLeaveApplication");
                        }
                    });
                }
                NativeAdUtil.registerShow(this.f15535w, ((a) this).f15530s, new NativeAdShownListener() { // from class: com.beizi.fusion.work.f.b.6
                    @Override // com.beizi.ad.internal.nativead.NativeAdShownListener
                    public void onAdShown() {
                        b.this.aU();
                    }
                });
            }
        } catch (Throwable th) {
            th.printStackTrace();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i4, final int i5, int i6) {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean;
        try {
            if (!aX() || (shakeViewBean = this.f15536x) == null || this.f15538z == null || shakeViewBean.getPosition() == null) {
                return;
            }
            com.beizi.fusion.b.b bVar = this.f15365b;
            if (bVar != null) {
                bVar.G(this.f15536x.getShakeViewUuid());
                au();
            }
            AdSpacesBean.BuyerBean.OrderDataShakeViewBean a4 = a(this.f15536x.getOrderData(), this.f15534v.getAdId());
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = null;
            if (a4 != null && a4.getShakeView() != null) {
                shakeViewBean2 = a4.getShakeView();
            }
            if (i5 <= 0) {
                i5 = i6;
            }
            this.f15538z.a(this.K);
            View a5 = this.f15538z.a(aw.b(((a) this).f15525n, i4), aw.b(((a) this).f15525n, i5), this.f15536x.getPosition(), this.I);
            this.H = a5;
            if (a5 != null) {
                ViewGroup.LayoutParams layoutParams = a5.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                    layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                    layoutParams2.topMargin = marginLayoutParams.topMargin;
                    AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean3 = this.f15536x;
                    if (shakeViewBean3 != null && shakeViewBean3.getIsHideAnim() == 0) {
                        ((a) this).f15530s.addView(this.H, layoutParams2);
                    }
                }
            }
            a(shakeViewBean2);
            this.f15538z.a(new ag.a() { // from class: com.beizi.fusion.work.f.b.7
                @Override // com.beizi.fusion.g.ag.a
                public void a() {
                    try {
                        if (ay.a(((a) b.this).f15530s)) {
                            int[] iArr = new int[2];
                            ((a) b.this).f15530s.getLocationOnScreen(iArr);
                            int[] a6 = am.a(i4 / 2, i5 / 2);
                            NativeAdUtil.handleClick(b.this.f15535w, ((a) b.this).f15530s, String.valueOf(a6[0]), String.valueOf(a6[1]), String.valueOf(a6[0] + iArr[0]), String.valueOf(a6[1] + iArr[1]), 2);
                            if (!b.this.B || b.this.f15537y == null) {
                                return;
                            }
                            b.this.B = false;
                            b.this.f15538z.a(b.this.f15537y);
                            b bVar2 = b.this;
                            au.a(((a) bVar2).f15525n, bVar2.A, Long.valueOf(System.currentTimeMillis()));
                            ar.a().a(b.this.A, System.currentTimeMillis());
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            });
            AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean = this.f15537y;
            if (coolShakeViewBean != null) {
                this.f15538z.a(coolShakeViewBean, this.A);
            }
            this.f15538z.a(((a) this).f15530s);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean == null) {
            try {
                shakeViewBean = this.f15536x;
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
        if (this.f15537y == null) {
            this.B = true;
            this.f15538z.a(shakeViewBean);
        } else if (b(shakeViewBean)) {
            this.f15538z.a(this.f15537y);
        } else if (aW()) {
            this.f15538z.a(this.f15537y);
        } else {
            this.B = true;
            this.f15538z.a(shakeViewBean);
        }
    }
}
