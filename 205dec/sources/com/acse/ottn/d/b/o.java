package com.acse.ottn.d.b;

import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.service.ShopHelperService;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.S;
import java.util.TimerTask;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class o implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ShopHelperService f5463a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ShopHelperService shopHelperService) {
        this.f5463a = shopHelperService;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
        AccessibilityNodeInfo g4 = C1442n.c().g(this.f5463a, "\u5141\u8bb8\u5b8c\u5168\u540e\u53f0\u884c\u4e3a");
        AccessibilityNodeInfo g5 = C1442n.c().g(this.f5463a, "\u5141\u8bb8\u540e\u53f0\u8fd0\u884c");
        AccessibilityNodeInfo g6 = C1442n.c().g(this.f5463a, "\u5141\u8bb8\u5e94\u7528\u81ea\u542f\u52a8");
        if (g6 != null && g6.getParent() != null) {
            TimerTask timerTask = q.f5466b;
            if (timerTask != null) {
                timerTask.cancel();
                q.f5466b = null;
            }
            for (int i4 = 0; i4 < g6.getParent().getChildCount(); i4++) {
                if (g6.getParent().getChild(i4) != null && "android.widget.Switch".equals(g6.getParent().getChild(i4).getClassName()) && !g6.getParent().getChild(i4).isChecked()) {
                    C1442n.c().f(g6);
                }
            }
        }
        if (g4 != null && g4.getParent() != null) {
            TimerTask timerTask2 = q.f5466b;
            if (timerTask2 != null) {
                timerTask2.cancel();
                q.f5466b = null;
            }
            for (int i5 = 0; i5 < g4.getParent().getChildCount(); i5++) {
                if ("android.widget.Switch".equals(g4.getParent().getChild(i5).getClassName()) && !g4.getParent().getChild(i5).isChecked()) {
                    C1442n.c().f(g4);
                }
            }
        } else if (g5 == null) {
            return;
        } else {
            TimerTask timerTask3 = q.f5466b;
            if (timerTask3 != null) {
                timerTask3.cancel();
                q.f5466b = null;
            }
            C1442n.c().f(g5);
        }
        q.g(this.f5463a);
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        TimerTask timerTask = q.f5466b;
        if (timerTask != null) {
            timerTask.cancel();
            q.f5466b = null;
        }
    }
}
