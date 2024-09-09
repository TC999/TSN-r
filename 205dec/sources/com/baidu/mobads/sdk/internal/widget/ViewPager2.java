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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.internal.concrete.ViewCompatDelegate;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ViewPager2 extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public static final int f12973a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f12974b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f12975c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static final int f12976d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static final int f12977e = 2;

    /* renamed from: f  reason: collision with root package name */
    public static final int f12978f = -1;

    /* renamed from: g  reason: collision with root package name */
    static boolean f12979g = true;
    private boolean A;
    private int B;

    /* renamed from: h  reason: collision with root package name */
    int f12980h;

    /* renamed from: i  reason: collision with root package name */
    boolean f12981i;

    /* renamed from: j  reason: collision with root package name */
    RecyclerView f12982j;

    /* renamed from: k  reason: collision with root package name */
    ScrollEventAdapter f12983k;

    /* renamed from: l  reason: collision with root package name */
    AccessibilityProvider f12984l;

    /* renamed from: m  reason: collision with root package name */
    private final Rect f12985m;

    /* renamed from: n  reason: collision with root package name */
    private final Rect f12986n;

    /* renamed from: o  reason: collision with root package name */
    private final int[] f12987o;

    /* renamed from: p  reason: collision with root package name */
    private CompositeOnPageChangeCallback f12988p;

    /* renamed from: q  reason: collision with root package name */
    private RecyclerView.AdapterDataObserver f12989q;

    /* renamed from: r  reason: collision with root package name */
    private LinearLayoutManager f12990r;

    /* renamed from: s  reason: collision with root package name */
    private int f12991s;

    /* renamed from: t  reason: collision with root package name */
    private Parcelable f12992t;

    /* renamed from: u  reason: collision with root package name */
    private PagerSnapHelper f12993u;

    /* renamed from: v  reason: collision with root package name */
    private CompositeOnPageChangeCallback f12994v;

    /* renamed from: w  reason: collision with root package name */
    private FakeDrag f12995w;

    /* renamed from: x  reason: collision with root package name */
    private PageTransformerAdapter f12996x;

    /* renamed from: y  reason: collision with root package name */
    private RecyclerView.ItemAnimator f12997y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f12998z;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public abstract class AccessibilityProvider {
        private AccessibilityProvider() {
        }

        void a(@NonNull AccessibilityEvent accessibilityEvent) {
        }

        void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        void a(@Nullable RecyclerView.Adapter<?> adapter) {
        }

        void a(@NonNull CompositeOnPageChangeCallback compositeOnPageChangeCallback, @NonNull RecyclerView recyclerView) {
        }

        boolean a() {
            return false;
        }

        boolean a(int i4, Bundle bundle) {
            return false;
        }

        String b() {
            throw new IllegalStateException("Not implemented.");
        }

        void b(@Nullable RecyclerView.Adapter<?> adapter) {
        }

        void c() {
        }

        void d() {
        }

        void e() {
        }

        void f() {
        }

        void g() {
        }

        boolean handlesLmPerformAccessibilityAction(int i4) {
            return false;
        }

        boolean handlesRvGetAccessibilityClassName() {
            return false;
        }

        void onLmInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        boolean onLmPerformAccessibilityAction(int i4) {
            throw new IllegalStateException("Not implemented.");
        }

        CharSequence onRvGetAccessibilityClassName() {
            throw new IllegalStateException("Not implemented.");
        }

        boolean b(int i4, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class BasicAccessibilityProvider extends AccessibilityProvider {
        BasicAccessibilityProvider() {
            super();
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public boolean handlesLmPerformAccessibilityAction(int i4) {
            return (i4 == 8192 || i4 == 4096) && !ViewPager2.this.isUserInputEnabled();
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
        public boolean onLmPerformAccessibilityAction(int i4) {
            if (handlesLmPerformAccessibilityAction(i4)) {
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

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i4, int i5) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int i4, int i5) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int i4, int i5, int i6) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int i4, int i5) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i4, int i5, @Nullable Object obj) {
            onChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
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
            return ViewPager2.this.b() * offscreenPageLimit;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
            ViewPager2.this.f12984l.onLmInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean performAccessibilityAction(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, int i4, @Nullable Bundle bundle) {
            if (ViewPager2.this.f12984l.handlesLmPerformAccessibilityAction(i4)) {
                return ViewPager2.this.f12984l.onLmPerformAccessibilityAction(i4);
            }
            return super.performAccessibilityAction(recycler, state, i4, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z3, boolean z4) {
            return false;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    @IntRange(from = 1)
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public @interface OffscreenPageLimit {
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnOverScrollListener {
        void onOverScrollEnd();

        void onOverScrollStart();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static abstract class OnPageChangeCallback {
        public void onPageScrollStateChanged(int i4) {
        }

        public void onPageScrolled(int i4, float f4, @Px int i5) {
        }

        public void onPageSelected(int i4) {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public @interface Orientation {
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface PageTransformer {
        void transformPage(@NonNull View view, float f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
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
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class RecyclerViewImpl extends RecyclerView {
        RecyclerViewImpl(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, androidx.core.view.NestedScrollingChild2
        public boolean dispatchNestedScroll(int i4, int i5, int i6, int i7, int[] iArr, int i8) {
            ViewPager2.this.f12987o[1] = ViewPager2.this.f12987o[0];
            if (1 == ViewPager2.this.getOrientation()) {
                ViewPager2.this.f12987o[0] = i7;
            } else {
                ViewPager2.this.f12987o[0] = i6;
            }
            return super.dispatchNestedScroll(i4, i5, i6, i7, iArr, i8);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        @RequiresApi(23)
        public CharSequence getAccessibilityClassName() {
            if (ViewPager2.this.f12984l.handlesRvGetAccessibilityClassName()) {
                return ViewPager2.this.f12984l.onRvGetAccessibilityClassName();
            }
            return super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f12980h);
            accessibilityEvent.setToIndex(ViewPager2.this.f12980h);
            ViewPager2.this.f12984l.a(accessibilityEvent);
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

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public @interface ScrollState {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class SmoothScrollToPosition implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f13017a;

        /* renamed from: b  reason: collision with root package name */
        private final RecyclerView f13018b;

        SmoothScrollToPosition(int i4, RecyclerView recyclerView) {
            this.f13017a = i4;
            this.f13018b = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f13018b.smoothScrollToPosition(this.f13017a);
        }
    }

    public ViewPager2(@NonNull Context context) {
        super(context);
        this.f12985m = new Rect();
        this.f12986n = new Rect();
        this.f12987o = new int[2];
        this.f12988p = new CompositeOnPageChangeCallback(3);
        this.f12981i = false;
        this.f12989q = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f12981i = true;
                viewPager2.f12983k.a();
            }
        };
        this.f12991s = -1;
        this.f12997y = null;
        this.f12998z = false;
        this.A = true;
        this.B = -1;
        a(context, (AttributeSet) null);
    }

    private void b(@Nullable RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.f12989q);
        }
    }

    private RecyclerView.OnChildAttachStateChangeListener e() {
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

    private void f() {
        RecyclerView.Adapter adapter;
        if (this.f12991s == -1 || (adapter = getAdapter()) == null) {
            return;
        }
        Parcelable parcelable = this.f12992t;
        if (parcelable != null) {
            if (adapter instanceof StatefulAdapter) {
                ((StatefulAdapter) adapter).restoreState(parcelable);
            }
            this.f12992t = null;
        }
        int max = Math.max(0, Math.min(this.f12991s, adapter.getItemCount() - 1));
        this.f12980h = max;
        this.f12991s = -1;
        this.f12982j.scrollToPosition(max);
        this.f12984l.c();
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        this.f12982j.addItemDecoration(itemDecoration);
    }

    public boolean beginFakeDrag() {
        return this.f12995w.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.f12990r.getLayoutDirection() == 1;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i4) {
        return this.f12982j.canScrollHorizontally(i4);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i4) {
        return this.f12982j.canScrollVertically(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        View findSnapView = this.f12993u.findSnapView(this.f12990r);
        if (findSnapView == null) {
            return;
        }
        int[] calculateDistanceToFinalSnap = this.f12993u.calculateDistanceToFinalSnap(this.f12990r, findSnapView);
        if (calculateDistanceToFinalSnap[0] == 0 && calculateDistanceToFinalSnap[1] == 0) {
            return;
        }
        this.f12982j.smoothScrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i4 = ((SavedState) parcelable).f13014a;
            sparseArray.put(this.f12982j.getId(), sparseArray.get(i4));
            sparseArray.remove(i4);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        f();
    }

    public boolean endFakeDrag() {
        return this.f12995w.c();
    }

    public boolean fakeDragBy(@Px @SuppressLint({"SupportAnnotationUsage"}) float f4) {
        return this.f12995w.a(f4);
    }

    @Override // android.view.ViewGroup, android.view.View
    @RequiresApi(23)
    public CharSequence getAccessibilityClassName() {
        if (this.f12984l.a()) {
            return this.f12984l.b();
        }
        return super.getAccessibilityClassName();
    }

    @Nullable
    public RecyclerView.Adapter getAdapter() {
        return this.f12982j.getAdapter();
    }

    public int getCurrentItem() {
        return this.f12980h;
    }

    @NonNull
    public RecyclerView.ItemDecoration getItemDecorationAt(int i4) {
        return this.f12982j.getItemDecorationAt(i4);
    }

    public int getItemDecorationCount() {
        return this.f12982j.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.B;
    }

    public int getOrientation() {
        return this.f12990r.getOrientation();
    }

    public int getOverScrolledDirection() {
        int[] iArr = this.f12987o;
        if (iArr[0] == 0) {
            return iArr[1];
        }
        return iArr[0];
    }

    public int getScrollState() {
        return this.f12983k.d();
    }

    public void invalidateItemDecorations() {
        this.f12982j.invalidateItemDecorations();
    }

    public boolean isFakeDragging() {
        return this.f12995w.a();
    }

    public boolean isUserInputEnabled() {
        return this.A;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.f12984l.a(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        int measuredWidth = this.f12982j.getMeasuredWidth();
        int measuredHeight = this.f12982j.getMeasuredHeight();
        this.f12985m.left = getPaddingLeft();
        this.f12985m.right = (i6 - i4) - getPaddingRight();
        this.f12985m.top = getPaddingTop();
        this.f12985m.bottom = (i7 - i5) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.f12985m, this.f12986n);
        RecyclerView recyclerView = this.f12982j;
        Rect rect = this.f12986n;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.f12981i) {
            a();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        measureChild(this.f12982j, i4, i5);
        int measuredWidth = this.f12982j.getMeasuredWidth();
        int measuredHeight = this.f12982j.getMeasuredHeight();
        int measuredState = this.f12982j.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(ViewGroup.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i4, measuredState), ViewGroup.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i5, measuredState << 16));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f12991s = savedState.f13015b;
        this.f12992t = savedState.f13016c;
    }

    @Override // android.view.View
    @Nullable
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f13014a = this.f12982j.getId();
        int i4 = this.f12991s;
        if (i4 == -1) {
            i4 = this.f12980h;
        }
        savedState.f13015b = i4;
        Parcelable parcelable = this.f12992t;
        if (parcelable != null) {
            savedState.f13016c = parcelable;
        } else {
            RecyclerView.Adapter adapter = this.f12982j.getAdapter();
            if (adapter instanceof StatefulAdapter) {
                savedState.f13016c = ((StatefulAdapter) adapter).saveState();
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
    public boolean performAccessibilityAction(int i4, Bundle bundle) {
        if (this.f12984l.a(i4, bundle)) {
            return this.f12984l.b(i4, bundle);
        }
        return super.performAccessibilityAction(i4, bundle);
    }

    public void registerOnPageChangeCallback(@NonNull OnPageChangeCallback onPageChangeCallback) {
        this.f12988p.a(onPageChangeCallback);
    }

    public void removeItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        this.f12982j.removeItemDecoration(itemDecoration);
    }

    public void removeItemDecorationAt(int i4) {
        this.f12982j.removeItemDecorationAt(i4);
    }

    public void requestTransform() {
        if (this.f12996x.a() == null) {
            return;
        }
        double h4 = this.f12983k.h();
        int i4 = (int) h4;
        double d4 = i4;
        Double.isNaN(d4);
        float f4 = (float) (h4 - d4);
        this.f12996x.onPageScrolled(i4, f4, Math.round(b() * f4));
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.f12982j.getAdapter();
        this.f12984l.b(adapter2);
        b(adapter2);
        this.f12982j.setAdapter(adapter);
        this.f12980h = 0;
        f();
        this.f12984l.a(adapter);
        a(adapter);
    }

    public void setCurrentItem(int i4) {
        setCurrentItem(i4, true);
    }

    @Override // android.view.View
    @RequiresApi(17)
    public void setLayoutDirection(int i4) {
        super.setLayoutDirection(i4);
        this.f12984l.g();
    }

    public void setOffscreenPageLimit(int i4) {
        if (i4 < 1 && i4 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.B = i4;
        this.f12982j.requestLayout();
    }

    public void setOnOverScrollListener(final OnOverScrollListener onOverScrollListener) {
        if (onOverScrollListener == null) {
            return;
        }
        registerOnPageChangeCallback(new OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.5

            /* renamed from: a  reason: collision with root package name */
            boolean f13003a = false;

            /* renamed from: b  reason: collision with root package name */
            boolean f13004b = false;

            /* renamed from: c  reason: collision with root package name */
            boolean f13005c = false;

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i4) {
                if (i4 != 0) {
                    if (i4 == 1) {
                        this.f13005c = true;
                        return;
                    } else if (i4 != 2) {
                        return;
                    } else {
                        this.f13003a = false;
                        this.f13004b = false;
                        return;
                    }
                }
                RecyclerView.Adapter adapter = ViewPager2.this.getAdapter();
                if (adapter == null || adapter.getItemCount() <= 0 || !this.f13005c) {
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
                this.f13005c = false;
            }
        });
    }

    public void setOrientation(int i4) {
        this.f12990r.setOrientation(i4);
        this.f12984l.d();
    }

    public void setPageTransformer(@Nullable PageTransformer pageTransformer) {
        if (pageTransformer != null) {
            if (!this.f12998z) {
                this.f12997y = this.f12982j.getItemAnimator();
                this.f12998z = true;
            }
            this.f12982j.setItemAnimator(null);
        } else if (this.f12998z) {
            this.f12982j.setItemAnimator(this.f12997y);
            this.f12997y = null;
            this.f12998z = false;
        }
        if (pageTransformer == this.f12996x.a()) {
            return;
        }
        this.f12996x.a(pageTransformer);
        requestTransform();
    }

    public void setUserInputEnabled(boolean z3) {
        this.A = z3;
        this.f12984l.f();
    }

    public void unregisterOnPageChangeCallback(@NonNull OnPageChangeCallback onPageChangeCallback) {
        this.f12988p.b(onPageChangeCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class SavedState extends View.BaseSavedState {

        /* renamed from: d  reason: collision with root package name */
        public static final Parcelable.Creator<SavedState> f13013d = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i4) {
                return new SavedState[i4];
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

        /* renamed from: a  reason: collision with root package name */
        int f13014a;

        /* renamed from: b  reason: collision with root package name */
        int f13015b;

        /* renamed from: c  reason: collision with root package name */
        Parcelable f13016c;

        @RequiresApi(24)
        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.f13014a = parcel.readInt();
            this.f13015b = parcel.readInt();
            this.f13016c = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f13014a);
            parcel.writeInt(this.f13015b);
            parcel.writeParcelable(this.f13016c, i4);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            a(parcel, null);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.f12984l = new BasicAccessibilityProvider();
        RecyclerViewImpl recyclerViewImpl = new RecyclerViewImpl(context);
        this.f12982j = recyclerViewImpl;
        recyclerViewImpl.setId(ViewCompatDelegate.generateViewId());
        this.f12982j.setDescendantFocusability(131072);
        LinearLayoutManagerImpl linearLayoutManagerImpl = new LinearLayoutManagerImpl(context);
        this.f12990r = linearLayoutManagerImpl;
        this.f12982j.setLayoutManager(linearLayoutManagerImpl);
        this.f12982j.setScrollingTouchSlop(1);
        setOrientation(0);
        this.f12982j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f12982j.addOnChildAttachStateChangeListener(e());
        ScrollEventAdapter scrollEventAdapter = new ScrollEventAdapter(this);
        this.f12983k = scrollEventAdapter;
        this.f12995w = new FakeDrag(this, scrollEventAdapter, this.f12982j);
        PagerSnapHelperImpl pagerSnapHelperImpl = new PagerSnapHelperImpl();
        this.f12993u = pagerSnapHelperImpl;
        pagerSnapHelperImpl.attachToRecyclerView(this.f12982j);
        this.f12982j.addOnScrollListener(this.f12983k);
        CompositeOnPageChangeCallback compositeOnPageChangeCallback = new CompositeOnPageChangeCallback(3);
        this.f12994v = compositeOnPageChangeCallback;
        this.f12983k.a(compositeOnPageChangeCallback);
        OnPageChangeCallback onPageChangeCallback = new OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.2
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i4) {
                if (i4 == 0) {
                    ViewPager2.this.a();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i4) {
                ViewPager2 viewPager2 = ViewPager2.this;
                if (viewPager2.f12980h != i4) {
                    viewPager2.f12980h = i4;
                    viewPager2.f12984l.e();
                }
            }
        };
        OnPageChangeCallback onPageChangeCallback2 = new OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.3
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i4) {
                ViewPager2.this.clearFocus();
                if (ViewPager2.this.hasFocus()) {
                    ViewPager2.this.f12982j.requestFocus(2);
                }
            }
        };
        this.f12994v.a(onPageChangeCallback);
        this.f12994v.a(onPageChangeCallback2);
        this.f12984l.a(this.f12994v, this.f12982j);
        this.f12994v.a(this.f12988p);
        PageTransformerAdapter pageTransformerAdapter = new PageTransformerAdapter(this.f12990r);
        this.f12996x = pageTransformerAdapter;
        this.f12994v.a(pageTransformerAdapter);
        RecyclerView recyclerView = this.f12982j;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration, int i4) {
        this.f12982j.addItemDecoration(itemDecoration, i4);
    }

    int b() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.f12982j;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public void setCurrentItem(int i4, boolean z3) {
        if (!isFakeDragging()) {
            a(i4, z3);
            return;
        }
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12985m = new Rect();
        this.f12986n = new Rect();
        this.f12987o = new int[2];
        this.f12988p = new CompositeOnPageChangeCallback(3);
        this.f12981i = false;
        this.f12989q = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f12981i = true;
                viewPager2.f12983k.a();
            }
        };
        this.f12991s = -1;
        this.f12997y = null;
        this.f12998z = false;
        this.A = true;
        this.B = -1;
        a(context, attributeSet);
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f12985m = new Rect();
        this.f12986n = new Rect();
        this.f12987o = new int[2];
        this.f12988p = new CompositeOnPageChangeCallback(3);
        this.f12981i = false;
        this.f12989q = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f12981i = true;
                viewPager2.f12983k.a();
            }
        };
        this.f12991s = -1;
        this.f12997y = null;
        this.f12998z = false;
        this.A = true;
        this.B = -1;
        a(context, attributeSet);
    }

    private void a(@Nullable RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f12989q);
        }
    }

    void a() {
        PagerSnapHelper pagerSnapHelper = this.f12993u;
        if (pagerSnapHelper != null) {
            View findSnapView = pagerSnapHelper.findSnapView(this.f12990r);
            if (findSnapView == null) {
                return;
            }
            int position = this.f12990r.getPosition(findSnapView);
            if (position != this.f12980h && getScrollState() == 0) {
                this.f12994v.onPageSelected(position);
            }
            this.f12981i = false;
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    void a(int i4, boolean z3) {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            if (this.f12991s != -1) {
                this.f12991s = Math.max(i4, 0);
            }
        } else if (adapter.getItemCount() <= 0) {
        } else {
            int min = Math.min(Math.max(i4, 0), adapter.getItemCount() - 1);
            if (min == this.f12980h && this.f12983k.e()) {
                return;
            }
            int i5 = this.f12980h;
            if (min == i5 && z3) {
                return;
            }
            double d4 = i5;
            this.f12980h = min;
            this.f12984l.e();
            if (!this.f12983k.e()) {
                d4 = this.f12983k.h();
            }
            this.f12983k.a(min, z3);
            if (!z3) {
                this.f12982j.scrollToPosition(min);
                return;
            }
            double d5 = min;
            Double.isNaN(d5);
            if (Math.abs(d5 - d4) > 3.0d) {
                this.f12982j.scrollToPosition(d5 > d4 ? min - 3 : min + 3);
                RecyclerView recyclerView = this.f12982j;
                recyclerView.post(new SmoothScrollToPosition(min, recyclerView));
                return;
            }
            this.f12982j.smoothScrollToPosition(min);
        }
    }

    @RequiresApi(21)
    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f12985m = new Rect();
        this.f12986n = new Rect();
        this.f12987o = new int[2];
        this.f12988p = new CompositeOnPageChangeCallback(3);
        this.f12981i = false;
        this.f12989q = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f12981i = true;
                viewPager2.f12983k.a();
            }
        };
        this.f12991s = -1;
        this.f12997y = null;
        this.f12998z = false;
        this.A = true;
        this.B = -1;
        a(context, attributeSet);
    }
}
