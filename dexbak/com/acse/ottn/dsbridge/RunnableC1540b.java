package com.acse.ottn.dsbridge;

import android.app.Activity;
import android.content.Context;
import com.acse.ottn.dsbridge.DWebView;

/* renamed from: com.acse.ottn.dsbridge.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class RunnableC1540b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ DWebView.C15341 f2864a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1540b(DWebView.C15341 c15341) {
        this.f2864a = c15341;
    }

    @Override // java.lang.Runnable
    public void run() {
        DWebView.InterfaceC1538c interfaceC1538c;
        DWebView.InterfaceC1538c interfaceC1538c2;
        interfaceC1538c = DWebView.this.f2852i;
        if (interfaceC1538c != null) {
            interfaceC1538c2 = DWebView.this.f2852i;
            if (!interfaceC1538c2.onClose()) {
                return;
            }
        }
        Context context = DWebView.this.getContext();
        if (context instanceof Activity) {
            ((Activity) context).onBackPressed();
        }
    }
}
