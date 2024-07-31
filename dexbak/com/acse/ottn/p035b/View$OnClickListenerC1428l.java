package com.acse.ottn.p035b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.util.C1703va;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.b.l */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1428l implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f2573a;

    /* renamed from: b */
    final /* synthetic */ Activity f2574b;

    /* renamed from: c */
    final /* synthetic */ AcseHelpManager.OnClickCallBack f2575c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1428l(boolean z, Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
        this.f2573a = z;
        this.f2574b = activity;
        this.f2575c = onClickCallBack;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        if (this.f2573a) {
            try {
                alertDialog = C1431o.f2580a;
                alertDialog.dismiss();
            } catch (Exception unused) {
            }
            C1414L.m56839a(this.f2574b, this.f2575c);
            return;
        }
        C1703va.m55903a().m55901a("not_now");
        AcseHelpManager.OnClickCallBack onClickCallBack = this.f2575c;
        if (onClickCallBack != null) {
            onClickCallBack.onDismiss();
        }
        try {
            alertDialog2 = C1431o.f2580a;
            alertDialog2.dismiss();
        } catch (Exception unused2) {
        }
    }
}
