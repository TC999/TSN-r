package com.autonavi.aps.amapapi;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import com.amap.api.col.p0003l.k9;
import com.amap.api.col.p0003l.q4;
import com.amap.api.col.p0003l.u5;
import com.amap.api.col.p0003l.y6;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.restruct.e;
import com.autonavi.aps.amapapi.restruct.g;
import com.autonavi.aps.amapapi.restruct.k;
import com.autonavi.aps.amapapi.trans.f;
import com.autonavi.aps.amapapi.utils.h;
import com.autonavi.aps.amapapi.utils.j;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Aps.java */
@SuppressLint({"NewApi"})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class b {
    static int A = -1;
    public static String[] D = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    public static String E = "android.permission.ACCESS_BACKGROUND_LOCATION";
    private static boolean K;
    private static volatile boolean Q;
    boolean F;
    private Handler N;
    private g O;
    private String P;
    private c R;

    /* renamed from: a  reason: collision with root package name */
    Context f11686a = null;

    /* renamed from: b  reason: collision with root package name */
    ConnectivityManager f11687b = null;

    /* renamed from: c  reason: collision with root package name */
    k f11688c = null;

    /* renamed from: d  reason: collision with root package name */
    e f11689d = null;

    /* renamed from: e  reason: collision with root package name */
    com.autonavi.aps.amapapi.storage.a f11690e = null;

    /* renamed from: f  reason: collision with root package name */
    com.autonavi.aps.amapapi.trans.e f11691f = null;

    /* renamed from: g  reason: collision with root package name */
    ArrayList<k9> f11692g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    a f11693h = null;

    /* renamed from: i  reason: collision with root package name */
    AMapLocationClientOption f11694i = new AMapLocationClientOption();

    /* renamed from: j  reason: collision with root package name */
    com.autonavi.aps.amapapi.model.a f11695j = null;

    /* renamed from: k  reason: collision with root package name */
    long f11696k = 0;
    private int I = 0;

    /* renamed from: l  reason: collision with root package name */
    f f11697l = null;

    /* renamed from: m  reason: collision with root package name */
    boolean f11698m = false;
    private String J = null;

    /* renamed from: n  reason: collision with root package name */
    com.autonavi.aps.amapapi.trans.c f11699n = null;

    /* renamed from: o  reason: collision with root package name */
    StringBuilder f11700o = new StringBuilder();

    /* renamed from: p  reason: collision with root package name */
    boolean f11701p = true;

    /* renamed from: q  reason: collision with root package name */
    boolean f11702q = true;

    /* renamed from: r  reason: collision with root package name */
    AMapLocationClientOption.GeoLanguage f11703r = AMapLocationClientOption.GeoLanguage.DEFAULT;

    /* renamed from: s  reason: collision with root package name */
    boolean f11704s = true;

    /* renamed from: t  reason: collision with root package name */
    boolean f11705t = false;

    /* renamed from: L  reason: collision with root package name */
    private String f11685L = null;

    /* renamed from: u  reason: collision with root package name */
    StringBuilder f11706u = null;

    /* renamed from: v  reason: collision with root package name */
    boolean f11707v = false;

    /* renamed from: w  reason: collision with root package name */
    public boolean f11708w = false;

    /* renamed from: x  reason: collision with root package name */
    int f11709x = 12;
    private boolean M = true;

    /* renamed from: y  reason: collision with root package name */
    com.autonavi.aps.amapapi.restruct.b f11710y = null;

    /* renamed from: z  reason: collision with root package name */
    boolean f11711z = false;
    com.autonavi.aps.amapapi.filters.a B = null;
    String C = null;
    IntentFilter G = null;
    LocationManager H = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: Aps.java */
    /* renamed from: com.autonavi.aps.amapapi.b$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f11712a;

        static {
            int[] iArr = new int[AMapLocationClientOption.GeoLanguage.values().length];
            f11712a = iArr;
            try {
                iArr[AMapLocationClientOption.GeoLanguage.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11712a[AMapLocationClientOption.GeoLanguage.ZH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11712a[AMapLocationClientOption.GeoLanguage.EN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: Aps.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            k kVar;
            k kVar2;
            if (context == null || intent == null) {
                return;
            }
            try {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                    k kVar3 = b.this.f11688c;
                    if (kVar3 != null) {
                        kVar3.i();
                    }
                    try {
                        if (intent.getExtras() == null || !intent.getExtras().getBoolean("resultsUpdated", true) || (kVar2 = b.this.f11688c) == null) {
                            return;
                        }
                        kVar2.h();
                    } catch (Throwable unused) {
                    }
                } else if (!action.equals("android.net.wifi.WIFI_STATE_CHANGED") || (kVar = b.this.f11688c) == null) {
                } else {
                    kVar.j();
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "onReceive");
            }
        }
    }

    public b(boolean z3) {
        this.F = z3;
    }

    private void i() {
        if (this.f11699n != null) {
            try {
                if (this.f11694i == null) {
                    this.f11694i = new AMapLocationClientOption();
                }
                this.f11699n.a(this.f11694i.getHttpTimeOut(), this.f11694i.getLocationProtocol().equals(AMapLocationClientOption.AMapLocationProtocol.HTTPS), j());
            } catch (Throwable unused) {
            }
        }
    }

    private int j() {
        int i4;
        if (this.f11694i.getGeoLanguage() != null && (i4 = AnonymousClass1.f11712a[this.f11694i.getGeoLanguage().ordinal()]) != 1) {
            if (i4 == 2) {
                return 1;
            }
            if (i4 == 3) {
                return 2;
            }
        }
        return 0;
    }

    private void k() {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        AMapLocationClientOption.GeoLanguage geoLanguage = AMapLocationClientOption.GeoLanguage.DEFAULT;
        boolean z7 = true;
        try {
            geoLanguage = this.f11694i.getGeoLanguage();
            z3 = this.f11694i.isNeedAddress();
            try {
                z5 = this.f11694i.isOffset();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            z3 = true;
        }
        try {
            z6 = this.f11694i.isLocationCacheEnable();
            try {
                this.f11705t = this.f11694i.isOnceLocationLatest();
                this.f11711z = this.f11694i.isSensorEnable();
                if (z5 != this.f11702q || z3 != this.f11701p || z6 != this.f11704s || geoLanguage != this.f11703r) {
                    s();
                }
            } catch (Throwable unused3) {
                z4 = z6;
                z7 = z5;
                boolean z8 = z4;
                z5 = z7;
                z6 = z8;
                this.f11702q = z5;
                this.f11701p = z3;
                this.f11704s = z6;
                this.f11703r = geoLanguage;
            }
        } catch (Throwable unused4) {
            z7 = z5;
            z4 = true;
            boolean z82 = z4;
            z5 = z7;
            z6 = z82;
            this.f11702q = z5;
            this.f11701p = z3;
            this.f11704s = z6;
            this.f11703r = geoLanguage;
        }
        this.f11702q = z5;
        this.f11701p = z3;
        this.f11704s = z6;
        this.f11703r = geoLanguage;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void l() {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = r4.f11686a     // Catch: java.lang.Throwable -> Lf
            if (r1 == 0) goto Lc
            com.autonavi.aps.amapapi.b$a r2 = r4.f11693h     // Catch: java.lang.Throwable -> Lf
            if (r2 == 0) goto Lc
            r1.unregisterReceiver(r2)     // Catch: java.lang.Throwable -> Lf
        Lc:
            r4.f11693h = r0
            goto L18
        Lf:
            r1 = move-exception
            java.lang.String r2 = "Aps"
            java.lang.String r3 = "destroy"
            com.autonavi.aps.amapapi.utils.b.a(r1, r2, r3)     // Catch: java.lang.Throwable -> L2b
            goto Lc
        L18:
            com.autonavi.aps.amapapi.restruct.e r0 = r4.f11689d
            if (r0 == 0) goto L21
            boolean r1 = r4.F
            r0.a(r1)
        L21:
            com.autonavi.aps.amapapi.restruct.k r0 = r4.f11688c
            if (r0 == 0) goto L2a
            boolean r1 = r4.F
            r0.c(r1)
        L2a:
            return
        L2b:
            r1 = move-exception
            r4.f11693h = r0
            goto L30
        L2f:
            throw r1
        L30:
            goto L2f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.b.l():void");
    }

    private void m() {
        try {
            if (this.f11693h == null) {
                this.f11693h = new a();
            }
            if (this.G == null) {
                IntentFilter intentFilter = new IntentFilter();
                this.G = intentFilter;
                intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
                this.G.addAction("android.net.wifi.SCAN_RESULTS");
            }
            this.f11686a.registerReceiver(this.f11693h, this.G);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "initBroadcastListener");
        }
    }

    private byte[] n() throws Throwable {
        if (this.f11697l == null) {
            this.f11697l = new f();
        }
        if (this.f11694i == null) {
            this.f11694i = new AMapLocationClientOption();
        }
        if (this.f11689d != null && this.f11688c != null) {
            this.f11697l.a(this.f11686a, this.f11694i.isNeedAddress(), this.f11694i.isOffset(), this.f11689d, this.f11688c, this.f11687b, this.C, this.O);
        }
        return this.f11697l.a();
    }

    private boolean o() {
        return this.f11696k == 0 || j.b() - this.f11696k > 20000;
    }

    private void p() {
        k kVar = this.f11688c;
        if (kVar == null) {
            return;
        }
        kVar.a(this.f11698m);
    }

    private boolean q() {
        k kVar = this.f11688c;
        if (kVar != null) {
            this.f11692g = kVar.e();
        }
        ArrayList<k9> arrayList = this.f11692g;
        return arrayList == null || arrayList.size() <= 0;
    }

    private void r() {
        if (this.f11685L != null) {
            this.f11685L = null;
        }
        StringBuilder sb = this.f11706u;
        if (sb != null) {
            sb.delete(0, sb.length());
        }
    }

    private void s() {
        try {
            com.autonavi.aps.amapapi.storage.a aVar = this.f11690e;
            if (aVar != null) {
                aVar.a();
            }
            d(null);
            this.M = false;
            com.autonavi.aps.amapapi.filters.a aVar2 = this.B;
            if (aVar2 != null) {
                aVar2.a();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "cleanCache");
        }
    }

    public final void a(Handler handler) {
        this.N = handler;
    }

    public final void b() {
        this.f11699n = com.autonavi.aps.amapapi.trans.c.a(this.f11686a);
        i();
        if (this.f11687b == null) {
            this.f11687b = (ConnectivityManager) j.a(this.f11686a, "connectivity");
        }
        if (this.f11697l == null) {
            this.f11697l = new f();
        }
    }

    public final void c() {
        if (this.f11710y == null) {
            this.f11710y = new com.autonavi.aps.amapapi.restruct.b(this.f11686a);
        }
        m();
        k kVar = this.f11688c;
        if (kVar != null) {
            kVar.b(false);
            this.f11692g = this.f11688c.e();
        }
        e eVar = this.f11689d;
        if (eVar != null) {
            eVar.a(false, q());
        }
        this.f11690e.a(this.f11686a);
        b(this.f11686a);
        this.f11708w = true;
    }

    public final void d() {
        if (this.f11700o.length() > 0) {
            StringBuilder sb = this.f11700o;
            sb.delete(0, sb.length());
        }
    }

    @SuppressLint({"NewApi"})
    public final void e() {
        this.C = null;
        this.f11707v = false;
        this.f11708w = false;
        com.autonavi.aps.amapapi.storage.a aVar = this.f11690e;
        if (aVar != null) {
            aVar.b(this.f11686a);
        }
        com.autonavi.aps.amapapi.filters.a aVar2 = this.B;
        if (aVar2 != null) {
            aVar2.a();
        }
        if (this.f11691f != null) {
            this.f11691f = null;
        }
        g gVar = this.O;
        if (gVar != null) {
            gVar.a(this.F);
        }
        l();
        ArrayList<k9> arrayList = this.f11692g;
        if (arrayList != null) {
            arrayList.clear();
        }
        com.autonavi.aps.amapapi.restruct.b bVar = this.f11710y;
        if (bVar != null) {
            bVar.f();
        }
        this.f11695j = null;
        this.f11686a = null;
        this.f11706u = null;
        this.H = null;
    }

    public final void f() {
        c cVar = this.R;
        if (cVar != null) {
            cVar.d();
        }
    }

    public final void g() {
        k kVar;
        try {
            if (this.f11686a == null) {
                return;
            }
            if (this.R == null) {
                this.R = new c(this.f11686a);
            }
            e eVar = this.f11689d;
            if (eVar == null || (kVar = this.f11688c) == null) {
                return;
            }
            this.R.a(eVar, kVar, this.N);
        } catch (Throwable th) {
            u5.p(th, "as", "stc");
        }
    }

    public final void h() {
        c cVar = this.R;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void a(Context context) {
        try {
            if (this.f11686a != null) {
                return;
            }
            this.B = new com.autonavi.aps.amapapi.filters.a();
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f11686a = origApplicationContext;
            j.b(origApplicationContext);
            if (this.f11688c == null) {
                this.f11688c = new k(this.f11686a, (WifiManager) j.a(this.f11686a, "wifi"), this.N);
            }
            if (this.f11689d == null) {
                this.f11689d = new e(this.f11686a, this.N);
            }
            this.O = new g(context, this.N);
            if (this.f11690e == null) {
                this.f11690e = new com.autonavi.aps.amapapi.storage.a();
            }
            if (this.f11691f == null) {
                this.f11691f = new com.autonavi.aps.amapapi.trans.e();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "initBase");
        }
    }

    private void d(com.autonavi.aps.amapapi.model.a aVar) {
        if (aVar != null) {
            this.f11695j = aVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0106 A[Catch: all -> 0x01fd, TRY_LEAVE, TryCatch #2 {all -> 0x01fd, blocks: (B:10:0x0052, B:12:0x007b, B:16:0x0086, B:18:0x008e, B:21:0x0096, B:22:0x0098, B:24:0x009e, B:25:0x00a8, B:29:0x00b1, B:31:0x00c4, B:33:0x00c8, B:34:0x00d2, B:37:0x00e8, B:39:0x00ee, B:41:0x00f2, B:44:0x0102, B:46:0x0106, B:42:0x00f9, B:43:0x00ff), top: B:102:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013f  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.autonavi.aps.amapapi.model.a b(boolean r12, com.autonavi.aps.amapapi.a r13) {
        /*
            Method dump skipped, instructions count: 778
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.b.b(boolean, com.autonavi.aps.amapapi.a):com.autonavi.aps.amapapi.model.a");
    }

    private String c(com.autonavi.aps.amapapi.a aVar) {
        e eVar = this.f11689d;
        String str = "";
        if (eVar == null || this.f11688c == null) {
            return "";
        }
        int h4 = eVar.h();
        com.autonavi.aps.amapapi.restruct.d e4 = this.f11689d.e();
        com.autonavi.aps.amapapi.restruct.d f4 = this.f11689d.f();
        ArrayList<k9> arrayList = this.f11692g;
        boolean z3 = arrayList == null || arrayList.isEmpty();
        if (e4 == null && f4 == null && z3) {
            if (this.f11687b == null) {
                this.f11687b = (ConnectivityManager) j.a(this.f11686a, "connectivity");
            }
            if (j.c() >= 31) {
                if (j.a(this.f11686a) && !this.f11688c.l()) {
                    this.f11709x = 18;
                    this.f11700o.append("\u98de\u884c\u6a21\u5f0f\u4e0b\u5173\u95ed\u4e86WIFI\u5f00\u5173\uff0c\u8bf7\u5173\u95ed\u98de\u884c\u6a21\u5f0f\u6216\u8005\u6253\u5f00WIFI\u5f00\u5173#1802");
                    h.a((String) null, 2132);
                    aVar.f("#1802");
                    return "";
                }
            } else if (j.a(this.f11686a) && !this.f11688c.k()) {
                this.f11709x = 18;
                this.f11700o.append("\u98de\u884c\u6a21\u5f0f\u4e0b\u5173\u95ed\u4e86WIFI\u5f00\u5173\uff0c\u8bf7\u5173\u95ed\u98de\u884c\u6a21\u5f0f\u6216\u8005\u6253\u5f00WIFI\u5f00\u5173#1801");
                h.a((String) null, 2132);
                aVar.f("#1801");
                return "";
            }
            if (j.c() >= 28) {
                if (this.H == null) {
                    this.H = (LocationManager) StubApp.getOrigApplicationContext(this.f11686a.getApplicationContext()).getSystemService("location");
                }
                if (!((Boolean) com.autonavi.aps.amapapi.utils.f.a(this.H, "isLocationEnabled", new Object[0])).booleanValue()) {
                    this.f11709x = 12;
                    this.f11700o.append("\u5b9a\u4f4d\u670d\u52a1\u6ca1\u6709\u5f00\u542f\uff0c\u8bf7\u5728\u8bbe\u7f6e\u4e2d\u6253\u5f00\u5b9a\u4f4d\u670d\u52a1\u5f00\u5173#1206");
                    aVar.f("#1206");
                    h.a((String) null, 2121);
                    return "";
                }
            }
            if (!j.e(this.f11686a)) {
                this.f11709x = 12;
                this.f11700o.append("\u5b9a\u4f4d\u6743\u9650\u88ab\u7981\u7528,\u8bf7\u6388\u4e88\u5e94\u7528\u5b9a\u4f4d\u6743\u9650#1201");
                aVar.f("#1201");
                h.a((String) null, 2121);
                return "";
            } else if (j.c() >= 24 && j.c() < 28 && Settings.Secure.getInt(this.f11686a.getContentResolver(), "location_mode", 0) == 0) {
                this.f11709x = 12;
                aVar.f("#1206");
                this.f11700o.append("\u5b9a\u4f4d\u670d\u52a1\u6ca1\u6709\u5f00\u542f\uff0c\u8bf7\u5728\u8bbe\u7f6e\u4e2d\u6253\u5f00\u5b9a\u4f4d\u670d\u52a1\u5f00\u5173#1206");
                h.a((String) null, 2121);
                return "";
            } else {
                String k4 = this.f11689d.k();
                String d4 = this.f11688c.d();
                if (this.f11688c.a(this.f11687b) && d4 != null) {
                    this.f11709x = 12;
                    aVar.f("#1202");
                    this.f11700o.append("\u83b7\u53d6\u57fa\u7ad9\u4e0e\u83b7\u53d6WIFI\u7684\u6743\u9650\u90fd\u88ab\u7981\u7528\uff0c\u8bf7\u5728\u5b89\u5168\u8f6f\u4ef6\u4e2d\u6253\u5f00\u5e94\u7528\u7684\u5b9a\u4f4d\u6743\u9650#1202");
                    h.a((String) null, 2121);
                    return "";
                } else if (k4 != null) {
                    this.f11709x = 12;
                    if (!this.f11688c.k()) {
                        aVar.f("#1204");
                        this.f11700o.append("WIFI\u5f00\u5173\u5173\u95ed\uff0c\u5e76\u4e14\u83b7\u53d6\u57fa\u7ad9\u6743\u9650\u88ab\u7981\u7528\uff0c\u8bf7\u5728\u5b89\u5168\u8f6f\u4ef6\u4e2d\u6253\u5f00\u5e94\u7528\u7684\u5b9a\u4f4d\u6743\u9650\u6216\u8005\u6253\u5f00WIFI\u5f00\u5173#1204");
                    } else {
                        aVar.f("#1205");
                        this.f11700o.append("\u83b7\u53d6\u7684WIFI\u5217\u8868\u4e3a\u7a7a\uff0c\u5e76\u4e14\u83b7\u53d6\u57fa\u7ad9\u6743\u9650\u88ab\u7981\u7528\uff0c\u8bf7\u5728\u5b89\u5168\u8f6f\u4ef6\u4e2d\u6253\u5f00\u5e94\u7528\u7684\u5b9a\u4f4d\u6743\u9650#1205");
                    }
                    h.a((String) null, 2121);
                    return "";
                } else if (!this.f11688c.k() && !this.f11689d.n()) {
                    this.f11709x = 19;
                    aVar.f("#1901");
                    this.f11700o.append("\u6ca1\u6709\u68c0\u67e5\u5230SIM\u5361\uff0c\u5e76\u4e14WIFI\u5f00\u5173\u5173\u95ed\uff0c\u8bf7\u6253\u5f00WIFI\u5f00\u5173\u6216\u8005\u63d2\u5165SIM\u5361#1901");
                    h.a((String) null, 2133);
                    return "";
                } else {
                    if (!this.f11688c.k()) {
                        aVar.f("#1301");
                        this.f11700o.append("\u83b7\u53d6\u5230\u7684\u57fa\u7ad9\u4e3a\u7a7a\uff0c\u5e76\u4e14\u5173\u95ed\u4e86WIFI\u5f00\u5173\uff0c\u8bf7\u60a8\u6253\u5f00WIFI\u5f00\u5173\u518d\u53d1\u8d77\u5b9a\u4f4d#1301");
                    } else {
                        aVar.f("#1302");
                        if (this.f11688c.c() != null) {
                            this.f11700o.append("\u83b7\u53d6\u5230\u7684\u57fa\u7ad9\u548cWIFI\u4fe1\u606f\u5747\u4e3a\u7a7a\uff0c\u8bf7\u68c0\u67e5\u662f\u5426\u6388\u4e88APP\u5b9a\u4f4d\u6743\u9650");
                            if (!j.f(this.f11686a)) {
                                this.f11700o.append("\u6216\u540e\u53f0\u8fd0\u884c\u6ca1\u6709\u540e\u53f0\u5b9a\u4f4d\u6743\u9650");
                            }
                            this.f11700o.append("#1302");
                        } else {
                            this.f11700o.append("\u83b7\u53d6\u5230\u7684\u57fa\u7ad9\u548cWIFI\u4fe1\u606f\u5747\u4e3a\u7a7a\uff0c\u8bf7\u79fb\u52a8\u5230\u6709WIFI\u7684\u533a\u57df\uff0c\u82e5\u786e\u5b9a\u5f53\u524d\u533a\u57df\u6709WIFI\uff0c\u8bf7\u68c0\u67e5\u662f\u5426\u6388\u4e88APP\u5b9a\u4f4d\u6743\u9650");
                            if (!j.f(this.f11686a)) {
                                this.f11700o.append("\u6216\u540e\u53f0\u8fd0\u884c\u6ca1\u6709\u540e\u53f0\u5b9a\u4f4d\u6743\u9650");
                            }
                            this.f11700o.append("#1302");
                        }
                    }
                    this.f11709x = 13;
                    h.a((String) null, 2131);
                    return "";
                }
            }
        }
        boolean a4 = this.f11688c.a(this.f11688c.m());
        String str2 = "cgi";
        if (h4 == 0) {
            boolean z4 = !this.f11692g.isEmpty() || a4;
            boolean z5 = f4 != null;
            if (!z5) {
                if (a4 && this.f11692g.isEmpty()) {
                    this.f11709x = 2;
                    aVar.f("#0201");
                    this.f11700o.append("\u5f53\u524d\u57fa\u7ad9\u4e3a\u4f2a\u57fa\u7ad9\uff0c\u5e76\u4e14WIFI\u6743\u9650\u88ab\u7981\u7528\uff0c\u8bf7\u5728\u5b89\u5168\u8f6f\u4ef6\u4e2d\u6253\u5f00\u5e94\u7528\u7684\u5b9a\u4f4d\u6743\u9650#0201");
                    h.a((String) null, 2021);
                    return "";
                } else if (this.f11692g.size() == 1) {
                    this.f11709x = 2;
                    if (!a4) {
                        aVar.f("#0202");
                        this.f11700o.append("\u5f53\u524d\u57fa\u7ad9\u4e3a\u4f2a\u57fa\u7ad9\uff0c\u5e76\u4e14\u641c\u5230\u7684WIFI\u6570\u91cf\u4e0d\u8db3\uff0c\u8bf7\u79fb\u52a8\u5230WIFI\u6bd4\u8f83\u4e30\u5bcc\u7684\u533a\u57df#0202");
                        h.a((String) null, 2022);
                        return "";
                    } else if (this.f11692g.get(0).f8260h) {
                        aVar.f("#0202");
                        this.f11700o.append("\u5f53\u524d\u57fa\u7ad9\u4e3a\u4f2a\u57fa\u7ad9\uff0c\u5e76\u4e14\u641c\u5230\u7684WIFI\u6570\u91cf\u4e0d\u8db3\uff0c\u8bf7\u79fb\u52a8\u5230WIFI\u6bd4\u8f83\u4e30\u5bcc\u7684\u533a\u57df#0202");
                        h.a((String) null, 2021);
                        return "";
                    }
                }
            }
            String format = String.format(Locale.US, "#%s#", "network");
            if (z5) {
                StringBuilder sb = new StringBuilder();
                sb.append(f4.b());
                str2 = (!this.f11692g.isEmpty() || a4) ? "cgiwifi" : "cgiwifi";
                sb.append("network");
                sb.append("#");
                sb.append(str2);
                str = sb.toString();
            } else if (z4) {
                str = format + "wifi";
            } else {
                this.f11709x = 2;
                if (!this.f11688c.k()) {
                    aVar.f("#0203");
                    this.f11700o.append("\u5f53\u524d\u57fa\u7ad9\u4e3a\u4f2a\u57fa\u7ad9,\u5e76\u4e14\u5173\u95ed\u4e86WIFI\u5f00\u5173\uff0c\u8bf7\u5728\u8bbe\u7f6e\u4e2d\u6253\u5f00WIFI\u5f00\u5173#0203");
                } else {
                    aVar.f("#0204");
                    this.f11700o.append("\u5f53\u524d\u57fa\u7ad9\u4e3a\u4f2a\u57fa\u7ad9,\u5e76\u4e14\u6ca1\u6709\u641c\u7d22\u5230WIFI\uff0c\u8bf7\u79fb\u52a8\u5230WIFI\u6bd4\u8f83\u4e30\u5bcc\u7684\u533a\u57df#0204");
                }
                h.a((String) null, 2022);
            }
        } else if (h4 != 1) {
            if (h4 != 2) {
                this.f11709x = 11;
                h.a((String) null, 2111);
                aVar.f("#1101");
                this.f11700o.append("get cgi failure#1101");
            } else if (e4 != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(e4.f11798a);
                sb2.append("#");
                sb2.append(e4.f11799b);
                sb2.append("#");
                sb2.append(e4.f11805h);
                sb2.append("#");
                sb2.append(e4.f11806i);
                sb2.append("#");
                sb2.append(e4.f11807j);
                sb2.append("#");
                sb2.append("network");
                sb2.append("#");
                sb2.append((!this.f11692g.isEmpty() || a4) ? "cgiwifi" : "cgiwifi");
                str = sb2.toString();
            }
        } else if (e4 != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(e4.f11798a);
            sb3.append("#");
            sb3.append(e4.f11799b);
            sb3.append("#");
            sb3.append(e4.f11800c);
            sb3.append("#");
            sb3.append(e4.f11801d);
            sb3.append("#");
            sb3.append("network");
            sb3.append("#");
            sb3.append((!this.f11692g.isEmpty() || a4) ? "cgiwifi" : "cgiwifi");
            str = sb3.toString();
        }
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (!str.startsWith("#")) {
            str = "#" + str;
        }
        return j.e() + str;
    }

    public final void a() {
        e eVar = this.f11689d;
        if (eVar != null) {
            eVar.b();
        }
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        this.f11694i = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.f11694i = new AMapLocationClientOption();
        }
        k kVar = this.f11688c;
        if (kVar != null) {
            this.f11694i.isWifiActiveScan();
            kVar.a(this.f11694i.isWifiScan(), this.f11694i.isMockEnable(), AMapLocationClientOption.isOpenAlwaysScanWifi(), aMapLocationClientOption.getScanWifiInterval());
        }
        i();
        com.autonavi.aps.amapapi.storage.a aVar = this.f11690e;
        if (aVar != null) {
            aVar.a(this.f11694i);
        }
        com.autonavi.aps.amapapi.trans.e eVar = this.f11691f;
        if (eVar != null) {
            eVar.a(this.f11694i);
        }
        e eVar2 = this.f11689d;
        if (eVar2 != null) {
            eVar2.c(this.f11694i.isNoLocReqCgiEnable());
        }
        k();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:20|(2:22|(1:24)(1:25))|26|(2:27|28)|(8:33|34|(1:36)|38|39|(1:41)|43|(2:45|46)(2:47|(11:53|(1:100)(1:57)|58|(1:60)(2:86|(3:88|(1:90)|91)(4:92|(1:96)|97|(1:99)))|61|62|(2:65|(1:67)(2:68|(1:70)(2:71|(1:73)(1:74))))|75|(2:77|(1:82)(1:81))|83|84)(2:51|52)))|103|34|(0)|38|39|(0)|43|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a3, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a4, code lost:
        com.autonavi.aps.amapapi.utils.b.a(r0, "Aps", "getLocation getCgiListParam");
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0085 A[Catch: all -> 0x0091, TRY_LEAVE, TryCatch #0 {all -> 0x0091, blocks: (B:27:0x006d, B:29:0x0075, B:34:0x0081, B:36:0x0085), top: B:104:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009b A[Catch: all -> 0x00a3, TRY_LEAVE, TryCatch #1 {all -> 0x00a3, blocks: (B:40:0x0097, B:42:0x009b), top: B:106:0x0097 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.autonavi.aps.amapapi.model.a a(com.autonavi.aps.amapapi.a r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 488
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.b.a(com.autonavi.aps.amapapi.a):com.autonavi.aps.amapapi.model.a");
    }

    private void b(Context context) {
        try {
            if (context.checkCallingOrSelfPermission(q4.u("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFQ1VSRV9TRVRUSU5HUw==")) == 0) {
                this.f11698m = true;
            }
        } catch (Throwable unused) {
        }
    }

    public final void b(com.autonavi.aps.amapapi.a aVar) {
        try {
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "initFirstLocateParam");
        }
        if (this.f11707v) {
            return;
        }
        r();
        if (this.f11705t) {
            m();
        }
        k kVar = this.f11688c;
        if (kVar != null) {
            kVar.b(this.f11705t);
            this.f11692g = this.f11688c.e();
        }
        e eVar = this.f11689d;
        if (eVar != null) {
            eVar.a(true, q());
        }
        String c4 = c(aVar);
        this.f11685L = c4;
        if (!TextUtils.isEmpty(c4)) {
            this.f11706u = a(this.f11706u);
        }
        this.f11707v = true;
    }

    public final com.autonavi.aps.amapapi.model.a a(com.autonavi.aps.amapapi.model.a aVar) {
        this.B.a(this.f11704s);
        return this.B.a(aVar);
    }

    public final void a(boolean z3) {
        e eVar = this.f11689d;
        if (eVar != null) {
            eVar.b(z3);
        }
    }

    private boolean a(long j4) {
        if (!this.M) {
            this.M = true;
            return false;
        }
        if (j.b() - j4 < 800) {
            if ((j.a(this.f11695j) ? j.a() - this.f11695j.getTime() : 0L) <= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                return true;
            }
        }
        return false;
    }

    private StringBuilder a(StringBuilder sb) {
        if (sb == null) {
            sb = new StringBuilder(700);
        } else {
            sb.delete(0, sb.length());
        }
        e eVar = this.f11689d;
        if (eVar != null && this.f11688c != null) {
            sb.append(eVar.m());
            sb.append(this.f11688c.o());
        }
        return sb;
    }

    public final com.autonavi.aps.amapapi.model.a b(boolean z3) {
        k kVar = this.f11688c;
        if (kVar != null && kVar.n()) {
            return a(15, "networkLocation has been mocked!#1502");
        }
        if (TextUtils.isEmpty(this.f11685L)) {
            return a(this.f11709x, this.f11700o.toString());
        }
        com.autonavi.aps.amapapi.model.a a4 = this.f11690e.a(this.f11686a, this.f11685L, this.f11706u, true, z3);
        if (j.a(a4)) {
            d(a4);
        }
        return a4;
    }

    private com.autonavi.aps.amapapi.model.a a(com.autonavi.aps.amapapi.model.a aVar, y6 y6Var, com.autonavi.aps.amapapi.a aVar2) {
        if (y6Var != null) {
            try {
                byte[] bArr = y6Var.f9524a;
                if (bArr != null && bArr.length != 0) {
                    com.autonavi.aps.amapapi.trans.e eVar = new com.autonavi.aps.amapapi.trans.e();
                    String str = new String(y6Var.f9524a, "UTF-8");
                    if (str.contains("\"status\":\"0\"")) {
                        com.autonavi.aps.amapapi.model.a a4 = eVar.a(str, this.f11686a, y6Var, aVar2);
                        a4.h(this.f11706u.toString());
                        return a4;
                    } else if (str.contains("</body></html>")) {
                        aVar.setErrorCode(5);
                        k kVar = this.f11688c;
                        if (kVar != null && kVar.a(this.f11687b)) {
                            aVar2.f("#0501");
                            this.f11700o.append("\u60a8\u8fde\u63a5\u7684\u662f\u4e00\u4e2a\u9700\u8981\u767b\u5f55\u7684\u7f51\u7edc\uff0c\u8bf7\u786e\u8ba4\u5df2\u7ecf\u767b\u5165\u7f51\u7edc#0501");
                            h.a((String) null, 2051);
                        } else {
                            aVar2.f("#0502");
                            this.f11700o.append("\u8bf7\u6c42\u53ef\u80fd\u88ab\u52ab\u6301\u4e86#0502");
                            h.a((String) null, 2052);
                        }
                        aVar.setLocationDetail(this.f11700o.toString());
                        return aVar;
                    } else {
                        return null;
                    }
                }
            } catch (Throwable th) {
                aVar.setErrorCode(4);
                com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "checkResponseEntity");
                aVar2.f("#0403");
                StringBuilder sb = this.f11700o;
                sb.append("check response exception ex is" + th.getMessage() + "#0403");
                aVar.setLocationDetail(this.f11700o.toString());
                return aVar;
            }
        }
        aVar.setErrorCode(4);
        this.f11700o.append("\u7f51\u7edc\u5f02\u5e38,\u8bf7\u6c42\u5f02\u5e38#0403");
        aVar2.f("#0403");
        aVar.h(this.f11706u.toString());
        aVar.setLocationDetail(this.f11700o.toString());
        if (y6Var != null) {
            h.a(y6Var.f9527d, 2041);
        }
        return aVar;
    }

    public final void b(com.autonavi.aps.amapapi.model.a aVar) {
        if (j.a(aVar)) {
            this.f11690e.a(this.f11685L, this.f11706u, aVar, this.f11686a, true);
        }
    }

    private static void c(com.autonavi.aps.amapapi.model.a aVar) {
        if (aVar.getErrorCode() == 0 && aVar.getLocationType() == 0) {
            if (!"-5".equals(aVar.d()) && !"1".equals(aVar.d()) && !"2".equals(aVar.d()) && !"14".equals(aVar.d()) && !"24".equals(aVar.d()) && !"-1".equals(aVar.d())) {
                aVar.setLocationType(6);
            } else {
                aVar.setLocationType(5);
            }
        }
    }

    public final com.autonavi.aps.amapapi.model.a a(boolean z3, com.autonavi.aps.amapapi.a aVar) {
        if (z3) {
            aVar.e("statics");
        } else {
            aVar.e("first");
        }
        if (this.f11686a == null) {
            aVar.f("#0101");
            this.f11700o.append("context is null#0101");
            h.a((String) null, 2011);
            return a(1, this.f11700o.toString());
        }
        k kVar = this.f11688c;
        if (kVar != null && kVar.n()) {
            aVar.f("#1502");
            return a(15, "networkLocation has been mocked!#1502");
        }
        b();
        if (TextUtils.isEmpty(this.f11685L)) {
            return a(this.f11709x, this.f11700o.toString());
        }
        com.autonavi.aps.amapapi.model.a b4 = b(z3, aVar);
        if (j.a(b4) && !Q) {
            this.f11690e.a(this.f11706u.toString());
            e eVar = this.f11689d;
            if (eVar != null) {
                this.f11690e.a(eVar.e());
            }
            d(b4);
        }
        Q = true;
        return b4;
    }

    public final com.autonavi.aps.amapapi.model.a a(double d4, double d5) {
        try {
            String a4 = this.f11699n.a(this.f11686a, d4, d5);
            if (a4.contains("\"status\":\"1\"")) {
                com.autonavi.aps.amapapi.model.a a5 = this.f11691f.a(a4);
                a5.setLatitude(d4);
                a5.setLongitude(d5);
                return a5;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void a(AMapLocation aMapLocation) {
        if (aMapLocation.getErrorCode() != 0) {
            return;
        }
        com.autonavi.aps.amapapi.restruct.f fVar = new com.autonavi.aps.amapapi.restruct.f();
        fVar.f11843a = aMapLocation.getLocationType();
        fVar.f11846d = aMapLocation.getTime();
        fVar.f11847e = (int) aMapLocation.getAccuracy();
        fVar.f11844b = aMapLocation.getLatitude();
        fVar.f11845c = aMapLocation.getLongitude();
        if (aMapLocation.getLocationType() == 1) {
            this.O.a(fVar);
        }
    }

    public final void a(com.autonavi.aps.amapapi.model.a aVar, int i4) {
        if (aVar != null && aVar.getErrorCode() == 0) {
            com.autonavi.aps.amapapi.restruct.f fVar = new com.autonavi.aps.amapapi.restruct.f();
            fVar.f11846d = aVar.getTime();
            fVar.f11847e = (int) aVar.getAccuracy();
            fVar.f11844b = aVar.getLatitude();
            fVar.f11845c = aVar.getLongitude();
            fVar.f11843a = i4;
            fVar.f11849g = Integer.parseInt(aVar.d());
            fVar.f11850h = aVar.l();
            this.O.b(fVar);
        }
    }

    private static com.autonavi.aps.amapapi.model.a a(int i4, String str) {
        com.autonavi.aps.amapapi.model.a aVar = new com.autonavi.aps.amapapi.model.a("");
        aVar.setErrorCode(i4);
        aVar.setLocationDetail(str);
        if (i4 == 15) {
            h.a((String) null, 2151);
        }
        return aVar;
    }
}
