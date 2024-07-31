package androidx.room;

import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: RoomDatabase.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, m12616d2 = {"R", "Lkotlinx/coroutines/q0;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 2})
@DebugMetadata(m8639c = "androidx.room.RoomDatabaseKt$withTransaction$2", m8638f = "RoomDatabase.kt", m8637i = {0}, m8636l = {58}, m8635m = "invokeSuspend", m8634n = {"transactionElement"}, m8633s = {"L$0"})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class RoomDatabaseKt$withTransaction$2<R> extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super R>, Object> {
    final /* synthetic */ InterfaceC15280l $block;
    final /* synthetic */ RoomDatabase $this_withTransaction;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomDatabaseKt$withTransaction$2(RoomDatabase roomDatabase, InterfaceC15280l interfaceC15280l, InterfaceC14268c interfaceC14268c) {
        super(2, interfaceC14268c);
        this.$this_withTransaction = roomDatabase;
        this.$block = interfaceC15280l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> completion) {
        C14342f0.m8184p(completion, "completion");
        RoomDatabaseKt$withTransaction$2 roomDatabaseKt$withTransaction$2 = new RoomDatabaseKt$withTransaction$2(this.$this_withTransaction, this.$block, completion);
        roomDatabaseKt$withTransaction$2.L$0 = obj;
        return roomDatabaseKt$withTransaction$2;
    }

    @Override // p617l1.InterfaceC15284p
    public final Object invoke(CoroutineScope coroutineScope, Object obj) {
        return ((RoomDatabaseKt$withTransaction$2) create(coroutineScope, (InterfaceC14268c) obj)).invokeSuspend(Unit.f41048a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        TransactionElement m8642h;
        Throwable th;
        TransactionElement transactionElement;
        m8642h = C14287b.m8642h();
        int i = this.label;
        try {
            if (i == 0) {
                C14294d0.m8596n(obj);
                CoroutineContext.InterfaceC14275b interfaceC14275b = ((CoroutineScope) this.L$0).getCoroutineContext().get(TransactionElement.Key);
                C14342f0.m8187m(interfaceC14275b);
                TransactionElement transactionElement2 = (TransactionElement) interfaceC14275b;
                transactionElement2.acquire();
                try {
                    this.$this_withTransaction.beginTransaction();
                    try {
                        InterfaceC15280l interfaceC15280l = this.$block;
                        this.L$0 = transactionElement2;
                        this.label = 1;
                        Object invoke = interfaceC15280l.invoke(this);
                        if (invoke == m8642h) {
                            return m8642h;
                        }
                        transactionElement = transactionElement2;
                        obj = invoke;
                    } catch (Throwable th2) {
                        th = th2;
                        this.$this_withTransaction.endTransaction();
                        throw th;
                    }
                } catch (Throwable th3) {
                    m8642h = transactionElement2;
                    th = th3;
                    m8642h.release();
                    throw th;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                transactionElement = (TransactionElement) this.L$0;
                try {
                    C14294d0.m8596n(obj);
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
