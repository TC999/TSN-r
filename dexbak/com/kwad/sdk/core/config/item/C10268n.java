package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.config.item.n */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10268n extends AbstractC10254b<String> {
    private static volatile String[] atr;

    public C10268n(String str, String str2) {
        super(str, str2);
        atr = null;
    }

    /* renamed from: W */
    public static boolean m26483W(long j) {
        String[] strArr;
        if (atr == null) {
            return false;
        }
        for (String str : atr) {
            if (str != null && String.valueOf(j).equals(str.trim())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: dm */
    private static void m26482dm(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        atr = str.split(",");
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: a */
    public final void mo26480a(@NonNull SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString(getKey(), m26495CH());
        setValue(string);
        m26482dm(string);
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: b */
    public final void mo26479b(@NonNull SharedPreferences.Editor editor) {
        editor.putString(getKey(), getValue());
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: k */
    public final void mo26478k(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString(getKey(), m26495CH());
            setValue(optString);
            m26482dm(optString);
            return;
        }
        setValue(m26495CH());
    }
}
