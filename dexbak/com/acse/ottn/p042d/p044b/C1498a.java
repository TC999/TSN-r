package com.acse.ottn.p042d.p044b;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.b.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1498a implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ AccessibilityService f2753a;

    /* renamed from: b */
    final /* synthetic */ boolean f2754b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1498a(AccessibilityService accessibilityService, boolean z) {
        this.f2753a = accessibilityService;
        this.f2754b = z;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
        try {
            C1694ra.m55917a("samon-->", "clickOpenFlowWindow  倒计时");
            AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(this.f2753a, "在其他应用上层显示");
            C1505h.m56598g(this.f2753a);
            if (m55955g == null || m55955g.getParent() == null) {
                return;
            }
            TimerTask timerTask = C1505h.f2770d;
            if (timerTask != null) {
                timerTask.cancel();
                C1505h.f2770d = null;
            }
            for (int i = 0; i < m55955g.getParent().getChildCount(); i++) {
                if (m55955g.getParent().getChild(i) != null && "android.widget.Switch".equals(m55955g.getParent().getChild(i).getClassName())) {
                    C1684n.m55975c().m55958f(m55955g.getParent().getChild(i));
                    C1684n.m55975c().m55969d(this.f2753a);
                    if (this.f2754b) {
                        C1684n.m55975c().m55969d(this.f2753a);
                        return;
                    }
                    return;
                }
            }
        } catch (Exception e) {
            C1694ra.m55917a("acse_HuaweiUtils", "e =" + e.getMessage());
        }
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        C1505h.f2770d = null;
    }
}
