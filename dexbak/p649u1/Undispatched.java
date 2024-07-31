package p649u1;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.open.SocialConstants;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.C15134m2;
import kotlinx.coroutines.CompletionState;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.Scopes;
import kotlinx.coroutines.internal.ThreadContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a@\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001aT\u0010\u000b\u001a\u00020\u0005\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t2\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a@\u0010\r\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0007\u001aT\u0010\u000e\u001a\u00020\u0005\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t2\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\f\u001a9\u0010\u0010\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u001a\u0010\u000f\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0082\b\u001a[\u0010\u0013\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\n\u001a\u00028\u00012'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t¢\u0006\u0002\b\u0012H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a[\u0010\u0015\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\n\u001a\u00028\u00012'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t¢\u0006\u0002\b\u0012H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0014\u001a?\u0010\u001b\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00112\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00012\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0019H\u0082\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "", "completion", "Lkotlin/f1;", "c", "(Ll1/l;Lkotlin/coroutines/c;)V", "R", "Lkotlin/Function2;", SocialConstants.PARAM_RECEIVER, "d", "(Ll1/p;Ljava/lang/Object;Lkotlin/coroutines/c;)V", "a", "b", "block", "e", "Lkotlinx/coroutines/internal/f0;", "Lkotlin/ExtensionFunctionType;", "f", "(Lkotlinx/coroutines/internal/f0;Ljava/lang/Object;Ll1/p;)Ljava/lang/Object;", "g", "", "", "shouldThrow", "Lkotlin/Function0;", "startBlock", "h", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: u1.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Undispatched {
    /* renamed from: a */
    public static final <T> void m225a(@NotNull InterfaceC15280l<? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15280l, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        Object m8642h;
        InterfaceC14268c m8618a = DebugProbes.m8618a(interfaceC14268c);
        try {
            CoroutineContext context = interfaceC14268c.getContext();
            Object m4253c = ThreadContext.m4253c(context, null);
            if (interfaceC15280l != null) {
                Object invoke = ((InterfaceC15280l) TypeIntrinsics.m8010q(interfaceC15280l, 1)).invoke(m8618a);
                ThreadContext.m4255a(context, m4253c);
                m8642h = C14287b.m8642h();
                if (invoke != m8642h) {
                    Result.C14124a c14124a = Result.Companion;
                    m8618a.resumeWith(Result.m60148constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            Result.C14124a c14124a2 = Result.Companion;
            m8618a.resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(th)));
        }
    }

    /* renamed from: b */
    public static final <R, T> void m224b(@NotNull InterfaceC15284p<? super R, ? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15284p, R r, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        Object m8642h;
        InterfaceC14268c m8618a = DebugProbes.m8618a(interfaceC14268c);
        try {
            CoroutineContext context = interfaceC14268c.getContext();
            Object m4253c = ThreadContext.m4253c(context, null);
            if (interfaceC15284p != null) {
                Object invoke = ((InterfaceC15284p) TypeIntrinsics.m8010q(interfaceC15284p, 2)).invoke(r, m8618a);
                ThreadContext.m4255a(context, m4253c);
                m8642h = C14287b.m8642h();
                if (invoke != m8642h) {
                    Result.C14124a c14124a = Result.Companion;
                    m8618a.resumeWith(Result.m60148constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            Result.C14124a c14124a2 = Result.Companion;
            m8618a.resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(th)));
        }
    }

    /* renamed from: c */
    public static final <T> void m223c(@NotNull InterfaceC15280l<? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15280l, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        Object m8642h;
        InterfaceC14268c m8618a = DebugProbes.m8618a(interfaceC14268c);
        try {
            if (interfaceC15280l != null) {
                Object invoke = ((InterfaceC15280l) TypeIntrinsics.m8010q(interfaceC15280l, 1)).invoke(m8618a);
                m8642h = C14287b.m8642h();
                if (invoke != m8642h) {
                    Result.C14124a c14124a = Result.Companion;
                    m8618a.resumeWith(Result.m60148constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            Result.C14124a c14124a2 = Result.Companion;
            m8618a.resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(th)));
        }
    }

    /* renamed from: d */
    public static final <R, T> void m222d(@NotNull InterfaceC15284p<? super R, ? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15284p, R r, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        Object m8642h;
        InterfaceC14268c m8618a = DebugProbes.m8618a(interfaceC14268c);
        try {
            if (interfaceC15284p != null) {
                Object invoke = ((InterfaceC15284p) TypeIntrinsics.m8010q(interfaceC15284p, 2)).invoke(r, m8618a);
                m8642h = C14287b.m8642h();
                if (invoke != m8642h) {
                    Result.C14124a c14124a = Result.Companion;
                    m8618a.resumeWith(Result.m60148constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            Result.C14124a c14124a2 = Result.Companion;
            m8618a.resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(th)));
        }
    }

    /* renamed from: e */
    private static final <T> void m221e(InterfaceC14268c<? super T> interfaceC14268c, InterfaceC15280l<? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15280l) {
        Object m8642h;
        InterfaceC14268c m8618a = DebugProbes.m8618a(interfaceC14268c);
        try {
            Object invoke = interfaceC15280l.invoke(m8618a);
            m8642h = C14287b.m8642h();
            if (invoke != m8642h) {
                Result.C14124a c14124a = Result.Companion;
                m8618a.resumeWith(Result.m60148constructorimpl(invoke));
            }
        } catch (Throwable th) {
            Result.C14124a c14124a2 = Result.Companion;
            m8618a.resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(th)));
        }
    }

    @Nullable
    /* renamed from: f */
    public static final <T, R> Object m220f(@NotNull Scopes<? super T> scopes, R r, @NotNull InterfaceC15284p<? super R, ? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15284p) {
        Object completionState;
        Object m8642h;
        Object m8642h2;
        Object m8642h3;
        scopes.m5759m1();
        try {
        } catch (Throwable th) {
            completionState = new CompletionState(th, false, 2, null);
        }
        if (interfaceC15284p != null) {
            completionState = ((InterfaceC15284p) TypeIntrinsics.m8010q(interfaceC15284p, 2)).invoke(r, scopes);
            m8642h = C14287b.m8642h();
            if (completionState == m8642h) {
                m8642h3 = C14287b.m8642h();
                return m8642h3;
            }
            Object m4069K0 = scopes.m4069K0(completionState);
            if (m4069K0 == C15134m2.f43181b) {
                m8642h2 = C14287b.m8642h();
                return m8642h2;
            } else if (!(m4069K0 instanceof CompletionState)) {
                return C15134m2.m3973o(m4069K0);
            } else {
                throw ((CompletionState) m4069K0).f42189a;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    @Nullable
    /* renamed from: g */
    public static final <T, R> Object m219g(@NotNull Scopes<? super T> scopes, R r, @NotNull InterfaceC15284p<? super R, ? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15284p) {
        Object completionState;
        Object m8642h;
        Object m8642h2;
        Object m8642h3;
        scopes.m5759m1();
        boolean z = false;
        try {
        } catch (Throwable th) {
            completionState = new CompletionState(th, false, 2, null);
        }
        if (interfaceC15284p != null) {
            completionState = ((InterfaceC15284p) TypeIntrinsics.m8010q(interfaceC15284p, 2)).invoke(r, scopes);
            m8642h = C14287b.m8642h();
            if (completionState == m8642h) {
                m8642h3 = C14287b.m8642h();
                return m8642h3;
            }
            Object m4069K0 = scopes.m4069K0(completionState);
            if (m4069K0 == C15134m2.f43181b) {
                m8642h2 = C14287b.m8642h();
                return m8642h2;
            } else if (m4069K0 instanceof CompletionState) {
                Throwable th2 = ((CompletionState) m4069K0).f42189a;
                if (((th2 instanceof TimeoutCancellationException) && ((TimeoutCancellationException) th2).coroutine == scopes) ? true : true) {
                    throw th2;
                }
                if (completionState instanceof CompletionState) {
                    throw ((CompletionState) completionState).f42189a;
                }
                return completionState;
            } else {
                return C15134m2.m3973o(m4069K0);
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    /* renamed from: h */
    private static final <T> Object m218h(Scopes<? super T> scopes, InterfaceC15280l<? super Throwable, Boolean> interfaceC15280l, InterfaceC15269a<? extends Object> interfaceC15269a) {
        Object completionState;
        Object m8642h;
        Object m8642h2;
        Object m8642h3;
        try {
            completionState = interfaceC15269a.invoke();
        } catch (Throwable th) {
            completionState = new CompletionState(th, false, 2, null);
        }
        m8642h = C14287b.m8642h();
        if (completionState == m8642h) {
            m8642h3 = C14287b.m8642h();
            return m8642h3;
        }
        Object m4069K0 = scopes.m4069K0(completionState);
        if (m4069K0 == C15134m2.f43181b) {
            m8642h2 = C14287b.m8642h();
            return m8642h2;
        } else if (m4069K0 instanceof CompletionState) {
            CompletionState completionState2 = (CompletionState) m4069K0;
            if (!interfaceC15280l.invoke(completionState2.f42189a).booleanValue()) {
                if (completionState instanceof CompletionState) {
                    throw ((CompletionState) completionState).f42189a;
                }
                return completionState;
            }
            throw completionState2.f42189a;
        } else {
            return C15134m2.m3973o(m4069K0);
        }
    }
}
