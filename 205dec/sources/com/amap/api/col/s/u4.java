package com.amap.api.col.s;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.services.auto.AutoTChargeStationResult;
import com.amap.api.services.auto.AutoTSearch;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiResultV2;
import com.amap.api.services.poisearch.PoiSearch;
import com.amap.api.services.poisearch.PoiSearchV2;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.BusRouteResultV2;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RideRouteResultV2;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.RouteSearchV2;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.route.WalkRouteResultV2;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;
import com.amap.api.services.share.ShareSearch;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: MessageHandler.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class u4 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private static u4 f10285a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: MessageHandler.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public AutoTChargeStationResult f10286a;

        /* renamed from: b  reason: collision with root package name */
        public AutoTSearch.OnChargeStationListener f10287b;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: MessageHandler.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public BusLineResult f10288a;

        /* renamed from: b  reason: collision with root package name */
        public BusLineSearch.OnBusLineSearchListener f10289b;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: MessageHandler.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public BusStationResult f10290a;

        /* renamed from: b  reason: collision with root package name */
        public BusStationSearch.OnBusStationSearchListener f10291b;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: MessageHandler.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public CloudItemDetail f10292a;

        /* renamed from: b  reason: collision with root package name */
        public CloudSearch.OnCloudSearchListener f10293b;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: MessageHandler.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public CloudResult f10294a;

        /* renamed from: b  reason: collision with root package name */
        public CloudSearch.OnCloudSearchListener f10295b;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: MessageHandler.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public GeocodeResult f10296a;

        /* renamed from: b  reason: collision with root package name */
        public GeocodeSearch.OnGeocodeSearchListener f10297b;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: MessageHandler.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public List<NearbySearch.NearbyListener> f10298a;

        /* renamed from: b  reason: collision with root package name */
        public NearbySearchResult f10299b;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: MessageHandler.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public PoiItem f10300a;

        /* renamed from: b  reason: collision with root package name */
        public PoiSearch.OnPoiSearchListener f10301b;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: MessageHandler.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public PoiItemV2 f10302a;

        /* renamed from: b  reason: collision with root package name */
        public PoiSearchV2.OnPoiSearchListener f10303b;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: MessageHandler.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public PoiResult f10304a;

        /* renamed from: b  reason: collision with root package name */
        public PoiSearch.OnPoiSearchListener f10305b;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: MessageHandler.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class k {

        /* renamed from: a  reason: collision with root package name */
        public PoiResultV2 f10306a;

        /* renamed from: b  reason: collision with root package name */
        public PoiSearchV2.OnPoiSearchListener f10307b;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: MessageHandler.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class l {

        /* renamed from: a  reason: collision with root package name */
        public RegeocodeResult f10308a;

        /* renamed from: b  reason: collision with root package name */
        public GeocodeSearch.OnGeocodeSearchListener f10309b;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: MessageHandler.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class m {

        /* renamed from: a  reason: collision with root package name */
        public RoutePOISearchResult f10310a;

        /* renamed from: b  reason: collision with root package name */
        public RoutePOISearch.OnRoutePOISearchListener f10311b;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: MessageHandler.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class n {

        /* renamed from: a  reason: collision with root package name */
        public LocalWeatherForecastResult f10312a;

        /* renamed from: b  reason: collision with root package name */
        public WeatherSearch.OnWeatherSearchListener f10313b;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: MessageHandler.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class o {

        /* renamed from: a  reason: collision with root package name */
        public LocalWeatherLiveResult f10314a;

        /* renamed from: b  reason: collision with root package name */
        public WeatherSearch.OnWeatherSearchListener f10315b;
    }

    u4() {
    }

    public static synchronized u4 a() {
        u4 u4Var;
        synchronized (u4.class) {
            if (f10285a == null) {
                if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
                    f10285a = new u4();
                }
                f10285a = new u4(Looper.getMainLooper());
            }
            u4Var = f10285a;
        }
        return u4Var;
    }

    private static void b(Message message) {
        int i4 = message.arg2;
        ShareSearch.OnShareSearchListener onShareSearchListener = (ShareSearch.OnShareSearchListener) message.obj;
        String string = message.getData().getString("shareurlkey");
        if (onShareSearchListener == null) {
            return;
        }
        switch (message.what) {
            case 1100:
                onShareSearchListener.onPoiShareUrlSearched(string, i4);
                return;
            case 1101:
                onShareSearchListener.onLocationShareUrlSearched(string, i4);
                return;
            case 1102:
                onShareSearchListener.onNaviShareUrlSearched(string, i4);
                return;
            case 1103:
                onShareSearchListener.onBusRouteShareUrlSearched(string, i4);
                return;
            case 1104:
                onShareSearchListener.onDrivingRouteShareUrlSearched(string, i4);
                return;
            case 1105:
                onShareSearchListener.onWalkRouteShareUrlSearched(string, i4);
                return;
            default:
                return;
        }
    }

    private static void c(Message message) {
        List<NearbySearch.NearbyListener> list = (List) message.obj;
        if (list == null || list.size() == 0) {
            return;
        }
        for (NearbySearch.NearbyListener nearbyListener : list) {
            nearbyListener.onNearbyInfoUploaded(message.what);
        }
    }

    private static void d(Message message) {
        List<NearbySearch.NearbyListener> list;
        g gVar = (g) message.obj;
        if (gVar == null || (list = gVar.f10298a) == null || list.size() == 0) {
            return;
        }
        NearbySearchResult nearbySearchResult = message.what == 1000 ? gVar.f10299b : null;
        for (NearbySearch.NearbyListener nearbyListener : list) {
            nearbyListener.onNearbyInfoSearched(nearbySearchResult, message.what);
        }
    }

    private static void e(Message message) {
        List<NearbySearch.NearbyListener> list = (List) message.obj;
        if (list == null || list.size() == 0) {
            return;
        }
        for (NearbySearch.NearbyListener nearbyListener : list) {
            nearbyListener.onUserInfoCleared(message.what);
        }
    }

    private static void f(Message message) {
        BusStationSearch.OnBusStationSearchListener onBusStationSearchListener;
        c cVar = (c) message.obj;
        if (cVar == null || (onBusStationSearchListener = cVar.f10291b) == null) {
            return;
        }
        int i4 = message.what;
        onBusStationSearchListener.onBusStationSearched(i4 == 1000 ? cVar.f10290a : null, i4);
    }

    private static void g(Message message) {
        h hVar;
        PoiSearch.OnPoiSearchListener onPoiSearchListener;
        Bundle data;
        int i4 = message.what;
        if (i4 == 600) {
            j jVar = (j) message.obj;
            if (jVar == null || (onPoiSearchListener = jVar.f10305b) == null || (data = message.getData()) == null) {
                return;
            }
            onPoiSearchListener.onPoiSearched(jVar.f10304a, data.getInt("errorCode"));
        } else if (i4 != 602 || (hVar = (h) message.obj) == null) {
        } else {
            PoiSearch.OnPoiSearchListener onPoiSearchListener2 = hVar.f10301b;
            Bundle data2 = message.getData();
            if (data2 != null) {
                onPoiSearchListener2.onPoiItemSearched(hVar.f10300a, data2.getInt("errorCode"));
            }
        }
    }

    private static void h(Message message) {
        i iVar;
        PoiSearchV2.OnPoiSearchListener onPoiSearchListener;
        Bundle data;
        int i4 = message.what;
        if (i4 == 603) {
            k kVar = (k) message.obj;
            if (kVar == null || (onPoiSearchListener = kVar.f10307b) == null || (data = message.getData()) == null) {
                return;
            }
            onPoiSearchListener.onPoiSearched(kVar.f10306a, data.getInt("errorCode"));
        } else if (i4 != 604 || (iVar = (i) message.obj) == null) {
        } else {
            PoiSearchV2.OnPoiSearchListener onPoiSearchListener2 = iVar.f10303b;
            Bundle data2 = message.getData();
            if (data2 != null) {
                onPoiSearchListener2.onPoiItemSearched(iVar.f10302a, data2.getInt("errorCode"));
            }
        }
    }

    private static void i(Message message) {
        a aVar;
        if (message.what != 600 || (aVar = (a) message.obj) == null) {
            return;
        }
        AutoTSearch.OnChargeStationListener onChargeStationListener = aVar.f10287b;
        Bundle data = message.getData();
        if (data != null) {
            int i4 = data.getInt("errorCode");
            if (onChargeStationListener != null) {
                onChargeStationListener.onChargeStationSearched(aVar.f10286a, i4);
            }
        }
    }

    private static void j(Message message) {
        Inputtips.InputtipsListener inputtipsListener = (Inputtips.InputtipsListener) message.obj;
        if (inputtipsListener == null) {
            return;
        }
        inputtipsListener.onGetInputtips(message.what == 1000 ? message.getData().getParcelableArrayList("result") : null, message.what);
    }

    private static void k(Message message) {
        f fVar;
        GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener;
        GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener2;
        int i4 = message.what;
        if (i4 == 201) {
            l lVar = (l) message.obj;
            if (lVar == null || (onGeocodeSearchListener2 = lVar.f10309b) == null) {
                return;
            }
            onGeocodeSearchListener2.onRegeocodeSearched(lVar.f10308a, message.arg2);
        } else if (i4 != 200 || (fVar = (f) message.obj) == null || (onGeocodeSearchListener = fVar.f10297b) == null) {
        } else {
            onGeocodeSearchListener.onGeocodeSearched(fVar.f10296a, message.arg2);
        }
    }

    private static void l(Message message) {
        DistrictSearch.OnDistrictSearchListener onDistrictSearchListener = (DistrictSearch.OnDistrictSearchListener) message.obj;
        if (onDistrictSearchListener == null) {
            return;
        }
        onDistrictSearchListener.onDistrictSearched((DistrictResult) message.getData().getParcelable("result"));
    }

    private static void m(Message message) {
        BusLineSearch.OnBusLineSearchListener onBusLineSearchListener;
        b bVar = (b) message.obj;
        if (bVar == null || (onBusLineSearchListener = bVar.f10289b) == null) {
            return;
        }
        int i4 = message.what;
        onBusLineSearchListener.onBusLineSearched(i4 == 1000 ? bVar.f10288a : null, i4);
    }

    private static void n(Message message) {
        Bundle data;
        RouteSearch.OnRouteSearchListener onRouteSearchListener = (RouteSearch.OnRouteSearchListener) message.obj;
        if (onRouteSearchListener == null) {
            return;
        }
        int i4 = message.what;
        if (i4 == 100) {
            Bundle data2 = message.getData();
            if (data2 != null) {
                onRouteSearchListener.onBusRouteSearched((BusRouteResult) message.getData().getParcelable("result"), data2.getInt("errorCode"));
            }
        } else if (i4 == 101) {
            Bundle data3 = message.getData();
            if (data3 != null) {
                onRouteSearchListener.onDriveRouteSearched((DriveRouteResult) message.getData().getParcelable("result"), data3.getInt("errorCode"));
            }
        } else if (i4 == 102) {
            Bundle data4 = message.getData();
            if (data4 != null) {
                onRouteSearchListener.onWalkRouteSearched((WalkRouteResult) message.getData().getParcelable("result"), data4.getInt("errorCode"));
            }
        } else if (i4 == 103) {
            Bundle data5 = message.getData();
            if (data5 != null) {
                onRouteSearchListener.onRideRouteSearched((RideRouteResult) message.getData().getParcelable("result"), data5.getInt("errorCode"));
            }
        } else if (i4 != 104 || (data = message.getData()) == null) {
        } else {
            onRouteSearchListener.onRideRouteSearched((RideRouteResult) message.getData().getParcelable("result"), data.getInt("errorCode"));
        }
    }

    private static void o(Message message) {
        Bundle data;
        RouteSearchV2.OnRouteSearchListener onRouteSearchListener = (RouteSearchV2.OnRouteSearchListener) message.obj;
        if (onRouteSearchListener == null) {
            return;
        }
        int i4 = message.what;
        if (i4 == 101) {
            Bundle data2 = message.getData();
            if (data2 != null) {
                onRouteSearchListener.onDriveRouteSearched((DriveRouteResultV2) message.getData().getParcelable("result"), data2.getInt("errorCode"));
            }
        } else if (i4 == 100) {
            Bundle data3 = message.getData();
            if (data3 != null) {
                onRouteSearchListener.onBusRouteSearched((BusRouteResultV2) message.getData().getParcelable("result"), data3.getInt("errorCode"));
            }
        } else if (i4 == 102) {
            Bundle data4 = message.getData();
            if (data4 != null) {
                onRouteSearchListener.onWalkRouteSearched((WalkRouteResultV2) message.getData().getParcelable("result"), data4.getInt("errorCode"));
            }
        } else if (i4 != 103 || (data = message.getData()) == null) {
        } else {
            onRouteSearchListener.onRideRouteSearched((RideRouteResultV2) message.getData().getParcelable("result"), data.getInt("errorCode"));
        }
    }

    private static void p(Message message) {
        Bundle data;
        RouteSearch.OnTruckRouteSearchListener onTruckRouteSearchListener = (RouteSearch.OnTruckRouteSearchListener) message.obj;
        if (onTruckRouteSearchListener == null || message.what != 104 || (data = message.getData()) == null) {
            return;
        }
        onTruckRouteSearchListener.onTruckRouteSearched((TruckRouteRestult) message.getData().getParcelable("result"), data.getInt("errorCode"));
    }

    private static void q(Message message) {
        Bundle data;
        RouteSearch.OnRoutePlanSearchListener onRoutePlanSearchListener = (RouteSearch.OnRoutePlanSearchListener) message.obj;
        if (onRoutePlanSearchListener == null || message.what != 105 || (data = message.getData()) == null) {
            return;
        }
        onRoutePlanSearchListener.onDriveRoutePlanSearched((DriveRoutePlanResult) message.getData().getParcelable("result"), data.getInt("errorCode"));
    }

    private static void r(Message message) {
        d dVar;
        int i4 = message.what;
        if (i4 == 700) {
            e eVar = (e) message.obj;
            if (eVar == null) {
                return;
            }
            eVar.f10295b.onCloudSearched(eVar.f10294a, message.arg2);
        } else if (i4 != 701 || (dVar = (d) message.obj) == null) {
        } else {
            dVar.f10293b.onCloudItemDetailSearched(dVar.f10292a, message.arg2);
        }
    }

    private static void s(Message message) {
        n nVar;
        WeatherSearch.OnWeatherSearchListener onWeatherSearchListener;
        Bundle data;
        WeatherSearch.OnWeatherSearchListener onWeatherSearchListener2;
        Bundle data2;
        int i4 = message.what;
        if (i4 == 1301) {
            o oVar = (o) message.obj;
            if (oVar == null || (onWeatherSearchListener2 = oVar.f10315b) == null || (data2 = message.getData()) == null) {
                return;
            }
            onWeatherSearchListener2.onWeatherLiveSearched(oVar.f10314a, data2.getInt("errorCode"));
        } else if (i4 != 1302 || (nVar = (n) message.obj) == null || (onWeatherSearchListener = nVar.f10313b) == null || (data = message.getData()) == null) {
        } else {
            onWeatherSearchListener.onWeatherForecastSearched(nVar.f10312a, data.getInt("errorCode"));
        }
    }

    private static void t(Message message) {
        RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener;
        Bundle data;
        m mVar = (m) message.obj;
        if (mVar == null || (onRoutePOISearchListener = mVar.f10311b) == null || (data = message.getData()) == null) {
            return;
        }
        onRoutePOISearchListener.onRoutePoiSearched(mVar.f10310a, data.getInt("errorCode"));
    }

    private static void u(Message message) {
        Bundle data;
        DistanceSearch.OnDistanceSearchListener onDistanceSearchListener = (DistanceSearch.OnDistanceSearchListener) message.obj;
        if (onDistanceSearchListener == null || message.what != 400 || (data = message.getData()) == null) {
            return;
        }
        onDistanceSearchListener.onDistanceSearched((DistanceResult) message.getData().getParcelable("result"), data.getInt("errorCode"));
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            int i4 = message.arg1;
            if (i4 != 101) {
                switch (i4) {
                    case 1:
                        n(message);
                        return;
                    case 2:
                        k(message);
                        return;
                    case 3:
                        m(message);
                        return;
                    case 4:
                        l(message);
                        return;
                    case 5:
                        j(message);
                        return;
                    case 6:
                        g(message);
                        return;
                    case 7:
                        f(message);
                        return;
                    case 8:
                        e(message);
                        return;
                    case 9:
                        d(message);
                        return;
                    case 10:
                        c(message);
                        return;
                    case 11:
                        b(message);
                        return;
                    case 12:
                        r(message);
                        return;
                    case 13:
                        s(message);
                        return;
                    case 14:
                        t(message);
                        return;
                    default:
                        switch (i4) {
                            case 16:
                                u(message);
                                return;
                            case 17:
                                p(message);
                                return;
                            case 18:
                                q(message);
                                return;
                            case 19:
                                h(message);
                                return;
                            case 20:
                                i(message);
                                return;
                            default:
                                return;
                        }
                }
            }
            o(message);
        } catch (Throwable th) {
            j4.i(th, "MessageHandler", "handleMessage");
        }
    }

    private u4(Looper looper) {
        super(looper);
    }
}
