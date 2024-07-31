package com.mcxtzhang.swipemenulib;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class CstViewPager extends ViewPager {

    /* renamed from: c */
    private static final String f32626c = "zxt/CstViewPager";

    /* renamed from: a */
    private int f32627a;

    /* renamed from: b */
    private int f32628b;

    public CstViewPager(Context context) {
        super(context);
    }

    /* renamed from: b */
    private boolean m20506b(int i, int i2) {
        return Math.abs(i2 - this.f32628b) < Math.abs(i - this.f32627a);
    }

    /* renamed from: h */
    private boolean m20505h() {
        PagerAdapter adapter = getAdapter();
        return adapter != null && adapter.getCount() - 1 == getCurrentItem();
    }

    /* renamed from: i */
    private boolean m20504i() {
        return getCurrentItem() == 0;
    }

    /* renamed from: j */
    private boolean m20503j(int i) {
        return i - this.f32627a < 0;
    }

    /* renamed from: k */
    private boolean m20502k(int i) {
        return i - this.f32627a > 0;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        boolean z = motionEvent.getAction() == 2 && m20506b(x, y) && !((m20504i() && m20502k(x)) || (m20505h() && m20503j(x)));
        this.f32627a = x;
        this.f32628b = y;
        return z || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public CstViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
