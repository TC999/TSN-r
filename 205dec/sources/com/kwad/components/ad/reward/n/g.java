package com.kwad.components.ad.reward.n;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ay;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class g extends s implements View.OnClickListener {
    private TextView hz;
    private com.kwad.components.ad.reward.g qo;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void hv();
    }

    public g(com.kwad.components.ad.reward.g gVar) {
        this.qo = gVar;
    }

    private static Animator q(View view) {
        if (view == null) {
            return null;
        }
        int dimensionPixelSize = view.getContext().getResources().getDimensionPixelSize(R.dimen.ksad_live_card_tips_animation_y);
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationY", -dimensionPixelSize).setDuration(500L);
        duration.setInterpolator(create);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f).setDuration(2500L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, "translationY", 0.0f).setDuration(500L);
        duration3.setInterpolator(create);
        animatorSet.playSequentially(duration, duration2, duration3);
        return animatorSet;
    }

    public final void a(final a aVar, long j4) {
        final Animator q3 = q(this.sz);
        if (q3 == null) {
            aVar.hv();
            return;
        }
        q3.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.n.g.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.hv();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.hv();
                }
            }
        });
        this.sz.postDelayed(new ay() { // from class: com.kwad.components.ad.reward.n.g.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                q3.start();
            }
        }, 500L);
    }

    public final void f(ViewGroup viewGroup) {
        super.a(viewGroup, R.id.ksad_card_tips_view, R.id.ksad_card_tips_root);
        if (this.hz == null) {
            this.hz = (TextView) this.sz.findViewById(R.id.ksad_card_tips_title);
        }
        this.sz.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.n.s, com.kwad.components.ad.reward.n.d
    public final ViewGroup gF() {
        return this.sz;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.sz)) {
            com.kwad.components.ad.reward.g gVar = this.qo;
            gVar.a(1, gVar.mContext, 1, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        String str;
        TextView textView;
        super.a(rVar);
        AdTemplate adTemplate = rVar.getAdTemplate();
        if (adTemplate == null || (str = com.kwad.sdk.core.response.b.b.db(adTemplate).title) == null || (textView = this.hz) == null) {
            return;
        }
        textView.setText(str);
    }
}
