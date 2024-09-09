package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: StatisticsUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class x {

    /* renamed from: a  reason: collision with root package name */
    static g3 f10374a;

    private static String a(AMapException aMapException) {
        if (aMapException != null) {
            if (aMapException.getErrorLevel() == 0) {
                int errorCode = aMapException.getErrorCode();
                if (errorCode == 0) {
                    return "4";
                }
                int pow = (int) Math.pow(10.0d, Math.floor(Math.log10(errorCode)));
                return String.valueOf((errorCode % pow) + (pow * 4));
            }
            StringBuilder sb = new StringBuilder();
            sb.append(aMapException.getErrorCode());
            return sb.toString();
        }
        return null;
    }

    private static String b(String str, long j4, boolean z3) {
        try {
            return "{\"RequestPath\":\"" + str + "\",\"ResponseTime\":" + j4 + ",\"Success\":" + z3 + "}";
        } catch (Throwable th) {
            j4.i(th, "StatisticsUtil", "generateNetWorkResponseStatisticsEntity");
            return null;
        }
    }

    private static String c(String str, boolean z3) {
        String str2;
        try {
            str2 = "";
            int indexOf = str.indexOf("?");
            int length = str.length();
            if (indexOf > 0) {
                String substring = str.substring(0, indexOf);
                int i4 = indexOf + 1;
                str2 = i4 < length ? str.substring(i4) : "";
                str = substring;
            }
            return "{\"RequestPath\":\"" + str + "\",\"RequestParm\":\"" + str2 + "\",\"IsCacheRequest\":" + z3 + "}";
        } catch (Throwable th) {
            j4.i(th, "StatisticsUtil", "generateNetWorkResponseStatisticsEntity");
            return null;
        }
    }

    public static void d(Context context, String str, long j4, boolean z3) {
        try {
            String b4 = b(str, j4, z3);
            if (b4 != null && b4.length() > 0) {
                if (f10374a == null) {
                    f10374a = new g3(context, "sea", "9.7.0", "O002");
                }
                f10374a.a(b4);
                h3.d(f10374a, context);
            }
        } catch (Throwable th) {
            j4.i(th, "StatisticsUtil", "recordResponseAction");
        }
    }

    public static void e(Context context, String str, boolean z3) {
        try {
            String c4 = c(str, z3);
            if (c4 != null && c4.length() > 0) {
                g3 g3Var = new g3(context, "sea", "9.7.0", "O006");
                g3Var.a(c4);
                h3.d(g3Var, context);
            }
        } catch (Throwable th) {
            j4.i(th, "StatisticsUtil", "recordResponseAction");
        }
    }

    public static void f(String str, String str2, AMapException aMapException) {
        if (str != null) {
            String errorType = aMapException.getErrorType();
            String a4 = a(aMapException);
            if (a4 == null || a4.length() <= 0) {
                return;
            }
            g2.i(i4.a(true), str, errorType, str2, a4);
        }
    }
}
