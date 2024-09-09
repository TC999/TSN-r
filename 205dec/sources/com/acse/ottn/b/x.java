package com.acse.ottn.b;

import android.app.Activity;
import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import com.acse.ottn.activity.SeedWebViewActivity;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class x extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f5160a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(Activity activity) {
        this.f5160a = activity;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(@NonNull View view) {
        Intent intent = new Intent(this.f5160a, SeedWebViewActivity.class);
        intent.putExtra("url", com.acse.ottn.util.I.a().c(this.f5160a));
        this.f5160a.startActivity(intent);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NonNull TextPaint textPaint) {
        com.acse.ottn.util.I.a().a(this.f5160a, textPaint);
    }
}
