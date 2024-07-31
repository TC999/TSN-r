package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a:\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001f\b\u0004\u0010\u0005\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, m12616d2 = {"R", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/a;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "builder", "a", "(Ll1/l;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.selects.h */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SelectUnbiased {
    @Nullable
    /* renamed from: a */
    public static final <R> Object m3686a(@NotNull InterfaceC15280l<? super Select<? super R>, Unit> interfaceC15280l, @NotNull InterfaceC14268c<? super R> interfaceC14268c) {
        Object m8642h;
        C15200j c15200j = new C15200j(interfaceC14268c);
        try {
            interfaceC15280l.invoke(c15200j);
        } catch (Throwable th) {
            c15200j.m3679e(th);
        }
        Object m3678f = c15200j.m3678f();
        m8642h = C14287b.m8642h();
        if (m3678f == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        return m3678f;
    }

    @Nullable
    /* renamed from: b */
    private static final Object m3685b(@NotNull InterfaceC15280l interfaceC15280l, @NotNull InterfaceC14268c interfaceC14268c) {
        Object m8642h;
        InlineMarker.m8227e(0);
        C15200j c15200j = new C15200j(interfaceC14268c);
        try {
            interfaceC15280l.invoke(c15200j);
        } catch (Throwable th) {
            c15200j.m3679e(th);
        }
        Object m3678f = c15200j.m3678f();
        m8642h = C14287b.m8642h();
        if (m3678f == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        InlineMarker.m8227e(1);
        return m3678f;
    }
}
