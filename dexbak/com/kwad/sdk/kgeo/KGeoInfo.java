package com.kwad.sdk.kgeo;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.p408a.C10482a;
import java.io.Serializable;

@KsJson
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class KGeoInfo extends C10482a implements Serializable {
    private static final long serialVersionUID = 7513106797546359464L;
    public double latitude;
    public double longitude;
    public int range;
    public int rate;
}
