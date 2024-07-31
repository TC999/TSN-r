package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.intrinsics.IntrinsicsJvm;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.C15094s;
import kotlinx.coroutines.internal.DispatchedContinuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* compiled from: CancellableContinuation.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a5\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a5\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0080Hø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0006\u001a\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0000\u001a\u0018\u0010\u000e\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\r\u001a\u00020\fH\u0000\u001a\u0018\u0010\u0011\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Lkotlinx/coroutines/o;", "Lkotlin/f1;", "block", "d", "(Ll1/l;Lkotlin/coroutines/c;)Ljava/lang/Object;", "f", "Lkotlin/coroutines/c;", "delegate", "Lkotlinx/coroutines/p;", "b", "Lkotlinx/coroutines/internal/s;", "node", "c", "Lkotlinx/coroutines/i1;", "handle", "a", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.r */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15161r {
    @InternalCoroutinesApi
    /* renamed from: a */
    public static final void m3853a(@NotNull InterfaceC15146o<?> interfaceC15146o, @NotNull InterfaceC15064i1 interfaceC15064i1) {
        interfaceC15146o.mo3902e(new CancellableContinuation(interfaceC15064i1));
    }

    @NotNull
    /* renamed from: b */
    public static final <T> C15153p<T> m3852b(@NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        if (!(interfaceC14268c instanceof DispatchedContinuation)) {
            return new C15153p<>(interfaceC14268c, 2);
        }
        C15153p<T> m4310l = ((DispatchedContinuation) interfaceC14268c).m4310l();
        if (m4310l != null) {
            if (!m4310l.m3918G()) {
                m4310l = null;
            }
            if (m4310l != null) {
                return m4310l;
            }
        }
        return new C15153p<>(interfaceC14268c, 2);
    }

    /* renamed from: c */
    public static final void m3851c(@NotNull InterfaceC15146o<?> interfaceC15146o, @NotNull C15094s c15094s) {
        interfaceC15146o.mo3902e(new C15248w2(c15094s));
    }

    @Nullable
    /* renamed from: d */
    public static final <T> Object m3850d(@NotNull InterfaceC15280l<? super InterfaceC15146o<? super T>, Unit> interfaceC15280l, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        InterfaceC14268c m8650d;
        Object m8642h;
        m8650d = IntrinsicsJvm.m8650d(interfaceC14268c);
        C15153p c15153p = new C15153p(m8650d, 1);
        c15153p.mo3915J();
        interfaceC15280l.invoke(c15153p);
        Object m3883y = c15153p.m3883y();
        m8642h = C14287b.m8642h();
        if (m3883y == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        return m3883y;
    }

    @Nullable
    /* renamed from: e */
    private static final Object m3849e(@NotNull InterfaceC15280l interfaceC15280l, @NotNull InterfaceC14268c interfaceC14268c) {
        InterfaceC14268c m8650d;
        Object m8642h;
        InlineMarker.m8227e(0);
        m8650d = IntrinsicsJvm.m8650d(interfaceC14268c);
        C15153p c15153p = new C15153p(m8650d, 1);
        c15153p.mo3915J();
        interfaceC15280l.invoke(c15153p);
        Object m3883y = c15153p.m3883y();
        m8642h = C14287b.m8642h();
        if (m3883y == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        InlineMarker.m8227e(1);
        return m3883y;
    }

    @Nullable
    /* renamed from: f */
    public static final <T> Object m3848f(@NotNull InterfaceC15280l<? super InterfaceC15146o<? super T>, Unit> interfaceC15280l, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        InterfaceC14268c m8650d;
        Object m8642h;
        m8650d = IntrinsicsJvm.m8650d(interfaceC14268c);
        C15153p m3852b = m3852b(m8650d);
        interfaceC15280l.invoke(m3852b);
        Object m3883y = m3852b.m3883y();
        m8642h = C14287b.m8642h();
        if (m3883y == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        return m3883y;
    }

    @Nullable
    /* renamed from: g */
    private static final Object m3847g(@NotNull InterfaceC15280l interfaceC15280l, @NotNull InterfaceC14268c interfaceC14268c) {
        InterfaceC14268c m8650d;
        Object m8642h;
        InlineMarker.m8227e(0);
        m8650d = IntrinsicsJvm.m8650d(interfaceC14268c);
        C15153p m3852b = m3852b(m8650d);
        interfaceC15280l.invoke(m3852b);
        Object m3883y = m3852b.m3883y();
        m8642h = C14287b.m8642h();
        if (m3883y == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        InlineMarker.m8227e(1);
        return m3883y;
    }
}
