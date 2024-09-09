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
import com.beizi.fusion.d.n;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.al;
import com.beizi.fusion.g.av;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.CircleProgressView;
import com.beizi.fusion.widget.SkipView;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.model.SplashAdExtraData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: KsSplashWorker.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class k extends com.beizi.fusion.work.a {
    private long E;
    private boolean F;
    private CircleProgressView G;
    private AdSpacesBean.PositionBean H;
    private AdSpacesBean.PositionBean I;
    private long J;
    private float K;

    /* renamed from: L  reason: collision with root package name */
    private float f16159L;
    private AdSpacesBean.RenderViewBean M;
    private int N;
    private int O;
    private String P;
    private String Q;
    private String R;
    private ViewGroup T;

    /* renamed from: n  reason: collision with root package name */
    long f16160n;

    /* renamed from: o  reason: collision with root package name */
    private Context f16161o;

    /* renamed from: p  reason: collision with root package name */
    private String f16162p;

    /* renamed from: q  reason: collision with root package name */
    private long f16163q;

    /* renamed from: r  reason: collision with root package name */
    private ViewGroup f16164r;

    /* renamed from: s  reason: collision with root package name */
    private KsSplashScreenAd f16165s;

    /* renamed from: t  reason: collision with root package name */
    private CountDownTimer f16166t;

    /* renamed from: u  reason: collision with root package name */
    private View f16167u;

    /* renamed from: v  reason: collision with root package name */
    private List<AdSpacesBean.RenderViewBean> f16168v;

    /* renamed from: w  reason: collision with root package name */
    private List<AdSpacesBean.RenderViewBean> f16169w = new ArrayList();

    /* renamed from: x  reason: collision with root package name */
    private List<AdSpacesBean.RenderViewBean> f16170x = new ArrayList();

    /* renamed from: y  reason: collision with root package name */
    private boolean f16171y = false;

    /* renamed from: z  reason: collision with root package name */
    private boolean f16172z = false;
    private boolean A = false;
    private boolean B = false;
    private boolean C = false;
    private long D = 5000;
    private View S = null;

    public k(Context context, String str, long j4, ViewGroup viewGroup, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, List<AdSpacesBean.RenderViewBean> list, com.beizi.fusion.d.e eVar) {
        this.f16161o = context;
        this.f16162p = str;
        this.f16163q = j4;
        this.f16164r = viewGroup;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        this.T = new SplashContainer(context);
        this.f16168v = list;
        r();
    }

    private void aG() {
        if (this.f16164r != null) {
            try {
                this.f16167u = a(this.f16165s);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            this.f16164r.removeAllViews();
            if (this.f16167u != null && this.T != null) {
                aH();
                this.T.removeAllViews();
                this.f16167u.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.T.addView(this.f16167u);
                aN();
                this.f16164r.removeAllViews();
                this.f16164r.addView(this.T);
                return;
            }
            aw();
            return;
        }
        aw();
    }

    private void aH() {
        String str;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.beizi.fusion.work.splash.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.f16166t != null) {
                    k.this.f16166t.cancel();
                }
                k.this.ac();
            }
        };
        if (this.F) {
            View view = this.S;
            if (view != null) {
                view.setVisibility(8);
                view.setAlpha(0.0f);
            }
            SkipView skipView = new SkipView(this.f16161o);
            this.S = skipView;
            skipView.setOnClickListener(onClickListener);
            this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.k.5
                @Override // java.lang.Runnable
                public void run() {
                    k.this.aK();
                }
            }, this.J);
            str = "beizi";
        } else {
            View view2 = this.S;
            if (view2 != null) {
                view2.setOnClickListener(onClickListener);
                aI();
                str = "app";
            } else {
                str = "buyer";
            }
        }
        com.beizi.fusion.b.b bVar = this.f15365b;
        if (bVar != null) {
            bVar.r(str);
            au();
        }
    }

    private void aI() {
        CountDownTimer countDownTimer = this.f16166t;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(100 + this.D, 50L) { // from class: com.beizi.fusion.work.splash.k.6
            @Override // android.os.CountDownTimer
            public void onFinish() {
                k.this.ac();
                k.this.G();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j4) {
                if (((com.beizi.fusion.work.a) k.this).f15367d == null || ((com.beizi.fusion.work.a) k.this).f15367d.s() == 2) {
                    return;
                }
                ((com.beizi.fusion.work.a) k.this).f15367d.a(j4);
            }
        };
        this.f16166t = countDownTimer2;
        countDownTimer2.start();
    }

    private void aJ() {
        for (int i4 = 0; i4 < this.f16168v.size(); i4++) {
            AdSpacesBean.RenderViewBean renderViewBean = this.f16168v.get(i4);
            String type = renderViewBean.getType();
            if ("SKIPVIEW".equals(type)) {
                this.f16170x.add(renderViewBean);
            } else if ("MATERIALVIEW".equals(type)) {
                this.f16169w.add(renderViewBean);
            }
        }
        this.E = 0L;
        if (this.f16170x.size() > 0) {
            AdSpacesBean.RenderViewBean renderViewBean2 = this.f16170x.get(0);
            this.M = renderViewBean2;
            if (renderViewBean2 != null) {
                this.I = renderViewBean2.getTapPosition();
                this.H = this.M.getLayerPosition();
                long delayDisplaySkipButton = this.M.getDelayDisplaySkipButton();
                this.J = delayDisplaySkipButton;
                if (delayDisplaySkipButton < 0) {
                    this.J = 0L;
                }
                long skipViewTotalTime = this.M.getSkipViewTotalTime();
                if (skipViewTotalTime > 0) {
                    this.D = skipViewTotalTime;
                }
                long skipUnavailableTime = this.M.getSkipUnavailableTime();
                if (skipUnavailableTime > 0) {
                    this.E = skipUnavailableTime;
                }
                this.N = this.M.getShowCountDown();
                this.O = this.M.getShowBorder();
                String skipText = this.M.getSkipText();
                this.P = skipText;
                if (TextUtils.isEmpty(skipText)) {
                    this.P = "\u8df3\u8fc7";
                }
                String textColor = this.M.getTextColor();
                this.Q = textColor;
                if (TextUtils.isEmpty(textColor)) {
                    this.Q = "#FFFFFF";
                }
                String countDownColor = this.M.getCountDownColor();
                this.R = countDownColor;
                if (TextUtils.isEmpty(countDownColor)) {
                    this.R = "#FFFFFF";
                }
                List<AdSpacesBean.PassPolicyBean> passPolicy = this.M.getPassPolicy();
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
                                this.f16172z = al.a(passPercent);
                                break;
                            case 1:
                                this.f16171y = al.a(passPercent);
                                break;
                            case 2:
                                AdSpacesBean.PositionBean positionBean = this.H;
                                if (positionBean != null && this.I != null) {
                                    double centerX = positionBean.getCenterX();
                                    double centerY = this.H.getCenterY();
                                    double width = this.H.getWidth();
                                    double height = this.H.getHeight();
                                    double centerX2 = this.I.getCenterX();
                                    double centerY2 = this.I.getCenterY();
                                    double width2 = this.I.getWidth();
                                    double height2 = this.I.getHeight();
                                    if ((centerX > 0.0d && centerX2 > 0.0d && centerX != centerX2) || ((centerY > 0.0d && centerY2 > 0.0d && centerY != centerY2) || ((width > 0.0d && width2 > 0.0d && width != width2) || (height > 0.0d && height2 > 0.0d && height != height2)))) {
                                        this.A = al.a(passPercent);
                                    }
                                    if (width2 * height2 < width * height) {
                                        this.B = true;
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
        if (this.f16169w.size() > 0) {
            Collections.sort(this.f16169w, new Comparator<AdSpacesBean.RenderViewBean>() { // from class: com.beizi.fusion.work.splash.k.7
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(AdSpacesBean.RenderViewBean renderViewBean3, AdSpacesBean.RenderViewBean renderViewBean4) {
                    return renderViewBean4.getLevel() - renderViewBean3.getLevel();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK() {
        if (this.f16171y) {
            Q();
        }
        if (this.f16172z) {
            R();
        }
        if (this.A) {
            S();
        }
        if (this.B) {
            T();
        }
        aL();
    }

    private void aL() {
        CountDownTimer countDownTimer = this.f16166t;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        final long j4 = this.D - this.E;
        CountDownTimer countDownTimer2 = new CountDownTimer(this.D + 100, 50L) { // from class: com.beizi.fusion.work.splash.k.8

            /* renamed from: a  reason: collision with root package name */
            boolean f16180a = false;

            @Override // android.os.CountDownTimer
            public void onFinish() {
                k.this.ac();
                k.this.G();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j5) {
                if (!this.f16180a) {
                    k.this.aQ();
                    this.f16180a = true;
                }
                if (k.this.E > 0 && k.this.E <= k.this.D) {
                    if (k.this.f16171y) {
                        long j6 = j4;
                        if (j6 <= 0 || j5 <= j6) {
                            k.this.C = false;
                            k.this.S.setAlpha(1.0f);
                        } else {
                            k.this.C = true;
                            k.this.S.setAlpha(0.2f);
                        }
                    }
                    if (k.this.E == k.this.D) {
                        k.this.S.setEnabled(false);
                    } else {
                        k.this.S.setEnabled(true);
                    }
                }
                if (k.this.F && k.this.S != null) {
                    k.this.e(Math.round(((float) j5) / 1000.0f));
                }
                if (((com.beizi.fusion.work.a) k.this).f15367d == null || ((com.beizi.fusion.work.a) k.this).f15367d.s() == 2) {
                    return;
                }
                ((com.beizi.fusion.work.a) k.this).f15367d.a(j5);
            }
        };
        this.f16166t = countDownTimer2;
        countDownTimer2.start();
        aP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM() {
        CountDownTimer countDownTimer = this.f16166t;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            af.a("BeiZis", "enter cancel mCountDownTimer");
        }
    }

    private void aN() {
        ViewGroup viewGroup;
        if (this.F) {
            if (this.H != null && (viewGroup = this.f16164r) != null) {
                float f4 = this.K;
                float height = viewGroup.getHeight();
                if (height == 0.0f) {
                    height = this.f16159L - av.a(this.f16161o, 100.0f);
                }
                double d4 = f4;
                Double.isNaN(d4);
                int width = (int) (d4 * this.H.getWidth() * 0.01d);
                if (this.H.getHeight() >= 12.0d) {
                    double d5 = width;
                    Double.isNaN(d5);
                    int height2 = (int) (d5 * this.H.getHeight() * 0.01d);
                    double d6 = height2;
                    Double.isNaN(d6);
                    int paddingHeight = (int) (d6 * this.M.getPaddingHeight() * 0.01d);
                    if (paddingHeight < 0) {
                        paddingHeight = 0;
                    }
                    ((SkipView) this.S).setData(this.O, paddingHeight);
                    e(5);
                    this.T.addView(this.S, new FrameLayout.LayoutParams(width, height2));
                    float centerX = (f4 * ((float) (this.H.getCenterX() * 0.01d))) - (width / 2);
                    float centerY = (height * ((float) (this.H.getCenterY() * 0.01d))) - (height2 / 2);
                    this.S.setX(centerX);
                    this.S.setY(centerY);
                    View view = this.S;
                    if (view != null) {
                        view.setVisibility(0);
                        return;
                    }
                    return;
                }
                aO();
                return;
            }
            aO();
            return;
        }
        View view2 = this.S;
        if (view2 != null) {
            view2.setVisibility(0);
            this.S.setAlpha(1.0f);
        }
    }

    private void aO() {
        double d4 = this.K;
        Double.isNaN(d4);
        int i4 = (int) (d4 * 0.15d);
        double d5 = i4;
        Double.isNaN(d5);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, (int) (d5 * 0.45d));
        layoutParams.gravity = 53;
        layoutParams.topMargin = av.a(this.f16161o, 20.0f);
        layoutParams.rightMargin = av.a(this.f16161o, 20.0f);
        ViewGroup viewGroup = this.T;
        if (viewGroup != null) {
            viewGroup.addView(this.S, layoutParams);
        }
        View view = this.S;
        if (view != null) {
            this.N = 1;
            this.O = 1;
            ((SkipView) view).setData(1, 0);
            ((SkipView) this.S).setText(String.format("\u8df3\u8fc7 %d", 5));
            this.S.setVisibility(0);
        }
    }

    private void aP() {
        CircleProgressView circleProgressView = new CircleProgressView(this.f16161o);
        this.G = circleProgressView;
        circleProgressView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.work.splash.k.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.H();
                if (k.this.f16166t != null) {
                    k.this.f16166t.cancel();
                }
                k.this.ac();
            }
        });
        this.G.setAlpha(0.0f);
        this.T.addView(this.G, new FrameLayout.LayoutParams(-2, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ() {
        int[] iArr;
        float f4;
        float f5;
        ViewGroup viewGroup;
        this.S.getLocationOnScreen(new int[2]);
        if (this.I != null) {
            float f6 = this.K;
            float height = this.f16164r != null ? viewGroup.getHeight() : 0.0f;
            if (height == 0.0f) {
                height = this.f16159L - av.a(this.f16161o, 100.0f);
            }
            double d4 = f6;
            Double.isNaN(d4);
            int width = (int) (d4 * this.I.getWidth() * 0.01d);
            double d5 = width;
            Double.isNaN(d5);
            int height2 = (int) (d5 * this.I.getHeight() * 0.01d);
            ViewGroup.LayoutParams layoutParams = this.G.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height2;
            this.G.setLayoutParams(layoutParams);
            f4 = (f6 * ((float) (this.I.getCenterX() * 0.01d))) - (width / 2);
            f5 = (height * ((float) (this.I.getCenterY() * 0.01d))) - (height2 / 2);
        } else {
            float pivotX = (iArr[0] + this.S.getPivotX()) - (this.G.getWidth() / 2);
            float pivotY = (iArr[1] + this.S.getPivotY()) - (this.G.getHeight() / 2);
            f4 = pivotX;
            f5 = pivotY;
        }
        this.G.setX(f4);
        this.G.setY(f5);
    }

    @Override // com.beizi.fusion.work.a
    public String g() {
        return "KUAISHOU";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i4) {
        if (this.N == 1) {
            String valueOf = String.valueOf(i4);
            String str = this.P + " ";
            String str2 = str + valueOf;
            SpannableString spannableString = new SpannableString(str2);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.Q)), 0, str.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.R)), str2.indexOf(valueOf), str2.length(), 33);
            ((SkipView) this.S).setText(spannableString);
            return;
        }
        SpannableString spannableString2 = new SpannableString(this.P);
        spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor(this.Q)), 0, this.P.length(), 33);
        ((SkipView) this.S).setText(spannableString2);
    }

    @Override // com.beizi.fusion.work.a
    public void d() {
        if (this.f15367d == null) {
            return;
        }
        this.f16160n = System.currentTimeMillis();
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
                if (!av.a(AMPSConstants.CHANNEL_SDK_KS_CLASSNAME)) {
                    t();
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.k.1
                        @Override // java.lang.Runnable
                        public void run() {
                            k.this.c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "Ks sdk not import , will do nothing");
                    return;
                }
                u();
                n.a(this.f16161o, this.f15371h);
                this.f15365b.u(KsAdSDK.getSDKVersion());
                au();
                v();
            }
        }
        long sleepTime = this.f15369f.getSleepTime();
        if (this.f15367d.v()) {
            sleepTime = Math.max(sleepTime, this.f15369f.getHotRequestDelay());
        }
        List<AdSpacesBean.RenderViewBean> list = this.f16168v;
        boolean z3 = list != null && list.size() > 0;
        this.F = z3;
        if (z3) {
            aJ();
        }
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + sleepTime);
        if (sleepTime > 0) {
            this.f15376m.sendEmptyMessageDelayed(1, sleepTime);
        } else {
            com.beizi.fusion.d.e eVar = this.f15367d;
            if (eVar != null && eVar.t() < 1 && this.f15367d.s() != 2) {
                l();
            }
        }
        this.K = av.l(this.f16161o);
        this.f16159L = av.m(this.f16161o);
    }

    @Override // com.beizi.fusion.work.a
    public void f() {
        Log.d("BeiZis", g() + " out make show ad");
        aG();
    }

    @Override // com.beizi.fusion.work.a
    public com.beizi.fusion.f.a i() {
        return this.f15373j;
    }

    @Override // com.beizi.fusion.work.a
    public String j() {
        if (this.f16165s == null) {
            return null;
        }
        return this.f16165s.getECPM() + "";
    }

    @Override // com.beizi.fusion.work.a
    public AdSpacesBean.BuyerBean k() {
        return this.f15368e;
    }

    @Override // com.beizi.fusion.work.a
    protected void l() {
        w();
        ag();
        SplashAdExtraData splashAdExtraData = new SplashAdExtraData();
        if (BeiZis.isCloseShakeAd()) {
            splashAdExtraData.setDisableShakeStatus(true);
        } else {
            splashAdExtraData.setDisableShakeStatus(false);
        }
        KsScene build = new KsScene.Builder(Long.parseLong(this.f15372i)).setSplashExtraData(splashAdExtraData).build();
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (loadManager == null) {
            Log.d("BeiZis", "showKsSplash onError:\u6e20\u9053\u5e7f\u544a\u8bf7\u6c42\u5bf9\u8c61\u4e3a\u7a7a");
            a("\u6e20\u9053\u5e7f\u544a\u8bf7\u6c42\u5f02\u5e38", 10160);
            return;
        }
        if (AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(this.f15368e.getBidType())) {
            build.setBidResponse(aC());
        }
        loadManager.loadSplashScreenAd(build, new KsLoadManager.SplashScreenAdListener() { // from class: com.beizi.fusion.work.splash.k.2
            @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
            public void onError(int i4, String str) {
                Log.d("BeiZis", "showKsSplash onError:" + str);
                k.this.a(str, i4);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
            public void onRequestResult(int i4) {
            }

            @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
            public void onSplashScreenAdLoad(@NonNull KsSplashScreenAd ksSplashScreenAd) {
                k.this.y();
                ((com.beizi.fusion.work.a) k.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                k.this.f16165s = ksSplashScreenAd;
                if (k.this.f16165s != null) {
                    k kVar = k.this;
                    kVar.a(kVar.f16165s.getECPM());
                }
                if (k.this.Y()) {
                    k.this.b();
                } else {
                    k.this.O();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
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

    private View a(KsSplashScreenAd ksSplashScreenAd) {
        if (ksSplashScreenAd == null) {
            return null;
        }
        return ksSplashScreenAd.getView(this.f16161o, new KsSplashScreenAd.SplashScreenAdInteractionListener() { // from class: com.beizi.fusion.work.splash.k.3
            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdClicked() {
                Log.d("BeiZis", "showKsSplash onAdClick()");
                if (((com.beizi.fusion.work.a) k.this).f15367d != null && ((com.beizi.fusion.work.a) k.this).f15367d.s() != 2) {
                    ((com.beizi.fusion.work.a) k.this).f15367d.d(k.this.g());
                    ((com.beizi.fusion.work.a) k.this).f15376m.sendEmptyMessageDelayed(2, (((com.beizi.fusion.work.a) k.this).f15375l + 5000) - System.currentTimeMillis());
                }
                k.this.E();
                k.this.ai();
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdShowEnd() {
                Log.d("BeiZis", "showKsSplash onADDismissed()");
                k.this.ac();
                k.this.G();
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdShowError(int i4, String str) {
                Log.d("BeiZis", "showKsSplash onAdShowError:" + str);
                k.this.a(str, i4);
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdShowStart() {
                Log.d("BeiZis", "showKsSplash onADPresent()");
                k.this.C();
                Log.d("BeiZis", "showKsSplash onADExposure()");
                ((com.beizi.fusion.work.a) k.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
                k.this.ab();
                k.this.D();
                k.this.ah();
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onDownloadTipsDialogCancel() {
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onDownloadTipsDialogDismiss() {
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onDownloadTipsDialogShow() {
                k.this.aM();
                ((com.beizi.fusion.work.a) k.this).f15376m.removeMessages(2);
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onSkippedAd() {
                Log.d("BeiZis", "showKsSplash onSkippedAd()");
                k.this.ac();
                k.this.H();
            }
        });
    }
}
