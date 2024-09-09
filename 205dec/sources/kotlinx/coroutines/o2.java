package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Builders.common.kt */
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\t\u001a\u00020\b\u0012'\u0010\u000e\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\f0\n\u00a2\u0006\u0002\b\r\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0014R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/o2;", "Lkotlinx/coroutines/e3;", "Lkotlin/f1;", "p1", "Lkotlin/coroutines/c;", "d", "Lkotlin/coroutines/c;", "continuation", "Lkotlin/coroutines/f;", "parentContext", "Lkotlin/Function2;", "Lkotlinx/coroutines/q0;", "", "Lkotlin/ExtensionFunctionType;", "block", "<init>", "(Lkotlin/coroutines/f;Ld2/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class o2 extends e3 {

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.coroutines.c<kotlin.f1> f60524d;

    public o2(@NotNull kotlin.coroutines.f fVar, @NotNull d2.p<? super q0, ? super kotlin.coroutines.c<? super kotlin.f1>, ? extends Object> pVar) {
        super(fVar, false);
        kotlin.coroutines.c<kotlin.f1> c4;
        c4 = IntrinsicsKt__IntrinsicsJvmKt.c(pVar, this, this);
        this.f60524d = c4;
    }

    @Override // kotlinx.coroutines.a
    protected void p1() {
        z2.a.d(this.f60524d, this);
    }
}
