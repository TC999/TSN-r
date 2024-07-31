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

/* renamed from: com.kwad.components.core.page.recycle.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8846b extends C8852g {

    /* renamed from: Pq */
    private Rect f28651Pq;

    /* renamed from: Pr */
    private int f28652Pr;

    /* renamed from: Ps */
    private int f28653Ps;

    /* renamed from: Pt */
    private boolean f28654Pt;

    /* renamed from: Pu */
    private int f28655Pu;

    /* renamed from: Pv */
    private InterfaceC8847a f28656Pv;

    /* renamed from: Pw */
    private boolean f28657Pw;

    /* renamed from: Px */
    private boolean f28658Px;

    /* renamed from: com.kwad.components.core.page.recycle.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8847a {
        /* renamed from: pQ */
        boolean m29745pQ();
    }

    public C8846b(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private void m29748a(int i, int i2, int i3) {
        while (true) {
            if (this.f28655Pu == Integer.MIN_VALUE) {
                int[] iArr = new int[2];
                getLocationOnScreen(iArr);
                this.f28655Pu = iArr[1];
            }
            int findFirstVisibleItemPosition = C8851f.m29738b(this).findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = C8851f.m29738b(this).findLastVisibleItemPosition();
            if (findFirstVisibleItemPosition == -1 || findLastVisibleItemPosition == -1) {
                return;
            }
            if (i >= findFirstVisibleItemPosition && i <= findLastVisibleItemPosition) {
                int i4 = i - findFirstVisibleItemPosition;
                if (getChildCount() > i4) {
                    int[] iArr2 = new int[2];
                    getChildAt(i4).getLocationOnScreen(iArr2);
                    scrollBy(0, (iArr2[1] - this.f28655Pu) - i3);
                    return;
                }
                return;
            } else if (i > findLastVisibleItemPosition) {
                scrollBy(0, i2);
                m29748a(i, i2, i3);
                return;
            } else {
                scrollBy(0, -i2);
            }
        }
    }

    /* renamed from: pO */
    private void m29747pO() {
        Rect rect = this.f28651Pq;
        if (rect == null) {
            this.f28651Pq = new Rect();
        } else {
            rect.setEmpty();
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                this.f28651Pq.union(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            }
        }
    }

    /* renamed from: pP */
    private void m29746pP() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter instanceof AbstractC8849d) {
            ((AbstractC8849d) adapter).m29740pT();
        }
    }

    private void scrollToPositionWithOffset(int i, int i2) {
        m29748a(i, getHeight(), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m29746pP();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f28652Pr != 0) {
            m29747pO();
            Rect rect = this.f28651Pq;
            if (rect != null && !rect.isEmpty()) {
                canvas.save();
                canvas.clipRect(this.f28651Pq);
                canvas.drawColor(this.f28652Pr);
                canvas.restore();
            }
        }
        super.onDraw(canvas);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f28657Pw) {
            return false;
        }
        if (motionEvent.getAction() == 0 && this.f28658Px) {
            stopScroll();
        }
        InterfaceC8847a interfaceC8847a = this.f28656Pv;
        if (interfaceC8847a == null || !interfaceC8847a.m29745pQ()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int i3 = this.f28653Ps;
        if (i3 > 0 && i3 < size) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.f28653Ps, View.MeasureSpec.getMode(i2));
        }
        super.onMeasure(i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f28657Pw) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i) {
        if (this.f28654Pt) {
            scrollToPositionWithOffset(i, 0);
        } else {
            super.scrollToPosition(i);
        }
    }

    public void setDisableScroll(boolean z) {
        this.f28657Pw = z;
    }

    public void setDownStop(boolean z) {
        this.f28658Px = z;
    }

    public void setIgnoreTouchSwipeHandler(InterfaceC8847a interfaceC8847a) {
        this.f28656Pv = interfaceC8847a;
    }

    public void setUnderneathColor(int i) {
        this.f28652Pr = i;
        m29747pO();
        invalidate();
    }

    public void setUseCustomScrollToPosition(boolean z) {
        this.f28654Pt = z;
    }

    public C8846b(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C8846b(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28655Pu = Integer.MIN_VALUE;
        this.f28658Px = false;
    }
}
