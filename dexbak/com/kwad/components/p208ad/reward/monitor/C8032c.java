package com.kwad.components.p208ad.reward.monitor;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p330s.C8941f;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p434g.InterfaceC10761a;
import com.kwai.adclient.kscommerciallogger.model.C11160a;

/* renamed from: com.kwad.components.ad.reward.monitor.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8032c {
    /* renamed from: K */
    public static void m31777K(AdTemplate adTemplate) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        C9815b.m27673c(true, (AbstractC9822a) new RewardMonitorInfo().setPageStatus(7).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(C10483a.m25978J(m25641dQ)).setVideoUrl(C10483a.m25977K(m25641dQ)).setAdTemplate(adTemplate));
    }

    /* renamed from: L */
    public static void m31776L(AdTemplate adTemplate) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        C9815b.m27673c(true, (AbstractC9822a) new RewardMonitorInfo().setPageStatus(8).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(C10483a.m25978J(m25641dQ)).setVideoUrl(C10483a.m25977K(m25641dQ)).setAdTemplate(adTemplate));
    }

    /* renamed from: a */
    public static void m31771a(boolean z, long j) {
        C9815b.m27685a(z, new RewardMonitorInfo().setLoadStatus(1).setPosId(j), C11160a.aTL);
    }

    /* renamed from: b */
    public static void m31759b(boolean z, long j) {
        C9815b.m27685a(z, new RewardMonitorInfo().setLoadStatus(5).setPosId(j), C11160a.aTL);
    }

    /* renamed from: c */
    public static void m31754c(boolean z, long j) {
        C9815b.m27685a(z, new RewardMonitorInfo().setLoadStatus(6).setPosId(j), C11160a.aTL);
    }

    /* renamed from: d */
    public static void m31752d(boolean z, @NonNull AdTemplate adTemplate) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        C9815b.m27685a(z, new RewardMonitorInfo().setLoadStatus(7).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setCreativeId(C10483a.m25978J(m25641dQ)).setVideoUrl(C10483a.m25977K(m25641dQ)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setVideoDuration(C10483a.m25976L(m25641dQ) * 1000).setAdTemplate(adTemplate), C11160a.aTL);
    }

    /* renamed from: e */
    public static void m31751e(boolean z, AdTemplate adTemplate) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        C9815b.m27673c(z, new RewardMonitorInfo().setPageStatus(6).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(C10483a.m25978J(m25641dQ)).setVideoUrl(C10483a.m25977K(m25641dQ)).setVideoDuration(C10483a.m25976L(m25641dQ) * 1000).setAdTemplate(adTemplate));
    }

    /* renamed from: f */
    public static void m31750f(boolean z, AdTemplate adTemplate) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        C9815b.m27673c(z, new RewardMonitorInfo().setPageStatus(5).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(C10483a.m25978J(m25641dQ)).setVideoUrl(C10483a.m25977K(m25641dQ)).setVideoDuration(C10483a.m25976L(m25641dQ) * 1000).setAdTemplate(adTemplate));
    }

    /* renamed from: g */
    public static void m31749g(boolean z, AdTemplate adTemplate) {
        C9815b.m27668f(new RewardWebViewInfo().setEvent("ad_show").setSceneId(z ? "ad_reward" : "ad_fullscreen").setAdTemplate(adTemplate));
    }

    /* renamed from: h */
    public static void m31748h(boolean z, AdTemplate adTemplate) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        C9815b.m27673c(z, new RewardMonitorInfo().setPageStatus(3).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(C10483a.m25978J(m25641dQ)).setVideoUrl(C10483a.m25977K(m25641dQ)).setVideoDuration(C10483a.m25976L(m25641dQ) * 1000).setAdTemplate(adTemplate));
    }

    /* renamed from: i */
    public static void m31747i(boolean z, @Nullable AdTemplate adTemplate) {
        String str;
        if (adTemplate != null) {
            if (C8941f.m29557az(adTemplate.mDataCacheTraceElement)) {
                str = "data_cache";
            } else if (C8941f.m29557az(adTemplate.mDataLoadTraceElement)) {
                str = "data_load";
            }
            C9815b.m27673c(z, new RewardMonitorInfo().setPageStatus(101).setLaunchFrom(str).setSubStage(PageCreateStage.START_LAUNCH.getStage()).setAdTemplate(adTemplate));
        }
        str = "unknown";
        C9815b.m27673c(z, new RewardMonitorInfo().setPageStatus(101).setLaunchFrom(str).setSubStage(PageCreateStage.START_LAUNCH.getStage()).setAdTemplate(adTemplate));
    }

    /* renamed from: k */
    private static boolean m31746k(long j) {
        return j == -1;
    }

    /* renamed from: a */
    public static void m31769a(boolean z, @NonNull AdTemplate adTemplate, int i, long j) {
        long loadDataTime = (j <= 0 || adTemplate.getLoadDataTime() <= 0) ? -1L : adTemplate.getLoadDataTime() - j;
        long j2 = m31760a(loadDataTime) ? -1L : loadDataTime;
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        C9815b.m27685a(z, new RewardMonitorInfo().setLoadStatus(2).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setAdCount(i).setLoadDataDuration(j2).setCreativeId(C10483a.m25978J(m25641dQ)).setVideoUrl(C10483a.m25977K(m25641dQ)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setVideoDuration(C10483a.m25976L(m25641dQ) * 1000).setAdTemplate(adTemplate), C11160a.aTL);
    }

    /* renamed from: b */
    public static void m31758b(boolean z, AdTemplate adTemplate, int i, long j) {
        adTemplate.setDownloadFinishTime(SystemClock.elapsedRealtime());
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        long loadDataTime = adTemplate.getLoadDataTime() - j;
        long downloadFinishTime = adTemplate.getDownloadFinishTime() - adTemplate.getLoadDataTime();
        long downloadFinishTime2 = adTemplate.getDownloadFinishTime() - j;
        if (m31760a(loadDataTime, downloadFinishTime, downloadFinishTime2)) {
            loadDataTime = -1;
            downloadFinishTime = -1;
            downloadFinishTime2 = -1;
        }
        C9815b.m27685a(z, new RewardMonitorInfo().setLoadStatus(3).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setAdCount(i).setLoadDataDuration(loadDataTime).setDownloadDuration(downloadFinishTime).setTotalDuration(downloadFinishTime2).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(C10483a.m25978J(m25641dQ)).setVideoUrl(C10483a.m25977K(m25641dQ)).setVideoDuration(C10483a.m25976L(m25641dQ) * 1000).setAdTemplate(adTemplate), C11160a.aTL);
    }

    /* renamed from: c */
    public static void m31755c(AdTemplate adTemplate, int i, String str) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        C9815b.m27673c(true, (AbstractC9822a) new RewardMonitorInfo().setPageStatus(9).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(C10483a.m25978J(m25641dQ)).setVideoUrl(C10483a.m25977K(m25641dQ)).setErrorMsg(str).setErrorCode(i).setAdTemplate(adTemplate));
    }

    /* renamed from: c */
    public static void m31753c(boolean z, @Nullable AdTemplate adTemplate, String str) {
        C9815b.m27673c(z, new RewardMonitorInfo().setPageStatus(101).setSubStage(str).setAdTemplate(adTemplate));
    }

    /* renamed from: a */
    public static void m31772a(boolean z, int i, String str, long j) {
        C9815b.m27685a(z, new RewardMonitorInfo().setLoadStatus(4).setErrorCode(i).setErrorMsg(str).setPosId(j), C11160a.aTH);
    }

    /* renamed from: b */
    public static void m31757b(boolean z, AdTemplate adTemplate, long j) {
        long j2 = -1;
        if (!m31746k(j)) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - j;
            if (!m31760a(elapsedRealtime)) {
                j2 = elapsedRealtime;
            }
        }
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        C9815b.m27673c(z, new RewardMonitorInfo().setPageStatus(2).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setRenderDuration(j2).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(C10483a.m25978J(m25641dQ)).setVideoUrl(C10483a.m25977K(m25641dQ)).setVideoDuration(C10483a.m25976L(m25641dQ) * 1000).setAdTemplate(adTemplate));
    }

    /* renamed from: a */
    public static void m31764a(boolean z, AdTemplate adTemplate, String str) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        C9815b.m27676b(z, new RewardMonitorInfo().setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(C10483a.m25978J(m25641dQ)).setVideoUrl(C10483a.m25977K(m25641dQ)).setVideoDuration(C10483a.m25976L(m25641dQ) * 1000).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    /* renamed from: a */
    public static void m31768a(boolean z, AdTemplate adTemplate, long j) {
        m31766a(z, adTemplate, j, (AdGlobalConfigInfo) null);
    }

    /* renamed from: a */
    public static void m31766a(boolean z, AdTemplate adTemplate, long j, AdGlobalConfigInfo adGlobalConfigInfo) {
        long loadDataTime = adTemplate.getLoadDataTime();
        long downloadFinishTime = adTemplate.getDownloadFinishTime();
        long j2 = loadDataTime > 0 ? j - loadDataTime : 0L;
        long j3 = downloadFinishTime > 0 ? j - downloadFinishTime : 0L;
        int i = 0;
        i = (adGlobalConfigInfo == null || adGlobalConfigInfo.neoPageType == 1) ? 3 : 3;
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        C9815b.m27673c(z, new RewardMonitorInfo().setPageStatus(1).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setAdSceneType(i).setDataLoadInterval(j2).setDataDownloadInterval(j3).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(C10483a.m25978J(m25641dQ)).setVideoUrl(C10483a.m25977K(m25641dQ)).setVideoDuration(C10483a.m25976L(m25641dQ) * 1000).setAdTemplate(adTemplate));
    }

    /* renamed from: b */
    public static void m31756b(boolean z, AdTemplate adTemplate, String str) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        C9815b.m27673c(z, new RewardMonitorInfo().setPageStatus(4).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(C10483a.m25978J(m25641dQ)).setVideoUrl(C10483a.m25977K(m25641dQ)).setVideoDuration(C10483a.m25976L(m25641dQ) * 1000).setInterceptReason(str).setAdTemplate(adTemplate));
    }

    /* renamed from: a */
    public static void m31762a(boolean z, String str) {
        C9815b.m27668f(new RewardWebViewInfo().setPageType(str).setEvent("webview_init").setSceneId(z ? "ad_reward" : "ad_fullscreen"));
    }

    /* renamed from: a */
    public static void m31774a(AdTemplate adTemplate, boolean z, String str, String str2) {
        C9815b.m27668f(new RewardWebViewInfo().setPageType(str).setEvent("webview_load_url").setSceneId(z ? "ad_reward" : "ad_fullscreen").setUrl(str2).setAdTemplate(adTemplate));
    }

    /* renamed from: a */
    public static void m31773a(AdTemplate adTemplate, boolean z, String str, String str2, long j, int i) {
        C9815b.m27668f(new RewardWebViewInfo().setPageType(str).setEvent("webview_timeout").setSceneId(z ? "ad_reward" : "ad_fullscreen").setDurationMs(j).setTimeType(i).setUrl(str2).setAdTemplate(adTemplate));
    }

    /* renamed from: a */
    public static void m31761a(boolean z, String str, String str2, long j) {
        C9815b.m27668f(new RewardWebViewInfo().setPageType(str).setEvent("webview_load_finish").setSceneId(z ? "ad_reward" : "ad_fullscreen").setDurationMs(j).setUrl(str2));
    }

    /* renamed from: a */
    public static void m31765a(boolean z, @Nullable AdTemplate adTemplate, InterfaceC8030a interfaceC8030a, long j, @Nullable InterfaceC10761a<RewardMonitorInfo> interfaceC10761a) {
        C9815b.m27669e(z, new RewardMonitorInfo().setCallbackType(interfaceC8030a.getTypeValue()).setAdTemplate(adTemplate).setPosId(j));
    }

    /* renamed from: a */
    public static void m31770a(boolean z, InterfaceC8030a interfaceC8030a, AdTemplate adTemplate, @Nullable InterfaceC10761a<RewardMonitorInfo> interfaceC10761a) {
        if (adTemplate == null) {
            return;
        }
        RewardMonitorInfo adTemplate2 = new RewardMonitorInfo().setMaterialType(C10483a.m25875be(C10487e.m25641dQ(adTemplate))).setCallbackType(interfaceC8030a.getTypeValue()).setAdTemplate(adTemplate);
        if (interfaceC10761a != null) {
            interfaceC10761a.accept(adTemplate2);
        }
        C9815b.m27671d(z, adTemplate2);
    }

    /* renamed from: a */
    public static void m31767a(boolean z, AdTemplate adTemplate, long j, int i, long j2) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        C9815b.m27667f(z, new RewardMonitorInfo().setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setCurrentDuration(j).setErrorCode(i).setErrorMsg(String.valueOf(j2)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(C10483a.m25978J(m25641dQ)).setVideoUrl(C10483a.m25977K(m25641dQ)).setVideoDuration(C10483a.m25975M(m25641dQ)).setAdTemplate(adTemplate));
    }

    /* renamed from: a */
    public static void m31763a(boolean z, @Nullable AdTemplate adTemplate, String str, String str2) {
        C9815b.m27673c(z, new RewardMonitorInfo().setPageStatus(101).setSubStage(str).setErrorMsg(str2).setAdTemplate(adTemplate));
    }

    /* renamed from: a */
    public static void m31775a(AdTemplate adTemplate, int i, int i2, boolean z) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        C9815b.m27666g(new RewardMonitorInfo().setCreativeId(C10483a.m25978J(m25641dQ)).setRewardType(!z ? 1 : 0).setTaskType(i).setTaskStep(i2).setVideoUrl(C10483a.m25977K(m25641dQ)).setVideoDuration(C10483a.m25976L(m25641dQ) * 1000).setAdTemplate(adTemplate));
    }

    /* renamed from: a */
    private static boolean m31760a(long... jArr) {
        for (long j : jArr) {
            if (j >= 60000) {
                return true;
            }
        }
        return false;
    }
}
