package com.acse.ottn.b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class B implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f5064a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B(Activity activity) {
        this.f5064a = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        Activity activity = this.f5064a;
        alertDialog = C.f5065a;
        C.a(activity, alertDialog);
    }
}
