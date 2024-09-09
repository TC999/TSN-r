package xyz.adscope.amps.adapter.gm;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.ad.banner.adapter.AMPSBannerAdAdapterListener;
import xyz.adscope.amps.ad.banner.adapter.AMPSBannerAdapter;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class GMBannerAdapter extends AMPSBannerAdapter {
    private TTAdNative csjAdNative;
    private TTNativeExpressAd mTTBannerAd;

    private void bindAdListener(TTNativeExpressAd tTNativeExpressAd) {
        tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: xyz.adscope.amps.adapter.gm.GMBannerAdapter.3
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i4) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadBannerAd onAdClicked");
                GMBannerAdapter.this.onAdClicked();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i4) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadBannerAd onAdShow");
                GMBannerAdapter.this.onAdShow();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i4) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadBannerAd onRenderFail");
                GMBannerAdapter.this.onAdShowFailed(String.valueOf(i4), str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f4, float f5) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadBannerAd onRenderSuccess");
            }
        });
        Context context = this.mContext;
        if (context != null) {
            tTNativeExpressAd.setDislikeCallback((Activity) context, new TTAdDislike.DislikeInteractionCallback() { // from class: xyz.adscope.amps.adapter.gm.GMBannerAdapter.4
                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onCancel() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onSelected(int i4, String str, boolean z3) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadBannerAd onSelected");
                    GMBannerAdapter.this.onAdDismiss();
                    if (GMBannerAdapter.this.mTTBannerAd != null) {
                        GMBannerAdapter.this.mTTBannerAd.destroy();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onShow() {
                }
            });
        }
    }

    private void initSDK() {
        GMInitMediation.getInstance().initSDK(this.mInitAdapterConfig, new IAMPSChannelInitCallBack() { // from class: xyz.adscope.amps.adapter.gm.GMBannerAdapter.1
            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void failCallBack(AMPSError aMPSError) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadBannerAd onSplashLoadFail code:" + aMPSError.getCode() + " message:" + aMPSError.getMessage());
                GMBannerAdapter.this.onAdFailed(aMPSError.getCode(), aMPSError.getMessage());
            }

            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void successCallBack() {
                GMBannerAdapter.this.loadBannerAd();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadBannerAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK start loadBannerAd  spaceId:" + this.mSpaceId);
        this.csjAdNative = GMInitMediation.get().createAdNative(this.mContext);
        this.csjAdNative.loadBannerExpressAd(new AdSlot.Builder().setCodeId(this.mSpaceId).setImageAcceptedSize(this.expressViewWidth, this.expressViewHeight).build(), new TTAdNative.NativeExpressAdListener() { // from class: xyz.adscope.amps.adapter.gm.GMBannerAdapter.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i4, String str) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadBannerAd onError code:" + i4 + " message:" + str);
                GMBannerAdapter.this.onAdFailed(String.valueOf(i4), str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadBannerAd onNativeExpressAdLoad");
                if (list == null || list.size() == 0) {
                    GMBannerAdapter gMBannerAdapter = GMBannerAdapter.this;
                    AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_IS_NULL;
                    gMBannerAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
                    return;
                }
                if (GMBannerAdapter.this.mTTBannerAd != null) {
                    GMBannerAdapter.this.mTTBannerAd.destroy();
                }
                GMBannerAdapter.this.mTTBannerAd = list.get(0);
                GMBannerAdapter.this.onAdLoad();
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        TTNativeExpressAd tTNativeExpressAd = this.mTTBannerAd;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
        }
        this.csjAdNative = null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public Map<String, Object> getMediaExtraInfo() {
        TTNativeExpressAd tTNativeExpressAd = this.mTTBannerAd;
        if (tTNativeExpressAd != null) {
            return tTNativeExpressAd.getMediaExtraInfo();
        }
        return null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.mTTBannerAd != null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.banner.adapter.AMPSBannerAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSBannerAdAdapterListener aMPSBannerAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSBannerAdAdapterListener);
        initSDK();
    }

    @Override // xyz.adscope.amps.ad.banner.adapter.AMPSBannerAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(ViewGroup viewGroup) {
        if (viewGroup == null) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_CONTAINER_NULL;
            onAdShowFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
            return;
        }
        bindAdListener(this.mTTBannerAd);
        View expressAdView = this.mTTBannerAd.getExpressAdView();
        if (expressAdView == null) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum2 = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_CONTAINER_NULL;
            onAdShowFailed(channelErrorEnum2.getErrorCode(), channelErrorEnum2.getErrorMsg());
            return;
        }
        viewGroup.removeAllViews();
        viewGroup.addView(expressAdView);
    }
}
