package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p205p0.jni.Engine;
import com.snail.antifake.deviceid.ShellAdbUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.as */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7175as extends C7263dg {

    /* renamed from: a */
    private JSONObject f24529a;

    public C7175as(Context context, int i) {
        if (Engine.loadSuccess) {
            try {
                Engine engine = Engine.getInstance(context);
                int intValue = Integer.valueOf(C7227ck.f24671c).intValue();
                String m34339a = m34339a(context);
                if (TextUtils.isEmpty(m34339a)) {
                    return;
                }
                String eopq = engine.eopq(intValue, 0, i, m34339a);
                if (TextUtils.isEmpty(eopq)) {
                    return;
                }
                this.f24529a = new JSONObject(eopq);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public JSONObject m34340a() {
        return this.f24529a;
    }

    /* renamed from: b */
    public String m34337b(String str) {
        JSONObject jSONObject = this.f24529a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                return !TextUtils.isEmpty(string) ? string.replace(ShellAdbUtils.f33810d, "").replace("\t", " ") : string;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: c */
    public JSONArray m34336c(String str) {
        JSONObject jSONObject = this.f24529a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (TextUtils.isEmpty(string) || string.length() <= 3) {
                    return null;
                }
                String replaceAll = string.replaceAll("\\n", "");
                if (!TextUtils.isEmpty(replaceAll)) {
                    string = replaceAll;
                }
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray.length() > 1) {
                    return jSONArray;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: d */
    public JSONObject m34335d(String str) {
        JSONObject jSONObject = this.f24529a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (TextUtils.isEmpty(string) || string.length() <= 2) {
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject(string);
                if (jSONObject2.length() > 1) {
                    return jSONObject2;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: e */
    public String m34334e(String str) {
        JSONObject jSONObject = this.f24529a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                if (string.length() > 2) {
                    return string;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public String m34338a(String str) {
        JSONObject jSONObject = this.f24529a;
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    private String m34339a(Context context) {
        try {
            StringBuilder sb = new StringBuilder();
            C7283h m33888a = C7283h.m33888a(context, "re_po_rt");
            sb.append(m33888a.m33878b(C7262df.f24842aa, 1));
            sb.append(m33888a.m33878b(C7262df.f24812X, 1));
            sb.append(m33888a.m33878b(C7262df.f24810V, 1));
            sb.append(m33888a.m33878b(C7262df.f24814Z, 1));
            sb.append(m33888a.m33878b(C7262df.f24843ab, 1));
            sb.append(m33888a.m33878b(C7262df.f24851aj, 1));
            sb.append(m33888a.m33878b(C7262df.f24813Y, 1));
            sb.append(m33888a.m33878b(C7262df.f24809U, 1));
            sb.append(m33888a.m33878b(C7262df.f24854am, 1));
            sb.append(m33888a.m33878b(C7262df.f24852ak, 1));
            sb.append(m33888a.m33878b(C7262df.f24853al, 1));
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
