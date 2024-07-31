package com.kwad.sdk.crash.model.message;

import android.text.TextUtils;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.C10670d;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.crash.model.message.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10693a {
    private JSONObject aGq = new JSONObject();

    private void put(String str, Object obj) {
        try {
            this.aGq.put(str, obj);
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
        }
    }

    /* renamed from: a */
    public final void m25105a(String str, JSONObject jSONObject) {
        put(str, jSONObject);
    }

    /* renamed from: fq */
    public final void m25104fq(String str) {
        put(C10670d.aFJ, str);
    }

    public final void putInt(String str, int i) {
        put(str, Integer.valueOf(i));
    }

    public final void putString(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && str2.length() <= 100) {
            put(str, str2);
        } else {
            C10331c.m26254d("AdExceptionCollector", "string value to long ,max is 100");
        }
    }

    public final String toString() {
        return this.aGq.toString();
    }
}
