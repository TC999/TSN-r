package com.acse.ottn.b;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.acse.ottn.activity.SeedWebViewActivity;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class F implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f5074a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public F(Activity activity) {
        this.f5074a = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f5074a, SeedWebViewActivity.class);
        intent.putExtra("url", com.acse.ottn.util.I.a().b(this.f5074a));
        this.f5074a.startActivity(intent);
    }
}
