package com.beizi.fusion.work.splash;

import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.ObserverAdStatus;
import com.beizi.fusion.p066d.AdShowObserver;
import com.beizi.fusion.p066d.BaseManager;
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
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.github.mikephil.charting.utils.Utils;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.splash.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CsjNSTWorker extends AdWorker implements AdShowObserver {

    /* renamed from: G */
    private long f12596G;

    /* renamed from: H */
    private boolean f12597H;

    /* renamed from: I */
    private CircleProgressView f12598I;

    /* renamed from: J */
    private AdSpacesBean.PositionBean f12599J;

    /* renamed from: K */
    private AdSpacesBean.PositionBean f12600K;

    /* renamed from: L */
    private long f12601L;

    /* renamed from: M */
    private float f12602M;

    /* renamed from: N */
    private float f12603N;

    /* renamed from: O */
    private float f12604O;

    /* renamed from: P */
    private float f12605P;

    /* renamed from: Q */
    private float f12606Q;

    /* renamed from: R */
    private float f12607R;

    /* renamed from: S */
    private AdSpacesBean.RenderViewBean f12608S;

    /* renamed from: T */
    private int f12609T;

    /* renamed from: U */
    private int f12610U;

    /* renamed from: V */
    private String f12611V;

    /* renamed from: W */
    private String f12612W;

    /* renamed from: X */
    private String f12613X;

    /* renamed from: Y */
    private long f12614Y;

    /* renamed from: n */
    private Context f12615n;

    /* renamed from: o */
    private String f12616o;

    /* renamed from: p */
    private long f12617p;

    /* renamed from: q */
    private View f12618q;

    /* renamed from: r */
    private ViewGroup f12619r;

    /* renamed from: s */
    private ViewGroup f12620s;

    /* renamed from: t */
    private TTAdNative f12621t;

    /* renamed from: u */
    private TTNativeExpressAd f12622u;

    /* renamed from: v */
    private CountDownTimer f12623v;

    /* renamed from: w */
    private View f12624w;

    /* renamed from: x */
    private List<AdSpacesBean.RenderViewBean> f12625x;

    /* renamed from: y */
    private List<AdSpacesBean.RenderViewBean> f12626y = new ArrayList();

    /* renamed from: z */
    private List<AdSpacesBean.RenderViewBean> f12627z = new ArrayList();

    /* renamed from: A */
    private boolean f12590A = false;

    /* renamed from: B */
    private boolean f12591B = false;

    /* renamed from: C */
    private boolean f12592C = false;

    /* renamed from: D */
    private boolean f12593D = false;

    /* renamed from: E */
    private boolean f12594E = false;

    /* renamed from: F */
    private long f12595F = 5000;

    public CsjNSTWorker(Context context, String str, long j, View view, ViewGroup viewGroup, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, List<AdSpacesBean.RenderViewBean> list, BaseManager baseManager) {
        this.f12615n = context;
        this.f12616o = str;
        this.f12617p = j;
        this.f12618q = view;
        this.f12619r = viewGroup;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        this.f12620s = new SplashContainer(context);
        this.f12625x = list;
        m47917r();
    }

    /* renamed from: aG */
    private void m46477aG() {
        CountDownTimer countDownTimer = this.f12623v;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(100 + this.f12595F, 50L) { // from class: com.beizi.fusion.work.splash.d.5
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (((AdWorker) CsjNSTWorker.this).f11797d == null) {
                    return;
                }
                ((AdWorker) CsjNSTWorker.this).f11797d.m48704c(CsjNSTWorker.this.mo46059g());
                CsjNSTWorker.this.m47988G();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (CsjNSTWorker.this.f12597H && CsjNSTWorker.this.f12618q != null) {
                    CsjNSTWorker.this.m46457e(Math.round(((float) j) / 1000.0f));
                }
                if (((AdWorker) CsjNSTWorker.this).f11797d == null || ((AdWorker) CsjNSTWorker.this).f11797d.m48668s() == 2) {
                    return;
                }
                ((AdWorker) CsjNSTWorker.this).f11797d.m48752a(j);
            }
        };
        this.f12623v = countDownTimer2;
        countDownTimer2.start();
    }

    /* renamed from: aH */
    private void m46476aH() {
        ViewGroup viewGroup = this.f12620s;
        if (viewGroup != null && this.f12619r != null && this.f12624w != null) {
            viewGroup.removeAllViews();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.f12606Q, (int) this.f12607R);
            if (this.f12607R < 1200.0f) {
                layoutParams.gravity = 16;
            }
            this.f12620s.addView(this.f12624w, layoutParams);
            final ViewGroup viewGroup2 = this.f12619r;
            if (viewGroup2 instanceof ViewGroup) {
                viewGroup2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.beizi.fusion.work.splash.d.6
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        if (viewGroup2 == null) {
                            return;
                        }
                        float height = CsjNSTWorker.this.f12619r.getHeight();
                        if (CsjNSTWorker.this.f12607R > height) {
                            float f = height / CsjNSTWorker.this.f12607R;
                            CsjNSTWorker.this.f12624w.setPivotY(0.0f);
                            CsjNSTWorker.this.f12624w.setScaleY(f);
                        }
                        viewGroup2.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                });
            }
            m46475aI();
            m46471aM();
            this.f12619r.removeAllViews();
            this.f12619r.addView(this.f12620s);
            return;
        }
        m47927aw();
    }

    /* renamed from: aI */
    private void m46475aI() {
        String str;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.beizi.fusion.work.splash.d.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CsjNSTWorker.this.f12623v != null) {
                    CsjNSTWorker.this.f12623v.cancel();
                }
                if (((AdWorker) CsjNSTWorker.this).f11797d != null) {
                    ((AdWorker) CsjNSTWorker.this).f11797d.m48704c(CsjNSTWorker.this.mo46059g());
                }
            }
        };
        if (this.f12597H) {
            View view = this.f12618q;
            if (view != null) {
                view.setVisibility(8);
                view.setAlpha(0.0f);
            }
            SkipView skipView = new SkipView(this.f12615n);
            this.f12618q = skipView;
            skipView.setOnClickListener(onClickListener);
            this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.d.8
                @Override // java.lang.Runnable
                public void run() {
                    CsjNSTWorker.this.m46473aK();
                }
            }, this.f12601L);
            str = "beizi";
        } else {
            View view2 = this.f12618q;
            if (view2 != null) {
                view2.setOnClickListener(onClickListener);
                m46477aG();
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
    }

    /* renamed from: aJ */
    private void m46474aJ() {
        for (int i = 0; i < this.f12625x.size(); i++) {
            AdSpacesBean.RenderViewBean renderViewBean = this.f12625x.get(i);
            String type = renderViewBean.getType();
            if ("SKIPVIEW".equals(type)) {
                this.f12627z.add(renderViewBean);
            } else if ("MATERIALVIEW".equals(type)) {
                this.f12626y.add(renderViewBean);
            }
        }
        this.f12596G = 0L;
        if (this.f12627z.size() > 0) {
            AdSpacesBean.RenderViewBean renderViewBean2 = this.f12627z.get(0);
            this.f12608S = renderViewBean2;
            if (renderViewBean2 != null) {
                this.f12600K = renderViewBean2.getTapPosition();
                this.f12599J = this.f12608S.getLayerPosition();
                long delayDisplaySkipButton = this.f12608S.getDelayDisplaySkipButton();
                this.f12601L = delayDisplaySkipButton;
                if (delayDisplaySkipButton < 0) {
                    this.f12601L = 0L;
                }
                long skipViewTotalTime = this.f12608S.getSkipViewTotalTime();
                if (skipViewTotalTime > 0) {
                    this.f12595F = skipViewTotalTime;
                }
                long skipUnavailableTime = this.f12608S.getSkipUnavailableTime();
                if (skipUnavailableTime > 0) {
                    this.f12596G = skipUnavailableTime;
                }
                this.f12609T = this.f12608S.getShowCountDown();
                this.f12610U = this.f12608S.getShowBorder();
                String skipText = this.f12608S.getSkipText();
                this.f12611V = skipText;
                if (TextUtils.isEmpty(skipText)) {
                    this.f12611V = "跳过";
                }
                String textColor = this.f12608S.getTextColor();
                this.f12612W = textColor;
                if (TextUtils.isEmpty(textColor)) {
                    this.f12612W = "#FFFFFF";
                }
                String countDownColor = this.f12608S.getCountDownColor();
                this.f12613X = countDownColor;
                if (TextUtils.isEmpty(countDownColor)) {
                    this.f12613X = "#FFFFFF";
                }
                List<AdSpacesBean.PassPolicyBean> passPolicy = this.f12608S.getPassPolicy();
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
                                this.f12591B = RandomUtils.m48438a(passPercent);
                                break;
                            case 1:
                                this.f12590A = RandomUtils.m48438a(passPercent);
                                break;
                            case 2:
                                AdSpacesBean.PositionBean positionBean = this.f12599J;
                                if (positionBean != null && this.f12600K != null) {
                                    double centerX = positionBean.getCenterX();
                                    double centerY = this.f12599J.getCenterY();
                                    double width = this.f12599J.getWidth();
                                    double height = this.f12599J.getHeight();
                                    double centerX2 = this.f12600K.getCenterX();
                                    double centerY2 = this.f12600K.getCenterY();
                                    double width2 = this.f12600K.getWidth();
                                    double height2 = this.f12600K.getHeight();
                                    if ((centerX > Utils.DOUBLE_EPSILON && centerX2 > Utils.DOUBLE_EPSILON && centerX != centerX2) || ((centerY > Utils.DOUBLE_EPSILON && centerY2 > Utils.DOUBLE_EPSILON && centerY != centerY2) || ((width > Utils.DOUBLE_EPSILON && width2 > Utils.DOUBLE_EPSILON && width != width2) || (height > Utils.DOUBLE_EPSILON && height2 > Utils.DOUBLE_EPSILON && height != height2)))) {
                                        this.f12592C = RandomUtils.m48438a(passPercent);
                                    }
                                    if (width2 * height2 < width * height) {
                                        this.f12593D = true;
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
        if (this.f12626y.size() > 0) {
            Collections.sort(this.f12626y, new Comparator<AdSpacesBean.RenderViewBean>() { // from class: com.beizi.fusion.work.splash.d.9
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(AdSpacesBean.RenderViewBean renderViewBean3, AdSpacesBean.RenderViewBean renderViewBean4) {
                    return renderViewBean4.getLevel() - renderViewBean3.getLevel();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aK */
    public void m46473aK() {
        if (this.f12590A) {
            m47978Q();
        }
        if (this.f12591B) {
            m47977R();
        }
        if (this.f12592C) {
            m47976S();
        }
        if (this.f12593D) {
            m47975T();
        }
        m46472aL();
    }

    /* renamed from: aL */
    private void m46472aL() {
        CountDownTimer countDownTimer = this.f12623v;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        final long j = this.f12595F - this.f12596G;
        CountDownTimer countDownTimer2 = new CountDownTimer(this.f12595F + 100, 50L) { // from class: com.beizi.fusion.work.splash.d.10

            /* renamed from: a */
            boolean f12629a = false;

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (((AdWorker) CsjNSTWorker.this).f11797d == null) {
                    return;
                }
                ((AdWorker) CsjNSTWorker.this).f11797d.m48704c(CsjNSTWorker.this.mo46059g());
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (!this.f12629a) {
                    CsjNSTWorker.this.m46468aP();
                    this.f12629a = true;
                }
                if (CsjNSTWorker.this.f12596G > 0 && CsjNSTWorker.this.f12596G <= CsjNSTWorker.this.f12595F) {
                    if (CsjNSTWorker.this.f12590A) {
                        long j3 = j;
                        if (j3 <= 0 || j2 <= j3) {
                            CsjNSTWorker.this.f12594E = false;
                            CsjNSTWorker.this.f12618q.setAlpha(1.0f);
                        } else {
                            CsjNSTWorker.this.f12594E = true;
                            CsjNSTWorker.this.f12618q.setAlpha(0.2f);
                        }
                    }
                    if (CsjNSTWorker.this.f12596G == CsjNSTWorker.this.f12595F) {
                        CsjNSTWorker.this.f12618q.setEnabled(false);
                    } else {
                        CsjNSTWorker.this.f12618q.setEnabled(true);
                    }
                }
                if (CsjNSTWorker.this.f12597H && CsjNSTWorker.this.f12618q != null) {
                    ((SkipView) CsjNSTWorker.this.f12618q).setText(String.format("跳过 %d", Integer.valueOf(Math.round(((float) j2) / 1000.0f))));
                }
                if (((AdWorker) CsjNSTWorker.this).f11797d == null || ((AdWorker) CsjNSTWorker.this).f11797d.m48668s() == 2) {
                    return;
                }
                ((AdWorker) CsjNSTWorker.this).f11797d.m48752a(j2);
            }
        };
        this.f12623v = countDownTimer2;
        countDownTimer2.start();
        m46469aO();
    }

    /* renamed from: aM */
    private void m46471aM() {
        ViewGroup viewGroup;
        if (this.f12597H) {
            if (this.f12599J != null && (viewGroup = this.f12619r) != null) {
                float f = this.f12602M;
                float height = viewGroup.getHeight();
                if (height == 0.0f) {
                    height = this.f12603N - C3138av.m48304a(this.f12615n, 100.0f);
                }
                double d = f;
                Double.isNaN(d);
                int width = (int) (d * this.f12599J.getWidth() * 0.01d);
                double d2 = width;
                Double.isNaN(d2);
                int height2 = (int) (d2 * this.f12599J.getHeight() * 0.01d);
                double d3 = height2;
                Double.isNaN(d3);
                int paddingHeight = (int) (d3 * this.f12608S.getPaddingHeight() * 0.01d);
                if (paddingHeight < 0) {
                    paddingHeight = 0;
                }
                ((SkipView) this.f12618q).setData(this.f12610U, paddingHeight);
                m46457e(5);
                this.f12620s.addView(this.f12618q, new FrameLayout.LayoutParams(width, height2));
                float centerX = (f * ((float) (this.f12599J.getCenterX() * 0.01d))) - (width / 2);
                float centerY = (height * ((float) (this.f12599J.getCenterY() * 0.01d))) - (height2 / 2);
                this.f12618q.setX(centerX);
                this.f12618q.setY(centerY);
                View view = this.f12618q;
                if (view != null) {
                    view.setVisibility(0);
                    return;
                }
                return;
            }
            m46470aN();
            return;
        }
        View view2 = this.f12618q;
        if (view2 != null) {
            view2.setVisibility(0);
            this.f12618q.setAlpha(1.0f);
        }
    }

    /* renamed from: aN */
    private void m46470aN() {
        double d = this.f12602M;
        Double.isNaN(d);
        int i = (int) (d * 0.15d);
        double d2 = i;
        Double.isNaN(d2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (int) (d2 * 0.45d));
        layoutParams.gravity = 53;
        layoutParams.topMargin = C3138av.m48304a(this.f12615n, 20.0f);
        layoutParams.rightMargin = C3138av.m48304a(this.f12615n, 20.0f);
        ViewGroup viewGroup = this.f12620s;
        if (viewGroup != null) {
            viewGroup.addView(this.f12618q, layoutParams);
        }
        View view = this.f12618q;
        if (view != null) {
            this.f12609T = 1;
            this.f12610U = 1;
            ((SkipView) view).setData(1, 0);
            ((SkipView) this.f12618q).setText(String.format("跳过 %d", 5));
            this.f12618q.setVisibility(0);
        }
    }

    /* renamed from: aO */
    private void m46469aO() {
        CircleProgressView circleProgressView = new CircleProgressView(this.f12615n);
        this.f12598I = circleProgressView;
        circleProgressView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.work.splash.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CsjNSTWorker.this.m47987H();
                if (CsjNSTWorker.this.f12623v != null) {
                    CsjNSTWorker.this.f12623v.cancel();
                }
                if (((AdWorker) CsjNSTWorker.this).f11797d != null) {
                    ((AdWorker) CsjNSTWorker.this).f11797d.m48704c(CsjNSTWorker.this.mo46059g());
                }
            }
        });
        this.f12598I.setAlpha(0.0f);
        this.f12620s.addView(this.f12598I, new FrameLayout.LayoutParams(-2, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aP */
    public void m46468aP() {
        int[] iArr;
        float f;
        float f2;
        ViewGroup viewGroup;
        this.f12618q.getLocationOnScreen(new int[2]);
        if (this.f12600K != null) {
            float f3 = this.f12602M;
            float height = this.f12619r != null ? viewGroup.getHeight() : 0.0f;
            if (height == 0.0f) {
                height = this.f12603N - C3138av.m48304a(this.f12615n, 100.0f);
            }
            double d = f3;
            Double.isNaN(d);
            int width = (int) (d * this.f12600K.getWidth() * 0.01d);
            double d2 = width;
            Double.isNaN(d2);
            int height2 = (int) (d2 * this.f12600K.getHeight() * 0.01d);
            ViewGroup.LayoutParams layoutParams = this.f12598I.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height2;
            this.f12598I.setLayoutParams(layoutParams);
            f = (f3 * ((float) (this.f12600K.getCenterX() * 0.01d))) - (width / 2);
            f2 = (height * ((float) (this.f12600K.getCenterY() * 0.01d))) - (height2 / 2);
        } else {
            float pivotX = (iArr[0] + this.f12618q.getPivotX()) - (this.f12598I.getWidth() / 2);
            float pivotY = (iArr[1] + this.f12618q.getPivotY()) - (this.f12598I.getHeight() / 2);
            f = pivotX;
            f2 = pivotY;
        }
        this.f12598I.setX(f);
        this.f12598I.setY(f2);
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
        return "CSJ_NST";
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: d */
    public void mo46065d() {
        if (this.f11797d == null) {
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
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.d.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CsjNSTWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "CSJ sdk not import , will do nothing");
                    return;
                }
                m47914u();
                TTAdManagerHolder.m48592a(this, this.f12615n, this.f11801h, this.f11798e.getDirectDownload());
                this.f11795b.m48883t(TTAdSdk.getAdManager().getSDKVersion());
                m47929au();
            }
        }
        this.f12614Y = this.f11799f.getSleepTime();
        if (this.f11797d.m48665v()) {
            this.f12614Y = Math.max(this.f12614Y, this.f11799f.getHotRequestDelay());
        }
        List<AdSpacesBean.RenderViewBean> list = this.f12625x;
        boolean z = list != null && list.size() > 0;
        this.f12597H = z;
        if (z) {
            m46474aJ();
        }
        this.f12602M = C3138av.m48286l(this.f12615n);
        this.f12603N = C3138av.m48285m(this.f12615n);
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: e */
    public void mo46389e() {
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + this.f12614Y);
        long j = this.f12614Y;
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
        m46476aH();
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
        m47912w();
        m47943ag();
        this.f12624w = null;
        if (m47928av()) {
            return;
        }
        this.f12621t = TTAdManagerHolder.m48594a().createAdNative(this.f12615n);
        this.f12604O = C3138av.m48288j(this.f12615n);
        this.f12605P = 0.0f;
        this.f12621t.loadNativeExpressAd(new AdSlot.Builder().setCodeId(this.f11802i).setSupportDeepLink(true).setAdCount(1).setExpressViewAcceptedSize(this.f12604O, this.f12605P).build(), new TTAdNative.NativeExpressAdListener() { // from class: com.beizi.fusion.work.splash.d.3
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i, String str) {
                Log.d("BeiZis", "showCsjNSTSplash Callback --> onError:" + str);
                CsjNSTWorker.this.m47961a(str, i);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                Log.d("BeiZis", "showCsjNSTSplash Callback --> onNativeExpressAdLoad()");
                ((AdWorker) CsjNSTWorker.this).f11803j = AdStatus.ADLOAD;
                CsjNSTWorker.this.m47910y();
                if (list == null || list.size() == 0) {
                    CsjNSTWorker.this.m47921c(-991);
                    return;
                }
                CsjNSTWorker.this.f12622u = list.get(0);
                CsjNSTWorker csjNSTWorker = CsjNSTWorker.this;
                csjNSTWorker.m46478a(csjNSTWorker.f12622u);
                CsjNSTWorker.this.f12622u.render();
            }
        });
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: m */
    public void mo46173m() {
        TTNativeExpressAd tTNativeExpressAd = this.f12622u;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: o */
    public View mo46446o() {
        return this.f12624w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m46467b() {
        BaseManager baseManager = this.f11797d;
        if (baseManager == null) {
            return;
        }
        Map<String, AdWorker> m48669r = baseManager.m48669r();
        Log.d("BeiZis", "splashWorkers:" + m48669r.toString());
        m47969Z();
        CompeteStatus competeStatus = this.f11800g;
        if (competeStatus == CompeteStatus.SUCCESS) {
            this.f11797d.m48726a(mo46059g(), (View) null);
        } else if (competeStatus == CompeteStatus.FAIL) {
            Log.d("BeiZis", "other worker shown," + mo46059g() + " remove");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m46457e(int i) {
        if (this.f12609T == 1) {
            String valueOf = String.valueOf(i);
            String str = this.f12611V + " ";
            String str2 = str + valueOf;
            SpannableString spannableString = new SpannableString(str2);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.f12612W)), 0, str.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.f12613X)), str2.indexOf(valueOf), str2.length(), 33);
            ((SkipView) this.f12618q).setText(spannableString);
            return;
        }
        SpannableString spannableString2 = new SpannableString(this.f12611V);
        spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor(this.f12612W)), 0, this.f12611V.length(), 33);
        ((SkipView) this.f12618q).setText(spannableString2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m46478a(TTNativeExpressAd tTNativeExpressAd) {
        tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.beizi.fusion.work.splash.d.4

            /* renamed from: a */
            boolean f12634a = false;

            /* renamed from: b */
            boolean f12635b = false;

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i) {
                Log.d("BeiZis", "showCsjNSTSplash Callback --> onAdClicked()");
                if (((AdWorker) CsjNSTWorker.this).f11797d != null && ((AdWorker) CsjNSTWorker.this).f11797d.m48668s() != 2) {
                    ((AdWorker) CsjNSTWorker.this).f11797d.m48700d(CsjNSTWorker.this.mo46059g());
                }
                if (this.f12635b) {
                    return;
                }
                this.f12635b = true;
                CsjNSTWorker.this.m47990E();
                CsjNSTWorker.this.m47941ai();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i) {
                Log.d("BeiZis", "showCsjNSTSplash Callback --> onAdShow()");
                ((AdWorker) CsjNSTWorker.this).f11803j = AdStatus.ADSHOW;
                if (((AdWorker) CsjNSTWorker.this).f11797d != null && ((AdWorker) CsjNSTWorker.this).f11797d.m48668s() != 2) {
                    ((AdWorker) CsjNSTWorker.this).f11797d.m48710b(CsjNSTWorker.this.mo46059g());
                }
                if (this.f12634a) {
                    return;
                }
                this.f12634a = true;
                CsjNSTWorker.this.m47992C();
                CsjNSTWorker.this.m47991D();
                CsjNSTWorker.this.m47942ah();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i) {
                Log.d("BeiZis", "showCsjNSTSplash Callback --> onRenderFail()");
                CsjNSTWorker.this.m47961a(str, i);
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f, float f2) {
                Log.d("BeiZis", "showCsjNSTSplash Callback --> onRenderSuccess() width == " + f + ", height == " + f2);
                CsjNSTWorker csjNSTWorker = CsjNSTWorker.this;
                csjNSTWorker.f12606Q = (float) C3138av.m48304a(csjNSTWorker.f12615n, f);
                CsjNSTWorker csjNSTWorker2 = CsjNSTWorker.this;
                csjNSTWorker2.f12607R = (float) C3138av.m48304a(csjNSTWorker2.f12615n, f2);
                CsjNSTWorker.this.f12624w = view;
                if (CsjNSTWorker.this.m47970Y()) {
                    CsjNSTWorker.this.m46467b();
                } else {
                    CsjNSTWorker.this.m47980O();
                }
            }
        });
    }
}
