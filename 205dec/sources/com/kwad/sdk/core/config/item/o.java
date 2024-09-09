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
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class o extends b<a> {
    private String ats;

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class a implements com.kwad.sdk.core.b {
        @NonNull
        public Map<Integer, String> att = new HashMap();
        @NonNull
        public List<String> atu = new ArrayList();
        @NonNull
        public List<String> atv = new ArrayList();
        public List<String> atw = new ArrayList();
        public int atx;
        private JSONObject aty;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.aty = jSONObject;
            JSONObject optJSONObject = jSONObject.optJSONObject("platformInfo");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.att.put(Integer.valueOf(next), optJSONObject.optString(next));
                }
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("keyStacks");
            if (optJSONArray != null) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    this.atu.add(optJSONArray.optString(i4));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("extendClassNames");
            if (optJSONArray2 != null) {
                for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                    this.atv.add(optJSONArray2.optString(i5));
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("keyNames");
            if (optJSONArray3 != null) {
                for (int i6 = 0; i6 < optJSONArray3.length(); i6++) {
                    this.atw.add(optJSONArray3.optString(i6));
                }
            }
            this.atx = jSONObject.optInt("handleType");
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            return this.aty;
        }
    }

    public o() {
        super("sdkPackInfo", null);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        String dl = b.dl(sharedPreferences.getString("sdkPackInfo", null));
        this.ats = dl;
        try {
            if (TextUtils.isEmpty(dl)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(this.ats);
            a aVar = new a();
            aVar.parseJson(jSONObject);
            setValue(aVar);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        editor.putString("sdkPackInfo", b.dk(this.ats));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("sdkPackInfo");
        if (optJSONObject == null) {
            return;
        }
        this.ats = optJSONObject.toString();
        a aVar = new a();
        aVar.parseJson(optJSONObject);
        setValue(aVar);
    }
}
