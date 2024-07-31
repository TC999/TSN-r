package com.beizi.fusion.work.interstitial;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.ObserverAdStatus;
import com.beizi.fusion.p066d.AdShowObserver;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.CompeteStatus;
import com.beizi.fusion.p066d.KsAdManagerHolder;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.work.AdWorker;
import com.beizi.fusion.work.interstitial.KsNativeInterstitialCustomLayout;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.interstitial.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class KsNativeInterstitialWorker extends AdWorker implements AdShowObserver, KsNativeInterstitialCustomLayout.InterfaceC3359a {

    /* renamed from: B */
    private Activity f12241B;

    /* renamed from: C */
    private AdSpacesBean.RenderViewBean f12242C;

    /* renamed from: E */
    private KsNativeAd f12244E;

    /* renamed from: n */
    RelativeLayout f12245n;

    /* renamed from: o */
    View f12246o;

    /* renamed from: p */
    TextView f12247p;

    /* renamed from: q */
    KsNativeAd.AdInteractionListener f12248q;

    /* renamed from: r */
    KsNativeAd.VideoPlayListener f12249r;

    /* renamed from: s */
    private Context f12250s;

    /* renamed from: t */
    private String f12251t;

    /* renamed from: u */
    private long f12252u;

    /* renamed from: v */
    private long f12253v;

    /* renamed from: w */
    private float f12254w;

    /* renamed from: x */
    private float f12255x;

    /* renamed from: y */
    private FrameLayout f12256y;

    /* renamed from: z */
    private CountDownTimer f12257z;

    /* renamed from: A */
    private long f12240A = 5000;

    /* renamed from: D */
    private boolean f12243D = false;

    public KsNativeInterstitialWorker(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager) {
        this.f12250s = context;
        this.f12251t = str;
        this.f12252u = j;
        this.f12253v = j2;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        int sizeRatio = buyerBean.getSizeRatio();
        float m48288j = C3138av.m48288j(context) * 0.8f;
        this.f12254w = m48288j;
        this.f12255x = sizeRatio == 1 ? (m48288j * 16.0f) / 9.0f : (m48288j * 9.0f) / 16.0f;
        C3116af.m48496a("BeiZis", "interstitial mAdWidthDp = " + this.f12254w + ",mAdHeightDp = " + this.f12255x);
        m47917r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aG */
    public void m47054aG() {
        Log.d("BeiZis", "ShowKsInterstitialCustom onADClosed()");
        m47947ac();
        m47988G();
        m47041c(this.f12241B);
    }

    /* renamed from: aH */
    private void m47053aH() {
        TextView textView = new TextView(this.f12250s);
        this.f12247p = textView;
        textView.setTextColor(this.f12250s.getResources().getColor(17170443));
        this.f12247p.setTextSize(2, 14.0f);
        m47037e((int) (this.f12240A / 1000));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(2, 107017);
        layoutParams.addRule(7, 107017);
        layoutParams.bottomMargin = C3138av.m48304a(this.f12250s, 3.0f);
        RelativeLayout relativeLayout = this.f12245n;
        if (relativeLayout != null) {
            relativeLayout.addView(this.f12247p, layoutParams);
        }
    }

    /* renamed from: aI */
    private void m47052aI() {
        ((FrameLayout) this.f12246o).removeView(this.f12245n);
    }

    /* renamed from: aJ */
    private void m47051aJ() {
        BaseManager baseManager = this.f11797d;
        if (baseManager == null) {
            return;
        }
        Map<String, AdWorker> m48669r = baseManager.m48669r();
        Log.d("BeiZis", mo46059g() + " NativeAdWorker:" + m48669r.toString());
        m47969Z();
        CompeteStatus competeStatus = this.f11800g;
        if (competeStatus == CompeteStatus.SUCCESS) {
            if (this.f12256y != null) {
                this.f11797d.m48726a(mo46059g(), this.f12256y);
            } else {
                this.f11797d.m48754a(10140);
            }
        } else if (competeStatus == CompeteStatus.FAIL) {
            Log.d("BeiZis", "other worker shown," + mo46059g() + " remove");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aK */
    public void m47050aK() {
        if (m47970Y()) {
            m47051aJ();
        } else {
            m47980O();
        }
    }

    /* renamed from: aL */
    private void m47049aL() {
        CountDownTimer countDownTimer = this.f12257z;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(100 + this.f12240A, 50L) { // from class: com.beizi.fusion.work.interstitial.e.3
            @Override // android.os.CountDownTimer
            public void onFinish() {
                KsNativeInterstitialWorker.this.m47054aG();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (((AdWorker) KsNativeInterstitialWorker.this).f11797d != null && ((AdWorker) KsNativeInterstitialWorker.this).f11797d.m48668s() != 2) {
                    ((AdWorker) KsNativeInterstitialWorker.this).f11797d.m48752a(j);
                }
                KsNativeInterstitialWorker.this.m47037e((int) (((float) j) / 1000.0f));
            }
        };
        this.f12257z = countDownTimer2;
        countDownTimer2.start();
    }

    @Override // com.beizi.fusion.work.interstitial.KsNativeInterstitialCustomLayout.InterfaceC3359a
    /* renamed from: b_ */
    public void mo47042b_() {
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: f */
    public void mo46061f() {
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "KUAISHOU";
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: n */
    public void mo46703n() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m47037e(int i) {
        if (this.f12247p == null) {
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
        this.f12247p.setText(spannableString);
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
            this.f12242C = renderViewBean;
            this.f12240A = renderViewBean.getPicSkipTime() > 0 ? this.f12242C.getPicSkipTime() : this.f12240A;
        }
        ObserverAdStatus observerAdStatus = this.f11794a;
        if (observerAdStatus != null) {
            EventBean m48977a = observerAdStatus.m48860a().m48977a(this.f11796c);
            this.f11795b = m48977a;
            if (m48977a != null) {
                m47916s();
                if (!C3138av.m48301a("com.kwad.sdk.api.KsAdSDK")) {
                    m47915t();
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.interstitial.e.1
                        @Override // java.lang.Runnable
                        public void run() {
                            KsNativeInterstitialWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "Ks sdk not import , will do nothing");
                    return;
                }
                m47914u();
                KsAdManagerHolder.m48622a(this.f12250s, this.f11801h);
                this.f11795b.m48881u(KsAdSDK.getSDKVersion());
                m47929au();
                m47913v();
            }
        }
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + this.f12253v);
        long j = this.f12253v;
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

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: i */
    public AdStatus mo46056i() {
        return this.f11803j;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: j */
    public String mo46054j() {
        if (this.f12244E == null) {
            return null;
        }
        return this.f12244E.getECPM() + "";
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
        if (this.f12254w <= 0.0f) {
            this.f12254w = C3138av.m48288j(this.f12250s);
        }
        if (this.f12255x <= 0.0f) {
            this.f12255x = 0.0f;
        }
        KsScene build = new KsScene.Builder(Long.parseLong(this.f11802i)).adNum(1).build();
        build.setAdNum(1);
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (loadManager == null) {
            Log.d("BeiZis", "ShowKsInterstitialCustom onError:渠道广告请求对象为空");
            m47961a("渠道广告请求异常", 10160);
            return;
        }
        if ("S2S".equalsIgnoreCase(this.f11798e.getBidType())) {
            build.setBidResponse(m47957aC());
        }
        loadManager.loadNativeAd(build, new KsLoadManager.NativeAdListener() { // from class: com.beizi.fusion.work.interstitial.e.2
            @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
            public void onError(int i, String str) {
                Log.d("BeiZis", "ShowKsInterstitialCustom onNoAD: " + str);
                KsNativeInterstitialWorker.this.m47961a(str, i);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
            public void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
                Log.d("BeiZis", "ShowKsInterstitialCustom onADLoaded()");
                ((AdWorker) KsNativeInterstitialWorker.this).f11803j = AdStatus.ADLOAD;
                KsNativeInterstitialWorker.this.m47910y();
                if (list == null || list.isEmpty()) {
                    KsNativeInterstitialWorker.this.m47921c(-991);
                    return;
                }
                if (list.get(0) != null) {
                    KsNativeInterstitialWorker.this.f12244E = list.get(0);
                    KsNativeInterstitialWorker.this.m47967a(list.get(0).getECPM());
                }
                KsNativeInterstitialWorker.this.f12248q = new KsNativeAd.AdInteractionListener() { // from class: com.beizi.fusion.work.interstitial.e.2.1

                    /* renamed from: a */
                    boolean f12260a = false;

                    /* renamed from: b */
                    boolean f12261b = false;

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                        return false;
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onAdClicked(View view, KsNativeAd ksNativeAd) {
                        Log.d("BeiZis", "ShowKsInterstitialCustom MediaView onVideoClicked()");
                        if (((AdWorker) KsNativeInterstitialWorker.this).f11797d != null && ((AdWorker) KsNativeInterstitialWorker.this).f11797d.m48668s() != 2) {
                            ((AdWorker) KsNativeInterstitialWorker.this).f11797d.m48700d(KsNativeInterstitialWorker.this.mo46059g());
                        }
                        if (this.f12261b) {
                            return;
                        }
                        this.f12261b = true;
                        KsNativeInterstitialWorker.this.m47990E();
                        KsNativeInterstitialWorker.this.m47941ai();
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onAdShow(KsNativeAd ksNativeAd) {
                        Log.d("BeiZis", "ShowKsInterstitialCustom onExposed()");
                        ((AdWorker) KsNativeInterstitialWorker.this).f11803j = AdStatus.ADSHOW;
                        if (((AdWorker) KsNativeInterstitialWorker.this).f11797d != null && ((AdWorker) KsNativeInterstitialWorker.this).f11797d.m48668s() != 2) {
                            ((AdWorker) KsNativeInterstitialWorker.this).f11797d.m48710b(KsNativeInterstitialWorker.this.mo46059g());
                        }
                        if (this.f12260a) {
                            return;
                        }
                        this.f12260a = true;
                        KsNativeInterstitialWorker.this.m47992C();
                        KsNativeInterstitialWorker.this.m47991D();
                        KsNativeInterstitialWorker.this.m47942ah();
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onDownloadTipsDialogDismiss() {
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onDownloadTipsDialogShow() {
                    }
                };
                KsNativeInterstitialWorker.this.f12249r = new KsNativeAd.VideoPlayListener() { // from class: com.beizi.fusion.work.interstitial.e.2.2
                    @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                    public void onVideoPlayComplete() {
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                    public void onVideoPlayError(int i, int i2) {
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                    public void onVideoPlayPause() {
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                    public void onVideoPlayReady() {
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                    public void onVideoPlayResume() {
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                    public void onVideoPlayStart() {
                    }
                };
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.beizi.fusion.work.interstitial.e.2.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        KsNativeInterstitialWorker.this.m47987H();
                        KsNativeInterstitialWorker.this.m47054aG();
                    }
                };
                KsNativeInterstitialCustomLayout ksNativeInterstitialCustomLayout = new KsNativeInterstitialCustomLayout(KsNativeInterstitialWorker.this.f12250s);
                ksNativeInterstitialCustomLayout.setViewInteractionListener(KsNativeInterstitialWorker.this);
                KsNativeAd ksNativeAd = list.get(0);
                float f = KsNativeInterstitialWorker.this.f12254w;
                float f2 = KsNativeInterstitialWorker.this.f12255x;
                AdSpacesBean.RenderViewBean renderViewBean = KsNativeInterstitialWorker.this.f12242C;
                KsNativeInterstitialWorker ksNativeInterstitialWorker = KsNativeInterstitialWorker.this;
                boolean onBindData = ksNativeInterstitialCustomLayout.onBindData(ksNativeAd, f, f2, renderViewBean, ksNativeInterstitialWorker.f12248q, ksNativeInterstitialWorker.f12249r, onClickListener);
                if (list.get(0).getMaterialType() == 1 && KsNativeInterstitialWorker.this.f12242C != null && KsNativeInterstitialWorker.this.f12242C.getVideoSkipTime() > 0) {
                    KsNativeInterstitialWorker ksNativeInterstitialWorker2 = KsNativeInterstitialWorker.this;
                    ksNativeInterstitialWorker2.f12240A = ksNativeInterstitialWorker2.f12242C.getVideoSkipTime();
                }
                if (onBindData) {
                    KsNativeInterstitialWorker.this.f12256y = ksNativeInterstitialCustomLayout;
                    KsNativeInterstitialWorker.this.m47050aK();
                    return;
                }
                KsNativeInterstitialWorker ksNativeInterstitialWorker3 = KsNativeInterstitialWorker.this;
                ksNativeInterstitialWorker3.m47961a("sdk custom error ".concat(ksNativeInterstitialWorker3.mo46059g()).concat(" ").concat("create view error"), 10140);
            }
        });
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: m */
    public void mo46173m() {
        this.f12244E = null;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: o */
    public View mo46446o() {
        return this.f12256y;
    }

    /* renamed from: c */
    private void m47041c(Activity activity) {
        if (activity != null) {
            if (this.f12246o == null) {
                this.f12246o = activity.getWindow().getDecorView();
            }
            if (this.f12246o instanceof FrameLayout) {
                m47052aI();
            }
        }
        mo46173m();
    }

    /* renamed from: b */
    private void m47047b(Activity activity) {
        if (activity == null || this.f12256y == null) {
            return;
        }
        View decorView = activity.getWindow().getDecorView();
        this.f12246o = decorView;
        if (decorView instanceof FrameLayout) {
            if (this.f12245n != null) {
                m47052aI();
            }
            RelativeLayout relativeLayout = new RelativeLayout(this.f12250s);
            this.f12245n = relativeLayout;
            relativeLayout.setBackgroundColor(Color.parseColor("#B2000000"));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            this.f12256y.setId(107017);
            C3138av.m48302a(this.f12256y);
            this.f12245n.addView(this.f12256y, layoutParams2);
            ((FrameLayout) this.f12246o).addView(this.f12245n, layoutParams);
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: a */
    public void mo47063a(Activity activity) {
        if (this.f12243D) {
            return;
        }
        this.f12243D = true;
        this.f12241B = activity;
        m47047b(activity);
        m47053aH();
        m47049aL();
    }

    @Override // com.beizi.fusion.work.interstitial.KsNativeInterstitialCustomLayout.InterfaceC3359a
    /* renamed from: b */
    public void mo47048b() {
        m47987H();
        m47054aG();
    }
}
