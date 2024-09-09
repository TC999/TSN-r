package androidx.room;

import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.f1;
import kotlin.jvm.JvmStatic;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.w1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: CoroutinesRoom.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Landroidx/room/CoroutinesRoom;", "", "()V", "Companion", "room-ktx_release"}, k = 1, mv = {1, 4, 2})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class CoroutinesRoom {
    @NotNull
    public static final Companion Companion = new Companion(null);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: CoroutinesRoom.kt */
    @Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J7\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ?\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\rJL\u0010\u0013\u001a\r\u0012\t\u0012\u00078\u0000\u00a2\u0006\u0002\b\u00120\u0011\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Landroidx/room/CoroutinesRoom$Companion;", "", "R", "Landroidx/room/RoomDatabase;", "db", "", "inTransaction", "Ljava/util/concurrent/Callable;", "callable", "execute", "(Landroidx/room/RoomDatabase;ZLjava/util/concurrent/Callable;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Landroid/os/CancellationSignal;", "cancellationSignal", "(Landroidx/room/RoomDatabase;ZLandroid/os/CancellationSignal;Ljava/util/concurrent/Callable;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "", "tableNames", "Lkotlinx/coroutines/flow/h;", "Lkotlin/jvm/JvmSuppressWildcards;", "createFlow", "(Landroidx/room/RoomDatabase;Z[Ljava/lang/String;Ljava/util/concurrent/Callable;)Lkotlinx/coroutines/flow/h;", "<init>", "()V", "room-ktx_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final <R> kotlinx.coroutines.flow.h<R> createFlow(@NotNull RoomDatabase db, boolean z3, @NotNull String[] tableNames, @NotNull Callable<R> callable) {
            kotlin.jvm.internal.f0.p(db, "db");
            kotlin.jvm.internal.f0.p(tableNames, "tableNames");
            kotlin.jvm.internal.f0.p(callable, "callable");
            return kotlinx.coroutines.flow.k.N0(new CoroutinesRoom$Companion$createFlow$1(tableNames, z3, db, callable, null));
        }

        @JvmStatic
        @Nullable
        public final <R> Object execute(@NotNull RoomDatabase roomDatabase, boolean z3, @NotNull Callable<R> callable, @NotNull kotlin.coroutines.c<? super R> cVar) {
            kotlin.coroutines.d transactionDispatcher;
            if (roomDatabase.isOpen() && roomDatabase.inTransaction()) {
                return callable.call();
            }
            TransactionElement transactionElement = (TransactionElement) cVar.getContext().get(TransactionElement.Key);
            if (transactionElement == null || (transactionDispatcher = transactionElement.getTransactionDispatcher$room_ktx_release()) == null) {
                transactionDispatcher = z3 ? CoroutinesRoomKt.getTransactionDispatcher(roomDatabase) : CoroutinesRoomKt.getQueryDispatcher(roomDatabase);
            }
            return kotlinx.coroutines.h.i(transactionDispatcher, new CoroutinesRoom$Companion$execute$2(callable, null), cVar);
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.u uVar) {
            this();
        }

        @JvmStatic
        @Nullable
        public final <R> Object execute(@NotNull RoomDatabase roomDatabase, boolean z3, @NotNull final CancellationSignal cancellationSignal, @NotNull final Callable<R> callable, @NotNull kotlin.coroutines.c<? super R> cVar) {
            final kotlin.coroutines.d transactionDispatcher;
            kotlin.coroutines.c d4;
            final e2 f4;
            Object h4;
            if (roomDatabase.isOpen() && roomDatabase.inTransaction()) {
                return callable.call();
            }
            TransactionElement transactionElement = (TransactionElement) cVar.getContext().get(TransactionElement.Key);
            if (transactionElement == null || (transactionDispatcher = transactionElement.getTransactionDispatcher$room_ktx_release()) == null) {
                transactionDispatcher = z3 ? CoroutinesRoomKt.getTransactionDispatcher(roomDatabase) : CoroutinesRoomKt.getQueryDispatcher(roomDatabase);
            }
            d4 = IntrinsicsKt__IntrinsicsJvmKt.d(cVar);
            kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(d4, 1);
            pVar.H();
            f4 = kotlinx.coroutines.j.f(w1.f60756a, transactionDispatcher, null, new CoroutinesRoom$Companion$execute$$inlined$suspendCancellableCoroutine$lambda$1(pVar, null, transactionDispatcher, callable, cancellationSignal), 2, null);
            pVar.B(new d2.l<Throwable, f1>() { // from class: androidx.room.CoroutinesRoom$Companion$execute$$inlined$suspendCancellableCoroutine$lambda$2
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
                    cancellationSignal.cancel();
                    e2.a.b(e2.this, null, 1, null);
                }
            });
            Object y3 = pVar.y();
            h4 = kotlin.coroutines.intrinsics.b.h();
            if (y3 == h4) {
                kotlin.coroutines.jvm.internal.e.c(cVar);
            }
            return y3;
        }
    }

    private CoroutinesRoom() {
    }

    @JvmStatic
    @NotNull
    public static final <R> kotlinx.coroutines.flow.h<R> createFlow(@NotNull RoomDatabase roomDatabase, boolean z3, @NotNull String[] strArr, @NotNull Callable<R> callable) {
        return Companion.createFlow(roomDatabase, z3, strArr, callable);
    }

    @JvmStatic
    @Nullable
    public static final <R> Object execute(@NotNull RoomDatabase roomDatabase, boolean z3, @NotNull CancellationSignal cancellationSignal, @NotNull Callable<R> callable, @NotNull kotlin.coroutines.c<? super R> cVar) {
        return Companion.execute(roomDatabase, z3, cancellationSignal, callable, cVar);
    }

    @JvmStatic
    @Nullable
    public static final <R> Object execute(@NotNull RoomDatabase roomDatabase, boolean z3, @NotNull Callable<R> callable, @NotNull kotlin.coroutines.c<? super R> cVar) {
        return Companion.execute(roomDatabase, z3, callable, cVar);
    }
}
