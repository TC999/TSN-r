package com.acse.ottn.dsbridge;

import android.content.DialogInterface;
import android.webkit.JsResult;
import com.acse.ottn.dsbridge.DWebView;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class i implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ JsResult f5603a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ DWebView.AnonymousClass6 f5604b;

    i(DWebView.AnonymousClass6 anonymousClass6, JsResult jsResult) {
        this.f5604b = anonymousClass6;
        this.f5603a = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i4) {
        if (DWebView.this.f5557e) {
            if (i4 == -1) {
                this.f5603a.confirm();
            } else {
                this.f5603a.cancel();
            }
        }
    }
}
