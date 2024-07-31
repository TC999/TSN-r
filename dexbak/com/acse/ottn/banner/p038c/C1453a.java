package com.acse.ottn.banner.p038c;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.InterfaceC0075Px;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: com.acse.ottn.banner.c.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1453a extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private int f2652a;

    public C1453a(@InterfaceC0075Px int i) {
        this.f2652a = i;
    }

    /* renamed from: a */
    private LinearLayoutManager m56732a(@NonNull RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return (LinearLayoutManager) layoutManager;
        }
        throw new IllegalStateException("The layoutManager must be LinearLayoutManager");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        if (m56732a(recyclerView).getOrientation() == 1) {
            int i = this.f2652a;
            rect.top = i;
            rect.bottom = i;
            return;
        }
        int i2 = this.f2652a;
        rect.left = i2;
        rect.right = i2;
    }
}
