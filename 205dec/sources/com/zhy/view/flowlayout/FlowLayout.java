package com.zhy.view.flowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class FlowLayout extends ViewGroup {

    /* renamed from: f  reason: collision with root package name */
    private static final String f54567f = "FlowLayout";

    /* renamed from: g  reason: collision with root package name */
    private static final int f54568g = -1;

    /* renamed from: h  reason: collision with root package name */
    private static final int f54569h = 0;

    /* renamed from: i  reason: collision with root package name */
    private static final int f54570i = 1;

    /* renamed from: a  reason: collision with root package name */
    protected List<List<View>> f54571a;

    /* renamed from: b  reason: collision with root package name */
    protected List<Integer> f54572b;

    /* renamed from: c  reason: collision with root package name */
    protected List<Integer> f54573c;

    /* renamed from: d  reason: collision with root package name */
    private int f54574d;

    /* renamed from: e  reason: collision with root package name */
    private List<View> f54575e;

    public FlowLayout(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f54571a = new ArrayList();
        this.f54572b = new ArrayList();
        this.f54573c = new ArrayList();
        this.f54575e = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TagFlowLayout);
        this.f54574d = obtainStyledAttributes.getInt(R.styleable.TagFlowLayout_gravity, -1);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        int i8;
        int paddingLeft;
        this.f54571a.clear();
        this.f54572b.clear();
        this.f54573c.clear();
        this.f54575e.clear();
        int width = getWidth();
        int childCount = getChildCount();
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredWidth + i10 + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin > (width - getPaddingLeft()) - getPaddingRight()) {
                    this.f54572b.add(Integer.valueOf(i9));
                    this.f54571a.add(this.f54575e);
                    this.f54573c.add(Integer.valueOf(i10));
                    i9 = marginLayoutParams.topMargin + measuredHeight + marginLayoutParams.bottomMargin;
                    this.f54575e = new ArrayList();
                    i10 = 0;
                }
                i10 += measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                i9 = Math.max(i9, measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
                this.f54575e.add(childAt);
            }
        }
        this.f54572b.add(Integer.valueOf(i9));
        this.f54573c.add(Integer.valueOf(i10));
        this.f54571a.add(this.f54575e);
        int paddingLeft2 = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.f54571a.size();
        for (int i12 = 0; i12 < size; i12++) {
            this.f54575e = this.f54571a.get(i12);
            int intValue = this.f54572b.get(i12).intValue();
            int intValue2 = this.f54573c.get(i12).intValue();
            int i13 = this.f54574d;
            if (i13 != -1) {
                if (i13 == 0) {
                    i8 = (width - intValue2) / 2;
                    paddingLeft = getPaddingLeft();
                } else if (i13 == 1) {
                    i8 = width - intValue2;
                    paddingLeft = getPaddingLeft();
                }
                paddingLeft2 = i8 + paddingLeft;
            } else {
                paddingLeft2 = getPaddingLeft();
            }
            for (int i14 = 0; i14 < this.f54575e.size(); i14++) {
                View view = this.f54575e.get(i14);
                if (view.getVisibility() != 8) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int i15 = marginLayoutParams2.leftMargin + paddingLeft2;
                    int i16 = marginLayoutParams2.topMargin + paddingTop;
                    view.layout(i15, i16, view.getMeasuredWidth() + i15, view.getMeasuredHeight() + i16);
                    paddingLeft2 += view.getMeasuredWidth() + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
                }
            }
            paddingTop += intValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i4, int i5) {
        int i6;
        int size = View.MeasureSpec.getSize(i4);
        int mode = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i5);
        int mode2 = View.MeasureSpec.getMode(i5);
        int childCount = getChildCount();
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i7 < childCount) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() == 8) {
                if (i7 == childCount - 1) {
                    i8 = Math.max(i9, i8);
                    i11 += i10;
                }
                i6 = size2;
            } else {
                measureChild(childAt, i4, i5);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                i6 = size2;
                int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                int i12 = i9 + measuredWidth;
                if (i12 > (size - getPaddingLeft()) - getPaddingRight()) {
                    i8 = Math.max(i8, i9);
                    i11 += i10;
                } else {
                    measuredHeight = Math.max(i10, measuredHeight);
                    measuredWidth = i12;
                }
                if (i7 == childCount - 1) {
                    i8 = Math.max(measuredWidth, i8);
                    i11 += measuredHeight;
                }
                i10 = measuredHeight;
                i9 = measuredWidth;
            }
            i7++;
            size2 = i6;
        }
        int i13 = size2;
        if (mode != 1073741824) {
            size = getPaddingRight() + i8 + getPaddingLeft();
        }
        setMeasuredDimension(size, mode2 == 1073741824 ? i13 : i11 + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context) {
        this(context, null);
    }
}
