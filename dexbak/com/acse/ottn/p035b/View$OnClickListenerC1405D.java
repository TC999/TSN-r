package com.acse.ottn.p035b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.p035b.C1409H;

/* renamed from: com.acse.ottn.b.D */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class View$OnClickListenerC1405D implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1409H.InterfaceC1410a f2520a;

    /* renamed from: b */
    final /* synthetic */ Activity f2521b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1405D(C1409H.InterfaceC1410a interfaceC1410a, Activity activity) {
        this.f2520a = interfaceC1410a;
        this.f2521b = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        this.f2520a.onOpen();
        Activity activity = this.f2521b;
        alertDialog = C1409H.f2525a;
        C1409H.m56844a(activity, alertDialog);
    }
}
