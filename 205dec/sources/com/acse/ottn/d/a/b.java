package com.acse.ottn.d.a;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.util.C1419ba;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.S;
import com.acse.ottn.util.ra;
import com.acse.ottn.x1;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class b implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibilityService f5397a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AccessibilityNodeInfo f5398b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f5397a = accessibilityService;
        this.f5398b = accessibilityNodeInfo;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
        TimerTask timerTask;
        TimerTask timerTask2;
        AccessibilityNodeInfo g4 = C1442n.c().g(this.f5397a, "\u4f4d\u7f6e\u4fe1\u606f");
        if (g4 == null) {
            C1442n.c().b(this.f5398b);
            return;
        }
        timerTask = f.f5407d;
        if (timerTask != null) {
            timerTask2 = f.f5407d;
            timerTask2.cancel();
            TimerTask unused = f.f5407d = null;
        }
        C1442n.c().f(g4);
        if (C1419ba.a() != null) {
            C1419ba.a().a("battery_white", true);
            C1419ba.a().a("location_permission", true);
        }
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        ra.a(x1.f6974a, "\u7ed3\u675f\u4e86");
    }
}
