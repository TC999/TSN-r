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
import com.orhanobut.logger.j;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ViewSwitcher extends FrameLayout {

    /* renamed from: d  reason: collision with root package name */
    private static final int f18841d = 500;

    /* renamed from: e  reason: collision with root package name */
    private static final String f18842e = "translationY";

    /* renamed from: f  reason: collision with root package name */
    private static final int f18843f = 60;

    /* renamed from: a  reason: collision with root package name */
    private Context f18844a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f18845b;

    /* renamed from: c  reason: collision with root package name */
    private View.OnClickListener f18846c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f18847a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f18848b;

        a(int i4, View view) {
            this.f18847a = i4;
            this.f18848b = view;
        }

        public void a(int i4) {
            ObjectAnimator ofFloat;
            j.c("onClickFirstCard");
            AnimatorSet animatorSet = new AnimatorSet();
            int childCount = ViewSwitcher.this.getChildCount();
            int i5 = 0;
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = ViewSwitcher.this.getChildAt(i6);
                if (childAt.getVisibility() == 0) {
                    if (i5 == i4) {
                        ofFloat = ObjectAnimator.ofFloat(childAt, "translationY", ViewSwitcher.f(ViewSwitcher.this.f18844a, (ViewSwitcher.this.getRealChildCount() - 1) * (-60)), 0.0f);
                        ofFloat.addListener(ViewSwitcher.this.g(i5, this.f18848b, childCount));
                    } else {
                        float f4 = ViewSwitcher.f(ViewSwitcher.this.f18844a, (i5 - 1) * 60);
                        ofFloat = ObjectAnimator.ofFloat(childAt, "translationY", childAt.getY() - f4, (childAt.getY() - f4) - ViewSwitcher.f(ViewSwitcher.this.f18844a, 60.0f));
                    }
                    if (ofFloat != null) {
                        ofFloat.setDuration(500L);
                        animatorSet.play(ofFloat);
                    }
                    i5++;
                }
            }
            animatorSet.start();
        }

        public void b() {
            ObjectAnimator ofFloat;
            j.c("onClickFirstCard");
            AnimatorSet animatorSet = new AnimatorSet();
            int childCount = ViewSwitcher.this.getChildCount();
            int i4 = 0;
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = ViewSwitcher.this.getChildAt(i5);
                if (childAt.getVisibility() == 0) {
                    if (i4 == 0) {
                        float f4 = ViewSwitcher.f(ViewSwitcher.this.f18844a, (ViewSwitcher.this.getRealChildCount() - 1) * (-60));
                        j.c("onClickFirstCard-downFactor=" + f4);
                        ofFloat = ObjectAnimator.ofFloat(childAt, "translationY", f4, 0.0f);
                        ofFloat.addListener(ViewSwitcher.this.g(i4, this.f18848b, childCount));
                    } else {
                        float f5 = ViewSwitcher.f(ViewSwitcher.this.f18844a, (i4 - 1) * 60);
                        j.c("onClickFirstCard-upFactor=" + f5);
                        ofFloat = ObjectAnimator.ofFloat(childAt, "translationY", childAt.getY() - f5, (childAt.getY() - f5) - ((float) ViewSwitcher.f(ViewSwitcher.this.f18844a, 60.0f)));
                    }
                    if (ofFloat != null) {
                        ofFloat.setDuration(500L);
                        animatorSet.play(ofFloat);
                    }
                    i4++;
                }
            }
            animatorSet.start();
        }

        public void c(int i4, View view) {
            ObjectAnimator ofFloat;
            j.c("onClickOtherCard");
            AnimatorSet animatorSet = new AnimatorSet();
            int childCount = ViewSwitcher.this.getChildCount();
            int i5 = 0;
            for (int i6 = i4; i6 < childCount; i6++) {
                View childAt = ViewSwitcher.this.getChildAt(i6);
                if (childAt.getVisibility() == 0) {
                    if (i5 == i4) {
                        float f4 = ViewSwitcher.f(ViewSwitcher.this.f18844a, ((ViewSwitcher.this.getRealChildCount() - i5) - 1) * (-60));
                        j.c("onClickOtherCard-downFactor=" + f4);
                        ofFloat = ObjectAnimator.ofFloat(childAt, "translationY", f4, 0.0f);
                        ofFloat.addListener(ViewSwitcher.this.g(i5, view, childCount));
                    } else {
                        float f5 = ViewSwitcher.f(ViewSwitcher.this.f18844a, (i5 - 1) * 60);
                        j.c("onClickOtherCard-upFactor=" + f5);
                        ofFloat = ObjectAnimator.ofFloat(childAt, "translationY", childAt.getY() - f5, (childAt.getY() - f5) - ((float) ViewSwitcher.f(ViewSwitcher.this.f18844a, 60.0f)));
                    }
                    if (ofFloat != null) {
                        ofFloat.setDuration(500L);
                        animatorSet.play(ofFloat);
                    }
                    i5++;
                }
            }
            animatorSet.start();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ViewSwitcher.this.f18845b) {
                return;
            }
            if (this.f18847a != ViewSwitcher.this.getRealChildCount() - 1) {
                ViewSwitcher.this.f18845b = true;
                a(this.f18847a);
                return;
            }
            if (ViewSwitcher.this.f18846c != null) {
                ViewSwitcher.this.f18846c.onClick(this.f18848b);
            }
            Log.d("---------------", "--onClickEndCard------------------------");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f18850a;

        b(View view) {
            this.f18850a = view;
        }

        private void a(View view) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Log.d("--------------", "-----------------onAnimationCancel-----------------");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Log.d("--------------", "-----------------onAnimationEnd-----------------");
            ViewSwitcher.this.f18845b = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Log.d("--------------", "-----------------onAnimationRepeat-----------------");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Log.d("--------------", "-----------------onAnimationStart-----------------");
            ViewSwitcher.this.removeView(this.f18850a);
            ViewSwitcher.this.addView(this.f18850a);
        }
    }

    public ViewSwitcher(Context context) {
        this(context, null);
    }

    public static int f(Context context, float f4) {
        return (int) ((f4 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator.AnimatorListener g(int i4, View view, int i5) {
        return new b(view);
    }

    private View.OnClickListener h(View view, int i4) {
        return new a(i4, view);
    }

    public View.OnClickListener getClickListener() {
        return this.f18846c;
    }

    public int getRealChildCount() {
        int childCount = super.getChildCount();
        int i4 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null && childAt.getVisibility() == 0) {
                i4++;
            }
        }
        return i4;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        int childCount = getChildCount();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() == 0) {
                measureChild(childAt, i4, i5);
                int measuredHeight = childAt.getMeasuredHeight();
                if (i7 != 0) {
                    measuredHeight = f(this.f18844a, 60.0f);
                }
                i6 += measuredHeight;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.setMargins(0, f(this.f18844a, i8), 0, 0);
                childAt.setLayoutParams(layoutParams);
                childAt.setOnClickListener(h(childAt, i7));
                i7++;
                i8 += 60;
            }
        }
        super.onMeasure(i4, i6);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f18846c = onClickListener;
    }

    public ViewSwitcher(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewSwitcher(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f18844a = context;
    }
}
