package com.acse.ottn.p042d.p044b;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.util.C1638Ka;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1652V;
import com.acse.ottn.util.C1661ba;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.b.j */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1507j implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ AccessibilityService f2775a;

    /* renamed from: b */
    final /* synthetic */ String f2776b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1507j(AccessibilityService accessibilityService, String str) {
        this.f2775a = accessibilityService;
        this.f2776b = str;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeInfo accessibilityNodeInfo2;
        C1694ra.m55917a("samon-->", "openMiuiFlowWindowPermission倒计时");
        try {
            AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(this.f2775a, this.f2776b);
            if (m55955g == null) {
                C1509l.m56567i(this.f2775a);
                accessibilityNodeInfo = C1509l.f2782d;
                if (accessibilityNodeInfo != null) {
                    C1684n m55975c = C1684n.m55975c();
                    accessibilityNodeInfo2 = C1509l.f2782d;
                    m55975c.m55978b(accessibilityNodeInfo2);
                    return;
                }
                return;
            }
            TimerTask timerTask = C1509l.f2781c;
            if (timerTask != null) {
                timerTask.cancel();
                C1509l.f2781c = null;
            }
            C1694ra.m55917a("acse_MiuiUtils", "找到了");
            C1661ba.m56097a().m56092a("battery_white", true);
            C1684n.m55975c().m55958f(m55955g);
            if ("samsung".equals(C1638Ka.m56193b())) {
                C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(200));
                C1684n.m55975c().m55969d(this.f2775a);
            }
        } catch (Exception e) {
            C1694ra.m55917a("acse_MiuiUtils", "e =" + e.getMessage());
        }
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        C1509l.f2781c = null;
    }
}
