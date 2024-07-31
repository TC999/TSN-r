package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.cg */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7222cg {
    /* renamed from: a */
    public static void m34091a(final Context context, String str, String str2, boolean z) {
        JSONObject jSONObject;
        try {
            String str3 = C7239cu.f24730a + C7239cu.f24735f;
            String m34030a = C7240cv.m34030a(context);
            if (!TextUtils.isEmpty(m34030a)) {
                if (C7239cu.m34032a() && str2 != null) {
                    str3 = str3 + "?logId=" + str2 + "&" + m34030a;
                } else {
                    str3 = str3 + "?" + m34030a;
                }
            }
            String str4 = str3;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (z) {
                jSONObject = new JSONObject();
                String m34153c = new C7198bn(context).m34153c(str);
                if (!TextUtils.isEmpty(m34153c)) {
                    jSONObject.put("data", m34153c);
                }
            } else {
                jSONObject = new JSONObject(str);
            }
            C7292n.m33830a().m33828a(new RunnableC7287k(context, WeaponHI.cookieData, WeaponHI.encryENV, str4, jSONObject, new InterfaceC7285j() { // from class: com.kuaishou.weapon.p0.cg.1
                @Override // com.kuaishou.weapon.p205p0.InterfaceC7285j
                /* renamed from: a */
                public final void mo33851a(String str5) {
                    C7222cg.m34092a(context, str5);
                }

                @Override // com.kuaishou.weapon.p205p0.InterfaceC7285j
                /* renamed from: b */
                public final void mo33850b(String str5) {
                }
            }));
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static void m34092a(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(CommonNetImpl.RESULT, 0) == 1) {
                JSONObject jSONObject2 = new JSONObject(new C7198bn(context).m34157a(jSONObject.getString("dataRsp")));
                String string = jSONObject2.getString("conjure");
                if (jSONObject2.getInt("status") == 1) {
                    C7209bx.m34120a(context, string);
                    C7209bx.m34118b(context, string);
                }
            }
        } catch (Exception unused) {
        }
    }
}
