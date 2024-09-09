package cn.bluemobi.dylan.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class NoSlidingViewPager extends ViewPager {
    private boolean isCanScroll;

    public NoSlidingViewPager(Context context) {
        super(context);
        this.isCanScroll = false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.isCanScroll) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.isCanScroll) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    public void scrollTo(int i4, int i5) {
        super.scrollTo(i4, i5);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i4, boolean z3) {
        super.setCurrentItem(i4, z3);
    }

    public void setScanScroll(boolean z3) {
        this.isCanScroll = z3;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i4) {
        super.setCurrentItem(i4);
    }

    public NoSlidingViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isCanScroll = false;
    }
}
