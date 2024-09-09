package com.kwad.sdk.crash.report.request;

import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.report.ReportEvent;
import com.kwad.sdk.g;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a extends d {
    public a(List<ReportEvent> list) {
        ReportEvent.StatPackage statPackage;
        ReportEvent.CustomStatEvent customStatEvent;
        putBody("eventList", list);
        if (com.kwad.sdk.crash.utils.c.b(list) || list.get(0) == null || (statPackage = list.get(0).statPackage) == null || (customStatEvent = statPackage.customStatEvent) == null || !"perf-block".equals(customStatEvent.key)) {
            return;
        }
        putBody("versionForKeep", ExceptionMessage.getSdkCrashVersionName(BuildConfig.VERSION_NAME, 1));
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public String getUrl() {
        return g.yd();
    }
}
