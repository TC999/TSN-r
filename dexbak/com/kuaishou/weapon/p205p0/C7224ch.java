package com.kuaishou.weapon.p205p0;

import android.content.Context;
import com.kwad.sdk.p433f.C10758b;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.ch */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7224ch {

    /* renamed from: a */
    private Context f24661a;

    /* renamed from: b */
    private int f24662b;

    public C7224ch(Context context, int i) {
        this.f24661a = context;
        this.f24662b = i;
    }

    /* renamed from: a */
    public JSONObject m34090a() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (C7283h.m33888a(this.f24661a, "re_po_rt").m33878b(C7262df.f24913y, 1) == 1) {
                try {
                    JSONArray m33722a = new C7310x().m33722a(this.f24661a);
                    if (m33722a != null && m33722a.length() > 0) {
                        jSONObject.put("10000", m33722a);
                        jSONObject.put("11301", C7191bh.m34254c(C10758b.m24900Is().mo23999Ir()));
                        jSONObject.put("11302", C7191bh.m34254c(C10758b.m24900Is().getSdkVersion()));
                        jSONObject.put("11303", C7191bh.m34254c(C10758b.m24900Is().getAppId()));
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

    /* renamed from: a */
    public String m34089a(String str) {
        JSONObject m34090a;
        try {
            JSONObject m34081a = new C7229cm(str, C7227ck.f24680l).m34081a(this.f24661a);
            if (m34081a != null && (m34090a = m34090a()) != null && m34090a.length() != 0) {
                m34081a.put("module_section", m34090a);
                return m34081a.toString();
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
