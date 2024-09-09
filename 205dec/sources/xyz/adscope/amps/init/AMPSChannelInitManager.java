package xyz.adscope.amps.init;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSEnum;
import xyz.adscope.amps.init.inter.AMPSChannelInitMediation;
import xyz.adscope.amps.tool.AMPSAdapterFactory;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSChannelInitManager {
    private static AMPSChannelInitManager instance;
    private ConcurrentHashMap<String, Object> channelInitMap = new ConcurrentHashMap<>();
    private String mASNPSDKVersion;
    private String mBDSDKVersion;
    private String mBZSDKVersion;
    private String mCSJSDKVersion;
    private String mGDTSDKVersion;
    private String mGMSDKVersion;
    private String mHWSDKVersion;
    private String mKSSDKVersion;
    private String mQMSDKVersion;

    private AMPSChannelInitManager() {
    }

    public static synchronized AMPSChannelInitManager getInstance() {
        AMPSChannelInitManager aMPSChannelInitManager;
        synchronized (AMPSChannelInitManager.class) {
            if (instance == null) {
                synchronized (AMPSChannelInitManager.class) {
                    instance = new AMPSChannelInitManager();
                }
            }
            aMPSChannelInitManager = instance;
        }
        return aMPSChannelInitManager;
    }

    public String getASNPSDKVersion() {
        AMPSChannelInitMediation createAdapterInit;
        if (this.mASNPSDKVersion == null && (createAdapterInit = AMPSAdapterFactory.createAdapterInit(AMPSConstants.CHANNEL_ADAPTER_INIT_CLASSNAME_ASNP)) != null) {
            this.mASNPSDKVersion = createAdapterInit.getNetworkVersion();
        }
        return this.mASNPSDKVersion;
    }

    public String getBDSDKVersion() {
        AMPSChannelInitMediation createAdapterInit;
        if (this.mBDSDKVersion == null && (createAdapterInit = AMPSAdapterFactory.createAdapterInit(AMPSConstants.CHANNEL_ADAPTER_INIT_CLASSNAME_BD)) != null) {
            this.mBDSDKVersion = createAdapterInit.getNetworkVersion();
        }
        return this.mBDSDKVersion;
    }

    public String getBZSDKVersion() {
        AMPSChannelInitMediation createAdapterInit;
        if (this.mBZSDKVersion == null && (createAdapterInit = AMPSAdapterFactory.createAdapterInit(AMPSConstants.CHANNEL_ADAPTER_INIT_CLASSNAME_BZ)) != null) {
            this.mBZSDKVersion = createAdapterInit.getNetworkVersion();
        }
        return this.mBZSDKVersion;
    }

    public String getCSJSDKVersion() {
        AMPSChannelInitMediation createAdapterInit;
        if (this.mCSJSDKVersion == null && (createAdapterInit = AMPSAdapterFactory.createAdapterInit(AMPSConstants.CHANNEL_ADAPTER_INIT_CLASSNAME_CSJ)) != null) {
            this.mCSJSDKVersion = createAdapterInit.getNetworkVersion();
        }
        return this.mCSJSDKVersion;
    }

    public ConcurrentHashMap<String, Object> getChannelInitMap() {
        return this.channelInitMap;
    }

    public AMPSEnum.ChannelInitStatus getChannelInitStatus(String str) {
        if (this.channelInitMap == null || TextUtils.isEmpty(str) || !this.channelInitMap.containsKey(str) || !(this.channelInitMap.get(str) instanceof AMPSEnum.ChannelInitStatus)) {
            return null;
        }
        return (AMPSEnum.ChannelInitStatus) this.channelInitMap.get(str);
    }

    public String getChannelSdkVersion(String str) {
        if (this.channelInitMap == null || TextUtils.isEmpty(str) || !this.channelInitMap.containsKey(str) || !(this.channelInitMap.get(str) instanceof String)) {
            return null;
        }
        return (String) this.channelInitMap.get(str);
    }

    public String getGDTSDKVersion() {
        AMPSChannelInitMediation createAdapterInit;
        if (this.mGDTSDKVersion == null && (createAdapterInit = AMPSAdapterFactory.createAdapterInit(AMPSConstants.CHANNEL_ADAPTER_INIT_CLASSNAME_GDT)) != null) {
            this.mGDTSDKVersion = createAdapterInit.getNetworkVersion();
        }
        return this.mGDTSDKVersion;
    }

    public String getGMSDKVersion() {
        AMPSChannelInitMediation createAdapterInit;
        if (this.mGMSDKVersion == null && (createAdapterInit = AMPSAdapterFactory.createAdapterInit(AMPSConstants.CHANNEL_ADAPTER_INIT_CLASSNAME_GM)) != null) {
            this.mGMSDKVersion = createAdapterInit.getNetworkVersion();
        }
        return this.mGMSDKVersion;
    }

    public String getHWSDKVersion() {
        AMPSChannelInitMediation createAdapterInit;
        if (this.mHWSDKVersion == null && (createAdapterInit = AMPSAdapterFactory.createAdapterInit(AMPSConstants.CHANNEL_ADAPTER_INIT_CLASSNAME_HW)) != null) {
            this.mHWSDKVersion = createAdapterInit.getNetworkVersion();
        }
        return this.mHWSDKVersion;
    }

    public String getKSSDKVersion() {
        AMPSChannelInitMediation createAdapterInit;
        if (this.mKSSDKVersion == null && (createAdapterInit = AMPSAdapterFactory.createAdapterInit(AMPSConstants.CHANNEL_ADAPTER_INIT_CLASSNAME_KS)) != null) {
            this.mKSSDKVersion = createAdapterInit.getNetworkVersion();
        }
        return this.mKSSDKVersion;
    }

    public String getQMSDKVersion() {
        AMPSChannelInitMediation createAdapterInit;
        if (this.mQMSDKVersion == null && (createAdapterInit = AMPSAdapterFactory.createAdapterInit(AMPSConstants.CHANNEL_ADAPTER_INIT_CLASSNAME_QM)) != null) {
            this.mQMSDKVersion = createAdapterInit.getNetworkVersion();
        }
        return this.mQMSDKVersion;
    }

    public void putChannelInitStatus(String str, AMPSEnum.ChannelInitStatus channelInitStatus) {
        if (this.channelInitMap == null) {
            this.channelInitMap = new ConcurrentHashMap<>();
        }
        this.channelInitMap.put(str, channelInitStatus);
    }

    public void putChannelSdkVersion(String str, String str2) {
        if (this.channelInitMap == null) {
            this.channelInitMap = new ConcurrentHashMap<>();
        }
        this.channelInitMap.put(str, str2);
    }
}
