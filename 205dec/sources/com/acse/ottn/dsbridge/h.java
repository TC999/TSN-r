package com.acse.ottn.dsbridge;

import android.content.DialogInterface;
import android.webkit.JsResult;
import com.acse.ottn.dsbridge.DWebView;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class h implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ JsResult f5601a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ DWebView.AnonymousClass6 f5602b;

    h(DWebView.AnonymousClass6 anonymousClass6, JsResult jsResult) {
        this.f5602b = anonymousClass6;
        this.f5601a = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i4) {
        dialogInterface.dismiss();
        if (DWebView.this.f5557e) {
            this.f5601a.confirm();
        }
    }
}
