package cn.bluemobi.dylan.http.dialog;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class DialogOnKeyListener implements DialogInterface.OnKeyListener {
    private boolean canCancel;
    private LoadingDialog dialog;

    public DialogOnKeyListener(LoadingDialog loadingDialog, boolean z) {
        this.dialog = loadingDialog;
        this.canCancel = z;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        LoadingDialog loadingDialog;
        if (i == 4) {
            if (this.canCancel && (loadingDialog = this.dialog) != null && loadingDialog.isShowing()) {
                this.dialog.dismiss();
                return true;
            }
            return true;
        }
        return false;
    }
}
