package androidx.room;

import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.C15242v1;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

/* compiled from: CoroutinesRoom.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0006\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003¨\u0006\u0007"}, m12616d2 = {"Landroidx/room/RoomDatabase;", "Lkotlinx/coroutines/l0;", "getQueryDispatcher", "(Landroidx/room/RoomDatabase;)Lkotlinx/coroutines/l0;", "queryDispatcher", "getTransactionDispatcher", "transactionDispatcher", "room-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 2})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class CoroutinesRoomKt {
    @NotNull
    public static final CoroutineDispatcher getQueryDispatcher(@NotNull RoomDatabase queryDispatcher) {
        C14342f0.m8184p(queryDispatcher, "$this$queryDispatcher");
        Map<String, Object> backingFieldMap = queryDispatcher.getBackingFieldMap();
        C14342f0.m8185o(backingFieldMap, "backingFieldMap");
        Object obj = backingFieldMap.get("QueryDispatcher");
        if (obj == null) {
            Executor queryExecutor = queryDispatcher.getQueryExecutor();
            C14342f0.m8185o(queryExecutor, "queryExecutor");
            obj = C15242v1.m3533b(queryExecutor);
            backingFieldMap.put("QueryDispatcher", obj);
        }
        if (obj != null) {
            return (CoroutineDispatcher) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
    }

    @NotNull
    public static final CoroutineDispatcher getTransactionDispatcher(@NotNull RoomDatabase transactionDispatcher) {
        C14342f0.m8184p(transactionDispatcher, "$this$transactionDispatcher");
        Map<String, Object> backingFieldMap = transactionDispatcher.getBackingFieldMap();
        C14342f0.m8185o(backingFieldMap, "backingFieldMap");
        Object obj = backingFieldMap.get("TransactionDispatcher");
        if (obj == null) {
            Executor transactionExecutor = transactionDispatcher.getTransactionExecutor();
            C14342f0.m8185o(transactionExecutor, "transactionExecutor");
            obj = C15242v1.m3533b(transactionExecutor);
            backingFieldMap.put("TransactionDispatcher", obj);
        }
        if (obj != null) {
            return (CoroutineDispatcher) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
    }
}
