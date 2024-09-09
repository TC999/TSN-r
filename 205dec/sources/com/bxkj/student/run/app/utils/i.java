package com.bxkj.student.run.app.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.amap.api.location.AMapLocation;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.bxkj.student.run.app.ready.RunType;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: FormatUtils.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static SimpleDateFormat f22822a;

    /* renamed from: b  reason: collision with root package name */
    private static List<LatLng> f22823b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private static LatLng f22824c = new LatLng(0.0d, 0.0d);

    public static String a(double distance, long time) {
        double d4 = distance / 1000.0d;
        double d5 = time;
        Double.isNaN(d5);
        double d6 = d5 / 3600.0d;
        if (d4 > 0.0d) {
            return new DecimalFormat("0.00").format(d4 / d6);
        }
        return "0.0";
    }

    public static String b(double distance, long time) {
        double round = Math.round((distance / 1000.0d) * 100.0d);
        Double.isNaN(round);
        double d4 = round / 100.0d;
        if (d4 > 0.0d) {
            double d5 = time;
            Double.isNaN(d5);
            return f((int) (d5 / d4));
        }
        return "0'0\"";
    }

    public static String c(double distance) {
        return com.bxkj.base.v2.common.utils.e.f18604a.a(distance / 1000.0d);
    }

    public static String d(double distance) {
        return com.bxkj.base.v2.common.utils.e.f18604a.b(distance / 1000.0d);
    }

    public static double e(double distance) {
        return new BigDecimal(distance).divide(new BigDecimal(1000), 2, RoundingMode.FLOOR).doubleValue();
    }

    private static String f(int peiSuSecond) {
        StringBuilder sb;
        String str;
        int i4 = peiSuSecond % 3600;
        int i5 = i4 / 60;
        if (i5 > 9) {
            sb = new StringBuilder();
            sb.append(i5);
            sb.append("");
        } else {
            sb = new StringBuilder();
            sb.append("0");
            sb.append(i5);
        }
        String sb2 = sb.toString();
        int i6 = i4 % 60;
        if (i6 > 9) {
            str = i6 + "";
        } else {
            str = "0" + i6;
        }
        return sb2 + "'" + str + "\"";
    }

    public static String g(long recordingTime) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        long j4 = recordingTime / 3600;
        if (j4 > 9) {
            sb = new StringBuilder();
            sb.append(j4);
            sb.append("");
        } else {
            sb = new StringBuilder();
            sb.append("0");
            sb.append(j4);
        }
        String sb4 = sb.toString();
        long j5 = recordingTime % 3600;
        long j6 = j5 / 60;
        if (j6 > 9) {
            sb2 = new StringBuilder();
            sb2.append(j6);
            sb2.append("");
        } else {
            sb2 = new StringBuilder();
            sb2.append("0");
            sb2.append(j6);
        }
        String sb5 = sb2.toString();
        long j7 = j5 % 60;
        if (j7 > 9) {
            sb3 = new StringBuilder();
            sb3.append(j7);
            sb3.append("");
        } else {
            sb3 = new StringBuilder();
            sb3.append("0");
            sb3.append(j7);
        }
        String sb6 = sb3.toString();
        return sb4 + ":" + sb5 + ":" + sb6;
    }

    public static String h(long l4, String strPattern) {
        if (TextUtils.isEmpty(strPattern)) {
            strPattern = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat = f22822a;
        if (simpleDateFormat == null) {
            try {
                f22822a = new SimpleDateFormat(strPattern, Locale.CHINA);
            } catch (Throwable unused) {
            }
        } else {
            simpleDateFormat.applyPattern(strPattern);
        }
        SimpleDateFormat simpleDateFormat2 = f22822a;
        return simpleDateFormat2 == null ? "NULL" : simpleDateFormat2.format(Long.valueOf(l4));
    }

    public static String i(long l4) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM", Locale.CHINA);
        f22822a = simpleDateFormat;
        return simpleDateFormat.format(Long.valueOf(l4));
    }

    public static String j(int statusCode, int gpsAccuracyStatus) {
        return statusCode != 0 ? statusCode != 1 ? statusCode != 2 ? statusCode != 3 ? statusCode != 4 ? "GPS\u72b6\u6001\u672a\u77e5" : "\u6ca1\u6709GPS\u5b9a\u4f4d\u6743\u9650\uff0c\u5efa\u8bae\u5f00\u542fgps\u5b9a\u4f4d\u6743\u9650" : "\u9009\u62e9\u7684\u5b9a\u4f4d\u6a21\u5f0f\u4e2d\u4e0d\u5305\u542bGPS\u5b9a\u4f4d\uff0c\u5efa\u8bae\u9009\u62e9\u5305\u542bGPS\u5b9a\u4f4d\u7684\u6a21\u5f0f\uff0c\u63d0\u9ad8\u5b9a\u4f4d\u8d28\u91cf" : "GPS\u5173\u95ed\uff0c\u5efa\u8bae\u5f00\u542fGPS\uff0c\u63d0\u9ad8\u5b9a\u4f4d\u8d28\u91cf" : "\u624b\u673a\u4e2d\u6ca1\u6709GPS Provider\uff0c\u65e0\u6cd5\u8fdb\u884cGPS\u5b9a\u4f4d" : gpsAccuracyStatus != -1 ? gpsAccuracyStatus != 0 ? gpsAccuracyStatus != 1 ? "GPS\u72b6\u6001\u6b63\u5e38" : "GPS\u4fe1\u53f7\u826f\u597d\uff0c\u8bf7\u5c3d\u60c5\u8dd1\u6b65" : "GPS\u4fe1\u53f7\u5f31\uff0c\u8bf7\u5728\u7a7a\u65f7\u7684\u5730\u65b9\u8dd1\u6b65" : "GPS\u4fe1\u53f7\u672a\u77e5\uff0c\u6b63\u5728\u641c\u5bfb\u00b7\u00b7\u00b7";
    }

    public static int k(int statusCode) {
        if (statusCode != 0) {
            return statusCode != 1 ? 2131558607 : 2131558604;
        }
        return 2131558603;
    }

    public static int l(int gpsQualityReportStatusCode, int gpsAccuracyStatus) {
        if (gpsQualityReportStatusCode != 0) {
            return (gpsQualityReportStatusCode == 1 || gpsQualityReportStatusCode == 2) ? 2131558607 : 2131558607;
        } else if (gpsAccuracyStatus != -1) {
            if (gpsAccuracyStatus != 0) {
                return gpsAccuracyStatus != 1 ? 2131558607 : 2131558604;
            }
            return 2131558603;
        } else {
            return 2131558607;
        }
    }

    public static String m(int statusCode) {
        return statusCode != 0 ? statusCode != 1 ? statusCode != 2 ? statusCode != 3 ? statusCode != 4 ? "" : "\u6ca1\u6709GPS\u5b9a\u4f4d\u6743\u9650\uff0c\u5efa\u8bae\u5f00\u542fgps\u5b9a\u4f4d\u6743\u9650" : "\u9009\u62e9\u7684\u5b9a\u4f4d\u6a21\u5f0f\u4e2d\u4e0d\u5305\u542bGPS\u5b9a\u4f4d\uff0c\u5efa\u8bae\u9009\u62e9\u5305\u542bGPS\u5b9a\u4f4d\u7684\u6a21\u5f0f\uff0c\u63d0\u9ad8\u5b9a\u4f4d\u8d28\u91cf" : "GPS\u5173\u95ed\uff0c\u5efa\u8bae\u5f00\u542fGPS\uff0c\u63d0\u9ad8\u5b9a\u4f4d\u8d28\u91cf" : "\u624b\u673a\u4e2d\u6ca1\u6709GPS Provider\uff0c\u65e0\u6cd5\u8fdb\u884cGPS\u5b9a\u4f4d" : "GPS\u72b6\u6001\u6b63\u5e38";
    }

    public static String n(int gpsQualityReportStatusCode, int gpsAccuracyStatus) {
        return gpsQualityReportStatusCode != 0 ? gpsQualityReportStatusCode != 1 ? gpsQualityReportStatusCode != 2 ? gpsQualityReportStatusCode != 3 ? gpsQualityReportStatusCode != 4 ? "" : "\u6ca1\u6709GPS\u5b9a\u4f4d\u6743\u9650\uff0c\u5efa\u8bae\u5f00\u542fgps\u5b9a\u4f4d\u6743\u9650" : "\u9009\u62e9\u7684\u5b9a\u4f4d\u6a21\u5f0f\u4e2d\u4e0d\u5305\u542bGPS\u5b9a\u4f4d\uff0c\u5efa\u8bae\u9009\u62e9\u5305\u542bGPS\u5b9a\u4f4d\u7684\u6a21\u5f0f\uff0c\u63d0\u9ad8\u5b9a\u4f4d\u8d28\u91cf" : "GPS\u5173\u95ed\uff0c\u5efa\u8bae\u5f00\u542fGPS\uff0c\u63d0\u9ad8\u5b9a\u4f4d\u8d28\u91cf" : "\u624b\u673a\u4e2d\u6ca1\u6709GPS Provider\uff0c\u65e0\u6cd5\u8fdb\u884cGPS\u5b9a\u4f4d" : gpsAccuracyStatus != -1 ? gpsAccuracyStatus != 0 ? gpsAccuracyStatus != 1 ? "GPS\u72b6\u6001\u6b63\u5e38" : "GPS\u4fe1\u53f7\u826f\u597d\uff0c\u8bf7\u5c3d\u60c5\u8dd1\u6b65" : "GPS\u4fe1\u53f7\u5f31\uff0c\u8bf7\u5728\u7a7a\u65f7\u7684\u5730\u65b9\u8dd1\u6b65" : "GPS\u4fe1\u53f7\u672a\u77e5\uff0c\u6b63\u5728\u641c\u5bfb\u00b7\u00b7\u00b7";
    }

    public static String o(int aMapLocationType) {
        switch (aMapLocationType) {
            case 1:
                return "GPS";
            case 2:
            case 3:
                return "\u524d\u6b21\u5b9a\u4f4d\u7ed3\u679c";
            case 4:
                return "\u7f13\u5b58\u5b9a\u4f4d\u7ed3\u679c";
            case 5:
                return "WIFI\u5b9a\u4f4d\u7ed3\u679c";
            case 6:
                return "\u57fa\u7ad9\u5b9a\u4f4d\u7ed3\u679c";
            case 7:
                return "LBS\u5b9a\u4f4d\u7ed3\u679c";
            case 8:
                return "\u79bb\u7ebf\u5b9a\u4f4d\u7ed3\u679c";
            default:
                return "\u672a\u77e5";
        }
    }

    public static LatLng p(AMapLocation location) {
        if (location.getTrustedLevel() != 1) {
            return null;
        }
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        if (AMapUtils.calculateLineDistance(f22824c, latLng) > 10.0f) {
            f22824c = latLng;
            f22823b.clear();
            return null;
        }
        f22823b.add(latLng);
        f22824c = latLng;
        if (f22823b.size() >= 5) {
            f22823b.clear();
            return latLng;
        }
        return null;
    }

    public static String q(@RunType int runType) {
        return runType == 1 ? "\u65e9\u64cd\u8dd1\u6b65" : runType == 2 ? "\u9633\u5149\u8dd1\u6b65" : runType == 3 ? "\u81ea\u7531\u8dd1\u6b65" : runType == 4 ? "\u5065\u5eb7\u8dd1\u6b65" : runType == 0 ? "\u5ba4\u5185\u8dd1\u6b65" : "\u8dd1\u6b65";
    }

    public static int r(Context mContext, float speed) {
        if (speed < 3.0f) {
            return ContextCompat.getColor(mContext, 2131034471);
        }
        if (speed <= 3.0f && speed >= 7.0f) {
            return ContextCompat.getColor(mContext, 2131034472);
        }
        return ContextCompat.getColor(mContext, 2131034473);
    }

    public static int s(Context mContext, float speed) {
        if (speed < 1.0f) {
            return ContextCompat.getColor(mContext, 2131034497);
        }
        if (speed < 1.0f || speed >= 2.0f) {
            if (speed < 2.0f || speed >= 3.0f) {
                if (speed < 3.0f || speed >= 4.0f) {
                    if (speed < 4.0f || speed >= 5.0f) {
                        if (speed < 5.0f || speed >= 6.0f) {
                            if (speed < 6.0f || speed >= 7.0f) {
                                if (speed < 7.0f || speed >= 8.0f) {
                                    if (speed < 8.0f || speed >= 9.0f) {
                                        if (speed >= 9.0f && speed < 10.0f) {
                                            return ContextCompat.getColor(mContext, 2131034507);
                                        }
                                        return ContextCompat.getColor(mContext, 2131034499);
                                    }
                                    return ContextCompat.getColor(mContext, 2131034506);
                                }
                                return ContextCompat.getColor(mContext, 2131034505);
                            }
                            return ContextCompat.getColor(mContext, 2131034504);
                        }
                        return ContextCompat.getColor(mContext, 2131034503);
                    }
                    return ContextCompat.getColor(mContext, 2131034502);
                }
                return ContextCompat.getColor(mContext, 2131034501);
            }
            return ContextCompat.getColor(mContext, 2131034500);
        }
        return ContextCompat.getColor(mContext, 2131034498);
    }

    public static int t(String step) {
        if (TextUtils.isEmpty(step)) {
            return 0;
        }
        List arrayList = new ArrayList();
        try {
            if (JSON.parse(step) instanceof JSONArray) {
                arrayList = JSON.parseArray(step, Integer.class);
            } else {
                String[] split = step.split(",");
                if (split.length > 0) {
                    for (String str : split) {
                        arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            String[] split2 = step.split(",");
            if (split2.length > 0) {
                for (String str2 : split2) {
                    if (str2 != null && !"null".equalsIgnoreCase(str2)) {
                        try {
                            arrayList.add(Integer.valueOf(Integer.parseInt(str2)));
                        } catch (NumberFormatException e5) {
                            e5.printStackTrace();
                        }
                    } else {
                        arrayList.add(0);
                    }
                }
            }
        }
        if (arrayList == null || arrayList.size() == 0) {
            return 0;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            i4 += ((Integer) arrayList.get(i5)).intValue();
        }
        return i4;
    }

    public static int u(int statusCode, int sportType) {
        if (sportType == 2) {
            if (statusCode != 0) {
                return statusCode != 1 ? 2131559117 : 2131559114;
            }
            return 2131559111;
        } else if (sportType == 0) {
            if (statusCode != 0) {
                return statusCode != 1 ? 2131559117 : 2131559116;
            }
            return 2131559113;
        } else if (statusCode != 0) {
            return statusCode != 1 ? 2131559117 : 2131559115;
        } else {
            return 2131559112;
        }
    }
}
