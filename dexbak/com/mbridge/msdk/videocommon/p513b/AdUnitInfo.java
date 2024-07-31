package com.mbridge.msdk.videocommon.p513b;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.videocommon.b.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class AdUnitInfo {

    /* renamed from: a */
    private int f32192a;

    /* renamed from: b */
    private int f32193b;

    /* renamed from: c */
    private AdParams f32194c;

    public AdUnitInfo(int i, int i2, AdParams adParams) {
        this.f32192a = i;
        this.f32193b = i2;
        this.f32194c = adParams;
    }

    /* renamed from: a */
    public final int m20878a() {
        return this.f32192a;
    }

    /* renamed from: b */
    public final int m20876b() {
        return this.f32193b;
    }

    /* renamed from: a */
    public static List<AdUnitInfo> m20877a(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    int optInt = optJSONObject.optInt("id");
                    int optInt2 = optJSONObject.optInt("timeout");
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("params");
                    arrayList.add(new AdUnitInfo(optInt, optInt2, optJSONObject2 != null ? AdParams.m20879a(optJSONObject2) : null));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        }
        return null;
    }
}
