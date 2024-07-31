package com.bytedance.msdk.adapter.pangle;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.TTDislikeCallback;
import com.bytedance.msdk.api.nativeAd.TTNativeExpressAdListener;
import com.bytedance.msdk.api.nativeAd.TTVideoListener;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.github.mikephil.charting.utils.Utils;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PangleNativeExpressLoader {

    /* renamed from: a */
    private boolean f21452a;

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class PangleNativeExpressAd extends TTBaseAd {

        /* renamed from: a */
        TTNativeExpressAd f21455a;

        /* renamed from: b */
        TTNativeExpressAd.ExpressAdInteractionListener f21456b = new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleNativeExpressLoader.PangleNativeExpressAd.2
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i) {
                if (((TTBaseAd) PangleNativeExpressAd.this).mTTNativeAdListener != null) {
                    ((TTBaseAd) PangleNativeExpressAd.this).mTTNativeAdListener.onAdClick();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i) {
                if (((TTBaseAd) PangleNativeExpressAd.this).mTTNativeAdListener != null) {
                    ((TTBaseAd) PangleNativeExpressAd.this).mTTNativeAdListener.onAdShow();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i) {
                if (((TTBaseAd) PangleNativeExpressAd.this).mTTNativeAdListener instanceof TTNativeExpressAdListener) {
                    ((TTNativeExpressAdListener) ((TTBaseAd) PangleNativeExpressAd.this).mTTNativeAdListener).onRenderFail(view, str, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f, float f2) {
                if (((TTBaseAd) PangleNativeExpressAd.this).mTTNativeAdListener instanceof TTNativeExpressAdListener) {
                    ((TTNativeExpressAdListener) ((TTBaseAd) PangleNativeExpressAd.this).mTTNativeAdListener).onRenderSuccess(f, f2);
                }
            }
        };

        /* renamed from: c */
        TTNativeExpressAd.ExpressVideoAdListener f21457c = new TTNativeExpressAd.ExpressVideoAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleNativeExpressLoader.PangleNativeExpressAd.3
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onClickRetry() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onProgressUpdate(long j, long j2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoAdComplete() {
                if (((TTBaseAd) PangleNativeExpressAd.this).mTTVideoListener != null) {
                    ((TTBaseAd) PangleNativeExpressAd.this).mTTVideoListener.onVideoCompleted();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoAdContinuePlay() {
                if (((TTBaseAd) PangleNativeExpressAd.this).mTTVideoListener != null) {
                    ((TTBaseAd) PangleNativeExpressAd.this).mTTVideoListener.onVideoResume();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoAdPaused() {
                if (((TTBaseAd) PangleNativeExpressAd.this).mTTVideoListener != null) {
                    ((TTBaseAd) PangleNativeExpressAd.this).mTTVideoListener.onVideoPause();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoAdStartPlay() {
                if (((TTBaseAd) PangleNativeExpressAd.this).mTTVideoListener != null) {
                    ((TTBaseAd) PangleNativeExpressAd.this).mTTVideoListener.onVideoStart();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoError(int i, int i2) {
                if (((TTBaseAd) PangleNativeExpressAd.this).mTTVideoListener != null) {
                    TTVideoListener tTVideoListener = ((TTBaseAd) PangleNativeExpressAd.this).mTTVideoListener;
                    tTVideoListener.onVideoError(new AdError(i, "MediaPlayer inter error code:" + i2));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoLoad() {
            }
        };

        PangleNativeExpressAd(PangleNativeExpressLoader pangleNativeExpressLoader, TTNativeExpressAd tTNativeExpressAd) {
            Map<String, Object> mediaExtraInfo;
            this.f21455a = tTNativeExpressAd;
            setImageMode(tTNativeExpressAd.getImageMode());
            setInteractionType(this.f21455a.getInteractionType());
            setExpressAd(true);
            this.f21455a.setExpressInteractionListener(this.f21456b);
            if (tTNativeExpressAd.getImageMode() == 5) {
                this.f21455a.setVideoAdListener(this.f21457c);
            }
            if (!pangleNativeExpressLoader.f21452a || (mediaExtraInfo = tTNativeExpressAd.getMediaExtraInfo()) == null) {
                return;
            }
            double value = PangleAdapterUtils.getValue(mediaExtraInfo.get(BidResponsed.KEY_PRICE));
            Logger.m37562d("TTMediationSDK_ECMP", "pangle 模板native 返回的 cpm价格：" + value);
            setCpm(value <= Utils.DOUBLE_EPSILON ? 0.0d : value);
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getAdId() {
            TTNativeExpressAd tTNativeExpressAd = this.f21455a;
            if (tTNativeExpressAd != null) {
                return PangleAdapterUtils.getAdId(tTNativeExpressAd.getMediaExtraInfo());
            }
            return super.getAdId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public int getAdType() {
            return 5;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public View getAdView() {
            TTNativeExpressAd tTNativeExpressAd = this.f21455a;
            if (tTNativeExpressAd != null) {
                return tTNativeExpressAd.getExpressAdView();
            }
            return null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getCreativeId() {
            TTNativeExpressAd tTNativeExpressAd = this.f21455a;
            if (tTNativeExpressAd != null) {
                return PangleAdapterUtils.getCreativeId(tTNativeExpressAd.getMediaExtraInfo());
            }
            return super.getCreativeId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public String getReqId() {
            TTNativeExpressAd tTNativeExpressAd = this.f21455a;
            if (tTNativeExpressAd != null) {
                return PangleAdapterUtils.getReqId(tTNativeExpressAd.getMediaExtraInfo());
            }
            return super.getReqId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.f21455a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDislike() {
            return true;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            TTNativeExpressAd tTNativeExpressAd = this.f21455a;
            if (tTNativeExpressAd != null) {
                tTNativeExpressAd.destroy();
                this.f21455a = null;
            }
            super.onDestroy();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void render() {
            TTNativeExpressAd tTNativeExpressAd = this.f21455a;
            if (tTNativeExpressAd != null) {
                tTNativeExpressAd.render();
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void setDislikeCallback(Activity activity, final TTDislikeCallback tTDislikeCallback) {
            TTNativeExpressAd tTNativeExpressAd = this.f21455a;
            if (tTNativeExpressAd != null) {
                tTNativeExpressAd.setDislikeCallback(activity, new TTAdDislike.DislikeInteractionCallback(this) { // from class: com.bytedance.msdk.adapter.pangle.PangleNativeExpressLoader.PangleNativeExpressAd.1
                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onCancel() {
                        TTDislikeCallback tTDislikeCallback2 = tTDislikeCallback;
                        if (tTDislikeCallback2 != null) {
                            tTDislikeCallback2.onCancel();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onSelected(int i, String str, boolean z) {
                        TTDislikeCallback tTDislikeCallback2 = tTDislikeCallback;
                        if (tTDislikeCallback2 != null) {
                            tTDislikeCallback2.onSelected(i, str);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onShow() {
                        TTDislikeCallback tTDislikeCallback2 = tTDislikeCallback;
                        if (tTDislikeCallback2 != null) {
                            tTDislikeCallback2.onShow();
                        }
                    }
                });
            }
        }
    }

    public void loadAd(Context context, boolean z, TTAdNative tTAdNative, AdSlot adSlot, final TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter) {
        if (tTAdNative == null || tTAbsAdLoaderAdapter == null) {
            return;
        }
        this.f21452a = z;
        tTAdNative.loadNativeExpressAd(adSlot, new TTAdNative.NativeExpressAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleNativeExpressLoader.1
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i, String str) {
                tTAbsAdLoaderAdapter.notifyAdFailed(PangleAdapterUtils.buildAdError(i, str));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                if (list != null && list.size() != 0) {
                    ArrayList arrayList = new ArrayList();
                    for (TTNativeExpressAd tTNativeExpressAd : list) {
                        if (tTNativeExpressAd != null) {
                            arrayList.add(new PangleNativeExpressAd(PangleNativeExpressLoader.this, tTNativeExpressAd));
                        }
                    }
                    tTAbsAdLoaderAdapter.notifyAdLoaded(arrayList);
                    return;
                }
                tTAbsAdLoaderAdapter.notifyAdFailed(PangleAdapterUtils.buildAdError(20001, AdError.getMessage(20001)));
            }
        });
    }
}
