package com.kwad.sdk.api;

import android.content.Context;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.loader.t;
import com.kwad.sdk.api.loader.u;
import com.kwad.sdk.api.proxy.app.AdSdkFileProvider;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsAdSdkApi
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class KsAdSDK {
    private static Context mOriginalAppContext;
    private static String sAppTag;
    public static final AtomicBoolean sHasInit = new AtomicBoolean(false);
    private static final AtomicBoolean sHasRest = new AtomicBoolean(false);
    @Keep
    private static IKsAdSDK sSdk;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    @Keep
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public @interface KsThemeModeType {
        public static final int NIGHT = 1;
        public static final int NORMAL = 0;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    @Keep
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public @interface SdkType {
        public static final int AD = 1;
        public static final int CAR = 5;
        public static final int CT = 2;
        public static final int CT_PURE = 4;
        public static final int EC = 3;
    }

    @KsAdSdkApi
    @Keep
    public static void deleteCache() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.deleteCache();
        }
    }

    @KsAdSdkApi
    @Keep
    public static String getAppId() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            return iKsAdSDK.getAppId();
        }
        return null;
    }

    @KsAdSdkApi
    @Keep
    public static String getAppName() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            return iKsAdSDK.getAppName();
        }
        return null;
    }

    @Nullable
    @KsAdSdkApi
    @Keep
    public static Context getContext() {
        return mOriginalAppContext;
    }

    @KsAdSdkApi
    @Keep
    public static String getDid() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            return iKsAdSDK.getDid();
        }
        return null;
    }

    @KsAdSdkApi
    @Keep
    public static synchronized KsLoadManager getLoadManager() {
        synchronized (KsAdSDK.class) {
            if (sSdk != null && sHasInit.get()) {
                return sSdk.getAdManager();
            }
            Log.e("KsAdSDK", "please init sdk before getLoadManager");
            return new b();
        }
    }

    @KsAdSdkApi
    @Keep
    public static int getSDKType() {
        return 1;
    }

    @KsAdSdkApi
    @Keep
    public static String getSDKVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @KsAdSdkApi
    @Keep
    public static String getSDKVersion(int i4) {
        return i4 != 1 ? "" : BuildConfig.VERSION_NAME;
    }

    public static boolean haseInit() {
        return sHasInit.get();
    }

    @KsAdSdkApi
    @Keep
    public static synchronized boolean init(Context context, SdkConfig sdkConfig) {
        Context context2;
        Throwable th;
        synchronized (KsAdSDK.class) {
            try {
                if (context != null && sdkConfig != null) {
                    mOriginalAppContext = context;
                    try {
                        context2 = com.kwad.sdk.api.loader.c.ax(context);
                        if (context2 != null) {
                            try {
                                IKsAdSDK init = Loader.get().init(context2, KsAdSDK.class.getClassLoader());
                                sSdk = init;
                                init.setApiVersion(BuildConfig.VERSION_NAME);
                                sSdk.setApiVersionCode(BuildConfig.VERSION_CODE);
                                sSdk.setLaunchTime(AdSdkFileProvider.sLaunchTime);
                                Context wrapContextIfNeed = Wrapper.wrapContextIfNeed(context2);
                                if (wrapContextIfNeed != null) {
                                    sSdk.init(wrapContextIfNeed, sdkConfig);
                                    sSdk.setAppTag(sAppTag);
                                    u.a(context2, sSdk);
                                    t.a(context2, sdkConfig);
                                    c.mQ();
                                    sHasInit.set(sSdk != null);
                                    return sHasInit.get();
                                }
                                throw new RuntimeException("init wrapContextIfNeed Exception");
                            } catch (Throwable th2) {
                                th = th2;
                                revertDynamic(th, context2, sdkConfig);
                                return false;
                            }
                        }
                        throw new RuntimeException("init wrapperApp Exception");
                    } catch (Throwable th3) {
                        context2 = context;
                        th = th3;
                    }
                } else {
                    throw new RuntimeException("init context or config is null");
                }
            }
        }
    }

    @KsAdSdkApi
    @Keep
    public static boolean isDebugLogEnable() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            return iKsAdSDK.isDebugLogEnable();
        }
        return false;
    }

    @KsAdSdkApi
    @Keep
    public static void pauseCurrentPlayer() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.pauseCurrentPlayer();
        }
    }

    @KsAdSdkApi
    @Keep
    public static void resumeCurrentPlayer() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.resumeCurrentPlayer();
        }
    }

    private static void revertDynamic(Throwable th, Context context, SdkConfig sdkConfig) {
        AtomicBoolean atomicBoolean = sHasRest;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        u.aF(context);
        Loader.get().rest();
        Log.d("KSAdSDK", "init appId after reset:" + sdkConfig.appId);
        init(context, sdkConfig);
        c.m(th);
    }

    @KsAdSdkApi
    @Keep
    public static void setAdxEnable(boolean z3) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setAdxEnable(z3);
        }
    }

    @KsAdSdkApi
    @Keep
    public static void setAppTag(String str) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setAppTag(str);
        } else {
            sAppTag = str;
        }
    }

    public static void setLoadingLottieAnimation(boolean z3, @RawRes int i4) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setLoadingLottieAnimation(z3, i4);
        }
    }

    public static void setLoadingLottieAnimationColor(boolean z3, @ColorInt int i4) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setLoadingLottieAnimationColor(z3, i4);
        }
    }

    @KsAdSdkApi
    @Keep
    public static void setPersonalRecommend(boolean z3) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setPersonalRecommend(z3);
        }
    }

    @KsAdSdkApi
    @Keep
    public static void setProgrammaticRecommend(boolean z3) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setProgrammaticRecommend(z3);
        }
    }

    public static void setThemeMode(int i4) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setThemeMode(i4);
        }
    }

    @KsAdSdkApi
    @Keep
    public static void unInit() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.unInit();
        }
        sSdk = null;
    }
}
