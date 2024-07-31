package com.kwai.adclient.kscommerciallogger.snapshot;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwai.adclient.kscommerciallogger.snapshot.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C11170d {
    private final String aUu;
    private final LinkedHashMap<String, String> aUv = new LinkedHashMap<>();
    private final long time = System.nanoTime();

    /* JADX INFO: Access modifiers changed from: package-private */
    public C11170d(String str) {
        this.aUu = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: Oq */
    public synchronized JSONObject mo23487Oq() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : this.aUv.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put(RtspHeaders.Values.TIME, this.time);
            jSONObject.put("span_name", this.aUu);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
