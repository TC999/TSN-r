package com.baidu.mobads.sdk.internal.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
final class FakeDrag {

    /* renamed from: a */
    private final ViewPager2 f9138a;

    /* renamed from: b */
    private final ScrollEventAdapter f9139b;

    /* renamed from: c */
    private final RecyclerView f9140c;

    /* renamed from: d */
    private VelocityTracker f9141d;

    /* renamed from: e */
    private int f9142e;

    /* renamed from: f */
    private float f9143f;

    /* renamed from: g */
    private int f9144g;

    /* renamed from: h */
    private long f9145h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FakeDrag(ViewPager2 viewPager2, ScrollEventAdapter scrollEventAdapter, RecyclerView recyclerView) {
        this.f9138a = viewPager2;
        this.f9139b = scrollEventAdapter;
        this.f9140c = recyclerView;
    }

    /* renamed from: d */
    private void m50285d() {
        VelocityTracker velocityTracker = this.f9141d;
        if (velocityTracker == null) {
            this.f9141d = VelocityTracker.obtain();
            this.f9142e = ViewConfiguration.get(this.f9138a.getContext()).getScaledMaximumFlingVelocity();
            return;
        }
        velocityTracker.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m50290a() {
        return this.f9139b.m50258g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @UiThread
    /* renamed from: b */
    public boolean m50287b() {
        if (this.f9139b.m50259f()) {
            return false;
        }
        this.f9144g = 0;
        this.f9143f = 0;
        this.f9145h = SystemClock.uptimeMillis();
        m50285d();
        this.f9139b.m50264b();
        if (!this.f9139b.m50260e()) {
            this.f9140c.stopScroll();
        }
        m50288a(this.f9145h, 0, 0.0f, 0.0f);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @UiThread
    /* renamed from: c */
    public boolean m50286c() {
        if (this.f9139b.m50258g()) {
            this.f9139b.m50262c();
            VelocityTracker velocityTracker = this.f9141d;
            velocityTracker.computeCurrentVelocity(1000, this.f9142e);
            if (this.f9140c.fling((int) velocityTracker.getXVelocity(), (int) velocityTracker.getYVelocity())) {
                return true;
            }
            this.f9138a.m50243d();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @UiThread
    /* renamed from: a */
    public boolean m50289a(float f) {
        if (this.f9139b.m50258g()) {
            float f2 = this.f9143f - f;
            this.f9143f = f2;
            int round = Math.round(f2 - this.f9144g);
            this.f9144g += round;
            long uptimeMillis = SystemClock.uptimeMillis();
            boolean z = this.f9138a.getOrientation() == 0;
            int i = z ? round : 0;
            int i2 = z ? 0 : round;
            float f3 = z ? this.f9143f : 0.0f;
            float f4 = z ? 0.0f : this.f9143f;
            this.f9140c.scrollBy(i, i2);
            m50288a(uptimeMillis, 2, f3, f4);
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private void m50288a(long j, int i, float f, float f2) {
        MotionEvent obtain = MotionEvent.obtain(this.f9145h, j, i, f, f2, 0);
        this.f9141d.addMovement(obtain);
        obtain.recycle();
    }
}
