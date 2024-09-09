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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class RLRecyclerView extends SwipeRefreshLayout {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f12943a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f12944b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f12945c;

    /* renamed from: d  reason: collision with root package name */
    private int[] f12946d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class NormalItemDecoration extends RecyclerView.ItemDecoration {

        /* renamed from: a  reason: collision with root package name */
        private final int f12947a;

        /* renamed from: b  reason: collision with root package name */
        private final int f12948b;

        /* renamed from: c  reason: collision with root package name */
        private final int f12949c;

        /* renamed from: d  reason: collision with root package name */
        private final int f12950d;

        public NormalItemDecoration(int i4, int i5, int i6, int i7) {
            this.f12947a = i4;
            this.f12948b = i5;
            this.f12949c = i6;
            this.f12950d = i7;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.left = this.f12947a;
            rect.top = this.f12948b;
            rect.right = this.f12949c;
            rect.bottom = this.f12950d;
        }
    }

    public RLRecyclerView(Context context) {
        super(context);
        this.f12945c = new int[2];
        this.f12946d = new int[2];
        a(context);
    }

    private void a(Context context) {
        this.f12943a = new RecyclerView(context);
        addView(this.f12943a, new ViewGroup.LayoutParams(-1, -1));
    }

    private int b(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return -1;
        }
        int i4 = iArr[0];
        for (int i5 : iArr) {
            if (i5 > i4) {
                i4 = i5;
            }
        }
        return i4;
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        RecyclerView recyclerView = this.f12943a;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(onScrollListener);
        }
    }

    public int[] findVisibleItemPositions() {
        RecyclerView recyclerView = this.f12943a;
        if (recyclerView != null) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                this.f12946d[0] = gridLayoutManager.findFirstVisibleItemPosition();
                this.f12946d[1] = gridLayoutManager.findLastVisibleItemPosition();
                return this.f12946d;
            } else if (layoutManager instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                this.f12946d[0] = linearLayoutManager.findFirstVisibleItemPosition();
                this.f12946d[1] = linearLayoutManager.findLastVisibleItemPosition();
                return this.f12946d;
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                if (this.f12944b == null) {
                    this.f12944b = new int[staggeredGridLayoutManager.getSpanCount()];
                }
                staggeredGridLayoutManager.findFirstVisibleItemPositions(this.f12944b);
                this.f12946d[0] = a(this.f12944b);
                staggeredGridLayoutManager.findLastVisibleItemPositions(this.f12944b);
                this.f12946d[1] = b(this.f12944b);
                return this.f12946d;
            } else {
                return null;
            }
        }
        return null;
    }

    public int getChildAdapterPosition(View view) {
        RecyclerView recyclerView = this.f12943a;
        if (recyclerView != null) {
            return recyclerView.getChildAdapterPosition(view);
        }
        return -1;
    }

    public int[] getLayoutManagerCounts() {
        RecyclerView.LayoutManager layoutManager;
        RecyclerView recyclerView = this.f12943a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return null;
        }
        this.f12945c[0] = layoutManager.getItemCount();
        this.f12945c[1] = layoutManager.getChildCount();
        return this.f12945c;
    }

    public View getRvChildAt(int i4) {
        RecyclerView recyclerView = this.f12943a;
        if (recyclerView != null) {
            return recyclerView.getChildAt(i4);
        }
        return null;
    }

    public int getRvChildCount() {
        RecyclerView recyclerView = this.f12943a;
        if (recyclerView != null) {
            return recyclerView.getChildCount();
        }
        return 0;
    }

    public int indexOfRvChild(View view) {
        RecyclerView recyclerView = this.f12943a;
        if (recyclerView != null) {
            return recyclerView.indexOfChild(view);
        }
        return -1;
    }

    public void scrollToPosition(int i4) {
        RecyclerView recyclerView = this.f12943a;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(i4);
        }
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        RecyclerView recyclerView = this.f12943a;
        if (recyclerView != null) {
            recyclerView.setAdapter(adapter);
        }
    }

    public void setItemDecoration(int i4, int i5, int i6, int i7) {
        RecyclerView recyclerView = this.f12943a;
        if (recyclerView != null) {
            recyclerView.addItemDecoration(new NormalItemDecoration(i4, i5, i6, i7));
        }
    }

    public void setLayoutManager(int i4, int i5, int i6) {
        RecyclerView recyclerView = this.f12943a;
        if (recyclerView != null) {
            if (1 == i4) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            } else if (2 == i4) {
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), i5));
            } else if (3 == i4) {
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(i5, i6));
            }
        }
    }

    public void setRecyclerViewPadding(int i4, int i5, int i6, int i7) {
        RecyclerView recyclerView = this.f12943a;
        if (recyclerView != null) {
            recyclerView.setPadding(i4, i5, i6, i7);
        }
    }

    private int a(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return -1;
        }
        int i4 = iArr[0];
        for (int i5 : iArr) {
            if (i5 < i4) {
                i4 = i5;
            }
        }
        return i4;
    }

    public RLRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12945c = new int[2];
        this.f12946d = new int[2];
        a(context);
    }
}
