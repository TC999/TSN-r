package com.kwad.components.offline.api.core.network.model;

import com.kwad.sdk.core.network.C10415c;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class NormalOfflineCompoResultData extends BaseOfflineCompoResultData {
    public int code;
    public String data;
    public String header;

    public void parseResponse(C10415c c10415c) {
        this.code = c10415c.code;
        this.data = c10415c.avs;
        this.header = null;
    }
}
