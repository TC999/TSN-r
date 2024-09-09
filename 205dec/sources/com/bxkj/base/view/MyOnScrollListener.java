package com.bxkj.base.view;

import androidx.recyclerview.widget.RecyclerView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class MyOnScrollListener extends RecyclerView.OnScrollListener {
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i4) {
        super.onScrollStateChanged(recyclerView, i4);
        if (i4 == 0) {
            recyclerView.removeOnScrollListener(this);
        }
    }
}
