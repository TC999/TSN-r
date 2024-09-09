package com.kwad.sdk.api.model;

import androidx.annotation.Keep;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class SplashAdExtraData {
    private boolean isDisableRotate;
    private boolean isDisableShake;
    private boolean isDisableSlide;

    public boolean getDisableRotateStatus() {
        return this.isDisableRotate;
    }

    public boolean getDisableShakeStatus() {
        return this.isDisableShake;
    }

    public boolean getDisableSlideStatus() {
        return this.isDisableSlide;
    }

    public void setDisableRotateStatus(boolean z3) {
        this.isDisableRotate = z3;
    }

    public void setDisableShakeStatus(boolean z3) {
        this.isDisableShake = z3;
    }

    public void setDisableSlideStatus(boolean z3) {
        this.isDisableSlide = z3;
    }
}
