package cn.jiguang.bb;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.ax.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f2550a = "";

    private static cn.jiguang.ba.a a(String str, int i4, List<cn.jiguang.ba.a> list) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            for (cn.jiguang.ba.a aVar : list) {
                if (a(str, i4, aVar)) {
                    return aVar;
                }
            }
        }
        return null;
    }

    public static String a(final Context context) {
        Object a4 = cn.jiguang.ax.d.a(context, 1012, 1800000L, 864000000L, new d.a() { // from class: cn.jiguang.bb.c.1
            @Override // cn.jiguang.ax.d.b
            public Object a() {
                return c.f2550a;
            }

            @Override // cn.jiguang.ax.d.b
            public void a(Object obj) {
                if (obj instanceof String) {
                    c.f2550a = (String) obj;
                }
            }

            @Override // cn.jiguang.ax.d.b
            public Object b() {
                return c.d(context);
            }
        });
        return cn.jiguang.ax.e.a(a4) ? "" : (String) a4;
    }

    public static String a(Context context, String str) {
        String e4 = cn.jiguang.ah.d.e(context, "");
        if (TextUtils.isEmpty(e4)) {
            ArrayList<cn.jiguang.ba.a> b4 = b.b(context);
            if (b4 != null && !b4.isEmpty()) {
                Iterator<cn.jiguang.ba.a> it = b4.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    cn.jiguang.ba.a next = it.next();
                    if (!TextUtils.isEmpty(next.f2519a)) {
                        str = next.f2519a;
                        break;
                    }
                }
            }
            return str;
        }
        return e4;
    }

    private static List<cn.jiguang.ba.a> a(String str, int i4, List<cn.jiguang.ba.a> list, cn.jiguang.ba.a aVar) {
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str) || aVar == null) {
            return null;
        }
        Iterator<cn.jiguang.ba.a> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            cn.jiguang.ba.a next = it.next();
            if (a(str, i4, next)) {
                next.f2520b = aVar.f2520b;
                next.f2521c = aVar.f2521c;
                break;
            }
        }
        return list;
    }

    private static boolean a(String str) {
        return (TextUtils.isEmpty(str) || str.trim().length() == 0 || str.length() != 14) ? false : true;
    }

    private static boolean a(String str, int i4, cn.jiguang.ba.a aVar) {
        return i4 != 0 ? i4 != 1 ? i4 == 2 && str.equals(aVar.f2521c) : str.equals(aVar.f2520b) : str.equals(aVar.f2519a);
    }

    public static List<cn.jiguang.ba.a> b(Context context) {
        cn.jiguang.ba.a a4;
        cn.jiguang.ba.a a5 = b.a(context);
        ArrayList<cn.jiguang.ba.a> a6 = d.a(context);
        ArrayList<cn.jiguang.ba.a> b4 = b.b(context);
        if (a6 != null && !a6.isEmpty()) {
            for (int size = a6.size() - 1; size >= 0; size--) {
                if (a6.get(size).b()) {
                    a6.remove(size);
                }
            }
        }
        if (a6 != null && !a6.isEmpty()) {
            for (cn.jiguang.ba.a aVar : a6) {
                if (TextUtils.isEmpty(aVar.f2519a) && !TextUtils.isEmpty(aVar.f2520b)) {
                    cn.jiguang.ba.a a7 = a(aVar.f2520b, 1, b4);
                    if (a7 != null) {
                        aVar.f2519a = a7.f2519a;
                    }
                } else if (TextUtils.isEmpty(aVar.f2520b) && !TextUtils.isEmpty(aVar.f2519a) && (a4 = a(aVar.f2519a, 1, b4)) != null) {
                    aVar.f2520b = a4.f2520b;
                    aVar.f2521c = a4.f2521c;
                }
            }
            return a6;
        } else if (a5 == null || a5.b()) {
            return b4;
        } else {
            if (b4 == null || b4.size() != 1) {
                cn.jiguang.ba.a a8 = a(a5.f2519a, 0, b4);
                return (a8 != null && TextUtils.isEmpty(a8.f2520b) && a(a5.f2520b, 1, b4) == null) ? a(a5.f2519a, 0, b4, a5) : b4;
            }
            if (TextUtils.isEmpty(a5.f2519a) || !a5.f2519a.equals(b4.get(0).f2519a)) {
                if (!TextUtils.isEmpty(a5.f2520b) && a5.f2520b.equals(b4.get(0).f2520b)) {
                    a5.f2520b = "";
                    a5.f2521c = "";
                    if (a5.b()) {
                        return b4;
                    }
                }
            } else if (TextUtils.isEmpty(a5.f2520b) || a5.f2520b.equals(b4.get(0).f2520b)) {
                return b4;
            }
            b4.add(a5);
            return b4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(Context context) {
        StringBuilder sb;
        String str;
        String e4 = cn.jiguang.ah.d.e(context, "");
        if (a(e4)) {
            sb = new StringBuilder();
            str = "JCommonPresenter.getImei is ";
        } else if (!TextUtils.isEmpty(e4)) {
            sb = new StringBuilder();
            str = "getMeidForM or O is ";
        } else if (!a(e4)) {
            return "";
        } else {
            sb = new StringBuilder();
            str = "JDeviceImeiHelper.getMeid is ";
        }
        sb.append(str);
        sb.append(e4);
        cn.jiguang.w.a.b("JDeviceSimHelper", sb.toString());
        return e4;
    }
}
