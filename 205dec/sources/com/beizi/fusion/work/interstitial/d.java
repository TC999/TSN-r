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
import com.beizi.fusion.d.h;
import com.beizi.fusion.d.k;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.al;
import com.beizi.fusion.g.aw;
import com.beizi.fusion.g.n;
import com.beizi.fusion.g.v;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.work.interstitial.GdtNativeInterstitialCustomLayout;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.AdError;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: GdtNativeInterstitialWorker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class d extends com.beizi.fusion.work.a implements com.beizi.fusion.d.c, GdtNativeInterstitialCustomLayout.a {
    private CountDownTimer A;
    private Activity C;
    private AdSpacesBean.RenderViewBean D;

    /* renamed from: n  reason: collision with root package name */
    View f15731n;

    /* renamed from: o  reason: collision with root package name */
    TextView f15732o;

    /* renamed from: p  reason: collision with root package name */
    RelativeLayout f15733p;

    /* renamed from: q  reason: collision with root package name */
    private Context f15734q;

    /* renamed from: r  reason: collision with root package name */
    private String f15735r;

    /* renamed from: s  reason: collision with root package name */
    private long f15736s;

    /* renamed from: t  reason: collision with root package name */
    private long f15737t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f15738u;

    /* renamed from: v  reason: collision with root package name */
    private NativeUnifiedAD f15739v;

    /* renamed from: w  reason: collision with root package name */
    private NativeUnifiedADData f15740w;

    /* renamed from: x  reason: collision with root package name */
    private float f15741x;

    /* renamed from: y  reason: collision with root package name */
    private float f15742y;

    /* renamed from: z  reason: collision with root package name */
    private FrameLayout f15743z;
    private long B = 5000;
    private boolean E = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: GdtNativeInterstitialWorker.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class a implements NativeADUnifiedListener {
        private a() {
        }

        @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
        public void onADLoaded(List<NativeUnifiedADData> list) {
            Log.d("BeiZis", "ShowGdtInterstitialCustom onADLoaded()");
            ((com.beizi.fusion.work.a) d.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
            d.this.y();
            if (list == null || list.size() == 0) {
                d.this.c(-991);
                return;
            }
            d.this.f15740w = list.get(0);
            if (d.this.f15740w == null) {
                d.this.c(-991);
                return;
            }
            if (d.this.f15740w.getECPM() > 0) {
                d dVar = d.this;
                dVar.a(dVar.f15740w.getECPM());
            }
            if (v.f14982a) {
                d.this.f15740w.setDownloadConfirmListener(v.f14983b);
            }
            NativeADEventListener nativeADEventListener = new NativeADEventListener() { // from class: com.beizi.fusion.work.interstitial.d.a.1

                /* renamed from: a  reason: collision with root package name */
                boolean f15747a = false;

                /* renamed from: b  reason: collision with root package name */
                boolean f15748b = false;

                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADClicked() {
                    Log.d("BeiZis", "ShowGdtInterstitialCustom onADClicked()");
                    if (((com.beizi.fusion.work.a) d.this).f15367d != null && ((com.beizi.fusion.work.a) d.this).f15367d.s() != 2) {
                        ((com.beizi.fusion.work.a) d.this).f15367d.d(d.this.g());
                    }
                    if (this.f15748b) {
                        return;
                    }
                    this.f15748b = true;
                    d.this.E();
                    d.this.ai();
                }

                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADError(AdError adError) {
                    Log.d("BeiZis", "ShowGdtInterstitialCustom onADError: " + adError.getErrorMsg());
                    d.this.a(adError.getErrorMsg(), adError.getErrorCode());
                }

                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADExposed() {
                    Log.d("BeiZis", "ShowGdtInterstitialCustom onExposed()");
                    ((com.beizi.fusion.work.a) d.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
                    if (((com.beizi.fusion.work.a) d.this).f15367d != null && ((com.beizi.fusion.work.a) d.this).f15367d.s() != 2) {
                        ((com.beizi.fusion.work.a) d.this).f15367d.b(d.this.g());
                    }
                    if (this.f15747a) {
                        return;
                    }
                    this.f15747a = true;
                    d.this.az();
                    d.this.C();
                    d.this.D();
                    d.this.ah();
                }

                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADStatusChanged() {
                    af.a("BeiZis", "ShowGdtInterstitialCustom onADStatusChanged()");
                }
            };
            NativeADMediaListener nativeADMediaListener = new NativeADMediaListener() { // from class: com.beizi.fusion.work.interstitial.d.a.2

                /* renamed from: a  reason: collision with root package name */
                boolean f15750a = false;

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoClicked() {
                    Log.d("BeiZis", "ShowGdtInterstitialCustom MediaView onVideoClicked()");
                    if (((com.beizi.fusion.work.a) d.this).f15367d != null && ((com.beizi.fusion.work.a) d.this).f15367d.s() != 2) {
                        ((com.beizi.fusion.work.a) d.this).f15367d.d(d.this.g());
                    }
                    if (this.f15750a) {
                        return;
                    }
                    this.f15750a = true;
                    d.this.E();
                    d.this.ai();
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoCompleted() {
                    Log.d("BeiZis", "ShowGdtInterstitialCustom MediaView onVideoCompleted()");
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoError(AdError adError) {
                    Log.d("BeiZis", "ShowGdtInterstitialCustom MediaView onVideoError: " + adError.getErrorMsg());
                    d.this.a(adError.getErrorMsg(), adError.getErrorCode());
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoInit() {
                    Log.d("BeiZis", "ShowGdtInterstitialCustom MediaView onVideoInit()");
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoLoaded(int i4) {
                    Log.d("BeiZis", "ShowGdtInterstitialCustom MediaView onVideoLoaded()");
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoLoading() {
                    Log.d("BeiZis", "ShowGdtInterstitialCustom MediaView onVideoLoading()");
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoPause() {
                    Log.d("BeiZis", "ShowGdtInterstitialCustom MediaView onVideoPause()");
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoReady() {
                    Log.d("BeiZis", "ShowGdtInterstitialCustom MediaView onVideoReady()");
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoResume() {
                    Log.d("BeiZis", "ShowGdtInterstitialCustom MediaView onVideoResume()");
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoStart() {
                    Log.d("BeiZis", "ShowGdtInterstitialCustom MediaView onVideoStart()");
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoStop() {
                    Log.d("BeiZis", "ShowGdtInterstitialCustom MediaView onVideoStop()");
                }
            };
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.beizi.fusion.work.interstitial.d.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Log.d("BeiZis", "ShowGdtInterstitialCustom onADClosed()");
                    d.this.H();
                    d.this.aL();
                }
            };
            GdtNativeInterstitialCustomLayout gdtNativeInterstitialCustomLayout = new GdtNativeInterstitialCustomLayout(d.this.f15734q);
            gdtNativeInterstitialCustomLayout.setViewInteractionListener(d.this);
            boolean onBindData = gdtNativeInterstitialCustomLayout.onBindData(d.this.f15740w, d.this.f15741x, d.this.f15742y, d.this.D, nativeADEventListener, nativeADMediaListener, onClickListener);
            if (d.this.f15740w.getAdPatternType() == 2 && d.this.D != null && d.this.D.getVideoSkipTime() > 0) {
                d dVar2 = d.this;
                dVar2.B = dVar2.D.getVideoSkipTime();
            }
            if (onBindData) {
                d.this.f15743z = gdtNativeInterstitialCustomLayout;
                d.this.aJ();
                return;
            }
            d dVar3 = d.this;
            dVar3.a("sdk custom error ".concat(dVar3.g()).concat(" ").concat("create view error"), 10140);
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            Log.d("BeiZis", "ShowGdtInterstitialCustom onNoAD: " + adError.getErrorMsg());
            d.this.a(adError.getErrorMsg(), adError.getErrorCode());
        }
    }

    public d(Context context, String str, long j4, long j5, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.d.e eVar) {
        this.f15734q = context;
        this.f15735r = str;
        this.f15736s = j4;
        this.f15737t = j5;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        int sizeRatio = buyerBean.getSizeRatio();
        float j6 = aw.j(context) * 0.8f;
        this.f15741x = j6;
        this.f15742y = sizeRatio == 1 ? (j6 * 16.0f) / 9.0f : (j6 * 9.0f) / 16.0f;
        af.a("BeiZis", "interstitial mAdWidthDp = " + this.f15741x + ",mAdHeightDp = " + this.f15742y);
        r();
    }

    private void aG() {
        TextView textView = new TextView(this.f15734q);
        this.f15732o = textView;
        textView.setTextColor(this.f15734q.getResources().getColor(17170443));
        this.f15732o.setTextSize(2, 14.0f);
        e((int) (this.B / 1000));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(2, 107011);
        layoutParams.addRule(7, 107011);
        layoutParams.bottomMargin = aw.a(this.f15734q, 3.0f);
        RelativeLayout relativeLayout = this.f15733p;
        if (relativeLayout != null) {
            relativeLayout.addView(this.f15732o, layoutParams);
        }
    }

    private void aH() {
        ((FrameLayout) this.f15731n).removeView(this.f15733p);
    }

    private void aI() {
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar == null) {
            return;
        }
        Map<String, com.beizi.fusion.work.a> r3 = eVar.r();
        Log.d("BeiZis", g() + " NativeAdWorker:" + r3.toString());
        Z();
        h hVar = this.f15370g;
        if (hVar == h.SUCCESS) {
            if (this.f15743z != null) {
                this.f15367d.a(g(), this.f15743z);
            } else {
                this.f15367d.a(10140);
            }
        } else if (hVar == h.FAIL) {
            Log.d("BeiZis", "other worker shown," + g() + " remove");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ() {
        if (Y()) {
            aI();
        } else {
            O();
        }
    }

    private void aK() {
        CountDownTimer countDownTimer = this.A;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(100 + this.B, 50L) { // from class: com.beizi.fusion.work.interstitial.d.2
            @Override // android.os.CountDownTimer
            public void onFinish() {
                d.this.aL();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j4) {
                if (((com.beizi.fusion.work.a) d.this).f15367d != null && ((com.beizi.fusion.work.a) d.this).f15367d.s() != 2) {
                    ((com.beizi.fusion.work.a) d.this).f15367d.a(j4);
                }
                d.this.e((int) (((float) j4) / 1000.0f));
            }
        };
        this.A = countDownTimer2;
        countDownTimer2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL() {
        ac();
        G();
        c(this.C);
    }

    @Override // com.beizi.fusion.work.interstitial.GdtNativeInterstitialCustomLayout.a
    public void a_() {
        n();
    }

    @Override // com.beizi.fusion.work.a
    public void az() {
        NativeUnifiedADData nativeUnifiedADData = this.f15740w;
        if (nativeUnifiedADData == null || nativeUnifiedADData.getECPM() <= 0 || this.f15738u) {
            return;
        }
        this.f15738u = true;
        af.a("BeiZis", "channel == GDT\u7ade\u4ef7\u6210\u529f");
        af.a("BeiZis", "channel == sendWinNoticeECPM" + this.f15740w.getECPM());
        NativeUnifiedADData nativeUnifiedADData2 = this.f15740w;
        k.a(nativeUnifiedADData2, nativeUnifiedADData2.getECPM());
    }

    @Override // com.beizi.fusion.work.a
    public void f() {
    }

    @Override // com.beizi.fusion.work.a
    public String g() {
        return AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_GDT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i4) {
        if (this.f15732o == null) {
            return;
        }
        int i5 = 1;
        String format = String.format(Locale.CHINA, "\u5e7f\u544a%d\u79d2\u540e\u81ea\u52a8\u5173\u95ed", Integer.valueOf(i4));
        if (i4 >= 10 && i4 <= 99) {
            i5 = 2;
        }
        String valueOf = String.valueOf(i4);
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#ffffff")), 0, format.indexOf(valueOf), 17);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#ffffff")), format.indexOf(valueOf) + i5, format.length(), 17);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#ff9933")), format.indexOf(valueOf), format.indexOf(valueOf) + i5, 17);
        this.f15732o.setText(spannableString);
    }

    @Override // com.beizi.fusion.work.a
    protected void A() {
        if (!z() || this.f15740w == null) {
            return;
        }
        al();
        int a4 = al.a(this.f15368e.getPriceDict(), this.f15740w.getECPMLevel());
        if (a4 == -1 || a4 == -2) {
            if (a4 == -2) {
                L();
                return;
            }
            return;
        }
        Log.d("BeiZisBid", "gdt realPrice = " + a4);
        a((double) a4);
    }

    @Override // com.beizi.fusion.work.a
    public com.beizi.fusion.f.a i() {
        return this.f15373j;
    }

    @Override // com.beizi.fusion.work.a
    public String j() {
        NativeUnifiedADData nativeUnifiedADData = this.f15740w;
        if (nativeUnifiedADData != null) {
            int a4 = al.a(this.f15368e.getPriceDict(), nativeUnifiedADData.getECPMLevel());
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
        w();
        ag();
        if (this.f15741x <= 0.0f) {
            this.f15741x = aw.j(this.f15734q);
        }
        if (this.f15742y <= 0.0f) {
            this.f15742y = 0.0f;
        }
        if (AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(this.f15368e.getBidType())) {
            this.f15739v = new NativeUnifiedAD(this.f15734q, this.f15372i, new a(), aC());
        } else {
            this.f15739v = new NativeUnifiedAD(this.f15734q, this.f15372i, new a());
        }
        this.f15739v.loadData(1);
    }

    @Override // com.beizi.fusion.work.a
    public void m() {
        NativeUnifiedADData nativeUnifiedADData = this.f15740w;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.destroy();
        }
    }

    @Override // com.beizi.fusion.work.a
    public void n() {
        NativeUnifiedADData nativeUnifiedADData = this.f15740w;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.resume();
        }
    }

    @Override // com.beizi.fusion.work.a
    public View o() {
        return this.f15743z;
    }

    private void c(Activity activity) {
        if (activity != null) {
            if (this.f15731n == null) {
                this.f15731n = activity.getWindow().getDecorView();
            }
            if (this.f15731n instanceof FrameLayout) {
                aH();
            }
        }
        m();
    }

    @Override // com.beizi.fusion.work.a
    public void d() {
        if (this.f15367d == null) {
            return;
        }
        this.f15371h = this.f15368e.getAppId();
        this.f15372i = this.f15368e.getSpaceId();
        this.f15366c = this.f15368e.getBuyerSpaceUuId();
        List<AdSpacesBean.RenderViewBean> renderView = this.f15368e.getRenderView();
        if (renderView != null && renderView.size() > 0) {
            AdSpacesBean.RenderViewBean renderViewBean = renderView.get(0);
            this.D = renderViewBean;
            this.B = renderViewBean.getPicSkipTime() > 0 ? this.D.getPicSkipTime() : this.B;
        }
        com.beizi.fusion.b.d dVar = this.f15364a;
        if (dVar != null) {
            com.beizi.fusion.b.b a4 = dVar.a().a(this.f15366c);
            this.f15365b = a4;
            if (a4 != null) {
                s();
                if (!aw.a(AMPSConstants.CHANNEL_SDK_GDT_CLASSNAME)) {
                    t();
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.interstitial.d.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "GDT sdk not import , will do nothing");
                    return;
                }
                u();
                k.a(this.f15734q, this.f15371h);
                this.f15365b.s(SDKStatus.getIntegrationSDKVersion());
                au();
                v();
            }
        }
        v.f14982a = !n.a(this.f15368e.getDirectDownload());
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + this.f15737t);
        long j4 = this.f15737t;
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

    private void b(Activity activity) {
        if (activity != null) {
            View decorView = activity.getWindow().getDecorView();
            this.f15731n = decorView;
            if (decorView instanceof FrameLayout) {
                if (this.f15733p != null) {
                    aH();
                }
                RelativeLayout relativeLayout = new RelativeLayout(this.f15734q);
                this.f15733p = relativeLayout;
                relativeLayout.setBackgroundColor(Color.parseColor("#B2000000"));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(13);
                this.f15743z.setId(107011);
                aw.a(this.f15743z);
                this.f15733p.addView(this.f15743z, layoutParams2);
                ((FrameLayout) this.f15731n).addView(this.f15733p, layoutParams);
            }
        }
    }

    @Override // com.beizi.fusion.work.a
    public void a(Activity activity) {
        if (this.E) {
            return;
        }
        this.E = true;
        this.C = activity;
        b(activity);
        aG();
        aK();
    }

    @Override // com.beizi.fusion.work.interstitial.GdtNativeInterstitialCustomLayout.a
    public void b() {
        H();
        aL();
    }

    @Override // com.beizi.fusion.work.a
    public void d(int i4) {
        NativeUnifiedADData nativeUnifiedADData = this.f15740w;
        if (nativeUnifiedADData == null || nativeUnifiedADData.getECPM() <= 0 || this.f15738u) {
            return;
        }
        this.f15738u = true;
        af.a("BeiZis", "channel == GDT\u7ade\u4ef7\u5931\u8d25:" + i4);
        k.b(this.f15740w, i4 != 1 ? 10001 : 1);
    }
}
