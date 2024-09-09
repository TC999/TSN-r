package xyz.adscope.amps.adapter.gm;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdAdapterListener;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter;
import xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo;
import xyz.adscope.amps.adapter.gm.data.GMNativeAd;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class GMNativeAdapter extends AMPSNativeAdapter {
    private List<TTFeedAd> mTTAdList;
    private TTAdNative mTTAdNative;

    private void bindAdListener(TTFeedAd tTFeedAd) {
        if (tTFeedAd.getInteractionType() != 4) {
            return;
        }
        tTFeedAd.setDownloadListener(new TTAppDownloadListener() { // from class: xyz.adscope.amps.adapter.gm.GMNativeAdapter.3
            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long j4, long j5, String str, String str2) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadNativeAd onDownloadActive");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long j4, long j5, String str, String str2) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadNativeAd onDownloadFailed");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long j4, String str, String str2) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadNativeAd onDownloadFinished");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long j4, long j5, String str, String str2) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadNativeAd onDownloadPaused");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadNativeAd onIdle");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String str, String str2) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadNativeAd onInstalled");
            }
        });
    }

    private void initSDK() {
        GMInitMediation.getInstance().initSDK(this.mInitAdapterConfig, new IAMPSChannelInitCallBack() { // from class: xyz.adscope.amps.adapter.gm.GMNativeAdapter.1
            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void failCallBack(AMPSError aMPSError) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadNativeAd onSplashLoadFail code:" + aMPSError.getCode() + " message:" + aMPSError.getMessage());
                GMNativeAdapter.this.onAdFailed(aMPSError.getCode(), aMPSError.getMessage());
            }

            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void successCallBack() {
                GMNativeAdapter.this.loadNativeAd();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadNativeAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK start loadNativeAd  spaceId:" + this.mSpaceId);
        this.mTTAdNative = GMInitMediation.get().createAdNative(this.mContext);
        if (this.expressViewHeight <= 0) {
            this.expressViewHeight = 0;
        }
        this.mTTAdNative.loadFeedAd(new AdSlot.Builder().setCodeId(this.mSpaceId).setAdCount(this.adCount).setImageAcceptedSize(this.expressViewWidth, this.expressViewHeight).build(), new TTAdNative.FeedAdListener() { // from class: xyz.adscope.amps.adapter.gm.GMNativeAdapter.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onError(int i4, String str) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadNativeAd onNativeLoadFail code:" + i4 + " message:" + str);
                GMNativeAdapter gMNativeAdapter = GMNativeAdapter.this;
                StringBuilder sb = new StringBuilder();
                sb.append(i4);
                sb.append("");
                gMNativeAdapter.onAdFailed(sb.toString(), str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onFeedAdLoad(List<TTFeedAd> list) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadNativeAd onNativeExpressAdLoad");
                if (list != null && list.size() != 0) {
                    GMNativeAdapter.this.mTTAdList = list;
                    GMNativeAdapter.this.onAdLoad();
                    return;
                }
                GMNativeAdapter gMNativeAdapter = GMNativeAdapter.this;
                AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_IS_NULL;
                gMNativeAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        try {
            if (this.mTTAdNative != null) {
                this.mTTAdNative = null;
            }
            List<TTFeedAd> list = this.mTTAdList;
            if (list != null) {
                list.clear();
                this.mTTAdList = null;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public Map<String, Object> getMediaExtraInfo() {
        TTFeedAd tTFeedAd;
        List<TTFeedAd> list = this.mTTAdList;
        if (list == null || list.size() < 1 || (tTFeedAd = this.mTTAdList.get(0)) == null) {
            return null;
        }
        return tTFeedAd.getMediaExtraInfo();
    }

    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter
    public List<AMPSNativeAdExpressInfo> getNativeListInfo() {
        ArrayList arrayList = new ArrayList();
        List<TTFeedAd> list = this.mTTAdList;
        if (list != null && list.size() > 0) {
            for (TTFeedAd tTFeedAd : this.mTTAdList) {
                bindAdListener(tTFeedAd);
                arrayList.add(new GMNativeAd(tTFeedAd, this.mContext, this));
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
