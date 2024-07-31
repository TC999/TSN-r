package com.kwad.sdk.crash.report.request;

import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.C10760g;
import com.kwad.sdk.core.network.AbstractC10418d;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.report.ReportEvent;
import com.kwad.sdk.crash.utils.C10739c;
import java.util.List;

/* renamed from: com.kwad.sdk.crash.report.request.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10721a extends AbstractC10418d {
    public C10721a(List<ReportEvent> list) {
        ReportEvent.StatPackage statPackage;
        ReportEvent.CustomStatEvent customStatEvent;
        putBody("eventList", list);
        if (C10739c.m25006b(list) || list.get(0) == null || (statPackage = list.get(0).statPackage) == null || (customStatEvent = statPackage.customStatEvent) == null || !"perf-block".equals(customStatEvent.key)) {
            return;
        }
        putBody("versionForKeep", ExceptionMessage.getSdkCrashVersionName(BuildConfig.VERSION_NAME, 1));
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b, com.kwad.sdk.core.network.InterfaceC10420f
    public String getUrl() {
        return C10760g.m24887yd();
    }
}
