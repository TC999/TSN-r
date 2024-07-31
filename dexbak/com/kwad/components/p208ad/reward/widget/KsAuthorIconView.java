package com.kwad.components.p208ad.reward.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.p330s.C8946i;
import com.kwad.components.core.widget.C9374e;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.utils.HandlerC11068br;

/* renamed from: com.kwad.components.ad.reward.widget.KsAuthorIconView */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class KsAuthorIconView extends FrameLayout implements HandlerC11068br.InterfaceC11069a {

    /* renamed from: AB */
    private ViewGroup f27492AB;

    /* renamed from: AC */
    private KSCornerImageView f27493AC;

    /* renamed from: AE */
    private KSCornerImageView f27494AE;

    /* renamed from: AF */
    private KSCornerImageView f27495AF;

    /* renamed from: AG */
    private TextView f27496AG;

    /* renamed from: AH */
    private View f27497AH;

    /* renamed from: AI */
    private View f27498AI;

    /* renamed from: AJ */
    private ImageView f27499AJ;

    /* renamed from: AK */
    private View f27500AK;

    /* renamed from: AL */
    private View f27501AL;

    /* renamed from: AM */
    private View f27502AM;

    /* renamed from: AN */
    private View f27503AN;

    /* renamed from: hh */
    private final HandlerC11068br f27504hh;

    /* renamed from: zz */
    private KSCornerImageView f27505zz;

    public KsAuthorIconView(@NonNull Context context) {
        super(context);
        this.f27504hh = new HandlerC11068br(this);
        m30989P(context);
    }

    /* renamed from: P */
    private void m30989P(@NonNull Context context) {
        C10887l.inflate(context, C9659R.C9663layout.ksad_author_icon, this);
        this.f27492AB = (ViewGroup) findViewById(C9659R.C9662id.ksad_author_icon_frame);
        this.f27505zz = (KSCornerImageView) findViewById(C9659R.C9662id.ksad_author_icon);
        this.f27493AC = (KSCornerImageView) findViewById(C9659R.C9662id.ksad_author_icon_outer);
        this.f27494AE = (KSCornerImageView) findViewById(C9659R.C9662id.ksad_author_animator);
        this.f27495AF = (KSCornerImageView) findViewById(C9659R.C9662id.ksad_author_animator2);
        this.f27496AG = (TextView) findViewById(C9659R.C9662id.ksad_fans_count);
        this.f27498AI = findViewById(C9659R.C9662id.ksad_fans_hot_icon);
        this.f27497AH = findViewById(C9659R.C9662id.ksad_author_btn_follow);
        this.f27499AJ = (ImageView) findViewById(C9659R.C9662id.ksad_author_arrow_down);
        this.f27501AL = findViewById(C9659R.C9662id.ksad_origin_live_bottom_layout);
        this.f27500AK = findViewById(C9659R.C9662id.ksad_top_layout);
        this.f27503AN = findViewById(C9659R.C9662id.ksad_author_icon_layout);
        this.f27502AM = findViewById(C9659R.C9662id.ksad_top_flag_layout);
    }

    /* renamed from: c */
    private Animator m30985c(View view, long j) {
        if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(view.getWidth(), getResources().getDimension(C9659R.dimen.ksad_reward_author_icon_width));
        ofFloat.addUpdateListener(m30983f(view, false));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        Interpolator create = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(j);
        animatorSet.setInterpolator(create);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    /* renamed from: e */
    private static Animator m30984e(View view, boolean z) {
        float width = view.getWidth();
        if (width <= 0.0f) {
            return null;
        }
        float f = 0.9f * width;
        C10331c.m26254d("KsAuthorIconView", "getIconScaleAnimator size: " + width + ", endSize: " + f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(width, f);
        ofFloat.addUpdateListener(m30983f(view, false));
        Interpolator create = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(create);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(f, width);
        ofFloat2.addUpdateListener(m30983f(view, false));
        Interpolator create2 = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ofFloat2.setDuration(500L);
        ofFloat2.setInterpolator(create2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofFloat2);
        return animatorSet;
    }

    /* renamed from: f */
    private static ValueAnimator.AnimatorUpdateListener m30983f(final View view, final boolean z) {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.widget.KsAuthorIconView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    int i = (int) floatValue;
                    layoutParams.width = i;
                    if (!z) {
                        layoutParams.height = i;
                    }
                    view.setLayoutParams(layoutParams);
                }
            }
        };
    }

    /* renamed from: i */
    private static Animator m30982i(View view, int i) {
        if (view == null) {
            return null;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.setPivotX(width / 2.0f);
        view.setPivotY(height);
        AnimatorSet animatorSet = new AnimatorSet();
        Interpolator create = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.1f, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.1f, 1.0f));
        animatorSet.setInterpolator(create);
        animatorSet.setDuration(250L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        Interpolator create2 = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        animatorSet2.playTogether(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.1f, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.1f, 1.0f));
        animatorSet2.setInterpolator(create2);
        animatorSet2.setDuration(250L);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playSequentially(animatorSet, animatorSet2);
        animatorSet3.setDuration(500L);
        return animatorSet3;
    }

    /* renamed from: a */
    public final void m30988a(C9374e c9374e) {
        C8946i.m29551a(c9374e, this);
        this.f27499AJ.setImageResource(C9659R.C9661drawable.ksad_reward_follow_arrow_down);
        m30987a(c9374e, this.f27494AE.getBackground());
        m30987a(c9374e, this.f27493AC.getBackground());
        m30987a(c9374e, this.f27495AF.getBackground());
        m30987a(c9374e, this.f27492AB.getBackground());
    }

    /* renamed from: b */
    public final void m30986b(AdTemplate adTemplate) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        String m25820cf = C10483a.m25820cf(m25641dQ);
        if (!TextUtils.isEmpty(m25820cf)) {
            KSImageLoader.loadImage(this.f27505zz, m25820cf, adTemplate);
        }
        int m25874bf = C10483a.m25874bf(m25641dQ);
        if (C10483a.m25842cL(C10487e.m25641dQ(adTemplate))) {
            this.f27496AG.setText("直播中");
            this.f27498AI.setVisibility(8);
            this.f27497AH.setVisibility(8);
            if (m25874bf == 8) {
                this.f27502AM.setVisibility(8);
                this.f27499AJ.setVisibility(8);
                this.f27501AL.setVisibility(0);
            } else {
                this.f27501AL.setVisibility(8);
                this.f27499AJ.setVisibility(0);
                this.f27501AL.setVisibility(8);
            }
        } else {
            this.f27496AG.setText(C10483a.m25847cG(m25641dQ));
        }
        this.f27504hh.sendEmptyMessageAtTime(1, 500L);
    }

    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f27504hh = new HandlerC11068br(this);
        m30989P(context);
    }

    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27504hh = new HandlerC11068br(this);
        m30989P(context);
    }

    /* renamed from: a */
    private void m30987a(C9374e c9374e, Drawable drawable) {
        if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setStroke(getResources().getDimensionPixelSize(C9659R.dimen.ksad_reward_author_icon_stroke_width), c9374e.m28873tt());
        }
    }

    @RequiresApi(api = 21)
    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f27504hh = new HandlerC11068br(this);
        m30989P(context);
    }

    @Override // com.kwad.sdk.utils.HandlerC11068br.InterfaceC11069a
    /* renamed from: a */
    public final void mo23849a(Message message) {
        if (message.what != 1) {
            return;
        }
        C10331c.m26254d("KsAuthorIconView", "handleMsg MSG_CHECKING");
        final Animator m30985c = m30985c(this.f27494AE, 900L);
        final Animator m30985c2 = m30985c(this.f27495AF, 1000L);
        final Animator m30984e = m30984e(this.f27505zz, false);
        final Animator m30982i = m30982i(this.f27500AK, 500);
        if (m30982i != null && m30985c != null && m30985c2 != null && m30984e != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(m30984e, m30985c, m30985c2);
            animatorSet.start();
            m30984e.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.widget.KsAuthorIconView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    m30985c.start();
                    m30985c2.start();
                    m30984e.start();
                    m30982i.start();
                }
            });
            return;
        }
        this.f27504hh.sendEmptyMessageDelayed(1, 500L);
    }
}
