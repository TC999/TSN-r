package com.acse.ottn.p035b;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.acse.ottn.activity.SeedWebViewActivity;
import com.acse.ottn.util.C1633I;

/* renamed from: com.acse.ottn.b.G */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class View$OnClickListenerC1408G implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Activity f2524a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1408G(Activity activity) {
        this.f2524a = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f2524a, SeedWebViewActivity.class);
        intent.putExtra("url", C1633I.m56254a().m56240d(this.f2524a));
        this.f2524a.startActivity(intent);
    }
}
