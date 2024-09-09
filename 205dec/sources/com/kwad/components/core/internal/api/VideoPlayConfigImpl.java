package com.kwad.components.core.internal.api;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.api.KsVideoPlayConfig;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class VideoPlayConfigImpl implements KsVideoPlayConfig {
    private static final long serialVersionUID = -7203854889686049813L;
    private boolean showLandscape;
    private String showScene;
    private boolean skipThirtySecond;
    private boolean videoSoundEnable = true;

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initModeImplForInvoker")
    public static void register() {
        com.kwad.sdk.service.b.b(KsVideoPlayConfig.class, VideoPlayConfigImpl.class);
    }

    @Override // com.kwad.sdk.api.KsVideoPlayConfig
    public String getShowScene() {
        return this.showScene;
    }

    @Override // com.kwad.sdk.api.KsVideoPlayConfig
    public boolean isShowLandscape() {
        return this.showLandscape;
    }

    @Override // com.kwad.sdk.api.KsVideoPlayConfig
    public boolean isSkipThirtySecond() {
        return this.skipThirtySecond;
    }

    @Override // com.kwad.sdk.api.KsVideoPlayConfig
    public boolean isVideoSoundEnable() {
        return this.videoSoundEnable;
    }

    @Override // com.kwad.sdk.api.KsVideoPlayConfig
    public void setShowLandscape(boolean z3) {
        this.showLandscape = z3;
    }

    @Override // com.kwad.sdk.api.KsVideoPlayConfig
    public void setShowScene(String str) {
        this.showScene = str;
    }

    @Override // com.kwad.sdk.api.KsVideoPlayConfig
    public void setSkipThirtySecond(boolean z3) {
        this.skipThirtySecond = z3;
    }

    @Override // com.kwad.sdk.api.KsVideoPlayConfig
    public void setVideoSoundEnable(boolean z3) {
        this.videoSoundEnable = z3;
    }
}
