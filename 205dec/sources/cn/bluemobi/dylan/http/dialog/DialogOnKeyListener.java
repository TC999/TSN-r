package cn.bluemobi.dylan.http.dialog;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class DialogOnKeyListener implements DialogInterface.OnKeyListener {
    private boolean canCancel;
    private LoadingDialog dialog;

    public DialogOnKeyListener(LoadingDialog loadingDialog, boolean z3) {
        this.dialog = loadingDialog;
        this.canCancel = z3;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i4, KeyEvent keyEvent) {
        LoadingDialog loadingDialog;
        if (i4 == 4) {
            if (this.canCancel && (loadingDialog = this.dialog) != null && loadingDialog.isShowing()) {
                this.dialog.dismiss();
                return true;
            }
            return true;
        }
        return false;
    }
}
