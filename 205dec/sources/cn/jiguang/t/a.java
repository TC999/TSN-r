package cn.jiguang.t;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.ag.i;
import cn.jiguang.ao.e;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a extends cn.jiguang.ah.b {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f3778b;

    /* renamed from: a  reason: collision with root package name */
    private Context f3779a;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3780c;

    /* renamed from: cn.jiguang.t.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    class CallableC0065a implements Callable<cn.jiguang.u.a> {
        CallableC0065a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public cn.jiguang.u.a call() {
            try {
                cn.jiguang.t.b bVar = new cn.jiguang.t.b(a.this.f3779a, a.this.f3780c);
                bVar.b();
                for (int i4 = 0; i4 < 20; i4++) {
                    cn.jiguang.u.a a4 = bVar.a();
                    if (a4 != null) {
                        return a4;
                    }
                    Thread.sleep(2000L);
                }
                return null;
            } catch (Throwable th) {
                cn.jiguang.w.a.f("JLocation", "JLocationCellInfo call failed:" + th.getMessage());
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements Callable<cn.jiguang.u.b> {
        b() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public cn.jiguang.u.b call() {
            try {
                c a4 = c.a(a.this.f3779a);
                a4.c();
                for (int i4 = 0; i4 < 30; i4++) {
                    if (a4.b()) {
                        return a4.a();
                    }
                    Thread.sleep(1000L);
                }
                return null;
            } catch (Throwable th) {
                cn.jiguang.w.a.f("JLocation", "JLocationGpsInfo call failed:" + th.getMessage());
                return null;
            }
        }
    }

    private Bundle a(long j4, double d4, double d5) {
        Bundle bundle = new Bundle();
        bundle.putLong("time", j4);
        bundle.putDouble("lot", d4);
        bundle.putDouble("lat", d5);
        return bundle;
    }

    public static a a() {
        if (f3778b == null) {
            synchronized (a.class) {
                if (f3778b == null) {
                    f3778b = new a();
                }
            }
        }
        return f3778b;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x018c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.json.JSONObject a(java.util.List<cn.jiguang.u.c> r19, cn.jiguang.u.a r20, cn.jiguang.u.b r21) {
        /*
            Method dump skipped, instructions count: 482
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.t.a.a(java.util.List, cn.jiguang.u.a, cn.jiguang.u.b):org.json.JSONObject");
    }

    private JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3;
        JSONArray jSONArray;
        cn.jiguang.w.a.b("JLocation", "currentJson:" + jSONObject + ",cacheJson:" + jSONObject2);
        if (jSONObject != null && !"{}".equals(jSONObject.toString())) {
            if (jSONObject2 == null) {
                try {
                    jSONObject3 = new JSONObject();
                } catch (JSONException e4) {
                    e = e4;
                }
                try {
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put(jSONObject);
                    jSONObject3.put("content", jSONArray2);
                    return jSONObject3;
                } catch (JSONException e5) {
                    e = e5;
                    jSONObject2 = jSONObject3;
                    cn.jiguang.w.a.f("JLocation", "mergeJson exception:" + e.getMessage());
                    return jSONObject2;
                }
            }
            try {
                jSONArray = jSONObject2.getJSONArray("content");
            } catch (JSONException unused) {
                jSONArray = new JSONArray();
            }
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                if (cn.jiguang.ar.a.a().e(AVMDLDataLoader.KeyIsIsEncryptVersion)) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("wifi");
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("wifi");
                    if (optJSONArray != null && optJSONArray.equals(optJSONArray2)) {
                        jSONObject.remove("wifi");
                    }
                }
                if (cn.jiguang.ar.a.a().e(1501)) {
                    JSONArray optJSONArray3 = optJSONObject.optJSONArray("cell");
                    JSONArray optJSONArray4 = jSONObject.optJSONArray("cell");
                    if (optJSONArray3 != null && optJSONArray3.equals(optJSONArray4)) {
                        jSONObject.remove("cell");
                    }
                }
                if (cn.jiguang.ar.a.a().e(AVMDLDataLoader.KeyIsIsTestSpeedVersion)) {
                    JSONArray optJSONArray5 = optJSONObject.optJSONArray("gps");
                    JSONArray optJSONArray6 = jSONObject.optJSONArray("gps");
                    if (optJSONArray5 != null && optJSONArray5.equals(optJSONArray6)) {
                        jSONObject.remove("gps");
                    }
                }
            }
            if (jSONObject.length() != 0) {
                try {
                    if (cn.jiguang.ar.a.a().e(AVMDLDataLoader.KeyIsIsChecksumLevel)) {
                        jSONObject.put("network_type", cn.jiguang.ah.d.l(this.f3779a));
                    }
                    cn.jiguang.ar.a.a().e(AVMDLDataLoader.KeyIsIsGetChecksumInfo);
                    cn.jiguang.ah.d.a(this.f3779a, jSONObject, "loc_info");
                    jSONArray.put(jSONObject);
                } catch (JSONException e6) {
                    cn.jiguang.w.a.f("JLocation", "package json exception:" + e6.getMessage());
                }
            }
        }
        return jSONObject2;
    }

    private List<cn.jiguang.u.c> c(Context context, int i4) {
        String str;
        List<cn.jiguang.u.c> list = null;
        try {
        } catch (Exception e4) {
            cn.jiguang.y.a.a(context, "loc_info", "wifi", -1);
            cn.jiguang.w.a.b("JLocation", "collect wifi failed :" + e4.getMessage());
        }
        if (!this.f3780c && !cn.jiguang.ar.a.a().e(AVMDLDataLoader.KeyIsIsEncryptVersion)) {
            cn.jiguang.y.a.a(context, "loc_info", "wifi", -3);
            return list;
        }
        if (!cn.jiguang.ah.d.b(context, "android.permission.ACCESS_WIFI_STATE")) {
            cn.jiguang.y.a.a(context, "loc_info", "wifi", -5);
            str = "collect wifi failed because has no android.permission.ACCESS_WIFI_STATE";
        } else if (cn.jiguang.ah.d.k(context)) {
            list = d.a(context, i4, this.f3780c);
            if (list != null && list.size() > 0) {
                cn.jiguang.y.a.a(context, "loc_info", "wifi", 0);
                cn.jiguang.w.a.b("JLocation", "collect wifi success:" + list);
            }
            return list;
        } else {
            cn.jiguang.y.a.a(context, "loc_info", "wifi", -6);
            str = "collect wifi failed because not enable to collect wifi list";
        }
        cn.jiguang.w.a.f("JLocation", str);
        return list;
    }

    private cn.jiguang.u.b g(Context context) {
        String str;
        int i4;
        cn.jiguang.u.b bVar = null;
        if (!this.f3780c && !c()) {
            cn.jiguang.w.a.b("JLocation", "lbs disable by user");
            i4 = -4;
        } else if (this.f3780c || cn.jiguang.ar.a.a().e(AVMDLDataLoader.KeyIsIsTestSpeedVersion)) {
            try {
                boolean a4 = cn.jiguang.ah.d.a(context, "android.permission.ACCESS_COARSE_LOCATION");
                boolean a5 = cn.jiguang.ah.d.a(context, "android.permission.ACCESS_FINE_LOCATION");
                cn.jiguang.w.a.b("JLocation", "coares:" + a4);
                cn.jiguang.w.a.b("JLocation", "fine:" + a5);
                if ((!a4 && !a5) || !cn.jiguang.ah.d.o(context)) {
                    cn.jiguang.y.a.a(context, "loc_info", "gps", -5);
                    cn.jiguang.w.a.f("JLocation", "collect gps failed because has no Manifest.permission.LOCATION");
                } else if (c.a(context).e()) {
                    bVar = c.a(context).d();
                    if (bVar == null) {
                        FutureTask futureTask = new FutureTask(new b());
                        cn.jiguang.ah.d.b(futureTask);
                        cn.jiguang.u.b bVar2 = (cn.jiguang.u.b) futureTask.get(31000L, TimeUnit.MILLISECONDS);
                        if (bVar2 != null) {
                            try {
                                str = "collect gps success:" + bVar2.toString();
                            } catch (Throwable th) {
                                th = th;
                                bVar = bVar2;
                                cn.jiguang.y.a.a(context, "loc_info", "gps", -1);
                                cn.jiguang.w.a.f("JLocation", "collect gps throwable:" + th.getMessage());
                                return bVar;
                            }
                        } else {
                            str = "collect gps failed";
                        }
                        cn.jiguang.w.a.b("JLocation", str);
                        bVar = bVar2;
                    } else {
                        cn.jiguang.w.a.b("JLocation", "load  last gps success:" + bVar.toString());
                    }
                    if (bVar != null) {
                        cn.jiguang.ah.c.r(context, bVar.f3810a + "," + bVar.f3813d + "," + bVar.f3812c);
                        cn.jiguang.y.a.a(context, "loc_info", "gps", 0);
                    } else {
                        cn.jiguang.y.a.a(context, "loc_info", "gps", -1);
                    }
                } else {
                    cn.jiguang.y.a.a(context, "loc_info", "gps", -6);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            return bVar;
        } else {
            i4 = -3;
        }
        cn.jiguang.y.a.a(context, "loc_info", "gps", i4);
        return null;
    }

    @Override // cn.jiguang.ah.b
    protected String a(Context context) {
        this.f3779a = context;
        return "JLocation";
    }

    public ArrayList<String> a(Context context, int i4) {
        ArrayList<String> arrayList = null;
        if (c() && cn.jiguang.ar.a.a().e(1500)) {
            List<cn.jiguang.u.c> c4 = c(context, Integer.MAX_VALUE);
            if (c4 != null) {
                arrayList = new ArrayList<>();
                for (cn.jiguang.u.c cVar : c4) {
                    String str = cVar.f3818b;
                    if (!TextUtils.isEmpty(str) && !arrayList.contains(str)) {
                        arrayList.add(str);
                        if (arrayList.size() == i4) {
                            break;
                        }
                    }
                }
            }
            cn.jiguang.w.a.b("JLocation", "getWifiNameArray:" + arrayList);
        }
        return arrayList;
    }

    @Override // cn.jiguang.ah.b
    protected void a(String str, JSONObject jSONObject) {
        if (cn.jiguang.ar.a.a().a(1500)) {
            int optInt = jSONObject.optInt("cmd");
            JSONObject optJSONObject = jSONObject.optJSONObject("content");
            if (optInt != 5) {
                if (optInt == 45) {
                    cn.jiguang.ah.c.a(this.f3779a, "JLocation", optJSONObject.optLong("interval", 0L) * 1000);
                    return;
                }
                return;
            }
            boolean z3 = !optJSONObject.optBoolean("disable", true);
            cn.jiguang.ah.c.a(this.f3779a, "JLocation", z3);
            if (z3) {
                cn.jiguang.ah.c.b(this.f3779a, "JLocation", optJSONObject.optLong("frequency", 0L) * 1000);
            }
        }
    }

    public void a(boolean z3) {
        this.f3780c = z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean a(Context context, String str) {
        return cn.jiguang.ah.c.a(context, str);
    }

    public int b(boolean z3) {
        int max = Math.max(cn.jiguang.ar.a.a().b(1500), 0);
        return z3 ? max + 30000 : max;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c7  */
    @Override // cn.jiguang.ah.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(android.content.Context r12, java.lang.String r13) {
        /*
            r11 = this;
            boolean r0 = r11.f3780c
            r1 = -3
            java.lang.String r2 = "loc_info"
            if (r0 != 0) goto L17
            cn.jiguang.ar.a r0 = cn.jiguang.ar.a.a()
            r3 = 1500(0x5dc, float:2.102E-42)
            boolean r0 = r0.a(r3)
            if (r0 != 0) goto L17
            cn.jiguang.y.a.a(r12, r2, r1)
            return
        L17:
            r0 = 10
            java.util.List r0 = r11.c(r12, r0)
            r3 = 0
            boolean r4 = r11.f3780c
            java.lang.String r5 = "JLocation"
            java.lang.String r6 = "cell"
            if (r4 != 0) goto L38
            cn.jiguang.ar.a r4 = cn.jiguang.ar.a.a()
            r7 = 1501(0x5dd, float:2.103E-42)
            boolean r4 = r4.e(r7)
            if (r4 == 0) goto L33
            goto L38
        L33:
            cn.jiguang.y.a.a(r12, r2, r6, r1)
            goto Lb3
        L38:
            r1 = -1
            java.lang.String r4 = "android.permission.ACCESS_COARSE_LOCATION"
            boolean r4 = cn.jiguang.ah.d.a(r12, r4)     // Catch: java.lang.Throwable -> L97
            if (r4 != 0) goto L49
            java.lang.String r4 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r4 = cn.jiguang.ah.d.a(r12, r4)     // Catch: java.lang.Throwable -> L97
            if (r4 == 0) goto L8d
        L49:
            boolean r4 = cn.jiguang.ah.d.o(r12)     // Catch: java.lang.Throwable -> L97
            if (r4 == 0) goto L8d
            java.util.concurrent.FutureTask r4 = new java.util.concurrent.FutureTask     // Catch: java.lang.Throwable -> L97
            cn.jiguang.t.a$a r7 = new cn.jiguang.t.a$a     // Catch: java.lang.Throwable -> L97
            r7.<init>()     // Catch: java.lang.Throwable -> L97
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L97
            cn.jiguang.ah.d.b(r4)     // Catch: java.lang.Throwable -> L97
            r7 = 20000(0x4e20, double:9.8813E-320)
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L97
            java.lang.Object r4 = r4.get(r7, r9)     // Catch: java.lang.Throwable -> L97
            cn.jiguang.u.a r4 = (cn.jiguang.u.a) r4     // Catch: java.lang.Throwable -> L97
            if (r4 == 0) goto L87
            r3 = 0
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L82
            r7.<init>()     // Catch: java.lang.Throwable -> L82
            java.lang.String r8 = "collect cell success:"
            r7.append(r8)     // Catch: java.lang.Throwable -> L82
            java.lang.String r8 = r4.toString()     // Catch: java.lang.Throwable -> L82
            r7.append(r8)     // Catch: java.lang.Throwable -> L82
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L82
            cn.jiguang.w.a.b(r5, r7)     // Catch: java.lang.Throwable -> L82
            goto L88
        L82:
            r3 = move-exception
            r10 = r4
            r4 = r3
            r3 = r10
            goto L98
        L87:
            r3 = -1
        L88:
            cn.jiguang.y.a.a(r12, r2, r6, r3)     // Catch: java.lang.Throwable -> L82
            r3 = r4
            goto Lb3
        L8d:
            r4 = -5
            cn.jiguang.y.a.a(r12, r2, r6, r4)     // Catch: java.lang.Throwable -> L97
            java.lang.String r4 = "collect cell failed because has no Manifest.permission.LOCATION"
            cn.jiguang.w.a.f(r5, r4)     // Catch: java.lang.Throwable -> L97
            goto Lb3
        L97:
            r4 = move-exception
        L98:
            cn.jiguang.y.a.a(r12, r2, r6, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "collect cell throwable:"
            r1.append(r2)
            java.lang.String r2 = r4.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            cn.jiguang.w.a.f(r5, r1)
        Lb3:
            cn.jiguang.u.b r1 = r11.g(r12)
            org.json.JSONObject r0 = r11.a(r0, r3, r1)
            java.lang.String r1 = "rl.catch"
            org.json.JSONObject r2 = cn.jiguang.ao.e.a(r12, r1)
            org.json.JSONObject r0 = r11.a(r0, r2)
            if (r0 == 0) goto Lde
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "save json:"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            cn.jiguang.w.a.b(r5, r2)
            cn.jiguang.ao.e.a(r12, r1, r0)
        Lde:
            super.b(r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.t.a.b(android.content.Context, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean b() {
        return cn.jiguang.ah.c.k(this.f3779a, "JLocation");
    }

    @Override // cn.jiguang.ah.b
    protected boolean b(Context context) {
        return true;
    }

    @Override // cn.jiguang.ah.b
    /* renamed from: c */
    public Bundle d(Context context) {
        long longValue;
        double doubleValue;
        double doubleValue2;
        String f4 = cn.jiguang.ah.c.f(context);
        if (TextUtils.isEmpty(f4)) {
            longValue = 0;
            doubleValue = 200.0d;
            doubleValue2 = 200.0d;
        } else {
            String[] split = f4.split(",");
            longValue = Long.valueOf(split[0]).longValue();
            doubleValue = Double.valueOf(split[1]).doubleValue();
            doubleValue2 = Double.valueOf(split[2]).doubleValue();
        }
        Bundle a4 = a(longValue, doubleValue, doubleValue2);
        String g4 = cn.jiguang.ah.c.g(context);
        if (!TextUtils.isEmpty(g4)) {
            a4.putString("wss", g4);
        }
        String a5 = i.a(context, this.f3780c);
        String a6 = i.a(context, i.c(context));
        a4.putString("operator", a5);
        a4.putString("networkType", a6);
        return a4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void c(Context context, String str) {
        if (this.f3780c || cn.jiguang.ar.a.a().a(1500)) {
            a(false);
            JSONObject a4 = e.a(context, "rl.catch");
            if (a4 == null || "{}".equals(a4.toString())) {
                cn.jiguang.w.a.b("JLocation", "there are no data to report");
                return;
            }
            JSONArray optJSONArray = a4.optJSONArray("content");
            if (optJSONArray != null) {
                try {
                } catch (Throwable th) {
                    cn.jiguang.w.a.f("JLocation", "merge ip failed, " + th.getMessage());
                }
                if (optJSONArray.length() != 0 && (optJSONArray.length() != 1 || !"{}".equals(optJSONArray.getJSONObject(0).toString()))) {
                    String c4 = cn.jiguang.ay.e.d().c(context);
                    if (!TextUtils.isEmpty(c4)) {
                        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                            optJSONArray.getJSONObject(i4).put("ipv6", c4);
                        }
                    }
                    try {
                        cn.jiguang.ah.d.a(context, optJSONArray);
                    } catch (Throwable unused) {
                    }
                    cn.jiguang.w.a.b("JLocation", "clean cache json");
                    e.b(context, "rl.catch");
                    super.c(context, str);
                    return;
                }
            }
            cn.jiguang.w.a.b("JLocation", "there are no content data to report");
        }
    }

    @Override // cn.jiguang.ah.b
    protected boolean c() {
        return cn.jiguang.ah.c.l(this.f3779a, "JLocation");
    }
}
