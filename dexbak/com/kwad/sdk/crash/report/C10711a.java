package com.kwad.sdk.crash.report;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.C10455g;
import com.kwad.sdk.core.report.C10464n;
import com.kwad.sdk.crash.model.message.ExceptionMessage;

/* renamed from: com.kwad.sdk.crash.report.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10711a {
    /* renamed from: b */
    public static void m25060b(@NonNull ExceptionMessage exceptionMessage) {
        C10464n c10464n = new C10464n(10211L);
        c10464n.errorMsg = exceptionMessage.getReportMsg();
        C10455g.m26032a(c10464n);
    }
}
