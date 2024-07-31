package com.kwad.sdk.crash.handler;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.C10671e;
import com.kwad.sdk.crash.model.message.CaughtExceptionMessage;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.report.request.C10722b;
import com.kwad.sdk.crash.report.request.C10727c;
import com.kwad.sdk.crash.utils.C10745g;
import java.util.ArrayList;
import java.util.UUID;

/* renamed from: com.kwad.sdk.crash.handler.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10684a {
    /* renamed from: a */
    private static void m25111a(ExceptionMessage exceptionMessage) {
        C10331c.m26254d("AdExceptionCollector", "upload msg=" + exceptionMessage);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(C10727c.m25022d(exceptionMessage));
        C10722b.m25028a(arrayList, null);
    }

    /* renamed from: p */
    public static void m25110p(@NonNull Throwable th) {
        CaughtExceptionMessage caughtExceptionMessage = new CaughtExceptionMessage();
        caughtExceptionMessage.mLogUUID = UUID.randomUUID().toString();
        caughtExceptionMessage.mCrashDetail = th.toString();
        caughtExceptionMessage.mCrashSource = 1;
        C10745g.m24971b(th, caughtExceptionMessage, C10671e.m25134Hu().getContext());
        C10745g.m24990a(caughtExceptionMessage, 2);
        m25111a(caughtExceptionMessage);
    }
}
