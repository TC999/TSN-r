package kotlinx.coroutines.flow;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.BuilderInference;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.collections.o0;
import kotlin.f1;
import kotlin.jvm.JvmName;
import kotlin.time.ExperimentalTime;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@Metadata(bv = {}, d1 = {"kotlinx/coroutines/flow/FlowKt__BuildersKt", "kotlinx/coroutines/flow/l", "kotlinx/coroutines/flow/FlowKt__CollectKt", "kotlinx/coroutines/flow/m", "kotlinx/coroutines/flow/n", "kotlinx/coroutines/flow/FlowKt__CountKt", "kotlinx/coroutines/flow/o", "kotlinx/coroutines/flow/p", "kotlinx/coroutines/flow/FlowKt__EmittersKt", "kotlinx/coroutines/flow/FlowKt__ErrorsKt", "kotlinx/coroutines/flow/FlowKt__LimitKt", "kotlinx/coroutines/flow/FlowKt__MergeKt", "kotlinx/coroutines/flow/FlowKt__MigrationKt", "kotlinx/coroutines/flow/FlowKt__ReduceKt", "kotlinx/coroutines/flow/q", "kotlinx/coroutines/flow/FlowKt__TransformKt", "kotlinx/coroutines/flow/FlowKt__ZipKt"}, d2 = {}, k = 4, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class k {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final String f60184a = "kotlinx.coroutines.flow.defaultConcurrency";

    @Nullable
    public static final Object A(@NotNull h<?> hVar, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        return FlowKt__CollectKt.b(hVar, cVar);
    }

    @Nullable
    public static final <T> Object A0(@NotNull h<? extends T> hVar, @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar, @NotNull kotlin.coroutines.c<? super T> cVar) {
        return FlowKt__ReduceKt.c(hVar, pVar, cVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    @NotNull
    public static final <T> h<T> A1(@NotNull h<? extends T> hVar, @NotNull kotlin.coroutines.f fVar) {
        return FlowKt__MigrationKt.y(hVar, fVar);
    }

    @Nullable
    private static final Object B(@NotNull h hVar, @NotNull d2.p pVar, @NotNull kotlin.coroutines.c cVar) {
        return FlowKt__CollectKt.a(hVar, pVar, cVar);
    }

    @Nullable
    public static final <T> Object B0(@NotNull h<? extends T> hVar, @NotNull kotlin.coroutines.c<? super T> cVar) {
        return FlowKt__ReduceKt.d(hVar, cVar);
    }

    @NotNull
    public static final <T> h<T> B1(@NotNull kotlinx.coroutines.channels.d0<? extends T> d0Var) {
        return l.h(d0Var);
    }

    @Nullable
    public static final <T> Object C(@NotNull h<? extends T> hVar, @NotNull d2.q<? super Integer, ? super T, ? super kotlin.coroutines.c<? super f1>, ? extends Object> qVar, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        return FlowKt__CollectKt.d(hVar, qVar, cVar);
    }

    @NotNull
    public static final kotlinx.coroutines.channels.d0<f1> C0(@NotNull q0 q0Var, long j4, long j5) {
        return o.f(q0Var, j4, j5);
    }

    @Nullable
    public static final <S, T extends S> Object C1(@NotNull h<? extends T> hVar, @NotNull d2.q<? super S, ? super T, ? super kotlin.coroutines.c<? super S>, ? extends Object> qVar, @NotNull kotlin.coroutines.c<? super S> cVar) {
        return FlowKt__ReduceKt.g(hVar, qVar, cVar);
    }

    @Nullable
    private static final Object D(@NotNull h hVar, @NotNull d2.q qVar, @NotNull kotlin.coroutines.c cVar) {
        return FlowKt__CollectKt.d(hVar, qVar, cVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay()' is 'shareIn' with unlimited replay. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, Int.MAX_VALUE)", imports = {}))
    @NotNull
    public static final <T> h<T> D1(@NotNull h<? extends T> hVar) {
        return FlowKt__MigrationKt.z(hVar);
    }

    @Nullable
    public static final <T> Object E(@NotNull h<? extends T> hVar, @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        return FlowKt__CollectKt.f(hVar, pVar, cVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue is 'flatMapConcat'", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", imports = {}))
    @NotNull
    public static final <T, R> h<R> E0(@NotNull h<? extends T> hVar, @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super h<? extends R>>, ? extends Object> pVar) {
        return FlowKt__MigrationKt.l(hVar, pVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay(bufferSize)' is 'shareIn' with the specified replay parameter. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, bufferSize)", imports = {}))
    @NotNull
    public static final <T> h<T> E1(@NotNull h<? extends T> hVar, int i4) {
        return FlowKt__MigrationKt.A(hVar, i4);
    }

    @Nullable
    public static final <T> Object F(@NotNull h<? extends T> hVar, @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        return FlowKt__LimitKt.a(hVar, pVar, cVar);
    }

    @FlowPreview
    @NotNull
    public static final <T, R> h<R> F0(@NotNull h<? extends T> hVar, @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super h<? extends R>>, ? extends Object> pVar) {
        return FlowKt__MergeKt.a(hVar, pVar);
    }

    @Nullable
    private static final Object G(@NotNull h hVar, @NotNull d2.p pVar, @NotNull kotlin.coroutines.c cVar) {
        return FlowKt__LimitKt.a(hVar, pVar, cVar);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> h<R> G0(@NotNull h<? extends T> hVar, @BuilderInference @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super h<? extends R>>, ? extends Object> pVar) {
        return FlowKt__MergeKt.b(hVar, pVar);
    }

    @NotNull
    public static final <T> h<T> G1(@NotNull h<? extends T> hVar, long j4, @NotNull d2.p<? super Throwable, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar) {
        return FlowKt__ErrorsKt.i(hVar, j4, pVar);
    }

    @FlowPreview
    @NotNull
    public static final <T, R> h<R> H0(@NotNull h<? extends T> hVar, int i4, @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super h<? extends R>>, ? extends Object> pVar) {
        return FlowKt__MergeKt.c(hVar, i4, pVar);
    }

    @NotNull
    public static final <T1, T2, R> h<R> I(@NotNull h<? extends T1> hVar, @NotNull h<? extends T2> hVar2, @NotNull d2.q<? super T1, ? super T2, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar) {
        return FlowKt__ZipKt.c(hVar, hVar2, qVar);
    }

    @NotNull
    public static final <T1, T2, T3, R> h<R> J(@NotNull h<? extends T1> hVar, @NotNull h<? extends T2> hVar2, @NotNull h<? extends T3> hVar3, @BuilderInference @NotNull d2.r<? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.c<? super R>, ? extends Object> rVar) {
        return FlowKt__ZipKt.d(hVar, hVar2, hVar3, rVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'flatten' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", imports = {}))
    @NotNull
    public static final <T> h<T> J0(@NotNull h<? extends h<? extends T>> hVar) {
        return FlowKt__MigrationKt.m(hVar);
    }

    @NotNull
    public static final <T> h<T> J1(@NotNull h<? extends T> hVar, @NotNull d2.r<? super i<? super T>, ? super Throwable, ? super Long, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> rVar) {
        return FlowKt__ErrorsKt.l(hVar, rVar);
    }

    @NotNull
    public static final <T1, T2, T3, T4, R> h<R> K(@NotNull h<? extends T1> hVar, @NotNull h<? extends T2> hVar2, @NotNull h<? extends T3> hVar3, @NotNull h<? extends T4> hVar4, @NotNull d2.s<? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.c<? super R>, ? extends Object> sVar) {
        return FlowKt__ZipKt.e(hVar, hVar2, hVar3, hVar4, sVar);
    }

    @FlowPreview
    @NotNull
    public static final <T> h<T> K0(@NotNull h<? extends h<? extends T>> hVar) {
        return FlowKt__MergeKt.e(hVar);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T> h<T> K1(@NotNull h<? extends T> hVar, @NotNull d2.q<? super T, ? super T, ? super kotlin.coroutines.c<? super T>, ? extends Object> qVar) {
        return FlowKt__TransformKt.h(hVar, qVar);
    }

    @NotNull
    public static final <T1, T2, T3, T4, T5, R> h<R> L(@NotNull h<? extends T1> hVar, @NotNull h<? extends T2> hVar2, @NotNull h<? extends T3> hVar3, @NotNull h<? extends T4> hVar4, @NotNull h<? extends T5> hVar5, @NotNull d2.t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.c<? super R>, ? extends Object> tVar) {
        return FlowKt__ZipKt.f(hVar, hVar2, hVar3, hVar4, hVar5, tVar);
    }

    @FlowPreview
    @NotNull
    public static final <T> h<T> L0(@NotNull h<? extends h<? extends T>> hVar, int i4) {
        return FlowKt__MergeKt.f(hVar, i4);
    }

    @FlowPreview
    @NotNull
    public static final <T> h<T> L1(@NotNull h<? extends T> hVar, long j4) {
        return o.h(hVar, j4);
    }

    @FlowPreview
    @ExperimentalTime
    @NotNull
    public static final <T> h<T> M1(@NotNull h<? extends T> hVar, double d4) {
        return o.i(hVar, d4);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "this.combine(other, transform)", imports = {}))
    @NotNull
    public static final <T1, T2, R> h<R> N(@NotNull h<? extends T1> hVar, @NotNull h<? extends T2> hVar2, @NotNull d2.q<? super T1, ? super T2, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar) {
        return FlowKt__MigrationKt.b(hVar, hVar2, qVar);
    }

    @NotNull
    public static final <T> h<T> N0(@BuilderInference @NotNull d2.p<? super i<? super T>, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar) {
        return FlowKt__BuildersKt.n(pVar);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> h<R> N1(@NotNull h<? extends T> hVar, R r3, @BuilderInference @NotNull d2.q<? super R, ? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar) {
        return FlowKt__TransformKt.i(hVar, r3, qVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, transform)", imports = {}))
    @NotNull
    public static final <T1, T2, T3, R> h<R> O(@NotNull h<? extends T1> hVar, @NotNull h<? extends T2> hVar2, @NotNull h<? extends T3> hVar3, @NotNull d2.r<? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.c<? super R>, ? extends Object> rVar) {
        return FlowKt__MigrationKt.c(hVar, hVar2, hVar3, rVar);
    }

    @JvmName(name = "flowCombine")
    @NotNull
    public static final <T1, T2, R> h<R> O0(@NotNull h<? extends T1> hVar, @NotNull h<? extends T2> hVar2, @NotNull d2.q<? super T1, ? super T2, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar) {
        return FlowKt__ZipKt.p(hVar, hVar2, qVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow has less verbose 'scan' shortcut", replaceWith = @ReplaceWith(expression = "scan(initial, operation)", imports = {}))
    @NotNull
    public static final <T, R> h<R> O1(@NotNull h<? extends T> hVar, R r3, @BuilderInference @NotNull d2.q<? super R, ? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar) {
        return FlowKt__MigrationKt.B(hVar, r3, qVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @NotNull
    public static final <T1, T2, T3, T4, R> h<R> P(@NotNull h<? extends T1> hVar, @NotNull h<? extends T2> hVar2, @NotNull h<? extends T3> hVar3, @NotNull h<? extends T4> hVar4, @NotNull d2.s<? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.c<? super R>, ? extends Object> sVar) {
        return FlowKt__MigrationKt.d(hVar, hVar2, hVar3, hVar4, sVar);
    }

    @JvmName(name = "flowCombineTransform")
    @NotNull
    public static final <T1, T2, R> h<R> P0(@NotNull h<? extends T1> hVar, @NotNull h<? extends T2> hVar2, @BuilderInference @NotNull d2.r<? super i<? super R>, ? super T1, ? super T2, ? super kotlin.coroutines.c<? super f1>, ? extends Object> rVar) {
        return FlowKt__ZipKt.q(hVar, hVar2, rVar);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "'scanReduce' was renamed to 'runningReduce' to be consistent with Kotlin standard library", replaceWith = @ReplaceWith(expression = "runningReduce(operation)", imports = {}))
    @NotNull
    public static final <T> h<T> P1(@NotNull h<? extends T> hVar, @NotNull d2.q<? super T, ? super T, ? super kotlin.coroutines.c<? super T>, ? extends Object> qVar) {
        return FlowKt__MigrationKt.C(hVar, qVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @NotNull
    public static final <T1, T2, T3, T4, T5, R> h<R> Q(@NotNull h<? extends T1> hVar, @NotNull h<? extends T2> hVar2, @NotNull h<? extends T3> hVar3, @NotNull h<? extends T4> hVar4, @NotNull h<? extends T5> hVar5, @NotNull d2.t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.c<? super R>, ? extends Object> tVar) {
        return FlowKt__MigrationKt.e(hVar, hVar2, hVar3, hVar4, hVar5, tVar);
    }

    @NotNull
    public static final <T> h<T> Q0(T t3) {
        return FlowKt__BuildersKt.o(t3);
    }

    @NotNull
    public static final <T> x<T> Q1(@NotNull h<? extends T> hVar, @NotNull q0 q0Var, @NotNull d0 d0Var, int i4) {
        return q.g(hVar, q0Var, d0Var, i4);
    }

    @NotNull
    public static final <T> h<T> R0(@NotNull T... tArr) {
        return FlowKt__BuildersKt.p(tArr);
    }

    @NotNull
    public static final <T1, T2, R> h<R> S(@NotNull h<? extends T1> hVar, @NotNull h<? extends T2> hVar2, @BuilderInference @NotNull d2.r<? super i<? super R>, ? super T1, ? super T2, ? super kotlin.coroutines.c<? super f1>, ? extends Object> rVar) {
        return FlowKt__ZipKt.i(hVar, hVar2, rVar);
    }

    @NotNull
    public static final <T> h<T> S0(@NotNull h<? extends T> hVar, @NotNull kotlin.coroutines.f fVar) {
        return n.h(hVar, fVar);
    }

    @Nullable
    public static final <T> Object S1(@NotNull h<? extends T> hVar, @NotNull kotlin.coroutines.c<? super T> cVar) {
        return FlowKt__ReduceKt.h(hVar, cVar);
    }

    @NotNull
    public static final <T1, T2, T3, R> h<R> T(@NotNull h<? extends T1> hVar, @NotNull h<? extends T2> hVar2, @NotNull h<? extends T3> hVar3, @BuilderInference @NotNull d2.s<? super i<? super R>, ? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.c<? super f1>, ? extends Object> sVar) {
        return FlowKt__ZipKt.j(hVar, hVar2, hVar3, sVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use channelFlow with awaitClose { } instead of flowViaChannel and invokeOnClose { }.")
    @FlowPreview
    @NotNull
    public static final <T> h<T> T0(int i4, @BuilderInference @NotNull d2.p<? super q0, ? super kotlinx.coroutines.channels.h0<? super T>, f1> pVar) {
        return FlowKt__BuildersKt.q(i4, pVar);
    }

    @Nullable
    public static final <T> Object T1(@NotNull h<? extends T> hVar, @NotNull kotlin.coroutines.c<? super T> cVar) {
        return FlowKt__ReduceKt.i(hVar, cVar);
    }

    @NotNull
    public static final <T1, T2, T3, T4, R> h<R> U(@NotNull h<? extends T1> hVar, @NotNull h<? extends T2> hVar2, @NotNull h<? extends T3> hVar3, @NotNull h<? extends T4> hVar4, @BuilderInference @NotNull d2.t<? super i<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.c<? super f1>, ? extends Object> tVar) {
        return FlowKt__ZipKt.k(hVar, hVar2, hVar3, hVar4, tVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'skip' is 'drop'", replaceWith = @ReplaceWith(expression = "drop(count)", imports = {}))
    @NotNull
    public static final <T> h<T> U1(@NotNull h<? extends T> hVar, int i4) {
        return FlowKt__MigrationKt.D(hVar, i4);
    }

    @NotNull
    public static final <T1, T2, T3, T4, T5, R> h<R> V(@NotNull h<? extends T1> hVar, @NotNull h<? extends T2> hVar2, @NotNull h<? extends T3> hVar3, @NotNull h<? extends T4> hVar4, @NotNull h<? extends T5> hVar5, @BuilderInference @NotNull d2.u<? super i<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.c<? super f1>, ? extends Object> uVar) {
        return FlowKt__ZipKt.l(hVar, hVar2, hVar3, hVar4, hVar5, uVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "flowWith is deprecated without replacement, please refer to its KDoc for an explanation")
    @FlowPreview
    @NotNull
    public static final <T, R> h<R> V0(@NotNull h<? extends T> hVar, @NotNull kotlin.coroutines.f fVar, int i4, @NotNull d2.l<? super h<? extends T>, ? extends h<? extends R>> lVar) {
        return n.i(hVar, fVar, i4, lVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith = @ReplaceWith(expression = "onStart { emit(value) }", imports = {}))
    @NotNull
    public static final <T> h<T> V1(@NotNull h<? extends T> hVar, T t3) {
        return FlowKt__MigrationKt.E(hVar, t3);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onStart { emitAll(other) }", imports = {}))
    @NotNull
    public static final <T> h<T> W1(@NotNull h<? extends T> hVar, @NotNull h<? extends T> hVar2) {
        return FlowKt__MigrationKt.F(hVar, hVar2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'compose' is 'let'", replaceWith = @ReplaceWith(expression = "let(transformer)", imports = {}))
    @NotNull
    public static final <T, R> h<R> X(@NotNull h<? extends T> hVar, @NotNull d2.l<? super h<? extends T>, ? extends h<? extends R>> lVar) {
        return FlowKt__MigrationKt.f(hVar, lVar);
    }

    @Nullable
    public static final <T, R> Object X0(@NotNull h<? extends T> hVar, R r3, @NotNull d2.q<? super R, ? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar, @NotNull kotlin.coroutines.c<? super R> cVar) {
        return FlowKt__ReduceKt.e(hVar, r3, qVar, cVar);
    }

    @Nullable
    public static final <T> Object X1(@NotNull h<? extends T> hVar, @NotNull q0 q0Var, @NotNull kotlin.coroutines.c<? super h0<? extends T>> cVar) {
        return q.i(hVar, q0Var, cVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", imports = {}))
    @NotNull
    public static final <T, R> h<R> Y(@NotNull h<? extends T> hVar, @NotNull d2.l<? super T, ? extends h<? extends R>> lVar) {
        return FlowKt__MigrationKt.g(hVar, lVar);
    }

    @Nullable
    private static final Object Y0(@NotNull h hVar, Object obj, @NotNull d2.q qVar, @NotNull kotlin.coroutines.c cVar) {
        return FlowKt__ReduceKt.e(hVar, obj, qVar, cVar);
    }

    @NotNull
    public static final <T> h0<T> Y1(@NotNull h<? extends T> hVar, @NotNull q0 q0Var, @NotNull d0 d0Var, T t3) {
        return q.j(hVar, q0Var, d0Var, t3);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith = @ReplaceWith(expression = "onCompletion { emit(value) }", imports = {}))
    @NotNull
    public static final <T> h<T> Z(@NotNull h<? extends T> hVar, T t3) {
        return FlowKt__MigrationKt.h(hVar, t3);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'forEach' is 'collect'", replaceWith = @ReplaceWith(expression = "collect(block)", imports = {}))
    public static final <T> void Z0(@NotNull h<? extends T> hVar, @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar) {
        FlowKt__MigrationKt.n(hVar, pVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void Z1(@NotNull h<? extends T> hVar) {
        FlowKt__MigrationKt.G(hVar);
    }

    @FlowPreview
    @NotNull
    public static final <T> h<T> a(@NotNull d2.a<? extends T> aVar) {
        return FlowKt__BuildersKt.a(aVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onCompletion { emitAll(other) }", imports = {}))
    @NotNull
    public static final <T> h<T> a0(@NotNull h<? extends T> hVar, @NotNull h<? extends T> hVar2) {
        return FlowKt__MigrationKt.i(hVar, hVar2);
    }

    public static final int a1() {
        return FlowKt__MergeKt.h();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void a2(@NotNull h<? extends T> hVar, @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar) {
        FlowKt__MigrationKt.H(hVar, pVar);
    }

    @FlowPreview
    @NotNull
    public static final <T> h<T> b(@NotNull d2.l<? super kotlin.coroutines.c<? super T>, ? extends Object> lVar) {
        return FlowKt__BuildersKt.b(lVar);
    }

    @NotNull
    public static final <T> h<T> b0(@NotNull h<? extends T> hVar) {
        return n.g(hVar);
    }

    @FlowPreview
    public static /* synthetic */ void b1() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void b2(@NotNull h<? extends T> hVar, @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar, @NotNull d2.p<? super Throwable, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar2) {
        FlowKt__MigrationKt.I(hVar, pVar, pVar2);
    }

    @NotNull
    public static final <T> h<T> c(@NotNull Iterable<? extends T> iterable) {
        return FlowKt__BuildersKt.c(iterable);
    }

    @NotNull
    public static final <T> h<T> c0(@NotNull kotlinx.coroutines.channels.d0<? extends T> d0Var) {
        return l.d(d0Var);
    }

    @NotNull
    public static final <T> e2 c1(@NotNull h<? extends T> hVar, @NotNull q0 q0Var) {
        return FlowKt__CollectKt.i(hVar, q0Var);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'flowOn' instead")
    @NotNull
    public static final <T> h<T> c2(@NotNull h<? extends T> hVar, @NotNull kotlin.coroutines.f fVar) {
        return FlowKt__MigrationKt.J(hVar, fVar);
    }

    @NotNull
    public static final <T> h<T> d(@NotNull Iterator<? extends T> it) {
        return FlowKt__BuildersKt.d(it);
    }

    @Nullable
    public static final <T> Object d0(@NotNull h<? extends T> hVar, @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar, @NotNull kotlin.coroutines.c<? super Integer> cVar) {
        return FlowKt__CountKt.a(hVar, pVar, cVar);
    }

    @NotNull
    public static final <T, R> h<R> d1(@NotNull h<? extends T> hVar, @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        return FlowKt__TransformKt.e(hVar, pVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith = @ReplaceWith(expression = "this.flatMapLatest(transform)", imports = {}))
    @NotNull
    public static final <T, R> h<R> d2(@NotNull h<? extends T> hVar, @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super h<? extends R>>, ? extends Object> pVar) {
        return FlowKt__MigrationKt.K(hVar, pVar);
    }

    @NotNull
    public static final h<Integer> e(@NotNull kotlin.ranges.k kVar) {
        return FlowKt__BuildersKt.e(kVar);
    }

    @Nullable
    public static final <T> Object e0(@NotNull h<? extends T> hVar, @NotNull kotlin.coroutines.c<? super Integer> cVar) {
        return FlowKt__CountKt.b(hVar, cVar);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> h<R> e1(@NotNull h<? extends T> hVar, @BuilderInference @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        return FlowKt__MergeKt.j(hVar, pVar);
    }

    @NotNull
    public static final <T> h<T> e2(@NotNull h<? extends T> hVar, int i4) {
        return FlowKt__LimitKt.f(hVar, i4);
    }

    @NotNull
    public static final h<Long> f(@NotNull kotlin.ranges.n nVar) {
        return FlowKt__BuildersKt.f(nVar);
    }

    @FlowPreview
    @NotNull
    public static final <T> h<T> f0(@NotNull h<? extends T> hVar, long j4) {
        return o.a(hVar, j4);
    }

    @NotNull
    public static final <T, R> h<R> f1(@NotNull h<? extends T> hVar, @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        return FlowKt__TransformKt.f(hVar, pVar);
    }

    @NotNull
    public static final <T> h<T> f2(@NotNull h<? extends T> hVar, @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar) {
        return FlowKt__LimitKt.g(hVar, pVar);
    }

    @NotNull
    public static final <T> h<T> g(@NotNull kotlin.sequences.m<? extends T> mVar) {
        return FlowKt__BuildersKt.g(mVar);
    }

    @FlowPreview
    @OverloadResolutionByLambdaReturnType
    @NotNull
    public static final <T> h<T> g0(@NotNull h<? extends T> hVar, @NotNull d2.l<? super T, Long> lVar) {
        return o.b(hVar, lVar);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T> h<T> g1(@NotNull Iterable<? extends h<? extends T>> iterable) {
        return FlowKt__MergeKt.k(iterable);
    }

    @Nullable
    public static final <T, C extends Collection<? super T>> Object g2(@NotNull h<? extends T> hVar, @NotNull C c4, @NotNull kotlin.coroutines.c<? super C> cVar) {
        return m.a(hVar, c4, cVar);
    }

    @FlowPreview
    @NotNull
    public static final <T> h<T> h(@NotNull kotlinx.coroutines.channels.j<T> jVar) {
        return l.a(jVar);
    }

    @FlowPreview
    @ExperimentalTime
    @NotNull
    public static final <T> h<T> h0(@NotNull h<? extends T> hVar, double d4) {
        return o.c(hVar, d4);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'merge' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", imports = {}))
    @NotNull
    public static final <T> h<T> h1(@NotNull h<? extends h<? extends T>> hVar) {
        return FlowKt__MigrationKt.o(hVar);
    }

    @Nullable
    public static final <T> Object h2(@NotNull h<? extends T> hVar, @NotNull List<T> list, @NotNull kotlin.coroutines.c<? super List<? extends T>> cVar) {
        return m.b(hVar, list, cVar);
    }

    @NotNull
    public static final h<Integer> i(@NotNull int[] iArr) {
        return FlowKt__BuildersKt.h(iArr);
    }

    @FlowPreview
    @JvmName(name = "debounceDuration")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    @ExperimentalTime
    public static final <T> h<T> i0(@NotNull h<? extends T> hVar, @NotNull d2.l<? super T, kotlin.time.d> lVar) {
        return o.d(hVar, lVar);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T> h<T> i1(@NotNull h<? extends T>... hVarArr) {
        return FlowKt__MergeKt.l(hVarArr);
    }

    @NotNull
    public static final h<Long> j(@NotNull long[] jArr) {
        return FlowKt__BuildersKt.i(jArr);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use 'onEach { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onEach { delay(timeMillis) }", imports = {}))
    @NotNull
    public static final <T> h<T> j0(@NotNull h<? extends T> hVar, long j4) {
        return FlowKt__MigrationKt.j(hVar, j4);
    }

    @NotNull
    public static final Void j1() {
        return FlowKt__MigrationKt.p();
    }

    @Nullable
    public static final <T> Object j2(@NotNull h<? extends T> hVar, @NotNull Set<T> set, @NotNull kotlin.coroutines.c<? super Set<? extends T>> cVar) {
        return m.d(hVar, set, cVar);
    }

    @NotNull
    public static final <T> h<T> k(@NotNull T[] tArr) {
        return FlowKt__BuildersKt.j(tArr);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use 'onStart { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onStart { delay(timeMillis) }", imports = {}))
    @NotNull
    public static final <T> h<T> k0(@NotNull h<? extends T> hVar, long j4) {
        return FlowKt__MigrationKt.k(hVar, j4);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    @NotNull
    public static final <T> h<T> k1(@NotNull h<? extends T> hVar, @NotNull kotlin.coroutines.f fVar) {
        return FlowKt__MigrationKt.q(hVar, fVar);
    }

    @NotNull
    public static final <T> x<T> l(@NotNull s<T> sVar) {
        return q.a(sVar);
    }

    @NotNull
    public static final <T> h<T> l0(@NotNull h<? extends T> hVar) {
        return p.a(hVar);
    }

    @NotNull
    public static final <T> h<T> l1(@NotNull h<? extends T> hVar, @NotNull d2.q<? super i<? super T>, ? super Throwable, ? super kotlin.coroutines.c<? super f1>, ? extends Object> qVar) {
        return FlowKt__EmittersKt.b(hVar, qVar);
    }

    @NotNull
    public static final <T, R> h<R> l2(@NotNull h<? extends T> hVar, @BuilderInference @NotNull d2.q<? super i<? super R>, ? super T, ? super kotlin.coroutines.c<? super f1>, ? extends Object> qVar) {
        return FlowKt__EmittersKt.e(hVar, qVar);
    }

    @NotNull
    public static final <T> h0<T> m(@NotNull t<T> tVar) {
        return q.b(tVar);
    }

    @NotNull
    public static final <T> h<T> m0(@NotNull h<? extends T> hVar, @NotNull d2.p<? super T, ? super T, Boolean> pVar) {
        return p.b(hVar, pVar);
    }

    @NotNull
    public static final <T> h<T> m1(@NotNull h<? extends T> hVar, @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar) {
        return FlowKt__TransformKt.g(hVar, pVar);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> h<R> m2(@NotNull h<? extends T> hVar, @BuilderInference @NotNull d2.q<? super i<? super R>, ? super T, ? super kotlin.coroutines.c<? super f1>, ? extends Object> qVar) {
        return FlowKt__MergeKt.m(hVar, qVar);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use shareIn operator and the resulting SharedFlow as a replacement for BroadcastChannel", replaceWith = @ReplaceWith(expression = "shareIn(scope, 0, SharingStarted.Lazily)", imports = {}))
    @NotNull
    public static final <T> kotlinx.coroutines.channels.j<T> n(@NotNull h<? extends T> hVar, @NotNull q0 q0Var, @NotNull CoroutineStart coroutineStart) {
        return l.b(hVar, q0Var, coroutineStart);
    }

    @NotNull
    public static final <T, K> h<T> n0(@NotNull h<? extends T> hVar, @NotNull d2.l<? super T, ? extends K> lVar) {
        return p.c(hVar, lVar);
    }

    @NotNull
    public static final <T> h<T> n1(@NotNull h<? extends T> hVar, @NotNull d2.p<? super i<? super T>, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar) {
        return FlowKt__EmittersKt.c(hVar, pVar);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> h<R> n2(@NotNull h<? extends T> hVar, @BuilderInference @NotNull d2.q<? super i<? super R>, ? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> qVar) {
        return FlowKt__LimitKt.h(hVar, qVar);
    }

    @NotNull
    public static final <T> h<T> o0(@NotNull h<? extends T> hVar, int i4) {
        return FlowKt__LimitKt.c(hVar, i4);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use catch { e -> if (predicate(e)) emitAll(fallback) else throw e }", replaceWith = @ReplaceWith(expression = "catch { e -> if (predicate(e)) emitAll(fallback) else throw e }", imports = {}))
    @NotNull
    public static final <T> h<T> o1(@NotNull h<? extends T> hVar, @NotNull h<? extends T> hVar2, @NotNull d2.l<? super Throwable, Boolean> lVar) {
        return FlowKt__ErrorsKt.f(hVar, hVar2, lVar);
    }

    @PublishedApi
    @NotNull
    public static final <T, R> h<R> o2(@NotNull h<? extends T> hVar, @BuilderInference @NotNull d2.q<? super i<? super R>, ? super T, ? super kotlin.coroutines.c<? super f1>, ? extends Object> qVar) {
        return FlowKt__EmittersKt.f(hVar, qVar);
    }

    @NotNull
    public static final <T> h<T> p0(@NotNull h<? extends T> hVar, @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar) {
        return FlowKt__LimitKt.d(hVar, pVar);
    }

    @NotNull
    public static final <T> h<o0<T>> p2(@NotNull h<? extends T> hVar) {
        return FlowKt__TransformKt.j(hVar);
    }

    @NotNull
    public static final <T> h<T> q(@NotNull h<? extends T> hVar, int i4, @NotNull BufferOverflow bufferOverflow) {
        return n.b(hVar, i4, bufferOverflow);
    }

    @Nullable
    public static final <T> Object q0(@NotNull i<? super T> iVar, @NotNull kotlinx.coroutines.channels.d0<? extends T> d0Var, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        return l.e(iVar, d0Var, cVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", imports = {}))
    @NotNull
    public static final <T> h<T> q1(@NotNull h<? extends T> hVar, @NotNull h<? extends T> hVar2) {
        return FlowKt__MigrationKt.r(hVar, hVar2);
    }

    @NotNull
    public static final <T1, T2, R> h<R> q2(@NotNull h<? extends T1> hVar, @NotNull h<? extends T2> hVar2, @NotNull d2.q<? super T1, ? super T2, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar) {
        return FlowKt__ZipKt.s(hVar, hVar2, qVar);
    }

    @BuilderInference
    @Nullable
    public static final <T> Object r0(@NotNull i<? super T> iVar, @NotNull h<? extends T> hVar, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        return FlowKt__CollectKt.g(iVar, hVar, cVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", imports = {}))
    @NotNull
    public static final <T> h<T> r1(@NotNull h<? extends T> hVar, @NotNull h<? extends T> hVar2) {
        return FlowKt__MigrationKt.s(hVar, hVar2);
    }

    @BuilderInference
    @Nullable
    private static final Object s0(@NotNull i iVar, @NotNull h hVar, @NotNull kotlin.coroutines.c cVar) {
        return FlowKt__CollectKt.g(iVar, hVar, cVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emit(fallback) }", imports = {}))
    @NotNull
    public static final <T> h<T> s1(@NotNull h<? extends T> hVar, T t3) {
        return FlowKt__MigrationKt.t(hVar, t3);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'cache()' is 'shareIn' with unlimited replay and 'started = SharingStared.Lazily' argument'", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, Int.MAX_VALUE, started = SharingStared.Lazily)", imports = {}))
    @NotNull
    public static final <T> h<T> t(@NotNull h<? extends T> hVar) {
        return FlowKt__MigrationKt.a(hVar);
    }

    @NotNull
    public static final <T> h<T> t0() {
        return FlowKt__BuildersKt.m();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith = @ReplaceWith(expression = "catch { e -> if (predicate(e)) emit(fallback) else throw e }", imports = {}))
    @NotNull
    public static final <T> h<T> t1(@NotNull h<? extends T> hVar, T t3, @NotNull d2.l<? super Throwable, Boolean> lVar) {
        return FlowKt__MigrationKt.u(hVar, t3, lVar);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T> h<T> u(@BuilderInference @NotNull d2.p<? super kotlinx.coroutines.channels.b0<? super T>, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar) {
        return FlowKt__BuildersKt.k(pVar);
    }

    @NotNull
    public static final <T> h<T> u0(@NotNull h<? extends T> hVar, @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar) {
        return FlowKt__TransformKt.a(hVar, pVar);
    }

    @NotNull
    public static final <T> h<T> v(@NotNull h<? extends T> hVar) {
        return n.e(hVar);
    }

    @NotNull
    public static final <T> h<T> v1(@NotNull h<? extends T> hVar, @NotNull d2.p<? super i<? super T>, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar) {
        return FlowKt__EmittersKt.d(hVar, pVar);
    }

    @NotNull
    public static final <T> h<T> w(@NotNull h<? extends T> hVar, @NotNull d2.q<? super i<? super T>, ? super Throwable, ? super kotlin.coroutines.c<? super f1>, ? extends Object> qVar) {
        return FlowKt__ErrorsKt.b(hVar, qVar);
    }

    @NotNull
    public static final <T> h<T> w0(@NotNull h<? extends T> hVar, @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar) {
        return FlowKt__TransformKt.c(hVar, pVar);
    }

    @NotNull
    public static final <T> x<T> w1(@NotNull x<? extends T> xVar, @NotNull d2.p<? super i<? super T>, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar) {
        return q.f(xVar, pVar);
    }

    @Nullable
    public static final <T> Object x(@NotNull h<? extends T> hVar, @NotNull i<? super T> iVar, @NotNull kotlin.coroutines.c<? super Throwable> cVar) {
        return FlowKt__ErrorsKt.c(hVar, iVar, cVar);
    }

    @NotNull
    public static final <T> h<T> x0(@NotNull h<? extends T> hVar) {
        return FlowKt__TransformKt.d(hVar);
    }

    @FlowPreview
    @NotNull
    public static final <T> kotlinx.coroutines.channels.d0<T> x1(@NotNull h<? extends T> hVar, @NotNull q0 q0Var) {
        return l.g(hVar, q0Var);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T> h<T> y(@BuilderInference @NotNull d2.p<? super kotlinx.coroutines.channels.b0<? super T>, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar) {
        return FlowKt__BuildersKt.l(pVar);
    }

    @Nullable
    public static final <T> Object y0(@NotNull h<? extends T> hVar, @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar, @NotNull kotlin.coroutines.c<? super T> cVar) {
        return FlowKt__ReduceKt.a(hVar, pVar, cVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish()' is 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, 0)", imports = {}))
    @NotNull
    public static final <T> h<T> y1(@NotNull h<? extends T> hVar) {
        return FlowKt__MigrationKt.w(hVar);
    }

    @Nullable
    public static final <T> Object z(@NotNull h<? extends T> hVar, @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        return FlowKt__CollectKt.a(hVar, pVar, cVar);
    }

    @Nullable
    public static final <T> Object z0(@NotNull h<? extends T> hVar, @NotNull kotlin.coroutines.c<? super T> cVar) {
        return FlowKt__ReduceKt.b(hVar, cVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish(bufferSize)' is 'buffer' followed by 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.buffer(bufferSize).shareIn(scope, 0)", imports = {}))
    @NotNull
    public static final <T> h<T> z1(@NotNull h<? extends T> hVar, int i4) {
        return FlowKt__MigrationKt.x(hVar, i4);
    }
}
