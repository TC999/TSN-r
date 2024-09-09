package com.kwai.adclient.kscommerciallogger.snapshot;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class c {
    private final String aUo;
    private final LinkedList<d> aUp;
    private int aUq;
    private final int aUr;
    private long aUs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str) {
        this(str, 10);
    }

    public final synchronized long Or() {
        return this.aUs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.aUo.equals(((c) obj).aUo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String getName() {
        return this.aUo;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.aUo});
    }

    public synchronized d hn(String str) {
        d dVar;
        if (this.aUp.size() >= this.aUr) {
            this.aUp.removeFirst();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_");
        int i4 = this.aUq;
        this.aUq = i4 + 1;
        sb.append(i4);
        dVar = new d(sb.toString());
        this.aUp.addLast(dVar);
        this.aUs = System.currentTimeMillis();
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized JSONObject ho(String str) {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<d> it = this.aUp.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().Oq());
            }
            jSONObject.put("session_id", str);
            jSONObject.put("segment_name", this.aUo);
            jSONObject.put("spans", jSONArray);
            this.aUs = System.currentTimeMillis();
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, int i4) {
        this.aUo = str == null ? "" : str;
        this.aUp = new LinkedList<>();
        this.aUr = Math.min(i4, 30);
        this.aUs = System.currentTimeMillis();
    }
}
