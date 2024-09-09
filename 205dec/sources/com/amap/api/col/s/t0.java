package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRouteSearch;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.WalkRouteResult;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: RouteSearchCore.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class t0 implements IRouteSearch {

    /* renamed from: a  reason: collision with root package name */
    private RouteSearch.OnRouteSearchListener f10228a;

    /* renamed from: b  reason: collision with root package name */
    private RouteSearch.OnTruckRouteSearchListener f10229b;

    /* renamed from: c  reason: collision with root package name */
    private RouteSearch.OnRoutePlanSearchListener f10230c;

    /* renamed from: d  reason: collision with root package name */
    private Context f10231d;

    /* renamed from: e  reason: collision with root package name */
    private Handler f10232e;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: RouteSearchCore.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RouteSearch.WalkRouteQuery f10233a;

        a(RouteSearch.WalkRouteQuery walkRouteQuery) {
            this.f10233a = walkRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.what = 102;
            obtainMessage.arg1 = 1;
            Bundle bundle = new Bundle();
            WalkRouteResult walkRouteResult = null;
            try {
                try {
                    walkRouteResult = t0.this.calculateWalkRoute(this.f10233a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e4) {
                    bundle.putInt("errorCode", e4.getErrorCode());
                }
            } finally {
                obtainMessage.obj = t0.this.f10228a;
                bundle.putParcelable("result", walkRouteResult);
                obtainMessage.setData(bundle);
                t0.this.f10232e.sendMessage(obtainMessage);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: RouteSearchCore.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RouteSearch.BusRouteQuery f10235a;

        b(RouteSearch.BusRouteQuery busRouteQuery) {
            this.f10235a = busRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.what = 100;
            obtainMessage.arg1 = 1;
            Bundle bundle = new Bundle();
            BusRouteResult busRouteResult = null;
            try {
                try {
                    busRouteResult = t0.this.calculateBusRoute(this.f10235a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e4) {
                    bundle.putInt("errorCode", e4.getErrorCode());
                }
            } finally {
                obtainMessage.obj = t0.this.f10228a;
                bundle.putParcelable("result", busRouteResult);
                obtainMessage.setData(bundle);
                t0.this.f10232e.sendMessage(obtainMessage);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: RouteSearchCore.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RouteSearch.DriveRouteQuery f10237a;

        c(RouteSearch.DriveRouteQuery driveRouteQuery) {
            this.f10237a = driveRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.what = 101;
            obtainMessage.arg1 = 1;
            Bundle bundle = new Bundle();
            DriveRouteResult driveRouteResult = null;
            try {
                try {
                    driveRouteResult = t0.this.calculateDriveRoute(this.f10237a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e4) {
                    bundle.putInt("errorCode", e4.getErrorCode());
                }
            } finally {
                obtainMessage.obj = t0.this.f10228a;
                bundle.putParcelable("result", driveRouteResult);
                obtainMessage.setData(bundle);
                t0.this.f10232e.sendMessage(obtainMessage);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: RouteSearchCore.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RouteSearch.RideRouteQuery f10239a;

        d(RouteSearch.RideRouteQuery rideRouteQuery) {
            this.f10239a = rideRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.what = 103;
            obtainMessage.arg1 = 1;
            Bundle bundle = new Bundle();
            RideRouteResult rideRouteResult = null;
            try {
                try {
                    rideRouteResult = t0.this.calculateRideRoute(this.f10239a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e4) {
                    bundle.putInt("errorCode", e4.getErrorCode());
                }
            } finally {
                obtainMessage.obj = t0.this.f10228a;
                bundle.putParcelable("result", rideRouteResult);
                obtainMessage.setData(bundle);
                t0.this.f10232e.sendMessage(obtainMessage);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: RouteSearchCore.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RouteSearch.TruckRouteQuery f10241a;

        e(RouteSearch.TruckRouteQuery truckRouteQuery) {
            this.f10241a = truckRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.what = 104;
            obtainMessage.arg1 = 17;
            Bundle bundle = new Bundle();
            TruckRouteRestult truckRouteRestult = null;
            try {
                try {
                    truckRouteRestult = t0.this.calculateTruckRoute(this.f10241a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e4) {
                    bundle.putInt("errorCode", e4.getErrorCode());
                }
            } finally {
                obtainMessage.obj = t0.this.f10229b;
                bundle.putParcelable("result", truckRouteRestult);
                obtainMessage.setData(bundle);
                t0.this.f10232e.sendMessage(obtainMessage);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: RouteSearchCore.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RouteSearch.DrivePlanQuery f10243a;

        f(RouteSearch.DrivePlanQuery drivePlanQuery) {
            this.f10243a = drivePlanQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.what = 105;
            obtainMessage.arg1 = 18;
            Bundle bundle = new Bundle();
            DriveRoutePlanResult driveRoutePlanResult = null;
            try {
                try {
                    driveRoutePlanResult = t0.this.calculateDrivePlan(this.f10243a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e4) {
                    bundle.putInt("errorCode", e4.getErrorCode());
                }
            } finally {
                obtainMessage.obj = t0.this.f10230c;
                bundle.putParcelable("result", driveRoutePlanResult);
                obtainMessage.setData(bundle);
                t0.this.f10232e.sendMessage(obtainMessage);
            }
        }
    }

    public t0(Context context) throws AMapException {
        h1 a4 = cf.a(context, i4.a(false));
        if (a4.f9876a == cf.c.SuccessCode) {
            this.f10231d = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f10232e = u4.a();
            return;
        }
        String str = a4.f9877b;
        throw new AMapException(str, 1, str, a4.f9876a.a());
    }

    private static boolean b(RouteSearch.FromAndTo fromAndTo) {
        return (fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) ? false : true;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final BusRouteResult calculateBusRoute(RouteSearch.BusRouteQuery busRouteQuery) throws AMapException {
        try {
            s4.d(this.f10231d);
            if (busRouteQuery != null) {
                if (b(busRouteQuery.getFromAndTo())) {
                    RouteSearch.BusRouteQuery m41clone = busRouteQuery.m41clone();
                    BusRouteResult O = new c4(this.f10231d, m41clone).O();
                    if (O != null) {
                        O.setBusQuery(m41clone);
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

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateBusRouteAsyn(RouteSearch.BusRouteQuery busRouteQuery) {
        try {
            y.a().b(new b(busRouteQuery));
        } catch (Throwable th) {
            j4.i(th, "RouteSearch", "calculateBusRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final DriveRoutePlanResult calculateDrivePlan(RouteSearch.DrivePlanQuery drivePlanQuery) throws AMapException {
        try {
            s4.d(this.f10231d);
            if (drivePlanQuery != null) {
                if (b(drivePlanQuery.getFromAndTo())) {
                    DriveRoutePlanResult O = new m4(this.f10231d, drivePlanQuery.m42clone()).O();
                    if (O != null) {
                        O.setDrivePlanQuery(drivePlanQuery);
                    }
                    return O;
                }
                throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
            }
            throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
        } catch (AMapException e4) {
            j4.i(e4, "RouteSearch", "calculateDrivePlan");
            throw e4;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateDrivePlanAsyn(RouteSearch.DrivePlanQuery drivePlanQuery) {
        try {
            y.a().b(new f(drivePlanQuery));
        } catch (Throwable th) {
            j4.i(th, "RouteSearch", "calculateTruckRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final DriveRouteResult calculateDriveRoute(RouteSearch.DriveRouteQuery driveRouteQuery) throws AMapException {
        try {
            s4.d(this.f10231d);
            if (driveRouteQuery != null) {
                if (b(driveRouteQuery.getFromAndTo())) {
                    q.a().g(driveRouteQuery.getPassedByPoints());
                    q.a().o(driveRouteQuery.getAvoidpolygons());
                    RouteSearch.DriveRouteQuery m43clone = driveRouteQuery.m43clone();
                    DriveRouteResult O = new n4(this.f10231d, m43clone).O();
                    if (O != null) {
                        O.setDriveQuery(m43clone);
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

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateDriveRouteAsyn(RouteSearch.DriveRouteQuery driveRouteQuery) {
        try {
            y.a().b(new c(driveRouteQuery));
        } catch (Throwable th) {
            j4.i(th, "RouteSearch", "calculateDriveRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final RideRouteResult calculateRideRoute(RouteSearch.RideRouteQuery rideRouteQuery) throws AMapException {
        try {
            s4.d(this.f10231d);
            if (rideRouteQuery != null) {
                if (b(rideRouteQuery.getFromAndTo())) {
                    q.a().c(rideRouteQuery.getFromAndTo());
                    RouteSearch.RideRouteQuery m45clone = rideRouteQuery.m45clone();
                    RideRouteResult O = new s(this.f10231d, m45clone).O();
                    if (O != null) {
                        O.setRideQuery(m45clone);
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

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateRideRouteAsyn(RouteSearch.RideRouteQuery rideRouteQuery) {
        try {
            y.a().b(new d(rideRouteQuery));
        } catch (Throwable th) {
            j4.i(th, "RouteSearch", "calculateRideRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final TruckRouteRestult calculateTruckRoute(RouteSearch.TruckRouteQuery truckRouteQuery) throws AMapException {
        try {
            s4.d(this.f10231d);
            if (truckRouteQuery != null) {
                if (b(truckRouteQuery.getFromAndTo())) {
                    q.a().d(truckRouteQuery.getFromAndTo(), truckRouteQuery.getPassedByPoints());
                    q.a();
                    q.l(truckRouteQuery.getPassedByPoints());
                    RouteSearch.TruckRouteQuery m46clone = truckRouteQuery.m46clone();
                    TruckRouteRestult O = new z(this.f10231d, m46clone).O();
                    if (O != null) {
                        O.setTruckQuery(m46clone);
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

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateTruckRouteAsyn(RouteSearch.TruckRouteQuery truckRouteQuery) {
        try {
            y.a().b(new e(truckRouteQuery));
        } catch (Throwable th) {
            j4.i(th, "RouteSearch", "calculateTruckRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final WalkRouteResult calculateWalkRoute(RouteSearch.WalkRouteQuery walkRouteQuery) throws AMapException {
        try {
            s4.d(this.f10231d);
            if (walkRouteQuery != null) {
                if (b(walkRouteQuery.getFromAndTo())) {
                    q.a().j(walkRouteQuery.getFromAndTo());
                    RouteSearch.WalkRouteQuery m47clone = walkRouteQuery.m47clone();
                    WalkRouteResult O = new a0(this.f10231d, m47clone).O();
                    if (O != null) {
                        O.setWalkQuery(m47clone);
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

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateWalkRouteAsyn(RouteSearch.WalkRouteQuery walkRouteQuery) {
        try {
            y.a().b(new a(walkRouteQuery));
        } catch (Throwable th) {
            j4.i(th, "RouteSearch", "calculateWalkRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void setOnRoutePlanSearchListener(RouteSearch.OnRoutePlanSearchListener onRoutePlanSearchListener) {
        this.f10230c = onRoutePlanSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void setOnTruckRouteSearchListener(RouteSearch.OnTruckRouteSearchListener onTruckRouteSearchListener) {
        this.f10229b = onTruckRouteSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void setRouteSearchListener(RouteSearch.OnRouteSearchListener onRouteSearchListener) {
        this.f10228a = onRouteSearchListener;
    }
}
