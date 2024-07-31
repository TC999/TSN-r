package com.bxkj.student.common.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class UniversalItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: b */
    private static final String f16208b = "UniversalItemDecoration";

    /* renamed from: a */
    private Map<Integer, AbstractC4246b> f16209a = new HashMap();

    /* renamed from: com.bxkj.student.common.utils.UniversalItemDecoration$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class C4245a extends AbstractC4246b {

        /* renamed from: e */
        private Paint f16210e;

        /* renamed from: f */
        public int f16211f = ViewCompat.MEASURED_STATE_MASK;

        public C4245a() {
            Paint paint = new Paint(1);
            this.f16210e = paint;
            paint.setStyle(Paint.Style.FILL);
        }

        @Override // com.bxkj.student.common.utils.UniversalItemDecoration.AbstractC4246b
        /* renamed from: a */
        public void mo42870a(Canvas c, int leftZ, int topZ, int rightZ, int bottomZ) {
            this.f16210e.setColor(this.f16211f);
            c.drawRect(leftZ, topZ, rightZ, bottomZ, this.f16210e);
        }
    }

    /* renamed from: com.bxkj.student.common.utils.UniversalItemDecoration$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static abstract class AbstractC4246b {

        /* renamed from: a */
        public int f16212a;

        /* renamed from: b */
        public int f16213b;

        /* renamed from: c */
        public int f16214c;

        /* renamed from: d */
        public int f16215d;

        /* renamed from: a */
        public abstract void mo42870a(Canvas c, int leftZ, int topZ, int rightZ, int bottomZ);
    }

    /* renamed from: b */
    public static int m42871b(String s, int defValue) {
        try {
            return Integer.parseInt(s);
        } catch (Exception unused) {
            return defValue;
        }
    }

    /* renamed from: a */
    public abstract AbstractC4246b mo40391a(int position);

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        view.setTag(Integer.valueOf(childAdapterPosition));
        AbstractC4246b mo40391a = mo40391a(childAdapterPosition);
        if (mo40391a != null) {
            outRect.set(mo40391a.f16212a, mo40391a.f16214c, mo40391a.f16213b, mo40391a.f16215d);
        }
        this.f16209a.put(Integer.valueOf(childAdapterPosition), mo40391a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            AbstractC4246b abstractC4246b = this.f16209a.get(Integer.valueOf(m42871b(childAt.getTag().toString(), 0)));
            if (abstractC4246b != null) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                int left = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                int right = childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                int top2 = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                int i2 = abstractC4246b.f16215d;
                if (i2 != 0) {
                    abstractC4246b.mo42870a(c, left - abstractC4246b.f16212a, bottom, right + abstractC4246b.f16213b, bottom + i2);
                }
                int i3 = abstractC4246b.f16214c;
                if (i3 != 0) {
                    abstractC4246b.mo42870a(c, left - abstractC4246b.f16212a, top2 - i3, right + abstractC4246b.f16213b, top2);
                }
                int i4 = abstractC4246b.f16212a;
                if (i4 != 0) {
                    abstractC4246b.mo42870a(c, left - i4, top2, left, bottom);
                }
                int i5 = abstractC4246b.f16213b;
                if (i5 != 0) {
                    abstractC4246b.mo42870a(c, right, top2, right + i5, bottom);
                }
            }
        }
    }
}
