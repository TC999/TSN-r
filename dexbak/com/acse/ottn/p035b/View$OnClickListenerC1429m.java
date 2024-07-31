package com.acse.ottn.p035b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.util.C1703va;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.b.m */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1429m implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AcseHelpManager.OnClickCallBack f2576a;

    /* renamed from: b */
    final /* synthetic */ Activity f2577b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1429m(AcseHelpManager.OnClickCallBack onClickCallBack, Activity activity) {
        this.f2576a = onClickCallBack;
        this.f2577b = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        C1703va.m55903a().m55901a("not_now");
        AcseHelpManager.OnClickCallBack onClickCallBack = this.f2576a;
        if (onClickCallBack != null) {
            onClickCallBack.onClose();
        }
        Activity activity = this.f2577b;
        alertDialog = C1431o.f2580a;
        C1431o.m56819a(activity, alertDialog);
    }
}
