package com.acse.ottn.b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class t implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ u f5154a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(u uVar) {
        this.f5154a = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        this.f5154a.f5156b.onOpen();
        Activity activity = this.f5154a.f5157c;
        alertDialog = C.f5065a;
        C.a(activity, alertDialog);
    }
}
