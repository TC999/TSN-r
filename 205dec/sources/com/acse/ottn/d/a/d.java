package com.acse.ottn.d.a;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.S;
import com.acse.ottn.util.V;
import com.acse.ottn.util.ra;
import com.acse.ottn.x1;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class d implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f5401a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AccessibilityService f5402b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str, AccessibilityService accessibilityService) {
        this.f5401a = str;
        this.f5402b = accessibilityService;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
        TimerTask timerTask;
        TimerTask timerTask2;
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeInfo accessibilityNodeInfo2;
        try {
            if (this.f5401a == null) {
                return;
            }
            AccessibilityNodeInfo g4 = C1442n.c().g(this.f5402b, this.f5401a);
            if (g4 == null) {
                f.j(this.f5402b);
                accessibilityNodeInfo = f.f5408e;
                if (accessibilityNodeInfo != null) {
                    C1442n c4 = C1442n.c();
                    accessibilityNodeInfo2 = f.f5408e;
                    c4.b(accessibilityNodeInfo2);
                    return;
                }
                return;
            }
            timerTask = f.f5407d;
            if (timerTask != null) {
                timerTask2 = f.f5407d;
                timerTask2.cancel();
                TimerTask unused = f.f5407d = null;
            }
            ra.a(x1.f6974a, "\u627e\u5230\u4e86\u5b9a\u4f4d");
            C1442n.c().f(g4);
            C1442n.c().a(V.a().b(200));
            AccessibilityNodeInfo g5 = C1442n.c().g(this.f5402b, "\u59cb\u7ec8\u5141\u8bb8");
            AccessibilityNodeInfo a4 = C1442n.c().a(this.f5402b, "\u5141\u8bb8", true);
            if (g5 != null) {
                C1442n.c().f(g5);
            } else if (a4 == null) {
                return;
            } else {
                C1442n.c().f(a4);
            }
            f.b(this.f5402b, 1);
        } catch (Exception e4) {
            ra.a(x1.f6974a, "e =" + e4.getMessage());
        }
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        TimerTask unused = f.f5407d = null;
    }
}
