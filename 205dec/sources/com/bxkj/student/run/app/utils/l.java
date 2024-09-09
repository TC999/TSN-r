package com.bxkj.student.run.app.utils;

import android.util.Log;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.bxkj.student.run.app.location.LatLngTimeSpeed;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: LocationPointUtils.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class l {
    public static List<LatLngTimeSpeed> a(List<LatLngTimeSpeed> latLngTimeSpeedList) {
        double floatValue;
        double d4 = 0.0d;
        BigDecimal bigDecimal = new BigDecimal(0.0d);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i4 = 0;
        for (int i5 = 1; i5 < latLngTimeSpeedList.size(); i5++) {
            LatLngTimeSpeed latLngTimeSpeed = latLngTimeSpeedList.get(i5 - 1);
            arrayList2.add(latLngTimeSpeed);
            LatLngTimeSpeed latLngTimeSpeed2 = latLngTimeSpeedList.get(i5);
            double calculateLineDistance = AMapUtils.calculateLineDistance(new LatLng(latLngTimeSpeed.getLatitude(), latLngTimeSpeed.getLongitude()), new LatLng(latLngTimeSpeed2.getLatitude(), latLngTimeSpeed2.getLongitude()));
            arrayList.add(Double.valueOf(calculateLineDistance));
            Log.d("standardDeviation", "\u8ddd\u79bb=" + calculateLineDistance);
            Log.d("standardDeviation", "\u901f\u5ea6=" + latLngTimeSpeed2.getSpeed());
            if (i5 > 5) {
                if (calculateLineDistance <= b(arrayList.subList(i5 - 5, i5)) * 3.0d) {
                    arrayList2.add(latLngTimeSpeed2);
                    floatValue = bigDecimal.add(new BigDecimal(calculateLineDistance)).floatValue();
                    Double.isNaN(floatValue);
                } else {
                    i4++;
                }
            } else {
                arrayList2.add(latLngTimeSpeed2);
                floatValue = bigDecimal.add(new BigDecimal(calculateLineDistance)).floatValue();
                Double.isNaN(floatValue);
            }
            d4 += floatValue;
        }
        Log.d("standardDeviation", "\u5171\u820d\u5f03\u70b9" + i4);
        Log.d("standardDeviation", "\u8ba1\u7b97\u540e\u8ddd\u79bb=" + i.d(d4));
        return arrayList2;
    }

    private static double b(List<Double> distanceList) {
        double d4 = 0.0d;
        for (Double d5 : distanceList) {
            d4 += d5.doubleValue();
        }
        double size = distanceList.size();
        Double.isNaN(size);
        double d6 = d4 / size;
        Log.d("getAvgDistance", "\u5e73\u5747\u8ddd\u79bb=" + d6);
        return d6;
    }

    public static double c(Double[] x3) {
        int length = x3.length;
        double d4 = 0.0d;
        double d5 = 0.0d;
        for (Double d6 : x3) {
            d5 += d6.doubleValue();
        }
        double d7 = length;
        Double.isNaN(d7);
        double d8 = d5 / d7;
        for (Double d9 : x3) {
            double doubleValue = d9.doubleValue() - d8;
            d4 += doubleValue * doubleValue;
        }
        Double.isNaN(d7);
        return Math.sqrt(d4 / d7);
    }

    public static double d(double[] x3) {
        int length = x3.length;
        double d4 = 0.0d;
        double d5 = 0.0d;
        for (double d6 : x3) {
            d5 += d6;
        }
        double d7 = length;
        Double.isNaN(d7);
        double d8 = d5 / d7;
        for (double d9 : x3) {
            double d10 = d9 - d8;
            d4 += d10 * d10;
        }
        Double.isNaN(d7);
        return d4 / d7;
    }
}
