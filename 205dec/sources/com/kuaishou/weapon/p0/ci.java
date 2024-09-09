package com.kuaishou.weapon.p0;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ci {

    /* renamed from: a  reason: collision with root package name */
    private Context f38162a;

    /* renamed from: b  reason: collision with root package name */
    private int f38163b;

    public ci(Context context, int i4) {
        this.f38162a = context;
        this.f38163b = i4;
    }

    public JSONObject a() {
        long currentTimeMillis;
        JSONObject jSONObject;
        JSONArray a4;
        try {
            currentTimeMillis = System.currentTimeMillis();
            jSONObject = new JSONObject();
        } catch (Throwable unused) {
        }
        if (WeaponHI.as) {
            h a5 = h.a(this.f38162a, "re_po_rt");
            int b4 = a5.b("plc001_al_s", 0);
            boolean e4 = a5.e("a1_p_s_p_s");
            boolean e5 = a5.e("a1_p_s_p_s_c_b");
            if (b4 == 1 && ((e4 || e5) && (a4 = new w(this.f38162a).a(0)) != null)) {
                jSONObject.put("10000", a4);
                try {
                    jSONObject.put("11301", bh.c(com.kwad.sdk.f.b.Is().Ir()));
                    jSONObject.put("11302", bh.c(com.kwad.sdk.f.b.Is().getSdkVersion()));
                    jSONObject.put("11303", bh.c(com.kwad.sdk.f.b.Is().getAppId()));
                } catch (Throwable unused2) {
                }
                jSONObject.put("11007", System.currentTimeMillis() - currentTimeMillis);
                jSONObject.put("11017", jSONObject.toString().length());
                return jSONObject;
            }
            return null;
        }
        return null;
    }

    public String a(String str) {
        JSONObject a4;
        try {
            JSONObject a5 = new cm(str, ck.f38176l).a(this.f38162a);
            if (a5 == null || (a4 = a()) == null) {
                return null;
            }
            a5.put("module_section", a4);
            return a5.toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
