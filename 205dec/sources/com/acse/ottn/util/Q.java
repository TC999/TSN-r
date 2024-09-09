package com.acse.ottn.util;

import android.os.Handler;
import android.os.Looper;
import com.acse.ottn.util.S;
import java.util.TimerTask;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class Q extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int[] f6781a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f6782b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f6783c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ S.a f6784d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ S f6785e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Q(S s3, int[] iArr, int i4, int i5, S.a aVar) {
        this.f6785e = s3;
        this.f6781a = iArr;
        this.f6782b = i4;
        this.f6783c = i5;
        this.f6784d = aVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable p3;
        int[] iArr = this.f6781a;
        iArr[0] = iArr[0] + this.f6782b;
        if (iArr[0] >= this.f6783c) {
            cancel();
            handler = new Handler(Looper.getMainLooper());
            p3 = new O(this);
        } else {
            handler = new Handler(Looper.getMainLooper());
            p3 = new P(this);
        }
        handler.postDelayed(p3, 0L);
    }
}
