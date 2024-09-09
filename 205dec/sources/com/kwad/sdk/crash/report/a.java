package com.kwad.sdk.crash.report;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.crash.model.message.ExceptionMessage;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    public static void b(@NonNull ExceptionMessage exceptionMessage) {
        n nVar = new n(10211L);
        nVar.errorMsg = exceptionMessage.getReportMsg();
        com.kwad.sdk.core.report.g.a2(nVar);
    }
}
