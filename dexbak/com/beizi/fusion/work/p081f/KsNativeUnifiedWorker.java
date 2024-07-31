package com.beizi.fusion.work.p081f;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.beizi.fusion.C3025R;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.KsAdManagerHolder;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.work.AdWorker;
import com.beizi.p051ad.internal.utilities.ImageManager;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.beizi.fusion.work.f.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class KsNativeUnifiedWorker extends BaseNativeUnifiedWorker {

    /* renamed from: v */
    private KsNativeAd f12004v;

    public KsNativeUnifiedWorker(Context context, long j, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager, int i) {
        super(context, j, buyerBean, forwardBean, baseManager, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aU */
    public void m47506aU() {
        this.f12004v.setVideoPlayListener(new KsNativeAd.VideoPlayListener() { // from class: com.beizi.fusion.work.f.e.3
            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayComplete() {
                Log.d("BeiZis", "showKsNativeUnifiedAd Callback --> onVideoPlayComplete()");
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayError(int i, int i2) {
                Log.d("BeiZis", "showKsNativeUnifiedAd Callback --> onVideoPlayError()");
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayPause() {
                Log.d("BeiZis", "showKsNativeUnifiedAd Callback --> onVideoPlayPause()");
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayReady() {
                Log.d("BeiZis", "showKsNativeUnifiedAd Callback --> onVideoPlayReady()");
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayResume() {
                Log.d("BeiZis", "showKsNativeUnifiedAd Callback --> onVideoPlayResume()");
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayStart() {
                Log.d("BeiZis", "showKsNativeUnifiedAd Callback --> onVideoPlayStart()");
            }
        });
        if (this.f12004v.getInteractionType() == 1) {
            this.f12004v.setDownloadListener(new KsAppDownloadListener() { // from class: com.beizi.fusion.work.f.e.4
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    Log.d("BeiZis", "showKsNativeUnifiedAd Callback --> onDownloadFailed()");
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    Log.d("BeiZis", "showKsNativeUnifiedAd Callback --> onDownloadFinished()");
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadStarted() {
                    Log.d("BeiZis", "showKsNativeUnifiedAd Callback --> onDownloadStarted()");
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    Log.d("BeiZis", "showKsNativeUnifiedAd Callback --> onIdle()");
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    Log.d("BeiZis", "showKsNativeUnifiedAd Callback --> onInstalled()");
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i) {
                    Log.d("BeiZis", "showKsNativeUnifiedAd Callback --> onProgressUpdate()");
                }
            });
        }
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aG */
    public void mo47519aG() {
        if (!C3138av.m48301a("com.kwad.sdk.api.KsAdSDK")) {
            m47915t();
            this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.f.e.1
                @Override // java.lang.Runnable
                public void run() {
                    KsNativeUnifiedWorker.this.m47921c(10151);
                }
            }, 10L);
            Log.e("BeiZis", "ks sdk not import , will do nothing");
            return;
        }
        m47914u();
        KsAdManagerHolder.m48622a(((BaseNativeUnifiedWorker) this).f11955n, this.f11801h);
        this.f11795b.m48881u(KsAdSDK.getSDKVersion());
        m47929au();
        m47913v();
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + ((BaseNativeUnifiedWorker) this).f11956o);
        long j = ((BaseNativeUnifiedWorker) this).f11956o;
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

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aH */
    public void mo47518aH() {
        KsScene build = new KsScene.Builder(Long.parseLong(this.f11802i)).width((int) ((BaseNativeUnifiedWorker) this).f11957p).adNum(1).build();
        ((BaseNativeUnifiedWorker) this).f11960s = new FrameLayout(((BaseNativeUnifiedWorker) this).f11955n);
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (loadManager == null) {
            Log.d("BeiZis", "showKsNativeUnifiedAd onError:渠道广告请求对象为空");
            m47961a("渠道广告请求异常", 10160);
            return;
        }
        if ("S2S".equalsIgnoreCase(this.f11798e.getBidType())) {
            build.setBidResponse(m47957aC());
        }
        loadManager.loadNativeAd(build, new KsLoadManager.NativeAdListener() { // from class: com.beizi.fusion.work.f.e.2
            @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
            public void onError(int i, String str) {
                Log.d("BeiZis", "showKsNativeUnifiedAd Callback --> onError: code = " + i + " ，message= " + str);
                KsNativeUnifiedWorker.this.m47961a(str, i);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
            public void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
                Log.d("BeiZis", "showKsNativeUnifiedAd Callback --> onFeedAdLoad()");
                ((AdWorker) KsNativeUnifiedWorker.this).f11803j = AdStatus.ADLOAD;
                KsNativeUnifiedWorker.this.m47910y();
                if (list == null || list.size() == 0) {
                    KsNativeUnifiedWorker.this.m47921c(-991);
                    return;
                }
                KsNativeUnifiedWorker.this.f12004v = list.get(0);
                if (KsNativeUnifiedWorker.this.f12004v == null) {
                    KsNativeUnifiedWorker.this.m47921c(-991);
                    return;
                }
                KsNativeUnifiedWorker ksNativeUnifiedWorker = KsNativeUnifiedWorker.this;
                ksNativeUnifiedWorker.m47967a(ksNativeUnifiedWorker.f12004v.getECPM());
                KsNativeUnifiedWorker.this.m47506aU();
                KsNativeUnifiedWorker.this.m47588aT();
            }
        });
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aI */
    public String mo47517aI() {
        KsNativeAd ksNativeAd = this.f12004v;
        if (ksNativeAd != null) {
            if (ksNativeAd.getInteractionType() == 1) {
                if (TextUtils.isEmpty(this.f12004v.getAppName())) {
                    return null;
                }
                return this.f12004v.getAppName();
            } else if (TextUtils.isEmpty(this.f12004v.getProductName())) {
                return null;
            } else {
                return this.f12004v.getProductName();
            }
        }
        return null;
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aJ */
    public String mo47516aJ() {
        KsNativeAd ksNativeAd = this.f12004v;
        if (ksNativeAd == null || TextUtils.isEmpty(ksNativeAd.getAdDescription())) {
            return null;
        }
        return this.f12004v.getAdDescription();
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aK */
    public String mo47515aK() {
        KsNativeAd ksNativeAd = this.f12004v;
        if (ksNativeAd == null || TextUtils.isEmpty(ksNativeAd.getAppIconUrl())) {
            return null;
        }
        return this.f12004v.getAppIconUrl();
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aL */
    public String mo47514aL() {
        KsNativeAd ksNativeAd = this.f12004v;
        if (ksNativeAd != null) {
            if ((ksNativeAd.getImageList() != null) & (this.f12004v.getImageList().size() > 0)) {
                List<KsImage> imageList = this.f12004v.getImageList();
                String imageUrl = imageList.get(0).getImageUrl();
                if (!TextUtils.isEmpty(imageUrl) && imageList.get(0).isValid()) {
                    return imageUrl;
                }
            }
        }
        return null;
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aM */
    public List<String> mo47513aM() {
        KsNativeAd ksNativeAd = this.f12004v;
        if (ksNativeAd != null) {
            if ((ksNativeAd.getImageList() != null) & (this.f12004v.getImageList().size() > 0)) {
                ArrayList arrayList = new ArrayList();
                List<KsImage> imageList = this.f12004v.getImageList();
                for (int i = 0; i < imageList.size(); i++) {
                    String imageUrl = imageList.get(i).getImageUrl();
                    if (!TextUtils.isEmpty(imageUrl) && imageList.get(i).isValid()) {
                        arrayList.add(imageUrl);
                    }
                }
                if (arrayList.size() > 0) {
                    return arrayList;
                }
            }
        }
        return null;
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aN */
    public int mo47512aN() {
        KsNativeAd ksNativeAd = this.f12004v;
        if (ksNativeAd != null) {
            int materialType = ksNativeAd.getMaterialType();
            if (materialType == 1) {
                return 2;
            }
            if (materialType == 2 || materialType == 3) {
                return 1;
            }
        }
        return 0;
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aO */
    public String mo47511aO() {
        KsNativeAd ksNativeAd = this.f12004v;
        if (ksNativeAd == null || TextUtils.isEmpty(ksNativeAd.getActionDescription())) {
            return null;
        }
        return this.f12004v.getActionDescription();
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aP */
    public boolean mo47510aP() {
        KsNativeAd ksNativeAd = this.f12004v;
        return ksNativeAd != null && ksNativeAd.getMaterialType() == 1;
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aQ */
    public ViewGroup mo47509aQ() {
        return ((BaseNativeUnifiedWorker) this).f11960s;
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aR */
    public View mo47508aR() {
        if (mo47510aP()) {
            return this.f12004v.getVideoView(((BaseNativeUnifiedWorker) this).f11955n, new KsAdVideoPlayConfig.Builder().build());
        }
        return null;
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aS */
    public void mo47507aS() {
        FrameLayout frameLayout = new FrameLayout(((BaseNativeUnifiedWorker) this).f11955n);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        frameLayout.setBackgroundDrawable(ContextCompat.getDrawable(((BaseNativeUnifiedWorker) this).f11955n, C3025R.C3027drawable.button_count_down_background));
        ImageView imageView = new ImageView(((BaseNativeUnifiedWorker) this).f11955n);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(26, 26, 19);
        layoutParams.setMargins(0, 0, 0, 0);
        imageView.setLayoutParams(layoutParams);
        if (!TextUtils.isEmpty(this.f12004v.getAdSourceLogoUrl(0))) {
            ImageManager.with(((BaseNativeUnifiedWorker) this).f11955n).load(this.f12004v.getAdSourceLogoUrl(0)).into(imageView);
        } else {
            imageView.setImageResource(C3025R.C3027drawable.ks_ad_logo_normal_mark);
        }
        frameLayout.addView(imageView);
        if (!TextUtils.isEmpty(this.f12004v.getAdSource())) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(((BaseNativeUnifiedWorker) this).f11955n);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, 19);
            layoutParams2.setMargins(32, 0, 0, 0);
            appCompatTextView.setLayoutParams(layoutParams2);
            appCompatTextView.setTextColor(ContextCompat.getColorStateList(((BaseNativeUnifiedWorker) this).f11955n, C3025R.C3026color.button_text_selector));
            appCompatTextView.setTextSize(2, 12.0f);
            appCompatTextView.setGravity(17);
            appCompatTextView.setText(this.f12004v.getAdSource());
            frameLayout.addView(appCompatTextView);
        }
        ((BaseNativeUnifiedWorker) this).f11960s.addView(frameLayout, new FrameLayout.LayoutParams(-2, -2, 85));
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker, com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "KUAISHOU";
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: j */
    public String mo46054j() {
        if (this.f12004v == null) {
            return null;
        }
        return this.f12004v.getECPM() + "";
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: m */
    public void mo46173m() {
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: a */
    public void mo47520a(List<View> list) {
        mo47507aS();
        int i = this.f12004v.getInteractionType() == 1 ? 2 : 1;
        HashMap hashMap = new HashMap();
        if (list != null && list.size() > 0) {
            for (View view : list) {
                hashMap.put(view, Integer.valueOf(i));
            }
        }
        this.f12004v.registerViewForInteraction((Activity) ((BaseNativeUnifiedWorker) this).f11955n, ((BaseNativeUnifiedWorker) this).f11960s, hashMap, new KsNativeAd.AdInteractionListener() { // from class: com.beizi.fusion.work.f.e.5
            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                return false;
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdClicked(View view2, KsNativeAd ksNativeAd) {
                KsNativeUnifiedWorker.this.m47584b();
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdShow(KsNativeAd ksNativeAd) {
                KsNativeUnifiedWorker.this.mo47585ab();
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogDismiss() {
                Log.d("BeiZis", "showKsNativeUnifiedAd Callback --> onDownloadTipsDialogDismiss()");
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogShow() {
                Log.d("BeiZis", "showKsNativeUnifiedAd Callback --> onDownloadTipsDialogShow()");
            }
        });
    }
}
