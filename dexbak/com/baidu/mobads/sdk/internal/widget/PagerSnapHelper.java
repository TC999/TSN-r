package com.baidu.mobads.sdk.internal.widget;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.baidu.mobads.sdk.internal.C2603as;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class PagerSnapHelper extends SnapHelper {

    /* renamed from: a */
    private static final int f9148a = 100;

    /* renamed from: b */
    private static final float f9149b = 100.0f;

    /* renamed from: g */
    private static final boolean f9150g = C2603as.m50959a((Class<?>) OrientationHelper.class, "getLayoutManager", (Class<?>[]) new Class[0]);
    @Nullable

    /* renamed from: c */
    private OrientationHelper f9151c;
    @Nullable

    /* renamed from: d */
    private RecyclerView.LayoutManager f9152d;
    @Nullable

    /* renamed from: e */
    private OrientationHelper f9153e;
    @Nullable

    /* renamed from: f */
    private RecyclerView.LayoutManager f9154f;

    /* renamed from: h */
    private RecyclerView f9155h;

    @Nullable
    /* renamed from: b */
    private OrientationHelper m50276b(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return m50275c(layoutManager);
        }
        if (layoutManager.canScrollHorizontally()) {
            return m50274d(layoutManager);
        }
        return null;
    }

    @NonNull
    /* renamed from: c */
    private OrientationHelper m50275c(@NonNull RecyclerView.LayoutManager layoutManager) {
        if (this.f9151c == null || this.f9152d != layoutManager) {
            this.f9152d = layoutManager;
            this.f9151c = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.f9151c;
    }

    @NonNull
    /* renamed from: d */
    private OrientationHelper m50274d(@NonNull RecyclerView.LayoutManager layoutManager) {
        if (this.f9153e == null || this.f9154f != layoutManager) {
            this.f9154f = layoutManager;
            this.f9153e = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.f9153e;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        super.attachToRecyclerView(recyclerView);
        if (this.f9155h == recyclerView) {
            return;
        }
        this.f9155h = recyclerView;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @NonNull
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = m50279a(layoutManager, view, m50274d(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = m50279a(layoutManager, view, m50275c(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    protected LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager layoutManager) {
        RecyclerView recyclerView;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (recyclerView = this.f9155h) == null) {
            return null;
        }
        return new LinearSmoothScroller(recyclerView.getContext()) { // from class: com.baidu.mobads.sdk.internal.widget.PagerSnapHelper.1
            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 100.0f / displayMetrics.densityDpi;
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            protected int calculateTimeForScrolling(int i) {
                return Math.min(100, super.calculateTimeForScrolling(i));
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
            protected void onStop() {
                RecyclerView.LayoutManager layoutManager2;
                super.onStop();
                if (!PagerSnapHelper.f9150g || PagerSnapHelper.this.f9155h == null || PagerSnapHelper.this.f9155h.getScrollState() == 0 || (layoutManager2 = PagerSnapHelper.this.f9155h.getLayoutManager()) == null || layoutManager2.getChildCount() > 1) {
                    return;
                }
                PagerSnapHelper.this.f9155h.stopScroll();
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
            protected void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                if (PagerSnapHelper.this.f9155h == null || PagerSnapHelper.this.f9155h.getLayoutManager() == null) {
                    return;
                }
                PagerSnapHelper pagerSnapHelper = PagerSnapHelper.this;
                int[] calculateDistanceToFinalSnap = pagerSnapHelper.calculateDistanceToFinalSnap(pagerSnapHelper.f9155h.getLayoutManager(), view);
                int i = calculateDistanceToFinalSnap[0];
                int i2 = calculateDistanceToFinalSnap[1];
                int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                if (calculateTimeForDeceleration > 0) {
                    action.update(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                }
            }
        };
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return m50278a(layoutManager, m50275c(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return m50278a(layoutManager, m50274d(layoutManager));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        OrientationHelper m50276b;
        int itemCount = layoutManager.getItemCount();
        if (itemCount == 0 || (m50276b = m50276b(layoutManager)) == null) {
            return -1;
        }
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MAX_VALUE;
        int childCount = layoutManager.getChildCount();
        View view = null;
        View view2 = null;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = layoutManager.getChildAt(i5);
            if (childAt != null) {
                int m50279a = m50279a(layoutManager, childAt, m50276b);
                if (m50279a <= 0 && m50279a > i3) {
                    view2 = childAt;
                    i3 = m50279a;
                }
                if (m50279a >= 0 && m50279a < i4) {
                    view = childAt;
                    i4 = m50279a;
                }
            }
        }
        boolean m50280a = m50280a(layoutManager, i, i2);
        if (!m50280a || view == null) {
            if (m50280a || view2 == null) {
                if (m50280a) {
                    view = view2;
                }
                if (view == null) {
                    return -1;
                }
                int position = layoutManager.getPosition(view) + (m50281a(layoutManager) == m50280a ? -1 : 1);
                if (position < 0 || position >= itemCount) {
                    return -1;
                }
                return position;
            }
            return layoutManager.getPosition(view2);
        }
        return layoutManager.getPosition(view);
    }

    /* renamed from: a */
    private boolean m50280a(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        return layoutManager.canScrollHorizontally() ? i > 0 : i2 > 0;
    }

    /* renamed from: a */
    private boolean m50281a(RecyclerView.LayoutManager layoutManager) {
        PointF computeScrollVectorForPosition;
        int itemCount = layoutManager.getItemCount();
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (computeScrollVectorForPosition = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return false;
        }
        return computeScrollVectorForPosition.x < 0.0f || computeScrollVectorForPosition.y < 0.0f;
    }

    /* renamed from: a */
    private int m50279a(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view, OrientationHelper orientationHelper) {
        return (orientationHelper.getDecoratedStart(view) + (orientationHelper.getDecoratedMeasurement(view) / 2)) - (orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2));
    }

    @Nullable
    /* renamed from: a */
    private View m50278a(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int childCount = layoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int startAfterPadding = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = layoutManager.getChildAt(i2);
            int abs = Math.abs((orientationHelper.getDecoratedStart(childAt) + (orientationHelper.getDecoratedMeasurement(childAt) / 2)) - startAfterPadding);
            if (abs < i) {
                view = childAt;
                i = abs;
            }
        }
        return view;
    }
}
