package com.acse.ottn.service;

import android.os.Handler;
import android.os.Looper;
import com.acse.ottn.util.S;
import com.acse.ottn.util.ra;

/* renamed from: com.acse.ottn.service.b  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class C1392b implements S.a {
    C1392b() {
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.acse.ottn.service.a, java.lang.Runnable] */
    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        ra.a(DemoService.f6300a, "\u7ed3\u675f\u4e86");
        new Handler(Looper.getMainLooper()).postDelayed(new C1391a(this), 0L);
    }
}
