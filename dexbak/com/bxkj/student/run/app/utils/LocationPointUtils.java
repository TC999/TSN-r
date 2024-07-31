package com.bxkj.student.run.app.utils;

import android.util.Log;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.bxkj.student.run.app.location.LatLngTimeSpeed;
import com.github.mikephil.charting.utils.Utils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bxkj.student.run.app.utils.l */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class LocationPointUtils {
    /* renamed from: a */
    public static List<LatLngTimeSpeed> m39608a(List<LatLngTimeSpeed> latLngTimeSpeedList) {
        double floatValue;
        double d = Utils.DOUBLE_EPSILON;
        BigDecimal bigDecimal = new BigDecimal((double) Utils.DOUBLE_EPSILON);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        for (int i2 = 1; i2 < latLngTimeSpeedList.size(); i2++) {
            LatLngTimeSpeed latLngTimeSpeed = latLngTimeSpeedList.get(i2 - 1);
            arrayList2.add(latLngTimeSpeed);
            LatLngTimeSpeed latLngTimeSpeed2 = latLngTimeSpeedList.get(i2);
            double calculateLineDistance = AMapUtils.calculateLineDistance(new LatLng(latLngTimeSpeed.getLatitude(), latLngTimeSpeed.getLongitude()), new LatLng(latLngTimeSpeed2.getLatitude(), latLngTimeSpeed2.getLongitude()));
            arrayList.add(Double.valueOf(calculateLineDistance));
            Log.d("standardDeviation", "距离=" + calculateLineDistance);
            Log.d("standardDeviation", "速度=" + latLngTimeSpeed2.getSpeed());
            if (i2 > 5) {
                if (calculateLineDistance <= m39607b(arrayList.subList(i2 - 5, i2)) * 3.0d) {
                    arrayList2.add(latLngTimeSpeed2);
                    floatValue = bigDecimal.add(new BigDecimal(calculateLineDistance)).floatValue();
                    Double.isNaN(floatValue);
                } else {
                    i++;
                }
            } else {
                arrayList2.add(latLngTimeSpeed2);
                floatValue = bigDecimal.add(new BigDecimal(calculateLineDistance)).floatValue();
                Double.isNaN(floatValue);
            }
            d += floatValue;
        }
        Log.d("standardDeviation", "共舍弃点" + i);
        Log.d("standardDeviation", "计算后距离=" + FormatUtils.m39633d(d));
        return arrayList2;
    }

    /* renamed from: b */
    private static double m39607b(List<Double> distanceList) {
        double d = Utils.DOUBLE_EPSILON;
        for (Double d2 : distanceList) {
            d += d2.doubleValue();
        }
        double size = distanceList.size();
        Double.isNaN(size);
        double d3 = d / size;
        Log.d("getAvgDistance", "平均距离=" + d3);
        return d3;
    }

    /* renamed from: c */
    public static double m39606c(Double[] x) {
        int length = x.length;
        double d = Utils.DOUBLE_EPSILON;
        double d2 = 0.0d;
        for (Double d3 : x) {
            d2 += d3.doubleValue();
        }
        double d4 = length;
        Double.isNaN(d4);
        double d5 = d2 / d4;
        for (Double d6 : x) {
            double doubleValue = d6.doubleValue() - d5;
            d += doubleValue * doubleValue;
        }
        Double.isNaN(d4);
        return Math.sqrt(d / d4);
    }

    /* renamed from: d */
    public static double m39605d(double[] x) {
        int length = x.length;
        double d = Utils.DOUBLE_EPSILON;
        double d2 = 0.0d;
        for (double d3 : x) {
            d2 += d3;
        }
        double d4 = length;
        Double.isNaN(d4);
        double d5 = d2 / d4;
        for (double d6 : x) {
            double d7 = d6 - d5;
            d += d7 * d7;
        }
        Double.isNaN(d4);
        return d / d4;
    }
}
