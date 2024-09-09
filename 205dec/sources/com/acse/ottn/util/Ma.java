package com.acse.ottn.util;

import android.os.CountDownTimer;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.util.S;
import java.util.ArrayList;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class Ma implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibilityNodeInfo f6768a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Na f6769b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ma(Na na, AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f6769b = na;
        this.f6768a = accessibilityNodeInfo;
    }

    @Override // com.acse.ottn.util.S.a
    @RequiresApi(api = 16)
    public void a(long j4) {
        CountDownTimer countDownTimer;
        this.f6769b.f6778d = new ArrayList();
        this.f6769b.a(this.f6768a);
        Na na = this.f6769b;
        if (!na.a(na.f6778d) || (countDownTimer = Na.f6777c) == null) {
            return;
        }
        countDownTimer.cancel();
        Na.f6777c = null;
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
    }
}
