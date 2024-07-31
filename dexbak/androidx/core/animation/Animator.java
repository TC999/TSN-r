package androidx.core.animation;

import android.animation.Animator;
import androidx.annotation.RequiresApi;
import com.umeng.ccg.CcgConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a2\u0010\b\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0086\b\u001a2\u0010\t\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0086\b\u001a2\u0010\n\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0086\b\u001a2\u0010\u000b\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0086\b\u001a2\u0010\r\u001a\u00020\f*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0087\b\u001a2\u0010\u000e\u001a\u00020\f*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0087\b\u001a¡\u0001\u0010\u0013\u001a\u00020\u0007*\u00020\u00002#\b\u0006\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0086\b\u001aW\u0010\u0016\u001a\u00020\f*\u00020\u00002#\b\u0006\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0087\b¨\u0006\u0017"}, m12616d2 = {"Landroid/animation/Animator;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "animator", "Lkotlin/f1;", CcgConstant.f38549t, "Landroid/animation/Animator$AnimatorListener;", "doOnEnd", "doOnStart", "doOnCancel", "doOnRepeat", "Landroid/animation/Animator$AnimatorPauseListener;", "doOnResume", "doOnPause", "onEnd", "onStart", "onCancel", "onRepeat", "addListener", "onResume", "onPause", "addPauseListener", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: androidx.core.animation.AnimatorKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Animator {
    @NotNull
    public static final Animator.AnimatorListener addListener(@NotNull android.animation.Animator addListener, @NotNull InterfaceC15280l<? super android.animation.Animator, Unit> onEnd, @NotNull InterfaceC15280l<? super android.animation.Animator, Unit> onStart, @NotNull InterfaceC15280l<? super android.animation.Animator, Unit> onCancel, @NotNull InterfaceC15280l<? super android.animation.Animator, Unit> onRepeat) {
        C14342f0.m8183q(addListener, "$this$addListener");
        C14342f0.m8183q(onEnd, "onEnd");
        C14342f0.m8183q(onStart, "onStart");
        C14342f0.m8183q(onCancel, "onCancel");
        C14342f0.m8183q(onRepeat, "onRepeat");
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(onRepeat, onEnd, onCancel, onStart);
        addListener.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    public static /* synthetic */ Animator.AnimatorListener addListener$default(android.animation.Animator addListener, InterfaceC15280l onEnd, InterfaceC15280l onStart, InterfaceC15280l onCancel, InterfaceC15280l onRepeat, int i, Object obj) {
        if ((i & 1) != 0) {
            onEnd = new InterfaceC15280l<android.animation.Animator, Unit>() { // from class: androidx.core.animation.AnimatorKt$addListener$1
                @Override // p617l1.InterfaceC15280l
                public /* bridge */ /* synthetic */ Unit invoke(Animator animator) {
                    invoke2(animator);
                    return Unit.f41048a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Animator it) {
                    C14342f0.m8183q(it, "it");
                }
            };
        }
        if ((i & 2) != 0) {
            onStart = new InterfaceC15280l<android.animation.Animator, Unit>() { // from class: androidx.core.animation.AnimatorKt$addListener$2
                @Override // p617l1.InterfaceC15280l
                public /* bridge */ /* synthetic */ Unit invoke(Animator animator) {
                    invoke2(animator);
                    return Unit.f41048a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Animator it) {
                    C14342f0.m8183q(it, "it");
                }
            };
        }
        if ((i & 4) != 0) {
            onCancel = new InterfaceC15280l<android.animation.Animator, Unit>() { // from class: androidx.core.animation.AnimatorKt$addListener$3
                @Override // p617l1.InterfaceC15280l
                public /* bridge */ /* synthetic */ Unit invoke(Animator animator) {
                    invoke2(animator);
                    return Unit.f41048a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Animator it) {
                    C14342f0.m8183q(it, "it");
                }
            };
        }
        if ((i & 8) != 0) {
            onRepeat = new InterfaceC15280l<android.animation.Animator, Unit>() { // from class: androidx.core.animation.AnimatorKt$addListener$4
                @Override // p617l1.InterfaceC15280l
                public /* bridge */ /* synthetic */ Unit invoke(Animator animator) {
                    invoke2(animator);
                    return Unit.f41048a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Animator it) {
                    C14342f0.m8183q(it, "it");
                }
            };
        }
        C14342f0.m8183q(addListener, "$this$addListener");
        C14342f0.m8183q(onEnd, "onEnd");
        C14342f0.m8183q(onStart, "onStart");
        C14342f0.m8183q(onCancel, "onCancel");
        C14342f0.m8183q(onRepeat, "onRepeat");
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(onRepeat, onEnd, onCancel, onStart);
        addListener.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    @RequiresApi(19)
    @NotNull
    public static final Animator.AnimatorPauseListener addPauseListener(@NotNull android.animation.Animator addPauseListener, @NotNull InterfaceC15280l<? super android.animation.Animator, Unit> onResume, @NotNull InterfaceC15280l<? super android.animation.Animator, Unit> onPause) {
        C14342f0.m8183q(addPauseListener, "$this$addPauseListener");
        C14342f0.m8183q(onResume, "onResume");
        C14342f0.m8183q(onPause, "onPause");
        AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(onPause, onResume);
        addPauseListener.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    public static /* synthetic */ Animator.AnimatorPauseListener addPauseListener$default(android.animation.Animator addPauseListener, InterfaceC15280l onResume, InterfaceC15280l onPause, int i, Object obj) {
        if ((i & 1) != 0) {
            onResume = new InterfaceC15280l<android.animation.Animator, Unit>() { // from class: androidx.core.animation.AnimatorKt$addPauseListener$1
                @Override // p617l1.InterfaceC15280l
                public /* bridge */ /* synthetic */ Unit invoke(Animator animator) {
                    invoke2(animator);
                    return Unit.f41048a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Animator it) {
                    C14342f0.m8183q(it, "it");
                }
            };
        }
        if ((i & 2) != 0) {
            onPause = new InterfaceC15280l<android.animation.Animator, Unit>() { // from class: androidx.core.animation.AnimatorKt$addPauseListener$2
                @Override // p617l1.InterfaceC15280l
                public /* bridge */ /* synthetic */ Unit invoke(Animator animator) {
                    invoke2(animator);
                    return Unit.f41048a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Animator it) {
                    C14342f0.m8183q(it, "it");
                }
            };
        }
        C14342f0.m8183q(addPauseListener, "$this$addPauseListener");
        C14342f0.m8183q(onResume, "onResume");
        C14342f0.m8183q(onPause, "onPause");
        AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(onPause, onResume);
        addPauseListener.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    @NotNull
    public static final Animator.AnimatorListener doOnCancel(@NotNull android.animation.Animator doOnCancel, @NotNull final InterfaceC15280l<? super android.animation.Animator, Unit> action) {
        C14342f0.m8183q(doOnCancel, "$this$doOnCancel");
        C14342f0.m8183q(action, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnCancel$$inlined$addListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator) {
                C14342f0.m8183q(animator, "animator");
                InterfaceC15280l.this.invoke(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator) {
                C14342f0.m8183q(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animator) {
                C14342f0.m8183q(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator) {
                C14342f0.m8183q(animator, "animator");
            }
        };
        doOnCancel.addListener(animatorListener);
        return animatorListener;
    }

    @NotNull
    public static final Animator.AnimatorListener doOnEnd(@NotNull android.animation.Animator doOnEnd, @NotNull final InterfaceC15280l<? super android.animation.Animator, Unit> action) {
        C14342f0.m8183q(doOnEnd, "$this$doOnEnd");
        C14342f0.m8183q(action, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnEnd$$inlined$addListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator) {
                C14342f0.m8183q(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator) {
                C14342f0.m8183q(animator, "animator");
                InterfaceC15280l.this.invoke(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animator) {
                C14342f0.m8183q(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator) {
                C14342f0.m8183q(animator, "animator");
            }
        };
        doOnEnd.addListener(animatorListener);
        return animatorListener;
    }

    @RequiresApi(19)
    @NotNull
    public static final Animator.AnimatorPauseListener doOnPause(@NotNull android.animation.Animator doOnPause, @NotNull final InterfaceC15280l<? super android.animation.Animator, Unit> action) {
        C14342f0.m8183q(doOnPause, "$this$doOnPause");
        C14342f0.m8183q(action, "action");
        Animator.AnimatorPauseListener animatorPauseListener = new Animator.AnimatorPauseListener() { // from class: androidx.core.animation.AnimatorKt$doOnPause$$inlined$addPauseListener$1
            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(@NotNull Animator animator) {
                C14342f0.m8183q(animator, "animator");
                InterfaceC15280l.this.invoke(animator);
            }

            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationResume(@NotNull Animator animator) {
                C14342f0.m8183q(animator, "animator");
            }
        };
        doOnPause.addPauseListener(animatorPauseListener);
        return animatorPauseListener;
    }

    @NotNull
    public static final Animator.AnimatorListener doOnRepeat(@NotNull android.animation.Animator doOnRepeat, @NotNull final InterfaceC15280l<? super android.animation.Animator, Unit> action) {
        C14342f0.m8183q(doOnRepeat, "$this$doOnRepeat");
        C14342f0.m8183q(action, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnRepeat$$inlined$addListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator) {
                C14342f0.m8183q(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator) {
                C14342f0.m8183q(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animator) {
                C14342f0.m8183q(animator, "animator");
                InterfaceC15280l.this.invoke(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator) {
                C14342f0.m8183q(animator, "animator");
            }
        };
        doOnRepeat.addListener(animatorListener);
        return animatorListener;
    }

    @RequiresApi(19)
    @NotNull
    public static final Animator.AnimatorPauseListener doOnResume(@NotNull android.animation.Animator doOnResume, @NotNull final InterfaceC15280l<? super android.animation.Animator, Unit> action) {
        C14342f0.m8183q(doOnResume, "$this$doOnResume");
        C14342f0.m8183q(action, "action");
        Animator.AnimatorPauseListener animatorPauseListener = new Animator.AnimatorPauseListener() { // from class: androidx.core.animation.AnimatorKt$doOnResume$$inlined$addPauseListener$1
            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(@NotNull Animator animator) {
                C14342f0.m8183q(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationResume(@NotNull Animator animator) {
                C14342f0.m8183q(animator, "animator");
                InterfaceC15280l.this.invoke(animator);
            }
        };
        doOnResume.addPauseListener(animatorPauseListener);
        return animatorPauseListener;
    }

    @NotNull
    public static final Animator.AnimatorListener doOnStart(@NotNull android.animation.Animator doOnStart, @NotNull final InterfaceC15280l<? super android.animation.Animator, Unit> action) {
        C14342f0.m8183q(doOnStart, "$this$doOnStart");
        C14342f0.m8183q(action, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnStart$$inlined$addListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator) {
                C14342f0.m8183q(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator) {
                C14342f0.m8183q(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animator) {
                C14342f0.m8183q(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator) {
                C14342f0.m8183q(animator, "animator");
                InterfaceC15280l.this.invoke(animator);
            }
        };
        doOnStart.addListener(animatorListener);
        return animatorListener;
    }
}
