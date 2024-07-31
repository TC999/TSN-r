package com.beizi.fusion.work.splash;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
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
import com.beizi.fusion.p066d.ClickEyeManager;
import com.beizi.fusion.p066d.CompeteStatus;
import com.beizi.fusion.p066d.TTAdManagerHolder;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.p072g.RandomUtils;
import com.beizi.fusion.widget.CircleProgressView;
import com.beizi.fusion.widget.SkipView;
import com.beizi.fusion.work.AdWorker;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.github.mikephil.charting.utils.Utils;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.splash.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CsjSplashWorker extends AdWorker {

    /* renamed from: F */
    private long f12648F;

    /* renamed from: G */
    private boolean f12649G;

    /* renamed from: H */
    private CircleProgressView f12650H;

    /* renamed from: I */
    private AdSpacesBean.PositionBean f12651I;

    /* renamed from: J */
    private AdSpacesBean.PositionBean f12652J;

    /* renamed from: K */
    private long f12653K;

    /* renamed from: L */
    private float f12654L;

    /* renamed from: M */
    private float f12655M;

    /* renamed from: N */
    private AdSpacesBean.RenderViewBean f12656N;

    /* renamed from: O */
    private int f12657O;

    /* renamed from: P */
    private int f12658P;

    /* renamed from: Q */
    private String f12659Q;

    /* renamed from: R */
    private String f12660R;

    /* renamed from: S */
    private String f12661S;

    /* renamed from: T */
    private CSJSplashAd f12662T;

    /* renamed from: U */
    private long f12663U;

    /* renamed from: V */
    private int f12664V;

    /* renamed from: W */
    private int f12665W;

    /* renamed from: n */
    private Context f12666n;

    /* renamed from: o */
    private String f12667o;

    /* renamed from: p */
    private long f12668p;

    /* renamed from: q */
    private View f12669q;

    /* renamed from: r */
    private ViewGroup f12670r;

    /* renamed from: s */
    private ViewGroup f12671s;

    /* renamed from: t */
    private TTAdNative f12672t;

    /* renamed from: u */
    private CountDownTimer f12673u;

    /* renamed from: v */
    private View f12674v;

    /* renamed from: w */
    private List<AdSpacesBean.RenderViewBean> f12675w;

    /* renamed from: x */
    private List<AdSpacesBean.RenderViewBean> f12676x = new ArrayList();

    /* renamed from: y */
    private List<AdSpacesBean.RenderViewBean> f12677y = new ArrayList();

    /* renamed from: z */
    private boolean f12678z = false;

    /* renamed from: A */
    private boolean f12643A = false;

    /* renamed from: B */
    private boolean f12644B = false;

    /* renamed from: C */
    private boolean f12645C = false;

    /* renamed from: D */
    private boolean f12646D = false;

    /* renamed from: E */
    private long f12647E = 5000;

    public CsjSplashWorker(Context context, String str, long j, View view, ViewGroup viewGroup, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, List<AdSpacesBean.RenderViewBean> list, int i, int i2, BaseManager baseManager) {
        this.f12666n = context;
        this.f12667o = str;
        this.f12668p = j;
        this.f12669q = view;
        this.f12670r = viewGroup;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        this.f12671s = new SplashContainer(context);
        this.f12675w = list;
        this.f12664V = i;
        this.f12665W = i2;
        m47917r();
    }

    /* renamed from: aG */
    private void m46407aG() {
        CountDownTimer countDownTimer = this.f12673u;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(100 + this.f12647E, 50L) { // from class: com.beizi.fusion.work.splash.e.5
            @Override // android.os.CountDownTimer
            public void onFinish() {
                CsjSplashWorker.this.m47947ac();
                CsjSplashWorker.this.m47988G();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (((AdWorker) CsjSplashWorker.this).f11797d == null || ((AdWorker) CsjSplashWorker.this).f11797d.m48668s() == 2) {
                    return;
                }
                ((AdWorker) CsjSplashWorker.this).f11797d.m48752a(j);
            }
        };
        this.f12673u = countDownTimer2;
        countDownTimer2.start();
    }

    /* renamed from: aH */
    private void m46406aH() {
        for (int i = 0; i < this.f12675w.size(); i++) {
            AdSpacesBean.RenderViewBean renderViewBean = this.f12675w.get(i);
            String type = renderViewBean.getType();
            if ("SKIPVIEW".equals(type)) {
                this.f12677y.add(renderViewBean);
            } else if ("MATERIALVIEW".equals(type)) {
                this.f12676x.add(renderViewBean);
            }
        }
        this.f12648F = 0L;
        if (this.f12677y.size() > 0) {
            AdSpacesBean.RenderViewBean renderViewBean2 = this.f12677y.get(0);
            this.f12656N = renderViewBean2;
            if (renderViewBean2 != null) {
                this.f12652J = renderViewBean2.getTapPosition();
                this.f12651I = this.f12656N.getLayerPosition();
                long delayDisplaySkipButton = this.f12656N.getDelayDisplaySkipButton();
                this.f12653K = delayDisplaySkipButton;
                if (delayDisplaySkipButton < 0) {
                    this.f12653K = 0L;
                }
                long skipViewTotalTime = this.f12656N.getSkipViewTotalTime();
                if (skipViewTotalTime > 0) {
                    this.f12647E = skipViewTotalTime;
                }
                long skipUnavailableTime = this.f12656N.getSkipUnavailableTime();
                if (skipUnavailableTime > 0) {
                    this.f12648F = skipUnavailableTime;
                }
                this.f12657O = this.f12656N.getShowCountDown();
                this.f12658P = this.f12656N.getShowBorder();
                String skipText = this.f12656N.getSkipText();
                this.f12659Q = skipText;
                if (TextUtils.isEmpty(skipText)) {
                    this.f12659Q = "跳过";
                }
                String textColor = this.f12656N.getTextColor();
                this.f12660R = textColor;
                if (TextUtils.isEmpty(textColor)) {
                    this.f12660R = "#FFFFFF";
                }
                String countDownColor = this.f12656N.getCountDownColor();
                this.f12661S = countDownColor;
                if (TextUtils.isEmpty(countDownColor)) {
                    this.f12661S = "#FFFFFF";
                }
                List<AdSpacesBean.PassPolicyBean> passPolicy = this.f12656N.getPassPolicy();
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
                                this.f12643A = RandomUtils.m48438a(passPercent);
                                break;
                            case 1:
                                this.f12678z = RandomUtils.m48438a(passPercent);
                                break;
                            case 2:
                                AdSpacesBean.PositionBean positionBean = this.f12651I;
                                if (positionBean != null && this.f12652J != null) {
                                    double centerX = positionBean.getCenterX();
                                    double centerY = this.f12651I.getCenterY();
                                    double width = this.f12651I.getWidth();
                                    double height = this.f12651I.getHeight();
                                    double centerX2 = this.f12652J.getCenterX();
                                    double centerY2 = this.f12652J.getCenterY();
                                    double width2 = this.f12652J.getWidth();
                                    double height2 = this.f12652J.getHeight();
                                    if ((centerX > Utils.DOUBLE_EPSILON && centerX2 > Utils.DOUBLE_EPSILON && centerX != centerX2) || ((centerY > Utils.DOUBLE_EPSILON && centerY2 > Utils.DOUBLE_EPSILON && centerY != centerY2) || ((width > Utils.DOUBLE_EPSILON && width2 > Utils.DOUBLE_EPSILON && width != width2) || (height > Utils.DOUBLE_EPSILON && height2 > Utils.DOUBLE_EPSILON && height != height2)))) {
                                        this.f12644B = RandomUtils.m48438a(passPercent);
                                    }
                                    if (width2 * height2 < width * height) {
                                        this.f12645C = true;
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
        if (this.f12676x.size() > 0) {
            Collections.sort(this.f12676x, new Comparator<AdSpacesBean.RenderViewBean>() { // from class: com.beizi.fusion.work.splash.e.6
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(AdSpacesBean.RenderViewBean renderViewBean3, AdSpacesBean.RenderViewBean renderViewBean4) {
                    return renderViewBean4.getLevel() - renderViewBean3.getLevel();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aI */
    public void m46405aI() {
        if (this.f12678z) {
            m47978Q();
        }
        if (this.f12643A) {
            m47977R();
        }
        if (this.f12644B) {
            m47976S();
        }
        if (this.f12645C) {
            m47975T();
        }
        m46404aJ();
    }

    /* renamed from: aJ */
    private void m46404aJ() {
        CountDownTimer countDownTimer = this.f12673u;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        final long j = this.f12647E - this.f12648F;
        CountDownTimer countDownTimer2 = new CountDownTimer(this.f12647E + 100, 50L) { // from class: com.beizi.fusion.work.splash.e.7

            /* renamed from: a */
            boolean f12686a = false;

            @Override // android.os.CountDownTimer
            public void onFinish() {
                CsjSplashWorker.this.m47947ac();
                CsjSplashWorker.this.m47988G();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (!this.f12686a) {
                    CsjSplashWorker.this.m46400aN();
                    this.f12686a = true;
                }
                if (CsjSplashWorker.this.f12648F > 0 && CsjSplashWorker.this.f12648F <= CsjSplashWorker.this.f12647E) {
                    if (CsjSplashWorker.this.f12678z) {
                        long j3 = j;
                        if (j3 <= 0 || j2 <= j3) {
                            CsjSplashWorker.this.f12646D = false;
                            CsjSplashWorker.this.f12669q.setAlpha(1.0f);
                        } else {
                            CsjSplashWorker.this.f12646D = true;
                            CsjSplashWorker.this.f12669q.setAlpha(0.2f);
                        }
                    }
                    if (CsjSplashWorker.this.f12648F == CsjSplashWorker.this.f12647E) {
                        CsjSplashWorker.this.f12669q.setEnabled(false);
                    } else {
                        CsjSplashWorker.this.f12669q.setEnabled(true);
                    }
                }
                if (CsjSplashWorker.this.f12649G && CsjSplashWorker.this.f12669q != null) {
                    CsjSplashWorker.this.m46388e(Math.round(((float) j2) / 1000.0f));
                }
                if (((AdWorker) CsjSplashWorker.this).f11797d == null || ((AdWorker) CsjSplashWorker.this).f11797d.m48668s() == 2) {
                    return;
                }
                ((AdWorker) CsjSplashWorker.this).f11797d.m48752a(j2);
            }
        };
        this.f12673u = countDownTimer2;
        countDownTimer2.start();
        m46401aM();
    }

    /* renamed from: aK */
    private void m46403aK() {
        ViewGroup viewGroup;
        if (this.f12649G) {
            if (this.f12651I != null && (viewGroup = this.f12670r) != null) {
                float f = this.f12654L;
                float height = viewGroup.getHeight();
                if (height == 0.0f) {
                    height = this.f12655M - C3138av.m48304a(this.f12666n, 100.0f);
                }
                double d = f;
                Double.isNaN(d);
                int width = (int) (d * this.f12651I.getWidth() * 0.01d);
                if (this.f12651I.getHeight() >= 12.0d) {
                    double d2 = width;
                    Double.isNaN(d2);
                    int height2 = (int) (d2 * this.f12651I.getHeight() * 0.01d);
                    double d3 = height2;
                    Double.isNaN(d3);
                    int paddingHeight = (int) (d3 * this.f12656N.getPaddingHeight() * 0.01d);
                    if (paddingHeight < 0) {
                        paddingHeight = 0;
                    }
                    ((SkipView) this.f12669q).setData(this.f12658P, paddingHeight);
                    m46388e(5);
                    this.f12671s.addView(this.f12669q, new FrameLayout.LayoutParams(width, height2));
                    float centerX = (f * ((float) (this.f12651I.getCenterX() * 0.01d))) - (width / 2);
                    float centerY = (height * ((float) (this.f12651I.getCenterY() * 0.01d))) - (height2 / 2);
                    this.f12669q.setX(centerX);
                    this.f12669q.setY(centerY);
                    View view = this.f12669q;
                    if (view != null) {
                        view.setVisibility(0);
                        return;
                    }
                    return;
                }
                m46402aL();
                return;
            }
            m46402aL();
            return;
        }
        View view2 = this.f12669q;
        if (view2 != null) {
            view2.setVisibility(0);
            this.f12669q.setAlpha(1.0f);
        }
    }

    /* renamed from: aL */
    private void m46402aL() {
        double d = this.f12654L;
        Double.isNaN(d);
        int i = (int) (d * 0.15d);
        double d2 = i;
        Double.isNaN(d2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (int) (d2 * 0.45d));
        layoutParams.gravity = 53;
        layoutParams.topMargin = C3138av.m48304a(this.f12666n, 20.0f);
        layoutParams.rightMargin = C3138av.m48304a(this.f12666n, 20.0f);
        ViewGroup viewGroup = this.f12671s;
        if (viewGroup != null) {
            viewGroup.addView(this.f12669q, layoutParams);
        }
        View view = this.f12669q;
        if (view != null) {
            this.f12657O = 1;
            this.f12658P = 1;
            ((SkipView) view).setData(1, 0);
            ((SkipView) this.f12669q).setText(String.format("跳过 %d", 5));
            this.f12669q.setVisibility(0);
        }
    }

    /* renamed from: aM */
    private void m46401aM() {
        CircleProgressView circleProgressView = new CircleProgressView(this.f12666n);
        this.f12650H = circleProgressView;
        circleProgressView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.work.splash.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CsjSplashWorker.this.m47987H();
                if (CsjSplashWorker.this.f12673u != null) {
                    CsjSplashWorker.this.f12673u.cancel();
                }
                CsjSplashWorker.this.m47947ac();
            }
        });
        this.f12650H.setAlpha(0.0f);
        this.f12671s.addView(this.f12650H, new FrameLayout.LayoutParams(-2, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aN */
    public void m46400aN() {
        int[] iArr;
        float f;
        float f2;
        ViewGroup viewGroup;
        this.f12669q.getLocationOnScreen(new int[2]);
        if (this.f12652J != null) {
            float f3 = this.f12654L;
            float height = this.f12670r != null ? viewGroup.getHeight() : 0.0f;
            if (height == 0.0f) {
                height = this.f12655M - C3138av.m48304a(this.f12666n, 100.0f);
            }
            double d = f3;
            Double.isNaN(d);
            int width = (int) (d * this.f12652J.getWidth() * 0.01d);
            double d2 = width;
            Double.isNaN(d2);
            int height2 = (int) (d2 * this.f12652J.getHeight() * 0.01d);
            ViewGroup.LayoutParams layoutParams = this.f12650H.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height2;
            this.f12650H.setLayoutParams(layoutParams);
            f = (f3 * ((float) (this.f12652J.getCenterX() * 0.01d))) - (width / 2);
            f2 = (height * ((float) (this.f12652J.getCenterY() * 0.01d))) - (height2 / 2);
        } else {
            float pivotX = (iArr[0] + this.f12669q.getPivotX()) - (this.f12650H.getWidth() / 2);
            float pivotY = (iArr[1] + this.f12669q.getPivotY()) - (this.f12650H.getHeight() / 2);
            f = pivotX;
            f2 = pivotY;
        }
        this.f12650H.setX(f);
        this.f12650H.setY(f2);
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: ay */
    public void mo46297ay() {
        m47913v();
        mo46389e();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "CSJ";
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: d */
    public void mo46065d() {
        if (this.f11797d == null || this.f12666n == null) {
            return;
        }
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
                if (!C3138av.m48301a("com.bytedance.sdk.openadsdk.TTAdNative")) {
                    m47915t();
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.e.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CsjSplashWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "CSJ sdk not import , will do nothing");
                    return;
                }
                m47914u();
                TTAdManagerHolder.m48592a(this, this.f12666n, this.f11801h, this.f11798e.getDirectDownload());
                this.f11795b.m48883t(TTAdSdk.getAdManager().getSDKVersion());
                m47929au();
            }
        }
        this.f12663U = this.f11799f.getSleepTime();
        if (this.f11797d.m48665v()) {
            this.f12663U = Math.max(this.f12663U, this.f11799f.getHotRequestDelay());
        }
        List<AdSpacesBean.RenderViewBean> list = this.f12675w;
        boolean z = list != null && list.size() > 0;
        this.f12649G = z;
        if (z) {
            m46406aH();
        }
        this.f12654L = C3138av.m48286l(this.f12666n);
        this.f12655M = C3138av.m48285m(this.f12666n);
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: e */
    public void mo46389e() {
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + this.f12663U);
        long j = this.f12663U;
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

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: f */
    public void mo46061f() {
        Log.d("BeiZis", mo46059g() + " out make show ad");
        m46399b();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: i */
    public AdStatus mo46056i() {
        return this.f11803j;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: k */
    public AdSpacesBean.BuyerBean mo46052k() {
        return this.f11798e;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: l */
    protected void mo46050l() {
        AdSlot build;
        m47912w();
        m47943ag();
        this.f12674v = null;
        ClickEyeManager.m48654a().m48650a(mo46059g(), false, false);
        if (m47928av()) {
            return;
        }
        if (this.f12664V == 0) {
            this.f12664V = (int) C3138av.m48288j(this.f12666n);
        }
        if (this.f12665W == 0) {
            this.f12665W = (int) C3138av.m48287k(this.f12666n);
        }
        int m48304a = C3138av.m48304a(this.f12666n, this.f12665W);
        int m48304a2 = C3138av.m48304a(this.f12666n, this.f12664V);
        C3116af.m48496a("BeiZis", "splashWidthPx = " + m48304a2 + ",splashHeightPx = " + m48304a);
        this.f12672t = TTAdManagerHolder.m48594a().createAdNative(this.f12666n);
        BaseManager baseManager = this.f11797d;
        if (baseManager != null && baseManager.m48662y()) {
            build = new AdSlot.Builder().setCodeId(this.f11802i).setSupportDeepLink(true).setImageAcceptedSize(m48304a2, m48304a).setExpressViewAcceptedSize(this.f12664V, this.f12665W).build();
        } else {
            build = new AdSlot.Builder().setCodeId(this.f11802i).setSupportDeepLink(true).setImageAcceptedSize(m48304a2, m48304a).setExpressViewAcceptedSize(this.f12664V, this.f12665W).build();
        }
        this.f12672t.loadSplashAd(build, new TTAdNative.CSJSplashAdListener() { // from class: com.beizi.fusion.work.splash.e.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashLoadFail(CSJAdError cSJAdError) {
                Log.d("BeiZis", "showCsjSplash onSplashLoadFail code:" + cSJAdError.getCode() + ";" + cSJAdError.getMsg());
                CsjSplashWorker.this.m47961a(cSJAdError.getMsg(), cSJAdError.getCode());
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashLoadSuccess(CSJSplashAd cSJSplashAd) {
                Log.d("BeiZis", "showCsjSplash onSplashLoadSuccess()");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashRenderFail(CSJSplashAd cSJSplashAd, CSJAdError cSJAdError) {
                Log.d("BeiZis", "showCsjSplash onSplashRenderFail code:" + cSJAdError.getCode() + ";" + cSJAdError.getMsg());
                CsjSplashWorker.this.m47961a(cSJAdError.getMsg(), cSJAdError.getCode());
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashRenderSuccess(CSJSplashAd cSJSplashAd) {
                Log.d("BeiZis", "showCsjSplash onSplashRenderSuccess()");
                CsjSplashWorker.this.f12662T = cSJSplashAd;
                ((AdWorker) CsjSplashWorker.this).f11803j = AdStatus.ADLOAD;
                CsjSplashWorker.this.m47910y();
                if (cSJSplashAd == null) {
                    CsjSplashWorker.this.m47921c(-991);
                    return;
                }
                if (!CsjSplashWorker.this.m47970Y()) {
                    CsjSplashWorker.this.m47980O();
                } else {
                    CsjSplashWorker.this.m46408a(cSJSplashAd);
                }
                cSJSplashAd.setSplashAdListener(new CSJSplashAd.SplashAdListener() { // from class: com.beizi.fusion.work.splash.e.2.1
                    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                    public void onSplashAdClick(CSJSplashAd cSJSplashAd2) {
                        Log.d("BeiZis", "showCsjSplash onSplashAdClick()");
                        CsjSplashWorker.this.m47990E();
                        if (((AdWorker) CsjSplashWorker.this).f11797d != null) {
                            if (((AdWorker) CsjSplashWorker.this).f11797d.m48668s() != 2) {
                                ((AdWorker) CsjSplashWorker.this).f11797d.m48700d(CsjSplashWorker.this.mo46059g());
                                ((AdWorker) CsjSplashWorker.this).f11806m.sendEmptyMessageDelayed(2, (((AdWorker) CsjSplashWorker.this).f11805l + 5000) - System.currentTimeMillis());
                            }
                            CsjSplashWorker.this.m47941ai();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                    public void onSplashAdClose(CSJSplashAd cSJSplashAd2, int i) {
                        Log.d("BeiZis", "showCsjSplash onSplashAdClose()");
                        if (((AdWorker) CsjSplashWorker.this).f11797d != null && ((AdWorker) CsjSplashWorker.this).f11797d.m48668s() != 2) {
                            CsjSplashWorker.this.m47947ac();
                        }
                        if (i == 1) {
                            CsjSplashWorker.this.m47987H();
                        }
                        CsjSplashWorker.this.m47988G();
                    }

                    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                    public void onSplashAdShow(CSJSplashAd cSJSplashAd2) {
                        Log.d("BeiZis", "showCsjSplash onSplashAdShow()");
                        ((AdWorker) CsjSplashWorker.this).f11803j = AdStatus.ADSHOW;
                        CsjSplashWorker.this.mo47585ab();
                        CsjSplashWorker.this.m47992C();
                        CsjSplashWorker.this.m47991D();
                        CsjSplashWorker.this.m47942ah();
                    }
                });
            }
        }, (int) this.f12668p);
    }

    /* renamed from: b */
    private void m46399b() {
        CSJSplashAd cSJSplashAd = this.f12662T;
        if (cSJSplashAd != null) {
            this.f12674v = cSJSplashAd.getSplashView();
            if (C3138av.m48301a("com.bytedance.sdk.openadsdk.ISplashClickEyeListener")) {
                m46415a(this.f12666n, this.f12662T, this.f12674v);
            } else {
                Log.d("BeiZis", "CSJ sdk is not Support SplashClickEye");
            }
            if (this.f12671s != null && this.f12670r != null) {
                m46393b(this.f12662T);
                this.f12671s.removeAllViews();
                this.f12671s.addView(this.f12674v);
                m46403aK();
                this.f12670r.removeAllViews();
                this.f12670r.addView(this.f12671s);
                return;
            }
            m47927aw();
            return;
        }
        m47927aw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m46408a(CSJSplashAd cSJSplashAd) {
        BaseManager baseManager = this.f11797d;
        if (baseManager == null) {
            return;
        }
        Map<String, AdWorker> m48669r = baseManager.m48669r();
        Log.d("BeiZis", mo46059g() + " splashWorkers:" + m48669r.toString());
        m47969Z();
        CompeteStatus competeStatus = this.f11800g;
        if (competeStatus == CompeteStatus.SUCCESS) {
            m47946ad();
        } else if (competeStatus == CompeteStatus.FAIL) {
            Log.d("BeiZis", "other worker shown," + mo46059g() + " remove");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m46388e(int i) {
        if (this.f12657O == 1) {
            String valueOf = String.valueOf(i);
            String str = this.f12659Q + " ";
            String str2 = str + valueOf;
            SpannableString spannableString = new SpannableString(str2);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.f12660R)), 0, str.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.f12661S)), str2.indexOf(valueOf), str2.length(), 33);
            ((SkipView) this.f12669q).setText(spannableString);
            return;
        }
        SpannableString spannableString2 = new SpannableString(this.f12659Q);
        spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor(this.f12660R)), 0, this.f12659Q.length(), 33);
        ((SkipView) this.f12669q).setText(spannableString2);
    }

    /* renamed from: a */
    private void m46415a(Context context, CSJSplashAd cSJSplashAd, View view) {
        Activity activity = (Activity) context;
        if (activity == null || cSJSplashAd == null || view == null) {
            return;
        }
        CsjClickEyeManager m46515a = CsjClickEyeManager.m46515a(context);
        cSJSplashAd.setSplashClickEyeListener(new CSJSplashAd.SplashClickEyeListener() { // from class: com.beizi.fusion.work.splash.e.9
            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
            public void onSplashClickEyeClick() {
                Log.d("BeiZis", "showCsjSplash onSplashClickEyeClick() ");
            }

            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
            public void onSplashClickEyeClose() {
                Log.d("BeiZis", "showCsjSplash onSplashClickEyeClose() ");
            }

            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
            public void onSplashClickEyeReadyToShow(CSJSplashAd cSJSplashAd2) {
                Log.d("BeiZis", "showCsjSplash onSplashClickEyeReadyToShow() ");
                ClickEyeManager.m48654a().m48650a(CsjSplashWorker.this.mo46059g(), true, true);
                boolean m48649b = ClickEyeManager.m48654a().m48649b();
                if (((AdWorker) CsjSplashWorker.this).f11795b != null) {
                    ((AdWorker) CsjSplashWorker.this).f11795b.m48946K(m48649b ? "2" : "0");
                    CsjSplashWorker.this.m47929au();
                }
            }
        });
        m46515a.m46514a(context, cSJSplashAd, view, activity.getWindow().getDecorView());
    }

    /* renamed from: b */
    private void m46393b(CSJSplashAd cSJSplashAd) {
        String str;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.beizi.fusion.work.splash.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CsjSplashWorker.this.f12673u != null) {
                    CsjSplashWorker.this.f12673u.cancel();
                }
                CsjSplashWorker.this.m47947ac();
            }
        };
        if (this.f12649G) {
            if (cSJSplashAd != null) {
                cSJSplashAd.hideSkipButton();
            }
            View view = this.f12669q;
            if (view != null) {
                view.setVisibility(8);
                view.setAlpha(0.0f);
            }
            SkipView skipView = new SkipView(this.f12666n);
            this.f12669q = skipView;
            skipView.setOnClickListener(onClickListener);
            this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.e.4
                @Override // java.lang.Runnable
                public void run() {
                    CsjSplashWorker.this.m46405aI();
                }
            }, this.f12653K);
            str = "beizi";
        } else if (this.f12669q != null) {
            if (cSJSplashAd != null) {
                cSJSplashAd.hideSkipButton();
            }
            this.f12669q.setOnClickListener(onClickListener);
            m46407aG();
            str = Constants.JumpUrlConstants.SRC_TYPE_APP;
        } else {
            str = "buyer";
        }
        EventBean eventBean = this.f11795b;
        if (eventBean != null) {
            eventBean.m48887r(str);
            m47929au();
        }
    }
}
