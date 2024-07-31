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
@Metadata(m12618bv = {}, m12617d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00152\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0016B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0013\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0010\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0017"}, m12616d2 = {"Lkotlin/ranges/k;", "Lkotlin/ranges/i;", "Lkotlin/ranges/g;", "", DomainCampaignEx.LOOPBACK_VALUE, "", "h", "isEmpty", "", AdnName.OTHER, "equals", TTDownloadField.TT_HASHCODE, "", "toString", "j", "()Ljava/lang/Integer;", CampaignEx.JSON_NATIVE_VIDEO_START, "i", "endInclusive", "<init>", "(II)V", "f", "a", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.ranges.k */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14413k extends C14410i implements InterfaceC14407g<Integer> {
    @NotNull

    /* renamed from: f */
    public static final C14414a f41301f = new C14414a(null);
    @NotNull

    /* renamed from: e */
    private static final C14413k f41300e = new C14413k(1, 0);

    /* compiled from: Ranges.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, m12616d2 = {"Lkotlin/ranges/k$a;", "", "Lkotlin/ranges/k;", "EMPTY", "Lkotlin/ranges/k;", "a", "()Lkotlin/ranges/k;", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.ranges.k$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14414a {
        private C14414a() {
        }

        @NotNull
        /* renamed from: a */
        public final C14413k m7594a() {
            return C14413k.f41300e;
        }

        public /* synthetic */ C14414a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public C14413k(int i, int i2) {
        super(i, i2, 1);
    }

    @Override // kotlin.ranges.InterfaceC14407g
    public /* bridge */ /* synthetic */ boolean contains(Integer num) {
        return m7597h(num.intValue());
    }

    @Override // kotlin.ranges.C14410i
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof C14413k) {
            if (!isEmpty() || !((C14413k) obj).isEmpty()) {
                C14413k c14413k = (C14413k) obj;
                if (m7604c() != c14413k.m7604c() || m7603d() != c14413k.m7603d()) {
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: h */
    public boolean m7597h(int i) {
        return m7604c() <= i && i <= m7603d();
    }

    @Override // kotlin.ranges.C14410i
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (m7604c() * 31) + m7603d();
    }

    @Override // kotlin.ranges.InterfaceC14407g
    @NotNull
    /* renamed from: i */
    public Integer getEndInclusive() {
        return Integer.valueOf(m7603d());
    }

    @Override // kotlin.ranges.C14410i, kotlin.ranges.InterfaceC14407g
    public boolean isEmpty() {
        return m7604c() > m7603d();
    }

    @Override // kotlin.ranges.InterfaceC14407g
    @NotNull
    /* renamed from: j */
    public Integer getStart() {
        return Integer.valueOf(m7604c());
    }

    @Override // kotlin.ranges.C14410i
    @NotNull
    public String toString() {
        return m7604c() + ".." + m7603d();
    }
}
