package com.kwad.components.core.page.widget;

import android.content.Context;
import android.view.TextureView;
import androidx.annotation.RequiresApi;

@RequiresApi(api = 14)
/* renamed from: com.kwad.components.core.page.widget.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8873b extends TextureView {
    public C8873b(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected final void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
