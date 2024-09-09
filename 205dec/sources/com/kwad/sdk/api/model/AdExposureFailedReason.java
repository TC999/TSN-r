package com.kwad.sdk.api.model;

import androidx.annotation.Keep;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class AdExposureFailedReason {
    public String adnName;
    public int adnType;
    public int winEcpm;

    public AdExposureFailedReason setAdnName(String str) {
        this.adnName = str;
        return this;
    }

    public AdExposureFailedReason setAdnType(int i4) {
        this.adnType = i4;
        return this;
    }

    public AdExposureFailedReason setWinEcpm(int i4) {
        this.winEcpm = i4;
        return this;
    }
}
