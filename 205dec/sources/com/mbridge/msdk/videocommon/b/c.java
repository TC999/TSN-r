package com.mbridge.msdk.videocommon.b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Cbprule.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private int f40943a;

    /* renamed from: b  reason: collision with root package name */
    private List<Integer> f40944b;

    private c(int i4, List<Integer> list) {
        this.f40943a = i4;
        this.f40944b = list;
    }

    public final int a() {
        return this.f40943a;
    }

    public final List<Integer> b() {
        return this.f40944b;
    }

    public static c a(JSONObject jSONObject) {
        c cVar = new c(1, Arrays.asList(1, 2, 3, 4));
        if (jSONObject == null) {
            return cVar;
        }
        try {
            int optInt = jSONObject.optInt("type");
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("value");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    arrayList.add(Integer.valueOf(optJSONArray.optInt(i4)));
                }
            }
            return new c(optInt, arrayList);
        } catch (Exception e4) {
            e4.printStackTrace();
            return cVar;
        }
    }
}
