package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class cp {
    public static void a(Context context, String str) {
        try {
            a(context, str, null, false, true);
        } catch (Throwable unused) {
        }
    }

    public static void a(final Context context, String str, final String str2, final boolean z3, boolean z4) {
        JSONObject jSONObject;
        try {
            String str3 = cu.f38226a + cu.f38230e;
            String a4 = cv.a(context);
            if (!TextUtils.isEmpty(a4)) {
                if (cu.a() && str2 != null) {
                    str3 = str3 + "?logId=" + str2 + "&" + a4;
                } else {
                    str3 = str3 + "?" + a4;
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (z4) {
                jSONObject = new JSONObject();
                String c4 = new bn(context).c(str);
                if (!TextUtils.isEmpty(c4)) {
                    jSONObject.put("data", c4);
                }
            } else {
                jSONObject = new JSONObject(str);
            }
            l a5 = l.a(context);
            m mVar = new m(str3, jSONObject);
            mVar.a(WeaponHI.cookieData);
            mVar.b(WeaponHI.encryENV);
            a5.b(mVar, new j() { // from class: com.kuaishou.weapon.p0.cp.1
                @Override // com.kuaishou.weapon.p0.j
                public final void a(String str4) {
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    try {
                        if (str2.equals(ck.f38166b)) {
                            df.a(context).a(System.currentTimeMillis());
                        } else if (str2.equals(ck.f38167c)) {
                            df.a(context).a("es_a1_1_upl_time", System.currentTimeMillis());
                        } else if (str2.equals(ck.f38168d)) {
                            df.a(context).a("apl_a1_1_upl_time", System.currentTimeMillis());
                        } else if (str2.equals(ck.f38171g)) {
                            df.a(context).a("cpgc_a1_1_upl_time", System.currentTimeMillis());
                        } else if (str2.equals(ck.f38173i)) {
                            df.a(context).a("act_a1_1_upl_time", System.currentTimeMillis());
                        }
                    } catch (Exception unused) {
                    }
                }

                @Override // com.kuaishou.weapon.p0.j
                public final void b(String str4) {
                    if (z3) {
                        TextUtils.isEmpty(str2);
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
