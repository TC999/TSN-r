package com.bytedance.msdk.core.xv;

import android.text.TextUtils;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {
    public static void c(String str, String str2, String str3) {
        if (com.bytedance.msdk.core.c.w().yu() != null) {
            com.bytedance.msdk.f.c.xv.c().insert(str, str2, str3, "show");
        }
    }

    private static boolean c(int i4) {
        return i4 == 0 || i4 == 1 || i4 == 2;
    }

    public static void w(String str, String str2, String str3) {
        if (com.bytedance.msdk.core.c.w().yu() != null) {
            com.bytedance.msdk.f.c.xv.c().insert(str, str2, str3, "send");
        }
    }

    private static boolean w(int i4) {
        return i4 == 3 || i4 == 4 || i4 == 5 || i4 == 6 || i4 == 7 || i4 == 8 || i4 == 9;
    }

    public static void xv(String str, String str2, String str3) {
        if (com.bytedance.msdk.core.c.w().yu() != null) {
            com.bytedance.msdk.f.c.xv.c().insert(str, str2, str3, TTLogUtil.TAG_EVENT_FILL);
        }
    }

    public static void c(String str, int i4) {
        if (com.bytedance.msdk.core.c.w().yu() == null || TextUtils.isEmpty(str)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - (i4 * 3600000);
        com.bytedance.msdk.adapter.sr.xv.w("TMe", "---\u9884\u7f13\u5b58\u4f18\u5316\u5220\u9664\u5b58\u50a8\u7684\u8fc7\u671f\u6570\u636e primeRit = " + str + " startTime = " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(currentTimeMillis)));
        com.bytedance.msdk.f.c.xv.c().c(str, currentTimeMillis);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x01dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bytedance.msdk.core.k.w c(com.bytedance.msdk.api.c.w r30, com.bytedance.msdk.core.k.w r31) {
        /*
            Method dump skipped, instructions count: 716
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.xv.xv.c(com.bytedance.msdk.api.c.w, com.bytedance.msdk.core.k.w):com.bytedance.msdk.core.k.w");
    }

    private static int c(com.bytedance.msdk.core.k.w wVar, w wVar2, int i4) {
        if (com.bytedance.msdk.core.c.w().wv()) {
            if (wVar2 == null || wVar2.ux() == null) {
                return 1;
            }
            if (wVar2.c(i4)) {
                if (wVar2.w() == 0) {
                    return 3;
                }
                if (wVar2.c() == 0) {
                    return 4;
                }
                if (wVar2.r()) {
                    if (wVar == null || !wVar2.c(wVar.xk())) {
                        return 6;
                    }
                    if (wVar.bj() == 0) {
                        return 7;
                    }
                    if (c(wVar, wVar2)) {
                        return c(wVar) ? 9 : 200;
                    }
                    return 8;
                }
                return 5;
            }
            return 2;
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean c(com.bytedance.msdk.core.k.w r8, com.bytedance.msdk.core.xv.w r9) {
        /*
            if (r8 == 0) goto L42
            java.util.List r0 = r8.up()
            if (r0 == 0) goto L42
            if (r9 == 0) goto L42
            java.util.List r0 = r8.up()
            java.util.Iterator r0 = r0.iterator()
        L12:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L42
            java.lang.Object r1 = r0.next()
            com.bytedance.msdk.core.k.p r1 = (com.bytedance.msdk.core.k.p) r1
            java.lang.String r2 = r1.fp()
            java.lang.String r3 = r8.xk()
            double r2 = r9.c(r2, r3)
            java.lang.String r1 = r1.fp()
            java.lang.String r4 = r8.xk()
            double r4 = r9.w(r1, r4)
            r6 = 0
            int r1 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r1 != 0) goto L40
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 == 0) goto L12
        L40:
            r8 = 1
            return r8
        L42:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.xv.xv.c(com.bytedance.msdk.core.k.w, com.bytedance.msdk.core.xv.w):boolean");
    }

    private static boolean c(com.bytedance.msdk.core.k.w wVar) {
        if (wVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            List<com.bytedance.msdk.f.c.w> query = com.bytedance.msdk.f.c.xv.c().query("", wVar.xk(), currentTimeMillis - (wVar.bj() * 3600000), currentTimeMillis);
            return query == null || query.isEmpty();
        }
        return false;
    }

    private static void c(com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.core.k.w wVar2, w wVar3, int i4, Set<String> set, Map<String, c> map) {
        if (wVar.k() != null) {
            com.bytedance.msdk.adapter.sr.xv.w("TMe", "\u9884\u7f13\u5b58\u4f18\u5316\u5b58\u5728\u57cb\u70b9\u6570\u636e \u65e0\u9700\u91cd\u65b0\u5b58\u50a8");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", i4);
            if (c(i4)) {
                wVar.c(jSONObject);
                return;
            }
            jSONObject.put("perform", c(i4, wVar3, map));
            if (w(i4)) {
                wVar.c(jSONObject);
                return;
            }
            jSONObject.put("behavior_state", c(wVar3));
            jSONObject.put("condition", wVar3.w());
            if (wVar2 != null) {
                try {
                    jSONObject.put("behavior_ttl", wVar2.bj());
                } catch (JSONException unused) {
                }
            }
            if (set != null && set.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                for (String str : set) {
                    jSONArray.put(str);
                }
                jSONObject.put("filtered_adn", jSONArray);
            }
            wVar.c(jSONObject);
        } catch (JSONException unused2) {
        }
    }

    private static JSONArray c(w wVar) {
        List<Integer> list;
        JSONArray jSONArray = new JSONArray();
        if (wVar != null && (list = wVar.f28293c) != null) {
            for (Integer num : list) {
                jSONArray.put(num);
            }
        }
        return jSONArray;
    }

    private static JSONObject c(int i4, w wVar, Map<String, c> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("rule_id", wVar.xv());
        jSONObject.put("rule_timestamp", wVar.sr());
        if (w(i4)) {
            return jSONObject;
        }
        jSONObject.put("condition", wVar.c());
        jSONObject.put("rule_inuse", (i4 == 10 || i4 == 11) ? 1 : 0);
        if (map != null) {
            try {
                DecimalFormat decimalFormat = new DecimalFormat("#0.000");
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                for (Map.Entry<String, c> entry : map.entrySet()) {
                    c value = entry.getValue();
                    if (value != null) {
                        jSONObject3.put(entry.getKey(), decimalFormat.format(value.w()));
                        jSONObject4.put(entry.getKey(), decimalFormat.format(value.xv()));
                    }
                }
                jSONObject2.put("ssr", jSONObject3);
                jSONObject2.put("srr", jSONObject4);
                jSONObject.put("res", jSONObject2);
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }
}
