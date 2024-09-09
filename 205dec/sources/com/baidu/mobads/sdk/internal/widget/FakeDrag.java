package com.baidu.mobads.sdk.internal.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
final class FakeDrag {

    /* renamed from: a  reason: collision with root package name */
    private final ViewPager2 f12924a;

    /* renamed from: b  reason: collision with root package name */
    private final ScrollEventAdapter f12925b;

    /* renamed from: c  reason: collision with root package name */
    private final RecyclerView f12926c;

    /* renamed from: d  reason: collision with root package name */
    private VelocityTracker f12927d;

    /* renamed from: e  reason: collision with root package name */
    private int f12928e;

    /* renamed from: f  reason: collision with root package name */
    private float f12929f;

    /* renamed from: g  reason: collision with root package name */
    private int f12930g;

    /* renamed from: h  reason: collision with root package name */
    private long f12931h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FakeDrag(ViewPager2 viewPager2, ScrollEventAdapter scrollEventAdapter, RecyclerView recyclerView) {
        this.f12924a = viewPager2;
        this.f12925b = scrollEventAdapter;
        this.f12926c = recyclerView;
    }

    private void d() {
        VelocityTracker velocityTracker = this.f12927d;
        if (velocityTracker == null) {
            this.f12927d = VelocityTracker.obtain();
            this.f12928e = ViewConfiguration.get(this.f12924a.getContext()).getScaledMaximumFlingVelocity();
            return;
        }
        velocityTracker.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.f12925b.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @UiThread
    public boolean b() {
        if (this.f12925b.f()) {
            return false;
        }
        this.f12930g = 0;
        this.f12929f = 0;
        this.f12931h = SystemClock.uptimeMillis();
        d();
        this.f12925b.b();
        if (!this.f12925b.e()) {
            this.f12926c.stopScroll();
        }
        a(this.f12931h, 0, 0.0f, 0.0f);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @UiThread
    public boolean c() {
        if (this.f12925b.g()) {
            this.f12925b.c();
            VelocityTracker velocityTracker = this.f12927d;
            velocityTracker.computeCurrentVelocity(1000, this.f12928e);
            if (this.f12926c.fling((int) velocityTracker.getXVelocity(), (int) velocityTracker.getYVelocity())) {
                return true;
            }
            this.f12924a.d();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @UiThread
    public boolean a(float f4) {
        if (this.f12925b.g()) {
            float f5 = this.f12929f - f4;
            this.f12929f = f5;
            int round = Math.round(f5 - this.f12930g);
            this.f12930g += round;
            long uptimeMillis = SystemClock.uptimeMillis();
            boolean z3 = this.f12924a.getOrientation() == 0;
            int i4 = z3 ? round : 0;
            int i5 = z3 ? 0 : round;
            float f6 = z3 ? this.f12929f : 0.0f;
            float f7 = z3 ? 0.0f : this.f12929f;
            this.f12926c.scrollBy(i4, i5);
            a(uptimeMillis, 2, f6, f7);
            return true;
        }
        return false;
    }

    private void a(long j4, int i4, float f4, float f5) {
        MotionEvent obtain = MotionEvent.obtain(this.f12931h, j4, i4, f4, f5, 0);
        this.f12927d.addMovement(obtain);
        obtain.recycle();
    }
}
