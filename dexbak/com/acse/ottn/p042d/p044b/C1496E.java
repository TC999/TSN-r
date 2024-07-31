package com.acse.ottn.p042d.p044b;

import android.accessibilityservice.AccessibilityService;
import android.graphics.Rect;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1652V;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import com.acse.ottn.util.CommonUtil;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.b.E */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1496E implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ AccessibilityService f2747a;

    /* renamed from: b */
    final /* synthetic */ String f2748b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1496E(AccessibilityService accessibilityService, String str) {
        this.f2747a = accessibilityService;
        this.f2748b = str;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeInfo accessibilityNodeInfo2;
        C1694ra.m55917a("samon-->", "倒计时");
        C1497F.m56627h(this.f2747a);
        try {
            AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(this.f2747a, this.f2748b);
            if (m55955g == null) {
                accessibilityNodeInfo = C1497F.f2752d;
                if (accessibilityNodeInfo != null) {
                    C1684n m55975c = C1684n.m55975c();
                    accessibilityNodeInfo2 = C1497F.f2752d;
                    m55975c.m55978b(accessibilityNodeInfo2);
                    return;
                }
                return;
            }
            TimerTask timerTask = C1497F.f2751c;
            if (timerTask != null) {
                timerTask.cancel();
                C1694ra.m55917a("samon-->", "结束倒计时");
                C1497F.f2751c = null;
            }
            C1694ra.m55917a("acse_VivoUtils", "buttery find");
            C1684n.m55975c().m55958f(m55955g);
            C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(200));
            AccessibilityNodeInfo m55955g2 = C1684n.m55975c().m55955g(this.f2747a, "允许后台高耗电");
            if (m55955g2 != null) {
                C1694ra.m55917a("acse_VivoUtils", "buttery info is not null");
                C1684n.m55975c().m55958f(m55955g2);
                CommonUtil.setServiceHightButteryState(true);
            } else {
                C1694ra.m55917a("acse_VivoUtils", "buttery info is null");
                if (m55955g.getParent() != null) {
                    C1694ra.m55917a("acse_VivoUtils", "buttery start");
                    for (int i = 0; i < m55955g.getParent().getChildCount(); i++) {
                        if (m55955g.getParent().getChild(i) != null && "android.widget.Switch".equals(m55955g.getParent().getChild(i).getClassName())) {
                            C1694ra.m55917a("acse_VivoUtils", "find buttery Switch");
                            if (!m55955g.getParent().getChild(i).isChecked()) {
                                Rect rect = new Rect();
                                m55955g.getParent().getChild(i).getBoundsInScreen(rect);
                                int i2 = rect.right;
                                int i3 = rect.left;
                                int i4 = ((i2 - i3) / 2) + i3;
                                int i5 = rect.bottom;
                                int i6 = rect.top;
                                int i7 = ((i5 - i6) / 2) + i6;
                                if (Build.VERSION.SDK_INT >= 24) {
                                    C1684n.m55975c().m56002a(this.f2747a, i4, i7);
                                }
                            }
                        }
                    }
                }
            }
            C1694ra.m55917a("acse_VivoUtils", "backgroundHightBattery comeBack");
            C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(100));
            C1684n.m55975c().m55969d(this.f2747a);
            C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(100));
            C1684n.m55975c().m55969d(this.f2747a);
            C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(100));
            C1684n.m55975c().m55969d(this.f2747a);
        } catch (Exception e) {
            C1694ra.m55917a("acse_VivoUtils", "backgroundHightBattery e =" + e.getMessage());
        }
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        C1497F.f2751c = null;
    }
}
