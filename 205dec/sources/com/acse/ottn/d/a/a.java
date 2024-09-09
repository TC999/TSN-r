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
public class a implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibilityService f5393a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f5394b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AccessibilityService accessibilityService, String str) {
        this.f5393a = accessibilityService;
        this.f5394b = str;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
        TimerTask timerTask;
        TimerTask timerTask2;
        try {
            AccessibilityNodeInfo g4 = C1442n.c().g(this.f5393a, this.f5394b);
            if (g4 != null) {
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
        } catch (Exception e4) {
            ra.a(x1.f6974a, "e =" + e4.getMessage());
        }
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        TimerTask unused = f.f5407d = null;
    }
}
