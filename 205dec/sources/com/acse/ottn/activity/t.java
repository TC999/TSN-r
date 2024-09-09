package com.acse.ottn.activity;

import android.view.View;
import androidx.annotation.RequiresApi;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class t implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibiltyTsnPermissionGreenActivity f4754a;

    t(AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity) {
        this.f4754a = accessibiltyTsnPermissionGreenActivity;
    }

    @Override // android.view.View.OnClickListener
    @RequiresApi(api = 23)
    public void onClick(View view) {
        this.f4754a.l();
    }
}
