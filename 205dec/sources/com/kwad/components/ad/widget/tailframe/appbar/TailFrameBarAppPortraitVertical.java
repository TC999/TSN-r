package com.kwad.components.ad.widget.tailframe.appbar;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class TailFrameBarAppPortraitVertical extends a {
    public TailFrameBarAppPortraitVertical(Context context) {
        this(context, null);
    }

    @Override // com.kwad.components.ad.widget.tailframe.appbar.a
    public final void b(@NonNull AdTemplate adTemplate) {
        if (e.F(adTemplate)) {
            this.Hh.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ksad_translucent));
            this.kU.setTextColor(Color.parseColor("#FFFFFF"));
            this.Ir.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            this.Hh.setBackgroundColor(Color.parseColor("#E6FFFFFF"));
        }
        super.b(adTemplate);
    }

    @Override // com.kwad.components.ad.widget.tailframe.appbar.a
    public int getLayoutId() {
        return R.layout.ksad_video_tf_bar_app_portrait_vertical;
    }

    public TailFrameBarAppPortraitVertical(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarAppPortraitVertical(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }
}
