package com.bytedance.sdk.openadsdk.core.p;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.eq.f;
import com.bytedance.sdk.openadsdk.core.widget.k;
import com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder;
import com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener;
import java.lang.ref.WeakReference;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class c implements DialogInterface {
        private c() {
        }

        @Override // android.content.DialogInterface
        public void cancel() {
        }

        @Override // android.content.DialogInterface
        public void dismiss() {
        }
    }

    private static AlertDialog c(Activity activity, final DialogBuilder dialogBuilder) {
        return new k(activity).c(dialogBuilder.title).w(dialogBuilder.message).xv(dialogBuilder.positiveBtnText).sr(dialogBuilder.negativeBtnText).c(dialogBuilder.icon).c(new k.c() { // from class: com.bytedance.sdk.openadsdk.core.p.f.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.k.c
            public void c(Dialog dialog) {
                IDialogStatusChangedListener iDialogStatusChangedListener = DialogBuilder.this.dialogStatusChangedListener;
                if (iDialogStatusChangedListener != null) {
                    iDialogStatusChangedListener.onPositiveBtnClick(dialog);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.k.c
            public void w(Dialog dialog) {
                IDialogStatusChangedListener iDialogStatusChangedListener = DialogBuilder.this.dialogStatusChangedListener;
                if (iDialogStatusChangedListener != null) {
                    iDialogStatusChangedListener.onNegativeBtnClick(dialog);
                }
            }
        }).c(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.p.f.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                IDialogStatusChangedListener iDialogStatusChangedListener = DialogBuilder.this.dialogStatusChangedListener;
                if (iDialogStatusChangedListener != null) {
                    iDialogStatusChangedListener.onCancel(dialogInterface);
                }
            }
        });
    }

    public static void c(WeakReference<Context> weakReference, boolean z3, final DialogBuilder dialogBuilder) {
        f.c cVar = new f.c() { // from class: com.bytedance.sdk.openadsdk.core.p.f.3
            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void c() {
                IDialogStatusChangedListener iDialogStatusChangedListener = DialogBuilder.this.dialogStatusChangedListener;
                if (iDialogStatusChangedListener != null) {
                    iDialogStatusChangedListener.onPositiveBtnClick(new c());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void w() {
                IDialogStatusChangedListener iDialogStatusChangedListener = DialogBuilder.this.dialogStatusChangedListener;
                if (iDialogStatusChangedListener != null) {
                    iDialogStatusChangedListener.onNegativeBtnClick(new c());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void xv() {
                IDialogStatusChangedListener iDialogStatusChangedListener = DialogBuilder.this.dialogStatusChangedListener;
                if (iDialogStatusChangedListener != null) {
                    iDialogStatusChangedListener.onCancel(new c());
                }
            }
        };
        if (z3) {
            com.bytedance.sdk.openadsdk.core.eq.f.c(weakReference.get(), String.valueOf(dialogBuilder.hashCode()), dialogBuilder.title, dialogBuilder.message, dialogBuilder.positiveBtnText, dialogBuilder.negativeBtnText, cVar);
        } else {
            com.bytedance.sdk.openadsdk.core.eq.f.c(weakReference.get(), String.valueOf(dialogBuilder.hashCode()), dialogBuilder.title, dialogBuilder.message, cVar);
        }
    }

    public static AlertDialog c(Activity activity, boolean z3, DialogBuilder dialogBuilder) {
        if (z3) {
            AlertDialog c4 = c(activity, dialogBuilder);
            if (activity != null && !activity.isFinishing()) {
                c4.show();
            }
            return c4;
        }
        return c(activity, i.ux(activity, Build.VERSION.SDK_INT >= 21 ? "Theme.Dialog.TTDownload" : "Theme.Dialog.TTDownloadOld"), dialogBuilder);
    }

    private static AlertDialog c(Activity activity, int i4, final DialogBuilder dialogBuilder) {
        AlertDialog.Builder onCancelListener = new AlertDialog.Builder(activity, i4).setTitle(dialogBuilder.title).setMessage(dialogBuilder.message).setPositiveButton(dialogBuilder.positiveBtnText, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.p.f.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i5) {
                IDialogStatusChangedListener iDialogStatusChangedListener = DialogBuilder.this.dialogStatusChangedListener;
                if (iDialogStatusChangedListener != null) {
                    iDialogStatusChangedListener.onPositiveBtnClick(dialogInterface);
                }
            }
        }).setNegativeButton(dialogBuilder.negativeBtnText, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.p.f.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i5) {
                IDialogStatusChangedListener iDialogStatusChangedListener = DialogBuilder.this.dialogStatusChangedListener;
                if (iDialogStatusChangedListener != null) {
                    iDialogStatusChangedListener.onNegativeBtnClick(dialogInterface);
                }
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.p.f.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                IDialogStatusChangedListener iDialogStatusChangedListener = DialogBuilder.this.dialogStatusChangedListener;
                if (iDialogStatusChangedListener != null) {
                    iDialogStatusChangedListener.onCancel(dialogInterface);
                }
            }
        });
        Drawable drawable = dialogBuilder.icon;
        if (drawable != null) {
            onCancelListener.setIcon(drawable);
        }
        AlertDialog create = onCancelListener.create();
        if (activity != null && !activity.isFinishing()) {
            create.show();
        }
        return create;
    }
}
