package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class bf {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f38059a;

    public bf(Context context, int i4) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f38167c).intValue(), 5, i4, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f38059a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f38059a;
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
        JSONObject jSONObject = this.f38059a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (TextUtils.isEmpty(string) || string.length() <= 2) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(string);
                HashSet hashSet = new HashSet();
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    hashSet.add((String) jSONArray.get(i4));
                }
                Set a4 = a(hashSet);
                if (a4 == null || a4.size() <= 0) {
                    return null;
                }
                return new JSONArray((Collection) a4);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public boolean a(Set set, String str) {
        try {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (!str2.equals(str) && str2.contains(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public Set a(Set set) {
        if (set != null) {
            try {
                if (set.size() > 0) {
                    HashSet hashSet = new HashSet();
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (!a(set, str)) {
                            hashSet.add(str);
                        }
                    }
                    return hashSet;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public JSONObject a(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    String string = jSONArray.getString(i4);
                    if (string.contains("data/data")) {
                        if (string.contains("libjnigraphics.so")) {
                            jSONObject.put("0", 1);
                            jSONObject.put("0-p", string);
                        } else if (string.contains("libandroid.so")) {
                            jSONObject.put("1", 1);
                            jSONObject.put("1-p", string);
                        } else if (string.contains("libjavacrypto.so")) {
                            jSONObject.put("2", 1);
                            jSONObject.put("2-p", string);
                        } else if (string.contains("libRSCpuRef.so")) {
                            jSONObject.put("3", 1);
                            jSONObject.put("3-p", string);
                        }
                    }
                }
                if (jSONObject.length() > 0) {
                    return jSONObject;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public JSONObject a() {
        return this.f38059a;
    }
}
