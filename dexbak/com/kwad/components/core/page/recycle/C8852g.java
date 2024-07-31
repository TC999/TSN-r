package com.kwad.components.core.page.recycle;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: com.kwad.components.core.page.recycle.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8852g extends RecyclerView {

    /* renamed from: PW */
    private boolean f28665PW;

    public C8852g(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public void removeDetachedView(View view, boolean z) {
        if (!this.f28665PW) {
            super.removeDetachedView(view, z);
        } else {
            super.removeDetachedView(view, z);
        }
    }

    public void setIngoreTmpDetachedFlag(boolean z) {
        this.f28665PW = z;
    }

    public C8852g(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public C8852g(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
