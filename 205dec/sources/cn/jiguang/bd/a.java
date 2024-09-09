package cn.jiguang.bd;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import cn.jiguang.ah.d;
import cn.jiguang.ax.d;
import cn.jiguang.ax.e;
import cn.jiguang.i.b;
import cn.jiguang.k.c;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static JSONObject f2567a;

    /* renamed from: b  reason: collision with root package name */
    private static String f2568b;

    /* renamed from: c  reason: collision with root package name */
    private static String f2569c;

    /* renamed from: d  reason: collision with root package name */
    private static String f2570d;

    /* renamed from: e  reason: collision with root package name */
    private static String f2571e;

    /* renamed from: f  reason: collision with root package name */
    private static String f2572f;

    /* renamed from: g  reason: collision with root package name */
    private static String f2573g;

    /* renamed from: h  reason: collision with root package name */
    private static String f2574h;

    /* renamed from: i  reason: collision with root package name */
    private static String f2575i;

    /* renamed from: j  reason: collision with root package name */
    private static String f2576j;

    /* renamed from: k  reason: collision with root package name */
    private static String f2577k;

    /* renamed from: cn.jiguang.bd.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    static class CallableC0054a implements Callable<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        private Context f2582a;

        public CallableC0054a(Context context) {
            this.f2582a = context;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public JSONObject call() {
            JSONObject jSONObject = new JSONObject();
            try {
                String t3 = cn.jiguang.ag.a.t(this.f2582a);
                if (!TextUtils.isEmpty(t3)) {
                    cn.jiguang.w.a.b("IdHelper", "start getAllIds by local");
                    String c4 = a.c(this.f2582a, t3);
                    if (!TextUtils.isEmpty(c4)) {
                        jSONObject = new JSONObject(c4);
                    }
                }
                String b4 = a.b(this.f2582a);
                if (!TextUtils.isEmpty(b4)) {
                    jSONObject.put("jgad", b4);
                }
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public static JSONObject a(final Context context) {
        try {
        } catch (Throwable th) {
            cn.jiguang.w.a.f("IdHelper", "[getAllIds] failed\uff1a" + th.getMessage());
        }
        if (cn.jiguang.ar.a.a().e(1008) && cn.jiguang.ar.a.a().e(1900)) {
            Object a4 = e.a(context, 1900, new e.a() { // from class: cn.jiguang.bd.a.1
                @Override // cn.jiguang.ax.e.b
                public Object a() {
                    if (a.f2567a == null || a.f2567a.toString().equals("{}")) {
                        return null;
                    }
                    return a.f2567a;
                }

                @Override // cn.jiguang.ax.e.b
                public void a(Object obj) {
                    if (obj instanceof JSONObject) {
                        JSONObject unused = a.f2567a = (JSONObject) obj;
                    }
                }

                @Override // cn.jiguang.ax.e.b
                public Object b() {
                    try {
                        FutureTask futureTask = new FutureTask(new CallableC0054a(context));
                        d.b(futureTask);
                        JSONObject jSONObject = (JSONObject) futureTask.get(2L, TimeUnit.SECONDS);
                        cn.jiguang.w.a.b("IdHelper", "[getAllIds] allIds\uff1a" + jSONObject);
                        if (jSONObject.toString().equals("{}")) {
                            return null;
                        }
                        return jSONObject;
                    } catch (Throwable unused) {
                        return null;
                    }
                }
            });
            if (a4 instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) a4;
                f2567a = jSONObject;
                return jSONObject;
            }
            return null;
        }
        return null;
    }

    public static String b(final Context context) {
        try {
            Object a4 = cn.jiguang.ax.d.a(context, 3334, 1800000L, 259200000L, false, (d.b) new d.a() { // from class: cn.jiguang.bd.a.3
                @Override // cn.jiguang.ax.d.b
                public Object a() {
                    return a.f2569c;
                }

                @Override // cn.jiguang.ax.d.b
                public void a(Object obj) {
                    if (obj instanceof String) {
                        String unused = a.f2569c = (String) obj;
                    }
                }

                @Override // cn.jiguang.ax.d.b
                public Object b() {
                    return a.d(context);
                }
            });
            if (a4 instanceof String) {
                f2569c = (String) a4;
            }
        } catch (Throwable th) {
            f2569c = "";
            cn.jiguang.w.a.f("IdHelper", "getGoogleAdid failed:" + th.getMessage());
        }
        return f2569c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(final Context context, final String str) {
        try {
            Object a4 = cn.jiguang.ax.d.a(context, 3334, 1800000L, 259200000L, false, (d.b) new d.a() { // from class: cn.jiguang.bd.a.2
                @Override // cn.jiguang.ax.d.b
                public Object a() {
                    return a.f2568b;
                }

                @Override // cn.jiguang.ax.d.b
                public void a(Object obj) {
                    if (obj instanceof String) {
                        String unused = a.f2568b = (String) obj;
                    }
                }

                @Override // cn.jiguang.ax.d.b
                public Object b() {
                    return a.d(context, str);
                }
            });
            if (a4 instanceof String) {
                f2568b = (String) a4;
            }
        } catch (Throwable unused) {
        }
        return f2568b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(Context context) {
        String f4;
        if (d()) {
            cn.jiguang.w.a.f("IdHelper", "not get id in main thread");
            return "";
        }
        try {
            f4 = cn.jiguang.ah.d.f("+Fc+/S0DV5xukan0E/9N4RvXQpEI8h8+6y3k9NAvwjLhqIYeN+juscczCl6Sq6PxwLAq9CdDlLtmxsbD83akRg==");
        } catch (Throwable th) {
            cn.jiguang.w.a.f("IdHelper", "google getAdvertisingIdInfo Exception: " + th.toString());
        }
        if (TextUtils.isEmpty(f4)) {
            return "";
        }
        Intent intent = new Intent(f4);
        String f5 = cn.jiguang.ah.d.f("+Fc+/S0DV5xukan0E/9N4VArQdi8pEVBp8UquAC8VbE=");
        if (TextUtils.isEmpty(f5)) {
            return "";
        }
        intent.setPackage(f5);
        b bVar = new b();
        if (!context.bindService(intent, bVar, 1)) {
            cn.jiguang.w.a.f("IdHelper", "google service bind failed");
            return "";
        } else if (bVar.f3668a) {
            cn.jiguang.w.a.f("IdHelper", "google service repeat bind");
            context.unbindService(bVar);
            return "";
        } else {
            String a4 = new cn.jiguang.i.a(bVar.f3669b.take()).a();
            cn.jiguang.w.a.b("IdHelper", "google ad id:" + a4);
            context.unbindService(bVar);
            return a4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(Context context, String str) {
        try {
        } catch (Throwable th) {
            cn.jiguang.w.a.f("IdHelper", "getIdsByLocal failed:" + th.getMessage());
        }
        if (d()) {
            cn.jiguang.w.a.f("IdHelper", "not get id in main thread");
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        String f4 = cn.jiguang.ah.d.f("KACzk43fXSu6fNDY3NHiRg==");
        String f5 = cn.jiguang.ah.d.f("1uhzqUdzasJ2ZR3KEL+MzQ==");
        if ((!TextUtils.isEmpty(f4) && str.toLowerCase().equals(f4)) || (!TextUtils.isEmpty(f5) && str.toLowerCase().equals(f5))) {
            String e4 = e(context);
            if (TextUtils.isEmpty(e4)) {
                return "";
            }
            jSONObject.put("joad", e4);
            return jSONObject.toString();
        }
        String f6 = cn.jiguang.ah.d.f("abElWL6JFOA3DmtpsVXe5g==");
        String f7 = cn.jiguang.ah.d.f("qqDQS9ZdTx8AkhCp5nUUmQ==");
        if ((TextUtils.isEmpty(f6) || !str.toLowerCase().equals(f6)) && (TextUtils.isEmpty(f7) || !str.toLowerCase().equals(f7))) {
            String f8 = cn.jiguang.ah.d.f("ZCUqO8ru60AnJTvdxNftwg==");
            if (TextUtils.isEmpty(f8) || !str.toLowerCase().equals(f8)) {
                String f9 = cn.jiguang.ah.d.f("Sqo/G40afBQEk/ThxiHCDA==");
                if (!TextUtils.isEmpty(f9) && str.toLowerCase().equals(f9)) {
                    String j4 = j(context);
                    if (TextUtils.isEmpty(j4)) {
                        return "";
                    }
                    jSONObject.put("joad", j4);
                    return jSONObject.toString();
                }
                String f10 = cn.jiguang.ah.d.f("Fl44OKc45ZSCqG4pxdgAdA==");
                if (!TextUtils.isEmpty(f10) && str.toLowerCase().equals(f10)) {
                    String h4 = h(context);
                    if (TextUtils.isEmpty(h4)) {
                        return "";
                    }
                    jSONObject.put("joad", h4);
                    return jSONObject.toString();
                }
                String f11 = cn.jiguang.ah.d.f("v4ibuvMAw0xxYGyCW947bw==");
                String f12 = cn.jiguang.ah.d.f("lJTl9z+ZycJlu+D6qavE9g==");
                if ((TextUtils.isEmpty(f11) || !str.toLowerCase().equals(f11)) && (TextUtils.isEmpty(f12) || !str.toLowerCase().equals(f12))) {
                    String f13 = cn.jiguang.ah.d.f("7UUoz3VX0wN8BuYNQ77o2g==");
                    if (TextUtils.isEmpty(f13) || !str.toLowerCase().equals(f13)) {
                        String f14 = cn.jiguang.ah.d.f("NftKgs8fjwuVYJ3VslncvA==");
                        String f15 = cn.jiguang.ah.d.f("Wq1559o9+HHChTmry59Bkg==");
                        if ((!TextUtils.isEmpty(f14) && str.toLowerCase().equals(f14)) || (!TextUtils.isEmpty(f15) && str.toLowerCase().equals(f15))) {
                            String f16 = f(context);
                            if (TextUtils.isEmpty(f16)) {
                                return "";
                            }
                            jSONObject.put("joad", f16);
                            return jSONObject.toString();
                        }
                        String f17 = cn.jiguang.ah.d.f("fmTCWm9ViPlyzM8H0bOrgw==");
                        if (!TextUtils.isEmpty(f17) && str.toLowerCase().equals(f17)) {
                            String l4 = l(context);
                            if (TextUtils.isEmpty(l4)) {
                                return "";
                            }
                            jSONObject.put("joad", l4);
                            return jSONObject.toString();
                        }
                        String f18 = cn.jiguang.ah.d.f("bbyVCf9F4jMXWPUAeT3frw==");
                        if (!TextUtils.isEmpty(f18) && str.toLowerCase().equals(f18)) {
                            String n4 = n(context);
                            if (TextUtils.isEmpty(n4)) {
                                return "";
                            }
                            jSONObject.put("joad", n4);
                            return jSONObject.toString();
                        }
                        String f19 = cn.jiguang.ah.d.f("0kbg5dLQpyr1z+M/7Qkp7A==");
                        if ((!TextUtils.isEmpty(f19) && str.toLowerCase().equals(f19)) || cn.jiguang.q.a.a()) {
                            String o4 = o(context);
                            if (TextUtils.isEmpty(o4)) {
                                return "";
                            }
                            jSONObject.put("joad", o4);
                            return jSONObject.toString();
                        }
                        String f20 = cn.jiguang.ah.d.f("7kOXkVyi2CnACIIN3msOQg==");
                        if ((TextUtils.isEmpty(f20) || !str.toLowerCase().equals(f20)) && !cn.jiguang.q.a.b()) {
                            cn.jiguang.w.a.f("IdHelper", "not supported this device: " + str);
                            return "";
                        }
                        String p3 = p(context);
                        if (TextUtils.isEmpty(p3)) {
                            return "";
                        }
                        jSONObject.put("joad", p3);
                        return jSONObject.toString();
                    }
                    return g(context);
                }
                return i(context);
            }
            return k(context);
        }
        return m(context);
    }

    private static boolean d() {
        try {
            return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
        } catch (Throwable th) {
            cn.jiguang.w.a.f("IdHelper", "[isMainThread] failed:" + th.getMessage());
            return true;
        }
    }

    private static String e(Context context) {
        String str;
        if (context == null) {
            return "";
        }
        try {
            str = f2570d;
        } catch (Throwable th) {
            cn.jiguang.w.a.f("IdHelper", "hw getAdvertisingIdInfo Exception: " + th.toString());
        }
        if (str != null) {
            return str;
        }
        String f4 = cn.jiguang.ah.d.f("CV+BUnOM9r9hBWkUu5oSnA==");
        if (TextUtils.isEmpty(f4)) {
            return "";
        }
        f2570d = "";
        String f5 = cn.jiguang.ah.d.f("axDZqud6H+CDQBXA/yBXOiEPy9gW6px8eLENPXdBlBHSZeanEgWxhi72s58AM6wZ");
        if (TextUtils.isEmpty(f5)) {
            return "";
        }
        Intent intent = new Intent(f5);
        intent.setPackage(f4);
        cn.jiguang.j.b bVar = new cn.jiguang.j.b();
        boolean bindService = context.bindService(intent, bVar, 1);
        if (!bindService) {
            cn.jiguang.w.a.f("IdHelper", "hw service bind failed");
            return "";
        }
        String a4 = new cn.jiguang.j.a(bVar.f3688a.take()).a();
        cn.jiguang.w.a.b("IdHelper", "hw ids-o:" + a4);
        f2570d = a4;
        if (bindService) {
            context.unbindService(bVar);
        }
        return a4;
    }

    private static String f(Context context) {
        String str;
        try {
            str = f2571e;
        } catch (Exception e4) {
            cn.jiguang.w.a.f("IdHelper", "zui getAdvertisingIdInfo Exception: " + e4.toString());
        }
        if (str != null) {
            return str;
        }
        String f4 = cn.jiguang.ah.d.f("Mpy0fkBSw1N+kug2cBPj2YJ2JkldBoT0Hj8EbMwXMGU=");
        if (TextUtils.isEmpty(f4)) {
            return "";
        }
        f2571e = "";
        String f5 = cn.jiguang.ah.d.f("Mpy0fkBSw1N+kug2cBPj2dTFEwqSue3aUHyxqBhF0BWQuC1TiTYwRmpXbBFYowSK");
        if (TextUtils.isEmpty(f5)) {
            return "";
        }
        Intent intent = new Intent(f5);
        intent.setPackage(f4);
        cn.jiguang.r.b bVar = new cn.jiguang.r.b();
        boolean bindService = context.bindService(intent, bVar, 1);
        if (!bindService) {
            cn.jiguang.w.a.f("IdHelper", "zui service bind failed");
            return "";
        }
        String a4 = new cn.jiguang.r.a(bVar.f3777a.take()).a();
        cn.jiguang.w.a.b("IdHelper", "zui ids-oa:" + a4);
        f2571e = a4;
        if (bindService) {
            context.unbindService(bVar);
        }
        return a4;
    }

    private static String g(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            String a4 = new cn.jiguang.l.b(context).a();
            if (!TextUtils.isEmpty(a4)) {
                jSONObject.put("joad", a4);
            }
        } catch (JSONException e4) {
            cn.jiguang.w.a.f("IdHelper", "getNubiaIds err: " + e4.getMessage());
        }
        return jSONObject.toString();
    }

    private static String h(Context context) {
        String str;
        try {
            str = f2572f;
        } catch (Exception e4) {
            cn.jiguang.w.a.f("IdHelper", "sumsung getAdvertisingIdInfo Exception: " + e4.toString());
        }
        if (str != null) {
            return str;
        }
        String f4 = cn.jiguang.ah.d.f("NZZdxIY39aBpJdeuRJ0VLp5xPlLZJqfiSSPak26ACVtSyGK74B1pfv+DoniV/u8H");
        if (TextUtils.isEmpty(f4)) {
            return "";
        }
        f2572f = "";
        String f5 = cn.jiguang.ah.d.f("NZZdxIY39aBpJdeuRJ0VLp5xPlLZJqfiSSPak26ACVsaSg3goTgfCOA0dOFWjVLPc7dVv4XHGL0Dk7MQTYMVQw==");
        if (TextUtils.isEmpty(f5)) {
            return "";
        }
        Intent intent = new Intent();
        intent.setClassName(f4, f5);
        cn.jiguang.n.b bVar = new cn.jiguang.n.b();
        boolean bindService = context.bindService(intent, bVar, 1);
        if (!bindService) {
            cn.jiguang.w.a.f("IdHelper", "sumsung service bind failed");
            return "";
        }
        String a4 = new cn.jiguang.n.a(bVar.f3715a.take()).a(context);
        cn.jiguang.w.a.b("IdHelper", "sumsuang ids-oa:" + a4);
        f2572f = a4;
        if (bindService) {
            context.unbindService(bVar);
        }
        return a4;
    }

    private static String i(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            String a4 = new c(context).a();
            if (!TextUtils.isEmpty(a4)) {
                jSONObject.put("joad", a4);
            }
        } catch (JSONException e4) {
            cn.jiguang.w.a.f("IdHelper", "getVivoIds err: " + e4.getMessage());
        }
        return jSONObject.toString();
    }

    private static String j(Context context) {
        String str;
        try {
            str = f2573g;
        } catch (Exception e4) {
            cn.jiguang.w.a.f("IdHelper", "oppo getAdvertisingIdInfo Exception: " + e4.toString());
        }
        if (str != null) {
            return str;
        }
        String f4 = cn.jiguang.ah.d.f("qFFOesfckPwVmbfqzGl5oG9IMWwJa4PjDfKEUokUsrU=");
        if (TextUtils.isEmpty(f4)) {
            return "";
        }
        f2573g = "";
        String f5 = cn.jiguang.ah.d.f("qFFOesfckPwVmbfqzGl5oOMkBF5tSSPHMYAiT/owwSwoCrUg5HXoJRYDJrCupV3K");
        if (TextUtils.isEmpty(f5)) {
            return "";
        }
        Intent intent = new Intent(f5);
        intent.setPackage(f4);
        String f6 = cn.jiguang.ah.d.f("/3gurUKcGzqF8/YMsL45D9RvCsSd5y5lQDTuvU2S5vtG2aMIkkluUNr+NKF2loi0");
        if (TextUtils.isEmpty(f6)) {
            return "";
        }
        intent.setAction(f6);
        cn.jiguang.m.b bVar = new cn.jiguang.m.b();
        boolean bindService = context.bindService(intent, bVar, 1);
        if (!bindService) {
            cn.jiguang.w.a.f("IdHelper", "oppo service bind failed");
            return "";
        }
        String a4 = new cn.jiguang.m.a(bVar.f3712a.take()).a(context);
        cn.jiguang.w.a.b("IdHelper", "oppo ids-oa: " + a4);
        f2573g = a4;
        if (bindService) {
            context.unbindService(bVar);
        }
        return a4;
    }

    private static String k(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            cn.jiguang.o.c cVar = new cn.jiguang.o.c(context);
            cVar.a("");
            String a4 = cVar.a();
            if (!TextUtils.isEmpty(a4)) {
                jSONObject.put("joad", a4);
            }
        } catch (JSONException e4) {
            cn.jiguang.w.a.f("IdHelper", "getVivoIds err: " + e4.getMessage());
        }
        return jSONObject.toString();
    }

    private static String l(Context context) {
        String str;
        if (context == null) {
            return "";
        }
        try {
            str = f2574h;
        } catch (Exception e4) {
            cn.jiguang.w.a.f("IdHelper", "asus getAdvertisingIdInfo Exception: " + e4.toString());
        }
        if (str != null) {
            return str;
        }
        f2574h = "";
        String f4 = cn.jiguang.ah.d.f("AVy8x+cBVze9OKJHZKioHyNDBGqtEllVM4dvG69zMJc=");
        if (TextUtils.isEmpty(f4)) {
            return "";
        }
        Intent intent = new Intent(f4);
        String f5 = cn.jiguang.ah.d.f("8lAhWp7NB89J3VIJU4lIGQtLf0YkfPcfFvWDnnGUuiQ=");
        if (TextUtils.isEmpty(f5)) {
            return "";
        }
        String f6 = cn.jiguang.ah.d.f("8lAhWp7NB89J3VIJU4lIGQnPwmB8zgbENyN+gUA8dpRI7pO4GGAXufB+HCPmLRg7bL9N6o9V3Rxxk98J3lyy6g==");
        if (TextUtils.isEmpty(f6)) {
            return "";
        }
        ComponentName componentName = new ComponentName(f5, f6);
        Intent intent2 = new Intent(intent);
        intent2.setComponent(componentName);
        cn.jiguang.w.a.e("IdHelper", "start to bind did service.");
        cn.jiguang.be.b bVar = new cn.jiguang.be.b();
        boolean bindService = context.bindService(intent2, bVar, 1);
        if (bindService) {
            String a4 = new cn.jiguang.be.a(bVar.f2585a.take()).a();
            cn.jiguang.w.a.b("IdHelper", "asus ids-oa; " + a4);
            f2574h = a4;
            if (bindService) {
                cn.jiguang.w.a.e("IdHelper", "start to unbind did service");
                context.unbindService(bVar);
            }
            return a4;
        }
        return "";
    }

    private static String m(Context context) {
        return cn.jiguang.p.a.a(context);
    }

    private static String n(Context context) {
        if (f2575i == null) {
            String a4 = new cn.jiguang.q.b(context).a();
            f2575i = a4;
            f2575i = TextUtils.isEmpty(a4) ? "" : f2575i;
        }
        return f2575i;
    }

    private static String o(Context context) {
        if (f2576j == null) {
            String a4 = new cn.jiguang.q.b(context).a();
            f2576j = a4;
            f2576j = TextUtils.isEmpty(a4) ? "" : f2576j;
        }
        return f2576j;
    }

    private static String p(Context context) {
        if (f2577k == null) {
            String a4 = new cn.jiguang.q.b(context).a();
            f2577k = a4;
            f2577k = TextUtils.isEmpty(a4) ? "" : f2577k;
        }
        return f2577k;
    }
}
