package com.bxkj.base.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class ExpandedLinearLayoutManager extends LinearLayoutManager {

    /* renamed from: e  reason: collision with root package name */
    private static final int f18322e = 0;

    /* renamed from: f  reason: collision with root package name */
    private static final int f18323f = 1;

    /* renamed from: g  reason: collision with root package name */
    private static final int f18324g = 100;

    /* renamed from: a  reason: collision with root package name */
    private final int[] f18325a;

    /* renamed from: b  reason: collision with root package name */
    private int f18326b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18327c;

    /* renamed from: d  reason: collision with root package name */
    private int[] f18328d;

    public ExpandedLinearLayoutManager(Context context) {
        super(context);
        this.f18325a = new int[2];
        this.f18326b = 100;
        this.f18328d = new int[2];
    }

    private void a(RecyclerView.Recycler recycler, int i4, int i5, int i6, int[] iArr) {
        View viewForPosition = recycler.getViewForPosition(i4);
        if (viewForPosition != null) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewForPosition.getLayoutParams();
            viewForPosition.measure(i5, ViewGroup.getChildMeasureSpec(i6, getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) layoutParams).height));
            iArr[0] = viewForPosition.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            iArr[1] = viewForPosition.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            recycler.recycleView(viewForPosition);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int i4, int i5) {
        View.MeasureSpec.getMode(i4);
        int mode = View.MeasureSpec.getMode(i5);
        View.MeasureSpec.getSize(i4);
        int size = View.MeasureSpec.getSize(i5);
        com.orhanobut.logger.j.c("state:" + state.toString());
        int i6 = 0;
        for (int i7 = 0; i7 < getItemCount(); i7++) {
            try {
                a(recycler, i7, i4, View.MeasureSpec.makeMeasureSpec(i7, 0), this.f18328d);
            } catch (IndexOutOfBoundsException e4) {
                e4.printStackTrace();
            }
            if (getOrientation() == 0) {
                int[] iArr = this.f18328d;
                int i8 = iArr[0];
                if (i7 == 0) {
                    i6 = iArr[1];
                }
            } else {
                int[] iArr2 = this.f18328d;
                i6 += iArr2[1];
                if (i7 == 0) {
                    int i9 = iArr2[0];
                }
            }
        }
        if (mode != 1073741824) {
            size = i6;
        }
        setMeasuredDimension(i4, size);
    }

    public ExpandedLinearLayoutManager(Context context, int i4, boolean z3) {
        super(context, i4, z3);
        this.f18325a = new int[2];
        this.f18326b = 100;
        this.f18328d = new int[2];
    }
}
