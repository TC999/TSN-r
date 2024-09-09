package com.acse.ottn.b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.b.H;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class D implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ H.a f5071a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Activity f5072b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public D(H.a aVar, Activity activity) {
        this.f5071a = aVar;
        this.f5072b = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        this.f5071a.onOpen();
        Activity activity = this.f5072b;
        alertDialog = H.f5076a;
        H.a(activity, alertDialog);
    }
}
