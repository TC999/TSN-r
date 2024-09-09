package com.acse.ottn.b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class E implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f5073a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public E(Activity activity) {
        this.f5073a = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        Activity activity = this.f5073a;
        alertDialog = H.f5076a;
        H.a(activity, alertDialog);
    }
}
