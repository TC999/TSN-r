package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: StatisticsUtil.java */
/* renamed from: com.amap.api.col.3l.x2  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class x2 {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f9389a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f9390b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f9391c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f9392d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f9393e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f9394f;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f9395g;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f9396h;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f9397i;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f9398j;

    /* renamed from: k  reason: collision with root package name */
    private static HashMap<String, Boolean> f9399k = new HashMap<>();

    /* renamed from: l  reason: collision with root package name */
    private static ConcurrentHashMap<Integer, Integer> f9400l = new ConcurrentHashMap<>();

    /* renamed from: m  reason: collision with root package name */
    private static ConcurrentHashMap<Integer, Integer> f9401m = new ConcurrentHashMap<>();

    private static <T> String a(Map<String, T> map) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            for (Map.Entry<String, T> entry : map.entrySet()) {
                sb.append("\"" + entry.getKey() + "\":");
                sb.append(entry.getValue());
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("}");
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String b(boolean z3) {
        try {
            return "{\"Quest\":" + z3 + "}";
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void c(Context context) {
        if (f9391c) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_heatmap", 1);
            i(context, "O009", a(hashMap));
            f9391c = true;
        } catch (Throwable unused) {
        }
    }

    public static void d(Context context, int i4) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_draw_fail", Integer.valueOf(i4));
            i(context, "O023", a(hashMap));
        } catch (Throwable unused) {
        }
    }

    public static void e(Context context, int i4, int i5, String str) {
        if (context == null) {
            return;
        }
        try {
            synchronized (f9400l) {
                if (!f9400l.containsKey(Integer.valueOf(i4)) || f9400l.get(Integer.valueOf(i4)).intValue() < 2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("amap_3dmap_map_request_type", String.valueOf(i5));
                    hashMap.put("amap_3dmap_map_request_info", str);
                    i(context, "O019", a(hashMap));
                    if (!f9400l.containsKey(Integer.valueOf(i4))) {
                        f9400l.put(Integer.valueOf(i4), 0);
                    } else {
                        f9400l.put(Integer.valueOf(i4), Integer.valueOf(f9400l.get(Integer.valueOf(i4)).intValue() + 1));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void f(Context context, int i4, long j4, long j5) {
        try {
            synchronized (f9401m) {
                if (!f9401m.containsKey(Integer.valueOf(i4)) || f9401m.get(Integer.valueOf(i4)).intValue() < 2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("amap_3dmap_map_request_rendertime", Long.valueOf(j4));
                    hashMap.put("amap_3dmap_map_request_size", Long.valueOf(j5));
                    i(context, "O020", a(hashMap));
                    if (!f9401m.containsKey(Integer.valueOf(i4))) {
                        f9401m.put(Integer.valueOf(i4), 0);
                    } else {
                        f9401m.put(Integer.valueOf(i4), Integer.valueOf(f9401m.get(Integer.valueOf(i4)).intValue() + 1));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void g(Context context, long j4) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_rendertime", Long.valueOf(j4));
            hashMap.put("amap_3dmap_render_background", 0L);
            i(context, "O005", a(hashMap));
        } catch (Throwable unused) {
        }
    }

    public static synchronized void h(Context context, String str) {
        synchronized (x2.class) {
            try {
                if (f9399k != null && !TextUtils.isEmpty(str)) {
                    if (f9399k.containsKey(str) && f9399k.get(str).booleanValue()) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("amap_3dmap_coordinate", str);
                    i(context, "O008", a(hashMap));
                    if (!f9399k.containsKey(str)) {
                        f9399k.put(str, Boolean.TRUE);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static void i(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        try {
            g7 g7Var = new g7(context, "3dmap", "10.0.600", str);
            g7Var.a(str2);
            h7.d(g7Var, context);
        } catch (Throwable unused) {
        }
    }

    public static void j(Context context, boolean z3) {
        try {
            String b4 = b(z3);
            g7 g7Var = new g7(context, "3dmap", "10.0.600", "O001");
            g7Var.a(b4);
            h7.d(g7Var, context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void k(Context context) {
        if (f9392d) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_offlinemap", 1);
            i(context, "O010", a(hashMap));
            f9392d = true;
        } catch (Throwable unused) {
        }
    }

    public static void l(Context context, String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_engine_init_fail", str);
            i(context, "O021", a(hashMap));
        } catch (Throwable unused) {
        }
    }

    public static void m(Context context, boolean z3) {
        if (f9389a) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_stylemap", Integer.valueOf(z3 ? 1 : 0));
            i(context, "O006", a(hashMap));
            f9389a = true;
        } catch (Throwable unused) {
        }
    }

    public static void n(Context context) {
        if (f9393e) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_particleoverlay", 1);
            i(context, "O011", a(hashMap));
            f9393e = true;
        } catch (Throwable unused) {
        }
    }

    public static void o(Context context, String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_res_load_fail", str);
            i(context, "O022", a(hashMap));
        } catch (Throwable unused) {
        }
    }

    public static void p(Context context, boolean z3) {
        if (f9390b) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_indoormap", Integer.valueOf(z3 ? 1 : 0));
            i(context, "O007", a(hashMap));
            f9390b = true;
        } catch (Throwable unused) {
        }
    }

    public static void q(Context context) {
        if (f9395g) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_bzmapreview", 1);
            i(context, "O012", a(hashMap));
            f9395g = true;
        } catch (Throwable unused) {
        }
    }

    public static void r(Context context) {
        if (f9396h) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_wxmapreview", 1);
            i(context, "O013", a(hashMap));
            f9396h = true;
        } catch (Throwable unused) {
        }
    }

    public static void s(Context context) {
        if (f9397i) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_dxmapreview", 1);
            i(context, "0016", a(hashMap));
            f9397i = true;
        } catch (Throwable unused) {
        }
    }

    public static void t(Context context) {
        if (f9394f) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_renderfps", 1);
            i(context, "O014", a(hashMap));
            f9394f = true;
        } catch (Throwable unused) {
        }
    }

    public static void u(Context context) {
        if (f9398j) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_buildingoverlay", 1);
            i(context, "O015", a(hashMap));
            f9398j = true;
        } catch (Throwable unused) {
        }
    }
}
