package com.beizi.fusion.widget.dialog.dislike;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class FlowLayoutManager extends RecyclerView.LayoutManager {

    /* renamed from: e  reason: collision with root package name */
    private static final String f15307e = "FlowLayoutManager";

    /* renamed from: b  reason: collision with root package name */
    protected int f15309b;

    /* renamed from: c  reason: collision with root package name */
    protected int f15310c;

    /* renamed from: f  reason: collision with root package name */
    private int f15312f;

    /* renamed from: g  reason: collision with root package name */
    private int f15313g;

    /* renamed from: h  reason: collision with root package name */
    private int f15314h;

    /* renamed from: i  reason: collision with root package name */
    private int f15315i;

    /* renamed from: a  reason: collision with root package name */
    final FlowLayoutManager f15308a = this;

    /* renamed from: j  reason: collision with root package name */
    private int f15316j = 0;

    /* renamed from: d  reason: collision with root package name */
    protected int f15311d = 0;

    /* renamed from: k  reason: collision with root package name */
    private b f15317k = new b();

    /* renamed from: l  reason: collision with root package name */
    private List<b> f15318l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    private SparseArray<Rect> f15319m = new SparseArray<>();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        int f15320a;

        /* renamed from: b  reason: collision with root package name */
        View f15321b;

        /* renamed from: c  reason: collision with root package name */
        Rect f15322c;

        public a(int i4, View view, Rect rect) {
            this.f15320a = i4;
            this.f15321b = view;
            this.f15322c = rect;
        }

        public void a(Rect rect) {
            this.f15322c = rect;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        float f15324a;

        /* renamed from: b  reason: collision with root package name */
        float f15325b;

        /* renamed from: c  reason: collision with root package name */
        List<a> f15326c = new ArrayList();

        public b() {
        }

        public void a(float f4) {
            this.f15324a = f4;
        }

        public void b(float f4) {
            this.f15325b = f4;
        }

        public void a(a aVar) {
            this.f15326c.add(aVar);
        }
    }

    private void a(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout() || getItemCount() == 0) {
            return;
        }
        new Rect(getPaddingLeft(), getPaddingTop() + this.f15316j, getWidth() - getPaddingRight(), this.f15316j + (getHeight() - getPaddingBottom()));
        for (int i4 = 0; i4 < this.f15318l.size(); i4++) {
            b bVar = this.f15318l.get(i4);
            float f4 = bVar.f15324a;
            List<a> list = bVar.f15326c;
            for (int i5 = 0; i5 < list.size(); i5++) {
                View view = list.get(i5).f15321b;
                measureChildWithMargins(view, 0, 0);
                addView(view);
                Rect rect = list.get(i5).f15322c;
                int i6 = rect.left;
                int i7 = rect.top;
                int i8 = this.f15316j;
                layoutDecoratedWithMargins(view, i6, i7 - i8, rect.right, rect.bottom - i8);
            }
        }
    }

    private int b() {
        return (this.f15308a.getHeight() - this.f15308a.getPaddingBottom()) - this.f15308a.getPaddingTop();
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
        this.f15311d = 0;
        int i4 = this.f15313g;
        this.f15317k = new b();
        this.f15318l.clear();
        this.f15319m.clear();
        removeAllViews();
        if (getItemCount() == 0) {
            detachAndScrapAttachedViews(recycler);
            this.f15316j = 0;
        } else if (getChildCount() != 0 || !state.isPreLayout()) {
            detachAndScrapAttachedViews(recycler);
            if (getChildCount() == 0) {
                this.f15309b = getWidth();
                this.f15310c = getHeight();
                this.f15312f = getPaddingLeft();
                this.f15314h = getPaddingRight();
                this.f15313g = getPaddingTop();
                this.f15315i = (this.f15309b - this.f15312f) - this.f15314h;
            }
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < getItemCount(); i7++) {
                View viewForPosition = recycler.getViewForPosition(i7);
                if (8 != viewForPosition.getVisibility()) {
                    measureChildWithMargins(viewForPosition, 0, 0);
                    int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
                    int decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewForPosition);
                    int i8 = i5 + decoratedMeasuredWidth;
                    if (i8 <= this.f15315i) {
                        int i9 = this.f15312f + i5;
                        Rect rect = this.f15319m.get(i7);
                        if (rect == null) {
                            rect = new Rect();
                        }
                        rect.set(i9, i4, decoratedMeasuredWidth + i9, i4 + decoratedMeasuredHeight);
                        this.f15319m.put(i7, rect);
                        i6 = Math.max(i6, decoratedMeasuredHeight);
                        this.f15317k.a(new a(decoratedMeasuredHeight, viewForPosition, rect));
                        this.f15317k.a(i4);
                        this.f15317k.b(i6);
                        i5 = i8;
                    } else {
                        a();
                        i4 += i6;
                        this.f15311d += i6;
                        int i10 = this.f15312f;
                        Rect rect2 = this.f15319m.get(i7);
                        if (rect2 == null) {
                            rect2 = new Rect();
                        }
                        rect2.set(i10, i4, i10 + decoratedMeasuredWidth, i4 + decoratedMeasuredHeight);
                        this.f15319m.put(i7, rect2);
                        this.f15317k.a(new a(decoratedMeasuredHeight, viewForPosition, rect2));
                        this.f15317k.a(i4);
                        this.f15317k.b(decoratedMeasuredHeight);
                        i5 = decoratedMeasuredWidth;
                        i6 = decoratedMeasuredHeight;
                    }
                    if (i7 == getItemCount() - 1) {
                        a();
                        this.f15311d += i6;
                    }
                }
            }
            this.f15311d = Math.max(this.f15311d, b());
            a(recycler, state);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i4, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i5 = this.f15316j;
        if (i5 + i4 < 0) {
            i4 = -i5;
        } else if (i5 + i4 > this.f15311d - b()) {
            i4 = (this.f15311d - b()) - this.f15316j;
        }
        this.f15316j += i4;
        offsetChildrenVertical(-i4);
        a(recycler, state);
        return i4;
    }

    private void a() {
        List<a> list = this.f15317k.f15326c;
        for (int i4 = 0; i4 < list.size(); i4++) {
            a aVar = list.get(i4);
            View view = aVar.f15321b;
            int position = getPosition(view);
            b bVar = this.f15317k;
            if (this.f15319m.get(position).top < bVar.f15324a + ((bVar.f15325b - list.get(i4).f15320a) / 2.0f)) {
                Rect rect = this.f15319m.get(position);
                if (rect == null) {
                    rect = new Rect();
                }
                int i5 = this.f15319m.get(position).left;
                b bVar2 = this.f15317k;
                int i6 = (int) (bVar2.f15324a + ((bVar2.f15325b - list.get(i4).f15320a) / 2.0f));
                int i7 = this.f15319m.get(position).right;
                b bVar3 = this.f15317k;
                rect.set(i5, i6, i7, (int) (bVar3.f15324a + ((bVar3.f15325b - list.get(i4).f15320a) / 2.0f) + getDecoratedMeasuredHeight(view)));
                this.f15319m.put(position, rect);
                aVar.a(rect);
                list.set(i4, aVar);
            }
        }
        b bVar4 = this.f15317k;
        bVar4.f15326c = list;
        this.f15318l.add(bVar4);
        this.f15317k = new b();
    }
}
