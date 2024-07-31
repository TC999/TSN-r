package kotlin.text;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.ranges.C14413k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Regex.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\t\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, m12616d2 = {"Lkotlin/text/h;", "", "", "a", "Lkotlin/ranges/k;", "b", DomainCampaignEx.LOOPBACK_VALUE, "range", "c", "toString", "", TTDownloadField.TT_HASHCODE, AdnName.OTHER, "", "equals", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "Lkotlin/ranges/k;", "e", "()Lkotlin/ranges/k;", "<init>", "(Ljava/lang/String;Lkotlin/ranges/k;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.text.h */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14564h {
    @NotNull

    /* renamed from: a */
    private final String f41611a;
    @NotNull

    /* renamed from: b */
    private final C14413k f41612b;

    public C14564h(@NotNull String value, @NotNull C14413k range) {
        C14342f0.m8184p(value, "value");
        C14342f0.m8184p(range, "range");
        this.f41611a = value;
        this.f41612b = range;
    }

    /* renamed from: d */
    public static /* synthetic */ C14564h m6809d(C14564h c14564h, String str, C14413k c14413k, int i, Object obj) {
        if ((i & 1) != 0) {
            str = c14564h.f41611a;
        }
        if ((i & 2) != 0) {
            c14413k = c14564h.f41612b;
        }
        return c14564h.m6810c(str, c14413k);
    }

    @NotNull
    /* renamed from: a */
    public final String m6812a() {
        return this.f41611a;
    }

    @NotNull
    /* renamed from: b */
    public final C14413k m6811b() {
        return this.f41612b;
    }

    @NotNull
    /* renamed from: c */
    public final C14564h m6810c(@NotNull String value, @NotNull C14413k range) {
        C14342f0.m8184p(value, "value");
        C14342f0.m8184p(range, "range");
        return new C14564h(value, range);
    }

    @NotNull
    /* renamed from: e */
    public final C14413k m6808e() {
        return this.f41612b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof C14564h) {
                C14564h c14564h = (C14564h) obj;
                return C14342f0.m8193g(this.f41611a, c14564h.f41611a) && C14342f0.m8193g(this.f41612b, c14564h.f41612b);
            }
            return false;
        }
        return true;
    }

    @NotNull
    /* renamed from: f */
    public final String m6807f() {
        return this.f41611a;
    }

    public int hashCode() {
        String str = this.f41611a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        C14413k c14413k = this.f41612b;
        return hashCode + (c14413k != null ? c14413k.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MatchGroup(value=" + this.f41611a + ", range=" + this.f41612b + ")";
    }
}
