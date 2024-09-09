package com.acse.ottn.d.b;

import android.accessibilityservice.AccessibilityService;
import android.app.Application;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.u2;
import com.acse.ottn.util.C1419ba;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.Ka;
import com.acse.ottn.util.S;
import com.acse.ottn.util.ra;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class r implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibilityService f5468a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f5469b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(AccessibilityService accessibilityService, String str) {
        this.f5468a = accessibilityService;
        this.f5469b = str;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
        try {
            AccessibilityNodeInfo g4 = C1442n.c().g(this.f5468a, this.f5469b);
            if (g4 == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    ra.a(u2.f6655a, "\u6ed1\u52a8");
                    Application application = AcseHelpManager.mContext;
                    if (application == null) {
                        return;
                    }
                    C1442n.a(this.f5468a, Ka.c(application) / 3, ((Ka.b(AcseHelpManager.mContext) * 2) / 3) + 300, (Ka.c(AcseHelpManager.mContext) / 3) + 100, Ka.b(AcseHelpManager.mContext) / 3, 300);
                    return;
                }
                return;
            }
            TimerTask timerTask = t.f5474c;
            if (timerTask != null) {
                timerTask.cancel();
                t.f5474c = null;
            }
            ra.a(u2.f6655a, "\u627e\u5230\u4e86");
            if (C1419ba.a() != null) {
                C1419ba.a().a("battery_white", true);
            }
            C1442n.c().f(g4);
        } catch (Exception e4) {
            ra.a(u2.f6655a, "e =" + e4.getMessage());
        }
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        t.f5474c = null;
    }
}
