package com.baidu.mobads.sdk.internal;

import android.os.CountDownTimer;
import android.widget.TextView;

/* renamed from: com.baidu.mobads.sdk.internal.do */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class CountDownTimerC2697do extends CountDownTimer {

    /* renamed from: a */
    final /* synthetic */ C2695dm f9014a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountDownTimerC2697do(C2695dm c2695dm, long j, long j2) {
        super(j, j2);
        this.f9014a = c2695dm;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f9014a.f9004b.m50742a("CountDownTimer finished");
        this.f9014a.m50490c();
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        TextView textView;
        int i = (int) (j / 1000);
        if (i > 5) {
            i = 5;
        }
        textView = this.f9014a.f9006d;
        textView.setText(String.valueOf(i));
    }
}
