package com.mcxtzhang.swipemenulib;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class CstViewPager extends ViewPager {

    /* renamed from: c  reason: collision with root package name */
    private static final String f41313c = "zxt/CstViewPager";

    /* renamed from: a  reason: collision with root package name */
    private int f41314a;

    /* renamed from: b  reason: collision with root package name */
    private int f41315b;

    public CstViewPager(Context context) {
        super(context);
    }

    private boolean b(int i4, int i5) {
        return Math.abs(i5 - this.f41315b) < Math.abs(i4 - this.f41314a);
    }

    private boolean h() {
        PagerAdapter adapter = getAdapter();
        return adapter != null && adapter.getCount() - 1 == getCurrentItem();
    }

    private boolean i() {
        return getCurrentItem() == 0;
    }

    private boolean j(int i4) {
        return i4 - this.f41314a < 0;
    }

    private boolean k(int i4) {
        return i4 - this.f41314a > 0;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int x3 = (int) motionEvent.getX();
        int y3 = (int) motionEvent.getY();
        boolean z3 = motionEvent.getAction() == 2 && b(x3, y3) && !((i() && k(x3)) || (h() && j(x3)));
        this.f41314a = x3;
        this.f41315b = y3;
        return z3 || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public CstViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
