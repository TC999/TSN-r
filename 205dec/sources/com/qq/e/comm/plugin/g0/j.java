package com.qq.e.comm.plugin.g0;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    String f43587a;

    /* renamed from: b  reason: collision with root package name */
    String f43588b;

    public j(JSONObject jSONObject) {
        k.a(this, jSONObject);
    }

    public String a() {
        return this.f43587a;
    }

    public String b() {
        return this.f43588b;
    }

    public static List<j> a(JSONObject jSONObject) {
        int length;
        JSONArray optJSONArray = jSONObject.optJSONArray("materials");
        if (optJSONArray == null || (length = optJSONArray.length()) <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i4 = 0; i4 < length; i4++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
            if (!JSONObject.NULL.equals(optJSONObject)) {
                arrayList.add(new j(optJSONObject));
            }
        }
        return arrayList;
    }
}
