package kotlin.ranges;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.Unsigned;
import kotlin.UnsignedUtils;
import kotlin.WasExperimental;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ULongRange.kt */
@SinceKotlin(version = "1.5")
@Metadata(m12618bv = {}, m12617d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u0000 \u00172\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0018B\u001a\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0013\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u001a\u0010\u0012\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0019"}, m12616d2 = {"Lkotlin/ranges/w;", "Lkotlin/ranges/u;", "Lkotlin/ranges/g;", "Lkotlin/v0;", DomainCampaignEx.LOOPBACK_VALUE, "", "g", "(J)Z", "isEmpty", "", AdnName.OTHER, "equals", "", TTDownloadField.TT_HASHCODE, "", "toString", "i", "()J", CampaignEx.JSON_NATIVE_VIDEO_START, "h", "endInclusive", "<init>", "(JJLkotlin/jvm/internal/u;)V", "f", "a", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
@WasExperimental(markerClass = {Unsigned.class})
/* renamed from: kotlin.ranges.w */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14428w extends ULongRange implements InterfaceC14407g<ULong> {
    @NotNull

    /* renamed from: f */
    public static final C14429a f41331f = new C14429a(null);
    @NotNull

    /* renamed from: e */
    private static final C14428w f41330e = new C14428w(-1, 0);

    /* compiled from: ULongRange.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, m12616d2 = {"Lkotlin/ranges/w$a;", "", "Lkotlin/ranges/w;", "EMPTY", "Lkotlin/ranges/w;", "a", "()Lkotlin/ranges/w;", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.ranges.w$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14429a {
        private C14429a() {
        }

        @NotNull
        /* renamed from: a */
        public final C14428w m7426a() {
            return C14428w.f41330e;
        }

        public /* synthetic */ C14429a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private C14428w(long j, long j2) {
        super(j, j2, 1L, null);
    }

    @Override // kotlin.ranges.InterfaceC14407g
    public /* bridge */ /* synthetic */ boolean contains(ULong uLong) {
        return m7429g(uLong.m5890g0());
    }

    @Override // kotlin.ranges.ULongRange
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof C14428w) {
            if (!isEmpty() || !((C14428w) obj).isEmpty()) {
                C14428w c14428w = (C14428w) obj;
                if (m7434c() != c14428w.m7434c() || m7433d() != c14428w.m7433d()) {
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: g */
    public boolean m7429g(long j) {
        return UnsignedUtils.m8557g(m7434c(), j) <= 0 && UnsignedUtils.m8557g(j, m7433d()) <= 0;
    }

    @Override // kotlin.ranges.InterfaceC14407g
    public /* bridge */ /* synthetic */ ULong getEndInclusive() {
        return ULong.m5901b(m7428h());
    }

    @Override // kotlin.ranges.InterfaceC14407g
    public /* bridge */ /* synthetic */ ULong getStart() {
        return ULong.m5901b(m7427i());
    }

    /* renamed from: h */
    public long m7428h() {
        return m7433d();
    }

    @Override // kotlin.ranges.ULongRange
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return ((int) ULong.m5889h(m7433d() ^ ULong.m5889h(m7433d() >>> 32))) + (((int) ULong.m5889h(m7434c() ^ ULong.m5889h(m7434c() >>> 32))) * 31);
    }

    /* renamed from: i */
    public long m7427i() {
        return m7434c();
    }

    @Override // kotlin.ranges.ULongRange, kotlin.ranges.InterfaceC14407g
    public boolean isEmpty() {
        return UnsignedUtils.m8557g(m7434c(), m7433d()) > 0;
    }

    @Override // kotlin.ranges.ULongRange
    @NotNull
    public String toString() {
        return ULong.m5900b0(m7434c()) + ".." + ULong.m5900b0(m7433d());
    }

    public /* synthetic */ C14428w(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }
}
