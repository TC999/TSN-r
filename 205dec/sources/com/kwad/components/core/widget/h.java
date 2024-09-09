package com.kwad.components.core.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@RequiresApi(api = 21)
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class h extends ViewOutlineProvider {
    private float act;

    private h(float f4) {
        this.act = f4;
    }

    @RequiresApi(api = 21)
    public static void b(View view, float f4) {
        if (f4 <= 0.0f) {
            view.setOutlineProvider(null);
            view.setClipToOutline(false);
            return;
        }
        view.setOutlineProvider(new h(f4));
        view.setClipToOutline(true);
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.act);
    }
}
