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
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.ObserverAdStatus;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.CompeteStatus;
import com.beizi.fusion.p066d.KsAdManagerHolder;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.p072g.RandomUtils;
import com.beizi.fusion.widget.CircleProgressView;
import com.beizi.fusion.widget.SkipView;
import com.beizi.fusion.work.AdWorker;
import com.github.mikephil.charting.utils.Utils;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.model.SplashAdExtraData;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.splash.k */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class KsSplashWorker extends AdWorker {

    /* renamed from: E */
    private long f12838E;

    /* renamed from: F */
    private boolean f12839F;

    /* renamed from: G */
    private CircleProgressView f12840G;

    /* renamed from: H */
    private AdSpacesBean.PositionBean f12841H;

    /* renamed from: I */
    private AdSpacesBean.PositionBean f12842I;

    /* renamed from: J */
    private long f12843J;

    /* renamed from: K */
    private float f12844K;

    /* renamed from: L */
    private float f12845L;

    /* renamed from: M */
    private AdSpacesBean.RenderViewBean f12846M;

    /* renamed from: N */
    private int f12847N;

    /* renamed from: O */
    private int f12848O;

    /* renamed from: P */
    private String f12849P;

    /* renamed from: Q */
    private String f12850Q;

    /* renamed from: R */
    private String f12851R;

    /* renamed from: T */
    private ViewGroup f12853T;

    /* renamed from: n */
    long f12854n;

    /* renamed from: o */
    private Context f12855o;

    /* renamed from: p */
    private String f12856p;

    /* renamed from: q */
    private long f12857q;

    /* renamed from: r */
    private ViewGroup f12858r;

    /* renamed from: s */
    private KsSplashScreenAd f12859s;

    /* renamed from: t */
    private CountDownTimer f12860t;

    /* renamed from: u */
    private View f12861u;

    /* renamed from: v */
    private List<AdSpacesBean.RenderViewBean> f12862v;

    /* renamed from: w */
    private List<AdSpacesBean.RenderViewBean> f12863w = new ArrayList();

    /* renamed from: x */
    private List<AdSpacesBean.RenderViewBean> f12864x = new ArrayList();

    /* renamed from: y */
    private boolean f12865y = false;

    /* renamed from: z */
    private boolean f12866z = false;

    /* renamed from: A */
    private boolean f12834A = false;

    /* renamed from: B */
    private boolean f12835B = false;

    /* renamed from: C */
    private boolean f12836C = false;

    /* renamed from: D */
    private long f12837D = 5000;

    /* renamed from: S */
    private View f12852S = null;

    public KsSplashWorker(Context context, String str, long j, ViewGroup viewGroup, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, List<AdSpacesBean.RenderViewBean> list, BaseManager baseManager) {
        this.f12855o = context;
        this.f12856p = str;
        this.f12857q = j;
        this.f12858r = viewGroup;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        this.f12853T = new SplashContainer(context);
        this.f12862v = list;
        m47917r();
    }

    /* renamed from: aG */
    private void m46138aG() {
        if (this.f12858r != null) {
            try {
                this.f12861u = m46139a(this.f12859s);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f12858r.removeAllViews();
            if (this.f12861u != null && this.f12853T != null) {
                m46137aH();
                this.f12853T.removeAllViews();
                this.f12861u.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.f12853T.addView(this.f12861u);
                m46131aN();
                this.f12858r.removeAllViews();
                this.f12858r.addView(this.f12853T);
                return;
            }
            m47927aw();
            return;
        }
        m47927aw();
    }

    /* renamed from: aH */
    private void m46137aH() {
        String str;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.beizi.fusion.work.splash.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (KsSplashWorker.this.f12860t != null) {
                    KsSplashWorker.this.f12860t.cancel();
                }
                KsSplashWorker.this.m47947ac();
            }
        };
        if (this.f12839F) {
            View view = this.f12852S;
            if (view != null) {
                view.setVisibility(8);
                view.setAlpha(0.0f);
            }
            SkipView skipView = new SkipView(this.f12855o);
            this.f12852S = skipView;
            skipView.setOnClickListener(onClickListener);
            this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.k.5
                @Override // java.lang.Runnable
                public void run() {
                    KsSplashWorker.this.m46134aK();
                }
            }, this.f12843J);
            str = "beizi";
        } else {
            View view2 = this.f12852S;
            if (view2 != null) {
                view2.setOnClickListener(onClickListener);
                m46136aI();
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

    /* renamed from: aI */
    private void m46136aI() {
        CountDownTimer countDownTimer = this.f12860t;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(100 + this.f12837D, 50L) { // from class: com.beizi.fusion.work.splash.k.6
            @Override // android.os.CountDownTimer
            public void onFinish() {
                KsSplashWorker.this.m47947ac();
                KsSplashWorker.this.m47988G();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (((AdWorker) KsSplashWorker.this).f11797d == null || ((AdWorker) KsSplashWorker.this).f11797d.m48668s() == 2) {
                    return;
                }
                ((AdWorker) KsSplashWorker.this).f11797d.m48752a(j);
            }
        };
        this.f12860t = countDownTimer2;
        countDownTimer2.start();
    }

    /* renamed from: aJ */
    private void m46135aJ() {
        for (int i = 0; i < this.f12862v.size(); i++) {
            AdSpacesBean.RenderViewBean renderViewBean = this.f12862v.get(i);
            String type = renderViewBean.getType();
            if ("SKIPVIEW".equals(type)) {
                this.f12864x.add(renderViewBean);
            } else if ("MATERIALVIEW".equals(type)) {
                this.f12863w.add(renderViewBean);
            }
        }
        this.f12838E = 0L;
        if (this.f12864x.size() > 0) {
            AdSpacesBean.RenderViewBean renderViewBean2 = this.f12864x.get(0);
            this.f12846M = renderViewBean2;
            if (renderViewBean2 != null) {
                this.f12842I = renderViewBean2.getTapPosition();
                this.f12841H = this.f12846M.getLayerPosition();
                long delayDisplaySkipButton = this.f12846M.getDelayDisplaySkipButton();
                this.f12843J = delayDisplaySkipButton;
                if (delayDisplaySkipButton < 0) {
                    this.f12843J = 0L;
                }
                long skipViewTotalTime = this.f12846M.getSkipViewTotalTime();
                if (skipViewTotalTime > 0) {
                    this.f12837D = skipViewTotalTime;
                }
                long skipUnavailableTime = this.f12846M.getSkipUnavailableTime();
                if (skipUnavailableTime > 0) {
                    this.f12838E = skipUnavailableTime;
                }
                this.f12847N = this.f12846M.getShowCountDown();
                this.f12848O = this.f12846M.getShowBorder();
                String skipText = this.f12846M.getSkipText();
                this.f12849P = skipText;
                if (TextUtils.isEmpty(skipText)) {
                    this.f12849P = "跳过";
                }
                String textColor = this.f12846M.getTextColor();
                this.f12850Q = textColor;
                if (TextUtils.isEmpty(textColor)) {
                    this.f12850Q = "#FFFFFF";
                }
                String countDownColor = this.f12846M.getCountDownColor();
                this.f12851R = countDownColor;
                if (TextUtils.isEmpty(countDownColor)) {
                    this.f12851R = "#FFFFFF";
                }
                List<AdSpacesBean.PassPolicyBean> passPolicy = this.f12846M.getPassPolicy();
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
                                this.f12866z = RandomUtils.m48438a(passPercent);
                                break;
                            case 1:
                                this.f12865y = RandomUtils.m48438a(passPercent);
                                break;
                            case 2:
                                AdSpacesBean.PositionBean positionBean = this.f12841H;
                                if (positionBean != null && this.f12842I != null) {
                                    double centerX = positionBean.getCenterX();
                                    double centerY = this.f12841H.getCenterY();
                                    double width = this.f12841H.getWidth();
                                    double height = this.f12841H.getHeight();
                                    double centerX2 = this.f12842I.getCenterX();
                                    double centerY2 = this.f12842I.getCenterY();
                                    double width2 = this.f12842I.getWidth();
                                    double height2 = this.f12842I.getHeight();
                                    if ((centerX > Utils.DOUBLE_EPSILON && centerX2 > Utils.DOUBLE_EPSILON && centerX != centerX2) || ((centerY > Utils.DOUBLE_EPSILON && centerY2 > Utils.DOUBLE_EPSILON && centerY != centerY2) || ((width > Utils.DOUBLE_EPSILON && width2 > Utils.DOUBLE_EPSILON && width != width2) || (height > Utils.DOUBLE_EPSILON && height2 > Utils.DOUBLE_EPSILON && height != height2)))) {
                                        this.f12834A = RandomUtils.m48438a(passPercent);
                                    }
                                    if (width2 * height2 < width * height) {
                                        this.f12835B = true;
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
        if (this.f12863w.size() > 0) {
            Collections.sort(this.f12863w, new Comparator<AdSpacesBean.RenderViewBean>() { // from class: com.beizi.fusion.work.splash.k.7
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
    public void m46134aK() {
        if (this.f12865y) {
            m47978Q();
        }
        if (this.f12866z) {
            m47977R();
        }
        if (this.f12834A) {
            m47976S();
        }
        if (this.f12835B) {
            m47975T();
        }
        m46133aL();
    }

    /* renamed from: aL */
    private void m46133aL() {
        CountDownTimer countDownTimer = this.f12860t;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        final long j = this.f12837D - this.f12838E;
        CountDownTimer countDownTimer2 = new CountDownTimer(this.f12837D + 100, 50L) { // from class: com.beizi.fusion.work.splash.k.8

            /* renamed from: a */
            boolean f12874a = false;

            @Override // android.os.CountDownTimer
            public void onFinish() {
                KsSplashWorker.this.m47947ac();
                KsSplashWorker.this.m47988G();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (!this.f12874a) {
                    KsSplashWorker.this.m46128aQ();
                    this.f12874a = true;
                }
                if (KsSplashWorker.this.f12838E > 0 && KsSplashWorker.this.f12838E <= KsSplashWorker.this.f12837D) {
                    if (KsSplashWorker.this.f12865y) {
                        long j3 = j;
                        if (j3 <= 0 || j2 <= j3) {
                            KsSplashWorker.this.f12836C = false;
                            KsSplashWorker.this.f12852S.setAlpha(1.0f);
                        } else {
                            KsSplashWorker.this.f12836C = true;
                            KsSplashWorker.this.f12852S.setAlpha(0.2f);
                        }
                    }
                    if (KsSplashWorker.this.f12838E == KsSplashWorker.this.f12837D) {
                        KsSplashWorker.this.f12852S.setEnabled(false);
                    } else {
                        KsSplashWorker.this.f12852S.setEnabled(true);
                    }
                }
                if (KsSplashWorker.this.f12839F && KsSplashWorker.this.f12852S != null) {
                    KsSplashWorker.this.m46120e(Math.round(((float) j2) / 1000.0f));
                }
                if (((AdWorker) KsSplashWorker.this).f11797d == null || ((AdWorker) KsSplashWorker.this).f11797d.m48668s() == 2) {
                    return;
                }
                ((AdWorker) KsSplashWorker.this).f11797d.m48752a(j2);
            }
        };
        this.f12860t = countDownTimer2;
        countDownTimer2.start();
        m46129aP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aM */
    public void m46132aM() {
        CountDownTimer countDownTimer = this.f12860t;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            C3116af.m48496a("BeiZis", "enter cancel mCountDownTimer");
        }
    }

    /* renamed from: aN */
    private void m46131aN() {
        ViewGroup viewGroup;
        if (this.f12839F) {
            if (this.f12841H != null && (viewGroup = this.f12858r) != null) {
                float f = this.f12844K;
                float height = viewGroup.getHeight();
                if (height == 0.0f) {
                    height = this.f12845L - C3138av.m48304a(this.f12855o, 100.0f);
                }
                double d = f;
                Double.isNaN(d);
                int width = (int) (d * this.f12841H.getWidth() * 0.01d);
                if (this.f12841H.getHeight() >= 12.0d) {
                    double d2 = width;
                    Double.isNaN(d2);
                    int height2 = (int) (d2 * this.f12841H.getHeight() * 0.01d);
                    double d3 = height2;
                    Double.isNaN(d3);
                    int paddingHeight = (int) (d3 * this.f12846M.getPaddingHeight() * 0.01d);
                    if (paddingHeight < 0) {
                        paddingHeight = 0;
                    }
                    ((SkipView) this.f12852S).setData(this.f12848O, paddingHeight);
                    m46120e(5);
                    this.f12853T.addView(this.f12852S, new FrameLayout.LayoutParams(width, height2));
                    float centerX = (f * ((float) (this.f12841H.getCenterX() * 0.01d))) - (width / 2);
                    float centerY = (height * ((float) (this.f12841H.getCenterY() * 0.01d))) - (height2 / 2);
                    this.f12852S.setX(centerX);
                    this.f12852S.setY(centerY);
                    View view = this.f12852S;
                    if (view != null) {
                        view.setVisibility(0);
                        return;
                    }
                    return;
                }
                m46130aO();
                return;
            }
            m46130aO();
            return;
        }
        View view2 = this.f12852S;
        if (view2 != null) {
            view2.setVisibility(0);
            this.f12852S.setAlpha(1.0f);
        }
    }

    /* renamed from: aO */
    private void m46130aO() {
        double d = this.f12844K;
        Double.isNaN(d);
        int i = (int) (d * 0.15d);
        double d2 = i;
        Double.isNaN(d2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (int) (d2 * 0.45d));
        layoutParams.gravity = 53;
        layoutParams.topMargin = C3138av.m48304a(this.f12855o, 20.0f);
        layoutParams.rightMargin = C3138av.m48304a(this.f12855o, 20.0f);
        ViewGroup viewGroup = this.f12853T;
        if (viewGroup != null) {
            viewGroup.addView(this.f12852S, layoutParams);
        }
        View view = this.f12852S;
        if (view != null) {
            this.f12847N = 1;
            this.f12848O = 1;
            ((SkipView) view).setData(1, 0);
            ((SkipView) this.f12852S).setText(String.format("跳过 %d", 5));
            this.f12852S.setVisibility(0);
        }
    }

    /* renamed from: aP */
    private void m46129aP() {
        CircleProgressView circleProgressView = new CircleProgressView(this.f12855o);
        this.f12840G = circleProgressView;
        circleProgressView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.work.splash.k.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                KsSplashWorker.this.m47987H();
                if (KsSplashWorker.this.f12860t != null) {
                    KsSplashWorker.this.f12860t.cancel();
                }
                KsSplashWorker.this.m47947ac();
            }
        });
        this.f12840G.setAlpha(0.0f);
        this.f12853T.addView(this.f12840G, new FrameLayout.LayoutParams(-2, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aQ */
    public void m46128aQ() {
        int[] iArr;
        float f;
        float f2;
        ViewGroup viewGroup;
        this.f12852S.getLocationOnScreen(new int[2]);
        if (this.f12842I != null) {
            float f3 = this.f12844K;
            float height = this.f12858r != null ? viewGroup.getHeight() : 0.0f;
            if (height == 0.0f) {
                height = this.f12845L - C3138av.m48304a(this.f12855o, 100.0f);
            }
            double d = f3;
            Double.isNaN(d);
            int width = (int) (d * this.f12842I.getWidth() * 0.01d);
            double d2 = width;
            Double.isNaN(d2);
            int height2 = (int) (d2 * this.f12842I.getHeight() * 0.01d);
            ViewGroup.LayoutParams layoutParams = this.f12840G.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height2;
            this.f12840G.setLayoutParams(layoutParams);
            f = (f3 * ((float) (this.f12842I.getCenterX() * 0.01d))) - (width / 2);
            f2 = (height * ((float) (this.f12842I.getCenterY() * 0.01d))) - (height2 / 2);
        } else {
            float pivotX = (iArr[0] + this.f12852S.getPivotX()) - (this.f12840G.getWidth() / 2);
            float pivotY = (iArr[1] + this.f12852S.getPivotY()) - (this.f12840G.getHeight() / 2);
            f = pivotX;
            f2 = pivotY;
        }
        this.f12840G.setX(f);
        this.f12840G.setY(f2);
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "KUAISHOU";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m46120e(int i) {
        if (this.f12847N == 1) {
            String valueOf = String.valueOf(i);
            String str = this.f12849P + " ";
            String str2 = str + valueOf;
            SpannableString spannableString = new SpannableString(str2);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.f12850Q)), 0, str.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.f12851R)), str2.indexOf(valueOf), str2.length(), 33);
            ((SkipView) this.f12852S).setText(spannableString);
            return;
        }
        SpannableString spannableString2 = new SpannableString(this.f12849P);
        spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor(this.f12850Q)), 0, this.f12849P.length(), 33);
        ((SkipView) this.f12852S).setText(spannableString2);
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: d */
    public void mo46065d() {
        if (this.f11797d == null) {
            return;
        }
        this.f12854n = System.currentTimeMillis();
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
                if (!C3138av.m48301a("com.kwad.sdk.api.KsAdSDK")) {
                    m47915t();
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.k.1
                        @Override // java.lang.Runnable
                        public void run() {
                            KsSplashWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "Ks sdk not import , will do nothing");
                    return;
                }
                m47914u();
                KsAdManagerHolder.m48622a(this.f12855o, this.f11801h);
                this.f11795b.m48881u(KsAdSDK.getSDKVersion());
                m47929au();
                m47913v();
            }
        }
        long sleepTime = this.f11799f.getSleepTime();
        if (this.f11797d.m48665v()) {
            sleepTime = Math.max(sleepTime, this.f11799f.getHotRequestDelay());
        }
        List<AdSpacesBean.RenderViewBean> list = this.f12862v;
        boolean z = list != null && list.size() > 0;
        this.f12839F = z;
        if (z) {
            m46135aJ();
        }
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + sleepTime);
        if (sleepTime > 0) {
            this.f11806m.sendEmptyMessageDelayed(1, sleepTime);
        } else {
            BaseManager baseManager = this.f11797d;
            if (baseManager != null && baseManager.m48667t() < 1 && this.f11797d.m48668s() != 2) {
                mo46050l();
            }
        }
        this.f12844K = C3138av.m48286l(this.f12855o);
        this.f12845L = C3138av.m48285m(this.f12855o);
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: f */
    public void mo46061f() {
        Log.d("BeiZis", mo46059g() + " out make show ad");
        m46138aG();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: i */
    public AdStatus mo46056i() {
        return this.f11803j;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: j */
    public String mo46054j() {
        if (this.f12859s == null) {
            return null;
        }
        return this.f12859s.getECPM() + "";
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
        SplashAdExtraData splashAdExtraData = new SplashAdExtraData();
        if (BeiZis.isCloseShakeAd()) {
            splashAdExtraData.setDisableShakeStatus(true);
        } else {
            splashAdExtraData.setDisableShakeStatus(false);
        }
        KsScene build = new KsScene.Builder(Long.parseLong(this.f11802i)).setSplashExtraData(splashAdExtraData).build();
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (loadManager == null) {
            Log.d("BeiZis", "showKsSplash onError:渠道广告请求对象为空");
            m47961a("渠道广告请求异常", 10160);
            return;
        }
        if ("S2S".equalsIgnoreCase(this.f11798e.getBidType())) {
            build.setBidResponse(m47957aC());
        }
        loadManager.loadSplashScreenAd(build, new KsLoadManager.SplashScreenAdListener() { // from class: com.beizi.fusion.work.splash.k.2
            @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
            public void onError(int i, String str) {
                Log.d("BeiZis", "showKsSplash onError:" + str);
                KsSplashWorker.this.m47961a(str, i);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
            public void onRequestResult(int i) {
            }

            @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
            public void onSplashScreenAdLoad(@NonNull KsSplashScreenAd ksSplashScreenAd) {
                KsSplashWorker.this.m47910y();
                ((AdWorker) KsSplashWorker.this).f11803j = AdStatus.ADLOAD;
                KsSplashWorker.this.f12859s = ksSplashScreenAd;
                if (KsSplashWorker.this.f12859s != null) {
                    KsSplashWorker ksSplashWorker = KsSplashWorker.this;
                    ksSplashWorker.m47967a(ksSplashWorker.f12859s.getECPM());
                }
                if (KsSplashWorker.this.m47970Y()) {
                    KsSplashWorker.this.m46127b();
                } else {
                    KsSplashWorker.this.m47980O();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m46127b() {
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

    /* renamed from: a */
    private View m46139a(KsSplashScreenAd ksSplashScreenAd) {
        if (ksSplashScreenAd == null) {
            return null;
        }
        return ksSplashScreenAd.getView(this.f12855o, new KsSplashScreenAd.SplashScreenAdInteractionListener() { // from class: com.beizi.fusion.work.splash.k.3
            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdClicked() {
                Log.d("BeiZis", "showKsSplash onAdClick()");
                if (((AdWorker) KsSplashWorker.this).f11797d != null && ((AdWorker) KsSplashWorker.this).f11797d.m48668s() != 2) {
                    ((AdWorker) KsSplashWorker.this).f11797d.m48700d(KsSplashWorker.this.mo46059g());
                    ((AdWorker) KsSplashWorker.this).f11806m.sendEmptyMessageDelayed(2, (((AdWorker) KsSplashWorker.this).f11805l + 5000) - System.currentTimeMillis());
                }
                KsSplashWorker.this.m47990E();
                KsSplashWorker.this.m47941ai();
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdShowEnd() {
                Log.d("BeiZis", "showKsSplash onADDismissed()");
                KsSplashWorker.this.m47947ac();
                KsSplashWorker.this.m47988G();
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdShowError(int i, String str) {
                Log.d("BeiZis", "showKsSplash onAdShowError:" + str);
                KsSplashWorker.this.m47961a(str, i);
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdShowStart() {
                Log.d("BeiZis", "showKsSplash onADPresent()");
                KsSplashWorker.this.m47992C();
                Log.d("BeiZis", "showKsSplash onADExposure()");
                ((AdWorker) KsSplashWorker.this).f11803j = AdStatus.ADSHOW;
                KsSplashWorker.this.mo47585ab();
                KsSplashWorker.this.m47991D();
                KsSplashWorker.this.m47942ah();
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onDownloadTipsDialogCancel() {
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onDownloadTipsDialogDismiss() {
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onDownloadTipsDialogShow() {
                KsSplashWorker.this.m46132aM();
                ((AdWorker) KsSplashWorker.this).f11806m.removeMessages(2);
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onSkippedAd() {
                Log.d("BeiZis", "showKsSplash onSkippedAd()");
                KsSplashWorker.this.m47947ac();
                KsSplashWorker.this.m47987H();
            }
        });
    }
}
