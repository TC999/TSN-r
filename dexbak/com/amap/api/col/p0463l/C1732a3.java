package com.amap.api.col.p0463l;

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
import com.amap.api.col.p0463l.SDKInfo;
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
import com.autonavi.base.amap.mapcore.AeUtil;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.github.mikephil.charting.utils.Utils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: Util.java */
/* renamed from: com.amap.api.col.3l.a3 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class C1732a3 {

    /* renamed from: a */
    private static FPoint[] f3524a = {FPoint.obtain(), FPoint.obtain(), FPoint.obtain(), FPoint.obtain()};

    /* renamed from: b */
    private static List<Float> f3525b = new ArrayList(4);

    /* renamed from: c */
    private static List<Float> f3526c = new ArrayList(4);

    /* renamed from: d */
    private static int f3527d = 0;

    /* renamed from: A */
    public static String m55744A(String... strArr) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str : strArr) {
            sb.append(str);
            if (i != strArr.length - 1) {
                sb.append(",");
            }
            i++;
        }
        return sb.toString();
    }

    /* renamed from: B */
    public static void m55743B(Bitmap bitmap) {
    }

    /* renamed from: C */
    public static void m55742C(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    /* renamed from: D */
    public static void m55741D(Throwable th) {
        try {
            if (MapsInitializer.getExceptionLogger() != null) {
                MapsInitializer.getExceptionLogger().onException(th);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: E */
    private static boolean m55740E(double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d3 - d;
        double d9 = d7 - d6;
        double d10 = d4 - d2;
        double d11 = 180.0d - d5;
        double d12 = (d8 * d9) - (d10 * d11);
        if (d12 != Utils.DOUBLE_EPSILON) {
            double d13 = d2 - d6;
            double d14 = d - d5;
            double d15 = ((d11 * d13) - (d9 * d14)) / d12;
            double d16 = ((d13 * d8) - (d14 * d10)) / d12;
            if (d15 >= Utils.DOUBLE_EPSILON && d15 <= 1.0d && d16 >= Utils.DOUBLE_EPSILON && d16 <= 1.0d) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: F */
    public static boolean m55739F(double d, LatLng latLng, CircleHoleOptions circleHoleOptions) {
        try {
            return ((double) AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), latLng)) <= d - circleHoleOptions.getRadius();
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "CircleDelegateImp", "isCircleInCircle");
            th.printStackTrace();
            return true;
        }
    }

    /* renamed from: G */
    private static boolean m55738G(double d, LatLng latLng, List<BaseHoleOptions> list, LatLng latLng2) throws RemoteException {
        if (list != null && list.size() > 0) {
            for (BaseHoleOptions baseHoleOptions : list) {
                if (m55734K(baseHoleOptions, latLng2)) {
                    return false;
                }
            }
        }
        return d >= ((double) AMapUtils.calculateLineDistance(latLng, latLng2));
    }

    /* renamed from: H */
    public static boolean m55737H(double d, LatLng latLng, List<BaseHoleOptions> list, PolygonHoleOptions polygonHoleOptions) {
        boolean z = true;
        try {
            List<LatLng> points = polygonHoleOptions.getPoints();
            for (int i = 0; i < points.size() && (z = m55738G(d, latLng, list, points.get(i))); i++) {
            }
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "CircleDelegateImp", "isPolygonInCircle");
            th.printStackTrace();
        }
        return z;
    }

    /* renamed from: I */
    public static boolean m55736I(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            Log.w("3dmap", "the map must have a size");
            return false;
        }
        return true;
    }

    /* renamed from: J */
    public static boolean m55735J(Rect rect, int i, int i2) {
        return rect.contains(i, i2);
    }

    /* renamed from: K */
    public static boolean m55734K(BaseHoleOptions baseHoleOptions, LatLng latLng) {
        if (baseHoleOptions instanceof CircleHoleOptions) {
            CircleHoleOptions circleHoleOptions = (CircleHoleOptions) baseHoleOptions;
            LatLng center = circleHoleOptions.getCenter();
            return center != null && ((double) AMapUtils.calculateLineDistance(center, latLng)) <= circleHoleOptions.getRadius();
        }
        List<LatLng> points = ((PolygonHoleOptions) baseHoleOptions).getPoints();
        if (points == null || points.size() == 0) {
            return false;
        }
        return m55732M(latLng, points);
    }

    /* renamed from: L */
    private static boolean m55733L(CircleHoleOptions circleHoleOptions, CircleHoleOptions circleHoleOptions2) {
        try {
            return ((double) AMapUtils.calculateLineDistance(circleHoleOptions2.getCenter(), circleHoleOptions.getCenter())) < circleHoleOptions.getRadius() + circleHoleOptions2.getRadius();
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "Util", "isPolygon2CircleIntersect");
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: M */
    public static boolean m55732M(LatLng latLng, List<LatLng> list) {
        boolean z;
        if (latLng == null || list == null) {
            return false;
        }
        double d = latLng.longitude;
        double d2 = latLng.latitude;
        if (list.size() < 3) {
            return false;
        }
        if (list.get(0).equals(list.get(list.size() - 1))) {
            z = false;
        } else {
            list.add(list.get(0));
            z = true;
        }
        int i = 0;
        int i2 = 0;
        while (i < list.size() - 1) {
            try {
                double d3 = list.get(i).longitude;
                double d4 = list.get(i).latitude;
                i++;
                double d5 = list.get(i).longitude;
                double d6 = list.get(i).latitude;
                double d7 = d2;
                double d8 = d;
                if (m55719Z(d, d2, d3, d4, d5, d6)) {
                    return true;
                }
                if (Math.abs(d6 - d4) >= 1.0E-9d) {
                    if (m55719Z(d3, d4, d8, d7, 180.0d, d7)) {
                        if (d4 <= d6) {
                        }
                        i2++;
                    } else if (m55719Z(d5, d6, d8, d7, 180.0d, d7)) {
                        if (d6 > d4) {
                            i2++;
                        }
                    } else if (m55740E(d3, d4, d5, d6, d8, d7, d7)) {
                        i2++;
                    }
                }
                d2 = d7;
                d = d8;
            } finally {
                if (z) {
                    list.remove(list.size() - 1);
                }
            }
        }
        boolean z2 = i2 % 2 != 0;
        if (z) {
            list.remove(list.size() - 1);
        }
        return z2;
    }

    /* renamed from: N */
    public static boolean m55731N(List<BaseHoleOptions> list, CircleHoleOptions circleHoleOptions) {
        boolean z = false;
        for (int i = 0; i < list.size(); i++) {
            BaseHoleOptions baseHoleOptions = list.get(i);
            if (baseHoleOptions instanceof PolygonHoleOptions) {
                z = m55717a0(((PolygonHoleOptions) baseHoleOptions).getPoints(), circleHoleOptions);
                if (z) {
                    return true;
                }
            } else if ((baseHoleOptions instanceof CircleHoleOptions) && (z = m55733L(circleHoleOptions, (CircleHoleOptions) baseHoleOptions))) {
                return true;
            }
        }
        return z;
    }

    /* renamed from: O */
    public static boolean m55730O(List<BaseHoleOptions> list, PolygonHoleOptions polygonHoleOptions) {
        boolean z = false;
        for (int i = 0; i < list.size(); i++) {
            BaseHoleOptions baseHoleOptions = list.get(i);
            if (baseHoleOptions instanceof PolygonHoleOptions) {
                z = m55729P(((PolygonHoleOptions) baseHoleOptions).getPoints(), polygonHoleOptions.getPoints());
                if (z) {
                    return true;
                }
            } else if (baseHoleOptions instanceof CircleHoleOptions) {
                z = m55717a0(polygonHoleOptions.getPoints(), (CircleHoleOptions) baseHoleOptions);
                if (z) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return z;
    }

    /* renamed from: P */
    private static boolean m55729P(List<LatLng> list, List<LatLng> list2) {
        for (int i = 0; i < list2.size(); i++) {
            try {
                if (m55732M(list2.get(i), list)) {
                    return true;
                }
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "Util", "isPolygon2PolygonIntersect");
                th.printStackTrace();
                return false;
            }
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (m55732M(list.get(i2), list2)) {
                return true;
            }
        }
        return m55713c0(list, list2);
    }

    /* renamed from: Q */
    public static boolean m55728Q(List<LatLng> list, List<BaseHoleOptions> list2, CircleHoleOptions circleHoleOptions) {
        try {
            if (m55717a0(list, circleHoleOptions)) {
                return false;
            }
            return m55727R(list, list2, circleHoleOptions.getCenter());
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "PolygonDelegateImp", "isCircleInPolygon");
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: R */
    private static boolean m55727R(List<LatLng> list, List<BaseHoleOptions> list2, LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return false;
        }
        if (list2 != null) {
            try {
                if (list2.size() > 0) {
                    for (BaseHoleOptions baseHoleOptions : list2) {
                        if (m55734K(baseHoleOptions, latLng)) {
                            return false;
                        }
                    }
                }
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "PolygonDelegateImp", "contains");
                th.printStackTrace();
                return false;
            }
        }
        return m55732M(latLng, list);
    }

    /* renamed from: S */
    public static byte[] m55726S(byte[] bArr, int i) {
        return m55725T(bArr, i, i, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
        r2.setPixel(r5, r6, r9);
     */
    /* renamed from: T */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] m55725T(byte[] r7, int r8, int r9, boolean r10) {
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
            byte[] r8 = m55711d0(r2)     // Catch: java.lang.Throwable -> L40
            if (r8 != 0) goto L38
            r8 = r7
        L38:
            m55743B(r2)     // Catch: java.lang.Throwable -> L40
            m55743B(r0)     // Catch: java.lang.Throwable -> L40
            r7 = r8
            goto L44
        L40:
            r8 = move-exception
            r8.printStackTrace()
        L44:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.C1732a3.m55725T(byte[], int, int, boolean):byte[]");
    }

    /* renamed from: U */
    public static synchronized int[] m55724U(int i, int i2, int i3, int i4, IMapConfig iMapConfig, IGLMapState iGLMapState, int i5, int i6) {
        int[] iArr;
        synchronized (C1732a3.class) {
            int mapWidth = iMapConfig.getMapWidth();
            int mapHeight = iMapConfig.getMapHeight();
            int anchorX = iMapConfig.getAnchorX();
            int anchorY = iMapConfig.getAnchorY();
            iArr = new int[]{(int) Math.max(i3 + m55712d(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), anchorX), Math.min(i5, i - m55712d(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), mapWidth - anchorX))), (int) Math.max(i2 + m55712d(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), anchorY), Math.min(i6, i4 - m55712d(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), mapHeight - anchorY)))};
        }
        return iArr;
    }

    /* renamed from: V */
    public static synchronized int m55723V() {
        int i;
        synchronized (C1732a3.class) {
            int i2 = f3527d + 1;
            f3527d = i2;
            if (i2 == Integer.MAX_VALUE) {
                f3527d = 0;
            }
            i = f3527d;
        }
        return i;
    }

    /* renamed from: W */
    private static Pair<Float, Boolean> m55722W(IMapConfig iMapConfig, int i, int i2, int i3, int i4, int i5, int i6) {
        float min;
        iMapConfig.getSZ();
        if (i == i3 && i2 == i4) {
            min = iMapConfig.getMaxZoomLevel();
        } else {
            float m55716b = (float) m55716b(iMapConfig.getMapZoomScale(), i6, Math.abs(i4 - i2));
            float m55716b2 = (float) m55716b(iMapConfig.getMapZoomScale(), i5, Math.abs(i3 - i));
            float min2 = Math.min(m55716b2, m55716b);
            r0 = min2 == m55716b2;
            min = Math.min(iMapConfig.getMaxZoomLevel(), Math.max(iMapConfig.getMinZoomLevel(), min2));
        }
        return new Pair<>(Float.valueOf(min), Boolean.valueOf(r0));
    }

    /* renamed from: X */
    public static String m55721X(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(FileUtil.getMapBaseStorage(context));
        String str = File.separator;
        sb.append(str);
        sb.append("data");
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: Y */
    public static String m55720Y(View view) {
        StringBuilder sb = new StringBuilder();
        if (view != null) {
            try {
                if (view instanceof TextView) {
                    sb = new StringBuilder(((TextView) view).getText().toString());
                }
                if (view instanceof ViewGroup) {
                    int childCount = ((ViewGroup) view).getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        String m55720Y = m55720Y(((ViewGroup) view).getChildAt(i));
                        if (!TextUtils.isEmpty(m55720Y)) {
                            sb.append("--");
                            sb.append(m55720Y);
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return sb.toString();
    }

    /* renamed from: Z */
    private static boolean m55719Z(double d, double d2, double d3, double d4, double d5, double d6) {
        return Math.abs(m55718a(d, d2, d3, d4, d5, d6)) < 1.0E-9d && (d - d3) * (d - d5) <= Utils.DOUBLE_EPSILON && (d2 - d4) * (d2 - d6) <= Utils.DOUBLE_EPSILON;
    }

    /* renamed from: a */
    private static double m55718a(double d, double d2, double d3, double d4, double d5, double d6) {
        return ((d3 - d) * (d6 - d2)) - ((d5 - d) * (d4 - d2));
    }

    /* renamed from: a0 */
    private static boolean m55717a0(List<LatLng> list, CircleHoleOptions circleHoleOptions) {
        int i;
        try {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                arrayList.add(list.get(i2));
            }
            arrayList.add(list.get(0));
            ArrayList arrayList2 = new ArrayList();
            int i3 = 0;
            while (i3 < arrayList.size() && (i = i3 + 1) < arrayList.size()) {
                if (circleHoleOptions.getRadius() < AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) arrayList.get(i3)) && circleHoleOptions.getRadius() < AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) arrayList.get(i))) {
                    arrayList2.clear();
                    arrayList2.add(arrayList.get(i3));
                    arrayList2.add(arrayList.get(i));
                    if (circleHoleOptions.getRadius() >= ((double) AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) SpatialRelationUtil.calShortestDistancePoint(arrayList2, circleHoleOptions.getCenter()).second))) {
                        return true;
                    }
                    i3 = i;
                }
                return true;
            }
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "Util", "isPolygon2CircleIntersect");
            th.printStackTrace();
        }
        return false;
    }

    /* renamed from: b */
    private static double m55716b(float f, double d, double d2) {
        double d3 = f;
        Double.isNaN(d3);
        return 20.0d - (Math.log(d2 / (d * d3)) / Math.log(2.0d));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b0 */
    public static boolean m55715b0(List<LatLng> list, PolygonHoleOptions polygonHoleOptions) {
        int i = 0;
        if (list == null || polygonHoleOptions == null) {
            return false;
        }
        try {
            List<LatLng> points = polygonHoleOptions.getPoints();
            boolean z = 0;
            while (i < points.size()) {
                try {
                    boolean m55732M = m55732M(points.get(i), list);
                    if (!m55732M) {
                        return m55732M;
                    }
                    i++;
                    z = m55732M;
                } catch (Throwable th) {
                    th = th;
                    i = z;
                    SDKLogHandler.m53863p(th, "PolygonDelegateImp", "isPolygonInPolygon");
                    th.printStackTrace();
                    return i;
                }
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: c */
    private static float m55714c(float f, float f2, double d) {
        double pow = Math.pow(2.0d, 20.0f - f2);
        double d2 = f;
        Double.isNaN(d2);
        return (float) (d / (pow * d2));
    }

    /* renamed from: c0 */
    private static boolean m55713c0(List<LatLng> list, List<LatLng> list2) {
        int i;
        int i2;
        int i3 = 0;
        while (i3 < list.size() && (i = i3 + 1) < list.size()) {
            try {
                int i4 = 0;
                while (i4 < list2.size() && (i2 = i4 + 1) < list2.size()) {
                    boolean m53664b = SegmentsIntersect.m53664b(list.get(i3), list.get(i), list2.get(i4), list2.get(i2));
                    if (m53664b) {
                        return m53664b;
                    }
                    i4 = i2;
                }
                i3 = i;
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "Util", "isSegmentsIntersect");
                th.printStackTrace();
            }
        }
        return false;
    }

    /* renamed from: d */
    private static float m55712d(float f, float f2, float f3) {
        double d = f3;
        double pow = Math.pow(2.0d, 20.0f - f2);
        Double.isNaN(d);
        double d2 = f;
        Double.isNaN(d2);
        return (float) (d * pow * d2);
    }

    /* renamed from: d0 */
    private static byte[] m55711d0(Bitmap bitmap) {
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

    /* renamed from: e */
    public static float m55710e(IGLMapState iGLMapState, int i, int i2, double d, double d2, int i3) {
        IPoint obtain = IPoint.obtain();
        VirtualEarthProjection.latLongToPixels(d, d2, 20, obtain);
        float m55708f = m55708f(iGLMapState, i, i2, ((Point) obtain).x, ((Point) obtain).y, i3);
        obtain.recycle();
        return m55708f;
    }

    /* renamed from: e0 */
    private static byte[] m55709e0(InputStream inputStream) throws IOException {
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

    /* renamed from: f */
    private static float m55708f(IGLMapState iGLMapState, int i, int i2, int i3, int i4, int i5) {
        if (iGLMapState != null) {
            return iGLMapState.calculateMapZoomer(i, i2, i3, i4, i5);
        }
        return 3.0f;
    }

    /* renamed from: f0 */
    public static String m55707f0(Context context) {
        String m55688v = m55688v(context);
        if (m55688v == null) {
            return null;
        }
        File file = new File(m55688v, "VMAP2");
        if (!file.exists()) {
            file.mkdir();
        }
        return file.toString() + File.separator;
    }

    /* renamed from: g */
    public static float m55706g(DPoint dPoint, DPoint dPoint2) {
        if (dPoint == null || dPoint2 == null) {
            return 0.0f;
        }
        double d = dPoint.f7977x;
        double d2 = dPoint2.f7977x;
        return (float) ((Math.atan2(dPoint2.f7978y - dPoint.f7978y, d2 - d) / 3.141592653589793d) * 180.0d);
    }

    /* renamed from: g0 */
    private static void m55705g0(View view) {
        int i = 0;
        if (!(view instanceof ViewGroup)) {
            if (view instanceof TextView) {
                ((TextView) view).setHorizontallyScrolling(false);
                return;
            }
            return;
        }
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return;
            }
            m55705g0(viewGroup.getChildAt(i));
            i++;
        }
    }

    /* renamed from: h */
    public static float m55704h(IMapConfig iMapConfig, float f) {
        if (iMapConfig != null) {
            if (f > iMapConfig.getMaxZoomLevel()) {
                return iMapConfig.getMaxZoomLevel();
            }
            return f < iMapConfig.getMinZoomLevel() ? iMapConfig.getMinZoomLevel() : f;
        } else if (f > 20.0f) {
            return 20.0f;
        } else {
            if (f < 3.0f) {
                return 3.0f;
            }
            return f;
        }
    }

    /* renamed from: h0 */
    public static boolean m55703h0(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        return (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || (state = activeNetworkInfo.getState()) == null || state == NetworkInfo.State.DISCONNECTED || state == NetworkInfo.State.DISCONNECTING) ? false : true;
    }

    /* renamed from: i */
    public static float m55702i(IMapConfig iMapConfig, float f, float f2) {
        boolean z;
        if (iMapConfig != null) {
            boolean isAbroadEnable = iMapConfig.isAbroadEnable();
            z = iMapConfig.getAbroadState() != 1;
            r0 = isAbroadEnable;
        } else {
            z = false;
        }
        float f3 = f >= 0.0f ? f : 0.0f;
        if (r0 && z) {
            if (f3 > 40.0f) {
                return 40.0f;
            }
            return f3;
        } else if (iMapConfig != null && iMapConfig.isTerrainEnable()) {
            if (f3 > 80.0f) {
                return 80.0f;
            }
            return f3;
        } else if (f > 40.0f) {
            float f4 = f2 <= 15.0f ? 40 : f2 <= 16.0f ? 56 : f2 <= 17.0f ? 66 : f2 <= 18.0f ? 74 : f2 <= 18.0f ? 78 : 80;
            return f3 > f4 ? f4 : f3;
        } else {
            return f3;
        }
    }

    /* renamed from: i0 */
    public static boolean m55701i0(Context context) {
        File file = new File(m55721X(context));
        if (file.exists()) {
            return FileUtil.deleteFile(file);
        }
        return true;
    }

    /* renamed from: j */
    public static float m55700j(IMapConfig iMapConfig, int i, int i2, int i3, int i4, int i5, int i6) {
        float sz = iMapConfig.getSZ();
        if (i == i3 || i2 == i4) {
            return sz;
        }
        return Math.max((float) m55716b(iMapConfig.getMapZoomScale(), i5, Math.abs(i3 - i)), (float) m55716b(iMapConfig.getMapZoomScale(), i6, Math.abs(i4 - i2)));
    }

    /* renamed from: k */
    public static int m55699k(Object[] objArr) {
        return Arrays.hashCode(objArr);
    }

    /* renamed from: l */
    public static Bitmap m55698l(Context context, String str) {
        try {
            InputStream open = ResourcesUtil.m53805b(context).open(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(open);
            open.close();
            return decodeStream;
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "Util", "fromAsset");
            m55741D(th);
            return null;
        }
    }

    /* renamed from: m */
    public static Bitmap m55697m(Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        return Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * f), (int) (bitmap.getHeight() * f), true);
    }

    /* renamed from: n */
    public static Bitmap m55696n(View view) {
        try {
            m55705g0(view);
            view.destroyDrawingCache();
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                return drawingCache.copy(Bitmap.Config.ARGB_8888, false);
            }
            return null;
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "Utils", "getBitmapFromView");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: o */
    public static Bitmap m55695o(int[] iArr, int i, int i2) {
        return m55694p(iArr, i, i2, false);
    }

    /* renamed from: p */
    public static Bitmap m55694p(int[] iArr, int i, int i2, boolean z) {
        try {
            int[] iArr2 = new int[iArr.length];
            for (int i3 = 0; i3 < i2; i3++) {
                for (int i4 = 0; i4 < i; i4++) {
                    int i5 = (i3 * i) + i4;
                    int i6 = iArr[i5];
                    int i7 = (i6 & (-16711936)) | ((i6 << 16) & 16711680) | ((i6 >> 16) & 255);
                    if (z) {
                        iArr2[(((i2 - i3) - 1) * i) + i4] = i7;
                    } else {
                        iArr2[i5] = i7;
                    }
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr2, 0, i, 0, 0, i, i2);
            return createBitmap;
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "Util", "rgbaToArgb");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: q */
    public static Pair<Float, IPoint> m55693q(AbstractCameraUpdateMessage abstractCameraUpdateMessage, IMapConfig iMapConfig) {
        return m55692r(iMapConfig, Math.max(abstractCameraUpdateMessage.paddingLeft, 1), Math.max(abstractCameraUpdateMessage.paddingRight, 1), Math.max(abstractCameraUpdateMessage.paddingTop, 1), Math.max(abstractCameraUpdateMessage.paddingBottom, 1), abstractCameraUpdateMessage.bounds, abstractCameraUpdateMessage.width, abstractCameraUpdateMessage.height);
    }

    /* renamed from: r */
    public static Pair<Float, IPoint> m55692r(IMapConfig iMapConfig, int i, int i2, int i3, int i4, LatLngBounds latLngBounds, int i5, int i6) {
        LatLng latLng;
        int i7;
        float f;
        float f2;
        int i8;
        if (latLngBounds == null || (latLng = latLngBounds.northeast) == null || latLngBounds.southwest == null || iMapConfig == null) {
            return null;
        }
        Point latLongToPixels = VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20);
        LatLng latLng2 = latLngBounds.southwest;
        Point latLongToPixels2 = VirtualEarthProjection.latLongToPixels(latLng2.latitude, latLng2.longitude, 20);
        int i9 = latLongToPixels.x;
        int i10 = latLongToPixels2.x;
        int i11 = i9 - i10;
        int i12 = latLongToPixels2.y;
        int i13 = latLongToPixels.y;
        int i14 = i12 - i13;
        int i15 = i5 - (i + i2);
        int i16 = i6 - (i3 + i4);
        if (i11 >= 0 || i14 >= 0) {
            if (i11 <= 0) {
                i11 = 1;
            }
            int i17 = i14 <= 0 ? 1 : i14;
            if (i15 <= 0) {
                i15 = 1;
            }
            if (i16 <= 0) {
                i16 = 1;
            }
            Pair<Float, Boolean> m55722W = m55722W(iMapConfig, i9, i13, i10, i12, i15, i16);
            float floatValue = ((Float) m55722W.first).floatValue();
            boolean booleanValue = ((Boolean) m55722W.second).booleanValue();
            float m55714c = m55714c(iMapConfig.getMapZoomScale(), floatValue, i11);
            float m55714c2 = m55714c(iMapConfig.getMapZoomScale(), floatValue, i17);
            if (floatValue >= iMapConfig.getMaxZoomLevel()) {
                i7 = (int) (latLongToPixels2.x + ((((i2 - i) + m55714c) * i11) / (m55714c * 2.0f)));
                i8 = latLongToPixels.y;
            } else if (booleanValue) {
                i7 = (int) (latLongToPixels2.x + ((((i5 / 2) - i) / m55714c) * i11));
                i8 = latLongToPixels.y;
            } else {
                i7 = (int) (latLongToPixels2.x + ((((i2 - i) + m55714c) * i11) / (m55714c * 2.0f)));
                f = latLongToPixels.y;
                f2 = (((i6 / 2) - i3) / m55714c2) * i17;
                return new Pair<>(Float.valueOf(floatValue), IPoint.obtain((int) (i7 + m55712d(iMapConfig.getMapZoomScale(), floatValue, iMapConfig.getAnchorX() - (iMapConfig.getMapWidth() >> 1))), (int) (((int) (f + f2)) + m55712d(iMapConfig.getMapZoomScale(), floatValue, iMapConfig.getAnchorY() - (iMapConfig.getMapHeight() >> 1)))));
            }
            f = i8;
            f2 = (((i4 - i3) + m55714c2) * i17) / (m55714c2 * 2.0f);
            return new Pair<>(Float.valueOf(floatValue), IPoint.obtain((int) (i7 + m55712d(iMapConfig.getMapZoomScale(), floatValue, iMapConfig.getAnchorX() - (iMapConfig.getMapWidth() >> 1))), (int) (((int) (f + f2)) + m55712d(iMapConfig.getMapZoomScale(), floatValue, iMapConfig.getAnchorY() - (iMapConfig.getMapHeight() >> 1)))));
        }
        return null;
    }

    /* renamed from: s */
    public static SDKInfo m55691s() {
        try {
            if (ConfigableConst.f3945e == null) {
                ConfigableConst.f3945e = new SDKInfo.C1869a("3dmap", "10.0.600", ConfigableConst.f3943c).m54390b(new String[]{"com.amap.api.maps", "com.amap.api.mapcore", "com.autonavi.amap.mapcore", "com.autonavi.amap", "com.autonavi.ae", "com.autonavi.base", "com.autonavi.patch", "com.amap.api.3dmap.admic", "com.amap.api.trace", "com.amap.api.trace.core"}).m54391a("10.0.600").m54389c();
            }
            return ConfigableConst.f3945e;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: t */
    public static DPoint m55690t(LatLng latLng) {
        double sin = Math.sin(Math.toRadians(latLng.latitude));
        return DPoint.obtain(((latLng.longitude / 360.0d) + 0.5d) * 1.0d, (((Math.log((sin + 1.0d) / (1.0d - sin)) * 0.5d) / (-6.283185307179586d)) + 0.5d) * 1.0d);
    }

    /* renamed from: u */
    public static String m55689u(int i) {
        if (i < 1000) {
            return i + "m";
        }
        return (i / 1000) + "km";
    }

    /* renamed from: v */
    public static String m55688v(Context context) {
        File file = new File(FileUtil.getMapBaseStorage(context), AeUtil.ROOT_DATA_PATH_NAME);
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
    /* JADX WARN: Removed duplicated region for block: B:103:0x00de A[Catch: IOException -> 0x00e2, TRY_ENTER, TRY_LEAVE, TryCatch #19 {IOException -> 0x00e2, blocks: (B:103:0x00de, B:94:0x00cd), top: B:118:0x00bf }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m55687w(java.io.File r7) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.C1732a3.m55687w(java.io.File):java.lang.String");
    }

    /* renamed from: x */
    public static String m55686x(InputStream inputStream) {
        try {
            return new String(m55709e0(inputStream), "utf-8");
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "Util", "decodeAssetResData");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: y */
    public static String m55685y(String str) {
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

    /* renamed from: z */
    public static String m55684z(String str, Object obj) {
        return str + "=" + String.valueOf(obj);
    }
}
