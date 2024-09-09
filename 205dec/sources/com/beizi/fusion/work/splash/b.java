package com.beizi.fusion.work.splash;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.beizi.ad.AdListener;
import com.beizi.ad.SplashAd;
import com.beizi.fusion.d.w;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.al;
import com.beizi.fusion.g.am;
import com.beizi.fusion.g.an;
import com.beizi.fusion.g.ap;
import com.beizi.fusion.g.ar;
import com.beizi.fusion.g.at;
import com.beizi.fusion.g.av;
import com.beizi.fusion.g.x;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.update.ShakeArcView;
import com.beizi.fusion.widget.CircleProgressView;
import com.beizi.fusion.widget.SkipView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BeiZiSplashWorker.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class b extends com.beizi.fusion.work.a implements am.a, ap.a, ar.a {
    private long I;
    private long J;
    private boolean K;

    /* renamed from: L  reason: collision with root package name */
    private CircleProgressView f15947L;
    private AdSpacesBean.PositionBean M;
    private AdSpacesBean.PositionBean N;
    private float O;
    private float P;
    private AdSpacesBean.RenderViewBean Q;
    private int R;
    private int S;
    private String T;
    private String U;
    private String V;
    private AdSpacesBean.BuyerBean.CoolShakeViewBean W;
    private ar ab;
    private am ac;
    private ap ad;
    private AdSpacesBean.BuyerBean.RollViewBean ae;
    private AdSpacesBean.BuyerBean.CoolRollViewBean af;
    private an ag;
    private AdSpacesBean.BuyerBean.EulerAngleViewBean ah;
    private x ai;
    private List<AdSpacesBean.ScreenConfigVoBean> aj;
    private View ak;

    /* renamed from: n  reason: collision with root package name */
    AdSpacesBean.BuyerBean.ShakeViewBean f15948n;

    /* renamed from: o  reason: collision with root package name */
    AdSpacesBean.BuyerBean.RegionalClickViewBean f15949o;

    /* renamed from: p  reason: collision with root package name */
    AdSpacesBean.BuyerBean.ScrollClickBean f15950p;

    /* renamed from: q  reason: collision with root package name */
    AdSpacesBean.BuyerBean.FullScreenClickBean f15951q;

    /* renamed from: r  reason: collision with root package name */
    View.OnClickListener f15952r;

    /* renamed from: s  reason: collision with root package name */
    private Context f15953s;

    /* renamed from: t  reason: collision with root package name */
    private String f15954t;

    /* renamed from: u  reason: collision with root package name */
    private long f15955u;

    /* renamed from: v  reason: collision with root package name */
    private SplashAd f15956v;

    /* renamed from: w  reason: collision with root package name */
    private ViewGroup f15957w;

    /* renamed from: x  reason: collision with root package name */
    private ViewGroup f15958x;

    /* renamed from: y  reason: collision with root package name */
    private View f15959y;

    /* renamed from: z  reason: collision with root package name */
    private List<AdSpacesBean.RenderViewBean> f15960z;
    private List<AdSpacesBean.RenderViewBean> A = new ArrayList();
    private List<AdSpacesBean.RenderViewBean> B = new ArrayList();
    private boolean C = false;
    private boolean D = false;
    private boolean E = false;
    private boolean F = false;
    private boolean G = false;
    private long H = 5000;
    private String X = null;
    private boolean Y = false;
    private int Z = -1;
    private String aa = "full";

    public b(Context context, String str, long j4, View view, ViewGroup viewGroup, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, List<AdSpacesBean.RenderViewBean> list, com.beizi.fusion.d.e eVar) {
        this.f15953s = context;
        this.f15954t = str;
        this.f15955u = j4;
        this.f15957w = viewGroup;
        this.f15368e = buyerBean;
        this.f15369f = forwardBean;
        this.f15367d = eVar;
        this.f15958x = new SplashContainer(context);
        this.f15959y = view;
        this.f15960z = list;
        r();
    }

    private void aG() {
        View view;
        View.OnClickListener onClickListener;
        if (this.K || (view = this.f15959y) == null || (onClickListener = this.f15952r) == null) {
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH() {
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar == null) {
            return;
        }
        Map<String, com.beizi.fusion.work.a> r3 = eVar.r();
        Log.d("BeiZis", "splashWorkers:" + r3.toString());
        Z();
        com.beizi.fusion.d.h hVar = this.f15370g;
        if (hVar == com.beizi.fusion.d.h.SUCCESS) {
            aG();
            this.f15367d.a(g(), (View) null);
        } else if (hVar == com.beizi.fusion.d.h.FAIL) {
            Log.d("BeiZis", "other worker shown," + g() + " remove");
        }
    }

    private void aI() {
        ViewGroup viewGroup;
        SplashAd splashAd = this.f15956v;
        if (splashAd != null && splashAd.isLoaded() && (viewGroup = this.f15957w) != null) {
            viewGroup.removeAllViews();
            this.f15957w.addView(this.f15958x);
            StringBuilder sb = new StringBuilder();
            sb.append("shakeViewBean != null ? ");
            sb.append(this.f15948n != null);
            sb.append(",regionalClickViewBean != null ? ");
            sb.append(this.f15949o != null);
            sb.append(",fullScreenClickBean != null ? ");
            sb.append(this.f15951q != null);
            af.a("BeiZis", sb.toString());
            this.f15958x.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.beizi.fusion.work.splash.b.6

                /* renamed from: a  reason: collision with root package name */
                boolean f15978a;

                /* renamed from: b  reason: collision with root package name */
                boolean f15979b;

                protected void a(boolean z3) {
                    if (z3 || b.this.f15956v == null) {
                        return;
                    }
                    b.this.f15956v.disableFullClick(new View.OnTouchListener() { // from class: com.beizi.fusion.work.splash.b.6.1
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            return true;
                        }
                    });
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    try {
                        if (b.this.f15958x == null) {
                            return;
                        }
                        b.this.f15958x.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        if (((com.beizi.fusion.work.a) b.this).f15368e == null) {
                            return;
                        }
                        b bVar = b.this;
                        if (bVar.f15951q != null) {
                            if (((com.beizi.fusion.work.a) bVar).f15365b != null) {
                                ((com.beizi.fusion.work.a) b.this).f15365b.I(b.this.f15951q.getFullScreenClickUuid());
                                b.this.au();
                            }
                            b bVar2 = b.this;
                            AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean d4 = bVar2.d(bVar2.f15951q.getOrderData(), b.this.f15956v.getAdId());
                            if (d4 != null) {
                                if (d4.getFullScreenClick() != null) {
                                    this.f15979b = al.a(d4.getFullScreenClick().getRandomClickNum());
                                    af.a("BeiZis", "beizi clickable = " + this.f15979b);
                                    a(this.f15979b);
                                }
                            } else {
                                this.f15978a = al.a(b.this.f15951q.getRandomClickNum());
                                af.a("BeiZis", "beizi clickable Two = " + this.f15978a);
                                a(this.f15978a);
                            }
                        }
                        b.this.aV();
                        if (((com.beizi.fusion.work.a) b.this).f15368e.getInteractionRules() != null && ((com.beizi.fusion.work.a) b.this).f15368e.getInteractionRules().size() > 0) {
                            String a4 = com.beizi.fusion.f.b.a(((com.beizi.fusion.work.a) b.this).f15368e.getInteractionRules(), al.b(100));
                            char c4 = '\uffff';
                            switch (a4.hashCode()) {
                                case -1671124246:
                                    if (a4.equals("eulerAngle")) {
                                        c4 = 4;
                                        break;
                                    }
                                    break;
                                case -907680051:
                                    if (a4.equals("scroll")) {
                                        c4 = 2;
                                        break;
                                    }
                                    break;
                                case -690338273:
                                    if (a4.equals("regional")) {
                                        c4 = 1;
                                        break;
                                    }
                                    break;
                                case 3506301:
                                    if (a4.equals("roll")) {
                                        c4 = 3;
                                        break;
                                    }
                                    break;
                                case 109399814:
                                    if (a4.equals("shake")) {
                                        c4 = 0;
                                        break;
                                    }
                                    break;
                            }
                            if (c4 == 0) {
                                b.this.aJ();
                                return;
                            } else if (c4 == 1) {
                                b.this.aR();
                                return;
                            } else if (c4 == 2) {
                                b.this.aS();
                                return;
                            } else if (c4 == 3) {
                                b.this.aT();
                                return;
                            } else if (c4 != 4) {
                                return;
                            } else {
                                b.this.aU();
                                return;
                            }
                        }
                        b.this.aJ();
                        b.this.aR();
                        b.this.aS();
                        b.this.aT();
                        b.this.aU();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            });
            this.f15956v.showAd();
            if (this.f15947L != null) {
                this.f15957w.addView(this.f15947L, new FrameLayout.LayoutParams(-2, -2));
            }
            aN();
            if (this.K) {
                aL();
                return;
            }
            return;
        }
        aw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ() {
        try {
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.f15948n;
            if (shakeViewBean == null || this.ab == null || shakeViewBean.getPosition() == null) {
                return;
            }
            com.beizi.fusion.b.b bVar = this.f15365b;
            if (bVar != null) {
                bVar.G(this.f15948n.getShakeViewUuid());
                au();
            }
            AdSpacesBean.BuyerBean.OrderDataShakeViewBean a4 = a(this.f15948n.getOrderData(), this.f15956v.getAdId());
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = null;
            if (a4 != null && a4.getShakeView() != null) {
                shakeViewBean2 = a4.getShakeView();
            }
            View a5 = this.ab.a(av.b(this.f15953s, this.f15958x.getWidth()), av.b(this.f15953s, this.f15958x.getHeight()), this.f15948n.getPosition());
            if (a5 != null) {
                ViewGroup.LayoutParams layoutParams = a5.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                    layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                    layoutParams2.topMargin = marginLayoutParams.topMargin;
                    this.f15957w.addView(a5, layoutParams2);
                }
            }
            a(shakeViewBean2);
            this.ab.a(this);
            a(shakeViewBean2, a5);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void aK() {
        for (int i4 = 0; i4 < this.f15960z.size(); i4++) {
            AdSpacesBean.RenderViewBean renderViewBean = this.f15960z.get(i4);
            String type = renderViewBean.getType();
            if ("SKIPVIEW".equals(type)) {
                this.B.add(renderViewBean);
            } else if ("MATERIALVIEW".equals(type)) {
                this.A.add(renderViewBean);
            }
        }
        if (this.B.size() > 0) {
            AdSpacesBean.RenderViewBean renderViewBean2 = this.B.get(0);
            this.Q = renderViewBean2;
            if (renderViewBean2 != null) {
                this.N = renderViewBean2.getTapPosition();
                this.M = this.Q.getLayerPosition();
                long skipViewTotalTime = this.Q.getSkipViewTotalTime();
                if (skipViewTotalTime > 0) {
                    this.H = skipViewTotalTime;
                }
                long skipUnavailableTime = this.Q.getSkipUnavailableTime();
                if (skipUnavailableTime > 0) {
                    this.J = skipUnavailableTime;
                }
                this.R = this.Q.getShowCountDown();
                this.S = this.Q.getShowBorder();
                String skipText = this.Q.getSkipText();
                this.T = skipText;
                if (TextUtils.isEmpty(skipText)) {
                    this.T = "\u8df3\u8fc7";
                }
                String textColor = this.Q.getTextColor();
                this.U = textColor;
                if (TextUtils.isEmpty(textColor)) {
                    this.U = "#FFFFFF";
                }
                String countDownColor = this.Q.getCountDownColor();
                this.V = countDownColor;
                if (TextUtils.isEmpty(countDownColor)) {
                    this.V = "#FFFFFF";
                }
                List<AdSpacesBean.PassPolicyBean> passPolicy = this.Q.getPassPolicy();
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
                                this.D = al.a(passPercent);
                                break;
                            case 1:
                                this.C = al.a(passPercent);
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
                                        this.E = al.a(passPercent);
                                    }
                                    if (width2 * height2 < width * height) {
                                        this.F = true;
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
        if (this.A.size() > 0) {
            Collections.sort(this.A, new Comparator<AdSpacesBean.RenderViewBean>() { // from class: com.beizi.fusion.work.splash.b.10
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(AdSpacesBean.RenderViewBean renderViewBean3, AdSpacesBean.RenderViewBean renderViewBean4) {
                    return renderViewBean4.getLevel() - renderViewBean3.getLevel();
                }
            });
        }
    }

    private void aL() {
        if (this.C) {
            Q();
        }
        if (this.D) {
            R();
        }
        if (this.E) {
            S();
        }
        if (this.F) {
            T();
        }
        this.I = this.H - this.J;
    }

    private View aM() {
        View view;
        String str;
        this.f15952r = new View.OnClickListener() { // from class: com.beizi.fusion.work.splash.b.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                try {
                    if (b.this.f15956v != null) {
                        b.this.f15956v.closeAd();
                    }
                    b.this.H();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        };
        if (this.K) {
            View view2 = this.f15959y;
            if (view2 != null) {
                view2.setVisibility(8);
                view2.setAlpha(0.0f);
            }
            SkipView skipView = new SkipView(this.f15953s);
            this.f15959y = skipView;
            skipView.setOnClickListener(this.f15952r);
            CircleProgressView circleProgressView = new CircleProgressView(this.f15953s);
            this.f15947L = circleProgressView;
            circleProgressView.setAlpha(0.0f);
            view = this.f15947L;
            str = "beizi";
        } else {
            view = this.f15959y;
            if (view != null) {
                CircleProgressView circleProgressView2 = new CircleProgressView(this.f15953s);
                this.f15947L = circleProgressView2;
                circleProgressView2.setAlpha(0.0f);
                view = this.f15947L;
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

    private void aN() {
        if (this.K) {
            if (this.M != null && this.Q != null) {
                float f4 = this.O;
                float height = this.f15957w.getHeight();
                if (height == 0.0f) {
                    height = this.P - av.a(this.f15953s, 100.0f);
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
                    int paddingHeight = (int) (d6 * this.Q.getPaddingHeight() * 0.01d);
                    if (paddingHeight < 0) {
                        paddingHeight = 0;
                    }
                    ((SkipView) this.f15959y).setData(this.S, paddingHeight);
                    e(5);
                    this.f15957w.addView(this.f15959y, new FrameLayout.LayoutParams(width, height2));
                    float centerX = (f4 * ((float) (this.M.getCenterX() * 0.01d))) - (width / 2);
                    float centerY = (height * ((float) (this.M.getCenterY() * 0.01d))) - (height2 / 2);
                    this.f15959y.setX(centerX);
                    this.f15959y.setY(centerY);
                    View view = this.f15959y;
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
        View view2 = this.f15959y;
        if (view2 != null) {
            view2.setVisibility(0);
            this.f15959y.setAlpha(1.0f);
        }
    }

    private void aO() {
        double d4 = this.O;
        Double.isNaN(d4);
        int i4 = (int) (d4 * 0.15d);
        double d5 = i4;
        Double.isNaN(d5);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, (int) (d5 * 0.45d));
        layoutParams.gravity = 53;
        layoutParams.topMargin = av.a(this.f15953s, 20.0f);
        layoutParams.rightMargin = av.a(this.f15953s, 20.0f);
        ViewGroup viewGroup = this.f15957w;
        if (viewGroup != null) {
            viewGroup.addView(this.f15959y, layoutParams);
        }
        View view = this.f15959y;
        if (view != null) {
            this.R = 1;
            this.S = 1;
            ((SkipView) view).setData(1, 0);
            ((SkipView) this.f15959y).setText(String.format("\u8df3\u8fc7 %d", 5));
            this.f15959y.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP() {
        int[] iArr;
        float pivotX;
        float pivotY;
        float height;
        try {
            View view = this.f15959y;
            if (view == null) {
                return;
            }
            view.getLocationOnScreen(new int[2]);
            if (this.N != null) {
                float f4 = this.O;
                float height2 = this.f15957w.getHeight();
                if (height2 == 0.0f) {
                    height2 = this.P - av.a(this.f15953s, 100.0f);
                }
                double d4 = f4;
                double width = this.N.getWidth() * 0.01d;
                Double.isNaN(d4);
                int i4 = (int) (d4 * width);
                double d5 = i4;
                double height3 = this.N.getHeight() * 0.01d;
                Double.isNaN(d5);
                int i5 = (int) (d5 * height3);
                ViewGroup.LayoutParams layoutParams = this.f15947L.getLayoutParams();
                layoutParams.width = i4;
                layoutParams.height = i5;
                this.f15947L.setLayoutParams(layoutParams);
                pivotX = (f4 * ((float) (this.N.getCenterX() * 0.01d))) - (i4 / 2);
                pivotY = height2 * ((float) (this.N.getCenterY() * 0.01d));
                height = i5 / 2;
            } else {
                pivotX = (iArr[0] + this.f15959y.getPivotX()) - (this.f15947L.getWidth() / 2);
                pivotY = iArr[1] + this.f15959y.getPivotY();
                height = this.f15947L.getHeight() / 2;
            }
            float f5 = pivotY - height;
            this.f15947L.setX(pivotX);
            this.f15947L.setY(f5);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void aQ() {
        SplashAd splashAd = this.f15956v;
        if (splashAd != null) {
            splashAd.adClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR() {
        try {
            AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean = this.f15949o;
            if (regionalClickViewBean == null || this.ac == null || regionalClickViewBean.getPosition() == null) {
                return;
            }
            com.beizi.fusion.b.b bVar = this.f15365b;
            if (bVar != null) {
                bVar.J(this.f15949o.getRegionalClickUuid());
                au();
            }
            AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean b4 = b(this.f15949o.getOrderData(), this.f15956v.getAdId());
            if (b4 != null) {
                this.ac.a(b4.getRegionalClickView());
            } else {
                this.ac.a(this.f15949o);
            }
            View a4 = this.ac.a(av.b(this.f15953s, this.f15958x.getWidth()), av.b(this.f15953s, this.f15958x.getHeight()), this.f15949o.getPosition(), true);
            this.ak = a4;
            if (a4 != null) {
                ViewGroup.LayoutParams layoutParams = a4.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                    layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                    layoutParams2.topMargin = marginLayoutParams.topMargin;
                    try {
                        this.f15957w.addView(this.ak, layoutParams2);
                        this.ac.a(this);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS() {
        try {
            AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean = this.f15950p;
            if (scrollClickBean == null || this.ad == null || scrollClickBean.getPosition() == null) {
                return;
            }
            com.beizi.fusion.b.b bVar = this.f15365b;
            if (bVar != null) {
                bVar.F(this.f15950p.getScrollClickUuid());
                au();
            }
            AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean c4 = c(this.f15950p.getOrderData(), this.f15956v.getAdId());
            if (c4 != null) {
                this.ad.a(c4.getScrollClick());
            } else {
                this.ad.a(this.f15950p);
            }
            View a4 = this.ad.a(av.b(this.f15953s, this.f15958x.getWidth()), av.b(this.f15953s, this.f15958x.getHeight()), this.f15950p.getPosition());
            if (a4 != null) {
                ViewGroup.LayoutParams layoutParams = a4.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                    layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                    layoutParams2.topMargin = marginLayoutParams.topMargin;
                    try {
                        this.f15957w.addView(a4, layoutParams2);
                        this.ad.a(this);
                        a(this.f15950p.getScrollDirection(), this.f15950p.getScrollDistance(), this);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aT() {
        try {
            AdSpacesBean.BuyerBean.RollViewBean rollView = this.f15368e.getRollView();
            this.ae = rollView;
            if (rollView == null) {
                return;
            }
            AdSpacesBean.BuyerBean.OrderDataRollViewBean e4 = e(rollView.getOrderData(), this.f15956v.getAdId());
            AdSpacesBean.BuyerBean.RollViewBean rollViewBean = null;
            if (e4 != null && e4.getRollView() != null) {
                rollViewBean = e4.getRollView();
            }
            if (rollViewBean == null) {
                rollViewBean = this.ae;
            }
            if (rollViewBean.getPosition() == null) {
                return;
            }
            com.beizi.fusion.b.b bVar = this.f15365b;
            if (bVar != null) {
                bVar.H(rollViewBean.getRollViewUuid());
                au();
            }
            if (this.ag == null) {
                this.ag = new an(this.f15953s);
            }
            this.ag.a(this.f15957w, av.b(this.f15953s, this.f15958x.getWidth()), av.b(this.f15953s, this.f15958x.getHeight()), rollViewBean);
            AdSpacesBean.BuyerBean.RollViewBean rollViewBean2 = this.ae;
            if (rollViewBean2 != null) {
                this.af = rollViewBean2.getCoolRollView();
            }
            a(rollViewBean);
            this.ag.a();
            final int isClick = rollViewBean.getIsClick();
            this.ag.a(new an.a() { // from class: com.beizi.fusion.work.splash.b.12
                public void a() {
                    if (b.this.Y && b.this.af != null) {
                        at.a(b.this.f15953s, b.this.X, Long.valueOf(System.currentTimeMillis()));
                    }
                    b.this.aa = "roll";
                    ((com.beizi.fusion.work.a) b.this).f15365b.O("roll");
                    b.this.au();
                    af.a("BeiZis", "enter onRollHappened  ");
                    b.this.a("", "", "", "", "", "", "", "", 5);
                }

                @Override // com.beizi.fusion.g.an.a
                public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
                    if (isClick == 1) {
                        b.this.aa = "regionalClick";
                        ((com.beizi.fusion.work.a) b.this).f15365b.O("regionalClick");
                        b.this.au();
                        af.a("BeiZis", "enter onClickHappened  ");
                        b.this.a(str, str2, str3, str4, str5, str6, str7, str8, 0);
                        an anVar = b.this.ag;
                        String unused = an.f14811e;
                    }
                }
            });
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU() {
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleRule = this.f15368e.getEulerAngleRule();
            this.ah = eulerAngleRule;
            if (eulerAngleRule == null) {
                return;
            }
            AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean f4 = f(eulerAngleRule.getOrderData(), this.f15956v.getAdId());
            AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean = null;
            if (f4 != null && f4.getEulerAngleRule() != null) {
                eulerAngleViewBean = f4.getEulerAngleRule();
            }
            if (eulerAngleViewBean != null) {
                com.beizi.fusion.b.b bVar = this.f15365b;
                if (bVar != null) {
                    bVar.R(eulerAngleViewBean.getEulerAngleUuid());
                    au();
                }
            } else {
                com.beizi.fusion.b.b bVar2 = this.f15365b;
                if (bVar2 != null) {
                    bVar2.R(this.ah.getEulerAngleUuid());
                    au();
                }
            }
            if (this.ai == null) {
                this.ai = new x(this.f15953s, this.f15372i, this.ah, eulerAngleViewBean);
            }
            this.ai.a(this.f15957w, av.b(this.f15953s, this.f15958x.getWidth()), av.b(this.f15953s, this.f15958x.getHeight()));
            this.ai.a(new x.a() { // from class: com.beizi.fusion.work.splash.b.2
                @Override // com.beizi.fusion.g.x.a
                public void a() {
                    try {
                        b.this.aa = "eulerAngle";
                        ((com.beizi.fusion.work.a) b.this).f15365b.O("eulerAngle");
                        b.this.au();
                        b.this.a("", "", "", "", "", "", "", "", 2);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            });
            this.ai.a();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0093 A[Catch: Exception -> 0x017f, TryCatch #0 {Exception -> 0x017f, blocks: (B:2:0x0000, B:4:0x0004, B:7:0x000c, B:8:0x0012, B:10:0x0018, B:12:0x0031, B:15:0x0037, B:16:0x0039, B:19:0x0054, B:22:0x005b, B:24:0x0061, B:27:0x0080, B:29:0x0086, B:32:0x008d, B:34:0x0093, B:37:0x00b2, B:39:0x00b8, B:42:0x00bf, B:44:0x00c5, B:47:0x00e4, B:49:0x00ea, B:52:0x00f1, B:54:0x00f7, B:57:0x0116, B:62:0x0127, B:64:0x0147, B:66:0x014f, B:67:0x015c, B:55:0x0109, B:56:0x0115, B:45:0x00d7, B:46:0x00e3, B:35:0x00a5, B:36:0x00b1, B:25:0x0073, B:26:0x007f), top: B:73:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a5 A[Catch: Exception -> 0x017f, TryCatch #0 {Exception -> 0x017f, blocks: (B:2:0x0000, B:4:0x0004, B:7:0x000c, B:8:0x0012, B:10:0x0018, B:12:0x0031, B:15:0x0037, B:16:0x0039, B:19:0x0054, B:22:0x005b, B:24:0x0061, B:27:0x0080, B:29:0x0086, B:32:0x008d, B:34:0x0093, B:37:0x00b2, B:39:0x00b8, B:42:0x00bf, B:44:0x00c5, B:47:0x00e4, B:49:0x00ea, B:52:0x00f1, B:54:0x00f7, B:57:0x0116, B:62:0x0127, B:64:0x0147, B:66:0x014f, B:67:0x015c, B:55:0x0109, B:56:0x0115, B:45:0x00d7, B:46:0x00e3, B:35:0x00a5, B:36:0x00b1, B:25:0x0073, B:26:0x007f), top: B:73:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b8 A[Catch: Exception -> 0x017f, TryCatch #0 {Exception -> 0x017f, blocks: (B:2:0x0000, B:4:0x0004, B:7:0x000c, B:8:0x0012, B:10:0x0018, B:12:0x0031, B:15:0x0037, B:16:0x0039, B:19:0x0054, B:22:0x005b, B:24:0x0061, B:27:0x0080, B:29:0x0086, B:32:0x008d, B:34:0x0093, B:37:0x00b2, B:39:0x00b8, B:42:0x00bf, B:44:0x00c5, B:47:0x00e4, B:49:0x00ea, B:52:0x00f1, B:54:0x00f7, B:57:0x0116, B:62:0x0127, B:64:0x0147, B:66:0x014f, B:67:0x015c, B:55:0x0109, B:56:0x0115, B:45:0x00d7, B:46:0x00e3, B:35:0x00a5, B:36:0x00b1, B:25:0x0073, B:26:0x007f), top: B:73:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c5 A[Catch: Exception -> 0x017f, TryCatch #0 {Exception -> 0x017f, blocks: (B:2:0x0000, B:4:0x0004, B:7:0x000c, B:8:0x0012, B:10:0x0018, B:12:0x0031, B:15:0x0037, B:16:0x0039, B:19:0x0054, B:22:0x005b, B:24:0x0061, B:27:0x0080, B:29:0x0086, B:32:0x008d, B:34:0x0093, B:37:0x00b2, B:39:0x00b8, B:42:0x00bf, B:44:0x00c5, B:47:0x00e4, B:49:0x00ea, B:52:0x00f1, B:54:0x00f7, B:57:0x0116, B:62:0x0127, B:64:0x0147, B:66:0x014f, B:67:0x015c, B:55:0x0109, B:56:0x0115, B:45:0x00d7, B:46:0x00e3, B:35:0x00a5, B:36:0x00b1, B:25:0x0073, B:26:0x007f), top: B:73:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d7 A[Catch: Exception -> 0x017f, TryCatch #0 {Exception -> 0x017f, blocks: (B:2:0x0000, B:4:0x0004, B:7:0x000c, B:8:0x0012, B:10:0x0018, B:12:0x0031, B:15:0x0037, B:16:0x0039, B:19:0x0054, B:22:0x005b, B:24:0x0061, B:27:0x0080, B:29:0x0086, B:32:0x008d, B:34:0x0093, B:37:0x00b2, B:39:0x00b8, B:42:0x00bf, B:44:0x00c5, B:47:0x00e4, B:49:0x00ea, B:52:0x00f1, B:54:0x00f7, B:57:0x0116, B:62:0x0127, B:64:0x0147, B:66:0x014f, B:67:0x015c, B:55:0x0109, B:56:0x0115, B:45:0x00d7, B:46:0x00e3, B:35:0x00a5, B:36:0x00b1, B:25:0x0073, B:26:0x007f), top: B:73:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ea A[Catch: Exception -> 0x017f, TryCatch #0 {Exception -> 0x017f, blocks: (B:2:0x0000, B:4:0x0004, B:7:0x000c, B:8:0x0012, B:10:0x0018, B:12:0x0031, B:15:0x0037, B:16:0x0039, B:19:0x0054, B:22:0x005b, B:24:0x0061, B:27:0x0080, B:29:0x0086, B:32:0x008d, B:34:0x0093, B:37:0x00b2, B:39:0x00b8, B:42:0x00bf, B:44:0x00c5, B:47:0x00e4, B:49:0x00ea, B:52:0x00f1, B:54:0x00f7, B:57:0x0116, B:62:0x0127, B:64:0x0147, B:66:0x014f, B:67:0x015c, B:55:0x0109, B:56:0x0115, B:45:0x00d7, B:46:0x00e3, B:35:0x00a5, B:36:0x00b1, B:25:0x0073, B:26:0x007f), top: B:73:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f7 A[Catch: Exception -> 0x017f, TryCatch #0 {Exception -> 0x017f, blocks: (B:2:0x0000, B:4:0x0004, B:7:0x000c, B:8:0x0012, B:10:0x0018, B:12:0x0031, B:15:0x0037, B:16:0x0039, B:19:0x0054, B:22:0x005b, B:24:0x0061, B:27:0x0080, B:29:0x0086, B:32:0x008d, B:34:0x0093, B:37:0x00b2, B:39:0x00b8, B:42:0x00bf, B:44:0x00c5, B:47:0x00e4, B:49:0x00ea, B:52:0x00f1, B:54:0x00f7, B:57:0x0116, B:62:0x0127, B:64:0x0147, B:66:0x014f, B:67:0x015c, B:55:0x0109, B:56:0x0115, B:45:0x00d7, B:46:0x00e3, B:35:0x00a5, B:36:0x00b1, B:25:0x0073, B:26:0x007f), top: B:73:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0109 A[Catch: Exception -> 0x017f, TryCatch #0 {Exception -> 0x017f, blocks: (B:2:0x0000, B:4:0x0004, B:7:0x000c, B:8:0x0012, B:10:0x0018, B:12:0x0031, B:15:0x0037, B:16:0x0039, B:19:0x0054, B:22:0x005b, B:24:0x0061, B:27:0x0080, B:29:0x0086, B:32:0x008d, B:34:0x0093, B:37:0x00b2, B:39:0x00b8, B:42:0x00bf, B:44:0x00c5, B:47:0x00e4, B:49:0x00ea, B:52:0x00f1, B:54:0x00f7, B:57:0x0116, B:62:0x0127, B:64:0x0147, B:66:0x014f, B:67:0x015c, B:55:0x0109, B:56:0x0115, B:45:0x00d7, B:46:0x00e3, B:35:0x00a5, B:36:0x00b1, B:25:0x0073, B:26:0x007f), top: B:73:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0147 A[Catch: Exception -> 0x017f, TryCatch #0 {Exception -> 0x017f, blocks: (B:2:0x0000, B:4:0x0004, B:7:0x000c, B:8:0x0012, B:10:0x0018, B:12:0x0031, B:15:0x0037, B:16:0x0039, B:19:0x0054, B:22:0x005b, B:24:0x0061, B:27:0x0080, B:29:0x0086, B:32:0x008d, B:34:0x0093, B:37:0x00b2, B:39:0x00b8, B:42:0x00bf, B:44:0x00c5, B:47:0x00e4, B:49:0x00ea, B:52:0x00f1, B:54:0x00f7, B:57:0x0116, B:62:0x0127, B:64:0x0147, B:66:0x014f, B:67:0x015c, B:55:0x0109, B:56:0x0115, B:45:0x00d7, B:46:0x00e3, B:35:0x00a5, B:36:0x00b1, B:25:0x0073, B:26:0x007f), top: B:73:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x015c A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void aV() {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.work.splash.b.aV():void");
    }

    @Override // com.beizi.fusion.g.ap.a
    public void c_() {
        this.aa = "scroll";
        this.f15365b.O("scroll");
        au();
        af.a("BeiZis", "enter onScrollDistanceMeet ");
        aQ();
    }

    @Override // com.beizi.fusion.work.a
    public String g() {
        return "BEIZI";
    }

    private boolean c(long j4) {
        try {
            return System.currentTimeMillis() - this.f15953s.getPackageManager().getPackageInfo(this.f15953s.getPackageName(), 0).firstInstallTime < j4;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    private AdSpacesBean.BuyerBean.OrderDataRollViewBean e(List<AdSpacesBean.BuyerBean.OrderDataRollViewBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataRollViewBean orderDataRollViewBean : list) {
                List<String> orderList = orderDataRollViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataRollViewBean;
                }
            }
        }
        return null;
    }

    @Override // com.beizi.fusion.work.a
    protected void A() {
        if (!z() || this.f15956v == null) {
            return;
        }
        al();
    }

    @Override // com.beizi.fusion.work.a
    public void d() {
        if (this.f15367d == null) {
            return;
        }
        this.f15371h = this.f15368e.getAppId();
        this.f15372i = this.f15368e.getSpaceId();
        this.f15366c = this.f15368e.getBuyerSpaceUuId();
        this.X = "splash_cool_" + this.f15372i;
        af.b("BeiZis", "AdWorker chanel = " + this.f15366c);
        com.beizi.fusion.b.d dVar = this.f15364a;
        if (dVar != null) {
            com.beizi.fusion.b.b a4 = dVar.a().a(this.f15366c);
            this.f15365b = a4;
            if (a4 != null) {
                s();
                if (!av.a("com.beizi.ad.BeiZi")) {
                    t();
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "BeiZi sdk not import , will do nothing");
                    return;
                }
                u();
                w.a(this.f15953s, this.f15371h);
                v();
            }
        }
        long sleepTime = this.f15369f.getSleepTime();
        if (this.f15367d.v()) {
            sleepTime = Math.max(sleepTime, this.f15369f.getHotRequestDelay());
        }
        List<AdSpacesBean.RenderViewBean> list = this.f15960z;
        boolean z3 = list != null && list.size() > 0;
        this.K = z3;
        if (z3) {
            aK();
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
        this.O = av.l(this.f15953s);
        this.P = av.m(this.f15953s);
        this.ab = new ar(this.f15953s);
        this.ac = new am(this.f15953s);
        this.ad = new ap(this.f15953s);
    }

    @Override // com.beizi.fusion.work.a
    public void f() {
        Log.d("BeiZis", g() + " out make show ad");
        try {
            aI();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.a
    public com.beizi.fusion.f.a i() {
        return this.f15373j;
    }

    @Override // com.beizi.fusion.work.a
    public String j() {
        SplashAd splashAd = this.f15956v;
        if (splashAd == null) {
            return null;
        }
        return splashAd.getPrice();
    }

    @Override // com.beizi.fusion.work.a
    public AdSpacesBean.BuyerBean k() {
        return this.f15368e;
    }

    @Override // com.beizi.fusion.work.a
    protected void l() {
        w();
        ag();
        View aM = aM();
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView = this.f15368e.getShakeView();
        this.f15948n = shakeView;
        if (shakeView != null) {
            this.W = shakeView.getCoolShakeView();
        }
        this.f15949o = this.f15368e.getRegionalClickView();
        this.f15951q = this.f15368e.getFullScreenClick();
        this.f15950p = this.f15368e.getScrollClick();
        this.aj = this.f15368e.getScreenConfigVo();
        SplashAd splashAd = new SplashAd(this.f15953s, this.f15958x, aM, new AdListener() { // from class: com.beizi.fusion.work.splash.b.5

            /* renamed from: a  reason: collision with root package name */
            boolean f15976a = false;

            /* JADX WARN: Code restructure failed: missing block: B:12:0x0047, code lost:
                r1 = com.beizi.fusion.g.al.a(java.lang.Integer.parseInt(r4.getRate()));
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x0089 A[ADDED_TO_REGION] */
            /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
            @Override // com.beizi.ad.AdListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onAdClicked() {
                /*
                    r7 = this;
                    java.lang.String r0 = "BeiZis"
                    java.lang.String r1 = "showBeiZiSplash onAdClicked()"
                    android.util.Log.d(r0, r1)
                    com.beizi.fusion.work.splash.b r0 = com.beizi.fusion.work.splash.b.this
                    android.content.Context r0 = com.beizi.fusion.work.splash.b.u(r0)
                    long r1 = java.lang.System.currentTimeMillis()
                    java.lang.Long r1 = java.lang.Long.valueOf(r1)
                    java.lang.String r2 = "uniteTime"
                    com.beizi.fusion.g.at.a(r0, r2, r1)
                    r0 = 1
                    r1 = 0
                    com.beizi.fusion.work.splash.b r2 = com.beizi.fusion.work.splash.b.this     // Catch: java.lang.Exception -> L5b
                    com.beizi.fusion.model.AdSpacesBean$BuyerBean r2 = com.beizi.fusion.work.splash.b.v(r2)     // Catch: java.lang.Exception -> L5b
                    java.util.List r2 = r2.getCallBackStrategy()     // Catch: java.lang.Exception -> L5b
                    if (r2 == 0) goto L59
                    int r3 = r2.size()     // Catch: java.lang.Exception -> L5b
                    if (r3 <= 0) goto L59
                    r3 = 0
                L2f:
                    int r4 = r2.size()     // Catch: java.lang.Exception -> L57
                    if (r3 >= r4) goto L60
                    java.lang.Object r4 = r2.get(r3)     // Catch: java.lang.Exception -> L57
                    com.beizi.fusion.model.AdSpacesBean$CallBackStrategyBean r4 = (com.beizi.fusion.model.AdSpacesBean.CallBackStrategyBean) r4     // Catch: java.lang.Exception -> L57
                    java.lang.String r5 = "290.300"
                    java.lang.String r6 = r4.getEventCode()     // Catch: java.lang.Exception -> L57
                    boolean r5 = r5.equalsIgnoreCase(r6)     // Catch: java.lang.Exception -> L57
                    if (r5 == 0) goto L54
                    java.lang.String r2 = r4.getRate()     // Catch: java.lang.Exception -> L57
                    int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Exception -> L57
                    boolean r1 = com.beizi.fusion.g.al.a(r2)     // Catch: java.lang.Exception -> L57
                    goto L60
                L54:
                    int r3 = r3 + 1
                    goto L2f
                L57:
                    r2 = move-exception
                    goto L5d
                L59:
                    r0 = 0
                    goto L60
                L5b:
                    r2 = move-exception
                    r0 = 0
                L5d:
                    r2.printStackTrace()
                L60:
                    if (r0 == 0) goto L82
                    com.beizi.fusion.work.splash.b r2 = com.beizi.fusion.work.splash.b.this
                    com.beizi.fusion.model.AdSpacesBean$BuyerBean r2 = com.beizi.fusion.work.splash.b.w(r2)
                    if (r2 == 0) goto L82
                    com.beizi.fusion.work.splash.b r2 = com.beizi.fusion.work.splash.b.this
                    com.beizi.fusion.b.b r2 = com.beizi.fusion.work.splash.b.y(r2)
                    com.beizi.fusion.work.splash.b r3 = com.beizi.fusion.work.splash.b.this
                    com.beizi.fusion.model.AdSpacesBean$BuyerBean r3 = com.beizi.fusion.work.splash.b.x(r3)
                    java.lang.String r3 = r3.getCallBackStrategyUuid()
                    r2.P(r3)
                    com.beizi.fusion.work.splash.b r2 = com.beizi.fusion.work.splash.b.this
                    com.beizi.fusion.work.splash.b.z(r2)
                L82:
                    com.beizi.fusion.work.splash.b r2 = com.beizi.fusion.work.splash.b.this
                    com.beizi.fusion.work.splash.b.A(r2)
                    if (r0 == 0) goto L8c
                    if (r1 != 0) goto L8c
                    return
                L8c:
                    com.beizi.fusion.work.splash.b r0 = com.beizi.fusion.work.splash.b.this
                    com.beizi.fusion.d.e r0 = com.beizi.fusion.work.splash.b.B(r0)
                    if (r0 == 0) goto La8
                    com.beizi.fusion.work.splash.b r0 = com.beizi.fusion.work.splash.b.this
                    com.beizi.fusion.d.e r0 = com.beizi.fusion.work.splash.b.C(r0)
                    com.beizi.fusion.work.splash.b r1 = com.beizi.fusion.work.splash.b.this
                    java.lang.String r1 = r1.g()
                    r0.d(r1)
                    com.beizi.fusion.work.splash.b r0 = com.beizi.fusion.work.splash.b.this
                    com.beizi.fusion.work.splash.b.D(r0)
                La8:
                    com.beizi.fusion.work.splash.b r0 = com.beizi.fusion.work.splash.b.this
                    com.beizi.fusion.work.splash.b.E(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.work.splash.b.AnonymousClass5.onAdClicked():void");
            }

            @Override // com.beizi.ad.AdListener
            public void onAdClosed() {
                Log.d("BeiZis", "showBeiZiSplash onAdClosed()");
                try {
                    if (((com.beizi.fusion.work.a) b.this).f15367d != null) {
                        ((com.beizi.fusion.work.a) b.this).f15367d.c(b.this.g());
                    }
                    b.this.G();
                    if (b.this.ab != null) {
                        b.this.ab.c();
                    }
                    if (b.this.ac != null) {
                        b.this.ac.a();
                    }
                    if (b.this.ad != null) {
                        b.this.ad.b();
                    }
                    if (b.this.ag != null) {
                        an anVar = b.this.ag;
                        String unused = an.f14810d;
                    }
                    if (b.this.ai != null) {
                        b.this.ai.b();
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }

            @Override // com.beizi.ad.AdListener
            public void onAdFailedToLoad(int i4) {
                Log.d("BeiZis", "showBeiZiSplash onAdFailedToLoad:" + i4);
                b.this.a(String.valueOf(i4), i4);
            }

            @Override // com.beizi.ad.AdListener
            public void onAdLoaded() {
                Log.d("BeiZis", "showBeiZiSplash onAdLoaded:" + System.currentTimeMillis());
                ((com.beizi.fusion.work.a) b.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                if (b.this.f15956v.getPrice() != null) {
                    try {
                        b bVar = b.this;
                        bVar.a(Double.parseDouble(bVar.f15956v.getPrice()));
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                b.this.y();
                if (b.this.Y()) {
                    b.this.aH();
                } else {
                    b.this.O();
                }
            }

            @Override // com.beizi.ad.AdListener
            public void onAdShown() {
                Log.d("BeiZis", "showBeiZiSplash onAdShown()");
                ((com.beizi.fusion.work.a) b.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
                if (((com.beizi.fusion.work.a) b.this).f15367d != null) {
                    if (((com.beizi.fusion.work.a) b.this).f15367d.s() != 2) {
                        ((com.beizi.fusion.work.a) b.this).f15367d.b(b.this.g());
                    }
                    b.this.ah();
                }
                b.this.C();
                b.this.U();
                b.this.D();
            }

            @Override // com.beizi.ad.AdListener
            public void onAdTick(long j4) {
                try {
                    if (!this.f15976a) {
                        b.this.aP();
                        this.f15976a = true;
                    }
                    if (b.this.K) {
                        if (b.this.J > 0 && b.this.J <= b.this.H) {
                            if (b.this.C) {
                                if (b.this.I <= 0 || j4 <= b.this.I) {
                                    b.this.G = false;
                                    b.this.f15959y.setAlpha(1.0f);
                                } else {
                                    b.this.G = true;
                                    b.this.f15959y.setAlpha(0.2f);
                                }
                            }
                            if (b.this.J == b.this.H) {
                                b.this.f15959y.setEnabled(false);
                            } else {
                                b.this.f15959y.setEnabled(true);
                            }
                        }
                        b.this.e(Math.round(((float) j4) / 1000.0f));
                    }
                    if (((com.beizi.fusion.work.a) b.this).f15367d == null || ((com.beizi.fusion.work.a) b.this).f15367d.s() == 2) {
                        return;
                    }
                    ((com.beizi.fusion.work.a) b.this).f15367d.a(j4);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }, this.f15372i);
        this.f15956v = splashAd;
        splashAd.setCloseButtonPadding(10, 20, 10, 10);
        this.f15956v.openAdInNativeBrowser(true);
    }

    @Override // com.beizi.fusion.work.a
    public void m() {
        super.m();
        SplashAd splashAd = this.f15956v;
        if (splashAd != null) {
            splashAd.cancel();
            this.f15956v = null;
        }
    }

    private boolean b(long j4) {
        long longValue = ((Long) at.b(this.f15953s, this.X, 0L)).longValue();
        return longValue != 0 && System.currentTimeMillis() - longValue < j4;
    }

    private AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean c(List<AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean orderDataScrollViewOrderBean : list) {
                List<String> orderList = orderDataScrollViewOrderBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataScrollViewOrderBean;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i4) {
        if (this.R == 1) {
            String valueOf = String.valueOf(i4);
            String str = this.T + " ";
            String str2 = str + valueOf;
            SpannableString spannableString = new SpannableString(str2);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.U)), 0, str.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.V)), str2.indexOf(valueOf), str2.length(), 33);
            ((SkipView) this.f15959y).setText(spannableString);
            return;
        }
        SpannableString spannableString2 = new SpannableString(this.T);
        spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor(this.U)), 0, this.T.length(), 33);
        ((SkipView) this.f15959y).setText(spannableString2);
    }

    private AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean f(List<AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean orderDataEulerAngleViewBean : list) {
                List<String> orderList = orderDataEulerAngleViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataEulerAngleViewBean;
                }
            }
        }
        return null;
    }

    private boolean b(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean != null) {
            AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeView = shakeViewBean.getAliaseShakeView();
            if (aliaseShakeView != null && aliaseShakeView.getPassivationTime() > 0 && (aliaseShakeView.getShakeCount() > 0 || aliaseShakeView.getRotatCount() > 0)) {
                return true;
            }
        } else {
            AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeView2 = this.f15948n.getAliaseShakeView();
            if (this.f15948n.getAliaseShakeView() != null && aliaseShakeView2.getPassivationTime() > 0 && (aliaseShakeView2.getShakeCount() > 0 || aliaseShakeView2.getRotatCount() > 0)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.beizi.fusion.work.a
    public void a(Message message) {
        com.beizi.fusion.b.b bVar = this.f15365b;
        if (bVar != null) {
            bVar.i(String.valueOf(message.obj));
            this.f15365b.m(String.valueOf(message.obj));
            au();
            B();
        }
    }

    private void a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        final AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = shakeViewBean != null ? shakeViewBean : this.f15948n;
        AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean = this.W;
        if (coolShakeViewBean == null) {
            if (b(shakeViewBean)) {
                AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeView = shakeViewBean2.getAliaseShakeView();
                if (aliaseShakeView != null) {
                    this.ab.a(aliaseShakeView);
                    new Handler().postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.b.7
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.Y = true;
                            b.this.ab.a(shakeViewBean2);
                        }
                    }, al.b(aliaseShakeView.getPassivationTime()));
                    return;
                }
                return;
            }
            this.Y = true;
            this.ab.a(shakeViewBean2);
        } else if (b(coolShakeViewBean.getCoolTime())) {
            this.Z = this.W.getFeedback();
            this.ab.a(this.W);
        } else if (c(this.W.getUserProtectTime())) {
            this.Z = this.W.getFeedback();
            this.ab.a(this.W);
        } else if (b(shakeViewBean)) {
            AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeView2 = shakeViewBean2.getAliaseShakeView();
            if (aliaseShakeView2 != null) {
                this.ab.a(aliaseShakeView2);
                new Handler().postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.Y = true;
                        b.this.ab.a(shakeViewBean2);
                    }
                }, al.b(aliaseShakeView2.getPassivationTime()));
            }
        } else {
            this.Y = true;
            this.ab.a(shakeViewBean2);
        }
    }

    private AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean b(List<AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean orderDataRegionalClickViewBean : list) {
                List<String> orderList = orderDataRegionalClickViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataRegionalClickViewBean;
                }
            }
        }
        return null;
    }

    @Override // com.beizi.fusion.g.ar.a
    public void b() {
        if (this.Y && this.W != null) {
            at.a(this.f15953s, this.X, Long.valueOf(System.currentTimeMillis()));
        }
        this.aa = "shake";
        this.f15365b.O("shake");
        au();
        af.a("BeiZis", "enter onShakeHappened  ");
        a("", "", "", "", "", "", "", "", 2);
    }

    @Override // com.beizi.fusion.g.ap.a
    public void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.aa = "scroll";
        this.f15365b.O("scroll");
        au();
        af.a("BeiZis", "enter onScrollDistanceMeetByPosition ");
        a(str, str2, str3, str4, str5, str6, str7, str8, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean d(List<AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean orderDataFullScreenClickBean : list) {
                List<String> orderList = orderDataFullScreenClickBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataFullScreenClickBean;
                }
            }
        }
        return null;
    }

    private void a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean, View view) {
        if (this.Z == -1) {
            this.Z = this.f15948n.getFeedback();
            if (shakeViewBean != null) {
                this.Z = shakeViewBean.getFeedback();
            }
        }
        if (this.Z == 0 || view == null || this.ab == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            ShakeArcView shakeArcView = new ShakeArcView(this.f15953s);
            shakeArcView.setLineRadius(5);
            double d4 = marginLayoutParams.width;
            Double.isNaN(d4);
            int i4 = (int) (d4 * 0.5d);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i4, i4);
            layoutParams2.leftMargin = marginLayoutParams.leftMargin + (((marginLayoutParams.width - i4) - 12) / 2);
            double d5 = marginLayoutParams.topMargin;
            double d6 = marginLayoutParams.height;
            Double.isNaN(d6);
            Double.isNaN(d5);
            layoutParams2.topMargin = (int) (d5 + (d6 * 0.08d));
            this.f15957w.addView(shakeArcView, layoutParams2);
            this.ab.a(shakeArcView, this.Z);
        }
    }

    private void a(final String str, int i4, final ap.a aVar) {
        final int a4 = av.a(this.f15953s, i4);
        this.f15956v.setScrollClick(new View.OnTouchListener() { // from class: com.beizi.fusion.work.splash.b.9

            /* renamed from: a  reason: collision with root package name */
            float f15986a;

            /* renamed from: b  reason: collision with root package name */
            float f15987b;

            /* renamed from: c  reason: collision with root package name */
            float f15988c;

            /* renamed from: d  reason: collision with root package name */
            float f15989d;

            /* renamed from: e  reason: collision with root package name */
            float f15990e;

            /* renamed from: f  reason: collision with root package name */
            float f15991f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ap.a aVar2;
                ap.a aVar3;
                ap.a aVar4;
                ap.a aVar5;
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f15986a = motionEvent.getX();
                    this.f15987b = motionEvent.getY();
                    this.f15988c = motionEvent.getX();
                    this.f15989d = motionEvent.getY();
                    this.f15990e = motionEvent.getRawX();
                    this.f15991f = motionEvent.getRawY();
                } else if (action == 1) {
                    af.b("ScrollClickUtil", "mCurPosX = " + this.f15988c + ",mCurPosY = " + this.f15989d + ",mPosX = " + this.f15986a + ",mPosY = " + this.f15987b);
                    float f4 = this.f15989d;
                    float f5 = this.f15987b;
                    if (f4 - f5 > 0.0f && Math.abs(f4 - f5) > a4) {
                        if ("down".equalsIgnoreCase(str) && (aVar5 = aVar) != null) {
                            aVar5.b(this.f15986a + "", this.f15987b + "", this.f15990e + "", this.f15991f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                        }
                    } else {
                        float f6 = this.f15989d;
                        float f7 = this.f15987b;
                        if (f6 - f7 < 0.0f && Math.abs(f6 - f7) > a4) {
                            if ("up".equalsIgnoreCase(str) && (aVar4 = aVar) != null) {
                                aVar4.b(this.f15986a + "", this.f15987b + "", this.f15990e + "", this.f15991f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                            }
                        } else {
                            float f8 = this.f15988c;
                            float f9 = this.f15986a;
                            if (f8 - f9 < 0.0f && Math.abs(f8 - f9) > a4) {
                                if ("left".equalsIgnoreCase(str) && (aVar3 = aVar) != null) {
                                    aVar3.b(this.f15986a + "", this.f15987b + "", this.f15990e + "", this.f15991f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                }
                            } else {
                                float f10 = this.f15988c;
                                float f11 = this.f15986a;
                                if (f10 - f11 > 0.0f && Math.abs(f10 - f11) > a4 && "right".equalsIgnoreCase(str) && (aVar2 = aVar) != null) {
                                    aVar2.b(this.f15986a + "", this.f15987b + "", this.f15990e + "", this.f15991f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                }
                            }
                        }
                    }
                } else if (action == 2) {
                    this.f15988c = motionEvent.getX();
                    this.f15989d = motionEvent.getY();
                }
                return true;
            }
        });
    }

    private AdSpacesBean.BuyerBean.OrderDataShakeViewBean a(List<AdSpacesBean.BuyerBean.OrderDataShakeViewBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataShakeViewBean orderDataShakeViewBean : list) {
                List<String> orderList = orderDataShakeViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataShakeViewBean;
                }
            }
        }
        return null;
    }

    @Override // com.beizi.fusion.g.am.a
    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.aa = "regionalClick";
        this.f15365b.O("regionalClick");
        au();
        af.a("BeiZis", "enter onRegionClickByPosition ");
        a(str, str2, str3, str4, str5, str6, str7, str8, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i4) {
        SplashAd splashAd = this.f15956v;
        if (splashAd != null) {
            splashAd.adClick(str, str2, str3, str4, str5, str6, str7, str8, i4);
        }
    }

    private void a(AdSpacesBean.BuyerBean.RollViewBean rollViewBean) {
        AdSpacesBean.BuyerBean.CoolRollViewBean coolRollViewBean = this.af;
        if (coolRollViewBean == null) {
            this.Y = true;
            this.ag.a(rollViewBean);
        } else if (b(coolRollViewBean.getCoolTime())) {
            this.ag.a(this.af);
        } else if (c(this.af.getUserProtectTime())) {
            this.ag.a(this.af);
        } else {
            this.Y = true;
            this.ag.a(rollViewBean);
        }
    }
}
