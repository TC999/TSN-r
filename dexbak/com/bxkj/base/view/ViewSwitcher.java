package com.bxkj.base.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.orhanobut.logger.C11792j;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ViewSwitcher extends FrameLayout {

    /* renamed from: d */
    private static final int f15271d = 500;

    /* renamed from: e */
    private static final String f15272e = "translationY";

    /* renamed from: f */
    private static final int f15273f = 60;

    /* renamed from: a */
    private Context f15274a;

    /* renamed from: b */
    private boolean f15275b;

    /* renamed from: c */
    private View.OnClickListener f15276c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.base.view.ViewSwitcher$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class View$OnClickListenerC4001a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ int f15277a;

        /* renamed from: b */
        final /* synthetic */ View f15278b;

        View$OnClickListenerC4001a(int i, View view) {
            this.f15277a = i;
            this.f15278b = view;
        }

        /* renamed from: a */
        public void m43504a(int i) {
            ObjectAnimator ofFloat;
            C11792j.m20470c("onClickFirstCard");
            AnimatorSet animatorSet = new AnimatorSet();
            int childCount = ViewSwitcher.this.getChildCount();
            int i2 = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = ViewSwitcher.this.getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    if (i2 == i) {
                        ofFloat = ObjectAnimator.ofFloat(childAt, ViewSwitcher.f15272e, ViewSwitcher.m43507f(ViewSwitcher.this.f15274a, (ViewSwitcher.this.getRealChildCount() - 1) * (-60)), 0.0f);
                        ofFloat.addListener(ViewSwitcher.this.m43506g(i2, this.f15278b, childCount));
                    } else {
                        float m43507f = ViewSwitcher.m43507f(ViewSwitcher.this.f15274a, (i2 - 1) * 60);
                        ofFloat = ObjectAnimator.ofFloat(childAt, ViewSwitcher.f15272e, childAt.getY() - m43507f, (childAt.getY() - m43507f) - ViewSwitcher.m43507f(ViewSwitcher.this.f15274a, 60.0f));
                    }
                    if (ofFloat != null) {
                        ofFloat.setDuration(500L);
                        animatorSet.play(ofFloat);
                    }
                    i2++;
                }
            }
            animatorSet.start();
        }

        /* renamed from: b */
        public void m43503b() {
            ObjectAnimator ofFloat;
            C11792j.m20470c("onClickFirstCard");
            AnimatorSet animatorSet = new AnimatorSet();
            int childCount = ViewSwitcher.this.getChildCount();
            int i = 0;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = ViewSwitcher.this.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    if (i == 0) {
                        float m43507f = ViewSwitcher.m43507f(ViewSwitcher.this.f15274a, (ViewSwitcher.this.getRealChildCount() - 1) * (-60));
                        C11792j.m20470c("onClickFirstCard-downFactor=" + m43507f);
                        ofFloat = ObjectAnimator.ofFloat(childAt, ViewSwitcher.f15272e, m43507f, 0.0f);
                        ofFloat.addListener(ViewSwitcher.this.m43506g(i, this.f15278b, childCount));
                    } else {
                        float m43507f2 = ViewSwitcher.m43507f(ViewSwitcher.this.f15274a, (i - 1) * 60);
                        C11792j.m20470c("onClickFirstCard-upFactor=" + m43507f2);
                        ofFloat = ObjectAnimator.ofFloat(childAt, ViewSwitcher.f15272e, childAt.getY() - m43507f2, (childAt.getY() - m43507f2) - ((float) ViewSwitcher.m43507f(ViewSwitcher.this.f15274a, 60.0f)));
                    }
                    if (ofFloat != null) {
                        ofFloat.setDuration(500L);
                        animatorSet.play(ofFloat);
                    }
                    i++;
                }
            }
            animatorSet.start();
        }

        /* renamed from: c */
        public void m43502c(int i, View view) {
            ObjectAnimator ofFloat;
            C11792j.m20470c("onClickOtherCard");
            AnimatorSet animatorSet = new AnimatorSet();
            int childCount = ViewSwitcher.this.getChildCount();
            int i2 = 0;
            for (int i3 = i; i3 < childCount; i3++) {
                View childAt = ViewSwitcher.this.getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    if (i2 == i) {
                        float m43507f = ViewSwitcher.m43507f(ViewSwitcher.this.f15274a, ((ViewSwitcher.this.getRealChildCount() - i2) - 1) * (-60));
                        C11792j.m20470c("onClickOtherCard-downFactor=" + m43507f);
                        ofFloat = ObjectAnimator.ofFloat(childAt, ViewSwitcher.f15272e, m43507f, 0.0f);
                        ofFloat.addListener(ViewSwitcher.this.m43506g(i2, view, childCount));
                    } else {
                        float m43507f2 = ViewSwitcher.m43507f(ViewSwitcher.this.f15274a, (i2 - 1) * 60);
                        C11792j.m20470c("onClickOtherCard-upFactor=" + m43507f2);
                        ofFloat = ObjectAnimator.ofFloat(childAt, ViewSwitcher.f15272e, childAt.getY() - m43507f2, (childAt.getY() - m43507f2) - ((float) ViewSwitcher.m43507f(ViewSwitcher.this.f15274a, 60.0f)));
                    }
                    if (ofFloat != null) {
                        ofFloat.setDuration(500L);
                        animatorSet.play(ofFloat);
                    }
                    i2++;
                }
            }
            animatorSet.start();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ViewSwitcher.this.f15275b) {
                return;
            }
            if (this.f15277a != ViewSwitcher.this.getRealChildCount() - 1) {
                ViewSwitcher.this.f15275b = true;
                m43504a(this.f15277a);
                return;
            }
            if (ViewSwitcher.this.f15276c != null) {
                ViewSwitcher.this.f15276c.onClick(this.f15278b);
            }
            Log.d("---------------", "--onClickEndCard------------------------");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.base.view.ViewSwitcher$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4002b implements Animator.AnimatorListener {

        /* renamed from: a */
        final /* synthetic */ View f15280a;

        C4002b(View view) {
            this.f15280a = view;
        }

        /* renamed from: a */
        private void m43501a(View view) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Log.d("--------------", "-----------------onAnimationCancel-----------------");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Log.d("--------------", "-----------------onAnimationEnd-----------------");
            ViewSwitcher.this.f15275b = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Log.d("--------------", "-----------------onAnimationRepeat-----------------");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Log.d("--------------", "-----------------onAnimationStart-----------------");
            ViewSwitcher.this.removeView(this.f15280a);
            ViewSwitcher.this.addView(this.f15280a);
        }
    }

    public ViewSwitcher(Context context) {
        this(context, null);
    }

    /* renamed from: f */
    public static int m43507f(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public Animator.AnimatorListener m43506g(int i, View view, int i2) {
        return new C4002b(view);
    }

    /* renamed from: h */
    private View.OnClickListener m43505h(View view, int i) {
        return new View$OnClickListenerC4001a(i, view);
    }

    public View.OnClickListener getClickListener() {
        return this.f15276c;
    }

    public int getRealChildCount() {
        int childCount = super.getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() == 0) {
                i++;
            }
        }
        return i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 0) {
                measureChild(childAt, i, i2);
                int measuredHeight = childAt.getMeasuredHeight();
                if (i4 != 0) {
                    measuredHeight = m43507f(this.f15274a, 60.0f);
                }
                i3 += measuredHeight;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.setMargins(0, m43507f(this.f15274a, i5), 0, 0);
                childAt.setLayoutParams(layoutParams);
                childAt.setOnClickListener(m43505h(childAt, i4));
                i4++;
                i5 += 60;
            }
        }
        super.onMeasure(i, i3);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f15276c = onClickListener;
    }

    public ViewSwitcher(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewSwitcher(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15274a = context;
    }
}
