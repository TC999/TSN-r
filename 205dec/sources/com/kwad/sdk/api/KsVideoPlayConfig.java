package com.kwad.sdk.api;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsAdSdkApi
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface KsVideoPlayConfig extends Serializable {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsAdSdkApi
    @Keep
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class Builder {
        private boolean showLandscape;
        private String showScene;
        private boolean skipLongTime;
        private boolean videoSoundEnable = true;

        @KsAdSdkApi
        @Keep
        public KsVideoPlayConfig build() {
            KsVideoPlayConfig ksVideoPlayConfig = (KsVideoPlayConfig) Loader.get().newInstance(KsVideoPlayConfig.class);
            ksVideoPlayConfig.setShowScene(this.showScene);
            ksVideoPlayConfig.setShowLandscape(this.showLandscape);
            ksVideoPlayConfig.setSkipThirtySecond(this.skipLongTime);
            ksVideoPlayConfig.setVideoSoundEnable(this.videoSoundEnable);
            return ksVideoPlayConfig;
        }

        @KsAdSdkApi
        @Keep
        public Builder showLandscape(boolean z3) {
            this.showLandscape = z3;
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder showScene(String str) {
            this.showScene = str;
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder skipThirtySecond(boolean z3) {
            this.skipLongTime = z3;
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder videoSoundEnable(boolean z3) {
            this.videoSoundEnable = z3;
            return this;
        }
    }

    @KsAdSdkApi
    @Keep
    String getShowScene();

    @KsAdSdkApi
    @Keep
    boolean isShowLandscape();

    @KsAdSdkApi
    @Keep
    boolean isSkipThirtySecond();

    @KsAdSdkApi
    @Keep
    boolean isVideoSoundEnable();

    @KsAdSdkApi
    @Keep
    void setShowLandscape(boolean z3);

    @KsAdSdkApi
    @Keep
    void setShowScene(String str);

    @KsAdSdkApi
    @Keep
    void setSkipThirtySecond(boolean z3);

    @KsAdSdkApi
    @Keep
    void setVideoSoundEnable(boolean z3);
}
