package com.amap.api.maps;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.amap.api.col.p0003l.e4;
import com.amap.api.col.p0003l.fa;
import com.amap.api.col.p0003l.fk;
import com.amap.api.col.p0003l.g4;
import com.amap.api.col.p0003l.p4;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.NaviPara;
import com.amap.api.maps.model.PoiPara;
import com.amap.api.maps.model.RoutePara;
import java.util.List;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
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
    private static final double R = 6378137.0d;
    private static final int TRANSIT_ROUTE_MODEL = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        String f10715a;

        /* renamed from: b  reason: collision with root package name */
        Context f10716b;

        public a(String str, Context context) {
            this.f10715a = str;
            if (context != null) {
                this.f10716b = context.getApplicationContext();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            if (this.f10716b != null) {
                try {
                    g4.c(this.f10716b, new p4.a(this.f10715a, "10.0.600", fa.f7732c).b(new String[]{"com.amap.api.maps"}).c(), "", null);
                    interrupt();
                } catch (fk e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    private static void a(RoutePara routePara, Context context, int i4) throws AMapException {
        if (a(routePara)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(276824064);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse(b(routePara, context, i4)));
            intent.setPackage("com.autonavi.minimap");
            new a("oan", context).start();
            context.startActivity(intent);
            return;
        }
        throw new AMapException("\u975e\u6cd5\u53c2\u6570");
    }

    private static String b(RoutePara routePara, Context context, int i4) {
        String format = String.format(Locale.US, "androidamap://route?sourceApplication=%s&slat=%f&slon=%f&sname=%s&dlat=%f&dlon=%f&dname=%s&dev=0&t=%d", e4.e(context), Double.valueOf(routePara.getStartPoint().latitude), Double.valueOf(routePara.getStartPoint().longitude), routePara.getStartName(), Double.valueOf(routePara.getEndPoint().latitude), Double.valueOf(routePara.getEndPoint().longitude), routePara.getEndName(), Integer.valueOf(i4));
        if (i4 == 1) {
            return format + "&m=" + routePara.getTransitRouteStyle();
        } else if (i4 == 2) {
            return format + "&m=" + routePara.getDrivingRouteStyle();
        } else {
            return format;
        }
    }

    public static float calculateArea(LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null) {
            try {
                double sin = Math.sin((latLng.latitude * 3.141592653589793d) / 180.0d) - Math.sin((latLng2.latitude * 3.141592653589793d) / 180.0d);
                double d4 = (latLng2.longitude - latLng.longitude) / 360.0d;
                if (d4 < 0.0d) {
                    d4 += 1.0d;
                }
                return (float) (sin * 2.5560394669790553E14d * d4);
            } catch (Throwable th) {
                th.printStackTrace();
                return 0.0f;
            }
        }
        try {
            throw new AMapException("\u975e\u6cd5\u5750\u6807\u503c");
        } catch (AMapException e4) {
            e4.printStackTrace();
            return 0.0f;
        }
    }

    public static float calculateLineDistance(LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null) {
            try {
                double d4 = latLng.longitude;
                double d5 = d4 * 0.01745329251994329d;
                double d6 = latLng.latitude * 0.01745329251994329d;
                double d7 = latLng2.longitude * 0.01745329251994329d;
                double d8 = latLng2.latitude * 0.01745329251994329d;
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
            throw new AMapException("\u975e\u6cd5\u5750\u6807\u503c");
        } catch (AMapException e4) {
            e4.printStackTrace();
            return 0.0f;
        }
    }

    public static void getLatestAMapApp(Context context) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(276824064);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("http://wap.amap.com/"));
            new a("glaa", context).start();
            context.startActivity(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void openAMapDrivingRoute(RoutePara routePara, Context context) throws AMapException {
        a(routePara, context, 2);
    }

    public static void openAMapNavi(NaviPara naviPara, Context context) throws AMapException {
        if (naviPara.getTargetPoint() != null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(276824064);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse(a(naviPara, context)));
            intent.setPackage("com.autonavi.minimap");
            new a("oan", context).start();
            context.startActivity(intent);
            return;
        }
        throw new AMapException("\u975e\u6cd5\u53c2\u6570");
    }

    public static void openAMapPoiNearbySearch(PoiPara poiPara, Context context) throws AMapException {
        if (poiPara.getKeywords() != null && poiPara.getKeywords().trim().length() > 0) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(276824064);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse(a(poiPara, context)));
            intent.setPackage("com.autonavi.minimap");
            new a("oan", context).start();
            context.startActivity(intent);
            return;
        }
        throw new AMapException("\u975e\u6cd5\u53c2\u6570");
    }

    public static void openAMapTransitRoute(RoutePara routePara, Context context) throws AMapException {
        a(routePara, context, 1);
    }

    public static void openAMapWalkingRoute(RoutePara routePara, Context context) throws AMapException {
        a(routePara, context, 4);
    }

    public static float calculateArea(List<LatLng> list) {
        if (list == null || list.size() < 3) {
            return 0.0f;
        }
        double d4 = 0.0d;
        int size = list.size();
        int i4 = 0;
        while (i4 < size) {
            LatLng latLng = list.get(i4);
            i4++;
            LatLng latLng2 = list.get(i4 % size);
            d4 += (((latLng.longitude * 111319.49079327357d) * Math.cos(latLng.latitude * 0.017453292519943295d)) * (latLng2.latitude * 111319.49079327357d)) - (((latLng2.longitude * 111319.49079327357d) * Math.cos(latLng2.latitude * 0.017453292519943295d)) * (latLng.latitude * 111319.49079327357d));
        }
        return Math.abs((float) (d4 / 2.0d));
    }

    private static boolean a(RoutePara routePara) {
        return (routePara.getStartPoint() == null || routePara.getEndPoint() == null || routePara.getStartName() == null || routePara.getStartName().trim().length() <= 0 || routePara.getEndName() == null || routePara.getEndName().trim().length() <= 0) ? false : true;
    }

    private static String a(NaviPara naviPara, Context context) {
        return String.format(Locale.US, "androidamap://navi?sourceApplication=%s&lat=%f&lon=%f&dev=0&style=%d", e4.e(context), Double.valueOf(naviPara.getTargetPoint().latitude), Double.valueOf(naviPara.getTargetPoint().longitude), Integer.valueOf(naviPara.getNaviStyle()));
    }

    private static String a(PoiPara poiPara, Context context) {
        String format = String.format(Locale.US, "androidamap://arroundpoi?sourceApplication=%s&keywords=%s&dev=0", e4.e(context), poiPara.getKeywords());
        if (poiPara.getCenter() != null) {
            return format + "&lat=" + poiPara.getCenter().latitude + "&lon=" + poiPara.getCenter().longitude;
        }
        return format;
    }
}
