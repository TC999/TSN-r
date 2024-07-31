package com.kwad.components.p208ad.reward.p264n;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.p208ad.p213d.C7355b;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.model.C8026a;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11015ai;
import com.kwad.sdk.utils.C11053bg;
import com.kwad.sdk.utils.C11064bn;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.kwad.components.ad.reward.n.l */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC8060l extends AbstractC8075s implements View.OnClickListener {

    /* renamed from: fq */
    private ImageView f26871fq;

    /* renamed from: lw */
    private TextView f26872lw;

    /* renamed from: qo */
    private C7907g f26873qo;

    /* renamed from: zj */
    private ImageView f26874zj;

    /* renamed from: zk */
    private TextView f26875zk;

    /* renamed from: zl */
    private TextView f26876zl;

    /* renamed from: zm */
    private TextView f26877zm;

    /* renamed from: zn */
    private View f26878zn;

    /* renamed from: zo */
    private Set<ImageView> f26879zo = new HashSet();

    /* renamed from: zp */
    private TextView f26880zp;

    /* renamed from: zq */
    private Animator f26881zq;

    public View$OnClickListenerC8060l(C7907g c7907g) {
        this.f26873qo = c7907g;
    }

    private void initView() {
        ViewGroup viewGroup = this.f26932sz;
        if (viewGroup == null) {
            return;
        }
        this.f26877zm = (TextView) viewGroup.findViewById(C9659R.C9662id.ksad_reward_live_subscribe_badge);
        this.f26874zj = (ImageView) this.f26932sz.findViewById(C9659R.C9662id.ksad_reward_live_subscribe_kwai_logo);
        this.f26871fq = (ImageView) this.f26932sz.findViewById(C9659R.C9662id.ksad_reward_live_subscribe_icon);
        this.f26875zk = (TextView) this.f26932sz.findViewById(C9659R.C9662id.ksad_reward_live_subscribe_name);
        this.f26872lw = (TextView) this.f26932sz.findViewById(C9659R.C9662id.ksad_reward_live_subscribe_desc);
        this.f26876zl = (TextView) this.f26932sz.findViewById(C9659R.C9662id.ksad_reward_live_subscribe_btn_follow);
        this.f26878zn = this.f26932sz.findViewById(C9659R.C9662id.ksad_reward_live_subscribe_follower_area);
        this.f26879zo.add((ImageView) this.f26932sz.findViewById(C9659R.C9662id.ksad_reward_live_subscribe_follower_icon1));
        this.f26879zo.add((ImageView) this.f26932sz.findViewById(C9659R.C9662id.ksad_reward_live_subscribe_follower_icon2));
        this.f26879zo.add((ImageView) this.f26932sz.findViewById(C9659R.C9662id.ksad_reward_live_subscribe_follower_icon3));
        this.f26880zp = (TextView) this.f26932sz.findViewById(C9659R.C9662id.ksad_reward_live_subscribe_count);
        this.f26932sz.setOnClickListener(this);
        this.f26876zl.setOnClickListener(this);
    }

    /* renamed from: ka */
    private void m31672ka() {
        this.f26877zm.postDelayed(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.n.l.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                View$OnClickListenerC8060l view$OnClickListenerC8060l = View$OnClickListenerC8060l.this;
                view$OnClickListenerC8060l.f26881zq = View$OnClickListenerC8060l.m31677a(view$OnClickListenerC8060l, view$OnClickListenerC8060l.f26877zm, 100L, 8.0f);
                View$OnClickListenerC8060l.this.f26881zq.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.n.l.1.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (View$OnClickListenerC8060l.this.f26881zq != null) {
                            View$OnClickListenerC8060l.this.f26881zq.start();
                        }
                    }
                });
                View$OnClickListenerC8060l.this.f26881zq.start();
            }
        }, 500L);
    }

    /* renamed from: kb */
    private void m31671kb() {
        C11064bn.runOnUiThreadDelay(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.n.l.2
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                View$OnClickListenerC8060l view$OnClickListenerC8060l = View$OnClickListenerC8060l.this;
                View$OnClickListenerC8060l.m31678a(view$OnClickListenerC8060l, view$OnClickListenerC8060l.f26878zn).start();
            }
        }, 2000L);
    }

    /* renamed from: r */
    private static Animator m31670r(View view) {
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationY", view.getResources().getDimension(C9659R.dimen.ksad_live_subscribe_card_count_area_trans_y)).setDuration(250L);
        duration.setInterpolator(create);
        return duration;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.p208ad.reward.p264n.AbstractC8041d
    /* renamed from: ab */
    public final void mo31659ab(boolean z) {
        super.mo31659ab(z);
        Context context = this.f26932sz.getContext();
        if (C11015ai.m24123LZ()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f26932sz.getLayoutParams();
        layoutParams.width = context.getResources().getDimensionPixelSize(C9659R.dimen.ksad_live_subscribe_card_width_horizontal);
        this.f26932sz.setLayoutParams(layoutParams);
    }

    /* renamed from: h */
    public final void m31674h(ViewGroup viewGroup) {
        super.m31644a(viewGroup, C9659R.C9662id.ksad_reward_live_subscribe_stub, C9659R.C9662id.ksad_reward_live_subscribe_root);
        initView();
    }

    /* renamed from: jZ */
    public final void m31673jZ() {
        m31672ka();
        m31671kb();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.f26876zl)) {
            this.f26873qo.m32060a(1, view.getContext(), 29, 1);
        } else if (view.equals(this.f26932sz)) {
            this.f26873qo.m32060a(1, view.getContext(), 53, 2);
        }
    }

    @Override // com.kwad.components.p208ad.reward.p264n.AbstractC8041d
    public final void onUnbind() {
        super.onUnbind();
        Animator animator = this.f26881zq;
        if (animator != null) {
            animator.cancel();
            this.f26881zq = null;
        }
    }

    /* renamed from: a */
    static /* synthetic */ Animator m31678a(View$OnClickListenerC8060l view$OnClickListenerC8060l, View view) {
        return m31670r(view);
    }

    /* renamed from: a */
    static /* synthetic */ Animator m31677a(View$OnClickListenerC8060l view$OnClickListenerC8060l, View view, long j, float f) {
        return m31682a(view, 100L, 8.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.p208ad.reward.p264n.AbstractC8041d
    /* renamed from: a */
    public final void mo31651a(C8074r c8074r) {
        super.mo31651a(c8074r);
        AdTemplate adTemplate = c8074r.getAdTemplate();
        if (adTemplate != null) {
            m31681a(C8026a.m31817J(adTemplate));
        }
    }

    /* renamed from: a */
    private void m31681a(C8026a c8026a) {
        this.f26875zk.setText(c8026a.getTitle());
        this.f26872lw.setText(c8026a.m31800hh());
        this.f26876zl.setText(c8026a.m31803he());
        String m31809gf = c8026a.m31809gf();
        Drawable drawable = this.f26871fq.getResources().getDrawable(C9659R.C9661drawable.ksad_ic_default_user_avatar);
        KSImageLoader.loadCircleIcon(this.f26871fq, m31809gf, drawable);
        String m33442Z = C7355b.m33442Z();
        if (!C11053bg.isNullString(m33442Z)) {
            KSImageLoader.loadImage(this.f26874zj, m33442Z, c8026a.m31811gY());
        }
        if (c8026a.m31802hf()) {
            this.f26878zn.setVisibility(0);
            String m31804hd = c8026a.m31804hd();
            if (!TextUtils.isEmpty(m31804hd)) {
                this.f26880zp.setText(String.format("%s已预约直播", m31804hd));
            }
            if (c8026a.m31801hg() != null) {
                List<String> m31801hg = c8026a.m31801hg();
                int i = 0;
                for (ImageView imageView : this.f26879zo) {
                    if (i < m31801hg.size()) {
                        imageView.setVisibility(0);
                        KSImageLoader.loadCircleIcon(imageView, m31801hg.get(i), drawable);
                    }
                    i++;
                }
                return;
            }
            return;
        }
        this.f26878zn.setVisibility(8);
    }

    /* renamed from: a */
    private static Animator m31682a(View view, long j, float f) {
        if (view == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Interpolator create = PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f);
        view.setPivotX(0.0f);
        view.setPivotY(view.getHeight());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f);
        ofFloat.setDuration(100L);
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "rotation", 0.0f, f).setDuration(j);
        float f2 = -f;
        long j2 = j * 2;
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "rotation", f, f2).setDuration(j2);
        duration2.setInterpolator(create);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, "rotation", f2, f).setDuration(j2);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(view, "rotation", f, f2).setDuration(j2);
        duration4.setInterpolator(create);
        animatorSet.playSequentially(ofFloat, duration, duration2, duration3, duration4, ObjectAnimator.ofFloat(view, "rotation", f2, 0.0f).setDuration(j));
        return animatorSet;
    }
}
