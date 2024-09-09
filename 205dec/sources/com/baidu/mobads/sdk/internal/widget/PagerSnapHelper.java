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
import com.baidu.mobads.sdk.internal.av;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class PagerSnapHelper extends SnapHelper {

    /* renamed from: a  reason: collision with root package name */
    private static final int f12934a = 100;

    /* renamed from: b  reason: collision with root package name */
    private static final float f12935b = 100.0f;

    /* renamed from: g  reason: collision with root package name */
    private static final boolean f12936g = av.a((Class<?>) OrientationHelper.class, "getLayoutManager", (Class<?>[]) new Class[0]);
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private OrientationHelper f12937c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView.LayoutManager f12938d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private OrientationHelper f12939e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView.LayoutManager f12940f;

    /* renamed from: h  reason: collision with root package name */
    private RecyclerView f12941h;

    @Nullable
    private OrientationHelper b(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return c(layoutManager);
        }
        if (layoutManager.canScrollHorizontally()) {
            return d(layoutManager);
        }
        return null;
    }

    @NonNull
    private OrientationHelper c(@NonNull RecyclerView.LayoutManager layoutManager) {
        if (this.f12937c == null || this.f12938d != layoutManager) {
            this.f12938d = layoutManager;
            this.f12937c = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.f12937c;
    }

    @NonNull
    private OrientationHelper d(@NonNull RecyclerView.LayoutManager layoutManager) {
        if (this.f12939e == null || this.f12940f != layoutManager) {
            this.f12940f = layoutManager;
            this.f12939e = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.f12939e;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        super.attachToRecyclerView(recyclerView);
        if (this.f12941h == recyclerView) {
            return;
        }
        this.f12941h = recyclerView;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @NonNull
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = a(layoutManager, view, d(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = a(layoutManager, view, c(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    protected LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager layoutManager) {
        RecyclerView recyclerView;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (recyclerView = this.f12941h) == null) {
            return null;
        }
        return new LinearSmoothScroller(recyclerView.getContext()) { // from class: com.baidu.mobads.sdk.internal.widget.PagerSnapHelper.1
            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 100.0f / displayMetrics.densityDpi;
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            protected int calculateTimeForScrolling(int i4) {
                return Math.min(100, super.calculateTimeForScrolling(i4));
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
            protected void onStop() {
                RecyclerView.LayoutManager layoutManager2;
                super.onStop();
                if (!PagerSnapHelper.f12936g || PagerSnapHelper.this.f12941h == null || PagerSnapHelper.this.f12941h.getScrollState() == 0 || (layoutManager2 = PagerSnapHelper.this.f12941h.getLayoutManager()) == null || layoutManager2.getChildCount() > 1) {
                    return;
                }
                PagerSnapHelper.this.f12941h.stopScroll();
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
            protected void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                if (PagerSnapHelper.this.f12941h == null || PagerSnapHelper.this.f12941h.getLayoutManager() == null) {
                    return;
                }
                PagerSnapHelper pagerSnapHelper = PagerSnapHelper.this;
                int[] calculateDistanceToFinalSnap = pagerSnapHelper.calculateDistanceToFinalSnap(pagerSnapHelper.f12941h.getLayoutManager(), view);
                int i4 = calculateDistanceToFinalSnap[0];
                int i5 = calculateDistanceToFinalSnap[1];
                int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i4), Math.abs(i5)));
                if (calculateTimeForDeceleration > 0) {
                    action.update(i4, i5, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                }
            }
        };
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return a(layoutManager, c(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return a(layoutManager, d(layoutManager));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i4, int i5) {
        OrientationHelper b4;
        int itemCount = layoutManager.getItemCount();
        if (itemCount == 0 || (b4 = b(layoutManager)) == null) {
            return -1;
        }
        int i6 = Integer.MIN_VALUE;
        int i7 = Integer.MAX_VALUE;
        int childCount = layoutManager.getChildCount();
        View view = null;
        View view2 = null;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = layoutManager.getChildAt(i8);
            if (childAt != null) {
                int a4 = a(layoutManager, childAt, b4);
                if (a4 <= 0 && a4 > i6) {
                    view2 = childAt;
                    i6 = a4;
                }
                if (a4 >= 0 && a4 < i7) {
                    view = childAt;
                    i7 = a4;
                }
            }
        }
        boolean a5 = a(layoutManager, i4, i5);
        if (!a5 || view == null) {
            if (a5 || view2 == null) {
                if (a5) {
                    view = view2;
                }
                if (view == null) {
                    return -1;
                }
                int position = layoutManager.getPosition(view) + (a(layoutManager) == a5 ? -1 : 1);
                if (position < 0 || position >= itemCount) {
                    return -1;
                }
                return position;
            }
            return layoutManager.getPosition(view2);
        }
        return layoutManager.getPosition(view);
    }

    private boolean a(RecyclerView.LayoutManager layoutManager, int i4, int i5) {
        return layoutManager.canScrollHorizontally() ? i4 > 0 : i5 > 0;
    }

    private boolean a(RecyclerView.LayoutManager layoutManager) {
        PointF computeScrollVectorForPosition;
        int itemCount = layoutManager.getItemCount();
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (computeScrollVectorForPosition = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return false;
        }
        return computeScrollVectorForPosition.x < 0.0f || computeScrollVectorForPosition.y < 0.0f;
    }

    private int a(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view, OrientationHelper orientationHelper) {
        return (orientationHelper.getDecoratedStart(view) + (orientationHelper.getDecoratedMeasurement(view) / 2)) - (orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2));
    }

    @Nullable
    private View a(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int childCount = layoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int startAfterPadding = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
        int i4 = Integer.MAX_VALUE;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = layoutManager.getChildAt(i5);
            int abs = Math.abs((orientationHelper.getDecoratedStart(childAt) + (orientationHelper.getDecoratedMeasurement(childAt) / 2)) - startAfterPadding);
            if (abs < i4) {
                view = childAt;
                i4 = abs;
            }
        }
        return view;
    }
}
