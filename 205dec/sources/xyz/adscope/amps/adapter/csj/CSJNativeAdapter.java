package xyz.adscope.amps.adapter.csj;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdAdapterListener;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter;
import xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo;
import xyz.adscope.amps.adapter.csj.data.CSJNativeAd;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class CSJNativeAdapter extends AMPSNativeAdapter {
    private List<TTNativeExpressAd> mTTAdList;
    private TTAdNative mTTAdNative;

    private void bindAdListener(TTNativeExpressAd tTNativeExpressAd) {
        if (tTNativeExpressAd.getInteractionType() != 4) {
            return;
        }
        tTNativeExpressAd.setDownloadListener(new TTAppDownloadListener() { // from class: xyz.adscope.amps.adapter.csj.CSJNativeAdapter.3
            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long j4, long j5, String str, String str2) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadNativeAd onDownloadActive");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long j4, long j5, String str, String str2) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadNativeAd onDownloadFailed");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long j4, String str, String str2) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadNativeAd onDownloadFinished");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long j4, long j5, String str, String str2) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadNativeAd onDownloadPaused");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadNativeAd onIdle");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String str, String str2) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadNativeAd onInstalled");
            }
        });
    }

    private void initSDK() {
        CSJInitMediation.getInstance().initSDK(this.mInitAdapterConfig, new IAMPSChannelInitCallBack() { // from class: xyz.adscope.amps.adapter.csj.CSJNativeAdapter.1
            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void failCallBack(AMPSError aMPSError) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadNativeAd onSplashLoadFail code:" + aMPSError.getCode() + " message:" + aMPSError.getMessage());
                CSJNativeAdapter.this.onAdFailed(aMPSError.getCode(), aMPSError.getMessage());
            }

            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void successCallBack() {
                CSJNativeAdapter.this.loadNativeAd();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadNativeAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK start loadNativeAd  spaceId:" + this.mSpaceId);
        this.mTTAdNative = CSJInitMediation.get().createAdNative(this.mContext);
        CSJInitMediation.get().requestPermissionIfNecessary(this.mContext);
        if (this.expressViewHeightDp <= 0) {
            this.expressViewHeightDp = 0;
        }
        this.mTTAdNative.loadNativeExpressAd(new AdSlot.Builder().setCodeId(this.mSpaceId).setAdCount(this.adCount).setExpressViewAcceptedSize(this.expressViewWidthDp, this.expressViewHeightDp).build(), new TTAdNative.NativeExpressAdListener() { // from class: xyz.adscope.amps.adapter.csj.CSJNativeAdapter.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i4, String str) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadNativeAd onError code:" + i4 + " message:" + str);
                CSJNativeAdapter cSJNativeAdapter = CSJNativeAdapter.this;
                StringBuilder sb = new StringBuilder();
                sb.append(i4);
                sb.append("");
                cSJNativeAdapter.onAdFailed(sb.toString(), str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadNativeAd onNativeExpressAdLoad");
                if (list != null && list.size() != 0) {
                    CSJNativeAdapter.this.mTTAdList = list;
                    CSJNativeAdapter.this.onAdLoad();
                    return;
                }
                CSJNativeAdapter cSJNativeAdapter = CSJNativeAdapter.this;
                AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_IS_NULL;
                cSJNativeAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        if (this.mTTAdNative != null) {
            this.mTTAdNative = null;
        }
        List<TTNativeExpressAd> list = this.mTTAdList;
        if (list != null) {
            list.clear();
            this.mTTAdList = null;
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public Map<String, Object> getMediaExtraInfo() {
        TTNativeExpressAd tTNativeExpressAd;
        List<TTNativeExpressAd> list = this.mTTAdList;
        if (list == null || list.size() < 1 || (tTNativeExpressAd = this.mTTAdList.get(0)) == null) {
            return null;
        }
        return tTNativeExpressAd.getMediaExtraInfo();
    }

    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter
    public List<AMPSNativeAdExpressInfo> getNativeListInfo() {
        ArrayList arrayList = new ArrayList();
        List<TTNativeExpressAd> list = this.mTTAdList;
        if (list != null && list.size() > 0) {
            for (TTNativeExpressAd tTNativeExpressAd : this.mTTAdList) {
                bindAdListener(tTNativeExpressAd);
                arrayList.add(new CSJNativeAd(tTNativeExpressAd, this.mContext, this));
            }
        }
        return arrayList;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.mTTAdNative != null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSNativeAdAdapterListener aMPSNativeAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSNativeAdAdapterListener);
        initSDK();
    }
}
