package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class d extends ViewPager {
    private int aSQ;
    private boolean aSR;

    public d(@NonNull Context context) {
        super(context);
        this.aSR = false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean canScrollHorizontally(int i4) {
        if (this.aSR) {
            return super.canScrollHorizontally(i4);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.aSR) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int x3 = (int) motionEvent.getX();
        int action = motionEvent.getAction();
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2) {
            int i4 = x3 - this.aSQ;
            if (getCurrentItem() == 0 && i4 > 0) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        this.aSQ = x3;
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.aSR && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.aSR && super.onTouchEvent(motionEvent);
    }

    public void setScrollable(boolean z3) {
        this.aSR = z3;
    }

    public d(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aSR = false;
    }
}
