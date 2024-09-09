package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomInitConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationInitConfig {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36091c;

    /* renamed from: w  reason: collision with root package name */
    private ValueSet f36092w;
    private ValueSet xv;

    private MediationInitConfig(ValueSet valueSet) {
        this.f36091c = valueSet;
        if (valueSet != null) {
            this.xv = (ValueSet) valueSet.objectValue(8457, ValueSet.class);
            this.f36092w = (ValueSet) this.f36091c.objectValue(8475, ValueSet.class);
        }
        c();
    }

    public static MediationInitConfig create(ValueSet valueSet) {
        return new MediationInitConfig(valueSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double f() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.f36092w;
        if (valueSet == null || (bridge = (Bridge) valueSet.objectValue(8312, Bridge.class)) == null || (values = bridge.values()) == null) {
            return -1.0d;
        }
        return values.doubleValue(8481);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double r() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.f36092w;
        if (valueSet == null || (bridge = (Bridge) valueSet.objectValue(8312, Bridge.class)) == null || (values = bridge.values()) == null) {
            return -1.0d;
        }
        return values.doubleValue(8482);
    }

    private void sr() {
        MediationApiLog.i("---------  sdk \u9690\u79c1\u8bbe\u7f6e start ----");
        MediationApiLog.i("isCanUseLocation\uff1a" + isCanUseLocation());
        IMediationLocation location = getLocation();
        MediationApiLog.i("getLocation\uff1a" + location);
        if (location != null) {
            MediationApiLog.i("getLocation getLatitude\uff1a" + location.getLatitude());
            MediationApiLog.i("getLocation getLongitude\uff1a" + location.getLongitude());
        }
        MediationApiLog.i("appList\uff1a" + appList());
        MediationApiLog.i("isCanUsePhoneState\uff1a" + isCanUsePhoneState());
        MediationApiLog.i("isLimitPersonalAds\uff1a" + isLimitPersonalAds());
        MediationApiLog.i("getDevImei\uff1a" + getDevImei());
        MediationApiLog.i("isCanUseWifiState\uff1a" + isCanUseWifiState());
        MediationApiLog.i("getMacAddress\uff1a" + getMacAddress());
        MediationApiLog.i("isCanUseWriteExternal\uff1a" + isCanUseWriteExternal());
        MediationApiLog.i("isCanUseAndroidId\uff1a" + isCanUseAndroidId());
        MediationApiLog.i("getAndroidId\uff1a" + getAndroidId());
        List<String> appList = getAppList();
        MediationApiLog.i("getAppList\uff1a" + appList);
        if (appList != null) {
            Iterator<String> it = appList.iterator();
            while (it.hasNext()) {
                MediationApiLog.i("getAppList item: " + it.next());
            }
        }
        List<String> devImeis = getDevImeis();
        MediationApiLog.i("getDevImeis\uff1a" + devImeis);
        if (devImeis != null) {
            Iterator<String> it2 = devImeis.iterator();
            while (it2.hasNext()) {
                MediationApiLog.i("getDevImeis item: " + it2.next());
            }
        }
        MediationApiLog.i("getDevOaid\uff1a" + getDevOaid());
        MediationApiLog.i("isCanUseOaid\uff1a" + isCanUseOaid());
        MediationApiLog.i("isCanUseMacAddress\uff1a" + isCanUseMacAddress());
        MediationApiLog.i("isProgrammaticRecommend\uff1a" + isProgrammaticRecommend());
        MediationApiLog.i("isCanUsePermissionRecordAudio\uff1a" + isCanUsePermissionRecordAudio());
        MediationApiLog.i("---------  sdk \u9690\u79c1\u8bbe\u7f6e end ----");
    }

    private boolean ux() {
        ValueSet valueSet = this.f36091c;
        return (valueSet == null || valueSet.isEmpty()) ? false : true;
    }

    private void xv() {
        MediationApiLog.i("---------  sdk \u521d\u59cb\u5316\u4fe1\u606f start ----");
        MediationApiLog.i("isDebug\uff1a" + isDebug());
        MediationApiLog.i("getClassName\uff1a" + getClassName());
        MediationApiLog.i("getAppId\uff1a" + getAppId());
        MediationApiLog.i("getAppName\uff1a" + getAppName());
        MediationApiLog.i("getADNName\uff1a" + getADNName());
        MediationApiLog.i("getAppKey\uff1a" + getAppKey());
        MediationApiLog.i("getInitCallback\uff1a" + getInitCallback());
        MediationApiLog.i("getAgeGroup\uff1a" + getAgeGroup());
        MediationApiLog.i("isCustom\uff1a" + isCustom());
        MediationApiLog.i("getCustomInitConfig\uff1a" + getCustomInitConfig());
        MediationApiLog.i("getCustomInitMap\uff1a" + getCustomInitMap());
        MediationApiLog.i("getCustomGMConfiguration\uff1a" + getCustomGMConfiguration());
        MediationApiLog.i("getKsAdapterVersion\uff1a" + getKsAdapterVersion());
        MediationApiLog.i("getGromoreVersion\uff1a" + getGromoreVersion());
        MediationApiLog.i("getAdmobAdapterVersion\uff1a" + getAdmobAdapterVersion());
        MediationApiLog.i("getBaiduAdapterVersion\uff1a" + getBaiduAdapterVersion());
        MediationApiLog.i("getGdtAdapterVersion\uff1a" + getGdtAdapterVersion());
        MediationApiLog.i("getKlevinAdapterVersion\uff1a" + getKlevinAdapterVersion());
        MediationApiLog.i("getMintegralAdapterVersion\uff1a" + getMintegralAdapterVersion());
        MediationApiLog.i("getSigmobAdapterVersion\uff1a" + getSigmobAdapterVersion());
        MediationApiLog.i("getUnityAdapterVersion\uff1a" + getUnityAdapterVersion());
        MediationApiLog.i("getMap\uff1a" + getInitAdnMap());
        MediationApiLog.i("---------  sdk \u521d\u59cb\u5316\u4fe1\u606f end ----");
    }

    public boolean appList() {
        ValueSet valueSet = this.f36092w;
        if (valueSet != null) {
            return valueSet.booleanValue(8026);
        }
        return true;
    }

    public String getADNName() {
        return ux() ? this.f36091c.stringValue(8003) : "";
    }

    public String getAdmobAdapterVersion() {
        ValueSet valueSet = this.f36091c;
        return valueSet != null ? valueSet.stringValue(8412) : "";
    }

    public int getAgeGroup() {
        if (ux()) {
            return this.f36091c.intValue(7);
        }
        return 0;
    }

    public String getAndroidId() {
        ValueSet valueSet = this.f36092w;
        return valueSet != null ? valueSet.stringValue(8485) : "";
    }

    public String getAppId() {
        if (ux()) {
            return this.f36091c.stringValue(3);
        }
        return null;
    }

    public String getAppKey() {
        return ux() ? this.f36091c.stringValue(AVMDLDataLoader.KeyIsLiveWatchDurationThreshold) : "";
    }

    public List<String> getAppList() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.f36092w;
        if (valueSet != null && (bridge = (Bridge) valueSet.objectValue(8311, Bridge.class)) != null && (values = bridge.values()) != null) {
            return (List) values.objectValue(8476, List.class);
        }
        return new LinkedList();
    }

    public String getAppName() {
        return ux() ? this.f36091c.stringValue(8) : "";
    }

    public String getBaiduAdapterVersion() {
        ValueSet valueSet = this.f36091c;
        return valueSet != null ? valueSet.stringValue(8413) : "";
    }

    public String getClassName() {
        return ux() ? this.f36091c.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow) : "";
    }

    public Bridge getCustomGMConfiguration() {
        if (ux()) {
            return (Bridge) this.f36091c.objectValue(8401, Bridge.class);
        }
        return null;
    }

    public MediationCustomInitConfig getCustomInitConfig() {
        if (ux()) {
            return (MediationCustomInitConfig) this.f36091c.objectValue(8099, MediationCustomInitConfig.class);
        }
        return null;
    }

    public ValueSet getCustomInitConfigValueSet() {
        if (ux()) {
            return (ValueSet) this.f36091c.objectValue(8545, ValueSet.class);
        }
        return null;
    }

    public Map getCustomInitMap() {
        if (ux()) {
            return (Map) this.f36091c.objectValue(8400, Map.class);
        }
        return null;
    }

    public JSONObject getCustomLocalConfig() {
        ValueSet valueSet = this.xv;
        if (valueSet != null) {
            return (JSONObject) valueSet.objectValue(8463, JSONObject.class);
        }
        return null;
    }

    public String getDevImei() {
        ValueSet valueSet = this.f36092w;
        return valueSet != null ? valueSet.stringValue(8484) : "";
    }

    public List<String> getDevImeis() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.f36092w;
        if (valueSet != null && (bridge = (Bridge) valueSet.objectValue(8311, Bridge.class)) != null && (values = bridge.values()) != null) {
            return (List) values.objectValue(8477, List.class);
        }
        return new LinkedList();
    }

    public String getDevOaid() {
        ValueSet valueSet = this.f36092w;
        return valueSet != null ? valueSet.stringValue(8486) : "";
    }

    public String getGdtAdapterVersion() {
        ValueSet valueSet = this.f36091c;
        return valueSet != null ? valueSet.stringValue(8414) : "";
    }

    public String getGromoreVersion() {
        ValueSet valueSet = this.f36091c;
        return valueSet != null ? valueSet.stringValue(8411) : "";
    }

    public boolean getHttps() {
        ValueSet valueSet = this.xv;
        if (valueSet != null) {
            return valueSet.booleanValue(8458);
        }
        return false;
    }

    public Map getInitAdnMap() {
        ValueSet valueSet = this.f36091c;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8425, Map.class);
        }
        return new HashMap();
    }

    public Bridge getInitCallback() {
        if (ux()) {
            return (Bridge) this.f36091c.objectValue(8300, Bridge.class);
        }
        return null;
    }

    public String getKlevinAdapterVersion() {
        ValueSet valueSet = this.f36091c;
        return valueSet != null ? valueSet.stringValue(8415) : "";
    }

    public String getKsAdapterVersion() {
        ValueSet valueSet = this.f36091c;
        return valueSet != null ? valueSet.stringValue(8410) : "";
    }

    public Map getLocalExtra() {
        ValueSet valueSet = this.xv;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8462, Map.class);
        }
        return new HashMap();
    }

    public IMediationLocation getLocation() {
        if (f() == -1.0d || f() == -1.0d) {
            return null;
        }
        return new IMediationLocation() { // from class: com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig.1
            @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation
            public double getLatitude() {
                return MediationInitConfig.this.f();
            }

            @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation
            public double getLongitude() {
                return MediationInitConfig.this.r();
            }
        };
    }

    public String getMacAddress() {
        ValueSet valueSet = this.f36092w;
        return valueSet != null ? valueSet.stringValue(8487) : "";
    }

    public Bridge getMediationConfigUserInfoForSegment() {
        ValueSet valueSet = this.xv;
        if (valueSet != null) {
            return (Bridge) valueSet.objectValue(8310, Bridge.class);
        }
        return null;
    }

    public String getMintegralAdapterVersion() {
        ValueSet valueSet = this.f36091c;
        return valueSet != null ? valueSet.stringValue(8416) : "";
    }

    public String getOpensdkVer() {
        ValueSet valueSet = this.xv;
        return valueSet != null ? valueSet.stringValue(8464) : "";
    }

    public String getPublisherDid() {
        ValueSet valueSet = this.xv;
        return valueSet != null ? valueSet.stringValue(8460) : "";
    }

    public String getSigmobAdapterVersion() {
        ValueSet valueSet = this.f36091c;
        return valueSet != null ? valueSet.stringValue(8417) : "";
    }

    public String getUnityAdapterVersion() {
        ValueSet valueSet = this.f36091c;
        return valueSet != null ? valueSet.stringValue(8418) : "";
    }

    public ValueSet getValueSet() {
        return this.f36091c;
    }

    public String getWxAppId() {
        ValueSet valueSet = this.xv;
        return valueSet != null ? valueSet.stringValue(8459) : "";
    }

    public boolean isCanUseAndroidId() {
        ValueSet valueSet = this.f36092w;
        if (valueSet != null) {
            return valueSet.booleanValue(8479);
        }
        return true;
    }

    public boolean isCanUseLocation() {
        ValueSet valueSet = this.f36092w;
        if (valueSet != null) {
            return valueSet.booleanValue(8024);
        }
        return true;
    }

    public boolean isCanUseMacAddress() {
        return isCanUseWifiState();
    }

    public boolean isCanUseOaid() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.f36092w;
        if (valueSet == null || (bridge = (Bridge) valueSet.objectValue(8311, Bridge.class)) == null || (values = bridge.values()) == null) {
            return true;
        }
        return values.booleanValue(8478);
    }

    public boolean isCanUsePermissionRecordAudio() {
        ValueSet valueSet = this.f36092w;
        if (valueSet != null) {
            return valueSet.booleanValue(8549);
        }
        return true;
    }

    public boolean isCanUsePhoneState() {
        ValueSet valueSet = this.f36092w;
        if (valueSet != null) {
            return valueSet.booleanValue(8023);
        }
        return true;
    }

    public boolean isCanUseWifiState() {
        ValueSet valueSet = this.f36092w;
        if (valueSet != null) {
            return valueSet.booleanValue(8480);
        }
        return true;
    }

    public boolean isCanUseWriteExternal() {
        ValueSet valueSet = this.f36092w;
        if (valueSet != null) {
            return valueSet.booleanValue(8025);
        }
        return true;
    }

    public boolean isCustom() {
        if (ux()) {
            return this.f36091c.booleanValue(8098);
        }
        return false;
    }

    public boolean isDebug() {
        ValueSet valueSet = this.f36091c;
        if (valueSet != null) {
            return valueSet.booleanValue(1);
        }
        return false;
    }

    public boolean isLimitPersonalAds() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.f36092w;
        if (valueSet == null || (bridge = (Bridge) valueSet.objectValue(8311, Bridge.class)) == null || (values = bridge.values()) == null) {
            return false;
        }
        return values.booleanValue(8027);
    }

    public boolean isOpenAdnTest() {
        ValueSet valueSet = this.xv;
        if (valueSet != null) {
            return valueSet.booleanValue(8461);
        }
        return false;
    }

    public boolean isProgrammaticRecommend() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.f36092w;
        if (valueSet == null || (bridge = (Bridge) valueSet.objectValue(8311, Bridge.class)) == null || (values = bridge.values()) == null) {
            return true;
        }
        return values.booleanValue(8028);
    }

    public boolean isSupportH265() {
        ValueSet valueSet = this.xv;
        if (valueSet != null) {
            return valueSet.booleanValue(8466);
        }
        return false;
    }

    public boolean isSupportSplashZoomout() {
        ValueSet valueSet = this.xv;
        if (valueSet != null) {
            return valueSet.booleanValue(8467);
        }
        return false;
    }

    public boolean isWxInstalled() {
        ValueSet valueSet = this.xv;
        if (valueSet != null) {
            return valueSet.booleanValue(8465);
        }
        return false;
    }

    public void setMediationCustomControllerValueSet(ValueSet valueSet) {
        this.f36092w = valueSet;
        sr();
    }

    private void c() {
        MediationApiLog.setDebug(Boolean.valueOf(isDebug()));
        xv();
        sr();
        w();
    }

    private void w() {
        MediationApiLog.i("---------  sdk \u805a\u5408\u4fe1\u606f start ----");
        MediationApiLog.i("getHttps\uff1a" + getHttps());
        MediationApiLog.i("getWxAppId\uff1a" + getWxAppId());
        MediationApiLog.i("getPublisherDid\uff1a" + getPublisherDid());
        MediationApiLog.i("isOpenAdnTest\uff1a" + isOpenAdnTest());
        MediationApiLog.i("getMediationConfigUserInfoForSegment\uff1a" + getMediationConfigUserInfoForSegment());
        MediationApiLog.i("getLocalExtra\uff1a" + getLocalExtra());
        MediationApiLog.i("getCustomLocalConfig\uff1a" + getCustomLocalConfig());
        MediationApiLog.i("getOpensdkVer\uff1a" + getOpensdkVer());
        MediationApiLog.i("isWxInstalled\uff1a" + isWxInstalled());
        MediationApiLog.i("isSupportH265\uff1a" + isSupportH265());
        MediationApiLog.i("isSupportSplashZoomout\uff1a" + isSupportSplashZoomout());
        MediationApiLog.i("---------  sdk \u805a\u5408\u4fe1\u606f end ----");
    }
}
