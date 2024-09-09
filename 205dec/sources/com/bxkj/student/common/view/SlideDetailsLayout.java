package com.bxkj.student.common.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.bxkj.student.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class SlideDetailsLayout extends ViewGroup {
    private static final int DEFAULT_DURATION = 300;
    private static final float DEFAULT_PERCENT = 0.2f;
    private boolean isFirstShowBehindView;
    private View mBehindView;
    private int mDefaultPanel;
    private long mDuration;
    private View mFrontView;
    private float mInitMotionX;
    private float mInitMotionY;
    private OnSlideDetailsListener mOnSlideDetailsListener;
    private float mPercent;
    private float mSlideOffset;
    private Status mStatus;
    private View mTarget;
    private float mTouchSlop;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface OnSlideDetailsListener {
        void onStatucChanged(Status status);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public enum Status {
        CLOSE,
        OPEN;

        public static Status valueOf(int stats) {
            if (stats == 0) {
                return CLOSE;
            }
            if (1 == stats) {
                return OPEN;
            }
            return CLOSE;
        }
    }

    public SlideDetailsLayout(Context context) {
        this(context, null);
    }

    private void animatorSwitch(final float start, final float end) {
        animatorSwitch(start, end, true, this.mDuration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndFirstOpenPanel() {
        if (this.isFirstShowBehindView) {
            this.isFirstShowBehindView = false;
            this.mBehindView.setVisibility(0);
        }
    }

    private void ensureTarget() {
        if (this.mStatus == Status.CLOSE) {
            this.mTarget = this.mFrontView;
        } else {
            this.mTarget = this.mBehindView;
        }
    }

    private void finishTouchEvent() {
        int measuredHeight;
        float measuredHeight2 = getMeasuredHeight();
        int i4 = (int) (this.mPercent * measuredHeight2);
        float f4 = this.mSlideOffset;
        Status status = Status.CLOSE;
        Status status2 = this.mStatus;
        boolean z3 = true;
        if (status != status2) {
            if (Status.OPEN == status2) {
                if (measuredHeight2 + f4 >= i4) {
                    this.mSlideOffset = 0.0f;
                    this.mStatus = status;
                } else {
                    this.mSlideOffset = -measuredHeight;
                }
            }
            z3 = false;
        } else if (f4 <= (-i4)) {
            this.mSlideOffset = -measuredHeight;
            this.mStatus = Status.OPEN;
        } else {
            this.mSlideOffset = 0.0f;
            z3 = false;
        }
        animatorSwitch(f4, this.mSlideOffset, z3);
    }

    private void processTouchEvent(final float offset) {
        if (Math.abs(offset) < this.mTouchSlop) {
            return;
        }
        float f4 = this.mSlideOffset;
        Status status = this.mStatus;
        if (status == Status.CLOSE) {
            if (offset >= 0.0f) {
                this.mSlideOffset = 0.0f;
            } else {
                this.mSlideOffset = offset;
            }
            if (this.mSlideOffset == f4) {
                return;
            }
        } else if (status == Status.OPEN) {
            float f5 = -getMeasuredHeight();
            if (offset <= 0.0f) {
                this.mSlideOffset = f5;
            } else {
                this.mSlideOffset = f5 + offset;
            }
            if (this.mSlideOffset == f4) {
                return;
            }
        }
        requestLayout();
    }

    protected boolean canChildScrollVertically(int direction) {
        View view = this.mTarget;
        if (view instanceof AbsListView) {
            return canListViewSroll((AbsListView) view);
        }
        if ((view instanceof FrameLayout) || (view instanceof RelativeLayout) || (view instanceof LinearLayout)) {
            for (int i4 = 0; i4 < ((ViewGroup) this.mTarget).getChildCount(); i4++) {
                View childAt = ((ViewGroup) this.mTarget).getChildAt(i4);
                if (childAt instanceof AbsListView) {
                    return canListViewSroll((AbsListView) childAt);
                }
            }
        }
        return ViewCompat.canScrollVertically(this.mTarget, -direction);
    }

    protected boolean canListViewSroll(AbsListView absListView) {
        int i4;
        if (this.mStatus == Status.OPEN) {
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        }
        int childCount = absListView.getChildCount();
        return childCount > 0 && (absListView.getLastVisiblePosition() < (i4 = childCount - 1) || absListView.getChildAt(i4).getBottom() > absListView.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new ViewGroup.MarginLayoutParams(getContext(), attrs);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (1 < getChildCount()) {
            this.mFrontView = getChildAt(0);
            this.mBehindView = getChildAt(1);
            if (this.mDefaultPanel == 1) {
                post(new Runnable() { // from class: com.bxkj.student.common.view.SlideDetailsLayout.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SlideDetailsLayout.this.smoothOpen(false);
                    }
                });
                return;
            }
            return;
        }
        throw new RuntimeException("SlideDetailsLayout only accept childs more than 1!!");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        ensureTarget();
        if (this.mTarget != null && isEnabled()) {
            int actionMasked = MotionEventCompat.getActionMasked(ev);
            if (actionMasked == 0) {
                this.mInitMotionX = ev.getX();
                this.mInitMotionY = ev.getY();
                return false;
            }
            if (actionMasked != 1 && actionMasked == 2) {
                float x3 = ev.getX();
                float y3 = ev.getY();
                float f4 = x3 - this.mInitMotionX;
                float f5 = y3 - this.mInitMotionY;
                if (canChildScrollVertically((int) f5)) {
                    return false;
                }
                float abs = Math.abs(f4);
                float abs2 = Math.abs(f5);
                if (abs2 <= this.mTouchSlop || abs2 < abs) {
                    return false;
                }
                Status status = this.mStatus;
                if (status != Status.CLOSE || f5 <= 0.0f) {
                    return status != Status.OPEN || f5 >= 0.0f;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l4, int t3, int r3, int b4) {
        int i4;
        int i5;
        int i6 = (int) this.mSlideOffset;
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                if (childAt == this.mBehindView) {
                    i4 = b4 + i6;
                    i5 = (i4 + b4) - t3;
                } else {
                    i4 = t3 + i6;
                    i5 = b4 + i6;
                }
                childAt.layout(l4, i4, r3, i5);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, makeMeasureSpec, makeMeasureSpec2);
            }
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable state) {
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mSlideOffset = savedState.offset;
        Status valueOf = Status.valueOf(savedState.status);
        this.mStatus = valueOf;
        if (valueOf == Status.OPEN) {
            this.mBehindView.setVisibility(0);
        }
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.offset = this.mSlideOffset;
        savedState.status = this.mStatus.ordinal();
        return savedState;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:
        if (r0 != 3) goto L15;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            r4.ensureTarget()
            android.view.View r0 = r4.mTarget
            r1 = 0
            if (r0 != 0) goto L9
            return r1
        L9:
            boolean r0 = r4.isEnabled()
            if (r0 != 0) goto L10
            return r1
        L10:
            int r0 = androidx.core.view.MotionEventCompat.getActionMasked(r5)
            r2 = 1
            if (r0 == 0) goto L37
            if (r0 == r2) goto L33
            r3 = 2
            if (r0 == r3) goto L20
            r5 = 3
            if (r0 == r5) goto L33
            goto L3b
        L20:
            float r5 = r5.getY()
            float r0 = r4.mInitMotionY
            float r5 = r5 - r0
            int r0 = (int) r5
            boolean r0 = r4.canChildScrollVertically(r0)
            if (r0 == 0) goto L2f
            goto L3c
        L2f:
            r4.processTouchEvent(r5)
            goto L3b
        L33:
            r4.finishTouchEvent()
            goto L3c
        L37:
            android.view.View r5 = r4.mTarget
            boolean r5 = r5 instanceof android.view.View
        L3b:
            r1 = 1
        L3c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.common.view.SlideDetailsLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setOnSlideDetailsListener(OnSlideDetailsListener listener) {
        this.mOnSlideDetailsListener = listener;
    }

    public void setPercent(float percent) {
        this.mPercent = percent;
    }

    public void smoothClose(boolean smooth) {
        Status status = this.mStatus;
        Status status2 = Status.CLOSE;
        if (status != status2) {
            this.mStatus = status2;
            animatorSwitch(-getMeasuredHeight(), 0.0f, true, smooth ? this.mDuration : 0L);
        }
    }

    public void smoothOpen(boolean smooth) {
        Status status = this.mStatus;
        Status status2 = Status.OPEN;
        if (status != status2) {
            this.mStatus = status2;
            animatorSwitch(0.0f, -getMeasuredHeight(), true, smooth ? this.mDuration : 0L);
        }
    }

    public SlideDetailsLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    private void animatorSwitch(final float start, final float end, final long duration) {
        animatorSwitch(start, end, true, duration);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p3) {
        return new ViewGroup.MarginLayoutParams(p3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.bxkj.student.common.view.SlideDetailsLayout.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        private float offset;
        private int status;

        public SavedState(Parcel source) {
            super(source);
            this.offset = source.readFloat();
            this.status = source.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeFloat(this.offset);
            out.writeInt(this.status);
        }

        public SavedState(Parcelable superState) {
            super(superState);
        }
    }

    public SlideDetailsLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mStatus = Status.CLOSE;
        this.isFirstShowBehindView = true;
        this.mPercent = 0.2f;
        this.mDuration = 300L;
        this.mDefaultPanel = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.SlideDetailsLayout, defStyleAttr, 0);
        this.mPercent = obtainStyledAttributes.getFloat(2, 0.2f);
        this.mDuration = obtainStyledAttributes.getInt(1, 300);
        this.mDefaultPanel = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private void animatorSwitch(final float start, final float end, final boolean changed) {
        animatorSwitch(start, end, changed, this.mDuration);
    }

    private void animatorSwitch(final float start, final float end, final boolean changed, final long duration) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(start, end);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bxkj.student.common.view.SlideDetailsLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                SlideDetailsLayout.this.mSlideOffset = ((Float) animation.getAnimatedValue()).floatValue();
                SlideDetailsLayout.this.requestLayout();
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bxkj.student.common.view.SlideDetailsLayout.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (changed) {
                    if (SlideDetailsLayout.this.mStatus == Status.OPEN) {
                        SlideDetailsLayout.this.checkAndFirstOpenPanel();
                    }
                    if (SlideDetailsLayout.this.mOnSlideDetailsListener != null) {
                        SlideDetailsLayout.this.mOnSlideDetailsListener.onStatucChanged(SlideDetailsLayout.this.mStatus);
                    }
                }
            }
        });
        ofFloat.setDuration(duration);
        ofFloat.start();
    }
}
