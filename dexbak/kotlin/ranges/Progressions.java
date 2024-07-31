package kotlin.ranges;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.collections.AbstractC14221u;
import kotlin.internal.progressionUtil;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p620m1.KMarkers;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0016\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB!\b\u0000\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\n¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0013\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0017\u0010\u0012\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0019\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, m12616d2 = {"Lkotlin/ranges/a;", "", "", "Lkotlin/collections/u;", "f", "", "isEmpty", "", AdnName.OTHER, "equals", "", TTDownloadField.TT_HASHCODE, "", "toString", "a", "C", "c", "()C", "first", "b", "d", "last", "I", "e", "()I", "step", CampaignEx.JSON_NATIVE_VIDEO_START, "endInclusive", "<init>", "(CCI)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.ranges.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class Progressions implements Iterable<Character>, KMarkers {
    @NotNull

    /* renamed from: d */
    public static final C14401a f41276d = new C14401a(null);

    /* renamed from: a */
    private final char f41277a;

    /* renamed from: b */
    private final char f41278b;

    /* renamed from: c */
    private final int f41279c;

    /* compiled from: Progressions.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u000b"}, m12616d2 = {"Lkotlin/ranges/a$a;", "", "", "rangeStart", "rangeEnd", "", "step", "Lkotlin/ranges/a;", "a", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.ranges.a$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14401a {
        private C14401a() {
        }

        @NotNull
        /* renamed from: a */
        public final Progressions m7624a(char c, char c2, int i) {
            return new Progressions(c, c2, i);
        }

        public /* synthetic */ C14401a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Progressions(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i != Integer.MIN_VALUE) {
            this.f41277a = c;
            this.f41278b = (char) progressionUtil.m8529c(c, c2, i);
            this.f41279c = i;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    }

    /* renamed from: c */
    public final char m7628c() {
        return this.f41277a;
    }

    /* renamed from: d */
    public final char m7627d() {
        return this.f41278b;
    }

    /* renamed from: e */
    public final int m7626e() {
        return this.f41279c;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Progressions) {
            if (!isEmpty() || !((Progressions) obj).isEmpty()) {
                Progressions progressions = (Progressions) obj;
                if (this.f41277a != progressions.f41277a || this.f41278b != progressions.f41278b || this.f41279c != progressions.f41279c) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    @NotNull
    /* renamed from: f */
    public AbstractC14221u iterator() {
        return new ProgressionIterators(this.f41277a, this.f41278b, this.f41279c);
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f41277a * 31) + this.f41278b) * 31) + this.f41279c;
    }

    public boolean isEmpty() {
        if (this.f41279c > 0) {
            if (C14342f0.m8180t(this.f41277a, this.f41278b) > 0) {
                return true;
            }
        } else if (C14342f0.m8180t(this.f41277a, this.f41278b) < 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        int i;
        if (this.f41279c > 0) {
            sb = new StringBuilder();
            sb.append(this.f41277a);
            sb.append("..");
            sb.append(this.f41278b);
            sb.append(" step ");
            i = this.f41279c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f41277a);
            sb.append(" downTo ");
            sb.append(this.f41278b);
            sb.append(" step ");
            i = -this.f41279c;
        }
        sb.append(i);
        return sb.toString();
    }
}
