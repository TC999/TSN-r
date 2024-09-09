package com.acse.ottn.d.b;

import android.accessibilityservice.AccessibilityService;
import android.app.Application;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.Ka;
import com.acse.ottn.util.S;
import com.acse.ottn.util.ra;
import com.acse.ottn.x2;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class u implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibilityService f5476a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f5477b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(AccessibilityService accessibilityService, String str) {
        this.f5476a = accessibilityService;
        this.f5477b = str;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
        Application application;
        ra.a("samon-->", "openOppoFlowWindowPermission  \u5012\u8ba1\u65f6");
        try {
            AccessibilityNodeInfo g4 = C1442n.c().g(this.f5476a, this.f5477b);
            if (g4 == null) {
                if (Build.VERSION.SDK_INT < 24 || (application = AcseHelpManager.mContext) == null) {
                    return;
                }
                C1442n.a(this.f5476a, Ka.c(application) / 3, ((Ka.b(AcseHelpManager.mContext) * 2) / 3) + 300, (Ka.c(AcseHelpManager.mContext) / 3) + 100, Ka.b(AcseHelpManager.mContext) / 3, 300);
                return;
            }
            TimerTask timerTask = z.f5486c;
            if (timerTask != null) {
                timerTask.cancel();
                z.f5486c = null;
            }
            ra.a(x2.f6988a, "\u627e\u5230\u4e86");
            C1442n.c().f(g4);
            C1442n.c().d(this.f5476a);
        } catch (Exception e4) {
            ra.a(x2.f6988a, "e =" + e4.getMessage());
        }
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        z.f5486c = null;
        ra.a(x2.f6988a, "\u7ed3\u675f\u4e86");
    }
}
