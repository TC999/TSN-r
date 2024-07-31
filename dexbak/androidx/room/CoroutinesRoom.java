package androidx.room;

import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.intrinsics.IntrinsicsJvm;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.C15057h;
import kotlinx.coroutines.C15111j;
import kotlinx.coroutines.C15153p;
import kotlinx.coroutines.C15247w1;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.C15006k;
import kotlinx.coroutines.flow.InterfaceC14958h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* compiled from: CoroutinesRoom.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m12616d2 = {"Landroidx/room/CoroutinesRoom;", "", "()V", "Companion", "room-ktx_release"}, m12615k = 1, m12614mv = {1, 4, 2})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class CoroutinesRoom {
    @NotNull
    public static final Companion Companion = new Companion(null);

    /* compiled from: CoroutinesRoom.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J7\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0087@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ?\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0087@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\rJL\u0010\u0013\u001a\r\u0012\t\u0012\u00078\u0000¢\u0006\u0002\b\u00120\u0011\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, m12616d2 = {"Landroidx/room/CoroutinesRoom$Companion;", "", "R", "Landroidx/room/RoomDatabase;", "db", "", "inTransaction", "Ljava/util/concurrent/Callable;", "callable", "execute", "(Landroidx/room/RoomDatabase;ZLjava/util/concurrent/Callable;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Landroid/os/CancellationSignal;", "cancellationSignal", "(Landroidx/room/RoomDatabase;ZLandroid/os/CancellationSignal;Ljava/util/concurrent/Callable;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "", "tableNames", "Lkotlinx/coroutines/flow/h;", "Lkotlin/jvm/JvmSuppressWildcards;", "createFlow", "(Landroidx/room/RoomDatabase;Z[Ljava/lang/String;Ljava/util/concurrent/Callable;)Lkotlinx/coroutines/flow/h;", "<init>", "()V", "room-ktx_release"}, m12615k = 1, m12614mv = {1, 4, 2})
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final <R> InterfaceC14958h<R> createFlow(@NotNull RoomDatabase db, boolean z, @NotNull String[] tableNames, @NotNull Callable<R> callable) {
            C14342f0.m8184p(db, "db");
            C14342f0.m8184p(tableNames, "tableNames");
            C14342f0.m8184p(callable, "callable");
            return C15006k.m4707N0(new CoroutinesRoom$Companion$createFlow$1(tableNames, z, db, callable, null));
        }

        @JvmStatic
        @Nullable
        public final <R> Object execute(@NotNull RoomDatabase roomDatabase, boolean z, @NotNull Callable<R> callable, @NotNull InterfaceC14268c<? super R> interfaceC14268c) {
            ContinuationInterceptor transactionDispatcher;
            if (roomDatabase.isOpen() && roomDatabase.inTransaction()) {
                return callable.call();
            }
            TransactionElement transactionElement = (TransactionElement) interfaceC14268c.getContext().get(TransactionElement.Key);
            if (transactionElement == null || (transactionDispatcher = transactionElement.getTransactionDispatcher$room_ktx_release()) == null) {
                transactionDispatcher = z ? CoroutinesRoomKt.getTransactionDispatcher(roomDatabase) : CoroutinesRoomKt.getQueryDispatcher(roomDatabase);
            }
            return C15057h.m4445i(transactionDispatcher, new CoroutinesRoom$Companion$execute$2(callable, null), interfaceC14268c);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final <R> Object execute(@NotNull RoomDatabase roomDatabase, boolean z, @NotNull final CancellationSignal cancellationSignal, @NotNull final Callable<R> callable, @NotNull InterfaceC14268c<? super R> interfaceC14268c) {
            final ContinuationInterceptor transactionDispatcher;
            InterfaceC14268c m8650d;
            final Job m4126f;
            Object m8642h;
            if (roomDatabase.isOpen() && roomDatabase.inTransaction()) {
                return callable.call();
            }
            TransactionElement transactionElement = (TransactionElement) interfaceC14268c.getContext().get(TransactionElement.Key);
            if (transactionElement == null || (transactionDispatcher = transactionElement.getTransactionDispatcher$room_ktx_release()) == null) {
                transactionDispatcher = z ? CoroutinesRoomKt.getTransactionDispatcher(roomDatabase) : CoroutinesRoomKt.getQueryDispatcher(roomDatabase);
            }
            m8650d = IntrinsicsJvm.m8650d(interfaceC14268c);
            C15153p c15153p = new C15153p(m8650d, 1);
            c15153p.mo3915J();
            m4126f = C15111j.m4126f(C15247w1.f43439a, transactionDispatcher, null, new C0711x67fef9d8(c15153p, null, transactionDispatcher, callable, cancellationSignal), 2, null);
            c15153p.mo3902e(new InterfaceC15280l<Throwable, Unit>() { // from class: androidx.room.CoroutinesRoom$Companion$execute$$inlined$suspendCancellableCoroutine$lambda$2
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
                    cancellationSignal.cancel();
                    Job.C14776a.m5047b(Job.this, null, 1, null);
                }
            });
            Object m3883y = c15153p.m3883y();
            m8642h = C14287b.m8642h();
            if (m3883y == m8642h) {
                DebugProbes.m8616c(interfaceC14268c);
            }
            return m3883y;
        }
    }

    private CoroutinesRoom() {
    }

    @JvmStatic
    @NotNull
    public static final <R> InterfaceC14958h<R> createFlow(@NotNull RoomDatabase roomDatabase, boolean z, @NotNull String[] strArr, @NotNull Callable<R> callable) {
        return Companion.createFlow(roomDatabase, z, strArr, callable);
    }

    @JvmStatic
    @Nullable
    public static final <R> Object execute(@NotNull RoomDatabase roomDatabase, boolean z, @NotNull CancellationSignal cancellationSignal, @NotNull Callable<R> callable, @NotNull InterfaceC14268c<? super R> interfaceC14268c) {
        return Companion.execute(roomDatabase, z, cancellationSignal, callable, interfaceC14268c);
    }

    @JvmStatic
    @Nullable
    public static final <R> Object execute(@NotNull RoomDatabase roomDatabase, boolean z, @NotNull Callable<R> callable, @NotNull InterfaceC14268c<? super R> interfaceC14268c) {
        return Companion.execute(roomDatabase, z, callable, interfaceC14268c);
    }
}
