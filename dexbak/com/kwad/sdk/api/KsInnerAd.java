package com.kwad.sdk.api;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@KsAdSdkApi
@Keep
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface KsInnerAd {

    @KsAdSdkApi
    @Keep
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface KsInnerAdInteractionListener {
        @KsAdSdkApi
        @Keep
        void onAdClicked(KsInnerAd ksInnerAd);

        @KsAdSdkApi
        @Keep
        void onAdShow(KsInnerAd ksInnerAd);
    }

    @Keep
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public @interface KsInnerAdType {
        public static final int AGGREGATION = 1;
        public static final int REFLOW = 2;
        public static final int UNKNOWN = 0;
    }

    int getType();
}
