package cn.jiguang.ar;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.ArrayMap;
import cn.jiguang.ah.d;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@TargetApi(19)
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, Integer> f2352a;

    /* renamed from: d  reason: collision with root package name */
    private static Map<Integer, Boolean> f2353d;

    /* renamed from: e  reason: collision with root package name */
    private static ArrayList<Integer> f2354e;

    /* renamed from: f  reason: collision with root package name */
    private static Map<Integer, Integer[]> f2355f;

    /* renamed from: g  reason: collision with root package name */
    private static ArrayList<Integer> f2356g;

    /* renamed from: h  reason: collision with root package name */
    private static ArrayList<Integer> f2357h;

    /* renamed from: i  reason: collision with root package name */
    private static a f2358i;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String[]> f2359b;

    /* renamed from: c  reason: collision with root package name */
    private Map<Integer, cn.jiguang.ax.a> f2360c;

    /* renamed from: j  reason: collision with root package name */
    private boolean f2361j = false;

    /* renamed from: k  reason: collision with root package name */
    private Context f2362k;

    static {
        ArrayMap arrayMap = new ArrayMap();
        f2352a = arrayMap;
        arrayMap.put("JDevice", 1000);
        f2352a.put("JDeviceScreen", 2900);
        f2352a.put("JLocation", 1500);
        f2352a.put("JAppAll", 1100);
        f2352a.put("JAppMovement", 1101);
        f2352a.put("JAppPermission", 1300);
        f2352a.put("JAppRunning", 1102);
        f2352a.put("JAppSdk", 1103);
        f2352a.put("JDeviceBattery", 1200);
        f2352a.put("JLocationv2", 1500);
        f2352a.put("JDeviceIds", 1900);
        f2352a.put("uid", 2300);
        f2352a.put("JAppActive", 1104);
        f2352a.put("JDataCollectStatistic", 2600);
        f2352a.put("JAppProbe", 1106);
        f2352a.put("JDeviceMac", 2700);
        f2352a.put("JDeviceIp", 2800);
        f2352a.put("JArp", 1600);
        f2353d = new ArrayMap();
        ArrayList<Integer> arrayList = new ArrayList<>();
        f2354e = arrayList;
        arrayList.add(1800);
        ArrayMap arrayMap2 = new ArrayMap();
        f2355f = arrayMap2;
        arrayMap2.put(1022, new Integer[]{1023, 1024, 1025});
        f2356g = new ArrayList<Integer>() { // from class: cn.jiguang.ar.a.1
            {
                add(2000);
                add(2002);
                add(2008);
                add(2009);
                add(2010);
                add(2011);
                add(2012);
                add(1014);
                add(1009);
                add(1015);
            }
        };
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        f2357h = arrayList2;
        arrayList2.add(1015);
        f2357h.add(1014);
        f2357h.add(1009);
        f2358i = null;
    }

    private a() {
    }

    private long a(Date date) {
        if (date == null) {
            return 0L;
        }
        Date date2 = new Date();
        date2.setHours(date.getHours());
        date2.setMinutes(date.getMinutes());
        date2.setSeconds(date.getSeconds());
        return (date2.getTime() / 1000) * 1000;
    }

    public static a a() {
        if (f2358i == null) {
            synchronized (a.class) {
                if (f2358i == null) {
                    f2358i = new a();
                }
                f2358i.f2359b = new ArrayList<>();
                f2358i.f2360c = new ArrayMap();
            }
        }
        return f2358i;
    }

    private boolean i(int i4) {
        return (i4 < 2000 || i4 >= 2300 || i4 == 2004 || i4 == 2005 || i4 == 2007) ? false : true;
    }

    public void a(Context context) {
        if (context != null) {
            this.f2362k = context;
        }
    }

    public void a(cn.jiguang.ax.a aVar) {
        int i4;
        if (aVar == null) {
            return;
        }
        try {
            if (this.f2360c == null) {
                this.f2360c = new ArrayMap();
            }
            int a4 = aVar.a();
            if (!this.f2360c.containsKey(Integer.valueOf(a4))) {
                this.f2360c.put(Integer.valueOf(a4), aVar);
            }
            if (a4 >= 2000 || (i4 = (a4 / 100) * 100) == 1100 || this.f2360c.containsKey(Integer.valueOf(i4))) {
                return;
            }
            cn.jiguang.ax.a aVar2 = new cn.jiguang.ax.a();
            aVar2.a(i4);
            aVar2.a(true);
            aVar2.b(aVar.c());
            aVar2.e(aVar.f());
            aVar2.d(aVar.e());
            aVar2.f(aVar.g());
            aVar2.g(aVar.h());
            aVar2.h(aVar.i());
            aVar2.c(aVar.d());
            this.f2360c.put(Integer.valueOf(i4), aVar2);
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JDataConfigManager", "addConfig failed :" + th);
        }
    }

    public synchronized void a(String str) {
        try {
            Map<String, Integer> map = f2352a;
            if (map != null) {
                Integer num = map.get(str);
                Map<Integer, Boolean> map2 = f2353d;
                if (map2 != null && num != null && !map2.containsKey(num)) {
                    cn.jiguang.w.a.b("JDataConfigManager", "mark first collect delay :" + str + ":" + num);
                    f2353d.put(num, Boolean.TRUE);
                }
            }
        } finally {
        }
    }

    public boolean a(int i4) {
        return a(i4, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00fb, code lost:
        if (java.lang.Math.abs(r10 - r12) >= r0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0188, code lost:
        if (r5 == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x018a, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (r6 == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x018d, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(int r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 493
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.ar.a.a(int, boolean):boolean");
    }

    public synchronized int b(int i4) {
        Map<Integer, Boolean> map;
        cn.jiguang.ax.a aVar;
        try {
            map = f2353d;
        } finally {
            return 0;
        }
        if (map == null || !map.containsKey(Integer.valueOf(i4))) {
            Map<Integer, cn.jiguang.ax.a> map2 = this.f2360c;
            if (map2 != null && map2.containsKey(Integer.valueOf(i4)) && (aVar = this.f2360c.get(Integer.valueOf(i4))) != null) {
                return aVar.c() * 1000;
            }
            return 0;
        }
        return 0;
    }

    public long b(String str) {
        cn.jiguang.ax.a aVar;
        try {
            Map<String, Integer> map = f2352a;
            if (map != null) {
                Integer num = map.get(str);
                Map<Integer, cn.jiguang.ax.a> map2 = this.f2360c;
                if (map2 == null || num == null || !map2.containsKey(num) || (aVar = this.f2360c.get(num)) == null) {
                    return 86400000L;
                }
                return aVar.f() * 1000;
            }
            return 86400000L;
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JDataConfigManager", "get clt interval  failed :" + th);
            return 86400000L;
        }
    }

    public void b() {
        this.f2359b = new ArrayList<>();
        this.f2360c = new ArrayMap();
    }

    public void b(Context context) {
        if (this.f2361j) {
            return;
        }
        synchronized (a.class) {
            if (this.f2361j) {
                return;
            }
            cn.jiguang.ax.c.a().b(context);
            this.f2361j = true;
        }
    }

    public boolean b(int i4, boolean z3) {
        StringBuilder sb;
        boolean z4 = false;
        if (d.j()) {
            if (a().a(i4, z3) && !cn.jiguang.ah.c.a(i4)) {
                z4 = true;
            }
            sb = new StringBuilder();
            sb.append("configId is ");
            sb.append(i4);
            sb.append(", isCanCollect is ");
            sb.append(z4);
        } else {
            sb = new StringBuilder();
            sb.append("isCanCollect isAuth ");
            sb.append(d.j());
        }
        cn.jiguang.w.a.a(i4, "JDataConfigManager", sb.toString());
        return z4;
    }

    public int c(int i4) {
        cn.jiguang.ax.a aVar;
        try {
            Map<Integer, cn.jiguang.ax.a> map = this.f2360c;
            if (map != null && map.containsKey(Integer.valueOf(i4)) && (aVar = this.f2360c.get(Integer.valueOf(i4))) != null) {
                return aVar.h();
            }
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JDataConfigManager", "get bg interval  failed :" + th);
        }
        return f2356g.contains(Integer.valueOf(i4)) ? -1 : 0;
    }

    public long c(String str) {
        cn.jiguang.ax.a aVar;
        try {
            Map<String, Integer> map = f2352a;
            if (map != null) {
                Integer num = map.get(str);
                Map<Integer, cn.jiguang.ax.a> map2 = this.f2360c;
                if (map2 == null || num == null || !map2.containsKey(num) || (aVar = this.f2360c.get(num)) == null) {
                    return 0L;
                }
                return aVar.d() * 1000;
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public int d(int i4) {
        cn.jiguang.ax.a aVar;
        int i5 = 0;
        try {
            Map<Integer, cn.jiguang.ax.a> map = this.f2360c;
            if (map != null && i4 > 0 && map.containsKey(Integer.valueOf(i4)) && (aVar = this.f2360c.get(Integer.valueOf(i4))) != null) {
                i5 = aVar.i();
                if (i5 > 0) {
                    i5 = i5 * 60 * 1000;
                }
            }
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JDataConfigManager", "get method interval  failed :" + th);
        }
        cn.jiguang.w.a.a(i4, "JDataConfigManager", "configId is " + i4 + ", method freq is " + i5);
        return i5;
    }

    public long d(String str) {
        cn.jiguang.ax.a aVar;
        try {
            Map<String, Integer> map = f2352a;
            if (map != null) {
                Integer num = map.get(str);
                Map<Integer, cn.jiguang.ax.a> map2 = this.f2360c;
                if (map2 == null || num == null || !map2.containsKey(num) || (aVar = this.f2360c.get(num)) == null) {
                    return 86400000L;
                }
                return aVar.g() * 1000;
            }
            return 86400000L;
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JDataConfigManager", "get rpt interval  failed :" + th);
            return 86400000L;
        }
    }

    public boolean e(int i4) {
        StringBuilder sb;
        boolean z3 = false;
        if (d.j()) {
            if (a().a(i4) && !cn.jiguang.ah.c.a(i4)) {
                z3 = true;
            }
            sb = new StringBuilder();
            sb.append("configId is ");
            sb.append(i4);
            sb.append(", isCanCollect is ");
            sb.append(z3);
        } else {
            sb = new StringBuilder();
            sb.append("isCanCollect isAuth ");
            sb.append(d.j());
        }
        cn.jiguang.w.a.a(i4, "JDataConfigManager", sb.toString());
        return z3;
    }

    public boolean f(int i4) {
        if (!d.j()) {
            cn.jiguang.w.a.a(i4, "JDataConfigManager", "isConfigCanCollect isAuth " + d.j());
            return false;
        }
        boolean a4 = a().a(i4);
        cn.jiguang.w.a.a(i4, "JDataConfigManager", "configId is " + i4 + ", isConfigCanCollect is " + a4);
        return a4;
    }

    public boolean g(int i4) {
        StringBuilder sb;
        boolean z3 = true;
        if (d.j()) {
            if (a().a(i4) && !cn.jiguang.ah.c.a(i4)) {
                z3 = false;
            }
            sb = new StringBuilder();
            sb.append("configId is ");
            sb.append(i4);
            sb.append(", isNotCollect is ");
            sb.append(z3);
        } else {
            sb = new StringBuilder();
            sb.append("isNotCollect isAuth ");
            sb.append(d.j());
        }
        cn.jiguang.w.a.a(i4, "JDataConfigManager", sb.toString());
        return z3;
    }

    public boolean h(int i4) {
        boolean a4 = c.a().a(i4);
        boolean b4 = c.a().b(i4);
        cn.jiguang.w.a.a(i4, "JDataConfigManager", "isUserEnable with configId: " + i4 + " { containEnableDatas: " + a4 + ", containDisableDatas: " + b4);
        return a4 || !b4;
    }
}
