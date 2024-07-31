package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.C14271e;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

/* compiled from: RunSuspend.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a0\u0010\u0005\u001a\u00020\u00022\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0000H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, m12616d2 = {"Lkotlin/Function1;", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "", "block", "a", "(Ll1/l;)V", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: kotlin.coroutines.jvm.internal.h */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14292h {
    @SinceKotlin(version = "1.3")
    /* renamed from: a */
    public static final void m8611a(@NotNull InterfaceC15280l<? super InterfaceC14268c<? super Unit>, ? extends Object> block) {
        C14342f0.m8184p(block, "block");
        RunSuspend runSuspend = new RunSuspend();
        C14271e.m8666h(block, runSuspend);
        runSuspend.m8613b();
    }
}
