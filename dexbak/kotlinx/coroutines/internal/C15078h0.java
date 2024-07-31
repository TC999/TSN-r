package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.internal.AbstractC15076g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConcurrentLinkedList.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0080@\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003B\u0014\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0003HÖ\u0003R\u0016\u0010\r\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0011\u0010\u0010\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, m12616d2 = {"Lkotlinx/coroutines/internal/h0;", "Lkotlinx/coroutines/internal/g0;", ExifInterface.LATITUDE_SOUTH, "", "", "toString", "", TTDownloadField.TT_HASHCODE, AdnName.OTHER, "", "equals", "a", "Ljava/lang/Object;", DomainCampaignEx.LOOPBACK_VALUE, "h", "(Ljava/lang/Object;)Z", "isClosed", "f", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/g0;", "getSegment$annotations", "()V", "segment", "b", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.h0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15078h0<S extends AbstractC15076g0<S>> {

    /* renamed from: a */
    private final Object f43045a;

    private /* synthetic */ C15078h0(@Nullable Object obj) {
        this.f43045a = obj;
    }

    @NotNull
    /* renamed from: a */
    public static final /* synthetic */ C15078h0 m4341a(@Nullable Object obj) {
        return new C15078h0(obj);
    }

    @NotNull
    /* renamed from: b */
    public static Object m4340b(@Nullable Object obj) {
        return obj;
    }

    /* renamed from: c */
    public static boolean m4339c(Object obj, @Nullable Object obj2) {
        return (obj2 instanceof C15078h0) && C14342f0.m8193g(obj, ((C15078h0) obj2).m4332j());
    }

    /* renamed from: d */
    public static final boolean m4338d(@Nullable Object obj, @Nullable Object obj2) {
        return C14342f0.m8193g(obj, obj2);
    }

    /* renamed from: e */
    public static /* synthetic */ void m4337e() {
    }

    @NotNull
    /* renamed from: f */
    public static final S m4336f(Object obj) {
        if (obj != ConcurrentLinkedList.f43039b) {
            if (obj != null) {
                return (S) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type S");
        }
        throw new IllegalStateException("Does not contain segment".toString());
    }

    /* renamed from: g */
    public static int m4335g(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* renamed from: h */
    public static final boolean m4334h(Object obj) {
        return obj == ConcurrentLinkedList.f43039b;
    }

    @NotNull
    /* renamed from: i */
    public static String m4333i(Object obj) {
        return "SegmentOrClosed(value=" + obj + ")";
    }

    public boolean equals(Object obj) {
        return m4339c(this.f43045a, obj);
    }

    public int hashCode() {
        return m4335g(this.f43045a);
    }

    @Nullable
    /* renamed from: j */
    public final /* synthetic */ Object m4332j() {
        return this.f43045a;
    }

    public String toString() {
        return m4333i(this.f43045a);
    }
}
