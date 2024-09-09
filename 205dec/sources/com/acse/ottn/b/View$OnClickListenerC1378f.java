package com.acse.ottn.b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.util.va;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.b.f  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class View$OnClickListenerC1378f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f5111a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f5112b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f5113c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ AcseHelpManager.OnClickCallBack f5114d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1378f(Activity activity, String str, String str2, AcseHelpManager.OnClickCallBack onClickCallBack) {
        this.f5111a = activity;
        this.f5112b = str;
        this.f5113c = str2;
        this.f5114d = onClickCallBack;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        Activity activity = this.f5111a;
        alertDialog = C1380h.f5122a;
        C1380h.a(activity, alertDialog);
        va a4 = va.a();
        a4.a(this.f5112b + "_" + this.f5113c + "_open");
        AcseHelpManager.OnClickCallBack onClickCallBack = this.f5114d;
        if (onClickCallBack != null) {
            onClickCallBack.onOpen();
        }
    }
}
