package com.kuaishou.weapon.p205p0;

import android.content.Context;
import com.kwad.sdk.p433f.C10758b;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.ci */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7225ci {

    /* renamed from: a */
    private Context f24663a;

    /* renamed from: b */
    private int f24664b;

    public C7225ci(Context context, int i) {
        this.f24663a = context;
        this.f24664b = i;
    }

    /* renamed from: a */
    public JSONObject m34088a() {
        long currentTimeMillis;
        JSONObject jSONObject;
        JSONArray m33726a;
        try {
            currentTimeMillis = System.currentTimeMillis();
            jSONObject = new JSONObject();
        } catch (Throwable unused) {
        }
        if (WeaponHI.f24463as) {
            C7283h m33888a = C7283h.m33888a(this.f24663a, "re_po_rt");
            int m33878b = m33888a.m33878b(C7262df.f24903o, 0);
            boolean m33867e = m33888a.m33867e("a1_p_s_p_s");
            boolean m33867e2 = m33888a.m33867e("a1_p_s_p_s_c_b");
            if (m33878b == 1 && ((m33867e || m33867e2) && (m33726a = new C7309w(this.f24663a).m33726a(0)) != null)) {
                jSONObject.put("10000", m33726a);
                try {
                    jSONObject.put("11301", C7191bh.m34254c(C10758b.m24900Is().mo23999Ir()));
                    jSONObject.put("11302", C7191bh.m34254c(C10758b.m24900Is().getSdkVersion()));
                    jSONObject.put("11303", C7191bh.m34254c(C10758b.m24900Is().getAppId()));
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

    /* renamed from: a */
    public String m34087a(String str) {
        JSONObject m34088a;
        try {
            JSONObject m34081a = new C7229cm(str, C7227ck.f24680l).m34081a(this.f24663a);
            if (m34081a == null || (m34088a = m34088a()) == null) {
                return null;
            }
            m34081a.put("module_section", m34088a);
            return m34081a.toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
