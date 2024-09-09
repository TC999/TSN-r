package com.bytedance.sdk.openadsdk.core.xv;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.openadsdk.core.ls;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private static volatile w f35630c;

    /* renamed from: w  reason: collision with root package name */
    private volatile SharedPreferences f35631w = com.bytedance.sdk.openadsdk.api.plugin.w.w(ls.getContext(), "sp_dynamic_tmpl_config", 0);

    public static w c() {
        if (f35630c == null) {
            synchronized (w.class) {
                if (f35630c == null) {
                    f35630c = new w();
                }
            }
        }
        return f35630c;
    }

    public void delete(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String w3 = w(str, null);
            if (TextUtils.isEmpty(w3)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(w3);
            if (jSONArray.length() > 0) {
                int i4 = 0;
                while (true) {
                    if (i4 >= jSONArray.length()) {
                        i4 = -1;
                        break;
                    }
                    JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                    if (optJSONObject != null && str2.equals(optJSONObject.getString("id"))) {
                        break;
                    }
                    i4++;
                }
                if (i4 != -1) {
                    jSONArray.remove(i4);
                    c(str, jSONArray.toString());
                }
            }
        } catch (Exception unused) {
        }
    }

    public void update(String str, com.bytedance.sdk.component.adexpress.c.xv.xv xvVar) {
        if (xvVar == null || xvVar.w() == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String w3 = w(str, null);
            JSONArray jSONArray = w3 == null ? new JSONArray() : new JSONArray(w3);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", xvVar.w());
            jSONObject.put("md5", xvVar.xv());
            jSONArray.put(jSONObject);
            c(str, jSONArray.toString());
        } catch (Exception unused) {
        }
    }

    public String w(String str, String str2) {
        try {
            if (sr.c().w()) {
                return com.bytedance.sdk.component.f.xv.c.w.w("sp_dynamic_tmpl_config", str, str2);
            }
            return this.f35631w.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public JSONArray c(final String str, int i4) {
        if (!sr.c().f(i4)) {
            return ls.w().a(str);
        }
        try {
            final String w3 = w(str, null);
            ev.w(new p("tmpl_updatetime") { // from class: com.bytedance.sdk.openadsdk.core.xv.w.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        boolean z3 = false;
                        Set<com.bytedance.sdk.component.adexpress.c.xv.w> c4 = com.bytedance.sdk.component.adexpress.c.w.w.c(str, false);
                        JSONArray jSONArray = new JSONArray();
                        if (c4 != null && c4.size() > 0) {
                            z3 = true;
                            for (com.bytedance.sdk.component.adexpress.c.xv.w wVar : c4) {
                                if (wVar != null) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("id", wVar.w());
                                    jSONObject.put("md5", wVar.xv());
                                    jSONArray.put(jSONObject);
                                }
                            }
                        }
                        if (!(w3 == null && z3) && jSONArray.toString().equals(w3)) {
                            return;
                        }
                        w.this.c(str, jSONArray.toString());
                    } catch (Exception unused) {
                    }
                }
            });
            if (TextUtils.isEmpty(w3)) {
                return null;
            }
            return new JSONArray(w3);
        } catch (Exception unused) {
            return null;
        }
    }

    public void c(String str, String str2) {
        try {
            if (sr.c().w()) {
                com.bytedance.sdk.component.f.xv.c.w.c("sp_dynamic_tmpl_config", str, str2);
            } else {
                SharedPreferences.Editor edit = this.f35631w.edit();
                edit.putString(str, str2);
                edit.apply();
            }
        } catch (Throwable unused) {
        }
    }
}
