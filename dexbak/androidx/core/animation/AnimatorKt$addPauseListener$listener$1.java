package androidx.core.animation;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

/* compiled from: Animator.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, m12616d2 = {"androidx/core/animation/AnimatorKt$addPauseListener$listener$1", "Landroid/animation/Animator$AnimatorPauseListener;", "Landroid/animation/Animator;", "animator", "Lkotlin/f1;", "onAnimationPause", "onAnimationResume", "core-ktx_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class AnimatorKt$addPauseListener$listener$1 implements Animator.AnimatorPauseListener {
    final /* synthetic */ InterfaceC15280l $onPause;
    final /* synthetic */ InterfaceC15280l $onResume;

    public AnimatorKt$addPauseListener$listener$1(InterfaceC15280l interfaceC15280l, InterfaceC15280l interfaceC15280l2) {
        this.$onPause = interfaceC15280l;
        this.$onResume = interfaceC15280l2;
    }

    @Override // android.animation.Animator.AnimatorPauseListener
    public void onAnimationPause(@NotNull Animator animator) {
        C14342f0.m8183q(animator, "animator");
        this.$onPause.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorPauseListener
    public void onAnimationResume(@NotNull Animator animator) {
        C14342f0.m8183q(animator, "animator");
        this.$onResume.invoke(animator);
    }
}
