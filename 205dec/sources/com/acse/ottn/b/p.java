package com.acse.ottn.b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class p implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f5145a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AcseHelpManager.OnClickCallBack f5146b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
        this.f5145a = activity;
        this.f5146b = onClickCallBack;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        Activity activity = this.f5145a;
        alertDialog = s.f5151a;
        s.a(activity, alertDialog);
        AcseHelpManager.startAccessibilityIntroduceActivityForResult(this.f5145a, 10010);
        this.f5146b.onOpen();
    }
}
