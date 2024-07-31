package com.acse.ottn.p042d.p044b;

import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.service.ShopHelperService;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1684n;
import java.util.TimerTask;

/* renamed from: com.acse.ottn.d.b.o */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1512o implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ ShopHelperService f2787a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1512o(ShopHelperService shopHelperService) {
        this.f2787a = shopHelperService;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
        AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(this.f2787a, "允许完全后台行为");
        AccessibilityNodeInfo m55955g2 = C1684n.m55975c().m55955g(this.f2787a, "允许后台运行");
        AccessibilityNodeInfo m55955g3 = C1684n.m55975c().m55955g(this.f2787a, "允许应用自启动");
        if (m55955g3 != null && m55955g3.getParent() != null) {
            TimerTask timerTask = C1514q.f2790b;
            if (timerTask != null) {
                timerTask.cancel();
                C1514q.f2790b = null;
            }
            for (int i = 0; i < m55955g3.getParent().getChildCount(); i++) {
                if (m55955g3.getParent().getChild(i) != null && "android.widget.Switch".equals(m55955g3.getParent().getChild(i).getClassName()) && !m55955g3.getParent().getChild(i).isChecked()) {
                    C1684n.m55975c().m55958f(m55955g3);
                }
            }
        }
        if (m55955g != null && m55955g.getParent() != null) {
            TimerTask timerTask2 = C1514q.f2790b;
            if (timerTask2 != null) {
                timerTask2.cancel();
                C1514q.f2790b = null;
            }
            for (int i2 = 0; i2 < m55955g.getParent().getChildCount(); i2++) {
                if ("android.widget.Switch".equals(m55955g.getParent().getChild(i2).getClassName()) && !m55955g.getParent().getChild(i2).isChecked()) {
                    C1684n.m55975c().m55958f(m55955g);
                }
            }
        } else if (m55955g2 == null) {
            return;
        } else {
            TimerTask timerTask3 = C1514q.f2790b;
            if (timerTask3 != null) {
                timerTask3.cancel();
                C1514q.f2790b = null;
            }
            C1684n.m55975c().m55958f(m55955g2);
        }
        C1514q.m56554g(this.f2787a);
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        TimerTask timerTask = C1514q.f2790b;
        if (timerTask != null) {
            timerTask.cancel();
            C1514q.f2790b = null;
        }
    }
}
