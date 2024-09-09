package com.bytedance.msdk.adapter.pangle_csjm;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.sr.xv;
import com.bytedance.msdk.core.w;
import com.bytedance.sdk.openadsdk.ys.w.xv.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class PluginInitConfig {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f27202c;
    private c sr = new c(w.k().up());

    /* renamed from: w  reason: collision with root package name */
    private ValueSet f27203w;
    private ValueSet xv;

    private PluginInitConfig(ValueSet valueSet) {
        this.f27202c = valueSet;
        if (valueSet != null) {
            this.xv = (ValueSet) valueSet.objectValue(8457, ValueSet.class);
            this.f27203w = (ValueSet) this.f27202c.objectValue(8475, ValueSet.class);
        }
        c();
    }

    public static PluginInitConfig create(ValueSet valueSet) {
        return new PluginInitConfig(valueSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double f() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.f27203w;
        if (valueSet == null || (bridge = (Bridge) valueSet.objectValue(8312, Bridge.class)) == null || (values = bridge.values()) == null) {
            return -1.0d;
        }
        return values.doubleValue(8481);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double r() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.f27203w;
        if (valueSet == null || (bridge = (Bridge) valueSet.objectValue(8312, Bridge.class)) == null || (values = bridge.values()) == null) {
            return -1.0d;
        }
        return values.doubleValue(8482);
    }

    private void sr() {
        xv.w("---------  sdk \u9690\u79c1\u8bbe\u7f6e start ----");
        xv.w("isCanUseLocation\uff1a" + isCanUseLocation());
        PluginLocation location = getLocation();
        xv.w("getLocation\uff1a" + location);
        if (location != null) {
            xv.w("getLocation getLatitude\uff1a" + location.getLatitude());
            xv.w("getLocation getLongitude\uff1a" + location.getLongitude());
        }
        xv.w("appList\uff1a" + appList());
        xv.w("isCanUsePhoneState\uff1a" + isCanUsePhoneState());
        xv.w("isLimitPersonalAds\uff1a" + isLimitPersonalAds());
        xv.w("getDevImei\uff1a" + getDevImei());
        xv.w("isCanUseWifiState\uff1a" + isCanUseWifiState());
        xv.w("getMacAddress\uff1a" + getMacAddress());
        xv.w("isCanUseWriteExternal\uff1a" + isCanUseWriteExternal());
        xv.w("isCanUseAndroidId\uff1a" + isCanUseAndroidId());
        xv.w("getAndroidId\uff1a" + getAndroidId());
        List<String> appList = getAppList();
        xv.w("getAppList\uff1a" + appList);
        if (appList != null) {
            Iterator<String> it = appList.iterator();
            while (it.hasNext()) {
                xv.w("getAppList item: " + it.next());
            }
        }
        List<String> devImeis = getDevImeis();
        xv.w("getDevImeis\uff1a" + devImeis);
        if (devImeis != null) {
            Iterator<String> it2 = devImeis.iterator();
            while (it2.hasNext()) {
                xv.w("getDevImeis item: " + it2.next());
            }
        }
        xv.w("getDevOaid\uff1a" + getDevOaid());
        xv.w("isCanUseOaid\uff1a" + isCanUseOaid());
        xv.w("isCanUseMacAddress\uff1a" + isCanUseMacAddress());
        xv.w("isProgrammaticRecommend\uff1a" + isProgrammaticRecommend());
        xv.w("---------  sdk \u9690\u79c1\u8bbe\u7f6e end ----");
    }

    private boolean ux() {
        ValueSet valueSet = this.f27202c;
        return (valueSet == null || valueSet.isEmpty()) ? false : true;
    }

    private void xv() {
        xv.w("---------  sdk \u521d\u59cb\u5316\u4fe1\u606f start ----");
        xv.w("isDebug\uff1a" + isDebug());
        xv.w("getClassName\uff1a" + getClassName());
        xv.w("getAppId\uff1a" + getAppId());
        xv.w("getAppName\uff1a" + getAppName());
        xv.w("getADNName\uff1a" + getADNName());
        xv.w("getAppKey\uff1a" + getAppKey());
        xv.w("getInitCallback\uff1a" + getInitCallback());
        xv.w("getAgeGroup\uff1a" + getAgeGroup());
        xv.w("isCustom\uff1a" + isCustom());
        xv.w("getCustomInitMap\uff1a" + getCustomInitMap());
        xv.w("getCustomGMConfiguration\uff1a" + getCustomGMConfiguration());
        xv.w("getKsAdapterVersion\uff1a" + getKsAdapterVersion());
        xv.w("getGromoreVersion\uff1a" + getGromoreVersion());
        xv.w("getAdmobAdapterVersion\uff1a" + getAdmobAdapterVersion());
        xv.w("getBaiduAdapterVersion\uff1a" + getBaiduAdapterVersion());
        xv.w("getGdtAdapterVersion\uff1a" + getGdtAdapterVersion());
        xv.w("getKlevinAdapterVersion\uff1a" + getKlevinAdapterVersion());
        xv.w("getMintegralAdapterVersion\uff1a" + getMintegralAdapterVersion());
        xv.w("getSigmobAdapterVersion\uff1a" + getSigmobAdapterVersion());
        xv.w("getUnityAdapterVersion\uff1a" + getUnityAdapterVersion());
        xv.w("getMap\uff1a" + getInitAdnMap());
        xv.w("---------  sdk \u521d\u59cb\u5316\u4fe1\u606f end ----");
    }

    public boolean appList() {
        ValueSet valueSet = this.f27203w;
        if (valueSet != null) {
            return valueSet.booleanValue(8026);
        }
        return true;
    }

    public String getADNName() {
        return ux() ? this.f27202c.stringValue(8003) : "";
    }

    public String getAdmobAdapterVersion() {
        ValueSet valueSet = this.f27202c;
        return valueSet != null ? valueSet.stringValue(8412) : "";
    }

    public int getAgeGroup() {
        return this.sr.t();
    }

    public String getAndroidId() {
        ValueSet valueSet = this.f27203w;
        return valueSet != null ? valueSet.stringValue(8485) : "";
    }

    public String getAppId() {
        if (ux()) {
            return this.f27202c.stringValue(3);
        }
        return null;
    }

    public String getAppKey() {
        return ux() ? this.f27202c.stringValue(AVMDLDataLoader.KeyIsLiveWatchDurationThreshold) : "";
    }

    public List<String> getAppList() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.f27203w;
        if (valueSet != null && (bridge = (Bridge) valueSet.objectValue(8311, Bridge.class)) != null && (values = bridge.values()) != null) {
            return (List) values.objectValue(8476, List.class);
        }
        return new LinkedList();
    }

    public String getAppName() {
        return ux() ? this.f27202c.stringValue(8) : "";
    }

    public String getBaiduAdapterVersion() {
        ValueSet valueSet = this.f27202c;
        return valueSet != null ? valueSet.stringValue(8413) : "";
    }

    public String getClassName() {
        return ux() ? this.f27202c.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow) : "";
    }

    public Bridge getCustomGMConfiguration() {
        if (ux()) {
            return (Bridge) this.f27202c.objectValue(8401, Bridge.class);
        }
        return null;
    }

    public ValueSet getCustomInitConfigValueSet() {
        if (ux()) {
            return (ValueSet) this.f27202c.objectValue(8545, ValueSet.class);
        }
        return null;
    }

    public Map getCustomInitMap() {
        if (ux()) {
            return (Map) this.f27202c.objectValue(8400, Map.class);
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
        ValueSet valueSet = this.f27203w;
        return valueSet != null ? valueSet.stringValue(8484) : "";
    }

    public List<String> getDevImeis() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.f27203w;
        if (valueSet != null && (bridge = (Bridge) valueSet.objectValue(8311, Bridge.class)) != null && (values = bridge.values()) != null) {
            return (List) values.objectValue(8477, List.class);
        }
        return new LinkedList();
    }

    public String getDevOaid() {
        ValueSet valueSet = this.f27203w;
        return valueSet != null ? valueSet.stringValue(8486) : "";
    }

    public String getGdtAdapterVersion() {
        ValueSet valueSet = this.f27202c;
        return valueSet != null ? valueSet.stringValue(8414) : "";
    }

    public String getGromoreVersion() {
        ValueSet valueSet = this.f27202c;
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
        ValueSet valueSet = this.f27202c;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8425, Map.class);
        }
        return new HashMap();
    }

    public Bridge getInitCallback() {
        if (ux()) {
            return (Bridge) this.f27202c.objectValue(8300, Bridge.class);
        }
        return null;
    }

    public String getKlevinAdapterVersion() {
        ValueSet valueSet = this.f27202c;
        return valueSet != null ? valueSet.stringValue(8415) : "";
    }

    public String getKsAdapterVersion() {
        ValueSet valueSet = this.f27202c;
        return valueSet != null ? valueSet.stringValue(8410) : "";
    }

    public Map getLocalExtra() {
        ValueSet valueSet = this.xv;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8462, Map.class);
        }
        return new HashMap();
    }

    public PluginLocation getLocation() {
        if (f() == -1.0d || f() == -1.0d) {
            return null;
        }
        return new PluginLocation() { // from class: com.bytedance.msdk.adapter.pangle_csjm.PluginInitConfig.1
            @Override // com.bytedance.msdk.adapter.pangle_csjm.PluginLocation
            public double getLatitude() {
                return PluginInitConfig.this.f();
            }

            @Override // com.bytedance.msdk.adapter.pangle_csjm.PluginLocation
            public double getLongitude() {
                return PluginInitConfig.this.r();
            }
        };
    }

    public String getMacAddress() {
        ValueSet valueSet = this.f27203w;
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
        ValueSet valueSet = this.f27202c;
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
        ValueSet valueSet = this.f27202c;
        return valueSet != null ? valueSet.stringValue(8417) : "";
    }

    public String getUnityAdapterVersion() {
        ValueSet valueSet = this.f27202c;
        return valueSet != null ? valueSet.stringValue(8418) : "";
    }

    public ValueSet getValueSet() {
        return this.f27202c;
    }

    public String getWxAppId() {
        ValueSet valueSet = this.xv;
        return valueSet != null ? valueSet.stringValue(8459) : "";
    }

    public boolean isCanUseAndroidId() {
        ValueSet valueSet = this.f27203w;
        if (valueSet != null) {
            return valueSet.booleanValue(8479);
        }
        return true;
    }

    public boolean isCanUseLocation() {
        ValueSet valueSet = this.f27203w;
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
        ValueSet valueSet = this.f27203w;
        if (valueSet == null || (bridge = (Bridge) valueSet.objectValue(8311, Bridge.class)) == null || (values = bridge.values()) == null) {
            return true;
        }
        return values.booleanValue(8478);
    }

    public boolean isCanUsePhoneState() {
        ValueSet valueSet = this.f27203w;
        if (valueSet != null) {
            return valueSet.booleanValue(8023);
        }
        return true;
    }

    public boolean isCanUseWifiState() {
        ValueSet valueSet = this.f27203w;
        if (valueSet != null) {
            return valueSet.booleanValue(8480);
        }
        return true;
    }

    public boolean isCanUseWriteExternal() {
        ValueSet valueSet = this.f27203w;
        if (valueSet != null) {
            return valueSet.booleanValue(8025);
        }
        return true;
    }

    public boolean isCustom() {
        if (ux()) {
            return this.f27202c.booleanValue(8098);
        }
        return false;
    }

    public boolean isDebug() {
        ValueSet valueSet = this.f27202c;
        if (valueSet != null) {
            return valueSet.booleanValue(1);
        }
        return false;
    }

    public boolean isLimitPersonalAds() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.f27203w;
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
        ValueSet valueSet = this.f27203w;
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
        this.f27203w = valueSet;
        sr();
    }

    private void c() {
        xv();
        sr();
        w();
    }

    private void w() {
        xv.w("---------  sdk \u805a\u5408\u4fe1\u606f start ----");
        xv.w("getHttps\uff1a" + getHttps());
        xv.w("getWxAppId\uff1a" + getWxAppId());
        xv.w("getPublisherDid\uff1a" + getPublisherDid());
        xv.w("isOpenAdnTest\uff1a" + isOpenAdnTest());
        xv.w("getMediationConfigUserInfoForSegment\uff1a" + getMediationConfigUserInfoForSegment());
        xv.w("getLocalExtra\uff1a" + getLocalExtra());
        xv.w("getCustomLocalConfig\uff1a" + getCustomLocalConfig());
        xv.w("getOpensdkVer\uff1a" + getOpensdkVer());
        xv.w("isWxInstalled\uff1a" + isWxInstalled());
        xv.w("isSupportH265\uff1a" + isSupportH265());
        xv.w("isSupportSplashZoomout\uff1a" + isSupportSplashZoomout());
        xv.w("---------  sdk \u805a\u5408\u4fe1\u606f end ----");
    }
}
