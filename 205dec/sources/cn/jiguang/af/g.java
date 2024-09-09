package cn.jiguang.af;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.ao.i;
import cn.jpush.android.service.WakedResultReceiver;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f2138a;

    /* renamed from: b  reason: collision with root package name */
    private static WakedResultReceiver f2139b;

    public static JSONArray a(Context context) {
        JSONObject a4;
        synchronized ("waked_cache_v2.json") {
            a4 = cn.jiguang.ao.e.a(context, "waked_cache_v2.json");
        }
        if (a4 == null) {
            a4 = new JSONObject();
        }
        JSONArray optJSONArray = a4.optJSONArray("content");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            cn.jiguang.w.a.b("JWakedHelper", "no save data");
            return null;
        }
        return a(context, optJSONArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static JSONArray a(Context context, JSONArray jSONArray) {
        String str;
        JSONArray jSONArray2;
        HashMap hashMap;
        int i4;
        Map map;
        HashMap hashMap2;
        Integer valueOf;
        HashMap hashMap3;
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    HashMap hashMap4 = new HashMap();
                    int i5 = 0;
                    while (true) {
                        str = "active";
                        if (i5 >= jSONArray.length()) {
                            break;
                        }
                        JSONObject jSONObject = jSONArray.getJSONObject(i5);
                        String optString = jSONObject.optString("type");
                        long optLong = jSONObject.optLong("itime");
                        Iterator it = hashMap4.entrySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                hashMap = hashMap4;
                                i4 = i5;
                                map = null;
                                break;
                            }
                            Map.Entry entry = (Map.Entry) it.next();
                            long longValue = ((Long) entry.getKey()).longValue();
                            i4 = i5;
                            hashMap = hashMap4;
                            if (i.a(optLong * 1000, longValue * 1000)) {
                                map = (Map) entry.getValue();
                                optLong = longValue;
                                break;
                            }
                            i5 = i4;
                            hashMap4 = hashMap;
                        }
                        if (map == null) {
                            map = new HashMap();
                        }
                        if ("android_awake_target2".equals(optString) || "aat3".equals(optString)) {
                            String optString2 = jSONObject.optString("package");
                            if (!jSONObject.optBoolean("app_alive")) {
                                str = "dead";
                            }
                            int optInt = jSONObject.optInt("wake_type");
                            if (map.containsKey(optString2)) {
                                Map map2 = (Map) map.get(optString2);
                                if (map2.containsKey(Integer.valueOf(optInt))) {
                                    Map map3 = (Map) map2.get(Integer.valueOf(optInt));
                                    map3.put(str, map3.containsKey(str) ? Integer.valueOf(((Integer) map3.get(str)).intValue() + 1) : 1);
                                    valueOf = Integer.valueOf(optInt);
                                    hashMap3 = map3;
                                } else {
                                    HashMap hashMap5 = new HashMap();
                                    hashMap5.put(str, 1);
                                    valueOf = Integer.valueOf(optInt);
                                    hashMap3 = hashMap5;
                                }
                                map2.put(valueOf, hashMap3);
                                map.put(optString2, map2);
                            } else {
                                HashMap hashMap6 = new HashMap();
                                hashMap6.put(str, 1);
                                HashMap hashMap7 = new HashMap();
                                hashMap7.put(Integer.valueOf(optInt), hashMap6);
                                map.put(optString2, hashMap7);
                            }
                            hashMap2 = hashMap;
                            hashMap2.put(Long.valueOf(optLong), map);
                            String optString3 = jSONObject.optString("jg_extras");
                            cn.jiguang.w.a.b("JWakedHelper", "jg_extras is :" + optString3);
                            if (!TextUtils.isEmpty(optString3)) {
                                String optString4 = new JSONObject(optString3).optString("di");
                                if (!TextUtils.isEmpty(optString4)) {
                                    a(context, optString4);
                                }
                            }
                        } else {
                            cn.jiguang.w.a.f("JWakedHelper", "unkown type :" + optString);
                            hashMap2 = hashMap;
                        }
                        i5 = i4 + 1;
                        hashMap4 = hashMap2;
                    }
                    JSONArray jSONArray3 = new JSONArray();
                    Iterator it2 = hashMap4.entrySet().iterator();
                    while (it2.hasNext()) {
                        Map.Entry entry2 = (Map.Entry) it2.next();
                        JSONObject jSONObject2 = new JSONObject();
                        JSONArray jSONArray4 = new JSONArray();
                        Iterator it3 = ((Map) entry2.getValue()).entrySet().iterator();
                        while (it3.hasNext()) {
                            Map.Entry entry3 = (Map.Entry) it3.next();
                            JSONObject jSONObject3 = new JSONObject();
                            Iterator it4 = it2;
                            Iterator it5 = it3;
                            jSONObject3.put("p", entry3.getKey());
                            cn.jiguang.w.a.b("JWakedHelper", "pkg:" + ((String) entry3.getKey()));
                            Iterator it6 = ((Map) entry3.getValue()).entrySet().iterator();
                            JSONArray jSONArray5 = new JSONArray();
                            while (it6.hasNext()) {
                                Map.Entry entry4 = (Map.Entry) it6.next();
                                Iterator it7 = it6;
                                int intValue = ((Integer) entry4.getKey()).intValue();
                                StringBuilder sb = new StringBuilder();
                                JSONArray jSONArray6 = jSONArray3;
                                sb.append("type:");
                                sb.append(intValue);
                                cn.jiguang.w.a.b("JWakedHelper", sb.toString());
                                Map map4 = (Map) entry4.getValue();
                                cn.jiguang.w.a.b("JWakedHelper", "value:" + map4);
                                int intValue2 = map4.containsKey(str) ? ((Integer) map4.get(str)).intValue() : 0;
                                int intValue3 = map4.containsKey("dead") ? ((Integer) map4.get("dead")).intValue() : 0;
                                String str2 = str;
                                jSONArray5.put(intValue + "_" + (intValue2 + intValue3) + "_" + intValue2 + "_" + intValue3);
                                jSONArray3 = jSONArray6;
                                it6 = it7;
                                str = str2;
                            }
                            jSONObject3.put("d", jSONArray5);
                            jSONArray4.put(jSONObject3);
                            it2 = it4;
                            it3 = it5;
                            jSONArray3 = jSONArray3;
                            str = str;
                        }
                        JSONArray jSONArray7 = jSONArray3;
                        Iterator it8 = it2;
                        String str3 = str;
                        if (jSONArray4.length() > 0) {
                            jSONObject2.put("f", jSONArray4);
                            jSONObject2.put("itime", ((Long) entry2.getKey()).longValue());
                            jSONObject2.put("type", "aat3");
                            jSONArray2 = jSONArray7;
                            jSONArray2.put(jSONObject2);
                        } else {
                            jSONArray2 = jSONArray7;
                        }
                        it2 = it8;
                        jSONArray3 = jSONArray2;
                        str = str3;
                    }
                    JSONArray jSONArray8 = jSONArray3;
                    return jSONArray8.length() > 0 ? jSONArray8 : jSONArray;
                }
            } catch (Throwable th) {
                cn.jiguang.w.a.g("JWakedHelper", "merge waked json failed:" + th.getMessage());
                return null;
            }
        }
        return jSONArray;
    }

    private static JSONObject a(String str, int i4, boolean z3) {
        if (str == null) {
            str = "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("wake_type", i4);
            jSONObject.put("package", str);
            jSONObject.put("app_alive", z3);
            return jSONObject;
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JWakedHelper", "packageWakedJson error:" + th.getMessage());
            return null;
        }
    }

    private static void a(Context context, int i4) {
        if (context == null) {
            cn.jiguang.w.a.f("JWakedHelper", "context is null,can not notify waked");
            return;
        }
        WakedResultReceiver c4 = c(context);
        f2139b = c4;
        if (c4 == null) {
            cn.jiguang.w.a.f("JWakedHelper", "waked receiver is null");
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("1", context);
        hashMap.put("2", Integer.valueOf(i4));
        f2139b.onWakeMap(hashMap);
    }

    public static void a(final Context context, final Bundle bundle, final int i4) {
        try {
            cn.jiguang.w.a.b("JWakedHelper", "executeWakedAction.");
            a(context, i4);
            cn.jiguang.ah.d.a(new cn.jiguang.ah.e() { // from class: cn.jiguang.af.g.1
                @Override // cn.jiguang.ah.e
                public void a() {
                    g.c(context, bundle, i4);
                }
            });
            cn.jiguang.aq.a.a(context, 2);
        } catch (Throwable th) {
            cn.jiguang.w.a.b("JWakedHelper", "executeWakedAction failed:" + th.getLocalizedMessage());
        }
    }

    public static void a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("di", str);
            synchronized ("di.json") {
                JSONObject a4 = cn.jiguang.ao.e.a(context, "di.json");
                if (a4 == null) {
                    a4 = new JSONObject();
                }
                JSONArray optJSONArray = a4.optJSONArray("content");
                if (optJSONArray == null) {
                    optJSONArray = new JSONArray();
                }
                optJSONArray.put(jSONObject);
                a4.put("content", optJSONArray);
                cn.jiguang.ao.e.a(context, "di.json", a4);
                cn.jiguang.w.a.b("JWakedHelper", "save di is: " + str + ", success!");
            }
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JWakedHelper", "saveDId failed:" + th.getMessage());
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("itime", cn.jiguang.ah.d.i(context));
            jSONObject.put("type", "aat3");
            synchronized ("waked_cache_v2.json") {
                JSONObject a4 = cn.jiguang.ao.e.a(context, "waked_cache_v2.json");
                if (a4 == null) {
                    a4 = new JSONObject();
                }
                JSONArray optJSONArray = a4.optJSONArray("content");
                if (optJSONArray == null) {
                    optJSONArray = new JSONArray();
                }
                optJSONArray.put(jSONObject);
                a4.put("content", optJSONArray);
                cn.jiguang.ao.e.a(context, "waked_cache_v2.json", a4);
                cn.jiguang.w.a.b("JWakedHelper", "save waked data : " + a4.toString());
            }
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JWakedHelper", "saveWakedData failed:" + th.getMessage());
        }
    }

    public static void b(Context context) {
        synchronized ("waked_cache_v2.json") {
            cn.jiguang.ao.e.a(context, "waked_cache_v2.json", (String) null);
        }
    }

    private static WakedResultReceiver c(Context context) {
        PackageInfo a4;
        ActivityInfo[] activityInfoArr;
        WakedResultReceiver wakedResultReceiver = f2139b;
        if (wakedResultReceiver != null) {
            return wakedResultReceiver;
        }
        try {
            a4 = cn.jiguang.ag.a.a(context, 0);
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JWakedHelper", "find waked receiver throwable:" + th.getMessage());
        }
        if (a4 == null) {
            return null;
        }
        for (ActivityInfo activityInfo : a4.receivers) {
            if (WakedResultReceiver.class.isAssignableFrom(Class.forName(activityInfo.name, false, WakedResultReceiver.class.getClassLoader()))) {
                return (WakedResultReceiver) Class.forName(activityInfo.name).newInstance();
            }
            continue;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, Bundle bundle, int i4) {
        String str;
        if (bundle == null) {
            str = "bundle is null,give up save";
        } else if (b.b(context).f2089x) {
            String str2 = null;
            try {
                str2 = bundle.getString("from_package");
            } catch (Throwable unused) {
            }
            if (str2 == null) {
                str2 = "";
            }
            JSONObject a4 = a(str2, i4, f2138a);
            f2138a = true;
            if (a4 == null) {
                return;
            }
            try {
                String string = bundle.getString("jg_extras");
                if (!TextUtils.isEmpty(string)) {
                    a4.put("jg_extras", string);
                }
            } catch (Throwable th) {
                cn.jiguang.w.a.f("JWakedHelper", "save waked extras error:" + th.getMessage());
            }
            a(context, a4);
            return;
        } else {
            str = "server set do not report waked data,give up save";
        }
        cn.jiguang.w.a.f("JWakedHelper", str);
    }
}
