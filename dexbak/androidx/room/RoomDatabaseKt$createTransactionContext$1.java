package androidx.room;

import kotlin.Metadata;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RoomDatabase.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0082@"}, m12616d2 = {"Landroidx/room/RoomDatabase;", "Lkotlin/coroutines/c;", "Lkotlin/coroutines/f;", "continuation", "", "createTransactionContext"}, m12615k = 3, m12614mv = {1, 4, 2})
@DebugMetadata(m8639c = "androidx.room.RoomDatabaseKt", m8638f = "RoomDatabase.kt", m8637i = {0, 0}, m8636l = {99}, m8635m = "createTransactionContext", m8634n = {"$this$createTransactionContext", "controlJob"}, m8633s = {"L$0", "L$1"})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class RoomDatabaseKt$createTransactionContext$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RoomDatabaseKt$createTransactionContext$1(InterfaceC14268c interfaceC14268c) {
        super(interfaceC14268c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RoomDatabaseKt.createTransactionContext(null, this);
    }
}
