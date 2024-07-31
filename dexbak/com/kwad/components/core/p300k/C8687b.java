package com.kwad.components.core.p300k;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p397e.C10331c;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.k.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8687b {
    /* renamed from: aa */
    public static boolean m30014aa(Context context) {
        boolean z;
        if (context == null) {
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_local_ad_force_active", 0);
        C8686a c8686a = new C8686a();
        if (sharedPreferences.contains("ksadsdk_local_ad_force_active_data")) {
            String string = sharedPreferences.getString("ksadsdk_local_ad_force_active_data", null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    c8686a.parseJson(new JSONObject(string));
                } catch (Exception e) {
                    C10331c.printStackTraceOnly(e);
                }
            }
            z = c8686a.m30016j(C10251d.m26547Ch(), C10251d.m26546Ci());
            C10331c.m26254d("LocalAdForceActiveHelper", "addCount contains success: " + z);
        } else {
            C10331c.m26254d("LocalAdForceActiveHelper", "addCount not contains");
            c8686a.m30015oI();
            z = true;
        }
        if (z) {
            sharedPreferences.edit().putString("ksadsdk_local_ad_force_active_data", c8686a.toJson().toString()).apply();
        }
        return z;
    }
}
