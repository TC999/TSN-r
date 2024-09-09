package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.content.Context;

/* compiled from: TTApmTagUtils.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class t {
    public static void a(Context context) {
        try {
            context.getSharedPreferences("tt_mediation_ppe_info", 0).edit().putString("tt_gromore_sdk_version", "2.9.2.1").commit();
        } catch (Throwable unused) {
        }
    }
}
