package com.kwad.sdk.crash.model.message;

import android.text.TextUtils;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.crash.d;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private JSONObject aGq = new JSONObject();

    private void put(String str, Object obj) {
        try {
            this.aGq.put(str, obj);
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
        }
    }

    public final void a(String str, JSONObject jSONObject) {
        put(str, jSONObject);
    }

    public final void fq(String str) {
        put(d.aFJ, str);
    }

    public final void putInt(String str, int i4) {
        put(str, Integer.valueOf(i4));
    }

    public final void putString(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && str2.length() <= 100) {
            put(str, str2);
        } else {
            c.d("AdExceptionCollector", "string value to long ,max is 100");
        }
    }

    public final String toString() {
        return this.aGq.toString();
    }
}
