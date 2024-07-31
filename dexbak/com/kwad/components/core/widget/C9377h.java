package com.kwad.components.core.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;

@RequiresApi(api = 21)
/* renamed from: com.kwad.components.core.widget.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9377h extends ViewOutlineProvider {
    private float act;

    private C9377h(float f) {
        this.act = f;
    }

    @RequiresApi(api = 21)
    /* renamed from: b */
    public static void m28870b(View view, float f) {
        if (f <= 0.0f) {
            view.setOutlineProvider(null);
            view.setClipToOutline(false);
            return;
        }
        view.setOutlineProvider(new C9377h(f));
        view.setClipToOutline(true);
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.act);
    }
}
