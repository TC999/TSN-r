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
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.ak;
import com.beizi.fusion.g.al;
import com.beizi.fusion.g.av;
import com.beizi.fusion.g.m;
import com.beizi.fusion.g.n;
import com.beizi.fusion.g.v;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.CircleProgressView;
import com.beizi.fusion.widget.SkipView;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: GdtSplashWorker.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class f extends com.beizi.fusion.work.a {
    private long H;
    private long J;
    private boolean K;

    /* renamed from: L  reason: collision with root package name */
    private CircleProgressView f16071L;
    private AdSpacesBean.PositionBean M;
    private AdSpacesBean.PositionBean N;
    private List<View> O;
    private float P;
    private float Q;
    private AdSpacesBean.RenderViewBean R;
    private int S;
    private int T;
    private String U;
    private String V;
    private String W;

    /* renamed from: n  reason: collision with root package name */
    int f16072n;

    /* renamed from: o  reason: collision with root package name */
    long f16073o;

    /* renamed from: p  reason: collision with root package name */
    View.OnClickListener f16074p;

    /* renamed from: q  reason: collision with root package name */
    private Context f16075q;

    /* renamed from: r  reason: collision with root package name */
    private String f16076r;

    /* renamed from: s  reason: collision with root package name */
    private long f16077s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f16078t;

    /* renamed from: u  reason: collision with root package name */
    private View f16079u;

    /* renamed from: v  reason: collision with root package name */
    private ViewGroup f16080v;

    /* renamed from: w  reason: collision with root package name */
    private ViewGroup f16081w;

    /* renamed from: x  reason: collision with root package name */
    private SplashAD f16082x;

    /* renamed from: y  reason: collision with root package name */
    private List<AdSpacesBean.RenderViewBean> f16083y;

    /* renamed from: z  reason: collision with root package name */
    private List<AdSpacesBean.RenderViewBean> f16084z = new ArrayList();
    private List<AdSpacesBean.RenderViewBean> A = new ArrayList();
    private boolean B = false;
    private boolean C = false;
    private boolean D = false;
    private boolean E = false;
    private boolean F = false;
    private long G = 5000;
    private int I = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: GdtSplashWorker.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class a implements SplashADListener {

        /* renamed from: a  reason: collision with root package name */
        boolean f16087a;

        /* renamed from: b  reason: collision with root package name */
        boolean f16088b;

        /* renamed from: c  reason: collision with root package name */
        boolean f16089c;

        private a() {
            this.f16087a = false;
            this.f16088b = false;
            this.f16089c = false;
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADClicked() {
            Log.d("BeiZis", "showGdtSplash onAdClick()");
            if (((com.beizi.fusion.work.a) f.this).f15367d != null && ((com.beizi.fusion.work.a) f.this).f15367d.s() != 2) {
                ((com.beizi.fusion.work.a) f.this).f15367d.d(f.this.g());
                ((com.beizi.fusion.work.a) f.this).f15376m.sendEmptyMessageDelayed(2, (((com.beizi.fusion.work.a) f.this).f15375l + 5000) - System.currentTimeMillis());
            }
            if (this.f16088b) {
                return;
            }
            this.f16088b = true;
            f.this.E();
            f.this.ai();
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADDismissed() {
            Log.d("BeiZis", "showGdtSplash onADDismissed()");
            if (((com.beizi.fusion.work.a) f.this).f15367d.s() != 2) {
                f.this.ac();
            }
            f.this.G();
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADExposure() {
            Log.d("BeiZis", "showGdtSplash onADExposure()");
            ((com.beizi.fusion.work.a) f.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
            if (this.f16087a) {
                return;
            }
            this.f16087a = true;
            f.this.az();
            f.this.ab();
            f.this.D();
            f.this.ah();
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADLoaded(long j4) {
            if (f.this.f16082x.getECPM() > 0) {
                f fVar = f.this;
                fVar.a(fVar.f16082x.getECPM());
            }
            if (v.f14982a) {
                f.this.f16082x.setDownloadConfirmListener(v.f14983b);
            }
            f.this.y();
            if (((com.beizi.fusion.work.a) f.this).f15373j.ordinal() < com.beizi.fusion.f.a.ADSHOW.ordinal()) {
                ((com.beizi.fusion.work.a) f.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                f.g(f.this);
                if (((com.beizi.fusion.work.a) f.this).f15367d != null) {
                    Log.d("BeiZis", "showGdtSplash onADLoaded:" + j4 + ",mAdLifeControl.getAdStatus() = " + ((com.beizi.fusion.work.a) f.this).f15367d.t() + ",gap = " + (j4 - SystemClock.elapsedRealtime()));
                }
                if (SystemClock.elapsedRealtime() < j4 && f.this.Y()) {
                    f.this.aG();
                    return;
                } else {
                    f.this.O();
                    return;
                }
            }
            int ordinal = ((com.beizi.fusion.work.a) f.this).f15373j.ordinal();
            String str = ordinal != 2 ? ordinal != 3 ? "other" : "fail" : "show";
            Message obtain = Message.obtain();
            obtain.obj = "ad status error " + str;
            f.this.a(obtain);
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADPresent() {
            Log.d("BeiZis", "showGdtSplash onADPresent()");
            f.g(f.this);
            f.this.C();
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADTick(long j4) {
            if (!this.f16089c) {
                if (f.this.K) {
                    f fVar = f.this;
                    fVar.O = m.a(fVar.f16081w);
                }
                f.this.aN();
                this.f16089c = true;
            }
            if (f.this.K) {
                if (f.this.J > 0 && f.this.J <= f.this.G) {
                    if (f.this.B) {
                        if (f.this.H <= 0 || j4 <= f.this.H) {
                            f.this.F = false;
                            f.this.f16079u.setAlpha(1.0f);
                        } else {
                            f.this.F = true;
                            f.this.f16079u.setAlpha(0.2f);
                        }
                    }
                    if (f.this.J == f.this.G) {
                        f.this.f16079u.setEnabled(false);
                    } else {
                        f.this.f16079u.setEnabled(true);
                    }
                }
                f.this.e(Math.round(((float) j4) / 1000.0f));
            }
            if (((com.beizi.fusion.work.a) f.this).f15367d == null || ((com.beizi.fusion.work.a) f.this).f15367d.s() == 2) {
                return;
            }
            ((com.beizi.fusion.work.a) f.this).f15367d.a(j4);
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onNoAD(AdError adError) {
            Log.d("BeiZis", "showGdtSplash onNoAD:" + adError.getErrorMsg());
            f.this.a(adError.getErrorMsg(), adError.getErrorCode());
            if (f.this.I < 1 || ((com.beizi.fusion.work.a) f.this).f15367d == null) {
                return;
            }
            ((com.beizi.fusion.work.a) f.this).f15367d.u();
        }
    }

    public f(Context context, String str, long j4, View view, ViewGroup viewGroup, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, List<AdSpacesBean.RenderViewBean> list, com.beizi.fusion.d.e eVar) {
        this.f16075q = context;
        this.f16076r = str;
        this.f16077s = j4;
        if (view != null) {
            view.setVisibility(8);
        }
        this.f16079u = null;
        this.f16080v = viewGroup;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        this.f16081w = new SplashContainer(context);
        this.f16083y = list;
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG() {
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar == null) {
            return;
        }
        Map<String, com.beizi.fusion.work.a> r3 = eVar.r();
        Log.d("BeiZis", g() + " splashWorkers:" + r3.toString());
        Z();
        com.beizi.fusion.d.h hVar = this.f15370g;
        if (hVar == com.beizi.fusion.d.h.SUCCESS) {
            b();
            ad();
        } else if (hVar == com.beizi.fusion.d.h.FAIL) {
            Log.d("BeiZis", "other worker shown," + g() + " remove");
        }
    }

    private void aH() {
        ViewGroup viewGroup = this.f16080v;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.f16080v.addView(this.f16081w);
            this.f16082x.showAd(this.f16081w);
            if (this.f16071L != null) {
                this.f16080v.addView(this.f16071L, new FrameLayout.LayoutParams(-2, -2));
            }
            aL();
            if (this.K) {
                aJ();
                return;
            }
            return;
        }
        aw();
    }

    private void aI() {
        for (int i4 = 0; i4 < this.f16083y.size(); i4++) {
            AdSpacesBean.RenderViewBean renderViewBean = this.f16083y.get(i4);
            String type = renderViewBean.getType();
            if ("SKIPVIEW".equals(type)) {
                this.A.add(renderViewBean);
            } else if ("MATERIALVIEW".equals(type)) {
                this.f16084z.add(renderViewBean);
            }
        }
        if (this.A.size() > 0) {
            AdSpacesBean.RenderViewBean renderViewBean2 = this.A.get(0);
            this.R = renderViewBean2;
            if (renderViewBean2 != null) {
                this.N = renderViewBean2.getTapPosition();
                this.M = this.R.getLayerPosition();
                long skipUnavailableTime = this.R.getSkipUnavailableTime();
                if (skipUnavailableTime > 0) {
                    this.J = skipUnavailableTime;
                }
                this.S = this.R.getShowCountDown();
                this.T = this.R.getShowBorder();
                String skipText = this.R.getSkipText();
                this.U = skipText;
                if (TextUtils.isEmpty(skipText)) {
                    this.U = "\u8df3\u8fc7";
                }
                String textColor = this.R.getTextColor();
                this.V = textColor;
                if (TextUtils.isEmpty(textColor)) {
                    this.V = "#FFFFFF";
                }
                String countDownColor = this.R.getCountDownColor();
                this.W = countDownColor;
                if (TextUtils.isEmpty(countDownColor)) {
                    this.W = "#FFFFFF";
                }
                List<AdSpacesBean.PassPolicyBean> passPolicy = this.R.getPassPolicy();
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
                                this.C = al.a(passPercent);
                                break;
                            case 1:
                                this.B = al.a(passPercent);
                                break;
                            case 2:
                                AdSpacesBean.PositionBean positionBean = this.M;
                                if (positionBean != null && this.N != null) {
                                    double centerX = positionBean.getCenterX();
                                    double centerY = this.M.getCenterY();
                                    double width = this.M.getWidth();
                                    double height = this.M.getHeight();
                                    double centerX2 = this.N.getCenterX();
                                    double centerY2 = this.N.getCenterY();
                                    double width2 = this.N.getWidth();
                                    double height2 = this.N.getHeight();
                                    if ((centerX > 0.0d && centerX2 > 0.0d && centerX != centerX2) || ((centerY > 0.0d && centerY2 > 0.0d && centerY != centerY2) || ((width > 0.0d && width2 > 0.0d && width != width2) || (height > 0.0d && height2 > 0.0d && height != height2)))) {
                                        this.D = al.a(passPercent);
                                    }
                                    if (width2 * height2 < width * height) {
                                        this.E = true;
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
        if (this.f16084z.size() > 0) {
            Collections.sort(this.f16084z, new Comparator<AdSpacesBean.RenderViewBean>() { // from class: com.beizi.fusion.work.splash.f.2
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(AdSpacesBean.RenderViewBean renderViewBean3, AdSpacesBean.RenderViewBean renderViewBean4) {
                    return renderViewBean4.getLevel() - renderViewBean3.getLevel();
                }
            });
        }
    }

    private void aJ() {
        if (this.B) {
            Q();
        }
        if (this.C) {
            R();
        }
        if (this.D) {
            S();
        }
        if (this.E) {
            T();
        }
        this.H = this.G - this.J;
    }

    private View aK() {
        View view;
        String str;
        if (this.K) {
            View view2 = this.f16079u;
            if (view2 != null) {
                view2.setVisibility(8);
                view2.setAlpha(0.0f);
            }
            this.f16079u = new SkipView(this.f16075q);
            CircleProgressView circleProgressView = new CircleProgressView(this.f16075q);
            this.f16071L = circleProgressView;
            circleProgressView.setAlpha(0.0f);
            view = this.f16071L;
            str = "beizi";
        } else {
            view = this.f16079u;
            if (view != null) {
                CircleProgressView circleProgressView2 = new CircleProgressView(this.f16075q);
                this.f16071L = circleProgressView2;
                circleProgressView2.setAlpha(0.0f);
                view = this.f16071L;
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

    private void aL() {
        if (this.K) {
            if (this.M != null && this.R != null) {
                float f4 = this.P;
                float height = this.f16080v.getHeight();
                if (height == 0.0f) {
                    height = this.Q - av.a(this.f16075q, 100.0f);
                }
                double d4 = f4;
                Double.isNaN(d4);
                int width = (int) (d4 * this.M.getWidth() * 0.01d);
                if (this.M.getHeight() >= 12.0d) {
                    double d5 = width;
                    Double.isNaN(d5);
                    int height2 = (int) (d5 * this.M.getHeight() * 0.01d);
                    double d6 = height2;
                    Double.isNaN(d6);
                    int paddingHeight = (int) (d6 * this.R.getPaddingHeight() * 0.01d);
                    if (paddingHeight < 0) {
                        paddingHeight = 0;
                    }
                    ((SkipView) this.f16079u).setData(this.T, paddingHeight);
                    e(5);
                    this.f16080v.addView(this.f16079u, new FrameLayout.LayoutParams(width, height2));
                    float centerX = (f4 * ((float) (this.M.getCenterX() * 0.01d))) - (width / 2);
                    float centerY = (height * ((float) (this.M.getCenterY() * 0.01d))) - (height2 / 2);
                    this.f16079u.setX(centerX);
                    this.f16079u.setY(centerY);
                    View view = this.f16079u;
                    if (view != null) {
                        view.setVisibility(0);
                        return;
                    }
                    return;
                }
                aM();
                return;
            }
            aM();
            return;
        }
        View view2 = this.f16079u;
        if (view2 != null) {
            view2.setVisibility(0);
            this.f16079u.setAlpha(1.0f);
        }
    }

    private void aM() {
        double d4 = this.P;
        Double.isNaN(d4);
        int i4 = (int) (d4 * 0.15d);
        double d5 = i4;
        Double.isNaN(d5);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, (int) (d5 * 0.45d));
        layoutParams.gravity = 53;
        layoutParams.topMargin = av.a(this.f16075q, 20.0f);
        layoutParams.rightMargin = av.a(this.f16075q, 20.0f);
        ViewGroup viewGroup = this.f16080v;
        if (viewGroup != null) {
            viewGroup.addView(this.f16079u, layoutParams);
        }
        View view = this.f16079u;
        if (view != null) {
            this.S = 1;
            this.T = 1;
            ((SkipView) view).setData(1, 0);
            ((SkipView) this.f16079u).setText(String.format("\u8df3\u8fc7 %d", 5));
            this.f16079u.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN() {
        int[] iArr;
        float pivotX;
        float pivotY;
        float height;
        View view = this.f16079u;
        if (view == null) {
            return;
        }
        view.getLocationOnScreen(new int[2]);
        if (this.N != null) {
            float f4 = this.P;
            float height2 = this.f16080v.getHeight();
            if (height2 == 0.0f) {
                height2 = this.Q - av.a(this.f16075q, 100.0f);
            }
            double d4 = f4;
            Double.isNaN(d4);
            int width = (int) (d4 * this.N.getWidth() * 0.01d);
            double d5 = width;
            Double.isNaN(d5);
            int height3 = (int) (d5 * this.N.getHeight() * 0.01d);
            ViewGroup.LayoutParams layoutParams = this.f16071L.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height3;
            this.f16071L.setLayoutParams(layoutParams);
            pivotX = (f4 * ((float) (this.N.getCenterX() * 0.01d))) - (width / 2);
            pivotY = height2 * ((float) (this.N.getCenterY() * 0.01d));
            height = height3 / 2;
        } else {
            pivotX = (iArr[0] + this.f16079u.getPivotX()) - (this.f16071L.getWidth() / 2);
            pivotY = iArr[1] + this.f16079u.getPivotY();
            height = this.f16071L.getHeight() / 2;
        }
        this.f16071L.setX(pivotX);
        this.f16071L.setY(pivotY - height);
    }

    static /* synthetic */ int g(f fVar) {
        int i4 = fVar.I;
        fVar.I = i4 + 1;
        return i4;
    }

    @Override // com.beizi.fusion.work.a
    public void az() {
        SplashAD splashAD = this.f16082x;
        if (splashAD == null || splashAD.getECPM() <= 0 || this.f16078t) {
            return;
        }
        this.f16078t = true;
        af.a("BeiZis", "channel == GDT\u7ade\u4ef7\u6210\u529f");
        af.a("BeiZis", "channel == sendWinNoticeECPM" + this.f16082x.getECPM());
        SplashAD splashAD2 = this.f16082x;
        com.beizi.fusion.d.k.a(splashAD2, splashAD2.getECPM());
    }

    @Override // com.beizi.fusion.work.a
    public String g() {
        return AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_GDT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i4) {
        if (this.S == 1) {
            String valueOf = String.valueOf(i4);
            String str = this.U + " ";
            String str2 = str + valueOf;
            SpannableString spannableString = new SpannableString(str2);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.V)), 0, str.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.W)), str2.indexOf(valueOf), str2.length(), 33);
            ((SkipView) this.f16079u).setText(spannableString);
            return;
        }
        SpannableString spannableString2 = new SpannableString(this.U);
        spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor(this.V)), 0, this.U.length(), 33);
        ((SkipView) this.f16079u).setText(spannableString2);
    }

    @Override // com.beizi.fusion.work.a
    protected void A() {
        StringBuilder sb = new StringBuilder();
        sb.append("enter handleBidAdLoaded isBidTypeC2S() = ");
        sb.append(am());
        sb.append(",mSplashAD != null ? ");
        sb.append(this.f16082x != null);
        af.a("BeiZis", sb.toString());
        if (!z() || this.f16082x == null) {
            return;
        }
        al();
        int a4 = ak.a(this.f15368e.getPriceDict(), this.f16082x.getECPMLevel());
        if (a4 != -1 && a4 != -2) {
            af.a("BeiZisBid", "gdt splash price = " + a4);
            a((double) a4);
            return;
        }
        a(3);
        L();
    }

    @Override // com.beizi.fusion.work.a
    public void d() {
        if (this.f15367d == null) {
            return;
        }
        this.f16073o = System.currentTimeMillis();
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
                if (!av.a(AMPSConstants.CHANNEL_SDK_GDT_CLASSNAME)) {
                    t();
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "GDT sdk not import , will do nothing");
                    return;
                }
                u();
                com.beizi.fusion.d.k.a(this.f16075q, this.f15371h);
                this.f15365b.s(SDKStatus.getIntegrationSDKVersion());
                au();
                v();
            }
        }
        this.f16072n = this.f15368e.getReqTimeOutType();
        long sleepTime = this.f15369f.getSleepTime();
        if (this.f15367d.v()) {
            sleepTime = Math.max(sleepTime, this.f15369f.getHotRequestDelay());
        }
        List<AdSpacesBean.RenderViewBean> list = this.f16083y;
        boolean z3 = list != null && list.size() > 0;
        this.K = z3;
        if (z3) {
            aI();
        }
        v.f14982a = !n.a(this.f15368e.getDirectDownload());
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + sleepTime);
        if (sleepTime > 0) {
            this.f15376m.sendEmptyMessageDelayed(1, sleepTime);
        } else {
            com.beizi.fusion.d.e eVar = this.f15367d;
            if (eVar != null && eVar.t() < 1 && this.f15367d.s() != 2) {
                l();
            }
        }
        this.P = av.l(this.f16075q);
        this.Q = av.m(this.f16075q);
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
    public String j() {
        SplashAD splashAD = this.f16082x;
        if (splashAD != null) {
            int a4 = ak.a(this.f15368e.getPriceDict(), splashAD.getECPMLevel());
            if (a4 == -1 || a4 == -2) {
                return null;
            }
            return a4 + "";
        }
        return null;
    }

    @Override // com.beizi.fusion.work.a
    public AdSpacesBean.BuyerBean k() {
        return this.f15368e;
    }

    @Override // com.beizi.fusion.work.a
    protected void l() {
        int i4;
        w();
        ag();
        long j4 = this.f16077s;
        int i5 = (int) j4;
        int i6 = this.f16072n;
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 == 3) {
                    j4 -= System.currentTimeMillis() - this.f16073o;
                }
                i4 = i5;
            }
            i5 = (int) j4;
            i4 = i5;
        } else {
            i4 = 0;
        }
        af.a("BeiZis", "reqTimeOutType = " + this.f16072n + ",timeOut = " + i4);
        aK();
        if (AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(this.f15368e.getBidType())) {
            this.f16082x = new SplashAD((Activity) this.f16075q, this.f15372i, new a(), i4, aC());
        } else {
            this.f16082x = new SplashAD((Activity) this.f16075q, this.f15372i, new a(), i4);
        }
        this.f16082x.fetchAdOnly();
    }

    private void b() {
        View view;
        View.OnClickListener onClickListener;
        if (this.K || (view = this.f16079u) == null || (onClickListener = this.f16074p) == null) {
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    @Override // com.beizi.fusion.work.a
    public void d(int i4) {
        SplashAD splashAD = this.f16082x;
        if (splashAD == null || splashAD.getECPM() <= 0 || this.f16078t) {
            return;
        }
        this.f16078t = true;
        af.a("BeiZis", "channel == GDT\u7ade\u4ef7\u5931\u8d25:" + i4);
        com.beizi.fusion.d.k.b(this.f16082x, i4 != 1 ? 10001 : 1);
    }
}
