package com.acse.ottn.p035b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.p035b.C1418d;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.b.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1416b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Activity f2540a;

    /* renamed from: b */
    final /* synthetic */ C1418d.InterfaceC1419a f2541b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1416b(Activity activity, C1418d.InterfaceC1419a interfaceC1419a) {
        this.f2540a = activity;
        this.f2541b = interfaceC1419a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        Activity activity = this.f2540a;
        alertDialog = C1418d.f2544a;
        C1418d.m56833a(activity, alertDialog);
        C1418d.InterfaceC1419a interfaceC1419a = this.f2541b;
        if (interfaceC1419a != null) {
            interfaceC1419a.onDismiss();
        }
    }
}
