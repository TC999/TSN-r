package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int CORNER_ANIMATION_DURATION = 500;
    private static final int DEF_STYLE_RES = R.style.Widget_Design_BottomSheet_Modal;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int SAVE_ALL = -1;
    public static final int SAVE_FIT_TO_CONTENTS = 2;
    public static final int SAVE_HIDEABLE = 4;
    public static final int SAVE_NONE = 0;
    public static final int SAVE_PEEK_HEIGHT = 1;
    public static final int SAVE_SKIP_COLLAPSED = 8;
    private static final int SIGNIFICANT_VEL_THRESHOLD = 500;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "BottomSheetBehavior";
    int activePointerId;
    @NonNull
    private final ArrayList<BottomSheetCallback> callbacks;
    private int childHeight;
    int collapsedOffset;
    private final ViewDragHelper.Callback dragCallback;
    private boolean draggable;
    float elevation;
    int expandedOffset;
    private boolean fitToContents;
    int fitToContentsOffset;
    private int gestureInsetBottom;
    private boolean gestureInsetBottomIgnored;
    int halfExpandedOffset;
    float halfExpandedRatio;
    boolean hideable;
    private boolean ignoreEvents;
    @Nullable
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY;
    @Nullable
    private ValueAnimator interpolatorAnimator;
    private boolean isShapeExpanded;
    private int lastNestedScrollDy;
    private MaterialShapeDrawable materialShapeDrawable;
    private float maximumVelocity;
    private boolean nestedScrolled;
    @Nullable
    WeakReference<View> nestedScrollingChildRef;
    int parentHeight;
    int parentWidth;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightGestureInsetBuffer;
    private int peekHeightMin;
    private int saveFlags;
    private BottomSheetBehavior<V>.SettleRunnable settleRunnable;
    private ShapeAppearanceModel shapeAppearanceModelDefault;
    private boolean shapeThemingEnabled;
    private boolean skipCollapsed;
    int state;
    boolean touchingScrollingChild;
    private boolean updateImportantForAccessibilityOnSiblings;
    @Nullable
    private VelocityTracker velocityTracker;
    @Nullable
    ViewDragHelper viewDragHelper;
    @Nullable
    WeakReference<V> viewRef;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static abstract class BottomSheetCallback {
        public abstract void onSlide(@NonNull View view, float f4);

        public abstract void onStateChanged(@NonNull View view, int i4);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public @interface SaveFlags {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState.1
            @Override // android.os.Parcelable.Creator
            @NonNull
            public SavedState[] newArray(int i4) {
                return new SavedState[i4];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
        final int state;

        public SavedState(@NonNull Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.state);
            parcel.writeInt(this.peekHeight);
            parcel.writeInt(this.fitToContents ? 1 : 0);
            parcel.writeInt(this.hideable ? 1 : 0);
            parcel.writeInt(this.skipCollapsed ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
            this.peekHeight = parcel.readInt();
            this.fitToContents = parcel.readInt() == 1;
            this.hideable = parcel.readInt() == 1;
            this.skipCollapsed = parcel.readInt() == 1;
        }

        public SavedState(Parcelable parcelable, @NonNull BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.state = bottomSheetBehavior.state;
            this.peekHeight = ((BottomSheetBehavior) bottomSheetBehavior).peekHeight;
            this.fitToContents = ((BottomSheetBehavior) bottomSheetBehavior).fitToContents;
            this.hideable = bottomSheetBehavior.hideable;
            this.skipCollapsed = ((BottomSheetBehavior) bottomSheetBehavior).skipCollapsed;
        }

        @Deprecated
        public SavedState(Parcelable parcelable, int i4) {
            super(parcelable);
            this.state = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public class SettleRunnable implements Runnable {
        private boolean isPosted;
        int targetState;
        private final View view;

        SettleRunnable(View view, int i4) {
            this.view = view;
            this.targetState = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper viewDragHelper = BottomSheetBehavior.this.viewDragHelper;
            if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.view, this);
            } else {
                BottomSheetBehavior.this.setStateInternal(this.targetState);
            }
            this.isPosted = false;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public @interface State {
    }

    public BottomSheetBehavior() {
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.settleRunnable = null;
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.callbacks = new ArrayList<>();
        this.dragCallback = new ViewDragHelper.Callback() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.4
            private boolean releasedLow(@NonNull View view) {
                int top2 = view.getTop();
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                return top2 > (bottomSheetBehavior.parentHeight + bottomSheetBehavior.getExpandedOffset()) / 2;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(@NonNull View view, int i4, int i5) {
                return view.getLeft();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(@NonNull View view, int i4, int i5) {
                int expandedOffset = BottomSheetBehavior.this.getExpandedOffset();
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                return MathUtils.clamp(i4, expandedOffset, bottomSheetBehavior.hideable ? bottomSheetBehavior.parentHeight : bottomSheetBehavior.collapsedOffset);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(@NonNull View view) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.hideable) {
                    return bottomSheetBehavior.parentHeight;
                }
                return bottomSheetBehavior.collapsedOffset;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewDragStateChanged(int i4) {
                if (i4 == 1 && BottomSheetBehavior.this.draggable) {
                    BottomSheetBehavior.this.setStateInternal(1);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(@NonNull View view, int i4, int i5, int i6, int i7) {
                BottomSheetBehavior.this.dispatchOnSlide(i5);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(@NonNull View view, float f4, float f5) {
                int i4;
                int i5 = 4;
                if (f5 < 0.0f) {
                    if (BottomSheetBehavior.this.fitToContents) {
                        i4 = BottomSheetBehavior.this.fitToContentsOffset;
                    } else {
                        int top2 = view.getTop();
                        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                        int i6 = bottomSheetBehavior.halfExpandedOffset;
                        if (top2 > i6) {
                            i4 = i6;
                            i5 = 6;
                        } else {
                            i4 = bottomSheetBehavior.expandedOffset;
                        }
                    }
                    i5 = 3;
                } else {
                    BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                    if (bottomSheetBehavior2.hideable && bottomSheetBehavior2.shouldHide(view, f5)) {
                        if ((Math.abs(f4) < Math.abs(f5) && f5 > 500.0f) || releasedLow(view)) {
                            i4 = BottomSheetBehavior.this.parentHeight;
                            i5 = 5;
                        } else {
                            if (BottomSheetBehavior.this.fitToContents) {
                                i4 = BottomSheetBehavior.this.fitToContentsOffset;
                            } else if (Math.abs(view.getTop() - BottomSheetBehavior.this.expandedOffset) < Math.abs(view.getTop() - BottomSheetBehavior.this.halfExpandedOffset)) {
                                i4 = BottomSheetBehavior.this.expandedOffset;
                            } else {
                                i4 = BottomSheetBehavior.this.halfExpandedOffset;
                                i5 = 6;
                            }
                            i5 = 3;
                        }
                    } else if (f5 != 0.0f && Math.abs(f4) <= Math.abs(f5)) {
                        if (BottomSheetBehavior.this.fitToContents) {
                            i4 = BottomSheetBehavior.this.collapsedOffset;
                        } else {
                            int top3 = view.getTop();
                            if (Math.abs(top3 - BottomSheetBehavior.this.halfExpandedOffset) < Math.abs(top3 - BottomSheetBehavior.this.collapsedOffset)) {
                                i4 = BottomSheetBehavior.this.halfExpandedOffset;
                                i5 = 6;
                            } else {
                                i4 = BottomSheetBehavior.this.collapsedOffset;
                            }
                        }
                    } else {
                        int top4 = view.getTop();
                        if (BottomSheetBehavior.this.fitToContents) {
                            if (Math.abs(top4 - BottomSheetBehavior.this.fitToContentsOffset) < Math.abs(top4 - BottomSheetBehavior.this.collapsedOffset)) {
                                i4 = BottomSheetBehavior.this.fitToContentsOffset;
                                i5 = 3;
                            } else {
                                i4 = BottomSheetBehavior.this.collapsedOffset;
                            }
                        } else {
                            BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                            int i7 = bottomSheetBehavior3.halfExpandedOffset;
                            if (top4 < i7) {
                                if (top4 < Math.abs(top4 - bottomSheetBehavior3.collapsedOffset)) {
                                    i4 = BottomSheetBehavior.this.expandedOffset;
                                    i5 = 3;
                                } else {
                                    i4 = BottomSheetBehavior.this.halfExpandedOffset;
                                }
                            } else if (Math.abs(top4 - i7) < Math.abs(top4 - BottomSheetBehavior.this.collapsedOffset)) {
                                i4 = BottomSheetBehavior.this.halfExpandedOffset;
                            } else {
                                i4 = BottomSheetBehavior.this.collapsedOffset;
                            }
                            i5 = 6;
                        }
                    }
                }
                BottomSheetBehavior.this.startSettlingAnimation(view, i5, i4, true);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(@NonNull View view, int i4) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                int i5 = bottomSheetBehavior.state;
                if (i5 == 1 || bottomSheetBehavior.touchingScrollingChild) {
                    return false;
                }
                if (i5 == 3 && bottomSheetBehavior.activePointerId == i4) {
                    WeakReference<View> weakReference = bottomSheetBehavior.nestedScrollingChildRef;
                    View view2 = weakReference != null ? weakReference.get() : null;
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                WeakReference<V> weakReference2 = BottomSheetBehavior.this.viewRef;
                return weakReference2 != null && weakReference2.get() == view;
            }
        };
    }

    private void addAccessibilityActionForState(V v3, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, final int i4) {
        ViewCompat.replaceAccessibilityAction(v3, accessibilityActionCompat, null, new AccessibilityViewCommand() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.5
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                BottomSheetBehavior.this.setState(i4);
                return true;
            }
        });
    }

    private void calculateCollapsedOffset() {
        int calculatePeekHeight = calculatePeekHeight();
        if (this.fitToContents) {
            this.collapsedOffset = Math.max(this.parentHeight - calculatePeekHeight, this.fitToContentsOffset);
        } else {
            this.collapsedOffset = this.parentHeight - calculatePeekHeight;
        }
    }

    private void calculateHalfExpandedOffset() {
        this.halfExpandedOffset = (int) (this.parentHeight * (1.0f - this.halfExpandedRatio));
    }

    private int calculatePeekHeight() {
        int i4;
        if (this.peekHeightAuto) {
            return Math.min(Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16)), this.childHeight);
        }
        if (!this.gestureInsetBottomIgnored && (i4 = this.gestureInsetBottom) > 0) {
            return Math.max(this.peekHeight, i4 + this.peekHeightGestureInsetBuffer);
        }
        return this.peekHeight;
    }

    private void createMaterialShapeDrawable(@NonNull Context context, AttributeSet attributeSet, boolean z3) {
        createMaterialShapeDrawable(context, attributeSet, z3, null);
    }

    private void createShapeValueAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.interpolatorAnimator = ofFloat;
        ofFloat.setDuration(500L);
        this.interpolatorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (BottomSheetBehavior.this.materialShapeDrawable != null) {
                    BottomSheetBehavior.this.materialShapeDrawable.setInterpolation(floatValue);
                }
            }
        });
    }

    @NonNull
    public static <V extends View> BottomSheetBehavior<V> from(@NonNull V v3) {
        ViewGroup.LayoutParams layoutParams = v3.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (behavior instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private float getYVelocity() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    private void reset() {
        this.activePointerId = -1;
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.velocityTracker = null;
        }
    }

    private void restoreOptionalState(@NonNull SavedState savedState) {
        int i4 = this.saveFlags;
        if (i4 == 0) {
            return;
        }
        if (i4 == -1 || (i4 & 1) == 1) {
            this.peekHeight = savedState.peekHeight;
        }
        if (i4 == -1 || (i4 & 2) == 2) {
            this.fitToContents = savedState.fitToContents;
        }
        if (i4 == -1 || (i4 & 4) == 4) {
            this.hideable = savedState.hideable;
        }
        if (i4 == -1 || (i4 & 8) == 8) {
            this.skipCollapsed = savedState.skipCollapsed;
        }
    }

    private void setSystemGestureInsets(@NonNull View view) {
        if (Build.VERSION.SDK_INT < 29 || isGestureInsetBottomIgnored() || this.peekHeightAuto) {
            return;
        }
        ViewUtils.doOnApplyWindowInsets(view, new ViewUtils.OnApplyWindowInsetsListener() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.3
            @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
                BottomSheetBehavior.this.gestureInsetBottom = windowInsetsCompat.getMandatorySystemGestureInsets().bottom;
                BottomSheetBehavior.this.updatePeekHeight(false);
                return windowInsetsCompat;
            }
        });
    }

    private void settleToStatePendingLayout(final int i4) {
        final V v3 = this.viewRef.get();
        if (v3 == null) {
            return;
        }
        ViewParent parent = v3.getParent();
        if (parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(v3)) {
            v3.post(new Runnable() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.1
                @Override // java.lang.Runnable
                public void run() {
                    BottomSheetBehavior.this.settleToState(v3, i4);
                }
            });
        } else {
            settleToState(v3, i4);
        }
    }

    private void updateAccessibilityActions() {
        V v3;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || (v3 = weakReference.get()) == null) {
            return;
        }
        ViewCompat.removeAccessibilityAction(v3, 524288);
        ViewCompat.removeAccessibilityAction(v3, 262144);
        ViewCompat.removeAccessibilityAction(v3, 1048576);
        if (this.hideable && this.state != 5) {
            addAccessibilityActionForState(v3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
        }
        int i4 = this.state;
        if (i4 == 3) {
            addAccessibilityActionForState(v3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, this.fitToContents ? 4 : 6);
        } else if (i4 == 4) {
            addAccessibilityActionForState(v3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, this.fitToContents ? 3 : 6);
        } else if (i4 != 6) {
        } else {
            addAccessibilityActionForState(v3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
            addAccessibilityActionForState(v3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
        }
    }

    private void updateDrawableForTargetState(int i4) {
        ValueAnimator valueAnimator;
        if (i4 == 2) {
            return;
        }
        boolean z3 = i4 == 3;
        if (this.isShapeExpanded != z3) {
            this.isShapeExpanded = z3;
            if (this.materialShapeDrawable == null || (valueAnimator = this.interpolatorAnimator) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.interpolatorAnimator.reverse();
                return;
            }
            float f4 = z3 ? 0.0f : 1.0f;
            this.interpolatorAnimator.setFloatValues(1.0f - f4, f4);
            this.interpolatorAnimator.start();
        }
    }

    private void updateImportantForAccessibility(boolean z3) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z3) {
                if (this.importantForAccessibilityMap != null) {
                    return;
                }
                this.importantForAccessibilityMap = new HashMap(childCount);
            }
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = coordinatorLayout.getChildAt(i4);
                if (childAt != this.viewRef.get()) {
                    if (z3) {
                        this.importantForAccessibilityMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        if (this.updateImportantForAccessibilityOnSiblings) {
                            ViewCompat.setImportantForAccessibility(childAt, 4);
                        }
                    } else if (this.updateImportantForAccessibilityOnSiblings && (map = this.importantForAccessibilityMap) != null && map.containsKey(childAt)) {
                        ViewCompat.setImportantForAccessibility(childAt, this.importantForAccessibilityMap.get(childAt).intValue());
                    }
                }
            }
            if (z3) {
                return;
            }
            this.importantForAccessibilityMap = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePeekHeight(boolean z3) {
        V v3;
        if (this.viewRef != null) {
            calculateCollapsedOffset();
            if (this.state != 4 || (v3 = this.viewRef.get()) == null) {
                return;
            }
            if (z3) {
                settleToStatePendingLayout(this.state);
            } else {
                v3.requestLayout();
            }
        }
    }

    public void addBottomSheetCallback(@NonNull BottomSheetCallback bottomSheetCallback) {
        if (this.callbacks.contains(bottomSheetCallback)) {
            return;
        }
        this.callbacks.add(bottomSheetCallback);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void disableShapeAnimations() {
        this.interpolatorAnimator = null;
    }

    void dispatchOnSlide(int i4) {
        float f4;
        float f5;
        V v3 = this.viewRef.get();
        if (v3 == null || this.callbacks.isEmpty()) {
            return;
        }
        int i5 = this.collapsedOffset;
        if (i4 <= i5 && i5 != getExpandedOffset()) {
            int i6 = this.collapsedOffset;
            f4 = i6 - i4;
            f5 = i6 - getExpandedOffset();
        } else {
            int i7 = this.collapsedOffset;
            f4 = i7 - i4;
            f5 = this.parentHeight - i7;
        }
        float f6 = f4 / f5;
        for (int i8 = 0; i8 < this.callbacks.size(); i8++) {
            this.callbacks.get(i8).onSlide(v3, f6);
        }
    }

    @Nullable
    @VisibleForTesting
    View findScrollingChild(View view) {
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View findScrollingChild = findScrollingChild(viewGroup.getChildAt(i4));
                if (findScrollingChild != null) {
                    return findScrollingChild;
                }
            }
            return null;
        }
        return null;
    }

    public int getExpandedOffset() {
        return this.fitToContents ? this.fitToContentsOffset : this.expandedOffset;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getHalfExpandedRatio() {
        return this.halfExpandedRatio;
    }

    public int getPeekHeight() {
        if (this.peekHeightAuto) {
            return -1;
        }
        return this.peekHeight;
    }

    @VisibleForTesting
    int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public int getSaveFlags() {
        return this.saveFlags;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public int getState() {
        return this.state;
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    public boolean isHideable() {
        return this.hideable;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        if (v3.isShown() && this.draggable) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                reset();
            }
            if (this.velocityTracker == null) {
                this.velocityTracker = VelocityTracker.obtain();
            }
            this.velocityTracker.addMovement(motionEvent);
            if (actionMasked == 0) {
                int x3 = (int) motionEvent.getX();
                this.initialY = (int) motionEvent.getY();
                if (this.state != 2) {
                    WeakReference<View> weakReference = this.nestedScrollingChildRef;
                    View view = weakReference != null ? weakReference.get() : null;
                    if (view != null && coordinatorLayout.isPointInChildBounds(view, x3, this.initialY)) {
                        this.activePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.touchingScrollingChild = true;
                    }
                }
                this.ignoreEvents = this.activePointerId == -1 && !coordinatorLayout.isPointInChildBounds(v3, x3, this.initialY);
            } else if (actionMasked == 1 || actionMasked == 3) {
                this.touchingScrollingChild = false;
                this.activePointerId = -1;
                if (this.ignoreEvents) {
                    this.ignoreEvents = false;
                    return false;
                }
            }
            if (this.ignoreEvents || (viewDragHelper = this.viewDragHelper) == null || !viewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
                WeakReference<View> weakReference2 = this.nestedScrollingChildRef;
                View view2 = weakReference2 != null ? weakReference2.get() : null;
                return (actionMasked != 2 || view2 == null || this.ignoreEvents || this.state == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.viewDragHelper == null || Math.abs(((float) this.initialY) - motionEvent.getY()) <= ((float) this.viewDragHelper.getTouchSlop())) ? false : true;
            }
            return true;
        }
        this.ignoreEvents = true;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, int i4) {
        MaterialShapeDrawable materialShapeDrawable;
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v3)) {
            v3.setFitsSystemWindows(true);
        }
        if (this.viewRef == null) {
            this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            setSystemGestureInsets(v3);
            this.viewRef = new WeakReference<>(v3);
            if (this.shapeThemingEnabled && (materialShapeDrawable = this.materialShapeDrawable) != null) {
                ViewCompat.setBackground(v3, materialShapeDrawable);
            }
            MaterialShapeDrawable materialShapeDrawable2 = this.materialShapeDrawable;
            if (materialShapeDrawable2 != null) {
                float f4 = this.elevation;
                if (f4 == -1.0f) {
                    f4 = ViewCompat.getElevation(v3);
                }
                materialShapeDrawable2.setElevation(f4);
                boolean z3 = this.state == 3;
                this.isShapeExpanded = z3;
                this.materialShapeDrawable.setInterpolation(z3 ? 0.0f : 1.0f);
            }
            updateAccessibilityActions();
            if (ViewCompat.getImportantForAccessibility(v3) == 0) {
                ViewCompat.setImportantForAccessibility(v3, 1);
            }
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = ViewDragHelper.create(coordinatorLayout, this.dragCallback);
        }
        int top2 = v3.getTop();
        coordinatorLayout.onLayoutChild(v3, i4);
        this.parentWidth = coordinatorLayout.getWidth();
        this.parentHeight = coordinatorLayout.getHeight();
        int height = v3.getHeight();
        this.childHeight = height;
        this.fitToContentsOffset = Math.max(0, this.parentHeight - height);
        calculateHalfExpandedOffset();
        calculateCollapsedOffset();
        int i5 = this.state;
        if (i5 == 3) {
            ViewCompat.offsetTopAndBottom(v3, getExpandedOffset());
        } else if (i5 == 6) {
            ViewCompat.offsetTopAndBottom(v3, this.halfExpandedOffset);
        } else if (this.hideable && i5 == 5) {
            ViewCompat.offsetTopAndBottom(v3, this.parentHeight);
        } else if (i5 == 4) {
            ViewCompat.offsetTopAndBottom(v3, this.collapsedOffset);
        } else if (i5 == 1 || i5 == 2) {
            ViewCompat.offsetTopAndBottom(v3, top2 - v3.getTop());
        }
        this.nestedScrollingChildRef = new WeakReference<>(findScrollingChild(v3));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, float f4, float f5) {
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        return this.state != 3 || super.onNestedPreFling(coordinatorLayout, v3, view, f4, f5);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, int i4, int i5, @NonNull int[] iArr, int i6) {
        if (i6 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (view != (weakReference != null ? weakReference.get() : null)) {
            return;
        }
        int top2 = v3.getTop();
        int i7 = top2 - i5;
        if (i5 > 0) {
            if (i7 < getExpandedOffset()) {
                iArr[1] = top2 - getExpandedOffset();
                ViewCompat.offsetTopAndBottom(v3, -iArr[1]);
                setStateInternal(3);
            } else if (!this.draggable) {
                return;
            } else {
                iArr[1] = i5;
                ViewCompat.offsetTopAndBottom(v3, -i5);
                setStateInternal(1);
            }
        } else if (i5 < 0 && !view.canScrollVertically(-1)) {
            int i8 = this.collapsedOffset;
            if (i7 > i8 && !this.hideable) {
                iArr[1] = top2 - i8;
                ViewCompat.offsetTopAndBottom(v3, -iArr[1]);
                setStateInternal(4);
            } else if (!this.draggable) {
                return;
            } else {
                iArr[1] = i5;
                ViewCompat.offsetTopAndBottom(v3, -i5);
                setStateInternal(1);
            }
        }
        dispatchOnSlide(v3.getTop());
        this.lastNestedScrollDy = i5;
        this.nestedScrolled = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, int i4, int i5, int i6, int i7, int i8, @NonNull int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v3, savedState.getSuperState());
        restoreOptionalState(savedState);
        int i4 = savedState.state;
        if (i4 != 1 && i4 != 2) {
            this.state = i4;
        } else {
            this.state = 4;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @NonNull
    public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v3), (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, @NonNull View view2, int i4, int i5) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        return (i4 & 2) != 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, int i4) {
        int i5;
        int i6 = 3;
        if (v3.getTop() == getExpandedOffset()) {
            setStateInternal(3);
            return;
        }
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference != null && view == weakReference.get() && this.nestedScrolled) {
            if (this.lastNestedScrollDy > 0) {
                if (this.fitToContents) {
                    i5 = this.fitToContentsOffset;
                } else {
                    int top2 = v3.getTop();
                    int i7 = this.halfExpandedOffset;
                    if (top2 > i7) {
                        i5 = i7;
                        i6 = 6;
                    } else {
                        i5 = this.expandedOffset;
                    }
                }
            } else if (this.hideable && shouldHide(v3, getYVelocity())) {
                i5 = this.parentHeight;
                i6 = 5;
            } else if (this.lastNestedScrollDy == 0) {
                int top3 = v3.getTop();
                if (this.fitToContents) {
                    if (Math.abs(top3 - this.fitToContentsOffset) < Math.abs(top3 - this.collapsedOffset)) {
                        i5 = this.fitToContentsOffset;
                    } else {
                        i5 = this.collapsedOffset;
                        i6 = 4;
                    }
                } else {
                    int i8 = this.halfExpandedOffset;
                    if (top3 < i8) {
                        if (top3 < Math.abs(top3 - this.collapsedOffset)) {
                            i5 = this.expandedOffset;
                        } else {
                            i5 = this.halfExpandedOffset;
                        }
                    } else if (Math.abs(top3 - i8) < Math.abs(top3 - this.collapsedOffset)) {
                        i5 = this.halfExpandedOffset;
                    } else {
                        i5 = this.collapsedOffset;
                        i6 = 4;
                    }
                    i6 = 6;
                }
            } else {
                if (this.fitToContents) {
                    i5 = this.collapsedOffset;
                } else {
                    int top4 = v3.getTop();
                    if (Math.abs(top4 - this.halfExpandedOffset) < Math.abs(top4 - this.collapsedOffset)) {
                        i5 = this.halfExpandedOffset;
                        i6 = 6;
                    } else {
                        i5 = this.collapsedOffset;
                    }
                }
                i6 = 4;
            }
            startSettlingAnimation(v3, i6, i5, false);
            this.nestedScrolled = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull MotionEvent motionEvent) {
        if (v3.isShown()) {
            int actionMasked = motionEvent.getActionMasked();
            if (this.state == 1 && actionMasked == 0) {
                return true;
            }
            ViewDragHelper viewDragHelper = this.viewDragHelper;
            if (viewDragHelper != null) {
                viewDragHelper.processTouchEvent(motionEvent);
            }
            if (actionMasked == 0) {
                reset();
            }
            if (this.velocityTracker == null) {
                this.velocityTracker = VelocityTracker.obtain();
            }
            this.velocityTracker.addMovement(motionEvent);
            if (this.viewDragHelper != null && actionMasked == 2 && !this.ignoreEvents && Math.abs(this.initialY - motionEvent.getY()) > this.viewDragHelper.getTouchSlop()) {
                this.viewDragHelper.captureChildView(v3, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
            return !this.ignoreEvents;
        }
        return false;
    }

    public void removeBottomSheetCallback(@NonNull BottomSheetCallback bottomSheetCallback) {
        this.callbacks.remove(bottomSheetCallback);
    }

    @Deprecated
    public void setBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        Log.w("BottomSheetBehavior", "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.callbacks.clear();
        if (bottomSheetCallback != null) {
            this.callbacks.add(bottomSheetCallback);
        }
    }

    public void setDraggable(boolean z3) {
        this.draggable = z3;
    }

    public void setExpandedOffset(int i4) {
        if (i4 >= 0) {
            this.expandedOffset = i4;
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public void setFitToContents(boolean z3) {
        if (this.fitToContents == z3) {
            return;
        }
        this.fitToContents = z3;
        if (this.viewRef != null) {
            calculateCollapsedOffset();
        }
        setStateInternal((this.fitToContents && this.state == 6) ? 3 : this.state);
        updateAccessibilityActions();
    }

    public void setGestureInsetBottomIgnored(boolean z3) {
        this.gestureInsetBottomIgnored = z3;
    }

    public void setHalfExpandedRatio(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        if (f4 > 0.0f && f4 < 1.0f) {
            this.halfExpandedRatio = f4;
            if (this.viewRef != null) {
                calculateHalfExpandedOffset();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    public void setHideable(boolean z3) {
        if (this.hideable != z3) {
            this.hideable = z3;
            if (!z3 && this.state == 5) {
                setState(4);
            }
            updateAccessibilityActions();
        }
    }

    public void setPeekHeight(int i4) {
        setPeekHeight(i4, false);
    }

    public void setSaveFlags(int i4) {
        this.saveFlags = i4;
    }

    public void setSkipCollapsed(boolean z3) {
        this.skipCollapsed = z3;
    }

    public void setState(int i4) {
        if (i4 == this.state) {
            return;
        }
        if (this.viewRef == null) {
            if (i4 == 4 || i4 == 3 || i4 == 6 || (this.hideable && i4 == 5)) {
                this.state = i4;
                return;
            }
            return;
        }
        settleToStatePendingLayout(i4);
    }

    void setStateInternal(int i4) {
        V v3;
        if (this.state == i4) {
            return;
        }
        this.state = i4;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || (v3 = weakReference.get()) == null) {
            return;
        }
        if (i4 == 3) {
            updateImportantForAccessibility(true);
        } else if (i4 == 6 || i4 == 5 || i4 == 4) {
            updateImportantForAccessibility(false);
        }
        updateDrawableForTargetState(i4);
        for (int i5 = 0; i5 < this.callbacks.size(); i5++) {
            this.callbacks.get(i5).onStateChanged(v3, i4);
        }
        updateAccessibilityActions();
    }

    public void setUpdateImportantForAccessibilityOnSiblings(boolean z3) {
        this.updateImportantForAccessibilityOnSiblings = z3;
    }

    void settleToState(@NonNull View view, int i4) {
        int i5;
        int i6;
        if (i4 == 4) {
            i5 = this.collapsedOffset;
        } else if (i4 == 6) {
            int i7 = this.halfExpandedOffset;
            if (!this.fitToContents || i7 > (i6 = this.fitToContentsOffset)) {
                i5 = i7;
            } else {
                i5 = i6;
                i4 = 3;
            }
        } else if (i4 == 3) {
            i5 = getExpandedOffset();
        } else if (this.hideable && i4 == 5) {
            i5 = this.parentHeight;
        } else {
            throw new IllegalArgumentException("Illegal state argument: " + i4);
        }
        startSettlingAnimation(view, i4, i5, false);
    }

    boolean shouldHide(@NonNull View view, float f4) {
        if (this.skipCollapsed) {
            return true;
        }
        if (view.getTop() < this.collapsedOffset) {
            return false;
        }
        return Math.abs((((float) view.getTop()) + (f4 * 0.1f)) - ((float) this.collapsedOffset)) / ((float) calculatePeekHeight()) > 0.5f;
    }

    void startSettlingAnimation(View view, int i4, int i5, boolean z3) {
        ViewDragHelper viewDragHelper = this.viewDragHelper;
        if (viewDragHelper != null && (!z3 ? !viewDragHelper.smoothSlideViewTo(view, view.getLeft(), i5) : !viewDragHelper.settleCapturedViewAt(view.getLeft(), i5))) {
            setStateInternal(2);
            updateDrawableForTargetState(i4);
            if (this.settleRunnable == null) {
                this.settleRunnable = new SettleRunnable(view, i4);
            }
            if (!((SettleRunnable) this.settleRunnable).isPosted) {
                BottomSheetBehavior<V>.SettleRunnable settleRunnable = this.settleRunnable;
                settleRunnable.targetState = i4;
                ViewCompat.postOnAnimation(view, settleRunnable);
                ((SettleRunnable) this.settleRunnable).isPosted = true;
                return;
            }
            this.settleRunnable.targetState = i4;
            return;
        }
        setStateInternal(i4);
    }

    private void createMaterialShapeDrawable(@NonNull Context context, AttributeSet attributeSet, boolean z3, @Nullable ColorStateList colorStateList) {
        if (this.shapeThemingEnabled) {
            this.shapeAppearanceModelDefault = ShapeAppearanceModel.builder(context, attributeSet, R.attr.bottomSheetStyle, DEF_STYLE_RES).build();
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.shapeAppearanceModelDefault);
            this.materialShapeDrawable = materialShapeDrawable;
            materialShapeDrawable.initializeElevationOverlay(context);
            if (z3 && colorStateList != null) {
                this.materialShapeDrawable.setFillColor(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16842801, typedValue, true);
            this.materialShapeDrawable.setTint(typedValue.data);
        }
    }

    public final void setPeekHeight(int i4, boolean z3) {
        boolean z4 = true;
        if (i4 == -1) {
            if (!this.peekHeightAuto) {
                this.peekHeightAuto = true;
            }
            z4 = false;
        } else {
            if (this.peekHeightAuto || this.peekHeight != i4) {
                this.peekHeightAuto = false;
                this.peekHeight = Math.max(0, i4);
            }
            z4 = false;
        }
        if (z4) {
            updatePeekHeight(z3);
        }
    }

    public BottomSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        int i4;
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.settleRunnable = null;
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.callbacks = new ArrayList<>();
        this.dragCallback = new ViewDragHelper.Callback() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.4
            private boolean releasedLow(@NonNull View view) {
                int top2 = view.getTop();
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                return top2 > (bottomSheetBehavior.parentHeight + bottomSheetBehavior.getExpandedOffset()) / 2;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(@NonNull View view, int i42, int i5) {
                return view.getLeft();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(@NonNull View view, int i42, int i5) {
                int expandedOffset = BottomSheetBehavior.this.getExpandedOffset();
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                return MathUtils.clamp(i42, expandedOffset, bottomSheetBehavior.hideable ? bottomSheetBehavior.parentHeight : bottomSheetBehavior.collapsedOffset);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(@NonNull View view) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.hideable) {
                    return bottomSheetBehavior.parentHeight;
                }
                return bottomSheetBehavior.collapsedOffset;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewDragStateChanged(int i42) {
                if (i42 == 1 && BottomSheetBehavior.this.draggable) {
                    BottomSheetBehavior.this.setStateInternal(1);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(@NonNull View view, int i42, int i5, int i6, int i7) {
                BottomSheetBehavior.this.dispatchOnSlide(i5);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(@NonNull View view, float f4, float f5) {
                int i42;
                int i5 = 4;
                if (f5 < 0.0f) {
                    if (BottomSheetBehavior.this.fitToContents) {
                        i42 = BottomSheetBehavior.this.fitToContentsOffset;
                    } else {
                        int top2 = view.getTop();
                        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                        int i6 = bottomSheetBehavior.halfExpandedOffset;
                        if (top2 > i6) {
                            i42 = i6;
                            i5 = 6;
                        } else {
                            i42 = bottomSheetBehavior.expandedOffset;
                        }
                    }
                    i5 = 3;
                } else {
                    BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                    if (bottomSheetBehavior2.hideable && bottomSheetBehavior2.shouldHide(view, f5)) {
                        if ((Math.abs(f4) < Math.abs(f5) && f5 > 500.0f) || releasedLow(view)) {
                            i42 = BottomSheetBehavior.this.parentHeight;
                            i5 = 5;
                        } else {
                            if (BottomSheetBehavior.this.fitToContents) {
                                i42 = BottomSheetBehavior.this.fitToContentsOffset;
                            } else if (Math.abs(view.getTop() - BottomSheetBehavior.this.expandedOffset) < Math.abs(view.getTop() - BottomSheetBehavior.this.halfExpandedOffset)) {
                                i42 = BottomSheetBehavior.this.expandedOffset;
                            } else {
                                i42 = BottomSheetBehavior.this.halfExpandedOffset;
                                i5 = 6;
                            }
                            i5 = 3;
                        }
                    } else if (f5 != 0.0f && Math.abs(f4) <= Math.abs(f5)) {
                        if (BottomSheetBehavior.this.fitToContents) {
                            i42 = BottomSheetBehavior.this.collapsedOffset;
                        } else {
                            int top3 = view.getTop();
                            if (Math.abs(top3 - BottomSheetBehavior.this.halfExpandedOffset) < Math.abs(top3 - BottomSheetBehavior.this.collapsedOffset)) {
                                i42 = BottomSheetBehavior.this.halfExpandedOffset;
                                i5 = 6;
                            } else {
                                i42 = BottomSheetBehavior.this.collapsedOffset;
                            }
                        }
                    } else {
                        int top4 = view.getTop();
                        if (BottomSheetBehavior.this.fitToContents) {
                            if (Math.abs(top4 - BottomSheetBehavior.this.fitToContentsOffset) < Math.abs(top4 - BottomSheetBehavior.this.collapsedOffset)) {
                                i42 = BottomSheetBehavior.this.fitToContentsOffset;
                                i5 = 3;
                            } else {
                                i42 = BottomSheetBehavior.this.collapsedOffset;
                            }
                        } else {
                            BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                            int i7 = bottomSheetBehavior3.halfExpandedOffset;
                            if (top4 < i7) {
                                if (top4 < Math.abs(top4 - bottomSheetBehavior3.collapsedOffset)) {
                                    i42 = BottomSheetBehavior.this.expandedOffset;
                                    i5 = 3;
                                } else {
                                    i42 = BottomSheetBehavior.this.halfExpandedOffset;
                                }
                            } else if (Math.abs(top4 - i7) < Math.abs(top4 - BottomSheetBehavior.this.collapsedOffset)) {
                                i42 = BottomSheetBehavior.this.halfExpandedOffset;
                            } else {
                                i42 = BottomSheetBehavior.this.collapsedOffset;
                            }
                            i5 = 6;
                        }
                    }
                }
                BottomSheetBehavior.this.startSettlingAnimation(view, i5, i42, true);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(@NonNull View view, int i42) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                int i5 = bottomSheetBehavior.state;
                if (i5 == 1 || bottomSheetBehavior.touchingScrollingChild) {
                    return false;
                }
                if (i5 == 3 && bottomSheetBehavior.activePointerId == i42) {
                    WeakReference<View> weakReference = bottomSheetBehavior.nestedScrollingChildRef;
                    View view2 = weakReference != null ? weakReference.get() : null;
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                WeakReference<V> weakReference2 = BottomSheetBehavior.this.viewRef;
                return weakReference2 != null && weakReference2.get() == view;
            }
        };
        this.peekHeightGestureInsetBuffer = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        this.shapeThemingEnabled = obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance);
        int i5 = R.styleable.BottomSheetBehavior_Layout_backgroundTint;
        boolean hasValue = obtainStyledAttributes.hasValue(i5);
        if (hasValue) {
            createMaterialShapeDrawable(context, attributeSet, hasValue, MaterialResources.getColorStateList(context, obtainStyledAttributes, i5));
        } else {
            createMaterialShapeDrawable(context, attributeSet, hasValue);
        }
        createShapeValueAnimator();
        if (Build.VERSION.SDK_INT >= 21) {
            this.elevation = obtainStyledAttributes.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        }
        int i6 = R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i6);
        if (peekValue != null && (i4 = peekValue.data) == -1) {
            setPeekHeight(i4);
        } else {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(i6, -1));
        }
        setHideable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setGestureInsetBottomIgnored(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        setFitToContents(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        setDraggable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        setSaveFlags(obtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        setHalfExpandedRatio(obtainStyledAttributes.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        int i7 = R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(i7);
        if (peekValue2 != null && peekValue2.type == 16) {
            setExpandedOffset(peekValue2.data);
        } else {
            setExpandedOffset(obtainStyledAttributes.getDimensionPixelOffset(i7, 0));
        }
        obtainStyledAttributes.recycle();
        this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
