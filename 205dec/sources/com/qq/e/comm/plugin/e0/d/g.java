package com.qq.e.comm.plugin.e0.d;

import android.text.TextUtils;
import android.util.Pair;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.j0;
import com.qq.e.comm.util.GDTLogger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.advertisings.constants.ConstantAd;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Integer, Pair<JSONObject, String>> f42805a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final Map<String, Pair<String, String>> f42806b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, Integer> f42807c = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, com.qq.e.comm.plugin.e0.e.d dVar, String str, int i4) {
        if (obj != null && dVar != null) {
            String n4 = dVar.n();
            com.qq.e.comm.plugin.n0.d dVar2 = new com.qq.e.comm.plugin.n0.d();
            dVar2.a("mediation_id", dVar.n()).a("adnet_id", Integer.valueOf(dVar.a())).a("placement_id", dVar.p());
            dVar2.a("flow_group_id", Integer.valueOf(dVar.k()));
            dVar2.a("trace_id", str);
            dVar2.a(BidResponsed.KEY_PRICE, Integer.valueOf(dVar.q()));
            if (a(n4, dVar)) {
                dVar2.a("ecpm", -1);
                dVar2.a("bpg", Integer.valueOf(dVar.d()));
                dVar2.a("yecpm", Integer.valueOf(dVar.t()));
            } else {
                dVar2.a("ecpm", Integer.valueOf(dVar.f()));
            }
            dVar2.a(ConstantAd.KEY_CACHE_AD, dVar.s());
            dVar2.a("exp_group_id", Integer.valueOf(i4));
            dVar2.a("report_json", new j0(dVar.j()).a().optString("report_json"));
            f42805a.put(Integer.valueOf(obj.hashCode()), new Pair<>(dVar2.a(), n4));
            return;
        }
        d1.b("MSDK ReportUtil ", "recordEventExtra adapter = " + obj + ", config = " + obj);
    }

    public static Map<String, String> b(String str) {
        Pair<String, String> pair;
        d1.a("MSDK ReportUtil getMediationHeader posId = " + str, new Object[0]);
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str) || (pair = f42806b.get(str)) == null) {
            return hashMap;
        }
        hashMap.put("adnid", pair.first);
        hashMap.put("adnposid", pair.second);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(int i4) {
        Pair<JSONObject, String> pair = f42805a.get(Integer.valueOf(i4));
        if (pair == null) {
            d1.a("MSDK ReportUtil reportShow error pair == null", new Object[0]);
        } else {
            a(1230003, new com.qq.e.comm.plugin.n0.d((JSONObject) pair.first), (String) pair.second);
        }
    }

    private static boolean c(String str) {
        return com.qq.e.comm.plugin.d0.a.d().f().a("mreecpmg", str, 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(int i4) {
        Pair<JSONObject, String> pair = f42805a.get(Integer.valueOf(i4));
        if (pair == null) {
            d1.a("MSDK ReportUtil reportReward error pair == null", new Object[0]);
        } else {
            a(1230004, new com.qq.e.comm.plugin.n0.d((JSONObject) pair.first), (String) pair.second);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, String str2, String str3) {
        d1.a("MSDK ReportUtil recordGDTAdapterExposeParam posId = " + str + ", adnId = " + str2 + ", adnPosId = " + str3, new Object[0]);
        f42806b.put(str, new Pair<>(str2, str3));
    }

    public static void a(String str, int i4) {
        if (TextUtils.isEmpty(str)) {
            GDTLogger.d("MSDK ReportUtil  recordBiddingAdapterExpGroupId:");
        } else {
            f42807c.put(str, Integer.valueOf(i4));
        }
    }

    public static Integer a(String str) {
        return f42807c.get(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0073 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.qq.e.comm.adevent.ADEvent r7, java.lang.String r8, com.qq.e.comm.plugin.b.g r9, java.lang.Object r10) {
        /*
            java.lang.String r0 = "adnet_id"
            com.qq.e.comm.plugin.n0.d r1 = new com.qq.e.comm.plugin.n0.d
            r1.<init>()
            r2 = 0
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r4 = 0
            java.lang.Object r3 = r7.getParam(r4, r3)     // Catch: java.lang.Exception -> L58
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Exception -> L58
            java.lang.String r4 = "appid"
            r5 = 1
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            java.lang.Object r5 = r7.getParam(r5, r6)     // Catch: java.lang.Exception -> L56
            r1.a(r4, r5)     // Catch: java.lang.Exception -> L56
            java.lang.String r4 = "request_id"
            r5 = 2
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            java.lang.Object r5 = r7.getParam(r5, r6)     // Catch: java.lang.Exception -> L56
            r1.a(r4, r5)     // Catch: java.lang.Exception -> L56
            java.lang.String r4 = "app_name"
            r5 = 3
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            java.lang.Object r5 = r7.getParam(r5, r6)     // Catch: java.lang.Exception -> L56
            r1.a(r4, r5)     // Catch: java.lang.Exception -> L56
            java.lang.String r4 = "m_posid"
            r1.a(r4, r8)     // Catch: java.lang.Exception -> L56
            java.util.Map<java.lang.Integer, android.util.Pair<org.json.JSONObject, java.lang.String>> r8 = com.qq.e.comm.plugin.e0.d.g.f42805a     // Catch: java.lang.Exception -> L56
            int r10 = r10.hashCode()     // Catch: java.lang.Exception -> L56
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch: java.lang.Exception -> L56
            java.lang.Object r8 = r8.get(r10)     // Catch: java.lang.Exception -> L56
            android.util.Pair r8 = (android.util.Pair) r8     // Catch: java.lang.Exception -> L56
            java.lang.Object r8 = r8.first     // Catch: java.lang.Exception -> L56
            org.json.JSONObject r8 = (org.json.JSONObject) r8     // Catch: java.lang.Exception -> L56
            java.lang.String r8 = r8.optString(r0)     // Catch: java.lang.Exception -> L56
            r1.a(r0, r8)     // Catch: java.lang.Exception -> L56
            goto L5f
        L56:
            r8 = move-exception
            goto L5a
        L58:
            r8 = move-exception
            r3 = r2
        L5a:
            java.lang.String r10 = " throw exception"
            com.qq.e.comm.plugin.util.d1.a(r10, r8)
        L5f:
            com.qq.e.comm.plugin.n0.c r8 = new com.qq.e.comm.plugin.n0.c
            r8.<init>()
            com.qq.e.comm.plugin.n0.c r8 = r8.c(r3)
            com.qq.e.comm.plugin.n0.c r8 = r8.a(r9)
            int r7 = r7.getType()
            switch(r7) {
                case 401: goto L88;
                case 402: goto L84;
                case 403: goto L80;
                case 404: goto L7c;
                case 405: goto L78;
                case 406: goto L74;
                default: goto L73;
            }
        L73:
            return
        L74:
            r7 = 1143006(0x1170de, float:1.601693E-39)
            goto L8b
        L78:
            r7 = 1143005(0x1170dd, float:1.601691E-39)
            goto L8b
        L7c:
            r7 = 1143004(0x1170dc, float:1.60169E-39)
            goto L8b
        L80:
            r7 = 1143003(0x1170db, float:1.601688E-39)
            goto L8b
        L84:
            r7 = 1143002(0x1170da, float:1.601687E-39)
            goto L8b
        L88:
            r7 = 1143001(0x1170d9, float:1.601686E-39)
        L8b:
            com.qq.e.comm.plugin.n0.v.a(r7, r8, r2, r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.e0.d.g.a(com.qq.e.comm.adevent.ADEvent, java.lang.String, com.qq.e.comm.plugin.b.g, java.lang.Object):void");
    }

    public static void a(Object obj, int i4) {
        if (obj == null) {
            return;
        }
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        try {
            dVar.a("adnet_id", ((JSONObject) f42805a.get(Integer.valueOf(obj.hashCode())).first).optString("adnet_id"));
        } catch (Exception e4) {
            d1.a(" throw exception", e4);
        }
        v.a(i4, null, null, null, dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i4, long j4) {
        Pair<JSONObject, String> pair = f42805a.get(Integer.valueOf(i4));
        if (pair == null) {
            d1.a("MSDK ReportUtil reportImp error pair == null", new Object[0]);
            return;
        }
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d((JSONObject) pair.first);
        dVar.a("exposeDuration", Long.valueOf(j4));
        a(1230000, dVar, (String) pair.second);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i4) {
        Pair<JSONObject, String> pair = f42805a.get(Integer.valueOf(i4));
        if (pair == null) {
            d1.a("MSDK ReportUtil reportClick error pair == null", new Object[0]);
        } else {
            a(1230001, new com.qq.e.comm.plugin.n0.d((JSONObject) pair.first), (String) pair.second);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(List<com.qq.e.comm.plugin.e0.e.d> list, String str, int i4) {
        JSONArray jSONArray = new JSONArray();
        if (list == null || list.size() <= 0) {
            return;
        }
        String str2 = "";
        int i5 = 0;
        for (com.qq.e.comm.plugin.e0.e.d dVar : list) {
            if (dVar == null) {
                d1.b("MSDK ReportUtil ", "report config is null");
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    str2 = dVar.n();
                    i5 = dVar.k();
                    jSONObject.put("adnet_id", dVar.a());
                    jSONObject.put("placement_id", dVar.p());
                    jSONObject.put(BidResponsed.KEY_PRICE, dVar.q());
                    if (a(str2, dVar)) {
                        jSONObject.put("ecpm", -1);
                        jSONObject.put("bpg", dVar.d());
                        jSONObject.put("yecpm", dVar.t());
                    } else {
                        jSONObject.put("ecpm", dVar.f());
                    }
                    jSONObject.put(ConstantAd.KEY_CACHE_AD, dVar.s());
                    int i6 = dVar.m() == 3 ? 1 : 0;
                    jSONObject.put("is_fill", i6);
                    if (i6 == 0) {
                        jSONObject.put("unfill_reason", dVar.m());
                        jSONObject.put("load_ec", dVar.g());
                        jSONObject.put("load_em", dVar.h());
                    }
                    jSONObject.put("is_win", dVar.v() ? 1 : 0);
                    jSONObject.put("load_duration", dVar.l());
                    jSONObject.put("report_json", new j0(dVar.j()).a().optString("report_json"));
                    jSONArray.put(jSONObject);
                } catch (JSONException e4) {
                    d1.a(" throw JSONException", e4);
                }
            }
        }
        com.qq.e.comm.plugin.n0.d dVar2 = new com.qq.e.comm.plugin.n0.d();
        dVar2.a("mediation_id", str2);
        dVar2.a("flow_group_id", Integer.valueOf(i5));
        dVar2.a("adns", jSONArray);
        dVar2.a("exp_group_id", Integer.valueOf(i4));
        dVar2.a("trace_id", str);
        a(1230002, dVar2, str2);
    }

    private static void a(int i4, com.qq.e.comm.plugin.n0.d dVar, String str) {
        d1.a("MSDK ReportUtil report: " + i4 + ", extra: " + dVar, new Object[0]);
        com.qq.e.comm.plugin.n0.e eVar = new com.qq.e.comm.plugin.n0.e(i4);
        eVar.a(new com.qq.e.comm.plugin.n0.c().c(str));
        eVar.a(dVar);
        v.a(eVar, true);
    }

    private static boolean a(String str, com.qq.e.comm.plugin.e0.e.d dVar) {
        return dVar.u() && dVar.a() != 100 && c(str);
    }
}
