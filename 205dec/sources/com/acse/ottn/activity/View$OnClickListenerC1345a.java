package com.acse.ottn.activity;

import android.content.Intent;
import android.view.View;

/* renamed from: com.acse.ottn.activity.a  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class View$OnClickListenerC1345a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibiltyTsnPermissionGreenActivity f4734a;

    View$OnClickListenerC1345a(AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity) {
        this.f4734a = accessibiltyTsnPermissionGreenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f4734a, SeedWebViewActivity.class);
        intent.putExtra("url", com.acse.ottn.util.I.a().b(this.f4734a));
        this.f4734a.startActivity(intent);
    }
}
