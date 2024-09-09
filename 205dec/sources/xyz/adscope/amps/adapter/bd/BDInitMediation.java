package xyz.adscope.amps.adapter.bd;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.AdSettings;
import com.baidu.mobads.sdk.api.BDAdConfig;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import java.util.LinkedHashMap;
import xyz.adscope.amps.AMPSSDK;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.config.AMPSPrivacyConfig;
import xyz.adscope.amps.init.AMPSInitAdapterConfig;
import xyz.adscope.amps.init.inter.AMPSChannelInitMediation;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.tool.AMPSLogUtil;
import xyz.adscope.common.tool.utils.SystemUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class BDInitMediation extends AMPSChannelInitMediation {
    private static BDInitMediation instance;
    private static boolean isInit;

    private int getAdn(String str) {
        str.getClass();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case 1507456:
                if (str.equals(AMPSConstants.ChannelName.CHANNEL_NAME_GDT)) {
                    c4 = 0;
                    break;
                }
                break;
            case 1507457:
                if (str.equals(AMPSConstants.ChannelName.CHANNEL_NAME_CSJ)) {
                    c4 = 1;
                    break;
                }
                break;
            case 1507462:
                if (str.equals(AMPSConstants.ChannelName.CHANNEL_NAME_BD)) {
                    c4 = 2;
                    break;
                }
                break;
            case 1507463:
                if (str.equals(AMPSConstants.ChannelName.CHANNEL_NAME_KS)) {
                    c4 = 3;
                    break;
                }
                break;
            case 1507487:
                if (str.equals(AMPSConstants.ChannelName.CHANNEL_NAME_GM)) {
                    c4 = 4;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return 2;
            case 1:
            case 4:
                return 1;
            case 2:
                return 9;
            case 3:
                return 3;
            default:
                return 10;
        }
    }

    private int getAdnType(String str) {
        str.getClass();
        return !str.equals(AMPSConstants.BiddingType.BIDDING_TYPE_C2S) ? 10 : 3;
    }

    public static synchronized BDInitMediation getInstance() {
        BDInitMediation bDInitMediation;
        synchronized (BDInitMediation.class) {
            if (instance == null) {
                synchronized (BDInitMediation.class) {
                    instance = new BDInitMediation();
                }
            }
            bDInitMediation = instance;
        }
        return bDInitMediation;
    }

    private void initBDSDK(AMPSInitAdapterConfig aMPSInitAdapterConfig, IAMPSChannelInitCallBack iAMPSChannelInitCallBack) {
        Context context = AMPSSDK.getContext();
        if (context == null || aMPSInitAdapterConfig == null || TextUtils.isEmpty(aMPSInitAdapterConfig.getAppId())) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_INIT_ERROR;
            initSDKFail(iAMPSChannelInitCallBack, new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
            return;
        }
        String str = null;
        try {
            AMPSPrivacyConfig privacyConfig = aMPSInitAdapterConfig.getPrivacyConfig();
            if (privacyConfig != null) {
                if (privacyConfig.isCanUsePhoneState()) {
                    MobadsPermissionSettings.setPermissionReadDeviceID(true);
                    MobadsPermissionSettings.setPermissionDeviceInfo(true);
                } else {
                    MobadsPermissionSettings.setPermissionReadDeviceID(false);
                    MobadsPermissionSettings.setPermissionDeviceInfo(false);
                }
                MobadsPermissionSettings.setPermissionStorage(privacyConfig.isCanUseWriteExternal());
                MobadsPermissionSettings.setPermissionAppList(privacyConfig.isCanUseAppList());
                MobadsPermissionSettings.setPermissionLocation(privacyConfig.isCanUseLocation());
                MobadsPermissionSettings.setPermissionOAID(privacyConfig.isCanUseOaid());
            }
            if (!aMPSInitAdapterConfig.isPersonalRecommend()) {
                MobadsPermissionSettings.setLimitPersonalAds(true);
            }
            str = aMPSInitAdapterConfig.getAppId();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (TextUtils.isEmpty(str)) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum2 = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_INIT_ERROR;
            initSDKFail(iAMPSChannelInitCallBack, new AMPSError(channelErrorEnum2.getErrorCode(), channelErrorEnum2.getErrorMsg()));
            return;
        }
        new BDAdConfig.Builder().setAppsid(str).setDebug(false).build(context).init();
        isInit = true;
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK init success");
        initSDKSuccess(iAMPSChannelInitCallBack);
    }

    public int getLossReason(int i4) {
        if (i4 != 1) {
            if (i4 != 2) {
                return i4 != 3 ? 900 : 100;
            }
            return 201;
        }
        return 203;
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public String getNetworkName() {
        return "BD";
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public String getNetworkVersion() {
        return AdSettings.getSDKVersion();
    }

    public LinkedHashMap<String, Object> getSecondInfo(AMPSBidResult aMPSBidResult) {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        if (aMPSBidResult == null) {
            return linkedHashMap;
        }
        linkedHashMap.put("ecpm", Integer.valueOf(aMPSBidResult.getEcpm()));
        linkedHashMap.put("adn", Integer.valueOf(getAdn(aMPSBidResult.getChannelName())));
        linkedHashMap.put("ad_t", 7);
        linkedHashMap.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
        linkedHashMap.put("bid_t", Integer.valueOf(getAdnType(aMPSBidResult.getBidType())));
        return linkedHashMap;
    }

    public LinkedHashMap<String, Object> getWinInfo(AMPSBidResult aMPSBidResult) {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        if (aMPSBidResult == null) {
            return linkedHashMap;
        }
        linkedHashMap.put("ecpm", Integer.valueOf(aMPSBidResult.getEcpm()));
        linkedHashMap.put("adn", Integer.valueOf(getAdn(aMPSBidResult.getChannelName())));
        linkedHashMap.put("ad_t", 7);
        linkedHashMap.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
        linkedHashMap.put("bid_t", Integer.valueOf(getAdnType(aMPSBidResult.getBidType())));
        linkedHashMap.put("is_s", 2);
        linkedHashMap.put("is_c", 2);
        linkedHashMap.put("reason", Integer.valueOf(getLossReason(aMPSBidResult.getReason())));
        return linkedHashMap;
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public void initSDK(AMPSInitAdapterConfig aMPSInitAdapterConfig, IAMPSChannelInitCallBack iAMPSChannelInitCallBack) {
        if (!SystemUtil.hasSdk(AMPSConstants.CHANNEL_SDK_BAIDU_CLASSNAME)) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_SDK_NOT_IMPORT;
            initSDKFail(iAMPSChannelInitCallBack, new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
        } else if (isInit) {
            initSDKSuccess(iAMPSChannelInitCallBack);
        } else {
            initBDSDK(aMPSInitAdapterConfig, iAMPSChannelInitCallBack);
        }
    }
}
