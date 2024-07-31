package com.amap.api.col.p047s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p047s.C2033cf;
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
import com.umeng.socialize.net.dplus.CommonNetImpl;

/* renamed from: com.amap.api.col.s.t0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class RouteSearchCore implements IRouteSearch {

    /* renamed from: a */
    private RouteSearch.OnRouteSearchListener f6500a;

    /* renamed from: b */
    private RouteSearch.OnTruckRouteSearchListener f6501b;

    /* renamed from: c */
    private RouteSearch.OnRoutePlanSearchListener f6502c;

    /* renamed from: d */
    private Context f6503d;

    /* renamed from: e */
    private Handler f6504e;

    /* compiled from: RouteSearchCore.java */
    /* renamed from: com.amap.api.col.s.t0$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2146a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ RouteSearch.WalkRouteQuery f6505a;

        RunnableC2146a(RouteSearch.WalkRouteQuery walkRouteQuery) {
            this.f6505a = walkRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = MessageHandler.m52418a().obtainMessage();
            obtainMessage.what = 102;
            obtainMessage.arg1 = 1;
            Bundle bundle = new Bundle();
            WalkRouteResult walkRouteResult = null;
            try {
                try {
                    walkRouteResult = RouteSearchCore.this.calculateWalkRoute(this.f6505a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                }
            } finally {
                obtainMessage.obj = RouteSearchCore.this.f6500a;
                bundle.putParcelable(CommonNetImpl.RESULT, walkRouteResult);
                obtainMessage.setData(bundle);
                RouteSearchCore.this.f6504e.sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: RouteSearchCore.java */
    /* renamed from: com.amap.api.col.s.t0$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2147b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ RouteSearch.BusRouteQuery f6507a;

        RunnableC2147b(RouteSearch.BusRouteQuery busRouteQuery) {
            this.f6507a = busRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = MessageHandler.m52418a().obtainMessage();
            obtainMessage.what = 100;
            obtainMessage.arg1 = 1;
            Bundle bundle = new Bundle();
            BusRouteResult busRouteResult = null;
            try {
                try {
                    busRouteResult = RouteSearchCore.this.calculateBusRoute(this.f6507a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                }
            } finally {
                obtainMessage.obj = RouteSearchCore.this.f6500a;
                bundle.putParcelable(CommonNetImpl.RESULT, busRouteResult);
                obtainMessage.setData(bundle);
                RouteSearchCore.this.f6504e.sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: RouteSearchCore.java */
    /* renamed from: com.amap.api.col.s.t0$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2148c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ RouteSearch.DriveRouteQuery f6509a;

        RunnableC2148c(RouteSearch.DriveRouteQuery driveRouteQuery) {
            this.f6509a = driveRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = MessageHandler.m52418a().obtainMessage();
            obtainMessage.what = 101;
            obtainMessage.arg1 = 1;
            Bundle bundle = new Bundle();
            DriveRouteResult driveRouteResult = null;
            try {
                try {
                    driveRouteResult = RouteSearchCore.this.calculateDriveRoute(this.f6509a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                }
            } finally {
                obtainMessage.obj = RouteSearchCore.this.f6500a;
                bundle.putParcelable(CommonNetImpl.RESULT, driveRouteResult);
                obtainMessage.setData(bundle);
                RouteSearchCore.this.f6504e.sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: RouteSearchCore.java */
    /* renamed from: com.amap.api.col.s.t0$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2149d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ RouteSearch.RideRouteQuery f6511a;

        RunnableC2149d(RouteSearch.RideRouteQuery rideRouteQuery) {
            this.f6511a = rideRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = MessageHandler.m52418a().obtainMessage();
            obtainMessage.what = 103;
            obtainMessage.arg1 = 1;
            Bundle bundle = new Bundle();
            RideRouteResult rideRouteResult = null;
            try {
                try {
                    rideRouteResult = RouteSearchCore.this.calculateRideRoute(this.f6511a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                }
            } finally {
                obtainMessage.obj = RouteSearchCore.this.f6500a;
                bundle.putParcelable(CommonNetImpl.RESULT, rideRouteResult);
                obtainMessage.setData(bundle);
                RouteSearchCore.this.f6504e.sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: RouteSearchCore.java */
    /* renamed from: com.amap.api.col.s.t0$e */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2150e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ RouteSearch.TruckRouteQuery f6513a;

        RunnableC2150e(RouteSearch.TruckRouteQuery truckRouteQuery) {
            this.f6513a = truckRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = MessageHandler.m52418a().obtainMessage();
            obtainMessage.what = 104;
            obtainMessage.arg1 = 17;
            Bundle bundle = new Bundle();
            TruckRouteRestult truckRouteRestult = null;
            try {
                try {
                    truckRouteRestult = RouteSearchCore.this.calculateTruckRoute(this.f6513a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                }
            } finally {
                obtainMessage.obj = RouteSearchCore.this.f6501b;
                bundle.putParcelable(CommonNetImpl.RESULT, truckRouteRestult);
                obtainMessage.setData(bundle);
                RouteSearchCore.this.f6504e.sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: RouteSearchCore.java */
    /* renamed from: com.amap.api.col.s.t0$f */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2151f implements Runnable {

        /* renamed from: a */
        final /* synthetic */ RouteSearch.DrivePlanQuery f6515a;

        RunnableC2151f(RouteSearch.DrivePlanQuery drivePlanQuery) {
            this.f6515a = drivePlanQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = MessageHandler.m52418a().obtainMessage();
            obtainMessage.what = 105;
            obtainMessage.arg1 = 18;
            Bundle bundle = new Bundle();
            DriveRoutePlanResult driveRoutePlanResult = null;
            try {
                try {
                    driveRoutePlanResult = RouteSearchCore.this.calculateDrivePlan(this.f6515a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                }
            } finally {
                obtainMessage.obj = RouteSearchCore.this.f6502c;
                bundle.putParcelable(CommonNetImpl.RESULT, driveRoutePlanResult);
                obtainMessage.setData(bundle);
                RouteSearchCore.this.f6504e.sendMessage(obtainMessage);
            }
        }
    }

    public RouteSearchCore(Context context) throws AMapException {
        C2066h1 m53127a = C2033cf.m53127a(context, C2077i4.m52895a(false));
        if (m53127a.f6148a == C2033cf.EnumC2036c.SuccessCode) {
            this.f6503d = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f6504e = MessageHandler.m52418a();
            return;
        }
        String str = m53127a.f6149b;
        throw new AMapException(str, 1, str, m53127a.f6148a.m53102a());
    }

    /* renamed from: b */
    private static boolean m52449b(RouteSearch.FromAndTo fromAndTo) {
        return (fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) ? false : true;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final BusRouteResult calculateBusRoute(RouteSearch.BusRouteQuery busRouteQuery) throws AMapException {
        try {
            ManifestConfig.m52460d(this.f6503d);
            if (busRouteQuery != null) {
                if (m52449b(busRouteQuery.getFromAndTo())) {
                    RouteSearch.BusRouteQuery m60120clone = busRouteQuery.m60120clone();
                    BusRouteResult m53251O = new BusRouteSearchHandler(this.f6503d, m60120clone).m53251O();
                    if (m53251O != null) {
                        m53251O.setBusQuery(m60120clone);
                    }
                    return m53251O;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            C2082j4.m52825i(e, "RouteSearch", "calculateBusRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateBusRouteAsyn(RouteSearch.BusRouteQuery busRouteQuery) {
        try {
            ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2147b(busRouteQuery));
        } catch (Throwable th) {
            C2082j4.m52825i(th, "RouteSearch", "calculateBusRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final DriveRoutePlanResult calculateDrivePlan(RouteSearch.DrivePlanQuery drivePlanQuery) throws AMapException {
        try {
            ManifestConfig.m52460d(this.f6503d);
            if (drivePlanQuery != null) {
                if (m52449b(drivePlanQuery.getFromAndTo())) {
                    DriveRoutePlanResult m53251O = new DrivePlanSearchHandler(this.f6503d, drivePlanQuery.m60121clone()).m53251O();
                    if (m53251O != null) {
                        m53251O.setDrivePlanQuery(drivePlanQuery);
                    }
                    return m53251O;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            C2082j4.m52825i(e, "RouteSearch", "calculateDrivePlan");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateDrivePlanAsyn(RouteSearch.DrivePlanQuery drivePlanQuery) {
        try {
            ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2151f(drivePlanQuery));
        } catch (Throwable th) {
            C2082j4.m52825i(th, "RouteSearch", "calculateTruckRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final DriveRouteResult calculateDriveRoute(RouteSearch.DriveRouteQuery driveRouteQuery) throws AMapException {
        try {
            ManifestConfig.m52460d(this.f6503d);
            if (driveRouteQuery != null) {
                if (m52449b(driveRouteQuery.getFromAndTo())) {
                    RequestConfig.m52687a().m52681g(driveRouteQuery.getPassedByPoints());
                    RequestConfig.m52687a().m52673o(driveRouteQuery.getAvoidpolygons());
                    RouteSearch.DriveRouteQuery m60122clone = driveRouteQuery.m60122clone();
                    DriveRouteResult m53251O = new DriveRouteSearchHandler(this.f6503d, m60122clone).m53251O();
                    if (m53251O != null) {
                        m53251O.setDriveQuery(m60122clone);
                    }
                    return m53251O;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            C2082j4.m52825i(e, "RouteSearch", "calculateDriveRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateDriveRouteAsyn(RouteSearch.DriveRouteQuery driveRouteQuery) {
        try {
            ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2148c(driveRouteQuery));
        } catch (Throwable th) {
            C2082j4.m52825i(th, "RouteSearch", "calculateDriveRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final RideRouteResult calculateRideRoute(RouteSearch.RideRouteQuery rideRouteQuery) throws AMapException {
        try {
            ManifestConfig.m52460d(this.f6503d);
            if (rideRouteQuery != null) {
                if (m52449b(rideRouteQuery.getFromAndTo())) {
                    RequestConfig.m52687a().m52685c(rideRouteQuery.getFromAndTo());
                    RouteSearch.RideRouteQuery m60124clone = rideRouteQuery.m60124clone();
                    RideRouteResult m53251O = new RideRouteSearchHandler(this.f6503d, m60124clone).m53251O();
                    if (m53251O != null) {
                        m53251O.setRideQuery(m60124clone);
                    }
                    return m53251O;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            C2082j4.m52825i(e, "RouteSearch", "calculaterideRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateRideRouteAsyn(RouteSearch.RideRouteQuery rideRouteQuery) {
        try {
            ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2149d(rideRouteQuery));
        } catch (Throwable th) {
            C2082j4.m52825i(th, "RouteSearch", "calculateRideRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final TruckRouteRestult calculateTruckRoute(RouteSearch.TruckRouteQuery truckRouteQuery) throws AMapException {
        try {
            ManifestConfig.m52460d(this.f6503d);
            if (truckRouteQuery != null) {
                if (m52449b(truckRouteQuery.getFromAndTo())) {
                    RequestConfig.m52687a().m52684d(truckRouteQuery.getFromAndTo(), truckRouteQuery.getPassedByPoints());
                    RequestConfig.m52687a();
                    RequestConfig.m52676l(truckRouteQuery.getPassedByPoints());
                    RouteSearch.TruckRouteQuery m60125clone = truckRouteQuery.m60125clone();
                    TruckRouteRestult m53251O = new TruckRouteSearchHandler(this.f6503d, m60125clone).m53251O();
                    if (m53251O != null) {
                        m53251O.setTruckQuery(m60125clone);
                    }
                    return m53251O;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            C2082j4.m52825i(e, "RouteSearch", "calculateDriveRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateTruckRouteAsyn(RouteSearch.TruckRouteQuery truckRouteQuery) {
        try {
            ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2150e(truckRouteQuery));
        } catch (Throwable th) {
            C2082j4.m52825i(th, "RouteSearch", "calculateTruckRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final WalkRouteResult calculateWalkRoute(RouteSearch.WalkRouteQuery walkRouteQuery) throws AMapException {
        try {
            ManifestConfig.m52460d(this.f6503d);
            if (walkRouteQuery != null) {
                if (m52449b(walkRouteQuery.getFromAndTo())) {
                    RequestConfig.m52687a().m52678j(walkRouteQuery.getFromAndTo());
                    RouteSearch.WalkRouteQuery m60126clone = walkRouteQuery.m60126clone();
                    WalkRouteResult m53251O = new WalkRouteSearchHandler(this.f6503d, m60126clone).m53251O();
                    if (m53251O != null) {
                        m53251O.setWalkQuery(m60126clone);
                    }
                    return m53251O;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            C2082j4.m52825i(e, "RouteSearch", "calculateWalkRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateWalkRouteAsyn(RouteSearch.WalkRouteQuery walkRouteQuery) {
        try {
            ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2146a(walkRouteQuery));
        } catch (Throwable th) {
            C2082j4.m52825i(th, "RouteSearch", "calculateWalkRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void setOnRoutePlanSearchListener(RouteSearch.OnRoutePlanSearchListener onRoutePlanSearchListener) {
        this.f6502c = onRoutePlanSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void setOnTruckRouteSearchListener(RouteSearch.OnTruckRouteSearchListener onTruckRouteSearchListener) {
        this.f6501b = onTruckRouteSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void setRouteSearchListener(RouteSearch.OnRouteSearchListener onRouteSearchListener) {
        this.f6500a = onRouteSearchListener;
    }
}
