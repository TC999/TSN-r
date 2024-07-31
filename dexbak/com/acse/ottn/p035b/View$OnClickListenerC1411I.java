package com.acse.ottn.p035b;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.b.I */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1411I implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AcseHelpManager.OnClickCallBack f2526a;

    /* renamed from: b */
    final /* synthetic */ Activity f2527b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1411I(AcseHelpManager.OnClickCallBack onClickCallBack, Activity activity) {
        this.f2526a = onClickCallBack;
        this.f2527b = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        AlertDialog alertDialog;
        textView = C1414L.f2536e;
        if (textView.getVisibility() == 0) {
            AcseHelpManager.OnClickCallBack onClickCallBack = this.f2526a;
            if (onClickCallBack != null) {
                onClickCallBack.onDismiss();
            }
        } else {
            AcseHelpManager.OnClickCallBack onClickCallBack2 = this.f2526a;
            if (onClickCallBack2 != null) {
                onClickCallBack2.onOpen();
            }
        }
        Activity activity = this.f2527b;
        alertDialog = C1414L.f2532a;
        C1414L.m56840a(activity, alertDialog);
    }
}
