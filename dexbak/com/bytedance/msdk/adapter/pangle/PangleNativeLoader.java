package com.bytedance.msdk.adapter.pangle;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.UIUtils;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.TTAdDislike;
import com.bytedance.msdk.api.TTDislikeCallback;
import com.bytedance.msdk.api.format.TTMediaView;
import com.bytedance.msdk.api.format.TTNativeAdView;
import com.bytedance.msdk.api.nativeAd.TTVideoListener;
import com.bytedance.msdk.api.nativeAd.TTViewBinder;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.github.mikephil.charting.utils.Utils;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PangleNativeLoader {

    /* renamed from: a */
    private boolean f21461a;

    /* renamed from: b */
    private Context f21462b;

    public void loadAd(Context context, boolean z, TTAdNative tTAdNative, AdSlot adSlot, final TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter) {
        if (tTAdNative == null || tTAbsAdLoaderAdapter == null) {
            return;
        }
        this.f21462b = context;
        this.f21461a = z;
        tTAdNative.loadFeedAd(adSlot, new TTAdNative.FeedAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.1
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onError(int i, String str) {
                tTAbsAdLoaderAdapter.notifyAdFailed(PangleAdapterUtils.buildAdError(i, str));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onFeedAdLoad(List<TTFeedAd> list) {
                if (list != null && !list.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (TTFeedAd tTFeedAd : list) {
                        arrayList.add(new PangleNativeAd(tTFeedAd));
                    }
                    tTAbsAdLoaderAdapter.notifyAdLoaded(arrayList);
                    return;
                }
                tTAbsAdLoaderAdapter.notifyAdFailed(PangleAdapterUtils.buildAdError(20001, AdError.getMessage(20001)));
            }
        });
    }

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class PangleNativeAd extends TTBaseAd {

        /* renamed from: a */
        private TTFeedAd f21465a;

        /* renamed from: b */
        TTNativeAd.AdInteractionListener f21466b = new TTNativeAd.AdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.2
            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdClicked(View view, TTNativeAd tTNativeAd) {
                if (((TTBaseAd) PangleNativeAd.this).mTTNativeAdListener != null) {
                    ((TTBaseAd) PangleNativeAd.this).mTTNativeAdListener.onAdClick();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
                if (((TTBaseAd) PangleNativeAd.this).mTTNativeAdListener != null) {
                    ((TTBaseAd) PangleNativeAd.this).mTTNativeAdListener.onAdClick();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdShow(TTNativeAd tTNativeAd) {
                if (((TTBaseAd) PangleNativeAd.this).mTTNativeAdListener != null) {
                    ((TTBaseAd) PangleNativeAd.this).mTTNativeAdListener.onAdShow();
                }
            }
        };

        /* renamed from: c */
        TTFeedAd.VideoAdListener f21467c = new TTFeedAd.VideoAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.3
            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onProgressUpdate(long j, long j2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoAdComplete(TTFeedAd tTFeedAd) {
                if (((TTBaseAd) PangleNativeAd.this).mTTVideoListener != null) {
                    ((TTBaseAd) PangleNativeAd.this).mTTVideoListener.onVideoCompleted();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
                if (((TTBaseAd) PangleNativeAd.this).mTTVideoListener != null) {
                    ((TTBaseAd) PangleNativeAd.this).mTTVideoListener.onVideoResume();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoAdPaused(TTFeedAd tTFeedAd) {
                if (((TTBaseAd) PangleNativeAd.this).mTTVideoListener != null) {
                    ((TTBaseAd) PangleNativeAd.this).mTTVideoListener.onVideoPause();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
                if (((TTBaseAd) PangleNativeAd.this).mTTVideoListener != null) {
                    ((TTBaseAd) PangleNativeAd.this).mTTVideoListener.onVideoStart();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoError(int i, int i2) {
                if (((TTBaseAd) PangleNativeAd.this).mTTVideoListener != null) {
                    TTVideoListener tTVideoListener = ((TTBaseAd) PangleNativeAd.this).mTTVideoListener;
                    tTVideoListener.onVideoError(new AdError(i, "Android MediaPlay Error Code :" + i2));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoLoad(TTFeedAd tTFeedAd) {
            }
        };

        PangleNativeAd(TTFeedAd tTFeedAd) {
            Map<String, Object> mediaExtraInfo;
            this.f21465a = tTFeedAd;
            setTitle(tTFeedAd.getTitle());
            setAdDescription(tTFeedAd.getDescription());
            setActionText(tTFeedAd.getButtonText());
            setIconUrl(tTFeedAd.getIcon() != null ? tTFeedAd.getIcon().getImageUrl() : null);
            setImageMode(tTFeedAd.getImageMode());
            setInteractionType(tTFeedAd.getInteractionType());
            setSource(tTFeedAd.getSource());
            setRating(tTFeedAd.getAppScore());
            setAdType(5);
            setIsAppDownload(tTFeedAd.getInteractionType() == 4);
            setExpressAd(false);
            this.f21465a.getMediaExtraInfo();
            if (tTFeedAd.getImageMode() != 16 && tTFeedAd.getImageMode() != 3 && tTFeedAd.getImageMode() != 2) {
                if (tTFeedAd.getImageMode() == 4 && tTFeedAd.getImageList() != null && tTFeedAd.getImageList().size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (TTImage tTImage : tTFeedAd.getImageList()) {
                        arrayList.add(tTImage.getImageUrl());
                    }
                    setImages(arrayList);
                }
            } else if (tTFeedAd.getImageList() != null && !tTFeedAd.getImageList().isEmpty() && tTFeedAd.getImageList().get(0) != null) {
                TTImage tTImage2 = tTFeedAd.getImageList().get(0);
                setImageUrl(tTImage2.getImageUrl());
                setImageHeight(tTImage2.getHeight());
                setImageWidth(tTImage2.getWidth());
            }
            if (PangleNativeLoader.this.f21461a && (mediaExtraInfo = tTFeedAd.getMediaExtraInfo()) != null) {
                double value = PangleAdapterUtils.getValue(mediaExtraInfo.get(BidResponsed.KEY_PRICE));
                Logger.m37562d("TTMediationSDK_ECMP", "pangle native 返回的 cpm价格：" + value);
                setCpm(value <= Utils.DOUBLE_EPSILON ? 0.0d : value);
            }
            this.f21465a.setVideoAdListener(this.f21467c);
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getAdId() {
            TTFeedAd tTFeedAd = this.f21465a;
            if (tTFeedAd != null) {
                return PangleAdapterUtils.getAdId(tTFeedAd.getMediaExtraInfo());
            }
            return super.getAdId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public int getAdType() {
            return 5;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getCreativeId() {
            TTFeedAd tTFeedAd = this.f21465a;
            if (tTFeedAd != null) {
                return PangleAdapterUtils.getCreativeId(tTFeedAd.getMediaExtraInfo());
            }
            return super.getCreativeId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public TTAdDislike getDislikeDialog(Activity activity) {
            TTFeedAd tTFeedAd = this.f21465a;
            if (tTFeedAd != null) {
                final com.bytedance.sdk.openadsdk.TTAdDislike dislikeDialog = tTFeedAd.getDislikeDialog(activity);
                return new TTAdDislike(this) { // from class: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.1
                    @Override // com.bytedance.msdk.api.TTAdDislike
                    public void setDislikeCallback(final TTDislikeCallback tTDislikeCallback) {
                        if (tTDislikeCallback != null) {
                            dislikeDialog.setDislikeInteractionCallback(new TTAdDislike.DislikeInteractionCallback(this) { // from class: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.1.1
                                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                                public void onCancel() {
                                    tTDislikeCallback.onCancel();
                                }

                                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                                public void onSelected(int i, String str, boolean z) {
                                    tTDislikeCallback.onSelected(i, str);
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

                    @Override // com.bytedance.msdk.api.TTAdDislike
                    public void showDislikeDialog() {
                        com.bytedance.sdk.openadsdk.TTAdDislike tTAdDislike = dislikeDialog;
                        if (tTAdDislike != null) {
                            tTAdDislike.showDislikeDialog();
                        }
                    }
                };
            }
            return super.getDislikeDialog(activity);
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public String getReqId() {
            TTFeedAd tTFeedAd = this.f21465a;
            if (tTFeedAd != null) {
                return PangleAdapterUtils.getReqId(tTFeedAd.getMediaExtraInfo());
            }
            return super.getReqId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.f21465a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDislike() {
            return true;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            TTFeedAd tTFeedAd = this.f21465a;
            if (tTFeedAd != null) {
                tTFeedAd.setVideoAdListener(null);
                this.f21465a = null;
            }
            super.onDestroy();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void registerViewForInteraction(@NonNull ViewGroup viewGroup, List<View> list, List<View> list2, TTViewBinder tTViewBinder) {
            TTFeedAd tTFeedAd;
            View adView;
            View findViewById;
            super.registerViewForInteraction(viewGroup, list, list2, tTViewBinder);
            if (viewGroup instanceof TTNativeAdView) {
                TTFeedAd tTFeedAd2 = this.f21465a;
                if (tTFeedAd2 != null) {
                    tTFeedAd2.registerViewForInteraction(viewGroup, list, list2, this.f21466b);
                }
                TTFeedAd tTFeedAd3 = this.f21465a;
                if (tTFeedAd3 != null && tTFeedAd3.getAdLogo() != null && (findViewById = viewGroup.findViewById(tTViewBinder.logoLayoutId)) != null) {
                    findViewById.setVisibility(0);
                    if (findViewById instanceof ViewGroup) {
                        ViewGroup viewGroup2 = (ViewGroup) findViewById;
                        viewGroup2.removeAllViews();
                        ImageView imageView = new ImageView(PangleNativeLoader.this.f21462b);
                        imageView.setImageBitmap(this.f21465a.getAdLogo());
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                        layoutParams.width = UIUtils.dp2px(PangleNativeLoader.this.f21462b, 38.0f);
                        layoutParams.height = UIUtils.dp2px(PangleNativeLoader.this.f21462b, 38.0f);
                        findViewById.setLayoutParams(layoutParams);
                        viewGroup2.addView(imageView, -1, -1);
                    } else if (findViewById instanceof ImageView) {
                        ((ImageView) findViewById).setImageBitmap(this.f21465a.getAdLogo());
                    }
                }
                TTMediaView tTMediaView = (TTMediaView) viewGroup.findViewById(tTViewBinder.mediaViewId);
                if (tTMediaView == null || (tTFeedAd = this.f21465a) == null || (adView = tTFeedAd.getAdView()) == null) {
                    return;
                }
                removeSelfFromParent(adView);
                tTMediaView.removeAllViews();
                tTMediaView.addView(adView, -1, -1);
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void registerViewForInteraction(@NonNull ViewGroup viewGroup, List<View> list, TTViewBinder tTViewBinder) {
            registerViewForInteraction(viewGroup, list, null, tTViewBinder);
        }
    }
}
