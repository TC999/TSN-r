package cn.jiguang.bt;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.bq.d;
import cn.jiguang.bx.e;
import cn.jiguang.bx.h;
import cn.jiguang.internal.JConstants;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f2891a;

    /* renamed from: b  reason: collision with root package name */
    public static int f2892b;

    public static void a(Context context) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 38, null, null, new Object[0]);
    }

    public static void a(Context context, int i4) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 57, null, null, Integer.valueOf(i4));
    }

    public static void a(Context context, long j4) {
        if (j4 > 0) {
            JCoreManager.onEvent(context, JConstants.SDK_TYPE, 37, null, null, Long.valueOf(j4));
        }
    }

    public static void a(Context context, long j4, String str, String str2) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 35, null, null, Long.valueOf(j4), str, str2);
    }

    public static void a(Context context, Bundle bundle) {
        if (bundle != null) {
            f2891a = bundle.getBoolean("foreground");
            int i4 = bundle.getInt("user_type");
            f2892b = i4;
            if (i4 == -1) {
                f2892b = f2891a ? 1 : 0;
            }
            d.c("JCoreManagerInternal", "changeForeGroundStat:" + f2891a + ", userActiveType:" + f2892b);
            if (f2891a) {
                if (h.a().f() >= 120) {
                    h.a().i();
                }
                cn.jiguang.e.a.b().b(context);
            }
            e.a(context, "foreground_state_change", bundle);
        }
    }

    public static void a(Context context, Object obj) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 39, null, null, obj);
    }

    public static void a(Context context, String str) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 36, null, null, str);
    }

    public static void a(Context context, String str, int i4, int i5, long j4, long j5, byte[] bArr) {
        a(context, str, i4, i5, j4, j5, bArr, true);
    }

    private static void a(Context context, String str, int i4, int i5, long j4, long j5, byte[] bArr, boolean z3) {
        Bundle bundle = new Bundle();
        bundle.putInt("cmd", i4);
        bundle.putInt("ver", i5);
        bundle.putLong("rid", j4);
        bundle.putLong("timeout", j5);
        bundle.putByteArray("body", bArr);
        JCoreManager.onEvent(context, str, z3 ? 17 : 16, null, bundle, new Object[0]);
    }

    public static void a(Context context, String str, long j4) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 44, null, null, str, Long.valueOf(j4));
    }

    public static void a(Runnable runnable, int... iArr) {
        JCoreManager.onEvent(null, null, 75, null, null, runnable);
    }

    public static void a(String str) {
        JCoreManager.onEvent(null, null, 13, str, null, new Object[0]);
    }

    public static Map b(Context context) {
        Object onEvent = JCoreManager.onEvent(context, JConstants.SDK_TYPE, 45, null, null, new Object[0]);
        if (onEvent instanceof Map) {
            return (Map) onEvent;
        }
        return null;
    }

    public static void b(Context context, int i4) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 51, "", null, Integer.valueOf(i4));
    }

    public static void b(Context context, String str, int i4, int i5, long j4, long j5, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putInt("cmd", i4);
        bundle.putInt("ver", i5);
        bundle.putLong("rid", j4);
        bundle.putLong("timeout", 0L);
        bundle.putByteArray("body", bArr);
        bundle.putLong("uid", j5);
        JCoreManager.onEvent(context, str, 59, null, bundle, new Object[0]);
    }

    public static void b(Runnable runnable, int... iArr) {
        JCoreManager.onEvent(null, null, 77, null, null, runnable);
    }

    public static int c(Context context) {
        Object onEvent = JCoreManager.onEvent(context, JConstants.SDK_TYPE, 47, null, null, new Object[0]);
        if (onEvent instanceof Integer) {
            return ((Integer) onEvent).intValue();
        }
        return 1;
    }

    public static void c(Runnable runnable, int... iArr) {
        JCoreManager.onEvent(null, null, 76, null, null, runnable);
    }

    public static void d(Context context) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 48, null, null, new Object[0]);
    }
}
