package com.kwad.sdk.crash.report.request;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.C10670d;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.report.ReportEvent;
import com.kwad.sdk.crash.utils.C10741e;
import java.util.Calendar;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.crash.report.request.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10727c {
    /* renamed from: d */
    public static ReportEvent m25022d(@NonNull ExceptionMessage exceptionMessage) {
        ReportEvent reportEvent = new ReportEvent();
        reportEvent.clientIncrementId = C10741e.m25003EU();
        reportEvent.clientTimeStamp = exceptionMessage.mCurrentTimeStamp;
        reportEvent.sessionId = m25021fE(exceptionMessage.mCustomMsg);
        reportEvent.timeZone = Calendar.getInstance().getTimeZone().getID();
        reportEvent.statPackage = new ReportEvent.StatPackage();
        ReportEvent.ExceptionEvent exceptionEvent = new ReportEvent.ExceptionEvent();
        exceptionEvent.type = exceptionMessage.mExceptionType;
        exceptionEvent.message = exceptionMessage.toJson().toString();
        exceptionEvent.urlPackage = new ReportEvent.UrlPackage();
        reportEvent.statPackage.exceptionEvent = exceptionEvent;
        return reportEvent;
    }

    /* renamed from: fE */
    private static String m25021fE(String str) {
        if (!TextUtils.isEmpty(str) && !"Unknown".equals(str)) {
            try {
                String optString = new JSONObject(str).optString(C10670d.aFJ);
                if (!TextUtils.isEmpty(optString)) {
                    return optString;
                }
            } catch (Exception e) {
                C10331c.printStackTraceOnly(e);
            }
        }
        return "Unknown";
    }
}
