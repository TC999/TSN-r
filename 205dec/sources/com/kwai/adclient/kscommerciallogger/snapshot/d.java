package com.kwai.adclient.kscommerciallogger.snapshot;

import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class d {
    private final String aUu;
    private final LinkedHashMap<String, String> aUv = new LinkedHashMap<>();
    private final long time = System.nanoTime();

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.aUu = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized JSONObject Oq() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : this.aUv.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put("time", this.time);
            jSONObject.put("span_name", this.aUu);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }
}
