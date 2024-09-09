package androidx.room;

import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlinx.coroutines.v1;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: CoroutinesRoom.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0006\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003\u00a8\u0006\u0007"}, d2 = {"Landroidx/room/RoomDatabase;", "Lkotlinx/coroutines/l0;", "getQueryDispatcher", "(Landroidx/room/RoomDatabase;)Lkotlinx/coroutines/l0;", "queryDispatcher", "getTransactionDispatcher", "transactionDispatcher", "room-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class CoroutinesRoomKt {
    @NotNull
    public static final kotlinx.coroutines.l0 getQueryDispatcher(@NotNull RoomDatabase queryDispatcher) {
        kotlin.jvm.internal.f0.p(queryDispatcher, "$this$queryDispatcher");
        Map<String, Object> backingFieldMap = queryDispatcher.getBackingFieldMap();
        kotlin.jvm.internal.f0.o(backingFieldMap, "backingFieldMap");
        Object obj = backingFieldMap.get("QueryDispatcher");
        if (obj == null) {
            Executor queryExecutor = queryDispatcher.getQueryExecutor();
            kotlin.jvm.internal.f0.o(queryExecutor, "queryExecutor");
            obj = v1.b(queryExecutor);
            backingFieldMap.put("QueryDispatcher", obj);
        }
        if (obj != null) {
            return (kotlinx.coroutines.l0) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
    }

    @NotNull
    public static final kotlinx.coroutines.l0 getTransactionDispatcher(@NotNull RoomDatabase transactionDispatcher) {
        kotlin.jvm.internal.f0.p(transactionDispatcher, "$this$transactionDispatcher");
        Map<String, Object> backingFieldMap = transactionDispatcher.getBackingFieldMap();
        kotlin.jvm.internal.f0.o(backingFieldMap, "backingFieldMap");
        Object obj = backingFieldMap.get("TransactionDispatcher");
        if (obj == null) {
            Executor transactionExecutor = transactionDispatcher.getTransactionExecutor();
            kotlin.jvm.internal.f0.o(transactionExecutor, "transactionExecutor");
            obj = v1.b(transactionExecutor);
            backingFieldMap.put("TransactionDispatcher", obj);
        }
        if (obj != null) {
            return (kotlinx.coroutines.l0) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
    }
}
