package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Builders.common.kt */
@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B;\u0012\u0006\u0010\n\u001a\u00020\t\u0012'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000b\u00a2\u0006\u0002\b\u000e\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0014R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/n2;", "T", "Lkotlinx/coroutines/y0;", "Lkotlin/f1;", "p1", "Lkotlin/coroutines/c;", "d", "Lkotlin/coroutines/c;", "continuation", "Lkotlin/coroutines/f;", "parentContext", "Lkotlin/Function2;", "Lkotlinx/coroutines/q0;", "", "Lkotlin/ExtensionFunctionType;", "block", "<init>", "(Lkotlin/coroutines/f;Ld2/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class n2<T> extends y0<T> {

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.coroutines.c<kotlin.f1> f60517d;

    public n2(@NotNull kotlin.coroutines.f fVar, @NotNull d2.p<? super q0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar) {
        super(fVar, false);
        kotlin.coroutines.c<kotlin.f1> c4;
        c4 = IntrinsicsKt__IntrinsicsJvmKt.c(pVar, this, this);
        this.f60517d = c4;
    }

    @Override // kotlinx.coroutines.a
    protected void p1() {
        z2.a.d(this.f60517d, this);
    }
}
