package kotlinx.coroutines.flow;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.f1;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.time.ExperimentalTime;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.flow.internal.ChildCancelledException;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Delay.kt */
@Metadata(bv = {}, d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a&\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a2\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0005H\u0007\u001a0\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001a<\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0005H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u001a9\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u000e\u0010\f\u001a&\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000f\u001a\u00020\u0002H\u0007\u001a$\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0002H\u0000\u001a0\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0017\u001a\u00020\u0007H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"T", "Lkotlinx/coroutines/flow/h;", "", "timeoutMillis", "a", "Lkotlin/Function1;", "b", "Lkotlin/time/d;", "timeout", "c", "(Lkotlinx/coroutines/flow/h;D)Lkotlinx/coroutines/flow/h;", "d", "(Lkotlinx/coroutines/flow/h;Ld2/l;)Lkotlinx/coroutines/flow/h;", "timeoutMillisSelector", "e", "periodMillis", "h", "Lkotlinx/coroutines/q0;", "delayMillis", "initialDelayMillis", "Lkotlinx/coroutines/channels/d0;", "Lkotlin/f1;", "f", "period", "i", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final /* synthetic */ class o {

    /* compiled from: Delay.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "it", "", "a", "(Ljava/lang/Object;)J"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends Lambda implements d2.l<T, Long> {

        /* renamed from: a */
        final /* synthetic */ long f60215a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j4) {
            super(1);
            this.f60215a = j4;
        }

        public final long a(T t3) {
            return this.f60215a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d2.l
        public /* bridge */ /* synthetic */ Long invoke(Object obj) {
            return Long.valueOf(a(obj));
        }
    }

    /* compiled from: Delay.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "emittedItem", "", "a", "(Ljava/lang/Object;)J"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T> extends Lambda implements d2.l<T, Long> {

        /* renamed from: a */
        final /* synthetic */ d2.l f60216a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(d2.l lVar) {
            super(1);
            this.f60216a = lVar;
        }

        public final long a(T t3) {
            return a1.e(((kotlin.time.d) this.f60216a.invoke(t3)).unbox-impl());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d2.l
        public /* bridge */ /* synthetic */ Long invoke(Object obj) {
            return Long.valueOf(a(obj));
        }
    }

    /* compiled from: Delay.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u008a@\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Lkotlinx/coroutines/q0;", "Lkotlinx/coroutines/flow/i;", "downstream", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_ENABLE_CERT_VERIFY, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP}, m = "invokeSuspend", n = {"$this$scopedFlow", "downstream", "values", "lastValue", "timeoutMillis", "$this$scopedFlow", "downstream", "values", "lastValue", "timeoutMillis"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c<T> extends SuspendLambda implements d2.q<q0, i<? super T>, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a */
        private q0 f60217a;

        /* renamed from: b */
        private i f60218b;

        /* renamed from: c */
        Object f60219c;

        /* renamed from: d */
        Object f60220d;

        /* renamed from: e */
        Object f60221e;

        /* renamed from: f */
        Object f60222f;

        /* renamed from: g */
        Object f60223g;

        /* renamed from: h */
        Object f60224h;

        /* renamed from: i */
        int f60225i;

        /* renamed from: j */
        final /* synthetic */ h f60226j;

        /* renamed from: k */
        final /* synthetic */ d2.l f60227k;

        /* compiled from: Delay.kt */
        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"T", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class a extends SuspendLambda implements d2.l<kotlin.coroutines.c<? super f1>, Object> {

            /* renamed from: a */
            int f60228a;

            /* renamed from: b */
            final /* synthetic */ Ref.ObjectRef f60229b;

            /* renamed from: c */
            final /* synthetic */ Ref.LongRef f60230c;

            /* renamed from: d */
            final /* synthetic */ i f60231d;

            /* renamed from: e */
            final /* synthetic */ Ref.ObjectRef f60232e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(kotlin.coroutines.c cVar, Ref.ObjectRef objectRef, Ref.LongRef longRef, i iVar, Ref.ObjectRef objectRef2) {
                super(1, cVar);
                this.f60229b = objectRef;
                this.f60230c = longRef;
                this.f60231d = iVar;
                this.f60232e = objectRef2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
                return new a(cVar, this.f60229b, this.f60230c, this.f60231d, this.f60232e);
            }

            @Override // d2.l
            public final Object invoke(kotlin.coroutines.c<? super f1> cVar) {
                return ((a) create(cVar)).invokeSuspend(f1.f55527a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object h4;
                h4 = kotlin.coroutines.intrinsics.b.h();
                int i4 = this.f60228a;
                if (i4 == 0) {
                    kotlin.d0.n(obj);
                    i iVar = this.f60231d;
                    kotlinx.coroutines.internal.j0 j0Var = kotlinx.coroutines.flow.internal.r.f60167a;
                    T t3 = this.f60229b.element;
                    if (t3 == j0Var) {
                        t3 = null;
                    }
                    this.f60228a = 1;
                    if (iVar.emit(t3, this) == h4) {
                        return h4;
                    }
                } else if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    kotlin.d0.n(obj);
                }
                this.f60229b.element = null;
                return f1.f55527a;
            }
        }

        /* compiled from: Delay.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"T", "", "value", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$2", "<anonymous>"}, k = 3, mv = {1, 4, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends SuspendLambda implements d2.p<Object, kotlin.coroutines.c<? super f1>, Object> {

            /* renamed from: a */
            private Object f60233a;

            /* renamed from: b */
            Object f60234b;

            /* renamed from: c */
            int f60235c;

            /* renamed from: d */
            final /* synthetic */ Ref.ObjectRef f60236d;

            /* renamed from: e */
            final /* synthetic */ Ref.LongRef f60237e;

            /* renamed from: f */
            final /* synthetic */ i f60238f;

            /* renamed from: g */
            final /* synthetic */ Ref.ObjectRef f60239g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(kotlin.coroutines.c cVar, Ref.ObjectRef objectRef, Ref.LongRef longRef, i iVar, Ref.ObjectRef objectRef2) {
                super(2, cVar);
                this.f60236d = objectRef;
                this.f60237e = longRef;
                this.f60238f = iVar;
                this.f60239g = objectRef2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
                b bVar = new b(cVar, this.f60236d, this.f60237e, this.f60238f, this.f60239g);
                bVar.f60233a = obj;
                return bVar;
            }

            @Override // d2.p
            public final Object invoke(Object obj, kotlin.coroutines.c<? super f1> cVar) {
                return ((b) create(obj, cVar)).invokeSuspend(f1.f55527a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object h4;
                h4 = kotlin.coroutines.intrinsics.b.h();
                int i4 = this.f60235c;
                if (i4 == 0) {
                    kotlin.d0.n(obj);
                    T t3 = (T) this.f60233a;
                    if (t3 == null) {
                        T t4 = this.f60236d.element;
                        if (t4 != null) {
                            i iVar = this.f60238f;
                            if (t4 == kotlinx.coroutines.flow.internal.r.f60167a) {
                                t4 = null;
                            }
                            this.f60234b = t3;
                            this.f60235c = 1;
                            if (iVar.emit(t4, this) == h4) {
                                return h4;
                            }
                        }
                    } else {
                        this.f60236d.element = t3;
                        return f1.f55527a;
                    }
                } else if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    kotlin.d0.n(obj);
                }
                this.f60236d.element = (T) kotlinx.coroutines.flow.internal.r.f60169c;
                return f1.f55527a;
            }
        }

        /* compiled from: Delay.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "Lkotlinx/coroutines/channels/b0;", "", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1", f = "Delay.kt", i = {0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CHLO_COUNT}, m = "invokeSuspend", n = {"$this$produce", "$this$collect$iv"}, s = {"L$0", "L$1"})
        /* renamed from: kotlinx.coroutines.flow.o$c$c */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class C1217c extends SuspendLambda implements d2.p<kotlinx.coroutines.channels.b0<? super Object>, kotlin.coroutines.c<? super f1>, Object> {

            /* renamed from: a */
            private kotlinx.coroutines.channels.b0 f60240a;

            /* renamed from: b */
            Object f60241b;

            /* renamed from: c */
            Object f60242c;

            /* renamed from: d */
            int f60243d;

            /* compiled from: Collect.kt */
            @Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", "value", "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
            /* renamed from: kotlinx.coroutines.flow.o$c$c$a */
            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            public static final class a implements i<T> {

                /* renamed from: a */
                final /* synthetic */ kotlinx.coroutines.channels.b0 f60245a;

                public a(kotlinx.coroutines.channels.b0 b0Var) {
                    this.f60245a = b0Var;
                }

                @Override // kotlinx.coroutines.flow.i
                @Nullable
                public Object emit(Object obj, @NotNull kotlin.coroutines.c cVar) {
                    Object h4;
                    kotlinx.coroutines.channels.b0 b0Var = this.f60245a;
                    if (obj == null) {
                        obj = kotlinx.coroutines.flow.internal.r.f60167a;
                    }
                    Object O = b0Var.O(obj, cVar);
                    h4 = kotlin.coroutines.intrinsics.b.h();
                    return O == h4 ? O : f1.f55527a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1217c(kotlin.coroutines.c cVar) {
                super(2, cVar);
                c.this = r1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
                C1217c c1217c = new C1217c(cVar);
                c1217c.f60240a = (kotlinx.coroutines.channels.b0) obj;
                return c1217c;
            }

            @Override // d2.p
            public final Object invoke(kotlinx.coroutines.channels.b0<? super Object> b0Var, kotlin.coroutines.c<? super f1> cVar) {
                return ((C1217c) create(b0Var, cVar)).invokeSuspend(f1.f55527a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object h4;
                h4 = kotlin.coroutines.intrinsics.b.h();
                int i4 = this.f60243d;
                if (i4 == 0) {
                    kotlin.d0.n(obj);
                    kotlinx.coroutines.channels.b0 b0Var = this.f60240a;
                    h hVar = c.this.f60226j;
                    a aVar = new a(b0Var);
                    this.f60241b = b0Var;
                    this.f60242c = hVar;
                    this.f60243d = 1;
                    if (hVar.e(aVar, this) == h4) {
                        return h4;
                    }
                } else if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    h hVar2 = (h) this.f60242c;
                    kotlinx.coroutines.channels.b0 b0Var2 = (kotlinx.coroutines.channels.b0) this.f60241b;
                    kotlin.d0.n(obj);
                }
                return f1.f55527a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(h hVar, d2.l lVar, kotlin.coroutines.c cVar) {
            super(3, cVar);
            this.f60226j = hVar;
            this.f60227k = lVar;
        }

        @NotNull
        public final kotlin.coroutines.c<f1> e(@NotNull q0 q0Var, @NotNull i<? super T> iVar, @NotNull kotlin.coroutines.c<? super f1> cVar) {
            c cVar2 = new c(this.f60226j, this.f60227k, cVar);
            cVar2.f60217a = q0Var;
            cVar2.f60218b = iVar;
            return cVar2;
        }

        @Override // d2.q
        public final Object invoke(q0 q0Var, Object obj, kotlin.coroutines.c<? super f1> cVar) {
            return ((c) e(q0Var, (i) obj, cVar)).invokeSuspend(f1.f55527a);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(14:9|(5:11|(1:13)|14|(1:16)(1:30)|(2:28|29)(2:18|(5:20|(1:22)|23|(1:25)|27)))|31|32|33|34|(8:53|54|55|56|57|58|59|60)(1:36)|37|38|39|40|41|(1:43)|(1:45)(4:46|6|7|(2:70|71)(0))) */
        /* JADX WARN: Can't wrap try/catch for region: R(8:(1:53)|54|55|56|57|58|59|60) */
        /* JADX WARN: Can't wrap try/catch for region: R(8:53|54|55|56|57|58|59|60) */
        /* JADX WARN: Code restructure failed: missing block: B:121:0x0116, code lost:
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:122:0x0117, code lost:
            r5 = r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:130:0x013a, code lost:
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:132:0x013c, code lost:
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:133:0x013d, code lost:
            r5 = r11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:134:0x013f, code lost:
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:135:0x0140, code lost:
            r5 = r10;
            r18 = r11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:136:0x0143, code lost:
            r5.p0(r0);
         */
        /* JADX WARN: Removed duplicated region for block: B:125:0x011f  */
        /* JADX WARN: Removed duplicated region for block: B:139:0x0150  */
        /* JADX WARN: Removed duplicated region for block: B:141:0x0155 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:142:0x0156  */
        /* JADX WARN: Removed duplicated region for block: B:144:0x0162  */
        /* JADX WARN: Removed duplicated region for block: B:150:0x00fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:91:0x0086  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:142:0x0156 -> B:143:0x015d). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r21) {
            /*
                Method dump skipped, instructions count: 357
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.o.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: Delay.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/channels/b0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$3", f = "Delay.kt", i = {0, 1, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_TCP_FAST_OPEN, MediaPlayer.MEDIA_PLAYER_OPTION_TFO_FALL_BACK_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_RENDER_TIME}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d extends SuspendLambda implements d2.p<kotlinx.coroutines.channels.b0<? super f1>, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a */
        private kotlinx.coroutines.channels.b0 f60246a;

        /* renamed from: b */
        Object f60247b;

        /* renamed from: c */
        int f60248c;

        /* renamed from: d */
        final /* synthetic */ long f60249d;

        /* renamed from: e */
        final /* synthetic */ long f60250e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(long j4, long j5, kotlin.coroutines.c cVar) {
            super(2, cVar);
            this.f60249d = j4;
            this.f60250e = j5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            d dVar = new d(this.f60249d, this.f60250e, cVar);
            dVar.f60246a = (kotlinx.coroutines.channels.b0) obj;
            return dVar;
        }

        @Override // d2.p
        public final Object invoke(kotlinx.coroutines.channels.b0<? super f1> b0Var, kotlin.coroutines.c<? super f1> cVar) {
            return ((d) create(b0Var, cVar)).invokeSuspend(f1.f55527a);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:38:0x004d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x005a A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0058 -> B:36:0x003d). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.h()
                int r1 = r7.f60248c
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2a
                if (r1 == r4) goto L11
                if (r1 == r3) goto L21
                if (r1 != r2) goto L19
            L11:
                java.lang.Object r1 = r7.f60247b
                kotlinx.coroutines.channels.b0 r1 = (kotlinx.coroutines.channels.b0) r1
                kotlin.d0.n(r8)
                goto L3c
            L19:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L21:
                java.lang.Object r1 = r7.f60247b
                kotlinx.coroutines.channels.b0 r1 = (kotlinx.coroutines.channels.b0) r1
                kotlin.d0.n(r8)
                r8 = r7
                goto L4e
            L2a:
                kotlin.d0.n(r8)
                kotlinx.coroutines.channels.b0 r1 = r7.f60246a
                long r5 = r7.f60249d
                r7.f60247b = r1
                r7.f60248c = r4
                java.lang.Object r8 = kotlinx.coroutines.a1.b(r5, r7)
                if (r8 != r0) goto L3c
                return r0
            L3c:
                r8 = r7
            L3d:
                kotlinx.coroutines.channels.h0 r4 = r1.getChannel()
                kotlin.f1 r5 = kotlin.f1.f55527a
                r8.f60247b = r1
                r8.f60248c = r3
                java.lang.Object r4 = r4.O(r5, r8)
                if (r4 != r0) goto L4e
                return r0
            L4e:
                long r4 = r8.f60250e
                r8.f60247b = r1
                r8.f60248c = r2
                java.lang.Object r4 = kotlinx.coroutines.a1.b(r4, r8)
                if (r4 != r0) goto L3d
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.o.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: Delay.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u008a@\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Lkotlinx/coroutines/q0;", "Lkotlinx/coroutines/flow/i;", "downstream", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", f = "Delay.kt", i = {0, 0, 0, 0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT}, m = "invokeSuspend", n = {"$this$scopedFlow", "downstream", "values", "lastValue", "ticker"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class e<T> extends SuspendLambda implements d2.q<q0, i<? super T>, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a */
        private q0 f60251a;

        /* renamed from: b */
        private i f60252b;

        /* renamed from: c */
        Object f60253c;

        /* renamed from: d */
        Object f60254d;

        /* renamed from: e */
        Object f60255e;

        /* renamed from: f */
        Object f60256f;

        /* renamed from: g */
        Object f60257g;

        /* renamed from: h */
        Object f60258h;

        /* renamed from: i */
        int f60259i;

        /* renamed from: j */
        final /* synthetic */ h f60260j;

        /* renamed from: k */
        final /* synthetic */ long f60261k;

        /* compiled from: Delay.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"T", "", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class a extends SuspendLambda implements d2.p<Object, kotlin.coroutines.c<? super f1>, Object> {

            /* renamed from: a */
            private Object f60262a;

            /* renamed from: b */
            int f60263b;

            /* renamed from: c */
            final /* synthetic */ Ref.ObjectRef f60264c;

            /* renamed from: d */
            final /* synthetic */ kotlinx.coroutines.channels.d0 f60265d;

            /* renamed from: e */
            final /* synthetic */ Ref.ObjectRef f60266e;

            /* renamed from: f */
            final /* synthetic */ i f60267f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(kotlin.coroutines.c cVar, Ref.ObjectRef objectRef, kotlinx.coroutines.channels.d0 d0Var, Ref.ObjectRef objectRef2, i iVar) {
                super(2, cVar);
                this.f60264c = objectRef;
                this.f60265d = d0Var;
                this.f60266e = objectRef2;
                this.f60267f = iVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
                a aVar = new a(cVar, this.f60264c, this.f60265d, this.f60266e, this.f60267f);
                aVar.f60262a = obj;
                return aVar;
            }

            @Override // d2.p
            public final Object invoke(Object obj, kotlin.coroutines.c<? super f1> cVar) {
                return ((a) create(obj, cVar)).invokeSuspend(f1.f55527a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.b.h();
                if (this.f60263b == 0) {
                    kotlin.d0.n(obj);
                    T t3 = (T) this.f60262a;
                    if (t3 == null) {
                        this.f60265d.b(new ChildCancelledException());
                        this.f60266e.element = (T) kotlinx.coroutines.flow.internal.r.f60169c;
                    } else {
                        this.f60266e.element = t3;
                    }
                    return f1.f55527a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* compiled from: Delay.kt */
        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0006\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"T", "Lkotlin/f1;", "it", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$2", "<anonymous>"}, k = 3, mv = {1, 4, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends SuspendLambda implements d2.p<f1, kotlin.coroutines.c<? super f1>, Object> {

            /* renamed from: a */
            private f1 f60268a;

            /* renamed from: b */
            Object f60269b;

            /* renamed from: c */
            Object f60270c;

            /* renamed from: d */
            int f60271d;

            /* renamed from: e */
            final /* synthetic */ Ref.ObjectRef f60272e;

            /* renamed from: f */
            final /* synthetic */ kotlinx.coroutines.channels.d0 f60273f;

            /* renamed from: g */
            final /* synthetic */ Ref.ObjectRef f60274g;

            /* renamed from: h */
            final /* synthetic */ i f60275h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(kotlin.coroutines.c cVar, Ref.ObjectRef objectRef, kotlinx.coroutines.channels.d0 d0Var, Ref.ObjectRef objectRef2, i iVar) {
                super(2, cVar);
                this.f60272e = objectRef;
                this.f60273f = d0Var;
                this.f60274g = objectRef2;
                this.f60275h = iVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
                b bVar = new b(cVar, this.f60272e, this.f60273f, this.f60274g, this.f60275h);
                bVar.f60268a = (f1) obj;
                return bVar;
            }

            @Override // d2.p
            public final Object invoke(f1 f1Var, kotlin.coroutines.c<? super f1> cVar) {
                return ((b) create(f1Var, cVar)).invokeSuspend(f1.f55527a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object h4;
                h4 = kotlin.coroutines.intrinsics.b.h();
                int i4 = this.f60271d;
                if (i4 == 0) {
                    kotlin.d0.n(obj);
                    f1 f1Var = this.f60268a;
                    Ref.ObjectRef objectRef = this.f60274g;
                    T t3 = objectRef.element;
                    if (t3 != null) {
                        objectRef.element = null;
                        i iVar = this.f60275h;
                        T t4 = t3 != kotlinx.coroutines.flow.internal.r.f60167a ? t3 : null;
                        this.f60269b = f1Var;
                        this.f60270c = t3;
                        this.f60271d = 1;
                        if (iVar.emit(t4, this) == h4) {
                            return h4;
                        }
                    } else {
                        return f1.f55527a;
                    }
                } else if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    f1 f1Var2 = (f1) this.f60269b;
                    kotlin.d0.n(obj);
                }
                return f1.f55527a;
            }
        }

        /* compiled from: Delay.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "Lkotlinx/coroutines/channels/b0;", "", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1", f = "Delay.kt", i = {0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CHLO_COUNT}, m = "invokeSuspend", n = {"$this$produce", "$this$collect$iv"}, s = {"L$0", "L$1"})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class c extends SuspendLambda implements d2.p<kotlinx.coroutines.channels.b0<? super Object>, kotlin.coroutines.c<? super f1>, Object> {

            /* renamed from: a */
            private kotlinx.coroutines.channels.b0 f60276a;

            /* renamed from: b */
            Object f60277b;

            /* renamed from: c */
            Object f60278c;

            /* renamed from: d */
            int f60279d;

            /* compiled from: Collect.kt */
            @Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", "value", "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            public static final class a implements i<T> {

                /* renamed from: a */
                final /* synthetic */ kotlinx.coroutines.channels.b0 f60281a;

                public a(kotlinx.coroutines.channels.b0 b0Var) {
                    this.f60281a = b0Var;
                }

                @Override // kotlinx.coroutines.flow.i
                @Nullable
                public Object emit(Object obj, @NotNull kotlin.coroutines.c cVar) {
                    Object h4;
                    kotlinx.coroutines.channels.b0 b0Var = this.f60281a;
                    if (obj == null) {
                        obj = kotlinx.coroutines.flow.internal.r.f60167a;
                    }
                    Object O = b0Var.O(obj, cVar);
                    h4 = kotlin.coroutines.intrinsics.b.h();
                    return O == h4 ? O : f1.f55527a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(kotlin.coroutines.c cVar) {
                super(2, cVar);
                e.this = r1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
                c cVar2 = new c(cVar);
                cVar2.f60276a = (kotlinx.coroutines.channels.b0) obj;
                return cVar2;
            }

            @Override // d2.p
            public final Object invoke(kotlinx.coroutines.channels.b0<? super Object> b0Var, kotlin.coroutines.c<? super f1> cVar) {
                return ((c) create(b0Var, cVar)).invokeSuspend(f1.f55527a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object h4;
                h4 = kotlin.coroutines.intrinsics.b.h();
                int i4 = this.f60279d;
                if (i4 == 0) {
                    kotlin.d0.n(obj);
                    kotlinx.coroutines.channels.b0 b0Var = this.f60276a;
                    h hVar = e.this.f60260j;
                    a aVar = new a(b0Var);
                    this.f60277b = b0Var;
                    this.f60278c = hVar;
                    this.f60279d = 1;
                    if (hVar.e(aVar, this) == h4) {
                        return h4;
                    }
                } else if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    h hVar2 = (h) this.f60278c;
                    kotlinx.coroutines.channels.b0 b0Var2 = (kotlinx.coroutines.channels.b0) this.f60277b;
                    kotlin.d0.n(obj);
                }
                return f1.f55527a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(h hVar, long j4, kotlin.coroutines.c cVar) {
            super(3, cVar);
            this.f60260j = hVar;
            this.f60261k = j4;
        }

        @NotNull
        public final kotlin.coroutines.c<f1> e(@NotNull q0 q0Var, @NotNull i<? super T> iVar, @NotNull kotlin.coroutines.c<? super f1> cVar) {
            e eVar = new e(this.f60260j, this.f60261k, cVar);
            eVar.f60251a = q0Var;
            eVar.f60252b = iVar;
            return eVar;
        }

        @Override // d2.q
        public final Object invoke(q0 q0Var, Object obj, kotlin.coroutines.c<? super f1> cVar) {
            return ((e) e(q0Var, (i) obj, cVar)).invokeSuspend(f1.f55527a);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(12:8|(1:9)|10|11|12|13|14|(1:16)|(1:18)|5|6|(2:26|27)(0)) */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00af, code lost:
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00b3, code lost:
            r1.p0(r0);
         */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0071  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x00c0  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00c5 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x00ca  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x00c3 -> B:59:0x00c6). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r17) {
            /*
                Method dump skipped, instructions count: 205
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.o.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @FlowPreview
    @NotNull
    public static final <T> h<T> a(@NotNull h<? extends T> hVar, long j4) {
        if (j4 >= 0) {
            return j4 == 0 ? hVar : e(hVar, new a(j4));
        }
        throw new IllegalArgumentException("Debounce timeout should not be negative".toString());
    }

    @FlowPreview
    @OverloadResolutionByLambdaReturnType
    @NotNull
    public static final <T> h<T> b(@NotNull h<? extends T> hVar, @NotNull d2.l<? super T, Long> lVar) {
        return e(hVar, lVar);
    }

    @FlowPreview
    @ExperimentalTime
    @NotNull
    public static final <T> h<T> c(@NotNull h<? extends T> hVar, double d4) {
        return k.f0(hVar, a1.e(d4));
    }

    @FlowPreview
    @JvmName(name = "debounceDuration")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    @ExperimentalTime
    public static final <T> h<T> d(@NotNull h<? extends T> hVar, @NotNull d2.l<? super T, kotlin.time.d> lVar) {
        return e(hVar, new b(lVar));
    }

    private static final <T> h<T> e(h<? extends T> hVar, d2.l<? super T, Long> lVar) {
        return kotlinx.coroutines.flow.internal.l.d(new c(hVar, lVar, null));
    }

    @NotNull
    public static final kotlinx.coroutines.channels.d0<f1> f(@NotNull q0 q0Var, long j4, long j5) {
        if (!(j4 >= 0)) {
            throw new IllegalArgumentException(("Expected non-negative delay, but has " + j4 + " ms").toString());
        }
        if (j5 >= 0) {
            return kotlinx.coroutines.channels.z.f(q0Var, null, 0, new d(j5, j4, null), 1, null);
        }
        throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j5 + " ms").toString());
    }

    public static /* synthetic */ kotlinx.coroutines.channels.d0 g(q0 q0Var, long j4, long j5, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            j5 = j4;
        }
        return k.C0(q0Var, j4, j5);
    }

    @FlowPreview
    @NotNull
    public static final <T> h<T> h(@NotNull h<? extends T> hVar, long j4) {
        if (j4 > 0) {
            return kotlinx.coroutines.flow.internal.l.d(new e(hVar, j4, null));
        }
        throw new IllegalArgumentException("Sample period should be positive".toString());
    }

    @FlowPreview
    @ExperimentalTime
    @NotNull
    public static final <T> h<T> i(@NotNull h<? extends T> hVar, double d4) {
        return k.L1(hVar, a1.e(d4));
    }
}
