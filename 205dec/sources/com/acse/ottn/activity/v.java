package com.acse.ottn.activity;

import android.content.Intent;
import android.view.View;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibiltyTsnPermissionGreenActivity f4756a;

    v(AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity) {
        this.f4756a = accessibiltyTsnPermissionGreenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f4756a, SeedWebViewActivity.class);
        intent.putExtra("url", com.acse.ottn.util.I.a().d(this.f4756a));
        this.f4756a.startActivity(intent);
    }
}
