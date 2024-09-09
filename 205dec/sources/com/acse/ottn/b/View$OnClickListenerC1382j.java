package com.acse.ottn.b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.b.C1383k;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.b.j  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class View$OnClickListenerC1382j implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f5130a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1383k.a f5131b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1382j(Activity activity, C1383k.a aVar) {
        this.f5130a = activity;
        this.f5131b = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        Activity activity = this.f5130a;
        alertDialog = C1383k.f5132a;
        C1383k.a(activity, alertDialog);
        this.f5131b.a();
    }
}
