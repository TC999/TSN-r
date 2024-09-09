package com.bytedance.msdk.f;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class s {

    /* renamed from: c  reason: collision with root package name */
    private static boolean f28352c = true;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f28353f = false;

    /* renamed from: r  reason: collision with root package name */
    private static final Map<Integer, Map<String, List<List<String>>>> f28354r = new HashMap();
    private static boolean sr = true;
    private static boolean ux = true;

    /* renamed from: w  reason: collision with root package name */
    private static boolean f28355w = true;
    private static boolean xv = true;

    public static boolean c() {
        return f28353f;
    }

    public static boolean f() {
        if (ux) {
            ux = false;
            return true;
        }
        return false;
    }

    public static boolean sr() {
        if (xv) {
            xv = false;
            return true;
        }
        return false;
    }

    public static boolean ux() {
        if (sr) {
            sr = false;
            return true;
        }
        return false;
    }

    public static boolean w(StackTraceElement[] stackTraceElementArr) {
        Map<String, List<List<String>>> map;
        List<List<String>> list;
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0 || (map = f28354r.get(8)) == null || (list = map.get("pangle")) == null || list.size() <= 1) {
            return true;
        }
        return c(stackTraceElementArr, list);
    }

    public static boolean xv() {
        if (f28355w) {
            f28355w = false;
            return true;
        }
        return false;
    }

    public static void c(boolean z3) {
        f28353f = z3;
    }

    public static void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                if (keys != null) {
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONArray optJSONArray = jSONObject.optJSONArray(next);
                        if (optJSONArray != null) {
                            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i4);
                                Integer valueOf = Integer.valueOf(jSONObject2.optInt("rit_type"));
                                JSONArray optJSONArray2 = jSONObject2.optJSONArray("adn_features");
                                if (optJSONArray2 != null) {
                                    ArrayList arrayList = new ArrayList();
                                    for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                                        JSONArray jSONArray = optJSONArray2.getJSONArray(i5);
                                        if (jSONArray != null) {
                                            ArrayList arrayList2 = new ArrayList();
                                            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                                                String string = jSONArray.getString(i6);
                                                if (!TextUtils.isEmpty(string)) {
                                                    arrayList2.add(string);
                                                }
                                            }
                                            arrayList.add(arrayList2);
                                        }
                                    }
                                    if (arrayList.size() > 0) {
                                        HashMap hashMap = new HashMap();
                                        hashMap.put(next, arrayList);
                                        f28354r.put(valueOf, hashMap);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e4) {
                com.bytedance.msdk.adapter.sr.xv.c("TMe", "supervisorFeature error: " + e4.toString());
                e4.printStackTrace();
                return;
            }
        }
        com.bytedance.msdk.adapter.sr.xv.c("TMe", "--==-- adn features:" + f28354r);
    }

    public static boolean w() {
        if (f28352c) {
            f28352c = false;
            return true;
        }
        return false;
    }

    private static boolean c(StackTraceElement[] stackTraceElementArr, List<List<String>> list) {
        for (List<String> list2 : list) {
            if (list2 != null && list2.size() > 0) {
                for (int i4 = 0; i4 < stackTraceElementArr.length; i4++) {
                    StackTraceElement stackTraceElement = stackTraceElementArr[i4];
                    if (stackTraceElement != null) {
                        String stackTraceElement2 = stackTraceElement.toString();
                        if (!TextUtils.isEmpty(stackTraceElement2) && stackTraceElement2.contains(list2.get(0)) && (list2.size() == 1 || c(stackTraceElementArr, i4, list2))) {
                            return true;
                        }
                    }
                }
                continue;
            }
        }
        return false;
    }

    private static boolean c(StackTraceElement[] stackTraceElementArr, int i4, List<String> list) {
        int i5;
        for (int i6 = 0; i6 < list.size(); i6++) {
            String str = list.get(i6);
            if (TextUtils.isEmpty(str) || (i5 = i4 + i6) >= stackTraceElementArr.length) {
                return false;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i5];
            if (stackTraceElement != null) {
                String stackTraceElement2 = stackTraceElement.toString();
                if (TextUtils.isEmpty(stackTraceElement2) || !stackTraceElement2.contains(str)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean c(StackTraceElement[] stackTraceElementArr) {
        Map<String, List<List<String>>> map;
        List<List<String>> list;
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0 || (map = f28354r.get(7)) == null || (list = map.get("pangle")) == null || list.size() <= 1) {
            return true;
        }
        return c(stackTraceElementArr, list);
    }
}
