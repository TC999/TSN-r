package com.kwad.components.p208ad.feed.monitor;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.p208ad.feed.C7577c;
import com.kwad.components.p208ad.feed.monitor.FeedPageInfo;
import com.kwad.sdk.C10829k;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.commercial.C9821c;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.utils.C11126t;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.C11160a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.feed.monitor.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7601b {
    /* renamed from: a */
    public static void m32815a(AdTemplate adTemplate, int i, int i2, String str, String str2, long j) {
        if (i2 == 1 && adTemplate.mHasReportVideoLoad) {
            return;
        }
        if (i2 == 1) {
            adTemplate.mHasReportVideoLoad = true;
        }
        m32818a(new FeedPageInfo().setStatus(3).setType(adTemplate.type).setLoadStatus(i).setResourceLoadDuration(j).setMaterialType(i2).setMaterialUrl(str).setErrorMsg(str2).setAdTemplate(adTemplate), i == 2);
    }

    /* renamed from: aY */
    public static void m32809aY() {
        m32810a("ad_sdk_feed_adnum_monitor", new FeedErrorInfo(), 1.0E-4d);
    }

    /* renamed from: aZ */
    public static void m32808aZ() {
        C9815b.m27668f(new FeedWebViewInfo().setEvent("webview_init").setSceneId("ad_feed"));
    }

    /* renamed from: b */
    private static void m32806b(AbstractC9822a abstractC9822a) {
        try {
            C9815b.m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(0.01d).m27635N("ad_sdk_feed_callback", "callback_type").m27634a(BusinessType.AD_FEED).m27625u(abstractC9822a).m27632a(C11160a.aTL));
        } catch (Exception e) {
            C10331c.m26250e("reportFeedCallback", e.toString());
        }
    }

    /* renamed from: c */
    private static List<FeedPageInfo.C7599a> m32805c(List<KsFeedAd> list) {
        ArrayList arrayList = new ArrayList();
        for (KsFeedAd ksFeedAd : list) {
            if (ksFeedAd instanceof C7577c) {
                AdInfo m25641dQ = C10487e.m25641dQ(((C7577c) ksFeedAd).getAdTemplate());
                arrayList.add(new FeedPageInfo.C7599a().m32828d(C10483a.m25978J(m25641dQ)).m32826u(C10483a.m25875be(m25641dQ)).m32827o(C10483a.m25878bb(m25641dQ)));
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    public static void m32804d(int i, String str) {
        m32818a((AbstractC9822a) new FeedPageInfo().setStatus(9).setErrorCode(i).setErrorMsg(str), true);
    }

    /* renamed from: e */
    public static void m32803e(int i, String str) {
        m32818a(new FeedPageInfo().setStatus(10).setLoadStatus(i).setErrorMsg(str), i == 2);
    }

    /* renamed from: f */
    public static void m32801f(int i, String str) {
        m32810a("ad_sdk_feed_request_monitor", (FeedErrorInfo) new FeedErrorInfo().setErrorCode(i).setErrorMsg(str), 1.0d);
    }

    /* renamed from: s */
    public static void m32799s(int i) {
        m32819a(new FeedPageInfo().setStatus(1).setAdNum(i));
    }

    /* renamed from: t */
    public static void m32798t(int i) {
        m32819a(new FeedPageInfo().setStatus(2).setAdNum(i));
    }

    /* renamed from: f */
    public static void m32800f(AdTemplate adTemplate) {
        C9815b.m27668f(new FeedWebViewInfo().setEvent("ad_show").setSceneId("ad_feed").setAdTemplate(adTemplate));
    }

    /* renamed from: e */
    public static void m32802e(AdTemplate adTemplate) {
        m32819a(new FeedPageInfo().setStatus(11).setAdTemplate(adTemplate));
    }

    /* renamed from: b */
    public static void m32807b(int i, int i2, AdTemplate adTemplate) {
        m32810a("ad_sdk_feed_h5_monitor", (FeedErrorInfo) new FeedErrorInfo().setMaterialType(i2).setErrorCode(i).setAdTemplate(adTemplate), 1.0d);
    }

    /* renamed from: a */
    public static void m32816a(AdTemplate adTemplate, int i, int i2, long j, String str) {
        m32818a(new FeedPageInfo().setStatus(5).setType(adTemplate.type).setMaterialType(C10483a.m25875be(C10487e.m25641dQ(adTemplate))).setRenderType(i).setLoadType(adTemplate.loadType).setExpectedRenderType(i2).setErrorMsg(str).setRenderDuration(j).setAdTemplate(adTemplate), i != 2);
    }

    /* renamed from: a */
    public static void m32823a(int i, long j) {
        JSONObject jSONObject = new JSONObject();
        C11126t.putValue(jSONObject, "feedLoadOptimizeType", C10251d.m26565Bw());
        C11126t.putValue(jSONObject, "feedLoadOptimizeExternalEnable", C10251d.m26562Bz());
        C11126t.putValue(jSONObject, "isExternal", C10829k.m24699zd().m24703yp());
        m32819a(new FeedPageInfo().setStatus(6).setAdNum(i).setLoadDataDuration(j).setAbParams(jSONObject.toString()));
    }

    /* renamed from: a */
    public static void m32817a(AdTemplate adTemplate, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        C11126t.putValue(jSONObject, "feedLoadOptimizeType", C10251d.m26565Bw());
        C11126t.putValue(jSONObject, "feedLoadOptimizeExternalEnable", C10251d.m26562Bz());
        C11126t.putValue(jSONObject, "isExternal", C10829k.m24699zd().m24703yp());
        m32819a(new FeedPageInfo().setStatus(7).setType(adTemplate.type).setLoadType(adTemplate.loadType).setMaterialType(C10483a.m25875be(C10487e.m25641dQ(adTemplate))).setRenderType(i).setExpectedRenderType(i2).setAbParams(jSONObject.toString()).setAdTemplate(adTemplate));
    }

    /* renamed from: a */
    public static void m32814a(AdTemplate adTemplate, int i, long j) {
        m32819a(new FeedPageInfo().setStatus(8).setType(adTemplate.type).setMaterialType(C10483a.m25875be(C10487e.m25641dQ(adTemplate))).setRenderType(i).setConvertDuration(j).setAdTemplate(adTemplate));
    }

    /* renamed from: a */
    private static void m32819a(AbstractC9822a abstractC9822a) {
        m32818a(abstractC9822a, false);
    }

    /* renamed from: a */
    private static void m32818a(AbstractC9822a abstractC9822a, boolean z) {
        try {
            C9815b.m27672d(C9821c.m27636AJ().m27631cu(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).m27628i(z ? 1.0d : 0.001d).m27635N("ad_sdk_feed_load", "status").m27634a(BusinessType.AD_FEED).m27625u(abstractC9822a).m27632a(C11160a.aTL));
        } catch (Exception e) {
            C10331c.m26250e("reportFeedPageLineLog", e.toString());
        }
    }

    /* renamed from: a */
    public static void m32822a(int i, AdTemplate adTemplate, String str, int i2) {
        m32806b(new FeedPageInfo().setCallbackType(i).setMaterialType(C10483a.m25875be(C10487e.m25641dQ(adTemplate))).setMaterialUrl(str).setRenderType(i2).setAdTemplate(adTemplate));
    }

    /* renamed from: a */
    public static void m32820a(long j, List<KsFeedAd> list) {
        if (list == null || list.size() == 0 || !(list.get(0) instanceof C7577c)) {
            return;
        }
        m32806b(new FeedPageInfo().setCallbackType(1).setPosId(j).setMaterialInfoList(m32805c(list)).setAdTemplate(((C7577c) list.get(0)).getAdTemplate()));
    }

    /* renamed from: a */
    private static void m32810a(String str, FeedErrorInfo feedErrorInfo, double d) {
        try {
            C9815b.m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.ERROR_LOG).m27634a(BusinessType.AD_FEED).m27635N(str, "default").m27630cv(str).m27632a(C11160a.aTL).m27625u(feedErrorInfo).m27628i(d));
        } catch (Exception e) {
            C10331c.m26254d("reportFeedError", e.toString());
        }
    }

    /* renamed from: a */
    public static void m32824a(int i, int i2, AdTemplate adTemplate) {
        m32810a("ad_sdk_feed_showType_monitor", (FeedErrorInfo) new FeedErrorInfo().setMaterialType(i).setFeedType(i2).setAdTemplate(adTemplate), 1.0d);
    }

    /* renamed from: a */
    public static void m32821a(long j, int i, int i2, AdTemplate adTemplate) {
        m32810a("ad_sdk_feed_width_monitor", (FeedErrorInfo) new FeedErrorInfo().setWidth(j).setMaterialType(i).setFeedType(i2).setAdTemplate(adTemplate), 1.0d);
    }

    /* renamed from: a */
    public static void m32813a(AdTemplate adTemplate, String str) {
        C9815b.m27668f(new FeedWebViewInfo().setEvent("webview_load_url").setSceneId("ad_feed").setUrl(str).setAdTemplate(adTemplate));
    }

    /* renamed from: a */
    public static void m32811a(AdTemplate adTemplate, String str, long j, int i) {
        C9815b.m27668f(new FeedWebViewInfo().setEvent("webview_timeout").setSceneId("ad_feed").setTimeType(i).setDurationMs(j).setUrl(str).setAdTemplate(adTemplate));
    }

    /* renamed from: a */
    public static void m32812a(AdTemplate adTemplate, String str, long j) {
        C9815b.m27668f(new FeedWebViewInfo().setEvent("webview_load_finish").setSceneId("ad_feed").setDurationMs(j).setUrl(str).setAdTemplate(adTemplate));
    }
}
