package com.kwad.sdk.p437i;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.kwad.sdk.i.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10791e implements InterfaceC10788b {
    public int aIT;
    public C10793b aIU;
    public C10792a aIV;
    public double aor;

    /* renamed from: com.kwad.sdk.i.e$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10792a implements InterfaceC10788b {
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
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aIW.add(optJSONArray.optString(i));
                }
            }
            this.aIX = new ArrayList();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("tagList");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.aIX.add(optJSONArray2.optString(i2));
                }
            }
            this.aIY = new ArrayList();
            JSONArray optJSONArray3 = jSONObject.optJSONArray("keywordList");
            if (optJSONArray3 != null) {
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    this.aIY.add(optJSONArray3.optString(i3));
                }
            }
        }

        @Override // com.kwad.sdk.p437i.InterfaceC10788b
        public final JSONObject toJson() {
            return null;
        }
    }

    /* renamed from: com.kwad.sdk.i.e$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10793b implements InterfaceC10788b {

        /* renamed from: OK */
        public static int f29659OK = 1;
        public static int aIZ = -1;
        public static int aJa;
        public List<String> aEY;
        public List<String> aEZ;
        public List<String> aJb;
        public int aJc = aIZ;

        /* renamed from: IW */
        public final boolean m24864IW() {
            return this.aJc == f29659OK;
        }

        /* renamed from: bD */
        public final void m24863bD(boolean z) {
            this.aJc = z ? f29659OK : aJa;
        }

        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.aEY = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("appIdList");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aEY.add(optJSONArray.optString(i));
                }
            }
            this.aEZ = new ArrayList();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("sdkVersionList");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.aEZ.add(optJSONArray2.optString(i2));
                }
            }
            this.aJb = new ArrayList();
            JSONArray optJSONArray3 = jSONObject.optJSONArray("deviceIdList");
            if (optJSONArray3 != null) {
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    this.aJb.add(optJSONArray3.optString(i3));
                }
            }
        }

        @Override // com.kwad.sdk.p437i.InterfaceC10788b
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
        C10793b c10793b = new C10793b();
        this.aIU = c10793b;
        c10793b.parseJson(jSONObject.optJSONObject("scopeConfig"));
        C10792a c10792a = new C10792a();
        this.aIV = c10792a;
        c10792a.parseJson(jSONObject.optJSONObject("logConfig"));
    }

    @Override // com.kwad.sdk.p437i.InterfaceC10788b
    public final JSONObject toJson() {
        return null;
    }
}
