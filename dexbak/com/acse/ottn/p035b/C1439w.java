package com.acse.ottn.p035b;

import android.app.Activity;
import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import com.acse.ottn.activity.SeedWebViewActivity;
import com.acse.ottn.util.C1633I;

/* renamed from: com.acse.ottn.b.w */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1439w extends ClickableSpan {

    /* renamed from: a */
    final /* synthetic */ Activity f2599a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1439w(Activity activity) {
        this.f2599a = activity;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(@NonNull View view) {
        Intent intent = new Intent(this.f2599a, SeedWebViewActivity.class);
        intent.putExtra("url", C1633I.m56254a().m56246b(this.f2599a));
        this.f2599a.startActivity(intent);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NonNull TextPaint textPaint) {
        C1633I.m56254a().m56252a(this.f2599a, textPaint);
    }
}
