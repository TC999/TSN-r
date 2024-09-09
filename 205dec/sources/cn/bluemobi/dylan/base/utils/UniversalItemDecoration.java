package cn.bluemobi.dylan.base.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class UniversalItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: b  reason: collision with root package name */
    private static final String f1768b = "UniversalItemDecoration";

    /* renamed from: a  reason: collision with root package name */
    private Map<Integer, b> f1769a = new HashMap();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class a extends b {

        /* renamed from: e  reason: collision with root package name */
        private Paint f1770e;

        /* renamed from: f  reason: collision with root package name */
        public int f1771f = -16777216;

        public a() {
            Paint paint = new Paint(1);
            this.f1770e = paint;
            paint.setStyle(Paint.Style.FILL);
        }

        @Override // cn.bluemobi.dylan.base.utils.UniversalItemDecoration.b
        public void a(Canvas canvas, int i4, int i5, int i6, int i7) {
            this.f1770e.setColor(this.f1771f);
            canvas.drawRect(i4, i5, i6, i7, this.f1770e);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        public int f1772a;

        /* renamed from: b  reason: collision with root package name */
        public int f1773b;

        /* renamed from: c  reason: collision with root package name */
        public int f1774c;

        /* renamed from: d  reason: collision with root package name */
        public int f1775d;

        public abstract void a(Canvas canvas, int i4, int i5, int i6, int i7);
    }

    public static int b(String str, int i4) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i4;
        }
    }

    public abstract b a(int i4);

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        view.setTag(Integer.valueOf(childAdapterPosition));
        b a4 = a(childAdapterPosition);
        if (a4 != null) {
            rect.set(a4.f1772a, a4.f1774c, a4.f1773b, a4.f1775d);
        }
        this.f1769a.put(Integer.valueOf(childAdapterPosition), a4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        int childCount = recyclerView.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = recyclerView.getChildAt(i4);
            b bVar = this.f1769a.get(Integer.valueOf(b(childAt.getTag().toString(), 0)));
            if (bVar != null) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                int left = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                int right = childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                int top2 = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                int i5 = bVar.f1775d;
                if (i5 != 0) {
                    bVar.a(canvas, left - bVar.f1772a, bottom, right + bVar.f1773b, bottom + i5);
                }
                int i6 = bVar.f1774c;
                if (i6 != 0) {
                    bVar.a(canvas, left - bVar.f1772a, top2 - i6, right + bVar.f1773b, top2);
                }
                int i7 = bVar.f1772a;
                if (i7 != 0) {
                    bVar.a(canvas, left - i7, top2, left, bottom);
                }
                int i8 = bVar.f1773b;
                if (i8 != 0) {
                    bVar.a(canvas, right, top2, right + i8, bottom);
                }
            }
        }
    }
}
