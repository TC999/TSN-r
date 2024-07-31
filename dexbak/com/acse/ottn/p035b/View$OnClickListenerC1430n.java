package com.acse.ottn.p035b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.b.n */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1430n implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AcseHelpManager.OnClickCallBack f2578a;

    /* renamed from: b */
    final /* synthetic */ Activity f2579b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1430n(AcseHelpManager.OnClickCallBack onClickCallBack, Activity activity) {
        this.f2578a = onClickCallBack;
        this.f2579b = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        AcseHelpManager.OnClickCallBack onClickCallBack = this.f2578a;
        if (onClickCallBack != null) {
            onClickCallBack.onOpen();
        }
        Activity activity = this.f2579b;
        alertDialog = C1431o.f2580a;
        C1431o.m56819a(activity, alertDialog);
    }
}
