package com.bxkj.student.common.utils;

import com.baidu.mobads.sdk.internal.C2658ck;
import com.github.mikephil.charting.utils.Utils;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.bxkj.student.common.utils.i */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class RunUtils {
    /* renamed from: a */
    public static String m42823a(double distance, double time) {
        double d = distance / 1000.0d;
        double d2 = time / 3600.0d;
        if (d > Utils.DOUBLE_EPSILON) {
            return new DecimalFormat("0.00").format(d / d2);
        }
        return C2658ck.f8834d;
    }

    /* renamed from: b */
    public static String m42822b(double distance, int time) {
        double round = Math.round((distance / 1000.0d) * 100.0d);
        Double.isNaN(round);
        double d = round / 100.0d;
        if (d > Utils.DOUBLE_EPSILON) {
            double d2 = time;
            Double.isNaN(d2);
            return m42820d((int) (d2 / d));
        }
        return "0'0\"";
    }

    /* renamed from: c */
    public static String m42821c(double distance) {
        double round = Math.round((distance / 1000.0d) * 100.0d);
        Double.isNaN(round);
        double d = round / 100.0d;
        return d > Utils.DOUBLE_EPSILON ? String.valueOf(d) : "0.00";
    }

    /* renamed from: d */
    private static String m42820d(int peiSuSecond) {
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

    /* renamed from: e */
    public static String m42819e(int recordingTime) {
        StringBuilder sb;
        StringBuilder sb2;
        String str;
        int i = recordingTime / SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        if (i > 9) {
            sb = new StringBuilder();
            sb.append(i);
            sb.append("");
        } else {
            sb = new StringBuilder();
            sb.append("0");
            sb.append(i);
        }
        String sb3 = sb.toString();
        int i2 = recordingTime % SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        int i3 = i2 / 60;
        if (i3 > 9) {
            sb2 = new StringBuilder();
            sb2.append(i3);
            sb2.append("");
        } else {
            sb2 = new StringBuilder();
            sb2.append("0");
            sb2.append(i3);
        }
        String sb4 = sb2.toString();
        int i4 = i2 % 60;
        if (i4 > 9) {
            str = i4 + "";
        } else {
            str = "0" + i4;
        }
        return sb3 + ":" + sb4 + ":" + str;
    }

    /* renamed from: f */
    public static String m42818f() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
