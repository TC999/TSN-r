package com.kwad.sdk.api;

import android.app.Activity;
import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.KsAdSdkApi;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsAdSdkApi
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface KsLoadManager {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsAdSdkApi
    @Keep
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface DrawAdListener {
        @KsAdSdkApi
        @Keep
        @MainThread
        void onDrawAdLoad(@Nullable List<KsDrawAd> list);

        @KsAdSdkApi
        @Keep
        @MainThread
        void onError(int i4, String str);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsAdSdkApi
    @Keep
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface FeedAdListener {
        @KsAdSdkApi
        @Keep
        @MainThread
        void onError(int i4, String str);

        @KsAdSdkApi
        @Keep
        @MainThread
        void onFeedAdLoad(@Nullable List<KsFeedAd> list);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsAdSdkApi
    @Keep
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface FullScreenVideoAdListener {
        @KsAdSdkApi
        @Keep
        @MainThread
        void onError(int i4, String str);

        @KsAdSdkApi
        @Keep
        @MainThread
        void onFullScreenVideoAdLoad(@Nullable List<KsFullScreenVideoAd> list);

        @KsAdSdkApi
        @Keep
        @MainThread
        void onFullScreenVideoResult(@Nullable List<KsFullScreenVideoAd> list);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsAdSdkApi
    @Keep
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface InterstitialAdListener {
        @KsAdSdkApi
        @Keep
        @MainThread
        void onError(int i4, String str);

        @KsAdSdkApi
        @Keep
        @MainThread
        void onInterstitialAdLoad(@Nullable List<KsInterstitialAd> list);

        @KsAdSdkApi
        @Keep
        void onRequestResult(int i4);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsAdSdkApi
    @Keep
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface NativeAdListener {
        @KsAdSdkApi
        @Keep
        @MainThread
        void onError(int i4, String str);

        @KsAdSdkApi
        @Keep
        @MainThread
        void onNativeAdLoad(@Nullable List<KsNativeAd> list);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsAdSdkApi
    @Keep
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface RewardVideoAdListener {
        @KsAdSdkApi
        @Keep
        @MainThread
        void onError(int i4, String str);

        @KsAdSdkApi
        @Keep
        @MainThread
        void onRewardVideoAdLoad(@Nullable List<KsRewardVideoAd> list);

        @KsAdSdkApi
        @Keep
        @MainThread
        void onRewardVideoResult(@Nullable List<KsRewardVideoAd> list);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsAdSdkApi
    @Keep
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface SplashScreenAdListener {
        @KsAdSdkApi
        @Keep
        @MainThread
        void onError(int i4, String str);

        @KsAdSdkApi
        @Keep
        void onRequestResult(int i4);

        @KsAdSdkApi
        @Keep
        @MainThread
        void onSplashScreenAdLoad(@Nullable KsSplashScreenAd ksSplashScreenAd);
    }

    @KsAdSdkApi
    @Keep
    String getBidRequestToken(KsScene ksScene);

    @KsAdSdkApi
    @Keep
    String getBidRequestTokenV2(KsScene ksScene);

    @KsAdSdkApi
    @Keep
    @MainThread
    void loadConfigFeedAd(KsScene ksScene, @NonNull FeedAdListener feedAdListener);

    @KsAdSdkApi
    @Keep
    @MainThread
    void loadDrawAd(KsScene ksScene, @NonNull DrawAdListener drawAdListener);

    @KsAdSdkApi
    @Keep
    @Deprecated
    @MainThread
    void loadFeedAd(KsScene ksScene, @NonNull FeedAdListener feedAdListener);

    @KsAdSdkApi
    @Keep
    void loadFullScreenVideoAd(KsScene ksScene, @NonNull FullScreenVideoAdListener fullScreenVideoAdListener);

    @KsAdSdkApi
    @Keep
    @MainThread
    void loadInterstitialAd(@NonNull KsScene ksScene, @NonNull InterstitialAdListener interstitialAdListener);

    @KsAdSdkApi
    @Keep
    @MainThread
    void loadNativeAd(KsScene ksScene, @NonNull NativeAdListener nativeAdListener);

    @KsAdSdkApi
    @Keep
    @MainThread
    void loadNativeAd(String str, @NonNull NativeAdListener nativeAdListener);

    @KsAdSdkApi
    @Keep
    @MainThread
    void loadRewardVideoAd(KsScene ksScene, @NonNull RewardVideoAdListener rewardVideoAdListener);

    @KsAdSdkApi
    @Keep
    @MainThread
    void loadSplashScreenAd(@NonNull KsScene ksScene, @NonNull SplashScreenAdListener splashScreenAdListener);

    boolean showInstallDialog(Activity activity, KsExitInstallListener ksExitInstallListener);
}
