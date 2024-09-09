package com.acse.ottn.d.b;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.o4;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.S;
import com.acse.ottn.util.ra;
import java.util.TimerTask;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class C implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibilityService f5417a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f5418b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C(AccessibilityService accessibilityService, String str) {
        this.f5417a = accessibilityService;
        this.f5418b = str;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeInfo accessibilityNodeInfo2;
        F.h(this.f5417a);
        try {
            if (C1442n.c().g(this.f5417a, this.f5418b) == null) {
                accessibilityNodeInfo = F.f5427d;
                if (accessibilityNodeInfo != null) {
                    C1442n c4 = C1442n.c();
                    accessibilityNodeInfo2 = F.f5427d;
                    c4.b(accessibilityNodeInfo2);
                }
            } else {
                TimerTask timerTask = F.f5426c;
                if (timerTask != null) {
                    timerTask.cancel();
                    F.f5426c = null;
                }
            }
        } catch (Exception e4) {
            ra.a(o4.f6114a, "e =" + e4.getMessage());
        }
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        F.f5426c = null;
    }
}
