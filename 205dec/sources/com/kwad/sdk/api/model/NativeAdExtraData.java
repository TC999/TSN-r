package com.kwad.sdk.api.model;

import androidx.annotation.Keep;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class NativeAdExtraData {
    private boolean enableShake;
    private int showLiveStatus;
    private int showLiveStyle;

    public int getShowLiveStatus() {
        return this.showLiveStatus;
    }

    public int getShowLiveStyle() {
        return this.showLiveStyle;
    }

    public boolean isEnableShake() {
        return this.enableShake;
    }

    public NativeAdExtraData setEnableShake(boolean z3) {
        this.enableShake = z3;
        return this;
    }

    public NativeAdExtraData setShowLiveStatus(int i4) {
        this.showLiveStatus = i4;
        return this;
    }

    public NativeAdExtraData setShowLiveStyle(int i4) {
        this.showLiveStyle = i4;
        return this;
    }
}
