package com.beizi.fusion.work.p083h;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.beizi.fusion.C3025R;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.CoordinateBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.ObserverAdStatus;
import com.beizi.fusion.p066d.AdShowObserver;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.CompeteStatus;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.BeiZiImageUtils;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3133ar;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.p072g.DataConvertUtil;
import com.beizi.fusion.p072g.ScrollClickUtil;
import com.beizi.fusion.widget.ScrollClickView;
import com.beizi.fusion.work.AdWorker;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.h.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BaseUnifiedCustomWorker extends AdWorker implements AdShowObserver {

    /* renamed from: A */
    protected ImageView f12068A;

    /* renamed from: B */
    protected ImageView f12069B;

    /* renamed from: C */
    protected TextView f12070C;

    /* renamed from: D */
    protected TextView f12071D;

    /* renamed from: E */
    protected TextView f12072E;

    /* renamed from: F */
    protected TextView f12073F;

    /* renamed from: G */
    protected TextView f12074G;

    /* renamed from: H */
    protected long f12075H;

    /* renamed from: I */
    protected float f12076I;

    /* renamed from: J */
    protected float f12077J;

    /* renamed from: K */
    protected boolean f12078K = false;

    /* renamed from: L */
    protected boolean f12079L = false;

    /* renamed from: M */
    protected boolean f12080M = false;

    /* renamed from: N */
    protected Context f12081N;

    /* renamed from: O */
    protected Activity f12082O;

    /* renamed from: P */
    protected C3133ar f12083P;

    /* renamed from: Q */
    protected ScrollClickUtil f12084Q;

    /* renamed from: R */
    protected CountDownTimer f12085R;

    /* renamed from: S */
    protected AdSpacesBean.RenderViewBean f12086S;

    /* renamed from: T */
    protected AdSpacesBean.BuyerBean.RenderAds f12087T;

    /* renamed from: U */
    protected List<AdSpacesBean.RenderViewBean> f12088U;

    /* renamed from: V */
    protected List<Pair<String, Integer>> f12089V;

    /* renamed from: n */
    protected View f12090n;

    /* renamed from: o */
    protected View f12091o;

    /* renamed from: p */
    protected View f12092p;

    /* renamed from: q */
    protected ViewGroup f12093q;

    /* renamed from: r */
    protected ViewGroup f12094r;

    /* renamed from: s */
    protected ViewGroup f12095s;

    /* renamed from: t */
    protected ViewGroup f12096t;

    /* renamed from: u */
    protected ViewGroup f12097u;

    /* renamed from: v */
    protected ViewGroup f12098v;

    /* renamed from: w */
    protected ViewGroup f12099w;

    /* renamed from: x */
    protected ViewGroup f12100x;

    /* renamed from: y */
    protected ImageView f12101y;

    /* renamed from: z */
    protected ImageView f12102z;

    public BaseUnifiedCustomWorker(Context context, long j, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager, int i) {
        this.f12081N = context;
        this.f12075H = j;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11804k = i;
        this.f11799f = forwardBean;
        this.f12076I = C3138av.m48286l(context);
        this.f12077J = C3138av.m48285m(context);
        mo47250aH();
        m47917r();
    }

    /* renamed from: aZ */
    private void m47321aZ() {
        List<String> clickView = this.f12087T.getClickView();
        ArrayList arrayList = new ArrayList();
        if (clickView != null && clickView.size() > 0) {
            if (clickView.contains("bg")) {
                arrayList.add(this.f12093q);
                arrayList.add(this.f12095s);
                arrayList.add(this.f12099w);
            } else if (clickView.contains(UMCommonContent.f37822az)) {
                arrayList.add(this.f12095s);
            } else {
                if (clickView.contains(SocializeProtocolConstants.IMAGE)) {
                    arrayList.add(this.f12096t);
                }
                if (clickView.contains("title")) {
                    arrayList.add(this.f12071D);
                }
                if (clickView.contains("desc")) {
                    arrayList.add(this.f12072E);
                }
                if (clickView.contains(RewardPlus.ICON)) {
                    arrayList.add(this.f12068A);
                }
                if (clickView.contains("target")) {
                    arrayList.add(this.f12098v);
                }
            }
        }
        mo47252a(arrayList);
    }

    /* renamed from: b */
    private void m47318b(Activity activity) {
        if (activity == null || this.f12092p == null) {
            return;
        }
        View decorView = activity.getWindow().getDecorView();
        this.f12090n = decorView;
        if (decorView instanceof FrameLayout) {
            C3138av.m48302a(this.f12092p);
            ((FrameLayout) this.f12090n).addView(this.f12092p);
            m47317b(this.f12094r);
        }
    }

    /* renamed from: ba */
    private void m47314ba() {
        ((FrameLayout) this.f12090n).removeView(this.f12092p);
    }

    /* renamed from: c */
    private void m47313c(int i, int i2) {
        m47331a(this.f12096t, this.f12087T.getImageCoordinate(), i, i2);
        mo47245aR();
    }

    /* renamed from: e */
    private void m47310e(int i, int i2) {
        m47331a(this.f12072E, this.f12087T.getDescCoordinate(), i, i2);
        if (TextUtils.isEmpty(mo47243aT())) {
            return;
        }
        this.f12072E.setText(mo47243aT());
    }

    /* renamed from: f */
    private void m47309f(int i, int i2) {
        m47331a(this.f12068A, this.f12087T.getIconCoordinate(), i, i2);
        if (this.f12068A.getVisibility() != 0 || TextUtils.isEmpty(mo47242aU())) {
            return;
        }
        BeiZiImageUtils.m48258a(this.f12081N).m48255a(mo47242aU(), new BeiZiImageUtils.InterfaceC3151a() { // from class: com.beizi.fusion.work.h.a.2
            @Override // com.beizi.fusion.p072g.BeiZiImageUtils.InterfaceC3151a
            /* renamed from: a */
            public void mo47232a() {
            }

            @Override // com.beizi.fusion.p072g.BeiZiImageUtils.InterfaceC3151a
            /* renamed from: a */
            public void mo47231a(Bitmap bitmap) {
                BaseUnifiedCustomWorker.this.f12068A.setImageBitmap(bitmap);
            }
        });
    }

    /* renamed from: g */
    private void m47308g(int i, int i2) {
        m47331a(this.f12098v, this.f12087T.getActionCoordinate(), i, i2);
        if (TextUtils.isEmpty(mo47241aV())) {
            return;
        }
        this.f12073F.setText(mo47241aV());
    }

    /* renamed from: h */
    private void m47307h(int i, int i2) {
        m47331a(this.f12097u, this.f12087T.getCloseCoordinate(), i, i2);
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: a */
    public void mo47063a(Activity activity) {
        try {
            if (this.f12080M) {
                return;
            }
            this.f12080M = true;
            this.f12082O = activity;
            m47318b(activity);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo47252a(List<View> list) {
    }

    /* renamed from: aG */
    public int mo47251aG() {
        return -1;
    }

    /* renamed from: aH */
    public void mo47250aH() {
        if (mo47251aG() == -1) {
            return;
        }
        View inflate = LayoutInflater.from(this.f12081N).inflate(mo47251aG(), (ViewGroup) null);
        this.f12091o = inflate;
        this.f12093q = (ViewGroup) inflate.findViewById(C3025R.C3028id.rl_bg_container);
        this.f12094r = (ViewGroup) this.f12091o.findViewById(C3025R.C3028id.rl_anim_container);
        this.f12095s = (ViewGroup) this.f12091o.findViewById(C3025R.C3028id.rl_container);
        this.f12096t = (ViewGroup) this.f12091o.findViewById(C3025R.C3028id.fl_img_container);
        this.f12101y = (ImageView) this.f12091o.findViewById(C3025R.C3028id.iv_imageview);
        this.f12097u = (ViewGroup) this.f12091o.findViewById(C3025R.C3028id.rl_close);
        this.f12070C = (TextView) this.f12091o.findViewById(C3025R.C3028id.tv_close);
        this.f12102z = (ImageView) this.f12091o.findViewById(C3025R.C3028id.iv_close);
        this.f12071D = (TextView) this.f12091o.findViewById(C3025R.C3028id.tv_title);
        this.f12072E = (TextView) this.f12091o.findViewById(C3025R.C3028id.tv_desc);
        this.f12068A = (ImageView) this.f12091o.findViewById(C3025R.C3028id.iv_icon);
        this.f12098v = (ViewGroup) this.f12091o.findViewById(C3025R.C3028id.rl_action);
        this.f12073F = (TextView) this.f12091o.findViewById(C3025R.C3028id.tv_action);
        this.f12099w = (ViewGroup) this.f12091o.findViewById(C3025R.C3028id.rl_slide_down_container);
        this.f12074G = (TextView) this.f12091o.findViewById(C3025R.C3028id.tv_slide_down_title);
        this.f12069B = (ImageView) this.f12091o.findViewById(C3025R.C3028id.iv_slide_down_arrow);
        this.f12100x = (ViewGroup) this.f12091o.findViewById(C3025R.C3028id.fl_event_container);
    }

    /* renamed from: aI */
    public void mo47249aI() {
    }

    /* renamed from: aJ */
    public void mo47248aJ() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: aK */
    public void m47327aK() {
        Log.d("BeiZis", "showUnifiedCustomAd Callback --> onADClicked()");
        BaseManager baseManager = this.f11797d;
        if (baseManager != null && baseManager.m48668s() != 2) {
            this.f11797d.m48700d(mo46059g());
        }
        if (this.f12079L) {
            return;
        }
        this.f12079L = true;
        m47990E();
        m47941ai();
        if (this.f11804k != 2) {
            m47322aY();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: aL */
    public void m47326aL() {
        Log.d("BeiZis", "showUnifiedCustomAd Callback --> onAdShow()");
        this.f11803j = AdStatus.ADSHOW;
        BaseManager baseManager = this.f11797d;
        if (baseManager != null && baseManager.m48668s() != 2) {
            this.f11797d.m48710b(mo46059g());
        }
        if (this.f12078K) {
            return;
        }
        this.f12078K = true;
        mo46072az();
        m47323aW();
        m47992C();
        m47991D();
        m47942ah();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: aM */
    public void m47325aM() {
        try {
            if (m47970Y()) {
                m47320b();
            } else {
                m47980O();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: aN */
    public void m47324aN() {
        if (this.f12087T != null) {
            m47334a((int) this.f12076I, (int) this.f12077J);
            this.f12102z.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.work.h.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BaseUnifiedCustomWorker.this.mo47247aO();
                }
            });
        }
        this.f12092p = this.f12091o;
        mo47296aP();
    }

    /* renamed from: aO */
    public void mo47247aO() {
    }

    /* renamed from: aP */
    public void mo47296aP() {
    }

    /* renamed from: aQ */
    public void mo47246aQ() {
    }

    /* renamed from: aR */
    public void mo47245aR() {
    }

    /* renamed from: aS */
    public String mo47244aS() {
        return "";
    }

    /* renamed from: aT */
    public String mo47243aT() {
        return "";
    }

    /* renamed from: aU */
    public String mo47242aU() {
        return "";
    }

    /* renamed from: aV */
    public String mo47241aV() {
        return "";
    }

    /* renamed from: aW */
    protected void m47323aW() {
        AdSpacesBean.BuyerBean.RenderAds renderAds;
        if (this.f12070C == null || this.f12102z == null || (renderAds = this.f12087T) == null) {
            return;
        }
        if (renderAds.getAutoClose() == 0 && this.f12087T.getMinTime() == 0) {
            this.f12070C.setVisibility(8);
            this.f12102z.setVisibility(0);
        } else {
            this.f12102z.setVisibility(8);
            this.f12070C.setVisibility(0);
            m47333a(this.f12087T.getAutoClose(), this.f12087T.getMinTime(), this.f12087T.getMaxTime());
        }
        this.f12097u.setVisibility(0);
    }

    /* renamed from: aX */
    public void mo47240aX() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: aY */
    public void m47322aY() {
        Log.d("BeiZis", "UnifiedCustomAd onADClosed()");
        C3133ar c3133ar = this.f12083P;
        if (c3133ar != null) {
            c3133ar.m48341c();
        }
        ScrollClickUtil scrollClickUtil = this.f12084Q;
        if (scrollClickUtil != null) {
            scrollClickUtil.m48373b();
        }
        m47947ac();
        m47988G();
        m47312c(this.f12082O);
    }

    /* renamed from: b */
    public void mo47236b(boolean z) {
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: d */
    public void mo46065d() {
        if (this.f11797d == null || mo47251aG() == -1) {
            return;
        }
        this.f11801h = this.f11798e.getAppId();
        this.f11802i = this.f11798e.getSpaceId();
        this.f11796c = this.f11798e.getBuyerSpaceUuId();
        List<AdSpacesBean.RenderViewBean> renderView = this.f11798e.getRenderView();
        this.f12088U = renderView;
        if (renderView != null && renderView.size() > 0) {
            AdSpacesBean.RenderViewBean renderViewBean = this.f12088U.get(0);
            this.f12086S = renderViewBean;
            this.f12089V = DataConvertUtil.m48220a(renderViewBean.getDpLinkUrlList());
        }
        ObserverAdStatus observerAdStatus = this.f11794a;
        if (observerAdStatus != null) {
            EventBean m48977a = observerAdStatus.m48860a().m48977a(this.f11796c);
            this.f11795b = m48977a;
            if (m48977a != null) {
                m47916s();
                mo47249aI();
            }
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: f */
    public void mo46061f() {
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "";
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: l */
    public void mo46050l() {
        m47912w();
        m47943ag();
        this.f12087T = this.f11798e.getRenderAds();
        mo47248aJ();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: m */
    public void mo46173m() {
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: o */
    public View mo46446o() {
        return this.f12092p;
    }

    /* renamed from: i */
    private void m47306i(int i, int i2) {
        m47316b(this.f12099w, this.f12087T.getScrollCoordinate(), i, i2);
    }

    /* renamed from: c */
    private void m47312c(Activity activity) {
        if (activity != null) {
            if (this.f12090n == null) {
                this.f12090n = activity.getWindow().getDecorView();
            }
            if (this.f12090n instanceof FrameLayout) {
                m47314ba();
            }
        }
        mo46173m();
    }

    /* renamed from: a */
    private void m47334a(int i, int i2) {
        m47331a(this.f12093q, this.f12087T.getBgCoordinate(), i, i2);
        int i3 = this.f12093q.getLayoutParams().width;
        int i4 = this.f12093q.getLayoutParams().height;
        m47319b(i3, i4);
        m47306i(i3, i4);
    }

    /* renamed from: b */
    private void m47317b(View view) {
        if (view != null) {
            view.setVisibility(8);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(500L);
            view.setVisibility(0);
            view.startAnimation(translateAnimation);
        }
    }

    /* renamed from: a */
    private void m47333a(final int i, final int i2, final int i3) {
        CountDownTimer countDownTimer = this.f12085R;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(600 + (i3 * 1000), 1000L) { // from class: com.beizi.fusion.work.h.a.3
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (i == 1) {
                    BaseUnifiedCustomWorker.this.m47322aY();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                BaseUnifiedCustomWorker baseUnifiedCustomWorker = BaseUnifiedCustomWorker.this;
                TextView textView = baseUnifiedCustomWorker.f12070C;
                if (textView == null || baseUnifiedCustomWorker.f12102z == null) {
                    return;
                }
                int i4 = (int) (((float) j) / 1000.0f);
                if (i3 - i4 >= i2) {
                    textView.setVisibility(8);
                    BaseUnifiedCustomWorker.this.f12102z.setVisibility(0);
                    return;
                }
                textView.setText(String.valueOf(i4));
            }
        };
        this.f12085R = countDownTimer2;
        countDownTimer2.start();
    }

    /* renamed from: b */
    private void m47320b() {
        BaseManager baseManager = this.f11797d;
        if (baseManager == null) {
            return;
        }
        Map<String, AdWorker> m48669r = baseManager.m48669r();
        Log.d("BeiZis", mo46059g() + " NativeAdWorker:" + m48669r.toString());
        m47969Z();
        CompeteStatus competeStatus = this.f11800g;
        if (competeStatus == CompeteStatus.SUCCESS) {
            mo47240aX();
            if (this.f12092p != null) {
                this.f11797d.m48726a(mo46059g(), this.f12092p);
            } else {
                this.f11797d.m48754a(10140);
            }
        } else if (competeStatus == CompeteStatus.FAIL) {
            Log.d("BeiZis", "other worker shown," + mo46059g() + " remove");
        }
    }

    /* renamed from: d */
    private void m47311d(int i, int i2) {
        m47331a(this.f12071D, this.f12087T.getTitleCoordinate(), i, i2);
        if (TextUtils.isEmpty(mo47244aS())) {
            return;
        }
        this.f12071D.setText(mo47244aS());
    }

    /* renamed from: a */
    private void m47331a(View view, String str, int i, int i2) {
        RelativeLayout.LayoutParams layoutParams;
        boolean z;
        if (view == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            view.setVisibility(8);
        } else if (str.equals("-1:-1:-1:-1:-1:-1:-1:-1:-1")) {
            view.setVisibility(8);
        } else {
            CoordinateBean coordinate = CoordinateBean.getCoordinate(str);
            if (coordinate == null) {
                view.setVisibility(8);
                return;
            }
            int[] m47329a = m47329a(coordinate, i, i2);
            int[] m47328a = m47328a(coordinate, i, i2, m47329a);
            boolean z2 = view instanceof TextView;
            if (z2) {
                layoutParams = new RelativeLayout.LayoutParams(m47328a[0], -2);
            } else {
                layoutParams = new RelativeLayout.LayoutParams(m47328a[0], m47328a[1]);
            }
            layoutParams.setMargins(m47329a[0], m47329a[1], m47329a[2], m47329a[3]);
            if (!coordinate.getTop().equals("-1") || coordinate.getBottom().equals("-1")) {
                z = false;
            } else {
                layoutParams.addRule(12, -1);
                z = true;
            }
            if (coordinate.getLeft().equals("-1") && !coordinate.getRight().equals("-1")) {
                layoutParams.addRule(11, -1);
            }
            view.setLayoutParams(layoutParams);
            if (!coordinate.getFontOrCorner().equals("-1")) {
                if (z2) {
                    ((TextView) view).setTextSize(Float.parseFloat(coordinate.getFontOrCorner()));
                } else if (view.getBackground() instanceof GradientDrawable) {
                    GradientDrawable gradientDrawable = (GradientDrawable) view.getBackground();
                    if (view != this.f12097u && view != this.f12098v) {
                        int m48304a = C3138av.m48304a(this.f12081N, Float.parseFloat(coordinate.getFontOrCorner()));
                        if (z) {
                            float f = m48304a;
                            gradientDrawable.setCornerRadii(new float[]{f, f, f, f, 0.0f, 0.0f, 0.0f, 0.0f});
                        } else {
                            gradientDrawable.setCornerRadius(m48304a);
                        }
                    } else {
                        gradientDrawable.setCornerRadius(m47328a[1]);
                    }
                }
            }
            if (coordinate.getColor().equals("-1")) {
                return;
            }
            if (z2) {
                ((TextView) view).setTextColor(Color.parseColor(coordinate.getColor()));
            } else if (view != this.f12100x) {
                if (view.getBackground() instanceof GradientDrawable) {
                    ((GradientDrawable) view.getBackground()).setColor(Color.parseColor(coordinate.getColor()));
                } else {
                    view.setBackgroundColor(Color.parseColor(coordinate.getColor()));
                }
            }
        }
    }

    /* renamed from: b */
    private void m47319b(int i, int i2) {
        String adCoordinate = this.f12087T.getAdCoordinate();
        m47331a(this.f12095s, adCoordinate, i, i2);
        m47331a(this.f12100x, adCoordinate, i, i2);
        int i3 = this.f12095s.getLayoutParams().width;
        int i4 = this.f12095s.getLayoutParams().height;
        m47313c(i3, i4);
        m47311d(i3, i4);
        m47310e(i3, i4);
        m47309f(i3, i4);
        m47308g(i3, i4);
        m47307h(i3, i4);
        mo47246aQ();
        m47321aZ();
    }

    /* renamed from: b */
    private int m47315b(String str, int i) {
        if (str.contains("%")) {
            return (i * ((int) Float.parseFloat(str.substring(0, str.indexOf("%"))))) / 100;
        }
        return C3138av.m48304a(this.f12081N, Float.parseFloat(str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0145, code lost:
        if (r2 <= 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0170, code lost:
        if (r3 <= 0) goto L59;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x027b  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m47316b(android.view.View r18, java.lang.String r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 740
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker.m47316b(android.view.View, java.lang.String, int, int):void");
    }

    /* renamed from: a */
    private int[] m47328a(CoordinateBean coordinateBean, int i, int i2, int[] iArr) {
        int m47315b;
        int m47315b2;
        int[] iArr2 = new int[2];
        if (coordinateBean.getWidth().equals("-1")) {
            m47315b = (i - iArr[0]) - iArr[2];
        } else {
            m47315b = m47315b(coordinateBean.getWidth(), i);
        }
        if (!coordinateBean.getScale().equals("-1") && !coordinateBean.getScale().equals("0")) {
            m47315b2 = (int) (m47315b / Float.parseFloat(coordinateBean.getScale()));
        } else if (coordinateBean.getHeight().equals("-1")) {
            m47315b2 = (i2 - iArr[1]) - iArr[3];
        } else {
            m47315b2 = m47315b(coordinateBean.getHeight(), i2);
        }
        iArr2[0] = m47315b;
        iArr2[1] = m47315b2;
        return iArr2;
    }

    /* renamed from: a */
    private int[] m47329a(CoordinateBean coordinateBean, int i, int i2) {
        int[] iArr = new int[4];
        String left = coordinateBean.getLeft();
        int m47315b = (left.equals("0%") || left.equals("0") || left.equals("-1")) ? 0 : m47315b(left, i);
        String top2 = coordinateBean.getTop();
        int m47315b2 = (top2.equals("0%") || top2.equals("0") || top2.equals("-1")) ? 0 : m47315b(top2, i2);
        String right = coordinateBean.getRight();
        int m47315b3 = (right.equals("0%") || right.equals("0") || right.equals("-1")) ? 0 : m47315b(right, i);
        String bottom = coordinateBean.getBottom();
        int m47315b4 = (bottom.equals("0%") || bottom.equals("0") || bottom.equals("-1")) ? 0 : m47315b(bottom, i2);
        iArr[0] = m47315b;
        iArr[1] = m47315b2;
        iArr[2] = m47315b3;
        iArr[3] = m47315b4;
        return iArr;
    }

    /* renamed from: a */
    protected void m47332a(View view) {
        m47330a(view, "", 30, (ScrollClickUtil.InterfaceC3132a) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: a */
    public void m47330a(View view, final String str, int i, final ScrollClickUtil.InterfaceC3132a interfaceC3132a) {
        final int m48304a = C3138av.m48304a(this.f12081N, i);
        final boolean z = view == this.f12093q;
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.h.a.4

            /* renamed from: a */
            float f12109a;

            /* renamed from: b */
            float f12110b;

            /* renamed from: c */
            float f12111c;

            /* renamed from: d */
            float f12112d;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                ScrollClickUtil.InterfaceC3132a interfaceC3132a2;
                ScrollClickUtil.InterfaceC3132a interfaceC3132a3;
                ScrollClickUtil.InterfaceC3132a interfaceC3132a4;
                ScrollClickUtil.InterfaceC3132a interfaceC3132a5;
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f12109a = motionEvent.getX();
                    this.f12110b = motionEvent.getY();
                    this.f12111c = motionEvent.getX();
                    this.f12112d = motionEvent.getY();
                    if (z) {
                        BaseUnifiedCustomWorker.this.f12093q.onTouchEvent(motionEvent);
                    } else {
                        BaseUnifiedCustomWorker.this.f12095s.dispatchTouchEvent(motionEvent);
                    }
                } else if (action == 1) {
                    C3116af.m48495b("SlideClickUtil", "mCurPosX = " + this.f12111c + ",mCurPosY = " + this.f12112d + ",mPosX = " + this.f12109a + ",mPosY = " + this.f12110b);
                    float f = this.f12112d;
                    float f2 = this.f12110b;
                    int i2 = m48304a;
                    if (f - f2 > i2) {
                        if (!TextUtils.isEmpty(BaseUnifiedCustomWorker.this.f12087T.getScrollCoordinate()) && !BaseUnifiedCustomWorker.this.f12087T.getScrollCoordinate().equals("-1:-1:-1:-1:-1:-1:-1:-1:-1")) {
                            BaseUnifiedCustomWorker.this.mo47236b(z);
                        } else if (ScrollClickView.DIR_DOWN.equalsIgnoreCase(str) && (interfaceC3132a5 = interfaceC3132a) != null) {
                            interfaceC3132a5.mo46549c_();
                        }
                    } else if (f2 - f > i2) {
                        if ("up".equalsIgnoreCase(str) && (interfaceC3132a4 = interfaceC3132a) != null) {
                            interfaceC3132a4.mo46549c_();
                        }
                    } else {
                        float f3 = this.f12109a;
                        float f4 = this.f12111c;
                        if (f3 - f4 > i2) {
                            if (ScrollClickView.DIR_LEFT.equalsIgnoreCase(str) && (interfaceC3132a3 = interfaceC3132a) != null) {
                                interfaceC3132a3.mo46549c_();
                            }
                        } else if (f4 - f3 > i2) {
                            if (ScrollClickView.DIR_RIGHT.equalsIgnoreCase(str) && (interfaceC3132a2 = interfaceC3132a) != null) {
                                interfaceC3132a2.mo46549c_();
                            }
                        } else if (z) {
                            BaseUnifiedCustomWorker.this.f12093q.onTouchEvent(motionEvent);
                        } else {
                            BaseUnifiedCustomWorker.this.f12095s.dispatchTouchEvent(motionEvent);
                        }
                    }
                } else if (action == 2) {
                    this.f12111c = motionEvent.getX();
                    this.f12112d = motionEvent.getY();
                }
                return true;
            }
        });
    }
}
