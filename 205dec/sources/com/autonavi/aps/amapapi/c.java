package com.autonavi.aps.amapapi;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import com.amap.api.col.p0003l.a8;
import com.amap.api.col.p0003l.b7;
import com.amap.api.col.p0003l.c7;
import com.amap.api.col.p0003l.e4;
import com.amap.api.col.p0003l.f9;
import com.amap.api.col.p0003l.g6;
import com.amap.api.col.p0003l.i4;
import com.amap.api.col.p0003l.i7;
import com.amap.api.col.p0003l.i8;
import com.amap.api.col.p0003l.j4;
import com.amap.api.col.p0003l.j9;
import com.amap.api.col.p0003l.k8;
import com.amap.api.col.p0003l.k9;
import com.amap.api.col.p0003l.ko;
import com.amap.api.col.p0003l.n6;
import com.amap.api.col.p0003l.o9;
import com.amap.api.col.p0003l.q4;
import com.amap.api.col.p0003l.q6;
import com.amap.api.col.p0003l.q9;
import com.amap.api.col.p0003l.r5;
import com.amap.api.col.p0003l.r9;
import com.amap.api.col.p0003l.t7;
import com.amap.api.col.p0003l.u5;
import com.amap.api.col.p0003l.v7;
import com.amap.api.col.p0003l.y6;
import com.amap.api.col.p0003l.z7;
import com.autonavi.aps.amapapi.restruct.e;
import com.autonavi.aps.amapapi.restruct.h;
import com.autonavi.aps.amapapi.restruct.k;
import com.autonavi.aps.amapapi.utils.j;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.KeyGenerator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: CollectionManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class c implements r9 {

    /* renamed from: k  reason: collision with root package name */
    private static long f11714k;

    /* renamed from: a  reason: collision with root package name */
    Context f11715a;

    /* renamed from: d  reason: collision with root package name */
    f9 f11718d;

    /* renamed from: e  reason: collision with root package name */
    b7 f11719e;

    /* renamed from: g  reason: collision with root package name */
    private Handler f11721g;

    /* renamed from: h  reason: collision with root package name */
    private LocationManager f11722h;

    /* renamed from: i  reason: collision with root package name */
    private a f11723i;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<k8> f11720f = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    k f11716b = null;

    /* renamed from: c  reason: collision with root package name */
    e f11717c = null;

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f11724j = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: CollectionManager.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a implements LocationListener {

        /* renamed from: a  reason: collision with root package name */
        private c f11726a;

        a(c cVar) {
            this.f11726a = cVar;
        }

        final void a(c cVar) {
            this.f11726a = cVar;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            try {
                c cVar = this.f11726a;
                if (cVar != null) {
                    cVar.a(location);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i4, Bundle bundle) {
        }

        final void a() {
            this.f11726a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.f11715a = null;
        this.f11715a = context;
        b7 b7Var = new b7();
        this.f11719e = b7Var;
        i7.f(this.f11715a, b7Var, r5.f8902k, 100, 1024000, "0");
        b7 b7Var2 = this.f11719e;
        int i4 = com.autonavi.aps.amapapi.utils.a.f11984g;
        boolean z3 = com.autonavi.aps.amapapi.utils.a.f11982e;
        int i5 = com.autonavi.aps.amapapi.utils.a.f11983f;
        b7Var2.f7269f = new v7(context, i4, "kKey", new t7(context, z3, i5, i5 * 10, "carrierLocKey"));
        this.f11719e.f7268e = new g6();
    }

    private static byte[] b(int i4) {
        return new byte[]{(byte) ((i4 >> 24) & 255), (byte) ((i4 >> 16) & 255), (byte) ((i4 >> 8) & 255), (byte) (i4 & 255)};
    }

    private static byte[] c(int i4) {
        return new byte[]{(byte) ((i4 & 65280) >> 8), (byte) (i4 & 255)};
    }

    static /* synthetic */ byte[] f() {
        return a(128);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            com.autonavi.aps.amapapi.utils.d.a();
            if (j.m(this.f11715a)) {
                com.autonavi.aps.amapapi.utils.d.a();
                return;
            }
            ArrayList<k8> arrayList = this.f11720f;
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList arrayList2 = new ArrayList();
                synchronized (this.f11720f) {
                    arrayList2.addAll(this.f11720f);
                    this.f11720f.clear();
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] a4 = a(256);
                if (a4 == null) {
                    return;
                }
                byteArrayOutputStream.write(c(a4.length));
                byteArrayOutputStream.write(a4);
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    k8 k8Var = (k8) it.next();
                    byte[] b4 = k8Var.b();
                    if (b4.length >= 10 && b4.length <= 65535) {
                        byte[] h4 = j4.h(a4, b4, q4.v());
                        byteArrayOutputStream.write(c(h4.length));
                        byteArrayOutputStream.write(h4);
                        byteArrayOutputStream.write(b(k8Var.a()));
                    }
                }
                c7.c(Long.toString(System.currentTimeMillis()), byteArrayOutputStream.toByteArray(), this.f11719e);
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "clm", "wtD");
        }
    }

    public final void d() {
        try {
            if (j.m(this.f11715a)) {
                com.autonavi.aps.amapapi.utils.d.a();
            } else if (System.currentTimeMillis() - f11714k < 60000) {
            } else {
                z7.h().b(new b(2));
            }
        } catch (Throwable unused) {
        }
    }

    public final void e() {
        try {
            z7.h().b(new b(3));
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: CollectionManager.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class b extends a8 {

        /* renamed from: b  reason: collision with root package name */
        private int f11728b;

        /* renamed from: c  reason: collision with root package name */
        private Location f11729c;

        b(int i4) {
            this.f11728b = i4;
        }

        private void a() {
            try {
                com.autonavi.aps.amapapi.utils.d.a();
                if (this.f11729c != null && c.this.f11724j) {
                    if (j.m(c.this.f11715a)) {
                        com.autonavi.aps.amapapi.utils.d.a();
                        return;
                    }
                    Bundle extras = this.f11729c.getExtras();
                    int i4 = extras != null ? extras.getInt("satellites") : 0;
                    if (j.a(this.f11729c, i4)) {
                        return;
                    }
                    k kVar = c.this.f11716b;
                    if (kVar != null && !kVar.f11885s) {
                        kVar.f();
                    }
                    ArrayList<k9> a4 = c.this.f11716b.a();
                    List<ko> a5 = c.this.f11717c.a();
                    i8.a aVar = new i8.a();
                    j9 j9Var = new j9();
                    j9Var.f8158i = this.f11729c.getAccuracy();
                    j9Var.f8155f = this.f11729c.getAltitude();
                    j9Var.f8153d = this.f11729c.getLatitude();
                    j9Var.f8157h = this.f11729c.getBearing();
                    j9Var.f8154e = this.f11729c.getLongitude();
                    j9Var.f8159j = this.f11729c.isFromMockProvider();
                    j9Var.f8150a = this.f11729c.getProvider();
                    j9Var.f8156g = this.f11729c.getSpeed();
                    j9Var.f8228l = (byte) i4;
                    j9Var.f8151b = System.currentTimeMillis();
                    j9Var.f8152c = this.f11729c.getTime();
                    j9Var.f8227k = this.f11729c.getTime();
                    aVar.f8140a = j9Var;
                    aVar.f8141b = a4;
                    WifiInfo c4 = c.this.f11716b.c();
                    if (c4 != null) {
                        aVar.f8142c = k9.a(h.a(c4));
                    }
                    aVar.f8143d = k.f11871z;
                    aVar.f8145f = this.f11729c.getTime();
                    aVar.f8146g = (byte) i4.K(c.this.f11715a);
                    aVar.f8147h = i4.V(c.this.f11715a);
                    aVar.f8144e = c.this.f11716b.k();
                    aVar.f8149j = j.a(c.this.f11715a);
                    aVar.f8148i = a5;
                    k8 a6 = f9.a(aVar);
                    if (a6 == null) {
                        return;
                    }
                    synchronized (c.this.f11720f) {
                        c.this.f11720f.add(a6);
                        if (c.this.f11720f.size() >= 5) {
                            c.this.e();
                        }
                    }
                    c.this.d();
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "cl", "coll");
            }
        }

        private void b() {
            com.autonavi.aps.amapapi.utils.d.a();
            if (!j.m(c.this.f11715a)) {
                n6 n6Var = null;
                try {
                    long unused = c.f11714k = System.currentTimeMillis();
                    if (c.this.f11719e.f7269f.e()) {
                        n6Var = n6.b(new File(c.this.f11719e.f7264a), c.this.f11719e.f7265b);
                        ArrayList arrayList = new ArrayList();
                        byte[] f4 = c.f();
                        if (f4 != null) {
                            List b4 = c.b(n6Var, c.this.f11719e, arrayList, f4);
                            if (b4 != null && b4.size() != 0) {
                                c.this.f11719e.f7269f.c(true);
                                if (f9.f(q4.t(f9.h(com.autonavi.aps.amapapi.security.a.a(f4), j4.h(f4, f9.g(), q4.v()), b4)))) {
                                    c.b(n6Var, arrayList);
                                }
                            }
                            try {
                                n6Var.close();
                                return;
                            } catch (Throwable unused2) {
                                return;
                            }
                        }
                        try {
                            n6Var.close();
                            return;
                        } catch (Throwable unused3) {
                            return;
                        }
                    }
                    if (n6Var != null) {
                        try {
                            n6Var.close();
                            return;
                        } catch (Throwable unused4) {
                            return;
                        }
                    }
                    return;
                } catch (Throwable th) {
                    try {
                        u5.p(th, "leg", "uts");
                        if (n6Var != null) {
                            try {
                                n6Var.close();
                                return;
                            } catch (Throwable unused5) {
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th2) {
                        if (n6Var != null) {
                            try {
                                n6Var.close();
                            } catch (Throwable unused6) {
                            }
                        }
                        throw th2;
                    }
                }
            }
            com.autonavi.aps.amapapi.utils.d.a();
        }

        @Override // com.amap.api.col.p0003l.a8
        public final void runTask() {
            int i4 = this.f11728b;
            if (i4 == 1) {
                a();
            } else if (i4 == 2) {
                b();
            } else if (i4 == 3) {
                c.this.g();
            }
        }

        b(c cVar, Location location) {
            this(1);
            this.f11729c = location;
        }
    }

    public final void b() {
        try {
            com.autonavi.aps.amapapi.utils.d.a();
            Handler handler = this.f11721g;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.autonavi.aps.amapapi.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        k kVar;
                        try {
                            c cVar = c.this;
                            if (cVar.f11718d == null || (kVar = cVar.f11716b) == null) {
                                return;
                            }
                            f9.k(kVar.a());
                        } catch (Throwable th) {
                            com.autonavi.aps.amapapi.utils.b.a(th, "cl", "upwr");
                        }
                    }
                });
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "cl", "upw");
        }
    }

    public final void c() {
        e eVar;
        try {
            com.autonavi.aps.amapapi.utils.d.a();
            if (this.f11718d == null || (eVar = this.f11717c) == null) {
                return;
            }
            f9.e(eVar.a());
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "cl", "upc");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        LocationManager locationManager;
        if (j.m(this.f11715a)) {
            com.autonavi.aps.amapapi.utils.d.a();
            return;
        }
        try {
            a aVar = this.f11723i;
            if (aVar != null && (locationManager = this.f11722h) != null) {
                locationManager.removeUpdates(aVar);
            }
            a aVar2 = this.f11723i;
            if (aVar2 != null) {
                aVar2.a();
            }
            if (this.f11724j) {
                g();
                this.f11716b.a((c) null);
                this.f11717c.a((c) null);
                this.f11717c = null;
                this.f11716b = null;
                this.f11721g = null;
                this.f11724j = false;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "clm", "stc");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(n6 n6Var, List<String> list) {
        if (n6Var != null) {
            try {
                for (String str : list) {
                    n6Var.q(str);
                }
                n6Var.close();
            } catch (Throwable th) {
                u5.p(th, "aps", "dlo");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
        if (r9 != null) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<com.amap.api.col.p0003l.k8> b(com.amap.api.col.p0003l.n6 r17, com.amap.api.col.p0003l.b7 r18, java.util.List<java.lang.String> r19, byte[] r20) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.c.b(com.amap.api.col.3l.n6, com.amap.api.col.3l.b7, java.util.List, byte[]):java.util.List");
    }

    public final void a(e eVar, k kVar, Handler handler) {
        LocationManager locationManager;
        com.autonavi.aps.amapapi.utils.d.a();
        if (this.f11724j || eVar == null || kVar == null || handler == null) {
            return;
        }
        if (j.m(this.f11715a)) {
            com.autonavi.aps.amapapi.utils.d.a();
            return;
        }
        this.f11724j = true;
        this.f11717c = eVar;
        this.f11716b = kVar;
        kVar.a(this);
        this.f11717c.a(this);
        this.f11721g = handler;
        try {
            if (this.f11722h == null) {
                this.f11722h = (LocationManager) this.f11715a.getSystemService("location");
            }
            if (this.f11723i == null) {
                this.f11723i = new a(this);
            }
            this.f11723i.a(this);
            a aVar = this.f11723i;
            if (aVar != null && (locationManager = this.f11722h) != null) {
                locationManager.requestLocationUpdates("passive", 1000L, -1.0f, aVar);
            }
            if (this.f11718d == null) {
                f9 f9Var = new f9("6.4.3", e4.j(this.f11715a), "S128DF1572465B890OE3F7A13167KLEI", e4.g(this.f11715a), this);
                this.f11718d = f9Var;
                f9Var.d(i4.P()).i(i4.F(this.f11715a)).l(i4.o(this.f11715a)).m(i4.D(this.f11715a)).n(i4.U()).o(i4.E()).p(Build.MODEL).q(Build.MANUFACTURER).r(Build.BRAND).b(Build.VERSION.SDK_INT).s(Build.VERSION.RELEASE).c(k9.a(i4.I())).t(i4.I());
                f9.j();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "col", "init");
        }
    }

    public final void a(Location location) {
        try {
            Handler handler = this.f11721g;
            if (handler != null) {
                handler.post(new b(this, location));
            }
        } catch (Throwable th) {
            u5.p(th, "cl", "olcc");
        }
    }

    @Override // com.amap.api.col.p0003l.r9
    public final q9 a(o9 o9Var) {
        try {
            com.autonavi.aps.amapapi.trans.b bVar = new com.autonavi.aps.amapapi.trans.b();
            bVar.a(o9Var.f8470b);
            bVar.a(o9Var.f8469a);
            bVar.a(o9Var.f8472d);
            q6.b();
            y6 d4 = q6.d(bVar);
            q9 q9Var = new q9();
            q9Var.f8842c = d4.f9524a;
            q9Var.f8841b = d4.f9525b;
            q9Var.f8840a = 200;
            return q9Var;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static byte[] a(int i4) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            if (keyGenerator == null) {
                return null;
            }
            keyGenerator.init(i4);
            return keyGenerator.generateKey().getEncoded();
        } catch (Throwable unused) {
            return null;
        }
    }

    private static int a(byte[] bArr) {
        return ((bArr[0] & 255) << 24) | (bArr[3] & 255) | ((bArr[2] & 255) << 8) | ((bArr[1] & 255) << 16);
    }
}
