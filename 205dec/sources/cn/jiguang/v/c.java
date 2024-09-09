package cn.jiguang.v;

import android.location.GpsStatus;
import android.location.Location;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c implements GpsStatus.Listener {

    /* renamed from: a  reason: collision with root package name */
    private b f3836a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f3836a = bVar;
    }

    @Override // android.location.GpsStatus.Listener
    public void onGpsStatusChanged(int i4) {
        final Location a4;
        if (i4 == 1) {
            cn.jiguang.w.a.b("GpsStatuListener", "onGpsStatus start");
            this.f3836a.f3828d = System.currentTimeMillis() - (e.f3859m * 1000);
        } else if (i4 != 4) {
        } else {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                b bVar = this.f3836a;
                if (currentTimeMillis - bVar.f3828d > e.f3859m * 1000) {
                    bVar.f3828d = currentTimeMillis;
                    bVar.f3830f = 0;
                }
                int i5 = bVar.f3830f;
                if (i5 >= 3 || currentTimeMillis - bVar.f3829e < 2000) {
                    return;
                }
                bVar.f3830f = i5 + 1;
                bVar.f3829e = currentTimeMillis;
                if (f.a().b() && (a4 = this.f3836a.a(true)) != null && "gps".equals(a4.getProvider())) {
                    Location location = this.f3836a.f3825a;
                    if (location == null || a4.distanceTo(location) >= e.f3860n) {
                        cn.jiguang.ah.d.b(new Runnable() { // from class: cn.jiguang.v.c.1
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.f3836a.f3827c.a(a4);
                            }
                        });
                        this.f3836a.f3825a = new Location(a4);
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.w.a.f("GpsStatuListener", "onGpsStatus error:" + th);
            }
        }
    }
}
