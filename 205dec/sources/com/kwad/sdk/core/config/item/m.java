package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class m extends a<Long> {
    public m(String str) {
        this(str, 0L);
    }

    @Override // com.kwad.sdk.core.config.item.b
    @NonNull
    /* renamed from: CO */
    public final Long getValue() {
        return (Long) super.getValue();
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        setValue(Long.valueOf(sharedPreferences.getLong(getKey(), CH().longValue())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        editor.putLong(getKey(), getValue().longValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        if (jSONObject != null) {
            setValue(Long.valueOf(jSONObject.optLong(getKey(), CH().longValue())));
        } else {
            setValue(CH());
        }
    }

    public m(String str, Long l4) {
        super(str, l4);
    }
}
