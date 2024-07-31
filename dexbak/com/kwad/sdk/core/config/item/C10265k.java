package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.config.item.k */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10265k extends AbstractC10253a<Integer> {
    public C10265k(String str, Integer num) {
        super(str, num);
    }

    /* renamed from: CM */
    public final boolean m26486CM() {
        return getValue().intValue() == 1;
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    @NonNull
    /* renamed from: CN */
    public final Integer getValue() {
        return (Integer) super.getValue();
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: a */
    public final void mo26480a(@NonNull SharedPreferences sharedPreferences) {
        setValue(Integer.valueOf(sharedPreferences.getInt(getKey(), m26495CH().intValue())));
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: b */
    public final void mo26479b(@NonNull SharedPreferences.Editor editor) {
        editor.putInt(getKey(), getValue().intValue());
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: k */
    public final void mo26478k(JSONObject jSONObject) {
        if (jSONObject != null) {
            setValue(Integer.valueOf(jSONObject.optInt(getKey(), m26495CH().intValue())));
        } else {
            setValue(m26495CH());
        }
    }
}
