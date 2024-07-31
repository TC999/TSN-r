package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MediationAdSlotValueSet {
    public static final String TAG = "TTMediationSDK";

    /* renamed from: a */
    private ValueSet f22746a;

    /* renamed from: bl */
    private ValueSet f22747bl;

    /* renamed from: n */
    private String f22748n;

    /* renamed from: ok */
    private ValueSet f22749ok;

    /* renamed from: s */
    private int f22750s;

    private MediationAdSlotValueSet(ValueSet valueSet) {
        this.f22749ok = valueSet;
        ValueSet valueSet2 = (ValueSet) valueSet.objectValue(8090, ValueSet.class);
        if (valueSet2 == null) {
            ValueSet valueSet3 = (ValueSet) this.f22749ok.objectValue(8089, ValueSet.class);
            this.f22746a = valueSet3;
            if (valueSet3 != null) {
                this.f22747bl = (ValueSet) valueSet3.objectValue(8443, ValueSet.class);
            }
        } else {
            ValueSet valueSet4 = (ValueSet) valueSet2.objectValue(8089, ValueSet.class);
            this.f22746a = valueSet4;
            if (valueSet4 != null) {
                this.f22747bl = (ValueSet) valueSet4.objectValue(8443, ValueSet.class);
            }
        }
        m36264ok();
    }

    /* renamed from: a */
    private boolean m36265a() {
        ValueSet valueSet = this.f22749ok;
        return (valueSet == null || valueSet.isEmpty()) ? false : true;
    }

    public static MediationAdSlotValueSet create(ValueSet valueSet) {
        return new MediationAdSlotValueSet(valueSet);
    }

    /* renamed from: ok */
    private void m36264ok() {
        MediationApiLog.m36298i("---------  sdk MediationAdSlotValueSet start ----");
        MediationApiLog.m36298i("getAdLoaderCallback：" + getAdLoaderCallback());
        MediationApiLog.m36298i("getADNId：" + getADNId());
        MediationApiLog.m36298i("getRitId：" + getRitId());
        MediationApiLog.m36298i("getUserId：" + getUserId());
        MediationApiLog.m36298i("getAdCount：" + getAdCount());
        MediationApiLog.m36298i("getWidth：" + getWidth());
        MediationApiLog.m36298i("getHeight：" + getHeight());
        MediationApiLog.m36298i("getExpressWidth：" + getExpressWidth());
        MediationApiLog.m36298i("getExpressHeight：" + getExpressHeight());
        MediationApiLog.m36298i("isMuted：" + isMuted());
        MediationApiLog.m36298i("isSplashShakeButton：" + isSplashShakeButton());
        MediationApiLog.m36298i("isSplashPreLoad：" + isSplashPreLoad());
        MediationApiLog.m36298i("getVolume：" + getVolume());
        MediationApiLog.m36298i("isUseSurfaceView：" + isUseSurfaceView());
        MediationApiLog.m36298i("getExtraObject：" + getExtraObject());
        MediationApiLog.m36298i("isBidNotify：" + isBidNotify());
        MediationApiLog.m36298i("getScenarioId：" + getScenarioId());
        MediationApiLog.m36298i("getRewardName：" + getRewardName());
        MediationApiLog.m36298i("getRewardAmount：" + getRewardAmount());
        MediationApiLog.m36298i("isAllowShowCloseBtn：" + isAllowShowCloseBtn());
        MediationApiLog.m36298i("isExpress：" + isExpress());
        MediationApiLog.m36298i("getOrientation：" + getOrientation());
        MediationApiLog.m36298i("getContentUrl：" + getContentUrl());
        MediationApiLog.m36298i("getDevices：" + getDevices());
        MediationApiLog.m36298i("getOriginType：" + getOriginType());
        MediationApiLog.m36298i("getAdSubType：" + getAdSubType());
        MediationApiLog.m36298i("getAdmobNativeAdOptions：" + getAdmobNativeAdOptions());
        MediationApiLog.m36298i("getBaiduAppSid：" + getBaiduAppSid());
        MediationApiLog.m36298i("getBaiduDownloadAppConfirmPolicy：" + getBaiduDownloadAppConfirmPolicy());
        MediationApiLog.m36298i("getBaiduUseRewardCountdown：" + getBaiduUseRewardCountdown());
        MediationApiLog.m36298i("getBaiduShowDialogOnSkip：" + getBaiduShowDialogOnSkip());
        MediationApiLog.m36298i("getBaiduCacheVideoOnlyWifi：" + getBaiduCacheVideoOnlyWifi());
        MediationApiLog.m36298i("getBaiduRequestParameters：" + getBaiduRequestParameters());
        MediationApiLog.m36298i("getBaiduNativeSmartOptStyleParams：" + getBaiduNativeSmartOptStyleParams());
        MediationApiLog.m36298i("getGdtMinVideoDuration：" + getGdtMinVideoDuration());
        MediationApiLog.m36298i("getGdtMaxVideoDuration：" + getGdtMaxVideoDuration());
        MediationApiLog.m36298i("getGdtVideoOption：" + getGdtVideoOption());
        MediationApiLog.m36298i("getGdtDownAPPConfirmPolicy：" + getGdtDownAPPConfirmPolicy());
        MediationApiLog.m36298i("getGdtNativeLogoParams：" + getGdtNativeLogoParams());
        MediationApiLog.m36298i("getAdLoadTimeOut：" + getAdLoadTimeOut());
        MediationApiLog.m36298i("getShakeViewWidth：" + getShakeViewWidth());
        MediationApiLog.m36298i("getShakeViewHeight：" + getShakeViewHeight());
        MediationApiLog.m36298i("getAdloadSeq：" + getAdloadSeq());
        MediationApiLog.m36298i("getAdUnitId：" + getAdUnitId());
        MediationApiLog.m36298i("isSupportDeepLink：" + isSupportDeepLink());
        MediationApiLog.m36298i("getParams：" + getParams());
        MediationApiLog.m36298i("---------  初始化adn sdk MediationAdSlotValueSet end ----");
    }

    public String getADNId() {
        if (m36265a()) {
            return this.f22749ok.stringValue(8007);
        }
        return null;
    }

    public int getAdCount() {
        ValueSet valueSet = this.f22746a;
        if (valueSet != null) {
            return valueSet.intValue(13);
        }
        return 1;
    }

    public int getAdLoadTimeOut() {
        ValueSet valueSet = this.f22746a;
        if (valueSet != null) {
            return valueSet.intValue(17, 3000);
        }
        return 3000;
    }

    public Bridge getAdLoaderCallback() {
        if (m36265a()) {
            return (Bridge) this.f22749ok.objectValue(8011, Bridge.class);
        }
        return null;
    }

    public int getAdSubType() {
        if (m36265a()) {
            return this.f22749ok.intValue(8094);
        }
        return 0;
    }

    public String getAdUnitId() {
        return this.f22748n;
    }

    public int getAdloadSeq() {
        int i = this.f22750s;
        if (i != 0) {
            return i;
        }
        if (m36265a()) {
            return this.f22749ok.intValue(20);
        }
        return 0;
    }

    public Object getAdmobNativeAdOptions() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            return extraObject.get(MediationConstant.KEY_ADMOB_NATIVE_OPTIONS);
        }
        return null;
    }

    public String getBaiduAppSid() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            Object obj = extraObject.get(MediationConstant.KEY_BAIDU_APPSID);
            return obj instanceof String ? (String) obj : "";
        }
        return "";
    }

    public boolean getBaiduCacheVideoOnlyWifi() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            Object obj = extraObject.get(MediationConstant.KEY_BAIDU_CACHE_VIDEO_ONLY_WIFI);
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
            Object obj = extraObject.get(MediationConstant.KEY_BAIDU_DOWN_APP_CONFIG_POLICY);
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
            return extraObject.get(MediationConstant.KEY_BAIDU_NATIVE_SMART_OPT_STYLE_PARAMS);
        }
        return null;
    }

    public Object getBaiduRequestParameters() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            return extraObject.get(MediationConstant.KEY_BAIDU_REQUEST_PARAMETERS);
        }
        return null;
    }

    public boolean getBaiduShowDialogOnSkip() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            Object obj = extraObject.get(MediationConstant.KEY_BAIDU_SHOW_DIALOG_ON_SKIP);
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
            Object obj = extraObject.get(MediationConstant.KEY_BAIDU_USE_REWARD_COUNTDOWN);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return false;
        }
        return false;
    }

    public ValueSet getCSJValueSet() {
        return this.f22746a;
    }

    public String getClientReqId() {
        return m36265a() ? this.f22749ok.stringValue(8430) : "";
    }

    public String getContentUrl() {
        return m36265a() ? this.f22749ok.stringValue(8083) : "";
    }

    public String getDevices() {
        return m36265a() ? this.f22749ok.stringValue(8084) : "";
    }

    public float getExpressHeight() {
        ValueSet valueSet = this.f22746a;
        if (valueSet != null) {
            return valueSet.floatValue(9);
        }
        return 0.0f;
    }

    public float getExpressWidth() {
        ValueSet valueSet = this.f22746a;
        if (valueSet != null) {
            return valueSet.floatValue(10);
        }
        return 0.0f;
    }

    public Map<String, Object> getExtraObject() {
        ValueSet valueSet = this.f22747bl;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8449, Map.class);
        }
        return null;
    }

    public Object getGdtDownAPPConfirmPolicy() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            return extraObject.get(MediationConstant.KEY_GDT_DOWN_APP_CONFIG_POLICY);
        }
        return null;
    }

    public int getGdtMaxVideoDuration() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            Object obj = extraObject.get(MediationConstant.KEY_GDT_MAX_VIDEO_DURATION);
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
            Object obj = extraObject.get(MediationConstant.KEY_GDT_MIN_VIDEO_DURATION);
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
            return extraObject.get(MediationConstant.KEY_GDT_NATIVE_LOGO_PARAMS);
        }
        return null;
    }

    public Object getGdtVideoOption() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            return extraObject.get(MediationConstant.KEY_GDT_VIDEO_OPTION);
        }
        return null;
    }

    public int getHeight() {
        ValueSet valueSet = this.f22746a;
        if (valueSet != null) {
            return valueSet.intValue(8);
        }
        return 0;
    }

    public int getOrientation() {
        ValueSet valueSet = this.f22746a;
        if (valueSet != null) {
            return valueSet.intValue(16);
        }
        return 2;
    }

    public int getOriginType() {
        if (m36265a()) {
            return this.f22749ok.intValue(8085);
        }
        return 0;
    }

    public Map<String, Object> getParams() {
        return m36265a() ? (Map) this.f22749ok.objectValue(8044, Map.class) : new HashMap();
    }

    public int getRenderControl() {
        if (m36265a()) {
            return this.f22749ok.intValue(8553);
        }
        return 0;
    }

    public int getRewardAmount() {
        ValueSet valueSet = this.f22747bl;
        if (valueSet != null) {
            return valueSet.intValue(8453);
        }
        return 0;
    }

    public String getRewardName() {
        ValueSet valueSet = this.f22747bl;
        return valueSet != null ? valueSet.stringValue(8452) : "";
    }

    public String getRitId() {
        if (m36265a()) {
            return this.f22749ok.stringValue(4);
        }
        return null;
    }

    public String getScenarioId() {
        ValueSet valueSet = this.f22747bl;
        return valueSet != null ? valueSet.stringValue(8451) : "";
    }

    public float getShakeViewHeight() {
        ValueSet valueSet = this.f22747bl;
        if (valueSet != null) {
            return valueSet.floatValue(8456);
        }
        return 0.0f;
    }

    public float getShakeViewWidth() {
        ValueSet valueSet = this.f22747bl;
        if (valueSet != null) {
            return valueSet.floatValue(8455);
        }
        return 0.0f;
    }

    public String getUserId() {
        ValueSet valueSet = this.f22746a;
        return valueSet != null ? valueSet.stringValue(15) : "";
    }

    public float getVolume() {
        ValueSet valueSet = this.f22747bl;
        if (valueSet != null) {
            return valueSet.floatValue(8447);
        }
        return 1.0f;
    }

    public String getWaterfallABTest() {
        return m36265a() ? this.f22749ok.stringValue(8429) : "";
    }

    public int getWidth() {
        ValueSet valueSet = this.f22746a;
        if (valueSet != null) {
            return valueSet.intValue(7);
        }
        return 0;
    }

    public boolean isAllowShowCloseBtn() {
        ValueSet valueSet = this.f22747bl;
        if (valueSet != null) {
            return valueSet.booleanValue(8454);
        }
        return false;
    }

    public boolean isBidNotify() {
        ValueSet valueSet = this.f22747bl;
        if (valueSet != null) {
            return valueSet.booleanValue(8450);
        }
        return false;
    }

    public boolean isExpress() {
        return m36265a() && this.f22749ok.booleanValue(8033);
    }

    public boolean isMuted() {
        ValueSet valueSet = this.f22747bl;
        if (valueSet != null) {
            return valueSet.booleanValue(8444);
        }
        return false;
    }

    public boolean isSplashPreLoad() {
        ValueSet valueSet = this.f22747bl;
        if (valueSet != null) {
            return valueSet.booleanValue(8446);
        }
        return false;
    }

    public boolean isSplashShakeButton() {
        ValueSet valueSet = this.f22747bl;
        if (valueSet != null) {
            return valueSet.booleanValue(8445);
        }
        return false;
    }

    public boolean isSupportDeepLink() {
        if (m36265a()) {
            return this.f22749ok.booleanValue(11);
        }
        return false;
    }

    public boolean isUseSurfaceView() {
        ValueSet valueSet = this.f22747bl;
        if (valueSet != null) {
            return valueSet.booleanValue(8448);
        }
        return false;
    }

    public void setAdUnitId(String str) {
        this.f22748n = str;
    }

    public void setAdloadSeq(int i) {
        this.f22750s = i;
    }
}
