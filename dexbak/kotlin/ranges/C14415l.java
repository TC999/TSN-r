package kotlin.ranges;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.collections.AbstractC14214r0;
import kotlin.internal.progressionUtil;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p620m1.KMarkers;

/* compiled from: Progressions.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0016\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB!\b\u0000\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0013\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0017\u0010\u0012\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011¨\u0006\u001c"}, m12616d2 = {"Lkotlin/ranges/l;", "", "", "Lkotlin/collections/r0;", "f", "", "isEmpty", "", AdnName.OTHER, "equals", "", TTDownloadField.TT_HASHCODE, "", "toString", "a", "J", "c", "()J", "first", "b", "d", "last", "e", "step", CampaignEx.JSON_NATIVE_VIDEO_START, "endInclusive", "<init>", "(JJJ)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.ranges.l */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class C14415l implements Iterable<Long>, KMarkers {
    @NotNull

    /* renamed from: d */
    public static final C14416a f41302d = new C14416a(null);

    /* renamed from: a */
    private final long f41303a;

    /* renamed from: b */
    private final long f41304b;

    /* renamed from: c */
    private final long f41305c;

    /* compiled from: Progressions.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002¨\u0006\n"}, m12616d2 = {"Lkotlin/ranges/l$a;", "", "", "rangeStart", "rangeEnd", "step", "Lkotlin/ranges/l;", "a", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.ranges.l$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14416a {
        private C14416a() {
        }

        @NotNull
        /* renamed from: a */
        public final C14415l m7589a(long j, long j2, long j3) {
            return new C14415l(j, j2, j3);
        }

        public /* synthetic */ C14416a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public C14415l(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 != Long.MIN_VALUE) {
            this.f41303a = j;
            this.f41304b = progressionUtil.m8528d(j, j2, j3);
            this.f41305c = j3;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
    }

    /* renamed from: c */
    public final long m7593c() {
        return this.f41303a;
    }

    /* renamed from: d */
    public final long m7592d() {
        return this.f41304b;
    }

    /* renamed from: e */
    public final long m7591e() {
        return this.f41305c;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof C14415l) {
            if (!isEmpty() || !((C14415l) obj).isEmpty()) {
                C14415l c14415l = (C14415l) obj;
                if (this.f41303a != c14415l.f41303a || this.f41304b != c14415l.f41304b || this.f41305c != c14415l.f41305c) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    @NotNull
    /* renamed from: f */
    public AbstractC14214r0 iterator() {
        return new C14417m(this.f41303a, this.f41304b, this.f41305c);
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j = 31;
        long j2 = this.f41303a;
        long j3 = this.f41304b;
        long j4 = j * (((j2 ^ (j2 >>> 32)) * j) + (j3 ^ (j3 >>> 32)));
        long j5 = this.f41305c;
        return (int) (j4 + (j5 ^ (j5 >>> 32)));
    }

    public boolean isEmpty() {
        int i = (this.f41305c > 0L ? 1 : (this.f41305c == 0L ? 0 : -1));
        long j = this.f41303a;
        long j2 = this.f41304b;
        if (i > 0) {
            if (j > j2) {
                return true;
            }
        } else if (j < j2) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        long j;
        if (this.f41305c > 0) {
            sb = new StringBuilder();
            sb.append(this.f41303a);
            sb.append("..");
            sb.append(this.f41304b);
            sb.append(" step ");
            j = this.f41305c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f41303a);
            sb.append(" downTo ");
            sb.append(this.f41304b);
            sb.append(" step ");
            j = -this.f41305c;
        }
        sb.append(j);
        return sb.toString();
    }
}
