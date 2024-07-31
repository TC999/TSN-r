package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.config.item.l */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10266l extends AbstractC10254b<String> {
    private boolean atq;

    public C10266l(String str, String str2) {
        super(str, str2);
        this.atq = false;
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: a */
    public final void mo26480a(@NonNull SharedPreferences sharedPreferences) {
        if (this.atq) {
            setValue(sharedPreferences.getString(getKey(), m26495CH()));
        }
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: b */
    public final void mo26479b(@NonNull SharedPreferences.Editor editor) {
        if (this.atq) {
            editor.putString(getKey(), getValue());
        }
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: k */
    public final void mo26478k(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(getKey())) != null) {
            setValue(optJSONObject.toString());
        } else {
            setValue(m26495CH());
        }
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    @NonNull
    public final String getValue() {
        return (String) super.getValue();
    }

    public C10266l(String str, String str2, boolean z) {
        this(str, str2);
        this.atq = false;
    }
}
