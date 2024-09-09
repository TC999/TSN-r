package cn.jiguang.bu;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.cn.d;
import cn.jiguang.g.b;
import java.util.LinkedHashMap;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2903a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f2904b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f2905c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f2906d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f2907e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f2908f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f2909g;

    /* renamed from: h  reason: collision with root package name */
    public static final String f2910h;

    /* renamed from: i  reason: collision with root package name */
    public static final String f2911i;

    /* renamed from: j  reason: collision with root package name */
    public static final String f2912j;

    /* renamed from: k  reason: collision with root package name */
    public static final String f2913k;

    /* renamed from: l  reason: collision with root package name */
    public static String f2914l;

    /* renamed from: m  reason: collision with root package name */
    public static int f2915m;

    /* renamed from: n  reason: collision with root package name */
    public static String f2916n;

    /* renamed from: o  reason: collision with root package name */
    public static int f2917o;

    /* renamed from: p  reason: collision with root package name */
    private static final LinkedHashMap<String, Integer> f2918p;

    /* renamed from: q  reason: collision with root package name */
    private static final LinkedHashMap<String, Integer> f2919q;

    /* renamed from: r  reason: collision with root package name */
    private static final LinkedHashMap<String, Integer> f2920r;

    /* renamed from: s  reason: collision with root package name */
    private static final LinkedHashMap<String, Integer> f2921s;

    /* renamed from: t  reason: collision with root package name */
    private static String f2922t;

    /* renamed from: u  reason: collision with root package name */
    private static String f2923u;

    /* renamed from: v  reason: collision with root package name */
    private static String f2924v;

    /* renamed from: w  reason: collision with root package name */
    private static String f2925w;

    static {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        f2918p = linkedHashMap;
        String b4 = d.b(new byte[]{98, 30, 74, 105, 125, 101, 121, 30, 67, 119});
        f2903a = b4;
        String b5 = d.b(new byte[]{83, 112, 123, 56, 123, 64, 85, 106, 96, 56, 120, 95});
        f2904b = b5;
        String b6 = d.b(new byte[]{85, 65, 106, 113, 98, 126, 93, 69, 106, 123, 119, 118, 85, 14, 122, 103, 123});
        f2905c = b6;
        String b7 = d.b(new byte[]{67, 73, 106, 37, Byte.MAX_VALUE, 97, 70, 22, 55, 98, 102, 100, 67, 72, 55, 107, 120});
        f2906d = b7;
        linkedHashMap.put(b4, 19000);
        linkedHashMap.put(b5, 19000);
        linkedHashMap.put(b6, 19000);
        linkedHashMap.put(b7, 19000);
        String b8 = d.b(new byte[]{17, 42, 49, 56, 40, 30, 20, 47, 38, 39, 32, 7});
        f2907e = b8;
        String b9 = d.b(new byte[]{40, 58, 34, 63, 7, 16, 55, 57, 35, 40, 30, 21, 32});
        f2908f = b9;
        String b10 = d.b(new byte[]{40, 58, 39, 63, 3, 23, 55, 58, 37, 39, 30, 17, 43});
        f2909g = b10;
        String b11 = d.b(new byte[]{17, 43, 59, 56, 39, 0, 14, 45, 63, 56, 37, 2});
        f2910h = b11;
        LinkedHashMap<String, Integer> linkedHashMap2 = new LinkedHashMap<>();
        f2919q = linkedHashMap2;
        try {
            linkedHashMap2.put(b8, 19000);
            linkedHashMap2.put(b9, 19000);
            linkedHashMap2.put(b10, 19000);
            linkedHashMap2.put(b11, 19000);
        } catch (Throwable unused) {
        }
        f2911i = d.b(new byte[]{112, 101, 32, 37, 30, 74, 105, 125, 101, 121, 30, 67, 119});
        f2912j = d.b(new byte[]{70, 97, 123, 39, 4, 14, 70, 124, 117, 97, 30, 74, 105, 125, 101, 121, 30, 67, 119});
        f2913k = d.b(new byte[]{70, 120, 101, 120, 67, 14, 70, 125, 114, 97, 30, 74, 105, 125, 101, 121, 30, 67, 119});
        f2920r = new LinkedHashMap<>();
        f2921s = new LinkedHashMap<>();
        f2922t = "";
        f2923u = "";
        f2924v = "";
        f2925w = "";
    }

    public static String a(Context context) {
        if (!JCoreManager.isTestEnv() || TextUtils.isEmpty(f2922t)) {
            String str = (String) b.b(context, cn.jiguang.g.a.aq());
            return !TextUtils.isEmpty(str) ? str : f2911i;
        }
        return f2922t;
    }

    public static LinkedHashMap<String, Integer> a() {
        if (JCoreManager.isTestEnv()) {
            LinkedHashMap<String, Integer> linkedHashMap = f2920r;
            if (!linkedHashMap.isEmpty()) {
                return linkedHashMap;
            }
        }
        return f2918p;
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            cn.jiguang.bq.d.i("HostConfig", "conn info was empty");
            return;
        }
        cn.jiguang.bq.d.c("HostConfig", "get conn info=" + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("srv");
            cn.jiguang.bq.d.c("HostConfig", "save srvHost:" + optString);
            if (!TextUtils.isEmpty(optString)) {
                b.a(context, cn.jiguang.g.a.ar().a((cn.jiguang.g.a<String>) optString));
            }
            String optString2 = jSONObject.optString("conn");
            cn.jiguang.bq.d.c("HostConfig", "save connHost:" + optString2);
            if (TextUtils.isEmpty(optString2)) {
                return;
            }
            b.a(context, cn.jiguang.g.a.aq().a((cn.jiguang.g.a<String>) optString2));
        } catch (Throwable unused) {
        }
    }

    public static String b(Context context) {
        if (!JCoreManager.isTestEnv() || TextUtils.isEmpty(f2923u)) {
            String str = (String) b.b(context, cn.jiguang.g.a.ar());
            return !TextUtils.isEmpty(str) ? str : f2912j;
        }
        return f2923u;
    }

    public static LinkedHashMap<String, Integer> b() {
        if (JCoreManager.isTestEnv()) {
            LinkedHashMap<String, Integer> linkedHashMap = f2921s;
            if (!linkedHashMap.isEmpty()) {
                return linkedHashMap;
            }
        }
        return f2919q;
    }

    public static String c() {
        return (!JCoreManager.isTestEnv() || TextUtils.isEmpty(f2924v)) ? f2913k : f2924v;
    }

    public static String d() {
        return (!JCoreManager.isTestEnv() || TextUtils.isEmpty(f2925w)) ? "" : f2925w;
    }
}
