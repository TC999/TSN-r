package com.beizi.fusion.work.p083h;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.beizi.fusion.C3025R;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.KsAdManagerHolder;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.BeiZiImageUtils;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.work.AdWorker;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.beizi.fusion.work.h.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class KsUnifiedCustomWorker extends BaseUnifiedCustomWorker {

    /* renamed from: W */
    private ViewGroup f12158W;

    /* renamed from: X */
    private ImageView f12159X;

    /* renamed from: Y */
    private TextView f12160Y;

    /* renamed from: Z */
    private KsNativeAd f12161Z;

    public KsUnifiedCustomWorker(Context context, long j, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager, int i) {
        super(context, j, buyerBean, forwardBean, baseManager, i);
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aG */
    public int mo47251aG() {
        return C3025R.C3029layout.ks_layout_unified_view;
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aH */
    public void mo47250aH() {
        super.mo47250aH();
        this.f12158W = (ViewGroup) ((BaseUnifiedCustomWorker) this).f12091o.findViewById(C3025R.C3028id.ll_ad_source_container);
        this.f12159X = (ImageView) ((BaseUnifiedCustomWorker) this).f12091o.findViewById(C3025R.C3028id.ad_source_logo_iv);
        this.f12160Y = (TextView) ((BaseUnifiedCustomWorker) this).f12091o.findViewById(C3025R.C3028id.ad_source_logo_tv);
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aI */
    public void mo47249aI() {
        if (!C3138av.m48301a("com.kwad.sdk.api.KsAdSDK")) {
            m47915t();
            this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.h.e.1
                @Override // java.lang.Runnable
                public void run() {
                    KsUnifiedCustomWorker.this.m47921c(10151);
                }
            }, 10L);
            Log.e("BeiZis", "ks sdk not import , will do nothing");
            return;
        }
        m47914u();
        KsAdManagerHolder.m48622a(this.f12081N, this.f11801h);
        this.f11795b.m48881u(KsAdSDK.getSDKVersion());
        m47929au();
        m47913v();
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + ((BaseUnifiedCustomWorker) this).f12075H);
        long j = ((BaseUnifiedCustomWorker) this).f12075H;
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

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aJ */
    public void mo47248aJ() {
        KsScene build = new KsScene.Builder(Long.parseLong(this.f11802i)).width((int) this.f12076I).adNum(1).build();
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (loadManager == null) {
            Log.d("BeiZis", "showKsUnifiedCustomAd onError:渠道广告请求对象为空");
            m47961a("渠道广告请求异常", 10160);
            return;
        }
        if ("S2S".equalsIgnoreCase(this.f11798e.getBidType())) {
            build.setBidResponse(m47957aC());
        }
        loadManager.loadNativeAd(build, new KsLoadManager.NativeAdListener() { // from class: com.beizi.fusion.work.h.e.2
            @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
            public void onError(int i, String str) {
                Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onError: code = " + i + " ，message= " + str);
                KsUnifiedCustomWorker.this.m47961a(str, i);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
            public void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
                Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onFeedAdLoad()");
                ((AdWorker) KsUnifiedCustomWorker.this).f11803j = AdStatus.ADLOAD;
                KsUnifiedCustomWorker.this.m47910y();
                if (list == null || list.size() == 0) {
                    KsUnifiedCustomWorker.this.m47921c(-991);
                    return;
                }
                KsUnifiedCustomWorker.this.f12161Z = list.get(0);
                if (KsUnifiedCustomWorker.this.f12161Z == null) {
                    KsUnifiedCustomWorker.this.m47921c(-991);
                    return;
                }
                KsUnifiedCustomWorker ksUnifiedCustomWorker = KsUnifiedCustomWorker.this;
                ksUnifiedCustomWorker.m47967a(ksUnifiedCustomWorker.f12161Z.getECPM());
                KsUnifiedCustomWorker.this.m47239b();
                KsUnifiedCustomWorker.this.mo47240aX();
                KsUnifiedCustomWorker.this.m47325aM();
            }
        });
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aO */
    public void mo47247aO() {
        m47322aY();
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aQ */
    public void mo47246aQ() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        layoutParams.rightMargin = (((BaseUnifiedCustomWorker) this).f12095s.getLayoutParams().width - ((BaseUnifiedCustomWorker) this).f12096t.getLayoutParams().width) / 2;
        layoutParams.bottomMargin = ((BaseUnifiedCustomWorker) this).f12095s.getLayoutParams().height - ((BaseUnifiedCustomWorker) this).f12096t.getLayoutParams().height;
        this.f12158W.setLayoutParams(layoutParams);
        if (!TextUtils.isEmpty(this.f12161Z.getAdSourceLogoUrl(0))) {
            BeiZiImageUtils.m48258a(this.f12081N).m48255a(this.f12161Z.getAdSourceLogoUrl(1), new BeiZiImageUtils.InterfaceC3151a() { // from class: com.beizi.fusion.work.h.e.6
                @Override // com.beizi.fusion.p072g.BeiZiImageUtils.InterfaceC3151a
                /* renamed from: a */
                public void mo47232a() {
                }

                @Override // com.beizi.fusion.p072g.BeiZiImageUtils.InterfaceC3151a
                /* renamed from: a */
                public void mo47231a(Bitmap bitmap) {
                    KsUnifiedCustomWorker.this.f12159X.setImageBitmap(bitmap);
                }
            });
        }
        if (TextUtils.isEmpty(this.f12161Z.getAdSource())) {
            return;
        }
        this.f12160Y.setText(this.f12161Z.getAdSource());
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aR */
    public void mo47245aR() {
        KsImage ksImage;
        if (this.f12161Z.getMaterialType() != 2 && this.f12161Z.getMaterialType() != 3) {
            if (this.f12161Z.getMaterialType() == 1) {
                View videoView = this.f12161Z.getVideoView(this.f12081N, new KsAdVideoPlayConfig.Builder().build());
                ((BaseUnifiedCustomWorker) this).f12096t.removeAllViews();
                ((BaseUnifiedCustomWorker) this).f12096t.addView(videoView);
            }
        } else if (this.f12161Z.getImageList() == null || this.f12161Z.getImageList().isEmpty() || (ksImage = this.f12161Z.getImageList().get(0)) == null || !ksImage.isValid()) {
        } else {
            BeiZiImageUtils.m48258a(this.f12081N).m48255a(ksImage.getImageUrl(), new BeiZiImageUtils.InterfaceC3151a() { // from class: com.beizi.fusion.work.h.e.5
                @Override // com.beizi.fusion.p072g.BeiZiImageUtils.InterfaceC3151a
                /* renamed from: a */
                public void mo47232a() {
                }

                @Override // com.beizi.fusion.p072g.BeiZiImageUtils.InterfaceC3151a
                /* renamed from: a */
                public void mo47231a(Bitmap bitmap) {
                    ((BaseUnifiedCustomWorker) KsUnifiedCustomWorker.this).f12101y.setImageBitmap(bitmap);
                }
            });
        }
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aS */
    public String mo47244aS() {
        KsNativeAd ksNativeAd = this.f12161Z;
        return ksNativeAd != null ? ksNativeAd.getInteractionType() == 1 ? !TextUtils.isEmpty(this.f12161Z.getAppName()) ? this.f12161Z.getAppName() : "" : !TextUtils.isEmpty(this.f12161Z.getProductName()) ? this.f12161Z.getProductName() : "" : "";
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aT */
    public String mo47243aT() {
        return this.f12161Z.getAdDescription();
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aU */
    public String mo47242aU() {
        return this.f12161Z.getAppIconUrl();
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aV */
    public String mo47241aV() {
        return this.f12161Z.getActionDescription();
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aX */
    public void mo47240aX() {
        if (this.f12161Z == null) {
            m47921c(-991);
        } else {
            m47324aN();
        }
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker, com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "KUAISHOU";
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker, com.beizi.fusion.work.AdWorker
    /* renamed from: m */
    public void mo46173m() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m47239b() {
        this.f12161Z.setVideoPlayListener(new KsNativeAd.VideoPlayListener() { // from class: com.beizi.fusion.work.h.e.3
            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayComplete() {
                Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onVideoPlayComplete()");
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayError(int i, int i2) {
                Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onVideoPlayError()");
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayPause() {
                Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onVideoPlayPause()");
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayReady() {
                Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onVideoPlayReady()");
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayResume() {
                Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onVideoPlayResume()");
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayStart() {
                Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onVideoPlayStart()");
            }
        });
        if (this.f12161Z.getInteractionType() == 1) {
            this.f12161Z.setDownloadListener(new KsAppDownloadListener() { // from class: com.beizi.fusion.work.h.e.4
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onDownloadFailed()");
                    String actionDescription = KsUnifiedCustomWorker.this.f12161Z.getActionDescription();
                    if (TextUtils.isEmpty(actionDescription)) {
                        return;
                    }
                    ((BaseUnifiedCustomWorker) KsUnifiedCustomWorker.this).f12073F.setText(actionDescription);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    ((BaseUnifiedCustomWorker) KsUnifiedCustomWorker.this).f12073F.setText("立即安装");
                    Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onDownloadFinished()");
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadStarted() {
                    Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onDownloadStarted()");
                    ((BaseUnifiedCustomWorker) KsUnifiedCustomWorker.this).f12073F.setText("开始下载");
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onIdle()");
                    String actionDescription = KsUnifiedCustomWorker.this.f12161Z.getActionDescription();
                    if (TextUtils.isEmpty(actionDescription)) {
                        return;
                    }
                    ((BaseUnifiedCustomWorker) KsUnifiedCustomWorker.this).f12073F.setText(actionDescription);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    ((BaseUnifiedCustomWorker) KsUnifiedCustomWorker.this).f12073F.setText("立即打开");
                    Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onInstalled()");
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i) {
                    Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onProgressUpdate()");
                    ((BaseUnifiedCustomWorker) KsUnifiedCustomWorker.this).f12073F.setText(String.format("%s/100", Integer.valueOf(i)));
                }
            });
        }
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: b */
    public void mo47236b(boolean z) {
        m47322aY();
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: a */
    public void mo47252a(List<View> list) {
        int i = this.f12161Z.getInteractionType() == 1 ? 2 : 1;
        HashMap hashMap = new HashMap();
        if (list != null && list.size() > 0) {
            for (View view : list) {
                hashMap.put(view, Integer.valueOf(i));
            }
        }
        this.f12161Z.registerViewForInteraction((Activity) this.f12081N, ((BaseUnifiedCustomWorker) this).f12095s, hashMap, new KsNativeAd.AdInteractionListener() { // from class: com.beizi.fusion.work.h.e.7
            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                return false;
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdClicked(View view2, KsNativeAd ksNativeAd) {
                KsUnifiedCustomWorker.this.m47327aK();
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdShow(KsNativeAd ksNativeAd) {
                KsUnifiedCustomWorker.this.m47326aL();
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogDismiss() {
                Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onDownloadTipsDialogDismiss()");
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogShow() {
                Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onDownloadTipsDialogShow()");
            }
        });
    }
}
