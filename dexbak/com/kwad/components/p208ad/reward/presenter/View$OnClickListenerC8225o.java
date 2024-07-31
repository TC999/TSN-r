package com.kwad.components.p208ad.reward.presenter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.asm.Opcodes;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.p208ad.reward.C7838a;
import com.kwad.components.p208ad.reward.p248a.C7844b;
import com.kwad.components.p208ad.reward.p252e.AbstractC7880a;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7886g;
import com.kwad.components.p208ad.reward.presenter.platdetail.actionbar.InterfaceC8259a;
import com.kwad.components.p208ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.widget.C11143a;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.presenter.o */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC8225o extends C8094b implements View.OnClickListener, InterfaceC8259a {

    /* renamed from: sy */
    private static long f27193sy = 300;

    /* renamed from: fq */
    private ImageView f27194fq;

    /* renamed from: sA */
    private TextView f27195sA;

    /* renamed from: sB */
    private boolean f27196sB;

    /* renamed from: sC */
    private float f27197sC;

    /* renamed from: sD */
    private WeakReference<View> f27198sD;

    /* renamed from: sE */
    private C8297r f27199sE;

    /* renamed from: sz */
    private ViewGroup f27201sz;

    /* renamed from: sF */
    private boolean f27200sF = false;
    private InterfaceC7886g mPlayEndPageListener = new AbstractC7880a() { // from class: com.kwad.components.ad.reward.presenter.o.1
        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7886g
        /* renamed from: bL */
        public final void mo31009bL() {
            View$OnClickListenerC8225o.this.hide();
        }
    };

    public View$OnClickListenerC8225o(C8297r c8297r) {
        this.f27199sE = c8297r;
    }

    /* renamed from: hx */
    private synchronized void m31250hx() {
        if (this.f27200sF) {
            return;
        }
        C9908c.m27309d(this.f26957qo.mAdTemplate, (JSONObject) null, new C9913b().m27264cM(Opcodes.CHECKCAST).m27269ah(this.f26957qo.f26529oJ.getPlayDuration()));
        this.f27200sF = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hy */
    public Animator m31249hy() {
        ValueAnimator valueAnimator;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f27201sz, "translationX", getContext().getResources().getDimension(C9659R.dimen.ksad_reward_playable_pre_tips_transx));
        Drawable background = this.f27194fq.getBackground();
        if (background instanceof ColorDrawable) {
            final ColorDrawable colorDrawable = (ColorDrawable) background;
            valueAnimator = C11143a.ofArgb(getContext().getResources().getColor(C9659R.C9660color.ksad_playable_pre_tips_icon_bg), getContext().getResources().getColor(C9659R.C9660color.ksad_reward_main_color));
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.o.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    colorDrawable.setColor(((Integer) valueAnimator2.getAnimatedValue()).intValue());
                }
            });
        } else {
            valueAnimator = null;
        }
        animatorSet.playTogether(ofFloat, valueAnimator, ObjectAnimator.ofFloat(this.f27195sA, "alpha", 0.0f, 1.0f));
        animatorSet.setDuration(f27193sy);
        return animatorSet;
    }

    private void initView() {
        ViewGroup viewGroup = this.f27201sz;
        if (viewGroup == null) {
            return;
        }
        ImageView imageView = (ImageView) viewGroup.findViewById(C9659R.C9662id.ksad_playabel_pre_tips_icon);
        this.f27194fq = imageView;
        imageView.setBackgroundColor(getContext().getResources().getColor(C9659R.C9660color.ksad_playable_pre_tips_icon_bg));
        this.f27195sA = (TextView) this.f27201sz.findViewById(C9659R.C9662id.ksad_playabel_pre_tips_text);
        this.f27201sz.setOnClickListener(this);
    }

    /* renamed from: H */
    public final void m31253H(boolean z) {
        ViewGroup viewGroup = this.f27201sz;
        if (viewGroup == null || viewGroup.getVisibility() == 0) {
            return;
        }
        m31250hx();
        WeakReference<View> weakReference = this.f27198sD;
        if (weakReference != null && weakReference.get() != null) {
            m31252a(this.f27198sD.get().getLayoutParams());
        }
        this.f27201sz.setVisibility(0);
        if (z) {
            this.f27201sz.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.o.2
                @Override // java.lang.Runnable
                public final void run() {
                    View$OnClickListenerC8225o.this.m31249hy().start();
                }
            }, 2000L);
        }
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        if (this.f27201sz == null) {
            ViewStub viewStub = (ViewStub) findViewById(C9659R.C9662id.ksad_playable_pre_tips_stub);
            if (viewStub != null) {
                this.f27201sz = (ViewGroup) viewStub.inflate();
            } else {
                this.f27201sz = (ViewGroup) findViewById(C9659R.C9662id.ksad_playable_pre_tips_root);
            }
            initView();
        }
        if (this.f26957qo.m32009fF()) {
            m31252a(new ViewGroup.LayoutParams(-1, this.f27201sz.getResources().getDimensionPixelSize(C9659R.dimen.ksad_reward_js_actionbar_height)));
        } else {
            this.f26957qo.f26532oM.m31197a(this);
        }
        this.f26957qo.m32034b(this.mPlayEndPageListener);
    }

    public final void hide() {
        ViewGroup viewGroup = this.f27201sz;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ViewGroup viewGroup = this.f27201sz;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        C7838a.m32198eX().m32204a(PlayableSource.PENDANT_CLICK_NOT_AUTO);
        C9908c.m27306e(this.f26957qo.mAdTemplate, (JSONObject) null, new C9913b().m27264cM(Opcodes.CHECKCAST).m27269ah(this.f26957qo.f26529oJ.getPlayDuration()));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f27197sC = C7844b.m32183gv();
        this.f27196sB = !C7844b.m32181gx() && C7844b.m32182gw();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f26957qo.m32024c(this.mPlayEndPageListener);
        this.f26957qo.f26532oM.m31193b(this);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.platdetail.actionbar.InterfaceC8259a
    /* renamed from: a */
    public final void mo31183a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
        this.f27198sD = new WeakReference<>(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        C10331c.m26254d("RewardPlayablePreTips", "onActionBarShown: type: " + showActionBarResult + ", params.height: " + layoutParams.height + ", params.width: " + layoutParams.width);
        m31252a(layoutParams);
    }

    /* renamed from: a */
    private void m31252a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.f27201sz.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
            if (layoutParams.height == -1) {
                marginLayoutParams.bottomMargin = this.f27201sz.getResources().getDimensionPixelSize(C9659R.dimen.ksad_reward_playable_pre_tips_margin_bottom_without_actionbar);
            } else {
                int dimensionPixelSize = this.f27201sz.getResources().getDimensionPixelSize(C9659R.dimen.ksad_reward_playable_pre_tips_margin_bottom);
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                    WeakReference<View> weakReference = this.f27198sD;
                    View view = weakReference != null ? weakReference.get() : null;
                    int i = marginLayoutParams2.height;
                    if (i <= 0 && view != null) {
                        i = view.getHeight();
                    }
                    marginLayoutParams.bottomMargin = i + marginLayoutParams2.bottomMargin + dimensionPixelSize;
                } else {
                    marginLayoutParams.bottomMargin = layoutParams.height + dimensionPixelSize;
                }
            }
            this.f27201sz.setLayoutParams(marginLayoutParams);
        }
    }
}
