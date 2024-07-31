package com.acse.ottn.p035b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.b.B */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1402B implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Activity f2513a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1402B(Activity activity) {
        this.f2513a = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        Activity activity = this.f2513a;
        alertDialog = C1403C.f2514a;
        C1403C.m56849a(activity, alertDialog);
    }
}
