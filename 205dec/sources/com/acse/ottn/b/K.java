package com.acse.ottn.b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class K implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AcseHelpManager.OnClickCallBack f5081a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Activity f5082b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public K(AcseHelpManager.OnClickCallBack onClickCallBack, Activity activity) {
        this.f5081a = onClickCallBack;
        this.f5082b = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        AcseHelpManager.OnClickCallBack onClickCallBack = this.f5081a;
        if (onClickCallBack != null) {
            onClickCallBack.onClose();
        }
        Activity activity = this.f5082b;
        alertDialog = L.f5083a;
        L.a(activity, alertDialog);
    }
}
