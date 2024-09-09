package com.bytedance.adsdk.w.w.w.c;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class m implements r0.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f26460a;

    public m(String str) {
        this.f26460a = str;
    }

    private Object e(String[] strArr, int i4, JSONObject jSONObject) {
        Object opt;
        if (strArr != null && strArr.length > 0 && i4 < strArr.length && jSONObject != null) {
            String str = strArr[i4];
            int indexOf = str.indexOf("[");
            int indexOf2 = str.indexOf("]");
            if (indexOf >= 0 && indexOf2 >= 0 && indexOf <= indexOf2) {
                String substring = str.substring(0, indexOf);
                try {
                    int parseInt = Integer.parseInt(str.substring(indexOf + 1, indexOf2));
                    Object opt2 = jSONObject.opt(substring);
                    opt = opt2 instanceof JSONArray ? ((JSONArray) opt2).opt(parseInt) : null;
                } catch (NumberFormatException e4) {
                    e4.printStackTrace();
                    return null;
                }
            } else {
                opt = jSONObject.opt(str);
            }
            if (i4 == strArr.length - 1) {
                return opt;
            }
            if (opt instanceof String) {
                try {
                    return e(strArr, i4 + 1, new JSONObject((String) opt));
                } catch (JSONException e5) {
                    e5.printStackTrace();
                    return opt;
                }
            } else if (opt instanceof JSONObject) {
                return e(strArr, i4 + 1, (JSONObject) opt);
            }
        }
        return null;
    }

    public Object c(Map<String, JSONObject> map) {
        Object d4;
        if (map == null || map.size() <= 0 || (d4 = d(this.f26460a, map.get("default_key"))) == JSONObject.NULL) {
            return null;
        }
        return d4;
    }

    public Object d(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return e(str.split("\\."), 0, jSONObject);
    }

    public String toString() {
        return "VariableNode [literals=" + this.f26460a + "]";
    }

    public String w() {
        return this.f26460a;
    }

    public p0.a c() {
        return com.bytedance.adsdk.w.w.sr.f.VARIABLE;
    }
}
