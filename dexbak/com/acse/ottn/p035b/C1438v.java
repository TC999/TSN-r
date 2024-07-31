package com.acse.ottn.p035b;

import android.app.Activity;
import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import com.acse.ottn.activity.SeedWebViewActivity;
import com.acse.ottn.util.C1633I;

/* renamed from: com.acse.ottn.b.v */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1438v extends ClickableSpan {

    /* renamed from: a */
    final /* synthetic */ Activity f2598a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1438v(Activity activity) {
        this.f2598a = activity;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(@NonNull View view) {
        Intent intent = new Intent(this.f2598a, SeedWebViewActivity.class);
        intent.putExtra("url", C1633I.m56254a().m56240d(this.f2598a));
        this.f2598a.startActivity(intent);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NonNull TextPaint textPaint) {
        C1633I.m56254a().m56252a(this.f2598a, textPaint);
    }
}
