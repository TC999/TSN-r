package xyz.adscope.amps.adapter.csj.data;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdExpressListener;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter;
import xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class CSJNativeAd implements AMPSNativeAdExpressInfo {
    private AMPSNativeAdapter adapter;
    private Context context;
    public TTNativeExpressAd ttNativeExpressAd;

    public CSJNativeAd(TTNativeExpressAd tTNativeExpressAd, Context context, AMPSNativeAdapter aMPSNativeAdapter) {
        this.ttNativeExpressAd = tTNativeExpressAd;
        this.context = context;
        this.adapter = aMPSNativeAdapter;
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public void destroy() {
        try {
            TTNativeExpressAd tTNativeExpressAd = this.ttNativeExpressAd;
            if (tTNativeExpressAd != null) {
                tTNativeExpressAd.destroy();
            }
            this.ttNativeExpressAd = null;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public View getNativeExpressAdView() {
        TTNativeExpressAd tTNativeExpressAd = this.ttNativeExpressAd;
        if (tTNativeExpressAd != null) {
            return tTNativeExpressAd.getExpressAdView();
        }
        return null;
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public void render() {
        AMPSNativeAdapter aMPSNativeAdapter = this.adapter;
        if (aMPSNativeAdapter != null) {
            aMPSNativeAdapter.onRender();
        }
        TTNativeExpressAd tTNativeExpressAd = this.ttNativeExpressAd;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.render();
        }
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public void setAMPSNativeAdExpressListener(final AMPSNativeAdExpressListener aMPSNativeAdExpressListener) {
        TTNativeExpressAd tTNativeExpressAd = this.ttNativeExpressAd;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: xyz.adscope.amps.adapter.csj.data.CSJNativeAd.1
                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdClicked(View view, int i4) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadNativeAd onAdClicked");
                    if (CSJNativeAd.this.adapter != null) {
                        CSJNativeAd.this.adapter.onAdClicked();
                    }
                    AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                    if (aMPSNativeAdExpressListener2 != null) {
                        aMPSNativeAdExpressListener2.onAdClicked();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdShow(View view, int i4) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadNativeAd onAdShow");
                    if (CSJNativeAd.this.adapter != null) {
                        CSJNativeAd.this.adapter.onAdShow();
                    }
                    AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                    if (aMPSNativeAdExpressListener2 != null) {
                        aMPSNativeAdExpressListener2.onAdShow();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderFail(View view, String str, int i4) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadNativeAd onRenderFailmsg : " + str + " , code : " + i4);
                    if (CSJNativeAd.this.adapter != null) {
                        CSJNativeAd.this.adapter.onAdShowFailed(String.valueOf(i4), str);
                        AMPSNativeAdapter aMPSNativeAdapter = CSJNativeAd.this.adapter;
                        aMPSNativeAdapter.onRenderFail(new AMPSError(i4 + "", str));
                    }
                    AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                    if (aMPSNativeAdExpressListener2 != null) {
                        aMPSNativeAdExpressListener2.onRenderFail(view, str, i4);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderSuccess(View view, float f4, float f5) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadNativeAd onRenderSuccess");
                    if (CSJNativeAd.this.adapter != null) {
                        CSJNativeAd.this.adapter.onRenderSuccess();
                    }
                    AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                    if (aMPSNativeAdExpressListener2 != null) {
                        aMPSNativeAdExpressListener2.onRenderSuccess(CSJNativeAd.this.getNativeExpressAdView(), f4, f5);
                    }
                }
            });
            this.ttNativeExpressAd.setDislikeCallback((Activity) this.context, new TTAdDislike.DislikeInteractionCallback() { // from class: xyz.adscope.amps.adapter.csj.data.CSJNativeAd.2
                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onCancel() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadNativeAd onCancel");
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onSelected(int i4, String str, boolean z3) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadNativeAd onSelected");
                    if (CSJNativeAd.this.adapter != null) {
                        CSJNativeAd.this.adapter.onAdDismiss();
                    }
                    AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                    if (aMPSNativeAdExpressListener2 != null) {
                        aMPSNativeAdExpressListener2.onAdClosed(CSJNativeAd.this.getNativeExpressAdView());
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onShow() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadNativeAd onShow");
                }
            });
        }
    }
}
