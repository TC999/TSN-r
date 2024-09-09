package cn.jiguang.bf;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.bj.e;
import cn.jiguang.bj.f;
import cn.jiguang.bj.j;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2586a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f2587b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f2588c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f2589d;

    /* renamed from: e  reason: collision with root package name */
    private static Map<Integer, Bundle> f2590e = new ConcurrentHashMap();

    static {
        a();
        f2586a = cn.jiguang.bh.a.b(new byte[]{67, 119, 38, 102, 63, 90, 73, 126, 125, 119, Byte.MAX_VALUE, 87, 14, 83, 75, 121, 99, 85, 104, 124, 100, 102, 116, 66});
        f2587b = cn.jiguang.bh.a.b(new byte[]{117, Byte.MAX_VALUE, 30, 74, 112, 111, 99, 112, 94, 71, 55, 97, 120, 101, 85, 82, 119, 105, 122, 63, 122, 99, 118, 122, 115, 88, 94, 84, 124, 122, 120, 112, 92, 104, 124, 100, 102, 116, 66});
        f2588c = cn.jiguang.bh.a.b(new byte[]{122, 102, 56, 123, 89, 71, 108, 105, 120, 118, 30, 73, 119, 124, 115, 99, 94, 65, 117, 38, 92, 82, 95, 82, 124, 64, 115, 125, 64, 69, 107, 73, 117, 101, 89, 79, 119});
        f2589d = cn.jiguang.bh.a.b(new byte[]{83, 78, 55, 120, 56, 123, 89, 71, 108, 105, 120, 118, 30, 106, 90, 103, 100, 116, 115, 76, 120, 123, 101, 93, 95, 65, 125, 109, 100});
    }

    public static File a(Context context, int i4) {
        try {
            return a(context, b(context, i4), true);
        } catch (Throwable th) {
            cn.jiguang.bi.b.e("PH", "getIIf error:" + th.getMessage());
            return null;
        }
    }

    public static File a(Context context, cn.jiguang.bg.c cVar, boolean z3) {
        File a4;
        if (cVar == null) {
            return null;
        }
        try {
            a4 = b.a(context, cVar.f2647s, cVar.f2641m, cVar.f2643o);
            cn.jiguang.bi.b.b("PH", "pF:" + a4);
        } catch (Throwable th) {
            cn.jiguang.bi.b.b("PH", "gIF error:" + th.getMessage());
        }
        if (b.a(a4, cVar, z3)) {
            return a4;
        }
        return null;
    }

    public static String a(int i4, int i5) {
        String str;
        if (i5 == 0) {
            str = "ic";
        } else if (i5 == 1) {
            str = "if";
        } else if (i5 == 2) {
            str = "iff";
        } else if (i5 == 3) {
            str = "dc";
        } else if (i5 != 4) {
            cn.jiguang.bi.b.e("PH", "unkown type:" + i5);
            return "";
        } else {
            str = "code";
        }
        return f2590e.containsKey(Integer.valueOf(i4)) ? f2590e.get(Integer.valueOf(i4)).getString(str) : "";
    }

    private static void a() {
        try {
            cn.jiguang.bi.b.b("PH", "[loadPinfo]");
            f2590e.putAll(f.a());
            Bundle bundle = new Bundle();
            bundle.putInt("pid", 1);
            bundle.putString("code", f.b() + "");
            bundle.putString("ic", j.a("Y24ucC5qaWd1YW5nLkpDb3JlSGVscGVy"));
            Class<?> cls = Class.forName(j.a("Y24uamlndWFuZy5pbnRlcm5hbC5KQ29yZUludGVybmFsSGVscGVy"));
            bundle.putString("if", cls.getCanonicalName());
            Field[] declaredFields = cls.getDeclaredFields();
            int length = declaredFields.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    break;
                }
                Field field = declaredFields[i4];
                Class<?> type = field.getType();
                if (type.getCanonicalName().equals(j.a("Y24uamlndWFuZy5pbnRlcm5hbC5KQ29yZUhlbHBlckFjdGlvbg"))) {
                    cn.jiguang.bi.b.b("PH", "find filed name:" + field.getName());
                    bundle.putString("iff", field.getName());
                    break;
                }
                i4++;
            }
            bundle.putString("dc", j.a("Y24ucC5qaWd1YW5nLkpDb3JlQ2xhc3NMb2FkZXI"));
            f2590e.put(1, bundle);
            cn.jiguang.bi.b.b("PH", "[loadPinfo] end:" + f2590e);
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, int i4, String str, boolean z3) {
        e.a(context, i4, "use", str, z3);
    }

    public static void a(Context context, cn.jiguang.bg.c cVar) {
        try {
            cn.jiguang.bi.b.b("PH", "clearPlugin...");
            e.a(context, cVar.f2641m, "use", "", false);
            File a4 = b.a(context, cVar.f2647s, cVar.f2641m, cVar.f2643o);
            if (a4.exists()) {
                a4.delete();
            }
        } catch (Throwable unused) {
        }
    }

    public static cn.jiguang.bg.c b(Context context, int i4) {
        return cn.jiguang.bg.c.a(e.a(context, i4, "use"));
    }
}
