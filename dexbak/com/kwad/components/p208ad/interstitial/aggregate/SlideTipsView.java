package com.kwad.components.p208ad.interstitial.aggregate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.p445n.C10887l;

/* renamed from: com.kwad.components.ad.interstitial.aggregate.SlideTipsView */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class SlideTipsView extends FrameLayout {
    public SlideTipsView(@NonNull Context context) {
        this(context, null);
    }

    public SlideTipsView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"CustomViewStyleable"})
    public SlideTipsView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C9659R.styleable.ksad_SlideTipsView, i, 0);
        boolean z = obtainStyledAttributes.getBoolean(C9659R.styleable.ksad_SlideTipsView_ksad_is_left_slide, true);
        obtainStyledAttributes.recycle();
        C10887l.inflate(context, z ? C9659R.C9663layout.ksad_interstitial_left_slide_to_next : C9659R.C9663layout.ksad_interstitial_right_slide_to_return, this);
    }
}
