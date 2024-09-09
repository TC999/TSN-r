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
import com.beizi.fusion.d.u;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.al;
import com.beizi.fusion.g.av;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.CircleProgressView;
import com.beizi.fusion.widget.SkipView;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: CsjNSTWorker.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class d extends com.beizi.fusion.work.a implements com.beizi.fusion.d.c {
    private long G;
    private boolean H;
    private CircleProgressView I;
    private AdSpacesBean.PositionBean J;
    private AdSpacesBean.PositionBean K;

    /* renamed from: L  reason: collision with root package name */
    private long f16016L;
    private float M;
    private float N;
    private float O;
    private float P;
    private float Q;
    private float R;
    private AdSpacesBean.RenderViewBean S;
    private int T;
    private int U;
    private String V;
    private String W;
    private String X;
    private long Y;

    /* renamed from: n  reason: collision with root package name */
    private Context f16017n;

    /* renamed from: o  reason: collision with root package name */
    private String f16018o;

    /* renamed from: p  reason: collision with root package name */
    private long f16019p;

    /* renamed from: q  reason: collision with root package name */
    private View f16020q;

    /* renamed from: r  reason: collision with root package name */
    private ViewGroup f16021r;

    /* renamed from: s  reason: collision with root package name */
    private ViewGroup f16022s;

    /* renamed from: t  reason: collision with root package name */
    private TTAdNative f16023t;

    /* renamed from: u  reason: collision with root package name */
    private TTNativeExpressAd f16024u;

    /* renamed from: v  reason: collision with root package name */
    private CountDownTimer f16025v;

    /* renamed from: w  reason: collision with root package name */
    private View f16026w;

    /* renamed from: x  reason: collision with root package name */
    private List<AdSpacesBean.RenderViewBean> f16027x;

    /* renamed from: y  reason: collision with root package name */
    private List<AdSpacesBean.RenderViewBean> f16028y = new ArrayList();

    /* renamed from: z  reason: collision with root package name */
    private List<AdSpacesBean.RenderViewBean> f16029z = new ArrayList();
    private boolean A = false;
    private boolean B = false;
    private boolean C = false;
    private boolean D = false;
    private boolean E = false;
    private long F = 5000;

    public d(Context context, String str, long j4, View view, ViewGroup viewGroup, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, List<AdSpacesBean.RenderViewBean> list, com.beizi.fusion.d.e eVar) {
        this.f16017n = context;
        this.f16018o = str;
        this.f16019p = j4;
        this.f16020q = view;
        this.f16021r = viewGroup;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        this.f16022s = new SplashContainer(context);
        this.f16027x = list;
        r();
    }

    private void aG() {
        CountDownTimer countDownTimer = this.f16025v;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(100 + this.F, 50L) { // from class: com.beizi.fusion.work.splash.d.5
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (((com.beizi.fusion.work.a) d.this).f15367d == null) {
                    return;
                }
                ((com.beizi.fusion.work.a) d.this).f15367d.c(d.this.g());
                d.this.G();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j4) {
                if (d.this.H && d.this.f16020q != null) {
                    d.this.e(Math.round(((float) j4) / 1000.0f));
                }
                if (((com.beizi.fusion.work.a) d.this).f15367d == null || ((com.beizi.fusion.work.a) d.this).f15367d.s() == 2) {
                    return;
                }
                ((com.beizi.fusion.work.a) d.this).f15367d.a(j4);
            }
        };
        this.f16025v = countDownTimer2;
        countDownTimer2.start();
    }

    private void aH() {
        ViewGroup viewGroup = this.f16022s;
        if (viewGroup != null && this.f16021r != null && this.f16026w != null) {
            viewGroup.removeAllViews();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.Q, (int) this.R);
            if (this.R < 1200.0f) {
                layoutParams.gravity = 16;
            }
            this.f16022s.addView(this.f16026w, layoutParams);
            final ViewGroup viewGroup2 = this.f16021r;
            if (viewGroup2 instanceof ViewGroup) {
                viewGroup2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.beizi.fusion.work.splash.d.6
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        if (viewGroup2 == null) {
                            return;
                        }
                        float height = d.this.f16021r.getHeight();
                        if (d.this.R > height) {
                            float f4 = height / d.this.R;
                            d.this.f16026w.setPivotY(0.0f);
                            d.this.f16026w.setScaleY(f4);
                        }
                        viewGroup2.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                });
            }
            aI();
            aM();
            this.f16021r.removeAllViews();
            this.f16021r.addView(this.f16022s);
            return;
        }
        aw();
    }

    private void aI() {
        String str;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.beizi.fusion.work.splash.d.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.f16025v != null) {
                    d.this.f16025v.cancel();
                }
                if (((com.beizi.fusion.work.a) d.this).f15367d != null) {
                    ((com.beizi.fusion.work.a) d.this).f15367d.c(d.this.g());
                }
            }
        };
        if (this.H) {
            View view = this.f16020q;
            if (view != null) {
                view.setVisibility(8);
                view.setAlpha(0.0f);
            }
            SkipView skipView = new SkipView(this.f16017n);
            this.f16020q = skipView;
            skipView.setOnClickListener(onClickListener);
            this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.d.8
                @Override // java.lang.Runnable
                public void run() {
                    d.this.aK();
                }
            }, this.f16016L);
            str = "beizi";
        } else {
            View view2 = this.f16020q;
            if (view2 != null) {
                view2.setOnClickListener(onClickListener);
                aG();
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

    private void aJ() {
        for (int i4 = 0; i4 < this.f16027x.size(); i4++) {
            AdSpacesBean.RenderViewBean renderViewBean = this.f16027x.get(i4);
            String type = renderViewBean.getType();
            if ("SKIPVIEW".equals(type)) {
                this.f16029z.add(renderViewBean);
            } else if ("MATERIALVIEW".equals(type)) {
                this.f16028y.add(renderViewBean);
            }
        }
        this.G = 0L;
        if (this.f16029z.size() > 0) {
            AdSpacesBean.RenderViewBean renderViewBean2 = this.f16029z.get(0);
            this.S = renderViewBean2;
            if (renderViewBean2 != null) {
                this.K = renderViewBean2.getTapPosition();
                this.J = this.S.getLayerPosition();
                long delayDisplaySkipButton = this.S.getDelayDisplaySkipButton();
                this.f16016L = delayDisplaySkipButton;
                if (delayDisplaySkipButton < 0) {
                    this.f16016L = 0L;
                }
                long skipViewTotalTime = this.S.getSkipViewTotalTime();
                if (skipViewTotalTime > 0) {
                    this.F = skipViewTotalTime;
                }
                long skipUnavailableTime = this.S.getSkipUnavailableTime();
                if (skipUnavailableTime > 0) {
                    this.G = skipUnavailableTime;
                }
                this.T = this.S.getShowCountDown();
                this.U = this.S.getShowBorder();
                String skipText = this.S.getSkipText();
                this.V = skipText;
                if (TextUtils.isEmpty(skipText)) {
                    this.V = "\u8df3\u8fc7";
                }
                String textColor = this.S.getTextColor();
                this.W = textColor;
                if (TextUtils.isEmpty(textColor)) {
                    this.W = "#FFFFFF";
                }
                String countDownColor = this.S.getCountDownColor();
                this.X = countDownColor;
                if (TextUtils.isEmpty(countDownColor)) {
                    this.X = "#FFFFFF";
                }
                List<AdSpacesBean.PassPolicyBean> passPolicy = this.S.getPassPolicy();
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
                                this.B = al.a(passPercent);
                                break;
                            case 1:
                                this.A = al.a(passPercent);
                                break;
                            case 2:
                                AdSpacesBean.PositionBean positionBean = this.J;
                                if (positionBean != null && this.K != null) {
                                    double centerX = positionBean.getCenterX();
                                    double centerY = this.J.getCenterY();
                                    double width = this.J.getWidth();
                                    double height = this.J.getHeight();
                                    double centerX2 = this.K.getCenterX();
                                    double centerY2 = this.K.getCenterY();
                                    double width2 = this.K.getWidth();
                                    double height2 = this.K.getHeight();
                                    if ((centerX > 0.0d && centerX2 > 0.0d && centerX != centerX2) || ((centerY > 0.0d && centerY2 > 0.0d && centerY != centerY2) || ((width > 0.0d && width2 > 0.0d && width != width2) || (height > 0.0d && height2 > 0.0d && height != height2)))) {
                                        this.C = al.a(passPercent);
                                    }
                                    if (width2 * height2 < width * height) {
                                        this.D = true;
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
        if (this.f16028y.size() > 0) {
            Collections.sort(this.f16028y, new Comparator<AdSpacesBean.RenderViewBean>() { // from class: com.beizi.fusion.work.splash.d.9
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
        if (this.A) {
            Q();
        }
        if (this.B) {
            R();
        }
        if (this.C) {
            S();
        }
        if (this.D) {
            T();
        }
        aL();
    }

    private void aL() {
        CountDownTimer countDownTimer = this.f16025v;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        final long j4 = this.F - this.G;
        CountDownTimer countDownTimer2 = new CountDownTimer(this.F + 100, 50L) { // from class: com.beizi.fusion.work.splash.d.10

            /* renamed from: a  reason: collision with root package name */
            boolean f16031a = false;

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (((com.beizi.fusion.work.a) d.this).f15367d == null) {
                    return;
                }
                ((com.beizi.fusion.work.a) d.this).f15367d.c(d.this.g());
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j5) {
                if (!this.f16031a) {
                    d.this.aP();
                    this.f16031a = true;
                }
                if (d.this.G > 0 && d.this.G <= d.this.F) {
                    if (d.this.A) {
                        long j6 = j4;
                        if (j6 <= 0 || j5 <= j6) {
                            d.this.E = false;
                            d.this.f16020q.setAlpha(1.0f);
                        } else {
                            d.this.E = true;
                            d.this.f16020q.setAlpha(0.2f);
                        }
                    }
                    if (d.this.G == d.this.F) {
                        d.this.f16020q.setEnabled(false);
                    } else {
                        d.this.f16020q.setEnabled(true);
                    }
                }
                if (d.this.H && d.this.f16020q != null) {
                    ((SkipView) d.this.f16020q).setText(String.format("\u8df3\u8fc7 %d", Integer.valueOf(Math.round(((float) j5) / 1000.0f))));
                }
                if (((com.beizi.fusion.work.a) d.this).f15367d == null || ((com.beizi.fusion.work.a) d.this).f15367d.s() == 2) {
                    return;
                }
                ((com.beizi.fusion.work.a) d.this).f15367d.a(j5);
            }
        };
        this.f16025v = countDownTimer2;
        countDownTimer2.start();
        aO();
    }

    private void aM() {
        ViewGroup viewGroup;
        if (this.H) {
            if (this.J != null && (viewGroup = this.f16021r) != null) {
                float f4 = this.M;
                float height = viewGroup.getHeight();
                if (height == 0.0f) {
                    height = this.N - av.a(this.f16017n, 100.0f);
                }
                double d4 = f4;
                Double.isNaN(d4);
                int width = (int) (d4 * this.J.getWidth() * 0.01d);
                double d5 = width;
                Double.isNaN(d5);
                int height2 = (int) (d5 * this.J.getHeight() * 0.01d);
                double d6 = height2;
                Double.isNaN(d6);
                int paddingHeight = (int) (d6 * this.S.getPaddingHeight() * 0.01d);
                if (paddingHeight < 0) {
                    paddingHeight = 0;
                }
                ((SkipView) this.f16020q).setData(this.U, paddingHeight);
                e(5);
                this.f16022s.addView(this.f16020q, new FrameLayout.LayoutParams(width, height2));
                float centerX = (f4 * ((float) (this.J.getCenterX() * 0.01d))) - (width / 2);
                float centerY = (height * ((float) (this.J.getCenterY() * 0.01d))) - (height2 / 2);
                this.f16020q.setX(centerX);
                this.f16020q.setY(centerY);
                View view = this.f16020q;
                if (view != null) {
                    view.setVisibility(0);
                    return;
                }
                return;
            }
            aN();
            return;
        }
        View view2 = this.f16020q;
        if (view2 != null) {
            view2.setVisibility(0);
            this.f16020q.setAlpha(1.0f);
        }
    }

    private void aN() {
        double d4 = this.M;
        Double.isNaN(d4);
        int i4 = (int) (d4 * 0.15d);
        double d5 = i4;
        Double.isNaN(d5);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, (int) (d5 * 0.45d));
        layoutParams.gravity = 53;
        layoutParams.topMargin = av.a(this.f16017n, 20.0f);
        layoutParams.rightMargin = av.a(this.f16017n, 20.0f);
        ViewGroup viewGroup = this.f16022s;
        if (viewGroup != null) {
            viewGroup.addView(this.f16020q, layoutParams);
        }
        View view = this.f16020q;
        if (view != null) {
            this.T = 1;
            this.U = 1;
            ((SkipView) view).setData(1, 0);
            ((SkipView) this.f16020q).setText(String.format("\u8df3\u8fc7 %d", 5));
            this.f16020q.setVisibility(0);
        }
    }

    private void aO() {
        CircleProgressView circleProgressView = new CircleProgressView(this.f16017n);
        this.I = circleProgressView;
        circleProgressView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.work.splash.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.H();
                if (d.this.f16025v != null) {
                    d.this.f16025v.cancel();
                }
                if (((com.beizi.fusion.work.a) d.this).f15367d != null) {
                    ((com.beizi.fusion.work.a) d.this).f15367d.c(d.this.g());
                }
            }
        });
        this.I.setAlpha(0.0f);
        this.f16022s.addView(this.I, new FrameLayout.LayoutParams(-2, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP() {
        int[] iArr;
        float f4;
        float f5;
        ViewGroup viewGroup;
        this.f16020q.getLocationOnScreen(new int[2]);
        if (this.K != null) {
            float f6 = this.M;
            float height = this.f16021r != null ? viewGroup.getHeight() : 0.0f;
            if (height == 0.0f) {
                height = this.N - av.a(this.f16017n, 100.0f);
            }
            double d4 = f6;
            Double.isNaN(d4);
            int width = (int) (d4 * this.K.getWidth() * 0.01d);
            double d5 = width;
            Double.isNaN(d5);
            int height2 = (int) (d5 * this.K.getHeight() * 0.01d);
            ViewGroup.LayoutParams layoutParams = this.I.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height2;
            this.I.setLayoutParams(layoutParams);
            f4 = (f6 * ((float) (this.K.getCenterX() * 0.01d))) - (width / 2);
            f5 = (height * ((float) (this.K.getCenterY() * 0.01d))) - (height2 / 2);
        } else {
            float pivotX = (iArr[0] + this.f16020q.getPivotX()) - (this.I.getWidth() / 2);
            float pivotY = (iArr[1] + this.f16020q.getPivotY()) - (this.I.getHeight() / 2);
            f4 = pivotX;
            f5 = pivotY;
        }
        this.I.setX(f4);
        this.I.setY(f5);
    }

    @Override // com.beizi.fusion.work.a
    public void ay() {
        v();
        e();
    }

    @Override // com.beizi.fusion.work.a
    public String g() {
        return "CSJ_NST";
    }

    @Override // com.beizi.fusion.work.a
    public void d() {
        if (this.f15367d == null) {
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
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.d.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "CSJ sdk not import , will do nothing");
                    return;
                }
                u();
                u.a(this, this.f16017n, this.f15371h, this.f15368e.getDirectDownload());
                this.f15365b.t(TTAdSdk.getAdManager().getSDKVersion());
                au();
            }
        }
        this.Y = this.f15369f.getSleepTime();
        if (this.f15367d.v()) {
            this.Y = Math.max(this.Y, this.f15369f.getHotRequestDelay());
        }
        List<AdSpacesBean.RenderViewBean> list = this.f16027x;
        boolean z3 = list != null && list.size() > 0;
        this.H = z3;
        if (z3) {
            aJ();
        }
        this.M = av.l(this.f16017n);
        this.N = av.m(this.f16017n);
    }

    @Override // com.beizi.fusion.work.a
    public void e() {
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + this.Y);
        long j4 = this.Y;
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
        aH();
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
        w();
        ag();
        this.f16026w = null;
        if (av()) {
            return;
        }
        this.f16023t = u.a().createAdNative(this.f16017n);
        this.O = av.j(this.f16017n);
        this.P = 0.0f;
        this.f16023t.loadNativeExpressAd(new AdSlot.Builder().setCodeId(this.f15372i).setSupportDeepLink(true).setAdCount(1).setExpressViewAcceptedSize(this.O, this.P).build(), new TTAdNative.NativeExpressAdListener() { // from class: com.beizi.fusion.work.splash.d.3
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i4, String str) {
                Log.d("BeiZis", "showCsjNSTSplash Callback --> onError:" + str);
                d.this.a(str, i4);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                Log.d("BeiZis", "showCsjNSTSplash Callback --> onNativeExpressAdLoad()");
                ((com.beizi.fusion.work.a) d.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                d.this.y();
                if (list == null || list.size() == 0) {
                    d.this.c(-991);
                    return;
                }
                d.this.f16024u = list.get(0);
                d dVar = d.this;
                dVar.a(dVar.f16024u);
                d.this.f16024u.render();
            }
        });
    }

    @Override // com.beizi.fusion.work.a
    public void m() {
        TTNativeExpressAd tTNativeExpressAd = this.f16024u;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
        }
    }

    @Override // com.beizi.fusion.work.a
    public View o() {
        return this.f16026w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar == null) {
            return;
        }
        Map<String, com.beizi.fusion.work.a> r3 = eVar.r();
        Log.d("BeiZis", "splashWorkers:" + r3.toString());
        Z();
        com.beizi.fusion.d.h hVar = this.f15370g;
        if (hVar == com.beizi.fusion.d.h.SUCCESS) {
            this.f15367d.a(g(), (View) null);
        } else if (hVar == com.beizi.fusion.d.h.FAIL) {
            Log.d("BeiZis", "other worker shown," + g() + " remove");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i4) {
        if (this.T == 1) {
            String valueOf = String.valueOf(i4);
            String str = this.V + " ";
            String str2 = str + valueOf;
            SpannableString spannableString = new SpannableString(str2);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.W)), 0, str.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.X)), str2.indexOf(valueOf), str2.length(), 33);
            ((SkipView) this.f16020q).setText(spannableString);
            return;
        }
        SpannableString spannableString2 = new SpannableString(this.V);
        spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor(this.W)), 0, this.V.length(), 33);
        ((SkipView) this.f16020q).setText(spannableString2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TTNativeExpressAd tTNativeExpressAd) {
        tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.beizi.fusion.work.splash.d.4

            /* renamed from: a  reason: collision with root package name */
            boolean f16036a = false;

            /* renamed from: b  reason: collision with root package name */
            boolean f16037b = false;

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i4) {
                Log.d("BeiZis", "showCsjNSTSplash Callback --> onAdClicked()");
                if (((com.beizi.fusion.work.a) d.this).f15367d != null && ((com.beizi.fusion.work.a) d.this).f15367d.s() != 2) {
                    ((com.beizi.fusion.work.a) d.this).f15367d.d(d.this.g());
                }
                if (this.f16037b) {
                    return;
                }
                this.f16037b = true;
                d.this.E();
                d.this.ai();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i4) {
                Log.d("BeiZis", "showCsjNSTSplash Callback --> onAdShow()");
                ((com.beizi.fusion.work.a) d.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
                if (((com.beizi.fusion.work.a) d.this).f15367d != null && ((com.beizi.fusion.work.a) d.this).f15367d.s() != 2) {
                    ((com.beizi.fusion.work.a) d.this).f15367d.b(d.this.g());
                }
                if (this.f16036a) {
                    return;
                }
                this.f16036a = true;
                d.this.C();
                d.this.D();
                d.this.ah();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i4) {
                Log.d("BeiZis", "showCsjNSTSplash Callback --> onRenderFail()");
                d.this.a(str, i4);
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f4, float f5) {
                Log.d("BeiZis", "showCsjNSTSplash Callback --> onRenderSuccess() width == " + f4 + ", height == " + f5);
                d dVar = d.this;
                dVar.Q = (float) av.a(dVar.f16017n, f4);
                d dVar2 = d.this;
                dVar2.R = (float) av.a(dVar2.f16017n, f5);
                d.this.f16026w = view;
                if (d.this.Y()) {
                    d.this.b();
                } else {
                    d.this.O();
                }
            }
        });
    }
}
