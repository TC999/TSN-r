package androidx.room;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.intrinsics.IntrinsicsJvm;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.C15062i;
import kotlinx.coroutines.C15153p;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.InterfaceC15146o;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

/* compiled from: RoomDatabase.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u001c\u0010\u0005\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\t\u001a\u00020\b*\u00020\u0001H\u0082@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\u000f\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\r\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, m12616d2 = {"R", "Landroidx/room/RoomDatabase;", "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "", "block", "withTransaction", "(Landroidx/room/RoomDatabase;Ll1/l;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/coroutines/f;", "createTransactionContext", "(Landroidx/room/RoomDatabase;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Ljava/util/concurrent/Executor;", "Lkotlinx/coroutines/e2;", "controlJob", "Lkotlin/coroutines/d;", "acquireTransactionThread", "(Ljava/util/concurrent/Executor;Lkotlinx/coroutines/e2;Lkotlin/coroutines/c;)Ljava/lang/Object;", "room-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 2})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class RoomDatabaseKt {
    static final /* synthetic */ Object acquireTransactionThread(final Executor executor, final Job job, InterfaceC14268c<? super ContinuationInterceptor> interfaceC14268c) {
        InterfaceC14268c m8650d;
        Object m8642h;
        m8650d = IntrinsicsJvm.m8650d(interfaceC14268c);
        final C15153p c15153p = new C15153p(m8650d, 1);
        c15153p.mo3915J();
        c15153p.mo3902e(new InterfaceC15280l<Throwable, Unit>() { // from class: androidx.room.RoomDatabaseKt$acquireTransactionThread$$inlined$suspendCancellableCoroutine$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // p617l1.InterfaceC15280l
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f41048a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th) {
                Job.C14776a.m5047b(job, null, 1, null);
            }
        });
        try {
            executor.execute(new Runnable() { // from class: androidx.room.RoomDatabaseKt$acquireTransactionThread$$inlined$suspendCancellableCoroutine$lambda$2

                /* compiled from: RoomDatabase.kt */
                @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m12616d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "androidx/room/RoomDatabaseKt$acquireTransactionThread$2$2$1", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 2})
                @DebugMetadata(m8639c = "androidx.room.RoomDatabaseKt$acquireTransactionThread$2$2$1", m8638f = "RoomDatabase.kt", m8637i = {}, m8636l = {124}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
                /* renamed from: androidx.room.RoomDatabaseKt$acquireTransactionThread$$inlined$suspendCancellableCoroutine$lambda$2$1 */
                /* loaded from: E:\fuckcool\tsn\6276784.dex */
                static final class C07271 extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {
                    private /* synthetic */ Object L$0;
                    int label;

                    C07271(InterfaceC14268c interfaceC14268c) {
                        super(2, interfaceC14268c);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @NotNull
                    public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> completion) {
                        C14342f0.m8184p(completion, "completion");
                        C07271 c07271 = new C07271(completion);
                        c07271.L$0 = obj;
                        return c07271;
                    }

                    @Override // p617l1.InterfaceC15284p
                    public final Object invoke(CoroutineScope coroutineScope, InterfaceC14268c<? super Unit> interfaceC14268c) {
                        return ((C07271) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        Object m8642h;
                        m8642h = C14287b.m8642h();
                        int i = this.label;
                        if (i == 0) {
                            C14294d0.m8596n(obj);
                            InterfaceC15146o interfaceC15146o = InterfaceC15146o.this;
                            CoroutineContext.InterfaceC14275b interfaceC14275b = ((CoroutineScope) this.L$0).getCoroutineContext().get(ContinuationInterceptor.f41024k0);
                            C14342f0.m8187m(interfaceC14275b);
                            Result.C14124a c14124a = Result.Companion;
                            interfaceC15146o.resumeWith(Result.m60148constructorimpl(interfaceC14275b));
                            Job job = job;
                            this.label = 1;
                            if (job.mo3831E(this) == m8642h) {
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

                @Override // java.lang.Runnable
                public final void run() {
                    C15062i.m4407b(null, new C07271(null), 1, null);
                }
            });
        } catch (RejectedExecutionException e) {
            c15153p.mo3905a(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e));
        }
        Object m3883y = c15153p.m3883y();
        m8642h = C14287b.m8642h();
        if (m3883y == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        return m3883y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object createTransactionContext(androidx.room.RoomDatabase r6, kotlin.coroutines.InterfaceC14268c<? super kotlin.coroutines.CoroutineContext> r7) {
        /*
            boolean r0 = r7 instanceof androidx.room.RoomDatabaseKt$createTransactionContext$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.room.RoomDatabaseKt$createTransactionContext$1 r0 = (androidx.room.RoomDatabaseKt$createTransactionContext$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.RoomDatabaseKt$createTransactionContext$1 r0 = new androidx.room.RoomDatabaseKt$createTransactionContext$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r6 = r0.L$1
            kotlinx.coroutines.b0 r6 = (kotlinx.coroutines.CompletableJob) r6
            java.lang.Object r0 = r0.L$0
            androidx.room.RoomDatabase r0 = (androidx.room.RoomDatabase) r0
            kotlin.C14294d0.m8596n(r7)
            goto L71
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            kotlin.C14294d0.m8596n(r7)
            r7 = 0
            kotlinx.coroutines.b0 r7 = kotlinx.coroutines.C15060h2.m4436d(r7, r3, r7)
            kotlin.coroutines.f r2 = r0.getContext()
            kotlinx.coroutines.e2$b r4 = kotlinx.coroutines.Job.f42281m0
            kotlin.coroutines.f$b r2 = r2.get(r4)
            kotlinx.coroutines.e2 r2 = (kotlinx.coroutines.Job) r2
            if (r2 == 0) goto L57
            androidx.room.RoomDatabaseKt$createTransactionContext$2 r4 = new androidx.room.RoomDatabaseKt$createTransactionContext$2
            r4.<init>()
            r2.mo3818w(r4)
        L57:
            java.util.concurrent.Executor r2 = r6.getTransactionExecutor()
            java.lang.String r4 = "transactionExecutor"
            kotlin.jvm.internal.C14342f0.m8185o(r2, r4)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r0 = acquireTransactionThread(r2, r7, r0)
            if (r0 != r1) goto L6d
            return r1
        L6d:
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r5
        L71:
            kotlin.coroutines.d r7 = (kotlin.coroutines.ContinuationInterceptor) r7
            androidx.room.TransactionElement r1 = new androidx.room.TransactionElement
            r1.<init>(r6, r7)
            java.lang.ThreadLocal r0 = r0.getSuspendingTransactionId()
            java.lang.String r2 = "suspendingTransactionId"
            kotlin.jvm.internal.C14342f0.m8185o(r0, r2)
            int r6 = java.lang.System.identityHashCode(r6)
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.boxing.m8626f(r6)
            kotlinx.coroutines.i3 r6 = kotlinx.coroutines.C15115j3.m4095a(r0, r6)
            kotlin.coroutines.f r7 = r7.plus(r1)
            kotlin.coroutines.f r6 = r7.plus(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabaseKt.createTransactionContext(androidx.room.RoomDatabase, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007b A[PHI: r7 
      PHI: (r7v11 java.lang.Object) = (r7v8 java.lang.Object), (r7v1 java.lang.Object) binds: [B:26:0x0078, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <R> java.lang.Object withTransaction(@org.jetbrains.annotations.NotNull androidx.room.RoomDatabase r5, @org.jetbrains.annotations.NotNull p617l1.InterfaceC15280l<? super kotlin.coroutines.InterfaceC14268c<? super R>, ? extends java.lang.Object> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super R> r7) {
        /*
            boolean r0 = r7 instanceof androidx.room.RoomDatabaseKt$withTransaction$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.room.RoomDatabaseKt$withTransaction$1 r0 = (androidx.room.RoomDatabaseKt$withTransaction$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.RoomDatabaseKt$withTransaction$1 r0 = new androidx.room.RoomDatabaseKt$withTransaction$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.C14294d0.m8596n(r7)
            goto L7b
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.L$1
            r6 = r5
            l1.l r6 = (p617l1.InterfaceC15280l) r6
            java.lang.Object r5 = r0.L$0
            androidx.room.RoomDatabase r5 = (androidx.room.RoomDatabase) r5
            kotlin.C14294d0.m8596n(r7)
            goto L66
        L41:
            kotlin.C14294d0.m8596n(r7)
            kotlin.coroutines.f r7 = r0.getContext()
            androidx.room.TransactionElement$Key r2 = androidx.room.TransactionElement.Key
            kotlin.coroutines.f$b r7 = r7.get(r2)
            androidx.room.TransactionElement r7 = (androidx.room.TransactionElement) r7
            if (r7 == 0) goto L59
            kotlin.coroutines.d r7 = r7.getTransactionDispatcher$room_ktx_release()
            if (r7 == 0) goto L59
            goto L68
        L59:
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = createTransactionContext(r5, r0)
            if (r7 != r1) goto L66
            return r1
        L66:
            kotlin.coroutines.f r7 = (kotlin.coroutines.CoroutineContext) r7
        L68:
            androidx.room.RoomDatabaseKt$withTransaction$2 r2 = new androidx.room.RoomDatabaseKt$withTransaction$2
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.L$0 = r4
            r0.L$1 = r4
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.C15057h.m4445i(r7, r2, r0)
            if (r7 != r1) goto L7b
            return r1
        L7b:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabaseKt.withTransaction(androidx.room.RoomDatabase, l1.l, kotlin.coroutines.c):java.lang.Object");
    }
}
