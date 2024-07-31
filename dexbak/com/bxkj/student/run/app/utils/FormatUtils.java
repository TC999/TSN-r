package com.bxkj.student.run.app.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.amap.api.location.AMapLocation;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.baidu.mobads.sdk.internal.C2658ck;
import com.bxkj.base.p085v2.common.utils.DecimalFormatUtils;
import com.bxkj.student.C4215R;
import com.bxkj.student.run.app.ready.RunType;
import com.github.mikephil.charting.utils.Utils;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.bxkj.student.run.app.utils.i */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class FormatUtils {

    /* renamed from: a */
    private static SimpleDateFormat f19592a;

    /* renamed from: b */
    private static List<LatLng> f19593b = new ArrayList();

    /* renamed from: c */
    private static LatLng f19594c = new LatLng(Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON);

    /* renamed from: a */
    public static String m39636a(double distance, long time) {
        double d = distance / 1000.0d;
        double d2 = time;
        Double.isNaN(d2);
        double d3 = d2 / 3600.0d;
        if (d > Utils.DOUBLE_EPSILON) {
            return new DecimalFormat("0.00").format(d / d3);
        }
        return C2658ck.f8834d;
    }

    /* renamed from: b */
    public static String m39635b(double distance, long time) {
        double round = Math.round((distance / 1000.0d) * 100.0d);
        Double.isNaN(round);
        double d = round / 100.0d;
        if (d > Utils.DOUBLE_EPSILON) {
            double d2 = time;
            Double.isNaN(d2);
            return m39631f((int) (d2 / d));
        }
        return "0'0\"";
    }

    /* renamed from: c */
    public static String m39634c(double distance) {
        return DecimalFormatUtils.f15114a.m43806a(distance / 1000.0d);
    }

    /* renamed from: d */
    public static String m39633d(double distance) {
        return DecimalFormatUtils.f15114a.m43805b(distance / 1000.0d);
    }

    /* renamed from: e */
    public static double m39632e(double distance) {
        return new BigDecimal(distance).divide(new BigDecimal(1000), 2, RoundingMode.FLOOR).doubleValue();
    }

    /* renamed from: f */
    private static String m39631f(int peiSuSecond) {
        StringBuilder sb;
        String str;
        int i = peiSuSecond % SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        int i2 = i / 60;
        if (i2 > 9) {
            sb = new StringBuilder();
            sb.append(i2);
            sb.append("");
        } else {
            sb = new StringBuilder();
            sb.append("0");
            sb.append(i2);
        }
        String sb2 = sb.toString();
        int i3 = i % 60;
        if (i3 > 9) {
            str = i3 + "";
        } else {
            str = "0" + i3;
        }
        return sb2 + "'" + str + "\"";
    }

    /* renamed from: g */
    public static String m39630g(long recordingTime) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        long j = recordingTime / 3600;
        if (j > 9) {
            sb = new StringBuilder();
            sb.append(j);
            sb.append("");
        } else {
            sb = new StringBuilder();
            sb.append("0");
            sb.append(j);
        }
        String sb4 = sb.toString();
        long j2 = recordingTime % 3600;
        long j3 = j2 / 60;
        if (j3 > 9) {
            sb2 = new StringBuilder();
            sb2.append(j3);
            sb2.append("");
        } else {
            sb2 = new StringBuilder();
            sb2.append("0");
            sb2.append(j3);
        }
        String sb5 = sb2.toString();
        long j4 = j2 % 60;
        if (j4 > 9) {
            sb3 = new StringBuilder();
            sb3.append(j4);
            sb3.append("");
        } else {
            sb3 = new StringBuilder();
            sb3.append("0");
            sb3.append(j4);
        }
        String sb6 = sb3.toString();
        return sb4 + ":" + sb5 + ":" + sb6;
    }

    /* renamed from: h */
    public static String m39629h(long l, String strPattern) {
        if (TextUtils.isEmpty(strPattern)) {
            strPattern = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat = f19592a;
        if (simpleDateFormat == null) {
            try {
                f19592a = new SimpleDateFormat(strPattern, Locale.CHINA);
            } catch (Throwable unused) {
            }
        } else {
            simpleDateFormat.applyPattern(strPattern);
        }
        SimpleDateFormat simpleDateFormat2 = f19592a;
        return simpleDateFormat2 == null ? "NULL" : simpleDateFormat2.format(Long.valueOf(l));
    }

    /* renamed from: i */
    public static String m39628i(long l) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM", Locale.CHINA);
        f19592a = simpleDateFormat;
        return simpleDateFormat.format(Long.valueOf(l));
    }

    /* renamed from: j */
    public static String m39627j(int statusCode, int gpsAccuracyStatus) {
        return statusCode != 0 ? statusCode != 1 ? statusCode != 2 ? statusCode != 3 ? statusCode != 4 ? "GPS状态未知" : "没有GPS定位权限，建议开启gps定位权限" : "选择的定位模式中不包含GPS定位，建议选择包含GPS定位的模式，提高定位质量" : "GPS关闭，建议开启GPS，提高定位质量" : "手机中没有GPS Provider，无法进行GPS定位" : gpsAccuracyStatus != -1 ? gpsAccuracyStatus != 0 ? gpsAccuracyStatus != 1 ? "GPS状态正常" : "GPS信号良好，请尽情跑步" : "GPS信号弱，请在空旷的地方跑步" : "GPS信号未知，正在搜寻···";
    }

    /* renamed from: k */
    public static int m39626k(int statusCode) {
        return statusCode != 0 ? statusCode != 1 ? C4215R.mipmap.ic_gps_unknow : C4215R.mipmap.ic_gps_full : C4215R.mipmap.ic_gps_bad;
    }

    /* renamed from: l */
    public static int m39625l(int gpsQualityReportStatusCode, int gpsAccuracyStatus) {
        return gpsQualityReportStatusCode != 0 ? (gpsQualityReportStatusCode == 1 || gpsQualityReportStatusCode == 2) ? C4215R.mipmap.ic_gps_unknow : C4215R.mipmap.ic_gps_unknow : gpsAccuracyStatus != -1 ? gpsAccuracyStatus != 0 ? gpsAccuracyStatus != 1 ? C4215R.mipmap.ic_gps_unknow : C4215R.mipmap.ic_gps_full : C4215R.mipmap.ic_gps_bad : C4215R.mipmap.ic_gps_unknow;
    }

    /* renamed from: m */
    public static String m39624m(int statusCode) {
        return statusCode != 0 ? statusCode != 1 ? statusCode != 2 ? statusCode != 3 ? statusCode != 4 ? "" : "没有GPS定位权限，建议开启gps定位权限" : "选择的定位模式中不包含GPS定位，建议选择包含GPS定位的模式，提高定位质量" : "GPS关闭，建议开启GPS，提高定位质量" : "手机中没有GPS Provider，无法进行GPS定位" : "GPS状态正常";
    }

    /* renamed from: n */
    public static String m39623n(int gpsQualityReportStatusCode, int gpsAccuracyStatus) {
        return gpsQualityReportStatusCode != 0 ? gpsQualityReportStatusCode != 1 ? gpsQualityReportStatusCode != 2 ? gpsQualityReportStatusCode != 3 ? gpsQualityReportStatusCode != 4 ? "" : "没有GPS定位权限，建议开启gps定位权限" : "选择的定位模式中不包含GPS定位，建议选择包含GPS定位的模式，提高定位质量" : "GPS关闭，建议开启GPS，提高定位质量" : "手机中没有GPS Provider，无法进行GPS定位" : gpsAccuracyStatus != -1 ? gpsAccuracyStatus != 0 ? gpsAccuracyStatus != 1 ? "GPS状态正常" : "GPS信号良好，请尽情跑步" : "GPS信号弱，请在空旷的地方跑步" : "GPS信号未知，正在搜寻···";
    }

    /* renamed from: o */
    public static String m39622o(int aMapLocationType) {
        switch (aMapLocationType) {
            case 1:
                return "GPS";
            case 2:
            case 3:
                return "前次定位结果";
            case 4:
                return "缓存定位结果";
            case 5:
                return "WIFI定位结果";
            case 6:
                return "基站定位结果";
            case 7:
                return "LBS定位结果";
            case 8:
                return "离线定位结果";
            default:
                return "未知";
        }
    }

    /* renamed from: p */
    public static LatLng m39621p(AMapLocation location) {
        if (location.getTrustedLevel() != 1) {
            return null;
        }
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        if (AMapUtils.calculateLineDistance(f19594c, latLng) > 10.0f) {
            f19594c = latLng;
            f19593b.clear();
            return null;
        }
        f19593b.add(latLng);
        f19594c = latLng;
        if (f19593b.size() >= 5) {
            f19593b.clear();
            return latLng;
        }
        return null;
    }

    /* renamed from: q */
    public static String m39620q(@RunType int runType) {
        return runType == 1 ? "早操跑步" : runType == 2 ? "阳光跑步" : runType == 3 ? "自由跑步" : runType == 4 ? "健康跑步" : runType == 0 ? "室内跑步" : "跑步";
    }

    /* renamed from: r */
    public static int m39619r(Context mContext, float speed) {
        if (speed < 3.0f) {
            return ContextCompat.getColor(mContext, C4215R.C4217color.speed1);
        }
        if (speed <= 3.0f && speed >= 7.0f) {
            return ContextCompat.getColor(mContext, C4215R.C4217color.speed2);
        }
        return ContextCompat.getColor(mContext, C4215R.C4217color.speed3);
    }

    /* renamed from: s */
    public static int m39618s(Context mContext, float speed) {
        if (speed < 1.0f) {
            return ContextCompat.getColor(mContext, C4215R.C4217color.track_line_0);
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
                                            return ContextCompat.getColor(mContext, C4215R.C4217color.track_line_9);
                                        }
                                        return ContextCompat.getColor(mContext, C4215R.C4217color.track_line_10);
                                    }
                                    return ContextCompat.getColor(mContext, C4215R.C4217color.track_line_8);
                                }
                                return ContextCompat.getColor(mContext, C4215R.C4217color.track_line_7);
                            }
                            return ContextCompat.getColor(mContext, C4215R.C4217color.track_line_6);
                        }
                        return ContextCompat.getColor(mContext, C4215R.C4217color.track_line_5);
                    }
                    return ContextCompat.getColor(mContext, C4215R.C4217color.track_line_4);
                }
                return ContextCompat.getColor(mContext, C4215R.C4217color.track_line_3);
            }
            return ContextCompat.getColor(mContext, C4215R.C4217color.track_line_2);
        }
        return ContextCompat.getColor(mContext, C4215R.C4217color.track_line_1);
    }

    /* renamed from: t */
    public static int m39617t(String step) {
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
        } catch (Exception e) {
            e.printStackTrace();
            String[] split2 = step.split(",");
            if (split2.length > 0) {
                for (String str2 : split2) {
                    if (str2 != null && !"null".equalsIgnoreCase(str2)) {
                        try {
                            arrayList.add(Integer.valueOf(Integer.parseInt(str2)));
                        } catch (NumberFormatException e2) {
                            e2.printStackTrace();
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
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            i += ((Integer) arrayList.get(i2)).intValue();
        }
        return i;
    }

    /* renamed from: u */
    public static int m39616u(int statusCode, int sportType) {
        return sportType == 2 ? statusCode != 0 ? statusCode != 1 ? C4215R.mipmap.v3_gps_unknow : C4215R.mipmap.v3_gps_good1 : C4215R.mipmap.v3_gps_bad1 : sportType == 0 ? statusCode != 0 ? statusCode != 1 ? C4215R.mipmap.v3_gps_unknow : C4215R.mipmap.v3_gps_good3 : C4215R.mipmap.v3_gps_bad3 : statusCode != 0 ? statusCode != 1 ? C4215R.mipmap.v3_gps_unknow : C4215R.mipmap.v3_gps_good2 : C4215R.mipmap.v3_gps_bad2;
    }
}
