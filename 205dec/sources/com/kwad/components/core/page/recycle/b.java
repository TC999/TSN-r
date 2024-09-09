package com.kwad.components.core.page.recycle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b extends g {
    private Rect Pq;
    private int Pr;
    private int Ps;
    private boolean Pt;
    private int Pu;
    private a Pv;
    private boolean Pw;
    private boolean Px;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        boolean pQ();
    }

    public b(Context context) {
        this(context, null);
    }

    private void a(int i4, int i5, int i6) {
        while (true) {
            if (this.Pu == Integer.MIN_VALUE) {
                int[] iArr = new int[2];
                getLocationOnScreen(iArr);
                this.Pu = iArr[1];
            }
            int findFirstVisibleItemPosition = f.b(this).findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = f.b(this).findLastVisibleItemPosition();
            if (findFirstVisibleItemPosition == -1 || findLastVisibleItemPosition == -1) {
                return;
            }
            if (i4 >= findFirstVisibleItemPosition && i4 <= findLastVisibleItemPosition) {
                int i7 = i4 - findFirstVisibleItemPosition;
                if (getChildCount() > i7) {
                    int[] iArr2 = new int[2];
                    getChildAt(i7).getLocationOnScreen(iArr2);
                    scrollBy(0, (iArr2[1] - this.Pu) - i6);
                    return;
                }
                return;
            } else if (i4 > findLastVisibleItemPosition) {
                scrollBy(0, i5);
                a(i4, i5, i6);
                return;
            } else {
                scrollBy(0, -i5);
            }
        }
    }

    private void pO() {
        Rect rect = this.Pq;
        if (rect == null) {
            this.Pq = new Rect();
        } else {
            rect.setEmpty();
        }
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 0) {
                this.Pq.union(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            }
        }
    }

    private void pP() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter instanceof d) {
            ((d) adapter).pT();
        }
    }

    private void scrollToPositionWithOffset(int i4, int i5) {
        a(i4, getHeight(), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        pP();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.Pr != 0) {
            pO();
            Rect rect = this.Pq;
            if (rect != null && !rect.isEmpty()) {
                canvas.save();
                canvas.clipRect(this.Pq);
                canvas.drawColor(this.Pr);
                canvas.restore();
            }
        }
        super.onDraw(canvas);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Pw) {
            return false;
        }
        if (motionEvent.getAction() == 0 && this.Px) {
            stopScroll();
        }
        a aVar = this.Pv;
        if (aVar == null || !aVar.pQ()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i4, int i5) {
        int size = View.MeasureSpec.getSize(i5);
        int i6 = this.Ps;
        if (i6 > 0 && i6 < size) {
            i5 = View.MeasureSpec.makeMeasureSpec(this.Ps, View.MeasureSpec.getMode(i5));
        }
        super.onMeasure(i4, i5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Pw) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i4) {
        if (this.Pt) {
            scrollToPositionWithOffset(i4, 0);
        } else {
            super.scrollToPosition(i4);
        }
    }

    public void setDisableScroll(boolean z3) {
        this.Pw = z3;
    }

    public void setDownStop(boolean z3) {
        this.Px = z3;
    }

    public void setIgnoreTouchSwipeHandler(a aVar) {
        this.Pv = aVar;
    }

    public void setUnderneathColor(int i4) {
        this.Pr = i4;
        pO();
        invalidate();
    }

    public void setUseCustomScrollToPosition(boolean z3) {
        this.Pt = z3;
    }

    public b(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.Pu = Integer.MIN_VALUE;
        this.Px = false;
    }
}
