package xyz.adscope.amps.adapter.gdt;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdAdapterListener;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdExpressListener;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter;
import xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo;
import xyz.adscope.amps.adapter.gdt.data.GDTNativeAd;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class GDTNativeAdapter extends AMPSNativeAdapter {
    public Map<View, AMPSNativeAdExpressListener> ampsNativeAdExpressListenerMap = new HashMap();
    private List<NativeExpressADView> iNativeAdViews;
    private NativeExpressAD nativeExpressAD;

    @NonNull
    public static LoadAdParams getLoadAdParams(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("custom_key", str);
        hashMap.put("staIn", "com.qq.e.demo");
        hashMap.put("thrmei", "29232329");
        LoadAdParams loadAdParams = new LoadAdParams();
        loadAdParams.setDevExtra(hashMap);
        return loadAdParams;
    }

    private ADSize getMyADSize() {
        return new ADSize(this.expressViewWidthDp, this.expressViewHeightDp);
    }

    private void initSDK() {
        GDTInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
        loadNativeAd();
    }

    private void loadNativeAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK start loadNativeAd spaceId:" + this.mSpaceId);
        NativeExpressAD nativeExpressAD = new NativeExpressAD(this.mContext, getMyADSize(), this.mSpaceId, new NativeExpressAD.NativeExpressADListener() { // from class: xyz.adscope.amps.adapter.gdt.GDTNativeAdapter.1
            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADClicked(NativeExpressADView nativeExpressADView) {
                AMPSNativeAdExpressListener aMPSNativeAdExpressListener;
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadNativeAd onADClicked");
                GDTNativeAdapter.this.onAdClicked();
                Map<View, AMPSNativeAdExpressListener> map = GDTNativeAdapter.this.ampsNativeAdExpressListenerMap;
                if (map == null || (aMPSNativeAdExpressListener = map.get(nativeExpressADView)) == null) {
                    return;
                }
                aMPSNativeAdExpressListener.onAdClicked();
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADClosed(NativeExpressADView nativeExpressADView) {
                AMPSNativeAdExpressListener aMPSNativeAdExpressListener;
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadNativeAd onADClosed");
                GDTNativeAdapter.this.onAdDismiss();
                Map<View, AMPSNativeAdExpressListener> map = GDTNativeAdapter.this.ampsNativeAdExpressListenerMap;
                if (map == null || (aMPSNativeAdExpressListener = map.get(nativeExpressADView)) == null) {
                    return;
                }
                aMPSNativeAdExpressListener.onAdClosed(nativeExpressADView);
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADExposure(NativeExpressADView nativeExpressADView) {
                AMPSNativeAdExpressListener aMPSNativeAdExpressListener;
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadNativeAd onADExposure");
                GDTNativeAdapter.this.onAdShow();
                Map<View, AMPSNativeAdExpressListener> map = GDTNativeAdapter.this.ampsNativeAdExpressListenerMap;
                if (map == null || (aMPSNativeAdExpressListener = map.get(nativeExpressADView)) == null) {
                    return;
                }
                aMPSNativeAdExpressListener.onAdShow();
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadNativeAd onADLeftApplication");
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADLoaded(List<NativeExpressADView> list) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadNativeAd onADLoaded");
                if (list == null || list.size() < 1) {
                    GDTNativeAdapter gDTNativeAdapter = GDTNativeAdapter.this;
                    AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_IS_NULL;
                    gDTNativeAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
                    return;
                }
                GDTNativeAdapter.this.iNativeAdViews = list;
                NativeExpressADView nativeExpressADView = (NativeExpressADView) GDTNativeAdapter.this.iNativeAdViews.get(0);
                int ecpm = nativeExpressADView != null ? nativeExpressADView.getECPM() : 0;
                GDTNativeAdapter gDTNativeAdapter2 = GDTNativeAdapter.this;
                if (gDTNativeAdapter2.isBidding) {
                    gDTNativeAdapter2.onC2SBiddingSuccess(ecpm);
                } else {
                    gDTNativeAdapter2.onAdLoad();
                }
            }

            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(AdError adError) {
                String str;
                String str2 = "";
                if (adError != null) {
                    str2 = adError.getErrorCode() + "";
                    str = adError.getErrorMsg();
                } else {
                    str = "";
                }
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadNativeAd onNoAD code:" + str2 + ";msg:" + str);
                GDTNativeAdapter.this.onAdFailed(str2, str);
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onRenderFail(NativeExpressADView nativeExpressADView) {
                AMPSNativeAdExpressListener aMPSNativeAdExpressListener;
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadNativeAd onRenderFail");
                GDTNativeAdapter gDTNativeAdapter = GDTNativeAdapter.this;
                AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_RENDER_FAIL;
                gDTNativeAdapter.onAdShowFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
                GDTNativeAdapter.this.onRenderFail(new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
                Map<View, AMPSNativeAdExpressListener> map = GDTNativeAdapter.this.ampsNativeAdExpressListenerMap;
                if (map == null || (aMPSNativeAdExpressListener = map.get(nativeExpressADView)) == null) {
                    return;
                }
                aMPSNativeAdExpressListener.onRenderFail(nativeExpressADView, channelErrorEnum.getErrorMsg(), Integer.parseInt(channelErrorEnum.getErrorCode()));
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
                AMPSNativeAdExpressListener aMPSNativeAdExpressListener;
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadNativeAd onRenderSuccess");
                GDTNativeAdapter.this.onRenderSuccess();
                Map<View, AMPSNativeAdExpressListener> map = GDTNativeAdapter.this.ampsNativeAdExpressListenerMap;
                if (map == null || (aMPSNativeAdExpressListener = map.get(nativeExpressADView)) == null) {
                    return;
                }
                aMPSNativeAdExpressListener.onRenderSuccess(nativeExpressADView, 0.0f, 0.0f);
            }
        });
        this.nativeExpressAD = nativeExpressAD;
        nativeExpressAD.loadAD(this.adCount, null);
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        try {
            if (this.nativeExpressAD != null) {
                this.nativeExpressAD = null;
            }
            List<NativeExpressADView> list = this.iNativeAdViews;
            if (list != null) {
                list.clear();
                this.iNativeAdViews = null;
            }
            Map<View, AMPSNativeAdExpressListener> map = this.ampsNativeAdExpressListenerMap;
            if (map != null) {
                map.clear();
                this.ampsNativeAdExpressListenerMap = null;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public Map<String, Object> getMediaExtraInfo() {
        NativeExpressADView nativeExpressADView;
        List<NativeExpressADView> list = this.iNativeAdViews;
        if (list == null || list.size() < 1 || (nativeExpressADView = this.iNativeAdViews.get(0)) == null) {
            return null;
        }
        return nativeExpressADView.getExtraInfo();
    }

    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter
    public List<AMPSNativeAdExpressInfo> getNativeListInfo() {
        ArrayList arrayList = new ArrayList();
        List<NativeExpressADView> list = this.iNativeAdViews;
        if (list != null && list.size() > 0) {
            for (NativeExpressADView nativeExpressADView : this.iNativeAdViews) {
                arrayList.add(new GDTNativeAd(nativeExpressADView, this));
            }
        }
        return arrayList;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        if (this.nativeExpressAD == null) {
            return false;
        }
        NativeExpressADView nativeExpressADView = null;
        List<NativeExpressADView> list = this.iNativeAdViews;
        if (list != null && list.size() > 0) {
            nativeExpressADView = this.iNativeAdViews.get(0);
        }
        if (nativeExpressADView == null) {
            return false;
        }
        return nativeExpressADView.isValid();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSNativeAdAdapterListener aMPSNativeAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSNativeAdAdapterListener);
        if (!this.isBidding || this.nativeExpressAD == null) {
            initSDK();
        } else {
            onAdLoad();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        NativeExpressADView nativeExpressADView;
        try {
            List<NativeExpressADView> list = this.iNativeAdViews;
            if (list == null || list.size() == 0 || aMPSBidResult == null || (nativeExpressADView = this.iNativeAdViews.get(0)) == null) {
                return;
            }
            GDTAdManagerHolder.sendLossNotification(nativeExpressADView, aMPSBidResult.getReason());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        NativeExpressADView nativeExpressADView;
        try {
            List<NativeExpressADView> list = this.iNativeAdViews;
            if (list == null || list.size() == 0 || (nativeExpressADView = this.iNativeAdViews.get(0)) == null) {
                return;
            }
            GDTAdManagerHolder.sendWinNotification(nativeExpressADView, nativeExpressADView.getECPM());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setAMPSNativeAdExpressListener(View view, AMPSNativeAdExpressListener aMPSNativeAdExpressListener) {
        this.ampsNativeAdExpressListenerMap.put(view, aMPSNativeAdExpressListener);
    }

    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
    }
}
