package com.mcxtzhang.swipemenulib;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SwipeMenuLayout extends ViewGroup {

    /* renamed from: u  reason: collision with root package name */
    private static final String f41316u = "zxt/SwipeMenuLayout";

    /* renamed from: v  reason: collision with root package name */
    private static SwipeMenuLayout f41317v;

    /* renamed from: w  reason: collision with root package name */
    private static boolean f41318w;

    /* renamed from: a  reason: collision with root package name */
    private int f41319a;

    /* renamed from: b  reason: collision with root package name */
    private int f41320b;

    /* renamed from: c  reason: collision with root package name */
    private int f41321c;

    /* renamed from: d  reason: collision with root package name */
    private int f41322d;

    /* renamed from: e  reason: collision with root package name */
    private int f41323e;

    /* renamed from: f  reason: collision with root package name */
    private int f41324f;

    /* renamed from: g  reason: collision with root package name */
    private View f41325g;

    /* renamed from: h  reason: collision with root package name */
    private PointF f41326h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f41327i;

    /* renamed from: j  reason: collision with root package name */
    private PointF f41328j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f41329k;

    /* renamed from: l  reason: collision with root package name */
    private VelocityTracker f41330l;

    /* renamed from: m  reason: collision with root package name */
    private Log f41331m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f41332n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f41333o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f41334p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f41335q;

    /* renamed from: r  reason: collision with root package name */
    private ValueAnimator f41336r;

    /* renamed from: s  reason: collision with root package name */
    private ValueAnimator f41337s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f41338t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SwipeMenuLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SwipeMenuLayout.this.f41338t = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SwipeMenuLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SwipeMenuLayout.this.f41338t = false;
        }
    }

    public SwipeMenuLayout(Context context) {
        this(context, null);
    }

    private void b(MotionEvent motionEvent) {
        if (this.f41330l == null) {
            this.f41330l = VelocityTracker.obtain();
        }
        this.f41330l.addMovement(motionEvent);
    }

    private void c() {
        ValueAnimator valueAnimator = this.f41337s;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f41337s.cancel();
        }
        ValueAnimator valueAnimator2 = this.f41336r;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            return;
        }
        this.f41336r.cancel();
    }

    private void d(int i4, int i5) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i6 = 0; i6 < i4; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                if (marginLayoutParams.height == -1) {
                    int i7 = marginLayoutParams.width;
                    marginLayoutParams.width = childAt.getMeasuredWidth();
                    measureChildWithMargins(childAt, i5, 0, makeMeasureSpec, 0);
                    marginLayoutParams.width = i7;
                }
            }
        }
    }

    private void e(Context context, AttributeSet attributeSet, int i4) {
        this.f41319a = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f41320b = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.f41332n = true;
        this.f41333o = true;
        this.f41335q = true;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SwipeMenuLayout, i4, 0);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i5 = 0; i5 < indexCount; i5++) {
            int index = obtainStyledAttributes.getIndex(i5);
            if (index == R.styleable.SwipeMenuLayout_swipeEnable) {
                this.f41332n = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == R.styleable.SwipeMenuLayout_ios) {
                this.f41333o = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == R.styleable.SwipeMenuLayout_leftSwipe) {
                this.f41335q = obtainStyledAttributes.getBoolean(index, true);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public static SwipeMenuLayout getViewCache() {
        return f41317v;
    }

    private void j() {
        VelocityTracker velocityTracker = this.f41330l;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f41330l.recycle();
            this.f41330l = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        if (r1 != 3) goto L67;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r6) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mcxtzhang.swipemenulib.SwipeMenuLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean f() {
        return this.f41333o;
    }

    public boolean g() {
        return this.f41335q;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public boolean h() {
        return this.f41332n;
    }

    public void i() {
        if (this == f41317v) {
            c();
            f41317v.scrollTo(0, 0);
            f41317v = null;
        }
    }

    public SwipeMenuLayout k(boolean z3) {
        this.f41333o = z3;
        return this;
    }

    public SwipeMenuLayout l(boolean z3) {
        this.f41335q = z3;
        return this;
    }

    public void m() {
        f41317v = null;
        View view = this.f41325g;
        if (view != null) {
            view.setLongClickable(true);
        }
        c();
        ValueAnimator ofInt = ValueAnimator.ofInt(getScrollX(), 0);
        this.f41337s = ofInt;
        ofInt.addUpdateListener(new c());
        this.f41337s.setInterpolator(new AccelerateInterpolator());
        this.f41337s.addListener(new d());
        this.f41337s.setDuration(300L).start();
    }

    public void n() {
        f41317v = this;
        View view = this.f41325g;
        if (view != null) {
            view.setLongClickable(false);
        }
        c();
        int[] iArr = new int[2];
        iArr[0] = getScrollX();
        iArr[1] = this.f41335q ? this.f41323e : -this.f41323e;
        ValueAnimator ofInt = ValueAnimator.ofInt(iArr);
        this.f41336r = ofInt;
        ofInt.addUpdateListener(new a());
        this.f41336r.setInterpolator(new OvershootInterpolator());
        this.f41336r.addListener(new b());
        this.f41336r.setDuration(300L).start();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        SwipeMenuLayout swipeMenuLayout = f41317v;
        if (this == swipeMenuLayout) {
            swipeMenuLayout.m();
            f41317v = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f41332n) {
            int action = motionEvent.getAction();
            if (action != 1) {
                if (action == 2 && Math.abs(motionEvent.getRawX() - this.f41328j.x) > this.f41319a) {
                    return true;
                }
            } else {
                if (this.f41335q) {
                    if (getScrollX() > this.f41319a && motionEvent.getX() < getWidth() - getScrollX()) {
                        if (this.f41327i) {
                            m();
                        }
                        return true;
                    }
                } else if ((-getScrollX()) > this.f41319a && motionEvent.getX() > (-getScrollX())) {
                    if (this.f41327i) {
                        m();
                    }
                    return true;
                }
                if (this.f41329k) {
                    return true;
                }
            }
            if (this.f41334p) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        int measuredWidth;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft() + 0;
        int paddingLeft2 = getPaddingLeft() + 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                if (i8 == 0) {
                    childAt.layout(paddingLeft, getPaddingTop(), childAt.getMeasuredWidth() + paddingLeft, getPaddingTop() + childAt.getMeasuredHeight());
                    measuredWidth = childAt.getMeasuredWidth();
                } else if (this.f41335q) {
                    childAt.layout(paddingLeft, getPaddingTop(), childAt.getMeasuredWidth() + paddingLeft, getPaddingTop() + childAt.getMeasuredHeight());
                    measuredWidth = childAt.getMeasuredWidth();
                } else {
                    childAt.layout(paddingLeft2 - childAt.getMeasuredWidth(), getPaddingTop(), paddingLeft2, getPaddingTop() + childAt.getMeasuredHeight());
                    paddingLeft2 -= childAt.getMeasuredWidth();
                }
                paddingLeft += measuredWidth;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        setClickable(true);
        this.f41323e = 0;
        this.f41322d = 0;
        int childCount = getChildCount();
        boolean z3 = View.MeasureSpec.getMode(i5) != 1073741824;
        int i6 = 0;
        boolean z4 = false;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            childAt.setClickable(true);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i4, i5);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                this.f41322d = Math.max(this.f41322d, childAt.getMeasuredHeight());
                if (z3 && marginLayoutParams.height == -1) {
                    z4 = true;
                }
                if (i7 > 0) {
                    this.f41323e += childAt.getMeasuredWidth();
                } else {
                    this.f41325g = childAt;
                    i6 = childAt.getMeasuredWidth();
                }
            }
        }
        setMeasuredDimension(getPaddingLeft() + getPaddingRight() + i6, this.f41322d + getPaddingTop() + getPaddingBottom());
        this.f41324f = (this.f41323e * 4) / 10;
        if (z4) {
            d(childCount, i4);
        }
    }

    @Override // android.view.View
    public boolean performLongClick() {
        if (Math.abs(getScrollX()) > this.f41319a) {
            return false;
        }
        return super.performLongClick();
    }

    public void setSwipeEnable(boolean z3) {
        this.f41332n = z3;
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f41326h = new PointF();
        this.f41327i = true;
        this.f41328j = new PointF();
        e(context, attributeSet, i4);
    }
}
