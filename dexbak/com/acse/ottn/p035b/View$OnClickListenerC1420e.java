package com.acse.ottn.p035b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.util.C1703va;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.b.e */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1420e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Activity f2550a;

    /* renamed from: b */
    final /* synthetic */ String f2551b;

    /* renamed from: c */
    final /* synthetic */ String f2552c;

    /* renamed from: d */
    final /* synthetic */ AcseHelpManager.OnClickCallBack f2553d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1420e(Activity activity, String str, String str2, AcseHelpManager.OnClickCallBack onClickCallBack) {
        this.f2550a = activity;
        this.f2551b = str;
        this.f2552c = str2;
        this.f2553d = onClickCallBack;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        Activity activity = this.f2550a;
        alertDialog = C1423h.f2562a;
        C1423h.m56829a(activity, alertDialog);
        C1703va m55903a = C1703va.m55903a();
        m55903a.m55901a(this.f2551b + "_" + this.f2552c + "_close");
        AcseHelpManager.OnClickCallBack onClickCallBack = this.f2553d;
        if (onClickCallBack != null) {
            onClickCallBack.onDismiss();
        }
    }
}
