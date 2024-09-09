package com.qq.e.comm.plugin.g0;

import com.qq.e.comm.plugin.util.d1;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e0 {

    /* renamed from: a  reason: collision with root package name */
    private String f43565a;

    private e0() {
    }

    public static List<e0> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                Object opt = jSONArray.opt(i4);
                if (opt instanceof JSONObject) {
                    e0 a4 = a((JSONObject) opt);
                    if (a4 != null) {
                        arrayList.add(a4);
                    }
                } else {
                    d1.a("Slot.parseList error !");
                }
            }
        }
        return arrayList;
    }

    public void a(long j4) {
    }

    public static e0 a(JSONObject jSONObject) {
        if (jSONObject != null) {
            e0 e0Var = new e0();
            e0Var.a(jSONObject.optString("url"));
            e0Var.a(jSONObject.optLong("reporttime"));
            return e0Var;
        }
        return null;
    }

    public String a() {
        return this.f43565a;
    }

    public void a(String str) {
        this.f43565a = str;
    }
}
