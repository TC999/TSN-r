package com.mbridge.msdk.mbjscommon.confirmation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.widget.custom.DownloadMessageDialog;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class CloseDialogBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private DownloadMessageDialog f31441a;

    public CloseDialogBroadcastReceiver(DownloadMessageDialog downloadMessageDialog) {
        this.f31441a = downloadMessageDialog;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (TextUtils.isEmpty(action) || !TextUtils.equals(action, "mb_dp_close_broadcast_receiver")) {
                return;
            }
            DownloadMessageDialog downloadMessageDialog = this.f31441a;
            try {
                if (downloadMessageDialog != null) {
                    try {
                        try {
                            if (downloadMessageDialog.isShowing()) {
                                this.f31441a.setRenderListener(null);
                                this.f31441a.cancel();
                                this.f31441a = null;
                            }
                        } catch (Exception e) {
                            SameLogTool.m21738a("CloseDialogBroadcastReceiver", e.getMessage());
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
                            } catch (Exception e2) {
                                SameLogTool.m21738a("CloseDialogBroadcastReceiver", e2.getMessage());
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e3) {
                SameLogTool.m21738a("CloseDialogBroadcastReceiver", e3.getMessage());
            }
        }
    }
}
