package com.kwad.sdk.crash.report;

import com.kwad.sdk.crash.report.ReportEvent;
import com.kwad.sdk.crash.report.request.C10722b;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* renamed from: com.kwad.sdk.crash.report.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10720h {
    /* renamed from: a */
    private static void m25033a(ReportEvent reportEvent) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(reportEvent);
        try {
            C10722b.m25028a(arrayList, null);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: ah */
    public static void m25030ah(String str, String str2) {
        m25033a(m25029ai(str, str2));
    }

    /* renamed from: ai */
    private static ReportEvent m25029ai(String str, String str2) {
        ReportEvent reportEvent = new ReportEvent();
        reportEvent.clientTimeStamp = System.currentTimeMillis();
        reportEvent.timeZone = Calendar.getInstance().getTimeZone().getID();
        reportEvent.statPackage = new ReportEvent.StatPackage();
        ReportEvent.CustomStatEvent customStatEvent = new ReportEvent.CustomStatEvent();
        customStatEvent.key = str;
        customStatEvent.value = str2;
        reportEvent.statPackage.customStatEvent = customStatEvent;
        return reportEvent;
    }

    /* renamed from: a */
    private static void m25031a(List<ReportEvent> list, C10722b.InterfaceC10726a interfaceC10726a) {
        try {
            C10722b.m25027a(list, null, interfaceC10726a);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static void m25032a(String str, List<String> list, C10722b.InterfaceC10726a interfaceC10726a) {
        if (list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : list) {
            arrayList.add(m25029ai(str, str2));
        }
        m25031a(arrayList, interfaceC10726a);
    }
}
