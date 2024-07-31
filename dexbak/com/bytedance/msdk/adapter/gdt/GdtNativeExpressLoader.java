package com.bytedance.msdk.adapter.gdt;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.listener.ITTAdapterNativeExpressAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdErrorUtil;
import com.bytedance.msdk.api.GDTExtraOption;
import com.bytedance.msdk.api.TTDislikeCallback;
import com.bytedance.msdk.api.TTVideoOption;
import com.bytedance.msdk.api.nativeAd.TTNativeAdListener;
import com.bytedance.msdk.api.nativeAd.TTNativeExpressAdListener;
import com.bytedance.msdk.base.TTBaseAd;
import com.github.mikephil.charting.utils.Utils;
import com.p518qq.p519e.ads.cfg.VideoOption;
import com.p518qq.p519e.ads.nativ.ADSize;
import com.p518qq.p519e.ads.nativ.NativeExpressAD;
import com.p518qq.p519e.ads.nativ.NativeExpressADView;
import com.p518qq.p519e.ads.nativ.NativeExpressMediaListener;
import com.p518qq.p519e.comm.p520pi.AdData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class GdtNativeExpressLoader {

    /* renamed from: k */
    private static Map<NativeExpressADView, ITTAdapterNativeExpressAdListener> f21362k = new HashMap();

    /* renamed from: a */
    private String f21363a;

    /* renamed from: b */
    private int f21364b;

    /* renamed from: c */
    private Context f21365c;

    /* renamed from: d */
    private TTVideoOption f21366d;

    /* renamed from: e */
    private GDTExtraOption f21367e;

    /* renamed from: f */
    private NativeExpressAD f21368f;

    /* renamed from: g */
    private TTAbsAdLoaderAdapter f21369g;

    /* renamed from: h */
    private int f21370h;

    /* renamed from: i */
    private boolean f21371i;

    /* renamed from: j */
    private final NativeExpressAD.NativeExpressADListener f21372j = new NativeExpressAD.NativeExpressADListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.1
        @Override // com.p518qq.p519e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClicked(NativeExpressADView nativeExpressADView) {
            ITTAdapterNativeExpressAdListener iTTAdapterNativeExpressAdListener;
            if (GdtNativeExpressLoader.f21362k == null || (iTTAdapterNativeExpressAdListener = (ITTAdapterNativeExpressAdListener) GdtNativeExpressLoader.f21362k.get(nativeExpressADView)) == null) {
                return;
            }
            iTTAdapterNativeExpressAdListener.onAdClick();
        }

        public void onADCloseOverlay(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.p518qq.p519e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClosed(NativeExpressADView nativeExpressADView) {
            if (GdtNativeExpressLoader.f21362k != null) {
                ITTAdapterNativeExpressAdListener iTTAdapterNativeExpressAdListener = (ITTAdapterNativeExpressAdListener) GdtNativeExpressLoader.f21362k.get(nativeExpressADView);
                if (iTTAdapterNativeExpressAdListener instanceof TTExpressAd) {
                    ((TTExpressAd) iTTAdapterNativeExpressAdListener).closeAd();
                }
                GdtNativeExpressLoader.f21362k.remove(nativeExpressADView);
            }
            if (nativeExpressADView != null) {
                nativeExpressADView.destroy();
            }
        }

        @Override // com.p518qq.p519e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADExposure(NativeExpressADView nativeExpressADView) {
            ITTAdapterNativeExpressAdListener iTTAdapterNativeExpressAdListener;
            if (GdtNativeExpressLoader.f21362k == null || (iTTAdapterNativeExpressAdListener = (ITTAdapterNativeExpressAdListener) GdtNativeExpressLoader.f21362k.get(nativeExpressADView)) == null) {
                return;
            }
            iTTAdapterNativeExpressAdListener.onAdShow();
        }

        @Override // com.p518qq.p519e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.p518qq.p519e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLoaded(List<NativeExpressADView> list) {
            if (list == null || list.size() == 0) {
                GdtNativeExpressLoader.this.f21369g.notifyAdFailed(new AdError(20001, AdError.AD_NO_FILL));
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (NativeExpressADView nativeExpressADView : list) {
                if (nativeExpressADView != null) {
                    TTExpressAd tTExpressAd = new TTExpressAd(nativeExpressADView);
                    GdtNativeExpressLoader.f21362k.put(nativeExpressADView, tTExpressAd);
                    arrayList.add(tTExpressAd);
                }
            }
            GdtNativeExpressLoader.this.f21369g.notifyAdLoaded(arrayList);
        }

        public void onADOpenOverlay(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.p518qq.p519e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(com.p518qq.p519e.comm.util.AdError adError) {
            if (adError != null) {
                GdtNativeExpressLoader.this.f21369g.notifyAdFailed(AdErrorUtil.getGdtError(adError.getErrorCode(), adError.getErrorMsg()));
            }
        }

        @Override // com.p518qq.p519e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderFail(NativeExpressADView nativeExpressADView) {
            ITTAdapterNativeExpressAdListener iTTAdapterNativeExpressAdListener;
            if (GdtNativeExpressLoader.f21362k == null || (iTTAdapterNativeExpressAdListener = (ITTAdapterNativeExpressAdListener) GdtNativeExpressLoader.f21362k.get(nativeExpressADView)) == null) {
                return;
            }
            iTTAdapterNativeExpressAdListener.onRenderFail(nativeExpressADView, AdError.getMessage(106), 106);
        }

        @Override // com.p518qq.p519e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
            ITTAdapterNativeExpressAdListener iTTAdapterNativeExpressAdListener;
            if (GdtNativeExpressLoader.f21362k == null || (iTTAdapterNativeExpressAdListener = (ITTAdapterNativeExpressAdListener) GdtNativeExpressLoader.f21362k.get(nativeExpressADView)) == null) {
                return;
            }
            iTTAdapterNativeExpressAdListener.onRenderSuccess(-1.0f, -2.0f);
        }
    };

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class TTExpressAd extends TTBaseAd implements ITTAdapterNativeExpressAdListener {

        /* renamed from: a */
        NativeExpressADView f21374a;

        /* renamed from: b */
        TTDislikeCallback f21375b;

        /* renamed from: c */
        private final NativeExpressMediaListener f21376c;

        TTExpressAd(NativeExpressADView nativeExpressADView) {
            NativeExpressMediaListener nativeExpressMediaListener = new NativeExpressMediaListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.TTExpressAd.1
                @Override // com.p518qq.p519e.ads.nativ.NativeExpressMediaListener
                public void onVideoCached(NativeExpressADView nativeExpressADView2) {
                    Log.i("GdtNativeExpressLoader", "onVideoCached");
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeExpressMediaListener
                public void onVideoComplete(NativeExpressADView nativeExpressADView2) {
                    if (((TTBaseAd) TTExpressAd.this).mTTVideoListener != null) {
                        ((TTBaseAd) TTExpressAd.this).mTTVideoListener.onVideoCompleted();
                    }
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeExpressMediaListener
                public void onVideoError(NativeExpressADView nativeExpressADView2, com.p518qq.p519e.comm.util.AdError adError) {
                    if (((TTBaseAd) TTExpressAd.this).mTTVideoListener != null) {
                        ((TTBaseAd) TTExpressAd.this).mTTVideoListener.onVideoError(AdErrorUtil.getGdtError(adError.getErrorCode(), adError.getErrorMsg()));
                    }
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeExpressMediaListener
                public void onVideoInit(NativeExpressADView nativeExpressADView2) {
                    Log.i("GdtNativeExpressLoader", "onVideoInit: " + GdtNativeExpressLoader.this.m37805e((AdData.VideoPlayer) nativeExpressADView2.getBoundData().getProperty(AdData.VideoPlayer.class)));
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeExpressMediaListener
                public void onVideoLoading(NativeExpressADView nativeExpressADView2) {
                    Log.i("GdtNativeExpressLoader", "onVideoLoading");
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeExpressMediaListener
                public void onVideoPageClose(NativeExpressADView nativeExpressADView2) {
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeExpressMediaListener
                public void onVideoPageOpen(NativeExpressADView nativeExpressADView2) {
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeExpressMediaListener
                public void onVideoPause(NativeExpressADView nativeExpressADView2) {
                    if (((TTBaseAd) TTExpressAd.this).mTTVideoListener != null) {
                        ((TTBaseAd) TTExpressAd.this).mTTVideoListener.onVideoPause();
                    }
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeExpressMediaListener
                public void onVideoReady(NativeExpressADView nativeExpressADView2, long j) {
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeExpressMediaListener
                public void onVideoStart(NativeExpressADView nativeExpressADView2) {
                    if (((TTBaseAd) TTExpressAd.this).mTTVideoListener != null) {
                        ((TTBaseAd) TTExpressAd.this).mTTVideoListener.onVideoStart();
                    }
                }
            };
            this.f21376c = nativeExpressMediaListener;
            this.f21374a = nativeExpressADView;
            AdData boundData = nativeExpressADView.getBoundData();
            if (boundData.getAdPatternType() == 2) {
                nativeExpressADView.preloadVideo();
                nativeExpressADView.setMediaListener(nativeExpressMediaListener);
                setImageMode(5);
            } else if (boundData.getAdPatternType() == 4 || boundData.getAdPatternType() == 1 || boundData.getAdPatternType() != 3) {
                setImageMode(3);
            } else {
                setImageMode(4);
            }
            setExpressAd(true);
            setTitle(boundData.getTitle());
            setAdDescription(boundData.getDesc());
            setInteractionType(3);
            if (GdtNativeExpressLoader.this.f21371i) {
                setCpm(boundData.getECPM() != -1 ? boundData.getECPM() : Utils.DOUBLE_EPSILON);
                Logger.m37563d("");
                Logger.m37562d("TTMediationSDK_ECMP", "GDT 模板Native 返回的 cpm价格：" + getCpm());
            }
        }

        public void closeAd() {
            TTDislikeCallback tTDislikeCallback = this.f21375b;
            if (tTDislikeCallback != null) {
                tTDislikeCallback.onSelected(-1, "ad close !");
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public int getAdType() {
            return 5;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public View getAdView() {
            return this.f21374a;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.f21374a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDislike() {
            return true;
        }

        @Override // com.bytedance.msdk.api.nativeAd.TTNativeAdListener
        public void onAdClick() {
            TTNativeAdListener tTNativeAdListener = this.mTTNativeAdListener;
            if (tTNativeAdListener != null) {
                tTNativeAdListener.onAdClick();
            }
        }

        @Override // com.bytedance.msdk.api.nativeAd.TTNativeAdListener
        public void onAdShow() {
            TTNativeAdListener tTNativeAdListener = this.mTTNativeAdListener;
            if (tTNativeAdListener != null) {
                tTNativeAdListener.onAdShow();
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            NativeExpressADView nativeExpressADView = this.f21374a;
            if (nativeExpressADView != null) {
                nativeExpressADView.destroy();
            }
            if (GdtNativeExpressLoader.f21362k != null) {
                GdtNativeExpressLoader.f21362k.remove(this.f21374a);
                this.f21374a = null;
            }
            this.f21375b = null;
            super.onDestroy();
        }

        @Override // com.bytedance.msdk.api.nativeAd.TTNativeExpressAdListener
        public void onRenderFail(View view, String str, int i) {
            TTNativeAdListener tTNativeAdListener = this.mTTNativeAdListener;
            if (tTNativeAdListener instanceof TTNativeExpressAdListener) {
                ((TTNativeExpressAdListener) tTNativeAdListener).onRenderFail(view, str, i);
            }
        }

        @Override // com.bytedance.msdk.api.nativeAd.TTNativeExpressAdListener
        public void onRenderSuccess(float f, float f2) {
            TTNativeAdListener tTNativeAdListener = this.mTTNativeAdListener;
            if (tTNativeAdListener instanceof TTNativeExpressAdListener) {
                ((TTNativeExpressAdListener) tTNativeAdListener).onRenderSuccess(f, f2);
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void render() {
            NativeExpressADView nativeExpressADView = this.f21374a;
            if (nativeExpressADView != null) {
                nativeExpressADView.render();
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void setDislikeCallback(Activity activity, TTDislikeCallback tTDislikeCallback) {
            this.f21375b = tTDislikeCallback;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public String m37805e(AdData.VideoPlayer videoPlayer) {
        if (videoPlayer != null) {
            return "{state:" + videoPlayer.getVideoState() + ",duration:" + videoPlayer.getDuration() + ",position:" + videoPlayer.getCurrentPosition() + "}";
        }
        return null;
    }

    /* renamed from: j */
    private ADSize m37800j() {
        ADSize aDSize = new ADSize(-1, -2);
        int i = this.f21370h;
        return i > 0 ? new ADSize(i, -2) : aDSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public GdtNativeExpressLoader m37809a(int i) {
        this.f21364b = i;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public GdtNativeExpressLoader m37808b(TTVideoOption tTVideoOption) {
        this.f21366d = tTVideoOption;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public GdtNativeExpressLoader m37807c(String str) {
        this.f21363a = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public GdtNativeExpressLoader m37801i(int i) {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public GdtNativeExpressLoader m37799k(int i) {
        this.f21370h = i;
        return this;
    }

    public void loadAd(Context context, boolean z, TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter) {
        if (context == null || tTAbsAdLoaderAdapter == null) {
            return;
        }
        this.f21365c = context;
        this.f21369g = tTAbsAdLoaderAdapter;
        this.f21371i = z;
        this.f21368f = new NativeExpressAD(context, m37800j(), this.f21363a, this.f21372j);
        TTVideoOption tTVideoOption = this.f21366d;
        if (tTVideoOption != null) {
            this.f21367e = tTVideoOption.getGDTExtraOption();
        }
        GDTExtraOption gDTExtraOption = this.f21367e;
        if (gDTExtraOption != null) {
            this.f21368f.setMinVideoDuration(gDTExtraOption.getGDTMinVideoDuration());
            this.f21368f.setMaxVideoDuration(this.f21367e.getGDTMaxVideoDuration());
        }
        VideoOption videoOption = GDTAdapterUtils.getVideoOption(this.f21367e);
        this.f21368f.setVideoOption(videoOption);
        this.f21368f.setVideoPlayPolicy(GDTAdapterUtils.getVideoPlayPolicy(videoOption.getAutoPlayPolicy(), this.f21365c));
        this.f21368f.loadAD(this.f21364b);
    }
}
