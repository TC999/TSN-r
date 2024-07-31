package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.config.item.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10257e extends AbstractC10254b<JSONObject> {
    public C10257e() {
        super(m26489CJ(), new JSONObject());
    }

    /* renamed from: CJ */
    private static String m26489CJ() {
        return "commercialLogRatioConfig";
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: a */
    public final void mo26480a(SharedPreferences sharedPreferences) {
        JSONObject value = getValue();
        if (value == null) {
            value = new JSONObject();
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(sharedPreferences.getString(getKey(), ""));
        } catch (Throwable unused) {
        }
        if (jSONObject != null) {
            value = jSONObject;
        }
        setValue(value);
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: b */
    public final void mo26479b(SharedPreferences.Editor editor) {
        if (getValue() != null) {
            editor.putString(getKey(), getValue().toString());
        } else {
            editor.putString(getKey(), "");
        }
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: k */
    public final void mo26478k(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(getKey())) != null) {
            setValue(optJSONObject);
        } else {
            setValue(m26495CH());
        }
    }
}
