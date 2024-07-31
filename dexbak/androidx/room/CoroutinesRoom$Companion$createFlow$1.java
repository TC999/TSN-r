package androidx.room;

import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.C15057h;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.C14728q;
import kotlinx.coroutines.channels.InterfaceC14722n;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: CoroutinesRoom.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u0010\u0012\f\u0012\n \u0002*\u0004\u0018\u00018\u00008\u00000\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {"R", "Lkotlinx/coroutines/flow/i;", "kotlin.jvm.PlatformType", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 2})
@DebugMetadata(m8639c = "androidx.room.CoroutinesRoom$Companion$createFlow$1", m8638f = "CoroutinesRoom.kt", m8637i = {}, m8636l = {116}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class CoroutinesRoom$Companion$createFlow$1<R> extends SuspendLambda implements InterfaceC15284p<FlowCollector<? super R>, InterfaceC14268c<? super Unit>, Object> {
    final /* synthetic */ Callable $callable;
    final /* synthetic */ RoomDatabase $db;
    final /* synthetic */ boolean $inTransaction;
    final /* synthetic */ String[] $tableNames;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CoroutinesRoom.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {"R", "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 2})
    @DebugMetadata(m8639c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1", m8638f = "CoroutinesRoom.kt", m8637i = {}, m8636l = {121, 123}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1 */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static final class C07131 extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef $flowContext;
        final /* synthetic */ Ref.ObjectRef $observer;
        final /* synthetic */ InterfaceC14722n $observerChannel;
        final /* synthetic */ FlowCollector $this_flow;
        Object L$0;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: CoroutinesRoom.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {"R", "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 2})
        @DebugMetadata(m8639c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1", m8638f = "CoroutinesRoom.kt", m8637i = {}, m8636l = {123}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
        /* renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1 */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        public static final class C07141 extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef $result;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C07141(Ref.ObjectRef objectRef, InterfaceC14268c interfaceC14268c) {
                super(2, interfaceC14268c);
                this.$result = objectRef;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> completion) {
                C14342f0.m8184p(completion, "completion");
                return new C07141(this.$result, completion);
            }

            @Override // p617l1.InterfaceC15284p
            public final Object invoke(CoroutineScope coroutineScope, InterfaceC14268c<? super Unit> interfaceC14268c) {
                return ((C07141) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object m8642h;
                m8642h = C14287b.m8642h();
                int i = this.label;
                if (i == 0) {
                    C14294d0.m8596n(obj);
                    FlowCollector flowCollector = C07131.this.$this_flow;
                    T t = this.$result.element;
                    this.label = 1;
                    if (flowCollector.emit(t, this) == m8642h) {
                        return m8642h;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    C14294d0.m8596n(obj);
                }
                return Unit.f41048a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07131(FlowCollector flowCollector, Ref.ObjectRef objectRef, InterfaceC14722n interfaceC14722n, Ref.ObjectRef objectRef2, InterfaceC14268c interfaceC14268c) {
            super(2, interfaceC14268c);
            this.$this_flow = flowCollector;
            this.$observer = objectRef;
            this.$observerChannel = interfaceC14722n;
            this.$flowContext = objectRef2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> completion) {
            C14342f0.m8184p(completion, "completion");
            return new C07131(this.$this_flow, this.$observer, this.$observerChannel, this.$flowContext, completion);
        }

        @Override // p617l1.InterfaceC15284p
        public final Object invoke(CoroutineScope coroutineScope, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C07131) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x004e A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x005a A[Catch: all -> 0x009c, TRY_LEAVE, TryCatch #0 {all -> 0x009c, blocks: (B:17:0x0044, B:21:0x0052, B:23:0x005a), top: B:36:0x0044 }] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0088  */
        /* JADX WARN: Type inference failed for: r5v2, types: [T, java.lang.Object] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0086 -> B:36:0x0044). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.C14286a.m8643h()
                int r1 = r9.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L29
                if (r1 == r3) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r1 = r9.L$0
                kotlinx.coroutines.channels.p r1 = (kotlinx.coroutines.channels.InterfaceC14725p) r1
                kotlin.C14294d0.m8596n(r10)     // Catch: java.lang.Throwable -> L9e
                r10 = r1
                goto L43
            L17:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L1f:
                java.lang.Object r1 = r9.L$0
                kotlinx.coroutines.channels.p r1 = (kotlinx.coroutines.channels.InterfaceC14725p) r1
                kotlin.C14294d0.m8596n(r10)     // Catch: java.lang.Throwable -> L9e
                r4 = r1
                r1 = r9
                goto L52
            L29:
                kotlin.C14294d0.m8596n(r10)
                androidx.room.CoroutinesRoom$Companion$createFlow$1 r10 = androidx.room.CoroutinesRoom$Companion$createFlow$1.this
                androidx.room.RoomDatabase r10 = r10.$db
                androidx.room.InvalidationTracker r10 = r10.getInvalidationTracker()
                kotlin.jvm.internal.Ref$ObjectRef r1 = r9.$observer
                T r1 = r1.element
                androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1 r1 = (androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1) r1
                r10.addObserver(r1)
                kotlinx.coroutines.channels.n r10 = r9.$observerChannel     // Catch: java.lang.Throwable -> L9e
                kotlinx.coroutines.channels.p r10 = r10.iterator()     // Catch: java.lang.Throwable -> L9e
            L43:
                r1 = r9
            L44:
                r1.L$0 = r10     // Catch: java.lang.Throwable -> L9c
                r1.label = r3     // Catch: java.lang.Throwable -> L9c
                java.lang.Object r4 = r10.mo5387b(r1)     // Catch: java.lang.Throwable -> L9c
                if (r4 != r0) goto L4f
                return r0
            L4f:
                r8 = r4
                r4 = r10
                r10 = r8
            L52:
                java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L9c
                boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L9c
                if (r10 == 0) goto L88
                java.lang.Object r10 = r4.next()     // Catch: java.lang.Throwable -> L9c
                kotlin.f1 r10 = (kotlin.Unit) r10     // Catch: java.lang.Throwable -> L9c
                kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch: java.lang.Throwable -> L9c
                r10.<init>()     // Catch: java.lang.Throwable -> L9c
                androidx.room.CoroutinesRoom$Companion$createFlow$1 r5 = androidx.room.CoroutinesRoom$Companion$createFlow$1.this     // Catch: java.lang.Throwable -> L9c
                java.util.concurrent.Callable r5 = r5.$callable     // Catch: java.lang.Throwable -> L9c
                java.lang.Object r5 = r5.call()     // Catch: java.lang.Throwable -> L9c
                r10.element = r5     // Catch: java.lang.Throwable -> L9c
                kotlin.jvm.internal.Ref$ObjectRef r5 = r1.$flowContext     // Catch: java.lang.Throwable -> L9c
                T r5 = r5.element     // Catch: java.lang.Throwable -> L9c
                kotlin.coroutines.f r5 = (kotlin.coroutines.CoroutineContext) r5     // Catch: java.lang.Throwable -> L9c
                androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1 r6 = new androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1     // Catch: java.lang.Throwable -> L9c
                r7 = 0
                r6.<init>(r10, r7)     // Catch: java.lang.Throwable -> L9c
                r1.L$0 = r4     // Catch: java.lang.Throwable -> L9c
                r1.label = r2     // Catch: java.lang.Throwable -> L9c
                java.lang.Object r10 = kotlinx.coroutines.C15057h.m4445i(r5, r6, r1)     // Catch: java.lang.Throwable -> L9c
                if (r10 != r0) goto L86
                return r0
            L86:
                r10 = r4
                goto L44
            L88:
                androidx.room.CoroutinesRoom$Companion$createFlow$1 r10 = androidx.room.CoroutinesRoom$Companion$createFlow$1.this
                androidx.room.RoomDatabase r10 = r10.$db
                androidx.room.InvalidationTracker r10 = r10.getInvalidationTracker()
                kotlin.jvm.internal.Ref$ObjectRef r0 = r1.$observer
                T r0 = r0.element
                androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1 r0 = (androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1) r0
                r10.removeObserver(r0)
                kotlin.f1 r10 = kotlin.Unit.f41048a
                return r10
            L9c:
                r10 = move-exception
                goto La0
            L9e:
                r10 = move-exception
                r1 = r9
            La0:
                androidx.room.CoroutinesRoom$Companion$createFlow$1 r0 = androidx.room.CoroutinesRoom$Companion$createFlow$1.this
                androidx.room.RoomDatabase r0 = r0.$db
                androidx.room.InvalidationTracker r0 = r0.getInvalidationTracker()
                kotlin.jvm.internal.Ref$ObjectRef r1 = r1.$observer
                T r1 = r1.element
                androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1 r1 = (androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1) r1
                r0.removeObserver(r1)
                goto Lb3
            Lb2:
                throw r10
            Lb3:
                goto Lb2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.CoroutinesRoom$Companion$createFlow$1.C07131.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutinesRoom$Companion$createFlow$1(String[] strArr, boolean z, RoomDatabase roomDatabase, Callable callable, InterfaceC14268c interfaceC14268c) {
        super(2, interfaceC14268c);
        this.$tableNames = strArr;
        this.$inTransaction = z;
        this.$db = roomDatabase;
        this.$callable = callable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> completion) {
        C14342f0.m8184p(completion, "completion");
        CoroutinesRoom$Companion$createFlow$1 coroutinesRoom$Companion$createFlow$1 = new CoroutinesRoom$Companion$createFlow$1(this.$tableNames, this.$inTransaction, this.$db, this.$callable, completion);
        coroutinesRoom$Companion$createFlow$1.L$0 = obj;
        return coroutinesRoom$Companion$createFlow$1;
    }

    @Override // p617l1.InterfaceC15284p
    public final Object invoke(Object obj, InterfaceC14268c<? super Unit> interfaceC14268c) {
        return ((CoroutinesRoom$Companion$createFlow$1) create(obj, interfaceC14268c)).invokeSuspend(Unit.f41048a);
    }

    /* JADX WARN: Type inference failed for: r11v3, types: [T, androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1] */
    /* JADX WARN: Type inference failed for: r11v5, types: [kotlin.coroutines.f, T] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object m8642h;
        ContinuationInterceptor transactionDispatcher;
        m8642h = C14287b.m8642h();
        int i = this.label;
        if (i == 0) {
            C14294d0.m8596n(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            final InterfaceC14722n m5382d = C14728q.m5382d(-1, null, null, 6, null);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            final String[] strArr = this.$tableNames;
            objectRef.element = new InvalidationTracker.Observer(strArr) { // from class: androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1
                @Override // androidx.room.InvalidationTracker.Observer
                public void onInvalidated(@NotNull Set<String> tables) {
                    C14342f0.m8184p(tables, "tables");
                    m5382d.offer(Unit.f41048a);
                }
            };
            m5382d.offer(Unit.f41048a);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = getContext();
            TransactionElement transactionElement = (TransactionElement) getContext().get(TransactionElement.Key);
            if (transactionElement == null || (transactionDispatcher = transactionElement.getTransactionDispatcher$room_ktx_release()) == null) {
                transactionDispatcher = this.$inTransaction ? CoroutinesRoomKt.getTransactionDispatcher(this.$db) : CoroutinesRoomKt.getQueryDispatcher(this.$db);
            }
            C07131 c07131 = new C07131(flowCollector, objectRef, m5382d, objectRef2, null);
            this.label = 1;
            if (C15057h.m4445i(transactionDispatcher, c07131, this) == m8642h) {
                return m8642h;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            C14294d0.m8596n(obj);
        }
        return Unit.f41048a;
    }
}
