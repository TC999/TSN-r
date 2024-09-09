package cn.jiguang.cl;

import android.content.Context;
import android.content.SharedPreferences;
import java.security.SecureRandom;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static SharedPreferences f3456a;

    private static long a(long j4) {
        return (j4 + (j4 % 2 == 0 ? 1L : 2L)) % 32767;
    }

    private static long a(Context context, long j4) {
        long j5 = c(context).getLong("next_rid", j4);
        if (j5 != j4) {
            long a4 = a(j5);
            c(context).edit().putLong("next_rid", a4).apply();
            return a4;
        }
        return j5;
    }

    public static void a(Context context) {
        f3456a = context.getSharedPreferences("cn.jpush.preferences.support.rid", 0);
    }

    public static synchronized long b(Context context) {
        long a4;
        synchronized (e.class) {
            a4 = a(context, -1L);
            if (a4 == -1) {
                a4 = a(Math.abs(new SecureRandom().nextInt(32767)));
                c(context).edit().putLong("next_rid", a4).apply();
            }
        }
        return a4;
    }

    private static SharedPreferences c(Context context) {
        if (f3456a == null) {
            a(context);
        }
        return f3456a;
    }
}
