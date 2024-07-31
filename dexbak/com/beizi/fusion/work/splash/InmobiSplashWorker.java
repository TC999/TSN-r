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
import androidx.annotation.NonNull;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.ObserverAdStatus;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.CompeteStatus;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.BeiZiViewUtils;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.p072g.RandomUtils;
import com.beizi.fusion.widget.CircleProgressView;
import com.beizi.fusion.widget.SkipView;
import com.beizi.fusion.work.AdWorker;
import com.github.mikephil.charting.utils.Utils;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiNative;
import com.inmobi.ads.listeners.NativeAdEventListener;
import com.inmobi.sdk.InMobiSdk;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.splash.i */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class InmobiSplashWorker extends AdWorker {

    /* renamed from: F */
    private long f12772F;

    /* renamed from: G */
    private long f12773G;

    /* renamed from: H */
    private boolean f12774H;

    /* renamed from: I */
    private CircleProgressView f12775I;

    /* renamed from: J */
    private AdSpacesBean.PositionBean f12776J;

    /* renamed from: K */
    private AdSpacesBean.PositionBean f12777K;

    /* renamed from: L */
    private List<View> f12778L;

    /* renamed from: M */
    private float f12779M;

    /* renamed from: N */
    private float f12780N;

    /* renamed from: O */
    private AdSpacesBean.RenderViewBean f12781O;

    /* renamed from: P */
    private int f12782P;

    /* renamed from: Q */
    private int f12783Q;

    /* renamed from: R */
    private String f12784R;

    /* renamed from: S */
    private String f12785S;

    /* renamed from: T */
    private String f12786T;

    /* renamed from: U */
    private InMobiNative f12787U;

    /* renamed from: V */
    private Long f12788V;

    /* renamed from: W */
    private CountDownTimer f12789W;

    /* renamed from: Y */
    private boolean f12791Y;

    /* renamed from: Z */
    private NativeAdEventListener f12792Z;

    /* renamed from: n */
    int f12793n;

    /* renamed from: o */
    long f12794o;

    /* renamed from: p */
    View f12795p;

    /* renamed from: q */
    private Context f12796q;

    /* renamed from: r */
    private String f12797r;

    /* renamed from: s */
    private long f12798s;

    /* renamed from: t */
    private View f12799t;

    /* renamed from: u */
    private ViewGroup f12800u;

    /* renamed from: v */
    private ViewGroup f12801v;

    /* renamed from: w */
    private List<AdSpacesBean.RenderViewBean> f12802w;

    /* renamed from: x */
    private List<AdSpacesBean.RenderViewBean> f12803x = new ArrayList();

    /* renamed from: y */
    private List<AdSpacesBean.RenderViewBean> f12804y = new ArrayList();

    /* renamed from: z */
    private boolean f12805z = false;

    /* renamed from: A */
    private boolean f12767A = false;

    /* renamed from: B */
    private boolean f12768B = false;

    /* renamed from: C */
    private boolean f12769C = false;

    /* renamed from: D */
    private boolean f12770D = false;

    /* renamed from: E */
    private long f12771E = 5000;

    /* renamed from: X */
    private boolean f12790X = false;

    public InmobiSplashWorker(Context context, String str, long j, View view, ViewGroup viewGroup, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, List<AdSpacesBean.RenderViewBean> list, BaseManager baseManager) {
        this.f12791Y = false;
        this.f12796q = context;
        this.f12797r = str;
        this.f12798s = j;
        if (this.f12799t == null) {
            this.f12799t = new SkipView(context);
            this.f12791Y = true;
        } else {
            this.f12799t = view;
        }
        this.f12800u = viewGroup;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        this.f12801v = new SplashContainer(context);
        this.f12802w = list;
        m47917r();
    }

    /* renamed from: aG */
    private void m46236aG() {
        StringBuilder sb = new StringBuilder();
        sb.append("finalShowAd mParent != null ? ");
        sb.append(this.f12800u != null);
        sb.append(",!mIsLoadAdView = ");
        sb.append(!this.f12790X);
        C3116af.m48494c("BeiZis", sb.toString());
        if (this.f12800u != null) {
            if (!this.f12790X) {
                this.f12799t.setVisibility(8);
            }
            m46235aH();
            this.f12801v.removeAllViews();
            C3116af.m48494c("BeiZis", "mAdContainer.getWidth() = " + this.f12801v.getWidth());
            InMobiNative inMobiNative = this.f12787U;
            Context context = this.f12796q;
            ViewGroup viewGroup = this.f12801v;
            View primaryViewOfWidth = inMobiNative.getPrimaryViewOfWidth(context, viewGroup, viewGroup, viewGroup.getWidth());
            this.f12801v.addView(primaryViewOfWidth);
            if (primaryViewOfWidth instanceof ViewGroup) {
                final ViewGroup viewGroup2 = (ViewGroup) primaryViewOfWidth;
                viewGroup2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.beizi.fusion.work.splash.i.3
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        ViewGroup viewGroup3 = viewGroup2;
                        if (viewGroup3 == null) {
                            return;
                        }
                        viewGroup3.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        ViewGroup.LayoutParams layoutParams = viewGroup2.getLayoutParams();
                        int i = layoutParams.height;
                        int height = InmobiSplashWorker.this.f12801v.getHeight();
                        C3116af.m48494c("BeiZis", "adsHeight = " + i + ",containerHeight = " + height);
                        if (i < height) {
                            layoutParams.height = height;
                        }
                    }
                });
            }
            this.f12800u.removeAllViews();
            this.f12800u.addView(this.f12801v);
            this.f12790X = true;
            this.f12799t.setVisibility(0);
            if (this.f12775I != null) {
                this.f12800u.addView(this.f12775I, new FrameLayout.LayoutParams(-2, -2));
            }
            m46230aM();
            if (this.f12774H) {
                m46232aK();
                return;
            }
            return;
        }
        m47927aw();
    }

    /* renamed from: aH */
    private void m46235aH() {
        m46234aI();
        if (this.f12791Y && (this.f12799t instanceof CircleProgressView)) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 53;
            layoutParams.topMargin = C3138av.m48304a(this.f12796q, 20.0f);
            layoutParams.rightMargin = C3138av.m48304a(this.f12796q, 20.0f);
            this.f12801v.addView(this.f12799t, layoutParams);
        }
    }

    /* renamed from: aI */
    private void m46234aI() {
        StringBuilder sb = new StringBuilder();
        sb.append("addCloseButton mSkipView != null ? ");
        sb.append(this.f12799t != null);
        C3116af.m48496a("BeiZis", sb.toString());
        if (this.f12799t != null) {
            CountDownTimer countDownTimer = this.f12789W;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            CountDownTimer countDownTimer2 = new CountDownTimer(this.f12771E, 50L) { // from class: com.beizi.fusion.work.splash.i.4

                /* renamed from: a */
                boolean f12810a = false;

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    InmobiSplashWorker.this.m47988G();
                    ((AdWorker) InmobiSplashWorker.this).f11797d.m48704c(InmobiSplashWorker.this.mo46059g());
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    if (!this.f12810a) {
                        if (InmobiSplashWorker.this.f12774H) {
                            InmobiSplashWorker inmobiSplashWorker = InmobiSplashWorker.this;
                            inmobiSplashWorker.f12778L = BeiZiViewUtils.m48237a(inmobiSplashWorker.f12801v);
                        }
                        InmobiSplashWorker.this.m46228aO();
                        this.f12810a = true;
                    }
                    if (InmobiSplashWorker.this.f12774H) {
                        if (InmobiSplashWorker.this.f12773G > 0 && InmobiSplashWorker.this.f12773G <= InmobiSplashWorker.this.f12771E) {
                            if (InmobiSplashWorker.this.f12805z) {
                                if (InmobiSplashWorker.this.f12772F <= 0 || j <= InmobiSplashWorker.this.f12772F) {
                                    InmobiSplashWorker.this.f12770D = false;
                                    InmobiSplashWorker.this.f12799t.setAlpha(1.0f);
                                } else {
                                    InmobiSplashWorker.this.f12770D = true;
                                    InmobiSplashWorker.this.f12799t.setAlpha(0.2f);
                                }
                            }
                            if (InmobiSplashWorker.this.f12773G == InmobiSplashWorker.this.f12771E) {
                                InmobiSplashWorker.this.f12799t.setEnabled(false);
                            } else {
                                InmobiSplashWorker.this.f12799t.setEnabled(true);
                            }
                        }
                        InmobiSplashWorker.this.m46221e(Math.round(((float) j) / 1000.0f));
                    }
                    if (InmobiSplashWorker.this.f12790X) {
                        if (InmobiSplashWorker.this.f12773G == InmobiSplashWorker.this.f12771E) {
                            InmobiSplashWorker.this.f12799t.setEnabled(false);
                        } else {
                            InmobiSplashWorker.this.f12799t.setEnabled(true);
                        }
                    }
                    int i = (int) ((5 * j) / InmobiSplashWorker.this.f12771E);
                    if (InmobiSplashWorker.this.f12799t instanceof SkipView) {
                        ((SkipView) InmobiSplashWorker.this.f12799t).setText(String.format("跳过 %d", Integer.valueOf(i)));
                    } else if (((AdWorker) InmobiSplashWorker.this).f11797d == null || ((AdWorker) InmobiSplashWorker.this).f11797d.m48668s() == 2) {
                    } else {
                        ((AdWorker) InmobiSplashWorker.this).f11797d.m48752a(j);
                    }
                }
            };
            this.f12789W = countDownTimer2;
            countDownTimer2.start();
            this.f12799t.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.work.splash.i.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    InmobiSplashWorker.this.m47988G();
                    InmobiSplashWorker.this.f12789W.cancel();
                    ((AdWorker) InmobiSplashWorker.this).f11797d.m48704c(InmobiSplashWorker.this.mo46059g());
                }
            });
        }
    }

    /* renamed from: aJ */
    private void m46233aJ() {
        for (int i = 0; i < this.f12802w.size(); i++) {
            AdSpacesBean.RenderViewBean renderViewBean = this.f12802w.get(i);
            String type = renderViewBean.getType();
            if ("SKIPVIEW".equals(type)) {
                this.f12804y.add(renderViewBean);
            } else if ("MATERIALVIEW".equals(type)) {
                this.f12803x.add(renderViewBean);
            }
        }
        if (this.f12804y.size() > 0) {
            AdSpacesBean.RenderViewBean renderViewBean2 = this.f12804y.get(0);
            this.f12781O = renderViewBean2;
            if (renderViewBean2 != null) {
                this.f12777K = renderViewBean2.getTapPosition();
                this.f12776J = this.f12781O.getLayerPosition();
                long skipUnavailableTime = this.f12781O.getSkipUnavailableTime();
                if (skipUnavailableTime > 0) {
                    this.f12773G = skipUnavailableTime;
                }
                this.f12782P = this.f12781O.getShowCountDown();
                this.f12783Q = this.f12781O.getShowBorder();
                String skipText = this.f12781O.getSkipText();
                this.f12784R = skipText;
                if (TextUtils.isEmpty(skipText)) {
                    this.f12784R = "跳过";
                }
                String textColor = this.f12781O.getTextColor();
                this.f12785S = textColor;
                if (TextUtils.isEmpty(textColor)) {
                    this.f12785S = "#FFFFFF";
                }
                String countDownColor = this.f12781O.getCountDownColor();
                this.f12786T = countDownColor;
                if (TextUtils.isEmpty(countDownColor)) {
                    this.f12786T = "#FFFFFF";
                }
                List<AdSpacesBean.PassPolicyBean> passPolicy = this.f12781O.getPassPolicy();
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
                                this.f12767A = RandomUtils.m48438a(passPercent);
                                break;
                            case 1:
                                this.f12805z = RandomUtils.m48438a(passPercent);
                                break;
                            case 2:
                                AdSpacesBean.PositionBean positionBean = this.f12776J;
                                if (positionBean != null && this.f12777K != null) {
                                    double centerX = positionBean.getCenterX();
                                    double centerY = this.f12776J.getCenterY();
                                    double width = this.f12776J.getWidth();
                                    double height = this.f12776J.getHeight();
                                    double centerX2 = this.f12777K.getCenterX();
                                    double centerY2 = this.f12777K.getCenterY();
                                    double width2 = this.f12777K.getWidth();
                                    double height2 = this.f12777K.getHeight();
                                    if ((centerX > Utils.DOUBLE_EPSILON && centerX2 > Utils.DOUBLE_EPSILON && centerX != centerX2) || ((centerY > Utils.DOUBLE_EPSILON && centerY2 > Utils.DOUBLE_EPSILON && centerY != centerY2) || ((width > Utils.DOUBLE_EPSILON && width2 > Utils.DOUBLE_EPSILON && width != width2) || (height > Utils.DOUBLE_EPSILON && height2 > Utils.DOUBLE_EPSILON && height != height2)))) {
                                        this.f12768B = RandomUtils.m48438a(passPercent);
                                    }
                                    if (width2 * height2 < width * height) {
                                        this.f12769C = true;
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
        if (this.f12803x.size() > 0) {
            Collections.sort(this.f12803x, new Comparator<AdSpacesBean.RenderViewBean>() { // from class: com.beizi.fusion.work.splash.i.6
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(AdSpacesBean.RenderViewBean renderViewBean3, AdSpacesBean.RenderViewBean renderViewBean4) {
                    return renderViewBean4.getLevel() - renderViewBean3.getLevel();
                }
            });
        }
    }

    /* renamed from: aK */
    private void m46232aK() {
        if (this.f12805z) {
            m47978Q();
        }
        if (this.f12767A) {
            m47977R();
        }
        if (this.f12768B) {
            m47976S();
        }
        if (this.f12769C) {
            m47975T();
        }
        this.f12772F = this.f12771E - this.f12773G;
    }

    /* renamed from: aL */
    private View m46231aL() {
        View view;
        String str;
        if (this.f12774H) {
            View view2 = this.f12799t;
            if (view2 != null) {
                view2.setVisibility(8);
                view2.setAlpha(0.0f);
            }
            this.f12799t = new SkipView(this.f12796q);
            CircleProgressView circleProgressView = new CircleProgressView(this.f12796q);
            this.f12775I = circleProgressView;
            circleProgressView.setAlpha(0.0f);
            view = this.f12775I;
            str = "beizi";
        } else {
            view = this.f12799t;
            if (view != null) {
                CircleProgressView circleProgressView2 = new CircleProgressView(this.f12796q);
                this.f12775I = circleProgressView2;
                circleProgressView2.setAlpha(0.0f);
                view = this.f12775I;
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

    /* renamed from: aM */
    private void m46230aM() {
        C3116af.m48496a("BeiZis", "enter checkDisplaySkipView mNeedRender = " + this.f12774H);
        if (this.f12774H) {
            if (this.f12776J != null && this.f12781O != null) {
                float f = this.f12779M;
                float height = this.f12800u.getHeight();
                if (height == 0.0f) {
                    height = this.f12780N - C3138av.m48304a(this.f12796q, 100.0f);
                }
                double d = f;
                Double.isNaN(d);
                int width = (int) (d * this.f12776J.getWidth() * 0.01d);
                if (this.f12776J.getHeight() >= 12.0d) {
                    double d2 = width;
                    Double.isNaN(d2);
                    int height2 = (int) (d2 * this.f12776J.getHeight() * 0.01d);
                    double d3 = height2;
                    Double.isNaN(d3);
                    int paddingHeight = (int) (d3 * this.f12781O.getPaddingHeight() * 0.01d);
                    if (paddingHeight < 0) {
                        paddingHeight = 0;
                    }
                    ((SkipView) this.f12799t).setData(this.f12783Q, paddingHeight);
                    m46221e(5);
                    this.f12800u.addView(this.f12799t, new FrameLayout.LayoutParams(width, height2));
                    float centerY = (height * ((float) (this.f12776J.getCenterY() * 0.01d))) - (height2 / 2);
                    this.f12799t.setX((f * ((float) (this.f12776J.getCenterX() * 0.01d))) - (width / 2));
                    this.f12799t.setY(centerY);
                    View view = this.f12799t;
                    if (view != null) {
                        view.setVisibility(0);
                        return;
                    }
                    return;
                }
                m46229aN();
                return;
            }
            m46229aN();
            return;
        }
        m46229aN();
    }

    /* renamed from: aN */
    private void m46229aN() {
        double d = this.f12779M;
        Double.isNaN(d);
        int i = (int) (d * 0.15d);
        double d2 = i;
        Double.isNaN(d2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (int) (d2 * 0.45d));
        layoutParams.gravity = 53;
        layoutParams.topMargin = C3138av.m48304a(this.f12796q, 20.0f);
        layoutParams.rightMargin = C3138av.m48304a(this.f12796q, 20.0f);
        ViewGroup viewGroup = this.f12800u;
        if (viewGroup != null) {
            viewGroup.addView(this.f12799t, layoutParams);
        }
        View view = this.f12799t;
        if (view != null) {
            this.f12782P = 1;
            this.f12783Q = 1;
            ((SkipView) view).setData(1, 0);
            ((SkipView) this.f12799t).setText(String.format("跳过 %d", 5));
            this.f12799t.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aO */
    public void m46228aO() {
        int[] iArr;
        float pivotX;
        float pivotY;
        float height;
        View view = this.f12799t;
        if (view == null) {
            return;
        }
        view.getLocationOnScreen(new int[2]);
        if (this.f12777K != null) {
            float f = this.f12779M;
            float height2 = this.f12800u.getHeight();
            if (height2 == 0.0f) {
                height2 = this.f12780N - C3138av.m48304a(this.f12796q, 100.0f);
            }
            double d = f;
            Double.isNaN(d);
            int width = (int) (d * this.f12777K.getWidth() * 0.01d);
            double d2 = width;
            Double.isNaN(d2);
            int height3 = (int) (d2 * this.f12777K.getHeight() * 0.01d);
            ViewGroup.LayoutParams layoutParams = this.f12775I.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height3;
            this.f12775I.setLayoutParams(layoutParams);
            pivotX = (f * ((float) (this.f12777K.getCenterX() * 0.01d))) - (width / 2);
            pivotY = height2 * ((float) (this.f12777K.getCenterY() * 0.01d));
            height = height3 / 2;
        } else {
            pivotX = (iArr[0] + this.f12799t.getPivotX()) - (this.f12775I.getWidth() / 2);
            pivotY = iArr[1] + this.f12799t.getPivotY();
            height = this.f12775I.getHeight() / 2;
        }
        this.f12775I.setX(pivotX);
        this.f12775I.setY(pivotY - height);
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "INMOBI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m46221e(int i) {
        if (this.f12782P == 1) {
            String valueOf = String.valueOf(i);
            String str = this.f12784R + " ";
            String str2 = str + valueOf;
            SpannableString spannableString = new SpannableString(str2);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.f12785S)), 0, str.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.f12786T)), str2.indexOf(valueOf), str2.length(), 33);
            ((SkipView) this.f12799t).setText(spannableString);
            return;
        }
        SpannableString spannableString2 = new SpannableString(this.f12784R);
        spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor(this.f12785S)), 0, this.f12784R.length(), 33);
        ((SkipView) this.f12799t).setText(spannableString2);
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: A */
    protected void mo46197A() {
        if (!m47909z() || this.f12787U == null) {
            return;
        }
        m47938al();
        this.f11798e.setAvgPrice(this.f12787U.getAdBid());
        C3116af.m48496a("BeiZisBid", "inmobi splash price = " + this.f12787U.getAdBid());
        EventBean eventBean = this.f11795b;
        if (eventBean != null) {
            eventBean.m48942M(String.valueOf(this.f11798e.getAvgPrice()));
            m47929au();
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: d */
    public void mo46065d() {
        boolean z;
        if (this.f11797d == null) {
            return;
        }
        this.f12794o = System.currentTimeMillis();
        this.f11801h = this.f11798e.getAppId();
        this.f11796c = this.f11798e.getBuyerSpaceUuId();
        C3116af.m48495b("BeiZis", "AdWorker chanel = " + this.f11796c);
        boolean z2 = false;
        try {
            this.f12788V = Long.valueOf(this.f11798e.getSpaceId());
            z = false;
        } catch (Exception unused) {
            this.f11803j = AdStatus.ADFAIL;
            this.f11806m.sendMessage(this.f11806m.obtainMessage(3, "Inmobi spaceId pattern problem!"));
            z = true;
        }
        if (z) {
            return;
        }
        ObserverAdStatus observerAdStatus = this.f11794a;
        if (observerAdStatus != null) {
            EventBean m48977a = observerAdStatus.m48860a().m48977a(this.f11796c);
            this.f11795b = m48977a;
            if (m48977a != null) {
                m47916s();
                if (!C3138av.m48301a("com.inmobi.sdk.InMobiSdk")) {
                    m47915t();
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.i.1
                        @Override // java.lang.Runnable
                        public void run() {
                            InmobiSplashWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "IMB sdk not import , will do nothing");
                    return;
                }
                m47914u();
                InMobiSdk.init(this.f12796q, this.f11801h);
                InMobiSdk.setLogLevel(InMobiSdk.LogLevel.DEBUG);
                this.f11795b.m48877w(InMobiSdk.getVersion());
                m47929au();
                m47913v();
            }
        }
        this.f12793n = this.f11798e.getReqTimeOutType();
        long sleepTime = this.f11799f.getSleepTime();
        if (this.f11797d.m48665v()) {
            sleepTime = Math.max(sleepTime, this.f11799f.getHotRequestDelay());
        }
        List<AdSpacesBean.RenderViewBean> list = this.f12802w;
        if (list != null && list.size() > 0) {
            z2 = true;
        }
        this.f12774H = z2;
        if (z2) {
            m46233aJ();
        }
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f12788V + "===" + sleepTime);
        if (sleepTime > 0) {
            this.f11806m.sendEmptyMessageDelayed(1, sleepTime);
        } else {
            BaseManager baseManager = this.f11797d;
            if (baseManager != null && baseManager.m48667t() < 1 && this.f11797d.m48668s() != 2) {
                mo46050l();
            }
        }
        this.f12779M = C3138av.m48286l(this.f12796q);
        this.f12780N = C3138av.m48285m(this.f12796q);
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: f */
    public void mo46061f() {
        Log.d("BeiZis", mo46059g() + " out make show ad");
        m46236aG();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: i */
    public AdStatus mo46056i() {
        return this.f11803j;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: j */
    public String mo46054j() {
        if (this.f12787U == null) {
            return null;
        }
        return this.f12787U.getAdBid() + "";
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: l */
    protected void mo46050l() {
        m47912w();
        m47943ag();
        this.f12795p = m46231aL();
        this.f12792Z = new NativeAdEventListener() { // from class: com.beizi.fusion.work.splash.i.2
            public void onAdClicked(@NonNull InMobiNative inMobiNative) {
                Log.d("BeiZis", "showInSplash onAdClicked:");
                if (((AdWorker) InmobiSplashWorker.this).f11797d != null && ((AdWorker) InmobiSplashWorker.this).f11797d.m48668s() != 2) {
                    ((AdWorker) InmobiSplashWorker.this).f11797d.m48700d(InmobiSplashWorker.this.mo46059g());
                }
                InmobiSplashWorker.this.m47990E();
                InmobiSplashWorker.this.m47941ai();
            }

            public void onAdImpressed(@NonNull InMobiNative inMobiNative) {
                Log.d("BeiZis", "showInSplash onAdImpressed");
                ((AdWorker) InmobiSplashWorker.this).f11803j = AdStatus.ADSHOW;
                InmobiSplashWorker.this.mo47585ab();
                InmobiSplashWorker.this.m47991D();
                InmobiSplashWorker.this.m47942ah();
            }

            public void onAdLoadFailed(@NonNull InMobiNative inMobiNative, @NonNull InMobiAdRequestStatus inMobiAdRequestStatus) {
                Log.d("BeiZis", "showInSplash onAdFailed:" + inMobiAdRequestStatus.getMessage());
                InmobiSplashWorker.this.m47961a(inMobiAdRequestStatus.getMessage(), inMobiAdRequestStatus.getStatusCode().ordinal());
            }

            public void onAdLoadSucceeded(@NonNull InMobiNative inMobiNative) {
                Log.d("BeiZis", "showInSplash onAdLoadSucceeded:");
                InmobiSplashWorker.this.m47910y();
                ((AdWorker) InmobiSplashWorker.this).f11803j = AdStatus.ADLOAD;
                C3116af.m48496a("BeiZisBid", "showInSplash inMobiNative.getAdBid() = " + inMobiNative.getAdBid() + ",mBuyerBean = " + ((AdWorker) InmobiSplashWorker.this).f11798e);
                if (InmobiSplashWorker.this.m47970Y()) {
                    InmobiSplashWorker.this.m46227b();
                } else {
                    InmobiSplashWorker.this.m47980O();
                }
            }

            public void onUserWillLeaveApplication(InMobiNative inMobiNative) {
                Log.d("BeiZis", "showInSplash onUserWillLeaveApplication");
            }
        };
        InMobiNative inMobiNative = new InMobiNative(this.f12796q, this.f12788V.longValue(), this.f12792Z);
        this.f12787U = inMobiNative;
        inMobiNative.setDownloaderEnabled(true);
        this.f12787U.load();
        C3116af.m48496a("BeiZis", "inmobi start load");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m46227b() {
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
}
