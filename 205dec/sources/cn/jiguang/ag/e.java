package cn.jiguang.ag;

import android.util.Pair;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<Object, Pair<Long, Integer>> f2199a = new HashMap<>();

    public static boolean a(Object obj) {
        return a(obj, 0L);
    }

    public static boolean a(Object obj, long j4) {
        return a(obj, j4, 0);
    }

    public static boolean a(Object obj, long j4, int i4) {
        int i5;
        Pair<Long, Integer> pair;
        if (j4 <= 0) {
            j4 = 3600000;
        }
        if (i4 <= 0) {
            i4 = Integer.MAX_VALUE;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (!f2199a.containsKey(obj) || (pair = f2199a.get(obj)) == null) {
                i5 = 0;
            } else {
                long longValue = ((Long) pair.first).longValue();
                i5 = ((Integer) pair.second).intValue();
                long abs = Math.abs(currentTimeMillis - longValue);
                cn.jiguang.w.a.b("ApiFrequency", "check api frequency, functionName: " + obj + "; callApiInternalTimeLimit: " + j4 + ", diffInternalTime: " + abs + "; callApiTimesLimit\uff1a " + i4 + ", currentApiCallTimes: " + i5);
                if (abs <= j4 || i5 >= i4) {
                    return true;
                }
            }
            f2199a.put(obj, new Pair<>(Long.valueOf(currentTimeMillis), Integer.valueOf(i5 + 1)));
        } catch (Throwable th) {
            cn.jiguang.w.a.f("ApiFrequency", "isFrequency failed: " + th.getMessage());
        }
        return false;
    }
}
