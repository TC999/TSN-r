package xyz.adscope.amps.adapter.ks.data;

import android.content.Context;
import android.view.View;
import com.kwad.sdk.api.KsFeedAd;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdExpressListener;
import xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo;
import xyz.adscope.amps.adapter.ks.KSNativeAdapter;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class KSNativeAd implements AMPSNativeAdExpressInfo {
    private KSNativeAdapter adapter;
    private Context context;
    public KsFeedAd ksNativeExpressAd;
    private AMPSNativeAdExpressListener mAmpsNativeAdExpressListener = null;

    public KSNativeAd(KsFeedAd ksFeedAd, KSNativeAdapter kSNativeAdapter, Context context) {
        this.ksNativeExpressAd = ksFeedAd;
        this.adapter = kSNativeAdapter;
        this.context = context;
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public void destroy() {
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public View getNativeExpressAdView() {
        Context context;
        KsFeedAd ksFeedAd = this.ksNativeExpressAd;
        if (ksFeedAd == null || (context = this.context) == null) {
            return null;
        }
        return ksFeedAd.getFeedView(context);
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public void render() {
        if (this.ksNativeExpressAd == null || getNativeExpressAdView() == null) {
            return;
        }
        KSNativeAdapter kSNativeAdapter = this.adapter;
        if (kSNativeAdapter != null) {
            kSNativeAdapter.onRender();
            this.adapter.onRenderSuccess();
        }
        AMPSNativeAdExpressListener aMPSNativeAdExpressListener = this.mAmpsNativeAdExpressListener;
        if (aMPSNativeAdExpressListener != null) {
            aMPSNativeAdExpressListener.onRenderSuccess(getNativeExpressAdView(), 0.0f, 0.0f);
        }
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public void setAMPSNativeAdExpressListener(final AMPSNativeAdExpressListener aMPSNativeAdExpressListener) {
        KsFeedAd ksFeedAd = this.ksNativeExpressAd;
        if (ksFeedAd == null) {
            return;
        }
        this.mAmpsNativeAdExpressListener = aMPSNativeAdExpressListener;
        ksFeedAd.setAdInteractionListener(new KsFeedAd.AdInteractionListener() { // from class: xyz.adscope.amps.adapter.ks.data.KSNativeAd.1
            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onAdClicked() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadNativeAd onAdClicked");
                if (KSNativeAd.this.adapter != null) {
                    KSNativeAd.this.adapter.onAdClicked();
                }
                AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                if (aMPSNativeAdExpressListener2 != null) {
                    aMPSNativeAdExpressListener2.onAdClicked();
                }
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onAdShow() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadNativeAd onAdShow");
                if (KSNativeAd.this.adapter != null) {
                    KSNativeAd.this.adapter.onAdShow();
                }
                AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                if (aMPSNativeAdExpressListener2 != null) {
                    aMPSNativeAdExpressListener2.onAdShow();
                }
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onDislikeClicked() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadNativeAd onDislikeClicked");
                if (KSNativeAd.this.adapter != null) {
                    KSNativeAd.this.adapter.onAdDismiss();
                }
                AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                if (aMPSNativeAdExpressListener2 != null) {
                    aMPSNativeAdExpressListener2.onAdClosed(KSNativeAd.this.getNativeExpressAdView());
                }
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onDownloadTipsDialogDismiss() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadNativeAd onDownloadTipsDialogDismiss");
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onDownloadTipsDialogShow() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadNativeAd onDownloadTipsDialogShow");
            }
        });
    }
}
