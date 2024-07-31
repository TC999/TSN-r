package com.amap.api.col.p047s;

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
import com.amap.api.services.core.AMapException;
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
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.List;

/* renamed from: com.amap.api.col.s.u4 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class MessageHandler extends Handler {

    /* renamed from: a */
    private static MessageHandler f6557a;

    /* compiled from: MessageHandler.java */
    /* renamed from: com.amap.api.col.s.u4$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2166a {

        /* renamed from: a */
        public AutoTChargeStationResult f6558a;

        /* renamed from: b */
        public AutoTSearch.OnChargeStationListener f6559b;
    }

    /* compiled from: MessageHandler.java */
    /* renamed from: com.amap.api.col.s.u4$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2167b {

        /* renamed from: a */
        public BusLineResult f6560a;

        /* renamed from: b */
        public BusLineSearch.OnBusLineSearchListener f6561b;
    }

    /* compiled from: MessageHandler.java */
    /* renamed from: com.amap.api.col.s.u4$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2168c {

        /* renamed from: a */
        public BusStationResult f6562a;

        /* renamed from: b */
        public BusStationSearch.OnBusStationSearchListener f6563b;
    }

    /* compiled from: MessageHandler.java */
    /* renamed from: com.amap.api.col.s.u4$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2169d {

        /* renamed from: a */
        public CloudItemDetail f6564a;

        /* renamed from: b */
        public CloudSearch.OnCloudSearchListener f6565b;
    }

    /* compiled from: MessageHandler.java */
    /* renamed from: com.amap.api.col.s.u4$e */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2170e {

        /* renamed from: a */
        public CloudResult f6566a;

        /* renamed from: b */
        public CloudSearch.OnCloudSearchListener f6567b;
    }

    /* compiled from: MessageHandler.java */
    /* renamed from: com.amap.api.col.s.u4$f */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2171f {

        /* renamed from: a */
        public GeocodeResult f6568a;

        /* renamed from: b */
        public GeocodeSearch.OnGeocodeSearchListener f6569b;
    }

    /* compiled from: MessageHandler.java */
    /* renamed from: com.amap.api.col.s.u4$g */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2172g {

        /* renamed from: a */
        public List<NearbySearch.NearbyListener> f6570a;

        /* renamed from: b */
        public NearbySearchResult f6571b;
    }

    /* compiled from: MessageHandler.java */
    /* renamed from: com.amap.api.col.s.u4$h */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2173h {

        /* renamed from: a */
        public PoiItem f6572a;

        /* renamed from: b */
        public PoiSearch.OnPoiSearchListener f6573b;
    }

    /* compiled from: MessageHandler.java */
    /* renamed from: com.amap.api.col.s.u4$i */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2174i {

        /* renamed from: a */
        public PoiItemV2 f6574a;

        /* renamed from: b */
        public PoiSearchV2.OnPoiSearchListener f6575b;
    }

    /* compiled from: MessageHandler.java */
    /* renamed from: com.amap.api.col.s.u4$j */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2175j {

        /* renamed from: a */
        public PoiResult f6576a;

        /* renamed from: b */
        public PoiSearch.OnPoiSearchListener f6577b;
    }

    /* compiled from: MessageHandler.java */
    /* renamed from: com.amap.api.col.s.u4$k */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2176k {

        /* renamed from: a */
        public PoiResultV2 f6578a;

        /* renamed from: b */
        public PoiSearchV2.OnPoiSearchListener f6579b;
    }

    /* compiled from: MessageHandler.java */
    /* renamed from: com.amap.api.col.s.u4$l */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2177l {

        /* renamed from: a */
        public RegeocodeResult f6580a;

        /* renamed from: b */
        public GeocodeSearch.OnGeocodeSearchListener f6581b;
    }

    /* compiled from: MessageHandler.java */
    /* renamed from: com.amap.api.col.s.u4$m */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2178m {

        /* renamed from: a */
        public RoutePOISearchResult f6582a;

        /* renamed from: b */
        public RoutePOISearch.OnRoutePOISearchListener f6583b;
    }

    /* compiled from: MessageHandler.java */
    /* renamed from: com.amap.api.col.s.u4$n */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2179n {

        /* renamed from: a */
        public LocalWeatherForecastResult f6584a;

        /* renamed from: b */
        public WeatherSearch.OnWeatherSearchListener f6585b;
    }

    /* compiled from: MessageHandler.java */
    /* renamed from: com.amap.api.col.s.u4$o */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2180o {

        /* renamed from: a */
        public LocalWeatherLiveResult f6586a;

        /* renamed from: b */
        public WeatherSearch.OnWeatherSearchListener f6587b;
    }

    MessageHandler() {
    }

    /* renamed from: a */
    public static synchronized MessageHandler m52418a() {
        MessageHandler messageHandler;
        synchronized (MessageHandler.class) {
            if (f6557a == null) {
                if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
                    f6557a = new MessageHandler();
                }
                f6557a = new MessageHandler(Looper.getMainLooper());
            }
            messageHandler = f6557a;
        }
        return messageHandler;
    }

    /* renamed from: b */
    private static void m52417b(Message message) {
        int i = message.arg2;
        ShareSearch.OnShareSearchListener onShareSearchListener = (ShareSearch.OnShareSearchListener) message.obj;
        String string = message.getData().getString("shareurlkey");
        if (onShareSearchListener == null) {
            return;
        }
        switch (message.what) {
            case 1100:
                onShareSearchListener.onPoiShareUrlSearched(string, i);
                return;
            case AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR /* 1101 */:
                onShareSearchListener.onLocationShareUrlSearched(string, i);
                return;
            case AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT /* 1102 */:
                onShareSearchListener.onNaviShareUrlSearched(string, i);
                return;
            case AMapException.CODE_AMAP_ENGINE_RETURN_TIMEOUT /* 1103 */:
                onShareSearchListener.onBusRouteShareUrlSearched(string, i);
                return;
            case 1104:
                onShareSearchListener.onDrivingRouteShareUrlSearched(string, i);
                return;
            case 1105:
                onShareSearchListener.onWalkRouteShareUrlSearched(string, i);
                return;
            default:
                return;
        }
    }

    /* renamed from: c */
    private static void m52416c(Message message) {
        List<NearbySearch.NearbyListener> list = (List) message.obj;
        if (list == null || list.size() == 0) {
            return;
        }
        for (NearbySearch.NearbyListener nearbyListener : list) {
            nearbyListener.onNearbyInfoUploaded(message.what);
        }
    }

    /* renamed from: d */
    private static void m52415d(Message message) {
        List<NearbySearch.NearbyListener> list;
        C2172g c2172g = (C2172g) message.obj;
        if (c2172g == null || (list = c2172g.f6570a) == null || list.size() == 0) {
            return;
        }
        NearbySearchResult nearbySearchResult = message.what == 1000 ? c2172g.f6571b : null;
        for (NearbySearch.NearbyListener nearbyListener : list) {
            nearbyListener.onNearbyInfoSearched(nearbySearchResult, message.what);
        }
    }

    /* renamed from: e */
    private static void m52414e(Message message) {
        List<NearbySearch.NearbyListener> list = (List) message.obj;
        if (list == null || list.size() == 0) {
            return;
        }
        for (NearbySearch.NearbyListener nearbyListener : list) {
            nearbyListener.onUserInfoCleared(message.what);
        }
    }

    /* renamed from: f */
    private static void m52413f(Message message) {
        BusStationSearch.OnBusStationSearchListener onBusStationSearchListener;
        C2168c c2168c = (C2168c) message.obj;
        if (c2168c == null || (onBusStationSearchListener = c2168c.f6563b) == null) {
            return;
        }
        int i = message.what;
        onBusStationSearchListener.onBusStationSearched(i == 1000 ? c2168c.f6562a : null, i);
    }

    /* renamed from: g */
    private static void m52412g(Message message) {
        C2173h c2173h;
        PoiSearch.OnPoiSearchListener onPoiSearchListener;
        Bundle data;
        int i = message.what;
        if (i == 600) {
            C2175j c2175j = (C2175j) message.obj;
            if (c2175j == null || (onPoiSearchListener = c2175j.f6577b) == null || (data = message.getData()) == null) {
                return;
            }
            onPoiSearchListener.onPoiSearched(c2175j.f6576a, data.getInt("errorCode"));
        } else if (i != 602 || (c2173h = (C2173h) message.obj) == null) {
        } else {
            PoiSearch.OnPoiSearchListener onPoiSearchListener2 = c2173h.f6573b;
            Bundle data2 = message.getData();
            if (data2 != null) {
                onPoiSearchListener2.onPoiItemSearched(c2173h.f6572a, data2.getInt("errorCode"));
            }
        }
    }

    /* renamed from: h */
    private static void m52411h(Message message) {
        C2174i c2174i;
        PoiSearchV2.OnPoiSearchListener onPoiSearchListener;
        Bundle data;
        int i = message.what;
        if (i == 603) {
            C2176k c2176k = (C2176k) message.obj;
            if (c2176k == null || (onPoiSearchListener = c2176k.f6579b) == null || (data = message.getData()) == null) {
                return;
            }
            onPoiSearchListener.onPoiSearched(c2176k.f6578a, data.getInt("errorCode"));
        } else if (i != 604 || (c2174i = (C2174i) message.obj) == null) {
        } else {
            PoiSearchV2.OnPoiSearchListener onPoiSearchListener2 = c2174i.f6575b;
            Bundle data2 = message.getData();
            if (data2 != null) {
                onPoiSearchListener2.onPoiItemSearched(c2174i.f6574a, data2.getInt("errorCode"));
            }
        }
    }

    /* renamed from: i */
    private static void m52410i(Message message) {
        C2166a c2166a;
        if (message.what != 600 || (c2166a = (C2166a) message.obj) == null) {
            return;
        }
        AutoTSearch.OnChargeStationListener onChargeStationListener = c2166a.f6559b;
        Bundle data = message.getData();
        if (data != null) {
            int i = data.getInt("errorCode");
            if (onChargeStationListener != null) {
                onChargeStationListener.onChargeStationSearched(c2166a.f6558a, i);
            }
        }
    }

    /* renamed from: j */
    private static void m52409j(Message message) {
        Inputtips.InputtipsListener inputtipsListener = (Inputtips.InputtipsListener) message.obj;
        if (inputtipsListener == null) {
            return;
        }
        inputtipsListener.onGetInputtips(message.what == 1000 ? message.getData().getParcelableArrayList(CommonNetImpl.RESULT) : null, message.what);
    }

    /* renamed from: k */
    private static void m52408k(Message message) {
        C2171f c2171f;
        GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener;
        GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener2;
        int i = message.what;
        if (i == 201) {
            C2177l c2177l = (C2177l) message.obj;
            if (c2177l == null || (onGeocodeSearchListener2 = c2177l.f6581b) == null) {
                return;
            }
            onGeocodeSearchListener2.onRegeocodeSearched(c2177l.f6580a, message.arg2);
        } else if (i != 200 || (c2171f = (C2171f) message.obj) == null || (onGeocodeSearchListener = c2171f.f6569b) == null) {
        } else {
            onGeocodeSearchListener.onGeocodeSearched(c2171f.f6568a, message.arg2);
        }
    }

    /* renamed from: l */
    private static void m52407l(Message message) {
        DistrictSearch.OnDistrictSearchListener onDistrictSearchListener = (DistrictSearch.OnDistrictSearchListener) message.obj;
        if (onDistrictSearchListener == null) {
            return;
        }
        onDistrictSearchListener.onDistrictSearched((DistrictResult) message.getData().getParcelable(CommonNetImpl.RESULT));
    }

    /* renamed from: m */
    private static void m52406m(Message message) {
        BusLineSearch.OnBusLineSearchListener onBusLineSearchListener;
        C2167b c2167b = (C2167b) message.obj;
        if (c2167b == null || (onBusLineSearchListener = c2167b.f6561b) == null) {
            return;
        }
        int i = message.what;
        onBusLineSearchListener.onBusLineSearched(i == 1000 ? c2167b.f6560a : null, i);
    }

    /* renamed from: n */
    private static void m52405n(Message message) {
        Bundle data;
        RouteSearch.OnRouteSearchListener onRouteSearchListener = (RouteSearch.OnRouteSearchListener) message.obj;
        if (onRouteSearchListener == null) {
            return;
        }
        int i = message.what;
        if (i == 100) {
            Bundle data2 = message.getData();
            if (data2 != null) {
                onRouteSearchListener.onBusRouteSearched((BusRouteResult) message.getData().getParcelable(CommonNetImpl.RESULT), data2.getInt("errorCode"));
            }
        } else if (i == 101) {
            Bundle data3 = message.getData();
            if (data3 != null) {
                onRouteSearchListener.onDriveRouteSearched((DriveRouteResult) message.getData().getParcelable(CommonNetImpl.RESULT), data3.getInt("errorCode"));
            }
        } else if (i == 102) {
            Bundle data4 = message.getData();
            if (data4 != null) {
                onRouteSearchListener.onWalkRouteSearched((WalkRouteResult) message.getData().getParcelable(CommonNetImpl.RESULT), data4.getInt("errorCode"));
            }
        } else if (i == 103) {
            Bundle data5 = message.getData();
            if (data5 != null) {
                onRouteSearchListener.onRideRouteSearched((RideRouteResult) message.getData().getParcelable(CommonNetImpl.RESULT), data5.getInt("errorCode"));
            }
        } else if (i != 104 || (data = message.getData()) == null) {
        } else {
            onRouteSearchListener.onRideRouteSearched((RideRouteResult) message.getData().getParcelable(CommonNetImpl.RESULT), data.getInt("errorCode"));
        }
    }

    /* renamed from: o */
    private static void m52404o(Message message) {
        Bundle data;
        RouteSearchV2.OnRouteSearchListener onRouteSearchListener = (RouteSearchV2.OnRouteSearchListener) message.obj;
        if (onRouteSearchListener == null) {
            return;
        }
        int i = message.what;
        if (i == 101) {
            Bundle data2 = message.getData();
            if (data2 != null) {
                onRouteSearchListener.onDriveRouteSearched((DriveRouteResultV2) message.getData().getParcelable(CommonNetImpl.RESULT), data2.getInt("errorCode"));
            }
        } else if (i == 100) {
            Bundle data3 = message.getData();
            if (data3 != null) {
                onRouteSearchListener.onBusRouteSearched((BusRouteResultV2) message.getData().getParcelable(CommonNetImpl.RESULT), data3.getInt("errorCode"));
            }
        } else if (i == 102) {
            Bundle data4 = message.getData();
            if (data4 != null) {
                onRouteSearchListener.onWalkRouteSearched((WalkRouteResultV2) message.getData().getParcelable(CommonNetImpl.RESULT), data4.getInt("errorCode"));
            }
        } else if (i != 103 || (data = message.getData()) == null) {
        } else {
            onRouteSearchListener.onRideRouteSearched((RideRouteResultV2) message.getData().getParcelable(CommonNetImpl.RESULT), data.getInt("errorCode"));
        }
    }

    /* renamed from: p */
    private static void m52403p(Message message) {
        Bundle data;
        RouteSearch.OnTruckRouteSearchListener onTruckRouteSearchListener = (RouteSearch.OnTruckRouteSearchListener) message.obj;
        if (onTruckRouteSearchListener == null || message.what != 104 || (data = message.getData()) == null) {
            return;
        }
        onTruckRouteSearchListener.onTruckRouteSearched((TruckRouteRestult) message.getData().getParcelable(CommonNetImpl.RESULT), data.getInt("errorCode"));
    }

    /* renamed from: q */
    private static void m52402q(Message message) {
        Bundle data;
        RouteSearch.OnRoutePlanSearchListener onRoutePlanSearchListener = (RouteSearch.OnRoutePlanSearchListener) message.obj;
        if (onRoutePlanSearchListener == null || message.what != 105 || (data = message.getData()) == null) {
            return;
        }
        onRoutePlanSearchListener.onDriveRoutePlanSearched((DriveRoutePlanResult) message.getData().getParcelable(CommonNetImpl.RESULT), data.getInt("errorCode"));
    }

    /* renamed from: r */
    private static void m52401r(Message message) {
        C2169d c2169d;
        int i = message.what;
        if (i == 700) {
            C2170e c2170e = (C2170e) message.obj;
            if (c2170e == null) {
                return;
            }
            c2170e.f6567b.onCloudSearched(c2170e.f6566a, message.arg2);
        } else if (i != 701 || (c2169d = (C2169d) message.obj) == null) {
        } else {
            c2169d.f6565b.onCloudItemDetailSearched(c2169d.f6564a, message.arg2);
        }
    }

    /* renamed from: s */
    private static void m52400s(Message message) {
        C2179n c2179n;
        WeatherSearch.OnWeatherSearchListener onWeatherSearchListener;
        Bundle data;
        WeatherSearch.OnWeatherSearchListener onWeatherSearchListener2;
        Bundle data2;
        int i = message.what;
        if (i == 1301) {
            C2180o c2180o = (C2180o) message.obj;
            if (c2180o == null || (onWeatherSearchListener2 = c2180o.f6587b) == null || (data2 = message.getData()) == null) {
                return;
            }
            onWeatherSearchListener2.onWeatherLiveSearched(c2180o.f6586a, data2.getInt("errorCode"));
        } else if (i != 1302 || (c2179n = (C2179n) message.obj) == null || (onWeatherSearchListener = c2179n.f6585b) == null || (data = message.getData()) == null) {
        } else {
            onWeatherSearchListener.onWeatherForecastSearched(c2179n.f6584a, data.getInt("errorCode"));
        }
    }

    /* renamed from: t */
    private static void m52399t(Message message) {
        RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener;
        Bundle data;
        C2178m c2178m = (C2178m) message.obj;
        if (c2178m == null || (onRoutePOISearchListener = c2178m.f6583b) == null || (data = message.getData()) == null) {
            return;
        }
        onRoutePOISearchListener.onRoutePoiSearched(c2178m.f6582a, data.getInt("errorCode"));
    }

    /* renamed from: u */
    private static void m52398u(Message message) {
        Bundle data;
        DistanceSearch.OnDistanceSearchListener onDistanceSearchListener = (DistanceSearch.OnDistanceSearchListener) message.obj;
        if (onDistanceSearchListener == null || message.what != 400 || (data = message.getData()) == null) {
            return;
        }
        onDistanceSearchListener.onDistanceSearched((DistanceResult) message.getData().getParcelable(CommonNetImpl.RESULT), data.getInt("errorCode"));
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            int i = message.arg1;
            if (i != 101) {
                switch (i) {
                    case 1:
                        m52405n(message);
                        return;
                    case 2:
                        m52408k(message);
                        return;
                    case 3:
                        m52406m(message);
                        return;
                    case 4:
                        m52407l(message);
                        return;
                    case 5:
                        m52409j(message);
                        return;
                    case 6:
                        m52412g(message);
                        return;
                    case 7:
                        m52413f(message);
                        return;
                    case 8:
                        m52414e(message);
                        return;
                    case 9:
                        m52415d(message);
                        return;
                    case 10:
                        m52416c(message);
                        return;
                    case 11:
                        m52417b(message);
                        return;
                    case 12:
                        m52401r(message);
                        return;
                    case 13:
                        m52400s(message);
                        return;
                    case 14:
                        m52399t(message);
                        return;
                    default:
                        switch (i) {
                            case 16:
                                m52398u(message);
                                return;
                            case 17:
                                m52403p(message);
                                return;
                            case 18:
                                m52402q(message);
                                return;
                            case 19:
                                m52411h(message);
                                return;
                            case 20:
                                m52410i(message);
                                return;
                            default:
                                return;
                        }
                }
            }
            m52404o(message);
        } catch (Throwable th) {
            C2082j4.m52825i(th, "MessageHandler", "handleMessage");
        }
    }

    private MessageHandler(Looper looper) {
        super(looper);
    }
}
