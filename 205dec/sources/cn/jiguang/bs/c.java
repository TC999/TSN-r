package cn.jiguang.bs;

import android.text.TextUtils;
import java.io.File;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f2844a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f2845b;

    /* renamed from: c  reason: collision with root package name */
    private File f2846c;

    /* renamed from: d  reason: collision with root package name */
    private JSONObject f2847d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2848e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2849f;

    private c(File file, JSONObject jSONObject, JSONObject jSONObject2, boolean z3) {
        this.f2846c = file;
        this.f2847d = jSONObject;
        this.f2845b = jSONObject2;
        this.f2844a = file.length();
        this.f2849f = z3;
        this.f2848e = z3;
    }

    public static c a(File file, Set<String> set) {
        JSONObject a4 = a(file);
        if (a4 != null) {
            return new c(file, a4, cn.jiguang.f.d.a(a4, set), false);
        }
        cn.jiguang.f.c.a(file);
        return null;
    }

    public static c a(File file, JSONObject jSONObject) {
        JSONObject a4 = a(file);
        if (a4 != null) {
            return new c(file, a4, jSONObject, true);
        }
        cn.jiguang.f.c.a(file);
        return null;
    }

    public static JSONObject a(File file) {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        try {
            String d4 = cn.jiguang.f.c.d(file);
            if (TextUtils.isEmpty(d4) || (optJSONArray = (jSONObject = new JSONObject(d4)).optJSONArray("content")) == null) {
                return null;
            }
            if (optJSONArray.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean a(c cVar, File file) {
        boolean z3 = true;
        if (cVar != null) {
            try {
                if (this.f2844a + cVar.f2844a <= 40960) {
                    JSONArray jSONArray = this.f2847d.getJSONArray("content");
                    JSONArray jSONArray2 = cVar.f2847d.getJSONArray("content");
                    for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                        jSONArray.put(jSONArray2.getJSONObject(i4));
                    }
                    this.f2844a += cVar.f2844a;
                    this.f2848e = true;
                    cn.jiguang.f.c.a(cVar.f2846c);
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, this.f2846c.getName());
        if (this.f2849f) {
            cn.jiguang.f.d.a(this.f2847d, this.f2845b);
        }
        if (this.f2846c.equals(file2)) {
            z3 = false;
        }
        if (this.f2848e || z3) {
            cn.jiguang.f.c.c(file2, this.f2847d.toString());
        }
        if (z3) {
            cn.jiguang.f.c.a(this.f2846c);
        }
        return false;
    }
}
