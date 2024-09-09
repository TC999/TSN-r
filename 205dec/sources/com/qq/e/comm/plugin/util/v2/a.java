package com.qq.e.comm.plugin.util.v2;

import android.text.TextUtils;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.d2;
import com.qq.e.comm.plugin.util.i1;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Map<Integer, String> f46648a;

    /* renamed from: b  reason: collision with root package name */
    private static Integer f46649b;

    /* renamed from: c  reason: collision with root package name */
    public static Double f46650c;

    /* renamed from: e  reason: collision with root package name */
    private static volatile String[] f46652e;

    /* renamed from: d  reason: collision with root package name */
    private static int f46651d = new Random(System.currentTimeMillis()).nextInt(100);

    /* renamed from: f  reason: collision with root package name */
    private static final Map<String, List<i1>> f46653f = new ConcurrentHashMap();

    private static int a(com.qq.e.comm.plugin.g0.e eVar) {
        return com.qq.e.comm.plugin.t.c.a("sldd", eVar.q0(), 0, eVar.p0());
    }

    public static boolean a(double d4) {
        return d4 == 0.0d;
    }

    public static String b(String str) {
        if (f46648a == null) {
            HashMap hashMap = new HashMap();
            f46648a = hashMap;
            hashMap.put(2, "AA");
            f46648a.put(3, "AB");
            f46648a.put(4, "AC");
            f46648a.put(5, "AD");
            f46648a.put(6, "AE");
            f46648a.put(100, "AX");
            f46648a.put(101, "AY");
            f46648a.put(102, "AZ");
        }
        return f46648a.get(Integer.valueOf(a(str)));
    }

    public static boolean b(double d4) {
        return d4 > 0.0d && d4 < 1.0d;
    }

    public static boolean c(com.qq.e.comm.plugin.g0.e eVar) {
        int a4 = a("vcrp");
        return (a4 == 4 || a4 == 5) && eVar.M0() >= a(eVar) && b(eVar);
    }

    public static boolean d(com.qq.e.comm.plugin.g0.e eVar) {
        int a4 = a("vcrp");
        return (a4 == 3 || a4 == 5 || a4 == 6) && eVar.M0() >= a(eVar) && b(eVar);
    }

    public static boolean e(com.qq.e.comm.plugin.g0.e eVar) {
        return a("vcrp") == 6 && eVar.M0() >= a(eVar) && b(eVar);
    }

    public static int a(String str) {
        Integer valueOf = Integer.valueOf(com.qq.e.comm.plugin.d0.a.d().f().a(str, 0));
        f46649b = valueOf;
        if (valueOf.intValue() < 10000) {
            return f46649b.intValue();
        }
        Integer valueOf2 = Integer.valueOf(com.qq.e.comm.plugin.t.a.b().a(String.valueOf(f46649b), 0));
        f46649b = valueOf2;
        return valueOf2.intValue();
    }

    private static synchronized void a() {
        synchronized (a.class) {
            if (f46652e == null) {
                String c4 = com.qq.e.comm.plugin.d0.a.d().f().c("addrupd");
                if (TextUtils.isEmpty(c4)) {
                    f46652e = new String[0];
                    return;
                }
                try {
                    f46652e = c4.split(",");
                } catch (Exception unused) {
                }
            }
        }
    }

    public static boolean b() {
        int parseInt;
        if (f46652e == null) {
            a();
        }
        if (f46652e != null && f46652e.length > 0) {
            try {
                String[] strArr = f46652e;
                Date date = new Date();
                int hours = date.getHours();
                int minutes = date.getMinutes();
                for (String str : strArr) {
                    int indexOf = str.indexOf("-");
                    int indexOf2 = str.indexOf(":");
                    if (indexOf > 0 && indexOf2 > 0) {
                        int parseInt2 = Integer.parseInt(str.substring(0, indexOf));
                        int parseInt3 = Integer.parseInt(str.substring(indexOf + 1, indexOf2));
                        if (hours >= parseInt2 && hours <= parseInt3) {
                            String substring = str.substring(indexOf2 + 1);
                            int indexOf3 = substring.indexOf("-");
                            if (indexOf3 > 0) {
                                int parseInt4 = Integer.parseInt(substring.substring(0, indexOf3));
                                parseInt = (((Integer.parseInt(substring.substring(indexOf3 + 1)) - parseInt4) * (((hours - parseInt2) * 60) + minutes)) / (((parseInt3 - parseInt2) + 1) * 60)) + parseInt4;
                            } else {
                                parseInt = Integer.parseInt(substring);
                            }
                            return parseInt > f46651d;
                        }
                    }
                }
            } catch (Exception e4) {
                d1.a(e4.getMessage());
            }
        }
        return false;
    }

    public static double a(double d4, int i4) {
        if (i4 == 0) {
            return d4;
        }
        if (f46650c == null) {
            double a4 = com.qq.e.comm.plugin.d0.a.d().f().a("stdd", 20);
            Double.isNaN(a4);
            f46650c = Double.valueOf(a4 * 1.0d);
        }
        double doubleValue = f46650c.doubleValue();
        double d5 = i4;
        Double.isNaN(d5);
        return Math.min(d4, doubleValue / d5);
    }

    public static String a(com.qq.e.comm.plugin.g0.e eVar, String str) {
        return str + "_" + eVar.o().f42000e;
    }

    public static String a(com.qq.e.comm.plugin.g0.e eVar, String str, String str2) {
        String a4 = com.qq.e.comm.plugin.d0.a.d().f().a(a(eVar, str), eVar.q0(), "");
        return !TextUtils.isEmpty(a4) ? a4 : com.qq.e.comm.plugin.d0.a.d().f().a(str, eVar.q0(), str2);
    }

    public static boolean b(com.qq.e.comm.plugin.g0.e eVar) {
        String a4 = a(eVar, "vatime");
        List<i1> list = f46653f.get(a4);
        if (list == null) {
            list = d2.a(a(eVar, "vatime", "0:00-23:59"));
            f46653f.put(a4, list);
        }
        if (list.size() <= 0) {
            return true;
        }
        return d2.a(list);
    }
}
