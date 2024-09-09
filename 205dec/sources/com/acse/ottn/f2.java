package com.acse.ottn;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class f2 extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public int f5656a;

    public f2(@Px int i4) {
        this.f5656a = i4;
    }

    public final LinearLayoutManager a(@NonNull RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return (LinearLayoutManager) layoutManager;
        }
        throw new IllegalStateException("The layoutManager must be LinearLayoutManager");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        if (a(recyclerView).getOrientation() == 1) {
            int i4 = this.f5656a;
            rect.top = i4;
            rect.bottom = i4;
            return;
        }
        int i5 = this.f5656a;
        rect.left = i5;
        rect.right = i5;
    }
}
