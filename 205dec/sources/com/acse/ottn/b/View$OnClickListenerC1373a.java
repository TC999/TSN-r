package com.acse.ottn.b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;

/* renamed from: com.acse.ottn.b.a  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class View$OnClickListenerC1373a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f5091a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1373a(Activity activity) {
        this.f5091a = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        Activity activity = this.f5091a;
        alertDialog = C1376d.f5099a;
        C1376d.a(activity, alertDialog);
    }
}
