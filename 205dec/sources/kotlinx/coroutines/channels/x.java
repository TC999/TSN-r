package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.f1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Broadcast.kt */
@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BO\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u0012-\u0010\u0013\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f\u00a2\u0006\u0002\b\u0012\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0014R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/channels/x;", "E", "Lkotlinx/coroutines/channels/l;", "Lkotlinx/coroutines/channels/d0;", "t", "Lkotlin/f1;", "p1", "Lkotlin/coroutines/c;", "e", "Lkotlin/coroutines/c;", "continuation", "Lkotlin/coroutines/f;", "parentContext", "Lkotlinx/coroutines/channels/j;", "channel", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/b0;", "", "Lkotlin/ExtensionFunctionType;", "block", "<init>", "(Lkotlin/coroutines/f;Lkotlinx/coroutines/channels/j;Ld2/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class x<E> extends l<E> {

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.coroutines.c<f1> f59504e;

    public x(@NotNull kotlin.coroutines.f fVar, @NotNull j<E> jVar, @NotNull d2.p<? super b0<? super E>, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar) {
        super(fVar, jVar, false);
        kotlin.coroutines.c<f1> c4;
        c4 = IntrinsicsKt__IntrinsicsJvmKt.c(pVar, this, this);
        this.f59504e = c4;
    }

    @Override // kotlinx.coroutines.a
    protected void p1() {
        z2.a.d(this.f59504e, this);
    }

    @Override // kotlinx.coroutines.channels.l, kotlinx.coroutines.channels.j
    @NotNull
    public d0<E> t() {
        d0<E> t3 = s1().t();
        start();
        return t3;
    }
}
