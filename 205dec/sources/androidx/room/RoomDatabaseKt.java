package androidx.room;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.f;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.f1;
import kotlinx.coroutines.e2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: RoomDatabase.kt */
@Metadata(bv = {}, d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u001c\u0010\u0005\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\t\u001a\u00020\b*\u00020\u0001H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\u000f\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\r\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"R", "Landroidx/room/RoomDatabase;", "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "", "block", "withTransaction", "(Landroidx/room/RoomDatabase;Ld2/l;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/coroutines/f;", "createTransactionContext", "(Landroidx/room/RoomDatabase;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Ljava/util/concurrent/Executor;", "Lkotlinx/coroutines/e2;", "controlJob", "Lkotlin/coroutines/d;", "acquireTransactionThread", "(Ljava/util/concurrent/Executor;Lkotlinx/coroutines/e2;Lkotlin/coroutines/c;)Ljava/lang/Object;", "room-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class RoomDatabaseKt {
    static final /* synthetic */ Object acquireTransactionThread(final Executor executor, final e2 e2Var, kotlin.coroutines.c<? super kotlin.coroutines.d> cVar) {
        kotlin.coroutines.c d4;
        Object h4;
        d4 = IntrinsicsKt__IntrinsicsJvmKt.d(cVar);
        final kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(d4, 1);
        pVar.H();
        pVar.B(new d2.l<Throwable, f1>() { // from class: androidx.room.RoomDatabaseKt$acquireTransactionThread$$inlined$suspendCancellableCoroutine$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // d2.l
            public /* bridge */ /* synthetic */ f1 invoke(Throwable th) {
                invoke2(th);
                return f1.f55527a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th) {
                e2.a.b(e2Var, null, 1, null);
            }
        });
        try {
            executor.execute(new Runnable() { // from class: androidx.room.RoomDatabaseKt$acquireTransactionThread$$inlined$suspendCancellableCoroutine$lambda$2

                /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
                /* compiled from: RoomDatabase.kt */
                @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "androidx/room/RoomDatabaseKt$acquireTransactionThread$2$2$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
                @DebugMetadata(c = "androidx.room.RoomDatabaseKt$acquireTransactionThread$2$2$1", f = "RoomDatabase.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.room.RoomDatabaseKt$acquireTransactionThread$$inlined$suspendCancellableCoroutine$lambda$2$1  reason: invalid class name */
                /* loaded from: E:\TSN-r\205dec\6329136.dex */
                static final class AnonymousClass1 extends SuspendLambda implements d2.p<kotlinx.coroutines.q0, kotlin.coroutines.c<? super f1>, Object> {
                    private /* synthetic */ Object L$0;
                    int label;

                    AnonymousClass1(kotlin.coroutines.c cVar) {
                        super(2, cVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @NotNull
                    public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> completion) {
                        kotlin.jvm.internal.f0.p(completion, "completion");
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(completion);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // d2.p
                    public final Object invoke(kotlinx.coroutines.q0 q0Var, kotlin.coroutines.c<? super f1> cVar) {
                        return ((AnonymousClass1) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        Object h4;
                        h4 = kotlin.coroutines.intrinsics.b.h();
                        int i4 = this.label;
                        if (i4 == 0) {
                            kotlin.d0.n(obj);
                            kotlinx.coroutines.o oVar = kotlinx.coroutines.o.this;
                            f.b bVar = ((kotlinx.coroutines.q0) this.L$0).getCoroutineContext().get(kotlin.coroutines.d.f55503f0);
                            kotlin.jvm.internal.f0.m(bVar);
                            Result.a aVar = Result.Companion;
                            oVar.resumeWith(Result.m119constructorimpl(bVar));
                            e2 e2Var = e2Var;
                            this.label = 1;
                            if (e2Var.A(this) == h4) {
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

                @Override // java.lang.Runnable
                public final void run() {
                    kotlinx.coroutines.i.b(null, new AnonymousClass1(null), 1, null);
                }
            });
        } catch (RejectedExecutionException e4) {
            pVar.a(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e4));
        }
        Object y3 = pVar.y();
        h4 = kotlin.coroutines.intrinsics.b.h();
        if (y3 == h4) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return y3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object createTransactionContext(androidx.room.RoomDatabase r6, kotlin.coroutines.c<? super kotlin.coroutines.f> r7) {
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
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r6 = r0.L$1
            kotlinx.coroutines.b0 r6 = (kotlinx.coroutines.b0) r6
            java.lang.Object r0 = r0.L$0
            androidx.room.RoomDatabase r0 = (androidx.room.RoomDatabase) r0
            kotlin.d0.n(r7)
            goto L72
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            kotlin.d0.n(r7)
            r7 = 0
            kotlinx.coroutines.b0 r7 = kotlinx.coroutines.h2.d(r7, r3, r7)
            kotlin.coroutines.f r2 = r0.getContext()
            kotlinx.coroutines.e2$b r4 = kotlinx.coroutines.e2.f59626i0
            kotlin.coroutines.f$b r2 = r2.get(r4)
            kotlinx.coroutines.e2 r2 = (kotlinx.coroutines.e2) r2
            if (r2 == 0) goto L57
            androidx.room.RoomDatabaseKt$createTransactionContext$2 r4 = new androidx.room.RoomDatabaseKt$createTransactionContext$2
            r4.<init>()
            r2.m(r4)
        L57:
            java.util.concurrent.Executor r2 = r6.getTransactionExecutor()
            java.lang.String r4 = "transactionExecutor"
            kotlin.jvm.internal.f0.o(r2, r4)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r0 = acquireTransactionThread(r2, r7, r0)
            if (r0 != r1) goto L6e
            return r1
        L6e:
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r5
        L72:
            kotlin.coroutines.d r7 = (kotlin.coroutines.d) r7
            androidx.room.TransactionElement r1 = new androidx.room.TransactionElement
            r1.<init>(r6, r7)
            java.lang.ThreadLocal r0 = r0.getSuspendingTransactionId()
            java.lang.String r2 = "suspendingTransactionId"
            kotlin.jvm.internal.f0.o(r0, r2)
            int r6 = java.lang.System.identityHashCode(r6)
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.a.f(r6)
            kotlinx.coroutines.i3 r6 = kotlinx.coroutines.j3.a(r0, r6)
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
    public static final <R> java.lang.Object withTransaction(@org.jetbrains.annotations.NotNull androidx.room.RoomDatabase r5, @org.jetbrains.annotations.NotNull d2.l<? super kotlin.coroutines.c<? super R>, ? extends java.lang.Object> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super R> r7) {
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
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.d0.n(r7)
            goto L7b
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.L$1
            r6 = r5
            d2.l r6 = (d2.l) r6
            java.lang.Object r5 = r0.L$0
            androidx.room.RoomDatabase r5 = (androidx.room.RoomDatabase) r5
            kotlin.d0.n(r7)
            goto L66
        L41:
            kotlin.d0.n(r7)
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
            kotlin.coroutines.f r7 = (kotlin.coroutines.f) r7
        L68:
            androidx.room.RoomDatabaseKt$withTransaction$2 r2 = new androidx.room.RoomDatabaseKt$withTransaction$2
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.L$0 = r4
            r0.L$1 = r4
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.h.i(r7, r2, r0)
            if (r7 != r1) goto L7b
            return r1
        L7b:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabaseKt.withTransaction(androidx.room.RoomDatabase, d2.l, kotlin.coroutines.c):java.lang.Object");
    }
}
