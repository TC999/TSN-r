package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class n extends b<String> {
    private static volatile String[] atr;

    public n(String str, String str2) {
        super(str, str2);
        atr = null;
    }

    public static boolean W(long j4) {
        String[] strArr;
        if (atr == null) {
            return false;
        }
        for (String str : atr) {
            if (str != null && String.valueOf(j4).equals(str.trim())) {
                return true;
            }
        }
        return false;
    }

    private static void dm(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        atr = str.split(",");
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString(getKey(), CH());
        setValue(string);
        dm(string);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        editor.putString(getKey(), getValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString(getKey(), CH());
            setValue(optString);
            dm(optString);
            return;
        }
        setValue(CH());
    }
}
