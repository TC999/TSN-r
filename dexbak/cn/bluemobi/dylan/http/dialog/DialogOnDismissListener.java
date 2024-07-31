package cn.bluemobi.dylan.http.dialog;

import android.content.DialogInterface;
import p640rx.Subscription;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class DialogOnDismissListener implements DialogInterface.OnDismissListener {
    private Subscription subscribe;

    public DialogOnDismissListener(Subscription subscription) {
        this.subscribe = subscription;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Subscription subscription = this.subscribe;
        if (subscription == null || subscription.isUnsubscribed()) {
            return;
        }
        this.subscribe.unsubscribe();
    }
}
