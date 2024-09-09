package com.kwad.sdk.api;

import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.model.AdExposureFailedReason;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsAdSdkApi
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface KsFeedAd extends BaseKSAd {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsAdSdkApi
    @Keep
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface AdInteractionListener {
        @KsAdSdkApi
        @Keep
        void onAdClicked();

        @KsAdSdkApi
        @Keep
        void onAdShow();

        @KsAdSdkApi
        @Keep
        void onDislikeClicked();

        @KsAdSdkApi
        @Keep
        void onDownloadTipsDialogDismiss();

        @KsAdSdkApi
        @Keep
        void onDownloadTipsDialogShow();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsAdSdkApi
    @Keep
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface AdRenderListener {
        @KsAdSdkApi
        @Keep
        void onAdRenderFailed(int i4, String str);

        @KsAdSdkApi
        @Keep
        void onAdRenderSuccess(View view);
    }

    @KsAdSdkApi
    @Keep
    int getECPM();

    @Nullable
    @KsAdSdkApi
    @Keep
    View getFeedView(Context context);

    @KsAdSdkApi
    @Keep
    int getInteractionType();

    @KsAdSdkApi
    @Keep
    int getMaterialType();

    @KsAdSdkApi
    @Keep
    void render(AdRenderListener adRenderListener);

    @KsAdSdkApi
    @Keep
    void reportAdExposureFailed(int i4, AdExposureFailedReason adExposureFailedReason);

    @KsAdSdkApi
    @Keep
    void setAdInteractionListener(AdInteractionListener adInteractionListener);

    @KsAdSdkApi
    @Keep
    @Deprecated
    void setBidEcpm(int i4);

    @KsAdSdkApi
    @Keep
    void setBidEcpm(long j4, long j5);

    @KsAdSdkApi
    @Keep
    void setVideoPlayConfig(@Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig);

    @KsAdSdkApi
    @Keep
    void setVideoSoundEnable(boolean z3);
}
