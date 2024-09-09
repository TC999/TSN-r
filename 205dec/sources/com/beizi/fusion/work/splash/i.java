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
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.al;
import com.beizi.fusion.g.av;
import com.beizi.fusion.g.m;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.CircleProgressView;
import com.beizi.fusion.widget.SkipView;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiNative;
import com.inmobi.ads.listeners.NativeAdEventListener;
import com.inmobi.sdk.InMobiSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: InmobiSplashWorker.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class i extends com.beizi.fusion.work.a {
    private long F;
    private long G;
    private boolean H;
    private CircleProgressView I;
    private AdSpacesBean.PositionBean J;
    private AdSpacesBean.PositionBean K;

    /* renamed from: L  reason: collision with root package name */
    private List<View> f16119L;
    private float M;
    private float N;
    private AdSpacesBean.RenderViewBean O;
    private int P;
    private int Q;
    private String R;
    private String S;
    private String T;
    private InMobiNative U;
    private Long V;
    private CountDownTimer W;
    private boolean Y;
    private NativeAdEventListener Z;

    /* renamed from: n  reason: collision with root package name */
    int f16120n;

    /* renamed from: o  reason: collision with root package name */
    long f16121o;

    /* renamed from: p  reason: collision with root package name */
    View f16122p;

    /* renamed from: q  reason: collision with root package name */
    private Context f16123q;

    /* renamed from: r  reason: collision with root package name */
    private String f16124r;

    /* renamed from: s  reason: collision with root package name */
    private long f16125s;

    /* renamed from: t  reason: collision with root package name */
    private View f16126t;

    /* renamed from: u  reason: collision with root package name */
    private ViewGroup f16127u;

    /* renamed from: v  reason: collision with root package name */
    private ViewGroup f16128v;

    /* renamed from: w  reason: collision with root package name */
    private List<AdSpacesBean.RenderViewBean> f16129w;

    /* renamed from: x  reason: collision with root package name */
    private List<AdSpacesBean.RenderViewBean> f16130x = new ArrayList();

    /* renamed from: y  reason: collision with root package name */
    private List<AdSpacesBean.RenderViewBean> f16131y = new ArrayList();

    /* renamed from: z  reason: collision with root package name */
    private boolean f16132z = false;
    private boolean A = false;
    private boolean B = false;
    private boolean C = false;
    private boolean D = false;
    private long E = 5000;
    private boolean X = false;

    public i(Context context, String str, long j4, View view, ViewGroup viewGroup, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, List<AdSpacesBean.RenderViewBean> list, com.beizi.fusion.d.e eVar) {
        this.Y = false;
        this.f16123q = context;
        this.f16124r = str;
        this.f16125s = j4;
        if (this.f16126t == null) {
            this.f16126t = new SkipView(context);
            this.Y = true;
        } else {
            this.f16126t = view;
        }
        this.f16127u = viewGroup;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        this.f16128v = new SplashContainer(context);
        this.f16129w = list;
        r();
    }

    private void aG() {
        StringBuilder sb = new StringBuilder();
        sb.append("finalShowAd mParent != null ? ");
        sb.append(this.f16127u != null);
        sb.append(",!mIsLoadAdView = ");
        sb.append(!this.X);
        af.c("BeiZis", sb.toString());
        if (this.f16127u != null) {
            if (!this.X) {
                this.f16126t.setVisibility(8);
            }
            aH();
            this.f16128v.removeAllViews();
            af.c("BeiZis", "mAdContainer.getWidth() = " + this.f16128v.getWidth());
            InMobiNative inMobiNative = this.U;
            Context context = this.f16123q;
            ViewGroup viewGroup = this.f16128v;
            View primaryViewOfWidth = inMobiNative.getPrimaryViewOfWidth(context, viewGroup, viewGroup, viewGroup.getWidth());
            this.f16128v.addView(primaryViewOfWidth);
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
                        int i4 = layoutParams.height;
                        int height = i.this.f16128v.getHeight();
                        af.c("BeiZis", "adsHeight = " + i4 + ",containerHeight = " + height);
                        if (i4 < height) {
                            layoutParams.height = height;
                        }
                    }
                });
            }
            this.f16127u.removeAllViews();
            this.f16127u.addView(this.f16128v);
            this.X = true;
            this.f16126t.setVisibility(0);
            if (this.I != null) {
                this.f16127u.addView(this.I, new FrameLayout.LayoutParams(-2, -2));
            }
            aM();
            if (this.H) {
                aK();
                return;
            }
            return;
        }
        aw();
    }

    private void aH() {
        aI();
        if (this.Y && (this.f16126t instanceof CircleProgressView)) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 53;
            layoutParams.topMargin = av.a(this.f16123q, 20.0f);
            layoutParams.rightMargin = av.a(this.f16123q, 20.0f);
            this.f16128v.addView(this.f16126t, layoutParams);
        }
    }

    private void aI() {
        StringBuilder sb = new StringBuilder();
        sb.append("addCloseButton mSkipView != null ? ");
        sb.append(this.f16126t != null);
        af.a("BeiZis", sb.toString());
        if (this.f16126t != null) {
            CountDownTimer countDownTimer = this.W;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            CountDownTimer countDownTimer2 = new CountDownTimer(this.E, 50L) { // from class: com.beizi.fusion.work.splash.i.4

                /* renamed from: a  reason: collision with root package name */
                boolean f16137a = false;

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    i.this.G();
                    ((com.beizi.fusion.work.a) i.this).f15367d.c(i.this.g());
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    if (!this.f16137a) {
                        if (i.this.H) {
                            i iVar = i.this;
                            iVar.f16119L = m.a(iVar.f16128v);
                        }
                        i.this.aO();
                        this.f16137a = true;
                    }
                    if (i.this.H) {
                        if (i.this.G > 0 && i.this.G <= i.this.E) {
                            if (i.this.f16132z) {
                                if (i.this.F <= 0 || j4 <= i.this.F) {
                                    i.this.D = false;
                                    i.this.f16126t.setAlpha(1.0f);
                                } else {
                                    i.this.D = true;
                                    i.this.f16126t.setAlpha(0.2f);
                                }
                            }
                            if (i.this.G == i.this.E) {
                                i.this.f16126t.setEnabled(false);
                            } else {
                                i.this.f16126t.setEnabled(true);
                            }
                        }
                        i.this.e(Math.round(((float) j4) / 1000.0f));
                    }
                    if (i.this.X) {
                        if (i.this.G == i.this.E) {
                            i.this.f16126t.setEnabled(false);
                        } else {
                            i.this.f16126t.setEnabled(true);
                        }
                    }
                    int i4 = (int) ((5 * j4) / i.this.E);
                    if (i.this.f16126t instanceof SkipView) {
                        ((SkipView) i.this.f16126t).setText(String.format("\u8df3\u8fc7 %d", Integer.valueOf(i4)));
                    } else if (((com.beizi.fusion.work.a) i.this).f15367d == null || ((com.beizi.fusion.work.a) i.this).f15367d.s() == 2) {
                    } else {
                        ((com.beizi.fusion.work.a) i.this).f15367d.a(j4);
                    }
                }
            };
            this.W = countDownTimer2;
            countDownTimer2.start();
            this.f16126t.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.work.splash.i.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    i.this.G();
                    i.this.W.cancel();
                    ((com.beizi.fusion.work.a) i.this).f15367d.c(i.this.g());
                }
            });
        }
    }

    private void aJ() {
        for (int i4 = 0; i4 < this.f16129w.size(); i4++) {
            AdSpacesBean.RenderViewBean renderViewBean = this.f16129w.get(i4);
            String type = renderViewBean.getType();
            if ("SKIPVIEW".equals(type)) {
                this.f16131y.add(renderViewBean);
            } else if ("MATERIALVIEW".equals(type)) {
                this.f16130x.add(renderViewBean);
            }
        }
        if (this.f16131y.size() > 0) {
            AdSpacesBean.RenderViewBean renderViewBean2 = this.f16131y.get(0);
            this.O = renderViewBean2;
            if (renderViewBean2 != null) {
                this.K = renderViewBean2.getTapPosition();
                this.J = this.O.getLayerPosition();
                long skipUnavailableTime = this.O.getSkipUnavailableTime();
                if (skipUnavailableTime > 0) {
                    this.G = skipUnavailableTime;
                }
                this.P = this.O.getShowCountDown();
                this.Q = this.O.getShowBorder();
                String skipText = this.O.getSkipText();
                this.R = skipText;
                if (TextUtils.isEmpty(skipText)) {
                    this.R = "\u8df3\u8fc7";
                }
                String textColor = this.O.getTextColor();
                this.S = textColor;
                if (TextUtils.isEmpty(textColor)) {
                    this.S = "#FFFFFF";
                }
                String countDownColor = this.O.getCountDownColor();
                this.T = countDownColor;
                if (TextUtils.isEmpty(countDownColor)) {
                    this.T = "#FFFFFF";
                }
                List<AdSpacesBean.PassPolicyBean> passPolicy = this.O.getPassPolicy();
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
                                this.f16132z = al.a(passPercent);
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
        if (this.f16130x.size() > 0) {
            Collections.sort(this.f16130x, new Comparator<AdSpacesBean.RenderViewBean>() { // from class: com.beizi.fusion.work.splash.i.6
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(AdSpacesBean.RenderViewBean renderViewBean3, AdSpacesBean.RenderViewBean renderViewBean4) {
                    return renderViewBean4.getLevel() - renderViewBean3.getLevel();
                }
            });
        }
    }

    private void aK() {
        if (this.f16132z) {
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
        this.F = this.E - this.G;
    }

    private View aL() {
        View view;
        String str;
        if (this.H) {
            View view2 = this.f16126t;
            if (view2 != null) {
                view2.setVisibility(8);
                view2.setAlpha(0.0f);
            }
            this.f16126t = new SkipView(this.f16123q);
            CircleProgressView circleProgressView = new CircleProgressView(this.f16123q);
            this.I = circleProgressView;
            circleProgressView.setAlpha(0.0f);
            view = this.I;
            str = "beizi";
        } else {
            view = this.f16126t;
            if (view != null) {
                CircleProgressView circleProgressView2 = new CircleProgressView(this.f16123q);
                this.I = circleProgressView2;
                circleProgressView2.setAlpha(0.0f);
                view = this.I;
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
        return view;
    }

    private void aM() {
        af.a("BeiZis", "enter checkDisplaySkipView mNeedRender = " + this.H);
        if (this.H) {
            if (this.J != null && this.O != null) {
                float f4 = this.M;
                float height = this.f16127u.getHeight();
                if (height == 0.0f) {
                    height = this.N - av.a(this.f16123q, 100.0f);
                }
                double d4 = f4;
                Double.isNaN(d4);
                int width = (int) (d4 * this.J.getWidth() * 0.01d);
                if (this.J.getHeight() >= 12.0d) {
                    double d5 = width;
                    Double.isNaN(d5);
                    int height2 = (int) (d5 * this.J.getHeight() * 0.01d);
                    double d6 = height2;
                    Double.isNaN(d6);
                    int paddingHeight = (int) (d6 * this.O.getPaddingHeight() * 0.01d);
                    if (paddingHeight < 0) {
                        paddingHeight = 0;
                    }
                    ((SkipView) this.f16126t).setData(this.Q, paddingHeight);
                    e(5);
                    this.f16127u.addView(this.f16126t, new FrameLayout.LayoutParams(width, height2));
                    float centerY = (height * ((float) (this.J.getCenterY() * 0.01d))) - (height2 / 2);
                    this.f16126t.setX((f4 * ((float) (this.J.getCenterX() * 0.01d))) - (width / 2));
                    this.f16126t.setY(centerY);
                    View view = this.f16126t;
                    if (view != null) {
                        view.setVisibility(0);
                        return;
                    }
                    return;
                }
                aN();
                return;
            }
            aN();
            return;
        }
        aN();
    }

    private void aN() {
        double d4 = this.M;
        Double.isNaN(d4);
        int i4 = (int) (d4 * 0.15d);
        double d5 = i4;
        Double.isNaN(d5);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, (int) (d5 * 0.45d));
        layoutParams.gravity = 53;
        layoutParams.topMargin = av.a(this.f16123q, 20.0f);
        layoutParams.rightMargin = av.a(this.f16123q, 20.0f);
        ViewGroup viewGroup = this.f16127u;
        if (viewGroup != null) {
            viewGroup.addView(this.f16126t, layoutParams);
        }
        View view = this.f16126t;
        if (view != null) {
            this.P = 1;
            this.Q = 1;
            ((SkipView) view).setData(1, 0);
            ((SkipView) this.f16126t).setText(String.format("\u8df3\u8fc7 %d", 5));
            this.f16126t.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO() {
        int[] iArr;
        float pivotX;
        float pivotY;
        float height;
        View view = this.f16126t;
        if (view == null) {
            return;
        }
        view.getLocationOnScreen(new int[2]);
        if (this.K != null) {
            float f4 = this.M;
            float height2 = this.f16127u.getHeight();
            if (height2 == 0.0f) {
                height2 = this.N - av.a(this.f16123q, 100.0f);
            }
            double d4 = f4;
            Double.isNaN(d4);
            int width = (int) (d4 * this.K.getWidth() * 0.01d);
            double d5 = width;
            Double.isNaN(d5);
            int height3 = (int) (d5 * this.K.getHeight() * 0.01d);
            ViewGroup.LayoutParams layoutParams = this.I.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height3;
            this.I.setLayoutParams(layoutParams);
            pivotX = (f4 * ((float) (this.K.getCenterX() * 0.01d))) - (width / 2);
            pivotY = height2 * ((float) (this.K.getCenterY() * 0.01d));
            height = height3 / 2;
        } else {
            pivotX = (iArr[0] + this.f16126t.getPivotX()) - (this.I.getWidth() / 2);
            pivotY = iArr[1] + this.f16126t.getPivotY();
            height = this.I.getHeight() / 2;
        }
        this.I.setX(pivotX);
        this.I.setY(pivotY - height);
    }

    @Override // com.beizi.fusion.work.a
    public String g() {
        return "INMOBI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i4) {
        if (this.P == 1) {
            String valueOf = String.valueOf(i4);
            String str = this.R + " ";
            String str2 = str + valueOf;
            SpannableString spannableString = new SpannableString(str2);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.S)), 0, str.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.T)), str2.indexOf(valueOf), str2.length(), 33);
            ((SkipView) this.f16126t).setText(spannableString);
            return;
        }
        SpannableString spannableString2 = new SpannableString(this.R);
        spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor(this.S)), 0, this.R.length(), 33);
        ((SkipView) this.f16126t).setText(spannableString2);
    }

    @Override // com.beizi.fusion.work.a
    protected void A() {
        if (!z() || this.U == null) {
            return;
        }
        al();
        this.f15368e.setAvgPrice(this.U.getAdBid());
        af.a("BeiZisBid", "inmobi splash price = " + this.U.getAdBid());
        com.beizi.fusion.b.b bVar = this.f15365b;
        if (bVar != null) {
            bVar.M(String.valueOf(this.f15368e.getAvgPrice()));
            au();
        }
    }

    @Override // com.beizi.fusion.work.a
    public void d() {
        boolean z3;
        if (this.f15367d == null) {
            return;
        }
        this.f16121o = System.currentTimeMillis();
        this.f15371h = this.f15368e.getAppId();
        this.f15366c = this.f15368e.getBuyerSpaceUuId();
        af.b("BeiZis", "AdWorker chanel = " + this.f15366c);
        boolean z4 = false;
        try {
            this.V = Long.valueOf(this.f15368e.getSpaceId());
            z3 = false;
        } catch (Exception unused) {
            this.f15373j = com.beizi.fusion.f.a.ADFAIL;
            this.f15376m.sendMessage(this.f15376m.obtainMessage(3, "Inmobi spaceId pattern problem!"));
            z3 = true;
        }
        if (z3) {
            return;
        }
        com.beizi.fusion.b.d dVar = this.f15364a;
        if (dVar != null) {
            com.beizi.fusion.b.b a4 = dVar.a().a(this.f15366c);
            this.f15365b = a4;
            if (a4 != null) {
                s();
                if (!av.a("com.inmobi.sdk.InMobiSdk")) {
                    t();
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.i.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "IMB sdk not import , will do nothing");
                    return;
                }
                u();
                InMobiSdk.init(this.f16123q, this.f15371h);
                InMobiSdk.setLogLevel(InMobiSdk.LogLevel.DEBUG);
                this.f15365b.w(InMobiSdk.getVersion());
                au();
                v();
            }
        }
        this.f16120n = this.f15368e.getReqTimeOutType();
        long sleepTime = this.f15369f.getSleepTime();
        if (this.f15367d.v()) {
            sleepTime = Math.max(sleepTime, this.f15369f.getHotRequestDelay());
        }
        List<AdSpacesBean.RenderViewBean> list = this.f16129w;
        if (list != null && list.size() > 0) {
            z4 = true;
        }
        this.H = z4;
        if (z4) {
            aJ();
        }
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.V + "===" + sleepTime);
        if (sleepTime > 0) {
            this.f15376m.sendEmptyMessageDelayed(1, sleepTime);
        } else {
            com.beizi.fusion.d.e eVar = this.f15367d;
            if (eVar != null && eVar.t() < 1 && this.f15367d.s() != 2) {
                l();
            }
        }
        this.M = av.l(this.f16123q);
        this.N = av.m(this.f16123q);
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
        if (this.U == null) {
            return null;
        }
        return this.U.getAdBid() + "";
    }

    @Override // com.beizi.fusion.work.a
    protected void l() {
        w();
        ag();
        this.f16122p = aL();
        this.Z = new NativeAdEventListener() { // from class: com.beizi.fusion.work.splash.i.2
            public void onAdClicked(@NonNull InMobiNative inMobiNative) {
                Log.d("BeiZis", "showInSplash onAdClicked:");
                if (((com.beizi.fusion.work.a) i.this).f15367d != null && ((com.beizi.fusion.work.a) i.this).f15367d.s() != 2) {
                    ((com.beizi.fusion.work.a) i.this).f15367d.d(i.this.g());
                }
                i.this.E();
                i.this.ai();
            }

            public void onAdImpressed(@NonNull InMobiNative inMobiNative) {
                Log.d("BeiZis", "showInSplash onAdImpressed");
                ((com.beizi.fusion.work.a) i.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
                i.this.ab();
                i.this.D();
                i.this.ah();
            }

            public void onAdLoadFailed(@NonNull InMobiNative inMobiNative, @NonNull InMobiAdRequestStatus inMobiAdRequestStatus) {
                Log.d("BeiZis", "showInSplash onAdFailed:" + inMobiAdRequestStatus.getMessage());
                i.this.a(inMobiAdRequestStatus.getMessage(), inMobiAdRequestStatus.getStatusCode().ordinal());
            }

            public void onAdLoadSucceeded(@NonNull InMobiNative inMobiNative) {
                Log.d("BeiZis", "showInSplash onAdLoadSucceeded:");
                i.this.y();
                ((com.beizi.fusion.work.a) i.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                af.a("BeiZisBid", "showInSplash inMobiNative.getAdBid() = " + inMobiNative.getAdBid() + ",mBuyerBean = " + ((com.beizi.fusion.work.a) i.this).f15368e);
                if (i.this.Y()) {
                    i.this.b();
                } else {
                    i.this.O();
                }
            }

            public void onUserWillLeaveApplication(InMobiNative inMobiNative) {
                Log.d("BeiZis", "showInSplash onUserWillLeaveApplication");
            }
        };
        InMobiNative inMobiNative = new InMobiNative(this.f16123q, this.V.longValue(), this.Z);
        this.U = inMobiNative;
        inMobiNative.setDownloaderEnabled(true);
        this.U.load();
        af.a("BeiZis", "inmobi start load");
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
}
