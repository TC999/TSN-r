package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationAdSlotValueSet {
    public static final String TAG = "TTMediationSDK";

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36089c;
    private int sr;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private ValueSet f36090w;
    private ValueSet xv;

    private MediationAdSlotValueSet(ValueSet valueSet) {
        this.f36089c = valueSet;
        ValueSet valueSet2 = (ValueSet) valueSet.objectValue(8090, ValueSet.class);
        if (valueSet2 == null) {
            ValueSet valueSet3 = (ValueSet) this.f36089c.objectValue(8089, ValueSet.class);
            this.f36090w = valueSet3;
            if (valueSet3 != null) {
                this.xv = (ValueSet) valueSet3.objectValue(8443, ValueSet.class);
            }
        } else {
            ValueSet valueSet4 = (ValueSet) valueSet2.objectValue(8089, ValueSet.class);
            this.f36090w = valueSet4;
            if (valueSet4 != null) {
                this.xv = (ValueSet) valueSet4.objectValue(8443, ValueSet.class);
            }
        }
        c();
    }

    private void c() {
        MediationApiLog.i("---------  sdk MediationAdSlotValueSet start ----");
        MediationApiLog.i("getAdLoaderCallback\uff1a" + getAdLoaderCallback());
        MediationApiLog.i("getADNId\uff1a" + getADNId());
        MediationApiLog.i("getRitId\uff1a" + getRitId());
        MediationApiLog.i("getUserId\uff1a" + getUserId());
        MediationApiLog.i("getAdCount\uff1a" + getAdCount());
        MediationApiLog.i("getWidth\uff1a" + getWidth());
        MediationApiLog.i("getHeight\uff1a" + getHeight());
        MediationApiLog.i("getExpressWidth\uff1a" + getExpressWidth());
        MediationApiLog.i("getExpressHeight\uff1a" + getExpressHeight());
        MediationApiLog.i("isMuted\uff1a" + isMuted());
        MediationApiLog.i("isSplashShakeButton\uff1a" + isSplashShakeButton());
        MediationApiLog.i("isSplashPreLoad\uff1a" + isSplashPreLoad());
        MediationApiLog.i("getVolume\uff1a" + getVolume());
        MediationApiLog.i("isUseSurfaceView\uff1a" + isUseSurfaceView());
        MediationApiLog.i("getExtraObject\uff1a" + getExtraObject());
        MediationApiLog.i("isBidNotify\uff1a" + isBidNotify());
        MediationApiLog.i("getScenarioId\uff1a" + getScenarioId());
        MediationApiLog.i("getRewardName\uff1a" + getRewardName());
        MediationApiLog.i("getRewardAmount\uff1a" + getRewardAmount());
        MediationApiLog.i("isAllowShowCloseBtn\uff1a" + isAllowShowCloseBtn());
        MediationApiLog.i("isExpress\uff1a" + isExpress());
        MediationApiLog.i("getOrientation\uff1a" + getOrientation());
        MediationApiLog.i("getContentUrl\uff1a" + getContentUrl());
        MediationApiLog.i("getDevices\uff1a" + getDevices());
        MediationApiLog.i("getOriginType\uff1a" + getOriginType());
        MediationApiLog.i("getAdSubType\uff1a" + getAdSubType());
        MediationApiLog.i("getAdmobNativeAdOptions\uff1a" + getAdmobNativeAdOptions());
        MediationApiLog.i("getBaiduAppSid\uff1a" + getBaiduAppSid());
        MediationApiLog.i("getBaiduDownloadAppConfirmPolicy\uff1a" + getBaiduDownloadAppConfirmPolicy());
        MediationApiLog.i("getBaiduUseRewardCountdown\uff1a" + getBaiduUseRewardCountdown());
        MediationApiLog.i("getBaiduShowDialogOnSkip\uff1a" + getBaiduShowDialogOnSkip());
        MediationApiLog.i("getBaiduCacheVideoOnlyWifi\uff1a" + getBaiduCacheVideoOnlyWifi());
        MediationApiLog.i("getBaiduRequestParameters\uff1a" + getBaiduRequestParameters());
        MediationApiLog.i("getBaiduNativeSmartOptStyleParams\uff1a" + getBaiduNativeSmartOptStyleParams());
        MediationApiLog.i("getGdtMinVideoDuration\uff1a" + getGdtMinVideoDuration());
        MediationApiLog.i("getGdtMaxVideoDuration\uff1a" + getGdtMaxVideoDuration());
        MediationApiLog.i("getGdtVideoOption\uff1a" + getGdtVideoOption());
        MediationApiLog.i("getGdtDownAPPConfirmPolicy\uff1a" + getGdtDownAPPConfirmPolicy());
        MediationApiLog.i("getGdtNativeLogoParams\uff1a" + getGdtNativeLogoParams());
        MediationApiLog.i("getAdLoadTimeOut\uff1a" + getAdLoadTimeOut());
        MediationApiLog.i("getShakeViewWidth\uff1a" + getShakeViewWidth());
        MediationApiLog.i("getShakeViewHeight\uff1a" + getShakeViewHeight());
        MediationApiLog.i("getAdloadSeq\uff1a" + getAdloadSeq());
        MediationApiLog.i("getAdUnitId\uff1a" + getAdUnitId());
        MediationApiLog.i("isSupportDeepLink\uff1a" + isSupportDeepLink());
        MediationApiLog.i("getParams\uff1a" + getParams());
        MediationApiLog.i("---------  \u521d\u59cb\u5316adn sdk MediationAdSlotValueSet end ----");
    }

    public static MediationAdSlotValueSet create(ValueSet valueSet) {
        return new MediationAdSlotValueSet(valueSet);
    }

    private boolean w() {
        ValueSet valueSet = this.f36089c;
        return (valueSet == null || valueSet.isEmpty()) ? false : true;
    }

    public String getADNId() {
        if (w()) {
            return this.f36089c.stringValue(AVMDLDataLoader.KeyIsLiveCacheThresholdP2pToHttp);
        }
        return null;
    }

    public int getAdCount() {
        ValueSet valueSet = this.f36090w;
        if (valueSet != null) {
            return valueSet.intValue(13);
        }
        return 1;
    }

    public int getAdLoadTimeOut() {
        ValueSet valueSet = this.f36090w;
        if (valueSet != null) {
            return valueSet.intValue(17, 3000);
        }
        return 3000;
    }

    public Bridge getAdLoaderCallback() {
        if (w()) {
            return (Bridge) this.f36089c.objectValue(AVMDLDataLoader.KeyIsLiveMobileDownloadAllow, Bridge.class);
        }
        return null;
    }

    public int getAdSubType() {
        if (w()) {
            return this.f36089c.intValue(8094);
        }
        return 0;
    }

    public String getAdUnitId() {
        return this.ux;
    }

    public int getAdloadSeq() {
        int i4 = this.sr;
        if (i4 != 0) {
            return i4;
        }
        if (w()) {
            return this.f36089c.intValue(20);
        }
        return 0;
    }

    public Object getAdmobNativeAdOptions() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            return extraObject.get("key_admob_native_options");
        }
        return null;
    }

    public String getBaiduAppSid() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            Object obj = extraObject.get("key_baidu_appsid");
            return obj instanceof String ? (String) obj : "";
        }
        return "";
    }

    public boolean getBaiduCacheVideoOnlyWifi() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            Object obj = extraObject.get("key_baidu_cache_video_only_wifi");
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return false;
        }
        return false;
    }

    public int getBaiduDownloadAppConfirmPolicy() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            Object obj = extraObject.get("key_baidu_down_app_config_policy");
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return 0;
        }
        return 0;
    }

    public Object getBaiduNativeSmartOptStyleParams() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            return extraObject.get("key_baidu_native_smart_opt_style_params");
        }
        return null;
    }

    public Object getBaiduRequestParameters() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            return extraObject.get("key_baidu_request_parameters");
        }
        return null;
    }

    public boolean getBaiduShowDialogOnSkip() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            Object obj = extraObject.get("key_baidu_show_dialog_on_skip");
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return false;
        }
        return false;
    }

    public boolean getBaiduUseRewardCountdown() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            Object obj = extraObject.get("key_baidu_use_reward_countdown");
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return false;
        }
        return false;
    }

    public ValueSet getCSJValueSet() {
        return this.f36090w;
    }

    public String getClientReqId() {
        return w() ? this.f36089c.stringValue(8430) : "";
    }

    public String getContentUrl() {
        return w() ? this.f36089c.stringValue(8083) : "";
    }

    public String getDevices() {
        return w() ? this.f36089c.stringValue(8084) : "";
    }

    public float getExpressHeight() {
        ValueSet valueSet = this.f36090w;
        if (valueSet != null) {
            return valueSet.floatValue(9);
        }
        return 0.0f;
    }

    public float getExpressWidth() {
        ValueSet valueSet = this.f36090w;
        if (valueSet != null) {
            return valueSet.floatValue(10);
        }
        return 0.0f;
    }

    public Map<String, Object> getExtraObject() {
        ValueSet valueSet = this.xv;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8449, Map.class);
        }
        return null;
    }

    public Object getGdtDownAPPConfirmPolicy() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            return extraObject.get("key_gdt_down_app_config_policy");
        }
        return null;
    }

    public int getGdtMaxVideoDuration() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            Object obj = extraObject.get("key_gdt_max_video_duration");
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return 0;
        }
        return 0;
    }

    public int getGdtMinVideoDuration() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            Object obj = extraObject.get("key_gdt_min_video_duration");
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return 0;
        }
        return 0;
    }

    public Object getGdtNativeLogoParams() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            return extraObject.get("key_gdt_native_logo_params");
        }
        return null;
    }

    public Object getGdtVideoOption() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            return extraObject.get("key_gdt_video_option");
        }
        return null;
    }

    public int getHeight() {
        ValueSet valueSet = this.f36090w;
        if (valueSet != null) {
            return valueSet.intValue(8);
        }
        return 0;
    }

    public int getOrientation() {
        ValueSet valueSet = this.f36090w;
        if (valueSet != null) {
            return valueSet.intValue(16);
        }
        return 2;
    }

    public int getOriginType() {
        if (w()) {
            return this.f36089c.intValue(8085);
        }
        return 0;
    }

    public Map<String, Object> getParams() {
        return w() ? (Map) this.f36089c.objectValue(8044, Map.class) : new HashMap();
    }

    public int getRenderControl() {
        if (w()) {
            return this.f36089c.intValue(8553);
        }
        return 0;
    }

    public int getRewardAmount() {
        ValueSet valueSet = this.xv;
        if (valueSet != null) {
            return valueSet.intValue(8453);
        }
        return 0;
    }

    public String getRewardName() {
        ValueSet valueSet = this.xv;
        return valueSet != null ? valueSet.stringValue(8452) : "";
    }

    public String getRitId() {
        if (w()) {
            return this.f36089c.stringValue(4);
        }
        return null;
    }

    public String getScenarioId() {
        ValueSet valueSet = this.xv;
        return valueSet != null ? valueSet.stringValue(8451) : "";
    }

    public float getShakeViewHeight() {
        ValueSet valueSet = this.xv;
        if (valueSet != null) {
            return valueSet.floatValue(8456);
        }
        return 0.0f;
    }

    public float getShakeViewWidth() {
        ValueSet valueSet = this.xv;
        if (valueSet != null) {
            return valueSet.floatValue(8455);
        }
        return 0.0f;
    }

    public String getUserId() {
        ValueSet valueSet = this.f36090w;
        return valueSet != null ? valueSet.stringValue(15) : "";
    }

    public float getVolume() {
        ValueSet valueSet = this.xv;
        if (valueSet != null) {
            return valueSet.floatValue(8447);
        }
        return 1.0f;
    }

    public String getWaterfallABTest() {
        return w() ? this.f36089c.stringValue(8429) : "";
    }

    public int getWidth() {
        ValueSet valueSet = this.f36090w;
        if (valueSet != null) {
            return valueSet.intValue(7);
        }
        return 0;
    }

    public boolean isAllowShowCloseBtn() {
        ValueSet valueSet = this.xv;
        if (valueSet != null) {
            return valueSet.booleanValue(8454);
        }
        return false;
    }

    public boolean isBidNotify() {
        ValueSet valueSet = this.xv;
        if (valueSet != null) {
            return valueSet.booleanValue(8450);
        }
        return false;
    }

    public boolean isExpress() {
        return w() && this.f36089c.booleanValue(8033);
    }

    public boolean isMuted() {
        ValueSet valueSet = this.xv;
        if (valueSet != null) {
            return valueSet.booleanValue(8444);
        }
        return false;
    }

    public boolean isSplashPreLoad() {
        ValueSet valueSet = this.xv;
        if (valueSet != null) {
            return valueSet.booleanValue(8446);
        }
        return false;
    }

    public boolean isSplashShakeButton() {
        ValueSet valueSet = this.xv;
        if (valueSet != null) {
            return valueSet.booleanValue(8445);
        }
        return false;
    }

    public boolean isSupportDeepLink() {
        if (w()) {
            return this.f36089c.booleanValue(11);
        }
        return false;
    }

    public boolean isUseSurfaceView() {
        ValueSet valueSet = this.xv;
        if (valueSet != null) {
            return valueSet.booleanValue(8448);
        }
        return false;
    }

    public void setAdUnitId(String str) {
        this.ux = str;
    }

    public void setAdloadSeq(int i4) {
        this.sr = i4;
    }
}
