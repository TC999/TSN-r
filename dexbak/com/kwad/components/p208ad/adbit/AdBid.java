package com.kwad.components.p208ad.adbit;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.p408a.C10482a;
import java.io.Serializable;

@KsJson
/* renamed from: com.kwad.components.ad.adbit.AdBid */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AdBid extends C10482a implements Serializable {
    private static final long serialVersionUID = -3937320872050889919L;
    public int bidEcpm;
    public long creativeId;
    public long ecpm;
    public String materialId;
    public String winNoticeUrl;
}
