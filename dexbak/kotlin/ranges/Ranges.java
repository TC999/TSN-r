package kotlin.ranges;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00162\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0017B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0013\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010\u0011\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0018"}, m12616d2 = {"Lkotlin/ranges/c;", "Lkotlin/ranges/a;", "Lkotlin/ranges/g;", "", DomainCampaignEx.LOOPBACK_VALUE, "", "h", "isEmpty", "", AdnName.OTHER, "equals", "", TTDownloadField.TT_HASHCODE, "", "toString", "j", "()Ljava/lang/Character;", CampaignEx.JSON_NATIVE_VIDEO_START, "i", "endInclusive", "<init>", "(CC)V", "f", "a", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.ranges.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Ranges extends Progressions implements InterfaceC14407g<Character> {
    @NotNull

    /* renamed from: f */
    public static final C14402a f41285f = new C14402a(null);
    @NotNull

    /* renamed from: e */
    private static final Ranges f41284e = new Ranges((char) 1, (char) 0);

    /* compiled from: Ranges.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, m12616d2 = {"Lkotlin/ranges/c$a;", "", "Lkotlin/ranges/c;", "EMPTY", "Lkotlin/ranges/c;", "a", "()Lkotlin/ranges/c;", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.ranges.c$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14402a {
        private C14402a() {
        }

        @NotNull
        /* renamed from: a */
        public final Ranges m7618a() {
            return Ranges.f41284e;
        }

        public /* synthetic */ C14402a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Ranges(char c, char c2) {
        super(c, c2, 1);
    }

    @Override // kotlin.ranges.InterfaceC14407g
    public /* bridge */ /* synthetic */ boolean contains(Character ch) {
        return m7621h(ch.charValue());
    }

    @Override // kotlin.ranges.Progressions
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Ranges) {
            if (!isEmpty() || !((Ranges) obj).isEmpty()) {
                Ranges ranges = (Ranges) obj;
                if (m7628c() != ranges.m7628c() || m7627d() != ranges.m7627d()) {
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: h */
    public boolean m7621h(char c) {
        return C14342f0.m8180t(m7628c(), c) <= 0 && C14342f0.m8180t(c, m7627d()) <= 0;
    }

    @Override // kotlin.ranges.Progressions
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (m7628c() * 31) + m7627d();
    }

    @Override // kotlin.ranges.InterfaceC14407g
    @NotNull
    /* renamed from: i */
    public Character getEndInclusive() {
        return Character.valueOf(m7627d());
    }

    @Override // kotlin.ranges.Progressions, kotlin.ranges.InterfaceC14407g
    public boolean isEmpty() {
        return C14342f0.m8180t(m7628c(), m7627d()) > 0;
    }

    @Override // kotlin.ranges.InterfaceC14407g
    @NotNull
    /* renamed from: j */
    public Character getStart() {
        return Character.valueOf(m7628c());
    }

    @Override // kotlin.ranges.Progressions
    @NotNull
    public String toString() {
        return m7628c() + ".." + m7627d();
    }
}
