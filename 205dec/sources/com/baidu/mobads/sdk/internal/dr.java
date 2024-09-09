package com.baidu.mobads.sdk.internal;

import android.os.CountDownTimer;
import android.widget.TextView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
class dr extends CountDownTimer {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ dp f12815a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dr(dp dpVar, long j4, long j5) {
        super(j4, j5);
        this.f12815a = dpVar;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f12815a.f12805b.a("CountDownTimer finished");
        this.f12815a.c();
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j4) {
        TextView textView;
        int i4 = (int) (j4 / 1000);
        if (i4 > 5) {
            i4 = 5;
        }
        textView = this.f12815a.f12807d;
        textView.setText(String.valueOf(i4));
    }
}
