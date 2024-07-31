package com.kwai.adclient.kscommerciallogger.snapshot;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwai.adclient.kscommerciallogger.snapshot.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C11169c {
    private final String aUo;
    private final LinkedList<C11170d> aUp;
    private int aUq;
    private final int aUr;
    private long aUs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C11169c(String str) {
        this(str, 10);
    }

    /* renamed from: Or */
    public final synchronized long m23490Or() {
        return this.aUs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.aUo.equals(((C11169c) obj).aUo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String getName() {
        return this.aUo;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.aUo});
    }

    /* renamed from: hn */
    public synchronized C11170d mo23489hn(String str) {
        C11170d c11170d;
        if (this.aUp.size() >= this.aUr) {
            this.aUp.removeFirst();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_");
        int i = this.aUq;
        this.aUq = i + 1;
        sb.append(i);
        c11170d = new C11170d(sb.toString());
        this.aUp.addLast(c11170d);
        this.aUs = System.currentTimeMillis();
        return c11170d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ho */
    public synchronized JSONObject mo23488ho(String str) {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<C11170d> it = this.aUp.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().mo23487Oq());
            }
            jSONObject.put("session_id", str);
            jSONObject.put("segment_name", this.aUo);
            jSONObject.put("spans", jSONArray);
            this.aUs = System.currentTimeMillis();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C11169c(String str, int i) {
        this.aUo = str == null ? "" : str;
        this.aUp = new LinkedList<>();
        this.aUr = Math.min(i, 30);
        this.aUs = System.currentTimeMillis();
    }
}
