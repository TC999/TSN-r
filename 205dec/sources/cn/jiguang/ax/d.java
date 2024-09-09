package cn.jiguang.ax;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static ArrayList<Integer> f2472a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private static ArrayList<Integer> f2473b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private static String f2474c;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static abstract class a implements b {
        @Override // cn.jiguang.ax.d.b
        public void b(Object obj) {
        }

        @Override // cn.jiguang.ax.d.b
        public Object c() {
            return null;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface b {
        Object a();

        void a(Object obj);

        Object b();

        void b(Object obj);

        Object c();
    }

    static {
        f2472a.add(2004);
        f2472a.add(2005);
        f2472a.add(1012);
        f2472a.add(2000);
        f2472a.add(1014);
        f2472a.add(3334);
        f2474c = "JMethodControl";
    }

    public static synchronized Object a(Context context, int i4, long j4, long j5, b bVar) {
        Object a4;
        synchronized (d.class) {
            a4 = a(context, i4, j4, j5, true, false, true, true, false, false, true, bVar);
        }
        return a4;
    }

    public static synchronized Object a(Context context, int i4, long j4, long j5, boolean z3, b bVar) {
        Object a4;
        synchronized (d.class) {
            a4 = a(context, i4, j4, j5, true, false, true, z3, false, false, true, bVar);
        }
        return a4;
    }

    private static synchronized Object a(Context context, int i4, long j4, long j5, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, b bVar) {
        Object b4;
        synchronized (d.class) {
            if (z4) {
                cn.jiguang.w.a.e(f2474c, "from cmd ,so get from api");
                return bVar.b();
            } else if (z6 && cn.jiguang.ar.a.a().g(i4)) {
                String str = f2474c;
                cn.jiguang.w.a.a(i4, str, "configId= " + i4 + " is not collect");
                return null;
            } else if (bVar == null) {
                return null;
            } else {
                Object a4 = bVar.a();
                String str2 = f2474c;
                cn.jiguang.w.a.e(str2, "local memory result=" + a4);
                if (a(a4)) {
                    a4 = bVar.c();
                    String str3 = f2474c;
                    cn.jiguang.w.a.e(str3, "local cache result=" + a4);
                }
                if (a(a4)) {
                    a4 = cn.jiguang.ah.c.a(context, i4, z9);
                    String str4 = f2474c;
                    cn.jiguang.w.a.e(str4, "sp cache result=" + a4);
                }
                if (z7 && !z8) {
                    bVar.b(a4);
                    Object b5 = bVar.b();
                    a(context, i4, b5, z3, z9, bVar);
                    String str5 = f2474c;
                    cn.jiguang.w.a.e(str5, "need use api, result=" + b5);
                    return b5;
                } else if (z8) {
                    String str6 = f2474c;
                    cn.jiguang.w.a.e(str6, "is frequency, so use cache result=" + a4);
                    return a4;
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (a(a4)) {
                        if (!(Math.abs(currentTimeMillis - cn.jiguang.ah.c.c(context, i4)) >= j4 && !f2473b.contains(Integer.valueOf(i4)))) {
                            String str7 = f2474c;
                            cn.jiguang.w.a.e(str7, "return default result=" + a4);
                            return a4;
                        }
                        b4 = bVar.b();
                        if (f2472a.contains(Integer.valueOf(i4))) {
                            f2473b.add(Integer.valueOf(i4));
                        }
                        String str8 = f2474c;
                        cn.jiguang.w.a.e(str8, "over interval time,  get api result=" + b4);
                        a(context, i4, b4, z3, z9, bVar);
                        a4 = b4;
                        return a4;
                    } else if (!z5) {
                        String str9 = f2474c;
                        cn.jiguang.w.a.e(str9, "no need update,so use cache result=" + a4);
                        return a4;
                    } else if (Math.abs(currentTimeMillis - cn.jiguang.ah.c.d(context, i4)) <= j5) {
                        bVar.a(a4);
                        return a4;
                    } else {
                        bVar.b(a4);
                        b4 = bVar.b();
                        String str10 = f2474c;
                        cn.jiguang.w.a.e(str10, "result out of expire time, so new get from api result=" + b4);
                        a(context, i4, b4, z3, z9, bVar);
                        a4 = b4;
                        return a4;
                    }
                }
            }
        }
    }

    public static synchronized Object a(Context context, int i4, long j4, boolean z3, b bVar) {
        synchronized (d.class) {
            if (cn.jiguang.ar.a.a().g(i4)) {
                String str = f2474c;
                cn.jiguang.w.a.a(i4, str, "configId= " + i4 + " is not collect");
                return null;
            } else if (bVar == null) {
                return null;
            } else {
                Object a4 = bVar.a();
                String str2 = f2474c;
                cn.jiguang.w.a.e(str2, "local memory result=" + a4);
                if (a(a4)) {
                    a4 = bVar.c();
                    String str3 = f2474c;
                    cn.jiguang.w.a.e(str3, "local cache result=" + a4);
                }
                boolean z4 = true;
                if (a(a4)) {
                    a4 = cn.jiguang.ah.c.a(context, i4, true);
                    String str4 = f2474c;
                    cn.jiguang.w.a.e(str4, "sp cache result=" + a4);
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (z3) {
                    if (Math.abs(currentTimeMillis - cn.jiguang.ah.c.c(context, i4)) < j4 || f2473b.contains(Integer.valueOf(i4))) {
                        z4 = false;
                    }
                    if (z4) {
                        a4 = bVar.b();
                        if (f2472a.contains(Integer.valueOf(i4))) {
                            f2473b.add(Integer.valueOf(i4));
                        }
                        String str5 = f2474c;
                        cn.jiguang.w.a.e(str5, "over interval time,  get api result=" + a4);
                        a(context, i4, a4, true, true, bVar);
                    } else {
                        String str6 = f2474c;
                        cn.jiguang.w.a.e(str6, "return default result=" + a4);
                    }
                }
                return a4;
            }
        }
    }

    public static synchronized Object a(Context context, int i4, b bVar) {
        Object a4;
        synchronized (d.class) {
            a4 = a(context, i4, 0L, 0L, true, false, false, true, false, false, true, bVar);
        }
        return a4;
    }

    public static synchronized Object a(Context context, int i4, boolean z3, boolean z4, b bVar) {
        Object a4;
        synchronized (d.class) {
            a4 = a(context, i4, 0L, 0L, true, false, false, true, z3, z4, true, bVar);
        }
        return a4;
    }

    private static void a(Context context, int i4, Object obj, boolean z3, boolean z4, b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!a(obj)) {
            bVar.a(obj);
            if (z3) {
                cn.jiguang.ah.c.a(context, i4, (String) obj, z4);
                cn.jiguang.ah.c.b(context, i4, currentTimeMillis);
            }
        }
        cn.jiguang.ah.c.a(context, i4, currentTimeMillis);
    }

    private static boolean a(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof String) {
            return TextUtils.isEmpty((String) obj);
        }
        if (obj instanceof List) {
            return ((List) obj).isEmpty();
        }
        return false;
    }

    public static synchronized Object b(Context context, int i4, long j4, long j5, b bVar) {
        Object a4;
        synchronized (d.class) {
            a4 = a(context, i4, j4, j5, true, false, true, false, false, false, true, bVar);
        }
        return a4;
    }

    public static synchronized Object b(Context context, int i4, long j4, long j5, boolean z3, b bVar) {
        Object a4;
        synchronized (d.class) {
            a4 = a(context, i4, j4, j5, false, z3, true, true, false, false, true, bVar);
        }
        return a4;
    }

    public static synchronized Object b(Context context, int i4, boolean z3, boolean z4, b bVar) {
        Object a4;
        synchronized (d.class) {
            a4 = a(context, i4, 0L, 0L, true, false, false, z3, false, false, z4, bVar);
        }
        return a4;
    }
}
