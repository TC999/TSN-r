package kotlin.coroutines.intrinsics;

import d2.l;
import d2.p;
import d2.q;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.coroutines.jvm.internal.e;
import kotlin.d0;
import kotlin.f1;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: IntrinsicsJvm.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001aC\u0010\u0005\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a\\\u0010\u000b\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\u0000*#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b\u00a2\u0006\u0002\b\t2\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u001ap\u0010\u0010\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\r\"\u0004\b\u0002\u0010\u0000*)\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000e\u00a2\u0006\u0002\b\t2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00020\u0002H\u0081\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001aF\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0002\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001a_\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0002\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\u0000*#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b\u00a2\u0006\u0002\b\t2\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a\u001e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007\u001aH\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u0002\"\u0004\b\u0000\u0010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u001c\b\u0004\u0010\u0018\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0083\b\u00a2\u0006\u0004\b\u0019\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"T", "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "", "completion", "e", "(Ld2/l;Lkotlin/coroutines/c;)Ljava/lang/Object;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "f", "(Ld2/p;Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "P", "Lkotlin/Function3;", "param", "g", "(Ld2/q;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/f1;", "b", "(Ld2/l;Lkotlin/coroutines/c;)Lkotlin/coroutines/c;", "c", "(Ld2/p;Ljava/lang/Object;Lkotlin/coroutines/c;)Lkotlin/coroutines/c;", "d", "block", "a", "(Lkotlin/coroutines/c;Ld2/l;)Lkotlin/coroutines/c;", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/coroutines/intrinsics/IntrinsicsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class IntrinsicsKt__IntrinsicsJvmKt {
    @SinceKotlin(version = "1.3")
    private static final <T> c<f1> a(final c<? super T> cVar, final l<? super c<? super T>, ? extends Object> lVar) {
        final f context = cVar.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            return new RestrictedContinuationImpl(cVar, lVar) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1
                final /* synthetic */ l<c<? super T>, Object> $block;
                final /* synthetic */ c<T> $completion;
                private int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(cVar);
                    this.$completion = cVar;
                    this.$block = lVar;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                protected Object invokeSuspend(@NotNull Object obj) {
                    int i4 = this.label;
                    if (i4 == 0) {
                        this.label = 1;
                        d0.n(obj);
                        return this.$block.invoke(this);
                    } else if (i4 == 1) {
                        this.label = 2;
                        d0.n(obj);
                        return obj;
                    } else {
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                }
            };
        }
        return new ContinuationImpl(cVar, context, lVar) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2
            final /* synthetic */ l<c<? super T>, Object> $block;
            final /* synthetic */ c<T> $completion;
            final /* synthetic */ f $context;
            private int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(cVar, context);
                this.$completion = cVar;
                this.$context = context;
                this.$block = lVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            protected Object invokeSuspend(@NotNull Object obj) {
                int i4 = this.label;
                if (i4 == 0) {
                    this.label = 1;
                    d0.n(obj);
                    return this.$block.invoke(this);
                } else if (i4 == 1) {
                    this.label = 2;
                    d0.n(obj);
                    return obj;
                } else {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
            }
        };
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static <T> c<f1> b(@NotNull final l<? super c<? super T>, ? extends Object> lVar, @NotNull c<? super T> completion) {
        f0.p(lVar, "<this>");
        f0.p(completion, "completion");
        final c<?> a4 = e.a(completion);
        if (lVar instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) lVar).create(a4);
        }
        final f context = a4.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            return new RestrictedContinuationImpl(lVar) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1
                final /* synthetic */ l $this_createCoroutineUnintercepted$inlined;
                private int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(c.this);
                    this.$this_createCoroutineUnintercepted$inlined = lVar;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                protected Object invokeSuspend(@NotNull Object obj) {
                    int i4 = this.label;
                    if (i4 == 0) {
                        this.label = 1;
                        d0.n(obj);
                        return ((l) t0.q(this.$this_createCoroutineUnintercepted$inlined, 1)).invoke(this);
                    } else if (i4 == 1) {
                        this.label = 2;
                        d0.n(obj);
                        return obj;
                    } else {
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                }
            };
        }
        return new ContinuationImpl(context, lVar) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2
            final /* synthetic */ f $context;
            final /* synthetic */ l $this_createCoroutineUnintercepted$inlined;
            private int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(c.this, context);
                this.$context = context;
                this.$this_createCoroutineUnintercepted$inlined = lVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            protected Object invokeSuspend(@NotNull Object obj) {
                int i4 = this.label;
                if (i4 == 0) {
                    this.label = 1;
                    d0.n(obj);
                    return ((l) t0.q(this.$this_createCoroutineUnintercepted$inlined, 1)).invoke(this);
                } else if (i4 == 1) {
                    this.label = 2;
                    d0.n(obj);
                    return obj;
                } else {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
            }
        };
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static <R, T> c<f1> c(@NotNull final p<? super R, ? super c<? super T>, ? extends Object> pVar, final R r3, @NotNull c<? super T> completion) {
        f0.p(pVar, "<this>");
        f0.p(completion, "completion");
        final c<?> a4 = e.a(completion);
        if (pVar instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) pVar).create(r3, a4);
        }
        final f context = a4.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            return new RestrictedContinuationImpl(pVar, r3) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3
                final /* synthetic */ Object $receiver$inlined;
                final /* synthetic */ p $this_createCoroutineUnintercepted$inlined;
                private int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(c.this);
                    this.$this_createCoroutineUnintercepted$inlined = pVar;
                    this.$receiver$inlined = r3;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                protected Object invokeSuspend(@NotNull Object obj) {
                    int i4 = this.label;
                    if (i4 == 0) {
                        this.label = 1;
                        d0.n(obj);
                        return ((p) t0.q(this.$this_createCoroutineUnintercepted$inlined, 2)).invoke(this.$receiver$inlined, this);
                    } else if (i4 == 1) {
                        this.label = 2;
                        d0.n(obj);
                        return obj;
                    } else {
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                }
            };
        }
        return new ContinuationImpl(context, pVar, r3) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4
            final /* synthetic */ f $context;
            final /* synthetic */ Object $receiver$inlined;
            final /* synthetic */ p $this_createCoroutineUnintercepted$inlined;
            private int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(c.this, context);
                this.$context = context;
                this.$this_createCoroutineUnintercepted$inlined = pVar;
                this.$receiver$inlined = r3;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            protected Object invokeSuspend(@NotNull Object obj) {
                int i4 = this.label;
                if (i4 == 0) {
                    this.label = 1;
                    d0.n(obj);
                    return ((p) t0.q(this.$this_createCoroutineUnintercepted$inlined, 2)).invoke(this.$receiver$inlined, this);
                } else if (i4 == 1) {
                    this.label = 2;
                    d0.n(obj);
                    return obj;
                } else {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @NotNull
    public static <T> c<T> d(@NotNull c<? super T> cVar) {
        f0.p(cVar, "<this>");
        ContinuationImpl continuationImpl = cVar instanceof ContinuationImpl ? (ContinuationImpl) cVar : null;
        return continuationImpl == null ? cVar : (c<T>) continuationImpl.intercepted();
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Object e(l<? super c<? super T>, ? extends Object> lVar, c<? super T> completion) {
        f0.p(lVar, "<this>");
        f0.p(completion, "completion");
        return ((l) t0.q(lVar, 1)).invoke(completion);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T> Object f(p<? super R, ? super c<? super T>, ? extends Object> pVar, R r3, c<? super T> completion) {
        f0.p(pVar, "<this>");
        f0.p(completion, "completion");
        return ((p) t0.q(pVar, 2)).invoke(r3, completion);
    }

    @InlineOnly
    private static final <R, P, T> Object g(q<? super R, ? super P, ? super c<? super T>, ? extends Object> qVar, R r3, P p3, c<? super T> completion) {
        f0.p(qVar, "<this>");
        f0.p(completion, "completion");
        return ((q) t0.q(qVar, 3)).invoke(r3, p3, completion);
    }
}
