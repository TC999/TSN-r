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
import com.scwang.smartrefresh.header.flyrefresh.PathInterpolatorCompat;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.header.FalsifyHeader;
import com.scwang.smartrefresh.layout.util.C11925c;
import p638r0.RefreshHeader;
import p638r0.RefreshKernel;
import p638r0.RefreshLayout;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class FlyRefreshHeader extends FalsifyHeader implements RefreshHeader {

    /* renamed from: b */
    private FlyView f33062b;

    /* renamed from: c */
    private AnimatorSet f33063c;

    /* renamed from: d */
    private MountanScenceView f33064d;

    /* renamed from: e */
    private RefreshLayout f33065e;

    /* renamed from: f */
    private RefreshKernel f33066f;

    /* renamed from: g */
    private float f33067g;

    /* renamed from: h */
    private boolean f33068h;

    /* renamed from: i */
    private int f33069i;

    /* renamed from: com.scwang.smartrefresh.header.FlyRefreshHeader$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C11847a implements ValueAnimator.AnimatorUpdateListener {
        C11847a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            FlyRefreshHeader.this.mo2100w(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scwang.smartrefresh.header.FlyRefreshHeader$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C11848b extends AnimatorListenerAdapter {
        C11848b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (FlyRefreshHeader.this.f33062b != null) {
                FlyRefreshHeader.this.f33062b.setRotationY(180.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scwang.smartrefresh.header.FlyRefreshHeader$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C11849c extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ AnimatorListenerAdapter f33072a;

        C11849c(AnimatorListenerAdapter animatorListenerAdapter) {
            this.f33072a = animatorListenerAdapter;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (FlyRefreshHeader.this.f33065e != null) {
                FlyRefreshHeader.this.f33065e.mo2050b0(true);
            }
            AnimatorListenerAdapter animatorListenerAdapter = this.f33072a;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationEnd(animator);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (FlyRefreshHeader.this.f33062b != null) {
                FlyRefreshHeader.this.f33062b.setRotationY(0.0f);
            }
        }
    }

    public FlyRefreshHeader(Context context) {
        super(context);
        this.f33068h = false;
        this.f33069i = 0;
    }

    /* renamed from: A */
    public void m20214A(AnimatorListenerAdapter animatorListenerAdapter) {
        if (this.f33062b == null || !this.f33068h || this.f33065e == null) {
            return;
        }
        AnimatorSet animatorSet = this.f33063c;
        if (animatorSet != null) {
            animatorSet.end();
            this.f33062b.clearAnimation();
        }
        this.f33068h = false;
        this.f33065e.mo2057W(0);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(800L);
        FlyView flyView = this.f33062b;
        float f = -this.f33062b.getRight();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(flyView, "translationX", flyView.getTranslationX(), f);
        FlyView flyView2 = this.f33062b;
        float f2 = -C11925c.m19766b(10.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(flyView2, "translationY", flyView2.getTranslationY(), f2);
        ofFloat2.setInterpolator(PathInterpolatorCompat.m20121a(0.1f, 1.0f));
        FlyView flyView3 = this.f33062b;
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(flyView3, "rotation", flyView3.getRotation(), 0.0f);
        FlyView flyView4 = this.f33062b;
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(flyView4, "rotationX", flyView4.getRotationX(), 30.0f);
        ofFloat3.setInterpolator(new AccelerateInterpolator());
        FlyView flyView5 = this.f33062b;
        float[] fArr = {flyView5.getScaleX(), 0.9f};
        FlyView flyView6 = this.f33062b;
        animatorSet2.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ObjectAnimator.ofFloat(flyView5, "scaleX", fArr), ObjectAnimator.ofFloat(flyView6, "scaleY", flyView6.getScaleY(), 0.9f));
        animatorSet2.addListener(new C11848b());
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.setDuration(800L);
        animatorSet3.setInterpolator(new DecelerateInterpolator());
        animatorSet3.playTogether(ObjectAnimator.ofFloat(this.f33062b, "translationX", f, 0.0f), ObjectAnimator.ofFloat(this.f33062b, "translationY", f2, 0.0f), ObjectAnimator.ofFloat(this.f33062b, "rotationX", 30.0f, 0.0f), ObjectAnimator.ofFloat(this.f33062b, "scaleX", 0.9f, 1.0f), ObjectAnimator.ofFloat(this.f33062b, "scaleY", 0.9f, 1.0f));
        animatorSet3.setStartDelay(100L);
        animatorSet3.addListener(new C11849c(animatorListenerAdapter));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.f33063c = animatorSet4;
        animatorSet4.playSequentially(animatorSet2, animatorSet3);
        this.f33063c.start();
    }

    /* renamed from: B */
    public void m20213B(MountanScenceView mountanScenceView, FlyView flyView) {
        setUpFlyView(flyView);
        setUpMountanScenceView(mountanScenceView);
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, p642s0.OnStateChangedListener
    /* renamed from: b */
    public void mo329b(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, p638r0.RefreshHeader
    /* renamed from: i */
    public void mo2102i(float f, int i, int i2, int i3) {
        if (this.f33068h) {
            return;
        }
        mo2100w(f, i, i2, i3);
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, p638r0.RefreshHeader
    /* renamed from: j */
    public void mo2101j(RefreshLayout refreshLayout, int i, int i2) {
        this.f33066f.mo2090e(0);
        float f = this.f33067g;
        if (f > 0.0f) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f, 0.0f);
            ofFloat.setDuration(300L);
            ofFloat.addUpdateListener(new C11847a());
            ofFloat.start();
            this.f33067g = 0.0f;
        }
        if (this.f33062b == null || this.f33068h) {
            return;
        }
        AnimatorSet animatorSet = this.f33063c;
        if (animatorSet != null) {
            animatorSet.end();
            this.f33062b.clearAnimation();
        }
        this.f33068h = true;
        refreshLayout.mo2050b0(false);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f33062b, "translationX", 0.0f, ((View) this.f33065e).getWidth() - this.f33062b.getLeft());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f33062b, "translationY", 0.0f, ((-(this.f33062b.getTop() - this.f33069i)) * 2) / 3);
        ofFloat3.setInterpolator(PathInterpolatorCompat.m20121a(0.7f, 1.0f));
        FlyView flyView = this.f33062b;
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(flyView, "rotation", flyView.getRotation(), 0.0f);
        ofFloat4.setInterpolator(new DecelerateInterpolator());
        FlyView flyView2 = this.f33062b;
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(flyView2, "rotationX", flyView2.getRotationX(), 50.0f);
        ofFloat5.setInterpolator(new DecelerateInterpolator());
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(800L);
        FlyView flyView3 = this.f33062b;
        float[] fArr = {flyView3.getScaleX(), 0.5f};
        FlyView flyView4 = this.f33062b;
        animatorSet2.playTogether(ofFloat2, ofFloat3, ofFloat4, ofFloat5, ObjectAnimator.ofFloat(flyView3, "scaleX", fArr), ObjectAnimator.ofFloat(flyView4, "scaleY", flyView4.getScaleY(), 0.5f));
        this.f33063c = animatorSet2;
        animatorSet2.start();
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, p638r0.RefreshInternal
    /* renamed from: n */
    public void mo2099n(float f, int i, int i2) {
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, p638r0.RefreshInternal
    /* renamed from: o */
    public void mo2098o(RefreshKernel refreshKernel, int i, int i2) {
        this.f33066f = refreshKernel;
        this.f33065e = refreshKernel.mo2081n();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f33062b = null;
        this.f33065e = null;
        this.f33066f = null;
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, p638r0.RefreshInternal
    /* renamed from: p */
    public boolean mo2097p() {
        return false;
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, p638r0.RefreshInternal
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        MountanScenceView mountanScenceView;
        if (iArr.length <= 0 || (mountanScenceView = this.f33064d) == null) {
            return;
        }
        mountanScenceView.setPrimaryColor(iArr[0]);
    }

    public void setUpFlyView(FlyView flyView) {
        this.f33062b = flyView;
    }

    public void setUpMountanScenceView(MountanScenceView mountanScenceView) {
        this.f33064d = mountanScenceView;
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, p638r0.RefreshInternal
    /* renamed from: u */
    public void mo2096u(RefreshLayout refreshLayout, int i, int i2) {
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, p638r0.RefreshInternal
    /* renamed from: v */
    public int mo2095v(RefreshLayout refreshLayout, boolean z) {
        if (this.f33068h) {
            m20210z();
        }
        return super.mo2095v(refreshLayout, z);
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, p638r0.RefreshHeader
    /* renamed from: w */
    public void mo2100w(float f, int i, int i2, int i3) {
        if (i < 0) {
            if (this.f33069i <= 0) {
                return;
            }
            i = 0;
            f = 0.0f;
        }
        this.f33069i = i;
        this.f33067g = f;
        MountanScenceView mountanScenceView = this.f33064d;
        if (mountanScenceView != null) {
            mountanScenceView.m20123d(f);
            this.f33064d.postInvalidate();
        }
        FlyView flyView = this.f33062b;
        if (flyView != null) {
            int i4 = i2 + i3;
            if (i4 > 0) {
                flyView.setRotation((i * (-45.0f)) / i4);
            } else {
                flyView.setRotation(f * (-45.0f));
            }
        }
    }

    /* renamed from: z */
    public void m20210z() {
        m20214A(null);
    }

    public FlyRefreshHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33068h = false;
        this.f33069i = 0;
    }

    public FlyRefreshHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33068h = false;
        this.f33069i = 0;
    }

    @RequiresApi(21)
    public FlyRefreshHeader(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f33068h = false;
        this.f33069i = 0;
    }
}
