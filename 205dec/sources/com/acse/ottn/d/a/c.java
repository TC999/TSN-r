package com.acse.ottn.d.a;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.util.C1419ba;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.Ka;
import com.acse.ottn.util.S;
import com.acse.ottn.util.ra;
import com.acse.ottn.x1;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class c implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibilityService f5399a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f5400b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AccessibilityService accessibilityService, String str) {
        this.f5399a = accessibilityService;
        this.f5400b = str;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
        TimerTask timerTask;
        TimerTask timerTask2;
        AccessibilityNodeInfo c4 = f.c(this.f5399a.getRootInActiveWindow());
        AccessibilityNodeInfo g4 = C1442n.c().g(this.f5399a, this.f5400b);
        if (g4 == null) {
            if (c4 != null) {
                C1442n.c().b(c4);
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
        if ("honor".equals(Ka.b()) || "tianyi".equals(Ka.b())) {
            C1442n.c().f(g4);
            f.g(this.f5399a);
            return;
        }
        C1419ba.a().a("battery_white", true);
        C1442n.c().f(g4);
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        ra.a(x1.f6974a, "\u7ed3\u675f\u4e86");
    }
}
