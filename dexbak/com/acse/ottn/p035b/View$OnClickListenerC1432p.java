package com.acse.ottn.p035b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;

/* renamed from: com.acse.ottn.b.p */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class View$OnClickListenerC1432p implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Activity f2585a;

    /* renamed from: b */
    final /* synthetic */ AcseHelpManager.OnClickCallBack f2586b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1432p(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
        this.f2585a = activity;
        this.f2586b = onClickCallBack;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        Activity activity = this.f2585a;
        alertDialog = C1435s.f2591a;
        C1435s.m56812a(activity, alertDialog);
        AcseHelpManager.startAccessibilityIntroduceActivityForResult(this.f2585a, 10010);
        this.f2586b.onOpen();
    }
}
