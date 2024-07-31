package com.baidu.mobads.sdk.internal.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RLRecyclerView extends SwipeRefreshLayout {

    /* renamed from: a */
    private RecyclerView f9157a;

    /* renamed from: b */
    private int[] f9158b;

    /* renamed from: c */
    private int[] f9159c;

    /* renamed from: d */
    private int[] f9160d;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class NormalItemDecoration extends RecyclerView.ItemDecoration {

        /* renamed from: a */
        private final int f9161a;

        /* renamed from: b */
        private final int f9162b;

        /* renamed from: c */
        private final int f9163c;

        /* renamed from: d */
        private final int f9164d;

        public NormalItemDecoration(int i, int i2, int i3, int i4) {
            this.f9161a = i;
            this.f9162b = i2;
            this.f9163c = i3;
            this.f9164d = i4;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.left = this.f9161a;
            rect.top = this.f9162b;
            rect.right = this.f9163c;
            rect.bottom = this.f9164d;
        }
    }

    public RLRecyclerView(Context context) {
        super(context);
        this.f9159c = new int[2];
        this.f9160d = new int[2];
        m50273a(context);
    }

    /* renamed from: a */
    private void m50273a(Context context) {
        this.f9157a = new RecyclerView(context);
        addView(this.f9157a, new ViewGroup.LayoutParams(-1, -1));
    }

    /* renamed from: b */
    private int m50271b(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return -1;
        }
        int i = iArr[0];
        for (int i2 : iArr) {
            if (i2 > i) {
                i = i2;
            }
        }
        return i;
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        RecyclerView recyclerView = this.f9157a;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(onScrollListener);
        }
    }

    public int[] findVisibleItemPositions() {
        RecyclerView recyclerView = this.f9157a;
        if (recyclerView != null) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                this.f9160d[0] = gridLayoutManager.findFirstVisibleItemPosition();
                this.f9160d[1] = gridLayoutManager.findLastVisibleItemPosition();
                return this.f9160d;
            } else if (layoutManager instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                this.f9160d[0] = linearLayoutManager.findFirstVisibleItemPosition();
                this.f9160d[1] = linearLayoutManager.findLastVisibleItemPosition();
                return this.f9160d;
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                if (this.f9158b == null) {
                    this.f9158b = new int[staggeredGridLayoutManager.getSpanCount()];
                }
                staggeredGridLayoutManager.findFirstVisibleItemPositions(this.f9158b);
                this.f9160d[0] = m50272a(this.f9158b);
                staggeredGridLayoutManager.findLastVisibleItemPositions(this.f9158b);
                this.f9160d[1] = m50271b(this.f9158b);
                return this.f9160d;
            } else {
                return null;
            }
        }
        return null;
    }

    public int getChildAdapterPosition(View view) {
        RecyclerView recyclerView = this.f9157a;
        if (recyclerView != null) {
            return recyclerView.getChildAdapterPosition(view);
        }
        return -1;
    }

    public int[] getLayoutManagerCounts() {
        RecyclerView.LayoutManager layoutManager;
        RecyclerView recyclerView = this.f9157a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return null;
        }
        this.f9159c[0] = layoutManager.getItemCount();
        this.f9159c[1] = layoutManager.getChildCount();
        return this.f9159c;
    }

    public View getRvChildAt(int i) {
        RecyclerView recyclerView = this.f9157a;
        if (recyclerView != null) {
            return recyclerView.getChildAt(i);
        }
        return null;
    }

    public int getRvChildCount() {
        RecyclerView recyclerView = this.f9157a;
        if (recyclerView != null) {
            return recyclerView.getChildCount();
        }
        return 0;
    }

    public int indexOfRvChild(View view) {
        RecyclerView recyclerView = this.f9157a;
        if (recyclerView != null) {
            return recyclerView.indexOfChild(view);
        }
        return -1;
    }

    public void scrollToPosition(int i) {
        RecyclerView recyclerView = this.f9157a;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(i);
        }
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        RecyclerView recyclerView = this.f9157a;
        if (recyclerView != null) {
            recyclerView.setAdapter(adapter);
        }
    }

    public void setItemDecoration(int i, int i2, int i3, int i4) {
        RecyclerView recyclerView = this.f9157a;
        if (recyclerView != null) {
            recyclerView.addItemDecoration(new NormalItemDecoration(i, i2, i3, i4));
        }
    }

    public void setLayoutManager(int i, int i2, int i3) {
        RecyclerView recyclerView = this.f9157a;
        if (recyclerView != null) {
            if (1 == i) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            } else if (2 == i) {
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), i2));
            } else if (3 == i) {
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(i2, i3));
            }
        }
    }

    public void setRecyclerViewPadding(int i, int i2, int i3, int i4) {
        RecyclerView recyclerView = this.f9157a;
        if (recyclerView != null) {
            recyclerView.setPadding(i, i2, i3, i4);
        }
    }

    /* renamed from: a */
    private int m50272a(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return -1;
        }
        int i = iArr[0];
        for (int i2 : iArr) {
            if (i2 < i) {
                i = i2;
            }
        }
        return i;
    }

    public RLRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9159c = new int[2];
        this.f9160d = new int[2];
        m50273a(context);
    }
}
