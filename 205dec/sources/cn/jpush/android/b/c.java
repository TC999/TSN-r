package cn.jpush.android.b;

import android.content.Context;
import android.location.Location;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.api.ReportCallBack;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.n.e;
import com.stub.StubApp;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    protected Context f4094a;

    public c(Context context) {
        this.f4094a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        e.a().a(new e.a() { // from class: cn.jpush.android.b.c.1
            @Override // cn.jpush.android.n.e.a
            public void a(b bVar) {
                c.this.a(bVar);
            }

            @Override // cn.jpush.android.n.e.a
            public void a(b bVar, b bVar2) {
                c.this.a(bVar, bVar2);
            }

            @Override // cn.jpush.android.n.e.a
            public void a(boolean z3) {
                if (z3) {
                    c.this.a();
                } else {
                    c.this.b();
                }
            }

            @Override // cn.jpush.android.n.e.a
            public void b(b bVar) {
                c.this.b(bVar);
            }
        });
    }

    private void a(Context context, b bVar, Location location) {
        try {
            Logger.d("GeofenceAction", "geofence report id=" + bVar.f4074a);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("geofence_id", bVar.f4074a);
            if (location != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("lat", location.getLatitude() + "");
                jSONObject2.put("lng", location.getLongitude() + "");
                jSONObject.put("gps", jSONObject2);
            }
            if (JCoreManager.onEvent(null, null, 26, null, null, jSONObject, "geo_fence") instanceof JSONObject) {
                JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 15, null, null, jSONObject, new ReportCallBack() { // from class: cn.jpush.android.b.c.2
                    @Override // cn.jiguang.api.ReportCallBack
                    public void onFinish(int i4) {
                        Logger.d("GeofenceAction", "report with callback:" + i4);
                    }
                });
            }
        } catch (Throwable th) {
            Logger.w("GeofenceAction", "report geofence error:" + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
    }

    public void a(long j4) {
    }

    protected abstract void a(b bVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(b bVar, Location location) {
        if (bVar != null) {
            try {
                if (bVar.f4082i == 2) {
                    a(this.f4094a, bVar, location);
                } else {
                    cn.jpush.android.d.d dVar = bVar.f4093t;
                    if (dVar != null) {
                        cn.jpush.android.d.b.a(this.f4094a, dVar);
                    } else {
                        Logger.w("GeofenceAction", "there is no push entity, won't show notification");
                    }
                }
            } catch (Throwable th) {
                Logger.ww("GeofenceAction", "process geofence error:" + th);
            }
        }
    }

    protected abstract void a(b bVar, b bVar2);

    public void b() {
    }

    protected abstract void b(b bVar);
}
