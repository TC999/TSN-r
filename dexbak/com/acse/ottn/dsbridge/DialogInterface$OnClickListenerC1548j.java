package com.acse.ottn.dsbridge;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.widget.EditText;
import com.acse.ottn.dsbridge.DWebView;

/* renamed from: com.acse.ottn.dsbridge.j */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class DialogInterface$OnClickListenerC1548j implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ JsPromptResult f2879a;

    /* renamed from: b */
    final /* synthetic */ EditText f2880b;

    /* renamed from: c */
    final /* synthetic */ DWebView.C15356 f2881c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterface$OnClickListenerC1548j(DWebView.C15356 c15356, JsPromptResult jsPromptResult, EditText editText) {
        this.f2881c = c15356;
        this.f2879a = jsPromptResult;
        this.f2880b = editText;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (DWebView.this.f2851h) {
            if (i == -1) {
                this.f2879a.confirm(this.f2880b.getText().toString());
            } else {
                this.f2879a.cancel();
            }
        }
    }
}
