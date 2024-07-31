package com.kwad.components.p208ad.widget.tailframe.appbar;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.components.ad.widget.tailframe.appbar.TailFrameBarAppPortraitVertical */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class TailFrameBarAppPortraitVertical extends AbstractC8522a {
    public TailFrameBarAppPortraitVertical(Context context) {
        this(context, null);
    }

    @Override // com.kwad.components.p208ad.widget.tailframe.appbar.AbstractC8522a
    /* renamed from: b */
    public final void mo30422b(@NonNull AdTemplate adTemplate) {
        if (C10487e.m25654F(adTemplate)) {
            this.f28031Hh.setBackgroundColor(ContextCompat.getColor(getContext(), C9659R.C9660color.ksad_translucent));
            this.f28036kU.setTextColor(Color.parseColor("#FFFFFF"));
            this.f28032Ir.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            this.f28031Hh.setBackgroundColor(Color.parseColor("#E6FFFFFF"));
        }
        super.mo30422b(adTemplate);
    }

    @Override // com.kwad.components.p208ad.widget.tailframe.appbar.AbstractC8522a
    public int getLayoutId() {
        return C9659R.C9663layout.ksad_video_tf_bar_app_portrait_vertical;
    }

    public TailFrameBarAppPortraitVertical(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarAppPortraitVertical(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
