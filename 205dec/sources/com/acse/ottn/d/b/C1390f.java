package com.acse.ottn.d.b;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.l1;
import com.acse.ottn.util.C1419ba;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.S;
import com.acse.ottn.util.ra;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.b.f  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class C1390f implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibilityService f5439a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AccessibilityNodeInfo f5440b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1390f(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f5439a = accessibilityService;
        this.f5440b = accessibilityNodeInfo;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
        ra.a("samon-->", "bbbb  \u5012\u8ba1\u65f6");
        AccessibilityNodeInfo g4 = C1442n.c().g(this.f5439a, "\u540e\u53f0\u5f39\u7a97");
        if (g4 == null) {
            C1442n.c().b(this.f5440b);
            return;
        }
        TimerTask timerTask = h.f5446d;
        if (timerTask != null) {
            timerTask.cancel();
            h.f5446d = null;
        }
        C1442n.c().f(g4);
        if (C1419ba.a() != null) {
            C1419ba.a().a("battery_white", true);
        }
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        ra.a(l1.f5876a, "\u7ed3\u675f\u4e86");
    }
}
