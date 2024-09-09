package com.scwang.smartrefresh.header;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.scwang.smartrefresh.header.flyrefresh.FlyView;
import com.scwang.smartrefresh.header.flyrefresh.MountanScenceView;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.header.FalsifyHeader;
import r0.e;
import r0.g;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class FlyRefreshHeader extends FalsifyHeader implements e {

    /* renamed from: b  reason: collision with root package name */
    private FlyView f47521b;

    /* renamed from: c  reason: collision with root package name */
    private AnimatorSet f47522c;

    /* renamed from: d  reason: collision with root package name */
    private MountanScenceView f47523d;

    /* renamed from: e  reason: collision with root package name */
    private h f47524e;

    /* renamed from: f  reason: collision with root package name */
    private g f47525f;

    /* renamed from: g  reason: collision with root package name */
    private float f47526g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f47527h;

    /* renamed from: i  reason: collision with root package name */
    private int f47528i;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            FlyRefreshHeader.this.w(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0, 0, 0);
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
        public void onAnimationStart(Animator animator) {
            if (FlyRefreshHeader.this.f47521b != null) {
                FlyRefreshHeader.this.f47521b.setRotationY(180.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AnimatorListenerAdapter f47531a;

        c(AnimatorListenerAdapter animatorListenerAdapter) {
            this.f47531a = animatorListenerAdapter;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (FlyRefreshHeader.this.f47524e != null) {
                FlyRefreshHeader.this.f47524e.b0(true);
            }
            AnimatorListenerAdapter animatorListenerAdapter = this.f47531a;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationEnd(animator);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (FlyRefreshHeader.this.f47521b != null) {
                FlyRefreshHeader.this.f47521b.setRotationY(0.0f);
            }
        }
    }

    public FlyRefreshHeader(Context context) {
        super(context);
        this.f47527h = false;
        this.f47528i = 0;
    }

    public void A(AnimatorListenerAdapter animatorListenerAdapter) {
        if (this.f47521b == null || !this.f47527h || this.f47524e == null) {
            return;
        }
        AnimatorSet animatorSet = this.f47522c;
        if (animatorSet != null) {
            animatorSet.end();
            this.f47521b.clearAnimation();
        }
        this.f47527h = false;
        this.f47524e.W(0);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(800L);
        FlyView flyView = this.f47521b;
        float f4 = -this.f47521b.getRight();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(flyView, "translationX", flyView.getTranslationX(), f4);
        FlyView flyView2 = this.f47521b;
        float f5 = -com.scwang.smartrefresh.layout.util.c.b(10.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(flyView2, "translationY", flyView2.getTranslationY(), f5);
        ofFloat2.setInterpolator(com.scwang.smartrefresh.header.flyrefresh.a.a(0.1f, 1.0f));
        FlyView flyView3 = this.f47521b;
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(flyView3, "rotation", flyView3.getRotation(), 0.0f);
        FlyView flyView4 = this.f47521b;
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(flyView4, "rotationX", flyView4.getRotationX(), 30.0f);
        ofFloat3.setInterpolator(new AccelerateInterpolator());
        FlyView flyView5 = this.f47521b;
        float[] fArr = {flyView5.getScaleX(), 0.9f};
        FlyView flyView6 = this.f47521b;
        animatorSet2.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ObjectAnimator.ofFloat(flyView5, "scaleX", fArr), ObjectAnimator.ofFloat(flyView6, "scaleY", flyView6.getScaleY(), 0.9f));
        animatorSet2.addListener(new b());
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.setDuration(800L);
        animatorSet3.setInterpolator(new DecelerateInterpolator());
        animatorSet3.playTogether(ObjectAnimator.ofFloat(this.f47521b, "translationX", f4, 0.0f), ObjectAnimator.ofFloat(this.f47521b, "translationY", f5, 0.0f), ObjectAnimator.ofFloat(this.f47521b, "rotationX", 30.0f, 0.0f), ObjectAnimator.ofFloat(this.f47521b, "scaleX", 0.9f, 1.0f), ObjectAnimator.ofFloat(this.f47521b, "scaleY", 0.9f, 1.0f));
        animatorSet3.setStartDelay(100L);
        animatorSet3.addListener(new c(animatorListenerAdapter));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.f47522c = animatorSet4;
        animatorSet4.playSequentially(animatorSet2, animatorSet3);
        this.f47522c.start();
    }

    public void B(MountanScenceView mountanScenceView, FlyView flyView) {
        setUpFlyView(flyView);
        setUpMountanScenceView(mountanScenceView);
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, s0.f
    public void b(h hVar, RefreshState refreshState, RefreshState refreshState2) {
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, r0.e
    public void i(float f4, int i4, int i5, int i6) {
        if (this.f47527h) {
            return;
        }
        w(f4, i4, i5, i6);
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, r0.e
    public void j(h hVar, int i4, int i5) {
        this.f47525f.e(0);
        float f4 = this.f47526g;
        if (f4 > 0.0f) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f4, 0.0f);
            ofFloat.setDuration(300L);
            ofFloat.addUpdateListener(new a());
            ofFloat.start();
            this.f47526g = 0.0f;
        }
        if (this.f47521b == null || this.f47527h) {
            return;
        }
        AnimatorSet animatorSet = this.f47522c;
        if (animatorSet != null) {
            animatorSet.end();
            this.f47521b.clearAnimation();
        }
        this.f47527h = true;
        hVar.b0(false);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f47521b, "translationX", 0.0f, ((View) this.f47524e).getWidth() - this.f47521b.getLeft());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f47521b, "translationY", 0.0f, ((-(this.f47521b.getTop() - this.f47528i)) * 2) / 3);
        ofFloat3.setInterpolator(com.scwang.smartrefresh.header.flyrefresh.a.a(0.7f, 1.0f));
        FlyView flyView = this.f47521b;
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(flyView, "rotation", flyView.getRotation(), 0.0f);
        ofFloat4.setInterpolator(new DecelerateInterpolator());
        FlyView flyView2 = this.f47521b;
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(flyView2, "rotationX", flyView2.getRotationX(), 50.0f);
        ofFloat5.setInterpolator(new DecelerateInterpolator());
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(800L);
        FlyView flyView3 = this.f47521b;
        float[] fArr = {flyView3.getScaleX(), 0.5f};
        FlyView flyView4 = this.f47521b;
        animatorSet2.playTogether(ofFloat2, ofFloat3, ofFloat4, ofFloat5, ObjectAnimator.ofFloat(flyView3, "scaleX", fArr), ObjectAnimator.ofFloat(flyView4, "scaleY", flyView4.getScaleY(), 0.5f));
        this.f47522c = animatorSet2;
        animatorSet2.start();
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, r0.f
    public void n(float f4, int i4, int i5) {
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, r0.f
    public void o(g gVar, int i4, int i5) {
        this.f47525f = gVar;
        this.f47524e = gVar.n();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f47521b = null;
        this.f47524e = null;
        this.f47525f = null;
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, r0.f
    public boolean p() {
        return false;
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, r0.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        MountanScenceView mountanScenceView;
        if (iArr.length <= 0 || (mountanScenceView = this.f47523d) == null) {
            return;
        }
        mountanScenceView.setPrimaryColor(iArr[0]);
    }

    public void setUpFlyView(FlyView flyView) {
        this.f47521b = flyView;
    }

    public void setUpMountanScenceView(MountanScenceView mountanScenceView) {
        this.f47523d = mountanScenceView;
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, r0.f
    public void u(h hVar, int i4, int i5) {
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, r0.f
    public int v(h hVar, boolean z3) {
        if (this.f47527h) {
            z();
        }
        return super.v(hVar, z3);
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, r0.e
    public void w(float f4, int i4, int i5, int i6) {
        if (i4 < 0) {
            if (this.f47528i <= 0) {
                return;
            }
            i4 = 0;
            f4 = 0.0f;
        }
        this.f47528i = i4;
        this.f47526g = f4;
        MountanScenceView mountanScenceView = this.f47523d;
        if (mountanScenceView != null) {
            mountanScenceView.d(f4);
            this.f47523d.postInvalidate();
        }
        FlyView flyView = this.f47521b;
        if (flyView != null) {
            int i7 = i5 + i6;
            if (i7 > 0) {
                flyView.setRotation((i4 * (-45.0f)) / i7);
            } else {
                flyView.setRotation(f4 * (-45.0f));
            }
        }
    }

    public void z() {
        A(null);
    }

    public FlyRefreshHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47527h = false;
        this.f47528i = 0;
    }

    public FlyRefreshHeader(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f47527h = false;
        this.f47528i = 0;
    }

    @RequiresApi(21)
    public FlyRefreshHeader(Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f47527h = false;
        this.f47528i = 0;
    }
}
