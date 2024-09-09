package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.stub.StubApp;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.JSONException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: OfflineDownloadManager.java */
/* renamed from: com.amap.api.col.3l.b0  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class b0 {

    /* renamed from: o  reason: collision with root package name */
    public static String f7174o = "";

    /* renamed from: p  reason: collision with root package name */
    public static boolean f7175p = false;

    /* renamed from: q  reason: collision with root package name */
    private static volatile b0 f7176q = null;

    /* renamed from: r  reason: collision with root package name */
    public static String f7177r = "";

    /* renamed from: a  reason: collision with root package name */
    private Context f7178a;

    /* renamed from: d  reason: collision with root package name */
    private d f7181d;

    /* renamed from: e  reason: collision with root package name */
    private l0 f7182e;

    /* renamed from: f  reason: collision with root package name */
    private r0 f7183f;

    /* renamed from: k  reason: collision with root package name */
    public g0 f7188k;

    /* renamed from: l  reason: collision with root package name */
    i0 f7189l;

    /* renamed from: b  reason: collision with root package name */
    private boolean f7179b = true;

    /* renamed from: c  reason: collision with root package name */
    List<ax> f7180c = new Vector();

    /* renamed from: g  reason: collision with root package name */
    private z7 f7184g = null;

    /* renamed from: h  reason: collision with root package name */
    private z7 f7185h = null;

    /* renamed from: i  reason: collision with root package name */
    private z7 f7186i = null;

    /* renamed from: j  reason: collision with root package name */
    e f7187j = null;

    /* renamed from: m  reason: collision with root package name */
    f0 f7190m = null;

    /* renamed from: n  reason: collision with root package name */
    private boolean f7191n = true;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: OfflineDownloadManager.java */
    /* renamed from: com.amap.api.col.3l.b0$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a extends a8 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f7192a;

        a(String str) {
            this.f7192a = str;
        }

        @Override // com.amap.api.col.p0003l.a8
        public final void runTask() {
            ax I = b0.this.I(this.f7192a);
            if (I != null) {
                try {
                    if (!I.s().equals(I.f7136h) && !I.s().equals(I.f7138j)) {
                        String pinyin = I.getPinyin();
                        if (pinyin.length() > 0) {
                            String n4 = b0.this.f7183f.n(pinyin);
                            if (n4 == null) {
                                n4 = I.getVersion();
                            }
                            if (b0.f7177r.length() > 0 && n4 != null && b0.n(b0.f7177r, n4)) {
                                I.F();
                            }
                        }
                    }
                    if (b0.this.f7181d != null) {
                        synchronized (b0.this) {
                            try {
                                b0.this.f7181d.b(I);
                            }
                        }
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    if (b0.this.f7181d != null) {
                        synchronized (b0.this) {
                            try {
                                b0.this.f7181d.b(I);
                                return;
                            }
                        }
                    }
                    return;
                } catch (Throwable th) {
                    if (b0.this.f7181d != null) {
                        synchronized (b0.this) {
                            try {
                                b0.this.f7181d.b(I);
                            }
                        }
                    }
                    throw th;
                }
            }
            b0.this.L();
            c0 f4 = new e0(b0.this.f7178a, b0.f7177r).f();
            if (b0.this.f7181d != null) {
                if (f4 == null) {
                    if (b0.this.f7181d != null) {
                        synchronized (b0.this) {
                            try {
                                b0.this.f7181d.b(I);
                            }
                        }
                        return;
                    }
                    return;
                } else if (f4.c()) {
                    b0.this.p();
                }
            }
            if (b0.this.f7181d != null) {
                synchronized (b0.this) {
                    try {
                        b0.this.f7181d.b(I);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: OfflineDownloadManager.java */
    /* renamed from: com.amap.api.col.3l.b0$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class b extends a8 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ax f7194a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f7195b;

        b(ax axVar, boolean z3) {
            this.f7194a = axVar;
            this.f7195b = z3;
        }

        @Override // com.amap.api.col.p0003l.a8
        public final void runTask() {
            try {
                if (this.f7194a.s().equals(this.f7194a.f7134f)) {
                    if (b0.this.f7181d != null) {
                        b0.this.f7181d.c(this.f7194a);
                        return;
                    }
                    return;
                }
                if (this.f7194a.getState() != 7 && this.f7194a.getState() != -1) {
                    b0.this.f7189l.a(this.f7194a);
                    if (b0.this.f7181d != null) {
                        b0.this.f7181d.c(this.f7194a);
                        return;
                    }
                    return;
                }
                b0.this.f7189l.a(this.f7194a);
                if (!this.f7195b || b0.this.f7181d == null) {
                    return;
                }
                b0.this.f7181d.c(this.f7194a);
            } catch (Throwable th) {
                u5.p(th, "requestDelete", "removeExcecRunnable");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: OfflineDownloadManager.java */
    /* renamed from: com.amap.api.col.3l.b0$c */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class c extends a8 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ax f7197a;

        c(ax axVar) {
            this.f7197a = axVar;
        }

        @Override // com.amap.api.col.p0003l.a8
        public final void runTask() {
            try {
                if (b0.this.f7179b) {
                    b0.this.L();
                    c0 f4 = new e0(b0.this.f7178a, b0.f7177r).f();
                    if (f4 != null) {
                        b0.D(b0.this);
                        if (f4.c()) {
                            b0.this.p();
                        }
                    }
                }
                this.f7197a.setVersion(b0.f7177r);
                this.f7197a.B();
            } catch (AMapException e4) {
                e4.printStackTrace();
            } catch (Throwable th) {
                u5.p(th, "OfflineDownloadManager", "startDownloadRunnable");
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: OfflineDownloadManager.java */
    /* renamed from: com.amap.api.col.3l.b0$d */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface d {
        void a();

        void a(ax axVar);

        void b(ax axVar);

        void c(ax axVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: OfflineDownloadManager.java */
    /* renamed from: com.amap.api.col.3l.b0$e */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                message.getData();
                Object obj = message.obj;
                if (obj instanceof ax) {
                    ax axVar = (ax) obj;
                    axVar.getCity();
                    axVar.getcompleteCode();
                    axVar.getState();
                    if (b0.this.f7181d != null) {
                        b0.this.f7181d.a(axVar);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private b0(Context context) {
        this.f7178a = context;
    }

    private void B(ax axVar) throws AMapException {
        L();
        if (axVar != null) {
            if (this.f7186i == null) {
                this.f7186i = z2.b("AMapOfflineDownload");
            }
            try {
                this.f7186i.b(new c(axVar));
                return;
            } catch (Throwable th) {
                u5.p(th, "startDownload", "downloadExcecRunnable");
                return;
            }
        }
        throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
    }

    static /* synthetic */ boolean D(b0 b0Var) {
        b0Var.f7179b = false;
        return false;
    }

    private void F() {
        try {
            m0 a4 = this.f7183f.a("000001");
            if (a4 != null) {
                this.f7183f.m("000001");
                a4.b("100000");
                this.f7183f.e(a4);
            }
        } catch (Throwable th) {
            u5.p(th, "OfflineDownloadManager", "changeBadCase");
        }
    }

    private void G() {
        String n4;
        if ("".equals(a3.f0(this.f7178a))) {
            return;
        }
        File file = new File(a3.f0(this.f7178a) + "offlinemapv4.png");
        if (!file.exists()) {
            n4 = z0.d(this.f7178a, "offlinemapv4.png");
        } else {
            n4 = z0.n(file);
        }
        if (n4 != null) {
            try {
                H(n4);
            } catch (JSONException e4) {
                if (file.exists()) {
                    file.delete();
                }
                u5.p(e4, "MapDownloadManager", "paseJson io");
                e4.printStackTrace();
            }
        }
    }

    private void H(String str) throws JSONException {
        g0 g0Var;
        List<OfflineMapProvince> f4 = z0.f(str, StubApp.getOrigApplicationContext(this.f7178a.getApplicationContext()));
        if (f4 == null || f4.size() == 0 || (g0Var = this.f7188k) == null) {
            return;
        }
        g0Var.i(f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0019 A[Catch: all -> 0x0037, TryCatch #0 {, blocks: (B:9:0x000d, B:10:0x0013, B:12:0x0019, B:14:0x0029, B:16:0x0033, B:18:0x0035), top: B:24:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.amap.api.col.p0003l.ax I(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L3a
            int r1 = r6.length()
            if (r1 > 0) goto La
            goto L3a
        La:
            java.util.List<com.amap.api.col.3l.ax> r1 = r5.f7180c
            monitor-enter(r1)
            java.util.List<com.amap.api.col.3l.ax> r2 = r5.f7180c     // Catch: java.lang.Throwable -> L37
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L37
        L13:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L37
            if (r3 == 0) goto L35
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L37
            com.amap.api.col.3l.ax r3 = (com.amap.api.col.p0003l.ax) r3     // Catch: java.lang.Throwable -> L37
            java.lang.String r4 = r3.getCity()     // Catch: java.lang.Throwable -> L37
            boolean r4 = r6.equals(r4)     // Catch: java.lang.Throwable -> L37
            if (r4 != 0) goto L33
            java.lang.String r4 = r3.getPinyin()     // Catch: java.lang.Throwable -> L37
            boolean r4 = r6.equals(r4)     // Catch: java.lang.Throwable -> L37
            if (r4 == 0) goto L13
        L33:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L37
            return r3
        L35:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L37
            return r0
        L37:
            r6 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L37
            throw r6
        L3a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.b0.I(java.lang.String):com.amap.api.col.3l.ax");
    }

    private void J() {
        Iterator<m0> it = this.f7183f.c().iterator();
        while (it.hasNext()) {
            m0 next = it.next();
            if (next != null && next.a() != null && next.e().length() > 0) {
                int i4 = next.f8591l;
                if (i4 != 4 && i4 != 7 && i4 >= 0) {
                    next.f8591l = 3;
                }
                ax I = I(next.a());
                if (I != null) {
                    String c4 = next.c();
                    if (c4 != null && n(f7177r, c4)) {
                        I.m(7);
                    } else {
                        I.m(next.f8591l);
                        I.setCompleteCode(next.i());
                    }
                    if (next.c().length() > 0) {
                        I.setVersion(next.c());
                    }
                    List<String> j4 = this.f7183f.j(next.e());
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : j4) {
                        stringBuffer.append(str);
                        stringBuffer.append(";");
                    }
                    I.p(stringBuffer.toString());
                    g0 g0Var = this.f7188k;
                    if (g0Var != null) {
                        g0Var.c(I);
                    }
                }
            }
        }
    }

    private ax K(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        synchronized (this.f7180c) {
            for (ax axVar : this.f7180c) {
                if (str.equals(axVar.getCode())) {
                    return axVar;
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() throws AMapException {
        if (!a3.h0(this.f7178a)) {
            throw new AMapException("http\u8fde\u63a5\u5931\u8d25 - ConnectionException");
        }
    }

    private static void M() {
        f7176q = null;
        f7175p = true;
    }

    private static void N(String str) {
        f7174o = str;
    }

    private void O() {
        synchronized (this) {
            this.f7181d = null;
        }
    }

    public static b0 b(Context context) {
        if (f7176q == null) {
            synchronized (b0.class) {
                if (f7176q == null && !f7175p) {
                    f7176q = new b0(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                }
            }
        }
        return f7176q;
    }

    private void f(ax axVar, boolean z3) {
        if (this.f7189l == null) {
            this.f7189l = new i0(this.f7178a);
        }
        if (this.f7185h == null) {
            this.f7185h = z2.b("AMapOfflineRemove");
        }
        try {
            this.f7185h.b(new b(axVar, z3));
        } catch (Throwable th) {
            u5.p(th, "requestDelete", "removeExcecRunnable");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean n(String str, String str2) {
        for (int i4 = 0; i4 < str2.length(); i4++) {
            try {
                if (str.charAt(i4) > str2.charAt(i4)) {
                    return true;
                }
                if (str.charAt(i4) < str2.charAt(i4)) {
                    return false;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public final void A() {
        z7 z7Var = this.f7184g;
        if (z7Var != null) {
            z7Var.g();
        }
        z7 z7Var2 = this.f7186i;
        if (z7Var2 != null) {
            z7Var2.g();
            this.f7186i = null;
        }
        f0 f0Var = this.f7190m;
        if (f0Var != null) {
            if (f0Var.isAlive()) {
                this.f7190m.interrupt();
            }
            this.f7190m = null;
        }
        e eVar = this.f7187j;
        if (eVar != null) {
            eVar.removeCallbacksAndMessages(null);
            this.f7187j = null;
        }
        l0 l0Var = this.f7182e;
        if (l0Var != null) {
            l0Var.d();
            this.f7182e = null;
        }
        g0 g0Var = this.f7188k;
        if (g0Var != null) {
            g0Var.w();
        }
        M();
        this.f7179b = true;
        O();
    }

    public final void C(String str) throws AMapException {
        ax K = K(str);
        if (K != null) {
            B(K);
            return;
        }
        throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
    }

    public final String E(String str) {
        ax I;
        return (str == null || (I = I(str)) == null) ? "" : I.getAdcode();
    }

    public final void d() {
        this.f7183f = r0.b(StubApp.getOrigApplicationContext(this.f7178a.getApplicationContext()));
        F();
        this.f7187j = new e(this.f7178a.getMainLooper());
        this.f7188k = new g0(this.f7178a);
        this.f7182e = l0.a();
        N(a3.f0(this.f7178a));
        try {
            G();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        synchronized (this.f7180c) {
            Iterator<OfflineMapProvince> it = this.f7188k.b().iterator();
            while (it.hasNext()) {
                Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                while (it2.hasNext()) {
                    OfflineMapCity next = it2.next();
                    if (next != null) {
                        this.f7180c.add(new ax(this.f7178a, next));
                    }
                }
            }
        }
        f0 f0Var = new f0(this.f7178a);
        this.f7190m = f0Var;
        f0Var.start();
    }

    public final void e(ax axVar) {
        f(axVar, false);
    }

    public final void g(d dVar) {
        this.f7181d = dVar;
    }

    public final void h(String str) {
        try {
            if (str == null) {
                d dVar = this.f7181d;
                if (dVar != null) {
                    dVar.b(null);
                    return;
                }
                return;
            }
            if (this.f7184g == null) {
                this.f7184g = z2.b("AMapOfflineCheckUpdate");
            }
            this.f7184g.b(new a(str));
        } catch (Throwable th) {
            u5.p(th, "OfflineDownloadManager", "checkUpdate");
        }
    }

    public final void j() {
        J();
        d dVar = this.f7181d;
        if (dVar != null) {
            try {
                dVar.a();
            } catch (Throwable th) {
                u5.p(th, "OfflineDownloadManager", "verifyCallBack");
            }
        }
    }

    public final void k(ax axVar) {
        try {
            l0 l0Var = this.f7182e;
            if (l0Var != null) {
                l0Var.c(axVar, this.f7178a);
            }
        } catch (fk e4) {
            e4.printStackTrace();
        }
    }

    public final boolean m(String str) {
        return I(str) != null;
    }

    protected final void p() throws AMapException {
        if (this.f7188k == null) {
            return;
        }
        j0 j0Var = new j0(this.f7178a, "");
        j0Var.h(this.f7178a);
        List<OfflineMapProvince> f4 = j0Var.f();
        if (this.f7180c != null) {
            this.f7188k.i(f4);
        }
        List<ax> list = this.f7180c;
        if (list != null) {
            synchronized (list) {
                Iterator<OfflineMapProvince> it = this.f7188k.b().iterator();
                while (it.hasNext()) {
                    Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                    while (it2.hasNext()) {
                        OfflineMapCity next = it2.next();
                        for (ax axVar : this.f7180c) {
                            if (next.getPinyin().equals(axVar.getPinyin())) {
                                String version = axVar.getVersion();
                                if (axVar.getState() == 4 && f7177r.length() > 0 && n(f7177r, version)) {
                                    axVar.F();
                                    axVar.setUrl(next.getUrl());
                                    axVar.I();
                                } else {
                                    axVar.setCity(next.getCity());
                                    axVar.setUrl(next.getUrl());
                                    axVar.I();
                                    axVar.setAdcode(next.getAdcode());
                                    axVar.setVersion(next.getVersion());
                                    axVar.setSize(next.getSize());
                                    axVar.setCode(next.getCode());
                                    axVar.setJianpin(next.getJianpin());
                                    axVar.setPinyin(next.getPinyin());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final void q(ax axVar) {
        g0 g0Var = this.f7188k;
        if (g0Var != null) {
            g0Var.c(axVar);
        }
        e eVar = this.f7187j;
        if (eVar != null) {
            Message obtainMessage = eVar.obtainMessage();
            obtainMessage.obj = axVar;
            this.f7187j.sendMessage(obtainMessage);
        }
    }

    public final void r(String str) {
        ax I = I(str);
        if (I == null) {
            d dVar = this.f7181d;
            if (dVar != null) {
                try {
                    dVar.c(I);
                    return;
                } catch (Throwable th) {
                    u5.p(th, "OfflineDownloadManager", "remove");
                    return;
                }
            }
            return;
        }
        u(I);
        f(I, true);
    }

    public final void t() {
        synchronized (this.f7180c) {
            for (ax axVar : this.f7180c) {
                if (axVar.s().equals(axVar.f7136h) || axVar.s().equals(axVar.f7135g)) {
                    u(axVar);
                    axVar.C();
                }
            }
        }
    }

    public final void u(ax axVar) {
        l0 l0Var = this.f7182e;
        if (l0Var != null) {
            l0Var.b(axVar);
        }
    }

    public final void v(String str) {
        ax I = I(str);
        if (I != null) {
            I.B();
        }
    }

    public final void w() {
        synchronized (this.f7180c) {
            Iterator<ax> it = this.f7180c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ax next = it.next();
                if (next.s().equals(next.f7136h)) {
                    next.C();
                    break;
                }
            }
        }
    }

    public final void x(ax axVar) {
        l0 l0Var = this.f7182e;
        if (l0Var != null) {
            l0Var.e(axVar);
        }
    }

    public final void y(String str) throws AMapException {
        ax I = I(str);
        if (str != null && str.length() > 0 && I != null) {
            B(I);
            return;
        }
        throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
    }
}
