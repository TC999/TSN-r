package androidx.viewpager2.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class FakeDrag {
    private int mActualDraggedDistance;
    private long mFakeDragBeginTime;
    private int mMaximumVelocity;
    private final RecyclerView mRecyclerView;
    private float mRequestedDragDistance;
    private final ScrollEventAdapter mScrollEventAdapter;
    private VelocityTracker mVelocityTracker;
    private final ViewPager2 mViewPager;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FakeDrag(ViewPager2 viewPager2, ScrollEventAdapter scrollEventAdapter, RecyclerView recyclerView) {
        this.mViewPager = viewPager2;
        this.mScrollEventAdapter = scrollEventAdapter;
        this.mRecyclerView = recyclerView;
    }

    private void addFakeMotionEvent(long j4, int i4, float f4, float f5) {
        MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, j4, i4, f4, f5, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
    }

    private void beginFakeVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
            this.mMaximumVelocity = ViewConfiguration.get(this.mViewPager.getContext()).getScaledMaximumFlingVelocity();
            return;
        }
        velocityTracker.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @UiThread
    public boolean beginFakeDrag() {
        if (this.mScrollEventAdapter.isDragging()) {
            return false;
        }
        this.mActualDraggedDistance = 0;
        this.mRequestedDragDistance = 0;
        this.mFakeDragBeginTime = SystemClock.uptimeMillis();
        beginFakeVelocityTracker();
        this.mScrollEventAdapter.notifyBeginFakeDrag();
        if (!this.mScrollEventAdapter.isIdle()) {
            this.mRecyclerView.stopScroll();
        }
        addFakeMotionEvent(this.mFakeDragBeginTime, 0, 0.0f, 0.0f);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @UiThread
    public boolean endFakeDrag() {
        if (this.mScrollEventAdapter.isFakeDragging()) {
            this.mScrollEventAdapter.notifyEndFakeDrag();
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
            if (this.mRecyclerView.fling((int) velocityTracker.getXVelocity(), (int) velocityTracker.getYVelocity())) {
                return true;
            }
            this.mViewPager.snapToPage();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @UiThread
    public boolean fakeDragBy(float f4) {
        if (this.mScrollEventAdapter.isFakeDragging()) {
            float f5 = this.mRequestedDragDistance - f4;
            this.mRequestedDragDistance = f5;
            int round = Math.round(f5 - this.mActualDraggedDistance);
            this.mActualDraggedDistance += round;
            long uptimeMillis = SystemClock.uptimeMillis();
            boolean z3 = this.mViewPager.getOrientation() == 0;
            int i4 = z3 ? round : 0;
            int i5 = z3 ? 0 : round;
            float f6 = z3 ? this.mRequestedDragDistance : 0.0f;
            float f7 = z3 ? 0.0f : this.mRequestedDragDistance;
            this.mRecyclerView.scrollBy(i4, i5);
            addFakeMotionEvent(uptimeMillis, 2, f6, f7);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isFakeDragging() {
        return this.mScrollEventAdapter.isFakeDragging();
    }
}
