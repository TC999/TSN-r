package com.acse.ottn.d.b;

import android.accessibilityservice.AccessibilityService;
import android.app.Application;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.Ka;
import com.acse.ottn.util.S;
import com.acse.ottn.util.V;
import com.acse.ottn.util.ra;
import com.acse.ottn.x2;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class w implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibilityService f5480a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f5481b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(AccessibilityService accessibilityService, String str) {
        this.f5480a = accessibilityService;
        this.f5481b = str;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
        Application application;
        ra.a("samon-->", "openAndroid12OppoFlowWindowPermission  \u5012\u8ba1\u65f6");
        try {
            AccessibilityNodeInfo g4 = C1442n.c().g(this.f5480a, this.f5481b);
            if (g4 == null) {
                if (Build.VERSION.SDK_INT < 24 || (application = AcseHelpManager.mContext) == null) {
                    return;
                }
                C1442n.a(this.f5480a, Ka.c(application) / 3, ((Ka.b(AcseHelpManager.mContext) * 2) / 3) + 300, (Ka.c(AcseHelpManager.mContext) / 3) + 100, Ka.b(AcseHelpManager.mContext) / 3, 300);
                return;
            }
            TimerTask timerTask = z.f5486c;
            if (timerTask != null) {
                timerTask.cancel();
                z.f5486c = null;
                ra.a(x2.f6988a, "\u53d6\u6d88\u5012\u8ba1\u65f6");
            }
            ra.a(x2.f6988a, "\u627e\u5230\u4e86");
            C1442n.c().f(g4);
            C1442n.c().a(V.a().b(500));
            StringBuilder sb = new StringBuilder();
            sb.append("\u70b9\u51fb1=");
            sb.append(System.currentTimeMillis());
            ra.a(x2.f6988a, sb.toString());
            AccessibilityNodeInfo g5 = C1442n.c().g(this.f5480a, "\u5141\u8bb8");
            if (g5 != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("\u70b9\u51fb2=");
                sb2.append(System.currentTimeMillis());
                ra.a(x2.f6988a, sb2.toString());
                C1442n.c().f(g5);
                C1442n.c().d(this.f5480a);
                C1442n.c().d(this.f5480a);
            }
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
