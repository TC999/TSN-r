package com.amap.api.fence;

import android.app.PendingIntent;
import android.content.Context;
import com.amap.api.col.p0463l.GeoFenceManager;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.utils.C2428b;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GeoFenceClient {
    public static final int GEOFENCE_IN = 1;
    public static final int GEOFENCE_OUT = 2;
    public static final int GEOFENCE_STAYED = 4;

    /* renamed from: a */
    Context f6852a;

    /* renamed from: b */
    GeoFenceManager f6853b;

    public GeoFenceClient(Context context) {
        this.f6852a = null;
        this.f6853b = null;
        try {
            if (context != null) {
                Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                this.f6852a = origApplicationContext;
                this.f6853b = m52165a(origApplicationContext);
                return;
            }
            throw new IllegalArgumentException("Context参数不能为null");
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceClient", "<init>");
        }
    }

    /* renamed from: a */
    private static GeoFenceManager m52165a(Context context) {
        return new GeoFenceManager(context);
    }

    public void addGeoFence(DPoint dPoint, float f, String str) {
        try {
            this.f6853b.m55791o(dPoint, f, str);
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceClient", "addGeoFence round");
        }
    }

    public PendingIntent createPendingIntent(String str) {
        try {
            return this.f6853b.m55808d(str);
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceClient", "creatPendingIntent");
            return null;
        }
    }

    public List<GeoFence> getAllGeoFence() {
        ArrayList arrayList = new ArrayList();
        try {
            return this.f6853b.m55838C();
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceClient", "getGeoFenceList");
            return arrayList;
        }
    }

    public boolean isPause() {
        try {
            return this.f6853b.m55813a0();
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceClient", "isPause");
            return true;
        }
    }

    public void pauseGeoFence() {
        try {
            this.f6853b.m55821T();
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceClient", "pauseGeoFence");
        }
    }

    public void removeGeoFence() {
        try {
            this.f6853b.m55802g();
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceClient", "removeGeoFence");
        }
    }

    public void resumeGeoFence() {
        try {
            this.f6853b.m55817X();
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceClient", "resumeGeoFence");
        }
    }

    public void setActivateAction(int i) {
        try {
            this.f6853b.m55800h(i);
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceClient", "setActivatesAction");
        }
    }

    public void setGeoFenceAble(String str, boolean z) {
        try {
            this.f6853b.m55786t(str, z);
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceClient", "setGeoFenceAble");
        }
    }

    public void setGeoFenceListener(GeoFenceListener geoFenceListener) {
        try {
            this.f6853b.m55794l(geoFenceListener);
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceClient", "setGeoFenceListener");
        }
    }

    public void setLocationClientOption(AMapLocationClientOption aMapLocationClientOption) {
        try {
            this.f6853b.m55792n(aMapLocationClientOption);
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceClient", "setGeoFenceListener");
        }
    }

    public void addGeoFence(List<DPoint> list, String str) {
        try {
            this.f6853b.m55785u(list, str);
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceClient", "addGeoFence polygon");
        }
    }

    public boolean removeGeoFence(GeoFence geoFence) {
        try {
            return this.f6853b.m55783w(geoFence);
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceClient", "removeGeoFence1");
            return false;
        }
    }

    public void addGeoFence(String str, String str2, DPoint dPoint, float f, int i, String str3) {
        try {
            this.f6853b.m55788r(str, str2, dPoint, f, i, str3);
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceClient", "addGeoFence searche");
        }
    }

    public void addGeoFence(String str, String str2, String str3, int i, String str4) {
        try {
            this.f6853b.m55787s(str, str2, str3, i, str4);
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceClient", "addGeoFence searche");
        }
    }

    public void addGeoFence(String str, String str2) {
        try {
            this.f6853b.m55789q(str, str2);
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceClient", "addGeoFence district");
        }
    }
}
