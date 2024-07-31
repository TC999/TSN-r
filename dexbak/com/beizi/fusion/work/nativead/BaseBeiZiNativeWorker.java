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
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p066d.AdShowObserver;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.CompeteStatus;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3137at;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.p072g.NativeShakeUtil;
import com.beizi.fusion.p072g.RandomUtils;
import com.beizi.fusion.p072g.ShakeCoolConfig;
import com.beizi.fusion.p072g.ViewCheckUtil;
import com.beizi.fusion.widget.dialog.dislike.DislikeDialog;
import com.beizi.fusion.work.AdWorker;
import com.beizi.fusion.work.splash.SplashContainer;
import com.beizi.p051ad.NativeAdListener;
import com.beizi.p051ad.NativeAdResponse;
import com.beizi.p051ad.UnifiedCustomAd;
import com.beizi.p051ad.internal.nativead.NativeAdEventListener;
import com.beizi.p051ad.internal.nativead.NativeAdShownListener;
import com.beizi.p051ad.internal.nativead.NativeAdUtil;
import com.beizi.p051ad.internal.utilities.ImageManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* renamed from: com.beizi.fusion.work.nativead.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BaseBeiZiNativeWorker extends AdWorker implements AdShowObserver {

    /* renamed from: A */
    protected NativeShakeUtil f12284A;

    /* renamed from: D */
    protected AdSpacesBean.BuyerBean.DislikeConfigBean f12287D;

    /* renamed from: E */
    protected AdSpacesBean.BuyerBean.DislikeConfigBean f12288E;

    /* renamed from: K */
    protected NativeAdResponse f12294K;

    /* renamed from: L */
    protected UnifiedCustomAd f12295L;

    /* renamed from: M */
    protected View f12296M;

    /* renamed from: N */
    protected AdSpacesBean.ComplainBean f12297N;

    /* renamed from: n */
    protected Context f12301n;

    /* renamed from: o */
    protected String f12302o;

    /* renamed from: p */
    protected long f12303p;

    /* renamed from: q */
    protected long f12304q;

    /* renamed from: r */
    protected float f12305r;

    /* renamed from: s */
    protected float f12306s;

    /* renamed from: t */
    protected ViewGroup f12307t;

    /* renamed from: u */
    protected View f12308u;

    /* renamed from: v */
    protected List<AdSpacesBean.RenderViewBean> f12309v;

    /* renamed from: w */
    protected AdSpacesBean.RenderViewBean f12310w;

    /* renamed from: x */
    protected List<Pair<String, Integer>> f12311x;

    /* renamed from: y */
    protected AdSpacesBean.BuyerBean.ShakeViewBean f12312y;

    /* renamed from: z */
    protected AdSpacesBean.BuyerBean.CoolShakeViewBean f12313z;

    /* renamed from: B */
    protected String f12285B = null;

    /* renamed from: C */
    protected boolean f12286C = false;

    /* renamed from: F */
    protected float f12289F = 0.0f;

    /* renamed from: G */
    protected float f12290G = 0.0f;

    /* renamed from: H */
    protected float f12291H = 0.0f;

    /* renamed from: I */
    protected float f12292I = 0.0f;

    /* renamed from: J */
    protected String f12293J = null;

    /* renamed from: O */
    protected String f12298O = null;

    /* renamed from: P */
    protected boolean f12299P = false;

    /* renamed from: Q */
    protected boolean f12300Q = false;

    public BaseBeiZiNativeWorker(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager, float f, float f2) {
        this.f12301n = context;
        this.f12302o = str;
        this.f12303p = j;
        this.f12304q = j2;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        this.f12305r = f;
        this.f12306s = f2;
        this.f12307t = new SplashContainer(context);
        m47917r();
    }

    /* renamed from: aN */
    private boolean m46965aN() {
        try {
            return System.currentTimeMillis() - this.f12301n.getPackageManager().getPackageInfo(this.f12301n.getPackageName(), 0).firstInstallTime < this.f12313z.getUserProtectTime();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: aO */
    private void m46964aO() {
        AdSpacesBean.BuyerBean.DislikeConfigBean m46957b;
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfig = this.f11798e.getDislikeConfig();
        this.f12287D = dislikeConfig;
        if (dislikeConfig == null || (m46957b = m46957b(dislikeConfig.getOrderData(), this.f12295L.getAdId())) == null) {
            return;
        }
        this.f12288E = m46957b;
    }

    /* renamed from: aP */
    private boolean m46963aP() {
        try {
            AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean = this.f12288E;
            if (dislikeConfigBean != null) {
                return dislikeConfigBean.getIsShowDialog() == 1;
            }
            AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean2 = this.f12287D;
            return dislikeConfigBean2 != null && dislikeConfigBean2.getIsShowDialog() == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* renamed from: aQ */
    private boolean m46962aQ() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.f12312y;
        if (shakeViewBean == null) {
            return false;
        }
        return RandomUtils.m48438a(shakeViewBean.getRenderRate());
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: A */
    protected void mo46197A() {
        if (!m47909z() || this.f12295L == null) {
            return;
        }
        m47938al();
    }

    /* renamed from: a */
    public void mo46919a(NativeAdResponse nativeAdResponse) {
    }

    /* renamed from: aG */
    public void m46972aG() {
        try {
            if (m47970Y()) {
                BaseManager baseManager = this.f11797d;
                if (baseManager == null) {
                    return;
                }
                Map<String, AdWorker> m48669r = baseManager.m48669r();
                Log.d("BeiZis", mo46059g() + " NativeAdWorker:" + m48669r.toString());
                m47969Z();
                CompeteStatus competeStatus = this.f11800g;
                if (competeStatus == CompeteStatus.SUCCESS) {
                    if (this.f12308u != null) {
                        this.f11797d.m48726a(mo46059g(), this.f12308u);
                    } else {
                        this.f11797d.m48754a(10140);
                    }
                } else if (competeStatus == CompeteStatus.FAIL) {
                    Log.d("BeiZis", "other worker shown," + mo46059g() + " remove");
                }
            } else {
                m47980O();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: aH */
    public void m46971aH() {
        View view;
        try {
            NativeAdResponse nativeAdResponse = this.f12294K;
            if (nativeAdResponse != null && (view = this.f12296M) != null) {
                NativeAdUtil.registerTracking(nativeAdResponse, view, new NativeAdEventListener() { // from class: com.beizi.fusion.work.nativead.b.5

                    /* renamed from: a */
                    boolean f12321a = false;

                    @Override // com.beizi.p051ad.internal.nativead.NativeAdEventListener
                    public void onAdWasClicked() {
                        Log.d("BeiZis", "showBeiZiNativeAd onAdWasClicked");
                        BaseBeiZiNativeWorker baseBeiZiNativeWorker = BaseBeiZiNativeWorker.this;
                        if (baseBeiZiNativeWorker.f12299P && ((AdWorker) baseBeiZiNativeWorker).f11798e != null) {
                            ((AdWorker) BaseBeiZiNativeWorker.this).f11795b.m48936P(((AdWorker) BaseBeiZiNativeWorker.this).f11798e.getCallBackStrategyUuid());
                            BaseBeiZiNativeWorker.this.m47929au();
                        }
                        BaseBeiZiNativeWorker.this.m47989F();
                        BaseBeiZiNativeWorker baseBeiZiNativeWorker2 = BaseBeiZiNativeWorker.this;
                        if (!baseBeiZiNativeWorker2.f12299P || baseBeiZiNativeWorker2.f12300Q) {
                            if (((AdWorker) baseBeiZiNativeWorker2).f11797d != null && ((AdWorker) BaseBeiZiNativeWorker.this).f11797d.m48668s() != 2) {
                                ((AdWorker) BaseBeiZiNativeWorker.this).f11797d.m48700d(BaseBeiZiNativeWorker.this.mo46059g());
                            }
                            BaseBeiZiNativeWorker.this.m47990E();
                            BaseBeiZiNativeWorker.this.m47941ai();
                            UnifiedCustomAd unifiedCustomAd = BaseBeiZiNativeWorker.this.f12295L;
                            if (unifiedCustomAd != null) {
                                unifiedCustomAd.setTouchAreaNormal();
                            }
                        }
                    }

                    @Override // com.beizi.p051ad.internal.nativead.NativeAdEventListener
                    public void onAdWillLeaveApplication() {
                        Log.d("BeiZis", "showBeiZiNativeAd onAdWillLeaveApplication");
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: aI */
    public void m46970aI() {
        View view;
        try {
            NativeAdResponse nativeAdResponse = this.f12294K;
            if (nativeAdResponse != null && (view = this.f12296M) != null) {
                NativeAdUtil.registerShow(nativeAdResponse, view, new NativeAdShownListener() { // from class: com.beizi.fusion.work.nativead.b.6
                    @Override // com.beizi.p051ad.internal.nativead.NativeAdShownListener
                    public void onAdShown() {
                        Log.d("BeiZis", "showBeiZiNativeAd onAdShown()");
                        ((AdWorker) BaseBeiZiNativeWorker.this).f11803j = AdStatus.ADSHOW;
                        if (((AdWorker) BaseBeiZiNativeWorker.this).f11797d != null && ((AdWorker) BaseBeiZiNativeWorker.this).f11797d.m48668s() != 2) {
                            ((AdWorker) BaseBeiZiNativeWorker.this).f11797d.m48710b(BaseBeiZiNativeWorker.this.mo46059g());
                        }
                        BaseBeiZiNativeWorker.this.m47992C();
                        BaseBeiZiNativeWorker.this.m47991D();
                        BaseBeiZiNativeWorker.this.m47942ah();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: aJ */
    public boolean m46969aJ() {
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean = this.f12288E;
        if (dislikeConfigBean != null) {
            return dislikeConfigBean.getIsHide() == 0;
        }
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean2 = this.f12287D;
        return dislikeConfigBean2 != null && dislikeConfigBean2.getIsHide() == 0;
    }

    /* renamed from: aK */
    public boolean m46968aK() {
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean = this.f12288E;
        if (dislikeConfigBean != null) {
            return RandomUtils.m48438a(dislikeConfigBean.getRandomNum());
        }
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean2 = this.f12287D;
        if (dislikeConfigBean2 != null) {
            return RandomUtils.m48438a(dislikeConfigBean2.getRandomNum());
        }
        return false;
    }

    /* renamed from: aL */
    public boolean m46967aL() {
        long longValue = ((Long) C3137at.m48313b(this.f12301n, this.f12293J, 0L)).longValue();
        return this.f12287D == null || longValue == 0 || System.currentTimeMillis() - longValue >= this.f12287D.getCoolTime();
    }

    /* renamed from: aM */
    public void m46966aM() {
        try {
            if (!m46963aP()) {
                BaseManager baseManager = this.f11797d;
                if (baseManager != null && baseManager.m48668s() != 2) {
                    this.f11797d.m48709b(mo46059g(), this.f12308u);
                }
                m47988G();
                return;
            }
            DislikeDialog.C3235a c3235a = new DislikeDialog.C3235a(this.f12301n);
            c3235a.m48010a(new DislikeDialog.InterfaceC3238c() { // from class: com.beizi.fusion.work.nativead.b.9
                @Override // com.beizi.fusion.widget.dialog.dislike.DislikeDialog.InterfaceC3238c
                /* renamed from: a */
                public void mo46798a() {
                    try {
                        if (((AdWorker) BaseBeiZiNativeWorker.this).f11797d != null && ((AdWorker) BaseBeiZiNativeWorker.this).f11797d.m48668s() != 2) {
                            ((AdWorker) BaseBeiZiNativeWorker.this).f11797d.m48709b(BaseBeiZiNativeWorker.this.mo46059g(), BaseBeiZiNativeWorker.this.f12308u);
                        }
                        BaseBeiZiNativeWorker.this.m47988G();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            c3235a.m48012a().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void mo46911b() {
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: f */
    public void mo46061f() {
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "BEIZI";
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0065, code lost:
        r7.f12300Q = com.beizi.fusion.p072g.RandomUtils.m48438a(java.lang.Integer.parseInt(r4.getRate()));
     */
    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo46065d() {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.work.nativead.BaseBeiZiNativeWorker.mo46065d():void");
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: i */
    public AdStatus mo46056i() {
        return this.f11803j;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: j */
    public String mo46054j() {
        UnifiedCustomAd unifiedCustomAd = this.f12295L;
        if (unifiedCustomAd == null) {
            return null;
        }
        return unifiedCustomAd.getPrice();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: k */
    public AdSpacesBean.BuyerBean mo46052k() {
        return this.f11798e;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: l */
    protected void mo46050l() {
        m47912w();
        m47943ag();
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView = this.f11798e.getShakeView();
        this.f12312y = shakeView;
        if (shakeView != null) {
            this.f12313z = shakeView.getCoolShakeView();
        }
        this.f12284A = new NativeShakeUtil(this.f12301n);
        this.f12285B = "cool_" + this.f11802i;
        this.f12293J = "dl_cool_" + this.f11802i;
        if (this.f12305r <= 0.0f) {
            this.f12305r = C3138av.m48288j(this.f12301n);
        }
        if (this.f12306s <= 0.0f) {
            this.f12306s = 0.0f;
        }
        UnifiedCustomAd unifiedCustomAd = new UnifiedCustomAd(this.f12301n, this.f11802i, new NativeAdListener() { // from class: com.beizi.fusion.work.nativead.b.2
            @Override // com.beizi.p051ad.NativeAdListener
            public void onAdClick() {
                Log.d("BeiZis", "showBeiZiNativeUnifiedAd onAdClick()");
            }

            @Override // com.beizi.p051ad.NativeAdListener
            public void onAdFailed(int i) {
                Log.d("BeiZis", "showBeiZiNativeUnifiedAd onAdFailed: " + i);
                BaseBeiZiNativeWorker.this.m47961a(String.valueOf(i), i);
            }

            @Override // com.beizi.p051ad.NativeAdListener
            public void onAdLoaded(NativeAdResponse nativeAdResponse) {
                Log.d("BeiZis", "showBeiZiNativeUnifiedAd onAdLoaded()");
                ((AdWorker) BaseBeiZiNativeWorker.this).f11803j = AdStatus.ADLOAD;
                if (BaseBeiZiNativeWorker.this.f12295L.getPrice() != null) {
                    try {
                        BaseBeiZiNativeWorker baseBeiZiNativeWorker = BaseBeiZiNativeWorker.this;
                        baseBeiZiNativeWorker.m47967a(Double.parseDouble(baseBeiZiNativeWorker.f12295L.getPrice()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                BaseBeiZiNativeWorker.this.m47910y();
                if (nativeAdResponse == null) {
                    BaseBeiZiNativeWorker.this.m47921c(-991);
                    return;
                }
                BaseBeiZiNativeWorker baseBeiZiNativeWorker2 = BaseBeiZiNativeWorker.this;
                baseBeiZiNativeWorker2.f12294K = nativeAdResponse;
                baseBeiZiNativeWorker2.mo46911b();
            }
        });
        this.f12295L = unifiedCustomAd;
        unifiedCustomAd.openAdInNativeBrowser(true);
        this.f12295L.loadAd();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: m */
    public void mo46173m() {
        UnifiedCustomAd unifiedCustomAd = this.f12295L;
        if (unifiedCustomAd != null) {
            unifiedCustomAd.cancel();
        }
        NativeShakeUtil nativeShakeUtil = this.f12284A;
        if (nativeShakeUtil != null) {
            nativeShakeUtil.m48468c();
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: o */
    public View mo46446o() {
        return this.f12308u;
    }

    /* renamed from: b */
    private boolean m46961b(final AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        long longValue = ((Long) C3137at.m48313b(this.f12301n, this.f12285B, 0L)).longValue();
        if (longValue != 0) {
            long currentTimeMillis = System.currentTimeMillis() - longValue;
            if (currentTimeMillis < this.f12313z.getCoolTime()) {
                new Handler().postDelayed(new Runnable() { // from class: com.beizi.fusion.work.nativead.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        BaseBeiZiNativeWorker.this.f12284A.m48478a(shakeViewBean);
                    }
                }, this.f12313z.getCoolTime() - currentTimeMillis);
                return true;
            }
            ShakeCoolConfig.m48369a().m48368a(this.f12285B);
        }
        return false;
    }

    /* renamed from: a */
    public void m46981a(final TextView textView, final ImageView imageView) {
        ArrayList<String> texts;
        try {
            NativeAdResponse nativeAdResponse = this.f12294K;
            if (nativeAdResponse == null) {
                return;
            }
            String callToAction = nativeAdResponse.getCallToAction();
            if (TextUtils.isEmpty(callToAction) && (texts = this.f12294K.getTexts()) != null && texts.size() >= 3) {
                callToAction = texts.get(2);
            }
            if (TextUtils.isEmpty(callToAction)) {
                if (textView != null) {
                    textView.setVisibility(8);
                }
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
            } else if (callToAction.startsWith(IDataSource.f43971a)) {
                ImageManager.with(null).getBitmap(callToAction, new ImageManager.BitmapLoadedListener() { // from class: com.beizi.fusion.work.nativead.b.3
                    @Override // com.beizi.p051ad.internal.utilities.ImageManager.BitmapLoadedListener
                    public void onBitmapLoadFailed() {
                    }

                    @Override // com.beizi.p051ad.internal.utilities.ImageManager.BitmapLoadedListener
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
                        } catch (Exception e) {
                            e.printStackTrace();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private AdSpacesBean.BuyerBean.DislikeConfigBean m46957b(List<AdSpacesBean.BuyerBean.OrderDataDislikeConfigBean> list, String str) {
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

    /* renamed from: a */
    public void m46982a(final View view) {
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean;
        try {
            int m48304a = C3138av.m48304a(this.f12301n, this.f12305r);
            float f = this.f12306s;
            int m48304a2 = f > 0.0f ? C3138av.m48304a(this.f12301n, f) : -2;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(m48304a, m48304a2);
            ViewGroup viewGroup = this.f12307t;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                StringBuilder sb = new StringBuilder();
                sb.append("mNativeAd != null ? ");
                boolean z = true;
                sb.append(this.f12295L != null);
                sb.append(",renderViewBean != null ? ");
                if (this.f12310w == null) {
                    z = false;
                }
                sb.append(z);
                C3116af.m48496a("BeiZis", sb.toString());
                this.f12307t.addView(this.f12296M, layoutParams);
                this.f12296M.measure(0, 0);
                m46980a(this.f12294K, m48304a, m48304a2, this.f12296M.getMeasuredHeight());
                m46964aO();
                EventBean eventBean = this.f11795b;
                if (eventBean != null && (dislikeConfigBean = this.f12287D) != null) {
                    eventBean.m48934Q(dislikeConfigBean.getDislikeUuid());
                    m47929au();
                }
                if (m46969aJ()) {
                    mo46919a(this.f12294K);
                }
                ViewGroup viewGroup2 = this.f12307t;
                this.f12308u = viewGroup2;
                this.f12284A.m48487a(viewGroup2);
            }
            UnifiedCustomAd unifiedCustomAd = this.f12295L;
            if (unifiedCustomAd == null || this.f12310w == null) {
                return;
            }
            unifiedCustomAd.setOrderOptimizeList(this.f12311x);
            this.f12295L.setAdOptimizePercent(this.f12310w.getOptimizePercent());
            C3116af.m48496a("BeiZis", "percent = " + this.f12310w.getOptimizePercent());
            this.f12307t.post(new Runnable() { // from class: com.beizi.fusion.work.nativead.b.4
                @Override // java.lang.Runnable
                public void run() {
                    BaseBeiZiNativeWorker baseBeiZiNativeWorker = BaseBeiZiNativeWorker.this;
                    UnifiedCustomAd unifiedCustomAd2 = baseBeiZiNativeWorker.f12295L;
                    int optimizeSize = baseBeiZiNativeWorker.f12310w.getOptimizeSize();
                    View view2 = view;
                    BaseBeiZiNativeWorker baseBeiZiNativeWorker2 = BaseBeiZiNativeWorker.this;
                    unifiedCustomAd2.optimizeClickArea(optimizeSize, view2, baseBeiZiNativeWorker2.f12307t, baseBeiZiNativeWorker2.f12310w.getDirection());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private AdSpacesBean.BuyerBean.OrderDataShakeViewBean m46973a(List<AdSpacesBean.BuyerBean.OrderDataShakeViewBean> list, String str) {
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

    /* renamed from: a */
    private void m46980a(final NativeAdResponse nativeAdResponse, final int i, final int i2, int i3) {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean;
        try {
            if (!m46962aQ() || (shakeViewBean = this.f12312y) == null || this.f12284A == null || shakeViewBean.getPosition() == null) {
                return;
            }
            EventBean eventBean = this.f11795b;
            if (eventBean != null) {
                eventBean.m48954G(this.f12312y.getShakeViewUuid());
                m47929au();
            }
            AdSpacesBean.BuyerBean.OrderDataShakeViewBean m46973a = m46973a(this.f12312y.getOrderData(), this.f12295L.getAdId());
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = null;
            if (m46973a != null && m46973a.getShakeView() != null) {
                shakeViewBean2 = m46973a.getShakeView();
            }
            if (i2 <= 0) {
                i2 = i3;
            }
            View m48489a = this.f12284A.m48489a(C3138av.m48298b(this.f12301n, i), C3138av.m48298b(this.f12301n, i2), this.f12312y.getPosition());
            if (m48489a != null) {
                ViewGroup.LayoutParams layoutParams = m48489a.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                    layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                    layoutParams2.topMargin = marginLayoutParams.topMargin;
                    AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean3 = this.f12312y;
                    if (shakeViewBean3 != null && shakeViewBean3.getIsHideAnim() == 0) {
                        this.f12307t.addView(m48489a, layoutParams2);
                    }
                }
            }
            m46979a(shakeViewBean2);
            this.f12284A.m48486a(new NativeShakeUtil.InterfaceC3118a() { // from class: com.beizi.fusion.work.nativead.b.7
                @Override // com.beizi.fusion.p072g.NativeShakeUtil.InterfaceC3118a
                /* renamed from: a */
                public void mo46796a() {
                    AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean;
                    if (ViewCheckUtil.m48281a(BaseBeiZiNativeWorker.this.f12308u)) {
                        int[] iArr = new int[2];
                        BaseBeiZiNativeWorker.this.f12308u.getLocationOnScreen(iArr);
                        int[] m48437a = RandomUtils.m48437a(i / 2, i2 / 2);
                        NativeAdUtil.handleClick(nativeAdResponse, BaseBeiZiNativeWorker.this.f12308u, String.valueOf(m48437a[0]), String.valueOf(m48437a[1]), String.valueOf(m48437a[0] + iArr[0]), String.valueOf(m48437a[1] + iArr[1]), 2);
                        BaseBeiZiNativeWorker baseBeiZiNativeWorker = BaseBeiZiNativeWorker.this;
                        if (!baseBeiZiNativeWorker.f12286C || (coolShakeViewBean = baseBeiZiNativeWorker.f12313z) == null) {
                            return;
                        }
                        baseBeiZiNativeWorker.f12286C = false;
                        baseBeiZiNativeWorker.f12284A.m48480a(coolShakeViewBean);
                        BaseBeiZiNativeWorker baseBeiZiNativeWorker2 = BaseBeiZiNativeWorker.this;
                        C3137at.m48315a(baseBeiZiNativeWorker2.f12301n, baseBeiZiNativeWorker2.f12285B, Long.valueOf(System.currentTimeMillis()));
                        ShakeCoolConfig.m48369a().m48367a(BaseBeiZiNativeWorker.this.f12285B, System.currentTimeMillis());
                    }
                }
            });
            AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean = this.f12313z;
            if (coolShakeViewBean != null) {
                this.f12284A.m48479a(coolShakeViewBean, this.f12285B);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m46979a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean == null) {
            shakeViewBean = this.f12312y;
        }
        if (this.f12313z == null) {
            this.f12286C = true;
            this.f12284A.m48478a(shakeViewBean);
        } else if (m46961b(shakeViewBean)) {
            this.f12284A.m48480a(this.f12313z);
        } else if (m46965aN()) {
            this.f12284A.m48480a(this.f12313z);
        } else {
            this.f12286C = true;
            this.f12284A.m48478a(shakeViewBean);
        }
    }
}
