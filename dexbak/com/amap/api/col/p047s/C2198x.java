package com.amap.api.col.p047s;

import android.content.Context;
import com.amap.api.services.core.AMapException;

/* compiled from: StatisticsUtil.java */
/* renamed from: com.amap.api.col.s.x */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2198x {

    /* renamed from: a */
    static C2064g3 f6646a;

    /* renamed from: a */
    private static String m52341a(AMapException aMapException) {
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

    /* renamed from: b */
    private static String m52340b(String str, long j, boolean z) {
        try {
            return "{\"RequestPath\":\"" + str + "\",\"ResponseTime\":" + j + ",\"Success\":" + z + "}";
        } catch (Throwable th) {
            C2082j4.m52825i(th, "StatisticsUtil", "generateNetWorkResponseStatisticsEntity");
            return null;
        }
    }

    /* renamed from: c */
    private static String m52339c(String str, boolean z) {
        String str2;
        try {
            str2 = "";
            int indexOf = str.indexOf("?");
            int length = str.length();
            if (indexOf > 0) {
                String substring = str.substring(0, indexOf);
                int i = indexOf + 1;
                str2 = i < length ? str.substring(i) : "";
                str = substring;
            }
            return "{\"RequestPath\":\"" + str + "\",\"RequestParm\":\"" + str2 + "\",\"IsCacheRequest\":" + z + "}";
        } catch (Throwable th) {
            C2082j4.m52825i(th, "StatisticsUtil", "generateNetWorkResponseStatisticsEntity");
            return null;
        }
    }

    /* renamed from: d */
    public static void m52338d(Context context, String str, long j, boolean z) {
        try {
            String m52340b = m52340b(str, j, z);
            if (m52340b != null && m52340b.length() > 0) {
                if (f6646a == null) {
                    f6646a = new C2064g3(context, "sea", "9.7.0", "O002");
                }
                f6646a.m52971a(m52340b);
                C2070h3.m52943d(f6646a, context);
            }
        } catch (Throwable th) {
            C2082j4.m52825i(th, "StatisticsUtil", "recordResponseAction");
        }
    }

    /* renamed from: e */
    public static void m52337e(Context context, String str, boolean z) {
        try {
            String m52339c = m52339c(str, z);
            if (m52339c != null && m52339c.length() > 0) {
                C2064g3 c2064g3 = new C2064g3(context, "sea", "9.7.0", "O006");
                c2064g3.m52971a(m52339c);
                C2070h3.m52943d(c2064g3, context);
            }
        } catch (Throwable th) {
            C2082j4.m52825i(th, "StatisticsUtil", "recordResponseAction");
        }
    }

    /* renamed from: f */
    public static void m52336f(String str, String str2, AMapException aMapException) {
        if (str != null) {
            String errorType = aMapException.getErrorType();
            String m52341a = m52341a(aMapException);
            if (m52341a == null || m52341a.length() <= 0) {
                return;
            }
            C2060g2.m52978i(C2077i4.m52895a(true), str, errorType, str2, m52341a);
        }
    }
}
