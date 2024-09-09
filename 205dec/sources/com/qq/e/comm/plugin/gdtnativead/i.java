package com.qq.e.comm.plugin.gdtnativead;

import android.content.Context;
import android.util.Pair;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.plugin.gdtnativead.a;
import com.qq.e.comm.plugin.rewardvideo.e;
import com.qq.e.comm.plugin.util.d1;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class i extends a {

    /* renamed from: l  reason: collision with root package name */
    private static final String f43817l = "i";

    public i(g gVar, Context context, String str, String str2, String str3, com.qq.e.comm.plugin.b.g gVar2, com.qq.e.comm.plugin.b.l lVar, ADSize aDSize, boolean z3, com.qq.e.comm.plugin.n0.c cVar) {
        super(context, str, str2, str3, gVar2, lVar, aDSize, z3, cVar);
        a(gVar);
        d1.a(f43817l, "NativeExpressADParserImpl");
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.a
    public void a(JSONObject jSONObject, a.b bVar, boolean z3) {
        Object obj;
        Object obj2;
        Pair<Object, Object> a4 = a(jSONObject, z3);
        if (a4 != null && (obj = a4.first) != null && (obj2 = a4.second) != null) {
            if (obj instanceof Integer) {
                if (a(bVar)) {
                    bVar.a(((Integer) a4.second).intValue(), ((Integer) a4.first).intValue(), false);
                    return;
                }
                return;
            }
            List<com.qq.e.comm.plugin.g0.e> list = (List) obj2;
            Pair<List<NativeExpressADView>, List<JSONObject>> a5 = a((JSONObject) obj, list);
            List<NativeExpressADView> list2 = (List) a5.first;
            if (list2 != null && list2.size() > 0) {
                this.f43749a.f43794x = System.currentTimeMillis();
                if (a(list.get(0), bVar) || bVar == null) {
                    return;
                }
                bVar.a(this.f43757i, null, list, list2, (List) a5.second);
                return;
            }
            if (a(bVar)) {
                bVar.a(5011, 5004, false);
            }
            com.qq.e.comm.plugin.l0.e.a(5011, this.f43758j, list.size());
        } else if (a(bVar)) {
            bVar.a(6000, 6000, false);
        }
    }

    public Pair<Object, Object> a(JSONObject jSONObject, boolean z3) {
        return a(jSONObject, null, null, z3);
    }

    public Pair<Object, Object> a(JSONObject jSONObject, String str, e.a aVar, boolean z3) {
        int length;
        int size;
        List a4;
        int optInt = jSONObject.optInt("ret");
        if (optInt != 0) {
            com.qq.e.comm.plugin.l0.e.a(this.f43758j, optInt, z3);
            return new Pair<>(Integer.valueOf(optInt), Integer.valueOf(optInt));
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null) {
            com.qq.e.comm.plugin.l0.e.a(this.f43758j, 5004, z3);
            return new Pair<>(5004, 5004);
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(this.f43752d);
        if (optJSONObject2 == null) {
            com.qq.e.comm.plugin.l0.e.a(this.f43758j, 5004, z3);
            return new Pair<>(5004, 5004);
        }
        int optInt2 = optJSONObject2.optInt("ret");
        if (optInt2 != 0) {
            com.qq.e.comm.plugin.l0.e.a(this.f43758j, optInt2, z3);
            return new Pair<>(Integer.valueOf(optInt2), Integer.valueOf(optInt2));
        }
        JSONArray optJSONArray = optJSONObject2.optJSONArray("list");
        if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
            com.qq.e.comm.plugin.l0.e.a(this.f43758j, length);
            boolean[] zArr = new boolean[length];
            com.qq.e.comm.plugin.b.g gVar = this.f43754f;
            List<JSONObject> list = null;
            if ((gVar == com.qq.e.comm.plugin.b.g.UNIFIED_BANNER || gVar == com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL || gVar == com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD) && d.c()) {
                list = com.qq.e.comm.plugin.util.c.a(optJSONArray, new com.qq.e.comm.plugin.b.m(this.f43752d, this.f43754f, (com.qq.e.comm.plugin.b.f) null), zArr, (com.qq.e.comm.plugin.b.d) null);
                size = list.size();
            } else {
                size = length;
            }
            List<JSONObject> list2 = list;
            if (size <= 0) {
                com.qq.e.comm.plugin.l0.e.a(5014, this.f43758j, length);
                return new Pair<>(5004, 5014);
            }
            if (list2 == null) {
                a4 = com.qq.e.comm.plugin.rewardvideo.e.a(this.f43751c, this.f43752d, this.f43753e, str, this.f43754f, this.f43755g, optJSONArray, aVar);
            } else {
                a4 = com.qq.e.comm.plugin.rewardvideo.e.a(this.f43751c, this.f43752d, this.f43753e, str, this.f43754f, this.f43755g, list2, aVar);
            }
            if (length > a4.size()) {
                JSONArray jSONArray = new JSONArray();
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("template");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                        if (!zArr[i4]) {
                            jSONArray.put(optJSONArray2.opt(i4));
                        }
                    }
                    try {
                        optJSONObject2.putOpt("template", jSONArray);
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                }
            }
            return new Pair<>(optJSONObject2, a4);
        }
        com.qq.e.comm.plugin.l0.e.a(this.f43758j, 5025, z3);
        return new Pair<>(5004, 5025);
    }

    public Pair<List<NativeExpressADView>, List<JSONObject>> a(JSONObject jSONObject, List<com.qq.e.comm.plugin.g0.e> list) {
        return a(jSONObject.optJSONArray("template"), list);
    }

    public Pair<List<NativeExpressADView>, List<JSONObject>> a(JSONArray jSONArray, List<com.qq.e.comm.plugin.g0.e> list) {
        boolean z3 = jSONArray != null;
        if (z3 && list.size() != jSONArray.length()) {
            z3 = false;
        }
        int min = this.f43754f != com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL ? Math.min(list.size(), this.f43749a.f43782l) : 1;
        ArrayList arrayList = new ArrayList(min);
        ArrayList arrayList2 = new ArrayList(min);
        for (int i4 = 0; i4 < min; i4++) {
            com.qq.e.comm.plugin.g0.e eVar = list.get(i4);
            JSONObject jSONObject = null;
            if (z3) {
                jSONObject = jSONArray.optJSONObject(i4);
            }
            arrayList.add(new n(this.f43749a, null, this.f43750b, this.f43756h, this.f43751c, this.f43752d, this.f43753e, jSONObject, a(eVar)));
            arrayList2.add(jSONObject);
        }
        return new Pair<>(arrayList, arrayList2);
    }
}
