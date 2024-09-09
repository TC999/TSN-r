package com.kwad.sdk.i;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e implements com.kwad.sdk.i.b {
    public int aIT;
    public b aIU;
    public a aIV;
    public double aor;

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a implements com.kwad.sdk.i.b {
        public List<String> aIW;
        public List<String> aIX;
        public List<String> aIY;

        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.aIW = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("levelList");
            if (optJSONArray != null) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    this.aIW.add(optJSONArray.optString(i4));
                }
            }
            this.aIX = new ArrayList();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("tagList");
            if (optJSONArray2 != null) {
                for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                    this.aIX.add(optJSONArray2.optString(i5));
                }
            }
            this.aIY = new ArrayList();
            JSONArray optJSONArray3 = jSONObject.optJSONArray("keywordList");
            if (optJSONArray3 != null) {
                for (int i6 = 0; i6 < optJSONArray3.length(); i6++) {
                    this.aIY.add(optJSONArray3.optString(i6));
                }
            }
        }

        @Override // com.kwad.sdk.i.b
        public final JSONObject toJson() {
            return null;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class b implements com.kwad.sdk.i.b {
        public static int OK = 1;
        public static int aIZ = -1;
        public static int aJa;
        public List<String> aEY;
        public List<String> aEZ;
        public List<String> aJb;
        public int aJc = aIZ;

        public final boolean IW() {
            return this.aJc == OK;
        }

        public final void bD(boolean z3) {
            this.aJc = z3 ? OK : aJa;
        }

        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.aEY = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("appIdList");
            if (optJSONArray != null) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    this.aEY.add(optJSONArray.optString(i4));
                }
            }
            this.aEZ = new ArrayList();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("sdkVersionList");
            if (optJSONArray2 != null) {
                for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                    this.aEZ.add(optJSONArray2.optString(i5));
                }
            }
            this.aJb = new ArrayList();
            JSONArray optJSONArray3 = jSONObject.optJSONArray("deviceIdList");
            if (optJSONArray3 != null) {
                for (int i6 = 0; i6 < optJSONArray3.length(); i6++) {
                    this.aJb.add(optJSONArray3.optString(i6));
                }
            }
        }

        @Override // com.kwad.sdk.i.b
        public final JSONObject toJson() {
            return null;
        }
    }

    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.aor = jSONObject.optDouble("ratio");
        this.aIT = jSONObject.optInt("kcType", 1);
        b bVar = new b();
        this.aIU = bVar;
        bVar.parseJson(jSONObject.optJSONObject("scopeConfig"));
        a aVar = new a();
        this.aIV = aVar;
        aVar.parseJson(jSONObject.optJSONObject("logConfig"));
    }

    @Override // com.kwad.sdk.i.b
    public final JSONObject toJson() {
        return null;
    }
}
