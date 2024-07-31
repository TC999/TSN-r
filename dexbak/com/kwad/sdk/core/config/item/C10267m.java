package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.config.item.m */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10267m extends AbstractC10253a<Long> {
    public C10267m(String str) {
        this(str, 0L);
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    @NonNull
    /* renamed from: CO */
    public final Long getValue() {
        return (Long) super.getValue();
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: a */
    public final void mo26480a(@NonNull SharedPreferences sharedPreferences) {
        setValue(Long.valueOf(sharedPreferences.getLong(getKey(), m26495CH().longValue())));
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: b */
    public final void mo26479b(@NonNull SharedPreferences.Editor editor) {
        editor.putLong(getKey(), getValue().longValue());
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: k */
    public final void mo26478k(JSONObject jSONObject) {
        if (jSONObject != null) {
            setValue(Long.valueOf(jSONObject.optLong(getKey(), m26495CH().longValue())));
        } else {
            setValue(m26495CH());
        }
    }

    public C10267m(String str, Long l) {
        super(str, l);
    }
}
