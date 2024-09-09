package androidx.room;

import androidx.annotation.RestrictTo;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.coroutines.f;
import kotlinx.coroutines.e2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: RoomDatabase.kt */
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\u00020\u000b8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00000\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Landroidx/room/TransactionElement;", "Lkotlin/coroutines/f$b;", "Lkotlin/f1;", "acquire", "release", "Ljava/util/concurrent/atomic/AtomicInteger;", "referenceCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "Lkotlinx/coroutines/e2;", "transactionThreadControlJob", "Lkotlinx/coroutines/e2;", "Lkotlin/coroutines/d;", "transactionDispatcher", "Lkotlin/coroutines/d;", "getTransactionDispatcher$room_ktx_release", "()Lkotlin/coroutines/d;", "Lkotlin/coroutines/f$c;", "getKey", "()Lkotlin/coroutines/f$c;", DomainCampaignEx.LOOPBACK_KEY, "<init>", "(Lkotlinx/coroutines/e2;Lkotlin/coroutines/d;)V", "Key", "room-ktx_release"}, k = 1, mv = {1, 4, 2})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class TransactionElement implements f.b {
    @NotNull
    public static final Key Key = new Key(null);
    private final AtomicInteger referenceCount;
    @NotNull
    private final kotlin.coroutines.d transactionDispatcher;
    private final e2 transactionThreadControlJob;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: RoomDatabase.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Landroidx/room/TransactionElement$Key;", "Lkotlin/coroutines/f$c;", "Landroidx/room/TransactionElement;", "<init>", "()V", "room-ktx_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static final class Key implements f.c<TransactionElement> {
        private Key() {
        }

        public /* synthetic */ Key(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    public TransactionElement(@NotNull e2 transactionThreadControlJob, @NotNull kotlin.coroutines.d transactionDispatcher) {
        kotlin.jvm.internal.f0.p(transactionThreadControlJob, "transactionThreadControlJob");
        kotlin.jvm.internal.f0.p(transactionDispatcher, "transactionDispatcher");
        this.transactionThreadControlJob = transactionThreadControlJob;
        this.transactionDispatcher = transactionDispatcher;
        this.referenceCount = new AtomicInteger(0);
    }

    public final void acquire() {
        this.referenceCount.incrementAndGet();
    }

    @Override // kotlin.coroutines.f.b, kotlin.coroutines.f
    public <R> R fold(R r3, @NotNull d2.p<? super R, ? super f.b, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(operation, "operation");
        return (R) f.b.a.a(this, r3, operation);
    }

    @Override // kotlin.coroutines.f.b, kotlin.coroutines.f
    @Nullable
    public <E extends f.b> E get(@NotNull f.c<E> key) {
        kotlin.jvm.internal.f0.p(key, "key");
        return (E) f.b.a.b(this, key);
    }

    @Override // kotlin.coroutines.f.b
    @NotNull
    public f.c<TransactionElement> getKey() {
        return Key;
    }

    @NotNull
    public final kotlin.coroutines.d getTransactionDispatcher$room_ktx_release() {
        return this.transactionDispatcher;
    }

    @Override // kotlin.coroutines.f.b, kotlin.coroutines.f
    @NotNull
    public kotlin.coroutines.f minusKey(@NotNull f.c<?> key) {
        kotlin.jvm.internal.f0.p(key, "key");
        return f.b.a.c(this, key);
    }

    @Override // kotlin.coroutines.f
    @NotNull
    public kotlin.coroutines.f plus(@NotNull kotlin.coroutines.f context) {
        kotlin.jvm.internal.f0.p(context, "context");
        return f.b.a.d(this, context);
    }

    public final void release() {
        int decrementAndGet = this.referenceCount.decrementAndGet();
        if (decrementAndGet < 0) {
            throw new IllegalStateException("Transaction was never started or was already released.");
        }
        if (decrementAndGet == 0) {
            e2.a.b(this.transactionThreadControlJob, null, 1, null);
        }
    }
}
