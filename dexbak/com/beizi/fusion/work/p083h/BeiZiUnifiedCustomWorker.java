package com.beizi.fusion.work.p083h;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.beizi.fusion.C3025R;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.selfAdManagerHolder;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3133ar;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.p072g.RandomUtils;
import com.beizi.fusion.p072g.ScrollClickUtil;
import com.beizi.fusion.work.AdWorker;
import com.beizi.p051ad.NativeAdListener;
import com.beizi.p051ad.NativeAdResponse;
import com.beizi.p051ad.UnifiedCustomAd;
import com.beizi.p051ad.internal.nativead.NativeAdEventListener;
import com.beizi.p051ad.internal.nativead.NativeAdShownListener;
import com.beizi.p051ad.internal.nativead.NativeAdUtil;
import com.beizi.p051ad.internal.utilities.ImageManager;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.beizi.fusion.work.h.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BeiZiUnifiedCustomWorker extends BaseUnifiedCustomWorker implements View.OnClickListener, ScrollClickUtil.InterfaceC3132a, C3133ar.InterfaceC3136a {

    /* renamed from: W */
    private ViewGroup f12118W;

    /* renamed from: X */
    private FrameLayout f12119X;

    /* renamed from: Y */
    private UnifiedCustomAd f12120Y;

    /* renamed from: Z */
    private NativeAdResponse f12121Z;

    /* renamed from: aa */
    private AdSpacesBean.BuyerBean.ShakeViewBean f12122aa;

    /* renamed from: ab */
    private AdSpacesBean.BuyerBean.ScrollClickBean f12123ab;

    /* renamed from: ac */
    private List<View> f12124ac;

    public BeiZiUnifiedCustomWorker(Context context, long j, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager, int i) {
        super(context, j, buyerBean, forwardBean, baseManager, i);
        this.f12124ac = new ArrayList();
    }

    /* renamed from: aZ */
    private void m47295aZ() {
        if (this.f12120Y != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("shakeViewBean != null ? ");
            sb.append(this.f12122aa != null);
            C3116af.m48496a("BeiZis", sb.toString());
            ((BaseUnifiedCustomWorker) this).f12100x.removeAllViews();
            ((BaseUnifiedCustomWorker) this).f12100x.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.beizi.fusion.work.h.b.8
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ViewGroup viewGroup = ((BaseUnifiedCustomWorker) BeiZiUnifiedCustomWorker.this).f12100x;
                    if (viewGroup == null) {
                        return;
                    }
                    viewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    BeiZiUnifiedCustomWorker.this.m47289ba();
                    BeiZiUnifiedCustomWorker.this.m47288bb();
                }
            });
            return;
        }
        m47927aw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ba */
    public void m47289ba() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.f12122aa;
        if (shakeViewBean == null || this.f12083P == null || shakeViewBean.getPosition() == null) {
            return;
        }
        EventBean eventBean = this.f11795b;
        if (eventBean != null) {
            eventBean.m48954G(this.f12122aa.getShakeViewUuid());
            m47929au();
        }
        AdSpacesBean.BuyerBean.OrderDataShakeViewBean m47297a = m47297a(this.f12122aa.getOrderData(), this.f12120Y.getAdId());
        if (m47297a != null) {
            this.f12083P.m48351a(m47297a.getShakeView());
        } else {
            this.f12083P.m48351a(this.f12122aa);
        }
        View m48360a = this.f12083P.m48360a(C3138av.m48298b(this.f12081N, ((BaseUnifiedCustomWorker) this).f12100x.getWidth()), C3138av.m48298b(this.f12081N, ((BaseUnifiedCustomWorker) this).f12100x.getHeight()), this.f12122aa.getPosition());
        if (m48360a != null) {
            ViewGroup.LayoutParams layoutParams = m48360a.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                layoutParams2.topMargin = marginLayoutParams.topMargin;
                try {
                    ((BaseUnifiedCustomWorker) this).f12100x.addView(m48360a, layoutParams2);
                    this.f12083P.m48359a(this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bb */
    public void m47288bb() {
        AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean = this.f12123ab;
        if (scrollClickBean == null || this.f12084Q == null || scrollClickBean.getPosition() == null) {
            return;
        }
        EventBean eventBean = this.f11795b;
        if (eventBean != null) {
            eventBean.m48956F(this.f12123ab.getScrollClickUuid());
            m47929au();
        }
        AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean m47290b = m47290b(this.f12123ab.getOrderData(), this.f12120Y.getAdId());
        if (m47290b != null) {
            this.f12084Q.m48374a(m47290b.getScrollClick());
        } else {
            this.f12084Q.m48374a(this.f12123ab);
        }
        View m48377a = this.f12084Q.m48377a(C3138av.m48298b(this.f12081N, ((BaseUnifiedCustomWorker) this).f12100x.getWidth()), C3138av.m48298b(this.f12081N, ((BaseUnifiedCustomWorker) this).f12100x.getHeight()), this.f12123ab.getPosition());
        if (m48377a != null) {
            ViewGroup.LayoutParams layoutParams = m48377a.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                layoutParams2.topMargin = marginLayoutParams.topMargin;
                try {
                    ((BaseUnifiedCustomWorker) this).f12100x.addView(m48377a, layoutParams2);
                    this.f12084Q.m48376a(this);
                    m47330a(((BaseUnifiedCustomWorker) this).f12100x, this.f12123ab.getScrollDirection(), this.f12123ab.getScrollDistance(), this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: A */
    protected void mo46197A() {
        if (!m47909z() || this.f12120Y == null) {
            return;
        }
        m47938al();
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aG */
    public int mo47251aG() {
        return C3025R.C3029layout.beizi_layout_unified_view;
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aH */
    public void mo47250aH() {
        super.mo47250aH();
        this.f12118W = (ViewGroup) ((BaseUnifiedCustomWorker) this).f12091o.findViewById(C3025R.C3028id.fl_container_mask);
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aI */
    public void mo47249aI() {
        if (!C3138av.m48301a("com.beizi.ad.BeiZi")) {
            m47915t();
            this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.h.b.1
                @Override // java.lang.Runnable
                public void run() {
                    BeiZiUnifiedCustomWorker.this.m47921c(10151);
                }
            }, 10L);
            Log.e("BeiZis", "BeiZi sdk not import , will do nothing");
            return;
        }
        m47914u();
        selfAdManagerHolder.m48575a(this.f12081N, this.f11801h);
        m47913v();
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + ((BaseUnifiedCustomWorker) this).f12075H);
        long j = ((BaseUnifiedCustomWorker) this).f12075H;
        if (j > 0) {
            this.f11806m.sendEmptyMessageDelayed(1, j);
        } else {
            BaseManager baseManager = this.f11797d;
            if (baseManager != null && baseManager.m48667t() < 1 && this.f11797d.m48668s() != 2) {
                mo46050l();
            }
        }
        this.f12083P = new C3133ar(this.f12081N);
        this.f12084Q = new ScrollClickUtil(this.f12081N);
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aJ */
    public void mo47248aJ() {
        this.f12122aa = this.f11798e.getShakeView();
        this.f12123ab = this.f11798e.getScrollClick();
        UnifiedCustomAd unifiedCustomAd = new UnifiedCustomAd(this.f12081N, this.f11802i, new NativeAdListener() { // from class: com.beizi.fusion.work.h.b.2
            @Override // com.beizi.p051ad.NativeAdListener
            public void onAdClick() {
                Log.d("BeiZis", "showBeiZiUnifiedCustomAd onAdClick()");
            }

            @Override // com.beizi.p051ad.NativeAdListener
            public void onAdFailed(int i) {
                Log.d("BeiZis", "showBeiZiUnifiedCustomAd onAdFailed: " + i);
                BeiZiUnifiedCustomWorker.this.m47961a(String.valueOf(i), i);
            }

            @Override // com.beizi.p051ad.NativeAdListener
            public void onAdLoaded(NativeAdResponse nativeAdResponse) {
                Log.d("BeiZis", "showBeiZiUnifiedCustomAd onAdLoaded()");
                ((AdWorker) BeiZiUnifiedCustomWorker.this).f11803j = AdStatus.ADLOAD;
                if (BeiZiUnifiedCustomWorker.this.f12120Y.getPrice() != null) {
                    try {
                        BeiZiUnifiedCustomWorker beiZiUnifiedCustomWorker = BeiZiUnifiedCustomWorker.this;
                        beiZiUnifiedCustomWorker.m47967a(Double.parseDouble(beiZiUnifiedCustomWorker.f12120Y.getPrice()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                BeiZiUnifiedCustomWorker.this.m47910y();
                if (nativeAdResponse == null) {
                    BeiZiUnifiedCustomWorker.this.m47921c(-991);
                    return;
                }
                BeiZiUnifiedCustomWorker.this.f12121Z = nativeAdResponse;
                BeiZiUnifiedCustomWorker.this.m47325aM();
            }
        });
        this.f12120Y = unifiedCustomAd;
        unifiedCustomAd.openAdInNativeBrowser(true);
        this.f12120Y.loadAd();
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aO */
    public void mo47247aO() {
        if (RandomUtils.m48438a(this.f12087T.getCec())) {
            m47291b("regionalClick");
        } else {
            m47322aY();
        }
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aP */
    public void mo47296aP() {
        m47295aZ();
        List<View> list = this.f12124ac;
        if (list != null && list.size() > 0) {
            NativeAdUtil.registerTracking(this.f12121Z, this.f12119X, this.f12124ac, new NativeAdEventListener() { // from class: com.beizi.fusion.work.h.b.4
                @Override // com.beizi.p051ad.internal.nativead.NativeAdEventListener
                public void onAdWasClicked() {
                    BeiZiUnifiedCustomWorker.this.m47327aK();
                }

                @Override // com.beizi.p051ad.internal.nativead.NativeAdEventListener
                public void onAdWillLeaveApplication() {
                    Log.d("BeiZis", "showBeiZiUnifiedCustomAd onAdWillLeaveApplication");
                }
            });
        } else {
            NativeAdUtil.registerTracking(this.f12121Z, this.f12119X, new NativeAdEventListener() { // from class: com.beizi.fusion.work.h.b.5
                @Override // com.beizi.p051ad.internal.nativead.NativeAdEventListener
                public void onAdWasClicked() {
                    BeiZiUnifiedCustomWorker.this.m47327aK();
                }

                @Override // com.beizi.p051ad.internal.nativead.NativeAdEventListener
                public void onAdWillLeaveApplication() {
                    Log.d("BeiZis", "showBeiZiUnifiedCustomAd onAdWillLeaveApplication");
                }
            });
        }
        NativeAdUtil.registerShow(this.f12121Z, this.f12119X, new NativeAdShownListener() { // from class: com.beizi.fusion.work.h.b.6
            @Override // com.beizi.p051ad.internal.nativead.NativeAdShownListener
            public void onAdShown() {
                BeiZiUnifiedCustomWorker.this.m47326aL();
            }
        });
        if (RandomUtils.m48438a(this.f12087T.getRmc())) {
            new Handler().postDelayed(new Runnable() { // from class: com.beizi.fusion.work.h.b.7
                @Override // java.lang.Runnable
                public void run() {
                    BeiZiUnifiedCustomWorker.this.m47291b("optimize");
                }
            }, (long) ((Math.random() * 1000.0d) + 1000.0d));
        }
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aR */
    public void mo47245aR() {
        ((BaseUnifiedCustomWorker) this).f12096t.removeAllViews();
        ((BaseUnifiedCustomWorker) this).f12096t.addView(this.f12119X, new FrameLayout.LayoutParams(-1, -1));
        this.f12118W.setLayoutParams(((BaseUnifiedCustomWorker) this).f12096t.getLayoutParams());
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aS */
    public String mo47244aS() {
        return this.f12121Z.getHeadline();
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aT */
    public String mo47243aT() {
        return this.f12121Z.getBody();
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aU */
    public String mo47242aU() {
        return this.f12121Z.getIconUrl();
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aV */
    public String mo47241aV() {
        ArrayList<String> texts;
        String callToAction = this.f12121Z.getCallToAction();
        return (!TextUtils.isEmpty(callToAction) || (texts = this.f12121Z.getTexts()) == null || texts.size() < 3) ? callToAction : texts.get(2);
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aX */
    public void mo47240aX() {
        if (this.f12121Z == null) {
            m47921c(-991);
        } else {
            ImageManager.with(null).getBitmap(this.f12121Z.getImageUrl(), new ImageManager.BitmapLoadedListener() { // from class: com.beizi.fusion.work.h.b.3
                @Override // com.beizi.p051ad.internal.utilities.ImageManager.BitmapLoadedListener
                public void onBitmapLoadFailed() {
                    Log.d("BeiZis", "showBeiZiUnifiedCustomAd onBitmapLoadFailed");
                    BeiZiUnifiedCustomWorker.this.m47961a("sdk custom error ".concat("onBitmapLoadFailed"), 99991);
                }

                @Override // com.beizi.p051ad.internal.utilities.ImageManager.BitmapLoadedListener
                public void onBitmapLoaded(Bitmap bitmap) {
                    BeiZiUnifiedCustomWorker beiZiUnifiedCustomWorker = BeiZiUnifiedCustomWorker.this;
                    beiZiUnifiedCustomWorker.f12119X = NativeAdUtil.getCustomRenderView(beiZiUnifiedCustomWorker.f12081N, bitmap, beiZiUnifiedCustomWorker.f12121Z);
                    BeiZiUnifiedCustomWorker.this.m47324aN();
                }
            });
        }
    }

    @Override // com.beizi.fusion.p072g.ScrollClickUtil.InterfaceC3132a
    /* renamed from: b */
    public void mo46554b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
    }

    @Override // com.beizi.fusion.p072g.ScrollClickUtil.InterfaceC3132a
    /* renamed from: c_ */
    public void mo46549c_() {
        if (this.f12123ab != null) {
            C3116af.m48496a("BeiZis", "enter showBeiZiUnifiedCustomAd onScrollDistanceMeet  ");
            m47291b("scroll");
        }
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker, com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "BEIZI";
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker, com.beizi.fusion.work.AdWorker
    /* renamed from: m */
    public void mo46173m() {
        UnifiedCustomAd unifiedCustomAd = this.f12120Y;
        if (unifiedCustomAd != null) {
            unifiedCustomAd.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m47291b("regionalClick");
    }

    /* renamed from: b */
    private AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean m47290b(List<AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean orderDataScrollViewOrderBean : list) {
                List<String> orderList = orderDataScrollViewOrderBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataScrollViewOrderBean;
                }
            }
        }
        return null;
    }

    @Override // com.beizi.fusion.p072g.C3133ar.InterfaceC3136a
    /* renamed from: b */
    public void mo46561b() {
        C3116af.m48496a("BeiZis", "enter showBeiZiUnifiedCustomAd onShakeHappened  ");
        m47291b("shake");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m47291b(String str) {
        try {
            if (this.f12120Y != null) {
                this.f11795b.m48938O(str);
                m47929au();
                C3116af.m48496a("BeiZis", "enter showBeiZiUnifiedCustomAd clickUnifiedAd clickEventType:" + str);
                int[] iArr = new int[2];
                this.f12119X.getLocationOnScreen(iArr);
                this.f12119X.measure(0, 0);
                int[] m48437a = RandomUtils.m48437a(this.f12119X.getMeasuredWidth() / 2, this.f12119X.getMeasuredHeight() / 2);
                NativeAdUtil.handleClick(this.f12121Z, this.f12119X, String.valueOf(m48437a[0]), String.valueOf(m48437a[1]), String.valueOf(m48437a[0] + iArr[0]), String.valueOf(m48437a[1] + iArr[1]), 2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: a */
    public void mo47252a(List<View> list) {
        List<String> clickView = this.f12087T.getClickView();
        if (clickView != null && clickView.size() > 0) {
            if (!clickView.contains("bg") && !clickView.contains(UMCommonContent.f37822az) && !clickView.contains(SocializeProtocolConstants.IMAGE)) {
                this.f12118W.setVisibility(0);
            } else {
                this.f12118W.setVisibility(8);
            }
            this.f12124ac.clear();
            this.f12124ac.addAll(list);
            return;
        }
        this.f12118W.setVisibility(0);
    }

    /* renamed from: a */
    private AdSpacesBean.BuyerBean.OrderDataShakeViewBean m47297a(List<AdSpacesBean.BuyerBean.OrderDataShakeViewBean> list, String str) {
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

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: b */
    public void mo47236b(boolean z) {
        boolean m48438a = RandomUtils.m48438a(this.f12087T.getSlc());
        boolean m48438a2 = RandomUtils.m48438a(this.f12087T.getSlac());
        if (z && m48438a) {
            m47291b("regionalClick");
        } else if (!z && m48438a2) {
            m47291b("regionalClick");
        } else {
            m47322aY();
        }
    }
}
