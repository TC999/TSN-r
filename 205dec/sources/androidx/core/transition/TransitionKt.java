package androidx.core.transition;

import android.transition.Transition;
import androidx.annotation.RequiresApi;
import d2.l;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Transition.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001a2\u0010\b\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0087\b\u001a2\u0010\t\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0087\b\u001a2\u0010\n\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0087\b\u001a2\u0010\u000b\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0087\b\u001a2\u0010\f\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0087\b\u001a\u00c6\u0001\u0010\u0012\u001a\u00020\u0007*\u00020\u00002#\b\u0006\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0087\b\u00a8\u0006\u0013"}, d2 = {"Landroid/transition/Transition;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "transition", "Lkotlin/f1;", "action", "Landroid/transition/Transition$TransitionListener;", "doOnEnd", "doOnStart", "doOnCancel", "doOnResume", "doOnPause", "onEnd", "onStart", "onCancel", "onResume", "onPause", "addListener", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class TransitionKt {
    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener addListener(@NotNull Transition addListener, @NotNull l<? super Transition, f1> onEnd, @NotNull l<? super Transition, f1> onStart, @NotNull l<? super Transition, f1> onCancel, @NotNull l<? super Transition, f1> onResume, @NotNull l<? super Transition, f1> onPause) {
        f0.q(addListener, "$this$addListener");
        f0.q(onEnd, "onEnd");
        f0.q(onStart, "onStart");
        f0.q(onCancel, "onCancel");
        f0.q(onResume, "onResume");
        f0.q(onPause, "onPause");
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(onEnd, onResume, onPause, onCancel, onStart);
        addListener.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    public static /* synthetic */ Transition.TransitionListener addListener$default(Transition addListener, l onEnd, l lVar, l lVar2, l onResume, l onPause, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            onEnd = new l<Transition, f1>() { // from class: androidx.core.transition.TransitionKt$addListener$1
                @Override // d2.l
                public /* bridge */ /* synthetic */ f1 invoke(Transition transition) {
                    invoke2(transition);
                    return f1.f55527a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Transition it) {
                    f0.q(it, "it");
                }
            };
        }
        if ((i4 & 2) != 0) {
            lVar = new l<Transition, f1>() { // from class: androidx.core.transition.TransitionKt$addListener$2
                @Override // d2.l
                public /* bridge */ /* synthetic */ f1 invoke(Transition transition) {
                    invoke2(transition);
                    return f1.f55527a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Transition it) {
                    f0.q(it, "it");
                }
            };
        }
        l onStart = lVar;
        if ((i4 & 4) != 0) {
            lVar2 = new l<Transition, f1>() { // from class: androidx.core.transition.TransitionKt$addListener$3
                @Override // d2.l
                public /* bridge */ /* synthetic */ f1 invoke(Transition transition) {
                    invoke2(transition);
                    return f1.f55527a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Transition it) {
                    f0.q(it, "it");
                }
            };
        }
        l onCancel = lVar2;
        if ((i4 & 8) != 0) {
            onResume = new l<Transition, f1>() { // from class: androidx.core.transition.TransitionKt$addListener$4
                @Override // d2.l
                public /* bridge */ /* synthetic */ f1 invoke(Transition transition) {
                    invoke2(transition);
                    return f1.f55527a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Transition it) {
                    f0.q(it, "it");
                }
            };
        }
        if ((i4 & 16) != 0) {
            onPause = new l<Transition, f1>() { // from class: androidx.core.transition.TransitionKt$addListener$5
                @Override // d2.l
                public /* bridge */ /* synthetic */ f1 invoke(Transition transition) {
                    invoke2(transition);
                    return f1.f55527a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Transition it) {
                    f0.q(it, "it");
                }
            };
        }
        f0.q(addListener, "$this$addListener");
        f0.q(onEnd, "onEnd");
        f0.q(onStart, "onStart");
        f0.q(onCancel, "onCancel");
        f0.q(onResume, "onResume");
        f0.q(onPause, "onPause");
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(onEnd, onResume, onPause, onCancel, onStart);
        addListener.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener doOnCancel(@NotNull Transition doOnCancel, @NotNull final l<? super Transition, f1> action) {
        f0.q(doOnCancel, "$this$doOnCancel");
        f0.q(action, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnCancel$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@NotNull Transition transition) {
                f0.q(transition, "transition");
                l.this.invoke(transition);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition) {
                f0.q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@NotNull Transition transition) {
                f0.q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@NotNull Transition transition) {
                f0.q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition) {
                f0.q(transition, "transition");
            }
        };
        doOnCancel.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener doOnEnd(@NotNull Transition doOnEnd, @NotNull final l<? super Transition, f1> action) {
        f0.q(doOnEnd, "$this$doOnEnd");
        f0.q(action, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnEnd$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@NotNull Transition transition) {
                f0.q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition) {
                f0.q(transition, "transition");
                l.this.invoke(transition);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@NotNull Transition transition) {
                f0.q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@NotNull Transition transition) {
                f0.q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition) {
                f0.q(transition, "transition");
            }
        };
        doOnEnd.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener doOnPause(@NotNull Transition doOnPause, @NotNull final l<? super Transition, f1> action) {
        f0.q(doOnPause, "$this$doOnPause");
        f0.q(action, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnPause$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@NotNull Transition transition) {
                f0.q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition) {
                f0.q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@NotNull Transition transition) {
                f0.q(transition, "transition");
                l.this.invoke(transition);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@NotNull Transition transition) {
                f0.q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition) {
                f0.q(transition, "transition");
            }
        };
        doOnPause.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener doOnResume(@NotNull Transition doOnResume, @NotNull final l<? super Transition, f1> action) {
        f0.q(doOnResume, "$this$doOnResume");
        f0.q(action, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnResume$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@NotNull Transition transition) {
                f0.q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition) {
                f0.q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@NotNull Transition transition) {
                f0.q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@NotNull Transition transition) {
                f0.q(transition, "transition");
                l.this.invoke(transition);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition) {
                f0.q(transition, "transition");
            }
        };
        doOnResume.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener doOnStart(@NotNull Transition doOnStart, @NotNull final l<? super Transition, f1> action) {
        f0.q(doOnStart, "$this$doOnStart");
        f0.q(action, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnStart$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@NotNull Transition transition) {
                f0.q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition) {
                f0.q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@NotNull Transition transition) {
                f0.q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@NotNull Transition transition) {
                f0.q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition) {
                f0.q(transition, "transition");
                l.this.invoke(transition);
            }
        };
        doOnStart.addListener(transitionListener);
        return transitionListener;
    }
}
