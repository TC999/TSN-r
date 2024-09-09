package cn.jiguang.ar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: i  reason: collision with root package name */
    private static boolean f2371i;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f2372j;

    /* renamed from: k  reason: collision with root package name */
    private static boolean f2373k;

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<Integer> f2363a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public static ArrayList<Integer> f2364b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public static ArrayList<Integer> f2365c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public static ArrayList<Integer> f2366d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public static ArrayList<Integer> f2367e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public static int f2368f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static int f2369g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static int f2370h = 0;

    /* renamed from: l  reason: collision with root package name */
    private static AtomicInteger f2374l = new AtomicInteger(0);

    static {
        f2364b.add(2002);
        f2364b.add(2001);
        f2364b.add(2000);
        f2364b.add(2004);
        f2364b.add(2003);
        f2364b.add(2005);
        f2364b.add(2006);
        f2364b.add(2007);
        f2364b.add(2008);
        f2364b.add(2009);
        f2364b.add(2010);
        f2364b.add(2011);
        f2364b.add(2012);
        f2364b.add(2013);
        f2363a.add(1001);
        f2363a.add(1000);
        f2363a.add(1007);
        f2363a.add(1003);
        f2363a.add(1005);
        f2363a.add(1008);
        f2363a.add(1006);
        f2363a.add(1010);
        f2363a.add(1012);
        f2363a.add(1013);
        f2365c.add(3006);
        f2365c.add(3008);
        f2365c.add(3003);
        f2365c.add(3002);
        f2365c.add(3004);
        f2365c.add(3001);
        f2365c.add(3012);
        f2365c.add(3013);
        f2365c.add(3000);
        f2365c.add(3007);
        f2365c.add(3005);
        f2365c.add(3011);
        f2365c.add(3010);
        f2365c.add(3009);
        f2365c.add(3014);
        f2365c.add(3015);
        f2365c.add(3016);
        f2365c.add(3017);
    }

    public static synchronized void a() {
        synchronized (b.class) {
            try {
                f2366d.clear();
                f2367e.clear();
                f2371i = b();
                f2372j = d();
                f2373k = c();
                cn.jiguang.w.a.b("JDataConfigManager", "updateCollectConfig isPluginJPus=" + f2371i + " isPluginJOperate=" + f2372j + " isPluginVerification=" + f2373k);
                if (f2371i) {
                    f2366d.addAll(f2363a);
                }
                if (f2372j) {
                    f2366d.addAll(f2364b);
                }
                if (f2373k) {
                    f2366d.addAll(f2365c);
                }
                cn.jiguang.w.a.b("JDataConfigManager", "updateCollectConfig default mDisableDatas=" + f2367e);
                cn.jiguang.w.a.b("JDataConfigManager", "updateCollectConfig default mEnableDatas=" + f2366d);
            } catch (Throwable unused) {
            }
        }
    }

    private static void a(int i4) {
        String valueOf = String.valueOf(i4);
        if (valueOf.startsWith(String.valueOf(1000).substring(0, 1))) {
            f2368f = i4;
        } else if (valueOf.startsWith(String.valueOf(2000).substring(0, 1))) {
            f2369g = i4;
        } else if (valueOf.startsWith(String.valueOf(3000).substring(0, 1))) {
            f2370h = i4;
        }
    }

    public static synchronized void a(List<Integer> list, List<Integer> list2) {
        synchronized (b.class) {
            try {
                f2366d.clear();
                f2367e.clear();
                if (list2 == null) {
                    list2 = new ArrayList<>();
                }
                if (list == null) {
                    list = new ArrayList<>();
                }
                HashSet<Integer> hashSet = new HashSet(list2);
                HashSet<Integer> hashSet2 = new HashSet(list);
                if (f2366d.isEmpty() && f2367e.isEmpty()) {
                    if (f2371i) {
                        hashSet.addAll(f2363a);
                    }
                    if (f2372j) {
                        hashSet.addAll(f2364b);
                    }
                    if (f2373k) {
                        hashSet.addAll(f2365c);
                    }
                } else {
                    hashSet.addAll(f2366d);
                    hashSet2.addAll(f2367e);
                }
                f2366d.clear();
                f2367e.clear();
                for (Integer num : hashSet2) {
                    int intValue = num.intValue();
                    if (!list2.contains(Integer.valueOf(intValue))) {
                        f2367e.add(Integer.valueOf(intValue));
                    }
                }
                for (Integer num2 : hashSet) {
                    int intValue2 = num2.intValue();
                    if (!list.contains(Integer.valueOf(intValue2))) {
                        f2366d.add(Integer.valueOf(intValue2));
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized boolean a(Object obj) {
        synchronized (b.class) {
            try {
                f2368f = -1;
                f2369g = -1;
                f2370h = -1;
                if (obj instanceof List) {
                    for (Integer num : (List) obj) {
                        a(num.intValue());
                    }
                } else {
                    a(((Integer) obj).intValue());
                }
                if (f2371i && !f2363a.contains(Integer.valueOf(f2368f))) {
                    cn.jiguang.w.a.a(10000, "JDataConfigManager", "isPluginJPush is true,not can control");
                    return false;
                } else if (f2372j && !f2364b.contains(Integer.valueOf(f2369g))) {
                    cn.jiguang.w.a.a(10000, "JDataConfigManager", "isIsPluginJOperate is true,not can control");
                    return false;
                } else if (!f2373k || f2365c.contains(Integer.valueOf(f2370h))) {
                    return true;
                } else {
                    cn.jiguang.w.a.a(10000, "JDataConfigManager", "isPluginVerification is true,not can control");
                    return false;
                }
            } catch (Throwable th) {
                cn.jiguang.w.a.b("JDataConfigManager", "isUserCanControlData throwable=" + th);
                return false;
            }
        }
    }

    private static boolean b() {
        try {
            if ((f2374l.intValue() & 1) != 0) {
                return f2371i;
            }
            f2374l.addAndGet(1);
            Class.forName("cn.jpush.android.api.JPushInterface");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static boolean c() {
        try {
            if ((f2374l.intValue() & 64) != 0) {
                return f2373k;
            }
            f2374l.addAndGet(64);
            Class.forName("cn.jiguang.verifysdk.api.JVerificationInterface");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static boolean d() {
        try {
            if ((f2374l.intValue() & 2048) != 0) {
                return f2372j;
            }
            f2374l.addAndGet(2048);
            Class.forName("cn.jiguang.joperate.api.JOperateInterface");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
