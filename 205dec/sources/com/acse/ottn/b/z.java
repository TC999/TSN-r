package com.acse.ottn.b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class z implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ A f5162a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(A a4) {
        this.f5162a = a4;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        this.f5162a.f5062b.onOpen();
        Activity activity = this.f5162a.f5063c;
        alertDialog = C.f5065a;
        C.a(activity, alertDialog);
    }
}
