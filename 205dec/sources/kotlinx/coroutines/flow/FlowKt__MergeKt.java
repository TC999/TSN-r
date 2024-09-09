package kotlinx.coroutines.flow;

import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.f1;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.flow.internal.ChannelFlowMerge;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Merge.kt */
@Metadata(bv = {}, d1 = {"\u0000R\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\u001ag\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u000227\u0010\t\u001a3\b\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\u001aq\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\b\u0002\u0010\r\u001a\u00020\f27\u0010\t\u001a3\b\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001a$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0002H\u0007\u001a$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0011H\u0007\u001a;\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u001e\u0010\u0014\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0013\"\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a.\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\fH\u0007\u001at\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022D\b\u0001\u0010\t\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0019\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0018\u00a2\u0006\u0002\b\u001bH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001d\u001aj\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u000229\b\u0005\u0010\t\u001a3\b\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u000b\u001ac\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u000223\b\u0001\u0010\t\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010\u000b\" \u0010%\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\n\u0010 \u0012\u0004\b#\u0010$\u001a\u0004\b!\u0010\"\"\u001a\u0010'\u001a\u00020&8\u0006X\u0087T\u00a2\u0006\f\n\u0004\b'\u0010(\u0012\u0004\b)\u0010$\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006*"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/h;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/c;", "", "transform", "a", "(Lkotlinx/coroutines/flow/h;Ld2/p;)Lkotlinx/coroutines/flow/h;", "", "concurrency", "c", "(Lkotlinx/coroutines/flow/h;ILd2/p;)Lkotlinx/coroutines/flow/h;", "e", "", "k", "", "flows", "l", "([Lkotlinx/coroutines/flow/h;)Lkotlinx/coroutines/flow/h;", "f", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/i;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "m", "(Lkotlinx/coroutines/flow/h;Ld2/q;)Lkotlinx/coroutines/flow/h;", "b", "j", "I", "h", "()I", "getDEFAULT_CONCURRENCY$annotations", "()V", "DEFAULT_CONCURRENCY", "", "DEFAULT_CONCURRENCY_PROPERTY_NAME", "Ljava/lang/String;", "getDEFAULT_CONCURRENCY_PROPERTY_NAME$annotations", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final /* synthetic */ class FlowKt__MergeKt {

    /* renamed from: a */
    private static final int f59769a = kotlinx.coroutines.internal.l0.b("kotlinx.coroutines.flow.defaultConcurrency", 16, 1, Integer.MAX_VALUE);

    /* compiled from: SafeCollector.common.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> implements h<T> {

        /* renamed from: a */
        final /* synthetic */ h f59794a;

        /* compiled from: Collect.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", "value", "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__MergeKt$$special$$inlined$collect$3"}, k = 1, mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$a$a */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class C1206a implements i<h<? extends T>> {

            /* renamed from: a */
            final /* synthetic */ i f59795a;

            public C1206a(i iVar) {
                this.f59795a = iVar;
            }

            @Override // kotlinx.coroutines.flow.i
            @Nullable
            public Object emit(Object obj, @NotNull kotlin.coroutines.c cVar) {
                Object h4;
                Object e4 = ((h) obj).e(this.f59795a, cVar);
                h4 = kotlin.coroutines.intrinsics.b.h();
                return e4 == h4 ? e4 : f1.f55527a;
            }
        }

        public a(h hVar) {
            this.f59794a = hVar;
        }

        @Override // kotlinx.coroutines.flow.h
        @Nullable
        public Object e(@NotNull i iVar, @NotNull kotlin.coroutines.c cVar) {
            Object h4;
            Object e4 = this.f59794a.e(new C1206a(iVar), cVar);
            h4 = kotlin.coroutines.intrinsics.b.h();
            return e4 == h4 ? e4 : f1.f55527a;
        }
    }

    /* compiled from: Merge.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u008a@\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/i;", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1", f = "Merge.kt", i = {0, 0, 1, 1}, l = {214, 214}, m = "invokeSuspend", n = {"$this$transformLatest", "it", "$this$transformLatest", "it"}, s = {"L$0", "L$1", "L$0", "L$1"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<R, T> extends SuspendLambda implements d2.q<i<? super R>, T, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a */
        private i f59796a;

        /* renamed from: b */
        private Object f59797b;

        /* renamed from: c */
        Object f59798c;

        /* renamed from: d */
        Object f59799d;

        /* renamed from: e */
        Object f59800e;

        /* renamed from: f */
        int f59801f;

        /* renamed from: g */
        final /* synthetic */ d2.p f59802g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(d2.p pVar, kotlin.coroutines.c cVar) {
            super(3, cVar);
            this.f59802g = pVar;
        }

        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull i<? super R> iVar, T t3, @NotNull kotlin.coroutines.c<? super f1> cVar) {
            b bVar = new b(this.f59802g, cVar);
            bVar.f59796a = iVar;
            bVar.f59797b = t3;
            return bVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d2.q
        public final Object invoke(Object obj, Object obj2, kotlin.coroutines.c<? super f1> cVar) {
            return ((b) create((i) obj, obj2, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            i iVar;
            i iVar2;
            Object obj2;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f59801f;
            if (i4 == 0) {
                kotlin.d0.n(obj);
                iVar = this.f59796a;
                Object obj3 = this.f59797b;
                d2.p pVar = this.f59802g;
                this.f59798c = iVar;
                this.f59799d = obj3;
                this.f59800e = iVar;
                this.f59801f = 1;
                Object invoke = pVar.invoke(obj3, this);
                if (invoke == h4) {
                    return h4;
                }
                iVar2 = iVar;
                obj2 = obj3;
                obj = invoke;
            } else if (i4 != 1) {
                if (i4 == 2) {
                    i iVar3 = (i) this.f59798c;
                    kotlin.d0.n(obj);
                    return f1.f55527a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                iVar = (i) this.f59800e;
                obj2 = this.f59799d;
                iVar2 = (i) this.f59798c;
                kotlin.d0.n(obj);
            }
            this.f59798c = iVar2;
            this.f59799d = obj2;
            this.f59801f = 2;
            if (iVar.emit(obj, this) == h4) {
                return h4;
            }
            return f1.f55527a;
        }
    }

    @FlowPreview
    @NotNull
    public static final <T, R> h<R> a(@NotNull final h<? extends T> hVar, @NotNull final d2.p<? super T, ? super kotlin.coroutines.c<? super h<? extends R>>, ? extends Object> pVar) {
        return k.K0(new h<h<? extends R>>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1

            /* JADX INFO: Add missing generic type declarations: [T] */
            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
            /* compiled from: Collect.kt */
            @Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", "value", "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 4, 0})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            public static final class AnonymousClass2<T> implements i<T> {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ i f59772a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ FlowKt__MergeKt$flatMapConcat$$inlined$map$1 f59773b;

                /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
                @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@\u00a8\u0006\u0006"}, d2 = {"T", "value", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "continuation", "", "kotlinx/coroutines/flow/FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2$1", "emit"}, k = 3, mv = {1, 4, 0})
                @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2", f = "Merge.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {134, 134}, m = "emit", n = {"this", "value", "continuation", "value", "continuation", "value", "$receiver", "this", "value", "continuation", "value", "continuation", "value", "$receiver"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: E:\TSN-r\205dec\7343912.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    Object L$7;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(kotlin.coroutines.c cVar) {
                        super(cVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i iVar, FlowKt__MergeKt$flatMapConcat$$inlined$map$1 flowKt__MergeKt$flatMapConcat$$inlined$map$1) {
                    this.f59772a = iVar;
                    this.f59773b = flowKt__MergeKt$flatMapConcat$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:16:0x0063  */
                /* JADX WARN: Removed duplicated region for block: B:22:0x00a4 A[RETURN] */
                @Override // kotlinx.coroutines.flow.i
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(java.lang.Object r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.c r12) {
                    /*
                        r10 = this;
                        boolean r0 = r12 instanceof kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r12
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1
                        r0.<init>(r12)
                    L18:
                        java.lang.Object r12 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L63
                        if (r2 == r4) goto L45
                        if (r2 != r3) goto L3d
                        java.lang.Object r11 = r0.L$6
                        kotlinx.coroutines.flow.i r11 = (kotlinx.coroutines.flow.i) r11
                        java.lang.Object r11 = r0.L$4
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1 r11 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.AnonymousClass2.AnonymousClass1) r11
                        java.lang.Object r11 = r0.L$2
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1 r11 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.AnonymousClass2.AnonymousClass1) r11
                        java.lang.Object r11 = r0.L$0
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2 r11 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.AnonymousClass2) r11
                        kotlin.d0.n(r12)
                        goto La5
                    L3d:
                        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                        java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                        r11.<init>(r12)
                        throw r11
                    L45:
                        java.lang.Object r11 = r0.L$7
                        kotlinx.coroutines.flow.i r11 = (kotlinx.coroutines.flow.i) r11
                        java.lang.Object r2 = r0.L$6
                        kotlinx.coroutines.flow.i r2 = (kotlinx.coroutines.flow.i) r2
                        java.lang.Object r4 = r0.L$5
                        java.lang.Object r5 = r0.L$4
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1 r5 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.AnonymousClass2.AnonymousClass1) r5
                        java.lang.Object r6 = r0.L$3
                        java.lang.Object r7 = r0.L$2
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1 r7 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.AnonymousClass2.AnonymousClass1) r7
                        java.lang.Object r8 = r0.L$1
                        java.lang.Object r9 = r0.L$0
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2 r9 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.AnonymousClass2) r9
                        kotlin.d0.n(r12)
                        goto L8e
                    L63:
                        kotlin.d0.n(r12)
                        kotlinx.coroutines.flow.i r12 = r10.f59772a
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1 r2 = r10.f59773b
                        d2.p r2 = r2
                        r0.L$0 = r10
                        r0.L$1 = r11
                        r0.L$2 = r0
                        r0.L$3 = r11
                        r0.L$4 = r0
                        r0.L$5 = r11
                        r0.L$6 = r12
                        r0.L$7 = r12
                        r0.label = r4
                        java.lang.Object r2 = r2.invoke(r11, r0)
                        if (r2 != r1) goto L85
                        return r1
                    L85:
                        r9 = r10
                        r4 = r11
                        r6 = r4
                        r8 = r6
                        r11 = r12
                        r5 = r0
                        r7 = r5
                        r12 = r2
                        r2 = r11
                    L8e:
                        r0.L$0 = r9
                        r0.L$1 = r8
                        r0.L$2 = r7
                        r0.L$3 = r6
                        r0.L$4 = r5
                        r0.L$5 = r4
                        r0.L$6 = r2
                        r0.label = r3
                        java.lang.Object r11 = r11.emit(r12, r0)
                        if (r11 != r1) goto La5
                        return r1
                    La5:
                        kotlin.f1 r11 = kotlin.f1.f55527a
                        return r11
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.h
            @Nullable
            public Object e(@NotNull i iVar, @NotNull kotlin.coroutines.c cVar) {
                Object h4;
                Object e4 = h.this.e(new AnonymousClass2(iVar, this), cVar);
                h4 = kotlin.coroutines.intrinsics.b.h();
                return e4 == h4 ? e4 : f1.f55527a;
            }
        });
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> h<R> b(@NotNull h<? extends T> hVar, @BuilderInference @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super h<? extends R>>, ? extends Object> pVar) {
        return k.m2(hVar, new FlowKt__MergeKt$flatMapLatest$1(pVar, null));
    }

    @FlowPreview
    @NotNull
    public static final <T, R> h<R> c(@NotNull final h<? extends T> hVar, int i4, @NotNull final d2.p<? super T, ? super kotlin.coroutines.c<? super h<? extends R>>, ? extends Object> pVar) {
        return k.L0(new h<h<? extends R>>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1

            /* JADX INFO: Add missing generic type declarations: [T] */
            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
            /* compiled from: Collect.kt */
            @Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", "value", "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2"}, k = 1, mv = {1, 4, 0})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            public static final class AnonymousClass2<T> implements i<T> {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ i f59776a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ FlowKt__MergeKt$flatMapMerge$$inlined$map$1 f59777b;

                /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
                @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@\u00a8\u0006\u0006"}, d2 = {"T", "value", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "continuation", "", "kotlinx/coroutines/flow/FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2$1", "emit"}, k = 3, mv = {1, 4, 0})
                @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2", f = "Merge.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {134, 134}, m = "emit", n = {"this", "value", "continuation", "value", "continuation", "value", "$receiver", "this", "value", "continuation", "value", "continuation", "value", "$receiver"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: E:\TSN-r\205dec\7343912.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    Object L$7;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(kotlin.coroutines.c cVar) {
                        super(cVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i iVar, FlowKt__MergeKt$flatMapMerge$$inlined$map$1 flowKt__MergeKt$flatMapMerge$$inlined$map$1) {
                    this.f59776a = iVar;
                    this.f59777b = flowKt__MergeKt$flatMapMerge$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:16:0x0063  */
                /* JADX WARN: Removed duplicated region for block: B:22:0x00a4 A[RETURN] */
                @Override // kotlinx.coroutines.flow.i
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(java.lang.Object r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.c r12) {
                    /*
                        r10 = this;
                        boolean r0 = r12 instanceof kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r12
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1
                        r0.<init>(r12)
                    L18:
                        java.lang.Object r12 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L63
                        if (r2 == r4) goto L45
                        if (r2 != r3) goto L3d
                        java.lang.Object r11 = r0.L$6
                        kotlinx.coroutines.flow.i r11 = (kotlinx.coroutines.flow.i) r11
                        java.lang.Object r11 = r0.L$4
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1 r11 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2.AnonymousClass1) r11
                        java.lang.Object r11 = r0.L$2
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1 r11 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2.AnonymousClass1) r11
                        java.lang.Object r11 = r0.L$0
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2 r11 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2) r11
                        kotlin.d0.n(r12)
                        goto La5
                    L3d:
                        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                        java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                        r11.<init>(r12)
                        throw r11
                    L45:
                        java.lang.Object r11 = r0.L$7
                        kotlinx.coroutines.flow.i r11 = (kotlinx.coroutines.flow.i) r11
                        java.lang.Object r2 = r0.L$6
                        kotlinx.coroutines.flow.i r2 = (kotlinx.coroutines.flow.i) r2
                        java.lang.Object r4 = r0.L$5
                        java.lang.Object r5 = r0.L$4
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1 r5 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2.AnonymousClass1) r5
                        java.lang.Object r6 = r0.L$3
                        java.lang.Object r7 = r0.L$2
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1 r7 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2.AnonymousClass1) r7
                        java.lang.Object r8 = r0.L$1
                        java.lang.Object r9 = r0.L$0
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2 r9 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2) r9
                        kotlin.d0.n(r12)
                        goto L8e
                    L63:
                        kotlin.d0.n(r12)
                        kotlinx.coroutines.flow.i r12 = r10.f59776a
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1 r2 = r10.f59777b
                        d2.p r2 = r2
                        r0.L$0 = r10
                        r0.L$1 = r11
                        r0.L$2 = r0
                        r0.L$3 = r11
                        r0.L$4 = r0
                        r0.L$5 = r11
                        r0.L$6 = r12
                        r0.L$7 = r12
                        r0.label = r4
                        java.lang.Object r2 = r2.invoke(r11, r0)
                        if (r2 != r1) goto L85
                        return r1
                    L85:
                        r9 = r10
                        r4 = r11
                        r6 = r4
                        r8 = r6
                        r11 = r12
                        r5 = r0
                        r7 = r5
                        r12 = r2
                        r2 = r11
                    L8e:
                        r0.L$0 = r9
                        r0.L$1 = r8
                        r0.L$2 = r7
                        r0.L$3 = r6
                        r0.L$4 = r5
                        r0.L$5 = r4
                        r0.L$6 = r2
                        r0.label = r3
                        java.lang.Object r11 = r11.emit(r12, r0)
                        if (r11 != r1) goto La5
                        return r1
                    La5:
                        kotlin.f1 r11 = kotlin.f1.f55527a
                        return r11
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.h
            @Nullable
            public Object e(@NotNull i iVar, @NotNull kotlin.coroutines.c cVar) {
                Object h4;
                Object e4 = h.this.e(new AnonymousClass2(iVar, this), cVar);
                h4 = kotlin.coroutines.intrinsics.b.h();
                return e4 == h4 ? e4 : f1.f55527a;
            }
        }, i4);
    }

    public static /* synthetic */ h d(h hVar, int i4, d2.p pVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = f59769a;
        }
        return k.H0(hVar, i4, pVar);
    }

    @FlowPreview
    @NotNull
    public static final <T> h<T> e(@NotNull h<? extends h<? extends T>> hVar) {
        return new a(hVar);
    }

    @FlowPreview
    @NotNull
    public static final <T> h<T> f(@NotNull h<? extends h<? extends T>> hVar, int i4) {
        if (i4 > 0) {
            return i4 == 1 ? k.K0(hVar) : new ChannelFlowMerge(hVar, i4, null, 0, null, 28, null);
        }
        throw new IllegalArgumentException(("Expected positive concurrency level, but had " + i4).toString());
    }

    public static /* synthetic */ h g(h hVar, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = f59769a;
        }
        return k.L0(hVar, i4);
    }

    public static final int h() {
        return f59769a;
    }

    @FlowPreview
    public static /* synthetic */ void i() {
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> h<R> j(@NotNull h<? extends T> hVar, @BuilderInference @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        return k.m2(hVar, new b(pVar, null));
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T> h<T> k(@NotNull Iterable<? extends h<? extends T>> iterable) {
        return new kotlinx.coroutines.flow.internal.i(iterable, null, 0, null, 14, null);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T> h<T> l(@NotNull h<? extends T>... hVarArr) {
        Iterable Y4;
        Y4 = kotlin.collections.p.Y4(hVarArr);
        return k.g1(Y4);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> h<R> m(@NotNull h<? extends T> hVar, @BuilderInference @NotNull d2.q<? super i<? super R>, ? super T, ? super kotlin.coroutines.c<? super f1>, ? extends Object> qVar) {
        return new ChannelFlowTransformLatest(qVar, hVar, null, 0, null, 28, null);
    }
}
