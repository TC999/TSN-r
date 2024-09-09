package com.acse.ottn.b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class n implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AcseHelpManager.OnClickCallBack f5138a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Activity f5139b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(AcseHelpManager.OnClickCallBack onClickCallBack, Activity activity) {
        this.f5138a = onClickCallBack;
        this.f5139b = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        AcseHelpManager.OnClickCallBack onClickCallBack = this.f5138a;
        if (onClickCallBack != null) {
            onClickCallBack.onOpen();
        }
        Activity activity = this.f5139b;
        alertDialog = o.f5140a;
        o.a(activity, alertDialog);
    }
}
