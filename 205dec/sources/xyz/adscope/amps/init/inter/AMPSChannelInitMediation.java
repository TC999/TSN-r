package xyz.adscope.amps.init.inter;

import java.util.List;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.init.AMPSInitAdapterConfig;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public abstract class AMPSChannelInitMediation {
    public List getActivityStatus() {
        return null;
    }

    public List getMetaValutStatus() {
        return null;
    }

    public String getNetworkName() {
        return "";
    }

    public String getNetworkSDKClass() {
        return "";
    }

    public String getNetworkVersion() {
        return "";
    }

    public Map<String, Boolean> getPluginClassStatus() {
        return null;
    }

    public List getProviderStatus() {
        return null;
    }

    public List getServiceStatus() {
        return null;
    }

    public abstract void initSDK(AMPSInitAdapterConfig aMPSInitAdapterConfig, IAMPSChannelInitCallBack iAMPSChannelInitCallBack);

    public void initSDKFail(IAMPSChannelInitCallBack iAMPSChannelInitCallBack, AMPSError aMPSError) {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, getNetworkName() + "SDK init fail code:" + aMPSError.getCode() + "; message:" + aMPSError.getMessage());
        if (iAMPSChannelInitCallBack != null) {
            iAMPSChannelInitCallBack.failCallBack(aMPSError);
        }
    }

    public void initSDKSuccess(IAMPSChannelInitCallBack iAMPSChannelInitCallBack) {
        if (iAMPSChannelInitCallBack != null) {
            iAMPSChannelInitCallBack.successCallBack();
        }
    }
}
