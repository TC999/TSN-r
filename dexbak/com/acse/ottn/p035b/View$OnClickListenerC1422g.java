package com.acse.ottn.p035b;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.util.C1703va;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.b.g */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1422g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f2558a;

    /* renamed from: b */
    final /* synthetic */ String f2559b;

    /* renamed from: c */
    final /* synthetic */ Activity f2560c;

    /* renamed from: d */
    final /* synthetic */ AcseHelpManager.OnClickCallBack f2561d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1422g(String str, String str2, Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
        this.f2558a = str;
        this.f2559b = str2;
        this.f2560c = activity;
        this.f2561d = onClickCallBack;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        C1703va m55903a = C1703va.m55903a();
        m55903a.m55901a(this.f2558a + "_" + this.f2559b + "_dismiss");
        Activity activity = this.f2560c;
        alertDialog = C1423h.f2562a;
        C1423h.m56829a(activity, alertDialog);
        AcseHelpManager.OnClickCallBack onClickCallBack = this.f2561d;
        if (onClickCallBack != null) {
            onClickCallBack.onClose();
        }
    }
}
