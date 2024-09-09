package com.acse.ottn.d.a;

import android.accessibilityservice.AccessibilityService;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.Ka;
import com.acse.ottn.util.S;
import com.acse.ottn.util.ra;
import com.acse.ottn.x1;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class e implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibilityService f5403a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AccessibilityService accessibilityService) {
        this.f5403a = accessibilityService;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
        TimerTask timerTask;
        TimerTask timerTask2;
        if (C1442n.c().h(this.f5403a, "\u5b9a\u4f4d") != null) {
            C1442n.c().i(this.f5403a, "\u5b9a\u4f4d");
            C1442n.c().a(100L);
            AccessibilityNodeInfo h4 = C1442n.c().h(this.f5403a, "\u59cb\u7ec8\u5141\u8bb8");
            if (h4 != null) {
                timerTask = f.f5407d;
                if (timerTask != null) {
                    timerTask2 = f.f5407d;
                    timerTask2.cancel();
                    TimerTask unused = f.f5407d = null;
                }
                ra.a(x1.f6974a, "clickVivoLocation appNodeInfo is not null");
                C1442n.c().f(h4);
                f.b(this.f5403a, 1);
                return;
            }
            ra.a(x1.f6974a, "clickVivoLocation appNodeInfo is null");
            if (Build.VERSION.SDK_INT < 24) {
                return;
            }
        } else if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        AccessibilityService accessibilityService = this.f5403a;
        C1442n.a(accessibilityService, Ka.c(accessibilityService) / 3, ((Ka.b(this.f5403a) * 2) / 3) + 300, (Ka.c(this.f5403a) / 3) + 100, Ka.b(this.f5403a) / 3, 200);
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        TimerTask unused = f.f5407d = null;
    }
}
