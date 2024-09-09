package com.acse.ottn.b;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.acse.ottn.activity.SeedWebViewActivity;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class G implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f5075a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public G(Activity activity) {
        this.f5075a = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f5075a, SeedWebViewActivity.class);
        intent.putExtra("url", com.acse.ottn.util.I.a().d(this.f5075a));
        this.f5075a.startActivity(intent);
    }
}
