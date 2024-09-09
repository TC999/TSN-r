package com.kwad.sdk.h;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class e implements com.kwad.sdk.h.b {
    public int aKi;
    public b aKj;
    public a aKk;
    public double apu;

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class a implements com.kwad.sdk.h.b {
        public List<String> aKl;
        public List<String> aKm;
        public List<String> aKn;

        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.aKl = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("levelList");
            if (optJSONArray != null) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    this.aKl.add(optJSONArray.optString(i4));
                }
            }
            this.aKm = new ArrayList();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("tagList");
            if (optJSONArray2 != null) {
                for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                    this.aKm.add(optJSONArray2.optString(i5));
                }
            }
            this.aKn = new ArrayList();
            JSONArray optJSONArray3 = jSONObject.optJSONArray("keywordList");
            if (optJSONArray3 != null) {
                for (int i6 = 0; i6 < optJSONArray3.length(); i6++) {
                    this.aKn.add(optJSONArray3.optString(i6));
                }
            }
        }

        @Override // com.kwad.sdk.h.b
        public final JSONObject toJson() {
            return null;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class b implements com.kwad.sdk.h.b {
        public static int OK = 1;
        public static int aKo = -1;
        public static int aKp;
        public List<String> aGm;
        public List<String> aGn;
        public List<String> aKq;
        public int aKr = aKo;

        public final boolean JH() {
            return this.aKr == OK;
        }

        public final void bD(boolean z3) {
            this.aKr = z3 ? OK : aKp;
        }

        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.aGm = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("appIdList");
            if (optJSONArray != null) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    this.aGm.add(optJSONArray.optString(i4));
                }
            }
            this.aGn = new ArrayList();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("sdkVersionList");
            if (optJSONArray2 != null) {
                for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                    this.aGn.add(optJSONArray2.optString(i5));
                }
            }
            this.aKq = new ArrayList();
            JSONArray optJSONArray3 = jSONObject.optJSONArray("deviceIdList");
            if (optJSONArray3 != null) {
                for (int i6 = 0; i6 < optJSONArray3.length(); i6++) {
                    this.aKq.add(optJSONArray3.optString(i6));
                }
            }
        }

        @Override // com.kwad.sdk.h.b
        public final JSONObject toJson() {
            return null;
        }
    }

    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.apu = jSONObject.optDouble("ratio");
        this.aKi = jSONObject.optInt("kcType", 1);
        b bVar = new b();
        this.aKj = bVar;
        bVar.parseJson(jSONObject.optJSONObject("scopeConfig"));
        a aVar = new a();
        this.aKk = aVar;
        aVar.parseJson(jSONObject.optJSONObject("logConfig"));
    }

    @Override // com.kwad.sdk.h.b
    public final JSONObject toJson() {
        return null;
    }
}
