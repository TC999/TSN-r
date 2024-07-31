package com.acse.ottn.widget;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.acse.ottn.C1239R;

/* renamed from: com.acse.ottn.widget.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ProgressDialogC1716b extends ProgressDialog {

    /* renamed from: a */
    private Context f3418a;

    public ProgressDialogC1716b(Context context) {
        super(context);
        this.f3418a = context;
    }

    public ProgressDialogC1716b(Context context, int i) {
        super(context, i);
        this.f3418a = context;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(View.inflate(getContext(), C1239R.C1244layout.customprogressdialog, null));
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }
}
