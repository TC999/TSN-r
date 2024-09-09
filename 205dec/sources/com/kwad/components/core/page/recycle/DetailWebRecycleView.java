package com.kwad.components.core.page.recycle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.kwad.components.core.s.o;
import com.kwad.sdk.utils.s;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class DetailWebRecycleView extends b {
    private boolean PA;
    private int PB;
    private int PC;
    private boolean PD;
    a PE;
    private Runnable PF;
    private o PG;
    private int Py;
    private boolean Pz;
    private int mf;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        boolean pR();
    }

    public DetailWebRecycleView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        postDelayed(this.PG, 50L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.PG);
    }

    @Override // com.kwad.components.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a aVar = this.PE;
        if (aVar == null || !aVar.pR()) {
            this.PC = computeVerticalScrollOffset();
            if (motionEvent.getY() <= this.PB - this.PC) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f4, float f5) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        this.PC = computeVerticalScrollOffset;
        if (computeVerticalScrollOffset >= this.PB) {
            return false;
        }
        fling((int) f4, (int) f5);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i4, int i5, int[] iArr) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        this.PC = computeVerticalScrollOffset;
        if ((i5 > 0 && computeVerticalScrollOffset < this.PB) && !this.PD && computeVerticalScrollOffset < this.mf) {
            scrollBy(0, i5);
            iArr[1] = i5;
        }
        if (i5 < 0 && this.PC > 0 && !ViewCompat.canScrollVertically(view, -1)) {
            scrollBy(0, i5);
            iArr[1] = i5;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i4) {
        super.onScrollStateChanged(i4);
        if (i4 == 0) {
            View childAt = getLayoutManager().getChildAt(getLayoutManager().getChildCount() - 1);
            if (childAt != null) {
                int bottom = childAt.getBottom();
                int bottom2 = getBottom() - getPaddingBottom();
                int position = getLayoutManager().getPosition(childAt);
                if (bottom == bottom2 && position == getLayoutManager().getItemCount() - 1) {
                    this.PD = true;
                    return;
                }
            }
            this.PD = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i4) {
        return (i4 & 2) != 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.PA) {
            this.PA = false;
        } else if (this.Pz) {
        } else {
            super.requestChildFocus(view, view2);
        }
    }

    public void setInterceptRequestFocusForWeb(boolean z3) {
        this.Pz = z3;
    }

    public void setInterceptRequestFocusForWebFiredOnce(boolean z3) {
        this.PA = z3;
    }

    public void setInterceptTouchListener(a aVar) {
        this.PE = aVar;
    }

    public void setTopViewHeight(int i4) {
        this.PB = i4;
    }

    public DetailWebRecycleView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DetailWebRecycleView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.Py = 1000;
        this.Pz = false;
        this.PA = false;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.page.recycle.DetailWebRecycleView.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Object field = s.getField(DetailWebRecycleView.this, "mGapWorker");
                    if (field != null) {
                        s.callMethod(field, "postFromTraversal", DetailWebRecycleView.this, 0, Integer.valueOf(DetailWebRecycleView.this.Py));
                    }
                } catch (RuntimeException e4) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
                }
            }
        };
        this.PF = runnable;
        this.PG = new o(runnable);
        if (context instanceof Activity) {
            this.mf = com.kwad.sdk.d.a.a.e((Activity) context);
        } else {
            this.mf = com.kwad.sdk.d.a.a.getScreenHeight(context);
        }
    }
}
