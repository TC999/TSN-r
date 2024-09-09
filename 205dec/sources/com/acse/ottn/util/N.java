package com.acse.ottn.util;

import android.os.Handler;
import android.os.Looper;
import com.acse.ottn.util.S;
import java.util.TimerTask;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class N extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int[] f6770a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f6771b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f6772c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ S.a f6773d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ S f6774e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public N(S s3, int[] iArr, int i4, int i5, S.a aVar) {
        this.f6774e = s3;
        this.f6770a = iArr;
        this.f6771b = i4;
        this.f6772c = i5;
        this.f6773d = aVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable m4;
        int[] iArr = this.f6770a;
        iArr[0] = iArr[0] + this.f6771b;
        if (iArr[0] >= this.f6772c) {
            cancel();
            handler = new Handler(Looper.getMainLooper());
            m4 = new L(this);
        } else {
            handler = new Handler(Looper.getMainLooper());
            m4 = new M(this);
        }
        handler.postDelayed(m4, 0L);
    }
}
