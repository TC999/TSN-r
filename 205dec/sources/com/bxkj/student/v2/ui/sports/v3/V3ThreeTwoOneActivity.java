package com.bxkj.student.v2.ui.sports.v3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import androidx.core.content.ContextCompat;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.student.databinding.V3AcThreetwooneBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: V3ThreeTwoOneActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0014J\b\u0010\t\u001a\u00020\u0004H\u0016R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/V3ThreeTwoOneActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/V3AcThreetwooneBinding;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "Lkotlin/f1;", "N", "E", "p", "onResume", "onBackPressed", "", "i", "I", "count", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class V3ThreeTwoOneActivity extends BaseActivity<V3AcThreetwooneBinding, BaseViewModel> {

    /* renamed from: i  reason: collision with root package name */
    private int f24076i = 4;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3ThreeTwoOneActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/V3ThreeTwoOneActivity$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "Lkotlin/f1;", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            f0.p(animation, "animation");
            super.onAnimationEnd(animation);
            V3SportsMapActivity v3SportsMapActivity = (V3SportsMapActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(V3SportsMapActivity.class);
            if (v3SportsMapActivity != null) {
                v3SportsMapActivity.R(true);
                if (v3SportsMapActivity.O()) {
                    v3SportsMapActivity.T();
                }
            }
            V3ThreeTwoOneActivity.this.finish();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animation) {
            f0.p(animation, "animation");
            super.onAnimationRepeat(animation);
            V3ThreeTwoOneActivity v3ThreeTwoOneActivity = V3ThreeTwoOneActivity.this;
            v3ThreeTwoOneActivity.f24076i--;
            int i4 = V3ThreeTwoOneActivity.this.f24076i;
            if (i4 == 0) {
                V3ThreeTwoOneActivity.this.M().tvNumber.setText("GO");
                d0.a.f54621a.b(V3ThreeTwoOneActivity.this.C(), 2131755023);
            } else if (i4 == 1) {
                V3ThreeTwoOneActivity.this.M().tvNumber.setText("1");
                d0.a.f54621a.b(V3ThreeTwoOneActivity.this.C(), 2131755011);
            } else if (i4 != 2) {
            } else {
                V3ThreeTwoOneActivity.this.M().tvNumber.setText("2");
                d0.a.f54621a.b(V3ThreeTwoOneActivity.this.C(), 2131755012);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animator) {
            super.onAnimationStart(animator);
            V3ThreeTwoOneActivity.this.M().tvNumber.setText("3");
            d0.a.f54621a.b(V3ThreeTwoOneActivity.this.C(), 2131755013);
        }
    }

    private final void N() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(M().tvNumber, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f));
        f0.o(ofPropertyValuesHolder, "ofPropertyValuesHolder(\n\u2026ctAnimatorAlpha\n        )");
        ofPropertyValuesHolder.setDuration(1000L);
        ofPropertyValuesHolder.setRepeatCount(3);
        this.f24076i = 3;
        ofPropertyValuesHolder.addListener(new a());
        ofPropertyValuesHolder.start();
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        int k4 = com.bxkj.base.v2.common.utils.l.f18624a.k(com.bxkj.student.v2.common.data.b.a.v(), "runType");
        int i4 = k4 != 0 ? k4 != 2 ? 2131034570 : 2131034568 : 2131034572;
        M().rlThreetwoone.setBackgroundResource(i4);
        com.bxkj.student.common.utils.l.g(this, ContextCompat.getColor(C(), i4));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        N();
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
