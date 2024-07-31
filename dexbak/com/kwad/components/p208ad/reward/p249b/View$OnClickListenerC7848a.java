package com.kwad.components.p208ad.reward.p249b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.kwad.components.p208ad.reward.p248a.C7844b;
import com.kwad.components.p208ad.reward.p264n.AbstractC8041d;
import com.kwad.components.p208ad.reward.p264n.C8074r;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC7848a extends AbstractC8041d implements View.OnClickListener {

    /* renamed from: gS */
    private final ViewGroup f26445gS;

    /* renamed from: hz */
    private TextView f26446hz;

    /* renamed from: lw */
    private TextView f26447lw;

    /* renamed from: qL */
    private int[] f26448qL;

    /* renamed from: qM */
    private View f26449qM;

    /* renamed from: qN */
    private ImageView f26450qN;

    /* renamed from: qO */
    private TextView f26451qO;

    /* renamed from: qP */
    private Button f26452qP;
    @Nullable

    /* renamed from: qQ */
    private InterfaceC7854b f26453qQ;

    /* renamed from: com.kwad.components.ad.reward.b.a$1 */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    final class C78491 extends AbstractRunnableC11033ay {

        /* renamed from: qR */
        final /* synthetic */ C8074r f26454qR;

        /* renamed from: qS */
        final /* synthetic */ long f26455qS;

        C78491(C8074r c8074r, long j) {
            this.f26454qR = c8074r;
            this.f26455qS = j;
        }

        @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
        public final void doTask() {
            View$OnClickListenerC7848a view$OnClickListenerC7848a = View$OnClickListenerC7848a.this;
            final Animator m32167a = View$OnClickListenerC7848a.m32167a(view$OnClickListenerC7848a, view$OnClickListenerC7848a.f26449qM);
            m32167a.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.b.a.1.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    m32167a.removeListener(this);
                    C9908c.m27337b(C78491.this.f26454qR.getAdTemplate(), (int) Opcodes.RET, (JSONObject) null);
                    View$OnClickListenerC7848a view$OnClickListenerC7848a2 = View$OnClickListenerC7848a.this;
                    View$OnClickListenerC7848a.m32166a(view$OnClickListenerC7848a2, view$OnClickListenerC7848a2.f26450qN, C78491.this.f26455qS).start();
                    C11064bn.m23862a(new Runnable() { // from class: com.kwad.components.ad.reward.b.a.1.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            View$OnClickListenerC7848a.this.m32160gG();
                        }
                    }, null, C78491.this.f26455qS);
                }
            });
            m32167a.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.reward.b.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7853a {

        /* renamed from: qY */
        private CharSequence f26462qY;

        /* renamed from: qZ */
        private CharSequence f26463qZ;

        /* renamed from: ra */
        private CharSequence f26464ra;
        private CharSequence title;

        private C7853a(@NonNull CouponInfo couponInfo) {
            this.title = couponInfo.displayTitle;
            this.f26462qY = couponInfo.displayValue;
            if (TextUtils.isEmpty(couponInfo.displayBase)) {
                this.f26463qZ = "";
            } else {
                this.f26463qZ = String.format("满%s可用", couponInfo.displayBase);
            }
            this.f26464ra = couponInfo.displayActionWords;
        }

        @Nullable
        /* renamed from: H */
        public static C7853a m32157H(AdTemplate adTemplate) {
            List<CouponInfo> list;
            AdProductInfo m25838cP = C10483a.m25838cP(C10487e.m25641dQ(adTemplate));
            if (m25838cP == null || (list = m25838cP.couponList) == null || list.size() <= 0) {
                return null;
            }
            return m32155a(m25838cP.couponList.get(0));
        }

        @Nullable
        /* renamed from: a */
        private static C7853a m32155a(CouponInfo couponInfo) {
            if (couponInfo == null) {
                return null;
            }
            return new C7853a(couponInfo);
        }

        /* renamed from: L */
        public final CharSequence m32156L(Context context) {
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(context.getResources().getDimensionPixelSize(C9659R.dimen.ksad_coupon_dialog_value_prefix_text_size));
            SpannableString spannableString = new SpannableString("¥" + ((Object) this.f26462qY));
            spannableString.setSpan(absoluteSizeSpan, 0, 1, 17);
            return spannableString;
        }

        /* renamed from: gH */
        public final CharSequence m32154gH() {
            return this.f26463qZ;
        }

        /* renamed from: gI */
        public final CharSequence m32153gI() {
            return this.f26464ra;
        }

        public final CharSequence getTitle() {
            return this.title;
        }
    }

    /* renamed from: com.kwad.components.ad.reward.b.a$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7854b {
        /* renamed from: gJ */
        void mo32150gJ();

        /* renamed from: gK */
        void mo32149gK();
    }

    public View$OnClickListenerC7848a(Context context, @Nullable ViewGroup viewGroup, @Nullable int[] iArr) {
        this.f26448qL = iArr;
        ViewGroup viewGroup2 = (ViewGroup) C10887l.m24563a(context, C9659R.C9663layout.ksad_reward_coupon_dialog, viewGroup, false);
        this.f26445gS = viewGroup2;
        m32163d(viewGroup2);
    }

    /* renamed from: a */
    static /* synthetic */ Animator m32167a(View$OnClickListenerC7848a view$OnClickListenerC7848a, View view) {
        return m32159m(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: gG */
    public void m32160gG() {
        final Animator m32158n = m32158n(this.f26449qM);
        m32158n.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                m32158n.removeListener(this);
                if (View$OnClickListenerC7848a.this.f26453qQ != null) {
                    View$OnClickListenerC7848a.this.f26453qQ.mo32149gK();
                }
            }
        });
        m32158n.start();
    }

    /* renamed from: m */
    private static Animator m32159m(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    /* renamed from: n */
    private Animator m32158n(View view) {
        ObjectAnimator objectAnimator;
        int[] m24926E;
        Interpolator create = PathInterpolatorCompat.create(0.89f, 0.02f, 0.72f, 1.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.0f);
        ofFloat.setInterpolator(create);
        ofFloat2.setInterpolator(create);
        int[] iArr = this.f26448qL;
        ObjectAnimator objectAnimator2 = null;
        if (iArr == null || iArr.length < 2 || (m24926E = C10751a.m24926E(view)) == null) {
            objectAnimator = null;
        } else {
            Interpolator create2 = PathInterpolatorCompat.create(0.33f, 0.0f, 0.83f, 1.0f);
            objectAnimator2 = ObjectAnimator.ofFloat(view, "translationX", this.f26448qL[0] - m24926E[0]);
            objectAnimator = ObjectAnimator.ofFloat(view, "translationY", this.f26448qL[1] - m24926E[1]);
            objectAnimator2.setInterpolator(create2);
            objectAnimator.setInterpolator(create2);
        }
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f);
        ofFloat3.setDuration(200L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        ofFloat4.setDuration(200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat3, ofFloat4);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(500L);
        if (objectAnimator2 != null) {
            animatorSet2.playTogether(ofFloat, ofFloat2, animatorSet, objectAnimator2, objectAnimator);
        } else {
            animatorSet2.playTogether(ofFloat, ofFloat2, animatorSet);
        }
        return animatorSet2;
    }

    @Override // com.kwad.components.p208ad.reward.p264n.AbstractC8041d
    /* renamed from: gF */
    public final ViewGroup mo31643gF() {
        return this.f26445gS;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        InterfaceC7854b interfaceC7854b;
        if (!view.equals(this.f26452qP) || (interfaceC7854b = this.f26453qQ) == null) {
            return;
        }
        interfaceC7854b.mo32150gJ();
    }

    /* renamed from: a */
    static /* synthetic */ Animator m32166a(View$OnClickListenerC7848a view$OnClickListenerC7848a, ImageView imageView, long j) {
        return m32171a(imageView, j);
    }

    /* renamed from: d */
    private void m32163d(ViewGroup viewGroup) {
        this.f26449qM = viewGroup.findViewById(C9659R.C9662id.ksad_coupon_dialog_card);
        this.f26450qN = (ImageView) viewGroup.findViewById(C9659R.C9662id.ksad_coupon_dialog_bg);
        this.f26446hz = (TextView) viewGroup.findViewById(C9659R.C9662id.ksad_coupon_dialog_title);
        this.f26451qO = (TextView) viewGroup.findViewById(C9659R.C9662id.ksad_coupon_dialog_content);
        this.f26447lw = (TextView) viewGroup.findViewById(C9659R.C9662id.ksad_coupon_dialog_desc);
        Button button = (Button) viewGroup.findViewById(C9659R.C9662id.ksad_coupon_dialog_btn_action);
        this.f26452qP = button;
        button.setOnClickListener(this);
    }

    /* renamed from: a */
    public final void m32169a(@Nullable InterfaceC7854b interfaceC7854b) {
        this.f26453qQ = interfaceC7854b;
    }

    @Override // com.kwad.components.p208ad.reward.p264n.AbstractC8041d
    /* renamed from: a */
    public final void mo31651a(C8074r c8074r) {
        super.mo31651a(c8074r);
        m32170a(C7853a.m32157H(c8074r.getAdTemplate()));
        this.f26445gS.post(new C78491(c8074r, C7844b.m32180gy()));
    }

    /* renamed from: a */
    private void m32170a(C7853a c7853a) {
        if (c7853a == null) {
            return;
        }
        TextView textView = this.f26446hz;
        if (textView != null) {
            textView.setText(c7853a.getTitle());
        }
        TextView textView2 = this.f26451qO;
        if (textView2 != null) {
            textView2.setText(c7853a.m32156L(this.f26445gS.getContext()));
        }
        TextView textView3 = this.f26447lw;
        if (textView3 != null) {
            textView3.setText(c7853a.m32154gH());
        }
        Button button = this.f26452qP;
        if (button != null) {
            button.setText(c7853a.m32153gI());
        }
    }

    /* renamed from: a */
    private static Animator m32171a(ImageView imageView, long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "alpha", imageView.getAlpha(), 0.0f);
        ofFloat.setDuration(j);
        return ofFloat;
    }
}
