package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.channels.m0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: AbstractChannel.kt */
@Metadata(bv = {}, d1 = {"\u00006\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u0004\u0018\u00010\u0001H\u0082\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a'\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u0006\u0012\u0002\b\u00030\u0005H\u0082\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\"\u0014\u0010\u000b\u001a\u00020\b8\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\"\u0014\u0010\r\u001a\u00020\b8\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\f\u0010\n\"\u0014\u0010\u000f\u001a\u00020\b8\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\n\"\u001a\u0010\u0015\u001a\u00020\u00108\u0000X\u0081\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0013\u0010\u0014\"\u001a\u0010\u0018\u001a\u00020\u00108\u0000X\u0081\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u0012\u0004\b\u0017\u0010\u0014\"\u001a\u0010\u001b\u001a\u00020\u00108\u0000X\u0081\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0012\u0012\u0004\b\u001a\u0010\u0014\"\u001a\u0010\u001e\u001a\u00020\u00108\u0000X\u0081\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0012\u0012\u0004\b\u001d\u0010\u0014\"\u001a\u0010!\u001a\u00020\u00108\u0000X\u0081\u0004\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0012\u0012\u0004\b \u0010\u0014\"\u001a\u0010#\u001a\u00020\u00108\u0000X\u0081\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0012\u0012\u0004\b\"\u0010\u0014*(\b\u0000\u0010'\"\u0010\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\u0004\u0012\u00020&0$2\u0010\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\u0004\u0012\u00020&0$\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006("}, d2 = {"E", "", "Lkotlinx/coroutines/channels/m0;", "i", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/t;", "j", "(Lkotlinx/coroutines/channels/t;)Ljava/lang/Object;", "", "a", "I", "RECEIVE_THROWS_ON_CLOSE", "b", "RECEIVE_NULL_ON_CLOSE", "c", "RECEIVE_RESULT", "Lkotlinx/coroutines/internal/j0;", "d", "Lkotlinx/coroutines/internal/j0;", "getEMPTY$annotations", "()V", "EMPTY", "e", "getOFFER_SUCCESS$annotations", "OFFER_SUCCESS", "f", "getOFFER_FAILED$annotations", "OFFER_FAILED", "g", "getPOLL_FAILED$annotations", "POLL_FAILED", "h", "getENQUEUE_FAILED$annotations", "ENQUEUE_FAILED", "getHANDLER_INVOKED$annotations", "HANDLER_INVOKED", "Lkotlin/Function1;", "", "Lkotlin/f1;", "Handler", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final int f59393a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f59394b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f59395c = 2;
    @JvmField
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final kotlinx.coroutines.internal.j0 f59396d = new kotlinx.coroutines.internal.j0("EMPTY");
    @JvmField
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final kotlinx.coroutines.internal.j0 f59397e = new kotlinx.coroutines.internal.j0("OFFER_SUCCESS");
    @JvmField
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public static final kotlinx.coroutines.internal.j0 f59398f = new kotlinx.coroutines.internal.j0("OFFER_FAILED");
    @JvmField
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    public static final kotlinx.coroutines.internal.j0 f59399g = new kotlinx.coroutines.internal.j0("POLL_FAILED");
    @JvmField
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    public static final kotlinx.coroutines.internal.j0 f59400h = new kotlinx.coroutines.internal.j0("ENQUEUE_FAILED");
    @JvmField
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public static final kotlinx.coroutines.internal.j0 f59401i = new kotlinx.coroutines.internal.j0("ON_CLOSE_HANDLER_INVOKED");

    public static /* synthetic */ void c() {
    }

    public static /* synthetic */ void d() {
    }

    public static /* synthetic */ void e() {
    }

    public static /* synthetic */ void f() {
    }

    public static /* synthetic */ void g() {
    }

    public static /* synthetic */ void h() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E> Object i(Object obj) {
        if (obj instanceof t) {
            m0.b bVar = m0.f59459b;
            return m0.b(new m0.a(((t) obj).f59488d));
        }
        m0.b bVar2 = m0.f59459b;
        return m0.b(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E> Object j(t<?> tVar) {
        m0.b bVar = m0.f59459b;
        return m0.b(new m0.a(tVar.f59488d));
    }
}
