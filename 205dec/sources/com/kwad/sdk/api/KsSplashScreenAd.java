package com.kwad.sdk.api;

import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.KSAdInfoData;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsAdSdkApi
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface KsSplashScreenAd extends BaseKSAd {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsAdSdkApi
    @Keep
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface SplashScreenAdInteractionListener {
        @KsAdSdkApi
        @Keep
        void onAdClicked();

        @KsAdSdkApi
        @Keep
        void onAdShowEnd();

        @KsAdSdkApi
        @Keep
        void onAdShowError(int i4, String str);

        @KsAdSdkApi
        @Keep
        void onAdShowStart();

        @KsAdSdkApi
        @Keep
        void onDownloadTipsDialogCancel();

        @KsAdSdkApi
        @Keep
        void onDownloadTipsDialogDismiss();

        @KsAdSdkApi
        @Keep
        void onDownloadTipsDialogShow();

        @KsAdSdkApi
        @Keep
        void onSkippedAd();
    }

    @KsAdSdkApi
    @Keep
    int getECPM();

    @KsAdSdkApi
    @Keep
    int getInteractionType();

    @KsAdSdkApi
    @Keep
    KSAdInfoData getKSAdInfoData();

    @KsAdSdkApi
    @Keep
    int getMaterialType();

    @KsAdSdkApi
    @Keep
    View getView(Context context, SplashScreenAdInteractionListener splashScreenAdInteractionListener);

    @KsAdSdkApi
    @Keep
    boolean isAdEnable();

    @KsAdSdkApi
    @Keep
    @Deprecated
    boolean isVideo();

    @KsAdSdkApi
    @Keep
    void reportAdExposureFailed(int i4, AdExposureFailedReason adExposureFailedReason);

    @KsAdSdkApi
    @Keep
    @Deprecated
    void setBidEcpm(int i4);

    @KsAdSdkApi
    @Keep
    void setBidEcpm(long j4, long j5);
}
