package kotlin.ranges;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.Unsigned;
import kotlin.UnsignedUtils;
import kotlin.WasExperimental;
import kotlin.internal.UProgressionUtil;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p620m1.KMarkers;

@SinceKotlin(version = "1.5")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0017\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB$\b\u0000\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0086\u0002ø\u0001\u0000J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0013\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u001d\u0010\u0012\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0015\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001c"}, m12616d2 = {"Lkotlin/ranges/r;", "", "Lkotlin/r0;", "", "iterator", "", "isEmpty", "", AdnName.OTHER, "equals", "", TTDownloadField.TT_HASHCODE, "", "toString", "a", "I", "c", "()I", "first", "b", "d", "last", "e", "step", CampaignEx.JSON_NATIVE_VIDEO_START, "endInclusive", "<init>", "(IIILkotlin/jvm/internal/u;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
@WasExperimental(markerClass = {Unsigned.class})
/* renamed from: kotlin.ranges.r */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class UIntRange implements Iterable<UInt>, KMarkers {
    @NotNull

    /* renamed from: d */
    public static final C14422a f41312d = new C14422a(null);

    /* renamed from: a */
    private final int f41313a;

    /* renamed from: b */
    private final int f41314b;

    /* renamed from: c */
    private final int f41315c;

    /* compiled from: UIntRange.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, m12616d2 = {"Lkotlin/ranges/r$a;", "", "Lkotlin/r0;", "rangeStart", "rangeEnd", "", "step", "Lkotlin/ranges/r;", "a", "(III)Lkotlin/ranges/r;", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.ranges.r$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14422a {
        private C14422a() {
        }

        @NotNull
        /* renamed from: a */
        public final UIntRange m7440a(int i, int i2, int i3) {
            return new UIntRange(i, i2, i3, null);
        }

        public /* synthetic */ C14422a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ UIntRange(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3);
    }

    /* renamed from: c */
    public final int m7443c() {
        return this.f41313a;
    }

    /* renamed from: d */
    public final int m7442d() {
        return this.f41314b;
    }

    /* renamed from: e */
    public final int m7441e() {
        return this.f41315c;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof UIntRange) {
            if (!isEmpty() || !((UIntRange) obj).isEmpty()) {
                UIntRange uIntRange = (UIntRange) obj;
                if (this.f41313a != uIntRange.f41313a || this.f41314b != uIntRange.f41314b || this.f41315c != uIntRange.f41315c) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f41313a * 31) + this.f41314b) * 31) + this.f41315c;
    }

    public boolean isEmpty() {
        if (this.f41315c > 0) {
            if (UnsignedUtils.m8561c(this.f41313a, this.f41314b) > 0) {
                return true;
            }
        } else if (UnsignedUtils.m8561c(this.f41313a, this.f41314b) < 0) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    @NotNull
    public final Iterator<UInt> iterator() {
        return new C14423s(this.f41313a, this.f41314b, this.f41315c, null);
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        int i;
        if (this.f41315c > 0) {
            sb = new StringBuilder();
            sb.append(UInt.m7689b0(this.f41313a));
            sb.append("..");
            sb.append(UInt.m7689b0(this.f41314b));
            sb.append(" step ");
            i = this.f41315c;
        } else {
            sb = new StringBuilder();
            sb.append(UInt.m7689b0(this.f41313a));
            sb.append(" downTo ");
            sb.append(UInt.m7689b0(this.f41314b));
            sb.append(" step ");
            i = -this.f41315c;
        }
        sb.append(i);
        return sb.toString();
    }

    private UIntRange(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f41313a = i;
            this.f41314b = UProgressionUtil.m8522d(i, i2, i3);
            this.f41315c = i3;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    }
}
