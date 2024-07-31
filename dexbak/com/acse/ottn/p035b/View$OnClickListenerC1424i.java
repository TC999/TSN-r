package com.acse.ottn.p035b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.p035b.C1426k;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.b.i */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1424i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Activity f2568a;

    /* renamed from: b */
    final /* synthetic */ C1426k.InterfaceC1427a f2569b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1424i(Activity activity, C1426k.InterfaceC1427a interfaceC1427a) {
        this.f2568a = activity;
        this.f2569b = interfaceC1427a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        Activity activity = this.f2568a;
        alertDialog = C1426k.f2572a;
        C1426k.m56823a(activity, alertDialog);
        this.f2569b.mo56521b();
    }
}
