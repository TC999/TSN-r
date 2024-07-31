package kotlin.ranges;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.Unsigned;
import kotlin.UnsignedUtils;
import kotlin.WasExperimental;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UIntRange.kt */
@SinceKotlin(version = "1.5")
@Metadata(m12618bv = {}, m12617d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u0000 \u00172\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0018B\u001a\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0013\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u001a\u0010\u0012\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0019"}, m12616d2 = {"Lkotlin/ranges/t;", "Lkotlin/ranges/r;", "Lkotlin/ranges/g;", "Lkotlin/r0;", DomainCampaignEx.LOOPBACK_VALUE, "", "g", "(I)Z", "isEmpty", "", AdnName.OTHER, "equals", "", TTDownloadField.TT_HASHCODE, "", "toString", "i", "()I", CampaignEx.JSON_NATIVE_VIDEO_START, "h", "endInclusive", "<init>", "(IILkotlin/jvm/internal/u;)V", "f", "a", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
@WasExperimental(markerClass = {Unsigned.class})
/* renamed from: kotlin.ranges.t */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14424t extends UIntRange implements InterfaceC14407g<UInt> {
    @NotNull

    /* renamed from: f */
    public static final C14425a f41321f = new C14425a(null);
    @NotNull

    /* renamed from: e */
    private static final C14424t f41320e = new C14424t(-1, 0);

    /* compiled from: UIntRange.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, m12616d2 = {"Lkotlin/ranges/t$a;", "", "Lkotlin/ranges/t;", "EMPTY", "Lkotlin/ranges/t;", "a", "()Lkotlin/ranges/t;", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.ranges.t$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14425a {
        private C14425a() {
        }

        @NotNull
        /* renamed from: a */
        public final C14424t m7435a() {
            return C14424t.f41320e;
        }

        public /* synthetic */ C14425a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private C14424t(int i, int i2) {
        super(i, i2, 1, null);
    }

    @Override // kotlin.ranges.InterfaceC14407g
    public /* bridge */ /* synthetic */ boolean contains(UInt uInt) {
        return m7438g(uInt.m7679g0());
    }

    @Override // kotlin.ranges.UIntRange
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof C14424t) {
            if (!isEmpty() || !((C14424t) obj).isEmpty()) {
                C14424t c14424t = (C14424t) obj;
                if (m7443c() != c14424t.m7443c() || m7442d() != c14424t.m7442d()) {
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: g */
    public boolean m7438g(int i) {
        return UnsignedUtils.m8561c(m7443c(), i) <= 0 && UnsignedUtils.m8561c(i, m7442d()) <= 0;
    }

    @Override // kotlin.ranges.InterfaceC14407g
    public /* bridge */ /* synthetic */ UInt getEndInclusive() {
        return UInt.m7690b(m7437h());
    }

    @Override // kotlin.ranges.InterfaceC14407g
    public /* bridge */ /* synthetic */ UInt getStart() {
        return UInt.m7690b(m7436i());
    }

    /* renamed from: h */
    public int m7437h() {
        return m7442d();
    }

    @Override // kotlin.ranges.UIntRange
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (m7443c() * 31) + m7442d();
    }

    /* renamed from: i */
    public int m7436i() {
        return m7443c();
    }

    @Override // kotlin.ranges.UIntRange, kotlin.ranges.InterfaceC14407g
    public boolean isEmpty() {
        return UnsignedUtils.m8561c(m7443c(), m7442d()) > 0;
    }

    @Override // kotlin.ranges.UIntRange
    @NotNull
    public String toString() {
        return UInt.m7689b0(m7443c()) + ".." + UInt.m7689b0(m7442d());
    }

    public /* synthetic */ C14424t(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2);
    }
}
