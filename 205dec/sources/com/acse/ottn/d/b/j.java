package com.acse.ottn.d.b;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.h2;
import com.acse.ottn.util.C1419ba;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.Ka;
import com.acse.ottn.util.S;
import com.acse.ottn.util.V;
import com.acse.ottn.util.ra;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class j implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibilityService f5451a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f5452b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(AccessibilityService accessibilityService, String str) {
        this.f5451a = accessibilityService;
        this.f5452b = str;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeInfo accessibilityNodeInfo2;
        ra.a("samon-->", "openMiuiFlowWindowPermission\u5012\u8ba1\u65f6");
        try {
            AccessibilityNodeInfo g4 = C1442n.c().g(this.f5451a, this.f5452b);
            if (g4 == null) {
                l.i(this.f5451a);
                accessibilityNodeInfo = l.f5458d;
                if (accessibilityNodeInfo != null) {
                    C1442n c4 = C1442n.c();
                    accessibilityNodeInfo2 = l.f5458d;
                    c4.b(accessibilityNodeInfo2);
                    return;
                }
                return;
            }
            TimerTask timerTask = l.f5457c;
            if (timerTask != null) {
                timerTask.cancel();
                l.f5457c = null;
            }
            ra.a(h2.f5715a, "\u627e\u5230\u4e86");
            C1419ba.a().a("battery_white", true);
            C1442n.c().f(g4);
            if ("samsung".equals(Ka.b())) {
                C1442n.c().a(V.a().b(200));
                C1442n.c().d(this.f5451a);
            }
        } catch (Exception e4) {
            ra.a(h2.f5715a, "e =" + e4.getMessage());
        }
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        l.f5457c = null;
    }
}
