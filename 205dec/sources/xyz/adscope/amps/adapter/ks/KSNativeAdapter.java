package xyz.adscope.amps.adapter.ks;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdAdapterListener;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter;
import xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo;
import xyz.adscope.amps.adapter.ks.data.KSNativeAd;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class KSNativeAdapter extends AMPSNativeAdapter {
    private List<KsFeedAd> iNativeAdViews;

    private void initSDK() {
        KSInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
        loadNativeAd();
    }

    private void loadNativeAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK start loadNativeAd spaceId:" + this.mSpaceId);
        KsAdSDK.getLoadManager().loadConfigFeedAd(new KsScene.Builder(Long.parseLong(this.mSpaceId)).width(this.expressViewWidth).adNum(this.adCount).build(), new KsLoadManager.FeedAdListener() { // from class: xyz.adscope.amps.adapter.ks.KSNativeAdapter.1
            @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
            public void onError(int i4, String str) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadNativeAd onError code:" + i4 + " message:" + str + " spaceId:" + KSNativeAdapter.this.mSpaceId);
                KSNativeAdapter kSNativeAdapter = KSNativeAdapter.this;
                StringBuilder sb = new StringBuilder();
                sb.append(i4);
                sb.append("");
                kSNativeAdapter.onAdFailed(sb.toString(), str);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
            public void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadNativeAd onFeedAdLoad");
                if (list == null || list.size() == 0) {
                    KSNativeAdapter kSNativeAdapter = KSNativeAdapter.this;
                    AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_IS_NULL;
                    kSNativeAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
                    return;
                }
                KSNativeAdapter.this.iNativeAdViews = list;
                KsFeedAd ksFeedAd = (KsFeedAd) KSNativeAdapter.this.iNativeAdViews.get(0);
                int ecpm = ksFeedAd != null ? ksFeedAd.getECPM() : 0;
                KSNativeAdapter kSNativeAdapter2 = KSNativeAdapter.this;
                if (kSNativeAdapter2.isBidding) {
                    kSNativeAdapter2.onC2SBiddingSuccess(ecpm);
                } else {
                    kSNativeAdapter2.onAdLoad();
                }
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        List<KsFeedAd> list = this.iNativeAdViews;
        if (list != null) {
            list.clear();
            this.iNativeAdViews = null;
        }
    }

    public KsFeedAd getKsFeedAd() {
        KsFeedAd ksFeedAd;
        List<KsFeedAd> list = this.iNativeAdViews;
        if (list == null || list.size() == 0 || (ksFeedAd = this.iNativeAdViews.get(0)) == null) {
            return null;
        }
        return ksFeedAd;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public Map<String, Object> getMediaExtraInfo() {
        KsFeedAd ksFeedAd = getKsFeedAd();
        if (ksFeedAd != null) {
            ksFeedAd.getMediaExtraInfo();
            return null;
        }
        return null;
    }

    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter
    public List<AMPSNativeAdExpressInfo> getNativeListInfo() {
        ArrayList arrayList = new ArrayList();
        List<KsFeedAd> list = this.iNativeAdViews;
        if (list != null && list.size() > 0) {
            for (KsFeedAd ksFeedAd : this.iNativeAdViews) {
                arrayList.add(new KSNativeAd(ksFeedAd, this, this.mContext));
            }
        }
        return arrayList;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        List<KsFeedAd> list = this.iNativeAdViews;
        return (list == null || list.size() == 0) ? false : true;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSNativeAdAdapterListener aMPSNativeAdAdapterListener) {
        List<KsFeedAd> list;
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSNativeAdAdapterListener);
        if (!this.isBidding || (list = this.iNativeAdViews) == null || list.size() <= 0) {
            initSDK();
        } else {
            onAdLoad();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        try {
            KsFeedAd ksFeedAd = getKsFeedAd();
            if (ksFeedAd != null && aMPSBidResult != null) {
                KSAdManagerHolder.sendLossNotification(ksFeedAd, aMPSBidResult.getReason());
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        try {
            KsFeedAd ksFeedAd = getKsFeedAd();
            if (ksFeedAd == null) {
                return;
            }
            KSAdManagerHolder.sendWinNotification(ksFeedAd, ksFeedAd.getECPM());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
    }
}
