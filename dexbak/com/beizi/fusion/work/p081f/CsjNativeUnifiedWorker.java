package com.beizi.fusion.work.p081f;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.TTAdManagerHolder;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.work.AdWorker;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.beizi.fusion.work.f.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CsjNativeUnifiedWorker extends BaseNativeUnifiedWorker {

    /* renamed from: v */
    private TTAdNative f11989v;

    /* renamed from: w */
    private TTFeedAd f11990w;

    public CsjNativeUnifiedWorker(Context context, long j, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager, int i) {
        super(context, j, buyerBean, forwardBean, baseManager, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aU */
    public void m47547aU() {
        if (mo47510aP()) {
            this.f11990w.setVideoAdListener(new TTFeedAd.VideoAdListener() { // from class: com.beizi.fusion.work.f.c.3
                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onProgressUpdate(long j, long j2) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoAdComplete(TTFeedAd tTFeedAd) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoAdPaused(TTFeedAd tTFeedAd) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoError(int i, int i2) {
                    Log.d("BeiZis", "showCsjNativeUnifiedAd Callback --> onVideoError()");
                    CsjNativeUnifiedWorker.this.m47961a("sdk custom error ".concat("onVideoError"), 99991);
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoLoad(TTFeedAd tTFeedAd) {
                }
            });
        }
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aG */
    public void mo47519aG() {
        if (!C3138av.m48301a("com.bytedance.sdk.openadsdk.TTAdNative")) {
            m47915t();
            this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.f.c.1
                @Override // java.lang.Runnable
                public void run() {
                    CsjNativeUnifiedWorker.this.m47921c(10151);
                }
            }, 10L);
            Log.e("BeiZis", "CSJ sdk not import , will do nothing");
            return;
        }
        m47914u();
        TTAdManagerHolder.m48592a(this, ((BaseNativeUnifiedWorker) this).f11955n, this.f11801h, this.f11798e.getDirectDownload());
        this.f11795b.m48883t(TTAdSdk.getAdManager().getSDKVersion());
        m47929au();
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aH */
    public void mo47518aH() {
        if (m47928av()) {
            return;
        }
        ((BaseNativeUnifiedWorker) this).f11960s = new FrameLayout(((BaseNativeUnifiedWorker) this).f11955n);
        this.f11989v = TTAdManagerHolder.m48594a().createAdNative(((BaseNativeUnifiedWorker) this).f11955n);
        this.f11989v.loadFeedAd(new AdSlot.Builder().setCodeId(this.f11802i).setSupportDeepLink(true).setAdCount(1).setImageAcceptedSize(640, GlMapUtil.DEVICE_DISPLAY_DPI_HIGH).build(), new TTAdNative.FeedAdListener() { // from class: com.beizi.fusion.work.f.c.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onError(int i, String str) {
                Log.d("BeiZis", "showCsjNativeUnifiedAd Callback --> onError:" + str);
                CsjNativeUnifiedWorker.this.m47961a(str, i);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onFeedAdLoad(List<TTFeedAd> list) {
                Log.d("BeiZis", "showCsjNativeUnifiedAd Callback --> onFeedAdLoad()");
                ((AdWorker) CsjNativeUnifiedWorker.this).f11803j = AdStatus.ADLOAD;
                CsjNativeUnifiedWorker.this.m47910y();
                if (list == null || list.size() == 0) {
                    CsjNativeUnifiedWorker.this.m47921c(-991);
                    return;
                }
                CsjNativeUnifiedWorker.this.f11990w = list.get(0);
                if (CsjNativeUnifiedWorker.this.f11990w != null) {
                    CsjNativeUnifiedWorker.this.m47547aU();
                    CsjNativeUnifiedWorker.this.m47588aT();
                    return;
                }
                CsjNativeUnifiedWorker.this.m47921c(-991);
            }
        });
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aI */
    public String mo47517aI() {
        TTFeedAd tTFeedAd = this.f11990w;
        if (tTFeedAd == null || TextUtils.isEmpty(tTFeedAd.getTitle())) {
            return null;
        }
        return this.f11990w.getTitle();
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aJ */
    public String mo47516aJ() {
        TTFeedAd tTFeedAd = this.f11990w;
        if (tTFeedAd == null || TextUtils.isEmpty(tTFeedAd.getDescription())) {
            return null;
        }
        return this.f11990w.getDescription();
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aK */
    public String mo47515aK() {
        TTFeedAd tTFeedAd = this.f11990w;
        if (tTFeedAd == null || tTFeedAd.getIcon() == null || TextUtils.isEmpty(this.f11990w.getIcon().getImageUrl())) {
            return null;
        }
        return this.f11990w.getIcon().getImageUrl();
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aL */
    public String mo47514aL() {
        TTFeedAd tTFeedAd = this.f11990w;
        if (tTFeedAd != null) {
            if ((tTFeedAd.getImageList() != null) & (this.f11990w.getImageList().size() > 0)) {
                List<TTImage> imageList = this.f11990w.getImageList();
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
        TTFeedAd tTFeedAd = this.f11990w;
        if (tTFeedAd != null) {
            if ((tTFeedAd.getImageList() != null) & (this.f11990w.getImageList().size() > 0)) {
                ArrayList arrayList = new ArrayList();
                List<TTImage> imageList = this.f11990w.getImageList();
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
        TTFeedAd tTFeedAd = this.f11990w;
        if (tTFeedAd != null) {
            int imageMode = tTFeedAd.getImageMode();
            if (imageMode == 2 || imageMode == 3 || imageMode == 4) {
                return 1;
            }
            if (imageMode == 5 || imageMode == 15 || imageMode == 166) {
                return 2;
            }
        }
        return 0;
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aO */
    public String mo47511aO() {
        TTFeedAd tTFeedAd = this.f11990w;
        if (tTFeedAd == null || TextUtils.isEmpty(tTFeedAd.getButtonText())) {
            return null;
        }
        return this.f11990w.getButtonText();
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aP */
    public boolean mo47510aP() {
        TTFeedAd tTFeedAd = this.f11990w;
        if (tTFeedAd != null) {
            return tTFeedAd.getImageMode() == 5 || this.f11990w.getImageMode() == 15 || this.f11990w.getImageMode() == 166;
        }
        return false;
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
            return this.f11990w.getAdView();
        }
        return null;
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aS */
    public void mo47507aS() {
        FrameLayout frameLayout = new FrameLayout(((BaseNativeUnifiedWorker) this).f11955n);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        if (this.f11990w.getAdLogo() != null) {
            ImageView imageView = new ImageView(((BaseNativeUnifiedWorker) this).f11955n);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setImageBitmap(this.f11990w.getAdLogo());
            frameLayout.addView(imageView);
        }
        ((BaseNativeUnifiedWorker) this).f11960s.addView(frameLayout, new FrameLayout.LayoutParams(-2, -2, 85));
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: ay */
    public void mo46297ay() {
        m47913v();
        mo46389e();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: e */
    public void mo46389e() {
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

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker, com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "CSJ";
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: m */
    public void mo46173m() {
        TTFeedAd tTFeedAd = this.f11990w;
        if (tTFeedAd != null) {
            tTFeedAd.destroy();
        }
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: a */
    public void mo47520a(List<View> list) {
        mo47507aS();
        this.f11990w.registerViewForInteraction(((BaseNativeUnifiedWorker) this).f11960s, null, list, null, null, new TTNativeAd.AdInteractionListener() { // from class: com.beizi.fusion.work.f.c.4
            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdClicked(View view, TTNativeAd tTNativeAd) {
                CsjNativeUnifiedWorker.this.m47584b();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
                CsjNativeUnifiedWorker.this.m47584b();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdShow(TTNativeAd tTNativeAd) {
                CsjNativeUnifiedWorker.this.mo47585ab();
            }
        });
    }
}
