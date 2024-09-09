package com.bytedance.sdk.openadsdk.core.ugeno.component.gif;

import android.content.Context;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import j0.d;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class UgenGif extends GifView {

    /* renamed from: c  reason: collision with root package name */
    private d f34926c;

    public UgenGif(Context context) {
        super(context);
    }

    public void c(d dVar) {
        this.f34926c = dVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d dVar = this.f34926c;
        if (dVar != null) {
            dVar.f();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dVar = this.f34926c;
        if (dVar != null) {
            dVar.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.adexpress.widget.GifView, android.view.View
    public void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
        d dVar = this.f34926c;
        if (dVar != null) {
            dVar.c(i4, i5, i6, i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.adexpress.widget.GifView, android.widget.ImageView, android.view.View
    public void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        d dVar = this.f34926c;
        if (dVar != null) {
            dVar.sr();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        d dVar = this.f34926c;
        if (dVar != null) {
            dVar.c(z3);
        }
    }
}
