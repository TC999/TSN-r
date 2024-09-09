package cn.jiguang.v;

import android.annotation.SuppressLint;
import android.location.GnssStatus;
import android.location.Location;

@SuppressLint({"NewApi"})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a extends GnssStatus.Callback {

    /* renamed from: a  reason: collision with root package name */
    private b f3822a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        this.f3822a = bVar;
    }

    @Override // android.location.GnssStatus.Callback
    public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
        final Location a4;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            b bVar = this.f3822a;
            if (currentTimeMillis - bVar.f3828d > e.f3859m * 1000) {
                bVar.f3828d = currentTimeMillis;
                bVar.f3830f = 0;
            }
            int i4 = bVar.f3830f;
            if (i4 >= 3 || currentTimeMillis - bVar.f3829e < 2000) {
                return;
            }
            bVar.f3830f = i4 + 1;
            bVar.f3829e = currentTimeMillis;
            if (f.a().b() && (a4 = this.f3822a.a(true)) != null && "gps".equals(a4.getProvider())) {
                Location location = this.f3822a.f3825a;
                if (location == null || a4.distanceTo(location) >= e.f3860n) {
                    cn.jiguang.ah.d.b(new Runnable() { // from class: cn.jiguang.v.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.f3822a.f3827c.a(a4);
                        }
                    });
                    this.f3822a.f3825a = new Location(a4);
                }
            }
        } catch (Throwable th) {
            cn.jiguang.w.a.f("GnssStatus", "onGnssStatus error:" + th);
        }
    }

    @Override // android.location.GnssStatus.Callback
    public void onStarted() {
        cn.jiguang.w.a.b("GnssStatus", "onGnssStatus start");
        this.f3822a.f3828d = System.currentTimeMillis() - (e.f3859m * 1000);
    }
}
