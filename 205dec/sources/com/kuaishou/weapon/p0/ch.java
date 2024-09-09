package com.kuaishou.weapon.p0;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ch {

    /* renamed from: a  reason: collision with root package name */
    private Context f38160a;

    /* renamed from: b  reason: collision with root package name */
    private int f38161b;

    public ch(Context context, int i4) {
        this.f38160a = context;
        this.f38161b = i4;
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (h.a(this.f38160a, "re_po_rt").b("plc001_act_s", 1) == 1) {
                try {
                    JSONArray a4 = new x().a(this.f38160a);
                    if (a4 != null && a4.length() > 0) {
                        jSONObject.put("10000", a4);
                        jSONObject.put("11301", bh.c(com.kwad.sdk.f.b.Is().Ir()));
                        jSONObject.put("11302", bh.c(com.kwad.sdk.f.b.Is().getSdkVersion()));
                        jSONObject.put("11303", bh.c(com.kwad.sdk.f.b.Is().getAppId()));
                    }
                } catch (Throwable unused) {
                }
                return jSONObject;
            }
            return null;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public String a(String str) {
        JSONObject a4;
        try {
            JSONObject a5 = new cm(str, ck.f38176l).a(this.f38160a);
            if (a5 != null && (a4 = a()) != null && a4.length() != 0) {
                a5.put("module_section", a4);
                return a5.toString();
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
