package cn.jiguang.bb;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import cn.jiguang.ag.h;
import cn.jiguang.ao.g;
import cn.jiguang.ax.d;
import cn.jiguang.ax.e;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.stub.StubApp;
import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {
    private static List<String> A = null;
    private static SimpleDateFormat B = null;
    private static long C = 0;
    private static String D = null;
    private static final FileFilter E;
    private static JSONObject F = null;

    /* renamed from: a  reason: collision with root package name */
    public static JSONArray f2522a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f2523b = "";

    /* renamed from: c  reason: collision with root package name */
    private static String f2524c = "";

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f2525d = {123, 98, 112, 68, 0, 52, 110, 54};

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f2526e = {67, 84, 120, 124, 54};

    /* renamed from: f  reason: collision with root package name */
    private static final String f2527f;

    /* renamed from: g  reason: collision with root package name */
    private static final String f2528g;

    /* renamed from: h  reason: collision with root package name */
    private static final String f2529h;

    /* renamed from: i  reason: collision with root package name */
    private static final String f2530i;

    /* renamed from: j  reason: collision with root package name */
    private static final String f2531j;

    /* renamed from: k  reason: collision with root package name */
    private static final String f2532k;

    /* renamed from: l  reason: collision with root package name */
    private static final String f2533l;

    /* renamed from: m  reason: collision with root package name */
    private static final String f2534m;

    /* renamed from: n  reason: collision with root package name */
    private static final String f2535n;

    /* renamed from: o  reason: collision with root package name */
    private static final String f2536o;

    /* renamed from: p  reason: collision with root package name */
    private static final String f2537p;

    /* renamed from: q  reason: collision with root package name */
    private static final String f2538q;

    /* renamed from: r  reason: collision with root package name */
    private static final String f2539r;

    /* renamed from: s  reason: collision with root package name */
    private static final String f2540s;

    /* renamed from: t  reason: collision with root package name */
    private static final String f2541t;

    /* renamed from: u  reason: collision with root package name */
    private static final String f2542u;

    /* renamed from: v  reason: collision with root package name */
    private static final String f2543v;

    /* renamed from: w  reason: collision with root package name */
    private static final String f2544w;

    /* renamed from: x  reason: collision with root package name */
    private static final String f2545x;

    /* renamed from: y  reason: collision with root package name */
    private static Map<String, String> f2546y;

    /* renamed from: z  reason: collision with root package name */
    private static List<String> f2547z;

    static {
        String b4 = cn.jiguang.ao.c.b(new byte[]{54});
        f2527f = b4;
        String b5 = cn.jiguang.ao.c.b(new byte[]{62, 84, 65, 109, 105, 57, 117, 81, 84, 120});
        f2528g = b5;
        String b6 = cn.jiguang.ao.c.b(new byte[]{31, 83, 96, 123, 98, 116, 93, 15, 124, 124, 117});
        f2529h = b6;
        String b7 = cn.jiguang.ao.c.b(new byte[]{31, 83, 109, 103, 100, 112, 87, 69, 54, 109, 123, 100, 92, 65, 109, 109, 114});
        f2530i = b7;
        String b8 = cn.jiguang.ao.c.b(new byte[]{54, 123, 98, 126, 66, 65, 126, 109, 57, 116, 93, 85, 117, 105, 98, 116, 84, 15, 41});
        f2531j = b8;
        String b9 = cn.jiguang.ao.c.b(new byte[]{62, 84, 65, 109, 105, 57, 100, 67, 69, 107});
        f2532k = b9;
        String b10 = cn.jiguang.ao.c.b(new byte[]{62, 93, 78, 109});
        f2533l = b10;
        String b11 = cn.jiguang.ao.c.b(new byte[]{31, 83, 96, 123, 98, 116, 93, 15, 120, 120, 102});
        f2534m = b11;
        String b12 = cn.jiguang.ao.c.b(new byte[]{62, 67, 89, 106, 124, 115, 124, 31, 80, 107, 97, 96, 60, 81, 80, 105});
        f2535n = b12;
        String b13 = cn.jiguang.ao.c.b(new byte[]{31, 83, 96, 123, 98, 116, 93, 15, 123, 97, 120});
        f2536o = b13;
        String b14 = cn.jiguang.ao.c.b(new byte[]{31, 83, 96, 123, 98, 116, 93, 15, 108, 123, 100});
        f2537p = b14;
        String b15 = cn.jiguang.ao.c.b(new byte[]{31, 65, 122, 107, 98});
        f2538q = b15;
        String b16 = cn.jiguang.ao.c.b(new byte[]{62, 84, 69, 111});
        f2539r = b16;
        String b17 = cn.jiguang.ao.c.b(new byte[]{54, 107, 121, Byte.MAX_VALUE, 86, 73, 126});
        f2540s = b17;
        String b18 = cn.jiguang.ao.c.b(new byte[]{31, 68, 120, 124, 119});
        f2541t = b18;
        String b19 = cn.jiguang.ao.c.b(new byte[]{39, 102, 99, 95, 68, 108, 107, 98});
        f2542u = b19;
        String b20 = cn.jiguang.ao.c.b(new byte[]{62, 67, 89, 106});
        f2543v = b20;
        String b21 = cn.jiguang.ao.c.b(new byte[]{54, 123, 111, 98, 68, 69, 116, 39, 112, 126, 94, 84, 106});
        f2544w = b21;
        String b22 = cn.jiguang.ao.c.b(new byte[]{31, 83, 96, 123, 98, 116, 93, 15, Byte.MAX_VALUE, 122, 119, 124, 85, 87, 118, 122, 125});
        f2545x = b22;
        f2546y = new HashMap();
        f2547z = new ArrayList();
        A = new ArrayList();
        B = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSSSSS Z");
        C = 31536000000L;
        f2546y.put(b4, "p_root");
        f2546y.put(b5, "p_data");
        f2546y.put(b6, "p_etc");
        f2546y.put(b7, "p_emu");
        f2546y.put(b8, "p_emu0");
        f2546y.put(b9, "p_user");
        f2546y.put(b10, "p_mnt");
        f2546y.put(b11, "p_app");
        f2546y.put(b12, "p_papp");
        f2546y.put(b13, "p_bin");
        f2546y.put(b14, "p_usr");
        f2546y.put(b15, "p_acct");
        f2546y.put(b16, "p_dev");
        f2546y.put(b17, "p_con");
        f2546y.put(b18, "p_datas");
        f2546y.put(b19, "p_pro");
        f2546y.put(b20, "p_sys");
        f2546y.put(b21, "p_sfont");
        f2546y.put(b22, "p_fram");
        f2547z.add(b5);
        f2547z.add(b9);
        A.add(":00:00.");
        E = new FileFilter() { // from class: cn.jiguang.bb.a.2
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                String name = file.getName();
                if (name.startsWith("cpu")) {
                    for (int i4 = 3; i4 < name.length(); i4++) {
                        if (name.charAt(i4) < '0' || name.charAt(i4) > '9') {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
        };
        f2522a = new JSONArray();
    }

    public static String a(final Context context) {
        Object b4 = cn.jiguang.ax.d.b(context, 1020, true, false, (d.b) new d.a() { // from class: cn.jiguang.bb.a.1
            @Override // cn.jiguang.ax.d.b
            public Object a() {
                return a.D;
            }

            @Override // cn.jiguang.ax.d.b
            public void a(Object obj) {
                if (obj instanceof String) {
                    String unused = a.D = (String) obj;
                }
            }

            @Override // cn.jiguang.ax.d.b
            public Object b() {
                return a.i(context);
            }
        });
        if (b4 instanceof String) {
            D = (String) b4;
        }
        return D;
    }

    public static String a(Context context, int i4) {
        if (i4 != 53) {
            return null;
        }
        try {
            String d4 = d(context);
            if (TextUtils.isEmpty(d4)) {
                d4 = c(context);
            }
            JSONObject jSONObject = new JSONObject(d4);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(JThirdPlatFormInterface.KEY_ROM_TYPE, (int) cn.jiguang.ah.d.p(context));
            jSONObject2.put("regid", cn.jiguang.ah.d.q(context));
            jSONObject.put("rom_info", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("cmd", 53);
            jSONObject3.put("content", jSONObject);
            return jSONObject3.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public static void a(Context context, String str) {
        cn.jiguang.ai.b.a(context, new cn.jiguang.ai.a("cn.jpush.preferences.v2", "n_udp_report_device_info", "").a(Base64.encodeToString(str.getBytes(), 2)));
        cn.jiguang.w.a.b("JDeviceHelper", "save device info:" + str);
    }

    private static String b(String str) {
        List<String> a4 = g.a(new String[]{cn.jiguang.ao.c.b(f2525d) + str}, 1);
        StringBuilder sb = new StringBuilder();
        for (String str2 : a4) {
            if (str2.startsWith("Blocks")) {
                int indexOf = str2.indexOf("Blocks:");
                int indexOf2 = str2.indexOf("Free:");
                if (indexOf >= 0 && indexOf2 >= 0) {
                    sb.append(str2.substring(indexOf + 15, indexOf2));
                }
            }
            if (str2.contains("ID")) {
                int indexOf3 = str2.indexOf("ID:");
                int indexOf4 = str2.indexOf("Namelen:");
                if (indexOf3 >= 0 && indexOf4 >= 0) {
                    sb.append(str2.substring(indexOf3 + 3, indexOf4));
                }
            }
        }
        return sb.toString();
    }

    public static JSONArray b(final Context context) {
        if (cn.jiguang.ar.a.a().g(1022)) {
            return new JSONArray();
        }
        Object a4 = cn.jiguang.ax.e.a(context, 1022, new e.a() { // from class: cn.jiguang.bb.a.3
            @Override // cn.jiguang.ax.e.b
            public Object a() {
                return a.f2522a.length() > 0 ? a.f2522a.toString() : "";
            }

            @Override // cn.jiguang.ax.e.b
            public void a(Object obj) {
                try {
                    a.f2522a = new JSONArray((String) obj);
                } catch (Throwable unused) {
                }
            }

            @Override // cn.jiguang.ax.e.b
            public Object b() {
                JSONArray j4 = a.j(context);
                return j4.length() > 0 ? j4.toString() : "";
            }
        });
        JSONArray jSONArray = new JSONArray();
        try {
            return !cn.jiguang.ax.e.a(a4) ? new JSONArray((String) a4) : jSONArray;
        } catch (Throwable unused) {
            return jSONArray;
        }
    }

    public static String c(Context context) {
        try {
            cn.jiguang.al.a a4 = cn.jiguang.al.a.a(context);
            JSONObject jSONObject = new JSONObject();
            if (cn.jiguang.ar.a.a().e(1022)) {
                jSONObject.put("sim_slots", b(context));
            }
            jSONObject.put("packagename", context.getPackageName());
            jSONObject.put("appkey", cn.jiguang.ah.d.b(context));
            jSONObject.put("platform", 0);
            jSONObject.put("apkversion", a4.f2282a);
            jSONObject.put("systemversion", a4.f2283b);
            if (cn.jiguang.ar.a.a().e(2009)) {
                jSONObject.put("modelnumber", a4.f2284c);
            }
            if (cn.jiguang.ar.a.a().e(2001)) {
                jSONObject.put("basebandversion", a4.f2285d);
            }
            jSONObject.put("buildnumber", a4.f2286e);
            jSONObject.put("channel", a4.f2287f);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("PushSDKVer", cn.jiguang.ah.d.b(0));
            jSONObject2.put("StatisticSDKVer", cn.jiguang.ah.d.b(1));
            jSONObject2.put("ShareSDKVer", cn.jiguang.ah.d.b(2));
            jSONObject2.put("CoreSDKVer", cn.jiguang.ah.d.b(3));
            jSONObject2.put("SspSDKVer", cn.jiguang.ah.d.b(4));
            jSONObject2.put("VerificationSDKVer", cn.jiguang.ah.d.b(5));
            jSONObject.put("sdkver", jSONObject2);
            jSONObject.put("installation", a4.f2288g);
            jSONObject.put("business", cn.jiguang.ah.d.g());
            jSONObject.put("device_id_status", cn.jiguang.ah.d.j(context));
            jSONObject.put("device_id", cn.jiguang.ah.d.h(context));
            if (cn.jiguang.ar.a.a().e(2012)) {
                jSONObject.put("resolution", a4.f2289h);
            }
            if (cn.jiguang.ar.a.a().e(2000)) {
                jSONObject.put("android_id", a4.f2290i);
            }
            if (cn.jiguang.ar.a.a().e(2007)) {
                jSONObject.put("mac_address", cn.jiguang.ah.d.c(context, ""));
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    private static String c(String str) {
        for (String str2 : g.a(new String[]{cn.jiguang.ao.c.b(f2526e) + str}, 1)) {
            if (str2.startsWith("Access:")) {
                try {
                    String trim = str2.replace("Access:", "").trim();
                    for (String str3 : A) {
                        if (trim.contains(str3)) {
                            return null;
                        }
                    }
                    if (Math.abs(B.parse(trim).getTime() - System.currentTimeMillis()) > C) {
                        return trim;
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return null;
    }

    public static String d(Context context) {
        String str;
        String str2 = (String) cn.jiguang.ai.b.b(context, new cn.jiguang.ai.a("cn.jpush.preferences.v2", "n_udp_report_device_info", ""));
        if (TextUtils.isEmpty(str2)) {
            str = (String) cn.jiguang.ai.b.b(context, new cn.jiguang.ai.a("cn.jpush.preferences.v2", "udp_report_device_info", ""));
            if (!TextUtils.isEmpty(str)) {
                a(context, str);
            }
        } else {
            str = new String(Base64.decode(str2, 2));
        }
        cn.jiguang.w.a.b("JDeviceHelper", "read deviceinfo:" + str);
        return str;
    }

    public static JSONObject e(Context context) {
        try {
            String j4 = cn.jiguang.h.a.j(context);
            if (TextUtils.isEmpty(j4)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(j4);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(BidResponsedEx.KEY_CID, jSONObject.optString("deviceId", ""));
            jSONObject2.put("imei", jSONObject.optString("imei", ""));
            jSONObject2.put("android_id", jSONObject.optString("androidId", ""));
            jSONObject2.put("uuid", jSONObject.optString("uuid", ""));
            jSONObject2.put("time_stamp", jSONObject.optLong("genIdTimeStamp", 0L));
            jSONObject2.put("f_type", jSONObject.optInt("deviceIdFromType", -1));
            jSONObject2.put("imei_udid", jSONObject.optString("newImei", ""));
            return jSONObject2;
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JDeviceHelper", "cid failed, " + th.getMessage());
            return null;
        }
    }

    public static JSONObject f(Context context) {
        try {
            JSONObject jSONObject = F;
            if (jSONObject != null && jSONObject.length() > 0) {
                return F;
            }
            JSONObject jSONObject2 = new JSONObject();
            StringBuilder sb = new StringBuilder();
            Iterator<Map.Entry<String, String>> it = f2546y.entrySet().iterator();
            while (true) {
                String str = "";
                if (!it.hasNext()) {
                    String c4 = cn.jiguang.ag.a.c(context, "");
                    sb.append(cn.jiguang.ag.a.p(context));
                    jSONObject2.put("p_imei", c4);
                    sb.append(c4);
                    String g4 = cn.jiguang.ag.a.g(context);
                    jSONObject2.put("p_android_id", g4);
                    sb.append(g4);
                    String string = cn.jiguang.bd.a.a(context).getString("joad");
                    jSONObject2.put("p_oaid", string);
                    sb.append(string);
                    jSONObject2.put("new_cid_all", h.c(sb.toString()));
                    cn.jiguang.w.a.b("JDeviceHelper", "ncid box data is aaa " + jSONObject2.toString());
                    F = jSONObject2;
                    return jSONObject2;
                }
                Map.Entry<String, String> next = it.next();
                String key = next.getKey();
                String b4 = b(key);
                if (!f2547z.contains(key)) {
                    str = "&" + c(key);
                }
                String str2 = b4 + str;
                sb.append(str2);
                jSONObject2.put(next.getValue(), str2);
            }
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JDeviceHelper", "ncid failed, " + th.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String i(Context context) {
        double pow;
        int i4;
        Point point = new Point();
        if (context instanceof Activity) {
            Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 31) {
                try {
                    Rect rect = (Rect) cn.jiguang.ag.g.a(cn.jiguang.ag.g.a(((Activity) context).getWindowManager(), "getMaximumWindowMetrics", (Object[]) null, (Class[]) null), "getBounds", (Object[]) null, (Class[]) null);
                    point.x = rect.right - rect.left;
                    point.y = rect.bottom - rect.top;
                } catch (Exception unused) {
                }
            } else {
                defaultDisplay.getRealSize(point);
            }
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (context instanceof Activity) {
            pow = Math.pow(point.x / displayMetrics.xdpi, 2.0d);
            i4 = point.y;
        } else {
            pow = Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d);
            i4 = displayMetrics.heightPixels;
        }
        return String.format(Locale.ENGLISH, "%.1f", Double.valueOf(Math.sqrt(pow + Math.pow(i4 / displayMetrics.ydpi, 2.0d))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONArray j(Context context) {
        JSONObject a4;
        List<cn.jiguang.ba.a> b4 = c.b(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        JSONArray jSONArray = new JSONArray();
        if (b4 != null) {
            for (cn.jiguang.ba.a aVar : b4) {
                if (aVar != null && (a4 = aVar.a()) != null) {
                    jSONArray.put(a4);
                }
            }
        }
        cn.jiguang.w.a.b("JDeviceHelper", "getSimInfos is " + jSONArray.toString());
        return jSONArray;
    }
}
