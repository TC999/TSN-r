package com.bxkj.base.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.orhanobut.logger.C11792j;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ExpandedLinearLayoutManager extends LinearLayoutManager {

    /* renamed from: e */
    private static final int f14838e = 0;

    /* renamed from: f */
    private static final int f14839f = 1;

    /* renamed from: g */
    private static final int f14840g = 100;

    /* renamed from: a */
    private final int[] f14841a;

    /* renamed from: b */
    private int f14842b;

    /* renamed from: c */
    private boolean f14843c;

    /* renamed from: d */
    private int[] f14844d;

    public ExpandedLinearLayoutManager(Context context) {
        super(context);
        this.f14841a = new int[2];
        this.f14842b = 100;
        this.f14844d = new int[2];
    }

    /* renamed from: a */
    private void m44151a(RecyclerView.Recycler recycler, int i, int i2, int i3, int[] iArr) {
        View viewForPosition = recycler.getViewForPosition(i);
        if (viewForPosition != null) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewForPosition.getLayoutParams();
            viewForPosition.measure(i2, ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) layoutParams).height));
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
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2) {
        View.MeasureSpec.getMode(i);
        int mode = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        int size = View.MeasureSpec.getSize(i2);
        C11792j.m20470c("state:" + state.toString());
        int i3 = 0;
        for (int i4 = 0; i4 < getItemCount(); i4++) {
            try {
                m44151a(recycler, i4, i, View.MeasureSpec.makeMeasureSpec(i4, 0), this.f14844d);
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
            if (getOrientation() == 0) {
                int[] iArr = this.f14844d;
                int i5 = iArr[0];
                if (i4 == 0) {
                    i3 = iArr[1];
                }
            } else {
                int[] iArr2 = this.f14844d;
                i3 += iArr2[1];
                if (i4 == 0) {
                    int i6 = iArr2[0];
                }
            }
        }
        if (mode != 1073741824) {
            size = i3;
        }
        setMeasuredDimension(i, size);
    }

    public ExpandedLinearLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
        this.f14841a = new int[2];
        this.f14842b = 100;
        this.f14844d = new int[2];
    }
}
