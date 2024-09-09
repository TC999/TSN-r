package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class as extends dg {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f38037a;

    public as(Context context, int i4) {
        if (Engine.loadSuccess) {
            try {
                Engine engine = Engine.getInstance(context);
                int intValue = Integer.valueOf(ck.f38167c).intValue();
                String a4 = a(context);
                if (TextUtils.isEmpty(a4)) {
                    return;
                }
                String eopq = engine.eopq(intValue, 0, i4, a4);
                if (TextUtils.isEmpty(eopq)) {
                    return;
                }
                this.f38037a = new JSONObject(eopq);
            } catch (Throwable unused) {
            }
        }
    }

    public JSONObject a() {
        return this.f38037a;
    }

    public String b(String str) {
        JSONObject jSONObject = this.f38037a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                return !TextUtils.isEmpty(string) ? string.replace("\n", "").replace("\t", " ") : string;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public JSONArray c(String str) {
        JSONObject jSONObject = this.f38037a;
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

    public JSONObject d(String str) {
        JSONObject jSONObject = this.f38037a;
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

    public String e(String str) {
        JSONObject jSONObject = this.f38037a;
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

    public String a(String str) {
        JSONObject jSONObject = this.f38037a;
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    private String a(Context context) {
        try {
            StringBuilder sb = new StringBuilder();
            h a4 = h.a(context, "re_po_rt");
            sb.append(a4.b("plc001_r_rcl_da", 1));
            sb.append(a4.b("plc001_r_rcl_dv", 1));
            sb.append(a4.b("plc001_r_rcl_fr", 1));
            sb.append(a4.b("plc001_r_rcl_li", 1));
            sb.append(a4.b("plc001_r_rcl_em", 1));
            sb.append(a4.b("plc001_r_rcl_vp", 1));
            sb.append(a4.b("plc001_r_rcl_rcd", 1));
            sb.append(a4.b("plc001_r_rcl_re", 1));
            sb.append(a4.b("plc001_r_rcl_ud", 1));
            sb.append(a4.b("plc001_r_rcl_sc", 1));
            sb.append(a4.b("plc001_r_rcl_mc", 1));
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
