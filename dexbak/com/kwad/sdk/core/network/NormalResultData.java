package com.kwad.sdk.core.network;

import com.kwad.sdk.core.response.model.BaseResultData;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class NormalResultData extends BaseResultData {
    public int code;
    public String data;
    public Map<String, String> header;

    public void parseResponse(C10415c c10415c) {
        this.code = c10415c.code;
        this.data = c10415c.avs;
        this.header = null;
    }
}
