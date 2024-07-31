package com.amap.api.col.p0463l;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.autonavi.aps.amapapi.security.C2422a;
import com.autonavi.aps.amapapi.storage.LastLocationInfo;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.autonavi.aps.amapapi.utils.C2428b;
import com.autonavi.aps.amapapi.utils.C2432j;
import com.stub.StubApp;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3l.r7 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class LastLocationManager {

    /* renamed from: g */
    static LastLocationInfo f5190g;

    /* renamed from: h */
    static DBOperation f5191h;

    /* renamed from: i */
    static long f5192i;

    /* renamed from: a */
    private Context f5193a;

    /* renamed from: b */
    String f5194b = null;

    /* renamed from: c */
    LastLocationInfo f5195c = null;

    /* renamed from: d */
    LastLocationInfo f5196d = null;

    /* renamed from: e */
    long f5197e = 0;

    /* renamed from: f */
    boolean f5198f = false;

    public LastLocationManager(Context context) {
        this.f5193a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    /* renamed from: g */
    private void m54028g() {
        if (f5190g == null || C2432j.m51186b() - f5192i > 180000) {
            LastLocationInfo m54027h = m54027h();
            f5192i = C2432j.m51186b();
            if (m54027h == null || !C2432j.m51197a(m54027h.m51421a())) {
                return;
            }
            f5190g = m54027h;
        }
    }

    /* renamed from: h */
    private LastLocationInfo m54027h() {
        Throwable th;
        LastLocationInfo lastLocationInfo;
        DBOperation dBOperation;
        byte[] m51450b;
        byte[] m51450b2;
        String str = null;
        if (this.f5193a == null) {
            return null;
        }
        m54033b();
        try {
            dBOperation = f5191h;
        } catch (Throwable th2) {
            th = th2;
            lastLocationInfo = null;
        }
        if (dBOperation == null) {
            return null;
        }
        List m55451p = dBOperation.m55451p("_id=1", LastLocationInfo.class);
        if (m55451p == null || m55451p.size() <= 0) {
            lastLocationInfo = null;
        } else {
            lastLocationInfo = (LastLocationInfo) m55451p.get(0);
            try {
                byte[] m54718g = Encrypt.m54718g(lastLocationInfo.m51415c());
                String str2 = (m54718g == null || m54718g.length <= 0 || (m51450b2 = C2422a.m51450b(m54718g, this.f5194b)) == null || m51450b2.length <= 0) ? null : new String(m51450b2, "UTF-8");
                byte[] m54718g2 = Encrypt.m54718g(lastLocationInfo.m51417b());
                if (m54718g2 != null && m54718g2.length > 0 && (m51450b = C2422a.m51450b(m54718g2, this.f5194b)) != null && m51450b.length > 0) {
                    str = new String(m51450b, "UTF-8");
                }
                lastLocationInfo.m51418a(str);
                str = str2;
            } catch (Throwable th3) {
                th = th3;
                C2428b.m51299a(th, "LastLocationManager", "readLastFix");
                return lastLocationInfo;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            AMapLocation aMapLocation = new AMapLocation("");
            C2428b.m51303a(aMapLocation, new JSONObject(str));
            if (C2432j.m51181b(aMapLocation)) {
                lastLocationInfo.m51419a(aMapLocation);
            }
        }
        return lastLocationInfo;
    }

    /* renamed from: a */
    public final AMapLocation m54034a(AMapLocation aMapLocation, String str, long j) {
        if (aMapLocation == null || aMapLocation.getErrorCode() == 0 || aMapLocation.getLocationType() == 1 || aMapLocation.getErrorCode() == 7) {
            return aMapLocation;
        }
        try {
            m54028g();
            LastLocationInfo lastLocationInfo = f5190g;
            if (lastLocationInfo != null && lastLocationInfo.m51421a() != null) {
                boolean z = false;
                if (TextUtils.isEmpty(str)) {
                    long m51186b = C2432j.m51186b() - f5190g.m51414d();
                    if (m51186b >= 0 && m51186b <= j) {
                        z = true;
                    }
                    aMapLocation.setTrustedLevel(3);
                } else {
                    z = C2432j.m51190a(f5190g.m51417b(), str);
                    aMapLocation.setTrustedLevel(2);
                }
                if (z) {
                    AMapLocation m51421a = f5190g.m51421a();
                    try {
                        m51421a.setLocationType(9);
                        m51421a.setFixLastLocation(true);
                        m51421a.setLocationDetail(aMapLocation.getLocationDetail());
                        return m51421a;
                    } catch (Throwable th) {
                        th = th;
                        aMapLocation = m51421a;
                        C2428b.m51299a(th, "LastLocationManager", "fixLastLocation");
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

    /* renamed from: b */
    public final void m54033b() {
        if (this.f5198f) {
            return;
        }
        try {
            if (this.f5194b == null) {
                this.f5194b = C2422a.m51455a("MD5", DeviceInfo.m54806P());
            }
            if (f5191h == null) {
                f5191h = new DBOperation(this.f5193a, DBOperation.m55464c(SdCardDbCreator.class));
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "LastLocationManager", "<init>:DBOperation");
        }
        this.f5198f = true;
    }

    /* renamed from: c */
    public final boolean m54032c(AMapLocation aMapLocation, String str) {
        if (this.f5193a != null && aMapLocation != null && C2432j.m51197a(aMapLocation) && aMapLocation.getLocationType() != 2 && !aMapLocation.isMock() && !aMapLocation.isFixLastLocation()) {
            LastLocationInfo lastLocationInfo = new LastLocationInfo();
            lastLocationInfo.m51419a(aMapLocation);
            if (aMapLocation.getLocationType() == 1) {
                lastLocationInfo.m51418a((String) null);
            } else {
                lastLocationInfo.m51418a(str);
            }
            try {
                f5190g = lastLocationInfo;
                f5192i = C2432j.m51186b();
                this.f5195c = lastLocationInfo;
                LastLocationInfo lastLocationInfo2 = this.f5196d;
                if (lastLocationInfo2 != null && C2432j.m51196a(lastLocationInfo2.m51421a(), lastLocationInfo.m51421a()) <= 500.0f) {
                    return false;
                }
                if (C2432j.m51186b() - this.f5197e > 30000) {
                    return true;
                }
            } catch (Throwable th) {
                C2428b.m51299a(th, "LastLocationManager", "setLastFix");
            }
        }
        return false;
    }

    /* renamed from: d */
    public final AMapLocation m54031d() {
        m54028g();
        LastLocationInfo lastLocationInfo = f5190g;
        if (lastLocationInfo != null && C2432j.m51197a(lastLocationInfo.m51421a())) {
            return f5190g.m51421a();
        }
        return null;
    }

    /* renamed from: e */
    public final void m54030e() {
        try {
            m54029f();
            this.f5197e = 0L;
            this.f5198f = false;
            this.f5195c = null;
            this.f5196d = null;
        } catch (Throwable th) {
            C2428b.m51299a(th, "LastLocationManager", "destroy");
        }
    }

    /* renamed from: f */
    public final void m54029f() {
        LastLocationInfo lastLocationInfo;
        String str;
        try {
            m54033b();
            LastLocationInfo lastLocationInfo2 = this.f5195c;
            if (lastLocationInfo2 != null && C2432j.m51197a(lastLocationInfo2.m51421a()) && f5191h != null && (lastLocationInfo = this.f5195c) != this.f5196d && lastLocationInfo.m51414d() == 0) {
                String str2 = this.f5195c.m51421a().toStr();
                String m51417b = this.f5195c.m51417b();
                this.f5196d = this.f5195c;
                if (TextUtils.isEmpty(str2)) {
                    str = null;
                } else {
                    String m54719f = Encrypt.m54719f(C2422a.m51453a(str2.getBytes("UTF-8"), this.f5194b));
                    str = TextUtils.isEmpty(m51417b) ? null : Encrypt.m54719f(C2422a.m51453a(m51417b.getBytes("UTF-8"), this.f5194b));
                    r4 = m54719f;
                }
                if (TextUtils.isEmpty(r4)) {
                    return;
                }
                LastLocationInfo lastLocationInfo3 = new LastLocationInfo();
                lastLocationInfo3.m51416b(r4);
                lastLocationInfo3.m51420a(C2432j.m51186b());
                lastLocationInfo3.m51418a(str);
                f5191h.m55459h(lastLocationInfo3, "_id=1");
                this.f5197e = C2432j.m51186b();
                LastLocationInfo lastLocationInfo4 = f5190g;
                if (lastLocationInfo4 != null) {
                    lastLocationInfo4.m51420a(C2432j.m51186b());
                }
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "LastLocationManager", "saveLastFix");
        }
    }
}
