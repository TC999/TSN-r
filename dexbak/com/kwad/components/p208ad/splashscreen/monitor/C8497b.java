package com.kwad.components.p208ad.splashscreen.monitor;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.offline.api.p341tk.model.StyleTemplate;
import com.kwad.components.p208ad.splashscreen.C8489h;
import com.kwad.components.p208ad.splashscreen.p277b.C8363a;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.diskcache.p394b.C10291a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.components.ad.splashscreen.monitor.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8497b {

    /* renamed from: CU */
    private static volatile C8497b f27897CU;

    /* renamed from: S */
    private static StyleTemplate m30579S(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate m25668k = C10484b.m25668k(adTemplate, C10484b.m25687dr(adTemplate));
        StyleTemplate styleTemplate = new StyleTemplate();
        if (m25668k != null) {
            styleTemplate.templateId = m25668k.templateId;
            styleTemplate.templateMd5 = m25668k.templateMd5;
            styleTemplate.templateUrl = m25668k.templateUrl;
            styleTemplate.templateVersionCode = (int) m25668k.templateVersionCode;
        }
        return styleTemplate;
    }

    /* renamed from: Z */
    public static void m30578Z(@NonNull AdTemplate adTemplate) {
        C9815b.m27660k(new SplashMonitorInfo().setStatus(1).setType(C10483a.m25876bd(C10487e.m25641dQ(adTemplate)) ? 2 : 1).setLoadProcessType(C10251d.m26527a(C8363a.f27628CQ) ? 1L : 2L).setAdTemplate(adTemplate));
    }

    /* renamed from: a */
    public static void m30577a(@NonNull AdTemplate adTemplate, int i, long j, long j2) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        C9815b.m27663h(new SplashMonitorInfo().setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(3).setLoadDataTime(adTemplate.loadDataTime).setCheckStatus(i).setCheckDataTime(elapsedRealtime).setBeforeLoadDataTime(j2).setLoadProcessType(C10251d.m26527a(C8363a.f27628CQ) ? 1L : 2L).setLoadAndCheckDataTime(adTemplate.loadDataTime + elapsedRealtime).setPreloadId(C10483a.m25936aZ(C10487e.m25641dQ(adTemplate))).setAdTemplate(adTemplate));
    }

    /* renamed from: aa */
    public static void m30570aa(@NonNull AdTemplate adTemplate) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        C9815b.m27660k(new SplashMonitorInfo().setStatus(4).setCreativeId(C10483a.m25978J(m25641dQ)).setType(C10483a.m25876bd(m25641dQ) ? 2 : 1).setAdTemplate(adTemplate));
    }

    /* renamed from: ab */
    public static void m30569ab(@Nullable AdTemplate adTemplate) {
        String str;
        boolean z;
        int i;
        AdMatrixInfo.SplashPlayCardTKInfo m25715dd = C10484b.m25715dd(adTemplate);
        boolean z2 = true;
        if (TextUtils.isEmpty(m25715dd.templateId)) {
            str = SplashMonitorInfo.TEMPLATE_ID_EMPTY;
            z = true;
        } else {
            str = "";
            z = false;
        }
        if (m25715dd.renderType != 1) {
            str = str + SplashMonitorInfo.TEMPLATE_RENER_TYPE_ERROR;
            i = m25715dd.renderType;
        } else {
            i = -1;
            z2 = z;
        }
        if (z2) {
            C9815b.m27658m(new SplashMonitorInfo().setErrorMsg(str).setErrorCode(i).setAdTemplate(adTemplate));
        }
    }

    /* renamed from: ac */
    public static void m30568ac(AdTemplate adTemplate) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        C9815b.m27660k(new SplashMonitorInfo().setStatus(3001).setMaterialType(2).setPreloadId(C10483a.m25936aZ(m25641dQ)).setCreativeId(C10483a.m25978J(m25641dQ)).setUrl(C10483a.m25941aU(m25641dQ).materialUrl).setAdTemplate(adTemplate));
    }

    /* renamed from: ad */
    public static void m30567ad(AdTemplate adTemplate) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        C9815b.m27660k(new SplashMonitorInfo().setStatus(3002).setMaterialType(2).setPreloadId(C10483a.m25936aZ(m25641dQ)).setCreativeId(C10483a.m25978J(m25641dQ)).setUrl(C10483a.m25941aU(m25641dQ).materialUrl).setAdTemplate(adTemplate));
    }

    /* renamed from: ae */
    public static void m30566ae(AdTemplate adTemplate) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        C9815b.m27660k(new SplashMonitorInfo().setStatus(3003).setMaterialType(2).setPreloadId(C10483a.m25936aZ(m25641dQ)).setCreativeId(C10483a.m25978J(m25641dQ)).setUrl(C10483a.m25941aU(m25641dQ).materialUrl).setAdTemplate(adTemplate));
    }

    /* renamed from: b */
    public static void m30564b(@NonNull AdTemplate adTemplate, int i, long j, long j2) {
        String str;
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        if (C10483a.m25877bc(m25641dQ)) {
            str = C10483a.m25977K(m25641dQ);
        } else {
            str = C10483a.m25941aU(m25641dQ).materialUrl;
        }
        C9815b.m27663h(new SplashMonitorInfo().setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(5).setCheckStatus(i).setLoadDataTime(adTemplate.loadDataTime).setCheckDataTime(elapsedRealtime).setBeforeLoadDataTime(j2).setLoadAndCheckDataTime(adTemplate.loadDataTime + elapsedRealtime).setPreloadId(C10483a.m25936aZ(m25641dQ)).setUrl(str).setAdTemplate(adTemplate));
    }

    /* renamed from: c */
    public static void m30559c(boolean z, int i, String str, long j) {
        C9815b.m27663h(new SplashMonitorInfo().setStatus(4).setType(z ? 2 : 1).setErrorCode(i).setErrorMsg(str).setPosId(j));
    }

    /* renamed from: d */
    public static void m30557d(@NonNull AdTemplate adTemplate, long j) {
        C9815b.m27663h(new SplashMonitorInfo().setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(2).setBeforeLoadDataTime(j).setLoadDataTime(adTemplate.loadDataTime).setLoadProcessType(C10251d.m26527a(C8363a.f27628CQ) ? 1L : 2L).setPreloadId(C10483a.m25936aZ(C10487e.m25641dQ(adTemplate))).setAdTemplate(adTemplate));
    }

    /* renamed from: e */
    public static void m30554e(@NonNull AdTemplate adTemplate, long j) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        C9815b.m27660k(new SplashMonitorInfo().setStatus(5).setType(C10483a.m25876bd(m25641dQ) ? 2 : 1).setCostTime(j).setCreativeId(C10483a.m25978J(m25641dQ)).setPreloadId(C10483a.m25936aZ(m25641dQ)).setAdTemplate(adTemplate));
    }

    /* renamed from: f */
    public static void m30553f(long j, long j2) {
        C9815b.m27663h(new SplashMonitorInfo().setStatus(11).setBeforeLoadDataTime(j2).setLoadProcessType(C10251d.m26527a(C8363a.f27628CQ) ? 1L : 2L).setPosId(j));
    }

    /* renamed from: h */
    public static void m30551h(@NonNull AdResultData adResultData) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
            arrayList.add(String.valueOf(C10483a.m25978J(C10487e.m25641dQ(adTemplate))));
            arrayList2.add(C10483a.m25936aZ(C10487e.m25641dQ(adTemplate)));
        }
        C9815b.m27661j(new SplashMonitorInfo().setTotalCount(adResultData.getAdTemplateList().size()).setCreativeIds(arrayList).setPreloadIds(arrayList2).setPosId(adResultData.getPosId()));
    }

    /* renamed from: kV */
    public static C8497b m30550kV() {
        if (f27897CU == null) {
            synchronized (C8497b.class) {
                if (f27897CU == null) {
                    f27897CU = new C8497b();
                }
            }
        }
        return f27897CU;
    }

    /* renamed from: p */
    public static void m30549p(long j) {
        C9815b.m27663h(new SplashMonitorInfo().setStatus(1).setLoadProcessType(C10251d.m26527a(C8363a.f27628CQ) ? 1L : 2L).setPosId(j));
    }

    /* renamed from: q */
    public static void m30548q(long j) {
        C9815b.m27662i(new SplashMonitorInfo().setStatus(1).setPosId(j));
    }

    /* renamed from: f */
    public static void m30552f(@NonNull AdTemplate adTemplate, long j) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        C9815b.m27660k(new SplashMonitorInfo().setStatus(2).setType(C10483a.m25876bd(m25641dQ) ? 2 : 1).setCostTime(j).setCreativeId(C10483a.m25978J(m25641dQ)).setPreloadId(C10483a.m25936aZ(m25641dQ)).setLoadProcessType(C10251d.m26527a(C8363a.f27628CQ) ? 1L : 2L).setAdTemplate(adTemplate));
    }

    /* renamed from: c */
    public final void m30560c(AdTemplate adTemplate, String str) {
        long m25700dl;
        StyleTemplate m30579S = m30579S(adTemplate);
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(103).setTkRenderType(C10484b.m25711df(adTemplate)).setTemplateId(m30579S.templateId).setTemplateVersionCode(m30579S.templateVersionCode);
        C10487e.m25641dQ(adTemplate);
        if (C8489h.m30626U(adTemplate)) {
            m25700dl = C10484b.m25713de(adTemplate);
        } else {
            m25700dl = C10484b.m25700dl(C10487e.m25641dQ(adTemplate));
        }
        C9815b.m27660k(templateVersionCode.setTkDefaultTimeout(m25700dl).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    /* renamed from: e */
    public static void m30555e(@NonNull AdTemplate adTemplate, int i, String str) {
        String m25977K;
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        boolean m25876bd = C10483a.m25876bd(m25641dQ);
        SplashMonitorInfo type = new SplashMonitorInfo().setStatus(3).setCreativeId(C10483a.m25978J(m25641dQ)).setPreloadId(C10483a.m25936aZ(m25641dQ)).setType(m25876bd ? 2 : 1);
        if (m25876bd) {
            m25977K = C10483a.m25941aU(m25641dQ).materialUrl;
        } else {
            m25977K = C10483a.m25977K(m25641dQ);
        }
        C9815b.m27660k(type.setUrl(m25977K).setErrorCode(i).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    /* renamed from: d */
    public static void m30558d(@NonNull AdTemplate adTemplate, int i, String str) {
        String str2;
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        if (C10483a.m25877bc(m25641dQ)) {
            str2 = C10483a.m25977K(m25641dQ);
        } else {
            str2 = C10483a.m25941aU(m25641dQ).materialUrl;
        }
        C9815b.m27664g(true, new SplashMonitorInfo().setStatus(2).setPreloadId(C10483a.m25936aZ(m25641dQ)).setCreativeId(C10483a.m25978J(m25641dQ)).setUrl(str2).setErrorCode(i).setErrorMsg(str).setMaterialType(C10483a.m25877bc(m25641dQ) ? 1 : 2).setType(1).setAdTemplate(adTemplate));
    }

    /* renamed from: a */
    public static void m30571a(@NonNull List<AdTemplate> list, long j, long j2) {
        ArrayList arrayList = new ArrayList();
        for (AdTemplate adTemplate : list) {
            arrayList.add(C10483a.m25936aZ(C10487e.m25641dQ(adTemplate)));
        }
        C9815b.m27662i(new SplashMonitorInfo().setStatus(2).setIds(arrayList).setLoadDataTime(j).setCount(list.size()).setPosId(j2));
    }

    /* renamed from: b */
    public static void m30565b(int i, String str, long j) {
        C9815b.m27662i(new SplashMonitorInfo().setStatus(3).setErrorCode(i).setErrorMsg(str).setPosId(j));
    }

    /* renamed from: c */
    public static void m30561c(AdTemplate adTemplate, StyleTemplate styleTemplate) {
        long m25700dl;
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(106).setTkRenderType(C10484b.m25711df(adTemplate)).setTemplateId(styleTemplate.templateId).setTemplateVersionCode(styleTemplate.templateVersionCode);
        C10487e.m25641dQ(adTemplate);
        if (C8489h.m30626U(adTemplate)) {
            m25700dl = C10484b.m25713de(adTemplate);
        } else {
            m25700dl = C10484b.m25700dl(C10487e.m25641dQ(adTemplate));
        }
        C9815b.m27660k(templateVersionCode.setTkDefaultTimeout(m25700dl).setAdTemplate(adTemplate));
    }

    /* renamed from: b */
    public static void m30562b(boolean z, int i, String str, long j) {
        C9815b.m27655n(new SplashMonitorInfo().setStatus(4).setType(z ? 2 : 1).setErrorCode(i).setErrorMsg(str).setPosId(j));
    }

    /* renamed from: a */
    public static void m30576a(@NonNull AdTemplate adTemplate, long j, int i) {
        String str;
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        if (C10483a.m25877bc(m25641dQ)) {
            str = C10483a.m25977K(m25641dQ);
        } else {
            str = C10483a.m25941aU(m25641dQ).materialUrl;
        }
        File m26391bV = C10291a.m26395Dc().m26391bV(C10483a.m25936aZ(m25641dQ));
        C9815b.m27664g(false, new SplashMonitorInfo().setStatus(1).setPreloadId(C10483a.m25936aZ(m25641dQ)).setCostTime(j).setCacheValidTime(m25641dQ.adPreloadInfo.validityPeriod * 1000).setSize((m26391bV == null || !m26391bV.exists()) ? 0L : m26391bV.length()).setUrl(str).setMaterialType(C10483a.m25877bc(m25641dQ) ? 1 : 2).setType(i).setAdTemplate(adTemplate));
    }

    /* renamed from: d */
    public final void m30556d(AdTemplate adTemplate, String str) {
        long m25700dl;
        StyleTemplate m30579S = m30579S(adTemplate);
        SplashMonitorInfo errorMsg = new SplashMonitorInfo().setStatus(105).setTemplateId(m30579S.templateId).setTemplateVersionCode(m30579S.templateVersionCode).setTkRenderType(C10484b.m25711df(adTemplate)).setErrorMsg(str);
        C10487e.m25641dQ(adTemplate);
        if (C8489h.m30626U(adTemplate)) {
            m25700dl = C10484b.m25713de(adTemplate);
        } else {
            m25700dl = C10484b.m25700dl(C10487e.m25641dQ(adTemplate));
        }
        C9815b.m27660k(errorMsg.setTkDefaultTimeout(m25700dl).setAdTemplate(adTemplate));
    }

    /* renamed from: b */
    public static void m30563b(AdTemplate adTemplate, StyleTemplate styleTemplate) {
        long m25700dl;
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(102).setTemplateId(styleTemplate.templateId).setTkRenderType(C10484b.m25711df(adTemplate)).setTemplateVersionCode(styleTemplate.templateVersionCode);
        C10487e.m25641dQ(adTemplate);
        if (C8489h.m30626U(adTemplate)) {
            m25700dl = C10484b.m25713de(adTemplate);
        } else {
            m25700dl = C10484b.m25700dl(C10487e.m25641dQ(adTemplate));
        }
        C9815b.m27660k(templateVersionCode.setTkDefaultTimeout(m25700dl).setAdTemplate(adTemplate));
    }

    /* renamed from: a */
    public static void m30575a(@NonNull AdTemplate adTemplate, long j, boolean z) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        C9815b.m27660k(new SplashMonitorInfo().setStatus(6).setCreativeId(C10483a.m25978J(m25641dQ)).setViewSource(z ? 1 : 2).setLoadDataTime(elapsedRealtime).setType(C10483a.m25876bd(m25641dQ) ? 2 : 1).setAdTemplate(adTemplate));
    }

    /* renamed from: a */
    public static void m30572a(@Nullable AdTemplate adTemplate, String str, boolean z) {
        if (adTemplate == null) {
            C9815b.m27659l(new SplashMonitorInfo().setErrorMsg(str).setViewSource(z ? 1 : 2));
        } else {
            C9815b.m27659l(new SplashMonitorInfo().setCreativeId(C10483a.m25978J(C10487e.m25641dQ(adTemplate))).setErrorMsg(str).setViewSource(z ? 1 : 2).setAdTemplate(adTemplate));
        }
    }

    /* renamed from: a */
    public static void m30574a(AdTemplate adTemplate, StyleTemplate styleTemplate) {
        long m25700dl;
        SplashMonitorInfo tkRenderType = new SplashMonitorInfo().setStatus(101).setTemplateId(styleTemplate.templateId).setTemplateVersionCode(styleTemplate.templateVersionCode).setTkRenderType(C10484b.m25711df(adTemplate));
        C10487e.m25641dQ(adTemplate);
        if (C8489h.m30626U(adTemplate)) {
            m25700dl = C10484b.m25713de(adTemplate);
        } else {
            m25700dl = C10484b.m25700dl(C10487e.m25641dQ(adTemplate));
        }
        C9815b.m27660k(tkRenderType.setTkDefaultTimeout(m25700dl).setAdTemplate(adTemplate));
    }

    /* renamed from: a */
    public static void m30573a(AdTemplate adTemplate, StyleTemplate styleTemplate, int i, long j, int i2, long j2, long j3, long j4, long j5, long j6) {
        long m25700dl;
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(104).setTemplateId(styleTemplate.templateId).setTkRenderType(C10484b.m25711df(adTemplate)).setTemplateVersionCode(styleTemplate.templateVersionCode);
        C10487e.m25641dQ(adTemplate);
        if (C8489h.m30626U(adTemplate)) {
            m25700dl = C10484b.m25713de(adTemplate);
        } else {
            m25700dl = C10484b.m25700dl(C10487e.m25641dQ(adTemplate));
        }
        C9815b.m27660k(templateVersionCode.setTkDefaultTimeout(m25700dl).setSoSource(i).setSoLoadTime(j).setOfflineSource(i2).setOfflineLoadTime(j2).setTkFileLoadTime(j3).setTkInitTime(j4).setTkRenderTime(j5).setTkTotalTime(j6).setAdTemplate(adTemplate));
    }
}
