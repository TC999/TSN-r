package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class l extends b<String> {
    private boolean atq;

    public l(String str, String str2) {
        super(str, str2);
        this.atq = false;
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        if (this.atq) {
            setValue(sharedPreferences.getString(getKey(), CH()));
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        if (this.atq) {
            editor.putString(getKey(), getValue());
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(getKey())) != null) {
            setValue(optJSONObject.toString());
        } else {
            setValue(CH());
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    @NonNull
    public final String getValue() {
        return (String) super.getValue();
    }

    public l(String str, String str2, boolean z3) {
        this(str, str2);
        this.atq = false;
    }
}
