package cn.jiguang.as;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class f extends cn.jiguang.ah.b {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    private static volatile f f2416d;

    /* renamed from: a  reason: collision with root package name */
    private Context f2417a;

    /* renamed from: b  reason: collision with root package name */
    private List<cn.jiguang.common.m.d> f2418b;

    /* renamed from: c  reason: collision with root package name */
    private List<cn.jiguang.common.m.f> f2419c;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicBoolean f2420e = new AtomicBoolean(true);

    public static f d() {
        if (f2416d == null) {
            synchronized (f.class) {
                if (f2416d == null) {
                    f2416d = new f();
                }
            }
        }
        return f2416d;
    }

    @Override // cn.jiguang.ah.b
    protected String a(Context context) {
        this.f2417a = context;
        return "JAppRunning";
    }

    @Override // cn.jiguang.ah.b
    protected void a(String str, JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("content");
        try {
            long j4 = optJSONObject.getLong("interval");
            if (j4 == -1) {
                cn.jiguang.ah.c.a(this.f2417a, "JAppRunning", false);
            } else if (j4 == 0) {
                cn.jiguang.ah.c.a(this.f2417a, "JAppRunning", true);
            } else {
                int optInt = optJSONObject.optInt("app_type", 0);
                int optInt2 = optJSONObject.optInt("process_type", 0);
                cn.jiguang.ah.c.a(this.f2417a, "JAppRunning", true);
                cn.jiguang.ah.c.a(this.f2417a, optInt);
                cn.jiguang.ah.c.b(this.f2417a, optInt2);
                if (j4 > 0) {
                    cn.jiguang.ah.c.b(this.f2417a, "JAppRunning", j4);
                }
            }
        } catch (JSONException e4) {
            cn.jiguang.w.a.f("JAppRunning", "parse interval exception:" + e4.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean a(Context context, String str) {
        if (this.f2420e.get()) {
            return true;
        }
        return super.a(context, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void b(Context context, String str) {
        if (cn.jiguang.ar.a.a().g(1102)) {
            return;
        }
        this.f2420e.set(false);
        int d4 = cn.jiguang.ah.c.d(context);
        int e4 = cn.jiguang.ah.c.e(context);
        if (d4 > 0) {
            this.f2418b = cn.jiguang.common.n.d.c(context);
        } else {
            cn.jiguang.w.a.f("JAppRunning", "can't collect runningApp because reportRunningAppType:" + d4);
        }
        if (e4 > 0) {
            this.f2419c = cn.jiguang.common.n.e.a(context, e4);
        } else {
            cn.jiguang.w.a.f("JAppRunning", "can't collect runningProcess because reportRunningProcessType:" + e4);
        }
        List<cn.jiguang.common.m.d> list = this.f2418b;
        if (list != null && !list.isEmpty()) {
            cn.jiguang.w.a.b("JAppRunning", "collect runningAppList success");
        }
        List<cn.jiguang.common.m.f> list2 = this.f2419c;
        if (list2 != null && !list2.isEmpty()) {
            cn.jiguang.w.a.b("JAppRunning", "collect runningProcessList success");
        }
        super.b(context, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean b() {
        return cn.jiguang.ah.c.k(this.f2417a, "JAppRunning");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    @Override // cn.jiguang.ah.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(android.content.Context r8, java.lang.String r9) {
        /*
            r7 = this;
            cn.jiguang.ar.a r0 = cn.jiguang.ar.a.a()
            r1 = 1102(0x44e, float:1.544E-42)
            boolean r0 = r0.g(r1)
            if (r0 == 0) goto Ld
            return
        Ld:
            java.util.List<cn.jiguang.common.m.d> r0 = r7.f2418b
            r1 = 128(0x80, float:1.8E-43)
            java.lang.String r2 = "JAppRunning"
            r3 = 0
            if (r0 == 0) goto L3d
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L3d
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            java.util.List<cn.jiguang.common.m.d> r4 = r7.f2418b
            java.util.Iterator r4 = r4.iterator()
        L27:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L44
            java.lang.Object r5 = r4.next()
            cn.jiguang.common.m.d r5 = (cn.jiguang.common.m.d) r5
            org.json.JSONObject r5 = r5.c(r1)
            if (r5 == 0) goto L27
            r0.put(r5)
            goto L27
        L3d:
            java.lang.String r0 = "there are no running app to report"
            cn.jiguang.w.a.f(r2, r0)
            r0 = r3
        L44:
            java.util.List<cn.jiguang.common.m.f> r4 = r7.f2419c
            if (r4 == 0) goto L6f
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L6f
            org.json.JSONArray r4 = new org.json.JSONArray
            r4.<init>()
            java.util.List<cn.jiguang.common.m.f> r5 = r7.f2419c
            java.util.Iterator r5 = r5.iterator()
        L59:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L76
            java.lang.Object r6 = r5.next()
            cn.jiguang.common.m.f r6 = (cn.jiguang.common.m.f) r6
            org.json.JSONObject r6 = r6.a(r1)
            if (r6 == 0) goto L59
            r4.put(r6)
            goto L59
        L6f:
            java.lang.String r1 = "there are no running process to report"
            cn.jiguang.w.a.f(r2, r1)
            r4 = r3
        L76:
            r7.f2418b = r3
            r7.f2419c = r3
            r1 = 0
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: org.json.JSONException -> La1
            r5.<init>()     // Catch: org.json.JSONException -> La1
            r3 = 1
            if (r0 == 0) goto L93
            int r6 = r0.length()     // Catch: org.json.JSONException -> L90
            if (r6 <= 0) goto L93
            java.lang.String r6 = "app"
            r5.put(r6, r0)     // Catch: org.json.JSONException -> L90
            r1 = 1
            goto L93
        L90:
            r0 = move-exception
            r3 = r5
            goto La2
        L93:
            if (r4 == 0) goto Lbb
            int r0 = r4.length()     // Catch: org.json.JSONException -> L90
            if (r0 <= 0) goto Lbb
            java.lang.String r0 = "process"
            r5.put(r0, r4)     // Catch: org.json.JSONException -> L90
            goto Lbc
        La1:
            r0 = move-exception
        La2:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "package json exception:"
            r4.append(r5)
            java.lang.String r0 = r0.getMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            cn.jiguang.w.a.f(r2, r0)
            r5 = r3
        Lbb:
            r3 = r1
        Lbc:
            if (r3 == 0) goto Lc9
            java.lang.String r0 = "app_running"
            cn.jiguang.ah.d.a(r8, r5, r0)
            cn.jiguang.ah.d.a(r8, r5)
            super.c(r8, r9)
        Lc9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.as.f.c(android.content.Context, java.lang.String):void");
    }

    @Override // cn.jiguang.ah.b
    protected boolean c() {
        cn.jiguang.w.a.b("JAppRunning", "for googlePlay:false");
        return cn.jiguang.ar.a.a().e(1102);
    }
}
