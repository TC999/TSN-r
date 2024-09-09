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
import com.beizi.fusion.d.h;
import com.beizi.fusion.d.n;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.aw;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.work.interstitial.KsNativeInterstitialCustomLayout;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: KsNativeInterstitialWorker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class e extends com.beizi.fusion.work.a implements com.beizi.fusion.d.c, KsNativeInterstitialCustomLayout.a {
    private Activity B;
    private AdSpacesBean.RenderViewBean C;
    private KsNativeAd E;

    /* renamed from: n  reason: collision with root package name */
    RelativeLayout f15753n;

    /* renamed from: o  reason: collision with root package name */
    View f15754o;

    /* renamed from: p  reason: collision with root package name */
    TextView f15755p;

    /* renamed from: q  reason: collision with root package name */
    KsNativeAd.AdInteractionListener f15756q;

    /* renamed from: r  reason: collision with root package name */
    KsNativeAd.VideoPlayListener f15757r;

    /* renamed from: s  reason: collision with root package name */
    private Context f15758s;

    /* renamed from: t  reason: collision with root package name */
    private String f15759t;

    /* renamed from: u  reason: collision with root package name */
    private long f15760u;

    /* renamed from: v  reason: collision with root package name */
    private long f15761v;

    /* renamed from: w  reason: collision with root package name */
    private float f15762w;

    /* renamed from: x  reason: collision with root package name */
    private float f15763x;

    /* renamed from: y  reason: collision with root package name */
    private FrameLayout f15764y;

    /* renamed from: z  reason: collision with root package name */
    private CountDownTimer f15765z;
    private long A = 5000;
    private boolean D = false;

    public e(Context context, String str, long j4, long j5, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.d.e eVar) {
        this.f15758s = context;
        this.f15759t = str;
        this.f15760u = j4;
        this.f15761v = j5;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        int sizeRatio = buyerBean.getSizeRatio();
        float j6 = aw.j(context) * 0.8f;
        this.f15762w = j6;
        this.f15763x = sizeRatio == 1 ? (j6 * 16.0f) / 9.0f : (j6 * 9.0f) / 16.0f;
        af.a("BeiZis", "interstitial mAdWidthDp = " + this.f15762w + ",mAdHeightDp = " + this.f15763x);
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG() {
        Log.d("BeiZis", "ShowKsInterstitialCustom onADClosed()");
        ac();
        G();
        c(this.B);
    }

    private void aH() {
        TextView textView = new TextView(this.f15758s);
        this.f15755p = textView;
        textView.setTextColor(this.f15758s.getResources().getColor(17170443));
        this.f15755p.setTextSize(2, 14.0f);
        e((int) (this.A / 1000));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(2, 107017);
        layoutParams.addRule(7, 107017);
        layoutParams.bottomMargin = aw.a(this.f15758s, 3.0f);
        RelativeLayout relativeLayout = this.f15753n;
        if (relativeLayout != null) {
            relativeLayout.addView(this.f15755p, layoutParams);
        }
    }

    private void aI() {
        ((FrameLayout) this.f15754o).removeView(this.f15753n);
    }

    private void aJ() {
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar == null) {
            return;
        }
        Map<String, com.beizi.fusion.work.a> r3 = eVar.r();
        Log.d("BeiZis", g() + " NativeAdWorker:" + r3.toString());
        Z();
        h hVar = this.f15370g;
        if (hVar == h.SUCCESS) {
            if (this.f15764y != null) {
                this.f15367d.a(g(), this.f15764y);
            } else {
                this.f15367d.a(10140);
            }
        } else if (hVar == h.FAIL) {
            Log.d("BeiZis", "other worker shown," + g() + " remove");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK() {
        if (Y()) {
            aJ();
        } else {
            O();
        }
    }

    private void aL() {
        CountDownTimer countDownTimer = this.f15765z;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(100 + this.A, 50L) { // from class: com.beizi.fusion.work.interstitial.e.3
            @Override // android.os.CountDownTimer
            public void onFinish() {
                e.this.aG();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j4) {
                if (((com.beizi.fusion.work.a) e.this).f15367d != null && ((com.beizi.fusion.work.a) e.this).f15367d.s() != 2) {
                    ((com.beizi.fusion.work.a) e.this).f15367d.a(j4);
                }
                e.this.e((int) (((float) j4) / 1000.0f));
            }
        };
        this.f15765z = countDownTimer2;
        countDownTimer2.start();
    }

    @Override // com.beizi.fusion.work.interstitial.KsNativeInterstitialCustomLayout.a
    public void b_() {
    }

    @Override // com.beizi.fusion.work.a
    public void f() {
    }

    @Override // com.beizi.fusion.work.a
    public String g() {
        return "KUAISHOU";
    }

    @Override // com.beizi.fusion.work.a
    public void n() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i4) {
        if (this.f15755p == null) {
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
        this.f15755p.setText(spannableString);
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
            this.C = renderViewBean;
            this.A = renderViewBean.getPicSkipTime() > 0 ? this.C.getPicSkipTime() : this.A;
        }
        com.beizi.fusion.b.d dVar = this.f15364a;
        if (dVar != null) {
            com.beizi.fusion.b.b a4 = dVar.a().a(this.f15366c);
            this.f15365b = a4;
            if (a4 != null) {
                s();
                if (!aw.a(AMPSConstants.CHANNEL_SDK_KS_CLASSNAME)) {
                    t();
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.interstitial.e.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "Ks sdk not import , will do nothing");
                    return;
                }
                u();
                n.a(this.f15758s, this.f15371h);
                this.f15365b.u(KsAdSDK.getSDKVersion());
                au();
                v();
            }
        }
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + this.f15761v);
        long j4 = this.f15761v;
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
    public com.beizi.fusion.f.a i() {
        return this.f15373j;
    }

    @Override // com.beizi.fusion.work.a
    public String j() {
        if (this.E == null) {
            return null;
        }
        return this.E.getECPM() + "";
    }

    @Override // com.beizi.fusion.work.a
    public AdSpacesBean.BuyerBean k() {
        return this.f15368e;
    }

    @Override // com.beizi.fusion.work.a
    protected void l() {
        w();
        ag();
        if (this.f15762w <= 0.0f) {
            this.f15762w = aw.j(this.f15758s);
        }
        if (this.f15763x <= 0.0f) {
            this.f15763x = 0.0f;
        }
        KsScene build = new KsScene.Builder(Long.parseLong(this.f15372i)).adNum(1).build();
        build.setAdNum(1);
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (loadManager == null) {
            Log.d("BeiZis", "ShowKsInterstitialCustom onError:\u6e20\u9053\u5e7f\u544a\u8bf7\u6c42\u5bf9\u8c61\u4e3a\u7a7a");
            a("\u6e20\u9053\u5e7f\u544a\u8bf7\u6c42\u5f02\u5e38", 10160);
            return;
        }
        if (AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(this.f15368e.getBidType())) {
            build.setBidResponse(aC());
        }
        loadManager.loadNativeAd(build, new KsLoadManager.NativeAdListener() { // from class: com.beizi.fusion.work.interstitial.e.2
            @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
            public void onError(int i4, String str) {
                Log.d("BeiZis", "ShowKsInterstitialCustom onNoAD: " + str);
                e.this.a(str, i4);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
            public void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
                Log.d("BeiZis", "ShowKsInterstitialCustom onADLoaded()");
                ((com.beizi.fusion.work.a) e.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                e.this.y();
                if (list == null || list.isEmpty()) {
                    e.this.c(-991);
                    return;
                }
                if (list.get(0) != null) {
                    e.this.E = list.get(0);
                    e.this.a(list.get(0).getECPM());
                }
                e.this.f15756q = new KsNativeAd.AdInteractionListener() { // from class: com.beizi.fusion.work.interstitial.e.2.1

                    /* renamed from: a  reason: collision with root package name */
                    boolean f15768a = false;

                    /* renamed from: b  reason: collision with root package name */
                    boolean f15769b = false;

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                        return false;
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onAdClicked(View view, KsNativeAd ksNativeAd) {
                        Log.d("BeiZis", "ShowKsInterstitialCustom MediaView onVideoClicked()");
                        if (((com.beizi.fusion.work.a) e.this).f15367d != null && ((com.beizi.fusion.work.a) e.this).f15367d.s() != 2) {
                            ((com.beizi.fusion.work.a) e.this).f15367d.d(e.this.g());
                        }
                        if (this.f15769b) {
                            return;
                        }
                        this.f15769b = true;
                        e.this.E();
                        e.this.ai();
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onAdShow(KsNativeAd ksNativeAd) {
                        Log.d("BeiZis", "ShowKsInterstitialCustom onExposed()");
                        ((com.beizi.fusion.work.a) e.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
                        if (((com.beizi.fusion.work.a) e.this).f15367d != null && ((com.beizi.fusion.work.a) e.this).f15367d.s() != 2) {
                            ((com.beizi.fusion.work.a) e.this).f15367d.b(e.this.g());
                        }
                        if (this.f15768a) {
                            return;
                        }
                        this.f15768a = true;
                        e.this.C();
                        e.this.D();
                        e.this.ah();
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onDownloadTipsDialogDismiss() {
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onDownloadTipsDialogShow() {
                    }
                };
                e.this.f15757r = new KsNativeAd.VideoPlayListener() { // from class: com.beizi.fusion.work.interstitial.e.2.2
                    @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                    public void onVideoPlayComplete() {
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                    public void onVideoPlayError(int i4, int i5) {
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
                        e.this.H();
                        e.this.aG();
                    }
                };
                KsNativeInterstitialCustomLayout ksNativeInterstitialCustomLayout = new KsNativeInterstitialCustomLayout(e.this.f15758s);
                ksNativeInterstitialCustomLayout.setViewInteractionListener(e.this);
                KsNativeAd ksNativeAd = list.get(0);
                float f4 = e.this.f15762w;
                float f5 = e.this.f15763x;
                AdSpacesBean.RenderViewBean renderViewBean = e.this.C;
                e eVar = e.this;
                boolean onBindData = ksNativeInterstitialCustomLayout.onBindData(ksNativeAd, f4, f5, renderViewBean, eVar.f15756q, eVar.f15757r, onClickListener);
                if (list.get(0).getMaterialType() == 1 && e.this.C != null && e.this.C.getVideoSkipTime() > 0) {
                    e eVar2 = e.this;
                    eVar2.A = eVar2.C.getVideoSkipTime();
                }
                if (onBindData) {
                    e.this.f15764y = ksNativeInterstitialCustomLayout;
                    e.this.aK();
                    return;
                }
                e eVar3 = e.this;
                eVar3.a("sdk custom error ".concat(eVar3.g()).concat(" ").concat("create view error"), 10140);
            }
        });
    }

    @Override // com.beizi.fusion.work.a
    public void m() {
        this.E = null;
    }

    @Override // com.beizi.fusion.work.a
    public View o() {
        return this.f15764y;
    }

    private void c(Activity activity) {
        if (activity != null) {
            if (this.f15754o == null) {
                this.f15754o = activity.getWindow().getDecorView();
            }
            if (this.f15754o instanceof FrameLayout) {
                aI();
            }
        }
        m();
    }

    private void b(Activity activity) {
        if (activity == null || this.f15764y == null) {
            return;
        }
        View decorView = activity.getWindow().getDecorView();
        this.f15754o = decorView;
        if (decorView instanceof FrameLayout) {
            if (this.f15753n != null) {
                aI();
            }
            RelativeLayout relativeLayout = new RelativeLayout(this.f15758s);
            this.f15753n = relativeLayout;
            relativeLayout.setBackgroundColor(Color.parseColor("#B2000000"));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            this.f15764y.setId(107017);
            aw.a(this.f15764y);
            this.f15753n.addView(this.f15764y, layoutParams2);
            ((FrameLayout) this.f15754o).addView(this.f15753n, layoutParams);
        }
    }

    @Override // com.beizi.fusion.work.a
    public void a(Activity activity) {
        if (this.D) {
            return;
        }
        this.D = true;
        this.B = activity;
        b(activity);
        aH();
        aL();
    }

    @Override // com.beizi.fusion.work.interstitial.KsNativeInterstitialCustomLayout.a
    public void b() {
        H();
        aG();
    }
}
