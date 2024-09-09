package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import com.amap.api.col.p0003l.e7;
import com.amap.api.col.p0003l.f7;
import com.amap.api.col.p0003l.fk;
import com.amap.api.col.p0003l.g7;
import com.amap.api.col.p0003l.h7;
import com.amap.api.col.p0003l.u5;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.bytedance.pangle.sdk.component.log.impl.BuildConfig;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ReportUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<Long> f12040a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    public int f12041b = -1;

    /* renamed from: c  reason: collision with root package name */
    public long f12042c = 0;

    /* renamed from: d  reason: collision with root package name */
    String[] f12043d = {"ol", "cl", "gl", "ha", "bs", "ds"};

    /* renamed from: e  reason: collision with root package name */
    public int f12044e = -1;

    /* renamed from: f  reason: collision with root package name */
    public long f12045f = -1;

    /* renamed from: i  reason: collision with root package name */
    private static List<g7> f12038i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    private static JSONArray f12039j = null;

    /* renamed from: g  reason: collision with root package name */
    static AMapLocation f12036g = null;

    /* renamed from: h  reason: collision with root package name */
    static boolean f12037h = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: ReportUtil.java */
    /* renamed from: com.autonavi.aps.amapapi.utils.h$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12046a;

        static {
            int[] iArr = new int[AMapLocationClientOption.AMapLocationMode.values().length];
            f12046a = iArr;
            try {
                iArr[AMapLocationClientOption.AMapLocationMode.Battery_Saving.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12046a[AMapLocationClientOption.AMapLocationMode.Device_Sensors.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12046a[AMapLocationClientOption.AMapLocationMode.Hight_Accuracy.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static String a(int i4) {
        if (i4 != 2011) {
            if (i4 != 2031) {
                if (i4 != 2041) {
                    if (i4 != 2081) {
                        if (i4 != 2091) {
                            if (i4 != 2111) {
                                if (i4 != 2121) {
                                    if (i4 != 2141) {
                                        if (i4 != 2021) {
                                            if (i4 != 2022) {
                                                if (i4 != 2061) {
                                                    if (i4 != 2062) {
                                                        switch (i4) {
                                                            case 2051:
                                                                return "NeedLoginNetWork\t";
                                                            case 2052:
                                                                return "MaybeIntercepted";
                                                            case 2053:
                                                                return "DecryptResponseException";
                                                            case 2054:
                                                                return "ParserDataException";
                                                            default:
                                                                switch (i4) {
                                                                    case 2101:
                                                                        return "BindAPSServiceException";
                                                                    case 2102:
                                                                        return "AuthClientScodeFail";
                                                                    case 2103:
                                                                        return "NotConfigAPSService";
                                                                    default:
                                                                        switch (i4) {
                                                                            case 2131:
                                                                                return "NoCgiOAndWifiInfo";
                                                                            case 2132:
                                                                                return "AirPlaneModeAndWifiOff";
                                                                            case 2133:
                                                                                return "NoCgiAndWifiOff";
                                                                            default:
                                                                                switch (i4) {
                                                                                    case 2151:
                                                                                        return "MaybeMockNetLoc";
                                                                                    case 2152:
                                                                                        return "MaybeMockGPSLoc";
                                                                                    case 2153:
                                                                                        return "UNSUPPORT_COARSE_LBSLOC";
                                                                                    case 2154:
                                                                                        return "UNSUPPORT_CONTINUE_LOC";
                                                                                    default:
                                                                                        return "";
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                    }
                                                    return "ServerLocFail";
                                                }
                                                return "ServerRetypeError";
                                            }
                                            return "OnlyOneWifiButNotMain";
                                        }
                                        return "OnlyMainWifi";
                                    }
                                    return "NoEnoughStatellites";
                                }
                                return "NotLocPermission";
                            }
                            return "ErrorCgiInfo";
                        }
                        return "InitException";
                    }
                    return "LocalLocException";
                }
                return "ResponseResultIsNull";
            }
            return "CreateApsReqException";
        }
        return "ContextIsNull";
    }

    private static boolean a(AMapLocation aMapLocation) {
        return j.a(aMapLocation) ? !b.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()) : "http://abroad.apilocate.amap.com/mobile/binary".equals(b.f12007c);
    }

    public static void b(Context context, long j4, boolean z3) {
        if (context != null) {
            try {
                if (a.a()) {
                    a(context, j4, z3, "O024");
                }
            } catch (Throwable th) {
                b.a(th, "ReportUtil", "reportCoarseLocUseTime");
            }
        }
    }

    private static void f(Context context) {
        try {
            JSONArray jSONArray = f12039j;
            if (jSONArray == null || jSONArray.length() <= 0) {
                return;
            }
            f7.e(new e7(context, b.c(), f12039j.toString()), context);
            f12039j = null;
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "writeOfflineLocLog");
        }
    }

    public final int c(Context context) {
        try {
            long a4 = i.a(context, "pref1", this.f12043d[2], 0L);
            long a5 = i.a(context, "pref1", this.f12043d[0], 0L);
            long a6 = i.a(context, "pref1", this.f12043d[1], 0L);
            if (a4 == 0 && a5 == 0 && a6 == 0) {
                return -1;
            }
            long j4 = a5 - a4;
            long j5 = a6 - a4;
            return a4 > j4 ? a4 > j5 ? 2 : 1 : j4 > j5 ? 0 : 1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int d(Context context) {
        try {
            long a4 = i.a(context, "pref1", this.f12043d[3], 0L);
            long a5 = i.a(context, "pref1", this.f12043d[4], 0L);
            long a6 = i.a(context, "pref1", this.f12043d[5], 0L);
            if (a4 == 0 && a5 == 0 && a6 == 0) {
                return -1;
            }
            return a4 > a5 ? a4 > a6 ? 3 : 5 : a5 > a6 ? 4 : 5;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final void e(Context context) {
        try {
            SharedPreferences.Editor a4 = i.a(context, "pref1");
            int i4 = 0;
            while (true) {
                String[] strArr = this.f12043d;
                if (i4 < strArr.length) {
                    i.a(a4, strArr[i4], 0L);
                    i4++;
                } else {
                    i.a(a4);
                    return;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, AMapLocation aMapLocation, com.autonavi.aps.amapapi.a aVar) {
        int i4;
        if (aMapLocation == null) {
            return;
        }
        try {
            if (!"gps".equalsIgnoreCase(aMapLocation.getProvider()) && aMapLocation.getLocationType() != 1) {
                String str = BuildConfig.FLAVOR;
                if (a(aMapLocation)) {
                    str = "abroad";
                }
                String str2 = str;
                String str3 = "cache";
                if (aMapLocation.getErrorCode() != 0) {
                    int errorCode = aMapLocation.getErrorCode();
                    if (errorCode == 4 || errorCode == 5 || errorCode == 6 || errorCode == 11) {
                        str3 = "net";
                    }
                    i4 = 0;
                } else {
                    int locationType = aMapLocation.getLocationType();
                    if (locationType == 5 || locationType == 6) {
                        str3 = "net";
                    }
                    i4 = 1;
                }
                a(context, "O016", str3, str2, i4, aMapLocation.getErrorCode(), aVar);
            }
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "reportBatting");
        }
    }

    public final void b(Context context) {
        try {
            long b4 = j.b() - this.f12042c;
            int i4 = this.f12041b;
            if (i4 != -1) {
                this.f12040a.append(this.f12041b, Long.valueOf(b4 + this.f12040a.get(i4, 0L).longValue()));
            }
            long b5 = j.b() - this.f12045f;
            int i5 = this.f12044e;
            if (i5 != -1) {
                this.f12040a.append(this.f12044e, Long.valueOf(b5 + this.f12040a.get(i5, 0L).longValue()));
            }
            SharedPreferences.Editor a4 = i.a(context, "pref1");
            for (int i6 = 0; i6 < this.f12043d.length; i6++) {
                long longValue = this.f12040a.get(i6, 0L).longValue();
                if (longValue > 0 && longValue > i.a(context, "pref1", this.f12043d[i6], 0L)) {
                    i.a(a4, this.f12043d[i6], longValue);
                }
            }
            i.a(a4);
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "saveLocationTypeAndMode");
        }
    }

    public static void a(Context context, long j4, boolean z3) {
        if (context != null) {
            try {
                if (a.a()) {
                    a(context, j4, z3, "O015");
                }
            } catch (Throwable th) {
                b.a(th, "ReportUtil", "reportGPSLocUseTime");
            }
        }
    }

    private static void a(Context context, long j4, boolean z3, String str) {
        a(context, str, !z3 ? "abroad" : BuildConfig.FLAVOR, Long.valueOf(j4).intValue());
    }

    private static void a(Context context, String str, String str2, String str3, int i4, int i5, com.autonavi.aps.amapapi.a aVar) {
        if (context != null) {
            try {
                if (a.a()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject.put("param_string_second", str3);
                    }
                    if (i4 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", i4);
                    }
                    if (i5 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_second", i5);
                    }
                    if (aVar != null) {
                        if (!TextUtils.isEmpty(aVar.d())) {
                            jSONObject.put("dns", aVar.d());
                        }
                        if (!TextUtils.isEmpty(aVar.e())) {
                            jSONObject.put(DomainCampaignEx.LOOPBACK_DOMAIN, aVar.e());
                        }
                        if (!TextUtils.isEmpty(aVar.f())) {
                            jSONObject.put("type", aVar.f());
                        }
                        if (!TextUtils.isEmpty(aVar.g())) {
                            jSONObject.put("reason", aVar.g());
                        }
                        if (!TextUtils.isEmpty(aVar.c())) {
                            jSONObject.put("ip", aVar.c());
                        }
                        if (!TextUtils.isEmpty(aVar.b())) {
                            jSONObject.put("stack", aVar.b());
                        }
                        if (aVar.h() > 0) {
                            jSONObject.put("ctime", String.valueOf(aVar.h()));
                        }
                        if (aVar.a() > 0) {
                            jSONObject.put("ntime", String.valueOf(aVar.a()));
                        }
                    }
                    a(context, str, jSONObject);
                }
            } catch (Throwable th) {
                b.a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    private static void a(Context context, String str, String str2, int i4) {
        if (context != null) {
            try {
                if (a.a()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (!TextUtils.isEmpty(null)) {
                        jSONObject.put("param_string_second", (Object) null);
                    }
                    if (i4 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", i4);
                    }
                    a(context, str, jSONObject);
                }
            } catch (Throwable th) {
                b.a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    public static synchronized void a(Context context, String str, JSONObject jSONObject) {
        synchronized (h.class) {
            if (context != null) {
                try {
                    if (a.a()) {
                        g7 g7Var = new g7(context, "loc", "6.4.3", str);
                        if (jSONObject != null) {
                            g7Var.a(jSONObject.toString());
                        }
                        f12038i.add(g7Var);
                        if (f12038i.size() >= 30) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(f12038i);
                            h7.h(arrayList, context);
                            f12038i.clear();
                        }
                    }
                } catch (Throwable th) {
                    b.a(th, "ReportUtil", "applyStatistics");
                }
            }
        }
    }

    public static synchronized void a(Context context) {
        synchronized (h.class) {
            if (context != null) {
                try {
                    if (a.a()) {
                        List<g7> list = f12038i;
                        if (list != null && list.size() > 0) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(f12038i);
                            h7.h(arrayList, context);
                            f12038i.clear();
                        }
                        f(context);
                    }
                } catch (Throwable th) {
                    b.a(th, "ReportUtil", "destroy");
                }
            }
        }
    }

    public static void a(String str, String str2) {
        try {
            u5.o(b.c(), str2, str);
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "reportLog");
        }
    }

    public final void a(Context context, int i4) {
        try {
            int i5 = this.f12041b;
            if (i5 == i4) {
                return;
            }
            if (i5 != -1 && i5 != i4) {
                this.f12040a.append(this.f12041b, Long.valueOf((j.b() - this.f12042c) + this.f12040a.get(this.f12041b, 0L).longValue()));
            }
            this.f12042c = j.b() - i.a(context, "pref1", this.f12043d[i4], 0L);
            this.f12041b = i4;
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "setLocationType");
        }
    }

    public final void a(Context context, AMapLocationClientOption aMapLocationClientOption) {
        try {
            int i4 = AnonymousClass1.f12046a[aMapLocationClientOption.getLocationMode().ordinal()];
            int i5 = 3;
            if (i4 == 1) {
                i5 = 4;
            } else if (i4 == 2) {
                i5 = 5;
            } else if (i4 != 3) {
                i5 = -1;
            }
            int i6 = this.f12044e;
            if (i6 == i5) {
                return;
            }
            if (i6 != -1 && i6 != i5) {
                this.f12040a.append(this.f12044e, Long.valueOf((j.b() - this.f12045f) + this.f12040a.get(this.f12044e, 0L).longValue()));
            }
            this.f12045f = j.b() - i.a(context, "pref1", this.f12043d[i5], 0L);
            this.f12044e = i5;
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "setLocationMode");
        }
    }

    public static void a(Context context, int i4, int i5, long j4, long j5) {
        if (i4 == -1 || i5 == -1) {
            return;
        }
        try {
            a(context, "O012", i4, i5, j4, j5);
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "reportServiceAliveTime");
        }
    }

    private static void a(Context context, String str, int i4, int i5, long j4, long j5) {
        if (context != null) {
            try {
                if (a.a()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("param_int_first", i4);
                    jSONObject.put("param_int_second", i5);
                    jSONObject.put("param_long_first", j4);
                    jSONObject.put("param_long_second", j5);
                    a(context, str, jSONObject);
                }
            } catch (Throwable th) {
                b.a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0034 A[Catch: all -> 0x00f0, TRY_LEAVE, TryCatch #0 {all -> 0x00f0, blocks: (B:4:0x0003, B:8:0x000b, B:26:0x0034, B:37:0x0047, B:39:0x004b, B:40:0x0052, B:42:0x008b, B:45:0x0098, B:46:0x00d9, B:48:0x00eb, B:43:0x0091), top: B:58:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void a(android.content.Context r8, com.amap.api.location.AMapLocation r9) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.h.a(android.content.Context, com.amap.api.location.AMapLocation):void");
    }

    public static void a(String str, int i4) {
        a(str, String.valueOf(i4), a(i4));
    }

    public static void a(String str, String str2, String str3) {
        try {
            u5.k(b.c(), "/mobile/binary", str3, str, str2);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, Throwable th) {
        try {
            if (th instanceof fk) {
                u5.j(b.c(), str, (fk) th);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        try {
            if (f12036g == null) {
                if (!j.a(aMapLocation)) {
                    f12036g = aMapLocation2;
                    return;
                }
                f12036g = aMapLocation.m15clone();
            }
            if (j.a(f12036g) && j.a(aMapLocation2)) {
                AMapLocation m15clone = aMapLocation2.m15clone();
                if (f12036g.getLocationType() != 1 && f12036g.getLocationType() != 9 && !"gps".equalsIgnoreCase(f12036g.getProvider()) && f12036g.getLocationType() != 7 && m15clone.getLocationType() != 1 && m15clone.getLocationType() != 9 && !"gps".equalsIgnoreCase(m15clone.getProvider()) && m15clone.getLocationType() != 7) {
                    long abs = Math.abs(m15clone.getTime() - f12036g.getTime()) / 1000;
                    if (abs <= 0) {
                        abs = 1;
                    }
                    if (abs <= 1800) {
                        float a4 = j.a(f12036g, m15clone);
                        float f4 = a4 / ((float) abs);
                        if (a4 > 30000.0f && f4 > 1000.0f) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(f12036g.getLatitude());
                            sb.append(",");
                            sb.append(f12036g.getLongitude());
                            sb.append(",");
                            sb.append(f12036g.getAccuracy());
                            sb.append(",");
                            sb.append(f12036g.getLocationType());
                            sb.append(",");
                            if (aMapLocation.getTime() != 0) {
                                sb.append(j.a(f12036g.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb.append(f12036g.getTime());
                            }
                            sb.append("#");
                            sb.append(m15clone.getLatitude());
                            sb.append(",");
                            sb.append(m15clone.getLongitude());
                            sb.append(",");
                            sb.append(m15clone.getAccuracy());
                            sb.append(",");
                            sb.append(m15clone.getLocationType());
                            sb.append(",");
                            if (m15clone.getTime() != 0) {
                                sb.append(j.a(m15clone.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb.append(m15clone.getTime());
                            }
                            a("bigshiftstatistics", sb.toString());
                            sb.delete(0, sb.length());
                        }
                    }
                }
                f12036g = m15clone;
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(long j4, long j5) {
        try {
            if (f12037h) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("gpsTime:");
            stringBuffer.append(j.a(j4, "yyyy-MM-dd HH:mm:ss.SSS"));
            stringBuffer.append(",");
            stringBuffer.append("sysTime:");
            stringBuffer.append(j.a(j5, "yyyy-MM-dd HH:mm:ss.SSS"));
            stringBuffer.append(",");
            long u3 = a.u();
            String a4 = 0 != u3 ? j.a(u3, "yyyy-MM-dd HH:mm:ss.SSS") : "0";
            stringBuffer.append("serverTime:");
            stringBuffer.append(a4);
            a("checkgpstime", stringBuffer.toString());
            if (0 != u3 && Math.abs(j4 - u3) < 31536000000L) {
                stringBuffer.append(", correctError");
                a("checkgpstimeerror", stringBuffer.toString());
            }
            stringBuffer.delete(0, stringBuffer.length());
            f12037h = true;
        } catch (Throwable unused) {
        }
    }
}
