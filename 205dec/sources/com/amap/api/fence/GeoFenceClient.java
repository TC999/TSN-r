package com.amap.api.fence;

import android.app.PendingIntent;
import android.content.Context;
import com.amap.api.col.p0003l.a;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.utils.b;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class GeoFenceClient {
    public static final int GEOFENCE_IN = 1;
    public static final int GEOFENCE_OUT = 2;
    public static final int GEOFENCE_STAYED = 4;

    /* renamed from: a  reason: collision with root package name */
    Context f10575a;

    /* renamed from: b  reason: collision with root package name */
    a f10576b;

    public GeoFenceClient(Context context) {
        this.f10575a = null;
        this.f10576b = null;
        try {
            if (context != null) {
                Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                this.f10575a = origApplicationContext;
                this.f10576b = a(origApplicationContext);
                return;
            }
            throw new IllegalArgumentException("Context\u53c2\u6570\u4e0d\u80fd\u4e3anull");
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "<init>");
        }
    }

    private static a a(Context context) {
        return new a(context);
    }

    public void addGeoFence(DPoint dPoint, float f4, String str) {
        try {
            this.f10576b.o(dPoint, f4, str);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "addGeoFence round");
        }
    }

    public PendingIntent createPendingIntent(String str) {
        try {
            return this.f10576b.d(str);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "creatPendingIntent");
            return null;
        }
    }

    public List<GeoFence> getAllGeoFence() {
        ArrayList arrayList = new ArrayList();
        try {
            return this.f10576b.C();
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "getGeoFenceList");
            return arrayList;
        }
    }

    public boolean isPause() {
        try {
            return this.f10576b.a0();
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "isPause");
            return true;
        }
    }

    public void pauseGeoFence() {
        try {
            this.f10576b.T();
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "pauseGeoFence");
        }
    }

    public void removeGeoFence() {
        try {
            this.f10576b.g();
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "removeGeoFence");
        }
    }

    public void resumeGeoFence() {
        try {
            this.f10576b.X();
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "resumeGeoFence");
        }
    }

    public void setActivateAction(int i4) {
        try {
            this.f10576b.h(i4);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "setActivatesAction");
        }
    }

    public void setGeoFenceAble(String str, boolean z3) {
        try {
            this.f10576b.t(str, z3);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "setGeoFenceAble");
        }
    }

    public void setGeoFenceListener(GeoFenceListener geoFenceListener) {
        try {
            this.f10576b.l(geoFenceListener);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "setGeoFenceListener");
        }
    }

    public void setLocationClientOption(AMapLocationClientOption aMapLocationClientOption) {
        try {
            this.f10576b.n(aMapLocationClientOption);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "setGeoFenceListener");
        }
    }

    public void addGeoFence(List<DPoint> list, String str) {
        try {
            this.f10576b.u(list, str);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "addGeoFence polygon");
        }
    }

    public boolean removeGeoFence(GeoFence geoFence) {
        try {
            return this.f10576b.w(geoFence);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "removeGeoFence1");
            return false;
        }
    }

    public void addGeoFence(String str, String str2, DPoint dPoint, float f4, int i4, String str3) {
        try {
            this.f10576b.r(str, str2, dPoint, f4, i4, str3);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "addGeoFence searche");
        }
    }

    public void addGeoFence(String str, String str2, String str3, int i4, String str4) {
        try {
            this.f10576b.s(str, str2, str3, i4, str4);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "addGeoFence searche");
        }
    }

    public void addGeoFence(String str, String str2) {
        try {
            this.f10576b.q(str, str2);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "addGeoFence district");
        }
    }
}
