package com.kwad.sdk.api.core;

import android.content.Context;
import androidx.annotation.ColorInt;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.proxy.IComponentProxy;
import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsAdSdkDynamicApi("com.kwad.sdk.KsAdSDKImpl")
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface IKsAdSDK {
    @Keep
    void addHp(@NonNull Map<String, String> map);

    @Keep
    Object dM(String str, Object... objArr);

    @KsAdSdkDynamicApi
    @Keep
    void deleteCache();

    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    KsLoadManager getAdManager();

    @KsAdSdkDynamicApi
    @Keep
    String getApiVersion();

    @KsAdSdkDynamicApi
    @Keep
    int getApiVersionCode();

    @KsAdSdkDynamicApi
    @Keep
    String getAppId();

    @KsAdSdkDynamicApi
    @Keep
    JSONObject getAppInfo();

    @KsAdSdkDynamicApi
    @Keep
    String getAppName();

    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    Context getContext();

    @KsAdSdkDynamicApi
    @Keep
    JSONObject getDeviceInfo();

    @KsAdSdkDynamicApi
    @Keep
    String getDid();

    @KsAdSdkDynamicApi
    @Keep
    JSONObject getNetworkInfo();

    @Keep
    String getRD(String str);

    @Keep
    String getRM(String str);

    @KsAdSdkDynamicApi
    @Keep
    int getSDKType();

    @KsAdSdkDynamicApi
    @Keep
    String getSDKVersion();

    @KsAdSdkDynamicApi
    @Keep
    int getSDKVersionCode();

    @KsAdSdkDynamicApi
    @Keep
    void init(Context context, SdkConfig sdkConfig);

    @KsAdSdkDynamicApi
    @Keep
    boolean isDebugLogEnable();

    @KsAdSdkDynamicApi
    @Keep
    <T extends IComponentProxy> T newComponentProxy(Class<?> cls, Object obj);

    @KsAdSdkDynamicApi
    @Keep
    <T> T newInstance(Class<T> cls);

    @KsAdSdkDynamicApi
    @Keep
    void pauseCurrentPlayer();

    @Keep
    void re(Object obj);

    @KsAdSdkDynamicApi
    @Keep
    @Deprecated
    void reportBatchEvent(int i4, Map<String, Object> map);

    @KsAdSdkDynamicApi
    @Keep
    void resumeCurrentPlayer();

    @Keep
    void sR(String str, Map<String, String> map, String str2);

    @KsAdSdkApi
    @Keep
    void setAdxEnable(boolean z3);

    @KsAdSdkDynamicApi
    @Keep
    void setApiVersion(String str);

    @KsAdSdkDynamicApi
    @Keep
    void setApiVersionCode(int i4);

    @KsAdSdkDynamicApi
    @Keep
    void setAppTag(String str);

    @KsAdSdkDynamicApi
    @Keep
    void setIsExternal(boolean z3);

    @KsAdSdkDynamicApi
    @Keep
    void setLaunchTime(long j4);

    @KsAdSdkDynamicApi
    @Keep
    void setLoadingLottieAnimation(boolean z3, @RawRes int i4);

    @KsAdSdkDynamicApi
    @Keep
    void setLoadingLottieAnimationColor(boolean z3, @ColorInt int i4);

    @KsAdSdkDynamicApi
    @Keep
    void setPersonalRecommend(boolean z3);

    @KsAdSdkDynamicApi
    @Keep
    void setProgrammaticRecommend(boolean z3);

    @KsAdSdkDynamicApi
    @Keep
    void setThemeMode(int i4);

    @KsAdSdkDynamicApi
    @Keep
    void unInit();
}
