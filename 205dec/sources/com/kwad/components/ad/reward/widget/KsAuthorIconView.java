package com.kwad.components.ad.reward.widget;

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
import com.kwad.components.core.s.i;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.e;
import com.kwad.sdk.R;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;
import com.kwad.sdk.utils.br;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class KsAuthorIconView extends FrameLayout implements br.a {
    private ViewGroup AB;
    private KSCornerImageView AC;
    private KSCornerImageView AE;
    private KSCornerImageView AF;
    private TextView AG;
    private View AH;
    private View AI;
    private ImageView AJ;
    private View AK;
    private View AL;
    private View AM;
    private View AN;
    private final br hh;
    private KSCornerImageView zz;

    public KsAuthorIconView(@NonNull Context context) {
        super(context);
        this.hh = new br(this);
        P(context);
    }

    private void P(@NonNull Context context) {
        l.inflate(context, R.layout.ksad_author_icon, this);
        this.AB = (ViewGroup) findViewById(R.id.ksad_author_icon_frame);
        this.zz = (KSCornerImageView) findViewById(R.id.ksad_author_icon);
        this.AC = (KSCornerImageView) findViewById(R.id.ksad_author_icon_outer);
        this.AE = (KSCornerImageView) findViewById(R.id.ksad_author_animator);
        this.AF = (KSCornerImageView) findViewById(R.id.ksad_author_animator2);
        this.AG = (TextView) findViewById(R.id.ksad_fans_count);
        this.AI = findViewById(R.id.ksad_fans_hot_icon);
        this.AH = findViewById(R.id.ksad_author_btn_follow);
        this.AJ = (ImageView) findViewById(R.id.ksad_author_arrow_down);
        this.AL = findViewById(R.id.ksad_origin_live_bottom_layout);
        this.AK = findViewById(R.id.ksad_top_layout);
        this.AN = findViewById(R.id.ksad_author_icon_layout);
        this.AM = findViewById(R.id.ksad_top_flag_layout);
    }

    private Animator c(View view, long j4) {
        if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(view.getWidth(), getResources().getDimension(R.dimen.ksad_reward_author_icon_width));
        ofFloat.addUpdateListener(f(view, false));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        Interpolator create = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(j4);
        animatorSet.setInterpolator(create);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    private static Animator e(View view, boolean z3) {
        float width = view.getWidth();
        if (width <= 0.0f) {
            return null;
        }
        float f4 = 0.9f * width;
        c.d("KsAuthorIconView", "getIconScaleAnimator size: " + width + ", endSize: " + f4);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(width, f4);
        ofFloat.addUpdateListener(f(view, false));
        Interpolator create = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(create);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(f4, width);
        ofFloat2.addUpdateListener(f(view, false));
        Interpolator create2 = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ofFloat2.setDuration(500L);
        ofFloat2.setInterpolator(create2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofFloat2);
        return animatorSet;
    }

    private static ValueAnimator.AnimatorUpdateListener f(final View view, final boolean z3) {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.widget.KsAuthorIconView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    int i4 = (int) floatValue;
                    layoutParams.width = i4;
                    if (!z3) {
                        layoutParams.height = i4;
                    }
                    view.setLayoutParams(layoutParams);
                }
            }
        };
    }

    private static Animator i(View view, int i4) {
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

    public final void a(e eVar) {
        i.a(eVar, this);
        this.AJ.setImageResource(R.drawable.ksad_reward_follow_arrow_down);
        a(eVar, this.AE.getBackground());
        a(eVar, this.AC.getBackground());
        a(eVar, this.AF.getBackground());
        a(eVar, this.AB.getBackground());
    }

    public final void b(AdTemplate adTemplate) {
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        String cf = a.cf(dQ);
        if (!TextUtils.isEmpty(cf)) {
            KSImageLoader.loadImage(this.zz, cf, adTemplate);
        }
        int bf = a.bf(dQ);
        if (a.cL(com.kwad.sdk.core.response.b.e.dQ(adTemplate))) {
            this.AG.setText("\u76f4\u64ad\u4e2d");
            this.AI.setVisibility(8);
            this.AH.setVisibility(8);
            if (bf == 8) {
                this.AM.setVisibility(8);
                this.AJ.setVisibility(8);
                this.AL.setVisibility(0);
            } else {
                this.AL.setVisibility(8);
                this.AJ.setVisibility(0);
                this.AL.setVisibility(8);
            }
        } else {
            this.AG.setText(a.cG(dQ));
        }
        this.hh.sendEmptyMessageAtTime(1, 500L);
    }

    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hh = new br(this);
        P(context);
    }

    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.hh = new br(this);
        P(context);
    }

    private void a(e eVar, Drawable drawable) {
        if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setStroke(getResources().getDimensionPixelSize(R.dimen.ksad_reward_author_icon_stroke_width), eVar.tt());
        }
    }

    @RequiresApi(api = 21)
    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.hh = new br(this);
        P(context);
    }

    @Override // com.kwad.sdk.utils.br.a
    public final void a(Message message) {
        if (message.what != 1) {
            return;
        }
        c.d("KsAuthorIconView", "handleMsg MSG_CHECKING");
        final Animator c4 = c(this.AE, 900L);
        final Animator c5 = c(this.AF, 1000L);
        final Animator e4 = e(this.zz, false);
        final Animator i4 = i(this.AK, 500);
        if (i4 != null && c4 != null && c5 != null && e4 != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(e4, c4, c5);
            animatorSet.start();
            e4.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.widget.KsAuthorIconView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c4.start();
                    c5.start();
                    e4.start();
                    i4.start();
                }
            });
            return;
        }
        this.hh.sendEmptyMessageDelayed(1, 500L);
    }
}
