package com.ss.android.download.api.ok;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.j;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.a;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ok implements j {
    @Override // com.ss.android.download.api.config.j
    public Dialog a(@NonNull com.ss.android.download.api.model.a aVar) {
        return ok(aVar);
    }

    @Override // com.ss.android.download.api.config.j
    public void ok(int i4, @Nullable Context context, DownloadModel downloadModel, String str, Drawable drawable, int i5) {
        Toast.makeText(context, str, 0).show();
    }

    private static Dialog ok(final com.ss.android.download.api.model.a aVar) {
        if (aVar == null) {
            return null;
        }
        AlertDialog show = new AlertDialog.Builder(aVar.ok).setTitle(aVar.f48201a).setMessage(aVar.bl).setPositiveButton(aVar.f48207s, new DialogInterface.OnClickListener() { // from class: com.ss.android.download.api.ok.ok.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                a.InterfaceC0935a interfaceC0935a = com.ss.android.download.api.model.a.this.f48205p;
                if (interfaceC0935a != null) {
                    interfaceC0935a.ok(dialogInterface);
                }
            }
        }).setNegativeButton(aVar.f48204n, new DialogInterface.OnClickListener() { // from class: com.ss.android.download.api.ok.ok.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                a.InterfaceC0935a interfaceC0935a = com.ss.android.download.api.model.a.this.f48205p;
                if (interfaceC0935a != null) {
                    interfaceC0935a.a(dialogInterface);
                }
            }
        }).show();
        show.setCanceledOnTouchOutside(aVar.kf);
        show.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.download.api.ok.ok.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                a.InterfaceC0935a interfaceC0935a = com.ss.android.download.api.model.a.this.f48205p;
                if (interfaceC0935a != null) {
                    interfaceC0935a.bl(dialogInterface);
                }
            }
        });
        Drawable drawable = aVar.f48202h;
        if (drawable != null) {
            show.setIcon(drawable);
        }
        return show;
    }
}
