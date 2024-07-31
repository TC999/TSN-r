package com.kwad.components.p208ad.interstitial.report.realtime.model;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import java.io.Serializable;

@KsJson
/* renamed from: com.kwad.components.ad.interstitial.report.realtime.model.InterstitialRealTimeInfo */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class InterstitialRealTimeInfo extends AbstractC9822a implements Serializable {
    public String materialUrl;
    public long monitorIndex;
    public long renderType;

    public void setMaterialUrl(String str) {
        this.materialUrl = str;
    }

    public void setRenderType(long j) {
        this.renderType = j;
    }
}
