package com.acse.ottn.d.b;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.l1;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.S;
import com.acse.ottn.util.ra;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.b.a  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class C1385a implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibilityService f5428a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f5429b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1385a(AccessibilityService accessibilityService, boolean z3) {
        this.f5428a = accessibilityService;
        this.f5429b = z3;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
        try {
            ra.a("samon-->", "clickOpenFlowWindow  \u5012\u8ba1\u65f6");
            AccessibilityNodeInfo g4 = C1442n.c().g(this.f5428a, "\u5728\u5176\u4ed6\u5e94\u7528\u4e0a\u5c42\u663e\u793a");
            h.g(this.f5428a);
            if (g4 == null || g4.getParent() == null) {
                return;
            }
            TimerTask timerTask = h.f5446d;
            if (timerTask != null) {
                timerTask.cancel();
                h.f5446d = null;
            }
            for (int i4 = 0; i4 < g4.getParent().getChildCount(); i4++) {
                if (g4.getParent().getChild(i4) != null && "android.widget.Switch".equals(g4.getParent().getChild(i4).getClassName())) {
                    C1442n.c().f(g4.getParent().getChild(i4));
                    C1442n.c().d(this.f5428a);
                    if (this.f5429b) {
                        C1442n.c().d(this.f5428a);
                        return;
                    }
                    return;
                }
            }
        } catch (Exception e4) {
            ra.a(l1.f5876a, "e =" + e4.getMessage());
        }
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        h.f5446d = null;
    }
}
