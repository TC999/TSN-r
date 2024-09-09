package com.acse.ottn;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class o0 extends ProgressDialog {

    /* renamed from: a  reason: collision with root package name */
    public Context f6076a;

    public o0(Context context) {
        super(context);
        this.f6076a = context;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(View.inflate(getContext(), R.layout.customprogressdialog, null));
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }

    public o0(Context context, int i4) {
        super(context, i4);
        this.f6076a = context;
    }
}
