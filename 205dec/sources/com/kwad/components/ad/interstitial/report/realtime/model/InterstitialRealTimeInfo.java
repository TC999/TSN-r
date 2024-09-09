package com.kwad.components.ad.interstitial.report.realtime.model;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.c.a;
import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class InterstitialRealTimeInfo extends a implements Serializable {
    public String materialUrl;
    public long monitorIndex;
    public long renderType;

    public void setMaterialUrl(String str) {
        this.materialUrl = str;
    }

    public void setRenderType(long j4) {
        this.renderType = j4;
    }
}
