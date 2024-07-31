package com.kwad.sdk.core.adlog;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.autonavi.base.p048ae.gmap.glyph.FontStyle;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.adlog.C9893a;
import com.kwad.sdk.core.adlog.p388c.C9912a;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.report.C10458h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11008ac;
import com.kwad.sdk.utils.C11015ai;
import com.kwad.sdk.utils.C11017ak;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.adlog.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9908c {
    private static ExecutorService apm = GlobalThreadPools.m25602FG();
    public static JSONObject apn;
    public static boolean apo;

    @KsJson
    /* renamed from: com.kwad.sdk.core.adlog.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9911a extends C10482a {
        public int code;
        public String msg;

        public C9911a(int i, String str) {
            this.code = i;
            this.msg = str;
        }
    }

    /* renamed from: Bg */
    private static int m27355Bg() {
        return C11015ai.isOrientationPortrait() ? 2 : 1;
    }

    /* renamed from: G */
    private static boolean m27354G(AdInfo adInfo) {
        InterfaceC10968f interfaceC10968f = (InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class);
        if (interfaceC10968f == null) {
            return false;
        }
        String m25911ay = C10483a.m25911ay(adInfo);
        if (TextUtils.isEmpty(m25911ay)) {
            return false;
        }
        return C11017ak.m24114an(interfaceC10968f.getContext(), m25911ay);
    }

    /* renamed from: a */
    public static void m27342a(AdTemplate adTemplate, C9912a c9912a, @Nullable JSONObject jSONObject) {
        if (c9912a != null) {
            try {
                if (adTemplate.fromCache) {
                    c9912a.m27283a(C10458h.m26022bW(adTemplate));
                }
                c9912a.m27272e(adTemplate, null, null);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
                return;
            }
        }
        m27350a(adTemplate, 2, c9912a, jSONObject);
    }

    /* renamed from: bE */
    public static void m27330bE(AdTemplate adTemplate) {
        m27286q(adTemplate, 4);
    }

    /* renamed from: bF */
    public static void m27329bF(AdTemplate adTemplate) {
        C9912a c9912a = new C9912a();
        c9912a.downloadSource = adTemplate.downloadSource;
        m27350a(adTemplate, 30, c9912a, (JSONObject) null);
    }

    /* renamed from: bG */
    public static void m27328bG(AdTemplate adTemplate) {
        m27286q(adTemplate, 36);
    }

    /* renamed from: bH */
    public static void m27327bH(AdTemplate adTemplate) {
        m27286q(adTemplate, 38);
    }

    /* renamed from: bI */
    public static void m27326bI(AdTemplate adTemplate) {
        m27286q(adTemplate, 41);
    }

    /* renamed from: bJ */
    public static void m27325bJ(AdTemplate adTemplate) {
        C9912a c9912a = new C9912a();
        c9912a.apZ = C10483a.m25911ay(C10487e.m25641dQ(adTemplate));
        m27350a(adTemplate, 768, c9912a, new JSONObject());
    }

    /* renamed from: bK */
    public static void m27324bK(@Nullable AdTemplate adTemplate) {
        m27305f(adTemplate, null);
    }

    /* renamed from: bL */
    public static void m27323bL(@Nullable AdTemplate adTemplate) {
        m27304g(adTemplate, (JSONObject) null);
    }

    /* renamed from: bM */
    public static void m27322bM(@Nullable AdTemplate adTemplate) {
        m27286q(adTemplate, 58);
    }

    /* renamed from: bN */
    public static void m27321bN(AdTemplate adTemplate) {
        m27286q(adTemplate, 914);
    }

    /* renamed from: bO */
    public static void m27320bO(AdTemplate adTemplate) {
        C9912a c9912a = new C9912a();
        c9912a.downloadStatus = C10483a.m25856bx(C10487e.m25641dQ(adTemplate));
        C10331c.m26254d("AdReportManager", "reportDownloadCardClose downloadStatus=" + c9912a.downloadStatus);
        m27350a(adTemplate, 713, c9912a, (JSONObject) null);
    }

    /* renamed from: bP */
    public static void m27319bP(AdTemplate adTemplate) {
        m27286q(adTemplate, 722);
    }

    /* renamed from: bQ */
    public static void m27318bQ(AdTemplate adTemplate) {
        m27286q(adTemplate, 721);
    }

    /* renamed from: bR */
    private static boolean m27317bR(AdTemplate adTemplate) {
        if (C10487e.m25649dI(adTemplate)) {
            return true;
        }
        InterfaceC10968f interfaceC10968f = (InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class);
        return interfaceC10968f != null && interfaceC10968f.mo24343aF(adTemplate);
    }

    /* renamed from: c */
    public static void m27314c(final AdTemplate adTemplate, final JSONObject jSONObject) {
        apm.submit(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.core.adlog.c.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C9913b m27263cN = new C9913b().m27263cN(AdTemplate.this.downloadSource);
                C9908c.m27341a(AdTemplate.this, m27263cN);
                C9908c.m27350a(AdTemplate.this, 31, m27263cN.m27270Bs(), jSONObject);
                AdInfo m25641dQ = C10487e.m25641dQ(AdTemplate.this);
                C11017ak.m24111av(m25641dQ.downloadFilePath, m25641dQ.downloadId);
            }
        });
    }

    /* renamed from: d */
    public static void m27310d(AdTemplate adTemplate, JSONObject jSONObject) {
        C9912a c9912a = new C9912a();
        c9912a.downloadSource = adTemplate.downloadSource;
        m27350a(adTemplate, 35, c9912a, jSONObject);
    }

    /* renamed from: e */
    public static void m27307e(final AdTemplate adTemplate, final JSONObject jSONObject) {
        apm.submit(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.core.adlog.c.2
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                AdInfo m25641dQ = C10487e.m25641dQ(AdTemplate.this);
                int m24110aw = C11017ak.m24110aw(m25641dQ.downloadId, C10483a.m25911ay(m25641dQ));
                C9912a c9912a = new C9912a();
                AdTemplate adTemplate2 = AdTemplate.this;
                c9912a.downloadSource = adTemplate2.downloadSource;
                c9912a.apU = m24110aw;
                c9912a.apV = adTemplate2.installFrom;
                C9908c.m27350a(adTemplate2, 32, c9912a, jSONObject);
            }
        });
    }

    /* renamed from: f */
    public static void m27305f(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        m27311d(adTemplate, 399, jSONObject);
    }

    /* renamed from: g */
    public static void m27304g(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        m27311d(adTemplate, (int) FontStyle.WEIGHT_NORMAL, jSONObject);
    }

    /* renamed from: h */
    public static void m27302h(AdTemplate adTemplate, int i) {
        adTemplate.mInstallApkFromSDK = true;
        adTemplate.mInstallApkFormUser = i == 1;
        C9912a c9912a = new C9912a();
        c9912a.aql = i;
        m27350a(adTemplate, 37, c9912a, (JSONObject) null);
    }

    /* renamed from: i */
    public static void m27299i(AdTemplate adTemplate, int i) {
        C9912a c9912a = new C9912a();
        c9912a.f29524KI = i;
        m27350a(adTemplate, 923, c9912a, (JSONObject) null);
    }

    /* renamed from: j */
    public static void m27297j(@Nullable AdTemplate adTemplate, int i) {
        C9912a c9912a = new C9912a();
        c9912a.apT = i;
        m27333b(adTemplate, "wxsmallapp", 1, c9912a);
    }

    /* renamed from: k */
    public static void m27295k(@Nullable AdTemplate adTemplate, int i) {
        m27312d(adTemplate, i, 0);
    }

    /* renamed from: l */
    public static void m27293l(AdTemplate adTemplate, int i) {
        C9912a c9912a = new C9912a();
        c9912a.apJ = i;
        m27350a(adTemplate, 759, c9912a, (JSONObject) null);
    }

    /* renamed from: m */
    public static void m27291m(AdTemplate adTemplate, int i) {
        C9912a c9912a = new C9912a();
        c9912a.apI = i;
        m27350a(adTemplate, 28, c9912a, (JSONObject) null);
    }

    /* renamed from: n */
    public static void m27289n(AdTemplate adTemplate, int i) {
        if (adTemplate == null) {
            return;
        }
        C9912a c9912a = new C9912a();
        c9912a.apZ = C10483a.m25911ay(C10487e.m25641dQ(adTemplate));
        m27350a(adTemplate, i, c9912a, new JSONObject());
    }

    /* renamed from: o */
    public static void m27288o(AdTemplate adTemplate, int i) {
        m27350a(adTemplate, i, new C9912a(), new JSONObject());
    }

    @Deprecated
    /* renamed from: p */
    public static void m27287p(AdTemplate adTemplate, int i) {
        m27306e(adTemplate, (JSONObject) null, new C9913b().m27264cM(i));
    }

    /* renamed from: q */
    private static void m27286q(AdTemplate adTemplate, int i) {
        m27350a(adTemplate, i, (C9912a) null, new JSONObject());
    }

    /* renamed from: b */
    public static boolean m27331b(@NonNull AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable C9913b c9913b) {
        if (adTemplate.mPvReported) {
            return false;
        }
        adTemplate.mPvReported = true;
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        if (c9913b == null) {
            c9913b = new C9913b();
        }
        c9913b.m27252cY(m27355Bg());
        C9912a m27270Bs = c9913b.m27270Bs();
        if (adTemplate.fromCache) {
            m27270Bs.m27283a(C10458h.m26022bW(adTemplate));
        }
        m27270Bs.aqg = m27354G(m25641dQ) ? 1 : 0;
        return m27350a(adTemplate, 1, m27270Bs, jSONObject);
    }

    /* renamed from: c */
    public static void m27315c(@Nullable AdTemplate adTemplate, String str, int i) {
        C9912a c9912a = new C9912a();
        c9912a.apR = i;
        if (!str.equals("")) {
            c9912a.apS = str;
        }
        m27350a(adTemplate, 803, c9912a, (JSONObject) null);
    }

    /* renamed from: e */
    public static void m27308e(AdTemplate adTemplate, int i, int i2) {
        C9912a c9912a = new C9912a();
        c9912a.apL = 69;
        c9912a.aqb = i;
        c9912a.aqc = i2;
        m27350a(adTemplate, 501, c9912a, (JSONObject) null);
    }

    /* renamed from: g */
    public static void m27303g(AdTemplate adTemplate, boolean z) {
        C9913b c9913b = new C9913b();
        C9893a.C9894a c9894a = new C9893a.C9894a();
        c9894a.ape = 1;
        c9913b.m27268b(c9894a);
        if (z) {
            c9913b.m27257cT(33);
        }
        m27350a(adTemplate, 804, c9913b.m27270Bs(), (JSONObject) null);
    }

    /* renamed from: k */
    public static void m27294k(@Nullable AdTemplate adTemplate, long j) {
        m27350a(adTemplate, 52, C9912a.m27285Br().m27281ag(j), (JSONObject) null);
    }

    /* renamed from: d */
    public static void m27312d(@Nullable AdTemplate adTemplate, int i, int i2) {
        C9912a c9912a = new C9912a();
        c9912a.aqf = i;
        c9912a.f29525KJ = i2;
        m27350a(adTemplate, 323, c9912a, (JSONObject) null);
    }

    /* renamed from: i */
    public static void m27298i(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        m27311d(adTemplate, 450, jSONObject);
    }

    /* renamed from: j */
    public static void m27296j(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        m27311d(adTemplate, 451, jSONObject);
    }

    /* renamed from: l */
    public static void m27292l(AdTemplate adTemplate, long j) {
        C9912a c9912a = new C9912a();
        c9912a.apN = j;
        m27350a(adTemplate, 600, c9912a, (JSONObject) null);
    }

    /* renamed from: m */
    public static void m27290m(AdTemplate adTemplate, long j) {
        C9912a c9912a = new C9912a();
        c9912a.aqe = j;
        m27350a(adTemplate, 401, c9912a, (JSONObject) null);
    }

    @Deprecated
    /* renamed from: a */
    public static void m27349a(AdTemplate adTemplate, int i, @Nullable C11008ac.C11009a c11009a) {
        C9912a c9912a = new C9912a();
        c9912a.f29528kl = i;
        if (c11009a != null) {
            c9912a.f29529kn = c11009a;
        }
        m27342a(adTemplate, c9912a, (JSONObject) null);
    }

    /* renamed from: h */
    public static void m27301h(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        m27311d(adTemplate, 501, jSONObject);
    }

    /* renamed from: c */
    public static void m27313c(AdTemplate adTemplate, @Nullable JSONObject jSONObject, C9913b c9913b) {
        m27350a(adTemplate, 451, c9913b != null ? c9913b.m27270Bs() : null, (JSONObject) null);
    }

    /* renamed from: e */
    public static void m27306e(AdTemplate adTemplate, JSONObject jSONObject, @Nullable C9913b c9913b) {
        if (c9913b == null) {
            c9913b = new C9913b();
        }
        C9912a m27270Bs = c9913b.m27270Bs();
        m27270Bs.m27272e(adTemplate, null, null);
        m27350a(adTemplate, (int) TTDownloadField.CALL_DOWNLOAD_MODEL_SET_BACKUP_URLS, m27270Bs, jSONObject);
    }

    /* renamed from: h */
    public static void m27300h(AdTemplate adTemplate, boolean z) {
        C9913b c9913b = new C9913b();
        C9893a.C9894a c9894a = new C9893a.C9894a();
        c9894a.ape = 2;
        c9913b.m27268b(c9894a);
        if (z) {
            c9913b.m27257cT(33);
        }
        m27350a(adTemplate, 804, c9913b.m27270Bs(), (JSONObject) null);
    }

    /* renamed from: d */
    public static void m27309d(AdTemplate adTemplate, @Nullable JSONObject jSONObject, C9913b c9913b) {
        if (c9913b == null) {
            c9913b = new C9913b();
        }
        C9912a m27270Bs = c9913b.m27270Bs();
        m27270Bs.m27272e(adTemplate, null, null);
        m27350a(adTemplate, 140, m27270Bs, jSONObject);
    }

    /* renamed from: c */
    public static void m27316c(AdTemplate adTemplate, int i, @Nullable JSONObject jSONObject) {
        C9912a c9912a = new C9912a();
        c9912a.apZ = C10483a.m25911ay(C10487e.m25641dQ(adTemplate));
        c9912a.apL = 93;
        m27350a(adTemplate, 140, c9912a, (JSONObject) null);
    }

    /* renamed from: a */
    public static void m27340a(AdTemplate adTemplate, C9913b c9913b, JSONObject jSONObject) {
        m27342a(adTemplate, c9913b != null ? c9913b.m27270Bs() : null, jSONObject);
    }

    /* renamed from: a */
    public static void m27346a(AdTemplate adTemplate, long j, @Nullable JSONObject jSONObject) {
        C9912a c9912a = new C9912a();
        C9893a.C9894a c9894a = new C9893a.C9894a();
        if (j != -1) {
            c9894a.duration = j;
            c9912a.f29523KH = c9894a;
        }
        m27350a(adTemplate, 934, c9912a, (JSONObject) null);
    }

    /* renamed from: b */
    public static void m27334b(AdTemplate adTemplate, C9913b c9913b, @Nullable JSONObject jSONObject) {
        m27350a(adTemplate, 3, c9913b != null ? c9913b.m27270Bs() : null, jSONObject);
    }

    /* renamed from: d */
    private static void m27311d(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        m27350a(adTemplate, i, (C9912a) null, jSONObject);
    }

    /* renamed from: b */
    public static void m27332b(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        C9912a c9912a = new C9912a();
        c9912a.downloadSource = adTemplate.downloadSource;
        m27350a(adTemplate, 34, c9912a, jSONObject);
    }

    @Deprecated
    /* renamed from: a */
    public static void m27352a(AdTemplate adTemplate, int i, long j, @Nullable JSONObject jSONObject) {
        C9912a c9912a = new C9912a();
        c9912a.apK = i;
        C9893a.C9894a c9894a = new C9893a.C9894a();
        c9894a.duration = j;
        c9912a.f29523KH = c9894a;
        m27350a(adTemplate, 3, c9912a, jSONObject);
    }

    /* renamed from: b */
    public static void m27333b(@Nullable AdTemplate adTemplate, String str, int i, C9912a c9912a) {
        if (c9912a == null) {
            c9912a = new C9912a();
        }
        c9912a.apR = i;
        if (!str.equals("")) {
            c9912a.apS = str;
        }
        m27350a(adTemplate, 321, c9912a, (JSONObject) null);
    }

    /* renamed from: b */
    public static void m27336b(@Nullable AdTemplate adTemplate, C9912a c9912a) {
        m27350a(adTemplate, 59, c9912a, (JSONObject) null);
    }

    /* renamed from: a */
    public static void m27353a(AdTemplate adTemplate, int i, long j, int i2, long j2, @Nullable JSONObject jSONObject) {
        C9912a c9912a = new C9912a();
        c9912a.f29531vz = j;
        c9912a.aqi = i2;
        c9912a.apK = i;
        C9893a.C9894a c9894a = new C9893a.C9894a();
        c9894a.duration = j2;
        c9912a.f29523KH = c9894a;
        m27350a(adTemplate, 3, c9912a, (JSONObject) null);
    }

    @Deprecated
    /* renamed from: b */
    public static void m27337b(AdTemplate adTemplate, int i, @Nullable JSONObject jSONObject) {
        m27309d(adTemplate, jSONObject, new C9913b().m27264cM(i));
    }

    /* renamed from: a */
    public static void m27338a(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        C9912a c9912a = new C9912a();
        c9912a.downloadSource = adTemplate.downloadSource;
        m27350a(adTemplate, 33, c9912a, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static void m27341a(AdTemplate adTemplate, C9913b c9913b) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        String str = m25641dQ.downloadFilePath;
        if (str == null) {
            return;
        }
        String m25911ay = C10483a.m25911ay(m25641dQ);
        String m24108gF = C11017ak.m24108gF(str);
        if (m24108gF == null || TextUtils.isEmpty(m24108gF) || m24108gF.equals(m25911ay)) {
            return;
        }
        c9913b.m27249df(m24108gF);
        c9913b.m27250de(m25911ay);
        m25641dQ.adBaseInfo.appPackageName = m24108gF;
    }

    /* renamed from: a */
    public static void m27345a(AdTemplate adTemplate, C9911a c9911a) {
        C9912a c9912a = new C9912a();
        c9912a.apW = c9911a.toJson().toString();
        m27350a(adTemplate, 40, c9912a, (JSONObject) null);
    }

    /* renamed from: a */
    public static void m27339a(@Nullable AdTemplate adTemplate, String str, int i, C9912a c9912a) {
        if (c9912a == null) {
            c9912a = new C9912a();
        }
        c9912a.apR = i;
        if (!str.equals("")) {
            c9912a.apS = str;
        }
        m27350a(adTemplate, (int) GlMapUtil.DEVICE_DISPLAY_DPI_HIGH, c9912a, (JSONObject) null);
    }

    /* renamed from: a */
    public static void m27344a(@Nullable AdTemplate adTemplate, C9912a c9912a) {
        m27350a(adTemplate, 50, c9912a, (JSONObject) null);
    }

    /* renamed from: a */
    public static void m27343a(@Nullable AdTemplate adTemplate, C9912a c9912a, long j) {
        c9912a.aqd = j;
        m27350a(adTemplate, 51, c9912a, (JSONObject) null);
    }

    /* renamed from: a */
    public static void m27348a(AdTemplate adTemplate, int i, @Nullable JSONObject jSONObject) {
        C9912a c9912a = new C9912a();
        c9912a.apI = i;
        m27350a(adTemplate, 402, c9912a, jSONObject);
    }

    /* renamed from: a */
    public static void m27351a(AdTemplate adTemplate, int i, AdExposureFailedReason adExposureFailedReason) {
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4) {
            C9912a c9912a = new C9912a();
            c9912a.apO = i;
            if (adExposureFailedReason != null && i == 2) {
                c9912a.apP = adExposureFailedReason.winEcpm;
                try {
                    int i2 = adExposureFailedReason.adnType;
                    c9912a.adnType = i2;
                    if (i2 == 2) {
                        c9912a.adnName = adExposureFailedReason.adnName;
                    }
                } catch (Throwable unused) {
                }
            }
            m27350a(adTemplate, 809, c9912a, (JSONObject) null);
        }
    }

    /* renamed from: a */
    public static void m27347a(AdTemplate adTemplate, int i, JSONObject jSONObject, String str) {
        C9912a c9912a = new C9912a();
        c9912a.f29522KG = str;
        m27350a(adTemplate, i, c9912a, jSONObject);
    }

    /* renamed from: a */
    public static boolean m27350a(@Nullable AdTemplate adTemplate, int i, @Nullable C9912a c9912a, @Nullable JSONObject jSONObject) {
        if (adTemplate == null || !m27317bR(adTemplate)) {
            return false;
        }
        if (c9912a == null) {
            c9912a = new C9912a();
        }
        c9912a.aqh = C10483a.m25942aT(C10487e.m25641dQ(adTemplate));
        c9912a.adxResult = adTemplate.adxResult;
        if (i == 2 && apo) {
            if (c9912a.f29523KH == null) {
                c9912a.f29523KH = new C9893a.C9894a();
            }
            c9912a.f29523KH.aph = apn;
        }
        c9912a.adTemplate = adTemplate;
        c9912a.aoM = i;
        c9912a.apH = jSONObject;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        C10331c.m26254d("AdReportManager", sb.toString());
        C9901b.m27395a(c9912a);
        return true;
    }
}
