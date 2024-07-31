package com.kwad.sdk.crash.online.monitor.block;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.report.AbstractC10453e;
import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import com.kwad.sdk.crash.online.monitor.block.report.BlockReportAction;
import com.kwad.sdk.crash.online.monitor.block.report.C10710a;
import com.kwad.sdk.crash.online.monitor.p428a.C10696a;
import com.kwad.sdk.crash.report.C10720h;
import com.kwad.sdk.crash.report.request.C10722b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11095g;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.kwad.sdk.crash.online.monitor.block.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10707f {
    /* renamed from: EA */
    private static boolean m25076EA() {
        int m25075HS = m25075HS();
        Context context = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext();
        if (context == null) {
            return false;
        }
        long size = C10710a.m25063bw(context).size();
        C10331c.m26254d("perfMonitor.Reporter", "size:" + size + " limit:" + m25075HS);
        return size >= ((long) m25075HS);
    }

    /* renamed from: HS */
    private static int m25075HS() {
        C10696a m25079HQ = C10706e.m25079HQ();
        if (m25079HQ != null) {
            return m25079HQ.aGV;
        }
        return 20;
    }

    /* renamed from: HT */
    static /* synthetic */ boolean m25074HT() {
        return m25076EA();
    }

    /* renamed from: a */
    public static void m25073a(String str, long j, long j2, String str2, String str3, boolean z) {
        try {
            m25067h(m25072b(str, j, j2, str2, str3), false);
        } catch (Throwable unused) {
        }
    }

    @Nullable
    /* renamed from: b */
    private static String m25072b(String str, long j, long j2, String str2, String str3) {
        try {
        } catch (Exception e) {
            C10331c.m26246w("perfMonitor.Reporter", Log.getStackTraceString(e));
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        str = m25070fw(C10702b.m25085fu(str));
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (j2 == 0) {
            j2 = 2000;
        }
        return m25071c(str, j, j2, str2, str3).toJson().toString();
    }

    /* renamed from: c */
    private static BlockEvent m25071c(String str, long j, long j2, String str2, String str3) {
        BlockEvent blockEvent = new BlockEvent();
        blockEvent.blockDuration = j2;
        blockEvent.currentActivity = str2;
        blockEvent.processName = str3;
        BlockEvent.C10699a c10699a = new BlockEvent.C10699a();
        c10699a.aGA = str;
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        c10699a.aGy = j;
        c10699a.repeatCount = (int) (j2 / blockEvent.blockLoopInterval);
        blockEvent.stackTraceSample.add(c10699a);
        return blockEvent;
    }

    /* renamed from: fw */
    private static String m25070fw(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            boolean startsWith = str.startsWith(" \n");
            C10331c.m26254d("perfMonitor.Reporter", "oldVersion:" + startsWith);
            if (startsWith) {
                if (str.contains("at ")) {
                    str = str.substring(str.indexOf("at "));
                }
                str = str.replaceAll(":", "\\.") + ShellAdbUtils.f33810d;
            }
            String replaceAll = str.replaceAll("at ", "").replaceAll(" ", "");
            if (replaceAll.contains(ShellAdbUtils.f33810d)) {
                replaceAll = replaceAll.replaceAll(ShellAdbUtils.f33810d, "\n\tat ");
            }
            return "\n\tat " + (replaceAll + "_").replaceAll("\n\tat _", ShellAdbUtils.f33810d);
        } catch (Exception e) {
            C10331c.m26246w("perfMonitor.Reporter", Log.getStackTraceString(e));
            return str;
        }
    }

    /* renamed from: fx */
    public static void m25069fx(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C10331c.m26254d("perfMonitor.Reporter", "reportPrinterName:" + str);
        if (C10706e.m25078HR()) {
            C10705d c10705d = new C10705d();
            c10705d.aGG = str;
            c10705d.aGI = C10700a.m25094HP();
            C9815b.m27653p(c10705d);
        }
    }

    /* renamed from: fy */
    public static void m25068fy(String str) {
        try {
            C10705d c10705d = new C10705d();
            c10705d.errorMsg = str;
            c10705d.aGI = C10700a.m25094HP();
            C9815b.m27653p(c10705d);
        } catch (Exception unused) {
        }
        C10331c.m26246w("perfMonitor.Reporter", str);
    }

    /* renamed from: h */
    private static void m25067h(final String str, final boolean z) {
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.crash.online.monitor.block.f.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (!z && C10707f.m25066zF() != 1) {
                    BlockReportAction blockReportAction = new BlockReportAction(str);
                    C10331c.m26254d("perfMonitor.Reporter", "write to db :" + blockReportAction.toJson().toString());
                    final Context context = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext();
                    if (context == null) {
                        return;
                    }
                    C10710a.m25063bw(context).mo26018j(blockReportAction);
                    if (C10707f.m25074HT()) {
                        final List<AbstractC10453e> mo26020EI = C10710a.m25063bw(context).mo26020EI();
                        ArrayList arrayList = new ArrayList();
                        Iterator<AbstractC10453e> it = mo26020EI.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((BlockReportAction) it.next()).msg);
                        }
                        C10720h.m25032a("perf-block", arrayList, new C10722b.InterfaceC10726a() { // from class: com.kwad.sdk.crash.online.monitor.block.f.1.1
                            @Override // com.kwad.sdk.crash.report.request.C10722b.InterfaceC10726a
                            public final void onError(int i, String str2) {
                                C10331c.m26246w("perfMonitor.Reporter", "errorCode:" + i + " errorMsg:" + str2);
                            }

                            @Override // com.kwad.sdk.crash.report.request.C10722b.InterfaceC10726a
                            public final void onSuccess() {
                                C10710a.m25063bw(context).mo26017x(mo26020EI);
                            }
                        });
                        return;
                    }
                    return;
                }
                C10331c.m26254d("perfMonitor.Reporter", "report now :" + str);
                C10720h.m25030ah("perf-block", str);
            }
        });
    }

    /* renamed from: zF */
    static /* synthetic */ int m25066zF() {
        return m25075HS();
    }
}
