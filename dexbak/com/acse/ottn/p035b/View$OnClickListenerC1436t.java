package com.acse.ottn.p035b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;

/* renamed from: com.acse.ottn.b.t */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class View$OnClickListenerC1436t implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1437u f2594a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1436t(C1437u c1437u) {
        this.f2594a = c1437u;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        this.f2594a.f2596b.onOpen();
        Activity activity = this.f2594a.f2597c;
        alertDialog = C1403C.f2514a;
        C1403C.m56849a(activity, alertDialog);
    }
}
