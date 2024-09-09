package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d extends a<Boolean> {
    public d(String str, boolean z3) {
        super(str, Boolean.valueOf(z3));
    }

    @Override // com.kwad.sdk.core.config.item.b
    @NonNull
    /* renamed from: CI */
    public final Boolean getValue() {
        return (Boolean) super.getValue();
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        setValue(Boolean.valueOf(sharedPreferences.getBoolean(getKey(), CH().booleanValue())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        editor.putBoolean(getKey(), getValue().booleanValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        if (jSONObject != null) {
            setValue(Boolean.valueOf(jSONObject.optBoolean(getKey(), CH().booleanValue())));
        } else {
            setValue(CH());
        }
    }
}
