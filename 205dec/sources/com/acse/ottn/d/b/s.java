package com.acse.ottn.d.b;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.u2;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.S;
import com.acse.ottn.util.V;
import com.acse.ottn.util.ra;
import java.util.TimerTask;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class s implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibilityService f5470a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f5471b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(AccessibilityService accessibilityService, String str) {
        this.f5470a = accessibilityService;
        this.f5471b = str;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
        C1442n c4;
        try {
            AccessibilityNodeInfo g4 = C1442n.c().g(this.f5470a, "\u540e\u53f0\u5f39\u51fa\u754c\u9762");
            AccessibilityNodeInfo accessibilityNodeInfo = null;
            if (g4 == null) {
                AccessibilityNodeInfo g5 = C1442n.c().g(this.f5470a, this.f5471b);
                if (g5 == null || g5.getParent() == null || g5.getParent().getParent() == null || g5.getParent().getParent().getParent() == null) {
                    return;
                }
                for (int i4 = 0; i4 < g5.getParent().getParent().getParent().getChildCount(); i4++) {
                    if (g5.getParent().getParent().getParent().getChild(i4) != null && "androidx.recyclerview.widget.RecyclerView".equals(g5.getParent().getParent().getParent().getChild(i4).getClassName())) {
                        accessibilityNodeInfo = g5.getParent().getParent().getParent().getChild(i4);
                    }
                }
                C1442n.c().b(accessibilityNodeInfo);
                return;
            }
            TimerTask timerTask = t.f5474c;
            if (timerTask != null) {
                timerTask.cancel();
                t.f5474c = null;
            }
            C1442n.c().f(g4);
            C1442n.c().a(V.a().b(500));
            AccessibilityNodeInfo g6 = C1442n.c().g(this.f5470a, "\u59cb\u7ec8\u5141\u8bb8");
            AccessibilityNodeInfo a4 = C1442n.c().a(this.f5470a, "\u5141\u8bb8", true);
            if (g6 != null) {
                C1442n.c().f(g6);
                C1442n.c().a(V.a().b(100));
                c4 = C1442n.c();
            } else if (a4 == null) {
                return;
            } else {
                C1442n.c().f(a4);
                C1442n.c().a(V.a().b(100));
                c4 = C1442n.c();
            }
            c4.d(this.f5470a);
        } catch (Exception e4) {
            ra.a(u2.f6655a, "e =" + e4.getMessage());
        }
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        t.f5474c = null;
    }
}
