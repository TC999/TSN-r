package com.qq.e.comm.plugin.rewardvideo;

import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.plugin.g0.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface a<T extends com.qq.e.comm.plugin.g0.e> {
        T a(String str, String str2, String str3, String str4, com.qq.e.comm.plugin.b.g gVar, JSONObject jSONObject, com.qq.e.comm.plugin.b.l lVar);
    }

    public static <T extends com.qq.e.comm.plugin.g0.e> Pair<Integer, List<T>> a(List<T> list, com.qq.e.comm.plugin.n0.c cVar, boolean z3) {
        int size;
        if (list != null && (size = list.size()) != 0) {
            Iterator<T> it = list.iterator();
            int i4 = 0;
            while (it.hasNext()) {
                T next = it.next();
                if (TextUtils.isEmpty(next.k())) {
                    it.remove();
                    i4 = 5038;
                } else if (!TextUtils.isEmpty(next.L0())) {
                    int R0 = next.R0();
                    int N0 = next.N0();
                    int M0 = next.M0();
                    int a4 = com.qq.e.comm.plugin.t.c.a("rewardVideoServerMaxDuration", next.q0(), 301);
                    if (R0 <= 0 || N0 <= 0 || M0 <= 0 || (a4 > 0 && M0 >= a4)) {
                        it.remove();
                        i4 = 5040;
                    }
                } else if (!(next instanceof u) || TextUtils.isEmpty(((u) next).a())) {
                    if (z3) {
                        it.remove();
                        i4 = 5020;
                    }
                }
            }
            if (list.size() > 0) {
                return new Pair<>(0, list);
            }
            if (size == 1) {
                return new Pair<>(Integer.valueOf(i4), null);
            }
            return new Pair<>(5039, null);
        }
        return new Pair<>(5025, null);
    }

    public static <T extends com.qq.e.comm.plugin.g0.e> List<T> a(String str, String str2, String str3, String str4, com.qq.e.comm.plugin.b.g gVar, com.qq.e.comm.plugin.b.l lVar, JSONArray jSONArray, a<T> aVar) {
        T a4;
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        String str5 = str4;
        for (int i4 = 0; i4 < length; i4++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i4);
                if (TextUtils.isEmpty(str5)) {
                    str5 = com.qq.e.comm.plugin.util.b.a(str, str2);
                }
                if (aVar == null) {
                    a4 = (T) new com.qq.e.comm.plugin.g0.e(str, str2, str3, str5, gVar, jSONObject, lVar);
                } else {
                    a4 = aVar.a(str, str2, str3, str5, gVar, jSONObject, lVar);
                }
                arrayList.add(a4);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        return arrayList;
    }

    public static <T extends com.qq.e.comm.plugin.g0.e> List<T> a(String str, String str2, String str3, String str4, com.qq.e.comm.plugin.b.g gVar, com.qq.e.comm.plugin.b.l lVar, List<JSONObject> list, a<T> aVar) {
        ArrayList arrayList = new ArrayList(list.size());
        for (JSONObject jSONObject : list) {
            arrayList.add(a(str, str2, str3, str4, gVar, lVar, jSONObject, aVar));
        }
        return arrayList;
    }

    public static <T extends com.qq.e.comm.plugin.g0.e> T a(String str, String str2, String str3, String str4, com.qq.e.comm.plugin.b.g gVar, com.qq.e.comm.plugin.b.l lVar, JSONObject jSONObject, a<T> aVar) {
        if (TextUtils.isEmpty(str4)) {
            str4 = com.qq.e.comm.plugin.util.b.a(str, str2);
        }
        String str5 = str4;
        if (aVar == null) {
            return (T) new com.qq.e.comm.plugin.g0.e(str, str2, str3, str5, gVar, jSONObject, lVar);
        }
        return aVar.a(str, str2, str3, str5, gVar, jSONObject, lVar);
    }
}
