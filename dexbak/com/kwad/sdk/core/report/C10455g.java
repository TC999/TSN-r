package com.kwad.sdk.core.report;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.service.p449a.InterfaceC10970h;
import io.netty.util.internal.StringUtil;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.kwad.sdk.core.report.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10455g extends AbstractC10444b<C10464n, C10454f> {
    private static volatile boolean axA;
    private static volatile C10455g axB;
    private static InterfaceC10470r<C10464n, C10454f> axC;

    private C10455g() {
    }

    /* renamed from: EJ */
    private static C10455g m26036EJ() {
        if (axB == null) {
            synchronized (C10455g.class) {
                if (axB == null) {
                    axB = new C10455g();
                }
            }
        }
        axB.checkInit();
        return axB;
    }

    /* renamed from: W */
    private static boolean m26035W(long j) {
        InterfaceC10471s interfaceC10471s = (InterfaceC10471s) ServiceProvider.get(InterfaceC10471s.class);
        return interfaceC10471s != null && interfaceC10471s.mo24874W(j);
    }

    /* renamed from: b */
    private void m26029b(final C10464n c10464n, boolean z) {
        if (c10464n == null || !axA) {
            return;
        }
        if (!z && !m26035W(c10464n.actionType)) {
            axB.m26054a(new InterfaceC10461k<C10464n>() { // from class: com.kwad.sdk.core.report.g.2
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.report.InterfaceC10461k
                /* renamed from: EK */
                public C10464n mo26021EF() {
                    return c10464n.m26016EM();
                }
            });
        } else {
            axB.m26048b(new InterfaceC10461k<C10464n>() { // from class: com.kwad.sdk.core.report.g.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.report.InterfaceC10461k
                /* renamed from: EK */
                public C10464n mo26021EF() {
                    return c10464n.m26016EM();
                }
            });
        }
    }

    private synchronized void checkInit() {
        if (axA) {
            return;
        }
        InterfaceC10968f interfaceC10968f = (InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class);
        if (interfaceC10968f == null) {
            return;
        }
        InterfaceC10970h interfaceC10970h = (InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class);
        if (interfaceC10970h == null) {
            return;
        }
        Context context = interfaceC10968f.getContext();
        if (context == null) {
            return;
        }
        int mo24326as = interfaceC10970h.mo24326as(context);
        m26044i(context, mo24326as);
        C10472t.init(context);
        C10472t.m26006ES();
        C10331c.m26254d("BatchReporter", "cache type = " + mo24326as);
        if (mo24326as == 2) {
            m26053a(C10469q.m26011bf(context));
        }
        axA = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.AbstractC10444b
    /* renamed from: y */
    public C10454f mo26028w(List<C10464n> list) {
        InterfaceC10470r<C10464n, C10454f> interfaceC10470r = axC;
        if (interfaceC10470r != null) {
            return interfaceC10470r.m26007ER();
        }
        String m26026z = m26026z(list);
        if (!TextUtils.isEmpty(m26026z)) {
            return new C10454f(m26026z);
        }
        return new C10454f(list);
    }

    /* renamed from: z */
    private static String m26026z(List<C10464n> list) {
        if (list.get(0) == null || TextUtils.isEmpty(list.get(0).ayQ)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(",\"actionList\":[");
        for (C10464n c10464n : list) {
            sb.append(c10464n.ayQ);
            sb.append(StringUtil.COMMA);
        }
        int length = sb.length();
        sb.replace(length - 1, length, "]");
        return sb.toString();
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void m26032a(@NonNull C10464n c10464n) {
        m26031a(c10464n, false);
    }

    /* renamed from: a */
    public static void m26031a(@NonNull C10464n c10464n, boolean z) {
        m26036EJ().m26029b(c10464n, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.report.AbstractC10444b
    /* renamed from: a */
    public final Runnable mo26034a(Context context, InterfaceC10462l<C10464n> interfaceC10462l, AtomicInteger atomicInteger) {
        RunnableC10473u<C10464n, C10454f> m26009EP;
        InterfaceC10470r<C10464n, C10454f> interfaceC10470r = axC;
        return (interfaceC10470r == null || (m26009EP = interfaceC10470r.m26009EP()) == null) ? super.mo26034a(context, interfaceC10462l, atomicInteger) : m26009EP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.AbstractC10444b
    /* renamed from: b */
    public C10454f mo26033a(C10464n c10464n) {
        InterfaceC10470r<C10464n, C10454f> interfaceC10470r = axC;
        if (interfaceC10470r != null) {
            return interfaceC10470r.m26008EQ();
        }
        return (C10454f) super.mo26033a((C10455g) c10464n);
    }
}
