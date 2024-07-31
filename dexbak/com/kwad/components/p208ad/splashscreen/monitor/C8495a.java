package com.kwad.components.p208ad.splashscreen.monitor;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.C10829k;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.commercial.C9821c;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.C11160a;

/* renamed from: com.kwad.components.ad.splashscreen.monitor.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8495a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.splashscreen.monitor.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8496a {

        /* renamed from: CS */
        private static final C8495a f27896CS = new C8495a();
    }

    /* renamed from: V */
    private static SplashMonitorInfo m30591V(@NonNull AdTemplate adTemplate) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        return new SplashMonitorInfo().setPreloadId(C10483a.m25936aZ(m25641dQ)).setCreativeId(C10483a.m25978J(m25641dQ)).setMaterialType(C10483a.m25877bc(m25641dQ) ? 1 : 2).setAdTemplate(adTemplate);
    }

    /* renamed from: c */
    private static void m30587c(AbstractC9822a abstractC9822a) {
        if (C10829k.m24699zd().m24700ys()) {
            C9815b.m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(0.01d).m27635N("ad_sdk_splash_callback", "callback_type").m27634a(BusinessType.AD_SPLASH).m27625u(abstractC9822a).m27632a(C11160a.aTL));
        }
    }

    /* renamed from: d */
    private static void m30586d(AbstractC9822a abstractC9822a) {
        if (C10829k.m24699zd().m24700ys()) {
            C9815b.m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(0.01d).m27635N("ad_sdk_splash_action", "action_type").m27634a(BusinessType.AD_SPLASH).m27625u(abstractC9822a).m27632a(C11160a.aTL));
        }
    }

    /* renamed from: kT */
    public static C8495a m30585kT() {
        return C8496a.f27896CS;
    }

    /* renamed from: W */
    public final void m30590W(@NonNull AdTemplate adTemplate) {
        m30587c(m30591V(adTemplate).setCallbackType(2));
    }

    /* renamed from: X */
    public final void m30589X(@NonNull AdTemplate adTemplate) {
        m30587c(m30591V(adTemplate).setCallbackType(5));
    }

    /* renamed from: Y */
    public final void m30588Y(@NonNull AdTemplate adTemplate) {
        m30586d(m30591V(adTemplate).setActionType(1));
    }

    /* renamed from: l */
    public final void m30584l(@NonNull AdTemplate adTemplate) {
        m30586d(m30591V(adTemplate).setActionType(2));
    }

    /* renamed from: m */
    public final void m30583m(@NonNull AdTemplate adTemplate) {
        m30587c(m30591V(adTemplate).setCallbackType(1));
    }

    /* renamed from: n */
    public final void m30582n(@NonNull AdTemplate adTemplate) {
        m30587c(m30591V(adTemplate).setCallbackType(3));
    }

    /* renamed from: o */
    public final void m30581o(long j) {
        m30587c(new SplashMonitorInfo().setCallbackType(4).setPosId(j));
    }
}
