package com.kwad.sdk;

import android.content.Context;
import androidx.annotation.ColorInt;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.RawRes;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.IComponentProxy;
import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsAdSdkDynamicImpl(IKsAdSDK.class)
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class KsAdSDKImpl implements IKsAdSDK {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class a {
        private static final KsAdSDKImpl akK = new KsAdSDKImpl();
    }

    @KsAdSdkDynamicImpl(IKsAdSDK.class)
    @Keep
    public static KsAdSDKImpl get() {
        return a.akK;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void addHp(@NonNull Map<String, String> map) {
        k.zd();
        k.d(map);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public Object dM(String str, Object... objArr) {
        k.zd();
        return k.c(str, objArr);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void deleteCache() {
        k.zd();
        k.deleteCache();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @NonNull
    public KsLoadManager getAdManager() {
        return k.zd().getAdManager();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getApiVersion() {
        return k.zd().getApiVersion();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getApiVersionCode() {
        return k.zd().getApiVersionCode();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getAppId() {
        k.zd();
        return k.getAppId();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getAppInfo() {
        k.zd();
        return k.getAppInfo();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getAppName() {
        k.zd();
        return k.getAppName();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public Context getContext() {
        k.zd();
        return k.getContext();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getDeviceInfo() {
        k.zd();
        return k.getDeviceInfo();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getDid() {
        k.zd();
        return k.getDid();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getNetworkInfo() {
        k.zd();
        return k.getNetworkInfo();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getRD(String str) {
        k.zd();
        return k.bZ(str);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getRM(String str) {
        k.zd();
        return k.bY(str);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getSDKType() {
        k.zd();
        return 1;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getSDKVersion() {
        k.zd();
        return k.getSDKVersion();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getSDKVersionCode() {
        k.zd();
        return BuildConfig.VERSION_CODE;
    }

    public SdkConfig getSdkConfig() {
        k.zd();
        return k.getSdkConfig();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public synchronized void init(Context context, SdkConfig sdkConfig) {
        k.zd().init(context, sdkConfig);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public boolean isDebugLogEnable() {
        k.zd();
        return k.isDebugLogEnable();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public <T extends IComponentProxy> T newComponentProxy(Class<?> cls, Object obj) {
        return (T) k.zd().newComponentProxy(cls, obj);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public <T> T newInstance(Class<T> cls) {
        k.zd();
        return (T) k.newInstance(cls);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void pauseCurrentPlayer() {
        k.zd();
        k.pauseCurrentPlayer();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void re(Object obj) {
        if (obj instanceof Throwable) {
            k.zd();
            k.k((Throwable) obj);
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void reportBatchEvent(int i4, Map<String, Object> map) {
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void resumeCurrentPlayer() {
        k.zd();
        k.resumeCurrentPlayer();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void sR(String str, Map<String, String> map, String str2) {
        k.zd();
        k.b(str, map, str2);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setAdxEnable(boolean z3) {
        k.zd().setAdxEnable(z3);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setApiVersion(String str) {
        k.zd().setApiVersion(str);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setApiVersionCode(int i4) {
        k.zd().setApiVersionCode(i4);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setAppTag(String str) {
        k.zd().setAppTag(str);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setIsExternal(boolean z3) {
        k.zd().setIsExternal(z3);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setLaunchTime(long j4) {
        k.zd().setLaunchTime(j4);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setLoadingLottieAnimation(boolean z3, @RawRes int i4) {
        k.zd();
        k.setLoadingLottieAnimation(z3, i4);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setLoadingLottieAnimationColor(boolean z3, @ColorInt int i4) {
        k.zd();
        k.setLoadingLottieAnimationColor(z3, i4);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setPersonalRecommend(boolean z3) {
        k.zd().setPersonalRecommend(z3);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setProgrammaticRecommend(boolean z3) {
        k.zd().setProgrammaticRecommend(z3);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setThemeMode(int i4) {
        k.zd();
        k.setThemeMode(i4);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void unInit() {
        k.zd().unInit();
    }

    private KsAdSDKImpl() {
    }
}
