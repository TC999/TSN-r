package kotlin.ranges;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Ranges.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00162\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0017B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0013\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010\u0011\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0018"}, m12616d2 = {"Lkotlin/ranges/n;", "Lkotlin/ranges/l;", "Lkotlin/ranges/g;", "", DomainCampaignEx.LOOPBACK_VALUE, "", "h", "isEmpty", "", AdnName.OTHER, "equals", "", TTDownloadField.TT_HASHCODE, "", "toString", "j", "()Ljava/lang/Long;", CampaignEx.JSON_NATIVE_VIDEO_START, "i", "endInclusive", "<init>", "(JJ)V", "f", "a", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.ranges.n */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14418n extends C14415l implements InterfaceC14407g<Long> {
    @NotNull

    /* renamed from: f */
    public static final C14419a f41311f = new C14419a(null);
    @NotNull

    /* renamed from: e */
    private static final C14418n f41310e = new C14418n(1, 0);

    /* compiled from: Ranges.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, m12616d2 = {"Lkotlin/ranges/n$a;", "", "Lkotlin/ranges/n;", "EMPTY", "Lkotlin/ranges/n;", "a", "()Lkotlin/ranges/n;", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.ranges.n$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14419a {
        private C14419a() {
        }

        @NotNull
        /* renamed from: a */
        public final C14418n m7583a() {
            return C14418n.f41310e;
        }

        public /* synthetic */ C14419a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public C14418n(long j, long j2) {
        super(j, j2, 1L);
    }

    @Override // kotlin.ranges.InterfaceC14407g
    public /* bridge */ /* synthetic */ boolean contains(Long l) {
        return m7586h(l.longValue());
    }

    @Override // kotlin.ranges.C14415l
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof C14418n) {
            if (!isEmpty() || !((C14418n) obj).isEmpty()) {
                C14418n c14418n = (C14418n) obj;
                if (m7593c() != c14418n.m7593c() || m7592d() != c14418n.m7592d()) {
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: h */
    public boolean m7586h(long j) {
        return m7593c() <= j && j <= m7592d();
    }

    @Override // kotlin.ranges.C14415l
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (m7593c() ^ (m7593c() >>> 32))) + (m7592d() ^ (m7592d() >>> 32)));
    }

    @Override // kotlin.ranges.InterfaceC14407g
    @NotNull
    /* renamed from: i */
    public Long getEndInclusive() {
        return Long.valueOf(m7592d());
    }

    @Override // kotlin.ranges.C14415l, kotlin.ranges.InterfaceC14407g
    public boolean isEmpty() {
        return m7593c() > m7592d();
    }

    @Override // kotlin.ranges.InterfaceC14407g
    @NotNull
    /* renamed from: j */
    public Long getStart() {
        return Long.valueOf(m7593c());
    }

    @Override // kotlin.ranges.C14415l
    @NotNull
    public String toString() {
        return m7593c() + ".." + m7592d();
    }
}
