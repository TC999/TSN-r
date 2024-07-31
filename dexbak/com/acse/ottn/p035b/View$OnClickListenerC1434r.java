package com.acse.ottn.p035b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;

/* renamed from: com.acse.ottn.b.r */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class View$OnClickListenerC1434r implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Activity f2589a;

    /* renamed from: b */
    final /* synthetic */ AcseHelpManager.OnClickCallBack f2590b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1434r(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
        this.f2589a = activity;
        this.f2590b = onClickCallBack;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        Activity activity = this.f2589a;
        alertDialog = C1435s.f2591a;
        C1435s.m56812a(activity, alertDialog);
        AcseHelpManager.startAccessibilityIntroduceActivityForResult(this.f2589a, 10010);
        this.f2590b.onOpen();
    }
}
