package com.acse.ottn.b;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class I implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AcseHelpManager.OnClickCallBack f5077a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Activity f5078b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public I(AcseHelpManager.OnClickCallBack onClickCallBack, Activity activity) {
        this.f5077a = onClickCallBack;
        this.f5078b = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        AlertDialog alertDialog;
        textView = L.f5087e;
        if (textView.getVisibility() == 0) {
            AcseHelpManager.OnClickCallBack onClickCallBack = this.f5077a;
            if (onClickCallBack != null) {
                onClickCallBack.onDismiss();
            }
        } else {
            AcseHelpManager.OnClickCallBack onClickCallBack2 = this.f5077a;
            if (onClickCallBack2 != null) {
                onClickCallBack2.onOpen();
            }
        }
        Activity activity = this.f5078b;
        alertDialog = L.f5083a;
        L.a(activity, alertDialog);
    }
}
