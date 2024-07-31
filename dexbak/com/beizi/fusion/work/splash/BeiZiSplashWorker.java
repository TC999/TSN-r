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
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.ObserverAdStatus;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.CompeteStatus;
import com.beizi.fusion.p066d.selfAdManagerHolder;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p071f.AdStrategy;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3120am;
import com.beizi.fusion.p072g.C3133ar;
import com.beizi.fusion.p072g.C3137at;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.p072g.C3170x;
import com.beizi.fusion.p072g.RandomUtils;
import com.beizi.fusion.p072g.RollUtil;
import com.beizi.fusion.p072g.ScrollClickUtil;
import com.beizi.fusion.update.ShakeArcView;
import com.beizi.fusion.widget.CircleProgressView;
import com.beizi.fusion.widget.ScrollClickView;
import com.beizi.fusion.widget.SkipView;
import com.beizi.fusion.work.AdWorker;
import com.beizi.p051ad.AdListener;
import com.beizi.p051ad.SplashAd;
import com.github.mikephil.charting.utils.Utils;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.splash.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BeiZiSplashWorker extends AdWorker implements C3120am.InterfaceC3123a, ScrollClickUtil.InterfaceC3132a, C3133ar.InterfaceC3136a {

    /* renamed from: I */
    private long f12493I;

    /* renamed from: J */
    private long f12494J;

    /* renamed from: K */
    private boolean f12495K;

    /* renamed from: L */
    private CircleProgressView f12496L;

    /* renamed from: M */
    private AdSpacesBean.PositionBean f12497M;

    /* renamed from: N */
    private AdSpacesBean.PositionBean f12498N;

    /* renamed from: O */
    private float f12499O;

    /* renamed from: P */
    private float f12500P;

    /* renamed from: Q */
    private AdSpacesBean.RenderViewBean f12501Q;

    /* renamed from: R */
    private int f12502R;

    /* renamed from: S */
    private int f12503S;

    /* renamed from: T */
    private String f12504T;

    /* renamed from: U */
    private String f12505U;

    /* renamed from: V */
    private String f12506V;

    /* renamed from: W */
    private AdSpacesBean.BuyerBean.CoolShakeViewBean f12507W;

    /* renamed from: ab */
    private C3133ar f12512ab;

    /* renamed from: ac */
    private C3120am f12513ac;

    /* renamed from: ad */
    private ScrollClickUtil f12514ad;

    /* renamed from: ae */
    private AdSpacesBean.BuyerBean.RollViewBean f12515ae;

    /* renamed from: af */
    private AdSpacesBean.BuyerBean.CoolRollViewBean f12516af;

    /* renamed from: ag */
    private RollUtil f12517ag;

    /* renamed from: ah */
    private AdSpacesBean.BuyerBean.EulerAngleViewBean f12518ah;

    /* renamed from: ai */
    private C3170x f12519ai;

    /* renamed from: aj */
    private List<AdSpacesBean.ScreenConfigVoBean> f12520aj;

    /* renamed from: ak */
    private View f12521ak;

    /* renamed from: n */
    AdSpacesBean.BuyerBean.ShakeViewBean f12522n;

    /* renamed from: o */
    AdSpacesBean.BuyerBean.RegionalClickViewBean f12523o;

    /* renamed from: p */
    AdSpacesBean.BuyerBean.ScrollClickBean f12524p;

    /* renamed from: q */
    AdSpacesBean.BuyerBean.FullScreenClickBean f12525q;

    /* renamed from: r */
    View.OnClickListener f12526r;

    /* renamed from: s */
    private Context f12527s;

    /* renamed from: t */
    private String f12528t;

    /* renamed from: u */
    private long f12529u;

    /* renamed from: v */
    private SplashAd f12530v;

    /* renamed from: w */
    private ViewGroup f12531w;

    /* renamed from: x */
    private ViewGroup f12532x;

    /* renamed from: y */
    private View f12533y;

    /* renamed from: z */
    private List<AdSpacesBean.RenderViewBean> f12534z;

    /* renamed from: A */
    private List<AdSpacesBean.RenderViewBean> f12485A = new ArrayList();

    /* renamed from: B */
    private List<AdSpacesBean.RenderViewBean> f12486B = new ArrayList();

    /* renamed from: C */
    private boolean f12487C = false;

    /* renamed from: D */
    private boolean f12488D = false;

    /* renamed from: E */
    private boolean f12489E = false;

    /* renamed from: F */
    private boolean f12490F = false;

    /* renamed from: G */
    private boolean f12491G = false;

    /* renamed from: H */
    private long f12492H = 5000;

    /* renamed from: X */
    private String f12508X = null;

    /* renamed from: Y */
    private boolean f12509Y = false;

    /* renamed from: Z */
    private int f12510Z = -1;

    /* renamed from: aa */
    private String f12511aa = "full";

    public BeiZiSplashWorker(Context context, String str, long j, View view, ViewGroup viewGroup, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, List<AdSpacesBean.RenderViewBean> list, BaseManager baseManager) {
        this.f12527s = context;
        this.f12528t = str;
        this.f12529u = j;
        this.f12531w = viewGroup;
        this.f11798e = buyerBean;
        this.f11799f = forwardBean;
        this.f11797d = baseManager;
        this.f12532x = new SplashContainer(context);
        this.f12533y = view;
        this.f12534z = list;
        m47917r();
    }

    /* renamed from: aG */
    private void m46591aG() {
        View view;
        View.OnClickListener onClickListener;
        if (this.f12495K || (view = this.f12533y) == null || (onClickListener = this.f12526r) == null) {
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aH */
    public void m46590aH() {
        BaseManager baseManager = this.f11797d;
        if (baseManager == null) {
            return;
        }
        Map<String, AdWorker> m48669r = baseManager.m48669r();
        Log.d("BeiZis", "splashWorkers:" + m48669r.toString());
        m47969Z();
        CompeteStatus competeStatus = this.f11800g;
        if (competeStatus == CompeteStatus.SUCCESS) {
            m46591aG();
            this.f11797d.m48726a(mo46059g(), (View) null);
        } else if (competeStatus == CompeteStatus.FAIL) {
            Log.d("BeiZis", "other worker shown," + mo46059g() + " remove");
        }
    }

    /* renamed from: aI */
    private void m46589aI() {
        ViewGroup viewGroup;
        SplashAd splashAd = this.f12530v;
        if (splashAd != null && splashAd.isLoaded() && (viewGroup = this.f12531w) != null) {
            viewGroup.removeAllViews();
            this.f12531w.addView(this.f12532x);
            StringBuilder sb = new StringBuilder();
            sb.append("shakeViewBean != null ? ");
            sb.append(this.f12522n != null);
            sb.append(",regionalClickViewBean != null ? ");
            sb.append(this.f12523o != null);
            sb.append(",fullScreenClickBean != null ? ");
            sb.append(this.f12525q != null);
            C3116af.m48496a("BeiZis", sb.toString());
            this.f12532x.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.beizi.fusion.work.splash.b.6

                /* renamed from: a */
                boolean f12552a;

                /* renamed from: b */
                boolean f12553b;

                /* renamed from: a */
                protected void m46517a(boolean z) {
                    if (z || BeiZiSplashWorker.this.f12530v == null) {
                        return;
                    }
                    BeiZiSplashWorker.this.f12530v.disableFullClick(new View.OnTouchListener() { // from class: com.beizi.fusion.work.splash.b.6.1
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            return true;
                        }
                    });
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    try {
                        if (BeiZiSplashWorker.this.f12532x == null) {
                            return;
                        }
                        BeiZiSplashWorker.this.f12532x.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        if (((AdWorker) BeiZiSplashWorker.this).f11798e == null) {
                            return;
                        }
                        BeiZiSplashWorker beiZiSplashWorker = BeiZiSplashWorker.this;
                        if (beiZiSplashWorker.f12525q != null) {
                            if (((AdWorker) beiZiSplashWorker).f11795b != null) {
                                ((AdWorker) BeiZiSplashWorker.this).f11795b.m48950I(BeiZiSplashWorker.this.f12525q.getFullScreenClickUuid());
                                BeiZiSplashWorker.this.m47929au();
                            }
                            BeiZiSplashWorker beiZiSplashWorker2 = BeiZiSplashWorker.this;
                            AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean m46547d = beiZiSplashWorker2.m46547d(beiZiSplashWorker2.f12525q.getOrderData(), BeiZiSplashWorker.this.f12530v.getAdId());
                            if (m46547d != null) {
                                if (m46547d.getFullScreenClick() != null) {
                                    this.f12553b = RandomUtils.m48438a(m46547d.getFullScreenClick().getRandomClickNum());
                                    C3116af.m48496a("BeiZis", "beizi clickable = " + this.f12553b);
                                    m46517a(this.f12553b);
                                }
                            } else {
                                this.f12552a = RandomUtils.m48438a(BeiZiSplashWorker.this.f12525q.getRandomClickNum());
                                C3116af.m48496a("BeiZis", "beizi clickable Two = " + this.f12552a);
                                m46517a(this.f12552a);
                            }
                        }
                        BeiZiSplashWorker.this.m46576aV();
                        if (((AdWorker) BeiZiSplashWorker.this).f11798e.getInteractionRules() != null && ((AdWorker) BeiZiSplashWorker.this).f11798e.getInteractionRules().size() > 0) {
                            String m48523a = AdStrategy.m48523a(((AdWorker) BeiZiSplashWorker.this).f11798e.getInteractionRules(), RandomUtils.m48436b(100));
                            char c = 65535;
                            switch (m48523a.hashCode()) {
                                case -1671124246:
                                    if (m48523a.equals("eulerAngle")) {
                                        c = 4;
                                        break;
                                    }
                                    break;
                                case -907680051:
                                    if (m48523a.equals("scroll")) {
                                        c = 2;
                                        break;
                                    }
                                    break;
                                case -690338273:
                                    if (m48523a.equals("regional")) {
                                        c = 1;
                                        break;
                                    }
                                    break;
                                case 3506301:
                                    if (m48523a.equals("roll")) {
                                        c = 3;
                                        break;
                                    }
                                    break;
                                case 109399814:
                                    if (m48523a.equals("shake")) {
                                        c = 0;
                                        break;
                                    }
                                    break;
                            }
                            if (c == 0) {
                                BeiZiSplashWorker.this.m46588aJ();
                                return;
                            } else if (c == 1) {
                                BeiZiSplashWorker.this.m46580aR();
                                return;
                            } else if (c == 2) {
                                BeiZiSplashWorker.this.m46579aS();
                                return;
                            } else if (c == 3) {
                                BeiZiSplashWorker.this.m46578aT();
                                return;
                            } else if (c != 4) {
                                return;
                            } else {
                                BeiZiSplashWorker.this.m46577aU();
                                return;
                            }
                        }
                        BeiZiSplashWorker.this.m46588aJ();
                        BeiZiSplashWorker.this.m46580aR();
                        BeiZiSplashWorker.this.m46579aS();
                        BeiZiSplashWorker.this.m46578aT();
                        BeiZiSplashWorker.this.m46577aU();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            this.f12530v.showAd();
            if (this.f12496L != null) {
                this.f12531w.addView(this.f12496L, new FrameLayout.LayoutParams(-2, -2));
            }
            m46584aN();
            if (this.f12495K) {
                m46586aL();
                return;
            }
            return;
        }
        m47927aw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aJ */
    public void m46588aJ() {
        try {
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.f12522n;
            if (shakeViewBean == null || this.f12512ab == null || shakeViewBean.getPosition() == null) {
                return;
            }
            EventBean eventBean = this.f11795b;
            if (eventBean != null) {
                eventBean.m48954G(this.f12522n.getShakeViewUuid());
                m47929au();
            }
            AdSpacesBean.BuyerBean.OrderDataShakeViewBean m46592a = m46592a(this.f12522n.getOrderData(), this.f12530v.getAdId());
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = null;
            if (m46592a != null && m46592a.getShakeView() != null) {
                shakeViewBean2 = m46592a.getShakeView();
            }
            View m48360a = this.f12512ab.m48360a(C3138av.m48298b(this.f12527s, this.f12532x.getWidth()), C3138av.m48298b(this.f12527s, this.f12532x.getHeight()), this.f12522n.getPosition());
            if (m48360a != null) {
                ViewGroup.LayoutParams layoutParams = m48360a.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                    layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                    layoutParams2.topMargin = marginLayoutParams.topMargin;
                    this.f12531w.addView(m48360a, layoutParams2);
                }
            }
            m46606a(shakeViewBean2);
            this.f12512ab.m48359a(this);
            m46605a(shakeViewBean2, m48360a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: aK */
    private void m46587aK() {
        for (int i = 0; i < this.f12534z.size(); i++) {
            AdSpacesBean.RenderViewBean renderViewBean = this.f12534z.get(i);
            String type = renderViewBean.getType();
            if ("SKIPVIEW".equals(type)) {
                this.f12486B.add(renderViewBean);
            } else if ("MATERIALVIEW".equals(type)) {
                this.f12485A.add(renderViewBean);
            }
        }
        if (this.f12486B.size() > 0) {
            AdSpacesBean.RenderViewBean renderViewBean2 = this.f12486B.get(0);
            this.f12501Q = renderViewBean2;
            if (renderViewBean2 != null) {
                this.f12498N = renderViewBean2.getTapPosition();
                this.f12497M = this.f12501Q.getLayerPosition();
                long skipViewTotalTime = this.f12501Q.getSkipViewTotalTime();
                if (skipViewTotalTime > 0) {
                    this.f12492H = skipViewTotalTime;
                }
                long skipUnavailableTime = this.f12501Q.getSkipUnavailableTime();
                if (skipUnavailableTime > 0) {
                    this.f12494J = skipUnavailableTime;
                }
                this.f12502R = this.f12501Q.getShowCountDown();
                this.f12503S = this.f12501Q.getShowBorder();
                String skipText = this.f12501Q.getSkipText();
                this.f12504T = skipText;
                if (TextUtils.isEmpty(skipText)) {
                    this.f12504T = "跳过";
                }
                String textColor = this.f12501Q.getTextColor();
                this.f12505U = textColor;
                if (TextUtils.isEmpty(textColor)) {
                    this.f12505U = "#FFFFFF";
                }
                String countDownColor = this.f12501Q.getCountDownColor();
                this.f12506V = countDownColor;
                if (TextUtils.isEmpty(countDownColor)) {
                    this.f12506V = "#FFFFFF";
                }
                List<AdSpacesBean.PassPolicyBean> passPolicy = this.f12501Q.getPassPolicy();
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
                                this.f12488D = RandomUtils.m48438a(passPercent);
                                break;
                            case 1:
                                this.f12487C = RandomUtils.m48438a(passPercent);
                                break;
                            case 2:
                                AdSpacesBean.PositionBean positionBean = this.f12497M;
                                if (positionBean != null && this.f12498N != null) {
                                    double centerX = positionBean.getCenterX();
                                    double centerY = this.f12497M.getCenterY();
                                    double width = this.f12497M.getWidth();
                                    double height = this.f12497M.getHeight();
                                    double centerX2 = this.f12498N.getCenterX();
                                    double centerY2 = this.f12498N.getCenterY();
                                    double width2 = this.f12498N.getWidth();
                                    double height2 = this.f12498N.getHeight();
                                    if ((centerX > Utils.DOUBLE_EPSILON && centerX2 > Utils.DOUBLE_EPSILON && centerX != centerX2) || ((centerY > Utils.DOUBLE_EPSILON && centerY2 > Utils.DOUBLE_EPSILON && centerY != centerY2) || ((width > Utils.DOUBLE_EPSILON && width2 > Utils.DOUBLE_EPSILON && width != width2) || (height > Utils.DOUBLE_EPSILON && height2 > Utils.DOUBLE_EPSILON && height != height2)))) {
                                        this.f12489E = RandomUtils.m48438a(passPercent);
                                    }
                                    if (width2 * height2 < width * height) {
                                        this.f12490F = true;
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
        if (this.f12485A.size() > 0) {
            Collections.sort(this.f12485A, new Comparator<AdSpacesBean.RenderViewBean>() { // from class: com.beizi.fusion.work.splash.b.10
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(AdSpacesBean.RenderViewBean renderViewBean3, AdSpacesBean.RenderViewBean renderViewBean4) {
                    return renderViewBean4.getLevel() - renderViewBean3.getLevel();
                }
            });
        }
    }

    /* renamed from: aL */
    private void m46586aL() {
        if (this.f12487C) {
            m47978Q();
        }
        if (this.f12488D) {
            m47977R();
        }
        if (this.f12489E) {
            m47976S();
        }
        if (this.f12490F) {
            m47975T();
        }
        this.f12493I = this.f12492H - this.f12494J;
    }

    /* renamed from: aM */
    private View m46585aM() {
        View view;
        String str;
        this.f12526r = new View.OnClickListener() { // from class: com.beizi.fusion.work.splash.b.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                try {
                    if (BeiZiSplashWorker.this.f12530v != null) {
                        BeiZiSplashWorker.this.f12530v.closeAd();
                    }
                    BeiZiSplashWorker.this.m47987H();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        if (this.f12495K) {
            View view2 = this.f12533y;
            if (view2 != null) {
                view2.setVisibility(8);
                view2.setAlpha(0.0f);
            }
            SkipView skipView = new SkipView(this.f12527s);
            this.f12533y = skipView;
            skipView.setOnClickListener(this.f12526r);
            CircleProgressView circleProgressView = new CircleProgressView(this.f12527s);
            this.f12496L = circleProgressView;
            circleProgressView.setAlpha(0.0f);
            view = this.f12496L;
            str = "beizi";
        } else {
            view = this.f12533y;
            if (view != null) {
                CircleProgressView circleProgressView2 = new CircleProgressView(this.f12527s);
                this.f12496L = circleProgressView2;
                circleProgressView2.setAlpha(0.0f);
                view = this.f12496L;
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

    /* renamed from: aN */
    private void m46584aN() {
        if (this.f12495K) {
            if (this.f12497M != null && this.f12501Q != null) {
                float f = this.f12499O;
                float height = this.f12531w.getHeight();
                if (height == 0.0f) {
                    height = this.f12500P - C3138av.m48304a(this.f12527s, 100.0f);
                }
                double d = f;
                Double.isNaN(d);
                int width = (int) (d * this.f12497M.getWidth() * 0.01d);
                if (this.f12497M.getHeight() >= 12.0d) {
                    double d2 = width;
                    Double.isNaN(d2);
                    int height2 = (int) (d2 * this.f12497M.getHeight() * 0.01d);
                    double d3 = height2;
                    Double.isNaN(d3);
                    int paddingHeight = (int) (d3 * this.f12501Q.getPaddingHeight() * 0.01d);
                    if (paddingHeight < 0) {
                        paddingHeight = 0;
                    }
                    ((SkipView) this.f12533y).setData(this.f12503S, paddingHeight);
                    m46546e(5);
                    this.f12531w.addView(this.f12533y, new FrameLayout.LayoutParams(width, height2));
                    float centerX = (f * ((float) (this.f12497M.getCenterX() * 0.01d))) - (width / 2);
                    float centerY = (height * ((float) (this.f12497M.getCenterY() * 0.01d))) - (height2 / 2);
                    this.f12533y.setX(centerX);
                    this.f12533y.setY(centerY);
                    View view = this.f12533y;
                    if (view != null) {
                        view.setVisibility(0);
                        return;
                    }
                    return;
                }
                m46583aO();
                return;
            }
            m46583aO();
            return;
        }
        View view2 = this.f12533y;
        if (view2 != null) {
            view2.setVisibility(0);
            this.f12533y.setAlpha(1.0f);
        }
    }

    /* renamed from: aO */
    private void m46583aO() {
        double d = this.f12499O;
        Double.isNaN(d);
        int i = (int) (d * 0.15d);
        double d2 = i;
        Double.isNaN(d2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (int) (d2 * 0.45d));
        layoutParams.gravity = 53;
        layoutParams.topMargin = C3138av.m48304a(this.f12527s, 20.0f);
        layoutParams.rightMargin = C3138av.m48304a(this.f12527s, 20.0f);
        ViewGroup viewGroup = this.f12531w;
        if (viewGroup != null) {
            viewGroup.addView(this.f12533y, layoutParams);
        }
        View view = this.f12533y;
        if (view != null) {
            this.f12502R = 1;
            this.f12503S = 1;
            ((SkipView) view).setData(1, 0);
            ((SkipView) this.f12533y).setText(String.format("跳过 %d", 5));
            this.f12533y.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aP */
    public void m46582aP() {
        int[] iArr;
        float pivotX;
        float pivotY;
        float height;
        try {
            View view = this.f12533y;
            if (view == null) {
                return;
            }
            view.getLocationOnScreen(new int[2]);
            if (this.f12498N != null) {
                float f = this.f12499O;
                float height2 = this.f12531w.getHeight();
                if (height2 == 0.0f) {
                    height2 = this.f12500P - C3138av.m48304a(this.f12527s, 100.0f);
                }
                double d = f;
                double width = this.f12498N.getWidth() * 0.01d;
                Double.isNaN(d);
                int i = (int) (d * width);
                double d2 = i;
                double height3 = this.f12498N.getHeight() * 0.01d;
                Double.isNaN(d2);
                int i2 = (int) (d2 * height3);
                ViewGroup.LayoutParams layoutParams = this.f12496L.getLayoutParams();
                layoutParams.width = i;
                layoutParams.height = i2;
                this.f12496L.setLayoutParams(layoutParams);
                pivotX = (f * ((float) (this.f12498N.getCenterX() * 0.01d))) - (i / 2);
                pivotY = height2 * ((float) (this.f12498N.getCenterY() * 0.01d));
                height = i2 / 2;
            } else {
                pivotX = (iArr[0] + this.f12533y.getPivotX()) - (this.f12496L.getWidth() / 2);
                pivotY = iArr[1] + this.f12533y.getPivotY();
                height = this.f12496L.getHeight() / 2;
            }
            float f2 = pivotY - height;
            this.f12496L.setX(pivotX);
            this.f12496L.setY(f2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: aQ */
    private void m46581aQ() {
        SplashAd splashAd = this.f12530v;
        if (splashAd != null) {
            splashAd.adClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aR */
    public void m46580aR() {
        try {
            AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean = this.f12523o;
            if (regionalClickViewBean == null || this.f12513ac == null || regionalClickViewBean.getPosition() == null) {
                return;
            }
            EventBean eventBean = this.f11795b;
            if (eventBean != null) {
                eventBean.m48948J(this.f12523o.getRegionalClickUuid());
                m47929au();
            }
            AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean m46553b = m46553b(this.f12523o.getOrderData(), this.f12530v.getAdId());
            if (m46553b != null) {
                this.f12513ac.m48429a(m46553b.getRegionalClickView());
            } else {
                this.f12513ac.m48429a(this.f12523o);
            }
            View m48432a = this.f12513ac.m48432a(C3138av.m48298b(this.f12527s, this.f12532x.getWidth()), C3138av.m48298b(this.f12527s, this.f12532x.getHeight()), this.f12523o.getPosition(), true);
            this.f12521ak = m48432a;
            if (m48432a != null) {
                ViewGroup.LayoutParams layoutParams = m48432a.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                    layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                    layoutParams2.topMargin = marginLayoutParams.topMargin;
                    try {
                        this.f12531w.addView(this.f12521ak, layoutParams2);
                        this.f12513ac.m48431a(this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aS */
    public void m46579aS() {
        try {
            AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean = this.f12524p;
            if (scrollClickBean == null || this.f12514ad == null || scrollClickBean.getPosition() == null) {
                return;
            }
            EventBean eventBean = this.f11795b;
            if (eventBean != null) {
                eventBean.m48956F(this.f12524p.getScrollClickUuid());
                m47929au();
            }
            AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean m46550c = m46550c(this.f12524p.getOrderData(), this.f12530v.getAdId());
            if (m46550c != null) {
                this.f12514ad.m48374a(m46550c.getScrollClick());
            } else {
                this.f12514ad.m48374a(this.f12524p);
            }
            View m48377a = this.f12514ad.m48377a(C3138av.m48298b(this.f12527s, this.f12532x.getWidth()), C3138av.m48298b(this.f12527s, this.f12532x.getHeight()), this.f12524p.getPosition());
            if (m48377a != null) {
                ViewGroup.LayoutParams layoutParams = m48377a.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                    layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                    layoutParams2.topMargin = marginLayoutParams.topMargin;
                    try {
                        this.f12531w.addView(m48377a, layoutParams2);
                        this.f12514ad.m48376a(this);
                        m46595a(this.f12524p.getScrollDirection(), this.f12524p.getScrollDistance(), this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aT */
    public void m46578aT() {
        try {
            AdSpacesBean.BuyerBean.RollViewBean rollView = this.f11798e.getRollView();
            this.f12515ae = rollView;
            if (rollView == null) {
                return;
            }
            AdSpacesBean.BuyerBean.OrderDataRollViewBean m46544e = m46544e(rollView.getOrderData(), this.f12530v.getAdId());
            AdSpacesBean.BuyerBean.RollViewBean rollViewBean = null;
            if (m46544e != null && m46544e.getRollView() != null) {
                rollViewBean = m46544e.getRollView();
            }
            if (rollViewBean == null) {
                rollViewBean = this.f12515ae;
            }
            if (rollViewBean.getPosition() == null) {
                return;
            }
            EventBean eventBean = this.f11795b;
            if (eventBean != null) {
                eventBean.m48952H(rollViewBean.getRollViewUuid());
                m47929au();
            }
            if (this.f12517ag == null) {
                this.f12517ag = new RollUtil(this.f12527s);
            }
            this.f12517ag.m48417a(this.f12531w, C3138av.m48298b(this.f12527s, this.f12532x.getWidth()), C3138av.m48298b(this.f12527s, this.f12532x.getHeight()), rollViewBean);
            AdSpacesBean.BuyerBean.RollViewBean rollViewBean2 = this.f12515ae;
            if (rollViewBean2 != null) {
                this.f12516af = rollViewBean2.getCoolRollView();
            }
            m46607a(rollViewBean);
            this.f12517ag.m48420a();
            final int isClick = rollViewBean.getIsClick();
            this.f12517ag.m48416a(new RollUtil.InterfaceC3128a() { // from class: com.beizi.fusion.work.splash.b.12
                @Override // com.beizi.fusion.p072g.RollUtil.InterfaceC3128a
                /* renamed from: a */
                public void mo46520a() {
                    if (BeiZiSplashWorker.this.f12509Y && BeiZiSplashWorker.this.f12516af != null) {
                        C3137at.m48315a(BeiZiSplashWorker.this.f12527s, BeiZiSplashWorker.this.f12508X, Long.valueOf(System.currentTimeMillis()));
                    }
                    BeiZiSplashWorker.this.f12511aa = "roll";
                    ((AdWorker) BeiZiSplashWorker.this).f11795b.m48938O("roll");
                    BeiZiSplashWorker.this.m47929au();
                    C3116af.m48496a("BeiZis", "enter onRollHappened  ");
                    BeiZiSplashWorker.this.m46593a("", "", "", "", "", "", "", "", 5);
                }

                @Override // com.beizi.fusion.p072g.RollUtil.InterfaceC3128a
                /* renamed from: a */
                public void mo46519a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
                    if (isClick == 1) {
                        BeiZiSplashWorker.this.f12511aa = "regionalClick";
                        ((AdWorker) BeiZiSplashWorker.this).f11795b.m48938O("regionalClick");
                        BeiZiSplashWorker.this.m47929au();
                        C3116af.m48496a("BeiZis", "enter onClickHappened  ");
                        BeiZiSplashWorker.this.m46593a(str, str2, str3, str4, str5, str6, str7, str8, 0);
                        BeiZiSplashWorker.this.f12517ag.m48401c();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aU */
    public void m46577aU() {
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleRule = this.f11798e.getEulerAngleRule();
            this.f12518ah = eulerAngleRule;
            if (eulerAngleRule == null) {
                return;
            }
            AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean m46542f = m46542f(eulerAngleRule.getOrderData(), this.f12530v.getAdId());
            AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean = null;
            if (m46542f != null && m46542f.getEulerAngleRule() != null) {
                eulerAngleViewBean = m46542f.getEulerAngleRule();
            }
            if (eulerAngleViewBean != null) {
                EventBean eventBean = this.f11795b;
                if (eventBean != null) {
                    eventBean.m48932R(eulerAngleViewBean.getEulerAngleUuid());
                    m47929au();
                }
            } else {
                EventBean eventBean2 = this.f11795b;
                if (eventBean2 != null) {
                    eventBean2.m48932R(this.f12518ah.getEulerAngleUuid());
                    m47929au();
                }
            }
            if (this.f12519ai == null) {
                this.f12519ai = new C3170x(this.f12527s, this.f11802i, this.f12518ah, eulerAngleViewBean);
            }
            this.f12519ai.m48183a(this.f12531w, C3138av.m48298b(this.f12527s, this.f12532x.getWidth()), C3138av.m48298b(this.f12527s, this.f12532x.getHeight()));
            this.f12519ai.m48182a(new C3170x.InterfaceC3173a() { // from class: com.beizi.fusion.work.splash.b.2
                @Override // com.beizi.fusion.p072g.C3170x.InterfaceC3173a
                /* renamed from: a */
                public void mo46518a() {
                    try {
                        BeiZiSplashWorker.this.f12511aa = "eulerAngle";
                        ((AdWorker) BeiZiSplashWorker.this).f11795b.m48938O("eulerAngle");
                        BeiZiSplashWorker.this.m47929au();
                        BeiZiSplashWorker.this.m46593a("", "", "", "", "", "", "", "", 2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            this.f12519ai.m48186a();
        } catch (Exception e) {
            e.printStackTrace();
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
    /* renamed from: aV */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m46576aV() {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.work.splash.BeiZiSplashWorker.m46576aV():void");
    }

    @Override // com.beizi.fusion.p072g.ScrollClickUtil.InterfaceC3132a
    /* renamed from: c_ */
    public void mo46549c_() {
        this.f12511aa = "scroll";
        this.f11795b.m48938O("scroll");
        m47929au();
        C3116af.m48496a("BeiZis", "enter onScrollDistanceMeet ");
        m46581aQ();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "BEIZI";
    }

    /* renamed from: c */
    private boolean m46552c(long j) {
        try {
            return System.currentTimeMillis() - this.f12527s.getPackageManager().getPackageInfo(this.f12527s.getPackageName(), 0).firstInstallTime < j;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: e */
    private AdSpacesBean.BuyerBean.OrderDataRollViewBean m46544e(List<AdSpacesBean.BuyerBean.OrderDataRollViewBean> list, String str) {
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

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: A */
    protected void mo46197A() {
        if (!m47909z() || this.f12530v == null) {
            return;
        }
        m47938al();
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
        this.f12508X = "splash_cool_" + this.f11802i;
        C3116af.m48495b("BeiZis", "AdWorker chanel = " + this.f11796c);
        ObserverAdStatus observerAdStatus = this.f11794a;
        if (observerAdStatus != null) {
            EventBean m48977a = observerAdStatus.m48860a().m48977a(this.f11796c);
            this.f11795b = m48977a;
            if (m48977a != null) {
                m47916s();
                if (!C3138av.m48301a("com.beizi.ad.BeiZi")) {
                    m47915t();
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BeiZiSplashWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "BeiZi sdk not import , will do nothing");
                    return;
                }
                m47914u();
                selfAdManagerHolder.m48575a(this.f12527s, this.f11801h);
                m47913v();
            }
        }
        long sleepTime = this.f11799f.getSleepTime();
        if (this.f11797d.m48665v()) {
            sleepTime = Math.max(sleepTime, this.f11799f.getHotRequestDelay());
        }
        List<AdSpacesBean.RenderViewBean> list = this.f12534z;
        boolean z = list != null && list.size() > 0;
        this.f12495K = z;
        if (z) {
            m46587aK();
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
        this.f12499O = C3138av.m48286l(this.f12527s);
        this.f12500P = C3138av.m48285m(this.f12527s);
        this.f12512ab = new C3133ar(this.f12527s);
        this.f12513ac = new C3120am(this.f12527s);
        this.f12514ad = new ScrollClickUtil(this.f12527s);
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: f */
    public void mo46061f() {
        Log.d("BeiZis", mo46059g() + " out make show ad");
        try {
            m46589aI();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: i */
    public AdStatus mo46056i() {
        return this.f11803j;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: j */
    public String mo46054j() {
        SplashAd splashAd = this.f12530v;
        if (splashAd == null) {
            return null;
        }
        return splashAd.getPrice();
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
        View m46585aM = m46585aM();
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView = this.f11798e.getShakeView();
        this.f12522n = shakeView;
        if (shakeView != null) {
            this.f12507W = shakeView.getCoolShakeView();
        }
        this.f12523o = this.f11798e.getRegionalClickView();
        this.f12525q = this.f11798e.getFullScreenClick();
        this.f12524p = this.f11798e.getScrollClick();
        this.f12520aj = this.f11798e.getScreenConfigVo();
        SplashAd splashAd = new SplashAd(this.f12527s, this.f12532x, m46585aM, new AdListener() { // from class: com.beizi.fusion.work.splash.b.5

            /* renamed from: a */
            boolean f12550a = false;

            /* JADX WARN: Code restructure failed: missing block: B:12:0x0047, code lost:
                r1 = com.beizi.fusion.p072g.RandomUtils.m48438a(java.lang.Integer.parseInt(r4.getRate()));
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x0089 A[ADDED_TO_REGION] */
            /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
            @Override // com.beizi.p051ad.AdListener
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
                    com.beizi.fusion.work.splash.b r0 = com.beizi.fusion.work.splash.BeiZiSplashWorker.this
                    android.content.Context r0 = com.beizi.fusion.work.splash.BeiZiSplashWorker.m46527u(r0)
                    long r1 = java.lang.System.currentTimeMillis()
                    java.lang.Long r1 = java.lang.Long.valueOf(r1)
                    java.lang.String r2 = "uniteTime"
                    com.beizi.fusion.p072g.C3137at.m48315a(r0, r2, r1)
                    r0 = 1
                    r1 = 0
                    com.beizi.fusion.work.splash.b r2 = com.beizi.fusion.work.splash.BeiZiSplashWorker.this     // Catch: java.lang.Exception -> L5b
                    com.beizi.fusion.model.AdSpacesBean$BuyerBean r2 = com.beizi.fusion.work.splash.BeiZiSplashWorker.m46526v(r2)     // Catch: java.lang.Exception -> L5b
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
                    boolean r1 = com.beizi.fusion.p072g.RandomUtils.m48438a(r2)     // Catch: java.lang.Exception -> L57
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
                    com.beizi.fusion.work.splash.b r2 = com.beizi.fusion.work.splash.BeiZiSplashWorker.this
                    com.beizi.fusion.model.AdSpacesBean$BuyerBean r2 = com.beizi.fusion.work.splash.BeiZiSplashWorker.m46525w(r2)
                    if (r2 == 0) goto L82
                    com.beizi.fusion.work.splash.b r2 = com.beizi.fusion.work.splash.BeiZiSplashWorker.this
                    com.beizi.fusion.b.b r2 = com.beizi.fusion.work.splash.BeiZiSplashWorker.m46523y(r2)
                    com.beizi.fusion.work.splash.b r3 = com.beizi.fusion.work.splash.BeiZiSplashWorker.this
                    com.beizi.fusion.model.AdSpacesBean$BuyerBean r3 = com.beizi.fusion.work.splash.BeiZiSplashWorker.m46524x(r3)
                    java.lang.String r3 = r3.getCallBackStrategyUuid()
                    r2.m48936P(r3)
                    com.beizi.fusion.work.splash.b r2 = com.beizi.fusion.work.splash.BeiZiSplashWorker.this
                    com.beizi.fusion.work.splash.BeiZiSplashWorker.m46522z(r2)
                L82:
                    com.beizi.fusion.work.splash.b r2 = com.beizi.fusion.work.splash.BeiZiSplashWorker.this
                    com.beizi.fusion.work.splash.BeiZiSplashWorker.m46633A(r2)
                    if (r0 == 0) goto L8c
                    if (r1 != 0) goto L8c
                    return
                L8c:
                    com.beizi.fusion.work.splash.b r0 = com.beizi.fusion.work.splash.BeiZiSplashWorker.this
                    com.beizi.fusion.d.e r0 = com.beizi.fusion.work.splash.BeiZiSplashWorker.m46632B(r0)
                    if (r0 == 0) goto La8
                    com.beizi.fusion.work.splash.b r0 = com.beizi.fusion.work.splash.BeiZiSplashWorker.this
                    com.beizi.fusion.d.e r0 = com.beizi.fusion.work.splash.BeiZiSplashWorker.m46631C(r0)
                    com.beizi.fusion.work.splash.b r1 = com.beizi.fusion.work.splash.BeiZiSplashWorker.this
                    java.lang.String r1 = r1.mo46059g()
                    r0.m48700d(r1)
                    com.beizi.fusion.work.splash.b r0 = com.beizi.fusion.work.splash.BeiZiSplashWorker.this
                    com.beizi.fusion.work.splash.BeiZiSplashWorker.m46630D(r0)
                La8:
                    com.beizi.fusion.work.splash.b r0 = com.beizi.fusion.work.splash.BeiZiSplashWorker.this
                    com.beizi.fusion.work.splash.BeiZiSplashWorker.m46629E(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.work.splash.BeiZiSplashWorker.C34405.onAdClicked():void");
            }

            @Override // com.beizi.p051ad.AdListener
            public void onAdClosed() {
                Log.d("BeiZis", "showBeiZiSplash onAdClosed()");
                try {
                    if (((AdWorker) BeiZiSplashWorker.this).f11797d != null) {
                        ((AdWorker) BeiZiSplashWorker.this).f11797d.m48704c(BeiZiSplashWorker.this.mo46059g());
                    }
                    BeiZiSplashWorker.this.m47988G();
                    if (BeiZiSplashWorker.this.f12512ab != null) {
                        BeiZiSplashWorker.this.f12512ab.m48341c();
                    }
                    if (BeiZiSplashWorker.this.f12513ac != null) {
                        BeiZiSplashWorker.this.f12513ac.m48434a();
                    }
                    if (BeiZiSplashWorker.this.f12514ad != null) {
                        BeiZiSplashWorker.this.f12514ad.m48373b();
                    }
                    if (BeiZiSplashWorker.this.f12517ag != null) {
                        BeiZiSplashWorker.this.f12517ag.m48407b();
                    }
                    if (BeiZiSplashWorker.this.f12519ai != null) {
                        BeiZiSplashWorker.this.f12519ai.m48176b();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // com.beizi.p051ad.AdListener
            public void onAdFailedToLoad(int i) {
                Log.d("BeiZis", "showBeiZiSplash onAdFailedToLoad:" + i);
                BeiZiSplashWorker.this.m47961a(String.valueOf(i), i);
            }

            @Override // com.beizi.p051ad.AdListener
            public void onAdLoaded() {
                Log.d("BeiZis", "showBeiZiSplash onAdLoaded:" + System.currentTimeMillis());
                ((AdWorker) BeiZiSplashWorker.this).f11803j = AdStatus.ADLOAD;
                if (BeiZiSplashWorker.this.f12530v.getPrice() != null) {
                    try {
                        BeiZiSplashWorker beiZiSplashWorker = BeiZiSplashWorker.this;
                        beiZiSplashWorker.m47967a(Double.parseDouble(beiZiSplashWorker.f12530v.getPrice()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                BeiZiSplashWorker.this.m47910y();
                if (BeiZiSplashWorker.this.m47970Y()) {
                    BeiZiSplashWorker.this.m46590aH();
                } else {
                    BeiZiSplashWorker.this.m47980O();
                }
            }

            @Override // com.beizi.p051ad.AdListener
            public void onAdShown() {
                Log.d("BeiZis", "showBeiZiSplash onAdShown()");
                ((AdWorker) BeiZiSplashWorker.this).f11803j = AdStatus.ADSHOW;
                if (((AdWorker) BeiZiSplashWorker.this).f11797d != null) {
                    if (((AdWorker) BeiZiSplashWorker.this).f11797d.m48668s() != 2) {
                        ((AdWorker) BeiZiSplashWorker.this).f11797d.m48710b(BeiZiSplashWorker.this.mo46059g());
                    }
                    BeiZiSplashWorker.this.m47942ah();
                }
                BeiZiSplashWorker.this.m47992C();
                BeiZiSplashWorker.this.m47974U();
                BeiZiSplashWorker.this.m47991D();
            }

            @Override // com.beizi.p051ad.AdListener
            public void onAdTick(long j) {
                try {
                    if (!this.f12550a) {
                        BeiZiSplashWorker.this.m46582aP();
                        this.f12550a = true;
                    }
                    if (BeiZiSplashWorker.this.f12495K) {
                        if (BeiZiSplashWorker.this.f12494J > 0 && BeiZiSplashWorker.this.f12494J <= BeiZiSplashWorker.this.f12492H) {
                            if (BeiZiSplashWorker.this.f12487C) {
                                if (BeiZiSplashWorker.this.f12493I <= 0 || j <= BeiZiSplashWorker.this.f12493I) {
                                    BeiZiSplashWorker.this.f12491G = false;
                                    BeiZiSplashWorker.this.f12533y.setAlpha(1.0f);
                                } else {
                                    BeiZiSplashWorker.this.f12491G = true;
                                    BeiZiSplashWorker.this.f12533y.setAlpha(0.2f);
                                }
                            }
                            if (BeiZiSplashWorker.this.f12494J == BeiZiSplashWorker.this.f12492H) {
                                BeiZiSplashWorker.this.f12533y.setEnabled(false);
                            } else {
                                BeiZiSplashWorker.this.f12533y.setEnabled(true);
                            }
                        }
                        BeiZiSplashWorker.this.m46546e(Math.round(((float) j) / 1000.0f));
                    }
                    if (((AdWorker) BeiZiSplashWorker.this).f11797d == null || ((AdWorker) BeiZiSplashWorker.this).f11797d.m48668s() == 2) {
                        return;
                    }
                    ((AdWorker) BeiZiSplashWorker.this).f11797d.m48752a(j);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, this.f11802i);
        this.f12530v = splashAd;
        splashAd.setCloseButtonPadding(10, 20, 10, 10);
        this.f12530v.openAdInNativeBrowser(true);
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: m */
    public void mo46173m() {
        super.mo46173m();
        SplashAd splashAd = this.f12530v;
        if (splashAd != null) {
            splashAd.cancel();
            this.f12530v = null;
        }
    }

    /* renamed from: b */
    private boolean m46560b(long j) {
        long longValue = ((Long) C3137at.m48313b(this.f12527s, this.f12508X, 0L)).longValue();
        return longValue != 0 && System.currentTimeMillis() - longValue < j;
    }

    /* renamed from: c */
    private AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean m46550c(List<AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean> list, String str) {
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
    /* renamed from: e */
    public void m46546e(int i) {
        if (this.f12502R == 1) {
            String valueOf = String.valueOf(i);
            String str = this.f12504T + " ";
            String str2 = str + valueOf;
            SpannableString spannableString = new SpannableString(str2);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.f12505U)), 0, str.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.f12506V)), str2.indexOf(valueOf), str2.length(), 33);
            ((SkipView) this.f12533y).setText(spannableString);
            return;
        }
        SpannableString spannableString2 = new SpannableString(this.f12504T);
        spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor(this.f12505U)), 0, this.f12504T.length(), 33);
        ((SkipView) this.f12533y).setText(spannableString2);
    }

    /* renamed from: f */
    private AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean m46542f(List<AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean> list, String str) {
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

    /* renamed from: b */
    private boolean m46559b(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean != null) {
            AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeView = shakeViewBean.getAliaseShakeView();
            if (aliaseShakeView != null && aliaseShakeView.getPassivationTime() > 0 && (aliaseShakeView.getShakeCount() > 0 || aliaseShakeView.getRotatCount() > 0)) {
                return true;
            }
        } else {
            AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeView2 = this.f12522n.getAliaseShakeView();
            if (this.f12522n.getAliaseShakeView() != null && aliaseShakeView2.getPassivationTime() > 0 && (aliaseShakeView2.getShakeCount() > 0 || aliaseShakeView2.getRotatCount() > 0)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: a */
    public void mo46196a(Message message) {
        EventBean eventBean = this.f11795b;
        if (eventBean != null) {
            eventBean.m48905i(String.valueOf(message.obj));
            this.f11795b.m48897m(String.valueOf(message.obj));
            m47929au();
            m47993B();
        }
    }

    /* renamed from: a */
    private void m46606a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        final AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = shakeViewBean != null ? shakeViewBean : this.f12522n;
        AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean = this.f12507W;
        if (coolShakeViewBean == null) {
            if (m46559b(shakeViewBean)) {
                AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeView = shakeViewBean2.getAliaseShakeView();
                if (aliaseShakeView != null) {
                    this.f12512ab.m48353a(aliaseShakeView);
                    new Handler().postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.b.7
                        @Override // java.lang.Runnable
                        public void run() {
                            BeiZiSplashWorker.this.f12509Y = true;
                            BeiZiSplashWorker.this.f12512ab.m48351a(shakeViewBean2);
                        }
                    }, RandomUtils.m48436b(aliaseShakeView.getPassivationTime()));
                    return;
                }
                return;
            }
            this.f12509Y = true;
            this.f12512ab.m48351a(shakeViewBean2);
        } else if (m46560b(coolShakeViewBean.getCoolTime())) {
            this.f12510Z = this.f12507W.getFeedback();
            this.f12512ab.m48352a(this.f12507W);
        } else if (m46552c(this.f12507W.getUserProtectTime())) {
            this.f12510Z = this.f12507W.getFeedback();
            this.f12512ab.m48352a(this.f12507W);
        } else if (m46559b(shakeViewBean)) {
            AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeView2 = shakeViewBean2.getAliaseShakeView();
            if (aliaseShakeView2 != null) {
                this.f12512ab.m48353a(aliaseShakeView2);
                new Handler().postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        BeiZiSplashWorker.this.f12509Y = true;
                        BeiZiSplashWorker.this.f12512ab.m48351a(shakeViewBean2);
                    }
                }, RandomUtils.m48436b(aliaseShakeView2.getPassivationTime()));
            }
        } else {
            this.f12509Y = true;
            this.f12512ab.m48351a(shakeViewBean2);
        }
    }

    /* renamed from: b */
    private AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean m46553b(List<AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean> list, String str) {
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

    @Override // com.beizi.fusion.p072g.C3133ar.InterfaceC3136a
    /* renamed from: b */
    public void mo46561b() {
        if (this.f12509Y && this.f12507W != null) {
            C3137at.m48315a(this.f12527s, this.f12508X, Long.valueOf(System.currentTimeMillis()));
        }
        this.f12511aa = "shake";
        this.f11795b.m48938O("shake");
        m47929au();
        C3116af.m48496a("BeiZis", "enter onShakeHappened  ");
        m46593a("", "", "", "", "", "", "", "", 2);
    }

    @Override // com.beizi.fusion.p072g.ScrollClickUtil.InterfaceC3132a
    /* renamed from: b */
    public void mo46554b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.f12511aa = "scroll";
        this.f11795b.m48938O("scroll");
        m47929au();
        C3116af.m48496a("BeiZis", "enter onScrollDistanceMeetByPosition ");
        m46593a(str, str2, str3, str4, str5, str6, str7, str8, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean m46547d(List<AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean> list, String str) {
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

    /* renamed from: a */
    private void m46605a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean, View view) {
        if (this.f12510Z == -1) {
            this.f12510Z = this.f12522n.getFeedback();
            if (shakeViewBean != null) {
                this.f12510Z = shakeViewBean.getFeedback();
            }
        }
        if (this.f12510Z == 0 || view == null || this.f12512ab == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            ShakeArcView shakeArcView = new ShakeArcView(this.f12527s);
            shakeArcView.setLineRadius(5);
            double d = marginLayoutParams.width;
            Double.isNaN(d);
            int i = (int) (d * 0.5d);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i);
            layoutParams2.leftMargin = marginLayoutParams.leftMargin + (((marginLayoutParams.width - i) - 12) / 2);
            double d2 = marginLayoutParams.topMargin;
            double d3 = marginLayoutParams.height;
            Double.isNaN(d3);
            Double.isNaN(d2);
            layoutParams2.topMargin = (int) (d2 + (d3 * 0.08d));
            this.f12531w.addView(shakeArcView, layoutParams2);
            this.f12512ab.m48349a(shakeArcView, this.f12510Z);
        }
    }

    /* renamed from: a */
    private void m46595a(final String str, int i, final ScrollClickUtil.InterfaceC3132a interfaceC3132a) {
        final int m48304a = C3138av.m48304a(this.f12527s, i);
        this.f12530v.setScrollClick(new View.OnTouchListener() { // from class: com.beizi.fusion.work.splash.b.9

            /* renamed from: a */
            float f12560a;

            /* renamed from: b */
            float f12561b;

            /* renamed from: c */
            float f12562c;

            /* renamed from: d */
            float f12563d;

            /* renamed from: e */
            float f12564e;

            /* renamed from: f */
            float f12565f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ScrollClickUtil.InterfaceC3132a interfaceC3132a2;
                ScrollClickUtil.InterfaceC3132a interfaceC3132a3;
                ScrollClickUtil.InterfaceC3132a interfaceC3132a4;
                ScrollClickUtil.InterfaceC3132a interfaceC3132a5;
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f12560a = motionEvent.getX();
                    this.f12561b = motionEvent.getY();
                    this.f12562c = motionEvent.getX();
                    this.f12563d = motionEvent.getY();
                    this.f12564e = motionEvent.getRawX();
                    this.f12565f = motionEvent.getRawY();
                } else if (action == 1) {
                    C3116af.m48495b("ScrollClickUtil", "mCurPosX = " + this.f12562c + ",mCurPosY = " + this.f12563d + ",mPosX = " + this.f12560a + ",mPosY = " + this.f12561b);
                    float f = this.f12563d;
                    float f2 = this.f12561b;
                    if (f - f2 > 0.0f && Math.abs(f - f2) > m48304a) {
                        if (ScrollClickView.DIR_DOWN.equalsIgnoreCase(str) && (interfaceC3132a5 = interfaceC3132a) != null) {
                            interfaceC3132a5.mo46554b(this.f12560a + "", this.f12561b + "", this.f12564e + "", this.f12565f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                        }
                    } else {
                        float f3 = this.f12563d;
                        float f4 = this.f12561b;
                        if (f3 - f4 < 0.0f && Math.abs(f3 - f4) > m48304a) {
                            if ("up".equalsIgnoreCase(str) && (interfaceC3132a4 = interfaceC3132a) != null) {
                                interfaceC3132a4.mo46554b(this.f12560a + "", this.f12561b + "", this.f12564e + "", this.f12565f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                            }
                        } else {
                            float f5 = this.f12562c;
                            float f6 = this.f12560a;
                            if (f5 - f6 < 0.0f && Math.abs(f5 - f6) > m48304a) {
                                if (ScrollClickView.DIR_LEFT.equalsIgnoreCase(str) && (interfaceC3132a3 = interfaceC3132a) != null) {
                                    interfaceC3132a3.mo46554b(this.f12560a + "", this.f12561b + "", this.f12564e + "", this.f12565f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                }
                            } else {
                                float f7 = this.f12562c;
                                float f8 = this.f12560a;
                                if (f7 - f8 > 0.0f && Math.abs(f7 - f8) > m48304a && ScrollClickView.DIR_RIGHT.equalsIgnoreCase(str) && (interfaceC3132a2 = interfaceC3132a) != null) {
                                    interfaceC3132a2.mo46554b(this.f12560a + "", this.f12561b + "", this.f12564e + "", this.f12565f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                }
                            }
                        }
                    }
                } else if (action == 2) {
                    this.f12562c = motionEvent.getX();
                    this.f12563d = motionEvent.getY();
                }
                return true;
            }
        });
    }

    /* renamed from: a */
    private AdSpacesBean.BuyerBean.OrderDataShakeViewBean m46592a(List<AdSpacesBean.BuyerBean.OrderDataShakeViewBean> list, String str) {
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

    @Override // com.beizi.fusion.p072g.C3120am.InterfaceC3123a
    /* renamed from: a */
    public void mo46594a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.f12511aa = "regionalClick";
        this.f11795b.m48938O("regionalClick");
        m47929au();
        C3116af.m48496a("BeiZis", "enter onRegionClickByPosition ");
        m46593a(str, str2, str3, str4, str5, str6, str7, str8, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m46593a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        SplashAd splashAd = this.f12530v;
        if (splashAd != null) {
            splashAd.adClick(str, str2, str3, str4, str5, str6, str7, str8, i);
        }
    }

    /* renamed from: a */
    private void m46607a(AdSpacesBean.BuyerBean.RollViewBean rollViewBean) {
        AdSpacesBean.BuyerBean.CoolRollViewBean coolRollViewBean = this.f12516af;
        if (coolRollViewBean == null) {
            this.f12509Y = true;
            this.f12517ag.m48409a(rollViewBean);
        } else if (m46560b(coolRollViewBean.getCoolTime())) {
            this.f12517ag.m48410a(this.f12516af);
        } else if (m46552c(this.f12516af.getUserProtectTime())) {
            this.f12517ag.m48410a(this.f12516af);
        } else {
            this.f12509Y = true;
            this.f12517ag.m48409a(rollViewBean);
        }
    }
}
