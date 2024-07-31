package com.bytedance.msdk.adapter.config;

import com.bytedance.msdk.api.TTPrivacyConfig;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class TTBaseAdapterConfiguration implements ITTAdapterConfiguration {
    public static final String APP_ID_EXTRA_KEY = "app_id";
    public static final String APP_KEY_EXTRA_KEY = "app_key";
    public static final String APP_NAME_EXTRA_KEY = "app_name";
    public static final String BAIDU_IS_READ_DEVICE_ID = "baidu_is_read_device_id";
    public static String TT_MSDK_ADSLOT_INFO = "tt_msdk_adslot_info";
    public static String TT_MSDK_CLIENT_REQ_ID = "tt_msdk_client_req_id";
    public static String TT_MSDK_THEME_STATUS = "tt_msdk_theme_status";
    public static String TT_MSDK_WATER_FALL_AB_TEST = "tt_msdk_water_fall_ab_test";
    public static String TT_MSDK_WATER_FALL_LIST = "tt_msdk_water_fall_list";

    /* renamed from: a */
    private volatile boolean f21329a = false;

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public Map<String, String> getMsdkRequestOptions() {
        return null;
    }

    public boolean isInitedSuccess() {
        return this.f21329a;
    }

    public void setInitedSuccess(boolean z) {
        this.f21329a = z;
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public void setMsdkRequestOptions(Map<String, String> map) {
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public void setPrivacyConfig(TTPrivacyConfig tTPrivacyConfig) {
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public void setThemeStatus(Map<String, Object> map) {
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public int showOpenOrInstallAppDialog(TTAppDialogClickListener tTAppDialogClickListener) {
        return 0;
    }
}
