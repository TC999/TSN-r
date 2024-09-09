package com.acse.ottn.d.b;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.S;
import com.acse.ottn.util.ra;
import com.acse.ottn.x2;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class x implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibilityService f5482a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(AccessibilityService accessibilityService) {
        this.f5482a = accessibilityService;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
        ra.a("samon-->", "clickOpenBatteryManage  \u5012\u8ba1\u65f6");
        AccessibilityNodeInfo g4 = C1442n.c().g(this.f5482a, "\u5141\u8bb8\u5e94\u7528\u81ea\u542f\u52a8");
        AccessibilityNodeInfo g5 = C1442n.c().g(this.f5482a, "\u5141\u8bb8\u5b8c\u5168\u540e\u53f0\u884c\u4e3a");
        AccessibilityNodeInfo g6 = C1442n.c().g(this.f5482a, "\u5141\u8bb8\u540e\u53f0\u8fd0\u884c");
        int i4 = 0;
        if (g4 != null && g4.getParent() != null) {
            ra.a(x2.f6988a, "infochild is not null");
            C1442n.c().a(200L);
            for (int i5 = 0; i5 < g4.getParent().getChildCount(); i5++) {
                if (g4.getParent().getChild(i5) != null && "android.widget.Switch".equals(g4.getParent().getChild(i5).getClassName())) {
                    ra.a(x2.f6988a, "infochild android.widget.Switch");
                    if (!g4.getParent().getChild(i5).isChecked()) {
                        ra.a(x2.f6988a, "\u70b9\u51fbinfochild");
                        C1442n.c().f(g4);
                    }
                }
            }
        }
        if (g5 != null && g5.getParent() != null) {
            ra.a(x2.f6988a, "nodeInfochild is not null");
            C1442n.c().a(100L);
            while (i4 < g5.getParent().getChildCount()) {
                if (g5.getParent().getChild(i4) != null && "android.widget.Switch".equals(g5.getParent().getChild(i4).getClassName())) {
                    ra.a(x2.f6988a, "nodeInfochild android.widget.Switch");
                    if (!g5.getParent().getChild(i4).isChecked()) {
                        ra.a(x2.f6988a, "\u70b9\u51fbnodeInfochild = ");
                        C1442n.c().f(g5);
                    }
                }
                i4++;
            }
            TimerTask timerTask = z.f5486c;
            if (timerTask != null) {
                timerTask.cancel();
                z.f5486c = null;
            }
        } else if (g6 == null || g6.getParent() == null) {
            return;
        } else {
            ra.a(x2.f6988a, "nodeInfochild1 is not null");
            C1442n.c().a(100L);
            TimerTask timerTask2 = z.f5486c;
            if (timerTask2 != null) {
                timerTask2.cancel();
                z.f5486c = null;
            }
            while (i4 < g6.getParent().getChildCount()) {
                if (g6.getParent().getChild(i4) != null && "android.widget.Switch".equals(g6.getParent().getChild(i4).getClassName())) {
                    ra.a(x2.f6988a, "nodeInfochild1 android.widget.Switch");
                    if (!g6.getParent().getChild(i4).isChecked()) {
                        ra.a(x2.f6988a, "\u70b9\u51fbnodeInfochild1");
                        C1442n.c().f(g6);
                    }
                }
                i4++;
            }
        }
        z.g(this.f5482a);
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        TimerTask timerTask = z.f5486c;
        if (timerTask != null) {
            timerTask.cancel();
            z.f5486c = null;
        }
    }
}
