package com.acse.ottn.b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.util.va;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.b.l  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class View$OnClickListenerC1384l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f5133a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Activity f5134b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ AcseHelpManager.OnClickCallBack f5135c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1384l(boolean z3, Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
        this.f5133a = z3;
        this.f5134b = activity;
        this.f5135c = onClickCallBack;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        if (this.f5133a) {
            try {
                alertDialog = o.f5140a;
                alertDialog.dismiss();
            } catch (Exception unused) {
            }
            L.a(this.f5134b, this.f5135c);
            return;
        }
        va.a().a("not_now");
        AcseHelpManager.OnClickCallBack onClickCallBack = this.f5135c;
        if (onClickCallBack != null) {
            onClickCallBack.onDismiss();
        }
        try {
            alertDialog2 = o.f5140a;
            alertDialog2.dismiss();
        } catch (Exception unused2) {
        }
    }
}
