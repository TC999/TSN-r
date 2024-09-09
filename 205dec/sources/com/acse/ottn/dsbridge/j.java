package com.acse.ottn.dsbridge;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.widget.EditText;
import com.acse.ottn.dsbridge.DWebView;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class j implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ JsPromptResult f5605a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ EditText f5606b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ DWebView.AnonymousClass6 f5607c;

    j(DWebView.AnonymousClass6 anonymousClass6, JsPromptResult jsPromptResult, EditText editText) {
        this.f5607c = anonymousClass6;
        this.f5605a = jsPromptResult;
        this.f5606b = editText;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i4) {
        if (DWebView.this.f5557e) {
            if (i4 == -1) {
                this.f5605a.confirm(this.f5606b.getText().toString());
            } else {
                this.f5605a.cancel();
            }
        }
    }
}
