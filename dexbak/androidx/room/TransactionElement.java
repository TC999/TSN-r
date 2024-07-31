package androidx.room;

import androidx.annotation.RestrictTo;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* compiled from: RoomDatabase.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\u00020\u000b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00000\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, m12616d2 = {"Landroidx/room/TransactionElement;", "Lkotlin/coroutines/f$b;", "Lkotlin/f1;", "acquire", "release", "Ljava/util/concurrent/atomic/AtomicInteger;", "referenceCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "Lkotlinx/coroutines/e2;", "transactionThreadControlJob", "Lkotlinx/coroutines/e2;", "Lkotlin/coroutines/d;", "transactionDispatcher", "Lkotlin/coroutines/d;", "getTransactionDispatcher$room_ktx_release", "()Lkotlin/coroutines/d;", "Lkotlin/coroutines/f$c;", "getKey", "()Lkotlin/coroutines/f$c;", DomainCampaignEx.LOOPBACK_KEY, "<init>", "(Lkotlinx/coroutines/e2;Lkotlin/coroutines/d;)V", "Key", "room-ktx_release"}, m12615k = 1, m12614mv = {1, 4, 2})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class TransactionElement implements CoroutineContext.InterfaceC14275b {
    @NotNull
    public static final Key Key = new Key(null);
    private final AtomicInteger referenceCount;
    @NotNull
    private final ContinuationInterceptor transactionDispatcher;
    private final Job transactionThreadControlJob;

    /* compiled from: RoomDatabase.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m12616d2 = {"Landroidx/room/TransactionElement$Key;", "Lkotlin/coroutines/f$c;", "Landroidx/room/TransactionElement;", "<init>", "()V", "room-ktx_release"}, m12615k = 1, m12614mv = {1, 4, 2})
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static final class Key implements CoroutineContext.InterfaceC14277c<TransactionElement> {
        private Key() {
        }

        public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TransactionElement(@NotNull Job transactionThreadControlJob, @NotNull ContinuationInterceptor transactionDispatcher) {
        C14342f0.m8184p(transactionThreadControlJob, "transactionThreadControlJob");
        C14342f0.m8184p(transactionDispatcher, "transactionDispatcher");
        this.transactionThreadControlJob = transactionThreadControlJob;
        this.transactionDispatcher = transactionDispatcher;
        this.referenceCount = new AtomicInteger(0);
    }

    public final void acquire() {
        this.referenceCount.incrementAndGet();
    }

    @Override // kotlin.coroutines.CoroutineContext.InterfaceC14275b, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @NotNull InterfaceC15284p<? super R, ? super CoroutineContext.InterfaceC14275b, ? extends R> operation) {
        C14342f0.m8184p(operation, "operation");
        return (R) CoroutineContext.InterfaceC14275b.C14276a.m8661a(this, r, operation);
    }

    @Override // kotlin.coroutines.CoroutineContext.InterfaceC14275b, kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.InterfaceC14275b> E get(@NotNull CoroutineContext.InterfaceC14277c<E> key) {
        C14342f0.m8184p(key, "key");
        return (E) CoroutineContext.InterfaceC14275b.C14276a.m8660b(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.InterfaceC14275b
    @NotNull
    public CoroutineContext.InterfaceC14277c<TransactionElement> getKey() {
        return Key;
    }

    @NotNull
    public final ContinuationInterceptor getTransactionDispatcher$room_ktx_release() {
        return this.transactionDispatcher;
    }

    @Override // kotlin.coroutines.CoroutineContext.InterfaceC14275b, kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.InterfaceC14277c<?> key) {
        C14342f0.m8184p(key, "key");
        return CoroutineContext.InterfaceC14275b.C14276a.m8659c(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext context) {
        C14342f0.m8184p(context, "context");
        return CoroutineContext.InterfaceC14275b.C14276a.m8658d(this, context);
    }

    public final void release() {
        int decrementAndGet = this.referenceCount.decrementAndGet();
        if (decrementAndGet < 0) {
            throw new IllegalStateException("Transaction was never started or was already released.");
        }
        if (decrementAndGet == 0) {
            Job.C14776a.m5047b(this.transactionThreadControlJob, null, 1, null);
        }
    }
}
