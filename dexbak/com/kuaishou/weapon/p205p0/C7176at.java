package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p205p0.jni.Engine;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.at */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7176at {

    /* renamed from: a */
    private JSONObject f24530a;

    /* renamed from: b */
    private boolean f24531b;

    /* renamed from: c */
    private boolean f24532c;

    public C7176at(Context context) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(C7227ck.f24675g).intValue(), 0, 100, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f24530a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public String m34330a(String str) {
        JSONObject jSONObject = this.f24530a;
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: b */
    public JSONArray m34328b(String str) {
        JSONObject jSONObject = this.f24530a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (TextUtils.isEmpty(string) || string.length() <= 3) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(string);
                HashSet<Object> hashSet = new HashSet();
                for (int i = 0; i < jSONArray.length(); i++) {
                    hashSet.add(jSONArray.getString(i));
                }
                JSONArray jSONArray2 = new JSONArray();
                for (Object obj : hashSet) {
                    jSONArray2.put(obj);
                }
                return jSONArray2;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: c */
    public Set m34327c(String str) {
        JSONObject jSONObject = this.f24530a;
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString(str, null);
                if (!TextUtils.isEmpty(optString) && optString.length() > 3) {
                    HashSet hashSet = new HashSet();
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        hashSet.add(Integer.valueOf(Integer.valueOf((String) jSONArray.get(i), 16).intValue()));
                    }
                    return hashSet;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: d */
    public JSONArray m34326d(String str) {
        JSONObject jSONObject = this.f24530a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                int i = 0;
                if (TextUtils.equals(str, "46")) {
                    if (TextUtils.isEmpty(string) || string.length() <= 3) {
                        return null;
                    }
                    JSONArray jSONArray = new JSONArray(string);
                    JSONArray jSONArray2 = new JSONArray();
                    while (i < jSONArray.length()) {
                        jSONArray2.put(jSONArray.getString(i).replaceAll(" ", "").replace(ShellAdbUtils.f33810d, "").replace(">", ""));
                        i++;
                    }
                    return jSONArray2;
                } else if (TextUtils.equals(str, "45")) {
                    String m33864a = C7284i.m33864a("aae31bed33c490b6613a", "0701");
                    String m33864a2 = C7284i.m33864a("99e111e83fc4d0a7662b", "0701");
                    if (TextUtils.isEmpty(string) || string.length() <= 3) {
                        return null;
                    }
                    JSONArray jSONArray3 = new JSONArray(string);
                    HashSet hashSet = new HashSet();
                    while (i < jSONArray3.length()) {
                        hashSet.add(jSONArray3.getString(i).replaceAll(" ", "").replace(ShellAdbUtils.f33810d, ""));
                        i++;
                    }
                    JSONArray jSONArray4 = new JSONArray();
                    for (Object obj : hashSet) {
                        jSONArray4.put(obj);
                        String str2 = (String) obj;
                        if (str2.contains(m33864a)) {
                            this.f24531b = true;
                        }
                        if (str2.contains(m33864a2)) {
                            this.f24532c = true;
                        }
                    }
                    return jSONArray4;
                } else {
                    return null;
                }
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public Set m34332a(int i) {
        HashSet hashSet = new HashSet();
        if (i == 0) {
            hashSet.add("/preas/chi");
        }
        return hashSet;
    }

    /* renamed from: a */
    public Set m34331a(Context context, String str, int i) {
        JSONObject jSONObject = this.f24530a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                Set m34332a = m34332a(i);
                if (TextUtils.isEmpty(string) || string.length() <= 3) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(string);
                HashSet hashSet = new HashSet();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    String replace = jSONArray.getString(i2).replaceAll(" ", "").replace(ShellAdbUtils.f33810d, "").replace("\t", "").replace("\u200b", "");
                    if (replace.startsWith(":")) {
                        replace = replace.substring(1);
                    }
                    String substring = replace.length() > 10 ? replace.substring(0, 10) : replace;
                    String packageName = context.getPackageName();
                    if (!replace.contains(packageName) && !packageName.contains(replace) && !m34332a.contains(substring)) {
                        hashSet.add(replace);
                    }
                }
                if (hashSet.size() > 0) {
                    return hashSet;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: b */
    public boolean m34329b() {
        return this.f24532c;
    }

    /* renamed from: a */
    public boolean m34333a() {
        return this.f24531b;
    }
}
