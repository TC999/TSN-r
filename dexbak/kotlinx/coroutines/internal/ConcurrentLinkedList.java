package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15284p;

@Metadata(m12618bv = {}, m12617d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001ao\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u00002\u0006\u0010\u0003\u001a\u00020\u000228\u0010\b\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0003\u0012\u0015\u0012\u0013\u0018\u00018\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00028\u00000\u0004H\u0082\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a#\u0010\u000e\u001a\u00028\u0000\"\u000e\b\u0000\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\f*\u00028\u0000H\u0000¢\u0006\u0004\b\u000e\u0010\u000f\"\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\"\u001a\u0010\u0019\u001a\u00020\u00148\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u0012\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, m12616d2 = {"Lkotlinx/coroutines/internal/g0;", ExifInterface.LATITUDE_SOUTH, "", "id", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "prev", "createNewSegment", "Lkotlinx/coroutines/internal/h0;", "d", "(Lkotlinx/coroutines/internal/g0;JLl1/p;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/g;", "N", "c", "(Lkotlinx/coroutines/internal/g;)Lkotlinx/coroutines/internal/g;", "", "a", "I", "POINTERS_SHIFT", "Lkotlinx/coroutines/internal/j0;", "b", "Lkotlinx/coroutines/internal/j0;", "getCLOSED$annotations", "()V", "CLOSED", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ConcurrentLinkedList {

    /* renamed from: a */
    private static final int f43038a = 16;

    /* renamed from: b */
    private static final Symbol f43039b = new Symbol("CLOSED");

    /* renamed from: b */
    public static final /* synthetic */ Symbol m4363b() {
        return f43039b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlinx.coroutines.internal.g] */
    @NotNull
    /* renamed from: c */
    public static final <N extends AbstractC15075g<N>> N m4362c(@NotNull N n) {
        while (true) {
            Object m4354e = n.m4354e();
            if (m4354e == f43039b) {
                return n;
            }
            ?? r0 = (AbstractC15075g) m4354e;
            if (r0 != 0) {
                n = r0;
            } else if (n.m4350j()) {
                return n;
            }
        }
    }

    /* renamed from: d */
    public static final <S extends AbstractC15076g0<S>> Object m4361d(S s, long j, InterfaceC15284p<? super Long, ? super S, ? extends S> interfaceC15284p) {
        while (true) {
            if (s.m4344o() >= j && !s.mo4346g()) {
                return C15078h0.m4340b(s);
            }
            Object m4354e = s.m4354e();
            if (m4354e == f43039b) {
                return C15078h0.m4340b(f43039b);
            }
            S s2 = (S) ((AbstractC15075g) m4354e);
            if (s2 == null) {
                s2 = interfaceC15284p.invoke(Long.valueOf(s.m4344o() + 1), s);
                if (s.m4347m(s2)) {
                    if (s.mo4346g()) {
                        s.m4348l();
                    }
                }
            }
            s = s2;
        }
    }

    /* renamed from: e */
    private static /* synthetic */ void m4360e() {
    }
}
