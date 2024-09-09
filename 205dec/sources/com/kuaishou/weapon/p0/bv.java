package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class bv {
    public static String a(Context context) {
        int i4 = 0;
        try {
            Intent d4 = d(context);
            if (d4 != null) {
                i4 = (int) ((d4.getIntExtra("level", -1) / d4.getIntExtra("scale", -1)) * 100.0f);
            }
            return i4 + "%";
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(Context context) {
        try {
            int intExtra = d(context).getIntExtra("plugged", -1);
            return intExtra != 1 ? intExtra != 2 ? intExtra != 4 ? "" : "Wireless charger" : "USB charger" : "AC charger";
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int c(Context context) {
        int i4 = -1;
        try {
            int intExtra = d(context).getIntExtra("health", -1);
            i4 = 3;
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
        return i4;
    }

    private static Intent d(Context context) {
        return context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }
}
