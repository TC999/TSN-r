package com.acse.ottn.b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.util.va;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class J implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AcseHelpManager.OnClickCallBack f5079a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Activity f5080b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public J(AcseHelpManager.OnClickCallBack onClickCallBack, Activity activity) {
        this.f5079a = onClickCallBack;
        this.f5080b = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        va.a().a("warning_start_run");
        AcseHelpManager.OnClickCallBack onClickCallBack = this.f5079a;
        if (onClickCallBack != null) {
            onClickCallBack.onOpen();
        }
        Activity activity = this.f5080b;
        alertDialog = L.f5083a;
        L.a(activity, alertDialog);
    }
}
