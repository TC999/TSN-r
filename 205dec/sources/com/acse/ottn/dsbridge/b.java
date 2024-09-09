package com.acse.ottn.dsbridge;

import android.app.Activity;
import android.content.Context;
import com.acse.ottn.dsbridge.DWebView;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DWebView.AnonymousClass1 f5590a;

    b(DWebView.AnonymousClass1 anonymousClass1) {
        this.f5590a = anonymousClass1;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (DWebView.this.f5558f == null || DWebView.this.f5558f.onClose()) {
            Context context = DWebView.this.getContext();
            if (context instanceof Activity) {
                ((Activity) context).onBackPressed();
            }
        }
    }
}
