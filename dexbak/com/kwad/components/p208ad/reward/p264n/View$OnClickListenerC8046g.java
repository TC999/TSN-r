package com.kwad.components.p208ad.reward.p264n;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;

/* renamed from: com.kwad.components.ad.reward.n.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC8046g extends AbstractC8075s implements View.OnClickListener {

    /* renamed from: hz */
    private TextView f26801hz;

    /* renamed from: qo */
    private C7907g f26802qo;

    /* renamed from: com.kwad.components.ad.reward.n.g$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8049a {
        /* renamed from: hv */
        void mo31260hv();
    }

    public View$OnClickListenerC8046g(C7907g c7907g) {
        this.f26802qo = c7907g;
    }

    /* renamed from: q */
    private static Animator m31711q(View view) {
        if (view == null) {
            return null;
        }
        int dimensionPixelSize = view.getContext().getResources().getDimensionPixelSize(C9659R.dimen.ksad_live_card_tips_animation_y);
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

    /* renamed from: a */
    public final void m31713a(final InterfaceC8049a interfaceC8049a, long j) {
        final Animator m31711q = m31711q(this.f26932sz);
        if (m31711q == null) {
            interfaceC8049a.mo31260hv();
            return;
        }
        m31711q.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.n.g.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                InterfaceC8049a interfaceC8049a2 = interfaceC8049a;
                if (interfaceC8049a2 != null) {
                    interfaceC8049a2.mo31260hv();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                InterfaceC8049a interfaceC8049a2 = interfaceC8049a;
                if (interfaceC8049a2 != null) {
                    interfaceC8049a2.mo31260hv();
                }
            }
        });
        this.f26932sz.postDelayed(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.n.g.2
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                m31711q.start();
            }
        }, 500L);
    }

    /* renamed from: f */
    public final void m31712f(ViewGroup viewGroup) {
        super.m31644a(viewGroup, C9659R.C9662id.ksad_card_tips_view, C9659R.C9662id.ksad_card_tips_root);
        if (this.f26801hz == null) {
            this.f26801hz = (TextView) this.f26932sz.findViewById(C9659R.C9662id.ksad_card_tips_title);
        }
        this.f26932sz.setOnClickListener(this);
    }

    @Override // com.kwad.components.p208ad.reward.p264n.AbstractC8075s, com.kwad.components.p208ad.reward.p264n.AbstractC8041d
    /* renamed from: gF */
    public final ViewGroup mo31643gF() {
        return this.f26932sz;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.f26932sz)) {
            C7907g c7907g = this.f26802qo;
            c7907g.m32060a(1, c7907g.mContext, 1, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.p208ad.reward.p264n.AbstractC8041d
    /* renamed from: a */
    public final void mo31651a(C8074r c8074r) {
        String str;
        TextView textView;
        super.mo31651a(c8074r);
        AdTemplate adTemplate = c8074r.getAdTemplate();
        if (adTemplate == null || (str = C10484b.m25717db(adTemplate).title) == null || (textView = this.f26801hz) == null) {
            return;
        }
        textView.setText(str);
    }
}
