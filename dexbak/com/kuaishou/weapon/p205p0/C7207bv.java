package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* renamed from: com.kuaishou.weapon.p0.bv */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7207bv {
    /* renamed from: a */
    public static String m34127a(Context context) {
        int i = 0;
        try {
            Intent m34124d = m34124d(context);
            if (m34124d != null) {
                i = (int) ((m34124d.getIntExtra("level", -1) / m34124d.getIntExtra("scale", -1)) * 100.0f);
            }
            return i + "%";
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static String m34126b(Context context) {
        try {
            int intExtra = m34124d(context).getIntExtra("plugged", -1);
            return intExtra != 1 ? intExtra != 2 ? intExtra != 4 ? "" : "Wireless charger" : "USB charger" : "AC charger";
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: c */
    public static int m34125c(Context context) {
        int i = -1;
        try {
            int intExtra = m34124d(context).getIntExtra("health", -1);
            i = 3;
            if (intExtra != 2) {
                if (intExtra != 3) {
                    if (intExtra != 4) {
                        if (intExtra != 5) {
                            return intExtra != 7 ? 6 : 1;
                        }
                        return 5;
                    }
                    return 2;
                }
                return 4;
            }
        } catch (Throwable unused) {
        }
        return i;
    }

    /* renamed from: d */
    private static Intent m34124d(Context context) {
        return context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }
}
