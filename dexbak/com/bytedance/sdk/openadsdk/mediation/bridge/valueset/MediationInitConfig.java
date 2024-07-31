package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomInitConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import p655w1.C16237a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MediationInitConfig {

    /* renamed from: a */
    private ValueSet f22751a;

    /* renamed from: bl */
    private ValueSet f22752bl;

    /* renamed from: ok */
    private ValueSet f22753ok;

    private MediationInitConfig(ValueSet valueSet) {
        this.f22753ok = valueSet;
        if (valueSet != null) {
            this.f22752bl = (ValueSet) valueSet.objectValue(8457, ValueSet.class);
            this.f22751a = (ValueSet) this.f22753ok.objectValue(8475, ValueSet.class);
        }
        m36257ok();
    }

    /* renamed from: bl */
    private void m36261bl() {
        MediationApiLog.m36298i("---------  sdk 初始化信息 start ----");
        MediationApiLog.m36298i("isDebug：" + isDebug());
        MediationApiLog.m36298i("getClassName：" + getClassName());
        MediationApiLog.m36298i("getAppId：" + getAppId());
        MediationApiLog.m36298i("getAppName：" + getAppName());
        MediationApiLog.m36298i("getADNName：" + getADNName());
        MediationApiLog.m36298i("getAppKey：" + getAppKey());
        MediationApiLog.m36298i("getInitCallback：" + getInitCallback());
        MediationApiLog.m36298i("getAgeGroup：" + getAgeGroup());
        MediationApiLog.m36298i("isCustom：" + isCustom());
        MediationApiLog.m36298i("getCustomInitConfig：" + getCustomInitConfig());
        MediationApiLog.m36298i("getCustomInitMap：" + getCustomInitMap());
        MediationApiLog.m36298i("getCustomGMConfiguration：" + getCustomGMConfiguration());
        MediationApiLog.m36298i("getKsAdapterVersion：" + getKsAdapterVersion());
        MediationApiLog.m36298i("getGromoreVersion：" + getGromoreVersion());
        MediationApiLog.m36298i("getAdmobAdapterVersion：" + getAdmobAdapterVersion());
        MediationApiLog.m36298i("getBaiduAdapterVersion：" + getBaiduAdapterVersion());
        MediationApiLog.m36298i("getGdtAdapterVersion：" + getGdtAdapterVersion());
        MediationApiLog.m36298i("getKlevinAdapterVersion：" + getKlevinAdapterVersion());
        MediationApiLog.m36298i("getMintegralAdapterVersion：" + getMintegralAdapterVersion());
        MediationApiLog.m36298i("getSigmobAdapterVersion：" + getSigmobAdapterVersion());
        MediationApiLog.m36298i("getUnityAdapterVersion：" + getUnityAdapterVersion());
        MediationApiLog.m36298i("getMap：" + getInitAdnMap());
        MediationApiLog.m36298i("---------  sdk 初始化信息 end ----");
    }

    public static MediationInitConfig create(ValueSet valueSet) {
        return new MediationInitConfig(valueSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public double m36260h() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.f22751a;
        if (valueSet == null || (bridge = (Bridge) valueSet.objectValue(8312, Bridge.class)) == null || (values = bridge.values()) == null) {
            return -1.0d;
        }
        return values.doubleValue(8482);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: kf */
    public double m36259kf() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.f22751a;
        if (valueSet == null || (bridge = (Bridge) valueSet.objectValue(8312, Bridge.class)) == null || (values = bridge.values()) == null) {
            return -1.0d;
        }
        return values.doubleValue(8481);
    }

    /* renamed from: n */
    private boolean m36258n() {
        ValueSet valueSet = this.f22753ok;
        return (valueSet == null || valueSet.isEmpty()) ? false : true;
    }

    /* renamed from: s */
    private void m36255s() {
        MediationApiLog.m36298i("---------  sdk 隐私设置 start ----");
        MediationApiLog.m36298i("isCanUseLocation：" + isCanUseLocation());
        IMediationLocation location = getLocation();
        MediationApiLog.m36298i("getLocation：" + location);
        if (location != null) {
            MediationApiLog.m36298i("getLocation getLatitude：" + location.getLatitude());
            MediationApiLog.m36298i("getLocation getLongitude：" + location.getLongitude());
        }
        MediationApiLog.m36298i("appList：" + appList());
        MediationApiLog.m36298i("isCanUsePhoneState：" + isCanUsePhoneState());
        MediationApiLog.m36298i("isLimitPersonalAds：" + isLimitPersonalAds());
        MediationApiLog.m36298i("getDevImei：" + getDevImei());
        MediationApiLog.m36298i("isCanUseWifiState：" + isCanUseWifiState());
        MediationApiLog.m36298i("getMacAddress：" + getMacAddress());
        MediationApiLog.m36298i("isCanUseWriteExternal：" + isCanUseWriteExternal());
        MediationApiLog.m36298i("isCanUseAndroidId：" + isCanUseAndroidId());
        MediationApiLog.m36298i("getAndroidId：" + getAndroidId());
        List<String> appList = getAppList();
        MediationApiLog.m36298i("getAppList：" + appList);
        if (appList != null) {
            Iterator<String> it = appList.iterator();
            while (it.hasNext()) {
                MediationApiLog.m36298i("getAppList item: " + it.next());
            }
        }
        List<String> devImeis = getDevImeis();
        MediationApiLog.m36298i("getDevImeis：" + devImeis);
        if (devImeis != null) {
            Iterator<String> it2 = devImeis.iterator();
            while (it2.hasNext()) {
                MediationApiLog.m36298i("getDevImeis item: " + it2.next());
            }
        }
        MediationApiLog.m36298i("getDevOaid：" + getDevOaid());
        MediationApiLog.m36298i("isCanUseOaid：" + isCanUseOaid());
        MediationApiLog.m36298i("isCanUseMacAddress：" + isCanUseMacAddress());
        MediationApiLog.m36298i("isProgrammaticRecommend：" + isProgrammaticRecommend());
        MediationApiLog.m36298i("isCanUsePermissionRecordAudio：" + isCanUsePermissionRecordAudio());
        MediationApiLog.m36298i("---------  sdk 隐私设置 end ----");
    }

    public boolean appList() {
        ValueSet valueSet = this.f22751a;
        if (valueSet != null) {
            return valueSet.booleanValue(8026);
        }
        return true;
    }

    public String getADNName() {
        return m36258n() ? this.f22753ok.stringValue(C16237a.f47148e) : "";
    }

    public String getAdmobAdapterVersion() {
        ValueSet valueSet = this.f22753ok;
        return valueSet != null ? valueSet.stringValue(8412) : "";
    }

    public int getAgeGroup() {
        if (m36258n()) {
            return this.f22753ok.intValue(7);
        }
        return 0;
    }

    public String getAndroidId() {
        ValueSet valueSet = this.f22751a;
        return valueSet != null ? valueSet.stringValue(8485) : "";
    }

    public String getAppId() {
        if (m36258n()) {
            return this.f22753ok.stringValue(3);
        }
        return null;
    }

    public String getAppKey() {
        return m36258n() ? this.f22753ok.stringValue(8005) : "";
    }

    public List<String> getAppList() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.f22751a;
        if (valueSet != null && (bridge = (Bridge) valueSet.objectValue(8311, Bridge.class)) != null && (values = bridge.values()) != null) {
            return (List) values.objectValue(8476, List.class);
        }
        return new LinkedList();
    }

    public String getAppName() {
        return m36258n() ? this.f22753ok.stringValue(8) : "";
    }

    public String getBaiduAdapterVersion() {
        ValueSet valueSet = this.f22753ok;
        return valueSet != null ? valueSet.stringValue(8413) : "";
    }

    public String getClassName() {
        return m36258n() ? this.f22753ok.stringValue(8010) : "";
    }

    public Bridge getCustomGMConfiguration() {
        if (m36258n()) {
            return (Bridge) this.f22753ok.objectValue(8401, Bridge.class);
        }
        return null;
    }

    public MediationCustomInitConfig getCustomInitConfig() {
        if (m36258n()) {
            return (MediationCustomInitConfig) this.f22753ok.objectValue(8099, MediationCustomInitConfig.class);
        }
        return null;
    }

    public ValueSet getCustomInitConfigValueSet() {
        if (m36258n()) {
            return (ValueSet) this.f22753ok.objectValue(8545, ValueSet.class);
        }
        return null;
    }

    public Map getCustomInitMap() {
        if (m36258n()) {
            return (Map) this.f22753ok.objectValue(8400, Map.class);
        }
        return null;
    }

    public JSONObject getCustomLocalConfig() {
        ValueSet valueSet = this.f22752bl;
        if (valueSet != null) {
            return (JSONObject) valueSet.objectValue(8463, JSONObject.class);
        }
        return null;
    }

    public String getDevImei() {
        ValueSet valueSet = this.f22751a;
        return valueSet != null ? valueSet.stringValue(8484) : "";
    }

    public List<String> getDevImeis() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.f22751a;
        if (valueSet != null && (bridge = (Bridge) valueSet.objectValue(8311, Bridge.class)) != null && (values = bridge.values()) != null) {
            return (List) values.objectValue(8477, List.class);
        }
        return new LinkedList();
    }

    public String getDevOaid() {
        ValueSet valueSet = this.f22751a;
        return valueSet != null ? valueSet.stringValue(8486) : "";
    }

    public String getGdtAdapterVersion() {
        ValueSet valueSet = this.f22753ok;
        return valueSet != null ? valueSet.stringValue(8414) : "";
    }

    public String getGromoreVersion() {
        ValueSet valueSet = this.f22753ok;
        return valueSet != null ? valueSet.stringValue(8411) : "";
    }

    public boolean getHttps() {
        ValueSet valueSet = this.f22752bl;
        if (valueSet != null) {
            return valueSet.booleanValue(8458);
        }
        return false;
    }

    public Map getInitAdnMap() {
        ValueSet valueSet = this.f22753ok;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8425, Map.class);
        }
        return new HashMap();
    }

    public Bridge getInitCallback() {
        if (m36258n()) {
            return (Bridge) this.f22753ok.objectValue(8300, Bridge.class);
        }
        return null;
    }

    public String getKlevinAdapterVersion() {
        ValueSet valueSet = this.f22753ok;
        return valueSet != null ? valueSet.stringValue(8415) : "";
    }

    public String getKsAdapterVersion() {
        ValueSet valueSet = this.f22753ok;
        return valueSet != null ? valueSet.stringValue(8410) : "";
    }

    public Map getLocalExtra() {
        ValueSet valueSet = this.f22752bl;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8462, Map.class);
        }
        return new HashMap();
    }

    public IMediationLocation getLocation() {
        if (m36259kf() == -1.0d || m36259kf() == -1.0d) {
            return null;
        }
        return new IMediationLocation() { // from class: com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig.1
            @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation
            public double getLatitude() {
                return MediationInitConfig.this.m36259kf();
            }

            @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation
            public double getLongitude() {
                return MediationInitConfig.this.m36260h();
            }
        };
    }

    public String getMacAddress() {
        ValueSet valueSet = this.f22751a;
        return valueSet != null ? valueSet.stringValue(8487) : "";
    }

    public Bridge getMediationConfigUserInfoForSegment() {
        ValueSet valueSet = this.f22752bl;
        if (valueSet != null) {
            return (Bridge) valueSet.objectValue(8310, Bridge.class);
        }
        return null;
    }

    public String getMintegralAdapterVersion() {
        ValueSet valueSet = this.f22753ok;
        return valueSet != null ? valueSet.stringValue(8416) : "";
    }

    public String getOpensdkVer() {
        ValueSet valueSet = this.f22752bl;
        return valueSet != null ? valueSet.stringValue(8464) : "";
    }

    public String getPublisherDid() {
        ValueSet valueSet = this.f22752bl;
        return valueSet != null ? valueSet.stringValue(8460) : "";
    }

    public String getSigmobAdapterVersion() {
        ValueSet valueSet = this.f22753ok;
        return valueSet != null ? valueSet.stringValue(8417) : "";
    }

    public String getUnityAdapterVersion() {
        ValueSet valueSet = this.f22753ok;
        return valueSet != null ? valueSet.stringValue(8418) : "";
    }

    public ValueSet getValueSet() {
        return this.f22753ok;
    }

    public String getWxAppId() {
        ValueSet valueSet = this.f22752bl;
        return valueSet != null ? valueSet.stringValue(8459) : "";
    }

    public boolean isCanUseAndroidId() {
        ValueSet valueSet = this.f22751a;
        if (valueSet != null) {
            return valueSet.booleanValue(8479);
        }
        return true;
    }

    public boolean isCanUseLocation() {
        ValueSet valueSet = this.f22751a;
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
        ValueSet valueSet = this.f22751a;
        if (valueSet == null || (bridge = (Bridge) valueSet.objectValue(8311, Bridge.class)) == null || (values = bridge.values()) == null) {
            return true;
        }
        return values.booleanValue(8478);
    }

    public boolean isCanUsePermissionRecordAudio() {
        ValueSet valueSet = this.f22751a;
        if (valueSet != null) {
            return valueSet.booleanValue(8549);
        }
        return true;
    }

    public boolean isCanUsePhoneState() {
        ValueSet valueSet = this.f22751a;
        if (valueSet != null) {
            return valueSet.booleanValue(8023);
        }
        return true;
    }

    public boolean isCanUseWifiState() {
        ValueSet valueSet = this.f22751a;
        if (valueSet != null) {
            return valueSet.booleanValue(8480);
        }
        return true;
    }

    public boolean isCanUseWriteExternal() {
        ValueSet valueSet = this.f22751a;
        if (valueSet != null) {
            return valueSet.booleanValue(8025);
        }
        return true;
    }

    public boolean isCustom() {
        if (m36258n()) {
            return this.f22753ok.booleanValue(8098);
        }
        return false;
    }

    public boolean isDebug() {
        ValueSet valueSet = this.f22753ok;
        if (valueSet != null) {
            return valueSet.booleanValue(1);
        }
        return false;
    }

    public boolean isLimitPersonalAds() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.f22751a;
        if (valueSet == null || (bridge = (Bridge) valueSet.objectValue(8311, Bridge.class)) == null || (values = bridge.values()) == null) {
            return false;
        }
        return values.booleanValue(8027);
    }

    public boolean isOpenAdnTest() {
        ValueSet valueSet = this.f22752bl;
        if (valueSet != null) {
            return valueSet.booleanValue(8461);
        }
        return false;
    }

    public boolean isProgrammaticRecommend() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.f22751a;
        if (valueSet == null || (bridge = (Bridge) valueSet.objectValue(8311, Bridge.class)) == null || (values = bridge.values()) == null) {
            return true;
        }
        return values.booleanValue(8028);
    }

    public boolean isSupportH265() {
        ValueSet valueSet = this.f22752bl;
        if (valueSet != null) {
            return valueSet.booleanValue(8466);
        }
        return false;
    }

    public boolean isSupportSplashZoomout() {
        ValueSet valueSet = this.f22752bl;
        if (valueSet != null) {
            return valueSet.booleanValue(8467);
        }
        return false;
    }

    public boolean isWxInstalled() {
        ValueSet valueSet = this.f22752bl;
        if (valueSet != null) {
            return valueSet.booleanValue(8465);
        }
        return false;
    }

    public void setMediationCustomControllerValueSet(ValueSet valueSet) {
        this.f22751a = valueSet;
        m36255s();
    }

    /* renamed from: a */
    private void m36263a() {
        MediationApiLog.m36298i("---------  sdk 聚合信息 start ----");
        MediationApiLog.m36298i("getHttps：" + getHttps());
        MediationApiLog.m36298i("getWxAppId：" + getWxAppId());
        MediationApiLog.m36298i("getPublisherDid：" + getPublisherDid());
        MediationApiLog.m36298i("isOpenAdnTest：" + isOpenAdnTest());
        MediationApiLog.m36298i("getMediationConfigUserInfoForSegment：" + getMediationConfigUserInfoForSegment());
        MediationApiLog.m36298i("getLocalExtra：" + getLocalExtra());
        MediationApiLog.m36298i("getCustomLocalConfig：" + getCustomLocalConfig());
        MediationApiLog.m36298i("getOpensdkVer：" + getOpensdkVer());
        MediationApiLog.m36298i("isWxInstalled：" + isWxInstalled());
        MediationApiLog.m36298i("isSupportH265：" + isSupportH265());
        MediationApiLog.m36298i("isSupportSplashZoomout：" + isSupportSplashZoomout());
        MediationApiLog.m36298i("---------  sdk 聚合信息 end ----");
    }

    /* renamed from: ok */
    private void m36257ok() {
        MediationApiLog.setDebug(Boolean.valueOf(isDebug()));
        m36261bl();
        m36255s();
        m36263a();
    }
}
