package com.bxkj.base.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class UniversalItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: b */
    private static final String f14855b = "UniversalItemDecoration";

    /* renamed from: a */
    private Map<Integer, AbstractC3891b> f14856a = new HashMap();

    /* renamed from: com.bxkj.base.util.UniversalItemDecoration$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3890a extends AbstractC3891b {

        /* renamed from: e */
        private Paint f14857e;

        /* renamed from: f */
        public int f14858f = ViewCompat.MEASURED_STATE_MASK;

        public C3890a() {
            Paint paint = new Paint(1);
            this.f14857e = paint;
            paint.setStyle(Paint.Style.FILL);
        }

        @Override // com.bxkj.base.util.UniversalItemDecoration.AbstractC3891b
        /* renamed from: a */
        public void mo44141a(Canvas canvas, int i, int i2, int i3, int i4) {
            this.f14857e.setColor(this.f14858f);
            canvas.drawRect(i, i2, i3, i4, this.f14857e);
        }
    }

    /* renamed from: com.bxkj.base.util.UniversalItemDecoration$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static abstract class AbstractC3891b {

        /* renamed from: a */
        public int f14859a;

        /* renamed from: b */
        public int f14860b;

        /* renamed from: c */
        public int f14861c;

        /* renamed from: d */
        public int f14862d;

        /* renamed from: a */
        public abstract void mo44141a(Canvas canvas, int i, int i2, int i3, int i4);
    }

    /* renamed from: b */
    public static int m44142b(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i;
        }
    }

    /* renamed from: a */
    public abstract AbstractC3891b mo43302a(int i);

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        view.setTag(Integer.valueOf(childAdapterPosition));
        AbstractC3891b mo43302a = mo43302a(childAdapterPosition);
        if (mo43302a != null) {
            rect.set(mo43302a.f14859a, mo43302a.f14861c, mo43302a.f14860b, mo43302a.f14862d);
        }
        this.f14856a.put(Integer.valueOf(childAdapterPosition), mo43302a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            AbstractC3891b abstractC3891b = this.f14856a.get(Integer.valueOf(m44142b(childAt.getTag().toString(), 0)));
            if (abstractC3891b != null) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                int left = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                int right = childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                int top2 = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                int i2 = abstractC3891b.f14862d;
                if (i2 != 0) {
                    abstractC3891b.mo44141a(canvas, left - abstractC3891b.f14859a, bottom, right + abstractC3891b.f14860b, bottom + i2);
                }
                int i3 = abstractC3891b.f14861c;
                if (i3 != 0) {
                    abstractC3891b.mo44141a(canvas, left - abstractC3891b.f14859a, top2 - i3, right + abstractC3891b.f14860b, top2);
                }
                int i4 = abstractC3891b.f14859a;
                if (i4 != 0) {
                    abstractC3891b.mo44141a(canvas, left - i4, top2, left, bottom);
                }
                int i5 = abstractC3891b.f14860b;
                if (i5 != 0) {
                    abstractC3891b.mo44141a(canvas, right, top2, right + i5, bottom);
                }
            }
        }
    }
}
