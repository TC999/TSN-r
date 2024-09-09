package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class at {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f38038a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f38039b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f38040c;

    public at(Context context) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f38171g).intValue(), 0, 100, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f38038a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f38038a;
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public JSONArray b(String str) {
        JSONObject jSONObject = this.f38038a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (TextUtils.isEmpty(string) || string.length() <= 3) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(string);
                HashSet<Object> hashSet = new HashSet();
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    hashSet.add(jSONArray.getString(i4));
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

    public Set c(String str) {
        JSONObject jSONObject = this.f38038a;
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString(str, null);
                if (!TextUtils.isEmpty(optString) && optString.length() > 3) {
                    HashSet hashSet = new HashSet();
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                        hashSet.add(Integer.valueOf(Integer.valueOf((String) jSONArray.get(i4), 16).intValue()));
                    }
                    return hashSet;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public JSONArray d(String str) {
        JSONObject jSONObject = this.f38038a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                int i4 = 0;
                if (TextUtils.equals(str, "46")) {
                    if (TextUtils.isEmpty(string) || string.length() <= 3) {
                        return null;
                    }
                    JSONArray jSONArray = new JSONArray(string);
                    JSONArray jSONArray2 = new JSONArray();
                    while (i4 < jSONArray.length()) {
                        jSONArray2.put(jSONArray.getString(i4).replaceAll(" ", "").replace("\n", "").replace(">", ""));
                        i4++;
                    }
                    return jSONArray2;
                } else if (TextUtils.equals(str, "45")) {
                    String a4 = i.a("aae31bed33c490b6613a", "0701");
                    String a5 = i.a("99e111e83fc4d0a7662b", "0701");
                    if (TextUtils.isEmpty(string) || string.length() <= 3) {
                        return null;
                    }
                    JSONArray jSONArray3 = new JSONArray(string);
                    HashSet hashSet = new HashSet();
                    while (i4 < jSONArray3.length()) {
                        hashSet.add(jSONArray3.getString(i4).replaceAll(" ", "").replace("\n", ""));
                        i4++;
                    }
                    JSONArray jSONArray4 = new JSONArray();
                    for (Object obj : hashSet) {
                        jSONArray4.put(obj);
                        String str2 = (String) obj;
                        if (str2.contains(a4)) {
                            this.f38039b = true;
                        }
                        if (str2.contains(a5)) {
                            this.f38040c = true;
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

    public Set a(int i4) {
        HashSet hashSet = new HashSet();
        if (i4 == 0) {
            hashSet.add("/preas/chi");
        }
        return hashSet;
    }

    public Set a(Context context, String str, int i4) {
        JSONObject jSONObject = this.f38038a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                Set a4 = a(i4);
                if (TextUtils.isEmpty(string) || string.length() <= 3) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(string);
                HashSet hashSet = new HashSet();
                for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                    String replace = jSONArray.getString(i5).replaceAll(" ", "").replace("\n", "").replace("\t", "").replace("\u200b", "");
                    if (replace.startsWith(":")) {
                        replace = replace.substring(1);
                    }
                    String substring = replace.length() > 10 ? replace.substring(0, 10) : replace;
                    String packageName = context.getPackageName();
                    if (!replace.contains(packageName) && !packageName.contains(replace) && !a4.contains(substring)) {
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

    public boolean b() {
        return this.f38040c;
    }

    public boolean a() {
        return this.f38039b;
    }
}
