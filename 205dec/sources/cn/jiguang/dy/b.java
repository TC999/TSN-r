package cn.jiguang.dy;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.bj.e;
import cn.jiguang.bj.g;
import cn.jiguang.bj.i;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f3585a;

    /* renamed from: b  reason: collision with root package name */
    private static Map<Integer, String> f3586b = new ConcurrentHashMap();

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface a {
        boolean a(File file);
    }

    private b() {
    }

    public static b a() {
        if (f3585a == null) {
            synchronized (b.class) {
                if (f3585a == null) {
                    f3585a = new b();
                }
            }
        }
        return f3585a;
    }

    public static Object a(Context context, int i4, int i5, Object obj) {
        int i6;
        int a4;
        String str;
        String str2;
        char c4;
        String str3;
        String str4;
        try {
            a4 = cn.jiguang.bf.c.a().a(context, i4);
        } catch (Throwable th) {
            th = th;
            i6 = -1;
        }
        try {
            cn.jiguang.bi.b.b("JDB", "context:" + context + ",pluginId:" + i4 + ",type:" + i5 + ",o:" + obj);
            String str5 = e.f2668e;
            String a5 = i.a("K9Ow/j0uADRPpP0ZrnpQ3A==", str5);
            if (i5 != 0 && i5 != 1) {
                if (i5 != 2) {
                    return null;
                }
                String a6 = cn.jiguang.bf.a.a(i4, 0);
                String a7 = cn.jiguang.bf.a.a(i4, 1);
                String a8 = cn.jiguang.bf.a.a(i4, 2);
                cn.jiguang.bi.b.b("JDB", "impClass:" + a6 + ",forClass:" + a7 + ",forField:" + a8);
                try {
                    Object newInstance = ((Class) obj.getClass().getMethod(a5, String.class).invoke(obj, a6)).newInstance();
                    Class<?> cls = Class.forName(a7);
                    Field declaredField = cls.getDeclaredField(a8);
                    declaredField.setAccessible(true);
                    declaredField.set(cls, newInstance);
                    str3 = a8;
                    str4 = a7;
                } catch (Throwable th2) {
                    th = th2;
                    str3 = a8;
                    str4 = a7;
                }
                try {
                    c.a().a(context, i4, a4, cn.jiguang.bg.a.f2606a, 1, null);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    cn.jiguang.bi.b.e("JDB", "d e:" + th);
                    c a9 = c.a();
                    cn.jiguang.bg.a aVar = cn.jiguang.bg.a.f2606a;
                    a9.a(context, i4, a4, aVar, 2, "15 load impClass:" + a6 + ",forClass:" + str4 + ",forField:" + str3 + ", error :" + th.getMessage());
                    return null;
                }
            }
            Map<String, String> c5 = c(context, i4);
            if (c5 != null && !c5.isEmpty()) {
                String str6 = c5.get("p");
                String str7 = c5.get("o");
                String str8 = c5.get("l");
                if (i5 == 0) {
                    c4 = 2;
                    str = a5;
                    str2 = str5;
                    c.a().a(context, i4, a4, cn.jiguang.bg.a.f2610e, 0, null);
                } else {
                    str = a5;
                    str2 = str5;
                    c4 = 2;
                }
                if (!TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str7) && !TextUtils.isEmpty(str8)) {
                    String a10 = i.a("Vd1zcNfZVmpqw+2NKX98sOf8ivTVMeqdIaqCpaA/CRg=", str2);
                    Object invoke = Context.class.getMethod(i.a("STVo4dDOk4G2wtqJZNmnGg==", str2), new Class[0]).invoke(context, new Object[0]);
                    if (i5 == 0) {
                        Class<?> cls2 = Class.forName(i.a("Zaqi7qnhpEu8dzobKmLDqlzxa1KuKDP47tarZAn48u8=", str2));
                        Class<?>[] clsArr = new Class[4];
                        clsArr[0] = String.class;
                        clsArr[1] = String.class;
                        clsArr[c4] = String.class;
                        clsArr[3] = Class.forName(a10);
                        Constructor<?> constructor = cls2.getConstructor(clsArr);
                        Object[] objArr = new Object[4];
                        objArr[0] = str6;
                        objArr[1] = str7;
                        objArr[c4] = str8;
                        objArr[3] = invoke;
                        Object newInstance2 = constructor.newInstance(objArr);
                        if (newInstance2 == null) {
                            c.a().a(context, i4, a4, cn.jiguang.bg.a.f2610e, 2, "create DexClassLoader failed");
                        }
                        return newInstance2;
                    }
                    String a11 = cn.jiguang.bf.a.a(i4, 3);
                    cn.jiguang.bi.b.b("JDB", "diy c l:" + a11);
                    Class<?>[] clsArr2 = new Class[4];
                    clsArr2[0] = String.class;
                    clsArr2[1] = String.class;
                    clsArr2[c4] = String.class;
                    clsArr2[3] = Class.forName(a10);
                    Constructor constructor2 = ((Class) obj.getClass().getMethod(str, String.class).invoke(obj, a11)).getConstructor(clsArr2);
                    Object[] objArr2 = new Object[4];
                    objArr2[0] = str6;
                    objArr2[1] = str7;
                    objArr2[c4] = str8;
                    objArr2[3] = invoke;
                    Object newInstance3 = constructor2.newInstance(objArr2);
                    try {
                        if (!TextUtils.isEmpty(str6)) {
                            if (f3586b.containsKey(Integer.valueOf(i4))) {
                                f3586b.remove(Integer.valueOf(i4));
                            }
                            File file = new File(str6);
                            if (file.exists()) {
                                file.delete();
                                cn.jiguang.bi.b.b("JDB", "d d file success:" + file.getAbsolutePath());
                            }
                        }
                    } catch (Throwable unused) {
                    }
                    c.a().a(context, i4, a4, cn.jiguang.bg.a.f2610e, 1, null);
                    return newInstance3;
                }
                c.a().a(context, i4, a4, cn.jiguang.bg.a.f2610e, 2, "parameter empty");
                return null;
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            i6 = a4;
            cn.jiguang.bi.b.e("JDB", "d failed " + th.getMessage());
            c a12 = c.a();
            cn.jiguang.bg.a aVar2 = cn.jiguang.bg.a.f2606a;
            a12.a(context, i4, i6, aVar2, 2, "16 load failed , error :" + th.getMessage());
            return null;
        }
    }

    public static String a(Context context, cn.jiguang.bg.c cVar) {
        String absolutePath = cn.jiguang.bf.b.c(context, cVar.f2647s, cVar.f2641m, cVar.f2643o).getAbsolutePath();
        cn.jiguang.bi.b.b("JDB", "o:" + absolutePath);
        return absolutePath;
    }

    public static String a(Context context, cn.jiguang.bg.c cVar, boolean z3) {
        String str;
        File a4 = cn.jiguang.bf.a.a(context, cVar, true);
        if (a4 != null) {
            str = a4.getAbsolutePath();
            cn.jiguang.bi.b.b("JDB", "p:" + str);
            if (z3) {
                c.a().a(context, cVar.f2641m, cVar.f2643o, cn.jiguang.bg.a.f2608c, 1, null);
            }
        } else {
            if (z3) {
                c.a().a(context, cVar.f2641m, cVar.f2643o, cn.jiguang.bg.a.f2608c, 2, "Plugin file validate check failed");
            }
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                if (f3586b.get(Integer.valueOf(cVar.f2641m)) != null) {
                    String str2 = f3586b.get(Integer.valueOf(cVar.f2641m));
                    if (new File(str2).exists()) {
                        return str2;
                    }
                }
            } catch (Throwable unused) {
            }
            c a5 = c.a();
            int i4 = cVar.f2641m;
            int i5 = cVar.f2643o;
            cn.jiguang.bg.a aVar = cn.jiguang.bg.a.f2609d;
            a5.a(context, i4, i5, aVar, 0, null);
            File a6 = cn.jiguang.bf.b.a(context, new File(str), cVar.f2641m, cVar.f2643o, e.f2667d);
            if (a6 == null || !a6.exists()) {
                cn.jiguang.bi.b.b("JDB", "d failed,clear p");
                cn.jiguang.bf.a.a(context, cVar);
                str = "";
            } else {
                String absolutePath = a6.getAbsolutePath();
                try {
                    f3586b.put(Integer.valueOf(cVar.f2641m), absolutePath);
                    if (z3) {
                        c.a().a(context, cVar.f2641m, cVar.f2643o, aVar, 1, null);
                    }
                } catch (Throwable th) {
                    if (z3) {
                        c a7 = c.a();
                        int i6 = cVar.f2641m;
                        int i7 = cVar.f2643o;
                        cn.jiguang.bg.a aVar2 = cn.jiguang.bg.a.f2609d;
                        a7.a(context, i6, i7, aVar2, 2, "11 add pluginCache error:" + th.getMessage());
                    }
                }
                str = absolutePath;
            }
        }
        cn.jiguang.bi.b.b("JDB", "end p:" + str);
        return str;
    }

    private static boolean a(Context context, cn.jiguang.bg.c cVar, int i4) {
        String a4 = cn.jiguang.bf.a.a(i4, 4);
        if (TextUtils.isEmpty(a4)) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(a4);
            cn.jiguang.bi.b.b("JDB", "p c vc:" + parseInt + ",p vc:" + cVar.f2643o);
            if (parseInt >= cVar.f2643o) {
                cn.jiguang.bf.a.a(context, cVar);
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static String b(Context context, cn.jiguang.bg.c cVar) {
        String absolutePath = cn.jiguang.bf.b.b(context, cVar.f2647s, cVar.f2641m, cVar.f2643o).getAbsolutePath();
        cn.jiguang.bi.b.b("JDB", "l:" + absolutePath);
        return absolutePath;
    }

    public static Map<String, String> c(Context context, int i4) {
        c a4;
        int i5;
        String str;
        int a5 = cn.jiguang.bf.c.a().a(context, i4);
        c a6 = c.a();
        cn.jiguang.bg.a aVar = cn.jiguang.bg.a.f2607b;
        a6.a(context, i4, a5, aVar, 0, null);
        cn.jiguang.bg.c b4 = cn.jiguang.bf.a.b(context, i4);
        if (b4 == null) {
            a4 = c.a();
            i5 = 2;
            str = "pluginInfo is null";
        } else {
            a5 = b4.f2643o;
            c.a().a(context, i4, a5, aVar, 1, null);
            c a7 = c.a();
            aVar = cn.jiguang.bg.a.f2608c;
            a7.a(context, i4, a5, aVar, 0, null);
            if (a(context, b4, i4)) {
                String a8 = a(context, b4, true);
                if (TextUtils.isEmpty(a8)) {
                    return null;
                }
                String a9 = a(context, b4);
                String b5 = b(context, b4);
                HashMap hashMap = new HashMap();
                hashMap.put("p", a8);
                hashMap.put("o", a9);
                hashMap.put("l", b5);
                return hashMap;
            }
            a4 = c.a();
            i5 = 2;
            str = "checkLocalVcode failed";
        }
        a4.a(context, i4, a5, aVar, i5, str);
        return null;
    }

    public void a(Context context, int i4, String str) {
        cn.jiguang.bi.b.b("JDB", "up :" + i4);
        a(context, i4, str, (a) null);
    }

    public void a(Context context, int i4, String str, a aVar) {
        if (g.b(context)) {
            cn.jiguang.bf.c.a().a(context, i4, str, aVar);
            if (i4 == 1) {
                c.a().a(context);
            }
        }
    }

    public boolean a(Context context, int i4) {
        try {
            int a4 = cn.jiguang.bf.c.a().a(context, i4);
            c a5 = c.a();
            cn.jiguang.bg.a aVar = cn.jiguang.bg.a.f2606a;
            a5.a(context, i4, a4, aVar, 0, null);
            if (context == null) {
                cn.jiguang.bi.b.g("JDB", "context is null");
                c.a().a(context, i4, a4, aVar, 2, "1 context is null");
                return false;
            }
            Object a6 = a(context, i4, 0, (Object) null);
            if (a6 == null) {
                c.a().a(context, i4, a4, aVar, 2, "baseCL failed");
                return false;
            }
            Object a7 = a(context, i4, 1, a6);
            if (a7 == null) {
                c.a().a(context, i4, a4, aVar, 2, "diyCL failed");
                return false;
            }
            a(context, i4, 2, a7);
            return true;
        } catch (Throwable th) {
            cn.jiguang.bi.b.a("JDB", "lP:" + th.getMessage(), th);
            return false;
        }
    }

    public void b(Context context, int i4) {
        try {
            cn.jiguang.bg.c b4 = cn.jiguang.bf.a.b(context, i4);
            if (b4 != null) {
                cn.jiguang.bf.a.a(context, b4);
            }
        } catch (Throwable unused) {
        }
    }
}
