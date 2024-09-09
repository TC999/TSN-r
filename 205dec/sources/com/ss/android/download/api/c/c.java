package com.ss.android.download.api.c;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.a;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.w;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class c implements a {
    @Override // com.ss.android.download.api.config.a
    public void c(int i4, @Nullable Context context, DownloadModel downloadModel, String str, Drawable drawable, int i5) {
        Toast.makeText(context, str, 0).show();
    }

    @Override // com.ss.android.download.api.config.a
    public Dialog w(@NonNull com.ss.android.download.api.model.w wVar) {
        return c(wVar);
    }

    private static Dialog c(final com.ss.android.download.api.model.w wVar) {
        if (wVar == null) {
            return null;
        }
        AlertDialog show = new AlertDialog.Builder(wVar.f48256c).setTitle(wVar.f48260w).setMessage(wVar.xv).setPositiveButton(wVar.sr, new DialogInterface.OnClickListener() { // from class: com.ss.android.download.api.c.c.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                w.InterfaceC0938w interfaceC0938w = com.ss.android.download.api.model.w.this.ev;
                if (interfaceC0938w != null) {
                    interfaceC0938w.c(dialogInterface);
                }
            }
        }).setNegativeButton(wVar.ux, new DialogInterface.OnClickListener() { // from class: com.ss.android.download.api.c.c.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                w.InterfaceC0938w interfaceC0938w = com.ss.android.download.api.model.w.this.ev;
                if (interfaceC0938w != null) {
                    interfaceC0938w.w(dialogInterface);
                }
            }
        }).show();
        show.setCanceledOnTouchOutside(wVar.f48257f);
        show.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.download.api.c.c.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                w.InterfaceC0938w interfaceC0938w = com.ss.android.download.api.model.w.this.ev;
                if (interfaceC0938w != null) {
                    interfaceC0938w.xv(dialogInterface);
                }
            }
        });
        Drawable drawable = wVar.f48259r;
        if (drawable != null) {
            show.setIcon(drawable);
        }
        return show;
    }
}
