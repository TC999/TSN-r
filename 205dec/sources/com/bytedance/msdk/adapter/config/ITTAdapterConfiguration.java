package com.bytedance.msdk.adapter.config;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.api.TTPrivacyConfig;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public interface ITTAdapterConfiguration {
    String getAdNetworkName();

    String getAdapterVersion();

    String getBiddingToken(Context context, Map<String, Object> map);

    Map<String, String> getMsdkRequestOptions();

    String getNetworkSdkVersion();

    void initializeNetwork(@NonNull Context context, @Nullable Map<String, String> map, @NonNull TTOnNetworkInitializationFinishedListener tTOnNetworkInitializationFinishedListener);

    void setMsdkRequestOptions(Map<String, String> map);

    void setPrivacyConfig(TTPrivacyConfig tTPrivacyConfig);

    void setThemeStatus(Map<String, Object> map);

    int showOpenOrInstallAppDialog(TTAppDialogClickListener tTAppDialogClickListener);
}
