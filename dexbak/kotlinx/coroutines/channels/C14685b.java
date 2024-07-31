package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlinx.coroutines.channels.C14719m0;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;

/* compiled from: AbstractChannel.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00006\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u0004\u0018\u00010\u0001H\u0082\bø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a'\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u0006\u0012\u0002\b\u00030\u0005H\u0082\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\"\u0014\u0010\u000b\u001a\u00020\b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\t\u0010\n\"\u0014\u0010\r\u001a\u00020\b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\f\u0010\n\"\u0014\u0010\u000f\u001a\u00020\b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000e\u0010\n\"\u001a\u0010\u0015\u001a\u00020\u00108\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0013\u0010\u0014\"\u001a\u0010\u0018\u001a\u00020\u00108\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u0012\u0004\b\u0017\u0010\u0014\"\u001a\u0010\u001b\u001a\u00020\u00108\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0012\u0012\u0004\b\u001a\u0010\u0014\"\u001a\u0010\u001e\u001a\u00020\u00108\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u0012\u0004\b\u001d\u0010\u0014\"\u001a\u0010!\u001a\u00020\u00108\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0012\u0012\u0004\b \u0010\u0014\"\u001a\u0010#\u001a\u00020\u00108\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u0012\u0004\b\"\u0010\u0014*(\b\u0000\u0010'\"\u0010\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\u0004\u0012\u00020&0$2\u0010\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\u0004\u0012\u00020&0$\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006("}, m12616d2 = {ExifInterface.LONGITUDE_EAST, "", "Lkotlinx/coroutines/channels/m0;", "i", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/t;", "j", "(Lkotlinx/coroutines/channels/t;)Ljava/lang/Object;", "", "a", "I", "RECEIVE_THROWS_ON_CLOSE", "b", "RECEIVE_NULL_ON_CLOSE", "c", "RECEIVE_RESULT", "Lkotlinx/coroutines/internal/j0;", "d", "Lkotlinx/coroutines/internal/j0;", "getEMPTY$annotations", "()V", "EMPTY", "e", "getOFFER_SUCCESS$annotations", "OFFER_SUCCESS", "f", "getOFFER_FAILED$annotations", "OFFER_FAILED", "g", "getPOLL_FAILED$annotations", "POLL_FAILED", "h", "getENQUEUE_FAILED$annotations", "ENQUEUE_FAILED", "getHANDLER_INVOKED$annotations", "HANDLER_INVOKED", "Lkotlin/Function1;", "", "Lkotlin/f1;", "Handler", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.channels.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14685b {

    /* renamed from: a */
    public static final int f42048a = 0;

    /* renamed from: b */
    public static final int f42049b = 1;

    /* renamed from: c */
    public static final int f42050c = 2;
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: d */
    public static final Symbol f42051d = new Symbol("EMPTY");
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: e */
    public static final Symbol f42052e = new Symbol("OFFER_SUCCESS");
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: f */
    public static final Symbol f42053f = new Symbol("OFFER_FAILED");
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: g */
    public static final Symbol f42054g = new Symbol("POLL_FAILED");
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: h */
    public static final Symbol f42055h = new Symbol("ENQUEUE_FAILED");
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: i */
    public static final Symbol f42056i = new Symbol("ON_CLOSE_HANDLER_INVOKED");

    /* renamed from: c */
    public static /* synthetic */ void m5507c() {
    }

    /* renamed from: d */
    public static /* synthetic */ void m5506d() {
    }

    /* renamed from: e */
    public static /* synthetic */ void m5505e() {
    }

    /* renamed from: f */
    public static /* synthetic */ void m5504f() {
    }

    /* renamed from: g */
    public static /* synthetic */ void m5503g() {
    }

    /* renamed from: h */
    public static /* synthetic */ void m5502h() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public static final <E> Object m5501i(Object obj) {
        if (obj instanceof C14731t) {
            C14719m0.C14721b c14721b = C14719m0.f42114b;
            return C14719m0.m5417b(new C14719m0.C14720a(((C14731t) obj).f42143d));
        }
        C14719m0.C14721b c14721b2 = C14719m0.f42114b;
        return C14719m0.m5417b(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static final <E> Object m5500j(C14731t<?> c14731t) {
        C14719m0.C14721b c14721b = C14719m0.f42114b;
        return C14719m0.m5417b(new C14719m0.C14720a(c14731t.f42143d));
    }
}
