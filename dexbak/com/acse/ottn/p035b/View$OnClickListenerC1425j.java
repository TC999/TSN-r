package com.acse.ottn.p035b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.p035b.C1426k;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.b.j */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1425j implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Activity f2570a;

    /* renamed from: b */
    final /* synthetic */ C1426k.InterfaceC1427a f2571b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1425j(Activity activity, C1426k.InterfaceC1427a interfaceC1427a) {
        this.f2570a = activity;
        this.f2571b = interfaceC1427a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        Activity activity = this.f2570a;
        alertDialog = C1426k.f2572a;
        C1426k.m56823a(activity, alertDialog);
        this.f2571b.mo56522a();
    }
}
