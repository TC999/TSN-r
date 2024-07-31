package com.kwad.sdk.crash.online.monitor.block;

import android.os.Looper;
import android.util.Printer;
import com.kwad.sdk.core.p385a.C9886c;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.online.monitor.p428a.C10696a;
import com.kwad.sdk.utils.C11124s;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.sdk.crash.online.monitor.block.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10700a {
    private static volatile boolean aGs;
    private static String aGt;
    private static List<String> aGu;
    private static List<String> aGv;
    private static volatile boolean aGw;
    private static volatile boolean aGx;

    /* renamed from: HO */
    public static boolean m25095HO() {
        if (aGs) {
            return false;
        }
        try {
            return ((Printer) C11124s.getField(Looper.getMainLooper(), "mLogging")) != null;
        } catch (Exception e) {
            C10331c.m26249e("perfMonitor.MonitorDetector", "hasBlockMonitor ", e);
            aGs = true;
            return false;
        }
    }

    /* renamed from: HP */
    public static boolean m25094HP() {
        if (aGx) {
            return aGw;
        }
        try {
            String str = new String(C9886c.m27442Du().decode("Y29tLnRlbmNlbnQubWF0cml4Lk1hdHJpeA=="));
            C10331c.m26254d("perfMonitor.MonitorDetector", "hasMatrix after:" + str);
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            aGw = false;
            aGx = true;
            return aGw;
        }
    }

    /* renamed from: a */
    public static void m25093a(C10696a c10696a) {
        aGu = c10696a.aGQ;
        aGv = c10696a.aGR;
    }

    /* renamed from: bA */
    public static boolean m25091bA(boolean z) {
        List<String> list = aGu;
        if (list != null && !list.isEmpty()) {
            return m25092a(aGu, true);
        }
        return m25089g("Y29tLnRlbmNlbnQubWF0cml4LnRyYWNlLmNvcmUuTG9vcGVyTW9uaXRvcg==", true);
    }

    /* renamed from: bB */
    public static boolean m25090bB(boolean z) {
        List<String> list = aGv;
        if (list == null || list.isEmpty()) {
            return false;
        }
        return m25092a(aGv, false);
    }

    /* renamed from: g */
    private static boolean m25089g(String str, boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return m25092a(arrayList, z);
    }

    /* renamed from: a */
    private static boolean m25092a(List<String> list, boolean z) {
        if (aGs) {
            return false;
        }
        try {
            Printer printer = (Printer) C11124s.getField(Looper.getMainLooper(), "mLogging");
            if (printer != null) {
                aGt = printer.getClass().getName();
                C10331c.m26254d("perfMonitor.MonitorDetector", "originPrinter name:" + printer.getClass().getName());
                if (z) {
                    C10707f.m25069fx(aGt);
                }
                for (String str : list) {
                    String str2 = new String(C9886c.m27442Du().decode(str));
                    C10331c.m26254d("perfMonitor.MonitorDetector", "printer after:" + str2);
                    if (printer.getClass().getName().contains(str2)) {
                        C10331c.m26254d("perfMonitor.MonitorDetector", "printer monitor");
                        return true;
                    }
                }
            } else {
                C10331c.m26254d("perfMonitor.MonitorDetector", "printer not hook");
            }
        } catch (Exception e) {
            C10331c.m26249e("perfMonitor.MonitorDetector", "hasBlockMonitor ", e);
            aGs = true;
        }
        return false;
    }
}
