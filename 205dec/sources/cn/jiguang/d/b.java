package cn.jiguang.d;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.bq.d;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile Long f3571a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile Long f3572b;

    public static long a(Context context, long j4) {
        return (j4 + c(context)) / 1000;
    }

    public static boolean a(Context context) {
        String str;
        if (((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.x())).longValue() <= 0) {
            str = "isValidRegistered uid <= 0";
        } else if (!TextUtils.isEmpty((String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.y()))) {
            return true;
        } else {
            str = "isValidRegistered regId is empty";
        }
        d.a("SpHelper", str);
        return false;
    }

    public static long b(Context context) {
        return a(context, System.currentTimeMillis());
    }

    public static void b(Context context, long j4) {
        if (j4 > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            f3571a = Long.valueOf(j4);
            f3572b = Long.valueOf(currentTimeMillis);
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.E().a((cn.jiguang.g.a<Long>) Long.valueOf(j4)), cn.jiguang.g.a.D().a((cn.jiguang.g.a<Long>) Long.valueOf(currentTimeMillis)));
        }
    }

    public static long c(Context context) {
        if (f3571a == null || f3572b == null) {
            long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.D())).longValue();
            long longValue2 = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.E())).longValue();
            if (longValue == 0 || longValue2 == 0) {
                return 0L;
            }
            f3571a = Long.valueOf(longValue2);
            f3572b = Long.valueOf(longValue);
            return longValue2 - longValue;
        }
        return f3571a.longValue() - f3572b.longValue();
    }
}
