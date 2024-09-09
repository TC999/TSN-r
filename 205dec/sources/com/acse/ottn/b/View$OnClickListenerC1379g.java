package com.acse.ottn.b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.util.va;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.b.g  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class View$OnClickListenerC1379g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f5117a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f5118b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Activity f5119c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ AcseHelpManager.OnClickCallBack f5120d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1379g(String str, String str2, Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
        this.f5117a = str;
        this.f5118b = str2;
        this.f5119c = activity;
        this.f5120d = onClickCallBack;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        va a4 = va.a();
        a4.a(this.f5117a + "_" + this.f5118b + "_dismiss");
        Activity activity = this.f5119c;
        alertDialog = C1380h.f5122a;
        C1380h.a(activity, alertDialog);
        AcseHelpManager.OnClickCallBack onClickCallBack = this.f5120d;
        if (onClickCallBack != null) {
            onClickCallBack.onClose();
        }
    }
}
