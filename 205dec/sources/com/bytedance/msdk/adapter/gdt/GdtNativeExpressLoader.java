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
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.comm.pi.AdData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class GdtNativeExpressLoader {

    /* renamed from: k  reason: collision with root package name */
    private static Map<NativeExpressADView, ITTAdapterNativeExpressAdListener> f26972k = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private String f26973a;

    /* renamed from: b  reason: collision with root package name */
    private int f26974b;

    /* renamed from: c  reason: collision with root package name */
    private Context f26975c;

    /* renamed from: d  reason: collision with root package name */
    private TTVideoOption f26976d;

    /* renamed from: e  reason: collision with root package name */
    private GDTExtraOption f26977e;

    /* renamed from: f  reason: collision with root package name */
    private NativeExpressAD f26978f;

    /* renamed from: g  reason: collision with root package name */
    private TTAbsAdLoaderAdapter f26979g;

    /* renamed from: h  reason: collision with root package name */
    private int f26980h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f26981i;

    /* renamed from: j  reason: collision with root package name */
    private final NativeExpressAD.NativeExpressADListener f26982j = new NativeExpressAD.NativeExpressADListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.1
        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClicked(NativeExpressADView nativeExpressADView) {
            ITTAdapterNativeExpressAdListener iTTAdapterNativeExpressAdListener;
            if (GdtNativeExpressLoader.f26972k == null || (iTTAdapterNativeExpressAdListener = (ITTAdapterNativeExpressAdListener) GdtNativeExpressLoader.f26972k.get(nativeExpressADView)) == null) {
                return;
            }
            iTTAdapterNativeExpressAdListener.onAdClick();
        }

        public void onADCloseOverlay(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClosed(NativeExpressADView nativeExpressADView) {
            if (GdtNativeExpressLoader.f26972k != null) {
                ITTAdapterNativeExpressAdListener iTTAdapterNativeExpressAdListener = (ITTAdapterNativeExpressAdListener) GdtNativeExpressLoader.f26972k.get(nativeExpressADView);
                if (iTTAdapterNativeExpressAdListener instanceof TTExpressAd) {
                    ((TTExpressAd) iTTAdapterNativeExpressAdListener).closeAd();
                }
                GdtNativeExpressLoader.f26972k.remove(nativeExpressADView);
            }
            if (nativeExpressADView != null) {
                nativeExpressADView.destroy();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADExposure(NativeExpressADView nativeExpressADView) {
            ITTAdapterNativeExpressAdListener iTTAdapterNativeExpressAdListener;
            if (GdtNativeExpressLoader.f26972k == null || (iTTAdapterNativeExpressAdListener = (ITTAdapterNativeExpressAdListener) GdtNativeExpressLoader.f26972k.get(nativeExpressADView)) == null) {
                return;
            }
            iTTAdapterNativeExpressAdListener.onAdShow();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLoaded(List<NativeExpressADView> list) {
            if (list == null || list.size() == 0) {
                GdtNativeExpressLoader.this.f26979g.notifyAdFailed(new AdError(20001, AdError.AD_NO_FILL));
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (NativeExpressADView nativeExpressADView : list) {
                if (nativeExpressADView != null) {
                    TTExpressAd tTExpressAd = new TTExpressAd(nativeExpressADView);
                    GdtNativeExpressLoader.f26972k.put(nativeExpressADView, tTExpressAd);
                    arrayList.add(tTExpressAd);
                }
            }
            GdtNativeExpressLoader.this.f26979g.notifyAdLoaded(arrayList);
        }

        public void onADOpenOverlay(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(com.qq.e.comm.util.AdError adError) {
            if (adError != null) {
                GdtNativeExpressLoader.this.f26979g.notifyAdFailed(AdErrorUtil.getGdtError(adError.getErrorCode(), adError.getErrorMsg()));
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderFail(NativeExpressADView nativeExpressADView) {
            ITTAdapterNativeExpressAdListener iTTAdapterNativeExpressAdListener;
            if (GdtNativeExpressLoader.f26972k == null || (iTTAdapterNativeExpressAdListener = (ITTAdapterNativeExpressAdListener) GdtNativeExpressLoader.f26972k.get(nativeExpressADView)) == null) {
                return;
            }
            iTTAdapterNativeExpressAdListener.onRenderFail(nativeExpressADView, AdError.getMessage(106), 106);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
            ITTAdapterNativeExpressAdListener iTTAdapterNativeExpressAdListener;
            if (GdtNativeExpressLoader.f26972k == null || (iTTAdapterNativeExpressAdListener = (ITTAdapterNativeExpressAdListener) GdtNativeExpressLoader.f26972k.get(nativeExpressADView)) == null) {
                return;
            }
            iTTAdapterNativeExpressAdListener.onRenderSuccess(-1.0f, -2.0f);
        }
    };

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class TTExpressAd extends TTBaseAd implements ITTAdapterNativeExpressAdListener {

        /* renamed from: a  reason: collision with root package name */
        NativeExpressADView f26984a;

        /* renamed from: b  reason: collision with root package name */
        TTDislikeCallback f26985b;

        /* renamed from: c  reason: collision with root package name */
        private final NativeExpressMediaListener f26986c;

        TTExpressAd(NativeExpressADView nativeExpressADView) {
            NativeExpressMediaListener nativeExpressMediaListener = new NativeExpressMediaListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.TTExpressAd.1
                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoCached(NativeExpressADView nativeExpressADView2) {
                    Log.i("GdtNativeExpressLoader", "onVideoCached");
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoComplete(NativeExpressADView nativeExpressADView2) {
                    if (((TTBaseAd) TTExpressAd.this).mTTVideoListener != null) {
                        ((TTBaseAd) TTExpressAd.this).mTTVideoListener.onVideoCompleted();
                    }
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoError(NativeExpressADView nativeExpressADView2, com.qq.e.comm.util.AdError adError) {
                    if (((TTBaseAd) TTExpressAd.this).mTTVideoListener != null) {
                        ((TTBaseAd) TTExpressAd.this).mTTVideoListener.onVideoError(AdErrorUtil.getGdtError(adError.getErrorCode(), adError.getErrorMsg()));
                    }
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoInit(NativeExpressADView nativeExpressADView2) {
                    Log.i("GdtNativeExpressLoader", "onVideoInit: " + GdtNativeExpressLoader.this.e((AdData.VideoPlayer) nativeExpressADView2.getBoundData().getProperty(AdData.VideoPlayer.class)));
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoLoading(NativeExpressADView nativeExpressADView2) {
                    Log.i("GdtNativeExpressLoader", "onVideoLoading");
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoPageClose(NativeExpressADView nativeExpressADView2) {
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoPageOpen(NativeExpressADView nativeExpressADView2) {
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoPause(NativeExpressADView nativeExpressADView2) {
                    if (((TTBaseAd) TTExpressAd.this).mTTVideoListener != null) {
                        ((TTBaseAd) TTExpressAd.this).mTTVideoListener.onVideoPause();
                    }
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoReady(NativeExpressADView nativeExpressADView2, long j4) {
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoStart(NativeExpressADView nativeExpressADView2) {
                    if (((TTBaseAd) TTExpressAd.this).mTTVideoListener != null) {
                        ((TTBaseAd) TTExpressAd.this).mTTVideoListener.onVideoStart();
                    }
                }
            };
            this.f26986c = nativeExpressMediaListener;
            this.f26984a = nativeExpressADView;
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
            if (GdtNativeExpressLoader.this.f26981i) {
                setCpm(boundData.getECPM() != -1 ? boundData.getECPM() : 0.0d);
                Logger.d("");
                Logger.d("TTMediationSDK_ECMP", "GDT \u6a21\u677fNative \u8fd4\u56de\u7684 cpm\u4ef7\u683c\uff1a" + getCpm());
            }
        }

        public void closeAd() {
            TTDislikeCallback tTDislikeCallback = this.f26985b;
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
            return this.f26984a;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.f26984a == null;
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
            NativeExpressADView nativeExpressADView = this.f26984a;
            if (nativeExpressADView != null) {
                nativeExpressADView.destroy();
            }
            if (GdtNativeExpressLoader.f26972k != null) {
                GdtNativeExpressLoader.f26972k.remove(this.f26984a);
                this.f26984a = null;
            }
            this.f26985b = null;
            super.onDestroy();
        }

        @Override // com.bytedance.msdk.api.nativeAd.TTNativeExpressAdListener
        public void onRenderFail(View view, String str, int i4) {
            TTNativeAdListener tTNativeAdListener = this.mTTNativeAdListener;
            if (tTNativeAdListener instanceof TTNativeExpressAdListener) {
                ((TTNativeExpressAdListener) tTNativeAdListener).onRenderFail(view, str, i4);
            }
        }

        @Override // com.bytedance.msdk.api.nativeAd.TTNativeExpressAdListener
        public void onRenderSuccess(float f4, float f5) {
            TTNativeAdListener tTNativeAdListener = this.mTTNativeAdListener;
            if (tTNativeAdListener instanceof TTNativeExpressAdListener) {
                ((TTNativeExpressAdListener) tTNativeAdListener).onRenderSuccess(f4, f5);
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void render() {
            NativeExpressADView nativeExpressADView = this.f26984a;
            if (nativeExpressADView != null) {
                nativeExpressADView.render();
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void setDislikeCallback(Activity activity, TTDislikeCallback tTDislikeCallback) {
            this.f26985b = tTDislikeCallback;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e(AdData.VideoPlayer videoPlayer) {
        if (videoPlayer != null) {
            return "{state:" + videoPlayer.getVideoState() + ",duration:" + videoPlayer.getDuration() + ",position:" + videoPlayer.getCurrentPosition() + "}";
        }
        return null;
    }

    private ADSize j() {
        ADSize aDSize = new ADSize(-1, -2);
        int i4 = this.f26980h;
        return i4 > 0 ? new ADSize(i4, -2) : aDSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GdtNativeExpressLoader a(int i4) {
        this.f26974b = i4;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GdtNativeExpressLoader b(TTVideoOption tTVideoOption) {
        this.f26976d = tTVideoOption;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GdtNativeExpressLoader c(String str) {
        this.f26973a = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GdtNativeExpressLoader i(int i4) {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GdtNativeExpressLoader k(int i4) {
        this.f26980h = i4;
        return this;
    }

    public void loadAd(Context context, boolean z3, TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter) {
        if (context == null || tTAbsAdLoaderAdapter == null) {
            return;
        }
        this.f26975c = context;
        this.f26979g = tTAbsAdLoaderAdapter;
        this.f26981i = z3;
        this.f26978f = new NativeExpressAD(context, j(), this.f26973a, this.f26982j);
        TTVideoOption tTVideoOption = this.f26976d;
        if (tTVideoOption != null) {
            this.f26977e = tTVideoOption.getGDTExtraOption();
        }
        GDTExtraOption gDTExtraOption = this.f26977e;
        if (gDTExtraOption != null) {
            this.f26978f.setMinVideoDuration(gDTExtraOption.getGDTMinVideoDuration());
            this.f26978f.setMaxVideoDuration(this.f26977e.getGDTMaxVideoDuration());
        }
        VideoOption videoOption = GDTAdapterUtils.getVideoOption(this.f26977e);
        this.f26978f.setVideoOption(videoOption);
        this.f26978f.setVideoPlayPolicy(GDTAdapterUtils.getVideoPlayPolicy(videoOption.getAutoPlayPolicy(), this.f26975c));
        this.f26978f.loadAD(this.f26974b);
    }
}
