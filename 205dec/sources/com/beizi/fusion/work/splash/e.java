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
import com.beizi.fusion.d.u;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.al;
import com.beizi.fusion.g.av;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.CircleProgressView;
import com.beizi.fusion.widget.SkipView;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: CsjSplashWorker.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class e extends com.beizi.fusion.work.a {
    private long F;
    private boolean G;
    private CircleProgressView H;
    private AdSpacesBean.PositionBean I;
    private AdSpacesBean.PositionBean J;
    private long K;

    /* renamed from: L  reason: collision with root package name */
    private float f16045L;
    private float M;
    private AdSpacesBean.RenderViewBean N;
    private int O;
    private int P;
    private String Q;
    private String R;
    private String S;
    private CSJSplashAd T;
    private long U;
    private int V;
    private int W;

    /* renamed from: n  reason: collision with root package name */
    private Context f16046n;

    /* renamed from: o  reason: collision with root package name */
    private String f16047o;

    /* renamed from: p  reason: collision with root package name */
    private long f16048p;

    /* renamed from: q  reason: collision with root package name */
    private View f16049q;

    /* renamed from: r  reason: collision with root package name */
    private ViewGroup f16050r;

    /* renamed from: s  reason: collision with root package name */
    private ViewGroup f16051s;

    /* renamed from: t  reason: collision with root package name */
    private TTAdNative f16052t;

    /* renamed from: u  reason: collision with root package name */
    private CountDownTimer f16053u;

    /* renamed from: v  reason: collision with root package name */
    private View f16054v;

    /* renamed from: w  reason: collision with root package name */
    private List<AdSpacesBean.RenderViewBean> f16055w;

    /* renamed from: x  reason: collision with root package name */
    private List<AdSpacesBean.RenderViewBean> f16056x = new ArrayList();

    /* renamed from: y  reason: collision with root package name */
    private List<AdSpacesBean.RenderViewBean> f16057y = new ArrayList();

    /* renamed from: z  reason: collision with root package name */
    private boolean f16058z = false;
    private boolean A = false;
    private boolean B = false;
    private boolean C = false;
    private boolean D = false;
    private long E = 5000;

    public e(Context context, String str, long j4, View view, ViewGroup viewGroup, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, List<AdSpacesBean.RenderViewBean> list, int i4, int i5, com.beizi.fusion.d.e eVar) {
        this.f16046n = context;
        this.f16047o = str;
        this.f16048p = j4;
        this.f16049q = view;
        this.f16050r = viewGroup;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        this.f16051s = new SplashContainer(context);
        this.f16055w = list;
        this.V = i4;
        this.W = i5;
        r();
    }

    private void aG() {
        CountDownTimer countDownTimer = this.f16053u;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(100 + this.E, 50L) { // from class: com.beizi.fusion.work.splash.e.5
            @Override // android.os.CountDownTimer
            public void onFinish() {
                e.this.ac();
                e.this.G();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j4) {
                if (((com.beizi.fusion.work.a) e.this).f15367d == null || ((com.beizi.fusion.work.a) e.this).f15367d.s() == 2) {
                    return;
                }
                ((com.beizi.fusion.work.a) e.this).f15367d.a(j4);
            }
        };
        this.f16053u = countDownTimer2;
        countDownTimer2.start();
    }

    private void aH() {
        for (int i4 = 0; i4 < this.f16055w.size(); i4++) {
            AdSpacesBean.RenderViewBean renderViewBean = this.f16055w.get(i4);
            String type = renderViewBean.getType();
            if ("SKIPVIEW".equals(type)) {
                this.f16057y.add(renderViewBean);
            } else if ("MATERIALVIEW".equals(type)) {
                this.f16056x.add(renderViewBean);
            }
        }
        this.F = 0L;
        if (this.f16057y.size() > 0) {
            AdSpacesBean.RenderViewBean renderViewBean2 = this.f16057y.get(0);
            this.N = renderViewBean2;
            if (renderViewBean2 != null) {
                this.J = renderViewBean2.getTapPosition();
                this.I = this.N.getLayerPosition();
                long delayDisplaySkipButton = this.N.getDelayDisplaySkipButton();
                this.K = delayDisplaySkipButton;
                if (delayDisplaySkipButton < 0) {
                    this.K = 0L;
                }
                long skipViewTotalTime = this.N.getSkipViewTotalTime();
                if (skipViewTotalTime > 0) {
                    this.E = skipViewTotalTime;
                }
                long skipUnavailableTime = this.N.getSkipUnavailableTime();
                if (skipUnavailableTime > 0) {
                    this.F = skipUnavailableTime;
                }
                this.O = this.N.getShowCountDown();
                this.P = this.N.getShowBorder();
                String skipText = this.N.getSkipText();
                this.Q = skipText;
                if (TextUtils.isEmpty(skipText)) {
                    this.Q = "\u8df3\u8fc7";
                }
                String textColor = this.N.getTextColor();
                this.R = textColor;
                if (TextUtils.isEmpty(textColor)) {
                    this.R = "#FFFFFF";
                }
                String countDownColor = this.N.getCountDownColor();
                this.S = countDownColor;
                if (TextUtils.isEmpty(countDownColor)) {
                    this.S = "#FFFFFF";
                }
                List<AdSpacesBean.PassPolicyBean> passPolicy = this.N.getPassPolicy();
                if (passPolicy != null && passPolicy.size() > 0) {
                    for (AdSpacesBean.PassPolicyBean passPolicyBean : passPolicy) {
                        String passType = passPolicyBean.getPassType();
                        int passPercent = passPolicyBean.getPassPercent();
                        passType.hashCode();
                        char c4 = '\uffff';
                        switch (passType.hashCode()) {
                            case 601561940:
                                if (passType.equals("RANDOMPASS")) {
                                    c4 = 0;
                                    break;
                                }
                                break;
                            case 1028793094:
                                if (passType.equals("WAITPASS")) {
                                    c4 = 1;
                                    break;
                                }
                                break;
                            case 1122973890:
                                if (passType.equals("LAYERPASS")) {
                                    c4 = 2;
                                    break;
                                }
                                break;
                        }
                        switch (c4) {
                            case 0:
                                this.A = al.a(passPercent);
                                break;
                            case 1:
                                this.f16058z = al.a(passPercent);
                                break;
                            case 2:
                                AdSpacesBean.PositionBean positionBean = this.I;
                                if (positionBean != null && this.J != null) {
                                    double centerX = positionBean.getCenterX();
                                    double centerY = this.I.getCenterY();
                                    double width = this.I.getWidth();
                                    double height = this.I.getHeight();
                                    double centerX2 = this.J.getCenterX();
                                    double centerY2 = this.J.getCenterY();
                                    double width2 = this.J.getWidth();
                                    double height2 = this.J.getHeight();
                                    if ((centerX > 0.0d && centerX2 > 0.0d && centerX != centerX2) || ((centerY > 0.0d && centerY2 > 0.0d && centerY != centerY2) || ((width > 0.0d && width2 > 0.0d && width != width2) || (height > 0.0d && height2 > 0.0d && height != height2)))) {
                                        this.B = al.a(passPercent);
                                    }
                                    if (width2 * height2 < width * height) {
                                        this.C = true;
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
        if (this.f16056x.size() > 0) {
            Collections.sort(this.f16056x, new Comparator<AdSpacesBean.RenderViewBean>() { // from class: com.beizi.fusion.work.splash.e.6
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(AdSpacesBean.RenderViewBean renderViewBean3, AdSpacesBean.RenderViewBean renderViewBean4) {
                    return renderViewBean4.getLevel() - renderViewBean3.getLevel();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI() {
        if (this.f16058z) {
            Q();
        }
        if (this.A) {
            R();
        }
        if (this.B) {
            S();
        }
        if (this.C) {
            T();
        }
        aJ();
    }

    private void aJ() {
        CountDownTimer countDownTimer = this.f16053u;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        final long j4 = this.E - this.F;
        CountDownTimer countDownTimer2 = new CountDownTimer(this.E + 100, 50L) { // from class: com.beizi.fusion.work.splash.e.7

            /* renamed from: a  reason: collision with root package name */
            boolean f16066a = false;

            @Override // android.os.CountDownTimer
            public void onFinish() {
                e.this.ac();
                e.this.G();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j5) {
                if (!this.f16066a) {
                    e.this.aN();
                    this.f16066a = true;
                }
                if (e.this.F > 0 && e.this.F <= e.this.E) {
                    if (e.this.f16058z) {
                        long j6 = j4;
                        if (j6 <= 0 || j5 <= j6) {
                            e.this.D = false;
                            e.this.f16049q.setAlpha(1.0f);
                        } else {
                            e.this.D = true;
                            e.this.f16049q.setAlpha(0.2f);
                        }
                    }
                    if (e.this.F == e.this.E) {
                        e.this.f16049q.setEnabled(false);
                    } else {
                        e.this.f16049q.setEnabled(true);
                    }
                }
                if (e.this.G && e.this.f16049q != null) {
                    e.this.e(Math.round(((float) j5) / 1000.0f));
                }
                if (((com.beizi.fusion.work.a) e.this).f15367d == null || ((com.beizi.fusion.work.a) e.this).f15367d.s() == 2) {
                    return;
                }
                ((com.beizi.fusion.work.a) e.this).f15367d.a(j5);
            }
        };
        this.f16053u = countDownTimer2;
        countDownTimer2.start();
        aM();
    }

    private void aK() {
        ViewGroup viewGroup;
        if (this.G) {
            if (this.I != null && (viewGroup = this.f16050r) != null) {
                float f4 = this.f16045L;
                float height = viewGroup.getHeight();
                if (height == 0.0f) {
                    height = this.M - av.a(this.f16046n, 100.0f);
                }
                double d4 = f4;
                Double.isNaN(d4);
                int width = (int) (d4 * this.I.getWidth() * 0.01d);
                if (this.I.getHeight() >= 12.0d) {
                    double d5 = width;
                    Double.isNaN(d5);
                    int height2 = (int) (d5 * this.I.getHeight() * 0.01d);
                    double d6 = height2;
                    Double.isNaN(d6);
                    int paddingHeight = (int) (d6 * this.N.getPaddingHeight() * 0.01d);
                    if (paddingHeight < 0) {
                        paddingHeight = 0;
                    }
                    ((SkipView) this.f16049q).setData(this.P, paddingHeight);
                    e(5);
                    this.f16051s.addView(this.f16049q, new FrameLayout.LayoutParams(width, height2));
                    float centerX = (f4 * ((float) (this.I.getCenterX() * 0.01d))) - (width / 2);
                    float centerY = (height * ((float) (this.I.getCenterY() * 0.01d))) - (height2 / 2);
                    this.f16049q.setX(centerX);
                    this.f16049q.setY(centerY);
                    View view = this.f16049q;
                    if (view != null) {
                        view.setVisibility(0);
                        return;
                    }
                    return;
                }
                aL();
                return;
            }
            aL();
            return;
        }
        View view2 = this.f16049q;
        if (view2 != null) {
            view2.setVisibility(0);
            this.f16049q.setAlpha(1.0f);
        }
    }

    private void aL() {
        double d4 = this.f16045L;
        Double.isNaN(d4);
        int i4 = (int) (d4 * 0.15d);
        double d5 = i4;
        Double.isNaN(d5);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, (int) (d5 * 0.45d));
        layoutParams.gravity = 53;
        layoutParams.topMargin = av.a(this.f16046n, 20.0f);
        layoutParams.rightMargin = av.a(this.f16046n, 20.0f);
        ViewGroup viewGroup = this.f16051s;
        if (viewGroup != null) {
            viewGroup.addView(this.f16049q, layoutParams);
        }
        View view = this.f16049q;
        if (view != null) {
            this.O = 1;
            this.P = 1;
            ((SkipView) view).setData(1, 0);
            ((SkipView) this.f16049q).setText(String.format("\u8df3\u8fc7 %d", 5));
            this.f16049q.setVisibility(0);
        }
    }

    private void aM() {
        CircleProgressView circleProgressView = new CircleProgressView(this.f16046n);
        this.H = circleProgressView;
        circleProgressView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.work.splash.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.H();
                if (e.this.f16053u != null) {
                    e.this.f16053u.cancel();
                }
                e.this.ac();
            }
        });
        this.H.setAlpha(0.0f);
        this.f16051s.addView(this.H, new FrameLayout.LayoutParams(-2, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN() {
        int[] iArr;
        float f4;
        float f5;
        ViewGroup viewGroup;
        this.f16049q.getLocationOnScreen(new int[2]);
        if (this.J != null) {
            float f6 = this.f16045L;
            float height = this.f16050r != null ? viewGroup.getHeight() : 0.0f;
            if (height == 0.0f) {
                height = this.M - av.a(this.f16046n, 100.0f);
            }
            double d4 = f6;
            Double.isNaN(d4);
            int width = (int) (d4 * this.J.getWidth() * 0.01d);
            double d5 = width;
            Double.isNaN(d5);
            int height2 = (int) (d5 * this.J.getHeight() * 0.01d);
            ViewGroup.LayoutParams layoutParams = this.H.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height2;
            this.H.setLayoutParams(layoutParams);
            f4 = (f6 * ((float) (this.J.getCenterX() * 0.01d))) - (width / 2);
            f5 = (height * ((float) (this.J.getCenterY() * 0.01d))) - (height2 / 2);
        } else {
            float pivotX = (iArr[0] + this.f16049q.getPivotX()) - (this.H.getWidth() / 2);
            float pivotY = (iArr[1] + this.f16049q.getPivotY()) - (this.H.getHeight() / 2);
            f4 = pivotX;
            f5 = pivotY;
        }
        this.H.setX(f4);
        this.H.setY(f5);
    }

    @Override // com.beizi.fusion.work.a
    public void ay() {
        v();
        e();
    }

    @Override // com.beizi.fusion.work.a
    public String g() {
        return AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_CSJ;
    }

    @Override // com.beizi.fusion.work.a
    public void d() {
        if (this.f15367d == null || this.f16046n == null) {
            return;
        }
        this.f15371h = this.f15368e.getAppId();
        this.f15372i = this.f15368e.getSpaceId();
        this.f15366c = this.f15368e.getBuyerSpaceUuId();
        af.b("BeiZis", "AdWorker chanel = " + this.f15366c);
        com.beizi.fusion.b.d dVar = this.f15364a;
        if (dVar != null) {
            com.beizi.fusion.b.b a4 = dVar.a().a(this.f15366c);
            this.f15365b = a4;
            if (a4 != null) {
                s();
                if (!av.a("com.bytedance.sdk.openadsdk.TTAdNative")) {
                    t();
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.e.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "CSJ sdk not import , will do nothing");
                    return;
                }
                u();
                u.a(this, this.f16046n, this.f15371h, this.f15368e.getDirectDownload());
                this.f15365b.t(TTAdSdk.getAdManager().getSDKVersion());
                au();
            }
        }
        this.U = this.f15369f.getSleepTime();
        if (this.f15367d.v()) {
            this.U = Math.max(this.U, this.f15369f.getHotRequestDelay());
        }
        List<AdSpacesBean.RenderViewBean> list = this.f16055w;
        boolean z3 = list != null && list.size() > 0;
        this.G = z3;
        if (z3) {
            aH();
        }
        this.f16045L = av.l(this.f16046n);
        this.M = av.m(this.f16046n);
    }

    @Override // com.beizi.fusion.work.a
    public void e() {
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + this.U);
        long j4 = this.U;
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

    @Override // com.beizi.fusion.work.a
    public void f() {
        Log.d("BeiZis", g() + " out make show ad");
        b();
    }

    @Override // com.beizi.fusion.work.a
    public com.beizi.fusion.f.a i() {
        return this.f15373j;
    }

    @Override // com.beizi.fusion.work.a
    public AdSpacesBean.BuyerBean k() {
        return this.f15368e;
    }

    @Override // com.beizi.fusion.work.a
    protected void l() {
        AdSlot build;
        w();
        ag();
        this.f16054v = null;
        com.beizi.fusion.d.g.a().a(g(), false, false);
        if (av()) {
            return;
        }
        if (this.V == 0) {
            this.V = (int) av.j(this.f16046n);
        }
        if (this.W == 0) {
            this.W = (int) av.k(this.f16046n);
        }
        int a4 = av.a(this.f16046n, this.W);
        int a5 = av.a(this.f16046n, this.V);
        af.a("BeiZis", "splashWidthPx = " + a5 + ",splashHeightPx = " + a4);
        this.f16052t = u.a().createAdNative(this.f16046n);
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar != null && eVar.y()) {
            build = new AdSlot.Builder().setCodeId(this.f15372i).setSupportDeepLink(true).setImageAcceptedSize(a5, a4).setExpressViewAcceptedSize(this.V, this.W).build();
        } else {
            build = new AdSlot.Builder().setCodeId(this.f15372i).setSupportDeepLink(true).setImageAcceptedSize(a5, a4).setExpressViewAcceptedSize(this.V, this.W).build();
        }
        this.f16052t.loadSplashAd(build, new TTAdNative.CSJSplashAdListener() { // from class: com.beizi.fusion.work.splash.e.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashLoadFail(CSJAdError cSJAdError) {
                Log.d("BeiZis", "showCsjSplash onSplashLoadFail code:" + cSJAdError.getCode() + ";" + cSJAdError.getMsg());
                e.this.a(cSJAdError.getMsg(), cSJAdError.getCode());
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashLoadSuccess(CSJSplashAd cSJSplashAd) {
                Log.d("BeiZis", "showCsjSplash onSplashLoadSuccess()");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashRenderFail(CSJSplashAd cSJSplashAd, CSJAdError cSJAdError) {
                Log.d("BeiZis", "showCsjSplash onSplashRenderFail code:" + cSJAdError.getCode() + ";" + cSJAdError.getMsg());
                e.this.a(cSJAdError.getMsg(), cSJAdError.getCode());
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashRenderSuccess(CSJSplashAd cSJSplashAd) {
                Log.d("BeiZis", "showCsjSplash onSplashRenderSuccess()");
                e.this.T = cSJSplashAd;
                ((com.beizi.fusion.work.a) e.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                e.this.y();
                if (cSJSplashAd == null) {
                    e.this.c(-991);
                    return;
                }
                if (!e.this.Y()) {
                    e.this.O();
                } else {
                    e.this.a(cSJSplashAd);
                }
                cSJSplashAd.setSplashAdListener(new CSJSplashAd.SplashAdListener() { // from class: com.beizi.fusion.work.splash.e.2.1
                    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                    public void onSplashAdClick(CSJSplashAd cSJSplashAd2) {
                        Log.d("BeiZis", "showCsjSplash onSplashAdClick()");
                        e.this.E();
                        if (((com.beizi.fusion.work.a) e.this).f15367d != null) {
                            if (((com.beizi.fusion.work.a) e.this).f15367d.s() != 2) {
                                ((com.beizi.fusion.work.a) e.this).f15367d.d(e.this.g());
                                ((com.beizi.fusion.work.a) e.this).f15376m.sendEmptyMessageDelayed(2, (((com.beizi.fusion.work.a) e.this).f15375l + 5000) - System.currentTimeMillis());
                            }
                            e.this.ai();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                    public void onSplashAdClose(CSJSplashAd cSJSplashAd2, int i4) {
                        Log.d("BeiZis", "showCsjSplash onSplashAdClose()");
                        if (((com.beizi.fusion.work.a) e.this).f15367d != null && ((com.beizi.fusion.work.a) e.this).f15367d.s() != 2) {
                            e.this.ac();
                        }
                        if (i4 == 1) {
                            e.this.H();
                        }
                        e.this.G();
                    }

                    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                    public void onSplashAdShow(CSJSplashAd cSJSplashAd2) {
                        Log.d("BeiZis", "showCsjSplash onSplashAdShow()");
                        ((com.beizi.fusion.work.a) e.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
                        e.this.ab();
                        e.this.C();
                        e.this.D();
                        e.this.ah();
                    }
                });
            }
        }, (int) this.f16048p);
    }

    private void b() {
        CSJSplashAd cSJSplashAd = this.T;
        if (cSJSplashAd != null) {
            this.f16054v = cSJSplashAd.getSplashView();
            if (av.a("com.bytedance.sdk.openadsdk.ISplashClickEyeListener")) {
                a(this.f16046n, this.T, this.f16054v);
            } else {
                Log.d("BeiZis", "CSJ sdk is not Support SplashClickEye");
            }
            if (this.f16051s != null && this.f16050r != null) {
                b(this.T);
                this.f16051s.removeAllViews();
                this.f16051s.addView(this.f16054v);
                aK();
                this.f16050r.removeAllViews();
                this.f16050r.addView(this.f16051s);
                return;
            }
            aw();
            return;
        }
        aw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CSJSplashAd cSJSplashAd) {
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar == null) {
            return;
        }
        Map<String, com.beizi.fusion.work.a> r3 = eVar.r();
        Log.d("BeiZis", g() + " splashWorkers:" + r3.toString());
        Z();
        com.beizi.fusion.d.h hVar = this.f15370g;
        if (hVar == com.beizi.fusion.d.h.SUCCESS) {
            ad();
        } else if (hVar == com.beizi.fusion.d.h.FAIL) {
            Log.d("BeiZis", "other worker shown," + g() + " remove");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i4) {
        if (this.O == 1) {
            String valueOf = String.valueOf(i4);
            String str = this.Q + " ";
            String str2 = str + valueOf;
            SpannableString spannableString = new SpannableString(str2);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.R)), 0, str.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.S)), str2.indexOf(valueOf), str2.length(), 33);
            ((SkipView) this.f16049q).setText(spannableString);
            return;
        }
        SpannableString spannableString2 = new SpannableString(this.Q);
        spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor(this.R)), 0, this.Q.length(), 33);
        ((SkipView) this.f16049q).setText(spannableString2);
    }

    private void a(Context context, CSJSplashAd cSJSplashAd, View view) {
        Activity activity = (Activity) context;
        if (activity == null || cSJSplashAd == null || view == null) {
            return;
        }
        c a4 = c.a(context);
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
                com.beizi.fusion.d.g.a().a(e.this.g(), true, true);
                boolean b4 = com.beizi.fusion.d.g.a().b();
                if (((com.beizi.fusion.work.a) e.this).f15365b != null) {
                    ((com.beizi.fusion.work.a) e.this).f15365b.K(b4 ? "2" : "0");
                    e.this.au();
                }
            }
        });
        a4.a(context, cSJSplashAd, view, activity.getWindow().getDecorView());
    }

    private void b(CSJSplashAd cSJSplashAd) {
        String str;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.beizi.fusion.work.splash.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.f16053u != null) {
                    e.this.f16053u.cancel();
                }
                e.this.ac();
            }
        };
        if (this.G) {
            if (cSJSplashAd != null) {
                cSJSplashAd.hideSkipButton();
            }
            View view = this.f16049q;
            if (view != null) {
                view.setVisibility(8);
                view.setAlpha(0.0f);
            }
            SkipView skipView = new SkipView(this.f16046n);
            this.f16049q = skipView;
            skipView.setOnClickListener(onClickListener);
            this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.e.4
                @Override // java.lang.Runnable
                public void run() {
                    e.this.aI();
                }
            }, this.K);
            str = "beizi";
        } else if (this.f16049q != null) {
            if (cSJSplashAd != null) {
                cSJSplashAd.hideSkipButton();
            }
            this.f16049q.setOnClickListener(onClickListener);
            aG();
            str = "app";
        } else {
            str = "buyer";
        }
        com.beizi.fusion.b.b bVar = this.f15365b;
        if (bVar != null) {
            bVar.r(str);
            au();
        }
    }
}
