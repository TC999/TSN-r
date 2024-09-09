package com.acse.ottn.d.b;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.l1;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.CommonUtil;
import com.acse.ottn.util.S;
import com.acse.ottn.util.ra;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class g implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibilityService f5441a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f5442b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AccessibilityService accessibilityService, String str) {
        this.f5441a = accessibilityService;
        this.f5442b = str;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
        ra.a("samon-->", "clickView  \u5012\u8ba1\u65f6");
        AccessibilityNodeInfo d4 = h.d(this.f5441a.getRootInActiveWindow());
        if (C1442n.c().g(this.f5441a, this.f5442b) == null) {
            if (d4 != null) {
                C1442n.c().b(d4);
                return;
            }
            return;
        }
        TimerTask timerTask = h.f5446d;
        if (timerTask != null) {
            timerTask.cancel();
            h.f5446d = null;
        }
        h.b(this.f5442b, this.f5441a);
        CommonUtil.setServiceHightButteryState(true);
        C1442n.c().d(this.f5441a);
        C1442n.c().d(this.f5441a);
        C1442n.c().d(this.f5441a);
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        ra.a(l1.f5876a, "\u7ed3\u675f\u4e86");
    }
}
