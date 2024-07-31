package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.p408a.C10482a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.config.item.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10263j extends AbstractC10254b<C10264a> {

    @KsJson
    /* renamed from: com.kwad.sdk.core.config.item.j$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10264a extends C10482a {
        public int ato = 180000;
        public int atp = 90000;
    }

    public C10263j(String str) {
        super(str, new C10264a());
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: a */
    public final void mo26480a(SharedPreferences sharedPreferences) {
        C10264a value = getValue();
        if (value == null) {
            value = new C10264a();
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(sharedPreferences.getString(getKey(), ""));
        } catch (JSONException e) {
            C10331c.printStackTraceOnly(e);
        }
        if (jSONObject != null) {
            value.parseJson(jSONObject);
        }
        setValue(value);
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: b */
    public final void mo26479b(SharedPreferences.Editor editor) {
        if (getValue() != null && getValue().toJson() != null) {
            editor.putString(getKey(), getValue().toJson().toString());
        } else {
            editor.putString(getKey(), "");
        }
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: k */
    public final void mo26478k(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(getKey())) != null) {
            C10264a c10264a = new C10264a();
            c10264a.parseJson(optJSONObject);
            setValue(c10264a);
            return;
        }
        setValue(m26495CH());
    }
}
