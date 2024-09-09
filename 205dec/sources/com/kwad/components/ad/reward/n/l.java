package com.kwad.components.ad.reward.n;

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
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bn;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class l extends s implements View.OnClickListener {
    private ImageView fq;
    private TextView lw;
    private com.kwad.components.ad.reward.g qo;
    private ImageView zj;
    private TextView zk;
    private TextView zl;
    private TextView zm;
    private View zn;
    private Set<ImageView> zo = new HashSet();
    private TextView zp;
    private Animator zq;

    public l(com.kwad.components.ad.reward.g gVar) {
        this.qo = gVar;
    }

    private void initView() {
        ViewGroup viewGroup = this.sz;
        if (viewGroup == null) {
            return;
        }
        this.zm = (TextView) viewGroup.findViewById(R.id.ksad_reward_live_subscribe_badge);
        this.zj = (ImageView) this.sz.findViewById(R.id.ksad_reward_live_subscribe_kwai_logo);
        this.fq = (ImageView) this.sz.findViewById(R.id.ksad_reward_live_subscribe_icon);
        this.zk = (TextView) this.sz.findViewById(R.id.ksad_reward_live_subscribe_name);
        this.lw = (TextView) this.sz.findViewById(R.id.ksad_reward_live_subscribe_desc);
        this.zl = (TextView) this.sz.findViewById(R.id.ksad_reward_live_subscribe_btn_follow);
        this.zn = this.sz.findViewById(R.id.ksad_reward_live_subscribe_follower_area);
        this.zo.add((ImageView) this.sz.findViewById(R.id.ksad_reward_live_subscribe_follower_icon1));
        this.zo.add((ImageView) this.sz.findViewById(R.id.ksad_reward_live_subscribe_follower_icon2));
        this.zo.add((ImageView) this.sz.findViewById(R.id.ksad_reward_live_subscribe_follower_icon3));
        this.zp = (TextView) this.sz.findViewById(R.id.ksad_reward_live_subscribe_count);
        this.sz.setOnClickListener(this);
        this.zl.setOnClickListener(this);
    }

    private void ka() {
        this.zm.postDelayed(new ay() { // from class: com.kwad.components.ad.reward.n.l.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                l lVar = l.this;
                lVar.zq = l.a(lVar, lVar.zm, 100L, 8.0f);
                l.this.zq.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.n.l.1.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (l.this.zq != null) {
                            l.this.zq.start();
                        }
                    }
                });
                l.this.zq.start();
            }
        }, 500L);
    }

    private void kb() {
        bn.runOnUiThreadDelay(new ay() { // from class: com.kwad.components.ad.reward.n.l.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                l lVar = l.this;
                l.a(lVar, lVar.zn).start();
            }
        }, 2000L);
    }

    private static Animator r(View view) {
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationY", view.getResources().getDimension(R.dimen.ksad_live_subscribe_card_count_area_trans_y)).setDuration(250L);
        duration.setInterpolator(create);
        return duration;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.ad.reward.n.d
    public final void ab(boolean z3) {
        super.ab(z3);
        Context context = this.sz.getContext();
        if (ai.LZ()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.sz.getLayoutParams();
        layoutParams.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_live_subscribe_card_width_horizontal);
        this.sz.setLayoutParams(layoutParams);
    }

    public final void h(ViewGroup viewGroup) {
        super.a(viewGroup, R.id.ksad_reward_live_subscribe_stub, R.id.ksad_reward_live_subscribe_root);
        initView();
    }

    public final void jZ() {
        ka();
        kb();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.zl)) {
            this.qo.a(1, view.getContext(), 29, 1);
        } else if (view.equals(this.sz)) {
            this.qo.a(1, view.getContext(), 53, 2);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void onUnbind() {
        super.onUnbind();
        Animator animator = this.zq;
        if (animator != null) {
            animator.cancel();
            this.zq = null;
        }
    }

    static /* synthetic */ Animator a(l lVar, View view) {
        return r(view);
    }

    static /* synthetic */ Animator a(l lVar, View view, long j4, float f4) {
        return a(view, 100L, 8.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        AdTemplate adTemplate = rVar.getAdTemplate();
        if (adTemplate != null) {
            a(com.kwad.components.ad.reward.model.a.J(adTemplate));
        }
    }

    private void a(com.kwad.components.ad.reward.model.a aVar) {
        this.zk.setText(aVar.getTitle());
        this.lw.setText(aVar.hh());
        this.zl.setText(aVar.he());
        String gf = aVar.gf();
        Drawable drawable = this.fq.getResources().getDrawable(R.drawable.ksad_ic_default_user_avatar);
        KSImageLoader.loadCircleIcon(this.fq, gf, drawable);
        String Z = com.kwad.components.ad.d.b.Z();
        if (!bg.isNullString(Z)) {
            KSImageLoader.loadImage(this.zj, Z, aVar.gY());
        }
        if (aVar.hf()) {
            this.zn.setVisibility(0);
            String hd = aVar.hd();
            if (!TextUtils.isEmpty(hd)) {
                this.zp.setText(String.format("%s\u5df2\u9884\u7ea6\u76f4\u64ad", hd));
            }
            if (aVar.hg() != null) {
                List<String> hg = aVar.hg();
                int i4 = 0;
                for (ImageView imageView : this.zo) {
                    if (i4 < hg.size()) {
                        imageView.setVisibility(0);
                        KSImageLoader.loadCircleIcon(imageView, hg.get(i4), drawable);
                    }
                    i4++;
                }
                return;
            }
            return;
        }
        this.zn.setVisibility(8);
    }

    private static Animator a(View view, long j4, float f4) {
        if (view == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Interpolator create = PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f);
        view.setPivotX(0.0f);
        view.setPivotY(view.getHeight());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f);
        ofFloat.setDuration(100L);
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "rotation", 0.0f, f4).setDuration(j4);
        float f5 = -f4;
        long j5 = j4 * 2;
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "rotation", f4, f5).setDuration(j5);
        duration2.setInterpolator(create);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, "rotation", f5, f4).setDuration(j5);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(view, "rotation", f4, f5).setDuration(j5);
        duration4.setInterpolator(create);
        animatorSet.playSequentially(ofFloat, duration, duration2, duration3, duration4, ObjectAnimator.ofFloat(view, "rotation", f5, 0.0f).setDuration(j4));
        return animatorSet;
    }
}
