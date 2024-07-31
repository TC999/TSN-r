package com.bxkj.student.p094v2.p098ui.sports.p102v3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import cn.bluemobi.dylan.base.utils.AppManager;
import com.bxkj.base.p085v2.base.BaseActivity;
import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.student.C4215R;
import com.bxkj.student.common.utils.C4254l;
import com.bxkj.student.databinding.V3AcThreetwooneBinding;
import com.bxkj.student.p094v2.common.data.SportsDataAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p581d0.VoiceUtils;

/* compiled from: V3ThreeTwoOneActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0014J\b\u0010\t\u001a\u00020\u0004H\u0016R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/V3ThreeTwoOneActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/V3AcThreetwooneBinding;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "Lkotlin/f1;", "N", ExifInterface.LONGITUDE_EAST, "p", "onResume", "onBackPressed", "", "i", "I", "count", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.v3.V3ThreeTwoOneActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class V3ThreeTwoOneActivity extends BaseActivity<V3AcThreetwooneBinding, BaseViewModel> {

    /* renamed from: i */
    private int f20661i = 4;

    /* compiled from: V3ThreeTwoOneActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/student/v2/ui/sports/v3/V3ThreeTwoOneActivity$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "Lkotlin/f1;", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3ThreeTwoOneActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5755a extends AnimatorListenerAdapter {
        C5755a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            C14342f0.m8184p(animation, "animation");
            super.onAnimationEnd(animation);
            V3SportsMapActivity v3SportsMapActivity = (V3SportsMapActivity) AppManager.m57776n().getActivity(V3SportsMapActivity.class);
            if (v3SportsMapActivity != null) {
                v3SportsMapActivity.m38471R(true);
                if (v3SportsMapActivity.m38474O()) {
                    v3SportsMapActivity.m38469T();
                }
            }
            V3ThreeTwoOneActivity.this.finish();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animation) {
            C14342f0.m8184p(animation, "animation");
            super.onAnimationRepeat(animation);
            V3ThreeTwoOneActivity v3ThreeTwoOneActivity = V3ThreeTwoOneActivity.this;
            v3ThreeTwoOneActivity.f20661i--;
            int i = V3ThreeTwoOneActivity.this.f20661i;
            if (i == 0) {
                V3ThreeTwoOneActivity.this.mo43920M().tvNumber.setText("GO");
                VoiceUtils.f40105a.m12842b(V3ThreeTwoOneActivity.this.mo43926C(), C4215R.raw.f16021go);
            } else if (i == 1) {
                V3ThreeTwoOneActivity.this.mo43920M().tvNumber.setText("1");
                VoiceUtils.f40105a.m12842b(V3ThreeTwoOneActivity.this.mo43926C(), C4215R.raw.countdown1);
            } else if (i != 2) {
            } else {
                V3ThreeTwoOneActivity.this.mo43920M().tvNumber.setText("2");
                VoiceUtils.f40105a.m12842b(V3ThreeTwoOneActivity.this.mo43926C(), C4215R.raw.countdown2);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animator) {
            super.onAnimationStart(animator);
            V3ThreeTwoOneActivity.this.mo43920M().tvNumber.setText("3");
            VoiceUtils.f40105a.m12842b(V3ThreeTwoOneActivity.this.mo43926C(), C4215R.raw.countdown3);
        }
    }

    /* renamed from: N */
    private final void m38463N() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(mo43920M().tvNumber, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f));
        C14342f0.m8185o(ofPropertyValuesHolder, "ofPropertyValuesHolder(\n…ctAnimatorAlpha\n        )");
        ofPropertyValuesHolder.setDuration(1000L);
        ofPropertyValuesHolder.setRepeatCount(3);
        this.f20661i = 3;
        ofPropertyValuesHolder.addListener(new C5755a());
        ofPropertyValuesHolder.start();
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        int m43769k = JsonGet.f15134a.m43769k(SportsDataAgent.f19899a.m39250v(), "runType");
        int i = m43769k != 0 ? m43769k != 2 ? C4215R.C4217color.v3_tab_color2_no_translation : C4215R.C4217color.v3_tab_color1_no_translation : C4215R.C4217color.v3_tab_color3_no_translation;
        mo43920M().rlThreetwoone.setBackgroundResource(i);
        C4254l.m42811g(this, ContextCompat.getColor(mo43926C(), i));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        m38463N();
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
    }
}
