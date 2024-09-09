package androidx.core.animation;

import android.animation.Animator;
import androidx.annotation.RequiresApi;
import d2.l;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Animator.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a2\u0010\b\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0086\b\u001a2\u0010\t\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0086\b\u001a2\u0010\n\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0086\b\u001a2\u0010\u000b\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0086\b\u001a2\u0010\r\u001a\u00020\f*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0087\b\u001a2\u0010\u000e\u001a\u00020\f*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0087\b\u001a\u00a1\u0001\u0010\u0013\u001a\u00020\u0007*\u00020\u00002#\b\u0006\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0086\b\u001aW\u0010\u0016\u001a\u00020\f*\u00020\u00002#\b\u0006\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0087\b\u00a8\u0006\u0017"}, d2 = {"Landroid/animation/Animator;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "animator", "Lkotlin/f1;", "action", "Landroid/animation/Animator$AnimatorListener;", "doOnEnd", "doOnStart", "doOnCancel", "doOnRepeat", "Landroid/animation/Animator$AnimatorPauseListener;", "doOnResume", "doOnPause", "onEnd", "onStart", "onCancel", "onRepeat", "addListener", "onResume", "onPause", "addPauseListener", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class AnimatorKt {
    @NotNull
    public static final Animator.AnimatorListener addListener(@NotNull Animator addListener, @NotNull l<? super Animator, f1> onEnd, @NotNull l<? super Animator, f1> onStart, @NotNull l<? super Animator, f1> onCancel, @NotNull l<? super Animator, f1> onRepeat) {
        f0.q(addListener, "$this$addListener");
        f0.q(onEnd, "onEnd");
        f0.q(onStart, "onStart");
        f0.q(onCancel, "onCancel");
        f0.q(onRepeat, "onRepeat");
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(onRepeat, onEnd, onCancel, onStart);
        addListener.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    public static /* synthetic */ Animator.AnimatorListener addListener$default(Animator addListener, l onEnd, l onStart, l onCancel, l onRepeat, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            onEnd = new l<Animator, f1>() { // from class: androidx.core.animation.AnimatorKt$addListener$1
                @Override // d2.l
                public /* bridge */ /* synthetic */ f1 invoke(Animator animator) {
                    invoke2(animator);
                    return f1.f55527a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Animator it) {
                    f0.q(it, "it");
                }
            };
        }
        if ((i4 & 2) != 0) {
            onStart = new l<Animator, f1>() { // from class: androidx.core.animation.AnimatorKt$addListener$2
                @Override // d2.l
                public /* bridge */ /* synthetic */ f1 invoke(Animator animator) {
                    invoke2(animator);
                    return f1.f55527a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Animator it) {
                    f0.q(it, "it");
                }
            };
        }
        if ((i4 & 4) != 0) {
            onCancel = new l<Animator, f1>() { // from class: androidx.core.animation.AnimatorKt$addListener$3
                @Override // d2.l
                public /* bridge */ /* synthetic */ f1 invoke(Animator animator) {
                    invoke2(animator);
                    return f1.f55527a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Animator it) {
                    f0.q(it, "it");
                }
            };
        }
        if ((i4 & 8) != 0) {
            onRepeat = new l<Animator, f1>() { // from class: androidx.core.animation.AnimatorKt$addListener$4
                @Override // d2.l
                public /* bridge */ /* synthetic */ f1 invoke(Animator animator) {
                    invoke2(animator);
                    return f1.f55527a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Animator it) {
                    f0.q(it, "it");
                }
            };
        }
        f0.q(addListener, "$this$addListener");
        f0.q(onEnd, "onEnd");
        f0.q(onStart, "onStart");
        f0.q(onCancel, "onCancel");
        f0.q(onRepeat, "onRepeat");
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(onRepeat, onEnd, onCancel, onStart);
        addListener.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    @RequiresApi(19)
    @NotNull
    public static final Animator.AnimatorPauseListener addPauseListener(@NotNull Animator addPauseListener, @NotNull l<? super Animator, f1> onResume, @NotNull l<? super Animator, f1> onPause) {
        f0.q(addPauseListener, "$this$addPauseListener");
        f0.q(onResume, "onResume");
        f0.q(onPause, "onPause");
        AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(onPause, onResume);
        addPauseListener.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    public static /* synthetic */ Animator.AnimatorPauseListener addPauseListener$default(Animator addPauseListener, l onResume, l onPause, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            onResume = new l<Animator, f1>() { // from class: androidx.core.animation.AnimatorKt$addPauseListener$1
                @Override // d2.l
                public /* bridge */ /* synthetic */ f1 invoke(Animator animator) {
                    invoke2(animator);
                    return f1.f55527a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Animator it) {
                    f0.q(it, "it");
                }
            };
        }
        if ((i4 & 2) != 0) {
            onPause = new l<Animator, f1>() { // from class: androidx.core.animation.AnimatorKt$addPauseListener$2
                @Override // d2.l
                public /* bridge */ /* synthetic */ f1 invoke(Animator animator) {
                    invoke2(animator);
                    return f1.f55527a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Animator it) {
                    f0.q(it, "it");
                }
            };
        }
        f0.q(addPauseListener, "$this$addPauseListener");
        f0.q(onResume, "onResume");
        f0.q(onPause, "onPause");
        AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(onPause, onResume);
        addPauseListener.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    @NotNull
    public static final Animator.AnimatorListener doOnCancel(@NotNull Animator doOnCancel, @NotNull final l<? super Animator, f1> action) {
        f0.q(doOnCancel, "$this$doOnCancel");
        f0.q(action, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnCancel$$inlined$addListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator) {
                f0.q(animator, "animator");
                l.this.invoke(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator) {
                f0.q(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animator) {
                f0.q(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator) {
                f0.q(animator, "animator");
            }
        };
        doOnCancel.addListener(animatorListener);
        return animatorListener;
    }

    @NotNull
    public static final Animator.AnimatorListener doOnEnd(@NotNull Animator doOnEnd, @NotNull final l<? super Animator, f1> action) {
        f0.q(doOnEnd, "$this$doOnEnd");
        f0.q(action, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnEnd$$inlined$addListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator) {
                f0.q(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator) {
                f0.q(animator, "animator");
                l.this.invoke(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animator) {
                f0.q(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator) {
                f0.q(animator, "animator");
            }
        };
        doOnEnd.addListener(animatorListener);
        return animatorListener;
    }

    @RequiresApi(19)
    @NotNull
    public static final Animator.AnimatorPauseListener doOnPause(@NotNull Animator doOnPause, @NotNull final l<? super Animator, f1> action) {
        f0.q(doOnPause, "$this$doOnPause");
        f0.q(action, "action");
        Animator.AnimatorPauseListener animatorPauseListener = new Animator.AnimatorPauseListener() { // from class: androidx.core.animation.AnimatorKt$doOnPause$$inlined$addPauseListener$1
            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(@NotNull Animator animator) {
                f0.q(animator, "animator");
                l.this.invoke(animator);
            }

            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationResume(@NotNull Animator animator) {
                f0.q(animator, "animator");
            }
        };
        doOnPause.addPauseListener(animatorPauseListener);
        return animatorPauseListener;
    }

    @NotNull
    public static final Animator.AnimatorListener doOnRepeat(@NotNull Animator doOnRepeat, @NotNull final l<? super Animator, f1> action) {
        f0.q(doOnRepeat, "$this$doOnRepeat");
        f0.q(action, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnRepeat$$inlined$addListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator) {
                f0.q(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator) {
                f0.q(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animator) {
                f0.q(animator, "animator");
                l.this.invoke(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator) {
                f0.q(animator, "animator");
            }
        };
        doOnRepeat.addListener(animatorListener);
        return animatorListener;
    }

    @RequiresApi(19)
    @NotNull
    public static final Animator.AnimatorPauseListener doOnResume(@NotNull Animator doOnResume, @NotNull final l<? super Animator, f1> action) {
        f0.q(doOnResume, "$this$doOnResume");
        f0.q(action, "action");
        Animator.AnimatorPauseListener animatorPauseListener = new Animator.AnimatorPauseListener() { // from class: androidx.core.animation.AnimatorKt$doOnResume$$inlined$addPauseListener$1
            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(@NotNull Animator animator) {
                f0.q(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationResume(@NotNull Animator animator) {
                f0.q(animator, "animator");
                l.this.invoke(animator);
            }
        };
        doOnResume.addPauseListener(animatorPauseListener);
        return animatorPauseListener;
    }

    @NotNull
    public static final Animator.AnimatorListener doOnStart(@NotNull Animator doOnStart, @NotNull final l<? super Animator, f1> action) {
        f0.q(doOnStart, "$this$doOnStart");
        f0.q(action, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnStart$$inlined$addListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator) {
                f0.q(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator) {
                f0.q(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animator) {
                f0.q(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator) {
                f0.q(animator, "animator");
                l.this.invoke(animator);
            }
        };
        doOnStart.addListener(animatorListener);
        return animatorListener;
    }
}
