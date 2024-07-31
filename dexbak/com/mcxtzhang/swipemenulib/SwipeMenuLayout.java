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

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SwipeMenuLayout extends ViewGroup {

    /* renamed from: u */
    private static final String f32629u = "zxt/SwipeMenuLayout";

    /* renamed from: v */
    private static SwipeMenuLayout f32630v;

    /* renamed from: w */
    private static boolean f32631w;

    /* renamed from: a */
    private int f32632a;

    /* renamed from: b */
    private int f32633b;

    /* renamed from: c */
    private int f32634c;

    /* renamed from: d */
    private int f32635d;

    /* renamed from: e */
    private int f32636e;

    /* renamed from: f */
    private int f32637f;

    /* renamed from: g */
    private View f32638g;

    /* renamed from: h */
    private PointF f32639h;

    /* renamed from: i */
    private boolean f32640i;

    /* renamed from: j */
    private PointF f32641j;

    /* renamed from: k */
    private boolean f32642k;

    /* renamed from: l */
    private VelocityTracker f32643l;

    /* renamed from: m */
    private Log f32644m;

    /* renamed from: n */
    private boolean f32645n;

    /* renamed from: o */
    private boolean f32646o;

    /* renamed from: p */
    private boolean f32647p;

    /* renamed from: q */
    private boolean f32648q;

    /* renamed from: r */
    private ValueAnimator f32649r;

    /* renamed from: s */
    private ValueAnimator f32650s;

    /* renamed from: t */
    private boolean f32651t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mcxtzhang.swipemenulib.SwipeMenuLayout$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C11782a implements ValueAnimator.AnimatorUpdateListener {
        C11782a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SwipeMenuLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mcxtzhang.swipemenulib.SwipeMenuLayout$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C11783b extends AnimatorListenerAdapter {
        C11783b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SwipeMenuLayout.this.f32651t = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mcxtzhang.swipemenulib.SwipeMenuLayout$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C11784c implements ValueAnimator.AnimatorUpdateListener {
        C11784c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SwipeMenuLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mcxtzhang.swipemenulib.SwipeMenuLayout$d */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C11785d extends AnimatorListenerAdapter {
        C11785d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SwipeMenuLayout.this.f32651t = false;
        }
    }

    public SwipeMenuLayout(Context context) {
        this(context, null);
    }

    /* renamed from: b */
    private void m20500b(MotionEvent motionEvent) {
        if (this.f32643l == null) {
            this.f32643l = VelocityTracker.obtain();
        }
        this.f32643l.addMovement(motionEvent);
    }

    /* renamed from: c */
    private void m20499c() {
        ValueAnimator valueAnimator = this.f32650s;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f32650s.cancel();
        }
        ValueAnimator valueAnimator2 = this.f32649r;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            return;
        }
        this.f32649r.cancel();
    }

    /* renamed from: d */
    private void m20498d(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                if (marginLayoutParams.height == -1) {
                    int i4 = marginLayoutParams.width;
                    marginLayoutParams.width = childAt.getMeasuredWidth();
                    measureChildWithMargins(childAt, i2, 0, makeMeasureSpec, 0);
                    marginLayoutParams.width = i4;
                }
            }
        }
    }

    /* renamed from: e */
    private void m20497e(Context context, AttributeSet attributeSet, int i) {
        this.f32632a = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f32633b = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.f32645n = true;
        this.f32646o = true;
        this.f32648q = true;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C11781R.styleable.SwipeMenuLayout, i, 0);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == C11781R.styleable.SwipeMenuLayout_swipeEnable) {
                this.f32645n = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == C11781R.styleable.SwipeMenuLayout_ios) {
                this.f32646o = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == C11781R.styleable.SwipeMenuLayout_leftSwipe) {
                this.f32648q = obtainStyledAttributes.getBoolean(index, true);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public static SwipeMenuLayout getViewCache() {
        return f32630v;
    }

    /* renamed from: j */
    private void m20492j() {
        VelocityTracker velocityTracker = this.f32643l;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f32643l.recycle();
            this.f32643l = null;
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

    /* renamed from: f */
    public boolean m20496f() {
        return this.f32646o;
    }

    /* renamed from: g */
    public boolean m20495g() {
        return this.f32648q;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    /* renamed from: h */
    public boolean m20494h() {
        return this.f32645n;
    }

    /* renamed from: i */
    public void m20493i() {
        if (this == f32630v) {
            m20499c();
            f32630v.scrollTo(0, 0);
            f32630v = null;
        }
    }

    /* renamed from: k */
    public SwipeMenuLayout m20491k(boolean z) {
        this.f32646o = z;
        return this;
    }

    /* renamed from: l */
    public SwipeMenuLayout m20490l(boolean z) {
        this.f32648q = z;
        return this;
    }

    /* renamed from: m */
    public void m20489m() {
        f32630v = null;
        View view = this.f32638g;
        if (view != null) {
            view.setLongClickable(true);
        }
        m20499c();
        ValueAnimator ofInt = ValueAnimator.ofInt(getScrollX(), 0);
        this.f32650s = ofInt;
        ofInt.addUpdateListener(new C11784c());
        this.f32650s.setInterpolator(new AccelerateInterpolator());
        this.f32650s.addListener(new C11785d());
        this.f32650s.setDuration(300L).start();
    }

    /* renamed from: n */
    public void m20488n() {
        f32630v = this;
        View view = this.f32638g;
        if (view != null) {
            view.setLongClickable(false);
        }
        m20499c();
        int[] iArr = new int[2];
        iArr[0] = getScrollX();
        iArr[1] = this.f32648q ? this.f32636e : -this.f32636e;
        ValueAnimator ofInt = ValueAnimator.ofInt(iArr);
        this.f32649r = ofInt;
        ofInt.addUpdateListener(new C11782a());
        this.f32649r.setInterpolator(new OvershootInterpolator());
        this.f32649r.addListener(new C11783b());
        this.f32649r.setDuration(300L).start();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        SwipeMenuLayout swipeMenuLayout = f32630v;
        if (this == swipeMenuLayout) {
            swipeMenuLayout.m20489m();
            f32630v = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f32645n) {
            int action = motionEvent.getAction();
            if (action != 1) {
                if (action == 2 && Math.abs(motionEvent.getRawX() - this.f32641j.x) > this.f32632a) {
                    return true;
                }
            } else {
                if (this.f32648q) {
                    if (getScrollX() > this.f32632a && motionEvent.getX() < getWidth() - getScrollX()) {
                        if (this.f32640i) {
                            m20489m();
                        }
                        return true;
                    }
                } else if ((-getScrollX()) > this.f32632a && motionEvent.getX() > (-getScrollX())) {
                    if (this.f32640i) {
                        m20489m();
                    }
                    return true;
                }
                if (this.f32642k) {
                    return true;
                }
            }
            if (this.f32647p) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft() + 0;
        int paddingLeft2 = getPaddingLeft() + 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                if (i5 == 0) {
                    childAt.layout(paddingLeft, getPaddingTop(), childAt.getMeasuredWidth() + paddingLeft, getPaddingTop() + childAt.getMeasuredHeight());
                    measuredWidth = childAt.getMeasuredWidth();
                } else if (this.f32648q) {
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
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setClickable(true);
        this.f32636e = 0;
        this.f32635d = 0;
        int childCount = getChildCount();
        boolean z = View.MeasureSpec.getMode(i2) != 1073741824;
        int i3 = 0;
        boolean z2 = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            childAt.setClickable(true);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i2);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                this.f32635d = Math.max(this.f32635d, childAt.getMeasuredHeight());
                if (z && marginLayoutParams.height == -1) {
                    z2 = true;
                }
                if (i4 > 0) {
                    this.f32636e += childAt.getMeasuredWidth();
                } else {
                    this.f32638g = childAt;
                    i3 = childAt.getMeasuredWidth();
                }
            }
        }
        setMeasuredDimension(getPaddingLeft() + getPaddingRight() + i3, this.f32635d + getPaddingTop() + getPaddingBottom());
        this.f32637f = (this.f32636e * 4) / 10;
        if (z2) {
            m20498d(childCount, i);
        }
    }

    @Override // android.view.View
    public boolean performLongClick() {
        if (Math.abs(getScrollX()) > this.f32632a) {
            return false;
        }
        return super.performLongClick();
    }

    public void setSwipeEnable(boolean z) {
        this.f32645n = z;
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f32639h = new PointF();
        this.f32640i = true;
        this.f32641j = new PointF();
        m20497e(context, attributeSet, i);
    }
}
