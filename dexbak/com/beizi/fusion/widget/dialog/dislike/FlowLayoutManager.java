package com.beizi.fusion.widget.dialog.dislike;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class FlowLayoutManager extends RecyclerView.LayoutManager {

    /* renamed from: e */
    private static final String f11729e = "FlowLayoutManager";

    /* renamed from: b */
    protected int f11731b;

    /* renamed from: c */
    protected int f11732c;

    /* renamed from: f */
    private int f11734f;

    /* renamed from: g */
    private int f11735g;

    /* renamed from: h */
    private int f11736h;

    /* renamed from: i */
    private int f11737i;

    /* renamed from: a */
    final FlowLayoutManager f11730a = this;

    /* renamed from: j */
    private int f11738j = 0;

    /* renamed from: d */
    protected int f11733d = 0;

    /* renamed from: k */
    private C3234b f11739k = new C3234b();

    /* renamed from: l */
    private List<C3234b> f11740l = new ArrayList();

    /* renamed from: m */
    private SparseArray<Rect> f11741m = new SparseArray<>();

    /* renamed from: com.beizi.fusion.widget.dialog.dislike.FlowLayoutManager$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3233a {

        /* renamed from: a */
        int f11742a;

        /* renamed from: b */
        View f11743b;

        /* renamed from: c */
        Rect f11744c;

        public C3233a(int i, View view, Rect rect) {
            this.f11742a = i;
            this.f11743b = view;
            this.f11744c = rect;
        }

        /* renamed from: a */
        public void m48020a(Rect rect) {
            this.f11744c = rect;
        }
    }

    /* renamed from: com.beizi.fusion.widget.dialog.dislike.FlowLayoutManager$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3234b {

        /* renamed from: a */
        float f11746a;

        /* renamed from: b */
        float f11747b;

        /* renamed from: c */
        List<C3233a> f11748c = new ArrayList();

        public C3234b() {
        }

        /* renamed from: a */
        public void m48019a(float f) {
            this.f11746a = f;
        }

        /* renamed from: b */
        public void m48017b(float f) {
            this.f11747b = f;
        }

        /* renamed from: a */
        public void m48018a(C3233a c3233a) {
            this.f11748c.add(c3233a);
        }
    }

    /* renamed from: a */
    private void m48022a(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout() || getItemCount() == 0) {
            return;
        }
        new Rect(getPaddingLeft(), getPaddingTop() + this.f11738j, getWidth() - getPaddingRight(), this.f11738j + (getHeight() - getPaddingBottom()));
        for (int i = 0; i < this.f11740l.size(); i++) {
            C3234b c3234b = this.f11740l.get(i);
            float f = c3234b.f11746a;
            List<C3233a> list = c3234b.f11748c;
            for (int i2 = 0; i2 < list.size(); i2++) {
                View view = list.get(i2).f11743b;
                measureChildWithMargins(view, 0, 0);
                addView(view);
                Rect rect = list.get(i2).f11744c;
                int i3 = rect.left;
                int i4 = rect.top;
                int i5 = this.f11738j;
                layoutDecoratedWithMargins(view, i3, i4 - i5, rect.right, rect.bottom - i5);
            }
        }
    }

    /* renamed from: b */
    private int m48021b() {
        return (this.f11730a.getHeight() - this.f11730a.getPaddingBottom()) - this.f11730a.getPaddingTop();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        this.f11733d = 0;
        int i = this.f11735g;
        this.f11739k = new C3234b();
        this.f11740l.clear();
        this.f11741m.clear();
        removeAllViews();
        if (getItemCount() == 0) {
            detachAndScrapAttachedViews(recycler);
            this.f11738j = 0;
        } else if (getChildCount() != 0 || !state.isPreLayout()) {
            detachAndScrapAttachedViews(recycler);
            if (getChildCount() == 0) {
                this.f11731b = getWidth();
                this.f11732c = getHeight();
                this.f11734f = getPaddingLeft();
                this.f11736h = getPaddingRight();
                this.f11735g = getPaddingTop();
                this.f11737i = (this.f11731b - this.f11734f) - this.f11736h;
            }
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < getItemCount(); i4++) {
                View viewForPosition = recycler.getViewForPosition(i4);
                if (8 != viewForPosition.getVisibility()) {
                    measureChildWithMargins(viewForPosition, 0, 0);
                    int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
                    int decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewForPosition);
                    int i5 = i2 + decoratedMeasuredWidth;
                    if (i5 <= this.f11737i) {
                        int i6 = this.f11734f + i2;
                        Rect rect = this.f11741m.get(i4);
                        if (rect == null) {
                            rect = new Rect();
                        }
                        rect.set(i6, i, decoratedMeasuredWidth + i6, i + decoratedMeasuredHeight);
                        this.f11741m.put(i4, rect);
                        i3 = Math.max(i3, decoratedMeasuredHeight);
                        this.f11739k.m48018a(new C3233a(decoratedMeasuredHeight, viewForPosition, rect));
                        this.f11739k.m48019a(i);
                        this.f11739k.m48017b(i3);
                        i2 = i5;
                    } else {
                        m48023a();
                        i += i3;
                        this.f11733d += i3;
                        int i7 = this.f11734f;
                        Rect rect2 = this.f11741m.get(i4);
                        if (rect2 == null) {
                            rect2 = new Rect();
                        }
                        rect2.set(i7, i, i7 + decoratedMeasuredWidth, i + decoratedMeasuredHeight);
                        this.f11741m.put(i4, rect2);
                        this.f11739k.m48018a(new C3233a(decoratedMeasuredHeight, viewForPosition, rect2));
                        this.f11739k.m48019a(i);
                        this.f11739k.m48017b(decoratedMeasuredHeight);
                        i2 = decoratedMeasuredWidth;
                        i3 = decoratedMeasuredHeight;
                    }
                    if (i4 == getItemCount() - 1) {
                        m48023a();
                        this.f11733d += i3;
                    }
                }
            }
            this.f11733d = Math.max(this.f11733d, m48021b());
            m48022a(recycler, state);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2 = this.f11738j;
        if (i2 + i < 0) {
            i = -i2;
        } else if (i2 + i > this.f11733d - m48021b()) {
            i = (this.f11733d - m48021b()) - this.f11738j;
        }
        this.f11738j += i;
        offsetChildrenVertical(-i);
        m48022a(recycler, state);
        return i;
    }

    /* renamed from: a */
    private void m48023a() {
        List<C3233a> list = this.f11739k.f11748c;
        for (int i = 0; i < list.size(); i++) {
            C3233a c3233a = list.get(i);
            View view = c3233a.f11743b;
            int position = getPosition(view);
            C3234b c3234b = this.f11739k;
            if (this.f11741m.get(position).top < c3234b.f11746a + ((c3234b.f11747b - list.get(i).f11742a) / 2.0f)) {
                Rect rect = this.f11741m.get(position);
                if (rect == null) {
                    rect = new Rect();
                }
                int i2 = this.f11741m.get(position).left;
                C3234b c3234b2 = this.f11739k;
                int i3 = (int) (c3234b2.f11746a + ((c3234b2.f11747b - list.get(i).f11742a) / 2.0f));
                int i4 = this.f11741m.get(position).right;
                C3234b c3234b3 = this.f11739k;
                rect.set(i2, i3, i4, (int) (c3234b3.f11746a + ((c3234b3.f11747b - list.get(i).f11742a) / 2.0f) + getDecoratedMeasuredHeight(view)));
                this.f11741m.put(position, rect);
                c3233a.m48020a(rect);
                list.set(i, c3233a);
            }
        }
        C3234b c3234b4 = this.f11739k;
        c3234b4.f11748c = list;
        this.f11740l.add(c3234b4);
        this.f11739k = new C3234b();
    }
}
