package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p205p0.jni.Engine;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.bf */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7189bf {

    /* renamed from: a */
    private JSONObject f24551a;

    public C7189bf(Context context, int i) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(C7227ck.f24671c).intValue(), 5, i, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f24551a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public String m34284a(String str) {
        JSONObject jSONObject = this.f24551a;
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
    public JSONArray m34280b(String str) {
        JSONObject jSONObject = this.f24551a;
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
                Set m34283a = m34283a(hashSet);
                if (m34283a == null || m34283a.size() <= 0) {
                    return null;
                }
                return new JSONArray((Collection) m34283a);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public boolean m34282a(Set set, String str) {
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

    /* renamed from: a */
    public Set m34283a(Set set) {
        if (set != null) {
            try {
                if (set.size() > 0) {
                    HashSet hashSet = new HashSet();
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (!m34282a(set, str)) {
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

    /* renamed from: a */
    public JSONObject m34281a(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getString(i);
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

    /* renamed from: a */
    public JSONObject m34285a() {
        return this.f24551a;
    }
}
