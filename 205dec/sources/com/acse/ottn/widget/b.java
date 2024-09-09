package com.acse.ottn.widget;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.acse.ottn.R;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class b extends ProgressDialog {

    /* renamed from: a  reason: collision with root package name */
    private Context f6965a;

    public b(Context context) {
        super(context);
        this.f6965a = context;
    }

    public b(Context context, int i4) {
        super(context, i4);
        this.f6965a = context;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(View.inflate(getContext(), R.layout.customprogressdialog, null));
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }
}
