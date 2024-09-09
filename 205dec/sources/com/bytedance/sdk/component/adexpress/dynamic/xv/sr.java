package com.bytedance.sdk.component.adexpress.dynamic.xv;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    public List<c> f29377c;
    public String sr;

    /* renamed from: w  reason: collision with root package name */
    public String f29378w;
    public String xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        public int f29379c;

        /* renamed from: w  reason: collision with root package name */
        public JSONObject f29380w;
    }

    public static sr c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        sr srVar = new sr();
        String optString = jSONObject.optString("custom_components");
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(optString);
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                if (optJSONObject != null) {
                    c cVar = new c();
                    cVar.f29379c = optJSONObject.optInt("id");
                    cVar.f29380w = new JSONObject(optJSONObject.optString("componentLayout"));
                    arrayList.add(cVar);
                }
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        srVar.f29377c = arrayList;
        srVar.f29378w = jSONObject.optString("diff_data");
        srVar.xv = jSONObject.optString("style_diff");
        srVar.sr = jSONObject.optString("tag_diff");
        return srVar;
    }
}
