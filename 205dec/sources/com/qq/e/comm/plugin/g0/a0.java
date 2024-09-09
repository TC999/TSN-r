package com.qq.e.comm.plugin.g0;

import com.qq.e.comm.plugin.util.d1;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a0 {
    public static List<Integer> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                Object opt = jSONArray.opt(i4);
                if (opt instanceof Integer) {
                    arrayList.add((Integer) opt);
                } else {
                    d1.a("parseIntegerList error ! type wrong !");
                }
            }
        }
        return arrayList;
    }

    public static List<String> b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                Object opt = jSONArray.opt(i4);
                if (opt instanceof String) {
                    arrayList.add((String) opt);
                } else {
                    d1.a("parseStringList error ! type wrong !");
                }
            }
        }
        return arrayList;
    }
}
