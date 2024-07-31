package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import com.amap.api.col.p0463l.AMapCoreException;
import com.amap.api.col.p0463l.OfflineLocEntity;
import com.amap.api.col.p0463l.OfflineLocManager;
import com.amap.api.col.p0463l.SDKLogHandler;
import com.amap.api.col.p0463l.StatisticsEntity;
import com.amap.api.col.p0463l.StatisticsManager;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.components.offline.api.p341tk.model.report.TKDownloadReason;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* renamed from: com.autonavi.aps.amapapi.utils.h */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ReportUtil {

    /* renamed from: a */
    public SparseArray<Long> f8402a = new SparseArray<>();

    /* renamed from: b */
    public int f8403b = -1;

    /* renamed from: c */
    public long f8404c = 0;

    /* renamed from: d */
    String[] f8405d = {"ol", "cl", "gl", "ha", "bs", "ds"};

    /* renamed from: e */
    public int f8406e = -1;

    /* renamed from: f */
    public long f8407f = -1;

    /* renamed from: i */
    private static List<StatisticsEntity> f8400i = new ArrayList();

    /* renamed from: j */
    private static JSONArray f8401j = null;

    /* renamed from: g */
    static AMapLocation f8398g = null;

    /* renamed from: h */
    static boolean f8399h = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReportUtil.java */
    /* renamed from: com.autonavi.aps.amapapi.utils.h$1 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static /* synthetic */ class C24301 {

        /* renamed from: a */
        static final /* synthetic */ int[] f8408a;

        static {
            int[] iArr = new int[AMapLocationClientOption.AMapLocationMode.values().length];
            f8408a = iArr;
            try {
                iArr[AMapLocationClientOption.AMapLocationMode.Battery_Saving.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8408a[AMapLocationClientOption.AMapLocationMode.Device_Sensors.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8408a[AMapLocationClientOption.AMapLocationMode.Hight_Accuracy.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: a */
    private static String m51249a(int i) {
        if (i != 2011) {
            if (i != 2031) {
                if (i != 2041) {
                    if (i != 2081) {
                        if (i != 2091) {
                            if (i != 2111) {
                                if (i != 2121) {
                                    if (i != 2141) {
                                        if (i != 2021) {
                                            if (i != 2022) {
                                                if (i != 2061) {
                                                    if (i != 2062) {
                                                        switch (i) {
                                                            case 2051:
                                                                return "NeedLoginNetWork\t";
                                                            case 2052:
                                                                return "MaybeIntercepted";
                                                            case 2053:
                                                                return "DecryptResponseException";
                                                            case 2054:
                                                                return "ParserDataException";
                                                            default:
                                                                switch (i) {
                                                                    case AMapException.CODE_AMAP_NEARBY_KEY_NOT_BIND /* 2101 */:
                                                                        return "BindAPSServiceException";
                                                                    case 2102:
                                                                        return "AuthClientScodeFail";
                                                                    case 2103:
                                                                        return "NotConfigAPSService";
                                                                    default:
                                                                        switch (i) {
                                                                            case 2131:
                                                                                return "NoCgiOAndWifiInfo";
                                                                            case 2132:
                                                                                return "AirPlaneModeAndWifiOff";
                                                                            case 2133:
                                                                                return "NoCgiAndWifiOff";
                                                                            default:
                                                                                switch (i) {
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

    /* renamed from: a */
    private static boolean m51235a(AMapLocation aMapLocation) {
        return C2432j.m51197a(aMapLocation) ? !C2428b.m51309a(aMapLocation.getLatitude(), aMapLocation.getLongitude()) : "http://abroad.apilocate.amap.com/mobile/binary".equals(C2428b.f8369c);
    }

    /* renamed from: b */
    public static void m51228b(Context context, long j, boolean z) {
        if (context != null) {
            try {
                if (AuthUtil.m51349a()) {
                    m51243a(context, j, z, "O024");
                }
            } catch (Throwable th) {
                C2428b.m51299a(th, "ReportUtil", "reportCoarseLocUseTime");
            }
        }
    }

    /* renamed from: f */
    private static void m51224f(Context context) {
        try {
            JSONArray jSONArray = f8401j;
            if (jSONArray == null || jSONArray.length() <= 0) {
                return;
            }
            OfflineLocManager.m55213e(new OfflineLocEntity(context, C2428b.m51294c(), f8401j.toString()), context);
            f8401j = null;
        } catch (Throwable th) {
            C2428b.m51299a(th, "ReportUtil", "writeOfflineLocLog");
        }
    }

    /* renamed from: c */
    public final int m51227c(Context context) {
        try {
            long m51220a = C2431i.m51220a(context, "pref1", this.f8405d[2], 0L);
            long m51220a2 = C2431i.m51220a(context, "pref1", this.f8405d[0], 0L);
            long m51220a3 = C2431i.m51220a(context, "pref1", this.f8405d[1], 0L);
            if (m51220a == 0 && m51220a2 == 0 && m51220a3 == 0) {
                return -1;
            }
            long j = m51220a2 - m51220a;
            long j2 = m51220a3 - m51220a;
            return m51220a > j ? m51220a > j2 ? 2 : 1 : j > j2 ? 0 : 1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* renamed from: d */
    public final int m51226d(Context context) {
        try {
            long m51220a = C2431i.m51220a(context, "pref1", this.f8405d[3], 0L);
            long m51220a2 = C2431i.m51220a(context, "pref1", this.f8405d[4], 0L);
            long m51220a3 = C2431i.m51220a(context, "pref1", this.f8405d[5], 0L);
            if (m51220a == 0 && m51220a2 == 0 && m51220a3 == 0) {
                return -1;
            }
            return m51220a > m51220a2 ? m51220a > m51220a3 ? 3 : 5 : m51220a2 > m51220a3 ? 4 : 5;
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* renamed from: e */
    public final void m51225e(Context context) {
        try {
            SharedPreferences.Editor m51222a = C2431i.m51222a(context, "pref1");
            int i = 0;
            while (true) {
                String[] strArr = this.f8405d;
                if (i < strArr.length) {
                    C2431i.m51214a(m51222a, strArr[i], 0L);
                    i++;
                } else {
                    C2431i.m51217a(m51222a);
                    return;
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static void m51241a(Context context, AMapLocation aMapLocation, AMapLocationStaticsEntity aMapLocationStaticsEntity) {
        int i;
        if (aMapLocation == null) {
            return;
        }
        try {
            if (!GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider()) && aMapLocation.getLocationType() != 1) {
                String str = m51235a(aMapLocation) ? "abroad" : "domestic";
                String str2 = "cache";
                if (aMapLocation.getErrorCode() != 0) {
                    int errorCode = aMapLocation.getErrorCode();
                    if (errorCode == 4 || errorCode == 5 || errorCode == 6 || errorCode == 11) {
                        str2 = TKDownloadReason.KSAD_TK_NET;
                    }
                    i = 0;
                } else {
                    int locationType = aMapLocation.getLocationType();
                    if (locationType == 5 || locationType == 6) {
                        str2 = TKDownloadReason.KSAD_TK_NET;
                    }
                    i = 1;
                }
                m51237a(context, "O016", str2, str, i, aMapLocation.getErrorCode(), aMapLocationStaticsEntity);
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "ReportUtil", "reportBatting");
        }
    }

    /* renamed from: b */
    public final void m51229b(Context context) {
        try {
            long m51186b = C2432j.m51186b() - this.f8404c;
            int i = this.f8403b;
            if (i != -1) {
                this.f8402a.append(this.f8403b, Long.valueOf(m51186b + this.f8402a.get(i, 0L).longValue()));
            }
            long m51186b2 = C2432j.m51186b() - this.f8407f;
            int i2 = this.f8406e;
            if (i2 != -1) {
                this.f8402a.append(this.f8406e, Long.valueOf(m51186b2 + this.f8402a.get(i2, 0L).longValue()));
            }
            SharedPreferences.Editor m51222a = C2431i.m51222a(context, "pref1");
            for (int i3 = 0; i3 < this.f8405d.length; i3++) {
                long longValue = this.f8402a.get(i3, 0L).longValue();
                if (longValue > 0 && longValue > C2431i.m51220a(context, "pref1", this.f8405d[i3], 0L)) {
                    C2431i.m51214a(m51222a, this.f8405d[i3], longValue);
                }
            }
            C2431i.m51217a(m51222a);
        } catch (Throwable th) {
            C2428b.m51299a(th, "ReportUtil", "saveLocationTypeAndMode");
        }
    }

    /* renamed from: a */
    public static void m51244a(Context context, long j, boolean z) {
        if (context != null) {
            try {
                if (AuthUtil.m51349a()) {
                    m51243a(context, j, z, "O015");
                }
            } catch (Throwable th) {
                C2428b.m51299a(th, "ReportUtil", "reportGPSLocUseTime");
            }
        }
    }

    /* renamed from: a */
    private static void m51243a(Context context, long j, boolean z, String str) {
        m51238a(context, str, !z ? "abroad" : "domestic", Long.valueOf(j).intValue());
    }

    /* renamed from: a */
    private static void m51237a(Context context, String str, String str2, String str3, int i, int i2, AMapLocationStaticsEntity aMapLocationStaticsEntity) {
        if (context != null) {
            try {
                if (AuthUtil.m51349a()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject.put("param_string_second", str3);
                    }
                    if (i != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", i);
                    }
                    if (i2 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_second", i2);
                    }
                    if (aMapLocationStaticsEntity != null) {
                        if (!TextUtils.isEmpty(aMapLocationStaticsEntity.m51728d())) {
                            jSONObject.put("dns", aMapLocationStaticsEntity.m51728d());
                        }
                        if (!TextUtils.isEmpty(aMapLocationStaticsEntity.m51725e())) {
                            jSONObject.put(DomainCampaignEx.LOOPBACK_DOMAIN, aMapLocationStaticsEntity.m51725e());
                        }
                        if (!TextUtils.isEmpty(aMapLocationStaticsEntity.m51723f())) {
                            jSONObject.put("type", aMapLocationStaticsEntity.m51723f());
                        }
                        if (!TextUtils.isEmpty(aMapLocationStaticsEntity.m51721g())) {
                            jSONObject.put(MediationConstant.KEY_REASON, aMapLocationStaticsEntity.m51721g());
                        }
                        if (!TextUtils.isEmpty(aMapLocationStaticsEntity.m51731c())) {
                            jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, aMapLocationStaticsEntity.m51731c());
                        }
                        if (!TextUtils.isEmpty(aMapLocationStaticsEntity.m51734b())) {
                            jSONObject.put("stack", aMapLocationStaticsEntity.m51734b());
                        }
                        if (aMapLocationStaticsEntity.m51720h() > 0) {
                            jSONObject.put("ctime", String.valueOf(aMapLocationStaticsEntity.m51720h()));
                        }
                        if (aMapLocationStaticsEntity.m51737a() > 0) {
                            jSONObject.put("ntime", String.valueOf(aMapLocationStaticsEntity.m51737a()));
                        }
                    }
                    m51236a(context, str, jSONObject);
                }
            } catch (Throwable th) {
                C2428b.m51299a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    /* renamed from: a */
    private static void m51238a(Context context, String str, String str2, int i) {
        if (context != null) {
            try {
                if (AuthUtil.m51349a()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (!TextUtils.isEmpty(null)) {
                        jSONObject.put("param_string_second", (Object) null);
                    }
                    if (i != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", i);
                    }
                    m51236a(context, str, jSONObject);
                }
            } catch (Throwable th) {
                C2428b.m51299a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m51236a(Context context, String str, JSONObject jSONObject) {
        synchronized (ReportUtil.class) {
            if (context != null) {
                try {
                    if (AuthUtil.m51349a()) {
                        StatisticsEntity statisticsEntity = new StatisticsEntity(context, "loc", "6.4.3", str);
                        if (jSONObject != null) {
                            statisticsEntity.m55025a(jSONObject.toString());
                        }
                        f8400i.add(statisticsEntity);
                        if (f8400i.size() >= 30) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(f8400i);
                            StatisticsManager.m54907h(arrayList, context);
                            f8400i.clear();
                        }
                    }
                } catch (Throwable th) {
                    C2428b.m51299a(th, "ReportUtil", "applyStatistics");
                }
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m51247a(Context context) {
        synchronized (ReportUtil.class) {
            if (context != null) {
                try {
                    if (AuthUtil.m51349a()) {
                        List<StatisticsEntity> list = f8400i;
                        if (list != null && list.size() > 0) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(f8400i);
                            StatisticsManager.m54907h(arrayList, context);
                            f8400i.clear();
                        }
                        m51224f(context);
                    }
                } catch (Throwable th) {
                    C2428b.m51299a(th, "ReportUtil", "destroy");
                }
            }
        }
    }

    /* renamed from: a */
    public static void m51232a(String str, String str2) {
        try {
            SDKLogHandler.m53864o(C2428b.m51294c(), str2, str);
        } catch (Throwable th) {
            C2428b.m51299a(th, "ReportUtil", "reportLog");
        }
    }

    /* renamed from: a */
    public final void m51246a(Context context, int i) {
        try {
            int i2 = this.f8403b;
            if (i2 == i) {
                return;
            }
            if (i2 != -1 && i2 != i) {
                this.f8402a.append(this.f8403b, Long.valueOf((C2432j.m51186b() - this.f8404c) + this.f8402a.get(this.f8403b, 0L).longValue()));
            }
            this.f8404c = C2432j.m51186b() - C2431i.m51220a(context, "pref1", this.f8405d[i], 0L);
            this.f8403b = i;
        } catch (Throwable th) {
            C2428b.m51299a(th, "ReportUtil", "setLocationType");
        }
    }

    /* renamed from: a */
    public final void m51240a(Context context, AMapLocationClientOption aMapLocationClientOption) {
        try {
            int i = C24301.f8408a[aMapLocationClientOption.getLocationMode().ordinal()];
            int i2 = 3;
            if (i == 1) {
                i2 = 4;
            } else if (i == 2) {
                i2 = 5;
            } else if (i != 3) {
                i2 = -1;
            }
            int i3 = this.f8406e;
            if (i3 == i2) {
                return;
            }
            if (i3 != -1 && i3 != i2) {
                this.f8402a.append(this.f8406e, Long.valueOf((C2432j.m51186b() - this.f8407f) + this.f8402a.get(this.f8406e, 0L).longValue()));
            }
            this.f8407f = C2432j.m51186b() - C2431i.m51220a(context, "pref1", this.f8405d[i2], 0L);
            this.f8406e = i2;
        } catch (Throwable th) {
            C2428b.m51299a(th, "ReportUtil", "setLocationMode");
        }
    }

    /* renamed from: a */
    public static void m51245a(Context context, int i, int i2, long j, long j2) {
        if (i == -1 || i2 == -1) {
            return;
        }
        try {
            m51239a(context, "O012", i, i2, j, j2);
        } catch (Throwable th) {
            C2428b.m51299a(th, "ReportUtil", "reportServiceAliveTime");
        }
    }

    /* renamed from: a */
    private static void m51239a(Context context, String str, int i, int i2, long j, long j2) {
        if (context != null) {
            try {
                if (AuthUtil.m51349a()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("param_int_first", i);
                    jSONObject.put("param_int_second", i2);
                    jSONObject.put("param_long_first", j);
                    jSONObject.put("param_long_second", j2);
                    m51236a(context, str, jSONObject);
                }
            } catch (Throwable th) {
                C2428b.m51299a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0034 A[Catch: all -> 0x00f0, TRY_LEAVE, TryCatch #0 {all -> 0x00f0, blocks: (B:4:0x0003, B:8:0x000b, B:26:0x0034, B:37:0x0047, B:39:0x004b, B:40:0x0052, B:42:0x008b, B:45:0x0098, B:46:0x00d9, B:48:0x00eb, B:43:0x0091), top: B:58:0x0003 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void m51242a(android.content.Context r8, com.amap.api.location.AMapLocation r9) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.ReportUtil.m51242a(android.content.Context, com.amap.api.location.AMapLocation):void");
    }

    /* renamed from: a */
    public static void m51233a(String str, int i) {
        m51231a(str, String.valueOf(i), m51249a(i));
    }

    /* renamed from: a */
    public static void m51231a(String str, String str2, String str3) {
        try {
            SDKLogHandler.m53868k(C2428b.m51294c(), "/mobile/binary", str3, str, str2);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static void m51230a(String str, Throwable th) {
        try {
            if (th instanceof AMapCoreException) {
                SDKLogHandler.m53869j(C2428b.m51294c(), str, (AMapCoreException) th);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static void m51234a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        try {
            if (f8398g == null) {
                if (!C2432j.m51197a(aMapLocation)) {
                    f8398g = aMapLocation2;
                    return;
                }
                f8398g = aMapLocation.m60094clone();
            }
            if (C2432j.m51197a(f8398g) && C2432j.m51197a(aMapLocation2)) {
                AMapLocation m60094clone = aMapLocation2.m60094clone();
                if (f8398g.getLocationType() != 1 && f8398g.getLocationType() != 9 && !GeocodeSearch.GPS.equalsIgnoreCase(f8398g.getProvider()) && f8398g.getLocationType() != 7 && m60094clone.getLocationType() != 1 && m60094clone.getLocationType() != 9 && !GeocodeSearch.GPS.equalsIgnoreCase(m60094clone.getProvider()) && m60094clone.getLocationType() != 7) {
                    long abs = Math.abs(m60094clone.getTime() - f8398g.getTime()) / 1000;
                    if (abs <= 0) {
                        abs = 1;
                    }
                    if (abs <= 1800) {
                        float m51196a = C2432j.m51196a(f8398g, m60094clone);
                        float f = m51196a / ((float) abs);
                        if (m51196a > 30000.0f && f > 1000.0f) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(f8398g.getLatitude());
                            sb.append(",");
                            sb.append(f8398g.getLongitude());
                            sb.append(",");
                            sb.append(f8398g.getAccuracy());
                            sb.append(",");
                            sb.append(f8398g.getLocationType());
                            sb.append(",");
                            if (aMapLocation.getTime() != 0) {
                                sb.append(C2432j.m51205a(f8398g.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb.append(f8398g.getTime());
                            }
                            sb.append("#");
                            sb.append(m60094clone.getLatitude());
                            sb.append(",");
                            sb.append(m60094clone.getLongitude());
                            sb.append(",");
                            sb.append(m60094clone.getAccuracy());
                            sb.append(",");
                            sb.append(m60094clone.getLocationType());
                            sb.append(",");
                            if (m60094clone.getTime() != 0) {
                                sb.append(C2432j.m51205a(m60094clone.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb.append(m60094clone.getTime());
                            }
                            m51232a("bigshiftstatistics", sb.toString());
                            sb.delete(0, sb.length());
                        }
                    }
                }
                f8398g = m60094clone;
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static void m51248a(long j, long j2) {
        try {
            if (f8399h) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("gpsTime:");
            stringBuffer.append(C2432j.m51205a(j, "yyyy-MM-dd HH:mm:ss.SSS"));
            stringBuffer.append(",");
            stringBuffer.append("sysTime:");
            stringBuffer.append(C2432j.m51205a(j2, "yyyy-MM-dd HH:mm:ss.SSS"));
            stringBuffer.append(",");
            long m51312u = AuthUtil.m51312u();
            String m51205a = 0 != m51312u ? C2432j.m51205a(m51312u, "yyyy-MM-dd HH:mm:ss.SSS") : "0";
            stringBuffer.append("serverTime:");
            stringBuffer.append(m51205a);
            m51232a("checkgpstime", stringBuffer.toString());
            if (0 != m51312u && Math.abs(j - m51312u) < 31536000000L) {
                stringBuffer.append(", correctError");
                m51232a("checkgpstimeerror", stringBuffer.toString());
            }
            stringBuffer.delete(0, stringBuffer.length());
            f8399h = true;
        } catch (Throwable unused) {
        }
    }
}
