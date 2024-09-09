package com.acse.ottn.b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class r implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f5149a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AcseHelpManager.OnClickCallBack f5150b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
        this.f5149a = activity;
        this.f5150b = onClickCallBack;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        Activity activity = this.f5149a;
        alertDialog = s.f5151a;
        s.a(activity, alertDialog);
        AcseHelpManager.startAccessibilityIntroduceActivityForResult(this.f5149a, 10010);
        this.f5150b.onOpen();
    }
}
