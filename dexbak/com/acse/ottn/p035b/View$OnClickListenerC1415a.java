package com.acse.ottn.p035b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.b.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1415a implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Activity f2539a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1415a(Activity activity) {
        this.f2539a = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        Activity activity = this.f2539a;
        alertDialog = C1418d.f2544a;
        C1418d.m56833a(activity, alertDialog);
    }
}
