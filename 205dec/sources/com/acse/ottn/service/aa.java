package com.acse.ottn.service;

import android.os.Handler;
import android.os.Looper;
import com.acse.ottn.util.S;
import com.acse.ottn.util.ra;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class aa implements S.a {
    aa() {
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        ra.a(WebViewService.f6401h, "\u7ed3\u675f\u4e86");
        new Handler(Looper.getMainLooper()).postDelayed(new Z(this), 0L);
    }
}
