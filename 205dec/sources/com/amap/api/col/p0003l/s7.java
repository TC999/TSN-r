package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.autonavi.aps.amapapi.security.a;
import com.autonavi.aps.amapapi.storage.b;
import com.autonavi.aps.amapapi.storage.c;
import com.autonavi.aps.amapapi.utils.j;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.stub.StubApp;
import java.util.List;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: LastLocationManager.java */
/* renamed from: com.amap.api.col.3l.s7  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class s7 {

    /* renamed from: g  reason: collision with root package name */
    static b f8957g;

    /* renamed from: h  reason: collision with root package name */
    static d6 f8958h;

    /* renamed from: i  reason: collision with root package name */
    static long f8959i;

    /* renamed from: a  reason: collision with root package name */
    private Context f8960a;

    /* renamed from: b  reason: collision with root package name */
    String f8961b = null;

    /* renamed from: c  reason: collision with root package name */
    b f8962c = null;

    /* renamed from: d  reason: collision with root package name */
    b f8963d = null;

    /* renamed from: e  reason: collision with root package name */
    long f8964e = 0;

    /* renamed from: f  reason: collision with root package name */
    boolean f8965f = false;

    public s7(Context context) {
        this.f8960a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    private void g() {
        if (f8957g == null || j.b() - f8959i > 180000) {
            b h4 = h();
            f8959i = j.b();
            if (h4 == null || !j.a(h4.a())) {
                return;
            }
            f8957g = h4;
        }
    }

    private b h() {
        Throwable th;
        b bVar;
        d6 d6Var;
        byte[] b4;
        byte[] b5;
        String str = null;
        if (this.f8960a == null) {
            return null;
        }
        b();
        try {
            d6Var = f8958h;
        } catch (Throwable th2) {
            th = th2;
            bVar = null;
        }
        if (d6Var == null) {
            return null;
        }
        List p3 = d6Var.p("_id=1", b.class);
        if (p3 == null || p3.size() <= 0) {
            bVar = null;
        } else {
            bVar = (b) p3.get(0);
            try {
                byte[] g4 = j4.g(bVar.c());
                String str2 = (g4 == null || g4.length <= 0 || (b5 = a.b(g4, this.f8961b)) == null || b5.length <= 0) ? null : new String(b5, "UTF-8");
                byte[] g5 = j4.g(bVar.b());
                if (g5 != null && g5.length > 0 && (b4 = a.b(g5, this.f8961b)) != null && b4.length > 0) {
                    str = new String(b4, "UTF-8");
                }
                bVar.a(str);
                str = str2;
            } catch (Throwable th3) {
                th = th3;
                com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", "readLastFix");
                return bVar;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            AMapLocation aMapLocation = new AMapLocation("");
            com.autonavi.aps.amapapi.utils.b.a(aMapLocation, new JSONObject(str));
            if (j.b(aMapLocation)) {
                bVar.a(aMapLocation);
            }
        }
        return bVar;
    }

    public final AMapLocation a(AMapLocation aMapLocation, String str, long j4) {
        if (aMapLocation == null || aMapLocation.getErrorCode() == 0 || aMapLocation.getLocationType() == 1 || aMapLocation.getErrorCode() == 7) {
            return aMapLocation;
        }
        try {
            g();
            b bVar = f8957g;
            if (bVar != null && bVar.a() != null) {
                boolean z3 = false;
                if (TextUtils.isEmpty(str)) {
                    long b4 = j.b() - f8957g.d();
                    if (b4 >= 0 && b4 <= j4) {
                        z3 = true;
                    }
                    aMapLocation.setTrustedLevel(3);
                } else {
                    z3 = j.a(f8957g.b(), str);
                    aMapLocation.setTrustedLevel(2);
                }
                if (z3) {
                    AMapLocation a4 = f8957g.a();
                    try {
                        a4.setLocationType(9);
                        a4.setFixLastLocation(true);
                        a4.setLocationDetail(aMapLocation.getLocationDetail());
                        return a4;
                    } catch (Throwable th) {
                        th = th;
                        aMapLocation = a4;
                        com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", "fixLastLocation");
                        return aMapLocation;
                    }
                }
                return aMapLocation;
            }
            return aMapLocation;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void b() {
        if (this.f8965f) {
            return;
        }
        try {
            if (this.f8961b == null) {
                this.f8961b = a.a("MD5", i4.P());
            }
            if (f8958h == null) {
                f8958h = new d6(this.f8960a, d6.c(c.class));
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", "<init>:DBOperation");
        }
        this.f8965f = true;
    }

    public final boolean c(AMapLocation aMapLocation, String str) {
        if (this.f8960a != null && aMapLocation != null && j.a(aMapLocation) && aMapLocation.getLocationType() != 2 && !aMapLocation.isMock() && !aMapLocation.isFixLastLocation()) {
            b bVar = new b();
            bVar.a(aMapLocation);
            if (aMapLocation.getLocationType() == 1) {
                bVar.a((String) null);
            } else {
                bVar.a(str);
            }
            try {
                f8957g = bVar;
                f8959i = j.b();
                this.f8962c = bVar;
                b bVar2 = this.f8963d;
                if (bVar2 != null && j.a(bVar2.a(), bVar.a()) <= 500.0f) {
                    return false;
                }
                if (j.b() - this.f8964e > PolicyConfig.mServerBusyRetryBaseInternal) {
                    return true;
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", "setLastFix");
            }
        }
        return false;
    }

    public final AMapLocation d() {
        g();
        b bVar = f8957g;
        if (bVar != null && j.a(bVar.a())) {
            return f8957g.a();
        }
        return null;
    }

    public final void e() {
        try {
            f();
            this.f8964e = 0L;
            this.f8965f = false;
            this.f8962c = null;
            this.f8963d = null;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", "destroy");
        }
    }

    public final void f() {
        b bVar;
        String str;
        try {
            b();
            b bVar2 = this.f8962c;
            if (bVar2 != null && j.a(bVar2.a()) && f8958h != null && (bVar = this.f8962c) != this.f8963d && bVar.d() == 0) {
                String str2 = this.f8962c.a().toStr();
                String b4 = this.f8962c.b();
                this.f8963d = this.f8962c;
                if (TextUtils.isEmpty(str2)) {
                    str = null;
                } else {
                    String f4 = j4.f(a.a(str2.getBytes("UTF-8"), this.f8961b));
                    str = TextUtils.isEmpty(b4) ? null : j4.f(a.a(b4.getBytes("UTF-8"), this.f8961b));
                    r4 = f4;
                }
                if (TextUtils.isEmpty(r4)) {
                    return;
                }
                b bVar3 = new b();
                bVar3.b(r4);
                bVar3.a(j.b());
                bVar3.a(str);
                f8958h.h(bVar3, "_id=1");
                this.f8964e = j.b();
                b bVar4 = f8957g;
                if (bVar4 != null) {
                    bVar4.a(j.b());
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", "saveLastFix");
        }
    }
}
