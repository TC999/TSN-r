package cn.jpush.android.r;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import cn.jpush.android.ad.m;
import cn.jpush.android.helper.Logger;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<Integer, HashMap<Integer, cn.jpush.android.t.a>> f4311a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private static HashMap<Integer, HashMap<Integer, cn.jpush.android.t.a>> f4312b = new HashMap<>();

    private static long a(Context context) {
        long j4 = 0;
        try {
            String b4 = cn.jpush.android.p.a.b(context);
            if (!TextUtils.isEmpty(b4)) {
                String[] split = b4.split(",");
                long parseLong = Long.parseLong(split[0]);
                int parseInt = Integer.parseInt(split[1]);
                Logger.d("InAppHelper", "checkUnionTopBannerTime, topBanner exposureTime: " + parseLong + ", server exposureTime: " + parseInt);
                long currentTimeMillis = System.currentTimeMillis() - (parseLong + 3000);
                if (currentTimeMillis < 0) {
                    currentTimeMillis = 0;
                }
                long j5 = parseInt;
                if (currentTimeMillis < j5) {
                    j4 = j5 - currentTimeMillis;
                }
                Logger.d("InAppHelper", "checkUnionTopBannerTime, should delay time: " + j4 + ", leftTime: " + currentTimeMillis);
            }
        } catch (Throwable unused) {
        }
        return j4;
    }

    public static long a(Context context, long j4, boolean z3) {
        String str;
        long max = Math.max(System.currentTimeMillis() - cn.jpush.android.s.a.a(), 0L);
        long max2 = Math.max(j4, 0L);
        long a4 = a(context);
        long j5 = z3 ? max2 > max ? max2 - max : 0L : max2;
        long max3 = Math.max(a4, j5);
        Logger.d("InAppHelper", "getDelayDisplayTime - stayForegroundTime: " + max + ", delayDisTime: " + max2 + ", unionDelayTime: " + a4 + ", foreDelayTime: " + j5 + ", realDelayTime: " + max3);
        if (max3 > 0) {
            str = "notify inapp should delay to show, delay time: " + max3 + ", server delay time: " + max2;
        } else {
            str = "notify inapp display directory, stay foreground time: " + max + ", server delay time: " + max2;
        }
        Logger.d("InAppHelper", str);
        return max3;
    }

    public static cn.jpush.android.t.a a(Context context, int i4) {
        HashMap<Integer, cn.jpush.android.t.a> hashMap;
        HashMap<Integer, HashMap<Integer, cn.jpush.android.t.a>> hashMap2;
        String str;
        int i5 = context.getResources().getConfiguration().orientation;
        Logger.d("InAppHelper", "current orientation state: " + i5 + " type=" + i4);
        if (i5 < 0) {
            str = "[getLayoutConfig] get screen orientation failed, curOrientation: " + i5;
        } else {
            if (i5 == 2) {
                hashMap2 = f4312b;
            } else if (i5 == 1) {
                hashMap2 = f4311a;
            } else {
                hashMap = null;
                Logger.d("InAppHelper", "current map: " + hashMap + " type=" + i4);
                if (hashMap == null && hashMap.size() != 0) {
                    return hashMap.get(Integer.valueOf(i5));
                }
                str = "current is null ";
            }
            hashMap = hashMap2.get(Integer.valueOf(i4));
            Logger.d("InAppHelper", "current map: " + hashMap + " type=" + i4);
            if (hashMap == null) {
            }
            str = "current is null ";
        }
        Logger.d("InAppHelper", str);
        return null;
    }

    public static void a(Context context, long j4) {
        cn.jpush.android.p.a.a(context, System.currentTimeMillis() + "," + (j4 * 1000));
    }

    public static void a(Context context, cn.jpush.android.d.d dVar, int i4) {
        f4311a.clear();
        f4312b.clear();
        cn.jpush.android.t.a b4 = b(context, dVar, i4);
        HashMap<Integer, cn.jpush.android.t.a> hashMap = new HashMap<>();
        hashMap.put(1, b4);
        f4311a.put(Integer.valueOf(i4), hashMap);
        cn.jpush.android.t.a c4 = c(context, dVar, i4);
        HashMap<Integer, cn.jpush.android.t.a> hashMap2 = new HashMap<>();
        hashMap2.put(2, c4);
        f4312b.put(Integer.valueOf(i4), hashMap2);
    }

    public static long b(Context context, long j4) {
        try {
            long a4 = cn.jpush.android.p.a.a(context);
            Logger.d("InAppHelper", "getIntervalTime lastShowMessageTime=" + a4);
            if (a4 <= 0) {
                return j4;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long abs = Math.abs(currentTimeMillis - a4);
            Logger.d("InAppHelper", "getIntervalTime currentTimeMillis=" + currentTimeMillis);
            Logger.d("InAppHelper", "getIntervalTime diff=" + abs);
            if (abs > j4) {
                Logger.d("InAppHelper", "getIntervalTime return value= 0");
                return 0L;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getIntervalTime return value= ");
            long j5 = j4 - abs;
            sb.append(j5);
            Logger.d("InAppHelper", sb.toString());
            return j5;
        } catch (Throwable unused) {
            Logger.d("InAppHelper", "getIntervalTime return intervalTime= " + j4);
            return j4;
        }
    }

    private static cn.jpush.android.t.a b(Context context, cn.jpush.android.d.d dVar, int i4) {
        boolean c4 = cn.jpush.android.u.b.c(i4);
        if (40 == i4 || c4) {
            DisplayMetrics a4 = m.a(context);
            cn.jpush.android.t.a b4 = new cn.jpush.android.t.a().a(Float.valueOf(0.3f)).b(Float.valueOf(0.3f)).a(Integer.valueOf((int) (a4.heightPixels * 0.5f))).b(Integer.valueOf((int) (a4.widthPixels * 0.9f))).e(-1).f(Integer.valueOf(c4 ? -2 : m.a(context, 94))).c(Integer.valueOf(dVar.aG == 0 ? 48 : 80)).d(65824).a(Integer.valueOf((int) (a4.heightPixels * 0.5f))).b(Integer.valueOf((int) (a4.widthPixels * 0.9f)));
            Boolean bool = Boolean.TRUE;
            return b4.a(true).a(bool).b(bool).b(true).a(dVar.ba * 1000).b(500.0f).c(500.0f);
        }
        return new cn.jpush.android.t.a().e(-1).f(-1);
    }

    private static cn.jpush.android.t.a c(Context context, cn.jpush.android.d.d dVar, int i4) {
        boolean c4 = cn.jpush.android.u.b.c(i4);
        if (40 == i4 || c4) {
            DisplayMetrics a4 = m.a(context);
            cn.jpush.android.t.a f4 = new cn.jpush.android.t.a().a(Float.valueOf(0.3f)).b(Float.valueOf(0.3f)).a(Integer.valueOf((int) (a4.heightPixels * 0.5f))).b(Integer.valueOf((int) (a4.widthPixels * 0.9f))).c(Integer.valueOf(dVar.aG == 0 ? 48 : 80)).d(65824).e(Integer.valueOf(a4.heightPixels)).f(Integer.valueOf(c4 ? -2 : m.a(context, 94)));
            Boolean bool = Boolean.TRUE;
            return f4.a(true).a(bool).b(bool).b(true).a(dVar.ba * 1000).b(500.0f).c(500.0f);
        }
        return new cn.jpush.android.t.a().e(-1).f(-1);
    }
}
