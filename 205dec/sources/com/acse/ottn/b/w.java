package com.acse.ottn.b;

import android.app.Activity;
import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import com.acse.ottn.activity.SeedWebViewActivity;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class w extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f5159a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(Activity activity) {
        this.f5159a = activity;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(@NonNull View view) {
        Intent intent = new Intent(this.f5159a, SeedWebViewActivity.class);
        intent.putExtra("url", com.acse.ottn.util.I.a().b(this.f5159a));
        this.f5159a.startActivity(intent);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NonNull TextPaint textPaint) {
        com.acse.ottn.util.I.a().a(this.f5159a, textPaint);
    }
}
