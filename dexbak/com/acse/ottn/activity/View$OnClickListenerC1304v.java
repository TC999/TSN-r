package com.acse.ottn.activity;

import android.content.Intent;
import android.view.View;
import com.acse.ottn.util.C1633I;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.activity.v */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1304v implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AccessibiltyTsnPermissionGreenActivity f2205a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1304v(AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity) {
        this.f2205a = accessibiltyTsnPermissionGreenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f2205a, SeedWebViewActivity.class);
        intent.putExtra("url", C1633I.m56254a().m56240d(this.f2205a));
        this.f2205a.startActivity(intent);
    }
}
