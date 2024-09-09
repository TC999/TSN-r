package com.kwad.components.core.internal.api;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class KSAdVideoPlayConfigImpl implements KsAdVideoPlayConfig, Serializable {
    private static final long serialVersionUID = -154151744722615768L;
    public boolean dataFlowAutoStart;
    public boolean hasNoCache;
    public int videoAutoPlayType;
    public boolean videoSoundEnable;
    private int videoSoundValue = 0;
    private int dataFlowAutoStartValue = 0;

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initModeImplForInvoker")
    public static void register() {
        com.kwad.sdk.service.b.b(KsAdVideoPlayConfig.class, KSAdVideoPlayConfigImpl.class);
    }

    public int getDataFlowAutoStartValue() {
        return this.dataFlowAutoStartValue;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public int getVideoAutoPlayType() {
        return this.videoAutoPlayType;
    }

    public int getVideoSoundValue() {
        return this.videoSoundValue;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public boolean isDataFlowAutoStart() {
        return this.dataFlowAutoStart;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public boolean isNoCache() {
        return this.hasNoCache;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public boolean isVideoSoundEnable() {
        return this.videoSoundEnable;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public void setDataFlowAutoStart(boolean z3) {
        this.dataFlowAutoStart = z3;
        this.dataFlowAutoStartValue = 1;
        this.videoAutoPlayType = 0;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public void setNoCache() {
        this.hasNoCache = true;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public void setVideoAutoPlayType(int i4) {
        this.videoAutoPlayType = i4;
        this.dataFlowAutoStartValue = 0;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public void setVideoSoundEnable(boolean z3) {
        this.videoSoundEnable = z3;
        this.videoSoundValue = 1;
    }
}
