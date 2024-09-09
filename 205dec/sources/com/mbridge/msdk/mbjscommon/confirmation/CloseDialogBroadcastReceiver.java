package com.mbridge.msdk.mbjscommon.confirmation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.widget.custom.DownloadMessageDialog;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class CloseDialogBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private DownloadMessageDialog f40213a;

    public CloseDialogBroadcastReceiver(DownloadMessageDialog downloadMessageDialog) {
        this.f40213a = downloadMessageDialog;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (TextUtils.isEmpty(action) || !TextUtils.equals(action, "mb_dp_close_broadcast_receiver")) {
                return;
            }
            DownloadMessageDialog downloadMessageDialog = this.f40213a;
            try {
                if (downloadMessageDialog != null) {
                    try {
                        try {
                            if (downloadMessageDialog.isShowing()) {
                                this.f40213a.setRenderListener(null);
                                this.f40213a.cancel();
                                this.f40213a = null;
                            }
                        } catch (Exception e4) {
                            x.a("CloseDialogBroadcastReceiver", e4.getMessage());
                            if (context == null) {
                                return;
                            }
                            context.unregisterReceiver(this);
                        }
                        if (context != null) {
                            context.unregisterReceiver(this);
                        }
                    } catch (Throwable th) {
                        if (context != null) {
                            try {
                                context.unregisterReceiver(this);
                            } catch (Exception e5) {
                                x.a("CloseDialogBroadcastReceiver", e5.getMessage());
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e6) {
                x.a("CloseDialogBroadcastReceiver", e6.getMessage());
            }
        }
    }
}
