package com.acse.ottn.d.b;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.CommonUtil;
import com.acse.ottn.util.S;
import com.acse.ottn.util.ra;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class y implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibilityService f5483a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(AccessibilityService accessibilityService) {
        this.f5483a = accessibilityService;
    }

    @Override // com.acse.ottn.util.S.a
    @RequiresApi(api = 16)
    public void a(long j4) {
        ra.a("samon-->", "backClick  \u5012\u8ba1\u65f6");
        AccessibilityNodeInfo a4 = C1442n.c().a(this.f5483a, "\u5141\u8bb8", true);
        if (a4 != null) {
            TimerTask timerTask = z.f5486c;
            if (timerTask != null) {
                timerTask.cancel();
                z.f5486c = null;
            }
            C1442n.c().f(a4);
            CommonUtil.setButteryState(true);
            C1442n.c().d(this.f5483a);
            C1442n.c().d(this.f5483a);
        }
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        TimerTask timerTask = z.f5486c;
        if (timerTask != null) {
            timerTask.cancel();
            z.f5486c = null;
        }
        CommonUtil.setButteryState(true);
        C1442n.c().d(this.f5483a);
        C1442n.c().d(this.f5483a);
    }
}
