package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import com.kwad.sdk.core.network.idc.p407a.C10432b;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.config.item.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10262i extends AbstractC10254b<C10432b> {
    public C10262i() {
        super("idc", new C10432b());
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: a */
    public final void mo26480a(SharedPreferences sharedPreferences) {
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: b */
    public final void mo26479b(SharedPreferences.Editor editor) {
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: k */
    public final void mo26478k(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(getKey())) != null) {
            C10432b c10432b = new C10432b();
            c10432b.parseJson(optJSONObject);
            setValue(c10432b);
            return;
        }
        setValue(m26495CH());
    }
}
