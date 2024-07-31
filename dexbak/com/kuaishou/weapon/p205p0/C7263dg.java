package com.kuaishou.weapon.p205p0;

import android.text.TextUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.dg */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7263dg {
    /* renamed from: a */
    public JSONArray m33973a(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (TextUtils.isEmpty(string) || string.length() <= 2) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(string);
                HashSet hashSet = new HashSet();
                for (int i = 0; i < jSONArray.length(); i++) {
                    hashSet.add((String) jSONArray.get(i));
                }
                if (hashSet.size() > 0) {
                    return new JSONArray((Collection) hashSet);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: b */
    public JSONArray m33972b(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(string);
                HashSet hashSet = new HashSet();
                for (int i = 0; i < jSONArray.length(); i++) {
                    String str2 = (String) jSONArray.get(i);
                    if (str2.contains("frida")) {
                        hashSet.add(str2);
                    }
                }
                if (hashSet.size() > 0) {
                    return new JSONArray((Collection) hashSet);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: c */
    public JSONArray m33971c(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(string);
                HashSet hashSet = new HashSet();
                for (int i = 0; i < jSONArray.length(); i++) {
                    String str2 = (String) jSONArray.get(i);
                    if (str2.contains("substrate") || str2.contains(".jar") || str2.contains("xposed")) {
                        hashSet.add(str2);
                    }
                }
                if (hashSet.size() > 0) {
                    return new JSONArray((Collection) hashSet);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public JSONArray m33974a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray != null) {
            if (jSONArray.length() > 0 && jSONArray2 != null && jSONArray2.length() > 0) {
                Set m33947a = C7268dl.m33947a(jSONArray);
                Set m33947a2 = C7268dl.m33947a(jSONArray2);
                if (m33947a != null && m33947a2 != null) {
                    m33947a.removeAll(m33947a2);
                    if (m33947a.size() > 0) {
                        return new JSONArray((Collection) m33947a);
                    }
                    return null;
                }
            }
        }
        return jSONArray;
    }
}
