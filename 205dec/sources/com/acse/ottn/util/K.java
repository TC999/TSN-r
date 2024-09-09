package com.acse.ottn.util;

import android.os.CountDownTimer;
import com.acse.ottn.util.S;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class K extends CountDownTimer {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ S.a f6762a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ S f6763b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(S s3, long j4, long j5, S.a aVar) {
        super(j4, j5);
        this.f6763b = s3;
        this.f6762a = aVar;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f6762a.onFinish();
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j4) {
        this.f6762a.a(j4);
    }
}
