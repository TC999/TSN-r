package com.acse.ottn.d.b;

import android.accessibilityservice.AccessibilityService;
import com.acse.ottn.l1;
import com.acse.ottn.util.C1419ba;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.CommonUtil;
import com.acse.ottn.util.S;
import com.acse.ottn.util.ra;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.b.e  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class C1389e implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibilityService f5438a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1389e(AccessibilityService accessibilityService) {
        this.f5438a = accessibilityService;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
        ra.a("samon-->", "clickOpenBatteryDetails  \u5012\u8ba1\u65f6");
        if (C1442n.c().g(this.f5438a, "\u624b\u52a8\u7ba1\u7406") != null) {
            TimerTask timerTask = h.f5446d;
            if (timerTask != null) {
                timerTask.cancel();
                h.f5446d = null;
            }
            h.b("\u5141\u8bb8\u81ea\u542f\u52a8", this.f5438a);
            h.b("\u5141\u8bb8\u5173\u8054\u542f\u52a8", this.f5438a);
            h.b("\u5141\u8bb8\u540e\u53f0\u6d3b\u52a8", this.f5438a);
            CommonUtil.setButteryState(true);
            C1442n.c().d(this.f5438a);
            C1442n.c().d(this.f5438a);
            C1442n.c().d(this.f5438a);
            if (C1419ba.a() != null) {
                C1419ba.a().a("battery_white", false);
            }
        }
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        ra.a(l1.f5876a, "\u7ed3\u675f\u4e86");
        h.f5446d = null;
    }
}
