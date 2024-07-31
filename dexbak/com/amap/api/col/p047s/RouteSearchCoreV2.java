package com.amap.api.col.p047s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p047s.C2033cf;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRouteSearchV2;
import com.amap.api.services.route.BusRouteResultV2;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RideRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;
import com.amap.api.services.route.WalkRouteResultV2;
import com.stub.StubApp;
import com.umeng.socialize.net.dplus.CommonNetImpl;

/* renamed from: com.amap.api.col.s.u0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class RouteSearchCoreV2 implements IRouteSearchV2 {

    /* renamed from: a */
    private RouteSearchV2.OnRouteSearchListener f6526a;

    /* renamed from: b */
    private Context f6527b;

    /* renamed from: c */
    private Handler f6528c;

    /* compiled from: RouteSearchCoreV2.java */
    /* renamed from: com.amap.api.col.s.u0$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2156a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ RouteSearchV2.DriveRouteQuery f6529a;

        RunnableC2156a(RouteSearchV2.DriveRouteQuery driveRouteQuery) {
            this.f6529a = driveRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = MessageHandler.m52418a().obtainMessage();
            obtainMessage.what = 101;
            obtainMessage.arg1 = 101;
            Bundle bundle = new Bundle();
            DriveRouteResultV2 driveRouteResultV2 = null;
            try {
                try {
                    driveRouteResultV2 = RouteSearchCoreV2.this.calculateDriveRoute(this.f6529a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                }
            } finally {
                obtainMessage.obj = RouteSearchCoreV2.this.f6526a;
                bundle.putParcelable(CommonNetImpl.RESULT, driveRouteResultV2);
                obtainMessage.setData(bundle);
                RouteSearchCoreV2.this.f6528c.sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: RouteSearchCoreV2.java */
    /* renamed from: com.amap.api.col.s.u0$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2157b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ RouteSearchV2.WalkRouteQuery f6531a;

        RunnableC2157b(RouteSearchV2.WalkRouteQuery walkRouteQuery) {
            this.f6531a = walkRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = MessageHandler.m52418a().obtainMessage();
            obtainMessage.what = 102;
            obtainMessage.arg1 = 101;
            Bundle bundle = new Bundle();
            WalkRouteResultV2 walkRouteResultV2 = null;
            try {
                try {
                    walkRouteResultV2 = RouteSearchCoreV2.this.calculateWalkRoute(this.f6531a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                }
            } finally {
                obtainMessage.obj = RouteSearchCoreV2.this.f6526a;
                bundle.putParcelable(CommonNetImpl.RESULT, walkRouteResultV2);
                obtainMessage.setData(bundle);
                RouteSearchCoreV2.this.f6528c.sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: RouteSearchCoreV2.java */
    /* renamed from: com.amap.api.col.s.u0$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2158c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ RouteSearchV2.RideRouteQuery f6533a;

        RunnableC2158c(RouteSearchV2.RideRouteQuery rideRouteQuery) {
            this.f6533a = rideRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = MessageHandler.m52418a().obtainMessage();
            obtainMessage.what = 103;
            obtainMessage.arg1 = 101;
            Bundle bundle = new Bundle();
            RideRouteResultV2 rideRouteResultV2 = null;
            try {
                try {
                    rideRouteResultV2 = RouteSearchCoreV2.this.calculateRideRoute(this.f6533a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                }
            } finally {
                obtainMessage.obj = RouteSearchCoreV2.this.f6526a;
                bundle.putParcelable(CommonNetImpl.RESULT, rideRouteResultV2);
                obtainMessage.setData(bundle);
                RouteSearchCoreV2.this.f6528c.sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: RouteSearchCoreV2.java */
    /* renamed from: com.amap.api.col.s.u0$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2159d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ RouteSearchV2.BusRouteQuery f6535a;

        RunnableC2159d(RouteSearchV2.BusRouteQuery busRouteQuery) {
            this.f6535a = busRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = MessageHandler.m52418a().obtainMessage();
            obtainMessage.what = 100;
            obtainMessage.arg1 = 101;
            Bundle bundle = new Bundle();
            BusRouteResultV2 busRouteResultV2 = null;
            try {
                try {
                    busRouteResultV2 = RouteSearchCoreV2.this.calculateBusRoute(this.f6535a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                }
            } finally {
                obtainMessage.obj = RouteSearchCoreV2.this.f6526a;
                bundle.putParcelable(CommonNetImpl.RESULT, busRouteResultV2);
                obtainMessage.setData(bundle);
                RouteSearchCoreV2.this.f6528c.sendMessage(obtainMessage);
            }
        }
    }

    public RouteSearchCoreV2(Context context) throws AMapException {
        C2066h1 m53127a = C2033cf.m53127a(context, C2077i4.m52895a(false));
        if (m53127a.f6148a == C2033cf.EnumC2036c.SuccessCode) {
            this.f6527b = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f6528c = MessageHandler.m52418a();
            return;
        }
        String str = m53127a.f6149b;
        throw new AMapException(str, 1, str, m53127a.f6148a.m53102a());
    }

    /* renamed from: b */
    private static boolean m52439b(RouteSearchV2.FromAndTo fromAndTo) {
        return (fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) ? false : true;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final BusRouteResultV2 calculateBusRoute(RouteSearchV2.BusRouteQuery busRouteQuery) throws AMapException {
        try {
            ManifestConfig.m52460d(this.f6527b);
            if (busRouteQuery != null) {
                if (m52439b(busRouteQuery.getFromAndTo())) {
                    RouteSearchV2.BusRouteQuery m60127clone = busRouteQuery.m60127clone();
                    BusRouteResultV2 m53251O = new BusRouteSearchHandlerV2(this.f6527b, m60127clone).m53251O();
                    if (m53251O != null) {
                        m53251O.setBusQuery(m60127clone);
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

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void calculateBusRouteAsyn(RouteSearchV2.BusRouteQuery busRouteQuery) {
        try {
            ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2159d(busRouteQuery));
        } catch (Throwable th) {
            C2082j4.m52825i(th, "RouteSearch", "calculateBusRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final DriveRouteResultV2 calculateDriveRoute(RouteSearchV2.DriveRouteQuery driveRouteQuery) throws AMapException {
        try {
            ManifestConfig.m52460d(this.f6527b);
            if (driveRouteQuery != null) {
                if (m52439b(driveRouteQuery.getFromAndTo())) {
                    RequestConfig.m52687a();
                    RequestConfig.m52676l(driveRouteQuery.getPassedByPoints());
                    RequestConfig.m52687a().m52673o(driveRouteQuery.getAvoidpolygons());
                    RouteSearchV2.DriveRouteQuery m60128clone = driveRouteQuery.m60128clone();
                    DriveRouteResultV2 m53251O = new DriveRouteSearchHandlerV2(this.f6527b, m60128clone).m53251O();
                    if (m53251O != null) {
                        m53251O.setDriveQuery(m60128clone);
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

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void calculateDriveRouteAsyn(RouteSearchV2.DriveRouteQuery driveRouteQuery) {
        try {
            ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2156a(driveRouteQuery));
        } catch (Throwable th) {
            C2082j4.m52825i(th, "RouteSearch", "calculateDriveRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final RideRouteResultV2 calculateRideRoute(RouteSearchV2.RideRouteQuery rideRouteQuery) throws AMapException {
        try {
            ManifestConfig.m52460d(this.f6527b);
            if (rideRouteQuery != null) {
                if (m52439b(rideRouteQuery.getFromAndTo())) {
                    RequestConfig.m52687a().m52683e(rideRouteQuery.getFromAndTo());
                    RouteSearchV2.RideRouteQuery m60130clone = rideRouteQuery.m60130clone();
                    RideRouteResultV2 m53251O = new RideRouteSearchHandlerV2(this.f6527b, m60130clone).m53251O();
                    if (m53251O != null) {
                        m53251O.setRideQuery(m60130clone);
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

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void calculateRideRouteAsyn(RouteSearchV2.RideRouteQuery rideRouteQuery) {
        try {
            ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2158c(rideRouteQuery));
        } catch (Throwable th) {
            C2082j4.m52825i(th, "RouteSearch", "calculateRideRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final WalkRouteResultV2 calculateWalkRoute(RouteSearchV2.WalkRouteQuery walkRouteQuery) throws AMapException {
        try {
            ManifestConfig.m52460d(this.f6527b);
            if (walkRouteQuery != null) {
                if (m52439b(walkRouteQuery.getFromAndTo())) {
                    RequestConfig.m52687a().m52677k(walkRouteQuery.getFromAndTo());
                    RouteSearchV2.WalkRouteQuery m60131clone = walkRouteQuery.m60131clone();
                    WalkRouteResultV2 m53251O = new WalkRouteSearchHandlerV2(this.f6527b, m60131clone).m53251O();
                    if (m53251O != null) {
                        m53251O.setWalkQuery(m60131clone);
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

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void calculateWalkRouteAsyn(RouteSearchV2.WalkRouteQuery walkRouteQuery) {
        try {
            ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2157b(walkRouteQuery));
        } catch (Throwable th) {
            C2082j4.m52825i(th, "RouteSearch", "calculateWalkRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void setRouteSearchListener(RouteSearchV2.OnRouteSearchListener onRouteSearchListener) {
        this.f6526a = onRouteSearchListener;
    }
}
