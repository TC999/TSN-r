package com.acse.ottn.p035b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;

/* renamed from: com.acse.ottn.b.z */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class View$OnClickListenerC1442z implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1401A f2602a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1442z(C1401A c1401a) {
        this.f2602a = c1401a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        this.f2602a.f2511b.onOpen();
        Activity activity = this.f2602a.f2512c;
        alertDialog = C1403C.f2514a;
        C1403C.m56849a(activity, alertDialog);
    }
}
