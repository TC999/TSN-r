package androidx.core.transition;

import android.transition.Transition;
import androidx.annotation.RequiresApi;
import com.umeng.ccg.CcgConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001a2\u0010\b\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0087\b\u001a2\u0010\t\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0087\b\u001a2\u0010\n\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0087\b\u001a2\u0010\u000b\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0087\b\u001a2\u0010\f\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0087\b\u001aÆ\u0001\u0010\u0012\u001a\u00020\u0007*\u00020\u00002#\b\u0006\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0087\b¨\u0006\u0013"}, m12616d2 = {"Landroid/transition/Transition;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "transition", "Lkotlin/f1;", CcgConstant.f38549t, "Landroid/transition/Transition$TransitionListener;", "doOnEnd", "doOnStart", "doOnCancel", "doOnResume", "doOnPause", "onEnd", "onStart", "onCancel", "onResume", "onPause", "addListener", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: androidx.core.transition.TransitionKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Transition {
    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener addListener(@NotNull android.transition.Transition addListener, @NotNull InterfaceC15280l<? super android.transition.Transition, Unit> onEnd, @NotNull InterfaceC15280l<? super android.transition.Transition, Unit> onStart, @NotNull InterfaceC15280l<? super android.transition.Transition, Unit> onCancel, @NotNull InterfaceC15280l<? super android.transition.Transition, Unit> onResume, @NotNull InterfaceC15280l<? super android.transition.Transition, Unit> onPause) {
        C14342f0.m8183q(addListener, "$this$addListener");
        C14342f0.m8183q(onEnd, "onEnd");
        C14342f0.m8183q(onStart, "onStart");
        C14342f0.m8183q(onCancel, "onCancel");
        C14342f0.m8183q(onResume, "onResume");
        C14342f0.m8183q(onPause, "onPause");
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(onEnd, onResume, onPause, onCancel, onStart);
        addListener.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    public static /* synthetic */ Transition.TransitionListener addListener$default(android.transition.Transition addListener, InterfaceC15280l onEnd, InterfaceC15280l interfaceC15280l, InterfaceC15280l interfaceC15280l2, InterfaceC15280l onResume, InterfaceC15280l onPause, int i, Object obj) {
        if ((i & 1) != 0) {
            onEnd = new InterfaceC15280l<android.transition.Transition, Unit>() { // from class: androidx.core.transition.TransitionKt$addListener$1
                @Override // p617l1.InterfaceC15280l
                public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
                    invoke2(transition);
                    return Unit.f41048a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Transition it) {
                    C14342f0.m8183q(it, "it");
                }
            };
        }
        if ((i & 2) != 0) {
            interfaceC15280l = new InterfaceC15280l<android.transition.Transition, Unit>() { // from class: androidx.core.transition.TransitionKt$addListener$2
                @Override // p617l1.InterfaceC15280l
                public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
                    invoke2(transition);
                    return Unit.f41048a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Transition it) {
                    C14342f0.m8183q(it, "it");
                }
            };
        }
        InterfaceC15280l onStart = interfaceC15280l;
        if ((i & 4) != 0) {
            interfaceC15280l2 = new InterfaceC15280l<android.transition.Transition, Unit>() { // from class: androidx.core.transition.TransitionKt$addListener$3
                @Override // p617l1.InterfaceC15280l
                public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
                    invoke2(transition);
                    return Unit.f41048a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Transition it) {
                    C14342f0.m8183q(it, "it");
                }
            };
        }
        InterfaceC15280l onCancel = interfaceC15280l2;
        if ((i & 8) != 0) {
            onResume = new InterfaceC15280l<android.transition.Transition, Unit>() { // from class: androidx.core.transition.TransitionKt$addListener$4
                @Override // p617l1.InterfaceC15280l
                public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
                    invoke2(transition);
                    return Unit.f41048a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Transition it) {
                    C14342f0.m8183q(it, "it");
                }
            };
        }
        if ((i & 16) != 0) {
            onPause = new InterfaceC15280l<android.transition.Transition, Unit>() { // from class: androidx.core.transition.TransitionKt$addListener$5
                @Override // p617l1.InterfaceC15280l
                public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
                    invoke2(transition);
                    return Unit.f41048a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Transition it) {
                    C14342f0.m8183q(it, "it");
                }
            };
        }
        C14342f0.m8183q(addListener, "$this$addListener");
        C14342f0.m8183q(onEnd, "onEnd");
        C14342f0.m8183q(onStart, "onStart");
        C14342f0.m8183q(onCancel, "onCancel");
        C14342f0.m8183q(onResume, "onResume");
        C14342f0.m8183q(onPause, "onPause");
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(onEnd, onResume, onPause, onCancel, onStart);
        addListener.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener doOnCancel(@NotNull android.transition.Transition doOnCancel, @NotNull final InterfaceC15280l<? super android.transition.Transition, Unit> action) {
        C14342f0.m8183q(doOnCancel, "$this$doOnCancel");
        C14342f0.m8183q(action, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnCancel$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@NotNull Transition transition) {
                C14342f0.m8183q(transition, "transition");
                InterfaceC15280l.this.invoke(transition);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition) {
                C14342f0.m8183q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@NotNull Transition transition) {
                C14342f0.m8183q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@NotNull Transition transition) {
                C14342f0.m8183q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition) {
                C14342f0.m8183q(transition, "transition");
            }
        };
        doOnCancel.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener doOnEnd(@NotNull android.transition.Transition doOnEnd, @NotNull final InterfaceC15280l<? super android.transition.Transition, Unit> action) {
        C14342f0.m8183q(doOnEnd, "$this$doOnEnd");
        C14342f0.m8183q(action, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnEnd$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@NotNull Transition transition) {
                C14342f0.m8183q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition) {
                C14342f0.m8183q(transition, "transition");
                InterfaceC15280l.this.invoke(transition);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@NotNull Transition transition) {
                C14342f0.m8183q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@NotNull Transition transition) {
                C14342f0.m8183q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition) {
                C14342f0.m8183q(transition, "transition");
            }
        };
        doOnEnd.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener doOnPause(@NotNull android.transition.Transition doOnPause, @NotNull final InterfaceC15280l<? super android.transition.Transition, Unit> action) {
        C14342f0.m8183q(doOnPause, "$this$doOnPause");
        C14342f0.m8183q(action, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnPause$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@NotNull Transition transition) {
                C14342f0.m8183q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition) {
                C14342f0.m8183q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@NotNull Transition transition) {
                C14342f0.m8183q(transition, "transition");
                InterfaceC15280l.this.invoke(transition);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@NotNull Transition transition) {
                C14342f0.m8183q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition) {
                C14342f0.m8183q(transition, "transition");
            }
        };
        doOnPause.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener doOnResume(@NotNull android.transition.Transition doOnResume, @NotNull final InterfaceC15280l<? super android.transition.Transition, Unit> action) {
        C14342f0.m8183q(doOnResume, "$this$doOnResume");
        C14342f0.m8183q(action, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnResume$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@NotNull Transition transition) {
                C14342f0.m8183q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition) {
                C14342f0.m8183q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@NotNull Transition transition) {
                C14342f0.m8183q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@NotNull Transition transition) {
                C14342f0.m8183q(transition, "transition");
                InterfaceC15280l.this.invoke(transition);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition) {
                C14342f0.m8183q(transition, "transition");
            }
        };
        doOnResume.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener doOnStart(@NotNull android.transition.Transition doOnStart, @NotNull final InterfaceC15280l<? super android.transition.Transition, Unit> action) {
        C14342f0.m8183q(doOnStart, "$this$doOnStart");
        C14342f0.m8183q(action, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnStart$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@NotNull Transition transition) {
                C14342f0.m8183q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition) {
                C14342f0.m8183q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@NotNull Transition transition) {
                C14342f0.m8183q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@NotNull Transition transition) {
                C14342f0.m8183q(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition) {
                C14342f0.m8183q(transition, "transition");
                InterfaceC15280l.this.invoke(transition);
            }
        };
        doOnStart.addListener(transitionListener);
        return transitionListener;
    }
}
