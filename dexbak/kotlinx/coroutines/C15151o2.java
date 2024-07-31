package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.IntrinsicsJvm;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15284p;
import p649u1.C16231a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Builders.common.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\t\u001a\u00020\b\u0012'\u0010\u000e\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\f0\n¢\u0006\u0002\b\rø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0014R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, m12616d2 = {"Lkotlinx/coroutines/o2;", "Lkotlinx/coroutines/e3;", "Lkotlin/f1;", "p1", "Lkotlin/coroutines/c;", "d", "Lkotlin/coroutines/c;", "continuation", "Lkotlin/coroutines/f;", "parentContext", "Lkotlin/Function2;", "Lkotlinx/coroutines/q0;", "", "Lkotlin/ExtensionFunctionType;", "block", "<init>", "(Lkotlin/coroutines/f;Ll1/p;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.o2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15151o2 extends C14778e3 {

    /* renamed from: d */
    private final InterfaceC14268c<Unit> f43207d;

    public C15151o2(@NotNull CoroutineContext coroutineContext, @NotNull InterfaceC15284p<? super CoroutineScope, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        super(coroutineContext, false);
        InterfaceC14268c<Unit> m8651c;
        m8651c = IntrinsicsJvm.m8651c(interfaceC15284p, this, this);
        this.f43207d = m8651c;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    /* renamed from: p1 */
    protected void mo3933p1() {
        C16231a.m229b(this.f43207d, this);
    }
}
