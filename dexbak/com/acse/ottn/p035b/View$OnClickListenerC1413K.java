package com.acse.ottn.p035b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.b.K */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1413K implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AcseHelpManager.OnClickCallBack f2530a;

    /* renamed from: b */
    final /* synthetic */ Activity f2531b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1413K(AcseHelpManager.OnClickCallBack onClickCallBack, Activity activity) {
        this.f2530a = onClickCallBack;
        this.f2531b = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        AcseHelpManager.OnClickCallBack onClickCallBack = this.f2530a;
        if (onClickCallBack != null) {
            onClickCallBack.onClose();
        }
        Activity activity = this.f2531b;
        alertDialog = C1414L.f2532a;
        C1414L.m56840a(activity, alertDialog);
    }
}
