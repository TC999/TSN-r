package com.acse.ottn.b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.b.C1376d;

/* renamed from: com.acse.ottn.b.c  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class View$OnClickListenerC1375c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f5095a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1376d.a f5096b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1375c(Activity activity, C1376d.a aVar) {
        this.f5095a = activity;
        this.f5096b = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        Activity activity = this.f5095a;
        alertDialog = C1376d.f5099a;
        C1376d.a(activity, alertDialog);
        C1376d.a aVar = this.f5096b;
        if (aVar != null) {
            aVar.onOpen();
        }
    }
}
