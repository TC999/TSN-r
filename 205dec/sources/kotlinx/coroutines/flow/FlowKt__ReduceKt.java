package kotlinx.coroutines.flow;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.f1;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Reduce.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u001au\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0001*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00022F\u0010\n\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u001a{\u0010\u0010\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u000e\u001a\u00028\u00012H\b\u0004\u0010\n\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0003H\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a#\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a%\u0010\u0014\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0013\u001a#\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0013\u001aG\u0010\u0019\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\"\u0010\u0018\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0016H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001a\u001a%\u0010\u001b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u0013\u001aI\u0010\u001c\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\"\u0010\u0018\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0016H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"S", "T", "Lkotlinx/coroutines/flow/h;", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "accumulator", "value", "Lkotlin/coroutines/c;", "", "operation", "g", "(Lkotlinx/coroutines/flow/h;Ld2/q;Lkotlin/coroutines/c;)Ljava/lang/Object;", "R", "initial", "acc", "e", "(Lkotlinx/coroutines/flow/h;Ljava/lang/Object;Ld2/q;Lkotlin/coroutines/c;)Ljava/lang/Object;", "h", "(Lkotlinx/coroutines/flow/h;Lkotlin/coroutines/c;)Ljava/lang/Object;", "i", "b", "Lkotlin/Function2;", "", "predicate", "a", "(Lkotlinx/coroutines/flow/h;Ld2/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "d", "c", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final /* synthetic */ class FlowKt__ReduceKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Limit.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/i;", "value", "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> implements kotlinx.coroutines.flow.i<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f59827a;

        public a(Ref.ObjectRef objectRef) {
            this.f59827a = objectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.i
        @Nullable
        public Object emit(Object obj, @NotNull kotlin.coroutines.c cVar) {
            this.f59827a.element = obj;
            if (kotlin.coroutines.jvm.internal.a.a(false).booleanValue()) {
                return f1.f55527a;
            }
            throw new AbortFlowException(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Reduce.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0005\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@"}, d2 = {"T", "Lkotlinx/coroutines/flow/h;", "Lkotlin/coroutines/c;", "continuation", "", "first"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0, 0, 0}, l = {182}, m = "first", n = {"$this$first", "result", "$this$collectWhile$iv", "collector$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f59828a;

        /* renamed from: b  reason: collision with root package name */
        int f59829b;

        /* renamed from: c  reason: collision with root package name */
        Object f59830c;

        /* renamed from: d  reason: collision with root package name */
        Object f59831d;

        /* renamed from: e  reason: collision with root package name */
        Object f59832e;

        /* renamed from: f  reason: collision with root package name */
        Object f59833f;

        b(kotlin.coroutines.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f59828a = obj;
            this.f59829b |= Integer.MIN_VALUE;
            return kotlinx.coroutines.flow.k.z0(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Reduce.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086@"}, d2 = {"T", "Lkotlinx/coroutines/flow/h;", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "", "predicate", "continuation", "first"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0, 0, 0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY}, m = "first", n = {"$this$first", "predicate", "result", "$this$collectWhile$iv", "collector$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f59834a;

        /* renamed from: b  reason: collision with root package name */
        int f59835b;

        /* renamed from: c  reason: collision with root package name */
        Object f59836c;

        /* renamed from: d  reason: collision with root package name */
        Object f59837d;

        /* renamed from: e  reason: collision with root package name */
        Object f59838e;

        /* renamed from: f  reason: collision with root package name */
        Object f59839f;

        /* renamed from: g  reason: collision with root package name */
        Object f59840g;

        c(kotlin.coroutines.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f59834a = obj;
            this.f59835b |= Integer.MIN_VALUE;
            return kotlinx.coroutines.flow.k.y0(null, null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Limit.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/i;", "value", "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d<T> implements kotlinx.coroutines.flow.i<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f59841a;

        public d(Ref.ObjectRef objectRef) {
            this.f59841a = objectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.i
        @Nullable
        public Object emit(Object obj, @NotNull kotlin.coroutines.c cVar) {
            this.f59841a.element = obj;
            if (kotlin.coroutines.jvm.internal.a.a(false).booleanValue()) {
                return f1.f55527a;
            }
            throw new AbortFlowException(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Reduce.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0005\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002H\u0086@"}, d2 = {"T", "Lkotlinx/coroutines/flow/h;", "Lkotlin/coroutines/c;", "continuation", "", "firstOrNull"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0, 0, 0}, l = {212}, m = "firstOrNull", n = {"$this$firstOrNull", "result", "$this$collectWhile$iv", "collector$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class e extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f59842a;

        /* renamed from: b  reason: collision with root package name */
        int f59843b;

        /* renamed from: c  reason: collision with root package name */
        Object f59844c;

        /* renamed from: d  reason: collision with root package name */
        Object f59845d;

        /* renamed from: e  reason: collision with root package name */
        Object f59846e;

        /* renamed from: f  reason: collision with root package name */
        Object f59847f;

        e(kotlin.coroutines.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f59842a = obj;
            this.f59843b |= Integer.MIN_VALUE;
            return kotlinx.coroutines.flow.k.B0(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Reduce.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00022\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0003H\u0086@"}, d2 = {"T", "Lkotlinx/coroutines/flow/h;", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "", "predicate", "continuation", "firstOrNull"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0, 0, 0, 0}, l = {227}, m = "firstOrNull", n = {"$this$firstOrNull", "predicate", "result", "$this$collectWhile$iv", "collector$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class f extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f59848a;

        /* renamed from: b  reason: collision with root package name */
        int f59849b;

        /* renamed from: c  reason: collision with root package name */
        Object f59850c;

        /* renamed from: d  reason: collision with root package name */
        Object f59851d;

        /* renamed from: e  reason: collision with root package name */
        Object f59852e;

        /* renamed from: f  reason: collision with root package name */
        Object f59853f;

        /* renamed from: g  reason: collision with root package name */
        Object f59854g;

        f(kotlin.coroutines.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f59848a = obj;
            this.f59849b |= Integer.MIN_VALUE;
            return kotlinx.coroutines.flow.k.A0(null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Reduce.kt */
    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\f\u001a\u0004\u0018\u00010\t\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0001*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00022F\u0010\n\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0086@"}, d2 = {"S", "T", "Lkotlinx/coroutines/flow/h;", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "accumulator", "value", "Lkotlin/coroutines/c;", "", "operation", "continuation", "reduce"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0, 0, 0}, l = {148}, m = "reduce", n = {"$this$reduce", "operation", "accumulator", "$this$collect$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class g extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f59855a;

        /* renamed from: b  reason: collision with root package name */
        int f59856b;

        /* renamed from: c  reason: collision with root package name */
        Object f59857c;

        /* renamed from: d  reason: collision with root package name */
        Object f59858d;

        /* renamed from: e  reason: collision with root package name */
        Object f59859e;

        /* renamed from: f  reason: collision with root package name */
        Object f59860f;

        g(kotlin.coroutines.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f59855a = obj;
            this.f59856b |= Integer.MIN_VALUE;
            return kotlinx.coroutines.flow.k.C1(null, null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Collect.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", "value", "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class h<T> implements kotlinx.coroutines.flow.i<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f59861a;

        public h(Ref.ObjectRef objectRef) {
            this.f59861a = objectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.i
        @Nullable
        public Object emit(Object obj, @NotNull kotlin.coroutines.c cVar) {
            Ref.ObjectRef objectRef = this.f59861a;
            if (objectRef.element == kotlinx.coroutines.flow.internal.r.f60167a) {
                objectRef.element = obj;
                return f1.f55527a;
            }
            throw new IllegalArgumentException("Flow has more than one element".toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Reduce.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0005\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@"}, d2 = {"T", "Lkotlinx/coroutines/flow/h;", "Lkotlin/coroutines/c;", "continuation", "", "single"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0, 0}, l = {154}, m = "single", n = {"$this$single", "result", "$this$collect$iv"}, s = {"L$0", "L$1", "L$2"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class i extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f59862a;

        /* renamed from: b  reason: collision with root package name */
        int f59863b;

        /* renamed from: c  reason: collision with root package name */
        Object f59864c;

        /* renamed from: d  reason: collision with root package name */
        Object f59865d;

        /* renamed from: e  reason: collision with root package name */
        Object f59866e;

        i(kotlin.coroutines.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f59862a = obj;
            this.f59863b |= Integer.MIN_VALUE;
            return kotlinx.coroutines.flow.k.S1(null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Limit.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/i;", "value", "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class j<T> implements kotlinx.coroutines.flow.i<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f59867a;

        public j(Ref.ObjectRef objectRef) {
            this.f59867a = objectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.i
        @Nullable
        public Object emit(Object obj, @NotNull kotlin.coroutines.c cVar) {
            boolean z3;
            Ref.ObjectRef objectRef = this.f59867a;
            T t3 = objectRef.element;
            T t4 = (T) kotlinx.coroutines.flow.internal.r.f60167a;
            if (t3 == t4) {
                objectRef.element = obj;
                z3 = true;
            } else {
                objectRef.element = t4;
                z3 = false;
            }
            if (kotlin.coroutines.jvm.internal.a.a(z3).booleanValue()) {
                return f1.f55527a;
            }
            throw new AbortFlowException(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Reduce.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0005\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002H\u0086@"}, d2 = {"T", "Lkotlinx/coroutines/flow/h;", "Lkotlin/coroutines/c;", "continuation", "", "singleOrNull"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0, 0, 0}, l = {167}, m = "singleOrNull", n = {"$this$singleOrNull", "result", "$this$collectWhile$iv", "collector$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class k extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f59868a;

        /* renamed from: b  reason: collision with root package name */
        int f59869b;

        /* renamed from: c  reason: collision with root package name */
        Object f59870c;

        /* renamed from: d  reason: collision with root package name */
        Object f59871d;

        /* renamed from: e  reason: collision with root package name */
        Object f59872e;

        /* renamed from: f  reason: collision with root package name */
        Object f59873f;

        k(kotlin.coroutines.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f59868a = obj;
            this.f59869b |= Integer.MIN_VALUE;
            return kotlinx.coroutines.flow.k.T1(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007d  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.h<? extends T> r4, @org.jetbrains.annotations.NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super java.lang.Boolean>, ? extends java.lang.Object> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super T> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt.c
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ReduceKt$c r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.c) r0
            int r1 = r0.f59835b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f59835b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$c r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$c
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f59834a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f59835b
            r3 = 1
            if (r2 == 0) goto L47
            if (r2 != r3) goto L3f
            java.lang.Object r4 = r0.f59840g
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2 r4 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2) r4
            java.lang.Object r5 = r0.f59839f
            kotlinx.coroutines.flow.h r5 = (kotlinx.coroutines.flow.h) r5
            java.lang.Object r5 = r0.f59838e
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
            java.lang.Object r1 = r0.f59837d
            d2.p r1 = (d2.p) r1
            java.lang.Object r0 = r0.f59836c
            kotlinx.coroutines.flow.h r0 = (kotlinx.coroutines.flow.h) r0
            kotlin.d0.n(r6)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L3d
            goto L76
        L3d:
            r6 = move-exception
            goto L73
        L3f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L47:
            kotlin.d0.n(r6)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            kotlinx.coroutines.internal.j0 r2 = kotlinx.coroutines.flow.internal.r.f60167a
            r6.element = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2 r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2
            r2.<init>(r5, r6)
            r0.f59836c = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L6e
            r0.f59837d = r5     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L6e
            r0.f59838e = r6     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L6e
            r0.f59839f = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L6e
            r0.f59840g = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L6e
            r0.f59835b = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L6e
            java.lang.Object r4 = r4.e(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L6e
            if (r4 != r1) goto L6b
            return r1
        L6b:
            r1 = r5
            r5 = r6
            goto L76
        L6e:
            r4 = move-exception
            r1 = r5
            r5 = r6
            r6 = r4
            r4 = r2
        L73:
            kotlinx.coroutines.flow.internal.m.b(r6, r4)
        L76:
            T r4 = r5.element
            kotlinx.coroutines.internal.j0 r5 = kotlinx.coroutines.flow.internal.r.f60167a
            if (r4 == r5) goto L7d
            return r4
        L7d:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Expected at least one element matching the predicate "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.a(kotlinx.coroutines.flow.h, d2.p, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0074 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0075  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object b(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.h<? extends T> r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super T> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt.b
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$b r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.b) r0
            int r1 = r0.f59829b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f59829b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$b r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$b
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f59828a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f59829b
            r3 = 1
            if (r2 == 0) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r4 = r0.f59833f
            kotlinx.coroutines.flow.FlowKt__ReduceKt$a r4 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.a) r4
            java.lang.Object r1 = r0.f59832e
            kotlinx.coroutines.flow.h r1 = (kotlinx.coroutines.flow.h) r1
            java.lang.Object r1 = r0.f59831d
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r0 = r0.f59830c
            kotlinx.coroutines.flow.h r0 = (kotlinx.coroutines.flow.h) r0
            kotlin.d0.n(r5)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L39
            goto L6e
        L39:
            r5 = move-exception
            goto L6b
        L3b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L43:
            kotlin.d0.n(r5)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            kotlinx.coroutines.internal.j0 r2 = kotlinx.coroutines.flow.internal.r.f60167a
            r5.element = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$a r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$a
            r2.<init>(r5)
            r0.f59830c = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L67
            r0.f59831d = r5     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L67
            r0.f59832e = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L67
            r0.f59833f = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L67
            r0.f59829b = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L67
            java.lang.Object r4 = r4.e(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L67
            if (r4 != r1) goto L65
            return r1
        L65:
            r1 = r5
            goto L6e
        L67:
            r4 = move-exception
            r1 = r5
            r5 = r4
            r4 = r2
        L6b:
            kotlinx.coroutines.flow.internal.m.b(r5, r4)
        L6e:
            T r4 = r1.element
            kotlinx.coroutines.internal.j0 r5 = kotlinx.coroutines.flow.internal.r.f60167a
            if (r4 == r5) goto L75
            return r4
        L75:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Expected at least one element"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.b(kotlinx.coroutines.flow.h, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object c(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.h<? extends T> r4, @org.jetbrains.annotations.NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super java.lang.Boolean>, ? extends java.lang.Object> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super T> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt.f
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ReduceKt$f r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.f) r0
            int r1 = r0.f59849b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f59849b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$f r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$f
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f59848a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f59849b
            r3 = 1
            if (r2 == 0) goto L47
            if (r2 != r3) goto L3f
            java.lang.Object r4 = r0.f59854g
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 r4 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2) r4
            java.lang.Object r5 = r0.f59853f
            kotlinx.coroutines.flow.h r5 = (kotlinx.coroutines.flow.h) r5
            java.lang.Object r5 = r0.f59852e
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
            java.lang.Object r1 = r0.f59851d
            d2.p r1 = (d2.p) r1
            java.lang.Object r0 = r0.f59850c
            kotlinx.coroutines.flow.h r0 = (kotlinx.coroutines.flow.h) r0
            kotlin.d0.n(r6)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L3d
            goto L73
        L3d:
            r6 = move-exception
            goto L70
        L3f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L47:
            kotlin.d0.n(r6)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            r2 = 0
            r6.element = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2
            r2.<init>(r5, r6)
            r0.f59850c = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L6c
            r0.f59851d = r5     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L6c
            r0.f59852e = r6     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L6c
            r0.f59853f = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L6c
            r0.f59854g = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L6c
            r0.f59849b = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L6c
            java.lang.Object r4 = r4.e(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L6c
            if (r4 != r1) goto L6a
            return r1
        L6a:
            r5 = r6
            goto L73
        L6c:
            r4 = move-exception
            r5 = r6
            r6 = r4
            r4 = r2
        L70:
            kotlinx.coroutines.flow.internal.m.b(r6, r4)
        L73:
            T r4 = r5.element
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.c(kotlinx.coroutines.flow.h, d2.p, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object d(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.h<? extends T> r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super T> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt.e
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$e r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.e) r0
            int r1 = r0.f59843b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f59843b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$e r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$e
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f59842a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f59843b
            r3 = 1
            if (r2 == 0) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r4 = r0.f59847f
            kotlinx.coroutines.flow.FlowKt__ReduceKt$d r4 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.d) r4
            java.lang.Object r1 = r0.f59846e
            kotlinx.coroutines.flow.h r1 = (kotlinx.coroutines.flow.h) r1
            java.lang.Object r1 = r0.f59845d
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r0 = r0.f59844c
            kotlinx.coroutines.flow.h r0 = (kotlinx.coroutines.flow.h) r0
            kotlin.d0.n(r5)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L39
            goto L6d
        L39:
            r5 = move-exception
            goto L6a
        L3b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L43:
            kotlin.d0.n(r5)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            r2 = 0
            r5.element = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$d r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$d
            r2.<init>(r5)
            r0.f59844c = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L66
            r0.f59845d = r5     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L66
            r0.f59846e = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L66
            r0.f59847f = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L66
            r0.f59843b = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L66
            java.lang.Object r4 = r4.e(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L66
            if (r4 != r1) goto L64
            return r1
        L64:
            r1 = r5
            goto L6d
        L66:
            r4 = move-exception
            r1 = r5
            r5 = r4
            r4 = r2
        L6a:
            kotlinx.coroutines.flow.internal.m.b(r5, r4)
        L6d:
            T r4 = r1.element
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.d(kotlinx.coroutines.flow.h, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T, R> java.lang.Object e(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.h<? extends T> r4, R r5, @org.jetbrains.annotations.NotNull d2.q<? super R, ? super T, ? super kotlin.coroutines.c<? super R>, ? extends java.lang.Object> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super R> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r4 = r0.L$4
            kotlinx.coroutines.flow.h r4 = (kotlinx.coroutines.flow.h) r4
            java.lang.Object r4 = r0.L$3
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            java.lang.Object r5 = r0.L$2
            d2.q r5 = (d2.q) r5
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.flow.h r5 = (kotlinx.coroutines.flow.h) r5
            kotlin.d0.n(r7)
            goto L64
        L39:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L41:
            kotlin.d0.n(r7)
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            r7.element = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$$inlined$collect$1 r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$$inlined$collect$1
            r2.<init>(r7, r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.L$3 = r7
            r0.L$4 = r4
            r0.label = r3
            java.lang.Object r4 = r4.e(r2, r0)
            if (r4 != r1) goto L63
            return r1
        L63:
            r4 = r7
        L64:
            T r4 = r4.element
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.e(kotlinx.coroutines.flow.h, java.lang.Object, d2.q, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    private static final Object f(@NotNull kotlinx.coroutines.flow.h hVar, Object obj, @NotNull d2.q qVar, @NotNull kotlin.coroutines.c cVar) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = obj;
        FlowKt__ReduceKt$fold$$inlined$collect$1 flowKt__ReduceKt$fold$$inlined$collect$1 = new FlowKt__ReduceKt$fold$$inlined$collect$1(objectRef, qVar);
        kotlin.jvm.internal.c0.e(0);
        hVar.e(flowKt__ReduceKt$fold$$inlined$collect$1, cVar);
        kotlin.jvm.internal.c0.e(2);
        kotlin.jvm.internal.c0.e(1);
        return objectRef.element;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006b  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.internal.j0] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <S, T extends S> java.lang.Object g(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.h<? extends T> r4, @org.jetbrains.annotations.NotNull d2.q<? super S, ? super T, ? super kotlin.coroutines.c<? super S>, ? extends java.lang.Object> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super S> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt.g
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ReduceKt$g r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.g) r0
            int r1 = r0.f59856b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f59856b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$g r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$g
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f59855a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f59856b
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r4 = r0.f59860f
            kotlinx.coroutines.flow.h r4 = (kotlinx.coroutines.flow.h) r4
            java.lang.Object r4 = r0.f59859e
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            java.lang.Object r5 = r0.f59858d
            d2.q r5 = (d2.q) r5
            java.lang.Object r5 = r0.f59857c
            kotlinx.coroutines.flow.h r5 = (kotlinx.coroutines.flow.h) r5
            kotlin.d0.n(r6)
            goto L64
        L39:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L41:
            kotlin.d0.n(r6)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            kotlinx.coroutines.internal.j0 r2 = kotlinx.coroutines.flow.internal.r.f60167a
            r6.element = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1 r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1
            r2.<init>(r6, r5)
            r0.f59857c = r4
            r0.f59858d = r5
            r0.f59859e = r6
            r0.f59860f = r4
            r0.f59856b = r3
            java.lang.Object r4 = r4.e(r2, r0)
            if (r4 != r1) goto L63
            return r1
        L63:
            r4 = r6
        L64:
            T r4 = r4.element
            kotlinx.coroutines.internal.j0 r5 = kotlinx.coroutines.flow.internal.r.f60167a
            if (r4 == r5) goto L6b
            return r4
        L6b:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Empty flow can't be reduced"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.g(kotlinx.coroutines.flow.h, d2.q, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object h(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.h<? extends T> r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super T> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt.i
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$i r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.i) r0
            int r1 = r0.f59863b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f59863b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$i r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$i
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f59862a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f59863b
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r4 = r0.f59866e
            kotlinx.coroutines.flow.h r4 = (kotlinx.coroutines.flow.h) r4
            java.lang.Object r4 = r0.f59865d
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            java.lang.Object r0 = r0.f59864c
            kotlinx.coroutines.flow.h r0 = (kotlinx.coroutines.flow.h) r0
            kotlin.d0.n(r5)
            goto L5e
        L35:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3d:
            kotlin.d0.n(r5)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            kotlinx.coroutines.internal.j0 r2 = kotlinx.coroutines.flow.internal.r.f60167a
            r5.element = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$h r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$h
            r2.<init>(r5)
            r0.f59864c = r4
            r0.f59865d = r5
            r0.f59866e = r4
            r0.f59863b = r3
            java.lang.Object r4 = r4.e(r2, r0)
            if (r4 != r1) goto L5d
            return r1
        L5d:
            r4 = r5
        L5e:
            T r4 = r4.element
            kotlinx.coroutines.internal.j0 r5 = kotlinx.coroutines.flow.internal.r.f60167a
            if (r4 == r5) goto L65
            return r4
        L65:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Flow is empty"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.h(kotlinx.coroutines.flow.h, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0074 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object i(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.h<? extends T> r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super T> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt.k
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$k r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.k) r0
            int r1 = r0.f59869b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f59869b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$k r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$k
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f59868a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f59869b
            r3 = 1
            if (r2 == 0) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r4 = r0.f59873f
            kotlinx.coroutines.flow.FlowKt__ReduceKt$j r4 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.j) r4
            java.lang.Object r1 = r0.f59872e
            kotlinx.coroutines.flow.h r1 = (kotlinx.coroutines.flow.h) r1
            java.lang.Object r1 = r0.f59871d
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r0 = r0.f59870c
            kotlinx.coroutines.flow.h r0 = (kotlinx.coroutines.flow.h) r0
            kotlin.d0.n(r5)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L39
            goto L6e
        L39:
            r5 = move-exception
            goto L6b
        L3b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L43:
            kotlin.d0.n(r5)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            kotlinx.coroutines.internal.j0 r2 = kotlinx.coroutines.flow.internal.r.f60167a
            r5.element = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$j r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$j
            r2.<init>(r5)
            r0.f59870c = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L67
            r0.f59871d = r5     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L67
            r0.f59872e = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L67
            r0.f59873f = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L67
            r0.f59869b = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L67
            java.lang.Object r4 = r4.e(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L67
            if (r4 != r1) goto L65
            return r1
        L65:
            r1 = r5
            goto L6e
        L67:
            r4 = move-exception
            r1 = r5
            r5 = r4
            r4 = r2
        L6b:
            kotlinx.coroutines.flow.internal.m.b(r5, r4)
        L6e:
            T r4 = r1.element
            kotlinx.coroutines.internal.j0 r5 = kotlinx.coroutines.flow.internal.r.f60167a
            if (r4 != r5) goto L75
            r4 = 0
        L75:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.i(kotlinx.coroutines.flow.h, kotlin.coroutines.c):java.lang.Object");
    }
}
