package cn.bluemobi.dylan.base.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class UniversalItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: b */
    private static final String f1782b = "UniversalItemDecoration";

    /* renamed from: a */
    private Map<Integer, AbstractC1137b> f1783a = new HashMap();

    /* renamed from: cn.bluemobi.dylan.base.utils.UniversalItemDecoration$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1136a extends AbstractC1137b {

        /* renamed from: e */
        private Paint f1784e;

        /* renamed from: f */
        public int f1785f = ViewCompat.MEASURED_STATE_MASK;

        public C1136a() {
            Paint paint = new Paint(1);
            this.f1784e = paint;
            paint.setStyle(Paint.Style.FILL);
        }

        @Override // cn.bluemobi.dylan.base.utils.UniversalItemDecoration.AbstractC1137b
        /* renamed from: a */
        public void mo57790a(Canvas canvas, int i, int i2, int i3, int i4) {
            this.f1784e.setColor(this.f1785f);
            canvas.drawRect(i, i2, i3, i4, this.f1784e);
        }
    }

    /* renamed from: cn.bluemobi.dylan.base.utils.UniversalItemDecoration$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static abstract class AbstractC1137b {

        /* renamed from: a */
        public int f1786a;

        /* renamed from: b */
        public int f1787b;

        /* renamed from: c */
        public int f1788c;

        /* renamed from: d */
        public int f1789d;

        /* renamed from: a */
        public abstract void mo57790a(Canvas canvas, int i, int i2, int i3, int i4);
    }

    /* renamed from: b */
    public static int m57791b(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i;
        }
    }

    /* renamed from: a */
    public abstract AbstractC1137b m57792a(int i);

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        view.setTag(Integer.valueOf(childAdapterPosition));
        AbstractC1137b m57792a = m57792a(childAdapterPosition);
        if (m57792a != null) {
            rect.set(m57792a.f1786a, m57792a.f1788c, m57792a.f1787b, m57792a.f1789d);
        }
        this.f1783a.put(Integer.valueOf(childAdapterPosition), m57792a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            AbstractC1137b abstractC1137b = this.f1783a.get(Integer.valueOf(m57791b(childAt.getTag().toString(), 0)));
            if (abstractC1137b != null) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                int left = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                int right = childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                int top2 = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                int i2 = abstractC1137b.f1789d;
                if (i2 != 0) {
                    abstractC1137b.mo57790a(canvas, left - abstractC1137b.f1786a, bottom, right + abstractC1137b.f1787b, bottom + i2);
                }
                int i3 = abstractC1137b.f1788c;
                if (i3 != 0) {
                    abstractC1137b.mo57790a(canvas, left - abstractC1137b.f1786a, top2 - i3, right + abstractC1137b.f1787b, top2);
                }
                int i4 = abstractC1137b.f1786a;
                if (i4 != 0) {
                    abstractC1137b.mo57790a(canvas, left - i4, top2, left, bottom);
                }
                int i5 = abstractC1137b.f1787b;
                if (i5 != 0) {
                    abstractC1137b.mo57790a(canvas, right, top2, right + i5, bottom);
                }
            }
        }
    }
}
