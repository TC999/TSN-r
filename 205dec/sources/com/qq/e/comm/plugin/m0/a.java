package com.qq.e.comm.plugin.m0;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.e.comm.plugin.i0.j;
import com.qq.e.comm.plugin.util.d0;
import com.qq.e.comm.plugin.util.d1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: r  reason: collision with root package name */
    private static final String f44656r = String.format("https://%s/%s", "sdk.e.qq.com", "update");

    /* renamed from: s  reason: collision with root package name */
    private static final a f44657s = new a();

    /* renamed from: t  reason: collision with root package name */
    private static Boolean f44658t;

    /* renamed from: a  reason: collision with root package name */
    private String f44659a;

    /* renamed from: b  reason: collision with root package name */
    private String f44660b;

    /* renamed from: l  reason: collision with root package name */
    private Boolean f44670l;

    /* renamed from: m  reason: collision with root package name */
    private String f44671m;

    /* renamed from: n  reason: collision with root package name */
    private com.qq.e.comm.plugin.edgeanalytics.g f44672n;

    /* renamed from: p  reason: collision with root package name */
    private long f44674p;

    /* renamed from: q  reason: collision with root package name */
    private Runnable f44675q;

    /* renamed from: c  reason: collision with root package name */
    private boolean f44661c = true;

    /* renamed from: d  reason: collision with root package name */
    private List<i> f44662d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private ExecutorService f44663e = Executors.newSingleThreadExecutor();

    /* renamed from: f  reason: collision with root package name */
    private AtomicLong f44664f = new AtomicLong();

    /* renamed from: g  reason: collision with root package name */
    private AtomicLong f44665g = new AtomicLong(0);

    /* renamed from: h  reason: collision with root package name */
    private AtomicLong f44666h = new AtomicLong();

    /* renamed from: i  reason: collision with root package name */
    private volatile int f44667i = 69;

    /* renamed from: j  reason: collision with root package name */
    private long f44668j = 0;

    /* renamed from: k  reason: collision with root package name */
    private long f44669k = 0;

    /* renamed from: o  reason: collision with root package name */
    private long f44673o = 0;

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.m0.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class RunnableC0855a implements Runnable {
        RunnableC0855a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.qq.e.comm.plugin.m0.d.a().b();
            a.this.a(false);
            a.a(a.this);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f44677a;

        b(int i4) {
            this.f44677a = i4;
        }

        @Override // com.qq.e.comm.plugin.m0.a.i
        public void a() {
            a.a(a.this, this.f44677a, false);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class c implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f44679c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ JSONObject f44680d;

        c(boolean z3, JSONObject jSONObject) {
            this.f44679c = z3;
            this.f44680d = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(a.this, this.f44679c, this.f44680d);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class e implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f44684c;

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.m0.a$e$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class RunnableC0856a implements Runnable {
            RunnableC0856a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d1.a("GDTConfig", "delayUpdate");
                e eVar = e.this;
                a.a(a.this, eVar.f44684c, false);
            }
        }

        e(int i4) {
            this.f44684c = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            d0.f46406b.submit(new RunnableC0856a());
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(a.b(a.this))) {
                a.a(a.this, "https://sg.ylhglobal.com");
                a.e(a.this);
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface i {
        void a();
    }

    private String a(com.qq.e.comm.plugin.d0.d.h hVar, com.qq.e.comm.plugin.d0.c.d dVar, com.qq.e.comm.plugin.d0.e.c cVar, com.qq.e.comm.plugin.d0.e.a aVar, Context context) {
        return (String) pro.getobjresult(47, 0, this, hVar, dVar, cVar, aVar, context);
    }

    static /* synthetic */ String a(a aVar, String str) {
        return (String) pro.getobjresult(48, 1, aVar, str);
    }

    private void a(int i4, int i5) {
        pro.getVresult(49, 0, this, Integer.valueOf(i4), Integer.valueOf(i5));
    }

    private void a(int i4, int i5, int i6) {
        pro.getVresult(50, 0, this, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
    }

    private void a(int i4, String str, int i5) {
        pro.getVresult(51, 0, this, Integer.valueOf(i4), str, Integer.valueOf(i5));
    }

    private void a(int i4, boolean z3) {
        pro.getVresult(52, 0, this, Integer.valueOf(i4), Boolean.valueOf(z3));
    }

    static /* synthetic */ void a(a aVar) {
        pro.getVresult(53, 1, aVar);
    }

    static /* synthetic */ void a(a aVar, int i4, int i5, int i6) {
        pro.getVresult(54, 1, aVar, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
    }

    static /* synthetic */ void a(a aVar, int i4, String str, int i5) {
        pro.getVresult(55, 1, aVar, Integer.valueOf(i4), str, Integer.valueOf(i5));
    }

    static /* synthetic */ void a(a aVar, int i4, boolean z3) {
        pro.getVresult(56, 1, aVar, Integer.valueOf(i4), Boolean.valueOf(z3));
    }

    static /* synthetic */ void a(a aVar, boolean z3, JSONObject jSONObject) {
        pro.getVresult(57, 1, aVar, Boolean.valueOf(z3), jSONObject);
    }

    private void a(String str) {
        pro.getVresult(58, 0, this, str);
    }

    private void a(String str, int i4) {
        pro.getVresult(59, 0, this, str, Integer.valueOf(i4));
    }

    private void a(String str, String str2) {
        pro.getVresult(60, 0, this, str, str2);
    }

    private void a(JSONObject jSONObject, JSONObject jSONObject2) {
        pro.getVresult(61, 0, this, jSONObject, jSONObject2);
    }

    private void a(boolean z3, int i4) {
        pro.getVresult(62, 0, this, Boolean.valueOf(z3), Integer.valueOf(i4));
    }

    private void a(boolean z3, JSONObject jSONObject) {
        pro.getVresult(63, 0, this, Boolean.valueOf(z3), jSONObject);
    }

    private boolean a(int i4) {
        return pro.getZresult(64, 0, this, Integer.valueOf(i4));
    }

    private static boolean a(Context context, String str, String str2) {
        return pro.getZresult(65, 1, context, str, str2);
    }

    static /* synthetic */ boolean a(a aVar, boolean z3) {
        return pro.getZresult(66, 1, aVar, Boolean.valueOf(z3));
    }

    static /* synthetic */ String b(a aVar) {
        return (String) pro.getobjresult(67, 1, aVar);
    }

    static /* synthetic */ String b(a aVar, String str) {
        return (String) pro.getobjresult(68, 1, aVar, str);
    }

    private void b(int i4) {
        pro.getVresult(69, 0, this, Integer.valueOf(i4));
    }

    private void b(String str) {
        pro.getVresult(70, 0, this, str);
    }

    private void b(String str, String str2) {
        pro.getVresult(71, 0, this, str, str2);
    }

    private void b(JSONObject jSONObject) {
        pro.getVresult(72, 0, this, jSONObject);
    }

    private long c() {
        return pro.getJresult(73, 0, this);
    }

    static /* synthetic */ String c(a aVar) {
        return (String) pro.getobjresult(74, 1, aVar);
    }

    private void c(String str) {
        pro.getVresult(75, 0, this, str);
    }

    private void c(String str, String str2) {
        pro.getVresult(76, 0, this, str, str2);
    }

    static /* synthetic */ boolean d(a aVar) {
        return pro.getZresult(77, 1, aVar);
    }

    static /* synthetic */ void e(a aVar) {
        pro.getVresult(78, 1, aVar);
    }

    private void g() {
        pro.getVresult(79, 0, this);
    }

    private void j() {
        pro.getVresult(80, 0, this);
    }

    private void k() {
        pro.getVresult(81, 0, this);
    }

    public static a l() {
        return (a) pro.getobjresult(82, 1, new Object[0]);
    }

    private static boolean m() {
        return pro.getZresult(83, 1, new Object[0]);
    }

    private void o() {
        pro.getVresult(84, 0, this);
    }

    private void p() {
        pro.getVresult(85, 0, this);
    }

    public void a() {
        pro.getVresult(86, 0, this);
    }

    public void a(Context context) {
        pro.getVresult(87, 0, this, context);
    }

    public void a(i iVar) {
        pro.getVresult(88, 0, this, iVar);
    }

    public void a(JSONObject jSONObject) {
        pro.getVresult(89, 0, this, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z3) {
        pro.getVresult(90, 0, this, Boolean.valueOf(z3));
    }

    public long b() {
        return pro.getJresult(91, 0, this);
    }

    public void b(boolean z3, JSONObject jSONObject) {
        pro.getVresult(92, 0, this, Boolean.valueOf(z3), jSONObject);
    }

    public int d() {
        return pro.getIresult(93, 0, this);
    }

    public String e() {
        return (String) pro.getobjresult(94, 0, this);
    }

    public String f() {
        return (String) pro.getobjresult(95, 0, this);
    }

    public long h() {
        return pro.getJresult(96, 0, this);
    }

    public void i() {
        pro.getVresult(97, 0, this);
    }

    public boolean n() {
        return pro.getZresult(98, 0, this);
    }

    public void q() {
        pro.getVresult(99, 0, this);
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class d implements com.qq.e.comm.plugin.edgeanalytics.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f44682a;

        d(int i4) {
            this.f44682a = i4;
        }

        @Override // com.qq.e.comm.plugin.edgeanalytics.g
        public void a(boolean z3, JSONObject jSONObject) {
            if (jSONObject == null || jSONObject.optInt("update") > 0) {
                a.a(a.this, this.f44682a, true);
            }
        }

        @Override // com.qq.e.comm.plugin.edgeanalytics.g
        public void a(int i4) {
            a.a(a.this, this.f44682a, true);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class f extends j {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f44687a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f44688b;

        f(int i4, int i5) {
            this.f44687a = i4;
            this.f44688b = i5;
        }

        @Override // com.qq.e.comm.plugin.i0.b
        public void a(com.qq.e.comm.plugin.i0.n.f fVar, com.qq.e.comm.plugin.i0.n.g gVar) {
            try {
                int statusCode = gVar.getStatusCode();
                if (statusCode == 200) {
                    String b4 = gVar.b();
                    d1.a("GDTConfig", "Config response:%s", b4);
                    if (TextUtils.isEmpty(b4)) {
                        a.a(a.this, 3000, "reponse is empty", 0);
                        d1.a("SDK Server response empty string, maybe zip or tea format error");
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(b4);
                    a.a(a.this, this.f44687a, this.f44688b, jSONObject.optInt("seq", -1));
                    a.this.b(true, jSONObject);
                    return;
                }
                a aVar = a.this;
                a.a(aVar, 3005, "status code=" + statusCode, 0);
                d1.a("SDK server response code error while launch or activate, code:" + gVar.getStatusCode());
            } catch (IOException e4) {
                a.a(a.this, 3001, e4.getMessage(), 0);
                d1.a("Config request error", e4);
            } catch (JSONException e5) {
                a.a(a.this, 5001, e5.getMessage(), 0);
                d1.a("Parse config response exception", e5);
            }
        }

        @Override // com.qq.e.comm.plugin.i0.j
        public void a(com.qq.e.comm.plugin.i0.n.f fVar, int i4, Exception exc) {
            a.a(a.this, i4, exc.getMessage(), 0);
            d1.a("Config request error: ", exc);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class g implements com.qq.e.comm.plugin.i0.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f44690a;

        g(long j4) {
            this.f44690a = j4;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x00a6  */
        /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
        @Override // com.qq.e.comm.plugin.i0.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(com.qq.e.comm.plugin.i0.n.f r7, com.qq.e.comm.plugin.i0.n.g r8) {
            /*
                r6 = this;
                int r7 = r8.getStatusCode()
                java.lang.String r0 = "https://sg.ylhglobal.com"
                r1 = 200(0xc8, float:2.8E-43)
                if (r7 != r1) goto L8e
                java.lang.String r7 = r8.b()     // Catch: java.io.IOException -> L94
                boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch: java.io.IOException -> L94
                if (r8 == 0) goto L16
                goto L8e
            L16:
                org.json.JSONObject r8 = new org.json.JSONObject     // Catch: java.lang.Exception -> L88
                r8.<init>(r7)     // Catch: java.lang.Exception -> L88
                java.lang.String r7 = "data"
                org.json.JSONObject r7 = r8.optJSONObject(r7)     // Catch: java.lang.Exception -> L88
                com.qq.e.comm.plugin.m0.a r1 = com.qq.e.comm.plugin.m0.a.this     // Catch: java.lang.Exception -> L88
                java.lang.String r2 = "domain"
                java.lang.String r2 = r7.optString(r2)     // Catch: java.lang.Exception -> L88
                java.lang.String r1 = com.qq.e.comm.plugin.m0.a.a(r1, r2)     // Catch: java.lang.Exception -> L88
                boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L88
                if (r1 == 0) goto L38
                com.qq.e.comm.plugin.m0.a r1 = com.qq.e.comm.plugin.m0.a.this     // Catch: java.lang.Exception -> L88
                com.qq.e.comm.plugin.m0.a.a(r1, r0)     // Catch: java.lang.Exception -> L88
            L38:
                com.qq.e.comm.plugin.m0.a r1 = com.qq.e.comm.plugin.m0.a.this     // Catch: java.lang.Exception -> L88
                java.lang.String r2 = "region"
                java.lang.String r7 = r7.optString(r2)     // Catch: java.lang.Exception -> L88
                com.qq.e.comm.plugin.m0.a.b(r1, r7)     // Catch: java.lang.Exception -> L88
                java.lang.String r7 = "code"
                r1 = 0
                int r7 = r8.optInt(r7, r1)     // Catch: java.lang.Exception -> L88
                com.qq.e.comm.plugin.m0.a r8 = com.qq.e.comm.plugin.m0.a.this     // Catch: java.lang.Exception -> L88
                r2 = 110(0x6e, float:1.54E-43)
                r3 = 1
                if (r7 == r2) goto L53
                r2 = 1
                goto L54
            L53:
                r2 = 0
            L54:
                com.qq.e.comm.plugin.m0.a.a(r8, r2)     // Catch: java.lang.Exception -> L88
                com.qq.e.comm.plugin.m0.a r8 = com.qq.e.comm.plugin.m0.a.this     // Catch: java.lang.Exception -> L88
                boolean r8 = com.qq.e.comm.plugin.m0.a.d(r8)     // Catch: java.lang.Exception -> L88
                if (r8 != 0) goto L66
                com.qq.e.comm.plugin.m0.a r8 = com.qq.e.comm.plugin.m0.a.this     // Catch: java.lang.Exception -> L88
                java.lang.String r2 = "https://xx.xx.xx.xx"
                com.qq.e.comm.plugin.m0.a.a(r8, r2)     // Catch: java.lang.Exception -> L88
            L66:
                java.lang.String r8 = "GDTConfig"
                java.lang.String r2 = "getOverseaDomainFromServer: mOverseaConfigRegion=%s, mOverseaConfigDomain=%s, code=%d"
                r4 = 3
                java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Exception -> L88
                com.qq.e.comm.plugin.m0.a r5 = com.qq.e.comm.plugin.m0.a.this     // Catch: java.lang.Exception -> L88
                java.lang.String r5 = com.qq.e.comm.plugin.m0.a.c(r5)     // Catch: java.lang.Exception -> L88
                r4[r1] = r5     // Catch: java.lang.Exception -> L88
                com.qq.e.comm.plugin.m0.a r1 = com.qq.e.comm.plugin.m0.a.this     // Catch: java.lang.Exception -> L88
                java.lang.String r1 = com.qq.e.comm.plugin.m0.a.b(r1)     // Catch: java.lang.Exception -> L88
                r4[r3] = r1     // Catch: java.lang.Exception -> L88
                r1 = 2
                java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Exception -> L88
                r4[r1] = r7     // Catch: java.lang.Exception -> L88
                com.qq.e.comm.plugin.util.d1.a(r8, r2, r4)     // Catch: java.lang.Exception -> L88
                goto L99
            L88:
                com.qq.e.comm.plugin.m0.a r7 = com.qq.e.comm.plugin.m0.a.this     // Catch: java.io.IOException -> L94
                com.qq.e.comm.plugin.m0.a.a(r7, r0)     // Catch: java.io.IOException -> L94
                goto L99
            L8e:
                com.qq.e.comm.plugin.m0.a r7 = com.qq.e.comm.plugin.m0.a.this     // Catch: java.io.IOException -> L94
                com.qq.e.comm.plugin.m0.a.a(r7, r0)     // Catch: java.io.IOException -> L94
                goto L99
            L94:
                com.qq.e.comm.plugin.m0.a r7 = com.qq.e.comm.plugin.m0.a.this
                com.qq.e.comm.plugin.m0.a.a(r7, r0)
            L99:
                long r7 = android.os.SystemClock.elapsedRealtime()
                long r0 = r6.f44690a
                long r7 = r7 - r0
                r0 = 2000(0x7d0, double:9.88E-321)
                int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r2 >= 0) goto Lab
                com.qq.e.comm.plugin.m0.a r7 = com.qq.e.comm.plugin.m0.a.this
                com.qq.e.comm.plugin.m0.a.e(r7)
            Lab:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.m0.a.g.a(com.qq.e.comm.plugin.i0.n.f, com.qq.e.comm.plugin.i0.n.g):void");
        }

        @Override // com.qq.e.comm.plugin.i0.b
        public void a(com.qq.e.comm.plugin.i0.n.f fVar, Exception exc) {
            if (SystemClock.elapsedRealtime() - this.f44690a < 2000) {
                a.a(a.this, "https://sg.ylhglobal.com");
                a.e(a.this);
            }
        }
    }
}
