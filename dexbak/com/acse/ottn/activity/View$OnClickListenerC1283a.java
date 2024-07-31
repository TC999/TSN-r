package com.acse.ottn.activity;

import android.content.Intent;
import android.view.View;
import com.acse.ottn.util.C1633I;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.activity.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1283a implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AccessibiltyTsnPermissionGreenActivity f2183a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1283a(AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity) {
        this.f2183a = accessibiltyTsnPermissionGreenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f2183a, SeedWebViewActivity.class);
        intent.putExtra("url", C1633I.m56254a().m56246b(this.f2183a));
        this.f2183a.startActivity(intent);
    }
}
