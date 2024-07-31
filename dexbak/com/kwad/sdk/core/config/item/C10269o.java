package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC9914b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.config.item.o */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10269o extends AbstractC10254b<C10270a> {
    private String ats;

    /* renamed from: com.kwad.sdk.core.config.item.o$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C10270a implements InterfaceC9914b {
        @NonNull
        public Map<Integer, String> att = new HashMap();
        @NonNull
        public List<String> atu = new ArrayList();
        @NonNull
        public List<String> atv = new ArrayList();
        public List<String> atw = new ArrayList();
        public int atx;
        private JSONObject aty;

        @Override // com.kwad.sdk.core.InterfaceC9914b
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
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.atu.add(optJSONArray.optString(i));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("extendClassNames");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.atv.add(optJSONArray2.optString(i2));
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("keyNames");
            if (optJSONArray3 != null) {
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    this.atw.add(optJSONArray3.optString(i3));
                }
            }
            this.atx = jSONObject.optInt("handleType");
        }

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public final JSONObject toJson() {
            return this.aty;
        }
    }

    public C10269o() {
        super("sdkPackInfo", null);
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: a */
    public final void mo26480a(SharedPreferences sharedPreferences) {
        String m26493dl = AbstractC10254b.m26493dl(sharedPreferences.getString("sdkPackInfo", null));
        this.ats = m26493dl;
        try {
            if (TextUtils.isEmpty(m26493dl)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(this.ats);
            C10270a c10270a = new C10270a();
            c10270a.parseJson(jSONObject);
            setValue(c10270a);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: b */
    public final void mo26479b(SharedPreferences.Editor editor) {
        editor.putString("sdkPackInfo", AbstractC10254b.m26494dk(this.ats));
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: k */
    public final void mo26478k(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("sdkPackInfo");
        if (optJSONObject == null) {
            return;
        }
        this.ats = optJSONObject.toString();
        C10270a c10270a = new C10270a();
        c10270a.parseJson(optJSONObject);
        setValue(c10270a);
    }
}
