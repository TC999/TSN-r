package com.bxkj.place.view;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MyRecyclerViewOnScrollListener extends RecyclerView.OnScrollListener {

    /* renamed from: a */
    private RecyclerView f15885a;

    public MyRecyclerViewOnScrollListener(RecyclerView other) {
        this.f15885a = other;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        if (newState == 0) {
            recyclerView.removeOnScrollListener(this);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        this.f15885a.scrollBy(dx, dy);
    }
}
