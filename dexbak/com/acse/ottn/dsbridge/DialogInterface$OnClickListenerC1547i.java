package com.acse.ottn.dsbridge;

import android.content.DialogInterface;
import android.webkit.JsResult;
import com.acse.ottn.dsbridge.DWebView;

/* renamed from: com.acse.ottn.dsbridge.i */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class DialogInterface$OnClickListenerC1547i implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ JsResult f2877a;

    /* renamed from: b */
    final /* synthetic */ DWebView.C15356 f2878b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterface$OnClickListenerC1547i(DWebView.C15356 c15356, JsResult jsResult) {
        this.f2878b = c15356;
        this.f2877a = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (DWebView.this.f2851h) {
            if (i == -1) {
                this.f2877a.confirm();
            } else {
                this.f2877a.cancel();
            }
        }
    }
}
