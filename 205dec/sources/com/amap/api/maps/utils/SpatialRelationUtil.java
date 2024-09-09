package com.amap.api.maps.utils;

import android.util.Pair;
import com.amap.api.col.p0003l.a3;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.DPoint;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class SpatialRelationUtil {
    public static final int A_CIRCLE_DEGREE = 360;
    public static final int A_HALF_CIRCLE_DEGREE = 180;
    public static final int MIN_OFFSET_DEGREE = 50;
    public static final int MIN_POLYLINE_POINT_SIZE = 2;

    public static Pair<Integer, LatLng> calShortestDistancePoint(List<LatLng> list, LatLng latLng, float f4, double d4) {
        if (list != null && latLng != null) {
            try {
                if (list.size() != 0) {
                    ArrayList arrayList = new ArrayList();
                    int i4 = 0;
                    for (LatLng latLng2 : list) {
                        arrayList.add(DPoint.obtain(latLng2.latitude, latLng2.longitude));
                        if (latLng2.equals(latLng)) {
                            return new Pair<>(Integer.valueOf(i4), latLng);
                        }
                        i4++;
                    }
                    Pair<Integer, DPoint> calShortestDistancePoint = calShortestDistancePoint(arrayList, DPoint.obtain(latLng.latitude, latLng.longitude), f4);
                    if (calShortestDistancePoint != null) {
                        DPoint dPoint = (DPoint) calShortestDistancePoint.second;
                        if (AMapUtils.calculateLineDistance(new LatLng(dPoint.f11671x, dPoint.f11672y), latLng) < d4) {
                            Object obj = calShortestDistancePoint.first;
                            Object obj2 = calShortestDistancePoint.second;
                            return new Pair<>(obj, new LatLng(((DPoint) obj2).f11671x, ((DPoint) obj2).f11672y));
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    private static boolean checkRotateIsMatch(DPoint dPoint, DPoint dPoint2, float f4) {
        if (f4 == -1.0f) {
            return true;
        }
        if (dPoint != null && dPoint2 != null) {
            float abs = Math.abs((a3.g(dPoint, dPoint2) + 360.0f) - f4) % 360.0f;
            if (abs > 180.0f) {
                abs = 360.0f - abs;
            }
            if (abs < 50.0f) {
                return true;
            }
        }
        return false;
    }

    private static Pair<Double, DPoint> pointToSegDist(double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d8 - d6;
        double d11 = d4 - d6;
        double d12 = d9 - d7;
        double d13 = d5 - d7;
        double d14 = (d10 * d11) + (d12 * d13);
        if (d14 <= 0.0d) {
            return new Pair<>(Double.valueOf(Math.sqrt((d11 * d11) + (d13 * d13))), new DPoint(d6, d7));
        }
        double d15 = (d10 * d10) + (d12 * d12);
        if (d14 >= d15) {
            double d16 = d4 - d8;
            double d17 = d5 - d9;
            return new Pair<>(Double.valueOf(Math.sqrt((d16 * d16) + (d17 * d17))), new DPoint(d8, d9));
        }
        double d18 = d14 / d15;
        double d19 = d6 + (d10 * d18);
        double d20 = d7 + (d12 * d18);
        double d21 = d4 - d19;
        double d22 = d20 - d5;
        return new Pair<>(Double.valueOf(Math.sqrt((d21 * d21) + (d22 * d22))), new DPoint(d19, d20));
    }

    public static Pair<Integer, LatLng> calShortestDistancePoint(List<LatLng> list, LatLng latLng) {
        if (list != null && latLng != null) {
            try {
                if (list.size() != 0) {
                    ArrayList arrayList = new ArrayList();
                    int i4 = 0;
                    for (LatLng latLng2 : list) {
                        arrayList.add(DPoint.obtain(latLng2.latitude, latLng2.longitude));
                        if (latLng2.equals(latLng)) {
                            return new Pair<>(Integer.valueOf(i4), latLng);
                        }
                        i4++;
                    }
                    Pair<Integer, DPoint> calShortestDistancePoint = calShortestDistancePoint(arrayList, DPoint.obtain(latLng.latitude, latLng.longitude));
                    if (calShortestDistancePoint != null) {
                        Object obj = calShortestDistancePoint.first;
                        Object obj2 = calShortestDistancePoint.second;
                        return new Pair<>(obj, new LatLng(((DPoint) obj2).f11671x, ((DPoint) obj2).f11672y));
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static Pair<Integer, DPoint> calShortestDistancePoint(List<DPoint> list, DPoint dPoint) {
        return calShortestDistancePoint(list, dPoint, -1.0f);
    }

    public static Pair<Integer, DPoint> calShortestDistancePoint(List<DPoint> list, DPoint dPoint, float f4) {
        double d4;
        int i4;
        int i5;
        double doubleValue;
        Pair<Integer, DPoint> pair;
        List<DPoint> list2 = list;
        DPoint dPoint2 = dPoint;
        Pair<Integer, DPoint> pair2 = null;
        if (list2 != null && dPoint2 != null && list.size() != 0) {
            if (list.size() >= 2) {
                DPoint dPoint3 = list2.get(0);
                double d5 = 0.0d;
                int size = list.size();
                int i6 = 1;
                int i7 = 1;
                while (true) {
                    int i8 = size - 1;
                    if (i7 > i8) {
                        break;
                    }
                    DPoint dPoint4 = list2.get(i7);
                    if (i7 == i8 && dPoint4.equals(dPoint2)) {
                        return new Pair<>(Integer.valueOf(i7), dPoint2);
                    }
                    if (!checkRotateIsMatch(dPoint3, dPoint4, f4)) {
                        d4 = d5;
                        i4 = size;
                        i5 = i7;
                    } else if (dPoint3.equals(dPoint2)) {
                        return new Pair<>(Integer.valueOf(i7 - i6), dPoint2);
                    } else {
                        i5 = i7;
                        d4 = d5;
                        i4 = size;
                        Pair<Double, DPoint> pointToSegDist = pointToSegDist(dPoint2.f11671x, dPoint2.f11672y, dPoint3.f11671x, dPoint3.f11672y, dPoint4.f11671x, dPoint4.f11672y);
                        if (pair2 == null) {
                            doubleValue = ((Double) pointToSegDist.first).doubleValue();
                            pair = new Pair<>(Integer.valueOf(i5 - 1), pointToSegDist.second);
                        } else if (d4 > ((Double) pointToSegDist.first).doubleValue()) {
                            doubleValue = ((Double) pointToSegDist.first).doubleValue();
                            pair = new Pair<>(Integer.valueOf(i5 - 1), pointToSegDist.second);
                        }
                        d5 = doubleValue;
                        pair2 = pair;
                        i7 = i5 + 1;
                        list2 = list;
                        dPoint2 = dPoint;
                        dPoint3 = dPoint4;
                        size = i4;
                        i6 = 1;
                    }
                    d5 = d4;
                    i7 = i5 + 1;
                    list2 = list;
                    dPoint2 = dPoint;
                    dPoint3 = dPoint4;
                    size = i4;
                    i6 = 1;
                }
            } else {
                return null;
            }
        }
        return pair2;
    }
}
