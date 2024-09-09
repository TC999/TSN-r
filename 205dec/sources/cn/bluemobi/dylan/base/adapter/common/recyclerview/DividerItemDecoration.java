package cn.bluemobi.dylan.base.adapter.common.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f1719c = {16843284};

    /* renamed from: d  reason: collision with root package name */
    public static final int f1720d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static final int f1721e = 1;

    /* renamed from: a  reason: collision with root package name */
    private Drawable f1722a;

    /* renamed from: b  reason: collision with root package name */
    private int f1723b;

    public DividerItemDecoration(Context context, int i4) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f1719c);
        this.f1722a = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        setOrientation(i4);
    }

    public void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop = recyclerView.getPaddingTop();
        int height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = recyclerView.getChildAt(i4);
            int right = childAt.getRight() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).rightMargin;
            this.f1722a.setBounds(right, paddingTop, this.f1722a.getIntrinsicHeight() + right, height);
            this.f1722a.draw(canvas);
        }
    }

    public void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = recyclerView.getChildAt(i4);
            new RecyclerView(recyclerView.getContext());
            int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).bottomMargin;
            this.f1722a.setBounds(paddingLeft, bottom, width, this.f1722a.getIntrinsicHeight() + bottom);
            this.f1722a.draw(canvas);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, int i4, RecyclerView recyclerView) {
        if (this.f1723b == 1) {
            rect.set(0, 0, 0, this.f1722a.getIntrinsicHeight());
        } else {
            rect.set(0, 0, this.f1722a.getIntrinsicWidth(), 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        if (this.f1723b == 1) {
            drawVertical(canvas, recyclerView);
        } else {
            drawHorizontal(canvas, recyclerView);
        }
    }

    public void setOrientation(int i4) {
        if (i4 != 0 && i4 != 1) {
            throw new IllegalArgumentException("invalid orientation");
        }
        this.f1723b = i4;
    }
}
