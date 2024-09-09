package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.amap.api.col.p0003l.p4;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.BaseHoleOptions;
import com.amap.api.maps.model.CircleHoleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.PolygonHoleOptions;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.FileUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Util.java */
/* renamed from: com.amap.api.col.3l.a3  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a3 {

    /* renamed from: a  reason: collision with root package name */
    private static FPoint[] f7090a = {FPoint.obtain(), FPoint.obtain(), FPoint.obtain(), FPoint.obtain()};

    /* renamed from: b  reason: collision with root package name */
    private static List<Float> f7091b = new ArrayList(4);

    /* renamed from: c  reason: collision with root package name */
    private static List<Float> f7092c = new ArrayList(4);

    /* renamed from: d  reason: collision with root package name */
    private static int f7093d = 0;

    public static String A(String... strArr) {
        StringBuilder sb = new StringBuilder();
        int i4 = 0;
        for (String str : strArr) {
            sb.append(str);
            if (i4 != strArr.length - 1) {
                sb.append(",");
            }
            i4++;
        }
        return sb.toString();
    }

    public static void B(Bitmap bitmap) {
    }

    public static void C(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public static void D(Throwable th) {
        try {
            if (MapsInitializer.getExceptionLogger() != null) {
                MapsInitializer.getExceptionLogger().onException(th);
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean E(double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        double d11 = d6 - d4;
        double d12 = d10 - d9;
        double d13 = d7 - d5;
        double d14 = 180.0d - d8;
        double d15 = (d11 * d12) - (d13 * d14);
        if (d15 != 0.0d) {
            double d16 = d5 - d9;
            double d17 = d4 - d8;
            double d18 = ((d14 * d16) - (d12 * d17)) / d15;
            double d19 = ((d16 * d11) - (d17 * d13)) / d15;
            if (d18 >= 0.0d && d18 <= 1.0d && d19 >= 0.0d && d19 <= 1.0d) {
                return true;
            }
        }
        return false;
    }

    public static boolean F(double d4, LatLng latLng, CircleHoleOptions circleHoleOptions) {
        try {
            return ((double) AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), latLng)) <= d4 - circleHoleOptions.getRadius();
        } catch (Throwable th) {
            u5.p(th, "CircleDelegateImp", "isCircleInCircle");
            th.printStackTrace();
            return true;
        }
    }

    private static boolean G(double d4, LatLng latLng, List<BaseHoleOptions> list, LatLng latLng2) throws RemoteException {
        if (list != null && list.size() > 0) {
            for (BaseHoleOptions baseHoleOptions : list) {
                if (K(baseHoleOptions, latLng2)) {
                    return false;
                }
            }
        }
        return d4 >= ((double) AMapUtils.calculateLineDistance(latLng, latLng2));
    }

    public static boolean H(double d4, LatLng latLng, List<BaseHoleOptions> list, PolygonHoleOptions polygonHoleOptions) {
        boolean z3 = true;
        try {
            List<LatLng> points = polygonHoleOptions.getPoints();
            for (int i4 = 0; i4 < points.size() && (z3 = G(d4, latLng, list, points.get(i4))); i4++) {
            }
        } catch (Throwable th) {
            u5.p(th, "CircleDelegateImp", "isPolygonInCircle");
            th.printStackTrace();
        }
        return z3;
    }

    public static boolean I(int i4, int i5) {
        if (i4 <= 0 || i5 <= 0) {
            Log.w("3dmap", "the map must have a size");
            return false;
        }
        return true;
    }

    public static boolean J(Rect rect, int i4, int i5) {
        return rect.contains(i4, i5);
    }

    public static boolean K(BaseHoleOptions baseHoleOptions, LatLng latLng) {
        if (baseHoleOptions instanceof CircleHoleOptions) {
            CircleHoleOptions circleHoleOptions = (CircleHoleOptions) baseHoleOptions;
            LatLng center = circleHoleOptions.getCenter();
            return center != null && ((double) AMapUtils.calculateLineDistance(center, latLng)) <= circleHoleOptions.getRadius();
        }
        List<LatLng> points = ((PolygonHoleOptions) baseHoleOptions).getPoints();
        if (points == null || points.size() == 0) {
            return false;
        }
        return M(latLng, points);
    }

    private static boolean L(CircleHoleOptions circleHoleOptions, CircleHoleOptions circleHoleOptions2) {
        try {
            return ((double) AMapUtils.calculateLineDistance(circleHoleOptions2.getCenter(), circleHoleOptions.getCenter())) < circleHoleOptions.getRadius() + circleHoleOptions2.getRadius();
        } catch (Throwable th) {
            u5.p(th, "Util", "isPolygon2CircleIntersect");
            th.printStackTrace();
            return false;
        }
    }

    public static boolean M(LatLng latLng, List<LatLng> list) {
        boolean z3;
        if (latLng == null || list == null) {
            return false;
        }
        double d4 = latLng.longitude;
        double d5 = latLng.latitude;
        if (list.size() < 3) {
            return false;
        }
        if (list.get(0).equals(list.get(list.size() - 1))) {
            z3 = false;
        } else {
            list.add(list.get(0));
            z3 = true;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < list.size() - 1) {
            try {
                double d6 = list.get(i4).longitude;
                double d7 = list.get(i4).latitude;
                i4++;
                double d8 = list.get(i4).longitude;
                double d9 = list.get(i4).latitude;
                double d10 = d5;
                double d11 = d4;
                if (Z(d4, d5, d6, d7, d8, d9)) {
                    return true;
                }
                if (Math.abs(d9 - d7) >= 1.0E-9d) {
                    if (Z(d6, d7, d11, d10, 180.0d, d10)) {
                        if (d7 <= d9) {
                        }
                        i5++;
                    } else if (Z(d8, d9, d11, d10, 180.0d, d10)) {
                        if (d9 > d7) {
                            i5++;
                        }
                    } else if (E(d6, d7, d8, d9, d11, d10, d10)) {
                        i5++;
                    }
                }
                d5 = d10;
                d4 = d11;
            } finally {
                if (z3) {
                    list.remove(list.size() - 1);
                }
            }
        }
        boolean z4 = i5 % 2 != 0;
        if (z3) {
            list.remove(list.size() - 1);
        }
        return z4;
    }

    public static boolean N(List<BaseHoleOptions> list, CircleHoleOptions circleHoleOptions) {
        boolean z3 = false;
        for (int i4 = 0; i4 < list.size(); i4++) {
            BaseHoleOptions baseHoleOptions = list.get(i4);
            if (baseHoleOptions instanceof PolygonHoleOptions) {
                z3 = a0(((PolygonHoleOptions) baseHoleOptions).getPoints(), circleHoleOptions);
                if (z3) {
                    return true;
                }
            } else if ((baseHoleOptions instanceof CircleHoleOptions) && (z3 = L(circleHoleOptions, (CircleHoleOptions) baseHoleOptions))) {
                return true;
            }
        }
        return z3;
    }

    public static boolean O(List<BaseHoleOptions> list, PolygonHoleOptions polygonHoleOptions) {
        boolean z3 = false;
        for (int i4 = 0; i4 < list.size(); i4++) {
            BaseHoleOptions baseHoleOptions = list.get(i4);
            if (baseHoleOptions instanceof PolygonHoleOptions) {
                z3 = P(((PolygonHoleOptions) baseHoleOptions).getPoints(), polygonHoleOptions.getPoints());
                if (z3) {
                    return true;
                }
            } else if (baseHoleOptions instanceof CircleHoleOptions) {
                z3 = a0(polygonHoleOptions.getPoints(), (CircleHoleOptions) baseHoleOptions);
                if (z3) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return z3;
    }

    private static boolean P(List<LatLng> list, List<LatLng> list2) {
        for (int i4 = 0; i4 < list2.size(); i4++) {
            try {
                if (M(list2.get(i4), list)) {
                    return true;
                }
            } catch (Throwable th) {
                u5.p(th, "Util", "isPolygon2PolygonIntersect");
                th.printStackTrace();
                return false;
            }
        }
        for (int i5 = 0; i5 < list.size(); i5++) {
            if (M(list.get(i5), list2)) {
                return true;
            }
        }
        return c0(list, list2);
    }

    public static boolean Q(List<LatLng> list, List<BaseHoleOptions> list2, CircleHoleOptions circleHoleOptions) {
        try {
            if (a0(list, circleHoleOptions)) {
                return false;
            }
            return R(list, list2, circleHoleOptions.getCenter());
        } catch (Throwable th) {
            u5.p(th, "PolygonDelegateImp", "isCircleInPolygon");
            th.printStackTrace();
            return false;
        }
    }

    private static boolean R(List<LatLng> list, List<BaseHoleOptions> list2, LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return false;
        }
        if (list2 != null) {
            try {
                if (list2.size() > 0) {
                    for (BaseHoleOptions baseHoleOptions : list2) {
                        if (K(baseHoleOptions, latLng)) {
                            return false;
                        }
                    }
                }
            } catch (Throwable th) {
                u5.p(th, "PolygonDelegateImp", "contains");
                th.printStackTrace();
                return false;
            }
        }
        return M(latLng, list);
    }

    public static byte[] S(byte[] bArr, int i4) {
        return T(bArr, i4, i4, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
        r2.setPixel(r5, r6, r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] T(byte[] r7, int r8, int r9, boolean r10) {
        /*
            int r0 = r7.length     // Catch: java.lang.Throwable -> L40
            r1 = 0
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeByteArray(r7, r1, r0)     // Catch: java.lang.Throwable -> L40
            android.graphics.Bitmap$Config r2 = r0.getConfig()     // Catch: java.lang.Throwable -> L40
            r3 = 1
            android.graphics.Bitmap r2 = r0.copy(r2, r3)     // Catch: java.lang.Throwable -> L40
            int r3 = r0.getWidth()     // Catch: java.lang.Throwable -> L40
            int r4 = r0.getHeight()     // Catch: java.lang.Throwable -> L40
            r5 = 0
        L18:
            if (r5 >= r3) goto L31
            r6 = 0
        L1b:
            if (r6 >= r4) goto L2e
            if (r5 == 0) goto L26
            if (r6 != 0) goto L22
            goto L26
        L22:
            r2.setPixel(r5, r6, r8)     // Catch: java.lang.Throwable -> L40
            goto L2b
        L26:
            if (r10 != 0) goto L2b
            r2.setPixel(r5, r6, r9)     // Catch: java.lang.Throwable -> L40
        L2b:
            int r6 = r6 + 1
            goto L1b
        L2e:
            int r5 = r5 + 1
            goto L18
        L31:
            byte[] r8 = d0(r2)     // Catch: java.lang.Throwable -> L40
            if (r8 != 0) goto L38
            r8 = r7
        L38:
            B(r2)     // Catch: java.lang.Throwable -> L40
            B(r0)     // Catch: java.lang.Throwable -> L40
            r7 = r8
            goto L44
        L40:
            r8 = move-exception
            r8.printStackTrace()
        L44:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.a3.T(byte[], int, int, boolean):byte[]");
    }

    public static synchronized int[] U(int i4, int i5, int i6, int i7, IMapConfig iMapConfig, IGLMapState iGLMapState, int i8, int i9) {
        int[] iArr;
        synchronized (a3.class) {
            int mapWidth = iMapConfig.getMapWidth();
            int mapHeight = iMapConfig.getMapHeight();
            int anchorX = iMapConfig.getAnchorX();
            int anchorY = iMapConfig.getAnchorY();
            iArr = new int[]{(int) Math.max(i6 + d(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), anchorX), Math.min(i8, i4 - d(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), mapWidth - anchorX))), (int) Math.max(i5 + d(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), anchorY), Math.min(i9, i7 - d(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), mapHeight - anchorY)))};
        }
        return iArr;
    }

    public static synchronized int V() {
        int i4;
        synchronized (a3.class) {
            int i5 = f7093d + 1;
            f7093d = i5;
            if (i5 == Integer.MAX_VALUE) {
                f7093d = 0;
            }
            i4 = f7093d;
        }
        return i4;
    }

    private static Pair<Float, Boolean> W(IMapConfig iMapConfig, int i4, int i5, int i6, int i7, int i8, int i9) {
        float min;
        iMapConfig.getSZ();
        if (i4 == i6 && i5 == i7) {
            min = iMapConfig.getMaxZoomLevel();
        } else {
            float b4 = (float) b(iMapConfig.getMapZoomScale(), i9, Math.abs(i7 - i5));
            float b5 = (float) b(iMapConfig.getMapZoomScale(), i8, Math.abs(i6 - i4));
            float min2 = Math.min(b5, b4);
            r0 = min2 == b5;
            min = Math.min(iMapConfig.getMaxZoomLevel(), Math.max(iMapConfig.getMinZoomLevel(), min2));
        }
        return new Pair<>(Float.valueOf(min), Boolean.valueOf(r0));
    }

    public static String X(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(FileUtil.getMapBaseStorage(context));
        String str = File.separator;
        sb.append(str);
        sb.append("data");
        sb.append(str);
        return sb.toString();
    }

    public static String Y(View view) {
        StringBuilder sb = new StringBuilder();
        if (view != null) {
            try {
                if (view instanceof TextView) {
                    sb = new StringBuilder(((TextView) view).getText().toString());
                }
                if (view instanceof ViewGroup) {
                    int childCount = ((ViewGroup) view).getChildCount();
                    for (int i4 = 0; i4 < childCount; i4++) {
                        String Y = Y(((ViewGroup) view).getChildAt(i4));
                        if (!TextUtils.isEmpty(Y)) {
                            sb.append("--");
                            sb.append(Y);
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return sb.toString();
    }

    private static boolean Z(double d4, double d5, double d6, double d7, double d8, double d9) {
        return Math.abs(a(d4, d5, d6, d7, d8, d9)) < 1.0E-9d && (d4 - d6) * (d4 - d8) <= 0.0d && (d5 - d7) * (d5 - d9) <= 0.0d;
    }

    private static double a(double d4, double d5, double d6, double d7, double d8, double d9) {
        return ((d6 - d4) * (d9 - d5)) - ((d8 - d4) * (d7 - d5));
    }

    private static boolean a0(List<LatLng> list, CircleHoleOptions circleHoleOptions) {
        int i4;
        try {
            ArrayList arrayList = new ArrayList();
            for (int i5 = 0; i5 < list.size(); i5++) {
                arrayList.add(list.get(i5));
            }
            arrayList.add(list.get(0));
            ArrayList arrayList2 = new ArrayList();
            int i6 = 0;
            while (i6 < arrayList.size() && (i4 = i6 + 1) < arrayList.size()) {
                if (circleHoleOptions.getRadius() < AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) arrayList.get(i6)) && circleHoleOptions.getRadius() < AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) arrayList.get(i4))) {
                    arrayList2.clear();
                    arrayList2.add(arrayList.get(i6));
                    arrayList2.add(arrayList.get(i4));
                    if (circleHoleOptions.getRadius() >= ((double) AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) SpatialRelationUtil.calShortestDistancePoint(arrayList2, circleHoleOptions.getCenter()).second))) {
                        return true;
                    }
                    i6 = i4;
                }
                return true;
            }
        } catch (Throwable th) {
            u5.p(th, "Util", "isPolygon2CircleIntersect");
            th.printStackTrace();
        }
        return false;
    }

    private static double b(float f4, double d4, double d5) {
        double d6 = f4;
        Double.isNaN(d6);
        return 20.0d - (Math.log(d5 / (d4 * d6)) / Math.log(2.0d));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean b0(List<LatLng> list, PolygonHoleOptions polygonHoleOptions) {
        int i4 = 0;
        if (list == null || polygonHoleOptions == null) {
            return false;
        }
        try {
            List<LatLng> points = polygonHoleOptions.getPoints();
            boolean z3 = 0;
            while (i4 < points.size()) {
                try {
                    boolean M = M(points.get(i4), list);
                    if (!M) {
                        return M;
                    }
                    i4++;
                    z3 = M;
                } catch (Throwable th) {
                    th = th;
                    i4 = z3;
                    u5.p(th, "PolygonDelegateImp", "isPolygonInPolygon");
                    th.printStackTrace();
                    return i4;
                }
            }
            return z3;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static float c(float f4, float f5, double d4) {
        double pow = Math.pow(2.0d, 20.0f - f5);
        double d5 = f4;
        Double.isNaN(d5);
        return (float) (d4 / (pow * d5));
    }

    private static boolean c0(List<LatLng> list, List<LatLng> list2) {
        int i4;
        int i5;
        int i6 = 0;
        while (i6 < list.size() && (i4 = i6 + 1) < list.size()) {
            try {
                int i7 = 0;
                while (i7 < list2.size() && (i5 = i7 + 1) < list2.size()) {
                    boolean b4 = v2.b(list.get(i6), list.get(i4), list2.get(i7), list2.get(i5));
                    if (b4) {
                        return b4;
                    }
                    i7 = i5;
                }
                i6 = i4;
            } catch (Throwable th) {
                u5.p(th, "Util", "isSegmentsIntersect");
                th.printStackTrace();
            }
        }
        return false;
    }

    private static float d(float f4, float f5, float f6) {
        double d4 = f6;
        double pow = Math.pow(2.0d, 20.0f - f5);
        Double.isNaN(d4);
        double d5 = f4;
        Double.isNaN(d5);
        return (float) (d4 * pow * d5);
    }

    private static byte[] d0(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                return byteArray;
            } catch (Throwable unused) {
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                return null;
            }
        } catch (Throwable unused2) {
            byteArrayOutputStream = null;
        }
    }

    public static float e(IGLMapState iGLMapState, int i4, int i5, double d4, double d5, int i6) {
        IPoint obtain = IPoint.obtain();
        VirtualEarthProjection.latLongToPixels(d4, d5, 20, obtain);
        float f4 = f(iGLMapState, i4, i5, ((Point) obtain).x, ((Point) obtain).y, i6);
        obtain.recycle();
        return f4;
    }

    private static byte[] e0(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            int read = inputStream.read(bArr, 0, 2048);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    private static float f(IGLMapState iGLMapState, int i4, int i5, int i6, int i7, int i8) {
        if (iGLMapState != null) {
            return iGLMapState.calculateMapZoomer(i4, i5, i6, i7, i8);
        }
        return 3.0f;
    }

    public static String f0(Context context) {
        String v3 = v(context);
        if (v3 == null) {
            return null;
        }
        File file = new File(v3, "VMAP2");
        if (!file.exists()) {
            file.mkdir();
        }
        return file.toString() + File.separator;
    }

    public static float g(DPoint dPoint, DPoint dPoint2) {
        if (dPoint == null || dPoint2 == null) {
            return 0.0f;
        }
        double d4 = dPoint.f11671x;
        double d5 = dPoint2.f11671x;
        return (float) ((Math.atan2(dPoint2.f11672y - dPoint.f11672y, d5 - d4) / 3.141592653589793d) * 180.0d);
    }

    private static void g0(View view) {
        int i4 = 0;
        if (!(view instanceof ViewGroup)) {
            if (view instanceof TextView) {
                ((TextView) view).setHorizontallyScrolling(false);
                return;
            }
            return;
        }
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i4 >= viewGroup.getChildCount()) {
                return;
            }
            g0(viewGroup.getChildAt(i4));
            i4++;
        }
    }

    public static float h(IMapConfig iMapConfig, float f4) {
        if (iMapConfig != null) {
            if (f4 > iMapConfig.getMaxZoomLevel()) {
                return iMapConfig.getMaxZoomLevel();
            }
            return f4 < iMapConfig.getMinZoomLevel() ? iMapConfig.getMinZoomLevel() : f4;
        } else if (f4 > 20.0f) {
            return 20.0f;
        } else {
            if (f4 < 3.0f) {
                return 3.0f;
            }
            return f4;
        }
    }

    public static boolean h0(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        return (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || (state = activeNetworkInfo.getState()) == null || state == NetworkInfo.State.DISCONNECTED || state == NetworkInfo.State.DISCONNECTING) ? false : true;
    }

    public static float i(IMapConfig iMapConfig, float f4, float f5) {
        boolean z3;
        if (iMapConfig != null) {
            boolean isAbroadEnable = iMapConfig.isAbroadEnable();
            z3 = iMapConfig.getAbroadState() != 1;
            r0 = isAbroadEnable;
        } else {
            z3 = false;
        }
        float f6 = f4 >= 0.0f ? f4 : 0.0f;
        if (r0 && z3) {
            if (f6 > 40.0f) {
                return 40.0f;
            }
            return f6;
        } else if (iMapConfig != null && iMapConfig.isTerrainEnable()) {
            if (f6 > 80.0f) {
                return 80.0f;
            }
            return f6;
        } else if (f4 > 40.0f) {
            float f7 = f5 <= 15.0f ? 40 : f5 <= 16.0f ? 56 : f5 <= 17.0f ? 66 : f5 <= 18.0f ? 74 : f5 <= 18.0f ? 78 : 80;
            return f6 > f7 ? f7 : f6;
        } else {
            return f6;
        }
    }

    public static boolean i0(Context context) {
        File file = new File(X(context));
        if (file.exists()) {
            return FileUtil.deleteFile(file);
        }
        return true;
    }

    public static float j(IMapConfig iMapConfig, int i4, int i5, int i6, int i7, int i8, int i9) {
        float sz = iMapConfig.getSZ();
        if (i4 == i6 || i5 == i7) {
            return sz;
        }
        return Math.max((float) b(iMapConfig.getMapZoomScale(), i8, Math.abs(i6 - i4)), (float) b(iMapConfig.getMapZoomScale(), i9, Math.abs(i7 - i5)));
    }

    public static int k(Object[] objArr) {
        return Arrays.hashCode(objArr);
    }

    public static Bitmap l(Context context, String str) {
        try {
            InputStream open = u2.b(context).open(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(open);
            open.close();
            return decodeStream;
        } catch (Throwable th) {
            u5.p(th, "Util", "fromAsset");
            D(th);
            return null;
        }
    }

    public static Bitmap m(Bitmap bitmap, float f4) {
        if (bitmap == null) {
            return null;
        }
        return Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * f4), (int) (bitmap.getHeight() * f4), true);
    }

    public static Bitmap n(View view) {
        try {
            g0(view);
            view.destroyDrawingCache();
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                return drawingCache.copy(Bitmap.Config.ARGB_8888, false);
            }
            return null;
        } catch (Throwable th) {
            u5.p(th, "Utils", "getBitmapFromView");
            th.printStackTrace();
            return null;
        }
    }

    public static Bitmap o(int[] iArr, int i4, int i5) {
        return p(iArr, i4, i5, false);
    }

    public static Bitmap p(int[] iArr, int i4, int i5, boolean z3) {
        try {
            int[] iArr2 = new int[iArr.length];
            for (int i6 = 0; i6 < i5; i6++) {
                for (int i7 = 0; i7 < i4; i7++) {
                    int i8 = (i6 * i4) + i7;
                    int i9 = iArr[i8];
                    int i10 = (i9 & (-16711936)) | ((i9 << 16) & 16711680) | ((i9 >> 16) & 255);
                    if (z3) {
                        iArr2[(((i5 - i6) - 1) * i4) + i7] = i10;
                    } else {
                        iArr2[i8] = i10;
                    }
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr2, 0, i4, 0, 0, i4, i5);
            return createBitmap;
        } catch (Throwable th) {
            u5.p(th, "Util", "rgbaToArgb");
            th.printStackTrace();
            return null;
        }
    }

    public static Pair<Float, IPoint> q(AbstractCameraUpdateMessage abstractCameraUpdateMessage, IMapConfig iMapConfig) {
        return r(iMapConfig, Math.max(abstractCameraUpdateMessage.paddingLeft, 1), Math.max(abstractCameraUpdateMessage.paddingRight, 1), Math.max(abstractCameraUpdateMessage.paddingTop, 1), Math.max(abstractCameraUpdateMessage.paddingBottom, 1), abstractCameraUpdateMessage.bounds, abstractCameraUpdateMessage.width, abstractCameraUpdateMessage.height);
    }

    public static Pair<Float, IPoint> r(IMapConfig iMapConfig, int i4, int i5, int i6, int i7, LatLngBounds latLngBounds, int i8, int i9) {
        LatLng latLng;
        int i10;
        float f4;
        float f5;
        int i11;
        if (latLngBounds == null || (latLng = latLngBounds.northeast) == null || latLngBounds.southwest == null || iMapConfig == null) {
            return null;
        }
        Point latLongToPixels = VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20);
        LatLng latLng2 = latLngBounds.southwest;
        Point latLongToPixels2 = VirtualEarthProjection.latLongToPixels(latLng2.latitude, latLng2.longitude, 20);
        int i12 = latLongToPixels.x;
        int i13 = latLongToPixels2.x;
        int i14 = i12 - i13;
        int i15 = latLongToPixels2.y;
        int i16 = latLongToPixels.y;
        int i17 = i15 - i16;
        int i18 = i8 - (i4 + i5);
        int i19 = i9 - (i6 + i7);
        if (i14 >= 0 || i17 >= 0) {
            if (i14 <= 0) {
                i14 = 1;
            }
            int i20 = i17 <= 0 ? 1 : i17;
            if (i18 <= 0) {
                i18 = 1;
            }
            if (i19 <= 0) {
                i19 = 1;
            }
            Pair<Float, Boolean> W = W(iMapConfig, i12, i16, i13, i15, i18, i19);
            float floatValue = ((Float) W.first).floatValue();
            boolean booleanValue = ((Boolean) W.second).booleanValue();
            float c4 = c(iMapConfig.getMapZoomScale(), floatValue, i14);
            float c5 = c(iMapConfig.getMapZoomScale(), floatValue, i20);
            if (floatValue >= iMapConfig.getMaxZoomLevel()) {
                i10 = (int) (latLongToPixels2.x + ((((i5 - i4) + c4) * i14) / (c4 * 2.0f)));
                i11 = latLongToPixels.y;
            } else if (booleanValue) {
                i10 = (int) (latLongToPixels2.x + ((((i8 / 2) - i4) / c4) * i14));
                i11 = latLongToPixels.y;
            } else {
                i10 = (int) (latLongToPixels2.x + ((((i5 - i4) + c4) * i14) / (c4 * 2.0f)));
                f4 = latLongToPixels.y;
                f5 = (((i9 / 2) - i6) / c5) * i20;
                return new Pair<>(Float.valueOf(floatValue), IPoint.obtain((int) (i10 + d(iMapConfig.getMapZoomScale(), floatValue, iMapConfig.getAnchorX() - (iMapConfig.getMapWidth() >> 1))), (int) (((int) (f4 + f5)) + d(iMapConfig.getMapZoomScale(), floatValue, iMapConfig.getAnchorY() - (iMapConfig.getMapHeight() >> 1)))));
            }
            f4 = i11;
            f5 = (((i7 - i6) + c5) * i20) / (c5 * 2.0f);
            return new Pair<>(Float.valueOf(floatValue), IPoint.obtain((int) (i10 + d(iMapConfig.getMapZoomScale(), floatValue, iMapConfig.getAnchorX() - (iMapConfig.getMapWidth() >> 1))), (int) (((int) (f4 + f5)) + d(iMapConfig.getMapZoomScale(), floatValue, iMapConfig.getAnchorY() - (iMapConfig.getMapHeight() >> 1)))));
        }
        return null;
    }

    public static p4 s() {
        try {
            if (fa.f7734e == null) {
                fa.f7734e = new p4.a("3dmap", "10.0.600", fa.f7732c).b(new String[]{"com.amap.api.maps", "com.amap.api.mapcore", "com.autonavi.amap.mapcore", "com.autonavi.amap", "com.autonavi.ae", "com.autonavi.base", "com.autonavi.patch", "com.amap.api.3dmap.admic", "com.amap.api.trace", "com.amap.api.trace.core"}).a("10.0.600").c();
            }
            return fa.f7734e;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static DPoint t(LatLng latLng) {
        double sin = Math.sin(Math.toRadians(latLng.latitude));
        return DPoint.obtain(((latLng.longitude / 360.0d) + 0.5d) * 1.0d, (((Math.log((sin + 1.0d) / (1.0d - sin)) * 0.5d) / (-6.283185307179586d)) + 0.5d) * 1.0d);
    }

    public static String u(int i4) {
        if (i4 < 1000) {
            return i4 + "m";
        }
        return (i4 / 1000) + "km";
    }

    public static String v(Context context) {
        File file = new File(FileUtil.getMapBaseStorage(context), "data_v6");
        if (!file.exists()) {
            file.mkdir();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(file.toString());
        String str = File.separator;
        sb.append(str);
        File file2 = new File(sb.toString());
        if (!file2.exists()) {
            file2.mkdir();
        }
        return file.toString() + str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00df A[Catch: IOException -> 0x00e3, TRY_ENTER, TRY_LEAVE, TryCatch #16 {IOException -> 0x00e3, blocks: (B:103:0x00df, B:94:0x00ce), top: B:115:0x00c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String w(java.io.File r7) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.a3.w(java.io.File):java.lang.String");
    }

    public static String x(InputStream inputStream) {
        try {
            return new String(e0(inputStream), "utf-8");
        } catch (Throwable th) {
            u5.p(th, "Util", "decodeAssetResData");
            th.printStackTrace();
            return null;
        }
    }

    public static String y(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse.getAuthority() == null || !parse.getAuthority().startsWith("dualstack-")) {
                if (parse.getAuthority() != null && parse.getAuthority().startsWith("restsdk.amap.com")) {
                    return parse.buildUpon().authority("dualstack-arestapi.amap.com").build().toString();
                }
                Uri.Builder buildUpon = parse.buildUpon();
                return buildUpon.authority("dualstack-" + parse.getAuthority()).build().toString();
            }
            return str;
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String z(String str, Object obj) {
        return str + "=" + String.valueOf(obj);
    }
}
