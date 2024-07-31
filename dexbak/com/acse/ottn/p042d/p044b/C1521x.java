package com.acse.ottn.p042d.p044b;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.b.x */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1521x implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ AccessibilityService f2806a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1521x(AccessibilityService accessibilityService) {
        this.f2806a = accessibilityService;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
        C1694ra.m55917a("samon-->", "clickOpenBatteryManage  倒计时");
        AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(this.f2806a, "允许应用自启动");
        AccessibilityNodeInfo m55955g2 = C1684n.m55975c().m55955g(this.f2806a, "允许完全后台行为");
        AccessibilityNodeInfo m55955g3 = C1684n.m55975c().m55955g(this.f2806a, "允许后台运行");
        int i = 0;
        if (m55955g != null && m55955g.getParent() != null) {
            C1694ra.m55917a("OppoUtils", "infochild is not null");
            C1684n.m55975c().m56005a(200L);
            for (int i2 = 0; i2 < m55955g.getParent().getChildCount(); i2++) {
                if (m55955g.getParent().getChild(i2) != null && "android.widget.Switch".equals(m55955g.getParent().getChild(i2).getClassName())) {
                    C1694ra.m55917a("OppoUtils", "infochild android.widget.Switch");
                    if (!m55955g.getParent().getChild(i2).isChecked()) {
                        C1694ra.m55917a("OppoUtils", "点击infochild");
                        C1684n.m55975c().m55958f(m55955g);
                    }
                }
            }
        }
        if (m55955g2 != null && m55955g2.getParent() != null) {
            C1694ra.m55917a("OppoUtils", "nodeInfochild is not null");
            C1684n.m55975c().m56005a(100L);
            while (i < m55955g2.getParent().getChildCount()) {
                if (m55955g2.getParent().getChild(i) != null && "android.widget.Switch".equals(m55955g2.getParent().getChild(i).getClassName())) {
                    C1694ra.m55917a("OppoUtils", "nodeInfochild android.widget.Switch");
                    if (!m55955g2.getParent().getChild(i).isChecked()) {
                        C1694ra.m55917a("OppoUtils", "点击nodeInfochild = ");
                        C1684n.m55975c().m55958f(m55955g2);
                    }
                }
                i++;
            }
            TimerTask timerTask = C1523z.f2810c;
            if (timerTask != null) {
                timerTask.cancel();
                C1523z.f2810c = null;
            }
        } else if (m55955g3 == null || m55955g3.getParent() == null) {
            return;
        } else {
            C1694ra.m55917a("OppoUtils", "nodeInfochild1 is not null");
            C1684n.m55975c().m56005a(100L);
            TimerTask timerTask2 = C1523z.f2810c;
            if (timerTask2 != null) {
                timerTask2.cancel();
                C1523z.f2810c = null;
            }
            while (i < m55955g3.getParent().getChildCount()) {
                if (m55955g3.getParent().getChild(i) != null && "android.widget.Switch".equals(m55955g3.getParent().getChild(i).getClassName())) {
                    C1694ra.m55917a("OppoUtils", "nodeInfochild1 android.widget.Switch");
                    if (!m55955g3.getParent().getChild(i).isChecked()) {
                        C1694ra.m55917a("OppoUtils", "点击nodeInfochild1");
                        C1684n.m55975c().m55958f(m55955g3);
                    }
                }
                i++;
            }
        }
        C1523z.m56525g(this.f2806a);
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        TimerTask timerTask = C1523z.f2810c;
        if (timerTask != null) {
            timerTask.cancel();
            C1523z.f2810c = null;
        }
    }
}
