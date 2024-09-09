package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CoroutineScope.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lkotlinx/coroutines/w1;", "Lkotlinx/coroutines/q0;", "Lkotlin/coroutines/f;", "getCoroutineContext", "()Lkotlin/coroutines/f;", "coroutineContext", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class w1 implements q0 {

    /* renamed from: a  reason: collision with root package name */
    public static final w1 f60756a = new w1();

    private w1() {
    }

    @Override // kotlinx.coroutines.q0
    @NotNull
    public kotlin.coroutines.f getCoroutineContext() {
        return EmptyCoroutineContext.INSTANCE;
    }
}
