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
public class ba {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f38054a;

    public ba(Context context, int i4) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f38167c).intValue(), 2, i4 < 10 ? 10 : i4, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f38054a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f38054a;
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public JSONObject b(String str) {
        if (this.f38054a != null) {
            try {
                String a4 = a(str);
                if (TextUtils.isEmpty(a4) || a4.length() <= 3) {
                    return null;
                }
                return new JSONObject(a4);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public JSONArray c(String str) {
        JSONObject jSONObject = this.f38054a;
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

    public JSONObject d(String str) {
        if (this.f38054a != null) {
            try {
                String a4 = a(str);
                if (TextUtils.isEmpty(a4) || a4.length() <= 3) {
                    return null;
                }
                return a(new JSONObject(a4));
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public JSONObject a(String str, boolean z3) {
        if (this.f38054a != null) {
            try {
                String a4 = a(str);
                if (!TextUtils.isEmpty(a4) && a4.length() > 3) {
                    JSONObject jSONObject = new JSONObject(a4);
                    if (z3) {
                        Iterator<String> keys = jSONObject.keys();
                        boolean z4 = false;
                        while (keys.hasNext()) {
                            if (jSONObject.getInt(keys.next()) == 1) {
                                z4 = true;
                            }
                        }
                        if (z4) {
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

    public JSONObject a(JSONObject jSONObject) {
        try {
            String a4 = i.a("da4c6c97b9", "0702");
            String a5 = i.a("da4c709eb15f", "0702");
            JSONArray optJSONArray = jSONObject.optJSONArray(a4);
            JSONArray optJSONArray2 = jSONObject.optJSONArray(a5);
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
