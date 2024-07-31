package com.acse.ottn.dsbridge;

import android.content.DialogInterface;
import android.webkit.JsResult;
import com.acse.ottn.dsbridge.DWebView;

/* renamed from: com.acse.ottn.dsbridge.h */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class DialogInterface$OnClickListenerC1546h implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ JsResult f2875a;

    /* renamed from: b */
    final /* synthetic */ DWebView.C15356 f2876b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterface$OnClickListenerC1546h(DWebView.C15356 c15356, JsResult jsResult) {
        this.f2876b = c15356;
        this.f2875a = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (DWebView.this.f2851h) {
            this.f2875a.confirm();
        }
    }
}
