package com.kwad.components.p208ad.feed.p226b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.p330s.C8951n;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.widget.GestureDetector$OnGestureListenerC11148f;
import com.kwad.sdk.widget.InterfaceC11145c;

/* renamed from: com.kwad.components.ad.feed.b.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7522e extends FrameLayout {

    /* renamed from: fp */
    private View f25668fp;

    /* renamed from: fq */
    private ImageView f25669fq;
    @Nullable

    /* renamed from: fr */
    private Animator f25670fr;

    /* renamed from: fs */
    private InterfaceC11145c f25671fs;

    public C7522e(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bq */
    public Animator m33073bq() {
        View view = this.f25668fp;
        if (view == null || this.f25669fq == null || view.getWidth() + this.f25668fp.getHeight() == 0 || this.f25669fq.getWidth() + this.f25669fq.getHeight() == 0) {
            return null;
        }
        Animator m33072br = m33072br();
        Animator m33078a = m33078a(this.f25669fq, 100L, 16.0f);
        Animator m33071bs = m33071bs();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(m33072br, m33078a, m33071bs);
        return animatorSet;
    }

    /* renamed from: br */
    private Animator m33072br() {
        Animator m33075b = m33075b(this.f25668fp, C10751a.m24924a(getContext(), 128.0f));
        Animator m33075b2 = m33075b(this.f25669fq, C10751a.m24924a(getContext(), 71.11f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.playTogether(m33075b, m33075b2);
        return animatorSet;
    }

    /* renamed from: bs */
    private Animator m33071bs() {
        Animator m33069f = m33069f(this.f25668fp);
        Animator m33069f2 = m33069f(this.f25669fq);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.playTogether(m33069f, m33069f2);
        return animatorSet;
    }

    /* renamed from: f */
    private Animator m33069f(final View view) {
        if (view == null) {
            return null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        animatorSet.setDuration(500L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.b.e.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(8);
            }
        });
        return animatorSet;
    }

    private void init(Context context) {
        C10887l.inflate(context, C9659R.C9663layout.ksad_feed_shake, this);
        setClickable(false);
        this.f25668fp = findViewById(C9659R.C9662id.ksad_feed_shake_bg);
        this.f25669fq = (ImageView) findViewById(C9659R.C9662id.ksad_feed_shake_icon);
    }

    public final void setOnViewEventListener(InterfaceC11145c interfaceC11145c) {
        this.f25671fs = interfaceC11145c;
    }

    private C7522e(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    /* renamed from: b */
    private Animator m33075b(final View view, int i) {
        if (view == null) {
            return null;
        }
        view.setPivotX(view.getWidth() / 2.0f);
        view.setPivotY(view.getHeight() / 2.0f);
        float min = i / Math.min(view.getHeight(), view.getWidth());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", min, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", min, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.setDuration(500L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.b.e.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                view.setVisibility(0);
                view.setClickable(true);
                new GestureDetector$OnGestureListenerC11148f(view, C7522e.this.f25671fs);
            }
        });
        return animatorSet;
    }

    private C7522e(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        init(context);
    }

    @MainThread
    /* renamed from: a */
    public final void m33079a(final AnimatorListenerAdapter animatorListenerAdapter) {
        Animator animator = this.f25670fr;
        if (animator != null) {
            animator.cancel();
            this.f25670fr = null;
        }
        this.f25669fq.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.feed.b.e.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C7522e c7522e = C7522e.this;
                c7522e.f25670fr = c7522e.m33073bq();
                if (C7522e.this.f25670fr != null) {
                    C7522e.this.f25670fr.addListener(animatorListenerAdapter);
                    C7522e.this.f25670fr.start();
                    return;
                }
                animatorListenerAdapter.onAnimationEnd(null);
            }
        });
    }

    /* renamed from: a */
    private Animator m33078a(View view, long j, float f) {
        if (view == null) {
            return null;
        }
        Interpolator create = PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f);
        this.f25669fq.setPivotX(view.getWidth());
        this.f25669fq.setPivotY(view.getHeight());
        Animator m29529a = C8951n.m29529a(view, create, 100L, 16.0f);
        Animator m29529a2 = C8951n.m29529a(view, create, 100L, 16.0f);
        Animator m29529a3 = C8951n.m29529a(view, create, 100L, 16.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(m29529a, m29529a2, m29529a3);
        return animatorSet;
    }
}
