package com.acse.ottn.d.b;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.service.ShopHelperService;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.CommonUtil;
import com.acse.ottn.util.S;
import java.util.TimerTask;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class p implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ShopHelperService f5464a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ShopHelperService shopHelperService) {
        this.f5464a = shopHelperService;
    }

    @Override // com.acse.ottn.util.S.a
    @RequiresApi(api = 16)
    public void a(long j4) {
        AccessibilityNodeInfo a4 = C1442n.c().a((AccessibilityService) this.f5464a, "\u5141\u8bb8", true);
        if (a4 != null) {
            TimerTask timerTask = q.f5466b;
            if (timerTask != null) {
                timerTask.cancel();
                q.f5466b = null;
            }
            C1442n.c().f(a4);
            CommonUtil.setButteryState(true);
            C1442n.c().d(this.f5464a);
            C1442n.c().d(this.f5464a);
        }
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        TimerTask timerTask = q.f5466b;
        if (timerTask != null) {
            timerTask.cancel();
            q.f5466b = null;
        }
        CommonUtil.setButteryState(true);
        C1442n.c().d(this.f5464a);
        C1442n.c().d(this.f5464a);
    }
}
