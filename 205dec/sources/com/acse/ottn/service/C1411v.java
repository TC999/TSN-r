package com.acse.ottn.service;

import android.os.Handler;
import android.os.Looper;
import com.acse.ottn.service.Y;
import com.acse.ottn.util.S;
import com.acse.ottn.util.ra;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.service.v  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class C1411v implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Y.a f6587a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1411v(Y.a aVar) {
        this.f6587a = aVar;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
        String str;
        str = Y.f6415a;
        ra.a(str, "\u5f00\u59cb\u5012\u8ba1\u65f6");
        new Handler(Looper.getMainLooper()).postDelayed(new RunnableC1400j(this), 0L);
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        String str;
        str = Y.f6415a;
        ra.a(str, "\u7ed3\u675f\u4e86");
        new Handler(Looper.getMainLooper()).postDelayed(new RunnableC1401k(this), 0L);
    }
}
