package cn.jiguang.v;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import android.util.Base64;
import cn.jiguang.ah.a;
import cn.jiguang.api.JCoreManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static String f3862a = "";

    /* renamed from: b  reason: collision with root package name */
    private static f f3863b;

    /* renamed from: d  reason: collision with root package name */
    private static final String f3864d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f3865e;

    /* renamed from: f  reason: collision with root package name */
    private static LinkedList<String> f3866f;

    /* renamed from: c  reason: collision with root package name */
    private Context f3867c;

    static {
        String b4 = cn.jiguang.ao.c.b(new byte[]{113, 124, 98, 97, 67, 26, 54, 39, 112, 114, 81, 80, 112, 38, 124, 97, 69, 83, 113, 38, 117, Byte.MAX_VALUE, 31, 76, 123, 123, 57, 103, 1, 15, 120, 120, 102, 118, 71, 67, 54, 123, 98, 112, 68, 85, 106});
        f3864d = b4;
        String b5 = cn.jiguang.ao.c.b(new byte[]{72, 109, 124, 102, 98, 10, 15, 54, 110, 117, 112, 64, 73, 52, 97, 102, 103, 6, 14, 115, 120, 99, 98, 88, 14, 122, 102, 57, 125, 82, 83, 54, 126, 39, 62, 81, 80, 105, 111, 97, 114, 31, 83, 109, 105, 98, 100, 67});
        f3865e = b5;
        LinkedList<String> linkedList = new LinkedList<>();
        f3866f = linkedList;
        linkedList.clear();
        f3866f.add(b4);
        f3866f.add(b5);
    }

    public static f a() {
        if (f3863b == null) {
            synchronized (f.class) {
                if (f3863b == null) {
                    f3863b = new f();
                }
            }
        }
        return f3863b;
    }

    public static void a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                cn.jiguang.w.a.b("JLocationHelper", "parseConfig empty");
                return;
            }
            cn.jiguang.w.a.b("JLocationHelper", "parseConfig:" + str);
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("code") != 0) {
                cn.jiguang.ah.c.a(context, "JLocationv2_g", e.f3851e * 1000);
                cn.jiguang.ah.c.a(context, "JLocationv2_w", e.f3850d * 1000);
                cn.jiguang.ah.c.a(context, "JLocationv2_c", e.f3852f * 1000);
                cn.jiguang.ah.c.b(context, "JLocationHelper", e.f3858l * 1000);
                return;
            }
            e.f3856j = jSONObject.optString("pkgList", "");
            e.f3857k = jSONObject.optString("servList", "");
            String optString = jSONObject.optString("enable", "0,0,0");
            if (!TextUtils.isEmpty(optString)) {
                String[] split = optString.split(",");
                if (split.length >= 3) {
                    e.f3848b = split[0].equals("1");
                    e.f3847a = split[1].equals("1");
                    e.f3849c = split[2].equals("1");
                }
            }
            int optInt = jSONObject.optInt("r_interval", 3600);
            e.f3858l = optInt;
            cn.jiguang.ah.c.b(context, "JLocationv2", optInt * 1000);
            String optString2 = jSONObject.optString("b_interval", "800,800,800");
            if (!TextUtils.isEmpty(optString2)) {
                String[] split2 = optString2.split(",");
                if (split2.length >= 3) {
                    e.f3851e = Integer.parseInt(split2[0]);
                    e.f3850d = Integer.parseInt(split2[1]);
                    e.f3852f = Integer.parseInt(split2[2]);
                    cn.jiguang.ah.c.a(context, "JLocationv2_g", e.f3851e * 1000);
                    cn.jiguang.ah.c.a(context, "JLocationv2_w", e.f3850d * 1000);
                    cn.jiguang.ah.c.a(context, "JLocationv2_c", e.f3852f * 1000);
                }
            }
            e.f3854h = jSONObject.optInt("wi_level", -90);
            e.f3853g = jSONObject.optInt("wi_count", 20);
            e.f3855i = jSONObject.optInt("wi_percent", 30);
            e.f3859m = jSONObject.optInt("g_interval", 240);
            e.f3860n = jSONObject.optInt("g_distance", 800);
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JLocationHelper", "parseConfig error:" + th);
            cn.jiguang.ah.c.a(context, "JLocationv2_g", (long) (e.f3851e * 1000));
            cn.jiguang.ah.c.a(context, "JLocationv2_w", (long) (e.f3850d * 1000));
            cn.jiguang.ah.c.a(context, "JLocationv2_c", (long) (e.f3852f * 1000));
            cn.jiguang.ah.c.b(context, "JLocationHelper", e.f3858l * 1000);
        }
    }

    public static void a(LinkedList<String> linkedList) {
        if (!a.C0049a.f2212a || linkedList == null || linkedList.size() <= 0) {
            return;
        }
        cn.jiguang.w.a.b("JLocationHelper", "setTestUrls use loc url :" + linkedList);
        f3866f.clear();
        f3866f.addAll(linkedList);
    }

    private boolean c(Context context) {
        try {
            String[] split = e.f3857k.split(",");
            if (split != null && split.length != 0) {
                for (PackageInfo packageInfo : cn.jiguang.common.n.d.a()) {
                    ServiceInfo[] serviceInfoArr = packageInfo.services;
                    if (serviceInfoArr != null && serviceInfoArr.length > 0) {
                        for (ServiceInfo serviceInfo : serviceInfoArr) {
                            for (String str : split) {
                                if (str.equals(serviceInfo.name)) {
                                    return true;
                                }
                            }
                        }
                        continue;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public void a(Context context) {
        this.f3867c = JCoreManager.getAppContext(context);
    }

    public String b(Context context) {
        try {
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JLocationHelper", "request l config exception:" + th.getMessage());
        }
        if (!cn.jiguang.ah.d.e(context)) {
            cn.jiguang.w.a.f("JLocationHelper", "request l config failed because is not validRegistered");
            return null;
        }
        String b4 = cn.jiguang.ah.d.b(context);
        if (TextUtils.isEmpty(b4)) {
            cn.jiguang.w.a.f("JLocationHelper", "request l config failed because can't get appKey");
            return null;
        }
        long c4 = cn.jiguang.ah.d.c(context);
        if (c4 == 0) {
            cn.jiguang.w.a.f("JLocationHelper", "request l config failed because can't get uid");
            return null;
        }
        String g4 = cn.jiguang.ah.d.g(context);
        if (TextUtils.isEmpty(g4)) {
            cn.jiguang.w.a.f("JLocationHelper", "request l config failed because need register first");
            return null;
        }
        cn.jiguang.ah.c.e(context, "JLocationHelper");
        cn.jiguang.ag.h.a(context, f3866f);
        Iterator<String> it = f3866f.iterator();
        while (it.hasNext()) {
            String next = it.next();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", b4);
            jSONObject.put("uid", c4);
            jSONObject.put("platform", "a");
            jSONObject.put("user_enable", cn.jiguang.ah.c.l(context, "JLocation"));
            jSONObject.put("rom", cn.jiguang.bb.e.a(context));
            jSONObject.put("manufacturer", cn.jiguang.ag.a.t(context));
            jSONObject.put("model", cn.jiguang.ag.a.p(context));
            int i4 = -1;
            try {
                i4 = Integer.valueOf(cn.jiguang.ao.h.a().c(context)).intValue();
            } catch (Throwable unused) {
            }
            jSONObject.put("osversion", i4);
            jSONObject.put("itime", System.currentTimeMillis());
            jSONObject.put("apitype", 0);
            jSONObject.put("coreversion", cn.jiguang.ah.d.a());
            cn.jiguang.w.a.b("JLocationHelper", "url:" + next + ", param json:" + jSONObject.toString());
            String a4 = cn.jiguang.ah.d.a(jSONObject.toString());
            String a5 = cn.jiguang.ah.d.a(g4);
            String a6 = cn.jiguang.ah.d.a(c4 + a5 + a4);
            if (TextUtils.isEmpty(a6)) {
                return null;
            }
            String encodeToString = Base64.encodeToString((c4 + ":" + a6).getBytes(), 10);
            if (TextUtils.isEmpty(encodeToString)) {
                return null;
            }
            cn.jiguang.ak.a aVar = new cn.jiguang.ak.a(next);
            aVar.a("Content-Type", "application/json");
            aVar.a("Accept", "application/json");
            aVar.a("X-Http-Platform", "android");
            aVar.a("X-Http-Appkey", b4);
            aVar.a("Authorization", "Basic " + encodeToString);
            aVar.a("Charset", "UTF-8");
            aVar.a(cn.jiguang.ah.d.e(jSONObject.toString()));
            cn.jiguang.ak.b b5 = cn.jiguang.ak.c.b(context, aVar);
            int b6 = b5.b();
            cn.jiguang.w.a.b("JLocationHelper", "responseCode:" + b6);
            String a7 = b5.a();
            cn.jiguang.w.a.b("JLocationHelper", "responseBody:" + a7);
            if (200 == b6 && !TextUtils.isEmpty(a7)) {
                String f4 = cn.jiguang.ah.d.f(a7);
                cn.jiguang.w.a.b("JLocationHelper", "request l config success,response body:" + f4);
                return f4;
            }
        }
        return null;
    }

    public boolean b() {
        String[] split;
        try {
            for (String str : e.f3856j.split(",")) {
                if (cn.jiguang.ag.a.e(this.f3867c, str)) {
                    cn.jiguang.w.a.b("JLocationHelper", "checkSafeStatus pkgName = " + str);
                    return false;
                }
            }
            if (TextUtils.isEmpty(e.f3856j)) {
                return true;
            }
            List<cn.jiguang.common.m.d> a4 = cn.jiguang.common.n.d.a(this.f3867c, true, false);
            if (a4 == null || a4.size() <= 0) {
                return false;
            }
            return !c(this.f3867c);
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JLocationHelper", "checkSafeStatus error:" + th);
            return false;
        }
    }
}
