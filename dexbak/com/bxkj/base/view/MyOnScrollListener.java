package com.bxkj.base.view;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MyOnScrollListener extends RecyclerView.OnScrollListener {
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        if (i == 0) {
            recyclerView.removeOnScrollListener(this);
        }
    }
}
