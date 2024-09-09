package com.kwad.components.ad.reward.monitor;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.components.core.s.f;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {
    public static void K(AdTemplate adTemplate) {
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.c(true, (com.kwad.sdk.commercial.c.a) new RewardMonitorInfo().setPageStatus(7).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setAdTemplate(adTemplate));
    }

    public static void L(AdTemplate adTemplate) {
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.c(true, (com.kwad.sdk.commercial.c.a) new RewardMonitorInfo().setPageStatus(8).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setAdTemplate(adTemplate));
    }

    public static void a(boolean z3, long j4) {
        com.kwad.sdk.commercial.b.a(z3, new RewardMonitorInfo().setLoadStatus(1).setPosId(j4), com.kwai.adclient.kscommerciallogger.model.a.aTL);
    }

    public static void b(boolean z3, long j4) {
        com.kwad.sdk.commercial.b.a(z3, new RewardMonitorInfo().setLoadStatus(5).setPosId(j4), com.kwai.adclient.kscommerciallogger.model.a.aTL);
    }

    public static void c(boolean z3, long j4) {
        com.kwad.sdk.commercial.b.a(z3, new RewardMonitorInfo().setLoadStatus(6).setPosId(j4), com.kwai.adclient.kscommerciallogger.model.a.aTL);
    }

    public static void d(boolean z3, @NonNull AdTemplate adTemplate) {
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.a(z3, new RewardMonitorInfo().setLoadStatus(7).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dQ) * 1000).setAdTemplate(adTemplate), com.kwai.adclient.kscommerciallogger.model.a.aTL);
    }

    public static void e(boolean z3, AdTemplate adTemplate) {
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.c(z3, new RewardMonitorInfo().setPageStatus(6).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dQ) * 1000).setAdTemplate(adTemplate));
    }

    public static void f(boolean z3, AdTemplate adTemplate) {
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.c(z3, new RewardMonitorInfo().setPageStatus(5).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dQ) * 1000).setAdTemplate(adTemplate));
    }

    public static void g(boolean z3, AdTemplate adTemplate) {
        com.kwad.sdk.commercial.b.f(new RewardWebViewInfo().setEvent("ad_show").setSceneId(z3 ? "ad_reward" : "ad_fullscreen").setAdTemplate(adTemplate));
    }

    public static void h(boolean z3, AdTemplate adTemplate) {
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.c(z3, new RewardMonitorInfo().setPageStatus(3).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dQ) * 1000).setAdTemplate(adTemplate));
    }

    public static void i(boolean z3, @Nullable AdTemplate adTemplate) {
        String str;
        if (adTemplate != null) {
            if (f.az(adTemplate.mDataCacheTraceElement)) {
                str = "data_cache";
            } else if (f.az(adTemplate.mDataLoadTraceElement)) {
                str = "data_load";
            }
            com.kwad.sdk.commercial.b.c(z3, new RewardMonitorInfo().setPageStatus(101).setLaunchFrom(str).setSubStage(PageCreateStage.START_LAUNCH.getStage()).setAdTemplate(adTemplate));
        }
        str = "unknown";
        com.kwad.sdk.commercial.b.c(z3, new RewardMonitorInfo().setPageStatus(101).setLaunchFrom(str).setSubStage(PageCreateStage.START_LAUNCH.getStage()).setAdTemplate(adTemplate));
    }

    private static boolean k(long j4) {
        return j4 == -1;
    }

    public static void a(boolean z3, @NonNull AdTemplate adTemplate, int i4, long j4) {
        long loadDataTime = (j4 <= 0 || adTemplate.getLoadDataTime() <= 0) ? -1L : adTemplate.getLoadDataTime() - j4;
        long j5 = a(loadDataTime) ? -1L : loadDataTime;
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.a(z3, new RewardMonitorInfo().setLoadStatus(2).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setAdCount(i4).setLoadDataDuration(j5).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dQ) * 1000).setAdTemplate(adTemplate), com.kwai.adclient.kscommerciallogger.model.a.aTL);
    }

    public static void b(boolean z3, AdTemplate adTemplate, int i4, long j4) {
        adTemplate.setDownloadFinishTime(SystemClock.elapsedRealtime());
        AdInfo dQ = e.dQ(adTemplate);
        long loadDataTime = adTemplate.getLoadDataTime() - j4;
        long downloadFinishTime = adTemplate.getDownloadFinishTime() - adTemplate.getLoadDataTime();
        long downloadFinishTime2 = adTemplate.getDownloadFinishTime() - j4;
        if (a(loadDataTime, downloadFinishTime, downloadFinishTime2)) {
            loadDataTime = -1;
            downloadFinishTime = -1;
            downloadFinishTime2 = -1;
        }
        com.kwad.sdk.commercial.b.a(z3, new RewardMonitorInfo().setLoadStatus(3).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setAdCount(i4).setLoadDataDuration(loadDataTime).setDownloadDuration(downloadFinishTime).setTotalDuration(downloadFinishTime2).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dQ) * 1000).setAdTemplate(adTemplate), com.kwai.adclient.kscommerciallogger.model.a.aTL);
    }

    public static void c(AdTemplate adTemplate, int i4, String str) {
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.c(true, (com.kwad.sdk.commercial.c.a) new RewardMonitorInfo().setPageStatus(9).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setErrorMsg(str).setErrorCode(i4).setAdTemplate(adTemplate));
    }

    public static void c(boolean z3, @Nullable AdTemplate adTemplate, String str) {
        com.kwad.sdk.commercial.b.c(z3, new RewardMonitorInfo().setPageStatus(101).setSubStage(str).setAdTemplate(adTemplate));
    }

    public static void a(boolean z3, int i4, String str, long j4) {
        com.kwad.sdk.commercial.b.a(z3, new RewardMonitorInfo().setLoadStatus(4).setErrorCode(i4).setErrorMsg(str).setPosId(j4), com.kwai.adclient.kscommerciallogger.model.a.aTH);
    }

    public static void b(boolean z3, AdTemplate adTemplate, long j4) {
        long j5 = -1;
        if (!k(j4)) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - j4;
            if (!a(elapsedRealtime)) {
                j5 = elapsedRealtime;
            }
        }
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.c(z3, new RewardMonitorInfo().setPageStatus(2).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setRenderDuration(j5).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dQ) * 1000).setAdTemplate(adTemplate));
    }

    public static void a(boolean z3, AdTemplate adTemplate, String str) {
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.b(z3, new RewardMonitorInfo().setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dQ) * 1000).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    public static void a(boolean z3, AdTemplate adTemplate, long j4) {
        a(z3, adTemplate, j4, (AdGlobalConfigInfo) null);
    }

    public static void a(boolean z3, AdTemplate adTemplate, long j4, AdGlobalConfigInfo adGlobalConfigInfo) {
        long loadDataTime = adTemplate.getLoadDataTime();
        long downloadFinishTime = adTemplate.getDownloadFinishTime();
        long j5 = loadDataTime > 0 ? j4 - loadDataTime : 0L;
        long j6 = downloadFinishTime > 0 ? j4 - downloadFinishTime : 0L;
        int i4 = 0;
        i4 = (adGlobalConfigInfo == null || adGlobalConfigInfo.neoPageType == 1) ? 3 : 3;
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.c(z3, new RewardMonitorInfo().setPageStatus(1).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setAdSceneType(i4).setDataLoadInterval(j5).setDataDownloadInterval(j6).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dQ) * 1000).setAdTemplate(adTemplate));
    }

    public static void b(boolean z3, AdTemplate adTemplate, String str) {
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.c(z3, new RewardMonitorInfo().setPageStatus(4).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dQ) * 1000).setInterceptReason(str).setAdTemplate(adTemplate));
    }

    public static void a(boolean z3, String str) {
        com.kwad.sdk.commercial.b.f(new RewardWebViewInfo().setPageType(str).setEvent("webview_init").setSceneId(z3 ? "ad_reward" : "ad_fullscreen"));
    }

    public static void a(AdTemplate adTemplate, boolean z3, String str, String str2) {
        com.kwad.sdk.commercial.b.f(new RewardWebViewInfo().setPageType(str).setEvent("webview_load_url").setSceneId(z3 ? "ad_reward" : "ad_fullscreen").setUrl(str2).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, boolean z3, String str, String str2, long j4, int i4) {
        com.kwad.sdk.commercial.b.f(new RewardWebViewInfo().setPageType(str).setEvent("webview_timeout").setSceneId(z3 ? "ad_reward" : "ad_fullscreen").setDurationMs(j4).setTimeType(i4).setUrl(str2).setAdTemplate(adTemplate));
    }

    public static void a(boolean z3, String str, String str2, long j4) {
        com.kwad.sdk.commercial.b.f(new RewardWebViewInfo().setPageType(str).setEvent("webview_load_finish").setSceneId(z3 ? "ad_reward" : "ad_fullscreen").setDurationMs(j4).setUrl(str2));
    }

    public static void a(boolean z3, @Nullable AdTemplate adTemplate, a aVar, long j4, @Nullable com.kwad.sdk.g.a<RewardMonitorInfo> aVar2) {
        com.kwad.sdk.commercial.b.e(z3, new RewardMonitorInfo().setCallbackType(aVar.getTypeValue()).setAdTemplate(adTemplate).setPosId(j4));
    }

    public static void a(boolean z3, a aVar, AdTemplate adTemplate, @Nullable com.kwad.sdk.g.a<RewardMonitorInfo> aVar2) {
        if (adTemplate == null) {
            return;
        }
        RewardMonitorInfo adTemplate2 = new RewardMonitorInfo().setMaterialType(com.kwad.sdk.core.response.b.a.be(e.dQ(adTemplate))).setCallbackType(aVar.getTypeValue()).setAdTemplate(adTemplate);
        if (aVar2 != null) {
            aVar2.accept(adTemplate2);
        }
        com.kwad.sdk.commercial.b.d(z3, adTemplate2);
    }

    public static void a(boolean z3, AdTemplate adTemplate, long j4, int i4, long j5) {
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.f(z3, new RewardMonitorInfo().setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setCurrentDuration(j4).setErrorCode(i4).setErrorMsg(String.valueOf(j5)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setVideoDuration(com.kwad.sdk.core.response.b.a.M(dQ)).setAdTemplate(adTemplate));
    }

    public static void a(boolean z3, @Nullable AdTemplate adTemplate, String str, String str2) {
        com.kwad.sdk.commercial.b.c(z3, new RewardMonitorInfo().setPageStatus(101).setSubStage(str).setErrorMsg(str2).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, int i4, int i5, boolean z3) {
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.g(new RewardMonitorInfo().setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setRewardType(!z3 ? 1 : 0).setTaskType(i4).setTaskStep(i5).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dQ) * 1000).setAdTemplate(adTemplate));
    }

    private static boolean a(long... jArr) {
        for (long j4 : jArr) {
            if (j4 >= 60000) {
                return true;
            }
        }
        return false;
    }
}
