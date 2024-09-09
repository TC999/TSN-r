package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRouteSearchV2;
import com.amap.api.services.route.BusRouteResultV2;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RideRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;
import com.amap.api.services.route.WalkRouteResultV2;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: RouteSearchCoreV2.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class u0 implements IRouteSearchV2 {

    /* renamed from: a  reason: collision with root package name */
    private RouteSearchV2.OnRouteSearchListener f10254a;

    /* renamed from: b  reason: collision with root package name */
    private Context f10255b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f10256c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: RouteSearchCoreV2.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RouteSearchV2.DriveRouteQuery f10257a;

        a(RouteSearchV2.DriveRouteQuery driveRouteQuery) {
            this.f10257a = driveRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.what = 101;
            obtainMessage.arg1 = 101;
            Bundle bundle = new Bundle();
            DriveRouteResultV2 driveRouteResultV2 = null;
            try {
                try {
                    driveRouteResultV2 = u0.this.calculateDriveRoute(this.f10257a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e4) {
                    bundle.putInt("errorCode", e4.getErrorCode());
                }
            } finally {
                obtainMessage.obj = u0.this.f10254a;
                bundle.putParcelable("result", driveRouteResultV2);
                obtainMessage.setData(bundle);
                u0.this.f10256c.sendMessage(obtainMessage);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: RouteSearchCoreV2.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RouteSearchV2.WalkRouteQuery f10259a;

        b(RouteSearchV2.WalkRouteQuery walkRouteQuery) {
            this.f10259a = walkRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.what = 102;
            obtainMessage.arg1 = 101;
            Bundle bundle = new Bundle();
            WalkRouteResultV2 walkRouteResultV2 = null;
            try {
                try {
                    walkRouteResultV2 = u0.this.calculateWalkRoute(this.f10259a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e4) {
                    bundle.putInt("errorCode", e4.getErrorCode());
                }
            } finally {
                obtainMessage.obj = u0.this.f10254a;
                bundle.putParcelable("result", walkRouteResultV2);
                obtainMessage.setData(bundle);
                u0.this.f10256c.sendMessage(obtainMessage);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: RouteSearchCoreV2.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RouteSearchV2.RideRouteQuery f10261a;

        c(RouteSearchV2.RideRouteQuery rideRouteQuery) {
            this.f10261a = rideRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.what = 103;
            obtainMessage.arg1 = 101;
            Bundle bundle = new Bundle();
            RideRouteResultV2 rideRouteResultV2 = null;
            try {
                try {
                    rideRouteResultV2 = u0.this.calculateRideRoute(this.f10261a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e4) {
                    bundle.putInt("errorCode", e4.getErrorCode());
                }
            } finally {
                obtainMessage.obj = u0.this.f10254a;
                bundle.putParcelable("result", rideRouteResultV2);
                obtainMessage.setData(bundle);
                u0.this.f10256c.sendMessage(obtainMessage);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: RouteSearchCoreV2.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RouteSearchV2.BusRouteQuery f10263a;

        d(RouteSearchV2.BusRouteQuery busRouteQuery) {
            this.f10263a = busRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.what = 100;
            obtainMessage.arg1 = 101;
            Bundle bundle = new Bundle();
            BusRouteResultV2 busRouteResultV2 = null;
            try {
                try {
                    busRouteResultV2 = u0.this.calculateBusRoute(this.f10263a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e4) {
                    bundle.putInt("errorCode", e4.getErrorCode());
                }
            } finally {
                obtainMessage.obj = u0.this.f10254a;
                bundle.putParcelable("result", busRouteResultV2);
                obtainMessage.setData(bundle);
                u0.this.f10256c.sendMessage(obtainMessage);
            }
        }
    }

    public u0(Context context) throws AMapException {
        h1 a4 = cf.a(context, i4.a(false));
        if (a4.f9876a == cf.c.SuccessCode) {
            this.f10255b = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f10256c = u4.a();
            return;
        }
        String str = a4.f9877b;
        throw new AMapException(str, 1, str, a4.f9876a.a());
    }

    private static boolean b(RouteSearchV2.FromAndTo fromAndTo) {
        return (fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) ? false : true;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final BusRouteResultV2 calculateBusRoute(RouteSearchV2.BusRouteQuery busRouteQuery) throws AMapException {
        try {
            s4.d(this.f10255b);
            if (busRouteQuery != null) {
                if (b(busRouteQuery.getFromAndTo())) {
                    RouteSearchV2.BusRouteQuery m48clone = busRouteQuery.m48clone();
                    BusRouteResultV2 O = new d4(this.f10255b, m48clone).O();
                    if (O != null) {
                        O.setBusQuery(m48clone);
                    }
                    return O;
                }
                throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
            }
            throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
        } catch (AMapException e4) {
            j4.i(e4, "RouteSearch", "calculateBusRoute");
            throw e4;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void calculateBusRouteAsyn(RouteSearchV2.BusRouteQuery busRouteQuery) {
        try {
            y.a().b(new d(busRouteQuery));
        } catch (Throwable th) {
            j4.i(th, "RouteSearch", "calculateBusRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final DriveRouteResultV2 calculateDriveRoute(RouteSearchV2.DriveRouteQuery driveRouteQuery) throws AMapException {
        try {
            s4.d(this.f10255b);
            if (driveRouteQuery != null) {
                if (b(driveRouteQuery.getFromAndTo())) {
                    q.a();
                    q.l(driveRouteQuery.getPassedByPoints());
                    q.a().o(driveRouteQuery.getAvoidpolygons());
                    RouteSearchV2.DriveRouteQuery m49clone = driveRouteQuery.m49clone();
                    DriveRouteResultV2 O = new o4(this.f10255b, m49clone).O();
                    if (O != null) {
                        O.setDriveQuery(m49clone);
                    }
                    return O;
                }
                throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
            }
            throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
        } catch (AMapException e4) {
            j4.i(e4, "RouteSearch", "calculateDriveRoute");
            throw e4;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void calculateDriveRouteAsyn(RouteSearchV2.DriveRouteQuery driveRouteQuery) {
        try {
            y.a().b(new a(driveRouteQuery));
        } catch (Throwable th) {
            j4.i(th, "RouteSearch", "calculateDriveRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final RideRouteResultV2 calculateRideRoute(RouteSearchV2.RideRouteQuery rideRouteQuery) throws AMapException {
        try {
            s4.d(this.f10255b);
            if (rideRouteQuery != null) {
                if (b(rideRouteQuery.getFromAndTo())) {
                    q.a().e(rideRouteQuery.getFromAndTo());
                    RouteSearchV2.RideRouteQuery m51clone = rideRouteQuery.m51clone();
                    RideRouteResultV2 O = new t(this.f10255b, m51clone).O();
                    if (O != null) {
                        O.setRideQuery(m51clone);
                    }
                    return O;
                }
                throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
            }
            throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
        } catch (AMapException e4) {
            j4.i(e4, "RouteSearch", "calculaterideRoute");
            throw e4;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void calculateRideRouteAsyn(RouteSearchV2.RideRouteQuery rideRouteQuery) {
        try {
            y.a().b(new c(rideRouteQuery));
        } catch (Throwable th) {
            j4.i(th, "RouteSearch", "calculateRideRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final WalkRouteResultV2 calculateWalkRoute(RouteSearchV2.WalkRouteQuery walkRouteQuery) throws AMapException {
        try {
            s4.d(this.f10255b);
            if (walkRouteQuery != null) {
                if (b(walkRouteQuery.getFromAndTo())) {
                    q.a().k(walkRouteQuery.getFromAndTo());
                    RouteSearchV2.WalkRouteQuery m52clone = walkRouteQuery.m52clone();
                    WalkRouteResultV2 O = new c0(this.f10255b, m52clone).O();
                    if (O != null) {
                        O.setWalkQuery(m52clone);
                    }
                    return O;
                }
                throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
            }
            throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
        } catch (AMapException e4) {
            j4.i(e4, "RouteSearch", "calculateWalkRoute");
            throw e4;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void calculateWalkRouteAsyn(RouteSearchV2.WalkRouteQuery walkRouteQuery) {
        try {
            y.a().b(new b(walkRouteQuery));
        } catch (Throwable th) {
            j4.i(th, "RouteSearch", "calculateWalkRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void setRouteSearchListener(RouteSearchV2.OnRouteSearchListener onRouteSearchListener) {
        this.f10254a = onRouteSearchListener;
    }
}
