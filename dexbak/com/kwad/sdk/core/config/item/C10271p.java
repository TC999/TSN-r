package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.config.item.p */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10271p extends AbstractC10253a<String> {
    public C10271p(String str, String str2) {
        super(str, str2);
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: a */
    public final void mo26480a(@NonNull SharedPreferences sharedPreferences) {
        setValue(AbstractC10254b.m26493dl(sharedPreferences.getString(getKey(), m26495CH())));
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: b */
    public final void mo26479b(@NonNull SharedPreferences.Editor editor) {
        editor.putString(getKey(), AbstractC10254b.m26494dk(getValue()));
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: k */
    public final void mo26478k(JSONObject jSONObject) {
        String optString = jSONObject != null ? jSONObject.optString(getKey(), m26495CH()) : null;
        if (TextUtils.isEmpty(optString)) {
            setValue(m26495CH());
        } else {
            setValue(optString);
        }
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    @NonNull
    public final String getValue() {
        return (String) super.getValue();
    }
}
