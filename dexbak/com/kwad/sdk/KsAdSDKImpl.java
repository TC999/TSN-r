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

@KsAdSdkDynamicImpl(IKsAdSDK.class)
@Keep
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class KsAdSDKImpl implements IKsAdSDK {

    /* renamed from: com.kwad.sdk.KsAdSDKImpl$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C9658a {
        private static final KsAdSDKImpl akK = new KsAdSDKImpl();
    }

    @KsAdSdkDynamicImpl(IKsAdSDK.class)
    @Keep
    public static KsAdSDKImpl get() {
        return C9658a.akK;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void addHp(@NonNull Map<String, String> map) {
        C10829k.m24699zd();
        C10829k.m24706d(map);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    /* renamed from: dM */
    public Object mo28008dM(String str, Object... objArr) {
        C10829k.m24699zd();
        return C10829k.m24707c(str, objArr);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void deleteCache() {
        C10829k.m24699zd();
        C10829k.deleteCache();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @NonNull
    public KsLoadManager getAdManager() {
        return C10829k.m24699zd().getAdManager();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getApiVersion() {
        return C10829k.m24699zd().getApiVersion();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getApiVersionCode() {
        return C10829k.m24699zd().getApiVersionCode();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getAppId() {
        C10829k.m24699zd();
        return C10829k.getAppId();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getAppInfo() {
        C10829k.m24699zd();
        return C10829k.getAppInfo();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getAppName() {
        C10829k.m24699zd();
        return C10829k.getAppName();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public Context getContext() {
        C10829k.m24699zd();
        return C10829k.getContext();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getDeviceInfo() {
        C10829k.m24699zd();
        return C10829k.getDeviceInfo();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getDid() {
        C10829k.m24699zd();
        return C10829k.getDid();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getNetworkInfo() {
        C10829k.m24699zd();
        return C10829k.getNetworkInfo();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getRD(String str) {
        C10829k.m24699zd();
        return C10829k.m24708bZ(str);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getRM(String str) {
        C10829k.m24699zd();
        return C10829k.m24709bY(str);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getSDKType() {
        C10829k.m24699zd();
        return 1;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getSDKVersion() {
        C10829k.m24699zd();
        return C10829k.getSDKVersion();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getSDKVersionCode() {
        C10829k.m24699zd();
        return BuildConfig.VERSION_CODE;
    }

    public SdkConfig getSdkConfig() {
        C10829k.m24699zd();
        return C10829k.getSdkConfig();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public synchronized void init(Context context, SdkConfig sdkConfig) {
        C10829k.m24699zd().init(context, sdkConfig);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public boolean isDebugLogEnable() {
        C10829k.m24699zd();
        return C10829k.isDebugLogEnable();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public <T extends IComponentProxy> T newComponentProxy(Class<?> cls, Object obj) {
        return (T) C10829k.m24699zd().newComponentProxy(cls, obj);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public <T> T newInstance(Class<T> cls) {
        C10829k.m24699zd();
        return (T) C10829k.newInstance(cls);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void pauseCurrentPlayer() {
        C10829k.m24699zd();
        C10829k.pauseCurrentPlayer();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    /* renamed from: re */
    public void mo28007re(Object obj) {
        if (obj instanceof Throwable) {
            C10829k.m24699zd();
            C10829k.m24704k((Throwable) obj);
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void reportBatchEvent(int i, Map<String, Object> map) {
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void resumeCurrentPlayer() {
        C10829k.m24699zd();
        C10829k.resumeCurrentPlayer();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    /* renamed from: sR */
    public void mo28006sR(String str, Map<String, String> map, String str2) {
        C10829k.m24699zd();
        C10829k.m24710b(str, map, str2);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setAdxEnable(boolean z) {
        C10829k.m24699zd().setAdxEnable(z);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setApiVersion(String str) {
        C10829k.m24699zd().setApiVersion(str);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setApiVersionCode(int i) {
        C10829k.m24699zd().setApiVersionCode(i);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setAppTag(String str) {
        C10829k.m24699zd().setAppTag(str);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setIsExternal(boolean z) {
        C10829k.m24699zd().setIsExternal(z);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setLaunchTime(long j) {
        C10829k.m24699zd().setLaunchTime(j);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setLoadingLottieAnimation(boolean z, @RawRes int i) {
        C10829k.m24699zd();
        C10829k.setLoadingLottieAnimation(z, i);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setLoadingLottieAnimationColor(boolean z, @ColorInt int i) {
        C10829k.m24699zd();
        C10829k.setLoadingLottieAnimationColor(z, i);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setPersonalRecommend(boolean z) {
        C10829k.m24699zd().setPersonalRecommend(z);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setProgrammaticRecommend(boolean z) {
        C10829k.m24699zd().setProgrammaticRecommend(z);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setThemeMode(int i) {
        C10829k.m24699zd();
        C10829k.setThemeMode(i);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void unInit() {
        C10829k.m24699zd().unInit();
    }

    private KsAdSDKImpl() {
    }
}
