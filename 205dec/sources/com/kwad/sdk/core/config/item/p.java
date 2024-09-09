package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class p extends com.kwad.sdk.core.config.item.a<String> {

    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public static final class a implements com.kwad.sdk.core.b {
        @NonNull
        public Map<Integer, String> auF = new HashMap();
        @NonNull
        public List<String> auG = new ArrayList();
        @NonNull
        public List<String> auH = new ArrayList();
        public List<String> auI = new ArrayList();
        public int auJ;
        private JSONObject auK;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.auK = jSONObject;
            JSONObject optJSONObject = jSONObject.optJSONObject("platformInfo");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.auF.put(Integer.valueOf(next), optJSONObject.optString(next));
                }
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("keyStacks");
            if (optJSONArray != null) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    this.auG.add(optJSONArray.optString(i4));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("extendClassNames");
            if (optJSONArray2 != null) {
                for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                    this.auH.add(optJSONArray2.optString(i5));
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("keyNames");
            if (optJSONArray3 != null) {
                for (int i6 = 0; i6 < optJSONArray3.length(); i6++) {
                    this.auI.add(optJSONArray3.optString(i6));
                }
            }
            this.auJ = jSONObject.optInt("handleType");
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            return this.auK;
        }
    }

    public p(String str, String str2) {
        super(str, str2);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        setValue(b.dl(sharedPreferences.getString(getKey(), CH())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        editor.putString(getKey(), b.dk(getValue()));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        String optString = jSONObject != null ? jSONObject.optString(getKey(), CH()) : null;
        if (TextUtils.isEmpty(optString)) {
            setValue(CH());
        } else {
            setValue(optString);
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    @NonNull
    public final String getValue() {
        return (String) super.getValue();
    }
}
