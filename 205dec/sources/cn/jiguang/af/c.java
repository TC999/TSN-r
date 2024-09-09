package cn.jiguang.af;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.ao.i;
import cn.jpush.android.api.JPushInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, cn.jiguang.ad.c> f2123a;

    public static Bundle a(HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (String str : hashMap.keySet()) {
            bundle.putString(str, hashMap.get(str));
        }
        return bundle;
    }

    public static cn.jiguang.ad.c a(Context context, String str) {
        try {
            return new cn.jiguang.ad.c(str, "", context.getPackageManager().getApplicationInfo(str, 0).targetSdkVersion);
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JWakeHelper", "getWakeTarget throwable:" + th.getMessage());
            return null;
        }
    }

    public static String a(List<cn.jiguang.ad.c> list) {
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < list.size(); i4++) {
            String str = list.get(i4).f2094a;
            String str2 = list.get(i4).f2095b;
            sb.append(str);
            sb.append("|");
            sb.append(str2);
            sb.append("$");
        }
        return sb.toString();
    }

    public static HashMap<String, cn.jiguang.ad.c> a(Context context) {
        cn.jiguang.ad.c a4;
        try {
            HashMap<String, cn.jiguang.ad.c> hashMap = new HashMap<>();
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent();
            intent.setAction("cn.jpush.android.intent.DaemonService");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() != 0) {
                for (int i4 = 0; i4 < queryIntentServices.size(); i4++) {
                    ServiceInfo serviceInfo = queryIntentServices.get(i4).serviceInfo;
                    String str = serviceInfo.name;
                    String str2 = serviceInfo.packageName;
                    if (str != null && str2 != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && serviceInfo.exported && serviceInfo.enabled && !context.getPackageName().equals(str2) && (a4 = a.a(context, packageManager, str2, str)) != null) {
                        cn.jiguang.w.a.b("JWakeHelper", "wakeTarget:" + a4.toString());
                        hashMap.put(a4.f2094a, a4);
                    }
                }
                return hashMap;
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JWakeHelper", "getWakeTargetMap throwable:" + th.getMessage());
            return null;
        }
    }

    public static HashMap<String, cn.jiguang.ad.c> a(Context context, HashMap<String, cn.jiguang.ad.c> hashMap) {
        try {
            HashMap<String, cn.jiguang.ad.c> hashMap2 = f2123a;
            if (hashMap2 == null || hashMap2.isEmpty()) {
                HashMap<String, cn.jiguang.ad.c> hashMap3 = new HashMap<>();
                PackageManager packageManager = context.getPackageManager();
                Intent intent = new Intent();
                intent.setAction("cn.jpush.android.intent.PushService");
                List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
                if (queryIntentServices != null && queryIntentServices.size() != 0) {
                    for (int i4 = 0; i4 < queryIntentServices.size(); i4++) {
                        ServiceInfo serviceInfo = queryIntentServices.get(i4).serviceInfo;
                        String str = serviceInfo.name;
                        String str2 = serviceInfo.packageName;
                        if (str != null && str2 != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && ((hashMap == null || !hashMap.containsKey(str2)) && !context.getPackageName().equals(str2))) {
                            int checkPermission = packageManager.checkPermission(str2 + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX, str2);
                            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str2, 128);
                            if (applicationInfo != null && applicationInfo.metaData != null) {
                                String b4 = cn.jiguang.ah.d.b(context);
                                if (checkPermission == 0 && !TextUtils.isEmpty(b4) && b4.length() == 24 && !context.getPackageName().equals(applicationInfo.packageName)) {
                                    cn.jiguang.ad.c cVar = new cn.jiguang.ad.c(str2, "", applicationInfo.targetSdkVersion);
                                    cVar.f2097d = str2 + ".DownloadProvider";
                                    hashMap3.put(cVar.f2094a, cVar);
                                }
                            }
                        }
                    }
                    f2123a = hashMap3;
                    cn.jiguang.w.a.b("JWakeHelper", "getWakeAppListWithoutDService:" + hashMap3.toString());
                    return hashMap3;
                }
                return null;
            }
            return f2123a;
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JWakeHelper", "getWakeAppListWithoutDService throwable:" + th.getMessage());
            return null;
        }
    }

    public static List<cn.jiguang.ad.c> a(Context context, List<cn.jiguang.ad.c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            try {
                list.get(i4).f2096c = context.getPackageManager().getApplicationInfo(list.get(i4).f2094a, 128).targetSdkVersion;
            } catch (Throwable unused) {
            }
        }
        return list;
    }

    public static List<String> a(cn.jiguang.ad.a aVar, List<String> list) {
        return aVar == null ? list : c(aVar, b(aVar, list));
    }

    public static List<cn.jiguang.ad.c> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\\$");
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            String[] split2 = str2.split("\\|");
            String str3 = split2[0];
            String str4 = split2[1];
            cn.jiguang.ad.c cVar = new cn.jiguang.ad.c();
            cVar.f2094a = str3;
            cVar.f2095b = str4;
            cVar.f2103j = 1;
            cVar.f2100g = 4;
            arrayList.add(cVar);
        }
        return arrayList;
    }

    private static List<String> a(List<String> list, List<String> list2) {
        return a(list, list2, false);
    }

    private static List<String> a(List<String> list, List<String> list2, boolean z3) {
        if (list == null || list.size() == 0) {
            return list2;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list2) {
            if (list.contains(str)) {
                if (z3) {
                    cn.jiguang.w.a.b("JWakeHelper", str + " in the white list");
                    arrayList.add(str);
                } else {
                    cn.jiguang.w.a.b("JWakeHelper", str + " in the black list");
                }
            }
            if (!z3) {
                cn.jiguang.w.a.b("JWakeHelper", str + " not in the global black list");
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private static JSONArray a(Context context, JSONArray jSONArray) {
        String str;
        HashMap hashMap;
        int i4;
        Map map;
        HashMap hashMap2;
        JSONArray jSONArray2;
        String str2 = "JWakeHelper";
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    HashMap hashMap3 = new HashMap();
                    int i5 = 0;
                    while (i5 < jSONArray.length()) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i5);
                        String optString = jSONObject.optString("type");
                        if ("aa3".equals(optString)) {
                            JSONArray optJSONArray = jSONObject.optJSONArray("target");
                            if (optJSONArray == null || optJSONArray.length() <= 0) {
                                break;
                            }
                            long optLong = jSONObject.optLong("itime");
                            Iterator it = hashMap3.entrySet().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    hashMap = hashMap3;
                                    i4 = i5;
                                    map = null;
                                    break;
                                }
                                Map.Entry entry = (Map.Entry) it.next();
                                long longValue = ((Long) entry.getKey()).longValue();
                                i4 = i5;
                                hashMap = hashMap3;
                                if (i.a(optLong * 1000, longValue * 1000)) {
                                    map = (Map) entry.getValue();
                                    optLong = longValue;
                                    break;
                                }
                                i5 = i4;
                                hashMap3 = hashMap;
                            }
                            if (map == null) {
                                map = new HashMap();
                            }
                            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                                JSONArray jSONArray3 = optJSONObject.getJSONArray("data");
                                if (jSONArray3 != null && jSONArray3.length() > 0) {
                                    String optString2 = optJSONObject.optString("package");
                                    int i7 = 0;
                                    while (i7 < jSONArray3.length()) {
                                        JSONObject jSONObject2 = jSONArray3.getJSONObject(i7);
                                        if (jSONObject2 != null) {
                                            int i8 = jSONObject2.getInt("wake_type");
                                            int i9 = jSONObject2.getInt("wake_status");
                                            if (map.containsKey(optString2)) {
                                                Map map2 = (Map) map.get(optString2);
                                                if (map2.containsKey(Integer.valueOf(i8))) {
                                                    Map map3 = (Map) map2.get(Integer.valueOf(i8));
                                                    if (map3.containsKey(Integer.valueOf(i9))) {
                                                        map3.put(Integer.valueOf(i9), Integer.valueOf(((Integer) map3.get(Integer.valueOf(i9))).intValue() + 1));
                                                        jSONArray2 = jSONArray3;
                                                    } else {
                                                        jSONArray2 = jSONArray3;
                                                        map3.put(Integer.valueOf(i9), 1);
                                                    }
                                                    map2.put(Integer.valueOf(i8), map3);
                                                } else {
                                                    jSONArray2 = jSONArray3;
                                                    HashMap hashMap4 = new HashMap();
                                                    hashMap4.put(Integer.valueOf(i9), 1);
                                                    map2.put(Integer.valueOf(i8), hashMap4);
                                                }
                                                map.put(optString2, map2);
                                            } else {
                                                jSONArray2 = jSONArray3;
                                                HashMap hashMap5 = new HashMap();
                                                hashMap5.put(Integer.valueOf(i9), 1);
                                                HashMap hashMap6 = new HashMap();
                                                hashMap6.put(Integer.valueOf(i8), hashMap5);
                                                map.put(optString2, hashMap6);
                                            }
                                        } else {
                                            jSONArray2 = jSONArray3;
                                        }
                                        i7++;
                                        jSONArray3 = jSONArray2;
                                    }
                                }
                            }
                            hashMap2 = hashMap;
                            hashMap2.put(Long.valueOf(optLong), map);
                        } else {
                            cn.jiguang.w.a.f("JWakeHelper", "unkown type :" + optString);
                            hashMap2 = hashMap3;
                            i4 = i5;
                        }
                        i5 = i4 + 1;
                        hashMap3 = hashMap2;
                    }
                    JSONArray jSONArray4 = new JSONArray();
                    Iterator it2 = hashMap3.entrySet().iterator();
                    while (it2.hasNext()) {
                        Map.Entry entry2 = (Map.Entry) it2.next();
                        JSONArray jSONArray5 = new JSONArray();
                        Iterator it3 = ((Map) entry2.getValue()).entrySet().iterator();
                        while (it3.hasNext()) {
                            Map.Entry entry3 = (Map.Entry) it3.next();
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("p", entry3.getKey());
                            JSONArray jSONArray6 = new JSONArray();
                            Iterator it4 = ((Map) entry3.getValue()).entrySet().iterator();
                            while (it4.hasNext()) {
                                Map.Entry entry4 = (Map.Entry) it4.next();
                                Integer num = (Integer) entry4.getKey();
                                Map map4 = (Map) entry4.getValue();
                                Iterator it5 = it2;
                                int intValue = map4.containsKey(1) ? ((Integer) map4.get(1)).intValue() : 0;
                                Iterator it6 = it3;
                                int intValue2 = map4.containsKey(101) ? ((Integer) map4.get(101)).intValue() : 0;
                                Iterator it7 = it4;
                                int intValue3 = map4.containsKey(102) ? ((Integer) map4.get(102)).intValue() : 0;
                                str = str2;
                                try {
                                    int intValue4 = map4.containsKey(103) ? ((Integer) map4.get(103)).intValue() : 0;
                                    jSONArray6.put(num + "_" + (intValue + intValue2 + intValue3 + intValue4) + "_" + intValue + "_" + intValue2 + "_" + intValue3 + "_" + intValue4);
                                    it2 = it5;
                                    it3 = it6;
                                    it4 = it7;
                                    str2 = str;
                                } catch (Throwable th) {
                                    th = th;
                                    cn.jiguang.w.a.g(str, "merge wake json failed:" + th.getMessage());
                                    return null;
                                }
                            }
                            jSONObject3.put("d", jSONArray6);
                            jSONArray5.put(jSONObject3);
                            it2 = it2;
                            it3 = it3;
                            str2 = str2;
                        }
                        String str3 = str2;
                        Iterator it8 = it2;
                        if (jSONArray5.length() > 0) {
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("t", jSONArray5);
                            jSONObject4.put("itime", ((Long) entry2.getKey()).longValue());
                            jSONObject4.put("type", "aa3");
                            jSONArray4.put(jSONObject4);
                        }
                        it2 = it8;
                        str2 = str3;
                    }
                    str = str2;
                    return jSONArray4.length() > 0 ? jSONArray4 : jSONArray;
                }
            } catch (Throwable th2) {
                th = th2;
                str = str2;
            }
        }
        return jSONArray;
    }

    public static void a(Context context, cn.jiguang.ad.a aVar, List<cn.jiguang.ad.b> list) {
        if (!aVar.f2088w) {
            cn.jiguang.w.a.f("JWakeHelper", "server set do not report wake data,give up save");
            return;
        }
        JSONObject b4 = b(list);
        cn.jiguang.w.a.b("JWakeHelper", "wake json:" + b4);
        a(context, b4);
    }

    private static void a(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("itime", cn.jiguang.ah.d.i(context));
            jSONObject.put("type", "aa3");
            synchronized ("wake_cache_v2.json") {
                JSONObject a4 = cn.jiguang.ao.e.a(context, "wake_cache_v2.json");
                if (a4 == null) {
                    a4 = new JSONObject();
                }
                JSONArray optJSONArray = a4.optJSONArray("content");
                if (optJSONArray == null) {
                    optJSONArray = new JSONArray();
                }
                optJSONArray.put(jSONObject);
                a4.put("content", optJSONArray);
                cn.jiguang.ao.e.a(context, "wake_cache_v2.json", a4);
                cn.jiguang.w.a.b("JWakeHelper", "save wake data : " + a4.toString());
            }
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JWakeHelper", "saveWakeData failed:" + th.getMessage());
        }
    }

    public static String b(HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return null;
        }
        Uri.Builder builder = new Uri.Builder();
        for (String str : hashMap.keySet()) {
            builder.appendQueryParameter(str, hashMap.get(str));
        }
        return builder.toString();
    }

    private static List<String> b(cn.jiguang.ad.a aVar, List<String> list) {
        if (TextUtils.isEmpty(aVar.f2079n) || aVar.f2079n.equals("disable")) {
            return list;
        }
        List<String> list2 = aVar.f2080o;
        String str = aVar.f2079n;
        str.hashCode();
        return !str.equals("exclude") ? !str.equals("include") ? list : b(list2, list) : a(list2, list);
    }

    private static List<String> b(List<String> list, List<String> list2) {
        return a(list, list2, true);
    }

    public static JSONArray b(Context context) {
        JSONObject a4;
        synchronized ("wake_cache_v2.json") {
            a4 = cn.jiguang.ao.e.a(context, "wake_cache_v2.json");
        }
        if (a4 == null) {
            a4 = new JSONObject();
        }
        JSONArray optJSONArray = a4.optJSONArray("content");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            cn.jiguang.w.a.b("JWakeHelper", "no save data");
            return null;
        }
        return a(context, optJSONArray);
    }

    private static JSONObject b(List<cn.jiguang.ad.b> list) {
        if (list == null || list.size() == 0) {
            cn.jiguang.w.a.b("JWakeHelper", "wakeUpResult is empty, no need report");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (cn.jiguang.ad.b bVar : list) {
            try {
                HashMap<Integer, Integer> hashMap = bVar.f2093b;
                if (hashMap != null && !hashMap.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("package", bVar.f2092a);
                    JSONArray jSONArray2 = new JSONArray();
                    HashMap<Integer, Integer> hashMap2 = bVar.f2093b;
                    for (Integer num : hashMap2.keySet()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("wake_type", num);
                        jSONObject2.put("wake_status", hashMap2.get(num));
                        jSONArray2.put(jSONObject2);
                    }
                    jSONObject.put("data", jSONArray2);
                    jSONArray.put(jSONObject);
                }
            } catch (Throwable th) {
                cn.jiguang.w.a.h("JWakeHelper", "formatReportData:" + th);
            }
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("target", jSONArray);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject3;
    }

    private static List<String> c(cn.jiguang.ad.a aVar, List<String> list) {
        return a(aVar.f2081p, list);
    }

    public static void c(Context context) {
        synchronized ("wake_cache_v2.json") {
            cn.jiguang.ao.e.a(context, "wake_cache_v2.json", (String) null);
        }
    }
}
