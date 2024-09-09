package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class FlowLayout extends ViewGroup {

    /* renamed from: c  reason: collision with root package name */
    private List<List<View>> f36360c;

    /* renamed from: w  reason: collision with root package name */
    private List<Integer> f36361w;

    public FlowLayout(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f36360c = new ArrayList();
        this.f36361w = new ArrayList();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        a.f("TAG", "onLayout");
        this.f36360c.clear();
        this.f36361w.clear();
        int width = getWidth();
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            i9++;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if ((measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin) * i9 > (width - getPaddingLeft()) - getPaddingRight()) {
                this.f36361w.add(Integer.valueOf(i8));
                this.f36360c.add(arrayList);
                i8 = marginLayoutParams.bottomMargin + marginLayoutParams.topMargin + measuredHeight;
                arrayList = new ArrayList();
                i9 = 1;
            }
            i8 = Math.max(i8, measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
            arrayList.add(childAt);
        }
        this.f36361w.add(Integer.valueOf(i8));
        this.f36360c.add(arrayList);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.f36360c.size();
        for (int i11 = 0; i11 < size; i11++) {
            List<View> list = this.f36360c.get(i11);
            int intValue = this.f36361w.get(i11).intValue();
            for (int i12 = 0; i12 < list.size(); i12++) {
                View view = list.get(i12);
                if (view.getVisibility() != 8) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int i13 = marginLayoutParams2.leftMargin + paddingLeft;
                    int i14 = marginLayoutParams2.topMargin + paddingTop;
                    view.layout(i13, i14, view.getMeasuredWidth() + i13, view.getMeasuredHeight() + i14);
                    paddingLeft += view.getMeasuredWidth() + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
                }
            }
            paddingLeft = getPaddingLeft();
            paddingTop += intValue;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        int size = View.MeasureSpec.getSize(i4);
        int mode = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i5);
        int mode2 = View.MeasureSpec.getMode(i5);
        int childCount = getChildCount();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            measureChild(childAt, i4, i5);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            int i11 = i8 + measuredWidth;
            if (i11 - marginLayoutParams.rightMargin > (size - getPaddingLeft()) - getPaddingRight()) {
                i6 = Math.max(i6, i8);
                i7 += i9;
                i9 = measuredHeight;
                i8 = measuredWidth;
            } else {
                i9 = Math.max(i9, measuredHeight);
                i8 = i11;
            }
            if (i10 == childCount - 1) {
                i6 = Math.max(i8, i6);
                i7 += i9;
            }
        }
        a.f("TAG", "sizeWidth = " + size + "|sizeHeight = " + size2);
        a.f("TAG", "width = " + i6 + ", height = " + i7);
        if (mode != 1073741824) {
            size = getPaddingRight() + i6 + getPaddingLeft();
        }
        if (mode2 != 1073741824) {
            size2 = i7 + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(size, size2);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context) {
        this(context, null);
    }
}
