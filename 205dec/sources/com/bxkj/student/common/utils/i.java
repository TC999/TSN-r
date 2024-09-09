package com.bxkj.student.common.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: RunUtils.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class i {
    public static String a(double distance, double time) {
        double d4 = distance / 1000.0d;
        double d5 = time / 3600.0d;
        if (d4 > 0.0d) {
            return new DecimalFormat("0.00").format(d4 / d5);
        }
        return "0.0";
    }

    public static String b(double distance, int time) {
        double round = Math.round((distance / 1000.0d) * 100.0d);
        Double.isNaN(round);
        double d4 = round / 100.0d;
        if (d4 > 0.0d) {
            double d5 = time;
            Double.isNaN(d5);
            return d((int) (d5 / d4));
        }
        return "0'0\"";
    }

    public static String c(double distance) {
        double round = Math.round((distance / 1000.0d) * 100.0d);
        Double.isNaN(round);
        double d4 = round / 100.0d;
        return d4 > 0.0d ? String.valueOf(d4) : "0.00";
    }

    private static String d(int peiSuSecond) {
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

    public static String e(int recordingTime) {
        StringBuilder sb;
        StringBuilder sb2;
        String str;
        int i4 = recordingTime / 3600;
        if (i4 > 9) {
            sb = new StringBuilder();
            sb.append(i4);
            sb.append("");
        } else {
            sb = new StringBuilder();
            sb.append("0");
            sb.append(i4);
        }
        String sb3 = sb.toString();
        int i5 = recordingTime % 3600;
        int i6 = i5 / 60;
        if (i6 > 9) {
            sb2 = new StringBuilder();
            sb2.append(i6);
            sb2.append("");
        } else {
            sb2 = new StringBuilder();
            sb2.append("0");
            sb2.append(i6);
        }
        String sb4 = sb2.toString();
        int i7 = i5 % 60;
        if (i7 > 9) {
            str = i7 + "";
        } else {
            str = "0" + i7;
        }
        return sb3 + ":" + sb4 + ":" + str;
    }

    public static String f() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
