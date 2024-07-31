package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Semaphore.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0013\u0010\u0003\u001a\u00020\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0002H&R\u0014\u0010\u000b\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, m12616d2 = {"Lkotlinx/coroutines/sync/e;", "", "Lkotlin/f1;", "c", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "b", "release", "", "a", "()I", "availablePermits", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.sync.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface InterfaceC15221e {
    /* renamed from: a */
    int mo3613a();

    /* renamed from: b */
    boolean mo3612b();

    @Nullable
    /* renamed from: c */
    Object mo3611c(@NotNull InterfaceC14268c<? super Unit> interfaceC14268c);

    void release();
}
