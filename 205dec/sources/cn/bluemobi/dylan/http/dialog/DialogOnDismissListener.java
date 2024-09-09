package cn.bluemobi.dylan.http.dialog;

import android.content.DialogInterface;
import rx.m;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class DialogOnDismissListener implements DialogInterface.OnDismissListener {
    private m subscribe;

    public DialogOnDismissListener(m mVar) {
        this.subscribe = mVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        m mVar = this.subscribe;
        if (mVar == null || mVar.isUnsubscribed()) {
            return;
        }
        this.subscribe.unsubscribe();
    }
}
