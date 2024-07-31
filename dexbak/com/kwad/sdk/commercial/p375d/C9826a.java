package com.kwad.sdk.commercial.p375d;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.commercial.C9821c;
import com.kwad.sdk.commercial.C9825d;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* renamed from: com.kwad.sdk.commercial.d.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9826a {
    /* renamed from: a */
    private static void m27620a(AdTemplate adTemplate, AbstractC9822a abstractC9822a) {
        abstractC9822a.setAdTemplate(adTemplate);
        C9815b.m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(0.001d).m27634a(C9825d.m27624aS(adTemplate)).m27635N("ad_convert_method_call", "method_name").m27625u(abstractC9822a));
    }

    /* renamed from: bc */
    public static void m27619bc(AdTemplate adTemplate) {
        try {
            m27620a(adTemplate, C9827b.m27596AM().m27592cy("adClick"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: bd */
    public static void m27618bd(AdTemplate adTemplate) {
        try {
            m27620a(adTemplate, C9827b.m27596AM().m27592cy("startH5Page"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: be */
    public static void m27617be(AdTemplate adTemplate) {
        try {
            m27620a(adTemplate, C9827b.m27596AM().m27592cy("dplinkStart"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: bf */
    public static void m27616bf(AdTemplate adTemplate) {
        try {
            m27620a(adTemplate, C9827b.m27596AM().m27592cy("smallAppSuccess"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: bg */
    public static void m27615bg(AdTemplate adTemplate) {
        try {
            m27620a(adTemplate, C9827b.m27596AM().m27592cy("appstoreStart"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: bh */
    public static void m27614bh(AdTemplate adTemplate) {
        try {
            m27620a(adTemplate, C9827b.m27596AM().m27592cy("disableClick"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: bi */
    public static void m27613bi(AdTemplate adTemplate) {
        try {
            m27620a(adTemplate, C9827b.m27596AM().m27592cy("toVideoH5Web"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: bj */
    public static void m27612bj(AdTemplate adTemplate) {
        try {
            m27620a(adTemplate, C9827b.m27596AM().m27592cy("toDownload"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: bk */
    public static void m27611bk(AdTemplate adTemplate) {
        try {
            m27620a(adTemplate, C9827b.m27596AM().m27592cy("toOpenApp"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: bl */
    public static void m27610bl(AdTemplate adTemplate) {
        try {
            m27620a(adTemplate, C9827b.m27596AM().m27592cy("toInstallApp"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: bm */
    public static void m27609bm(AdTemplate adTemplate) {
        try {
            m27620a(adTemplate, C9827b.m27596AM().m27592cy("toDownloadDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: bn */
    public static void m27608bn(AdTemplate adTemplate) {
        try {
            m27620a(adTemplate, C9827b.m27596AM().m27592cy("toDownloadThirdDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: bo */
    public static void m27607bo(AdTemplate adTemplate) {
        try {
            m27620a(adTemplate, C9827b.m27596AM().m27592cy("toDownloadPage"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: bp */
    public static void m27606bp(AdTemplate adTemplate) {
        try {
            m27620a(adTemplate, C9827b.m27596AM().m27592cy("toDownloadPause"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: bq */
    public static void m27605bq(AdTemplate adTemplate) {
        try {
            m27620a(adTemplate, C9827b.m27596AM().m27592cy("toDownloadResume"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: br */
    public static void m27604br(AdTemplate adTemplate) {
        try {
            m27620a(adTemplate, C9827b.m27596AM().m27592cy("toDownloadNoNet"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: bs */
    public static void m27603bs(AdTemplate adTemplate) {
        try {
            m27620a(adTemplate, C9827b.m27596AM().m27592cy("toDoNoting"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: bt */
    public static void m27602bt(AdTemplate adTemplate) {
        try {
            m27620a(adTemplate, C9827b.m27596AM().m27592cy("toOpenAppDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: bu */
    public static void m27601bu(AdTemplate adTemplate) {
        try {
            m27620a(adTemplate, C9827b.m27596AM().m27592cy("toOpenDeeplinkDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: bv */
    public static void m27600bv(AdTemplate adTemplate) {
        try {
            m27620a(adTemplate, C9827b.m27596AM().m27592cy("toH5PageDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: bw */
    public static void m27599bw(AdTemplate adTemplate) {
        try {
            m27620a(adTemplate, C9827b.m27596AM().m27592cy("toMiddlePageDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: bx */
    public static void m27598bx(AdTemplate adTemplate) {
        try {
            m27620a(adTemplate, C9827b.m27596AM().m27592cy("toSmallAppDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: f */
    public static void m27597f(AdTemplate adTemplate, boolean z) {
        try {
            m27620a(adTemplate, C9827b.m27596AM().m27592cy("adUserClick").m27595bk(z));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
