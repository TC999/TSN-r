package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.components.core.s.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class KsStyledTextButton extends TextView implements d {
    public KsStyledTextButton(Context context) {
        super(context);
    }

    @Override // com.kwad.components.core.widget.d
    public final void a(e eVar) {
        i.b(eVar, getBackground());
    }

    public KsStyledTextButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsStyledTextButton(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }

    @RequiresApi(api = 21)
    public KsStyledTextButton(Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
    }
}
