package com.kwad.sdk.commercial.model;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.p408a.C10482a;
import java.io.Serializable;

@KsJson
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class WebCloseStatus extends C10482a implements Serializable {
    private static final long serialVersionUID = -998295657148922925L;
    public int closeType;
    public boolean interactSuccess;
}
