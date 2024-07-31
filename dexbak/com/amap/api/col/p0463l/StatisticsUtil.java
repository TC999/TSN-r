package com.amap.api.col.p0463l;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.amap.api.col.3l.x2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class StatisticsUtil {

    /* renamed from: a */
    private static boolean f5658a;

    /* renamed from: b */
    private static boolean f5659b;

    /* renamed from: c */
    private static boolean f5660c;

    /* renamed from: d */
    private static boolean f5661d;

    /* renamed from: e */
    private static boolean f5662e;

    /* renamed from: f */
    private static boolean f5663f;

    /* renamed from: g */
    private static boolean f5664g;

    /* renamed from: h */
    private static boolean f5665h;

    /* renamed from: i */
    private static boolean f5666i;

    /* renamed from: j */
    private static boolean f5667j;

    /* renamed from: k */
    private static HashMap<String, Boolean> f5668k = new HashMap<>();

    /* renamed from: l */
    private static ConcurrentHashMap<Integer, Integer> f5669l = new ConcurrentHashMap<>();

    /* renamed from: m */
    private static ConcurrentHashMap<Integer, Integer> f5670m = new ConcurrentHashMap<>();

    /* renamed from: a */
    private static <T> String m53560a(Map<String, T> map) {
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

    /* renamed from: b */
    private static String m53559b(boolean z) {
        try {
            return "{\"Quest\":" + z + "}";
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public static void m53558c(Context context) {
        if (f5660c) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_heatmap", 1);
            m53552i(context, "O009", m53560a(hashMap));
            f5660c = true;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: d */
    public static void m53557d(Context context, int i) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_draw_fail", Integer.valueOf(i));
            m53552i(context, "O023", m53560a(hashMap));
        } catch (Throwable unused) {
        }
    }

    /* renamed from: e */
    public static void m53556e(Context context, int i, int i2, String str) {
        if (context == null) {
            return;
        }
        try {
            synchronized (f5669l) {
                if (!f5669l.containsKey(Integer.valueOf(i)) || f5669l.get(Integer.valueOf(i)).intValue() < 2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("amap_3dmap_map_request_type", String.valueOf(i2));
                    hashMap.put("amap_3dmap_map_request_info", str);
                    m53552i(context, "O019", m53560a(hashMap));
                    if (!f5669l.containsKey(Integer.valueOf(i))) {
                        f5669l.put(Integer.valueOf(i), 0);
                    } else {
                        f5669l.put(Integer.valueOf(i), Integer.valueOf(f5669l.get(Integer.valueOf(i)).intValue() + 1));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: f */
    public static void m53555f(Context context, int i, long j, long j2) {
        try {
            synchronized (f5670m) {
                if (!f5670m.containsKey(Integer.valueOf(i)) || f5670m.get(Integer.valueOf(i)).intValue() < 2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("amap_3dmap_map_request_rendertime", Long.valueOf(j));
                    hashMap.put("amap_3dmap_map_request_size", Long.valueOf(j2));
                    m53552i(context, "O020", m53560a(hashMap));
                    if (!f5670m.containsKey(Integer.valueOf(i))) {
                        f5670m.put(Integer.valueOf(i), 0);
                    } else {
                        f5670m.put(Integer.valueOf(i), Integer.valueOf(f5670m.get(Integer.valueOf(i)).intValue() + 1));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: g */
    public static void m53554g(Context context, long j) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_rendertime", Long.valueOf(j));
            hashMap.put("amap_3dmap_render_background", 0L);
            m53552i(context, "O005", m53560a(hashMap));
        } catch (Throwable unused) {
        }
    }

    /* renamed from: h */
    public static synchronized void m53553h(Context context, String str) {
        synchronized (StatisticsUtil.class) {
            try {
                if (f5668k != null && !TextUtils.isEmpty(str)) {
                    if (f5668k.containsKey(str) && f5668k.get(str).booleanValue()) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("amap_3dmap_coordinate", str);
                    m53552i(context, "O008", m53560a(hashMap));
                    if (!f5668k.containsKey(str)) {
                        f5668k.put(str, Boolean.TRUE);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: i */
    private static void m53552i(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        try {
            StatisticsEntity statisticsEntity = new StatisticsEntity(context, "3dmap", "10.0.600", str);
            statisticsEntity.m55025a(str2);
            StatisticsManager.m54911d(statisticsEntity, context);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: j */
    public static void m53551j(Context context, boolean z) {
        try {
            String m53559b = m53559b(z);
            StatisticsEntity statisticsEntity = new StatisticsEntity(context, "3dmap", "10.0.600", "O001");
            statisticsEntity.m55025a(m53559b);
            StatisticsManager.m54911d(statisticsEntity, context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: k */
    public static void m53550k(Context context) {
        if (f5661d) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_offlinemap", 1);
            m53552i(context, "O010", m53560a(hashMap));
            f5661d = true;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: l */
    public static void m53549l(Context context, String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_engine_init_fail", str);
            m53552i(context, "O021", m53560a(hashMap));
        } catch (Throwable unused) {
        }
    }

    /* renamed from: m */
    public static void m53548m(Context context, boolean z) {
        if (f5658a) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_stylemap", Integer.valueOf(z ? 1 : 0));
            m53552i(context, "O006", m53560a(hashMap));
            f5658a = true;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: n */
    public static void m53547n(Context context) {
        if (f5662e) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_particleoverlay", 1);
            m53552i(context, "O011", m53560a(hashMap));
            f5662e = true;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: o */
    public static void m53546o(Context context, String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_res_load_fail", str);
            m53552i(context, "O022", m53560a(hashMap));
        } catch (Throwable unused) {
        }
    }

    /* renamed from: p */
    public static void m53545p(Context context, boolean z) {
        if (f5659b) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_indoormap", Integer.valueOf(z ? 1 : 0));
            m53552i(context, "O007", m53560a(hashMap));
            f5659b = true;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: q */
    public static void m53544q(Context context) {
        if (f5664g) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_bzmapreview", 1);
            m53552i(context, "O012", m53560a(hashMap));
            f5664g = true;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: r */
    public static void m53543r(Context context) {
        if (f5665h) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_wxmapreview", 1);
            m53552i(context, "O013", m53560a(hashMap));
            f5665h = true;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: s */
    public static void m53542s(Context context) {
        if (f5666i) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_dxmapreview", 1);
            m53552i(context, "0016", m53560a(hashMap));
            f5666i = true;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: t */
    public static void m53541t(Context context) {
        if (f5663f) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_renderfps", 1);
            m53552i(context, "O014", m53560a(hashMap));
            f5663f = true;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: u */
    public static void m53540u(Context context) {
        if (f5667j) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_buildingoverlay", 1);
            m53552i(context, "O015", m53560a(hashMap));
            f5667j = true;
        } catch (Throwable unused) {
        }
    }
}
