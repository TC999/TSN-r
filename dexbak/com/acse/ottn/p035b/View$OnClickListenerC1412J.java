package com.acse.ottn.p035b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.util.C1703va;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.b.J */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1412J implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AcseHelpManager.OnClickCallBack f2528a;

    /* renamed from: b */
    final /* synthetic */ Activity f2529b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1412J(AcseHelpManager.OnClickCallBack onClickCallBack, Activity activity) {
        this.f2528a = onClickCallBack;
        this.f2529b = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        C1703va.m55903a().m55901a("warning_start_run");
        AcseHelpManager.OnClickCallBack onClickCallBack = this.f2528a;
        if (onClickCallBack != null) {
            onClickCallBack.onOpen();
        }
        Activity activity = this.f2529b;
        alertDialog = C1414L.f2532a;
        C1414L.m56840a(activity, alertDialog);
    }
}
