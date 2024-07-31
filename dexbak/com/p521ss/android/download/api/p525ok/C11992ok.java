package com.p521ss.android.download.api.p525ok;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.p521ss.android.download.api.config.InterfaceC11958j;
import com.p521ss.android.download.api.download.DownloadModel;
import com.p521ss.android.download.api.model.C11980a;

/* renamed from: com.ss.android.download.api.ok.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C11992ok implements InterfaceC11958j {
    @Override // com.p521ss.android.download.api.config.InterfaceC11958j
    /* renamed from: a */
    public Dialog mo19529a(@NonNull C11980a c11980a) {
        return m19527ok(c11980a);
    }

    @Override // com.p521ss.android.download.api.config.InterfaceC11958j
    /* renamed from: ok */
    public void mo19528ok(int i, @Nullable Context context, DownloadModel downloadModel, String str, Drawable drawable, int i2) {
        Toast.makeText(context, str, 0).show();
    }

    /* renamed from: ok */
    private static Dialog m19527ok(final C11980a c11980a) {
        if (c11980a == null) {
            return null;
        }
        AlertDialog show = new AlertDialog.Builder(c11980a.f33859ok).setTitle(c11980a.f33853a).setMessage(c11980a.f33854bl).setPositiveButton(c11980a.f33862s, new DialogInterface.OnClickListener() { // from class: com.ss.android.download.api.ok.ok.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                C11980a.InterfaceC11982a interfaceC11982a = C11980a.this.f33860p;
                if (interfaceC11982a != null) {
                    interfaceC11982a.mo18860ok(dialogInterface);
                }
            }
        }).setNegativeButton(c11980a.f33858n, new DialogInterface.OnClickListener() { // from class: com.ss.android.download.api.ok.ok.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                C11980a.InterfaceC11982a interfaceC11982a = C11980a.this.f33860p;
                if (interfaceC11982a != null) {
                    interfaceC11982a.mo18862a(dialogInterface);
                }
            }
        }).show();
        show.setCanceledOnTouchOutside(c11980a.f33857kf);
        show.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.download.api.ok.ok.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                C11980a.InterfaceC11982a interfaceC11982a = C11980a.this.f33860p;
                if (interfaceC11982a != null) {
                    interfaceC11982a.mo18861bl(dialogInterface);
                }
            }
        });
        Drawable drawable = c11980a.f33855h;
        if (drawable != null) {
            show.setIcon(drawable);
        }
        return show;
    }
}
