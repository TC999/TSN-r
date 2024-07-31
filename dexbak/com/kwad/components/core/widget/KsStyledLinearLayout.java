package com.kwad.components.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.components.core.p330s.C8946i;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class KsStyledLinearLayout extends LinearLayout implements InterfaceC9373d {
    public KsStyledLinearLayout(Context context) {
        super(context);
    }

    @Override // com.kwad.components.core.widget.InterfaceC9373d
    /* renamed from: a */
    public final void mo28874a(C9374e c9374e) {
        C8946i.m29550b(c9374e, getBackground());
    }

    public KsStyledLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsStyledLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public KsStyledLinearLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
