package com.amap.api.maps;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.amap.api.col.p0463l.AMapCoreException;
import com.amap.api.col.p0463l.AuthConfigManager;
import com.amap.api.col.p0463l.C1780e4;
import com.amap.api.col.p0463l.ConfigableConst;
import com.amap.api.col.p0463l.SDKInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.NaviPara;
import com.amap.api.maps.model.PoiPara;
import com.amap.api.maps.model.RoutePara;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;
import java.util.Locale;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AMapUtils {
    private static final String AMAPNAVIURL = "androidamap://navi?sourceApplication=%s&lat=%f&lon=%f&dev=0&style=%d";
    private static final String AMAPPOISEARCHURL = "androidamap://arroundpoi?sourceApplication=%s&keywords=%s&dev=0";
    private static final String AMAPROUTEURL = "androidamap://route?sourceApplication=%s&slat=%f&slon=%f&sname=%s&dlat=%f&dlon=%f&dname=%s&dev=0&t=%d";
    public static final int BUS_COMFORT = 4;
    public static final int BUS_MONEY_LITTLE = 1;
    public static final int BUS_NO_SUBWAY = 5;
    public static final int BUS_TIME_FIRST = 0;
    public static final int BUS_TRANSFER_LITTLE = 2;
    public static final int BUS_WALK_LITTLE = 3;
    private static final double DEG_TO_RAD = 0.017453292519943295d;
    private static final int DRING_ROUTE_MODEL = 2;
    public static final int DRIVING_AVOID_CONGESTION = 4;
    public static final int DRIVING_DEFAULT = 0;
    public static final int DRIVING_NO_HIGHWAY = 3;
    public static final int DRIVING_NO_HIGHWAY_AVOID_CONGESTION = 6;
    public static final int DRIVING_NO_HIGHWAY_AVOID_SHORT_MONEY = 5;
    public static final int DRIVING_NO_HIGHWAY_SAVE_MONEY_AVOID_CONGESTION = 8;
    public static final int DRIVING_SAVE_MONEY = 1;
    public static final int DRIVING_SAVE_MONEY_AVOID_CONGESTION = 7;
    public static final int DRIVING_SHORT_DISTANCE = 2;
    private static final double EARTHRADIUS = 6378137.0d;
    private static final double NF_PI = 0.01745329251994329d;

    /* renamed from: R */
    private static final double f7011R = 6378137.0d;
    private static final int TRANSIT_ROUTE_MODEL = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.maps.AMapUtils$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2257a extends Thread {

        /* renamed from: a */
        String f7012a;

        /* renamed from: b */
        Context f7013b;

        public C2257a(String str, Context context) {
            this.f7012a = str;
            if (context != null) {
                this.f7013b = context.getApplicationContext();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            if (this.f7013b != null) {
                try {
                    AuthConfigManager.m55061c(this.f7013b, new SDKInfo.C1869a(this.f7012a, "10.0.600", ConfigableConst.f3943c).m54390b(new String[]{"com.amap.api.maps"}).m54389c(), "", null);
                    interrupt();
                } catch (AMapCoreException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    private static void m52106a(RoutePara routePara, Context context, int i) throws AMapException {
        if (m52107a(routePara)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(276824064);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse(m52105b(routePara, context, i)));
            intent.setPackage("com.autonavi.minimap");
            new C2257a("oan", context).start();
            context.startActivity(intent);
            return;
        }
        throw new AMapException(AMapException.ILLEGAL_AMAP_ARGUMENT);
    }

    /* renamed from: b */
    private static String m52105b(RoutePara routePara, Context context, int i) {
        String format = String.format(Locale.US, AMAPROUTEURL, C1780e4.m55245e(context), Double.valueOf(routePara.getStartPoint().latitude), Double.valueOf(routePara.getStartPoint().longitude), routePara.getStartName(), Double.valueOf(routePara.getEndPoint().latitude), Double.valueOf(routePara.getEndPoint().longitude), routePara.getEndName(), Integer.valueOf(i));
        if (i == 1) {
            return format + "&m=" + routePara.getTransitRouteStyle();
        } else if (i == 2) {
            return format + "&m=" + routePara.getDrivingRouteStyle();
        } else {
            return format;
        }
    }

    public static float calculateArea(LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null) {
            try {
                double sin = Math.sin((latLng.latitude * 3.141592653589793d) / 180.0d) - Math.sin((latLng2.latitude * 3.141592653589793d) / 180.0d);
                double d = (latLng2.longitude - latLng.longitude) / 360.0d;
                if (d < Utils.DOUBLE_EPSILON) {
                    d += 1.0d;
                }
                return (float) (sin * 2.5560394669790553E14d * d);
            } catch (Throwable th) {
                th.printStackTrace();
                return 0.0f;
            }
        }
        try {
            throw new AMapException(AMapException.ERROR_ILLEGAL_VALUE);
        } catch (AMapException e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    public static float calculateLineDistance(LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null) {
            try {
                double d = latLng.longitude;
                double d2 = latLng.latitude;
                double d3 = latLng2.longitude;
                double d4 = latLng2.latitude;
                double d5 = d * NF_PI;
                double d6 = d2 * NF_PI;
                double d7 = d3 * NF_PI;
                double d8 = d4 * NF_PI;
                double sin = Math.sin(d5);
                double sin2 = Math.sin(d6);
                double cos = Math.cos(d5);
                double cos2 = Math.cos(d6);
                double sin3 = Math.sin(d7);
                double sin4 = Math.sin(d8);
                double cos3 = Math.cos(d7);
                double cos4 = Math.cos(d8);
                double[] dArr = {cos * cos2, cos2 * sin, sin2};
                double[] dArr2 = {cos3 * cos4, cos4 * sin3, sin4};
                return (float) (Math.asin(Math.sqrt((((dArr[0] - dArr2[0]) * (dArr[0] - dArr2[0])) + ((dArr[1] - dArr2[1]) * (dArr[1] - dArr2[1]))) + ((dArr[2] - dArr2[2]) * (dArr[2] - dArr2[2]))) / 2.0d) * 1.27420015798544E7d);
            } catch (Throwable th) {
                th.printStackTrace();
                return 0.0f;
            }
        }
        try {
            throw new AMapException(AMapException.ERROR_ILLEGAL_VALUE);
        } catch (AMapException e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    public static void getLatestAMapApp(Context context) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(276824064);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("http://wap.amap.com/"));
            new C2257a("glaa", context).start();
            context.startActivity(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void openAMapDrivingRoute(RoutePara routePara, Context context) throws AMapException {
        m52106a(routePara, context, 2);
    }

    public static void openAMapNavi(NaviPara naviPara, Context context) throws AMapException {
        if (naviPara.getTargetPoint() != null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(276824064);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse(m52109a(naviPara, context)));
            intent.setPackage("com.autonavi.minimap");
            new C2257a("oan", context).start();
            context.startActivity(intent);
            return;
        }
        throw new AMapException(AMapException.ILLEGAL_AMAP_ARGUMENT);
    }

    public static void openAMapPoiNearbySearch(PoiPara poiPara, Context context) throws AMapException {
        if (poiPara.getKeywords() != null && poiPara.getKeywords().trim().length() > 0) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(276824064);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse(m52108a(poiPara, context)));
            intent.setPackage("com.autonavi.minimap");
            new C2257a("oan", context).start();
            context.startActivity(intent);
            return;
        }
        throw new AMapException(AMapException.ILLEGAL_AMAP_ARGUMENT);
    }

    public static void openAMapTransitRoute(RoutePara routePara, Context context) throws AMapException {
        m52106a(routePara, context, 1);
    }

    public static void openAMapWalkingRoute(RoutePara routePara, Context context) throws AMapException {
        m52106a(routePara, context, 4);
    }

    public static float calculateArea(List<LatLng> list) {
        if (list == null || list.size() < 3) {
            return 0.0f;
        }
        double d = Utils.DOUBLE_EPSILON;
        int size = list.size();
        int i = 0;
        while (i < size) {
            LatLng latLng = list.get(i);
            i++;
            LatLng latLng2 = list.get(i % size);
            d += (((latLng.longitude * 111319.49079327357d) * Math.cos(latLng.latitude * 0.017453292519943295d)) * (latLng2.latitude * 111319.49079327357d)) - (((latLng2.longitude * 111319.49079327357d) * Math.cos(latLng2.latitude * 0.017453292519943295d)) * (latLng.latitude * 111319.49079327357d));
        }
        return Math.abs((float) (d / 2.0d));
    }

    /* renamed from: a */
    private static boolean m52107a(RoutePara routePara) {
        return (routePara.getStartPoint() == null || routePara.getEndPoint() == null || routePara.getStartName() == null || routePara.getStartName().trim().length() <= 0 || routePara.getEndName() == null || routePara.getEndName().trim().length() <= 0) ? false : true;
    }

    /* renamed from: a */
    private static String m52109a(NaviPara naviPara, Context context) {
        return String.format(Locale.US, AMAPNAVIURL, C1780e4.m55245e(context), Double.valueOf(naviPara.getTargetPoint().latitude), Double.valueOf(naviPara.getTargetPoint().longitude), Integer.valueOf(naviPara.getNaviStyle()));
    }

    /* renamed from: a */
    private static String m52108a(PoiPara poiPara, Context context) {
        String format = String.format(Locale.US, AMAPPOISEARCHURL, C1780e4.m55245e(context), poiPara.getKeywords());
        if (poiPara.getCenter() != null) {
            return format + "&lat=" + poiPara.getCenter().latitude + "&lon=" + poiPara.getCenter().longitude;
        }
        return format;
    }
}
