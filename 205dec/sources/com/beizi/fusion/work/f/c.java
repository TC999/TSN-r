package com.beizi.fusion.work.f;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.beizi.fusion.d.u;
import com.beizi.fusion.g.aw;
import com.beizi.fusion.model.AdSpacesBean;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.ArrayList;
import java.util.List;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: CsjNativeUnifiedWorker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class c extends a {

    /* renamed from: v  reason: collision with root package name */
    private TTAdNative f15550v;

    /* renamed from: w  reason: collision with root package name */
    private TTFeedAd f15551w;

    public c(Context context, long j4, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.d.e eVar, int i4) {
        super(context, j4, buyerBean, forwardBean, eVar, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU() {
        if (aP()) {
            this.f15551w.setVideoAdListener(new TTFeedAd.VideoAdListener() { // from class: com.beizi.fusion.work.f.c.3
                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onProgressUpdate(long j4, long j5) {
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
                public void onVideoError(int i4, int i5) {
                    Log.d("BeiZis", "showCsjNativeUnifiedAd Callback --> onVideoError()");
                    c.this.a("sdk custom error ".concat("onVideoError"), 99991);
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoLoad(TTFeedAd tTFeedAd) {
                }
            });
        }
    }

    @Override // com.beizi.fusion.work.f.a
    public void aG() {
        if (!aw.a("com.bytedance.sdk.openadsdk.TTAdNative")) {
            t();
            this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.f.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.c(10151);
                }
            }, 10L);
            Log.e("BeiZis", "CSJ sdk not import , will do nothing");
            return;
        }
        u();
        u.a(this, ((a) this).f15525n, this.f15371h, this.f15368e.getDirectDownload());
        this.f15365b.t(TTAdSdk.getAdManager().getSDKVersion());
        au();
    }

    @Override // com.beizi.fusion.work.f.a
    public void aH() {
        if (av()) {
            return;
        }
        ((a) this).f15530s = new FrameLayout(((a) this).f15525n);
        this.f15550v = u.a().createAdNative(((a) this).f15525n);
        this.f15550v.loadFeedAd(new AdSlot.Builder().setCodeId(this.f15372i).setSupportDeepLink(true).setAdCount(1).setImageAcceptedSize(640, 320).build(), new TTAdNative.FeedAdListener() { // from class: com.beizi.fusion.work.f.c.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onError(int i4, String str) {
                Log.d("BeiZis", "showCsjNativeUnifiedAd Callback --> onError:" + str);
                c.this.a(str, i4);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onFeedAdLoad(List<TTFeedAd> list) {
                Log.d("BeiZis", "showCsjNativeUnifiedAd Callback --> onFeedAdLoad()");
                ((com.beizi.fusion.work.a) c.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                c.this.y();
                if (list == null || list.size() == 0) {
                    c.this.c(-991);
                    return;
                }
                c.this.f15551w = list.get(0);
                if (c.this.f15551w != null) {
                    c.this.aU();
                    c.this.aT();
                    return;
                }
                c.this.c(-991);
            }
        });
    }

    @Override // com.beizi.fusion.work.f.a
    public String aI() {
        TTFeedAd tTFeedAd = this.f15551w;
        if (tTFeedAd == null || TextUtils.isEmpty(tTFeedAd.getTitle())) {
            return null;
        }
        return this.f15551w.getTitle();
    }

    @Override // com.beizi.fusion.work.f.a
    public String aJ() {
        TTFeedAd tTFeedAd = this.f15551w;
        if (tTFeedAd == null || TextUtils.isEmpty(tTFeedAd.getDescription())) {
            return null;
        }
        return this.f15551w.getDescription();
    }

    @Override // com.beizi.fusion.work.f.a
    public String aK() {
        TTFeedAd tTFeedAd = this.f15551w;
        if (tTFeedAd == null || tTFeedAd.getIcon() == null || TextUtils.isEmpty(this.f15551w.getIcon().getImageUrl())) {
            return null;
        }
        return this.f15551w.getIcon().getImageUrl();
    }

    @Override // com.beizi.fusion.work.f.a
    public String aL() {
        TTFeedAd tTFeedAd = this.f15551w;
        if (tTFeedAd != null) {
            if ((tTFeedAd.getImageList() != null) & (this.f15551w.getImageList().size() > 0)) {
                List<TTImage> imageList = this.f15551w.getImageList();
                String imageUrl = imageList.get(0).getImageUrl();
                if (!TextUtils.isEmpty(imageUrl) && imageList.get(0).isValid()) {
                    return imageUrl;
                }
            }
        }
        return null;
    }

    @Override // com.beizi.fusion.work.f.a
    public List<String> aM() {
        TTFeedAd tTFeedAd = this.f15551w;
        if (tTFeedAd != null) {
            if ((tTFeedAd.getImageList() != null) & (this.f15551w.getImageList().size() > 0)) {
                ArrayList arrayList = new ArrayList();
                List<TTImage> imageList = this.f15551w.getImageList();
                for (int i4 = 0; i4 < imageList.size(); i4++) {
                    String imageUrl = imageList.get(i4).getImageUrl();
                    if (!TextUtils.isEmpty(imageUrl) && imageList.get(i4).isValid()) {
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

    @Override // com.beizi.fusion.work.f.a
    public int aN() {
        TTFeedAd tTFeedAd = this.f15551w;
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

    @Override // com.beizi.fusion.work.f.a
    public String aO() {
        TTFeedAd tTFeedAd = this.f15551w;
        if (tTFeedAd == null || TextUtils.isEmpty(tTFeedAd.getButtonText())) {
            return null;
        }
        return this.f15551w.getButtonText();
    }

    @Override // com.beizi.fusion.work.f.a
    public boolean aP() {
        TTFeedAd tTFeedAd = this.f15551w;
        if (tTFeedAd != null) {
            return tTFeedAd.getImageMode() == 5 || this.f15551w.getImageMode() == 15 || this.f15551w.getImageMode() == 166;
        }
        return false;
    }

    @Override // com.beizi.fusion.work.f.a
    public ViewGroup aQ() {
        return ((a) this).f15530s;
    }

    @Override // com.beizi.fusion.work.f.a
    public View aR() {
        if (aP()) {
            return this.f15551w.getAdView();
        }
        return null;
    }

    @Override // com.beizi.fusion.work.f.a
    public void aS() {
        FrameLayout frameLayout = new FrameLayout(((a) this).f15525n);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        if (this.f15551w.getAdLogo() != null) {
            ImageView imageView = new ImageView(((a) this).f15525n);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setImageBitmap(this.f15551w.getAdLogo());
            frameLayout.addView(imageView);
        }
        ((a) this).f15530s.addView(frameLayout, new FrameLayout.LayoutParams(-2, -2, 85));
    }

    @Override // com.beizi.fusion.work.a
    public void ay() {
        v();
        e();
    }

    @Override // com.beizi.fusion.work.a
    public void e() {
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + ((a) this).f15526o);
        long j4 = ((a) this).f15526o;
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

    @Override // com.beizi.fusion.work.f.a, com.beizi.fusion.work.a
    public String g() {
        return AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_CSJ;
    }

    @Override // com.beizi.fusion.work.a
    public void m() {
        TTFeedAd tTFeedAd = this.f15551w;
        if (tTFeedAd != null) {
            tTFeedAd.destroy();
        }
    }

    @Override // com.beizi.fusion.work.f.a
    public void a(List<View> list) {
        aS();
        this.f15551w.registerViewForInteraction(((a) this).f15530s, null, list, null, null, new TTNativeAd.AdInteractionListener() { // from class: com.beizi.fusion.work.f.c.4
            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdClicked(View view, TTNativeAd tTNativeAd) {
                c.this.b();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
                c.this.b();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdShow(TTNativeAd tTNativeAd) {
                c.this.ab();
            }
        });
    }
}
