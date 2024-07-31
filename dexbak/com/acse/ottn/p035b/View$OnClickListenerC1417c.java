package com.acse.ottn.p035b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.p035b.C1418d;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.b.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1417c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Activity f2542a;

    /* renamed from: b */
    final /* synthetic */ C1418d.InterfaceC1419a f2543b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1417c(Activity activity, C1418d.InterfaceC1419a interfaceC1419a) {
        this.f2542a = activity;
        this.f2543b = interfaceC1419a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        Activity activity = this.f2542a;
        alertDialog = C1418d.f2544a;
        C1418d.m56833a(activity, alertDialog);
        C1418d.InterfaceC1419a interfaceC1419a = this.f2543b;
        if (interfaceC1419a != null) {
            interfaceC1419a.onOpen();
        }
    }
}
