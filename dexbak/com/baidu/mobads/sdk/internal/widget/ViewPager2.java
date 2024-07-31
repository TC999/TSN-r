package com.baidu.mobads.sdk.internal.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.IntRange;
import androidx.annotation.InterfaceC0075Px;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.internal.concrete.ViewCompatDelegate;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ViewPager2 extends ViewGroup {

    /* renamed from: a */
    public static final int f9187a = 0;

    /* renamed from: b */
    public static final int f9188b = 1;

    /* renamed from: c */
    public static final int f9189c = 0;

    /* renamed from: d */
    public static final int f9190d = 1;

    /* renamed from: e */
    public static final int f9191e = 2;

    /* renamed from: f */
    public static final int f9192f = -1;

    /* renamed from: g */
    static boolean f9193g = true;

    /* renamed from: A */
    private boolean f9194A;

    /* renamed from: B */
    private int f9195B;

    /* renamed from: h */
    int f9196h;

    /* renamed from: i */
    boolean f9197i;

    /* renamed from: j */
    RecyclerView f9198j;

    /* renamed from: k */
    ScrollEventAdapter f9199k;

    /* renamed from: l */
    AccessibilityProvider f9200l;

    /* renamed from: m */
    private final Rect f9201m;

    /* renamed from: n */
    private final Rect f9202n;

    /* renamed from: o */
    private final int[] f9203o;

    /* renamed from: p */
    private CompositeOnPageChangeCallback f9204p;

    /* renamed from: q */
    private RecyclerView.AdapterDataObserver f9205q;

    /* renamed from: r */
    private LinearLayoutManager f9206r;

    /* renamed from: s */
    private int f9207s;

    /* renamed from: t */
    private Parcelable f9208t;

    /* renamed from: u */
    private PagerSnapHelper f9209u;

    /* renamed from: v */
    private CompositeOnPageChangeCallback f9210v;

    /* renamed from: w */
    private FakeDrag f9211w;

    /* renamed from: x */
    private PageTransformerAdapter f9212x;

    /* renamed from: y */
    private RecyclerView.ItemAnimator f9213y;

    /* renamed from: z */
    private boolean f9214z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public abstract class AccessibilityProvider {
        private AccessibilityProvider() {
        }

        /* renamed from: a */
        void m50238a(@NonNull AccessibilityEvent accessibilityEvent) {
        }

        /* renamed from: a */
        void m50237a(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        /* renamed from: a */
        void m50236a(@Nullable RecyclerView.Adapter<?> adapter) {
        }

        /* renamed from: a */
        void m50235a(@NonNull CompositeOnPageChangeCallback compositeOnPageChangeCallback, @NonNull RecyclerView recyclerView) {
        }

        /* renamed from: a */
        boolean m50240a() {
            return false;
        }

        /* renamed from: a */
        boolean m50239a(int i, Bundle bundle) {
            return false;
        }

        /* renamed from: b */
        String m50234b() {
            throw new IllegalStateException("Not implemented.");
        }

        /* renamed from: b */
        void m50232b(@Nullable RecyclerView.Adapter<?> adapter) {
        }

        /* renamed from: c */
        void m50231c() {
        }

        /* renamed from: d */
        void m50230d() {
        }

        /* renamed from: e */
        void m50229e() {
        }

        /* renamed from: f */
        void m50228f() {
        }

        /* renamed from: g */
        void m50227g() {
        }

        boolean handlesLmPerformAccessibilityAction(int i) {
            return false;
        }

        boolean handlesRvGetAccessibilityClassName() {
            return false;
        }

        void onLmInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        boolean onLmPerformAccessibilityAction(int i) {
            throw new IllegalStateException("Not implemented.");
        }

        CharSequence onRvGetAccessibilityClassName() {
            throw new IllegalStateException("Not implemented.");
        }

        /* renamed from: b */
        boolean m50233b(int i, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class BasicAccessibilityProvider extends AccessibilityProvider {
        BasicAccessibilityProvider() {
            super();
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public boolean handlesLmPerformAccessibilityAction(int i) {
            return (i == 8192 || i == 4096) && !ViewPager2.this.isUserInputEnabled();
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public boolean handlesRvGetAccessibilityClassName() {
            return true;
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public void onLmInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (ViewPager2.this.isUserInputEnabled()) {
                return;
            }
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfoCompat.setScrollable(false);
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public boolean onLmPerformAccessibilityAction(int i) {
            if (handlesLmPerformAccessibilityAction(i)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public CharSequence onRvGetAccessibilityClassName() {
            if (handlesRvGetAccessibilityClassName()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int i, int i2, int i3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
            onChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class LinearLayoutManagerImpl extends LinearLayoutManager {
        LinearLayoutManagerImpl(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public int getExtraLayoutSpace(RecyclerView.State state) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                return super.getExtraLayoutSpace(state);
            }
            return ViewPager2.this.m50246b() * offscreenPageLimit;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
            ViewPager2.this.f9200l.onLmInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean performAccessibilityAction(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, int i, @Nullable Bundle bundle) {
            if (ViewPager2.this.f9200l.handlesLmPerformAccessibilityAction(i)) {
                return ViewPager2.this.f9200l.onLmPerformAccessibilityAction(i);
            }
            return super.performAccessibilityAction(recycler, state, i, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z, boolean z2) {
            return false;
        }
    }

    @IntRange(from = 1)
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public @interface OffscreenPageLimit {
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnOverScrollListener {
        void onOverScrollEnd();

        void onOverScrollStart();
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static abstract class OnPageChangeCallback {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, @InterfaceC0075Px int i2) {
        }

        public void onPageSelected(int i) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public @interface Orientation {
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface PageTransformer {
        void transformPage(@NonNull View view, float f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class PagerSnapHelperImpl extends PagerSnapHelper {
        PagerSnapHelperImpl() {
        }

        @Override // com.baidu.mobads.sdk.internal.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
        @Nullable
        public View findSnapView(RecyclerView.LayoutManager layoutManager) {
            if (ViewPager2.this.isFakeDragging()) {
                return null;
            }
            return super.findSnapView(layoutManager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class RecyclerViewImpl extends RecyclerView {
        RecyclerViewImpl(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, androidx.core.view.NestedScrollingChild2
        public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
            ViewPager2.this.f9203o[1] = ViewPager2.this.f9203o[0];
            if (1 == ViewPager2.this.getOrientation()) {
                ViewPager2.this.f9203o[0] = i4;
            } else {
                ViewPager2.this.f9203o[0] = i3;
            }
            return super.dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        @RequiresApi(23)
        public CharSequence getAccessibilityClassName() {
            if (ViewPager2.this.f9200l.handlesRvGetAccessibilityClassName()) {
                return ViewPager2.this.f9200l.onRvGetAccessibilityClassName();
            }
            return super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f9196h);
            accessibilityEvent.setToIndex(ViewPager2.this.f9196h);
            ViewPager2.this.f9200l.m50238a(accessibilityEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.isUserInputEnabled() && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.isUserInputEnabled() && super.onTouchEvent(motionEvent);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public @interface ScrollState {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class SmoothScrollToPosition implements Runnable {

        /* renamed from: a */
        private final int f9233a;

        /* renamed from: b */
        private final RecyclerView f9234b;

        SmoothScrollToPosition(int i, RecyclerView recyclerView) {
            this.f9233a = i;
            this.f9234b = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f9234b.smoothScrollToPosition(this.f9233a);
        }
    }

    public ViewPager2(@NonNull Context context) {
        super(context);
        this.f9201m = new Rect();
        this.f9202n = new Rect();
        this.f9203o = new int[2];
        this.f9204p = new CompositeOnPageChangeCallback(3);
        this.f9197i = false;
        this.f9205q = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f9197i = true;
                viewPager2.f9199k.m50270a();
            }
        };
        this.f9207s = -1;
        this.f9213y = null;
        this.f9214z = false;
        this.f9194A = true;
        this.f9195B = -1;
        m50249a(context, (AttributeSet) null);
    }

    /* renamed from: b */
    private void m50245b(@Nullable RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.f9205q);
        }
    }

    /* renamed from: e */
    private RecyclerView.OnChildAttachStateChangeListener m50242e() {
        return new RecyclerView.OnChildAttachStateChangeListener() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewAttachedToWindow(@NonNull View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) layoutParams).width != -1 || ((ViewGroup.MarginLayoutParams) layoutParams).height != -1) {
                    throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewDetachedFromWindow(@NonNull View view) {
            }
        };
    }

    /* renamed from: f */
    private void m50241f() {
        RecyclerView.Adapter adapter;
        if (this.f9207s == -1 || (adapter = getAdapter()) == null) {
            return;
        }
        Parcelable parcelable = this.f9208t;
        if (parcelable != null) {
            if (adapter instanceof StatefulAdapter) {
                ((StatefulAdapter) adapter).restoreState(parcelable);
            }
            this.f9208t = null;
        }
        int max = Math.max(0, Math.min(this.f9207s, adapter.getItemCount() - 1));
        this.f9196h = max;
        this.f9207s = -1;
        this.f9198j.scrollToPosition(max);
        this.f9200l.m50231c();
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        this.f9198j.addItemDecoration(itemDecoration);
    }

    public boolean beginFakeDrag() {
        return this.f9211w.m50287b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean m50244c() {
        return this.f9206r.getLayoutDirection() == 1;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        return this.f9198j.canScrollHorizontally(i);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        return this.f9198j.canScrollVertically(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public void m50243d() {
        View findSnapView = this.f9209u.findSnapView(this.f9206r);
        if (findSnapView == null) {
            return;
        }
        int[] calculateDistanceToFinalSnap = this.f9209u.calculateDistanceToFinalSnap(this.f9206r, findSnapView);
        if (calculateDistanceToFinalSnap[0] == 0 && calculateDistanceToFinalSnap[1] == 0) {
            return;
        }
        this.f9198j.smoothScrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i = ((SavedState) parcelable).f9230a;
            sparseArray.put(this.f9198j.getId(), sparseArray.get(i));
            sparseArray.remove(i);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        m50241f();
    }

    public boolean endFakeDrag() {
        return this.f9211w.m50286c();
    }

    public boolean fakeDragBy(@InterfaceC0075Px @SuppressLint({"SupportAnnotationUsage"}) float f) {
        return this.f9211w.m50289a(f);
    }

    @Override // android.view.ViewGroup, android.view.View
    @RequiresApi(23)
    public CharSequence getAccessibilityClassName() {
        if (this.f9200l.m50240a()) {
            return this.f9200l.m50234b();
        }
        return super.getAccessibilityClassName();
    }

    @Nullable
    public RecyclerView.Adapter getAdapter() {
        return this.f9198j.getAdapter();
    }

    public int getCurrentItem() {
        return this.f9196h;
    }

    @NonNull
    public RecyclerView.ItemDecoration getItemDecorationAt(int i) {
        return this.f9198j.getItemDecorationAt(i);
    }

    public int getItemDecorationCount() {
        return this.f9198j.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.f9195B;
    }

    public int getOrientation() {
        return this.f9206r.getOrientation();
    }

    public int getOverScrolledDirection() {
        int[] iArr = this.f9203o;
        if (iArr[0] == 0) {
            return iArr[1];
        }
        return iArr[0];
    }

    public int getScrollState() {
        return this.f9199k.m50261d();
    }

    public void invalidateItemDecorations() {
        this.f9198j.invalidateItemDecorations();
    }

    public boolean isFakeDragging() {
        return this.f9211w.m50290a();
    }

    public boolean isUserInputEnabled() {
        return this.f9194A;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.f9200l.m50237a(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = this.f9198j.getMeasuredWidth();
        int measuredHeight = this.f9198j.getMeasuredHeight();
        this.f9201m.left = getPaddingLeft();
        this.f9201m.right = (i3 - i) - getPaddingRight();
        this.f9201m.top = getPaddingTop();
        this.f9201m.bottom = (i4 - i2) - getPaddingBottom();
        Gravity.apply(BadgeDrawable.TOP_START, measuredWidth, measuredHeight, this.f9201m, this.f9202n);
        RecyclerView recyclerView = this.f9198j;
        Rect rect = this.f9202n;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.f9197i) {
            m50251a();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        measureChild(this.f9198j, i, i2);
        int measuredWidth = this.f9198j.getMeasuredWidth();
        int measuredHeight = this.f9198j.getMeasuredHeight();
        int measuredState = this.f9198j.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(ViewGroup.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, measuredState), ViewGroup.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, measuredState << 16));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f9207s = savedState.f9231b;
        this.f9208t = savedState.f9232c;
    }

    @Override // android.view.View
    @Nullable
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f9230a = this.f9198j.getId();
        int i = this.f9207s;
        if (i == -1) {
            i = this.f9196h;
        }
        savedState.f9231b = i;
        Parcelable parcelable = this.f9208t;
        if (parcelable != null) {
            savedState.f9232c = parcelable;
        } else {
            RecyclerView.Adapter adapter = this.f9198j.getAdapter();
            if (adapter instanceof StatefulAdapter) {
                savedState.f9232c = ((StatefulAdapter) adapter).saveState();
            }
        }
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(getClass().getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    @RequiresApi(16)
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (this.f9200l.m50239a(i, bundle)) {
            return this.f9200l.m50233b(i, bundle);
        }
        return super.performAccessibilityAction(i, bundle);
    }

    public void registerOnPageChangeCallback(@NonNull OnPageChangeCallback onPageChangeCallback) {
        this.f9204p.m50293a(onPageChangeCallback);
    }

    public void removeItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        this.f9198j.removeItemDecoration(itemDecoration);
    }

    public void removeItemDecorationAt(int i) {
        this.f9198j.removeItemDecorationAt(i);
    }

    public void requestTransform() {
        if (this.f9212x.m50284a() == null) {
            return;
        }
        double m50257h = this.f9199k.m50257h();
        int i = (int) m50257h;
        double d = i;
        Double.isNaN(d);
        float f = (float) (m50257h - d);
        this.f9212x.onPageScrolled(i, f, Math.round(m50246b() * f));
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.f9198j.getAdapter();
        this.f9200l.m50232b(adapter2);
        m50245b(adapter2);
        this.f9198j.setAdapter(adapter);
        this.f9196h = 0;
        m50241f();
        this.f9200l.m50236a(adapter);
        m50248a(adapter);
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, true);
    }

    @Override // android.view.View
    @RequiresApi(17)
    public void setLayoutDirection(int i) {
        super.setLayoutDirection(i);
        this.f9200l.m50227g();
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1 && i != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.f9195B = i;
        this.f9198j.requestLayout();
    }

    public void setOnOverScrollListener(final OnOverScrollListener onOverScrollListener) {
        if (onOverScrollListener == null) {
            return;
        }
        registerOnPageChangeCallback(new OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.5

            /* renamed from: a */
            boolean f9219a = false;

            /* renamed from: b */
            boolean f9220b = false;

            /* renamed from: c */
            boolean f9221c = false;

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i) {
                if (i != 0) {
                    if (i == 1) {
                        this.f9221c = true;
                        return;
                    } else if (i != 2) {
                        return;
                    } else {
                        this.f9219a = false;
                        this.f9220b = false;
                        return;
                    }
                }
                RecyclerView.Adapter adapter = ViewPager2.this.getAdapter();
                if (adapter == null || adapter.getItemCount() <= 0 || !this.f9221c) {
                    return;
                }
                if (1 == ViewPager2.this.getOrientation()) {
                    if (!ViewPager2.this.canScrollVertically(-1) && ViewPager2.this.getOverScrolledDirection() < 0) {
                        onOverScrollListener.onOverScrollStart();
                    } else if (!ViewPager2.this.canScrollVertically(1) && ViewPager2.this.getOverScrolledDirection() > 0) {
                        onOverScrollListener.onOverScrollEnd();
                    }
                } else if (ViewPager2.this.getOrientation() == 0) {
                    if (!ViewPager2.this.canScrollHorizontally(-1) && ViewPager2.this.getOverScrolledDirection() < 0) {
                        onOverScrollListener.onOverScrollStart();
                    } else if (!ViewPager2.this.canScrollHorizontally(1) && ViewPager2.this.getOverScrolledDirection() > 0) {
                        onOverScrollListener.onOverScrollEnd();
                    }
                }
                this.f9221c = false;
            }
        });
    }

    public void setOrientation(int i) {
        this.f9206r.setOrientation(i);
        this.f9200l.m50230d();
    }

    public void setPageTransformer(@Nullable PageTransformer pageTransformer) {
        if (pageTransformer != null) {
            if (!this.f9214z) {
                this.f9213y = this.f9198j.getItemAnimator();
                this.f9214z = true;
            }
            this.f9198j.setItemAnimator(null);
        } else if (this.f9214z) {
            this.f9198j.setItemAnimator(this.f9213y);
            this.f9213y = null;
            this.f9214z = false;
        }
        if (pageTransformer == this.f9212x.m50284a()) {
            return;
        }
        this.f9212x.m50283a(pageTransformer);
        requestTransform();
    }

    public void setUserInputEnabled(boolean z) {
        this.f9194A = z;
        this.f9200l.m50228f();
    }

    public void unregisterOnPageChangeCallback(@NonNull OnPageChangeCallback onPageChangeCallback) {
        this.f9204p.m50291b(onPageChangeCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class SavedState extends View.BaseSavedState {

        /* renamed from: d */
        public static final Parcelable.Creator<SavedState> f9229d = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return Build.VERSION.SDK_INT >= 24 ? new SavedState(parcel, classLoader) : new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, (ClassLoader) null);
            }
        };

        /* renamed from: a */
        int f9230a;

        /* renamed from: b */
        int f9231b;

        /* renamed from: c */
        Parcelable f9232c;

        @RequiresApi(24)
        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            m50226a(parcel, classLoader);
        }

        /* renamed from: a */
        private void m50226a(Parcel parcel, ClassLoader classLoader) {
            this.f9230a = parcel.readInt();
            this.f9231b = parcel.readInt();
            this.f9232c = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f9230a);
            parcel.writeInt(this.f9231b);
            parcel.writeParcelable(this.f9232c, i);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            m50226a(parcel, null);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* renamed from: a */
    private void m50249a(Context context, AttributeSet attributeSet) {
        this.f9200l = new BasicAccessibilityProvider();
        RecyclerViewImpl recyclerViewImpl = new RecyclerViewImpl(context);
        this.f9198j = recyclerViewImpl;
        recyclerViewImpl.setId(ViewCompatDelegate.generateViewId());
        this.f9198j.setDescendantFocusability(131072);
        LinearLayoutManagerImpl linearLayoutManagerImpl = new LinearLayoutManagerImpl(context);
        this.f9206r = linearLayoutManagerImpl;
        this.f9198j.setLayoutManager(linearLayoutManagerImpl);
        this.f9198j.setScrollingTouchSlop(1);
        setOrientation(0);
        this.f9198j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f9198j.addOnChildAttachStateChangeListener(m50242e());
        ScrollEventAdapter scrollEventAdapter = new ScrollEventAdapter(this);
        this.f9199k = scrollEventAdapter;
        this.f9211w = new FakeDrag(this, scrollEventAdapter, this.f9198j);
        PagerSnapHelperImpl pagerSnapHelperImpl = new PagerSnapHelperImpl();
        this.f9209u = pagerSnapHelperImpl;
        pagerSnapHelperImpl.attachToRecyclerView(this.f9198j);
        this.f9198j.addOnScrollListener(this.f9199k);
        CompositeOnPageChangeCallback compositeOnPageChangeCallback = new CompositeOnPageChangeCallback(3);
        this.f9210v = compositeOnPageChangeCallback;
        this.f9199k.m50266a(compositeOnPageChangeCallback);
        OnPageChangeCallback onPageChangeCallback = new OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.2
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i) {
                if (i == 0) {
                    ViewPager2.this.m50251a();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                ViewPager2 viewPager2 = ViewPager2.this;
                if (viewPager2.f9196h != i) {
                    viewPager2.f9196h = i;
                    viewPager2.f9200l.m50229e();
                }
            }
        };
        OnPageChangeCallback onPageChangeCallback2 = new OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.3
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                ViewPager2.this.clearFocus();
                if (ViewPager2.this.hasFocus()) {
                    ViewPager2.this.f9198j.requestFocus(2);
                }
            }
        };
        this.f9210v.m50293a(onPageChangeCallback);
        this.f9210v.m50293a(onPageChangeCallback2);
        this.f9200l.m50235a(this.f9210v, this.f9198j);
        this.f9210v.m50293a(this.f9204p);
        PageTransformerAdapter pageTransformerAdapter = new PageTransformerAdapter(this.f9206r);
        this.f9212x = pageTransformerAdapter;
        this.f9210v.m50293a(pageTransformerAdapter);
        RecyclerView recyclerView = this.f9198j;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration, int i) {
        this.f9198j.addItemDecoration(itemDecoration, i);
    }

    /* renamed from: b */
    int m50246b() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.f9198j;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public void setCurrentItem(int i, boolean z) {
        if (!isFakeDragging()) {
            m50250a(i, z);
            return;
        }
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9201m = new Rect();
        this.f9202n = new Rect();
        this.f9203o = new int[2];
        this.f9204p = new CompositeOnPageChangeCallback(3);
        this.f9197i = false;
        this.f9205q = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f9197i = true;
                viewPager2.f9199k.m50270a();
            }
        };
        this.f9207s = -1;
        this.f9213y = null;
        this.f9214z = false;
        this.f9194A = true;
        this.f9195B = -1;
        m50249a(context, attributeSet);
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9201m = new Rect();
        this.f9202n = new Rect();
        this.f9203o = new int[2];
        this.f9204p = new CompositeOnPageChangeCallback(3);
        this.f9197i = false;
        this.f9205q = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f9197i = true;
                viewPager2.f9199k.m50270a();
            }
        };
        this.f9207s = -1;
        this.f9213y = null;
        this.f9214z = false;
        this.f9194A = true;
        this.f9195B = -1;
        m50249a(context, attributeSet);
    }

    /* renamed from: a */
    private void m50248a(@Nullable RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f9205q);
        }
    }

    /* renamed from: a */
    void m50251a() {
        PagerSnapHelper pagerSnapHelper = this.f9209u;
        if (pagerSnapHelper != null) {
            View findSnapView = pagerSnapHelper.findSnapView(this.f9206r);
            if (findSnapView == null) {
                return;
            }
            int position = this.f9206r.getPosition(findSnapView);
            if (position != this.f9196h && getScrollState() == 0) {
                this.f9210v.onPageSelected(position);
            }
            this.f9197i = false;
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    /* renamed from: a */
    void m50250a(int i, boolean z) {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            if (this.f9207s != -1) {
                this.f9207s = Math.max(i, 0);
            }
        } else if (adapter.getItemCount() <= 0) {
        } else {
            int min = Math.min(Math.max(i, 0), adapter.getItemCount() - 1);
            if (min == this.f9196h && this.f9199k.m50260e()) {
                return;
            }
            int i2 = this.f9196h;
            if (min == i2 && z) {
                return;
            }
            double d = i2;
            this.f9196h = min;
            this.f9200l.m50229e();
            if (!this.f9199k.m50260e()) {
                d = this.f9199k.m50257h();
            }
            this.f9199k.m50267a(min, z);
            if (!z) {
                this.f9198j.scrollToPosition(min);
                return;
            }
            double d2 = min;
            Double.isNaN(d2);
            if (Math.abs(d2 - d) > 3.0d) {
                this.f9198j.scrollToPosition(d2 > d ? min - 3 : min + 3);
                RecyclerView recyclerView = this.f9198j;
                recyclerView.post(new SmoothScrollToPosition(min, recyclerView));
                return;
            }
            this.f9198j.smoothScrollToPosition(min);
        }
    }

    @RequiresApi(21)
    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f9201m = new Rect();
        this.f9202n = new Rect();
        this.f9203o = new int[2];
        this.f9204p = new CompositeOnPageChangeCallback(3);
        this.f9197i = false;
        this.f9205q = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f9197i = true;
                viewPager2.f9199k.m50270a();
            }
        };
        this.f9207s = -1;
        this.f9213y = null;
        this.f9214z = false;
        this.f9194A = true;
        this.f9195B = -1;
        m50249a(context, attributeSet);
    }
}
