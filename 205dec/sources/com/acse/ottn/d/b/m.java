package com.acse.ottn.d.b;

import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.o2;
import com.acse.ottn.service.ShopHelperService;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.S;
import com.acse.ottn.util.ra;
import java.util.TimerTask;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class m implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ShopHelperService f5459a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f5460b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ShopHelperService shopHelperService, String str) {
        this.f5459a = shopHelperService;
        this.f5460b = str;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeInfo accessibilityNodeInfo2;
        try {
            AccessibilityNodeInfo g4 = C1442n.c().g(this.f5459a, this.f5460b);
            if (g4 == null) {
                q.h(this.f5459a);
                accessibilityNodeInfo = q.f5467c;
                if (accessibilityNodeInfo == null) {
                    return;
                }
                C1442n c4 = C1442n.c();
                accessibilityNodeInfo2 = q.f5467c;
                c4.b(accessibilityNodeInfo2);
                return;
            }
            TimerTask timerTask = q.f5466b;
            if (timerTask != null) {
                timerTask.cancel();
                q.f5466b = null;
            }
            ra.a(o2.f6096a, "\u627e\u5230\u4e86");
            C1442n.c().f(g4);
            C1442n.c().d(this.f5459a);
        } catch (Exception e4) {
            ra.a(o2.f6096a, "e =" + e4.getMessage());
        }
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        q.f5466b = null;
        ra.a(o2.f6096a, "\u7ed3\u675f\u4e86");
    }
}
