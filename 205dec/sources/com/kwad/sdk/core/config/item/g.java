package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class g extends a<Float> {
    public g(String str, float f4) {
        super(str, Float.valueOf(f4));
    }

    @Override // com.kwad.sdk.core.config.item.b
    @NonNull
    /* renamed from: CL */
    public final Float getValue() {
        return (Float) super.getValue();
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        setValue(Float.valueOf(sharedPreferences.getFloat(getKey(), CH().floatValue())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        editor.putFloat(getKey(), getValue().floatValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        if (jSONObject != null) {
            setValue(Float.valueOf((float) jSONObject.optDouble(getKey(), CH().floatValue())));
        } else {
            setValue(CH());
        }
    }
}
