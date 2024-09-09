package com.acse.ottn.b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.util.va;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class m implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AcseHelpManager.OnClickCallBack f5136a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Activity f5137b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(AcseHelpManager.OnClickCallBack onClickCallBack, Activity activity) {
        this.f5136a = onClickCallBack;
        this.f5137b = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        va.a().a("not_now");
        AcseHelpManager.OnClickCallBack onClickCallBack = this.f5136a;
        if (onClickCallBack != null) {
            onClickCallBack.onClose();
        }
        Activity activity = this.f5137b;
        alertDialog = o.f5140a;
        o.a(activity, alertDialog);
    }
}
