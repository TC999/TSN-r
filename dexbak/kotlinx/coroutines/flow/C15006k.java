package kotlinx.coroutines.flow;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.Inference;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.jvm.JvmName;
import kotlin.ranges.C14413k;
import kotlin.ranges.C14418n;
import kotlin.sequences.Sequence;
import kotlin.time.Duration;
import kotlin.time.ExperimentalTime;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.InterfaceC14686b0;
import kotlinx.coroutines.channels.InterfaceC14695d0;
import kotlinx.coroutines.channels.InterfaceC14704h0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;
import p617l1.InterfaceC15285q;
import p617l1.InterfaceC15286r;
import p617l1.InterfaceC15287s;
import p617l1.InterfaceC15288t;
import p617l1.InterfaceC15289u;

@Metadata(m12618bv = {}, m12617d1 = {"kotlinx/coroutines/flow/FlowKt__BuildersKt", "kotlinx/coroutines/flow/l", "kotlinx/coroutines/flow/FlowKt__CollectKt", "kotlinx/coroutines/flow/m", "kotlinx/coroutines/flow/n", "kotlinx/coroutines/flow/FlowKt__CountKt", "kotlinx/coroutines/flow/o", "kotlinx/coroutines/flow/p", "kotlinx/coroutines/flow/FlowKt__EmittersKt", "kotlinx/coroutines/flow/FlowKt__ErrorsKt", "kotlinx/coroutines/flow/FlowKt__LimitKt", "kotlinx/coroutines/flow/FlowKt__MergeKt", "kotlinx/coroutines/flow/FlowKt__MigrationKt", "kotlinx/coroutines/flow/FlowKt__ReduceKt", "kotlinx/coroutines/flow/q", "kotlinx/coroutines/flow/FlowKt__TransformKt", "kotlinx/coroutines/flow/FlowKt__ZipKt"}, m12616d2 = {}, m12615k = 4, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.k */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C15006k {
    @NotNull

    /* renamed from: a */
    public static final String f42867a = "kotlinx.coroutines.flow.defaultConcurrency";

    @Nullable
    /* renamed from: A */
    public static final <T> Object m4747A(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        return FlowKt__CollectKt.m5011b(interfaceC14958h, interfaceC15284p, interfaceC14268c);
    }

    @Nullable
    /* renamed from: A0 */
    public static final <T> Object m4746A0(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        return Reduce.m4902c(interfaceC14958h, interfaceC14268c);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    @NotNull
    /* renamed from: A1 */
    public static final <T> InterfaceC14958h<T> m4745A1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull CoroutineContext coroutineContext) {
        return Migration.m4908y(interfaceC14958h, coroutineContext);
    }

    @Nullable
    /* renamed from: B */
    private static final Object m4744B(@NotNull InterfaceC14958h interfaceC14958h, @NotNull InterfaceC15284p interfaceC15284p, @NotNull InterfaceC14268c interfaceC14268c) {
        return FlowKt__CollectKt.m5011b(interfaceC14958h, interfaceC15284p, interfaceC14268c);
    }

    @Nullable
    /* renamed from: B0 */
    public static final <T> Object m4743B0(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super Boolean>, ? extends Object> interfaceC15284p, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        return Reduce.m4901d(interfaceC14958h, interfaceC15284p, interfaceC14268c);
    }

    @NotNull
    /* renamed from: B1 */
    public static final <T> InterfaceC14958h<T> m4742B1(@NotNull InterfaceC14695d0<? extends T> interfaceC14695d0) {
        return C15008l.m4560h(interfaceC14695d0);
    }

    @Nullable
    /* renamed from: C */
    public static final <T> Object m4741C(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15285q<? super Integer, ? super T, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15285q, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        return FlowKt__CollectKt.m5009d(interfaceC14958h, interfaceC15285q, interfaceC14268c);
    }

    @NotNull
    /* renamed from: C0 */
    public static final InterfaceC14695d0<Unit> m4740C0(@NotNull CoroutineScope coroutineScope, long j, long j2) {
        return C15020o.m4538f(coroutineScope, j, j2);
    }

    @Nullable
    /* renamed from: C1 */
    public static final <S, T extends S> Object m4739C1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15285q<? super S, ? super T, ? super InterfaceC14268c<? super S>, ? extends Object> interfaceC15285q, @NotNull InterfaceC14268c<? super S> interfaceC14268c) {
        return Reduce.m4898g(interfaceC14958h, interfaceC15285q, interfaceC14268c);
    }

    @Nullable
    /* renamed from: D */
    private static final Object m4738D(@NotNull InterfaceC14958h interfaceC14958h, @NotNull InterfaceC15285q interfaceC15285q, @NotNull InterfaceC14268c interfaceC14268c) {
        return FlowKt__CollectKt.m5009d(interfaceC14958h, interfaceC15285q, interfaceC14268c);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay()' is 'shareIn' with unlimited replay. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, Int.MAX_VALUE)", imports = {}))
    @NotNull
    /* renamed from: D1 */
    public static final <T> InterfaceC14958h<T> m4736D1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h) {
        return Migration.m4907z(interfaceC14958h);
    }

    @Nullable
    /* renamed from: E */
    public static final <T> Object m4735E(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        return FlowKt__CollectKt.m5007f(interfaceC14958h, interfaceC15284p, interfaceC14268c);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue is 'flatMapConcat'", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", imports = {}))
    @NotNull
    /* renamed from: E0 */
    public static final <T, R> InterfaceC14958h<R> m4734E0(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super InterfaceC14958h<? extends R>>, ? extends Object> interfaceC15284p) {
        return Migration.m4921l(interfaceC14958h, interfaceC15284p);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay(bufferSize)' is 'shareIn' with the specified replay parameter. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, bufferSize)", imports = {}))
    @NotNull
    /* renamed from: E1 */
    public static final <T> InterfaceC14958h<T> m4733E1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, int i) {
        return Migration.m4943A(interfaceC14958h, i);
    }

    @Nullable
    /* renamed from: F */
    public static final <T> Object m4732F(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super Boolean>, ? extends Object> interfaceC15284p, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        return Limit.m4973a(interfaceC14958h, interfaceC15284p, interfaceC14268c);
    }

    @FlowPreview
    @NotNull
    /* renamed from: F0 */
    public static final <T, R> InterfaceC14958h<R> m4731F0(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super InterfaceC14958h<? extends R>>, ? extends Object> interfaceC15284p) {
        return Merge.m4964a(interfaceC14958h, interfaceC15284p);
    }

    @Nullable
    /* renamed from: G */
    private static final Object m4729G(@NotNull InterfaceC14958h interfaceC14958h, @NotNull InterfaceC15284p interfaceC15284p, @NotNull InterfaceC14268c interfaceC14268c) {
        return Limit.m4973a(interfaceC14958h, interfaceC15284p, interfaceC14268c);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    /* renamed from: G0 */
    public static final <T, R> InterfaceC14958h<R> m4728G0(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @Inference @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super InterfaceC14958h<? extends R>>, ? extends Object> interfaceC15284p) {
        return Merge.m4963b(interfaceC14958h, interfaceC15284p);
    }

    @NotNull
    /* renamed from: G1 */
    public static final <T> InterfaceC14958h<T> m4727G1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, long j, @NotNull InterfaceC15284p<? super Throwable, ? super InterfaceC14268c<? super Boolean>, ? extends Object> interfaceC15284p) {
        return FlowKt__ErrorsKt.m4982i(interfaceC14958h, j, interfaceC15284p);
    }

    @FlowPreview
    @NotNull
    /* renamed from: H0 */
    public static final <T, R> InterfaceC14958h<R> m4725H0(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, int i, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super InterfaceC14958h<? extends R>>, ? extends Object> interfaceC15284p) {
        return Merge.m4962c(interfaceC14958h, i, interfaceC15284p);
    }

    @NotNull
    /* renamed from: I */
    public static final <T1, T2, T3, T4, T5, R> InterfaceC14958h<R> m4723I(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @NotNull InterfaceC14958h<? extends T3> interfaceC14958h3, @NotNull InterfaceC14958h<? extends T4> interfaceC14958h4, @NotNull InterfaceC14958h<? extends T5> interfaceC14958h5, @NotNull InterfaceC15288t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15288t) {
        return Zip.m4856c(interfaceC14958h, interfaceC14958h2, interfaceC14958h3, interfaceC14958h4, interfaceC14958h5, interfaceC15288t);
    }

    @NotNull
    /* renamed from: J */
    public static final <T1, T2, T3, T4, R> InterfaceC14958h<R> m4720J(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @NotNull InterfaceC14958h<? extends T3> interfaceC14958h3, @NotNull InterfaceC14958h<? extends T4> interfaceC14958h4, @NotNull InterfaceC15287s<? super T1, ? super T2, ? super T3, ? super T4, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15287s) {
        return Zip.m4855d(interfaceC14958h, interfaceC14958h2, interfaceC14958h3, interfaceC14958h4, interfaceC15287s);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'flatten' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", imports = {}))
    @NotNull
    /* renamed from: J0 */
    public static final <T> InterfaceC14958h<T> m4719J0(@NotNull InterfaceC14958h<? extends InterfaceC14958h<? extends T>> interfaceC14958h) {
        return Migration.m4920m(interfaceC14958h);
    }

    @NotNull
    /* renamed from: J1 */
    public static final <T> InterfaceC14958h<T> m4718J1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15286r<? super FlowCollector<? super T>, ? super Throwable, ? super Long, ? super InterfaceC14268c<? super Boolean>, ? extends Object> interfaceC15286r) {
        return FlowKt__ErrorsKt.m4979l(interfaceC14958h, interfaceC15286r);
    }

    @NotNull
    /* renamed from: K */
    public static final <T1, T2, T3, R> InterfaceC14958h<R> m4717K(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @NotNull InterfaceC14958h<? extends T3> interfaceC14958h3, @Inference @NotNull InterfaceC15286r<? super T1, ? super T2, ? super T3, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15286r) {
        return Zip.m4854e(interfaceC14958h, interfaceC14958h2, interfaceC14958h3, interfaceC15286r);
    }

    @FlowPreview
    @NotNull
    /* renamed from: K0 */
    public static final <T> InterfaceC14958h<T> m4716K0(@NotNull InterfaceC14958h<? extends InterfaceC14958h<? extends T>> interfaceC14958h) {
        return Merge.m4960e(interfaceC14958h);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    /* renamed from: K1 */
    public static final <T> InterfaceC14958h<T> m4715K1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15285q<? super T, ? super T, ? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15285q) {
        return FlowKt__TransformKt.m4887h(interfaceC14958h, interfaceC15285q);
    }

    @NotNull
    /* renamed from: L */
    public static final <T1, T2, R> InterfaceC14958h<R> m4714L(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @NotNull InterfaceC15285q<? super T1, ? super T2, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15285q) {
        return Zip.m4853f(interfaceC14958h, interfaceC14958h2, interfaceC15285q);
    }

    @FlowPreview
    @NotNull
    /* renamed from: L0 */
    public static final <T> InterfaceC14958h<T> m4713L0(@NotNull InterfaceC14958h<? extends InterfaceC14958h<? extends T>> interfaceC14958h, int i) {
        return Merge.m4959f(interfaceC14958h, i);
    }

    @FlowPreview
    @NotNull
    /* renamed from: L1 */
    public static final <T> InterfaceC14958h<T> m4712L1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, long j) {
        return C15020o.m4536h(interfaceC14958h, j);
    }

    @FlowPreview
    @ExperimentalTime
    @NotNull
    /* renamed from: M1 */
    public static final <T> InterfaceC14958h<T> m4709M1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, double d) {
        return C15020o.m4535i(interfaceC14958h, d);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @NotNull
    /* renamed from: N */
    public static final <T1, T2, T3, T4, T5, R> InterfaceC14958h<R> m4708N(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @NotNull InterfaceC14958h<? extends T3> interfaceC14958h3, @NotNull InterfaceC14958h<? extends T4> interfaceC14958h4, @NotNull InterfaceC14958h<? extends T5> interfaceC14958h5, @NotNull InterfaceC15288t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15288t) {
        return Migration.m4931b(interfaceC14958h, interfaceC14958h2, interfaceC14958h3, interfaceC14958h4, interfaceC14958h5, interfaceC15288t);
    }

    @NotNull
    /* renamed from: N0 */
    public static final <T> InterfaceC14958h<T> m4707N0(@Inference @NotNull InterfaceC15284p<? super FlowCollector<? super T>, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        return FlowKt__BuildersKt.m5017n(interfaceC15284p);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    /* renamed from: N1 */
    public static final <T, R> InterfaceC14958h<R> m4706N1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, R r, @Inference @NotNull InterfaceC15285q<? super R, ? super T, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15285q) {
        return FlowKt__TransformKt.m4886i(interfaceC14958h, r, interfaceC15285q);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @NotNull
    /* renamed from: O */
    public static final <T1, T2, T3, T4, R> InterfaceC14958h<R> m4705O(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @NotNull InterfaceC14958h<? extends T3> interfaceC14958h3, @NotNull InterfaceC14958h<? extends T4> interfaceC14958h4, @NotNull InterfaceC15287s<? super T1, ? super T2, ? super T3, ? super T4, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15287s) {
        return Migration.m4930c(interfaceC14958h, interfaceC14958h2, interfaceC14958h3, interfaceC14958h4, interfaceC15287s);
    }

    @JvmName(name = "flowCombine")
    @NotNull
    /* renamed from: O0 */
    public static final <T1, T2, R> InterfaceC14958h<R> m4704O0(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @NotNull InterfaceC15285q<? super T1, ? super T2, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15285q) {
        return Zip.m4843p(interfaceC14958h, interfaceC14958h2, interfaceC15285q);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow has less verbose 'scan' shortcut", replaceWith = @ReplaceWith(expression = "scan(initial, operation)", imports = {}))
    @NotNull
    /* renamed from: O1 */
    public static final <T, R> InterfaceC14958h<R> m4703O1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, R r, @Inference @NotNull InterfaceC15285q<? super R, ? super T, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15285q) {
        return Migration.m4942B(interfaceC14958h, r, interfaceC15285q);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, transform)", imports = {}))
    @NotNull
    /* renamed from: P */
    public static final <T1, T2, T3, R> InterfaceC14958h<R> m4702P(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @NotNull InterfaceC14958h<? extends T3> interfaceC14958h3, @NotNull InterfaceC15286r<? super T1, ? super T2, ? super T3, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15286r) {
        return Migration.m4929d(interfaceC14958h, interfaceC14958h2, interfaceC14958h3, interfaceC15286r);
    }

    @JvmName(name = "flowCombineTransform")
    @NotNull
    /* renamed from: P0 */
    public static final <T1, T2, R> InterfaceC14958h<R> m4701P0(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @Inference @NotNull InterfaceC15286r<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15286r) {
        return Zip.m4842q(interfaceC14958h, interfaceC14958h2, interfaceC15286r);
    }

    @Annotations(level = DeprecationLevel.WARNING, message = "'scanReduce' was renamed to 'runningReduce' to be consistent with Kotlin standard library", replaceWith = @ReplaceWith(expression = "runningReduce(operation)", imports = {}))
    @NotNull
    /* renamed from: P1 */
    public static final <T> InterfaceC14958h<T> m4700P1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15285q<? super T, ? super T, ? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15285q) {
        return Migration.m4941C(interfaceC14958h, interfaceC15285q);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "this.combine(other, transform)", imports = {}))
    @NotNull
    /* renamed from: Q */
    public static final <T1, T2, R> InterfaceC14958h<R> m4699Q(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @NotNull InterfaceC15285q<? super T1, ? super T2, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15285q) {
        return Migration.m4928e(interfaceC14958h, interfaceC14958h2, interfaceC15285q);
    }

    @NotNull
    /* renamed from: Q0 */
    public static final <T> InterfaceC14958h<T> m4698Q0(T t) {
        return FlowKt__BuildersKt.m5016o(t);
    }

    @NotNull
    /* renamed from: Q1 */
    public static final <T> InterfaceC15048x<T> m4697Q1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull CoroutineScope coroutineScope, @NotNull InterfaceC14948d0 interfaceC14948d0, int i) {
        return C15037q.m4515g(interfaceC14958h, coroutineScope, interfaceC14948d0, i);
    }

    @NotNull
    /* renamed from: R0 */
    public static final <T> InterfaceC14958h<T> m4695R0(@NotNull T... tArr) {
        return FlowKt__BuildersKt.m5015p(tArr);
    }

    @NotNull
    /* renamed from: S */
    public static final <T1, T2, T3, T4, T5, R> InterfaceC14958h<R> m4693S(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @NotNull InterfaceC14958h<? extends T3> interfaceC14958h3, @NotNull InterfaceC14958h<? extends T4> interfaceC14958h4, @NotNull InterfaceC14958h<? extends T5> interfaceC14958h5, @Inference @NotNull InterfaceC15289u<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15289u) {
        return Zip.m4850i(interfaceC14958h, interfaceC14958h2, interfaceC14958h3, interfaceC14958h4, interfaceC14958h5, interfaceC15289u);
    }

    @NotNull
    /* renamed from: S0 */
    public static final <T> InterfaceC14958h<T> m4692S0(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull CoroutineContext coroutineContext) {
        return C15016n.m4546h(interfaceC14958h, coroutineContext);
    }

    @Nullable
    /* renamed from: S1 */
    public static final <T> Object m4691S1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        return Reduce.m4897h(interfaceC14958h, interfaceC14268c);
    }

    @NotNull
    /* renamed from: T */
    public static final <T1, T2, T3, T4, R> InterfaceC14958h<R> m4690T(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @NotNull InterfaceC14958h<? extends T3> interfaceC14958h3, @NotNull InterfaceC14958h<? extends T4> interfaceC14958h4, @Inference @NotNull InterfaceC15288t<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15288t) {
        return Zip.m4849j(interfaceC14958h, interfaceC14958h2, interfaceC14958h3, interfaceC14958h4, interfaceC15288t);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Use channelFlow with awaitClose { } instead of flowViaChannel and invokeOnClose { }.")
    @FlowPreview
    @NotNull
    /* renamed from: T0 */
    public static final <T> InterfaceC14958h<T> m4689T0(int i, @Inference @NotNull InterfaceC15284p<? super CoroutineScope, ? super InterfaceC14704h0<? super T>, Unit> interfaceC15284p) {
        return FlowKt__BuildersKt.m5014q(i, interfaceC15284p);
    }

    @Nullable
    /* renamed from: T1 */
    public static final <T> Object m4688T1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        return Reduce.m4896i(interfaceC14958h, interfaceC14268c);
    }

    @NotNull
    /* renamed from: U */
    public static final <T1, T2, T3, R> InterfaceC14958h<R> m4687U(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @NotNull InterfaceC14958h<? extends T3> interfaceC14958h3, @Inference @NotNull InterfaceC15287s<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15287s) {
        return Zip.m4848k(interfaceC14958h, interfaceC14958h2, interfaceC14958h3, interfaceC15287s);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'skip' is 'drop'", replaceWith = @ReplaceWith(expression = "drop(count)", imports = {}))
    @NotNull
    /* renamed from: U1 */
    public static final <T> InterfaceC14958h<T> m4685U1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, int i) {
        return Migration.m4940D(interfaceC14958h, i);
    }

    @NotNull
    /* renamed from: V */
    public static final <T1, T2, R> InterfaceC14958h<R> m4684V(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @Inference @NotNull InterfaceC15286r<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15286r) {
        return Zip.m4847l(interfaceC14958h, interfaceC14958h2, interfaceC15286r);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "flowWith is deprecated without replacement, please refer to its KDoc for an explanation")
    @FlowPreview
    @NotNull
    /* renamed from: V0 */
    public static final <T, R> InterfaceC14958h<R> m4683V0(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull CoroutineContext coroutineContext, int i, @NotNull InterfaceC15280l<? super InterfaceC14958h<? extends T>, ? extends InterfaceC14958h<? extends R>> interfaceC15280l) {
        return C15016n.m4545i(interfaceC14958h, coroutineContext, i, interfaceC15280l);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith = @ReplaceWith(expression = "onStart { emit(value) }", imports = {}))
    @NotNull
    /* renamed from: V1 */
    public static final <T> InterfaceC14958h<T> m4682V1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, T t) {
        return Migration.m4939E(interfaceC14958h, t);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onStart { emitAll(other) }", imports = {}))
    @NotNull
    /* renamed from: W1 */
    public static final <T> InterfaceC14958h<T> m4679W1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC14958h<? extends T> interfaceC14958h2) {
        return Migration.m4938F(interfaceC14958h, interfaceC14958h2);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'compose' is 'let'", replaceWith = @ReplaceWith(expression = "let(transformer)", imports = {}))
    @NotNull
    /* renamed from: X */
    public static final <T, R> InterfaceC14958h<R> m4678X(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15280l<? super InterfaceC14958h<? extends T>, ? extends InterfaceC14958h<? extends R>> interfaceC15280l) {
        return Migration.m4927f(interfaceC14958h, interfaceC15280l);
    }

    @Nullable
    /* renamed from: X0 */
    public static final <T, R> Object m4677X0(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, R r, @NotNull InterfaceC15285q<? super R, ? super T, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15285q, @NotNull InterfaceC14268c<? super R> interfaceC14268c) {
        return Reduce.m4900e(interfaceC14958h, r, interfaceC15285q, interfaceC14268c);
    }

    @Nullable
    /* renamed from: X1 */
    public static final <T> Object m4676X1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull CoroutineScope coroutineScope, @NotNull InterfaceC14268c<? super StateFlow<? extends T>> interfaceC14268c) {
        return C15037q.m4513i(interfaceC14958h, coroutineScope, interfaceC14268c);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", imports = {}))
    @NotNull
    /* renamed from: Y */
    public static final <T, R> InterfaceC14958h<R> m4675Y(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15280l<? super T, ? extends InterfaceC14958h<? extends R>> interfaceC15280l) {
        return Migration.m4926g(interfaceC14958h, interfaceC15280l);
    }

    @Nullable
    /* renamed from: Y0 */
    private static final Object m4674Y0(@NotNull InterfaceC14958h interfaceC14958h, Object obj, @NotNull InterfaceC15285q interfaceC15285q, @NotNull InterfaceC14268c interfaceC14268c) {
        return Reduce.m4900e(interfaceC14958h, obj, interfaceC15285q, interfaceC14268c);
    }

    @NotNull
    /* renamed from: Y1 */
    public static final <T> StateFlow<T> m4673Y1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull CoroutineScope coroutineScope, @NotNull InterfaceC14948d0 interfaceC14948d0, T t) {
        return C15037q.m4512j(interfaceC14958h, coroutineScope, interfaceC14948d0, t);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith = @ReplaceWith(expression = "onCompletion { emit(value) }", imports = {}))
    @NotNull
    /* renamed from: Z */
    public static final <T> InterfaceC14958h<T> m4672Z(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, T t) {
        return Migration.m4925h(interfaceC14958h, t);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'forEach' is 'collect'", replaceWith = @ReplaceWith(expression = "collect(block)", imports = {}))
    /* renamed from: Z0 */
    public static final <T> void m4671Z0(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        Migration.m4919n(interfaceC14958h, interfaceC15284p);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    /* renamed from: Z1 */
    public static final <T> void m4670Z1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h) {
        Migration.m4937G(interfaceC14958h);
    }

    @NotNull
    /* renamed from: a */
    public static final <T> InterfaceC14958h<T> m4669a(@NotNull Iterable<? extends T> iterable) {
        return FlowKt__BuildersKt.m5030a(iterable);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onCompletion { emitAll(other) }", imports = {}))
    @NotNull
    /* renamed from: a0 */
    public static final <T> InterfaceC14958h<T> m4668a0(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC14958h<? extends T> interfaceC14958h2) {
        return Migration.m4924i(interfaceC14958h, interfaceC14958h2);
    }

    /* renamed from: a1 */
    public static final int m4667a1() {
        return Merge.m4957h();
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    /* renamed from: a2 */
    public static final <T> void m4666a2(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        Migration.m4936H(interfaceC14958h, interfaceC15284p);
    }

    @NotNull
    /* renamed from: b */
    public static final <T> InterfaceC14958h<T> m4665b(@NotNull Iterator<? extends T> it) {
        return FlowKt__BuildersKt.m5029b(it);
    }

    @NotNull
    /* renamed from: b0 */
    public static final <T> InterfaceC14958h<T> m4664b0(@NotNull InterfaceC14958h<? extends T> interfaceC14958h) {
        return C15016n.m4547g(interfaceC14958h);
    }

    @FlowPreview
    /* renamed from: b1 */
    public static /* synthetic */ void m4663b1() {
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    /* renamed from: b2 */
    public static final <T> void m4662b2(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p, @NotNull InterfaceC15284p<? super Throwable, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p2) {
        Migration.m4935I(interfaceC14958h, interfaceC15284p, interfaceC15284p2);
    }

    @NotNull
    /* renamed from: c */
    public static final InterfaceC14958h<Integer> m4661c(@NotNull C14413k c14413k) {
        return FlowKt__BuildersKt.m5028c(c14413k);
    }

    @NotNull
    /* renamed from: c0 */
    public static final <T> InterfaceC14958h<T> m4660c0(@NotNull InterfaceC14695d0<? extends T> interfaceC14695d0) {
        return C15008l.m4564d(interfaceC14695d0);
    }

    @NotNull
    /* renamed from: c1 */
    public static final <T> Job m4659c1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull CoroutineScope coroutineScope) {
        return FlowKt__CollectKt.m5004i(interfaceC14958h, coroutineScope);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Use 'flowOn' instead")
    @NotNull
    /* renamed from: c2 */
    public static final <T> InterfaceC14958h<T> m4658c2(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull CoroutineContext coroutineContext) {
        return Migration.m4934J(interfaceC14958h, coroutineContext);
    }

    @NotNull
    /* renamed from: d */
    public static final InterfaceC14958h<Long> m4657d(@NotNull C14418n c14418n) {
        return FlowKt__BuildersKt.m5027d(c14418n);
    }

    @Nullable
    /* renamed from: d0 */
    public static final <T> Object m4656d0(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC14268c<? super Integer> interfaceC14268c) {
        return Count.m5001a(interfaceC14958h, interfaceC14268c);
    }

    @NotNull
    /* renamed from: d1 */
    public static final <T, R> InterfaceC14958h<R> m4655d1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
        return FlowKt__TransformKt.m4890e(interfaceC14958h, interfaceC15284p);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith = @ReplaceWith(expression = "this.flatMapLatest(transform)", imports = {}))
    @NotNull
    /* renamed from: d2 */
    public static final <T, R> InterfaceC14958h<R> m4654d2(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super InterfaceC14958h<? extends R>>, ? extends Object> interfaceC15284p) {
        return Migration.m4933K(interfaceC14958h, interfaceC15284p);
    }

    @NotNull
    /* renamed from: e */
    public static final <T> InterfaceC14958h<T> m4653e(@NotNull Sequence<? extends T> sequence) {
        return FlowKt__BuildersKt.m5026e(sequence);
    }

    @Nullable
    /* renamed from: e0 */
    public static final <T> Object m4652e0(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super Boolean>, ? extends Object> interfaceC15284p, @NotNull InterfaceC14268c<? super Integer> interfaceC14268c) {
        return Count.m5000b(interfaceC14958h, interfaceC15284p, interfaceC14268c);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    /* renamed from: e1 */
    public static final <T, R> InterfaceC14958h<R> m4651e1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @Inference @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
        return Merge.m4955j(interfaceC14958h, interfaceC15284p);
    }

    @NotNull
    /* renamed from: e2 */
    public static final <T> InterfaceC14958h<T> m4650e2(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, int i) {
        return Limit.m4968f(interfaceC14958h, i);
    }

    @FlowPreview
    @NotNull
    /* renamed from: f */
    public static final <T> InterfaceC14958h<T> m4649f(@NotNull BroadcastChannel<T> broadcastChannel) {
        return C15008l.m4567a(broadcastChannel);
    }

    @FlowPreview
    @NotNull
    /* renamed from: f0 */
    public static final <T> InterfaceC14958h<T> m4648f0(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, long j) {
        return C15020o.m4543a(interfaceC14958h, j);
    }

    @NotNull
    /* renamed from: f1 */
    public static final <T, R> InterfaceC14958h<R> m4647f1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
        return FlowKt__TransformKt.m4889f(interfaceC14958h, interfaceC15284p);
    }

    @NotNull
    /* renamed from: f2 */
    public static final <T> InterfaceC14958h<T> m4646f2(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super Boolean>, ? extends Object> interfaceC15284p) {
        return Limit.m4967g(interfaceC14958h, interfaceC15284p);
    }

    @FlowPreview
    @NotNull
    /* renamed from: g */
    public static final <T> InterfaceC14958h<T> m4645g(@NotNull InterfaceC15269a<? extends T> interfaceC15269a) {
        return FlowKt__BuildersKt.m5025f(interfaceC15269a);
    }

    @FlowPreview
    @OverloadResolutionByLambdaReturnType
    @NotNull
    /* renamed from: g0 */
    public static final <T> InterfaceC14958h<T> m4644g0(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15280l<? super T, Long> interfaceC15280l) {
        return C15020o.m4542b(interfaceC14958h, interfaceC15280l);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    /* renamed from: g1 */
    public static final <T> InterfaceC14958h<T> m4643g1(@NotNull Iterable<? extends InterfaceC14958h<? extends T>> iterable) {
        return Merge.m4954k(iterable);
    }

    @Nullable
    /* renamed from: g2 */
    public static final <T, C extends Collection<? super T>> Object m4642g2(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull C c, @NotNull InterfaceC14268c<? super C> interfaceC14268c) {
        return Collection.m4558a(interfaceC14958h, c, interfaceC14268c);
    }

    @FlowPreview
    @NotNull
    /* renamed from: h */
    public static final <T> InterfaceC14958h<T> m4641h(@NotNull InterfaceC15280l<? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15280l) {
        return FlowKt__BuildersKt.m5024g(interfaceC15280l);
    }

    @FlowPreview
    @ExperimentalTime
    @NotNull
    /* renamed from: h0 */
    public static final <T> InterfaceC14958h<T> m4640h0(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, double d) {
        return C15020o.m4541c(interfaceC14958h, d);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'merge' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", imports = {}))
    @NotNull
    /* renamed from: h1 */
    public static final <T> InterfaceC14958h<T> m4639h1(@NotNull InterfaceC14958h<? extends InterfaceC14958h<? extends T>> interfaceC14958h) {
        return Migration.m4918o(interfaceC14958h);
    }

    @Nullable
    /* renamed from: h2 */
    public static final <T> Object m4638h2(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull List<T> list, @NotNull InterfaceC14268c<? super List<? extends T>> interfaceC14268c) {
        return Collection.m4557b(interfaceC14958h, list, interfaceC14268c);
    }

    @NotNull
    /* renamed from: i */
    public static final InterfaceC14958h<Integer> m4637i(@NotNull int[] iArr) {
        return FlowKt__BuildersKt.m5023h(iArr);
    }

    @FlowPreview
    @JvmName(name = "debounceDuration")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    @ExperimentalTime
    /* renamed from: i0 */
    public static final <T> InterfaceC14958h<T> m4636i0(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15280l<? super T, Duration> interfaceC15280l) {
        return C15020o.m4540d(interfaceC14958h, interfaceC15280l);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    /* renamed from: i1 */
    public static final <T> InterfaceC14958h<T> m4635i1(@NotNull InterfaceC14958h<? extends T>... interfaceC14958hArr) {
        return Merge.m4953l(interfaceC14958hArr);
    }

    @NotNull
    /* renamed from: j */
    public static final InterfaceC14958h<Long> m4633j(@NotNull long[] jArr) {
        return FlowKt__BuildersKt.m5022i(jArr);
    }

    @Annotations(level = DeprecationLevel.WARNING, message = "Use 'onEach { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onEach { delay(timeMillis) }", imports = {}))
    @NotNull
    /* renamed from: j0 */
    public static final <T> InterfaceC14958h<T> m4632j0(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, long j) {
        return Migration.m4923j(interfaceC14958h, j);
    }

    @NotNull
    /* renamed from: j1 */
    public static final Void m4631j1() {
        return Migration.m4917p();
    }

    @Nullable
    /* renamed from: j2 */
    public static final <T> Object m4630j2(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull Set<T> set, @NotNull InterfaceC14268c<? super Set<? extends T>> interfaceC14268c) {
        return Collection.m4555d(interfaceC14958h, set, interfaceC14268c);
    }

    @NotNull
    /* renamed from: k */
    public static final <T> InterfaceC14958h<T> m4629k(@NotNull T[] tArr) {
        return FlowKt__BuildersKt.m5021j(tArr);
    }

    @Annotations(level = DeprecationLevel.WARNING, message = "Use 'onStart { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onStart { delay(timeMillis) }", imports = {}))
    @NotNull
    /* renamed from: k0 */
    public static final <T> InterfaceC14958h<T> m4628k0(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, long j) {
        return Migration.m4922k(interfaceC14958h, j);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    @NotNull
    /* renamed from: k1 */
    public static final <T> InterfaceC14958h<T> m4627k1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull CoroutineContext coroutineContext) {
        return Migration.m4916q(interfaceC14958h, coroutineContext);
    }

    @NotNull
    /* renamed from: l */
    public static final <T> InterfaceC15048x<T> m4625l(@NotNull InterfaceC15043s<T> interfaceC15043s) {
        return C15037q.m4521a(interfaceC15043s);
    }

    @NotNull
    /* renamed from: l0 */
    public static final <T> InterfaceC14958h<T> m4624l0(@NotNull InterfaceC14958h<? extends T> interfaceC14958h) {
        return C15034p.m4530a(interfaceC14958h);
    }

    @NotNull
    /* renamed from: l1 */
    public static final <T> InterfaceC14958h<T> m4623l1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15285q<? super FlowCollector<? super T>, ? super Throwable, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15285q) {
        return Emitters.m4998b(interfaceC14958h, interfaceC15285q);
    }

    @NotNull
    /* renamed from: l2 */
    public static final <T, R> InterfaceC14958h<R> m4622l2(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @Inference @NotNull InterfaceC15285q<? super FlowCollector<? super R>, ? super T, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15285q) {
        return Emitters.m4995e(interfaceC14958h, interfaceC15285q);
    }

    @NotNull
    /* renamed from: m */
    public static final <T> StateFlow<T> m4621m(@NotNull InterfaceC15044t<T> interfaceC15044t) {
        return C15037q.m4520b(interfaceC15044t);
    }

    @NotNull
    /* renamed from: m0 */
    public static final <T> InterfaceC14958h<T> m4620m0(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super T, Boolean> interfaceC15284p) {
        return C15034p.m4529b(interfaceC14958h, interfaceC15284p);
    }

    @NotNull
    /* renamed from: m1 */
    public static final <T> InterfaceC14958h<T> m4619m1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        return FlowKt__TransformKt.m4888g(interfaceC14958h, interfaceC15284p);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    /* renamed from: m2 */
    public static final <T, R> InterfaceC14958h<R> m4618m2(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @Inference @NotNull InterfaceC15285q<? super FlowCollector<? super R>, ? super T, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15285q) {
        return Merge.m4952m(interfaceC14958h, interfaceC15285q);
    }

    @Annotations(level = DeprecationLevel.WARNING, message = "Use shareIn operator and the resulting SharedFlow as a replacement for BroadcastChannel", replaceWith = @ReplaceWith(expression = "shareIn(scope, 0, SharingStarted.Lazily)", imports = {}))
    @NotNull
    /* renamed from: n */
    public static final <T> BroadcastChannel<T> m4617n(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull CoroutineScope coroutineScope, @NotNull CoroutineStart coroutineStart) {
        return C15008l.m4566b(interfaceC14958h, coroutineScope, coroutineStart);
    }

    @NotNull
    /* renamed from: n0 */
    public static final <T, K> InterfaceC14958h<T> m4616n0(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15280l<? super T, ? extends K> interfaceC15280l) {
        return C15034p.m4528c(interfaceC14958h, interfaceC15280l);
    }

    @NotNull
    /* renamed from: n1 */
    public static final <T> InterfaceC14958h<T> m4615n1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super FlowCollector<? super T>, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        return Emitters.m4997c(interfaceC14958h, interfaceC15284p);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    /* renamed from: n2 */
    public static final <T, R> InterfaceC14958h<R> m4614n2(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @Inference @NotNull InterfaceC15285q<? super FlowCollector<? super R>, ? super T, ? super InterfaceC14268c<? super Boolean>, ? extends Object> interfaceC15285q) {
        return Limit.m4966h(interfaceC14958h, interfaceC15285q);
    }

    @NotNull
    /* renamed from: o0 */
    public static final <T> InterfaceC14958h<T> m4612o0(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, int i) {
        return Limit.m4971c(interfaceC14958h, i);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Use catch { e -> if (predicate(e)) emitAll(fallback) else throw e }", replaceWith = @ReplaceWith(expression = "catch { e -> if (predicate(e)) emitAll(fallback) else throw e }", imports = {}))
    @NotNull
    /* renamed from: o1 */
    public static final <T> InterfaceC14958h<T> m4611o1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC14958h<? extends T> interfaceC14958h2, @NotNull InterfaceC15280l<? super Throwable, Boolean> interfaceC15280l) {
        return FlowKt__ErrorsKt.m4985f(interfaceC14958h, interfaceC14958h2, interfaceC15280l);
    }

    @PublishedApi
    @NotNull
    /* renamed from: o2 */
    public static final <T, R> InterfaceC14958h<R> m4610o2(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @Inference @NotNull InterfaceC15285q<? super FlowCollector<? super R>, ? super T, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15285q) {
        return Emitters.m4994f(interfaceC14958h, interfaceC15285q);
    }

    @NotNull
    /* renamed from: p0 */
    public static final <T> InterfaceC14958h<T> m4608p0(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super Boolean>, ? extends Object> interfaceC15284p) {
        return Limit.m4970d(interfaceC14958h, interfaceC15284p);
    }

    @NotNull
    /* renamed from: p2 */
    public static final <T> InterfaceC14958h<IndexedValue<T>> m4606p2(@NotNull InterfaceC14958h<? extends T> interfaceC14958h) {
        return FlowKt__TransformKt.m4885j(interfaceC14958h);
    }

    @NotNull
    /* renamed from: q */
    public static final <T> InterfaceC14958h<T> m4605q(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, int i, @NotNull BufferOverflow bufferOverflow) {
        return C15016n.m4552b(interfaceC14958h, i, bufferOverflow);
    }

    @Nullable
    /* renamed from: q0 */
    public static final <T> Object m4604q0(@NotNull FlowCollector<? super T> flowCollector, @NotNull InterfaceC14695d0<? extends T> interfaceC14695d0, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        return C15008l.m4563e(flowCollector, interfaceC14695d0, interfaceC14268c);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", imports = {}))
    @NotNull
    /* renamed from: q1 */
    public static final <T> InterfaceC14958h<T> m4603q1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC14958h<? extends T> interfaceC14958h2) {
        return Migration.m4915r(interfaceC14958h, interfaceC14958h2);
    }

    @NotNull
    /* renamed from: q2 */
    public static final <T1, T2, R> InterfaceC14958h<R> m4602q2(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @NotNull InterfaceC15285q<? super T1, ? super T2, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15285q) {
        return Zip.m4840s(interfaceC14958h, interfaceC14958h2, interfaceC15285q);
    }

    @Inference
    @Nullable
    /* renamed from: r0 */
    public static final <T> Object m4600r0(@NotNull FlowCollector<? super T> flowCollector, @NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        return FlowKt__CollectKt.m5006g(flowCollector, interfaceC14958h, interfaceC14268c);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", imports = {}))
    @NotNull
    /* renamed from: r1 */
    public static final <T> InterfaceC14958h<T> m4599r1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC14958h<? extends T> interfaceC14958h2) {
        return Migration.m4914s(interfaceC14958h, interfaceC14958h2);
    }

    @Inference
    @Nullable
    /* renamed from: s0 */
    private static final Object m4597s0(@NotNull FlowCollector flowCollector, @NotNull InterfaceC14958h interfaceC14958h, @NotNull InterfaceC14268c interfaceC14268c) {
        return FlowKt__CollectKt.m5006g(flowCollector, interfaceC14958h, interfaceC14268c);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emit(fallback) }", imports = {}))
    @NotNull
    /* renamed from: s1 */
    public static final <T> InterfaceC14958h<T> m4596s1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, T t) {
        return Migration.m4913t(interfaceC14958h, t);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'cache()' is 'shareIn' with unlimited replay and 'started = SharingStared.Lazily' argument'", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, Int.MAX_VALUE, started = SharingStared.Lazily)", imports = {}))
    @NotNull
    /* renamed from: t */
    public static final <T> InterfaceC14958h<T> m4595t(@NotNull InterfaceC14958h<? extends T> interfaceC14958h) {
        return Migration.m4932a(interfaceC14958h);
    }

    @NotNull
    /* renamed from: t0 */
    public static final <T> InterfaceC14958h<T> m4594t0() {
        return FlowKt__BuildersKt.m5018m();
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith = @ReplaceWith(expression = "catch { e -> if (predicate(e)) emit(fallback) else throw e }", imports = {}))
    @NotNull
    /* renamed from: t1 */
    public static final <T> InterfaceC14958h<T> m4593t1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, T t, @NotNull InterfaceC15280l<? super Throwable, Boolean> interfaceC15280l) {
        return Migration.m4912u(interfaceC14958h, t, interfaceC15280l);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    /* renamed from: u */
    public static final <T> InterfaceC14958h<T> m4592u(@Inference @NotNull InterfaceC15284p<? super InterfaceC14686b0<? super T>, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        return FlowKt__BuildersKt.m5020k(interfaceC15284p);
    }

    @NotNull
    /* renamed from: u0 */
    public static final <T> InterfaceC14958h<T> m4591u0(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super Boolean>, ? extends Object> interfaceC15284p) {
        return FlowKt__TransformKt.m4894a(interfaceC14958h, interfaceC15284p);
    }

    @NotNull
    /* renamed from: v */
    public static final <T> InterfaceC14958h<T> m4589v(@NotNull InterfaceC14958h<? extends T> interfaceC14958h) {
        return C15016n.m4549e(interfaceC14958h);
    }

    @NotNull
    /* renamed from: v1 */
    public static final <T> InterfaceC14958h<T> m4587v1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super FlowCollector<? super T>, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        return Emitters.m4996d(interfaceC14958h, interfaceC15284p);
    }

    @NotNull
    /* renamed from: w */
    public static final <T> InterfaceC14958h<T> m4586w(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15285q<? super FlowCollector<? super T>, ? super Throwable, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15285q) {
        return FlowKt__ErrorsKt.m4989b(interfaceC14958h, interfaceC15285q);
    }

    @NotNull
    /* renamed from: w0 */
    public static final <T> InterfaceC14958h<T> m4585w0(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super Boolean>, ? extends Object> interfaceC15284p) {
        return FlowKt__TransformKt.m4892c(interfaceC14958h, interfaceC15284p);
    }

    @NotNull
    /* renamed from: w1 */
    public static final <T> InterfaceC15048x<T> m4584w1(@NotNull InterfaceC15048x<? extends T> interfaceC15048x, @NotNull InterfaceC15284p<? super FlowCollector<? super T>, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        return C15037q.m4516f(interfaceC15048x, interfaceC15284p);
    }

    @Nullable
    /* renamed from: x */
    public static final <T> Object m4583x(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull FlowCollector<? super T> flowCollector, @NotNull InterfaceC14268c<? super Throwable> interfaceC14268c) {
        return FlowKt__ErrorsKt.m4988c(interfaceC14958h, flowCollector, interfaceC14268c);
    }

    @NotNull
    /* renamed from: x0 */
    public static final <T> InterfaceC14958h<T> m4582x0(@NotNull InterfaceC14958h<? extends T> interfaceC14958h) {
        return FlowKt__TransformKt.m4891d(interfaceC14958h);
    }

    @FlowPreview
    @NotNull
    /* renamed from: x1 */
    public static final <T> InterfaceC14695d0<T> m4581x1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull CoroutineScope coroutineScope) {
        return C15008l.m4561g(interfaceC14958h, coroutineScope);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    /* renamed from: y */
    public static final <T> InterfaceC14958h<T> m4580y(@Inference @NotNull InterfaceC15284p<? super InterfaceC14686b0<? super T>, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        return FlowKt__BuildersKt.m5019l(interfaceC15284p);
    }

    @Nullable
    /* renamed from: y0 */
    public static final <T> Object m4579y0(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        return Reduce.m4904a(interfaceC14958h, interfaceC14268c);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish()' is 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, 0)", imports = {}))
    @NotNull
    /* renamed from: y1 */
    public static final <T> InterfaceC14958h<T> m4578y1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h) {
        return Migration.m4910w(interfaceC14958h);
    }

    @Nullable
    /* renamed from: z */
    public static final Object m4577z(@NotNull InterfaceC14958h<?> interfaceC14958h, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        return FlowKt__CollectKt.m5012a(interfaceC14958h, interfaceC14268c);
    }

    @Nullable
    /* renamed from: z0 */
    public static final <T> Object m4576z0(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super Boolean>, ? extends Object> interfaceC15284p, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        return Reduce.m4903b(interfaceC14958h, interfaceC15284p, interfaceC14268c);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish(bufferSize)' is 'buffer' followed by 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.buffer(bufferSize).shareIn(scope, 0)", imports = {}))
    @NotNull
    /* renamed from: z1 */
    public static final <T> InterfaceC14958h<T> m4575z1(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, int i) {
        return Migration.m4909x(interfaceC14958h, i);
    }
}
