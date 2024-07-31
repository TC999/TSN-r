package com.beizi.fusion.work.splash;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Message;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.ObserverAdStatus;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.CompeteStatus;
import com.beizi.fusion.p066d.GDTAdManagerHolder;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.BeiZiViewUtils;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.p072g.CheckDirectDownload;
import com.beizi.fusion.p072g.DownloadConfirmHelper;
import com.beizi.fusion.p072g.PriceUtil;
import com.beizi.fusion.p072g.RandomUtils;
import com.beizi.fusion.widget.CircleProgressView;
import com.beizi.fusion.widget.SkipView;
import com.beizi.fusion.work.AdWorker;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.github.mikephil.charting.utils.Utils;
import com.kwad.sdk.api.model.AdnName;
import com.p518qq.p519e.ads.splash.SplashAD;
import com.p518qq.p519e.ads.splash.SplashADListener;
import com.p518qq.p519e.comm.managers.status.SDKStatus;
import com.p518qq.p519e.comm.util.AdError;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.splash.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GdtSplashWorker extends AdWorker {

    /* renamed from: H */
    private long f12698H;

    /* renamed from: J */
    private long f12700J;

    /* renamed from: K */
    private boolean f12701K;

    /* renamed from: L */
    private CircleProgressView f12702L;

    /* renamed from: M */
    private AdSpacesBean.PositionBean f12703M;

    /* renamed from: N */
    private AdSpacesBean.PositionBean f12704N;

    /* renamed from: O */
    private List<View> f12705O;

    /* renamed from: P */
    private float f12706P;

    /* renamed from: Q */
    private float f12707Q;

    /* renamed from: R */
    private AdSpacesBean.RenderViewBean f12708R;

    /* renamed from: S */
    private int f12709S;

    /* renamed from: T */
    private int f12710T;

    /* renamed from: U */
    private String f12711U;

    /* renamed from: V */
    private String f12712V;

    /* renamed from: W */
    private String f12713W;

    /* renamed from: n */
    int f12714n;

    /* renamed from: o */
    long f12715o;

    /* renamed from: p */
    View.OnClickListener f12716p;

    /* renamed from: q */
    private Context f12717q;

    /* renamed from: r */
    private String f12718r;

    /* renamed from: s */
    private long f12719s;

    /* renamed from: t */
    private boolean f12720t;

    /* renamed from: u */
    private View f12721u;

    /* renamed from: v */
    private ViewGroup f12722v;

    /* renamed from: w */
    private ViewGroup f12723w;

    /* renamed from: x */
    private SplashAD f12724x;

    /* renamed from: y */
    private List<AdSpacesBean.RenderViewBean> f12725y;

    /* renamed from: z */
    private List<AdSpacesBean.RenderViewBean> f12726z = new ArrayList();

    /* renamed from: A */
    private List<AdSpacesBean.RenderViewBean> f12691A = new ArrayList();

    /* renamed from: B */
    private boolean f12692B = false;

    /* renamed from: C */
    private boolean f12693C = false;

    /* renamed from: D */
    private boolean f12694D = false;

    /* renamed from: E */
    private boolean f12695E = false;

    /* renamed from: F */
    private boolean f12696F = false;

    /* renamed from: G */
    private long f12697G = 5000;

    /* renamed from: I */
    private int f12699I = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GdtSplashWorker.java */
    /* renamed from: com.beizi.fusion.work.splash.f$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3470a implements SplashADListener {

        /* renamed from: a */
        boolean f12729a;

        /* renamed from: b */
        boolean f12730b;

        /* renamed from: c */
        boolean f12731c;

        private C3470a() {
            this.f12729a = false;
            this.f12730b = false;
            this.f12731c = false;
        }

        @Override // com.p518qq.p519e.ads.splash.SplashADListener
        public void onADClicked() {
            Log.d("BeiZis", "showGdtSplash onAdClick()");
            if (((AdWorker) GdtSplashWorker.this).f11797d != null && ((AdWorker) GdtSplashWorker.this).f11797d.m48668s() != 2) {
                ((AdWorker) GdtSplashWorker.this).f11797d.m48700d(GdtSplashWorker.this.mo46059g());
                ((AdWorker) GdtSplashWorker.this).f11806m.sendEmptyMessageDelayed(2, (((AdWorker) GdtSplashWorker.this).f11805l + 5000) - System.currentTimeMillis());
            }
            if (this.f12730b) {
                return;
            }
            this.f12730b = true;
            GdtSplashWorker.this.m47990E();
            GdtSplashWorker.this.m47941ai();
        }

        @Override // com.p518qq.p519e.ads.splash.SplashADListener
        public void onADDismissed() {
            Log.d("BeiZis", "showGdtSplash onADDismissed()");
            if (((AdWorker) GdtSplashWorker.this).f11797d.m48668s() != 2) {
                GdtSplashWorker.this.m47947ac();
            }
            GdtSplashWorker.this.m47988G();
        }

        @Override // com.p518qq.p519e.ads.splash.SplashADListener
        public void onADExposure() {
            Log.d("BeiZis", "showGdtSplash onADExposure()");
            ((AdWorker) GdtSplashWorker.this).f11803j = AdStatus.ADSHOW;
            if (this.f12729a) {
                return;
            }
            this.f12729a = true;
            GdtSplashWorker.this.mo46072az();
            GdtSplashWorker.this.mo47585ab();
            GdtSplashWorker.this.m47991D();
            GdtSplashWorker.this.m47942ah();
        }

        @Override // com.p518qq.p519e.ads.splash.SplashADListener
        public void onADLoaded(long j) {
            if (GdtSplashWorker.this.f12724x.getECPM() > 0) {
                GdtSplashWorker gdtSplashWorker = GdtSplashWorker.this;
                gdtSplashWorker.m47967a(gdtSplashWorker.f12724x.getECPM());
            }
            if (DownloadConfirmHelper.f11427a) {
                GdtSplashWorker.this.f12724x.setDownloadConfirmListener(DownloadConfirmHelper.f11428b);
            }
            GdtSplashWorker.this.m47910y();
            if (((AdWorker) GdtSplashWorker.this).f11803j.ordinal() < AdStatus.ADSHOW.ordinal()) {
                ((AdWorker) GdtSplashWorker.this).f11803j = AdStatus.ADLOAD;
                GdtSplashWorker.m46327g(GdtSplashWorker.this);
                if (((AdWorker) GdtSplashWorker.this).f11797d != null) {
                    Log.d("BeiZis", "showGdtSplash onADLoaded:" + j + ",mAdLifeControl.getAdStatus() = " + ((AdWorker) GdtSplashWorker.this).f11797d.m48667t() + ",gap = " + (j - SystemClock.elapsedRealtime()));
                }
                if (SystemClock.elapsedRealtime() < j && GdtSplashWorker.this.m47970Y()) {
                    GdtSplashWorker.this.m46344aG();
                    return;
                } else {
                    GdtSplashWorker.this.m47980O();
                    return;
                }
            }
            int ordinal = ((AdWorker) GdtSplashWorker.this).f11803j.ordinal();
            String str = ordinal != 2 ? ordinal != 3 ? AdnName.OTHER : CommonNetImpl.FAIL : TTLogUtil.TAG_EVENT_SHOW;
            Message obtain = Message.obtain();
            obtain.obj = "ad status error " + str;
            GdtSplashWorker.this.mo46196a(obtain);
        }

        @Override // com.p518qq.p519e.ads.splash.SplashADListener
        public void onADPresent() {
            Log.d("BeiZis", "showGdtSplash onADPresent()");
            GdtSplashWorker.m46327g(GdtSplashWorker.this);
            GdtSplashWorker.this.m47992C();
        }

        @Override // com.p518qq.p519e.ads.splash.SplashADListener
        public void onADTick(long j) {
            if (!this.f12731c) {
                if (GdtSplashWorker.this.f12701K) {
                    GdtSplashWorker gdtSplashWorker = GdtSplashWorker.this;
                    gdtSplashWorker.f12705O = BeiZiViewUtils.m48237a(gdtSplashWorker.f12723w);
                }
                GdtSplashWorker.this.m46337aN();
                this.f12731c = true;
            }
            if (GdtSplashWorker.this.f12701K) {
                if (GdtSplashWorker.this.f12700J > 0 && GdtSplashWorker.this.f12700J <= GdtSplashWorker.this.f12697G) {
                    if (GdtSplashWorker.this.f12692B) {
                        if (GdtSplashWorker.this.f12698H <= 0 || j <= GdtSplashWorker.this.f12698H) {
                            GdtSplashWorker.this.f12696F = false;
                            GdtSplashWorker.this.f12721u.setAlpha(1.0f);
                        } else {
                            GdtSplashWorker.this.f12696F = true;
                            GdtSplashWorker.this.f12721u.setAlpha(0.2f);
                        }
                    }
                    if (GdtSplashWorker.this.f12700J == GdtSplashWorker.this.f12697G) {
                        GdtSplashWorker.this.f12721u.setEnabled(false);
                    } else {
                        GdtSplashWorker.this.f12721u.setEnabled(true);
                    }
                }
                GdtSplashWorker.this.m46330e(Math.round(((float) j) / 1000.0f));
            }
            if (((AdWorker) GdtSplashWorker.this).f11797d == null || ((AdWorker) GdtSplashWorker.this).f11797d.m48668s() == 2) {
                return;
            }
            ((AdWorker) GdtSplashWorker.this).f11797d.m48752a(j);
        }

        @Override // com.p518qq.p519e.ads.splash.SplashADListener
        public void onNoAD(AdError adError) {
            Log.d("BeiZis", "showGdtSplash onNoAD:" + adError.getErrorMsg());
            GdtSplashWorker.this.m47961a(adError.getErrorMsg(), adError.getErrorCode());
            if (GdtSplashWorker.this.f12699I < 1 || ((AdWorker) GdtSplashWorker.this).f11797d == null) {
                return;
            }
            ((AdWorker) GdtSplashWorker.this).f11797d.m48666u();
        }
    }

    public GdtSplashWorker(Context context, String str, long j, View view, ViewGroup viewGroup, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, List<AdSpacesBean.RenderViewBean> list, BaseManager baseManager) {
        this.f12717q = context;
        this.f12718r = str;
        this.f12719s = j;
        if (view != null) {
            view.setVisibility(8);
        }
        this.f12721u = null;
        this.f12722v = viewGroup;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        this.f12723w = new SplashContainer(context);
        this.f12725y = list;
        m47917r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aG */
    public void m46344aG() {
        BaseManager baseManager = this.f11797d;
        if (baseManager == null) {
            return;
        }
        Map<String, AdWorker> m48669r = baseManager.m48669r();
        Log.d("BeiZis", mo46059g() + " splashWorkers:" + m48669r.toString());
        m47969Z();
        CompeteStatus competeStatus = this.f11800g;
        if (competeStatus == CompeteStatus.SUCCESS) {
            m46336b();
            m47946ad();
        } else if (competeStatus == CompeteStatus.FAIL) {
            Log.d("BeiZis", "other worker shown," + mo46059g() + " remove");
        }
    }

    /* renamed from: aH */
    private void m46343aH() {
        ViewGroup viewGroup = this.f12722v;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.f12722v.addView(this.f12723w);
            this.f12724x.showAd(this.f12723w);
            if (this.f12702L != null) {
                this.f12722v.addView(this.f12702L, new FrameLayout.LayoutParams(-2, -2));
            }
            m46339aL();
            if (this.f12701K) {
                m46341aJ();
                return;
            }
            return;
        }
        m47927aw();
    }

    /* renamed from: aI */
    private void m46342aI() {
        for (int i = 0; i < this.f12725y.size(); i++) {
            AdSpacesBean.RenderViewBean renderViewBean = this.f12725y.get(i);
            String type = renderViewBean.getType();
            if ("SKIPVIEW".equals(type)) {
                this.f12691A.add(renderViewBean);
            } else if ("MATERIALVIEW".equals(type)) {
                this.f12726z.add(renderViewBean);
            }
        }
        if (this.f12691A.size() > 0) {
            AdSpacesBean.RenderViewBean renderViewBean2 = this.f12691A.get(0);
            this.f12708R = renderViewBean2;
            if (renderViewBean2 != null) {
                this.f12704N = renderViewBean2.getTapPosition();
                this.f12703M = this.f12708R.getLayerPosition();
                long skipUnavailableTime = this.f12708R.getSkipUnavailableTime();
                if (skipUnavailableTime > 0) {
                    this.f12700J = skipUnavailableTime;
                }
                this.f12709S = this.f12708R.getShowCountDown();
                this.f12710T = this.f12708R.getShowBorder();
                String skipText = this.f12708R.getSkipText();
                this.f12711U = skipText;
                if (TextUtils.isEmpty(skipText)) {
                    this.f12711U = "跳过";
                }
                String textColor = this.f12708R.getTextColor();
                this.f12712V = textColor;
                if (TextUtils.isEmpty(textColor)) {
                    this.f12712V = "#FFFFFF";
                }
                String countDownColor = this.f12708R.getCountDownColor();
                this.f12713W = countDownColor;
                if (TextUtils.isEmpty(countDownColor)) {
                    this.f12713W = "#FFFFFF";
                }
                List<AdSpacesBean.PassPolicyBean> passPolicy = this.f12708R.getPassPolicy();
                if (passPolicy != null && passPolicy.size() > 0) {
                    for (AdSpacesBean.PassPolicyBean passPolicyBean : passPolicy) {
                        String passType = passPolicyBean.getPassType();
                        int passPercent = passPolicyBean.getPassPercent();
                        passType.hashCode();
                        char c = 65535;
                        switch (passType.hashCode()) {
                            case 601561940:
                                if (passType.equals("RANDOMPASS")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 1028793094:
                                if (passType.equals("WAITPASS")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 1122973890:
                                if (passType.equals("LAYERPASS")) {
                                    c = 2;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                                this.f12693C = RandomUtils.m48438a(passPercent);
                                break;
                            case 1:
                                this.f12692B = RandomUtils.m48438a(passPercent);
                                break;
                            case 2:
                                AdSpacesBean.PositionBean positionBean = this.f12703M;
                                if (positionBean != null && this.f12704N != null) {
                                    double centerX = positionBean.getCenterX();
                                    double centerY = this.f12703M.getCenterY();
                                    double width = this.f12703M.getWidth();
                                    double height = this.f12703M.getHeight();
                                    double centerX2 = this.f12704N.getCenterX();
                                    double centerY2 = this.f12704N.getCenterY();
                                    double width2 = this.f12704N.getWidth();
                                    double height2 = this.f12704N.getHeight();
                                    if ((centerX > Utils.DOUBLE_EPSILON && centerX2 > Utils.DOUBLE_EPSILON && centerX != centerX2) || ((centerY > Utils.DOUBLE_EPSILON && centerY2 > Utils.DOUBLE_EPSILON && centerY != centerY2) || ((width > Utils.DOUBLE_EPSILON && width2 > Utils.DOUBLE_EPSILON && width != width2) || (height > Utils.DOUBLE_EPSILON && height2 > Utils.DOUBLE_EPSILON && height != height2)))) {
                                        this.f12694D = RandomUtils.m48438a(passPercent);
                                    }
                                    if (width2 * height2 < width * height) {
                                        this.f12695E = true;
                                        break;
                                    } else {
                                        break;
                                    }
                                }
                                break;
                        }
                    }
                }
            }
        }
        if (this.f12726z.size() > 0) {
            Collections.sort(this.f12726z, new Comparator<AdSpacesBean.RenderViewBean>() { // from class: com.beizi.fusion.work.splash.f.2
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(AdSpacesBean.RenderViewBean renderViewBean3, AdSpacesBean.RenderViewBean renderViewBean4) {
                    return renderViewBean4.getLevel() - renderViewBean3.getLevel();
                }
            });
        }
    }

    /* renamed from: aJ */
    private void m46341aJ() {
        if (this.f12692B) {
            m47978Q();
        }
        if (this.f12693C) {
            m47977R();
        }
        if (this.f12694D) {
            m47976S();
        }
        if (this.f12695E) {
            m47975T();
        }
        this.f12698H = this.f12697G - this.f12700J;
    }

    /* renamed from: aK */
    private View m46340aK() {
        View view;
        String str;
        if (this.f12701K) {
            View view2 = this.f12721u;
            if (view2 != null) {
                view2.setVisibility(8);
                view2.setAlpha(0.0f);
            }
            this.f12721u = new SkipView(this.f12717q);
            CircleProgressView circleProgressView = new CircleProgressView(this.f12717q);
            this.f12702L = circleProgressView;
            circleProgressView.setAlpha(0.0f);
            view = this.f12702L;
            str = "beizi";
        } else {
            view = this.f12721u;
            if (view != null) {
                CircleProgressView circleProgressView2 = new CircleProgressView(this.f12717q);
                this.f12702L = circleProgressView2;
                circleProgressView2.setAlpha(0.0f);
                view = this.f12702L;
                str = Constants.JumpUrlConstants.SRC_TYPE_APP;
            } else {
                str = "buyer";
            }
        }
        EventBean eventBean = this.f11795b;
        if (eventBean != null) {
            eventBean.m48887r(str);
            m47929au();
        }
        return view;
    }

    /* renamed from: aL */
    private void m46339aL() {
        if (this.f12701K) {
            if (this.f12703M != null && this.f12708R != null) {
                float f = this.f12706P;
                float height = this.f12722v.getHeight();
                if (height == 0.0f) {
                    height = this.f12707Q - C3138av.m48304a(this.f12717q, 100.0f);
                }
                double d = f;
                Double.isNaN(d);
                int width = (int) (d * this.f12703M.getWidth() * 0.01d);
                if (this.f12703M.getHeight() >= 12.0d) {
                    double d2 = width;
                    Double.isNaN(d2);
                    int height2 = (int) (d2 * this.f12703M.getHeight() * 0.01d);
                    double d3 = height2;
                    Double.isNaN(d3);
                    int paddingHeight = (int) (d3 * this.f12708R.getPaddingHeight() * 0.01d);
                    if (paddingHeight < 0) {
                        paddingHeight = 0;
                    }
                    ((SkipView) this.f12721u).setData(this.f12710T, paddingHeight);
                    m46330e(5);
                    this.f12722v.addView(this.f12721u, new FrameLayout.LayoutParams(width, height2));
                    float centerX = (f * ((float) (this.f12703M.getCenterX() * 0.01d))) - (width / 2);
                    float centerY = (height * ((float) (this.f12703M.getCenterY() * 0.01d))) - (height2 / 2);
                    this.f12721u.setX(centerX);
                    this.f12721u.setY(centerY);
                    View view = this.f12721u;
                    if (view != null) {
                        view.setVisibility(0);
                        return;
                    }
                    return;
                }
                m46338aM();
                return;
            }
            m46338aM();
            return;
        }
        View view2 = this.f12721u;
        if (view2 != null) {
            view2.setVisibility(0);
            this.f12721u.setAlpha(1.0f);
        }
    }

    /* renamed from: aM */
    private void m46338aM() {
        double d = this.f12706P;
        Double.isNaN(d);
        int i = (int) (d * 0.15d);
        double d2 = i;
        Double.isNaN(d2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (int) (d2 * 0.45d));
        layoutParams.gravity = 53;
        layoutParams.topMargin = C3138av.m48304a(this.f12717q, 20.0f);
        layoutParams.rightMargin = C3138av.m48304a(this.f12717q, 20.0f);
        ViewGroup viewGroup = this.f12722v;
        if (viewGroup != null) {
            viewGroup.addView(this.f12721u, layoutParams);
        }
        View view = this.f12721u;
        if (view != null) {
            this.f12709S = 1;
            this.f12710T = 1;
            ((SkipView) view).setData(1, 0);
            ((SkipView) this.f12721u).setText(String.format("跳过 %d", 5));
            this.f12721u.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aN */
    public void m46337aN() {
        int[] iArr;
        float pivotX;
        float pivotY;
        float height;
        View view = this.f12721u;
        if (view == null) {
            return;
        }
        view.getLocationOnScreen(new int[2]);
        if (this.f12704N != null) {
            float f = this.f12706P;
            float height2 = this.f12722v.getHeight();
            if (height2 == 0.0f) {
                height2 = this.f12707Q - C3138av.m48304a(this.f12717q, 100.0f);
            }
            double d = f;
            Double.isNaN(d);
            int width = (int) (d * this.f12704N.getWidth() * 0.01d);
            double d2 = width;
            Double.isNaN(d2);
            int height3 = (int) (d2 * this.f12704N.getHeight() * 0.01d);
            ViewGroup.LayoutParams layoutParams = this.f12702L.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height3;
            this.f12702L.setLayoutParams(layoutParams);
            pivotX = (f * ((float) (this.f12704N.getCenterX() * 0.01d))) - (width / 2);
            pivotY = height2 * ((float) (this.f12704N.getCenterY() * 0.01d));
            height = height3 / 2;
        } else {
            pivotX = (iArr[0] + this.f12721u.getPivotX()) - (this.f12702L.getWidth() / 2);
            pivotY = iArr[1] + this.f12721u.getPivotY();
            height = this.f12702L.getHeight() / 2;
        }
        this.f12702L.setX(pivotX);
        this.f12702L.setY(pivotY - height);
    }

    /* renamed from: g */
    static /* synthetic */ int m46327g(GdtSplashWorker gdtSplashWorker) {
        int i = gdtSplashWorker.f12699I;
        gdtSplashWorker.f12699I = i + 1;
        return i;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: az */
    public void mo46072az() {
        SplashAD splashAD = this.f12724x;
        if (splashAD == null || splashAD.getECPM() <= 0 || this.f12720t) {
            return;
        }
        this.f12720t = true;
        C3116af.m48496a("BeiZis", "channel == GDT竞价成功");
        C3116af.m48496a("BeiZis", "channel == sendWinNoticeECPM" + this.f12724x.getECPM());
        SplashAD splashAD2 = this.f12724x;
        GDTAdManagerHolder.m48636a(splashAD2, splashAD2.getECPM());
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "GDT";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m46330e(int i) {
        if (this.f12709S == 1) {
            String valueOf = String.valueOf(i);
            String str = this.f12711U + " ";
            String str2 = str + valueOf;
            SpannableString spannableString = new SpannableString(str2);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.f12712V)), 0, str.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.f12713W)), str2.indexOf(valueOf), str2.length(), 33);
            ((SkipView) this.f12721u).setText(spannableString);
            return;
        }
        SpannableString spannableString2 = new SpannableString(this.f12711U);
        spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor(this.f12712V)), 0, this.f12711U.length(), 33);
        ((SkipView) this.f12721u).setText(spannableString2);
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: A */
    protected void mo46197A() {
        StringBuilder sb = new StringBuilder();
        sb.append("enter handleBidAdLoaded isBidTypeC2S() = ");
        sb.append(m47937am());
        sb.append(",mSplashAD != null ? ");
        sb.append(this.f12724x != null);
        C3116af.m48496a("BeiZis", sb.toString());
        if (!m47909z() || this.f12724x == null) {
            return;
        }
        m47938al();
        int m48440a = PriceUtil.m48440a(this.f11798e.getPriceDict(), this.f12724x.getECPMLevel());
        if (m48440a != -1 && m48440a != -2) {
            C3116af.m48496a("BeiZisBid", "gdt splash price = " + m48440a);
            m47967a((double) m48440a);
            return;
        }
        m47966a(3);
        m47983L();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: d */
    public void mo46065d() {
        if (this.f11797d == null) {
            return;
        }
        this.f12715o = System.currentTimeMillis();
        this.f11801h = this.f11798e.getAppId();
        this.f11802i = this.f11798e.getSpaceId();
        this.f11796c = this.f11798e.getBuyerSpaceUuId();
        C3116af.m48495b("BeiZis", "AdWorker chanel = " + this.f11796c);
        ObserverAdStatus observerAdStatus = this.f11794a;
        if (observerAdStatus != null) {
            EventBean m48977a = observerAdStatus.m48860a().m48977a(this.f11796c);
            this.f11795b = m48977a;
            if (m48977a != null) {
                m47916s();
                if (!C3138av.m48301a("com.qq.e.comm.managers.GDTAdSdk")) {
                    m47915t();
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GdtSplashWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "GDT sdk not import , will do nothing");
                    return;
                }
                m47914u();
                GDTAdManagerHolder.m48638a(this.f12717q, this.f11801h);
                this.f11795b.m48885s(SDKStatus.getIntegrationSDKVersion());
                m47929au();
                m47913v();
            }
        }
        this.f12714n = this.f11798e.getReqTimeOutType();
        long sleepTime = this.f11799f.getSleepTime();
        if (this.f11797d.m48665v()) {
            sleepTime = Math.max(sleepTime, this.f11799f.getHotRequestDelay());
        }
        List<AdSpacesBean.RenderViewBean> list = this.f12725y;
        boolean z = list != null && list.size() > 0;
        this.f12701K = z;
        if (z) {
            m46342aI();
        }
        DownloadConfirmHelper.f11427a = !CheckDirectDownload.m48236a(this.f11798e.getDirectDownload());
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + sleepTime);
        if (sleepTime > 0) {
            this.f11806m.sendEmptyMessageDelayed(1, sleepTime);
        } else {
            BaseManager baseManager = this.f11797d;
            if (baseManager != null && baseManager.m48667t() < 1 && this.f11797d.m48668s() != 2) {
                mo46050l();
            }
        }
        this.f12706P = C3138av.m48286l(this.f12717q);
        this.f12707Q = C3138av.m48285m(this.f12717q);
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: f */
    public void mo46061f() {
        Log.d("BeiZis", mo46059g() + " out make show ad");
        m46343aH();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: i */
    public AdStatus mo46056i() {
        return this.f11803j;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: j */
    public String mo46054j() {
        SplashAD splashAD = this.f12724x;
        if (splashAD != null) {
            int m48440a = PriceUtil.m48440a(this.f11798e.getPriceDict(), splashAD.getECPMLevel());
            if (m48440a == -1 || m48440a == -2) {
                return null;
            }
            return m48440a + "";
        }
        return null;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: k */
    public AdSpacesBean.BuyerBean mo46052k() {
        return this.f11798e;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: l */
    protected void mo46050l() {
        int i;
        m47912w();
        m47943ag();
        long j = this.f12719s;
        int i2 = (int) j;
        int i3 = this.f12714n;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    j -= System.currentTimeMillis() - this.f12715o;
                }
                i = i2;
            }
            i2 = (int) j;
            i = i2;
        } else {
            i = 0;
        }
        C3116af.m48496a("BeiZis", "reqTimeOutType = " + this.f12714n + ",timeOut = " + i);
        m46340aK();
        if ("S2S".equalsIgnoreCase(this.f11798e.getBidType())) {
            this.f12724x = new SplashAD((Activity) this.f12717q, this.f11802i, new C3470a(), i, m47957aC());
        } else {
            this.f12724x = new SplashAD((Activity) this.f12717q, this.f11802i, new C3470a(), i);
        }
        this.f12724x.fetchAdOnly();
    }

    /* renamed from: b */
    private void m46336b() {
        View view;
        View.OnClickListener onClickListener;
        if (this.f12701K || (view = this.f12721u) == null || (onClickListener = this.f12716p) == null) {
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: d */
    public void mo46064d(int i) {
        SplashAD splashAD = this.f12724x;
        if (splashAD == null || splashAD.getECPM() <= 0 || this.f12720t) {
            return;
        }
        this.f12720t = true;
        C3116af.m48496a("BeiZis", "channel == GDT竞价失败:" + i);
        GDTAdManagerHolder.m48634b(this.f12724x, i != 1 ? 10001 : 1);
    }
}
