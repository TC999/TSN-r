package com.beizi.fusion.work.p081f;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.selfAdManagerHolder;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.C3137at;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.p072g.NativeShakeUtil;
import com.beizi.fusion.p072g.RandomUtils;
import com.beizi.fusion.p072g.ShakeCoolConfig;
import com.beizi.fusion.p072g.ViewCheckUtil;
import com.beizi.fusion.work.AdWorker;
import com.beizi.p051ad.NativeAdListener;
import com.beizi.p051ad.NativeAdResponse;
import com.beizi.p051ad.UnifiedCustomAd;
import com.beizi.p051ad.internal.nativead.NativeAdEventListener;
import com.beizi.p051ad.internal.nativead.NativeAdShownListener;
import com.beizi.p051ad.internal.nativead.NativeAdUtil;
import com.beizi.p051ad.internal.utilities.ViewUtil;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.beizi.fusion.work.f.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BeiZiNativeUnifiedWorker extends BaseNativeUnifiedWorker {

    /* renamed from: A */
    private String f11964A;

    /* renamed from: B */
    private boolean f11965B;

    /* renamed from: C */
    private boolean f11966C;

    /* renamed from: D */
    private boolean f11967D;

    /* renamed from: E */
    private int f11968E;

    /* renamed from: F */
    private int f11969F;

    /* renamed from: G */
    private int f11970G;

    /* renamed from: H */
    private View f11971H;

    /* renamed from: I */
    private String f11972I;

    /* renamed from: v */
    private UnifiedCustomAd f11973v;

    /* renamed from: w */
    private NativeAdResponse f11974w;

    /* renamed from: x */
    private AdSpacesBean.BuyerBean.ShakeViewBean f11975x;

    /* renamed from: y */
    private AdSpacesBean.BuyerBean.CoolShakeViewBean f11976y;

    /* renamed from: z */
    private NativeShakeUtil f11977z;

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003a, code lost:
        r0.f11967D = com.beizi.fusion.p072g.RandomUtils.m48438a(java.lang.Integer.parseInt(r4.getRate()));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BeiZiNativeUnifiedWorker(android.content.Context r1, long r2, com.beizi.fusion.model.AdSpacesBean.BuyerBean r4, com.beizi.fusion.model.AdSpacesBean.ForwardBean r5, com.beizi.fusion.p066d.BaseManager r6, int r7) {
        /*
            r0 = this;
            r0.<init>(r1, r2, r4, r5, r6, r7)
            r2 = 0
            r0.f11964A = r2
            r3 = 0
            r0.f11965B = r3
            r0.f11966C = r3
            r0.f11967D = r3
            r0.f11970G = r3
            r0.f11972I = r2
            com.beizi.fusion.model.AdSpacesBean$BuyerBean r2 = r0.f11798e     // Catch: java.lang.Exception -> L4c
            java.util.List r2 = r2.getCallBackStrategy()     // Catch: java.lang.Exception -> L4c
            if (r2 == 0) goto L50
            int r4 = r2.size()     // Catch: java.lang.Exception -> L4c
            if (r4 <= 0) goto L50
            r4 = 1
            r0.f11966C = r4     // Catch: java.lang.Exception -> L4c
        L22:
            int r4 = r2.size()     // Catch: java.lang.Exception -> L4c
            if (r3 >= r4) goto L50
            java.lang.Object r4 = r2.get(r3)     // Catch: java.lang.Exception -> L4c
            com.beizi.fusion.model.AdSpacesBean$CallBackStrategyBean r4 = (com.beizi.fusion.model.AdSpacesBean.CallBackStrategyBean) r4     // Catch: java.lang.Exception -> L4c
            java.lang.String r5 = "290.300"
            java.lang.String r6 = r4.getEventCode()     // Catch: java.lang.Exception -> L4c
            boolean r5 = r5.equalsIgnoreCase(r6)     // Catch: java.lang.Exception -> L4c
            if (r5 == 0) goto L49
            java.lang.String r2 = r4.getRate()     // Catch: java.lang.Exception -> L4c
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Exception -> L4c
            boolean r2 = com.beizi.fusion.p072g.RandomUtils.m48438a(r2)     // Catch: java.lang.Exception -> L4c
            r0.f11967D = r2     // Catch: java.lang.Exception -> L4c
            goto L50
        L49:
            int r3 = r3 + 1
            goto L22
        L4c:
            r2 = move-exception
            r2.printStackTrace()
        L50:
            com.beizi.fusion.model.AdSpacesBean$BuyerBean r2 = r0.f11798e
            com.beizi.fusion.model.AdSpacesBean$BuyerBean$ShakeViewBean r2 = r2.getShakeView()
            r0.f11975x = r2
            if (r2 == 0) goto L70
            com.beizi.fusion.model.AdSpacesBean$BuyerBean$CoolShakeViewBean r2 = r2.getCoolShakeView()
            r0.f11976y = r2
            com.beizi.fusion.model.AdSpacesBean$BuyerBean$ShakeViewBean r2 = r0.f11975x
            int r2 = r2.getClkremove()
            r0.f11970G = r2
            com.beizi.fusion.model.AdSpacesBean$BuyerBean$ShakeViewBean r2 = r0.f11975x
            java.lang.String r2 = r2.getTitle()
            r0.f11972I = r2
        L70:
            com.beizi.fusion.g.ag r2 = new com.beizi.fusion.g.ag
            r2.<init>(r1)
            r0.f11977z = r2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "cool_"
            r1.append(r2)
            java.lang.String r2 = r0.f11802i
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.f11964A = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.work.p081f.BeiZiNativeUnifiedWorker.<init>(android.content.Context, long, com.beizi.fusion.model.AdSpacesBean$BuyerBean, com.beizi.fusion.model.AdSpacesBean$ForwardBean, com.beizi.fusion.d.e, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aU */
    public void m47572aU() {
        Log.d("BeiZis", "showNativeUnifiedAd Callback --> onAdShow()");
        float m48286l = C3138av.m48286l(((BaseNativeUnifiedWorker) this).f11955n);
        if (this.f11968E < m48286l / 4.0f || this.f11969F < m48286l / 7.0f) {
            return;
        }
        this.f11803j = AdStatus.ADSHOW;
        BaseManager baseManager = this.f11797d;
        if (baseManager != null && baseManager.m48668s() != 2) {
            this.f11797d.m48710b(mo46059g());
        }
        if (((BaseNativeUnifiedWorker) this).f11961t) {
            return;
        }
        ((BaseNativeUnifiedWorker) this).f11961t = true;
        mo46072az();
        m47992C();
        m47991D();
        m47942ah();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aV */
    public void m47571aV() {
        NativeShakeUtil nativeShakeUtil;
        AdSpacesBean.BuyerBean buyerBean;
        try {
            if (this.f11966C && (buyerBean = this.f11798e) != null) {
                this.f11795b.m48936P(buyerBean.getCallBackStrategyUuid());
                m47929au();
            }
            m47989F();
            if (!this.f11966C || this.f11967D) {
                BaseManager baseManager = this.f11797d;
                if (baseManager != null && baseManager.m48668s() != 2) {
                    this.f11797d.m48700d(mo46059g());
                }
                m47990E();
                m47941ai();
                if (this.f11970G != 0 && (nativeShakeUtil = this.f11977z) != null && this.f11971H != null) {
                    nativeShakeUtil.m48468c();
                    this.f11971H.setVisibility(8);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: aW */
    private boolean m47570aW() {
        try {
            return System.currentTimeMillis() - ((BaseNativeUnifiedWorker) this).f11955n.getPackageManager().getPackageInfo(((BaseNativeUnifiedWorker) this).f11955n.getPackageName(), 0).firstInstallTime < this.f11976y.getUserProtectTime();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: aX */
    private boolean m47569aX() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.f11975x;
        if (shakeViewBean == null) {
            return false;
        }
        return RandomUtils.m48438a(shakeViewBean.getRenderRate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aY */
    public void m47568aY() {
        View downloadTextView;
        try {
            NativeAdResponse nativeAdResponse = this.f11974w;
            if (nativeAdResponse == null || nativeAdResponse.getApkInfo() == null || (downloadTextView = NativeAdUtil.getDownloadTextView(((BaseNativeUnifiedWorker) this).f11955n, this.f11974w)) == null) {
                return;
            }
            downloadTextView.setLayoutParams(new FrameLayout.LayoutParams((((BaseNativeUnifiedWorker) this).f11960s.getLayoutParams().width * 2) / 3, -2));
            ((BaseNativeUnifiedWorker) this).f11960s.addView(downloadTextView, new FrameLayout.LayoutParams(-2, -2, 51));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: A */
    protected void mo46197A() {
        if (!m47909z() || this.f11973v == null) {
            return;
        }
        m47938al();
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aG */
    public void mo47519aG() {
        if (!C3138av.m48301a("com.beizi.ad.BeiZi")) {
            m47915t();
            this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.f.b.1
                @Override // java.lang.Runnable
                public void run() {
                    BeiZiNativeUnifiedWorker.this.m47921c(10151);
                }
            }, 10L);
            Log.e("BeiZis", "BeiZi sdk not import , will do nothing");
            return;
        }
        m47914u();
        selfAdManagerHolder.m48575a(((BaseNativeUnifiedWorker) this).f11955n, this.f11801h);
        m47913v();
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + ((BaseNativeUnifiedWorker) this).f11956o);
        long j = ((BaseNativeUnifiedWorker) this).f11956o;
        if (j > 0) {
            this.f11806m.sendEmptyMessageDelayed(1, j);
            return;
        }
        BaseManager baseManager = this.f11797d;
        if (baseManager == null || baseManager.m48667t() >= 1 || this.f11797d.m48668s() == 2) {
            return;
        }
        mo46050l();
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aH */
    public void mo47518aH() {
        ((BaseNativeUnifiedWorker) this).f11960s = new FrameLayout(((BaseNativeUnifiedWorker) this).f11955n);
        UnifiedCustomAd unifiedCustomAd = new UnifiedCustomAd(((BaseNativeUnifiedWorker) this).f11955n, this.f11802i, new NativeAdListener() { // from class: com.beizi.fusion.work.f.b.2
            @Override // com.beizi.p051ad.NativeAdListener
            public void onAdClick() {
                Log.d("BeiZis", "showBeiZiNativeUnifiedAd onAdClick()");
            }

            @Override // com.beizi.p051ad.NativeAdListener
            public void onAdFailed(int i) {
                Log.d("BeiZis", "showBeiZiNativeUnifiedAd onAdFailed: " + i);
                BeiZiNativeUnifiedWorker.this.m47961a(String.valueOf(i), i);
            }

            @Override // com.beizi.p051ad.NativeAdListener
            public void onAdLoaded(NativeAdResponse nativeAdResponse) {
                Log.d("BeiZis", "showBeiZiNativeUnifiedAd onAdLoaded()");
                ((AdWorker) BeiZiNativeUnifiedWorker.this).f11803j = AdStatus.ADLOAD;
                if (BeiZiNativeUnifiedWorker.this.f11973v.getPrice() != null) {
                    try {
                        BeiZiNativeUnifiedWorker beiZiNativeUnifiedWorker = BeiZiNativeUnifiedWorker.this;
                        beiZiNativeUnifiedWorker.m47967a(Double.parseDouble(beiZiNativeUnifiedWorker.f11973v.getPrice()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                BeiZiNativeUnifiedWorker.this.m47910y();
                if (nativeAdResponse != null) {
                    BeiZiNativeUnifiedWorker.this.f11974w = nativeAdResponse;
                    BeiZiNativeUnifiedWorker.this.m47588aT();
                    return;
                }
                BeiZiNativeUnifiedWorker.this.m47921c(-991);
            }
        });
        this.f11973v = unifiedCustomAd;
        unifiedCustomAd.openAdInNativeBrowser(true);
        this.f11973v.loadAd();
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aI */
    public String mo47517aI() {
        ArrayList<String> texts;
        NativeAdResponse nativeAdResponse = this.f11974w;
        if (nativeAdResponse != null) {
            String headline = nativeAdResponse.getHeadline();
            return (!TextUtils.isEmpty(headline) || (texts = this.f11974w.getTexts()) == null || texts.size() < 1) ? headline : texts.get(0);
        }
        return null;
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aJ */
    public String mo47516aJ() {
        ArrayList<String> texts;
        NativeAdResponse nativeAdResponse = this.f11974w;
        if (nativeAdResponse == null || TextUtils.isEmpty(nativeAdResponse.getBody())) {
            return null;
        }
        String body = this.f11974w.getBody();
        return (!TextUtils.isEmpty(body) || (texts = this.f11974w.getTexts()) == null || texts.size() < 2) ? body : texts.get(1);
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aK */
    public String mo47515aK() {
        NativeAdResponse nativeAdResponse = this.f11974w;
        if (nativeAdResponse == null || TextUtils.isEmpty(nativeAdResponse.getIconUrl())) {
            return null;
        }
        return this.f11974w.getIconUrl();
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aL */
    public String mo47514aL() {
        NativeAdResponse nativeAdResponse = this.f11974w;
        if (nativeAdResponse == null || TextUtils.isEmpty(nativeAdResponse.getImageUrl())) {
            return null;
        }
        return this.f11974w.getImageUrl();
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aM */
    public List<String> mo47513aM() {
        NativeAdResponse nativeAdResponse = this.f11974w;
        if (nativeAdResponse != null) {
            if ((nativeAdResponse.getImageUrls() != null) && (this.f11974w.getImageUrls().size() > 0)) {
                return this.f11974w.getImageUrls();
            }
            return null;
        }
        return null;
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aN */
    public int mo47512aN() {
        return 1;
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aO */
    public String mo47511aO() {
        String str;
        ArrayList<String> texts;
        NativeAdResponse nativeAdResponse = this.f11974w;
        if (nativeAdResponse != null) {
            str = nativeAdResponse.getCallToAction();
            if (TextUtils.isEmpty(str) && (texts = this.f11974w.getTexts()) != null && texts.size() >= 3) {
                str = texts.get(2);
            }
        } else {
            str = null;
        }
        return TextUtils.isEmpty(str) ? "查看详情" : str;
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aP */
    public boolean mo47510aP() {
        return false;
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aQ */
    public ViewGroup mo47509aQ() {
        return ((BaseNativeUnifiedWorker) this).f11960s;
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aS */
    public void mo47507aS() {
        try {
            if (this.f11974w == null) {
                return;
            }
            LinearLayout linearLayout = new LinearLayout(((BaseNativeUnifiedWorker) this).f11955n);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            FrameLayout createLogoImageView = ViewUtil.createLogoImageView(((BaseNativeUnifiedWorker) this).f11955n, this.f11974w.getlogoUrl());
            createLogoImageView.setVisibility(0);
            linearLayout.addView(createLogoImageView, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            FrameLayout createAdImageView = ViewUtil.createAdImageView(((BaseNativeUnifiedWorker) this).f11955n, this.f11974w.getAdUrl());
            createAdImageView.setVisibility(0);
            linearLayout.addView(createAdImageView, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) createAdImageView.getLayoutParams();
            layoutParams.setMargins(5, 0, 0, 0);
            layoutParams.gravity = 17;
            createAdImageView.setLayoutParams(layoutParams);
            ((BaseNativeUnifiedWorker) this).f11960s.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 85));
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            int m48304a = C3138av.m48304a(((BaseNativeUnifiedWorker) this).f11955n, 6.0f);
            layoutParams2.setMargins(0, 0, m48304a, m48304a);
            linearLayout.setLayoutParams(layoutParams2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker, com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "BEIZI";
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: m */
    public void mo46173m() {
        UnifiedCustomAd unifiedCustomAd = this.f11973v;
        if (unifiedCustomAd != null) {
            unifiedCustomAd.cancel();
        }
        NativeShakeUtil nativeShakeUtil = this.f11977z;
        if (nativeShakeUtil != null) {
            nativeShakeUtil.m48468c();
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: j */
    public String mo46054j() {
        UnifiedCustomAd unifiedCustomAd = this.f11973v;
        if (unifiedCustomAd == null) {
            return null;
        }
        return unifiedCustomAd.getPrice();
    }

    /* renamed from: b */
    private boolean m47567b(final AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        long longValue = ((Long) C3137at.m48313b(((BaseNativeUnifiedWorker) this).f11955n, this.f11964A, 0L)).longValue();
        if (longValue != 0) {
            long currentTimeMillis = System.currentTimeMillis() - longValue;
            if (currentTimeMillis < this.f11976y.getCoolTime()) {
                new Handler().postDelayed(new Runnable() { // from class: com.beizi.fusion.work.f.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        BeiZiNativeUnifiedWorker.this.f11977z.m48478a(shakeViewBean);
                    }
                }, this.f11976y.getCoolTime() - currentTimeMillis);
                return true;
            }
            ShakeCoolConfig.m48369a().m48368a(this.f11964A);
        }
        return false;
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: a */
    public void mo47520a(List<View> list) {
        try {
            if (((BaseNativeUnifiedWorker) this).f11960s != null) {
                mo47507aS();
                ((BaseNativeUnifiedWorker) this).f11960s.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.beizi.fusion.work.f.b.3
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        try {
                            FrameLayout frameLayout = ((BaseNativeUnifiedWorker) BeiZiNativeUnifiedWorker.this).f11960s;
                            if (frameLayout != null) {
                                frameLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                                BeiZiNativeUnifiedWorker.this.m47568aY();
                                BeiZiNativeUnifiedWorker beiZiNativeUnifiedWorker = BeiZiNativeUnifiedWorker.this;
                                beiZiNativeUnifiedWorker.f11968E = ((BaseNativeUnifiedWorker) beiZiNativeUnifiedWorker).f11960s.getWidth();
                                BeiZiNativeUnifiedWorker beiZiNativeUnifiedWorker2 = BeiZiNativeUnifiedWorker.this;
                                beiZiNativeUnifiedWorker2.f11969F = ((BaseNativeUnifiedWorker) beiZiNativeUnifiedWorker2).f11960s.getHeight();
                                BeiZiNativeUnifiedWorker beiZiNativeUnifiedWorker3 = BeiZiNativeUnifiedWorker.this;
                                beiZiNativeUnifiedWorker3.m47583a(beiZiNativeUnifiedWorker3.f11968E, BeiZiNativeUnifiedWorker.this.f11969F, BeiZiNativeUnifiedWorker.this.f11969F);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                if (list != null && list.size() > 0) {
                    NativeAdUtil.registerTracking(this.f11974w, ((BaseNativeUnifiedWorker) this).f11960s, list, new NativeAdEventListener() { // from class: com.beizi.fusion.work.f.b.4
                        @Override // com.beizi.p051ad.internal.nativead.NativeAdEventListener
                        public void onAdWasClicked() {
                            BeiZiNativeUnifiedWorker.this.m47571aV();
                        }

                        @Override // com.beizi.p051ad.internal.nativead.NativeAdEventListener
                        public void onAdWillLeaveApplication() {
                            Log.d("BeiZis", "showBeiZiNativeUnifiedAd onAdWillLeaveApplication");
                        }
                    });
                } else {
                    NativeAdUtil.registerTracking(this.f11974w, ((BaseNativeUnifiedWorker) this).f11960s, new NativeAdEventListener() { // from class: com.beizi.fusion.work.f.b.5
                        @Override // com.beizi.p051ad.internal.nativead.NativeAdEventListener
                        public void onAdWasClicked() {
                            BeiZiNativeUnifiedWorker.this.m47571aV();
                        }

                        @Override // com.beizi.p051ad.internal.nativead.NativeAdEventListener
                        public void onAdWillLeaveApplication() {
                            Log.d("BeiZis", "showBeiZiNativeUnifiedAd onAdWillLeaveApplication");
                        }
                    });
                }
                NativeAdUtil.registerShow(this.f11974w, ((BaseNativeUnifiedWorker) this).f11960s, new NativeAdShownListener() { // from class: com.beizi.fusion.work.f.b.6
                    @Override // com.beizi.p051ad.internal.nativead.NativeAdShownListener
                    public void onAdShown() {
                        BeiZiNativeUnifiedWorker.this.m47572aU();
                    }
                });
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private AdSpacesBean.BuyerBean.OrderDataShakeViewBean m47573a(List<AdSpacesBean.BuyerBean.OrderDataShakeViewBean> list, String str) {
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
    /* renamed from: a */
    public void m47583a(final int i, final int i2, int i3) {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean;
        try {
            if (!m47569aX() || (shakeViewBean = this.f11975x) == null || this.f11977z == null || shakeViewBean.getPosition() == null) {
                return;
            }
            EventBean eventBean = this.f11795b;
            if (eventBean != null) {
                eventBean.m48954G(this.f11975x.getShakeViewUuid());
                m47929au();
            }
            AdSpacesBean.BuyerBean.OrderDataShakeViewBean m47573a = m47573a(this.f11975x.getOrderData(), this.f11973v.getAdId());
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = null;
            if (m47573a != null && m47573a.getShakeView() != null) {
                shakeViewBean2 = m47573a.getShakeView();
            }
            if (i2 <= 0) {
                i2 = i3;
            }
            View m48488a = this.f11977z.m48488a(C3138av.m48298b(((BaseNativeUnifiedWorker) this).f11955n, i), C3138av.m48298b(((BaseNativeUnifiedWorker) this).f11955n, i2), this.f11975x.getPosition(), this.f11972I);
            this.f11971H = m48488a;
            if (m48488a != null) {
                ViewGroup.LayoutParams layoutParams = m48488a.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                    layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                    layoutParams2.topMargin = marginLayoutParams.topMargin;
                    AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean3 = this.f11975x;
                    if (shakeViewBean3 != null && shakeViewBean3.getIsHideAnim() == 0) {
                        ((BaseNativeUnifiedWorker) this).f11960s.addView(this.f11971H, layoutParams2);
                    }
                }
            }
            m47582a(shakeViewBean2);
            this.f11977z.m48486a(new NativeShakeUtil.InterfaceC3118a() { // from class: com.beizi.fusion.work.f.b.7
                @Override // com.beizi.fusion.p072g.NativeShakeUtil.InterfaceC3118a
                /* renamed from: a */
                public void mo46796a() {
                    try {
                        if (ViewCheckUtil.m48281a(((BaseNativeUnifiedWorker) BeiZiNativeUnifiedWorker.this).f11960s)) {
                            int[] iArr = new int[2];
                            ((BaseNativeUnifiedWorker) BeiZiNativeUnifiedWorker.this).f11960s.getLocationOnScreen(iArr);
                            int[] m48437a = RandomUtils.m48437a(i / 2, i2 / 2);
                            NativeAdUtil.handleClick(BeiZiNativeUnifiedWorker.this.f11974w, ((BaseNativeUnifiedWorker) BeiZiNativeUnifiedWorker.this).f11960s, String.valueOf(m48437a[0]), String.valueOf(m48437a[1]), String.valueOf(m48437a[0] + iArr[0]), String.valueOf(m48437a[1] + iArr[1]), 2);
                            if (!BeiZiNativeUnifiedWorker.this.f11965B || BeiZiNativeUnifiedWorker.this.f11976y == null) {
                                return;
                            }
                            BeiZiNativeUnifiedWorker.this.f11965B = false;
                            BeiZiNativeUnifiedWorker.this.f11977z.m48480a(BeiZiNativeUnifiedWorker.this.f11976y);
                            BeiZiNativeUnifiedWorker beiZiNativeUnifiedWorker = BeiZiNativeUnifiedWorker.this;
                            C3137at.m48315a(((BaseNativeUnifiedWorker) beiZiNativeUnifiedWorker).f11955n, beiZiNativeUnifiedWorker.f11964A, Long.valueOf(System.currentTimeMillis()));
                            ShakeCoolConfig.m48369a().m48367a(BeiZiNativeUnifiedWorker.this.f11964A, System.currentTimeMillis());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean = this.f11976y;
            if (coolShakeViewBean != null) {
                this.f11977z.m48479a(coolShakeViewBean, this.f11964A);
            }
            this.f11977z.m48487a(((BaseNativeUnifiedWorker) this).f11960s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m47582a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean == null) {
            try {
                shakeViewBean = this.f11975x;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (this.f11976y == null) {
            this.f11965B = true;
            this.f11977z.m48478a(shakeViewBean);
        } else if (m47567b(shakeViewBean)) {
            this.f11977z.m48480a(this.f11976y);
        } else if (m47570aW()) {
            this.f11977z.m48480a(this.f11976y);
        } else {
            this.f11965B = true;
            this.f11977z.m48478a(shakeViewBean);
        }
    }
}
