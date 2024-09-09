package androidx.room;

import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.f1;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: CoroutinesRoom.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u0010\u0012\f\u0012\n \u0002*\u0004\u0018\u00018\u00008\u00000\u0001H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"R", "Lkotlinx/coroutines/flow/i;", "kotlin.jvm.PlatformType", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1", f = "CoroutinesRoom.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class CoroutinesRoom$Companion$createFlow$1<R> extends SuspendLambda implements d2.p<kotlinx.coroutines.flow.i<? super R>, kotlin.coroutines.c<? super f1>, Object> {
    final /* synthetic */ Callable $callable;
    final /* synthetic */ RoomDatabase $db;
    final /* synthetic */ boolean $inTransaction;
    final /* synthetic */ String[] $tableNames;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: CoroutinesRoom.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"R", "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    @DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1", f = "CoroutinesRoom.kt", i = {}, l = {121, 123}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements d2.p<kotlinx.coroutines.q0, kotlin.coroutines.c<? super f1>, Object> {
        final /* synthetic */ Ref.ObjectRef $flowContext;
        final /* synthetic */ Ref.ObjectRef $observer;
        final /* synthetic */ kotlinx.coroutines.channels.n $observerChannel;
        final /* synthetic */ kotlinx.coroutines.flow.i $this_flow;
        Object L$0;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
        /* compiled from: CoroutinesRoom.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"R", "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        @DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1", f = "CoroutinesRoom.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public static final class C00131 extends SuspendLambda implements d2.p<kotlinx.coroutines.q0, kotlin.coroutines.c<? super f1>, Object> {
            final /* synthetic */ Ref.ObjectRef $result;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00131(Ref.ObjectRef objectRef, kotlin.coroutines.c cVar) {
                super(2, cVar);
                this.$result = objectRef;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> completion) {
                kotlin.jvm.internal.f0.p(completion, "completion");
                return new C00131(this.$result, completion);
            }

            @Override // d2.p
            public final Object invoke(kotlinx.coroutines.q0 q0Var, kotlin.coroutines.c<? super f1> cVar) {
                return ((C00131) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object h4;
                h4 = kotlin.coroutines.intrinsics.b.h();
                int i4 = this.label;
                if (i4 == 0) {
                    kotlin.d0.n(obj);
                    kotlinx.coroutines.flow.i iVar = AnonymousClass1.this.$this_flow;
                    Object obj2 = this.$result.element;
                    this.label = 1;
                    if (iVar.emit(obj2, this) == h4) {
                        return h4;
                    }
                } else if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    kotlin.d0.n(obj);
                }
                return f1.f55527a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(kotlinx.coroutines.flow.i iVar, Ref.ObjectRef objectRef, kotlinx.coroutines.channels.n nVar, Ref.ObjectRef objectRef2, kotlin.coroutines.c cVar) {
            super(2, cVar);
            this.$this_flow = iVar;
            this.$observer = objectRef;
            this.$observerChannel = nVar;
            this.$flowContext = objectRef2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> completion) {
            kotlin.jvm.internal.f0.p(completion, "completion");
            return new AnonymousClass1(this.$this_flow, this.$observer, this.$observerChannel, this.$flowContext, completion);
        }

        @Override // d2.p
        public final Object invoke(kotlinx.coroutines.q0 q0Var, kotlin.coroutines.c<? super f1> cVar) {
            return ((AnonymousClass1) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
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
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.h()
                int r1 = r9.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L29
                if (r1 == r3) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r1 = r9.L$0
                kotlinx.coroutines.channels.p r1 = (kotlinx.coroutines.channels.p) r1
                kotlin.d0.n(r10)     // Catch: java.lang.Throwable -> L9e
                r10 = r1
                goto L43
            L17:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L1f:
                java.lang.Object r1 = r9.L$0
                kotlinx.coroutines.channels.p r1 = (kotlinx.coroutines.channels.p) r1
                kotlin.d0.n(r10)     // Catch: java.lang.Throwable -> L9e
                r4 = r1
                r1 = r9
                goto L52
            L29:
                kotlin.d0.n(r10)
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
                java.lang.Object r4 = r10.b(r1)     // Catch: java.lang.Throwable -> L9c
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
                kotlin.f1 r10 = (kotlin.f1) r10     // Catch: java.lang.Throwable -> L9c
                kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch: java.lang.Throwable -> L9c
                r10.<init>()     // Catch: java.lang.Throwable -> L9c
                androidx.room.CoroutinesRoom$Companion$createFlow$1 r5 = androidx.room.CoroutinesRoom$Companion$createFlow$1.this     // Catch: java.lang.Throwable -> L9c
                java.util.concurrent.Callable r5 = r5.$callable     // Catch: java.lang.Throwable -> L9c
                java.lang.Object r5 = r5.call()     // Catch: java.lang.Throwable -> L9c
                r10.element = r5     // Catch: java.lang.Throwable -> L9c
                kotlin.jvm.internal.Ref$ObjectRef r5 = r1.$flowContext     // Catch: java.lang.Throwable -> L9c
                T r5 = r5.element     // Catch: java.lang.Throwable -> L9c
                kotlin.coroutines.f r5 = (kotlin.coroutines.f) r5     // Catch: java.lang.Throwable -> L9c
                androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1 r6 = new androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1     // Catch: java.lang.Throwable -> L9c
                r7 = 0
                r6.<init>(r10, r7)     // Catch: java.lang.Throwable -> L9c
                r1.L$0 = r4     // Catch: java.lang.Throwable -> L9c
                r1.label = r2     // Catch: java.lang.Throwable -> L9c
                java.lang.Object r10 = kotlinx.coroutines.h.i(r5, r6, r1)     // Catch: java.lang.Throwable -> L9c
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
                kotlin.f1 r10 = kotlin.f1.f55527a
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
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.CoroutinesRoom$Companion$createFlow$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutinesRoom$Companion$createFlow$1(String[] strArr, boolean z3, RoomDatabase roomDatabase, Callable callable, kotlin.coroutines.c cVar) {
        super(2, cVar);
        this.$tableNames = strArr;
        this.$inTransaction = z3;
        this.$db = roomDatabase;
        this.$callable = callable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> completion) {
        kotlin.jvm.internal.f0.p(completion, "completion");
        CoroutinesRoom$Companion$createFlow$1 coroutinesRoom$Companion$createFlow$1 = new CoroutinesRoom$Companion$createFlow$1(this.$tableNames, this.$inTransaction, this.$db, this.$callable, completion);
        coroutinesRoom$Companion$createFlow$1.L$0 = obj;
        return coroutinesRoom$Companion$createFlow$1;
    }

    @Override // d2.p
    public final Object invoke(Object obj, kotlin.coroutines.c<? super f1> cVar) {
        return ((CoroutinesRoom$Companion$createFlow$1) create(obj, cVar)).invokeSuspend(f1.f55527a);
    }

    /* JADX WARN: Type inference failed for: r11v3, types: [T, androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1] */
    /* JADX WARN: Type inference failed for: r11v5, types: [kotlin.coroutines.f, T] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object h4;
        kotlin.coroutines.d transactionDispatcher;
        h4 = kotlin.coroutines.intrinsics.b.h();
        int i4 = this.label;
        if (i4 == 0) {
            kotlin.d0.n(obj);
            kotlinx.coroutines.flow.i iVar = (kotlinx.coroutines.flow.i) this.L$0;
            final kotlinx.coroutines.channels.n d4 = kotlinx.coroutines.channels.q.d(-1, null, null, 6, null);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            final String[] strArr = this.$tableNames;
            objectRef.element = new InvalidationTracker.Observer(strArr) { // from class: androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1
                @Override // androidx.room.InvalidationTracker.Observer
                public void onInvalidated(@NotNull Set<String> tables) {
                    kotlin.jvm.internal.f0.p(tables, "tables");
                    d4.offer(f1.f55527a);
                }
            };
            d4.offer(f1.f55527a);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = getContext();
            TransactionElement transactionElement = (TransactionElement) getContext().get(TransactionElement.Key);
            if (transactionElement == null || (transactionDispatcher = transactionElement.getTransactionDispatcher$room_ktx_release()) == null) {
                transactionDispatcher = this.$inTransaction ? CoroutinesRoomKt.getTransactionDispatcher(this.$db) : CoroutinesRoomKt.getQueryDispatcher(this.$db);
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(iVar, objectRef, d4, objectRef2, null);
            this.label = 1;
            if (kotlinx.coroutines.h.i(transactionDispatcher, anonymousClass1, this) == h4) {
                return h4;
            }
        } else if (i4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            kotlin.d0.n(obj);
        }
        return f1.f55527a;
    }
}
