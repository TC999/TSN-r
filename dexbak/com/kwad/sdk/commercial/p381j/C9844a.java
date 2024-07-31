package com.kwad.sdk.commercial.p381j;

import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.commercial.C9821c;
import com.kwad.sdk.commercial.C9825d;
import com.kwad.sdk.core.InterfaceC10229c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10970h;
import com.kwad.sdk.utils.C11126t;
import java.util.List;

/* renamed from: com.kwad.sdk.commercial.j.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9844a {
    private static C9846a aoK;

    @KsJson
    /* renamed from: com.kwad.sdk.commercial.j.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9846a extends C10482a {
        public List<String> aoL;
    }

    /* renamed from: AU */
    private static C9846a m27532AU() {
        String mo24301yW = ((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24301yW();
        if (!TextUtils.isEmpty(mo24301yW)) {
            aoK = (C9846a) C11126t.m23677b(mo24301yW, new InterfaceC10229c<C9846a>() { // from class: com.kwad.sdk.commercial.j.a.1
                /* renamed from: AV */
                private static C9846a m27524AV() {
                    return new C9846a();
                }

                @Override // com.kwad.sdk.core.InterfaceC10229c
                /* renamed from: AW */
                public final /* synthetic */ C9846a mo23794AW() {
                    return m27524AV();
                }
            });
        }
        return aoK;
    }

    /* renamed from: a */
    private static void m27529a(AdTemplate adTemplate, C9847b c9847b) {
        m27528a(adTemplate, false, c9847b);
    }

    /* renamed from: cL */
    private static boolean m27527cL(String str) {
        List<String> list;
        C9846a m27532AU = m27532AU();
        if (m27532AU == null || (list = m27532AU.aoL) == null) {
            return false;
        }
        for (String str2 : list) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: n */
    public static void m27526n(AdTemplate adTemplate, int i, String str) {
        try {
            m27529a(adTemplate, C9847b.m27523AX().m27518cn(4).m27517co(i).m27521cM(str).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: o */
    public static void m27525o(AdTemplate adTemplate, int i, String str) {
        try {
            m27529a(adTemplate, C9847b.m27523AX().m27518cn(1).m27517co(i).m27521cM(str).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    private static void m27528a(AdTemplate adTemplate, boolean z, C9847b c9847b) {
        if (m27527cL(c9847b.aoN)) {
            return;
        }
        C9815b.m27672d(C9821c.m27636AJ().m27631cu(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).m27628i(z ? 1.0d : 0.001d).m27634a(C9825d.m27624aS(adTemplate)).m27635N("ad_sdk_track_performance", "status").m27625u(c9847b));
    }

    /* renamed from: a */
    public static void m27531a(AdTemplate adTemplate, int i, String str, int i2, int i3) {
        try {
            m27529a(adTemplate, C9847b.m27523AX().m27518cn(2).m27517co(i).m27521cM(str).m27516cp(i3).setErrorCode(i2).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    public static void m27530a(AdTemplate adTemplate, int i, String str, String str2, int i2, String str3, int i3) {
        try {
            m27528a(adTemplate, true, C9847b.m27523AX().m27518cn(3).m27517co(i).m27521cM(str).m27520cN(str2).setErrorCode(i2).setErrorMsg(str3).m27516cp(i3).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
