package com.bytedance.android.openliveplugin;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.C6266R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class LiveLoadingDialog {
    private static Dialog loadingDialog;

    public static boolean dismiss() {
        Dialog dialog = loadingDialog;
        if (dialog == null || !dialog.isShowing()) {
            return false;
        }
        loadingDialog.dismiss();
        return true;
    }

    public static void show(Activity activity) {
        if (activity == null) {
            return;
        }
        Dialog dialog = loadingDialog;
        if (dialog != null) {
            if (dialog.isShowing()) {
                return;
            }
            loadingDialog.show();
            return;
        }
        float f = activity.getResources().getDisplayMetrics().density;
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setCancelable(true);
        View inflate = activity.getLayoutInflater().inflate(C6266R.C6270layout.live_init_progress_dialog, (ViewGroup) null);
        inflate.findViewById(C6266R.C6269id.live_progress_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.android.openliveplugin.LiveLoadingDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveLoadingDialog.loadingDialog.dismiss();
            }
        });
        builder.setView(inflate);
        AlertDialog create = builder.create();
        loadingDialog = create;
        if (create.getWindow() != null) {
            loadingDialog.getWindow().setBackgroundDrawableResource(17170445);
            loadingDialog.getWindow().setDimAmount(0.0f);
            loadingDialog.show();
            loadingDialog.getWindow().setLayout(Math.round(92.0f * f), Math.round(f * 80.0f));
        }
    }
}
