package androidx.room;

import kotlin.Metadata;
import kotlin.coroutines.f;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: RoomDatabase.kt */
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"R", "Lkotlinx/coroutines/q0;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.room.RoomDatabaseKt$withTransaction$2", f = "RoomDatabase.kt", i = {0}, l = {58}, m = "invokeSuspend", n = {"transactionElement"}, s = {"L$0"})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class RoomDatabaseKt$withTransaction$2<R> extends SuspendLambda implements d2.p<kotlinx.coroutines.q0, kotlin.coroutines.c<? super R>, Object> {
    final /* synthetic */ d2.l $block;
    final /* synthetic */ RoomDatabase $this_withTransaction;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomDatabaseKt$withTransaction$2(RoomDatabase roomDatabase, d2.l lVar, kotlin.coroutines.c cVar) {
        super(2, cVar);
        this.$this_withTransaction = roomDatabase;
        this.$block = lVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> completion) {
        kotlin.jvm.internal.f0.p(completion, "completion");
        RoomDatabaseKt$withTransaction$2 roomDatabaseKt$withTransaction$2 = new RoomDatabaseKt$withTransaction$2(this.$this_withTransaction, this.$block, completion);
        roomDatabaseKt$withTransaction$2.L$0 = obj;
        return roomDatabaseKt$withTransaction$2;
    }

    @Override // d2.p
    public final Object invoke(kotlinx.coroutines.q0 q0Var, Object obj) {
        return ((RoomDatabaseKt$withTransaction$2) create(q0Var, (kotlin.coroutines.c) obj)).invokeSuspend(f1.f55527a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        TransactionElement h4;
        Throwable th;
        TransactionElement transactionElement;
        h4 = kotlin.coroutines.intrinsics.b.h();
        int i4 = this.label;
        try {
            if (i4 == 0) {
                kotlin.d0.n(obj);
                f.b bVar = ((kotlinx.coroutines.q0) this.L$0).getCoroutineContext().get(TransactionElement.Key);
                kotlin.jvm.internal.f0.m(bVar);
                TransactionElement transactionElement2 = (TransactionElement) bVar;
                transactionElement2.acquire();
                try {
                    this.$this_withTransaction.beginTransaction();
                    try {
                        d2.l lVar = this.$block;
                        this.L$0 = transactionElement2;
                        this.label = 1;
                        Object invoke = lVar.invoke(this);
                        if (invoke == h4) {
                            return h4;
                        }
                        transactionElement = transactionElement2;
                        obj = invoke;
                    } catch (Throwable th2) {
                        th = th2;
                        this.$this_withTransaction.endTransaction();
                        throw th;
                    }
                } catch (Throwable th3) {
                    h4 = transactionElement2;
                    th = th3;
                    h4.release();
                    throw th;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                transactionElement = (TransactionElement) this.L$0;
                try {
                    kotlin.d0.n(obj);
                } catch (Throwable th4) {
                    th = th4;
                    this.$this_withTransaction.endTransaction();
                    throw th;
                }
            }
            this.$this_withTransaction.setTransactionSuccessful();
            this.$this_withTransaction.endTransaction();
            transactionElement.release();
            return obj;
        } catch (Throwable th5) {
            th = th5;
        }
    }
}
