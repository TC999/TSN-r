package com.bxkj.student.common.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class UniversalItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: b  reason: collision with root package name */
    private static final String f19607b = "UniversalItemDecoration";

    /* renamed from: a  reason: collision with root package name */
    private Map<Integer, b> f19608a = new HashMap();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static class a extends b {

        /* renamed from: e  reason: collision with root package name */
        private Paint f19609e;

        /* renamed from: f  reason: collision with root package name */
        public int f19610f = -16777216;

        public a() {
            Paint paint = new Paint(1);
            this.f19609e = paint;
            paint.setStyle(Paint.Style.FILL);
        }

        @Override // com.bxkj.student.common.utils.UniversalItemDecoration.b
        public void a(Canvas c4, int leftZ, int topZ, int rightZ, int bottomZ) {
            this.f19609e.setColor(this.f19610f);
            c4.drawRect(leftZ, topZ, rightZ, bottomZ, this.f19609e);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        public int f19611a;

        /* renamed from: b  reason: collision with root package name */
        public int f19612b;

        /* renamed from: c  reason: collision with root package name */
        public int f19613c;

        /* renamed from: d  reason: collision with root package name */
        public int f19614d;

        public abstract void a(Canvas c4, int leftZ, int topZ, int rightZ, int bottomZ);
    }

    public static int b(String s3, int defValue) {
        try {
            return Integer.parseInt(s3);
        } catch (Exception unused) {
            return defValue;
        }
    }

    public abstract b a(int position);

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        view.setTag(Integer.valueOf(childAdapterPosition));
        b a4 = a(childAdapterPosition);
        if (a4 != null) {
            outRect.set(a4.f19611a, a4.f19613c, a4.f19612b, a4.f19614d);
        }
        this.f19608a.put(Integer.valueOf(childAdapterPosition), a4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas c4, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c4, parent, state);
        int childCount = parent.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = parent.getChildAt(i4);
            b bVar = this.f19608a.get(Integer.valueOf(b(childAt.getTag().toString(), 0)));
            if (bVar != null) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                int left = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                int right = childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                int top2 = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                int i5 = bVar.f19614d;
                if (i5 != 0) {
                    bVar.a(c4, left - bVar.f19611a, bottom, right + bVar.f19612b, bottom + i5);
                }
                int i6 = bVar.f19613c;
                if (i6 != 0) {
                    bVar.a(c4, left - bVar.f19611a, top2 - i6, right + bVar.f19612b, top2);
                }
                int i7 = bVar.f19611a;
                if (i7 != 0) {
                    bVar.a(c4, left - i7, top2, left, bottom);
                }
                int i8 = bVar.f19612b;
                if (i8 != 0) {
                    bVar.a(c4, right, top2, right + i8, bottom);
                }
            }
        }
    }
}
