package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.cp */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7232cp {
    /* renamed from: a */
    public static void m34049a(Context context, String str) {
        try {
            m34048a(context, str, null, false, true);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static void m34048a(final Context context, String str, final String str2, final boolean z, boolean z2) {
        JSONObject jSONObject;
        try {
            String str3 = C7239cu.f24730a + C7239cu.f24734e;
            String m34030a = C7240cv.m34030a(context);
            if (!TextUtils.isEmpty(m34030a)) {
                if (C7239cu.m34032a() && str2 != null) {
                    str3 = str3 + "?logId=" + str2 + "&" + m34030a;
                } else {
                    str3 = str3 + "?" + m34030a;
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (z2) {
                jSONObject = new JSONObject();
                String m34153c = new C7198bn(context).m34153c(str);
                if (!TextUtils.isEmpty(m34153c)) {
                    jSONObject.put("data", m34153c);
                }
            } else {
                jSONObject = new JSONObject(str);
            }
            C7289l m33849a = C7289l.m33849a(context);
            C7291m c7291m = new C7291m(str3, jSONObject);
            c7291m.m33834a(WeaponHI.cookieData);
            c7291m.m33832b(WeaponHI.encryENV);
            m33849a.m33837b(c7291m, new InterfaceC7285j() { // from class: com.kuaishou.weapon.p0.cp.1
                @Override // com.kuaishou.weapon.p205p0.InterfaceC7285j
                /* renamed from: a */
                public final void mo33851a(String str4) {
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    try {
                        if (str2.equals(C7227ck.f24670b)) {
                            C7262df.m33986a(context).m33987a(System.currentTimeMillis());
                        } else if (str2.equals(C7227ck.f24671c)) {
                            C7262df.m33986a(context).m33984a(C7262df.f24878bj, System.currentTimeMillis());
                        } else if (str2.equals(C7227ck.f24672d)) {
                            C7262df.m33986a(context).m33984a(C7262df.f24877bi, System.currentTimeMillis());
                        } else if (str2.equals(C7227ck.f24675g)) {
                            C7262df.m33986a(context).m33984a(C7262df.f24881bm, System.currentTimeMillis());
                        } else if (str2.equals(C7227ck.f24677i)) {
                            C7262df.m33986a(context).m33984a(C7262df.f24876bh, System.currentTimeMillis());
                        }
                    } catch (Exception unused) {
                    }
                }

                @Override // com.kuaishou.weapon.p205p0.InterfaceC7285j
                /* renamed from: b */
                public final void mo33850b(String str4) {
                    if (z) {
                        TextUtils.isEmpty(str2);
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
