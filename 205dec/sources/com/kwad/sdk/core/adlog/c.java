package com.kwad.sdk.core.adlog;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.report.h;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.ay;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {
    private static ExecutorService apm = GlobalThreadPools.FG();
    public static JSONObject apn;
    public static boolean apo;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int code;
        public String msg;

        public a(int i4, String str) {
            this.code = i4;
            this.msg = str;
        }
    }

    private static int Bg() {
        return ai.isOrientationPortrait() ? 2 : 1;
    }

    private static boolean G(AdInfo adInfo) {
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar == null) {
            return false;
        }
        String ay = com.kwad.sdk.core.response.b.a.ay(adInfo);
        if (TextUtils.isEmpty(ay)) {
            return false;
        }
        return ak.an(fVar.getContext(), ay);
    }

    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar, @Nullable JSONObject jSONObject) {
        if (aVar != null) {
            try {
                if (adTemplate.fromCache) {
                    aVar.a(h.bW(adTemplate));
                }
                aVar.e(adTemplate, null, null);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
                return;
            }
        }
        a(adTemplate, 2, aVar, jSONObject);
    }

    public static void bE(AdTemplate adTemplate) {
        q(adTemplate, 4);
    }

    public static void bF(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        a(adTemplate, 30, aVar, (JSONObject) null);
    }

    public static void bG(AdTemplate adTemplate) {
        q(adTemplate, 36);
    }

    public static void bH(AdTemplate adTemplate) {
        q(adTemplate, 38);
    }

    public static void bI(AdTemplate adTemplate) {
        q(adTemplate, 41);
    }

    public static void bJ(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.apZ = com.kwad.sdk.core.response.b.a.ay(e.dQ(adTemplate));
        a(adTemplate, 768, aVar, new JSONObject());
    }

    public static void bK(@Nullable AdTemplate adTemplate) {
        f(adTemplate, null);
    }

    public static void bL(@Nullable AdTemplate adTemplate) {
        g(adTemplate, (JSONObject) null);
    }

    public static void bM(@Nullable AdTemplate adTemplate) {
        q(adTemplate, 58);
    }

    public static void bN(AdTemplate adTemplate) {
        q(adTemplate, 914);
    }

    public static void bO(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadStatus = com.kwad.sdk.core.response.b.a.bx(e.dQ(adTemplate));
        com.kwad.sdk.core.e.c.d("AdReportManager", "reportDownloadCardClose downloadStatus=" + aVar.downloadStatus);
        a(adTemplate, (int) MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_RETRY_COUNT, aVar, (JSONObject) null);
    }

    public static void bP(AdTemplate adTemplate) {
        q(adTemplate, 722);
    }

    public static void bQ(AdTemplate adTemplate) {
        q(adTemplate, 721);
    }

    private static boolean bR(AdTemplate adTemplate) {
        if (e.dI(adTemplate)) {
            return true;
        }
        f fVar = (f) ServiceProvider.get(f.class);
        return fVar != null && fVar.aF(adTemplate);
    }

    public static void c(final AdTemplate adTemplate, final JSONObject jSONObject) {
        apm.submit(new ay() { // from class: com.kwad.sdk.core.adlog.c.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                com.kwad.sdk.core.adlog.c.b cN = new com.kwad.sdk.core.adlog.c.b().cN(AdTemplate.this.downloadSource);
                c.a(AdTemplate.this, cN);
                c.a(AdTemplate.this, 31, cN.Bs(), jSONObject);
                AdInfo dQ = e.dQ(AdTemplate.this);
                ak.av(dQ.downloadFilePath, dQ.downloadId);
            }
        });
    }

    public static void d(AdTemplate adTemplate, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        a(adTemplate, 35, aVar, jSONObject);
    }

    public static void e(final AdTemplate adTemplate, final JSONObject jSONObject) {
        apm.submit(new ay() { // from class: com.kwad.sdk.core.adlog.c.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                AdInfo dQ = e.dQ(AdTemplate.this);
                int aw = ak.aw(dQ.downloadId, com.kwad.sdk.core.response.b.a.ay(dQ));
                com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
                AdTemplate adTemplate2 = AdTemplate.this;
                aVar.downloadSource = adTemplate2.downloadSource;
                aVar.apU = aw;
                aVar.apV = adTemplate2.installFrom;
                c.a(adTemplate2, 32, aVar, jSONObject);
            }
        });
    }

    public static void f(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 399, jSONObject);
    }

    public static void g(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 400, jSONObject);
    }

    public static void h(AdTemplate adTemplate, int i4) {
        adTemplate.mInstallApkFromSDK = true;
        adTemplate.mInstallApkFormUser = i4 == 1;
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aql = i4;
        a(adTemplate, 37, aVar, (JSONObject) null);
    }

    public static void i(AdTemplate adTemplate, int i4) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.KI = i4;
        a(adTemplate, (int) MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE, aVar, (JSONObject) null);
    }

    public static void j(@Nullable AdTemplate adTemplate, int i4) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.apT = i4;
        b(adTemplate, "wxsmallapp", 1, aVar);
    }

    public static void k(@Nullable AdTemplate adTemplate, int i4) {
        d(adTemplate, i4, 0);
    }

    public static void l(AdTemplate adTemplate, int i4) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.apJ = i4;
        a(adTemplate, 759, aVar, (JSONObject) null);
    }

    public static void m(AdTemplate adTemplate, int i4) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.apI = i4;
        a(adTemplate, 28, aVar, (JSONObject) null);
    }

    public static void n(AdTemplate adTemplate, int i4) {
        if (adTemplate == null) {
            return;
        }
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.apZ = com.kwad.sdk.core.response.b.a.ay(e.dQ(adTemplate));
        a(adTemplate, i4, aVar, new JSONObject());
    }

    public static void o(AdTemplate adTemplate, int i4) {
        a(adTemplate, i4, new com.kwad.sdk.core.adlog.c.a(), new JSONObject());
    }

    @Deprecated
    public static void p(AdTemplate adTemplate, int i4) {
        e(adTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cM(i4));
    }

    private static void q(AdTemplate adTemplate, int i4) {
        a(adTemplate, i4, (com.kwad.sdk.core.adlog.c.a) null, new JSONObject());
    }

    public static boolean b(@NonNull AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable com.kwad.sdk.core.adlog.c.b bVar) {
        if (adTemplate.mPvReported) {
            return false;
        }
        adTemplate.mPvReported = true;
        AdInfo dQ = e.dQ(adTemplate);
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        bVar.cY(Bg());
        com.kwad.sdk.core.adlog.c.a Bs = bVar.Bs();
        if (adTemplate.fromCache) {
            Bs.a(h.bW(adTemplate));
        }
        Bs.aqg = G(dQ) ? 1 : 0;
        return a(adTemplate, 1, Bs, jSONObject);
    }

    public static void c(@Nullable AdTemplate adTemplate, String str, int i4) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.apR = i4;
        if (!str.equals("")) {
            aVar.apS = str;
        }
        a(adTemplate, (int) MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_RECONNECT_COUNT, aVar, (JSONObject) null);
    }

    public static void e(AdTemplate adTemplate, int i4, int i5) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.apL = 69;
        aVar.aqb = i4;
        aVar.aqc = i5;
        a(adTemplate, (int) MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_PROTOCOL_HANDLE, aVar, (JSONObject) null);
    }

    public static void g(AdTemplate adTemplate, boolean z3) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a.C0688a c0688a = new a.C0688a();
        c0688a.ape = 1;
        bVar.b(c0688a);
        if (z3) {
            bVar.cT(33);
        }
        a(adTemplate, (int) MediaPlayer.MEDIA_PLAYER_OPTION_RTC_RECONNECT_INTERVAL, bVar.Bs(), (JSONObject) null);
    }

    public static void k(@Nullable AdTemplate adTemplate, long j4) {
        a(adTemplate, 52, com.kwad.sdk.core.adlog.c.a.Br().ag(j4), (JSONObject) null);
    }

    public static void d(@Nullable AdTemplate adTemplate, int i4, int i5) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aqf = i4;
        aVar.KJ = i5;
        a(adTemplate, (int) MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL, aVar, (JSONObject) null);
    }

    public static void i(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, (int) MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_SOCKET_CONNECT_TIME, jSONObject);
    }

    public static void j(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, (int) MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_PACKET_RECV_TIME, jSONObject);
    }

    public static void l(AdTemplate adTemplate, long j4) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.apN = j4;
        a(adTemplate, 600, aVar, (JSONObject) null);
    }

    public static void m(AdTemplate adTemplate, long j4) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aqe = j4;
        a(adTemplate, 401, aVar, (JSONObject) null);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i4, @Nullable ac.a aVar) {
        com.kwad.sdk.core.adlog.c.a aVar2 = new com.kwad.sdk.core.adlog.c.a();
        aVar2.kl = i4;
        if (aVar != null) {
            aVar2.kn = aVar;
        }
        a(adTemplate, aVar2, (JSONObject) null);
    }

    public static void h(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, (int) MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_PROTOCOL_HANDLE, jSONObject);
    }

    public static void c(AdTemplate adTemplate, @Nullable JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        a(adTemplate, (int) MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_PACKET_RECV_TIME, bVar != null ? bVar.Bs() : null, (JSONObject) null);
    }

    public static void e(AdTemplate adTemplate, JSONObject jSONObject, @Nullable com.kwad.sdk.core.adlog.c.b bVar) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        com.kwad.sdk.core.adlog.c.a Bs = bVar.Bs();
        Bs.e(adTemplate, null, null);
        a(adTemplate, 141, Bs, jSONObject);
    }

    public static void h(AdTemplate adTemplate, boolean z3) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a.C0688a c0688a = new a.C0688a();
        c0688a.ape = 2;
        bVar.b(c0688a);
        if (z3) {
            bVar.cT(33);
        }
        a(adTemplate, (int) MediaPlayer.MEDIA_PLAYER_OPTION_RTC_RECONNECT_INTERVAL, bVar.Bs(), (JSONObject) null);
    }

    public static void d(AdTemplate adTemplate, @Nullable JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        com.kwad.sdk.core.adlog.c.a Bs = bVar.Bs();
        Bs.e(adTemplate, null, null);
        a(adTemplate, 140, Bs, jSONObject);
    }

    public static void c(AdTemplate adTemplate, int i4, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.apZ = com.kwad.sdk.core.response.b.a.ay(e.dQ(adTemplate));
        aVar.apL = 93;
        a(adTemplate, 140, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.b bVar, JSONObject jSONObject) {
        a(adTemplate, bVar != null ? bVar.Bs() : null, jSONObject);
    }

    public static void a(AdTemplate adTemplate, long j4, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        a.C0688a c0688a = new a.C0688a();
        if (j4 != -1) {
            c0688a.duration = j4;
            aVar.KH = c0688a;
        }
        a(adTemplate, 934, aVar, (JSONObject) null);
    }

    public static void b(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.b bVar, @Nullable JSONObject jSONObject) {
        a(adTemplate, 3, bVar != null ? bVar.Bs() : null, jSONObject);
    }

    private static void d(AdTemplate adTemplate, int i4, JSONObject jSONObject) {
        a(adTemplate, i4, (com.kwad.sdk.core.adlog.c.a) null, jSONObject);
    }

    public static void b(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        a(adTemplate, 34, aVar, jSONObject);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i4, long j4, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.apK = i4;
        a.C0688a c0688a = new a.C0688a();
        c0688a.duration = j4;
        aVar.KH = c0688a;
        a(adTemplate, 3, aVar, jSONObject);
    }

    public static void b(@Nullable AdTemplate adTemplate, String str, int i4, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null) {
            aVar = new com.kwad.sdk.core.adlog.c.a();
        }
        aVar.apR = i4;
        if (!str.equals("")) {
            aVar.apS = str;
        }
        a(adTemplate, (int) MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RENDER_STALL_THRESHOLD, aVar, (JSONObject) null);
    }

    public static void b(@Nullable AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar) {
        a(adTemplate, 59, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i4, long j4, int i5, long j5, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.vz = j4;
        aVar.aqi = i5;
        aVar.apK = i4;
        a.C0688a c0688a = new a.C0688a();
        c0688a.duration = j5;
        aVar.KH = c0688a;
        a(adTemplate, 3, aVar, (JSONObject) null);
    }

    @Deprecated
    public static void b(AdTemplate adTemplate, int i4, @Nullable JSONObject jSONObject) {
        d(adTemplate, jSONObject, new com.kwad.sdk.core.adlog.c.b().cM(i4));
    }

    public static void a(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        a(adTemplate, 33, aVar, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.b bVar) {
        AdInfo dQ = e.dQ(adTemplate);
        String str = dQ.downloadFilePath;
        if (str == null) {
            return;
        }
        String ay = com.kwad.sdk.core.response.b.a.ay(dQ);
        String gF = ak.gF(str);
        if (gF == null || TextUtils.isEmpty(gF) || gF.equals(ay)) {
            return;
        }
        bVar.df(gF);
        bVar.de(ay);
        dQ.adBaseInfo.appPackageName = gF;
    }

    public static void a(AdTemplate adTemplate, a aVar) {
        com.kwad.sdk.core.adlog.c.a aVar2 = new com.kwad.sdk.core.adlog.c.a();
        aVar2.apW = aVar.toJson().toString();
        a(adTemplate, 40, aVar2, (JSONObject) null);
    }

    public static void a(@Nullable AdTemplate adTemplate, String str, int i4, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null) {
            aVar = new com.kwad.sdk.core.adlog.c.a();
        }
        aVar.apR = i4;
        if (!str.equals("")) {
            aVar.apS = str;
        }
        a(adTemplate, 320, aVar, (JSONObject) null);
    }

    public static void a(@Nullable AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar) {
        a(adTemplate, 50, aVar, (JSONObject) null);
    }

    public static void a(@Nullable AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar, long j4) {
        aVar.aqd = j4;
        a(adTemplate, 51, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i4, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.apI = i4;
        a(adTemplate, 402, aVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i4, AdExposureFailedReason adExposureFailedReason) {
        if (i4 == 0 || i4 == 1 || i4 == 2 || i4 == 3 || i4 == 4) {
            com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
            aVar.apO = i4;
            if (adExposureFailedReason != null && i4 == 2) {
                aVar.apP = adExposureFailedReason.winEcpm;
                try {
                    int i5 = adExposureFailedReason.adnType;
                    aVar.adnType = i5;
                    if (i5 == 2) {
                        aVar.adnName = adExposureFailedReason.adnName;
                    }
                } catch (Throwable unused) {
                }
            }
            a(adTemplate, (int) MediaPlayer.MEDIA_PLAYER_OPTION_RTC_START_TIME, aVar, (JSONObject) null);
        }
    }

    public static void a(AdTemplate adTemplate, int i4, JSONObject jSONObject, String str) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.KG = str;
        a(adTemplate, i4, aVar, jSONObject);
    }

    public static boolean a(@Nullable AdTemplate adTemplate, int i4, @Nullable com.kwad.sdk.core.adlog.c.a aVar, @Nullable JSONObject jSONObject) {
        if (adTemplate == null || !bR(adTemplate)) {
            return false;
        }
        if (aVar == null) {
            aVar = new com.kwad.sdk.core.adlog.c.a();
        }
        aVar.aqh = com.kwad.sdk.core.response.b.a.aT(e.dQ(adTemplate));
        aVar.adxResult = adTemplate.adxResult;
        if (i4 == 2 && apo) {
            if (aVar.KH == null) {
                aVar.KH = new a.C0688a();
            }
            aVar.KH.aph = apn;
        }
        aVar.adTemplate = adTemplate;
        aVar.aoM = i4;
        aVar.apH = jSONObject;
        StringBuilder sb = new StringBuilder();
        sb.append(i4);
        com.kwad.sdk.core.e.c.d("AdReportManager", sb.toString());
        b.a(aVar);
        return true;
    }
}
