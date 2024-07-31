package com.kwad.components.core.page.recycle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.kwad.components.core.p330s.RunnableC8957o;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.utils.C11124s;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DetailWebRecycleView extends C8846b {

    /* renamed from: PA */
    private boolean f28627PA;

    /* renamed from: PB */
    private int f28628PB;

    /* renamed from: PC */
    private int f28629PC;

    /* renamed from: PD */
    private boolean f28630PD;

    /* renamed from: PE */
    InterfaceC8844a f28631PE;

    /* renamed from: PF */
    private Runnable f28632PF;

    /* renamed from: PG */
    private RunnableC8957o f28633PG;

    /* renamed from: Py */
    private int f28634Py;

    /* renamed from: Pz */
    private boolean f28635Pz;

    /* renamed from: mf */
    private int f28636mf;

    /* renamed from: com.kwad.components.core.page.recycle.DetailWebRecycleView$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8844a {
        /* renamed from: pR */
        boolean m29756pR();
    }

    public DetailWebRecycleView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        postDelayed(this.f28633PG, 50L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.core.page.recycle.C8846b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f28633PG);
    }

    @Override // com.kwad.components.core.page.recycle.C8846b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterfaceC8844a interfaceC8844a = this.f28631PE;
        if (interfaceC8844a == null || !interfaceC8844a.m29756pR()) {
            this.f28629PC = computeVerticalScrollOffset();
            if (motionEvent.getY() <= this.f28628PB - this.f28629PC) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        this.f28629PC = computeVerticalScrollOffset;
        if (computeVerticalScrollOffset >= this.f28628PB) {
            return false;
        }
        fling((int) f, (int) f2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        this.f28629PC = computeVerticalScrollOffset;
        if ((i2 > 0 && computeVerticalScrollOffset < this.f28628PB) && !this.f28630PD && computeVerticalScrollOffset < this.f28636mf) {
            scrollBy(0, i2);
            iArr[1] = i2;
        }
        if (i2 < 0 && this.f28629PC > 0 && !ViewCompat.canScrollVertically(view, -1)) {
            scrollBy(0, i2);
            iArr[1] = i2;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i) {
        super.onScrollStateChanged(i);
        if (i == 0) {
            View childAt = getLayoutManager().getChildAt(getLayoutManager().getChildCount() - 1);
            if (childAt != null) {
                int bottom = childAt.getBottom();
                int bottom2 = getBottom() - getPaddingBottom();
                int position = getLayoutManager().getPosition(childAt);
                if (bottom == bottom2 && position == getLayoutManager().getItemCount() - 1) {
                    this.f28630PD = true;
                    return;
                }
            }
            this.f28630PD = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.f28627PA) {
            this.f28627PA = false;
        } else if (this.f28635Pz) {
        } else {
            super.requestChildFocus(view, view2);
        }
    }

    public void setInterceptRequestFocusForWeb(boolean z) {
        this.f28635Pz = z;
    }

    public void setInterceptRequestFocusForWebFiredOnce(boolean z) {
        this.f28627PA = z;
    }

    public void setInterceptTouchListener(InterfaceC8844a interfaceC8844a) {
        this.f28631PE = interfaceC8844a;
    }

    public void setTopViewHeight(int i) {
        this.f28628PB = i;
    }

    public DetailWebRecycleView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DetailWebRecycleView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28634Py = 1000;
        this.f28635Pz = false;
        this.f28627PA = false;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.page.recycle.DetailWebRecycleView.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Object field = C11124s.getField(DetailWebRecycleView.this, "mGapWorker");
                    if (field != null) {
                        C11124s.callMethod(field, "postFromTraversal", DetailWebRecycleView.this, 0, Integer.valueOf(DetailWebRecycleView.this.f28634Py));
                    }
                } catch (RuntimeException e) {
                    C10331c.printStackTraceOnly(e);
                }
            }
        };
        this.f28632PF = runnable;
        this.f28633PG = new RunnableC8957o(runnable);
        if (context instanceof Activity) {
            this.f28636mf = C10751a.m24911e((Activity) context);
        } else {
            this.f28636mf = C10751a.getScreenHeight(context);
        }
    }
}
