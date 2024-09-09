package cn.jiguang.common.n;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import cn.jiguang.ao.g;
import cn.jiguang.ax.e;
import cn.jiguang.common.m.f;
import cn.jiguang.common.n.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import xyz.adscope.common.network.cookie.db.Field;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f3566a = {120, 101};

    /* renamed from: b  reason: collision with root package name */
    private static List<f> f3567b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f3568c = Pattern.compile("^zygote[0-9]*$");

    private static int a(LinkedList<String> linkedList, String str, int i4) {
        int indexOf = linkedList.indexOf(str);
        if (indexOf == -1) {
            indexOf = linkedList.indexOf(str.toLowerCase(Locale.ENGLISH));
        }
        return indexOf == -1 ? i4 : indexOf;
    }

    private static f a(String str, Map<String, Integer> map) {
        String[] split;
        int length;
        String str2;
        if (!TextUtils.isEmpty(str) && (length = (split = str.split("\\s+")).length) >= 3) {
            try {
                f fVar = new f();
                if (map != null && !map.isEmpty()) {
                    fVar.f3513a = split[map.get("USER").intValue()];
                    fVar.f3514b = split[map.get("PID").intValue()];
                    fVar.f3515c = split[map.get("PPID").intValue()];
                    str2 = split[map.get(Field.NAME).intValue()];
                    fVar.f3516d = str2;
                    return fVar;
                }
                fVar.f3513a = split[0];
                fVar.f3514b = split[1];
                fVar.f3515c = split[2];
                str2 = split[length - 1];
                fVar.f3516d = str2;
                return fVar;
            } catch (Throwable th) {
                cn.jiguang.w.a.f("JProcessHelper", "parseCommandResult throwable:" + th.getMessage());
                return null;
            }
        }
        return null;
    }

    public static List<f> a(Context context, final int i4) {
        if (cn.jiguang.ar.a.a().g(1102)) {
            return null;
        }
        Object a4 = cn.jiguang.ax.e.a(context, 1102, new e.a() { // from class: cn.jiguang.common.n.e.1
            @Override // cn.jiguang.ax.e.b
            public Object a() {
                return e.f3567b;
            }

            @Override // cn.jiguang.ax.e.b
            public void a(Object obj) {
                if (obj instanceof List) {
                    List unused = e.f3567b = (List) obj;
                }
            }

            @Override // cn.jiguang.ax.e.b
            public Object b() {
                return e.b(i4);
            }
        });
        if (a4 instanceof List) {
            return (List) a4;
        }
        return null;
    }

    private static Map<String, Integer> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, str.split("\\s+"));
        int size = linkedList.size() - 1;
        HashMap hashMap = new HashMap();
        int a4 = a(linkedList, "USER", 0);
        int a5 = a(linkedList, "PID", 1);
        int a6 = a(linkedList, "PPID", 2);
        int a7 = a(linkedList, Field.NAME, size);
        if (a4 == 0 && a5 == 1 && a6 == 2 && a7 == size) {
            return null;
        }
        return hashMap;
    }

    private static void a(f fVar) {
        String str;
        if (Build.VERSION.SDK_INT < 24 && fVar != null) {
            try {
                a aVar = new a(Integer.parseInt(fVar.f3514b));
                fVar.f3517e = aVar.f3544a ? 1 : 0;
                fVar.f3518f = String.valueOf(aVar.f().b());
                long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
                long j4 = aVar.f().j();
                Long.signum(j4);
                fVar.f3519g = currentTimeMillis + (j4 * 10);
                fVar.f3520h = aVar.f().h();
                fVar.f3521i = aVar.f().i();
                fVar.f3522j = aVar.f().k();
                fVar.f3523k = aVar.f().c();
                try {
                    cn.jiguang.common.m.b a4 = aVar.b().a("cpuacct");
                    cn.jiguang.common.m.b a5 = aVar.b().a("cpu");
                    fVar.f3524l = a4 != null ? a4.toString() : "";
                    fVar.f3525m = a5 != null ? a5.toString() : "";
                } catch (Throwable unused) {
                }
                fVar.f3526n = aVar.f().d();
                fVar.f3527o = aVar.f().e();
                fVar.f3528p = aVar.f().f();
                fVar.f3529q = aVar.f().g();
                fVar.f3530r = aVar.f().l();
                fVar.f3531s = aVar.c();
                fVar.f3532t = aVar.d();
                fVar.f3533u = aVar.e();
            } catch (a.C0061a unused2) {
            } catch (IOException unused3) {
                str = "Error reading from /proc/pid.";
                cn.jiguang.w.a.f("JProcessHelper", str);
            } catch (Throwable unused4) {
                str = "process detail info from /proc file failed.";
                cn.jiguang.w.a.f("JProcessHelper", str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<f> b(int i4) {
        boolean z3;
        try {
            List<String> a4 = g.a(new String[]{cn.jiguang.ao.c.b(f3566a)}, 1);
            if (a4 != null && !a4.isEmpty()) {
                HashSet hashSet = new HashSet();
                ArrayList arrayList = new ArrayList();
                Map<String, Integer> a5 = a(a4.remove(0));
                for (String str : a4) {
                    f a6 = a(str, a5);
                    if (a6 != null) {
                        if (i4 == 3 || !b(a6.f3515c)) {
                            if (!"ps".equals(a6.f3516d)) {
                                a(a6);
                                arrayList.add(a6);
                            }
                        } else if (c(a6.f3516d)) {
                            hashSet.add(a6.f3514b);
                        }
                    }
                }
                if (i4 != 1 || hashSet.isEmpty()) {
                    return arrayList;
                }
                ArrayList arrayList2 = new ArrayList();
                for (boolean z4 = false; !z4; z4 = z3) {
                    Iterator it = arrayList.iterator();
                    z3 = true;
                    while (it.hasNext()) {
                        f fVar = (f) it.next();
                        if (hashSet.contains(fVar.f3515c)) {
                            arrayList2.add(fVar);
                            hashSet.add(fVar.f3514b);
                            it.remove();
                            z3 = false;
                        }
                    }
                }
                return arrayList2;
            }
            cn.jiguang.w.a.b("JProcessHelper", "execute command failed");
            return null;
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JProcessHelper", "getRunningProcessInfo throwable:" + th.getMessage());
            return null;
        }
    }

    private static boolean b(String str) {
        return str.equals("0") || str.equals("1") || str.equals("2");
    }

    private static boolean c(String str) {
        return f3568c.matcher(str).matches();
    }
}
