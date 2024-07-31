package com.beizi.fusion.p073sm.p074a;

import android.util.Log;

/* renamed from: com.beizi.fusion.sm.a.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class OAIDLog {

    /* renamed from: a */
    private static boolean f11523a;

    /* renamed from: a */
    public static void m48130a(Object obj) {
        if (f11523a) {
            if (obj == null) {
                obj = "<null>";
            }
            Log.d("OAID", obj.toString());
        }
    }
}
