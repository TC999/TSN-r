package com.kwad.sdk.core.network;

import com.kwad.sdk.core.response.model.BaseResultData;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class NormalResultData extends BaseResultData {
    public int code;
    public String data;
    public Map<String, String> header;

    public void parseResponse(c cVar) {
        this.code = cVar.code;
        this.data = cVar.avs;
        this.header = null;
    }
}
