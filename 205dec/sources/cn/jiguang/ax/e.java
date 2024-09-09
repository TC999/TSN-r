package cn.jiguang.ax;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import java.util.HashMap;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<Integer, Pair<Long, Integer>> f2475a = new HashMap<>();

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static abstract class a implements b {
        @Override // cn.jiguang.ax.e.b
        public Object c() {
            return null;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface b {
        Object a();

        void a(Object obj);

        Object b();

        Object c();
    }

    public static synchronized Object a(Context context, int i4, int i5, long j4, b bVar) {
        String str;
        String str2;
        Object obj;
        String str3;
        String str4;
        synchronized (e.class) {
            Object obj2 = null;
            if (cn.jiguang.ar.a.a().g(i4)) {
                return null;
            }
            if (i5 <= 0) {
                i5 = Integer.MAX_VALUE;
            }
            if (j4 <= 0) {
                j4 = 3600000;
            }
            int d4 = cn.jiguang.ar.a.a().d(i4);
            if (d4 != -1) {
                if (d4 != 0) {
                    if (System.currentTimeMillis() - cn.jiguang.ah.c.c(context, i4) < d4) {
                        obj = bVar.c();
                        if (a(obj)) {
                            obj = cn.jiguang.ah.c.a(context, i4, true);
                        }
                    } else {
                        if (a(i4, i5, j4)) {
                            obj2 = bVar.b();
                            if (a(obj2)) {
                                cn.jiguang.w.a.a(i4, "JMethodFreq", " origin api  get value is null, configID=" + i4);
                            }
                        }
                        if (!a(obj2)) {
                            if (obj2 instanceof String) {
                                cn.jiguang.ah.c.a(context, i4, (String) obj2, true);
                            }
                            cn.jiguang.ah.c.a(context, i4, System.currentTimeMillis());
                        }
                        obj = obj2;
                    }
                    str3 = "JMethodFreq";
                    str4 = "get disk value is " + obj;
                } else {
                    obj = bVar.b();
                    str3 = "JMethodFreq";
                    str4 = "get method value is " + obj;
                }
                cn.jiguang.w.a.e(str3, str4);
            } else {
                Object a4 = bVar.a();
                if (a(a4) && a(i4, i5, j4)) {
                    a4 = bVar.b();
                    if (a(a4)) {
                        str = "JMethodFreq";
                        str2 = " origin api  get value is null, configID=" + i4;
                    } else {
                        bVar.a(a4);
                        obj = a4;
                        cn.jiguang.w.a.a(i4, "JMethodFreq", "get memory value is " + obj);
                    }
                } else {
                    str = "JMethodFreq";
                    str2 = "configID =" + i4 + " , fre control,user memory";
                }
                cn.jiguang.w.a.a(i4, str, str2);
                obj = a4;
                cn.jiguang.w.a.a(i4, "JMethodFreq", "get memory value is " + obj);
            }
            return obj;
        }
    }

    public static synchronized Object a(Context context, int i4, int i5, b bVar) {
        Object a4;
        synchronized (e.class) {
            a4 = a(context, i4, i5, 0L, bVar);
        }
        return a4;
    }

    public static synchronized Object a(Context context, int i4, b bVar) {
        Object a4;
        synchronized (e.class) {
            a4 = a(context, i4, 0, bVar);
        }
        return a4;
    }

    private static boolean a(int i4, int i5, long j4) {
        int intValue;
        long currentTimeMillis = System.currentTimeMillis();
        int i6 = 0;
        if (f2475a.containsKey(Integer.valueOf(i4))) {
            Pair<Long, Integer> pair = f2475a.get(Integer.valueOf(i4));
            if (Math.abs(currentTimeMillis - ((Long) pair.first).longValue()) < j4 || (intValue = ((Integer) pair.second).intValue()) >= i5) {
                return false;
            }
            i6 = intValue;
        }
        f2475a.put(Integer.valueOf(i4), new Pair<>(Long.valueOf(currentTimeMillis), Integer.valueOf(i6 + 1)));
        return true;
    }

    public static boolean a(Object obj) {
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
}
