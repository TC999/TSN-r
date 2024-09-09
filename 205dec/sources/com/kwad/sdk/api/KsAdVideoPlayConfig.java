package com.kwad.sdk.api;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsAdSdkApi
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface KsAdVideoPlayConfig {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsAdSdkApi
    @Keep
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class Builder {
        private boolean dataFlowAutoStart;
        private boolean videoSoundEnable;
        private boolean isNoCache = false;
        KsAdVideoPlayConfig config = (KsAdVideoPlayConfig) Loader.get().newInstance(KsAdVideoPlayConfig.class);

        @KsAdSdkApi
        @Keep
        public KsAdVideoPlayConfig build() {
            return this.config;
        }

        @KsAdSdkApi
        @Keep
        @Deprecated
        public Builder dataFlowAutoStart(boolean z3) {
            this.config.setDataFlowAutoStart(z3);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder noCache() {
            this.config.setNoCache();
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder videoAutoPlayType(int i4) {
            this.config.setVideoAutoPlayType(i4);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder videoSoundEnable(boolean z3) {
            this.config.setVideoSoundEnable(z3);
            return this;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    @KsAdSdkApi
    @Keep
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public @interface VideoAutoPlayType {
        public static final int AUTO_PLAY = 1;
        public static final int AUTO_PLAY_WIFI = 2;
        public static final int NO_AUTO_PLAY = 3;
        public static final int UNKNOWN = 0;
    }

    @KsAdSdkApi
    @Keep
    int getVideoAutoPlayType();

    @KsAdSdkApi
    @Keep
    boolean isDataFlowAutoStart();

    @KsAdSdkApi
    @Keep
    boolean isNoCache();

    @KsAdSdkApi
    @Keep
    boolean isVideoSoundEnable();

    @KsAdSdkApi
    @Keep
    @Deprecated
    void setDataFlowAutoStart(boolean z3);

    @KsAdSdkApi
    @Keep
    void setNoCache();

    @KsAdSdkApi
    @Keep
    void setVideoAutoPlayType(int i4);

    @KsAdSdkApi
    @Keep
    void setVideoSoundEnable(boolean z3);
}
