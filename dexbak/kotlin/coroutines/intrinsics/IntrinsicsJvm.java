package kotlin.coroutines.intrinsics;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.open.SocialConstants;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;
import p617l1.InterfaceC15285q;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001aC\u0010\u0005\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\\\u0010\u000b\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\u0000*#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b¢\u0006\u0002\b\t2\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001ap\u0010\u0010\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\r\"\u0004\b\u0002\u0010\u0000*)\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000e¢\u0006\u0002\b\t2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00020\u0002H\u0081\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001aF\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0002\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a_\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0002\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\u0000*#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b¢\u0006\u0002\b\t2\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007\u001aH\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u0002\"\u0004\b\u0000\u0010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u001c\b\u0004\u0010\u0018\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0083\b¢\u0006\u0004\b\u0019\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "", "completion", "e", "(Ll1/l;Lkotlin/coroutines/c;)Ljava/lang/Object;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", SocialConstants.PARAM_RECEIVER, "f", "(Ll1/p;Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "P", "Lkotlin/Function3;", "param", "g", "(Ll1/q;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/f1;", "b", "(Ll1/l;Lkotlin/coroutines/c;)Lkotlin/coroutines/c;", "c", "(Ll1/p;Ljava/lang/Object;Lkotlin/coroutines/c;)Lkotlin/coroutines/c;", "d", "block", "a", "(Lkotlin/coroutines/c;Ll1/l;)Lkotlin/coroutines/c;", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/coroutines/intrinsics/IntrinsicsKt")
/* renamed from: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class IntrinsicsJvm {
    @SinceKotlin(version = "1.3")
    /* renamed from: a */
    private static final <T> InterfaceC14268c<Unit> m8653a(final InterfaceC14268c<? super T> interfaceC14268c, final InterfaceC15280l<? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15280l) {
        final CoroutineContext context = interfaceC14268c.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            return new RestrictedContinuationImpl(interfaceC14268c) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1
                private int label;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                protected Object invokeSuspend(@NotNull Object obj) {
                    int i = this.label;
                    if (i == 0) {
                        this.label = 1;
                        C14294d0.m8596n(obj);
                        return InterfaceC15280l.this.invoke(this);
                    } else if (i == 1) {
                        this.label = 2;
                        C14294d0.m8596n(obj);
                        return obj;
                    } else {
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                }
            };
        }
        return new ContinuationImpl(interfaceC14268c, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2
            private int label;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            protected Object invokeSuspend(@NotNull Object obj) {
                int i = this.label;
                if (i == 0) {
                    this.label = 1;
                    C14294d0.m8596n(obj);
                    return InterfaceC15280l.this.invoke(this);
                } else if (i == 1) {
                    this.label = 2;
                    C14294d0.m8596n(obj);
                    return obj;
                } else {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
            }
        };
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    /* renamed from: b */
    public static <T> InterfaceC14268c<Unit> m8652b(@NotNull final InterfaceC15280l<? super InterfaceC14268c<? super T>, ? extends Object> createCoroutineUnintercepted, @NotNull InterfaceC14268c<? super T> completion) {
        InterfaceC14268c<Unit> interfaceC14268c;
        C14342f0.m8184p(createCoroutineUnintercepted, "$this$createCoroutineUnintercepted");
        C14342f0.m8184p(completion, "completion");
        final InterfaceC14268c<?> m8618a = DebugProbes.m8618a(completion);
        if (createCoroutineUnintercepted instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) createCoroutineUnintercepted).create(m8618a);
        }
        final CoroutineContext context = m8618a.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            interfaceC14268c = new RestrictedContinuationImpl(m8618a) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1
                private int label;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                protected Object invokeSuspend(@NotNull Object obj) {
                    int i = this.label;
                    if (i != 0) {
                        if (i == 1) {
                            this.label = 2;
                            C14294d0.m8596n(obj);
                            return obj;
                        }
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                    this.label = 1;
                    C14294d0.m8596n(obj);
                    InterfaceC15280l interfaceC15280l = createCoroutineUnintercepted;
                    if (interfaceC15280l != null) {
                        return ((InterfaceC15280l) TypeIntrinsics.m8010q(interfaceC15280l, 1)).invoke(this);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                }
            };
        } else {
            interfaceC14268c = new ContinuationImpl(m8618a, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2
                private int label;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                protected Object invokeSuspend(@NotNull Object obj) {
                    int i = this.label;
                    if (i != 0) {
                        if (i == 1) {
                            this.label = 2;
                            C14294d0.m8596n(obj);
                            return obj;
                        }
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                    this.label = 1;
                    C14294d0.m8596n(obj);
                    InterfaceC15280l interfaceC15280l = createCoroutineUnintercepted;
                    if (interfaceC15280l != null) {
                        return ((InterfaceC15280l) TypeIntrinsics.m8010q(interfaceC15280l, 1)).invoke(this);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                }
            };
        }
        return interfaceC14268c;
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    /* renamed from: c */
    public static <R, T> InterfaceC14268c<Unit> m8651c(@NotNull final InterfaceC15284p<? super R, ? super InterfaceC14268c<? super T>, ? extends Object> createCoroutineUnintercepted, final R r, @NotNull InterfaceC14268c<? super T> completion) {
        InterfaceC14268c<Unit> interfaceC14268c;
        C14342f0.m8184p(createCoroutineUnintercepted, "$this$createCoroutineUnintercepted");
        C14342f0.m8184p(completion, "completion");
        final InterfaceC14268c<?> m8618a = DebugProbes.m8618a(completion);
        if (createCoroutineUnintercepted instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) createCoroutineUnintercepted).create(r, m8618a);
        }
        final CoroutineContext context = m8618a.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            interfaceC14268c = new RestrictedContinuationImpl(m8618a) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3
                private int label;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                protected Object invokeSuspend(@NotNull Object obj) {
                    int i = this.label;
                    if (i != 0) {
                        if (i == 1) {
                            this.label = 2;
                            C14294d0.m8596n(obj);
                            return obj;
                        }
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                    this.label = 1;
                    C14294d0.m8596n(obj);
                    InterfaceC15284p interfaceC15284p = createCoroutineUnintercepted;
                    if (interfaceC15284p != null) {
                        return ((InterfaceC15284p) TypeIntrinsics.m8010q(interfaceC15284p, 2)).invoke(r, this);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                }
            };
        } else {
            interfaceC14268c = new ContinuationImpl(m8618a, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4
                private int label;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                protected Object invokeSuspend(@NotNull Object obj) {
                    int i = this.label;
                    if (i != 0) {
                        if (i == 1) {
                            this.label = 2;
                            C14294d0.m8596n(obj);
                            return obj;
                        }
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                    this.label = 1;
                    C14294d0.m8596n(obj);
                    InterfaceC15284p interfaceC15284p = createCoroutineUnintercepted;
                    if (interfaceC15284p != null) {
                        return ((InterfaceC15284p) TypeIntrinsics.m8010q(interfaceC15284p, 2)).invoke(r, this);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                }
            };
        }
        return interfaceC14268c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @NotNull
    /* renamed from: d */
    public static <T> InterfaceC14268c<T> m8650d(@NotNull InterfaceC14268c<? super T> intercepted) {
        InterfaceC14268c<T> interfaceC14268c;
        C14342f0.m8184p(intercepted, "$this$intercepted");
        ContinuationImpl continuationImpl = !(intercepted instanceof ContinuationImpl) ? null : intercepted;
        return (continuationImpl == null || (interfaceC14268c = (InterfaceC14268c<T>) continuationImpl.intercepted()) == null) ? intercepted : interfaceC14268c;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: e */
    private static final <T> Object m8649e(InterfaceC15280l<? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15280l, InterfaceC14268c<? super T> interfaceC14268c) {
        if (interfaceC15280l != null) {
            return ((InterfaceC15280l) TypeIntrinsics.m8010q(interfaceC15280l, 1)).invoke(interfaceC14268c);
        }
        throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: f */
    private static final <R, T> Object m8648f(InterfaceC15284p<? super R, ? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15284p, R r, InterfaceC14268c<? super T> interfaceC14268c) {
        if (interfaceC15284p != null) {
            return ((InterfaceC15284p) TypeIntrinsics.m8010q(interfaceC15284p, 2)).invoke(r, interfaceC14268c);
        }
        throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    @InlineOnly
    /* renamed from: g */
    private static final <R, P, T> Object m8647g(InterfaceC15285q<? super R, ? super P, ? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15285q, R r, P p, InterfaceC14268c<? super T> interfaceC14268c) {
        if (interfaceC15285q != null) {
            return ((InterfaceC15285q) TypeIntrinsics.m8010q(interfaceC15285q, 3)).invoke(r, p, interfaceC14268c);
        }
        throw new NullPointerException("null cannot be cast to non-null type (R, P, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }
}
