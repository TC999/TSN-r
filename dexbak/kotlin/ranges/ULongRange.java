package kotlin.ranges;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.Unsigned;
import kotlin.UnsignedUtils;
import kotlin.WasExperimental;
import kotlin.internal.UProgressionUtil;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p620m1.KMarkers;

@SinceKotlin(version = "1.5")
@Metadata(m12618bv = {}, m12617d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\b\u0017\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB$\b\u0000\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0016ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0086\u0002ø\u0001\u0000J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0013\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u001d\u0010\u0012\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0015\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001d"}, m12616d2 = {"Lkotlin/ranges/u;", "", "Lkotlin/v0;", "", "iterator", "", "isEmpty", "", AdnName.OTHER, "equals", "", TTDownloadField.TT_HASHCODE, "", "toString", "a", "J", "c", "()J", "first", "b", "d", "last", "", "e", "step", CampaignEx.JSON_NATIVE_VIDEO_START, "endInclusive", "<init>", "(JJJLkotlin/jvm/internal/u;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
@WasExperimental(markerClass = {Unsigned.class})
/* renamed from: kotlin.ranges.u */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class ULongRange implements Iterable<ULong>, KMarkers {
    @NotNull

    /* renamed from: d */
    public static final C14426a f41322d = new C14426a(null);

    /* renamed from: a */
    private final long f41323a;

    /* renamed from: b */
    private final long f41324b;

    /* renamed from: c */
    private final long f41325c;

    /* compiled from: ULongRange.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, m12616d2 = {"Lkotlin/ranges/u$a;", "", "Lkotlin/v0;", "rangeStart", "rangeEnd", "", "step", "Lkotlin/ranges/u;", "a", "(JJJ)Lkotlin/ranges/u;", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.ranges.u$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14426a {
        private C14426a() {
        }

        @NotNull
        /* renamed from: a */
        public final ULongRange m7431a(long j, long j2, long j3) {
            return new ULongRange(j, j2, j3, null);
        }

        public /* synthetic */ C14426a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ ULongRange(long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3);
    }

    /* renamed from: c */
    public final long m7434c() {
        return this.f41323a;
    }

    /* renamed from: d */
    public final long m7433d() {
        return this.f41324b;
    }

    /* renamed from: e */
    public final long m7432e() {
        return this.f41325c;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ULongRange) {
            if (!isEmpty() || !((ULongRange) obj).isEmpty()) {
                ULongRange uLongRange = (ULongRange) obj;
                if (this.f41323a != uLongRange.f41323a || this.f41324b != uLongRange.f41324b || this.f41325c != uLongRange.f41325c) {
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
        long j = this.f41323a;
        long j2 = this.f41324b;
        long j3 = this.f41325c;
        return ((int) (j3 ^ (j3 >>> 32))) + (((((int) ULong.m5889h(j ^ ULong.m5889h(j >>> 32))) * 31) + ((int) ULong.m5889h(j2 ^ ULong.m5889h(j2 >>> 32)))) * 31);
    }

    public boolean isEmpty() {
        int i = (this.f41325c > 0L ? 1 : (this.f41325c == 0L ? 0 : -1));
        int m8557g = UnsignedUtils.m8557g(this.f41323a, this.f41324b);
        if (i > 0) {
            if (m8557g > 0) {
                return true;
            }
        } else if (m8557g < 0) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    @NotNull
    public final Iterator<ULong> iterator() {
        return new C14427v(this.f41323a, this.f41324b, this.f41325c, null);
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        long j;
        if (this.f41325c > 0) {
            sb = new StringBuilder();
            sb.append(ULong.m5900b0(this.f41323a));
            sb.append("..");
            sb.append(ULong.m5900b0(this.f41324b));
            sb.append(" step ");
            j = this.f41325c;
        } else {
            sb = new StringBuilder();
            sb.append(ULong.m5900b0(this.f41323a));
            sb.append(" downTo ");
            sb.append(ULong.m5900b0(this.f41324b));
            sb.append(" step ");
            j = -this.f41325c;
        }
        sb.append(j);
        return sb.toString();
    }

    private ULongRange(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 != Long.MIN_VALUE) {
            this.f41323a = j;
            this.f41324b = UProgressionUtil.m8523c(j, j2, j3);
            this.f41325c = j3;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
    }
}
