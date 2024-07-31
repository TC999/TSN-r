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

/* renamed from: com.kuaishou.weapon.p0.ba */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7184ba {

    /* renamed from: a */
    private JSONObject f24546a;

    public C7184ba(Context context, int i) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(C7227ck.f24671c).intValue(), 2, i < 10 ? 10 : i, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f24546a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public String m34303a(String str) {
        JSONObject jSONObject = this.f24546a;
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
    public JSONObject m34298b(String str) {
        if (this.f24546a != null) {
            try {
                String m34303a = m34303a(str);
                if (TextUtils.isEmpty(m34303a) || m34303a.length() <= 3) {
                    return null;
                }
                return new JSONObject(m34303a);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: c */
    public JSONArray m34297c(String str) {
        JSONObject jSONObject = this.f24546a;
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
                Set m34301a = m34301a(hashSet);
                if (m34301a == null || m34301a.size() <= 0) {
                    return null;
                }
                return new JSONArray((Collection) m34301a);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: d */
    public JSONObject m34296d(String str) {
        if (this.f24546a != null) {
            try {
                String m34303a = m34303a(str);
                if (TextUtils.isEmpty(m34303a) || m34303a.length() <= 3) {
                    return null;
                }
                return m34299a(new JSONObject(m34303a));
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public JSONObject m34302a(String str, boolean z) {
        if (this.f24546a != null) {
            try {
                String m34303a = m34303a(str);
                if (!TextUtils.isEmpty(m34303a) && m34303a.length() > 3) {
                    JSONObject jSONObject = new JSONObject(m34303a);
                    if (z) {
                        Iterator<String> keys = jSONObject.keys();
                        boolean z2 = false;
                        while (keys.hasNext()) {
                            if (jSONObject.getInt(keys.next()) == 1) {
                                z2 = true;
                            }
                        }
                        if (z2) {
                            return jSONObject;
                        }
                        return null;
                    }
                    return jSONObject;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: a */
    public boolean m34300a(Set set, String str) {
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
    public Set m34301a(Set set) {
        if (set != null) {
            try {
                if (set.size() > 0) {
                    HashSet hashSet = new HashSet();
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (!m34300a(set, str)) {
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
    public JSONObject m34299a(JSONObject jSONObject) {
        try {
            String m33864a = C7284i.m33864a("da4c6c97b9", "0702");
            String m33864a2 = C7284i.m33864a("da4c709eb15f", "0702");
            JSONArray optJSONArray = jSONObject.optJSONArray(m33864a);
            JSONArray optJSONArray2 = jSONObject.optJSONArray(m33864a2);
            JSONObject jSONObject2 = new JSONObject();
            if (optJSONArray != null && optJSONArray.length() == 3) {
                jSONObject2.put("0", optJSONArray.get(2));
            }
            if (optJSONArray2 != null && optJSONArray2.length() == 3) {
                jSONObject2.put("1", optJSONArray2.get(2));
            }
            if (jSONObject2.length() > 0) {
                return jSONObject2;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
