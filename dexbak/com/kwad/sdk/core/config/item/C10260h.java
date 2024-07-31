package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.p408a.C10482a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.config.item.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10260h extends AbstractC10254b<C10261a> {

    @KsJson
    /* renamed from: com.kwad.sdk.core.config.item.h$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C10261a extends C10482a {
        public String atm = "";
        public String atn = "";
    }

    public C10260h() {
        super("idMapping", new C10261a());
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: a */
    public final void mo26480a(SharedPreferences sharedPreferences) {
        C10261a value = getValue();
        if (value == null) {
            value = new C10261a();
        }
        String string = sharedPreferences.getString(getKey(), "");
        if (!TextUtils.isEmpty(string)) {
            try {
                value.parseJson(new JSONObject(AbstractC10254b.m26493dl(string)));
            } catch (JSONException e) {
                C10331c.printStackTraceOnly(e);
            }
        }
        setValue(value);
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: b */
    public final void mo26479b(SharedPreferences.Editor editor) {
        if (getValue() != null && getValue().toJson() != null) {
            editor.putString(getKey(), AbstractC10254b.m26494dk(getValue().toJson().toString()));
            return;
        }
        editor.putString(getKey(), "");
    }

    public final String getImei() {
        C10261a value = getValue();
        return (value == null || TextUtils.isEmpty(value.atm)) ? "" : value.atm;
    }

    public final String getOaid() {
        C10261a value = getValue();
        return (value == null || TextUtils.isEmpty(value.atn)) ? "" : value.atn;
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: k */
    public final void mo26478k(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(getKey());
        if (optJSONObject == null) {
            return;
        }
        C10261a c10261a = new C10261a();
        c10261a.parseJson(optJSONObject);
        setValue(c10261a);
    }
}
