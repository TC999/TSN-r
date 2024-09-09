package com.kwad.sdk.api;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsAdSdkApi
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface KsInnerAd {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsAdSdkApi
    @Keep
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface KsInnerAdInteractionListener {
        @KsAdSdkApi
        @Keep
        void onAdClicked(KsInnerAd ksInnerAd);

        @KsAdSdkApi
        @Keep
        void onAdShow(KsInnerAd ksInnerAd);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    @Keep
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public @interface KsInnerAdType {
        public static final int AGGREGATION = 1;
        public static final int REFLOW = 2;
        public static final int UNKNOWN = 0;
    }

    int getType();
}
