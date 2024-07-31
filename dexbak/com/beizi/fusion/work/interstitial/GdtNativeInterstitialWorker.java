package com.beizi.fusion.work.interstitial;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.ObserverAdStatus;
import com.beizi.fusion.p066d.AdShowObserver;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.CompeteStatus;
import com.beizi.fusion.p066d.GDTAdManagerHolder;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.p072g.CheckDirectDownload;
import com.beizi.fusion.p072g.DownloadConfirmHelper;
import com.beizi.fusion.p072g.PriceUtil;
import com.beizi.fusion.work.AdWorker;
import com.beizi.fusion.work.interstitial.GdtNativeInterstitialCustomLayout;
import com.p518qq.p519e.ads.nativ.NativeADEventListener;
import com.p518qq.p519e.ads.nativ.NativeADMediaListener;
import com.p518qq.p519e.ads.nativ.NativeADUnifiedListener;
import com.p518qq.p519e.ads.nativ.NativeUnifiedAD;
import com.p518qq.p519e.ads.nativ.NativeUnifiedADData;
import com.p518qq.p519e.comm.constants.ErrorCode;
import com.p518qq.p519e.comm.managers.status.SDKStatus;
import com.p518qq.p519e.comm.util.AdError;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.interstitial.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GdtNativeInterstitialWorker extends AdWorker implements AdShowObserver, GdtNativeInterstitialCustomLayout.InterfaceC3356a {

    /* renamed from: A */
    private CountDownTimer f12213A;

    /* renamed from: C */
    private Activity f12215C;

    /* renamed from: D */
    private AdSpacesBean.RenderViewBean f12216D;

    /* renamed from: n */
    View f12218n;

    /* renamed from: o */
    TextView f12219o;

    /* renamed from: p */
    RelativeLayout f12220p;

    /* renamed from: q */
    private Context f12221q;

    /* renamed from: r */
    private String f12222r;

    /* renamed from: s */
    private long f12223s;

    /* renamed from: t */
    private long f12224t;

    /* renamed from: u */
    private boolean f12225u;

    /* renamed from: v */
    private NativeUnifiedAD f12226v;

    /* renamed from: w */
    private NativeUnifiedADData f12227w;

    /* renamed from: x */
    private float f12228x;

    /* renamed from: y */
    private float f12229y;

    /* renamed from: z */
    private FrameLayout f12230z;

    /* renamed from: B */
    private long f12214B = 5000;

    /* renamed from: E */
    private boolean f12217E = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GdtNativeInterstitialWorker.java */
    /* renamed from: com.beizi.fusion.work.interstitial.d$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3371a implements NativeADUnifiedListener {
        private C3371a() {
        }

        @Override // com.p518qq.p519e.ads.nativ.NativeADUnifiedListener
        public void onADLoaded(List<NativeUnifiedADData> list) {
            Log.d("BeiZis", "ShowGdtInterstitialCustom onADLoaded()");
            ((AdWorker) GdtNativeInterstitialWorker.this).f11803j = AdStatus.ADLOAD;
            GdtNativeInterstitialWorker.this.m47910y();
            if (list == null || list.size() == 0) {
                GdtNativeInterstitialWorker.this.m47921c(-991);
                return;
            }
            GdtNativeInterstitialWorker.this.f12227w = list.get(0);
            if (GdtNativeInterstitialWorker.this.f12227w == null) {
                GdtNativeInterstitialWorker.this.m47921c(-991);
                return;
            }
            if (GdtNativeInterstitialWorker.this.f12227w.getECPM() > 0) {
                GdtNativeInterstitialWorker gdtNativeInterstitialWorker = GdtNativeInterstitialWorker.this;
                gdtNativeInterstitialWorker.m47967a(gdtNativeInterstitialWorker.f12227w.getECPM());
            }
            if (DownloadConfirmHelper.f11427a) {
                GdtNativeInterstitialWorker.this.f12227w.setDownloadConfirmListener(DownloadConfirmHelper.f11428b);
            }
            NativeADEventListener nativeADEventListener = new NativeADEventListener() { // from class: com.beizi.fusion.work.interstitial.d.a.1

                /* renamed from: a */
                boolean f12234a = false;

                /* renamed from: b */
                boolean f12235b = false;

                @Override // com.p518qq.p519e.ads.nativ.NativeADEventListener
                public void onADClicked() {
                    Log.d("BeiZis", "ShowGdtInterstitialCustom onADClicked()");
                    if (((AdWorker) GdtNativeInterstitialWorker.this).f11797d != null && ((AdWorker) GdtNativeInterstitialWorker.this).f11797d.m48668s() != 2) {
                        ((AdWorker) GdtNativeInterstitialWorker.this).f11797d.m48700d(GdtNativeInterstitialWorker.this.mo46059g());
                    }
                    if (this.f12235b) {
                        return;
                    }
                    this.f12235b = true;
                    GdtNativeInterstitialWorker.this.m47990E();
                    GdtNativeInterstitialWorker.this.m47941ai();
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeADEventListener
                public void onADError(AdError adError) {
                    Log.d("BeiZis", "ShowGdtInterstitialCustom onADError: " + adError.getErrorMsg());
                    GdtNativeInterstitialWorker.this.m47961a(adError.getErrorMsg(), adError.getErrorCode());
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeADEventListener
                public void onADExposed() {
                    Log.d("BeiZis", "ShowGdtInterstitialCustom onExposed()");
                    ((AdWorker) GdtNativeInterstitialWorker.this).f11803j = AdStatus.ADSHOW;
                    if (((AdWorker) GdtNativeInterstitialWorker.this).f11797d != null && ((AdWorker) GdtNativeInterstitialWorker.this).f11797d.m48668s() != 2) {
                        ((AdWorker) GdtNativeInterstitialWorker.this).f11797d.m48710b(GdtNativeInterstitialWorker.this.mo46059g());
                    }
                    if (this.f12234a) {
                        return;
                    }
                    this.f12234a = true;
                    GdtNativeInterstitialWorker.this.mo46072az();
                    GdtNativeInterstitialWorker.this.m47992C();
                    GdtNativeInterstitialWorker.this.m47991D();
                    GdtNativeInterstitialWorker.this.m47942ah();
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeADEventListener
                public void onADStatusChanged() {
                    C3116af.m48496a("BeiZis", "ShowGdtInterstitialCustom onADStatusChanged()");
                }
            };
            NativeADMediaListener nativeADMediaListener = new NativeADMediaListener() { // from class: com.beizi.fusion.work.interstitial.d.a.2

                /* renamed from: a */
                boolean f12237a = false;

                @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
                public void onVideoClicked() {
                    Log.d("BeiZis", "ShowGdtInterstitialCustom MediaView onVideoClicked()");
                    if (((AdWorker) GdtNativeInterstitialWorker.this).f11797d != null && ((AdWorker) GdtNativeInterstitialWorker.this).f11797d.m48668s() != 2) {
                        ((AdWorker) GdtNativeInterstitialWorker.this).f11797d.m48700d(GdtNativeInterstitialWorker.this.mo46059g());
                    }
                    if (this.f12237a) {
                        return;
                    }
                    this.f12237a = true;
                    GdtNativeInterstitialWorker.this.m47990E();
                    GdtNativeInterstitialWorker.this.m47941ai();
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
                public void onVideoCompleted() {
                    Log.d("BeiZis", "ShowGdtInterstitialCustom MediaView onVideoCompleted()");
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
                public void onVideoError(AdError adError) {
                    Log.d("BeiZis", "ShowGdtInterstitialCustom MediaView onVideoError: " + adError.getErrorMsg());
                    GdtNativeInterstitialWorker.this.m47961a(adError.getErrorMsg(), adError.getErrorCode());
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
                public void onVideoInit() {
                    Log.d("BeiZis", "ShowGdtInterstitialCustom MediaView onVideoInit()");
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
                public void onVideoLoaded(int i) {
                    Log.d("BeiZis", "ShowGdtInterstitialCustom MediaView onVideoLoaded()");
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
                public void onVideoLoading() {
                    Log.d("BeiZis", "ShowGdtInterstitialCustom MediaView onVideoLoading()");
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
                public void onVideoPause() {
                    Log.d("BeiZis", "ShowGdtInterstitialCustom MediaView onVideoPause()");
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
                public void onVideoReady() {
                    Log.d("BeiZis", "ShowGdtInterstitialCustom MediaView onVideoReady()");
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
                public void onVideoResume() {
                    Log.d("BeiZis", "ShowGdtInterstitialCustom MediaView onVideoResume()");
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
                public void onVideoStart() {
                    Log.d("BeiZis", "ShowGdtInterstitialCustom MediaView onVideoStart()");
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
                public void onVideoStop() {
                    Log.d("BeiZis", "ShowGdtInterstitialCustom MediaView onVideoStop()");
                }
            };
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.beizi.fusion.work.interstitial.d.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Log.d("BeiZis", "ShowGdtInterstitialCustom onADClosed()");
                    GdtNativeInterstitialWorker.this.m47987H();
                    GdtNativeInterstitialWorker.this.m47101aL();
                }
            };
            GdtNativeInterstitialCustomLayout gdtNativeInterstitialCustomLayout = new GdtNativeInterstitialCustomLayout(GdtNativeInterstitialWorker.this.f12221q);
            gdtNativeInterstitialCustomLayout.setViewInteractionListener(GdtNativeInterstitialWorker.this);
            boolean onBindData = gdtNativeInterstitialCustomLayout.onBindData(GdtNativeInterstitialWorker.this.f12227w, GdtNativeInterstitialWorker.this.f12228x, GdtNativeInterstitialWorker.this.f12229y, GdtNativeInterstitialWorker.this.f12216D, nativeADEventListener, nativeADMediaListener, onClickListener);
            if (GdtNativeInterstitialWorker.this.f12227w.getAdPatternType() == 2 && GdtNativeInterstitialWorker.this.f12216D != null && GdtNativeInterstitialWorker.this.f12216D.getVideoSkipTime() > 0) {
                GdtNativeInterstitialWorker gdtNativeInterstitialWorker2 = GdtNativeInterstitialWorker.this;
                gdtNativeInterstitialWorker2.f12214B = gdtNativeInterstitialWorker2.f12216D.getVideoSkipTime();
            }
            if (onBindData) {
                GdtNativeInterstitialWorker.this.f12230z = gdtNativeInterstitialCustomLayout;
                GdtNativeInterstitialWorker.this.m47103aJ();
                return;
            }
            GdtNativeInterstitialWorker gdtNativeInterstitialWorker3 = GdtNativeInterstitialWorker.this;
            gdtNativeInterstitialWorker3.m47961a("sdk custom error ".concat(gdtNativeInterstitialWorker3.mo46059g()).concat(" ").concat("create view error"), 10140);
        }

        @Override // com.p518qq.p519e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            Log.d("BeiZis", "ShowGdtInterstitialCustom onNoAD: " + adError.getErrorMsg());
            GdtNativeInterstitialWorker.this.m47961a(adError.getErrorMsg(), adError.getErrorCode());
        }
    }

    public GdtNativeInterstitialWorker(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager) {
        this.f12221q = context;
        this.f12222r = str;
        this.f12223s = j;
        this.f12224t = j2;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        int sizeRatio = buyerBean.getSizeRatio();
        float m48288j = C3138av.m48288j(context) * 0.8f;
        this.f12228x = m48288j;
        this.f12229y = sizeRatio == 1 ? (m48288j * 16.0f) / 9.0f : (m48288j * 9.0f) / 16.0f;
        C3116af.m48496a("BeiZis", "interstitial mAdWidthDp = " + this.f12228x + ",mAdHeightDp = " + this.f12229y);
        m47917r();
    }

    /* renamed from: aG */
    private void m47106aG() {
        TextView textView = new TextView(this.f12221q);
        this.f12219o = textView;
        textView.setTextColor(this.f12221q.getResources().getColor(17170443));
        this.f12219o.setTextSize(2, 14.0f);
        m47086e((int) (this.f12214B / 1000));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(2, ErrorCode.ServerError.OS_TYPE_ERROR);
        layoutParams.addRule(7, ErrorCode.ServerError.OS_TYPE_ERROR);
        layoutParams.bottomMargin = C3138av.m48304a(this.f12221q, 3.0f);
        RelativeLayout relativeLayout = this.f12220p;
        if (relativeLayout != null) {
            relativeLayout.addView(this.f12219o, layoutParams);
        }
    }

    /* renamed from: aH */
    private void m47105aH() {
        ((FrameLayout) this.f12218n).removeView(this.f12220p);
    }

    /* renamed from: aI */
    private void m47104aI() {
        BaseManager baseManager = this.f11797d;
        if (baseManager == null) {
            return;
        }
        Map<String, AdWorker> m48669r = baseManager.m48669r();
        Log.d("BeiZis", mo46059g() + " NativeAdWorker:" + m48669r.toString());
        m47969Z();
        CompeteStatus competeStatus = this.f11800g;
        if (competeStatus == CompeteStatus.SUCCESS) {
            if (this.f12230z != null) {
                this.f11797d.m48726a(mo46059g(), this.f12230z);
            } else {
                this.f11797d.m48754a(10140);
            }
        } else if (competeStatus == CompeteStatus.FAIL) {
            Log.d("BeiZis", "other worker shown," + mo46059g() + " remove");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aJ */
    public void m47103aJ() {
        if (m47970Y()) {
            m47104aI();
        } else {
            m47980O();
        }
    }

    /* renamed from: aK */
    private void m47102aK() {
        CountDownTimer countDownTimer = this.f12213A;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(100 + this.f12214B, 50L) { // from class: com.beizi.fusion.work.interstitial.d.2
            @Override // android.os.CountDownTimer
            public void onFinish() {
                GdtNativeInterstitialWorker.this.m47101aL();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (((AdWorker) GdtNativeInterstitialWorker.this).f11797d != null && ((AdWorker) GdtNativeInterstitialWorker.this).f11797d.m48668s() != 2) {
                    ((AdWorker) GdtNativeInterstitialWorker.this).f11797d.m48752a(j);
                }
                GdtNativeInterstitialWorker.this.m47086e((int) (((float) j) / 1000.0f));
            }
        };
        this.f12213A = countDownTimer2;
        countDownTimer2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aL */
    public void m47101aL() {
        m47947ac();
        m47988G();
        m47093c(this.f12215C);
    }

    @Override // com.beizi.fusion.work.interstitial.GdtNativeInterstitialCustomLayout.InterfaceC3356a
    /* renamed from: a_ */
    public void mo47100a_() {
        mo46703n();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: az */
    public void mo46072az() {
        NativeUnifiedADData nativeUnifiedADData = this.f12227w;
        if (nativeUnifiedADData == null || nativeUnifiedADData.getECPM() <= 0 || this.f12225u) {
            return;
        }
        this.f12225u = true;
        C3116af.m48496a("BeiZis", "channel == GDT竞价成功");
        C3116af.m48496a("BeiZis", "channel == sendWinNoticeECPM" + this.f12227w.getECPM());
        NativeUnifiedADData nativeUnifiedADData2 = this.f12227w;
        GDTAdManagerHolder.m48636a(nativeUnifiedADData2, nativeUnifiedADData2.getECPM());
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: f */
    public void mo46061f() {
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "GDT";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m47086e(int i) {
        if (this.f12219o == null) {
            return;
        }
        int i2 = 1;
        String format = String.format(Locale.CHINA, "广告%d秒后自动关闭", Integer.valueOf(i));
        if (i >= 10 && i <= 99) {
            i2 = 2;
        }
        String valueOf = String.valueOf(i);
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#ffffff")), 0, format.indexOf(valueOf), 17);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#ffffff")), format.indexOf(valueOf) + i2, format.length(), 17);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#ff9933")), format.indexOf(valueOf), format.indexOf(valueOf) + i2, 17);
        this.f12219o.setText(spannableString);
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: A */
    protected void mo46197A() {
        if (!m47909z() || this.f12227w == null) {
            return;
        }
        m47938al();
        int m48440a = PriceUtil.m48440a(this.f11798e.getPriceDict(), this.f12227w.getECPMLevel());
        if (m48440a == -1 || m48440a == -2) {
            if (m48440a == -2) {
                m47983L();
                return;
            }
            return;
        }
        Log.d("BeiZisBid", "gdt realPrice = " + m48440a);
        m47967a((double) m48440a);
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: i */
    public AdStatus mo46056i() {
        return this.f11803j;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: j */
    public String mo46054j() {
        NativeUnifiedADData nativeUnifiedADData = this.f12227w;
        if (nativeUnifiedADData != null) {
            int m48440a = PriceUtil.m48440a(this.f11798e.getPriceDict(), nativeUnifiedADData.getECPMLevel());
            if (m48440a == -1 || m48440a == -2) {
                return null;
            }
            return m48440a + "";
        }
        return null;
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
        if (this.f12228x <= 0.0f) {
            this.f12228x = C3138av.m48288j(this.f12221q);
        }
        if (this.f12229y <= 0.0f) {
            this.f12229y = 0.0f;
        }
        if ("S2S".equalsIgnoreCase(this.f11798e.getBidType())) {
            this.f12226v = new NativeUnifiedAD(this.f12221q, this.f11802i, new C3371a(), m47957aC());
        } else {
            this.f12226v = new NativeUnifiedAD(this.f12221q, this.f11802i, new C3371a());
        }
        this.f12226v.loadData(1);
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: m */
    public void mo46173m() {
        NativeUnifiedADData nativeUnifiedADData = this.f12227w;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.destroy();
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: n */
    public void mo46703n() {
        NativeUnifiedADData nativeUnifiedADData = this.f12227w;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.resume();
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: o */
    public View mo46446o() {
        return this.f12230z;
    }

    /* renamed from: c */
    private void m47093c(Activity activity) {
        if (activity != null) {
            if (this.f12218n == null) {
                this.f12218n = activity.getWindow().getDecorView();
            }
            if (this.f12218n instanceof FrameLayout) {
                m47105aH();
            }
        }
        mo46173m();
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
        List<AdSpacesBean.RenderViewBean> renderView = this.f11798e.getRenderView();
        if (renderView != null && renderView.size() > 0) {
            AdSpacesBean.RenderViewBean renderViewBean = renderView.get(0);
            this.f12216D = renderViewBean;
            this.f12214B = renderViewBean.getPicSkipTime() > 0 ? this.f12216D.getPicSkipTime() : this.f12214B;
        }
        ObserverAdStatus observerAdStatus = this.f11794a;
        if (observerAdStatus != null) {
            EventBean m48977a = observerAdStatus.m48860a().m48977a(this.f11796c);
            this.f11795b = m48977a;
            if (m48977a != null) {
                m47916s();
                if (!C3138av.m48301a("com.qq.e.comm.managers.GDTAdSdk")) {
                    m47915t();
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.interstitial.d.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GdtNativeInterstitialWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "GDT sdk not import , will do nothing");
                    return;
                }
                m47914u();
                GDTAdManagerHolder.m48638a(this.f12221q, this.f11801h);
                this.f11795b.m48885s(SDKStatus.getIntegrationSDKVersion());
                m47929au();
                m47913v();
            }
        }
        DownloadConfirmHelper.f11427a = !CheckDirectDownload.m48236a(this.f11798e.getDirectDownload());
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + this.f12224t);
        long j = this.f12224t;
        if (j > 0) {
            this.f11806m.sendEmptyMessageDelayed(1, j);
            return;
        }
        BaseManager baseManager = this.f11797d;
        if (baseManager == null || baseManager.m48667t() >= 1 || this.f11797d.m48668s() == 2) {
            return;
        }
        mo46050l();
    }

    /* renamed from: b */
    private void m47098b(Activity activity) {
        if (activity != null) {
            View decorView = activity.getWindow().getDecorView();
            this.f12218n = decorView;
            if (decorView instanceof FrameLayout) {
                if (this.f12220p != null) {
                    m47105aH();
                }
                RelativeLayout relativeLayout = new RelativeLayout(this.f12221q);
                this.f12220p = relativeLayout;
                relativeLayout.setBackgroundColor(Color.parseColor("#B2000000"));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(13);
                this.f12230z.setId(ErrorCode.ServerError.OS_TYPE_ERROR);
                C3138av.m48302a(this.f12230z);
                this.f12220p.addView(this.f12230z, layoutParams2);
                ((FrameLayout) this.f12218n).addView(this.f12220p, layoutParams);
            }
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: a */
    public void mo47063a(Activity activity) {
        if (this.f12217E) {
            return;
        }
        this.f12217E = true;
        this.f12215C = activity;
        m47098b(activity);
        m47106aG();
        m47102aK();
    }

    @Override // com.beizi.fusion.work.interstitial.GdtNativeInterstitialCustomLayout.InterfaceC3356a
    /* renamed from: b */
    public void mo47099b() {
        m47987H();
        m47101aL();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: d */
    public void mo46064d(int i) {
        NativeUnifiedADData nativeUnifiedADData = this.f12227w;
        if (nativeUnifiedADData == null || nativeUnifiedADData.getECPM() <= 0 || this.f12225u) {
            return;
        }
        this.f12225u = true;
        C3116af.m48496a("BeiZis", "channel == GDT竞价失败:" + i);
        GDTAdManagerHolder.m48634b(this.f12227w, i != 1 ? 10001 : 1);
    }
}
