package kotlin.ranges;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.g1;
import kotlin.v0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ULongRange.kt */
@SinceKotlin(version = "1.5")
@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\b\u0017\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB$\b\u0000\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0086\u0002\u00f8\u0001\u0000J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0013\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u001d\u0010\u0012\u001a\u00020\u00028\u0006\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0015\u001a\u00020\u00028\u0006\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u001e"}, d2 = {"Lkotlin/ranges/u;", "", "Lkotlin/v0;", "", "iterator", "", "isEmpty", "", "other", "equals", "", "hashCode", "", "toString", "a", "J", "c", "()J", "first", "b", "g", "last", "", "k", "step", CampaignEx.JSON_NATIVE_VIDEO_START, "endInclusive", "<init>", "(JJJLkotlin/jvm/internal/u;)V", "d", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class u implements Iterable<v0>, e2.a {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final a f55822d = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final long f55823a;

    /* renamed from: b  reason: collision with root package name */
    private final long f55824b;

    /* renamed from: c  reason: collision with root package name */
    private final long f55825c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ULongRange.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lkotlin/ranges/u$a;", "", "Lkotlin/v0;", "rangeStart", "rangeEnd", "", "step", "Lkotlin/ranges/u;", "a", "(JJJ)Lkotlin/ranges/u;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @NotNull
        public final u a(long j4, long j5, long j6) {
            return new u(j4, j5, j6, null);
        }
    }

    private u(long j4, long j5, long j6) {
        if (j6 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j6 != Long.MIN_VALUE) {
            this.f55823a = j4;
            this.f55824b = kotlin.internal.d.c(j4, j5, j6);
            this.f55825c = j6;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
    }

    public /* synthetic */ u(long j4, long j5, long j6, kotlin.jvm.internal.u uVar) {
        this(j4, j5, j6);
    }

    public final long c() {
        return this.f55823a;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof u) {
            if (!isEmpty() || !((u) obj).isEmpty()) {
                u uVar = (u) obj;
                if (c() != uVar.c() || g() != uVar.g() || this.f55825c != uVar.f55825c) {
                }
            }
            return true;
        }
        return false;
    }

    public final long g() {
        return this.f55824b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j4 = this.f55825c;
        return ((int) (j4 ^ (j4 >>> 32))) + (((((int) v0.i(c() ^ v0.i(c() >>> 32))) * 31) + ((int) v0.i(g() ^ v0.i(g() >>> 32)))) * 31);
    }

    public boolean isEmpty() {
        int i4 = (this.f55825c > 0L ? 1 : (this.f55825c == 0L ? 0 : -1));
        int g4 = g1.g(c(), g());
        if (i4 > 0) {
            if (g4 > 0) {
                return true;
            }
        } else if (g4 < 0) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    @NotNull
    public final Iterator<v0> iterator() {
        return new v(c(), g(), this.f55825c, null);
    }

    public final long k() {
        return this.f55825c;
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        long j4;
        if (this.f55825c > 0) {
            sb = new StringBuilder();
            sb.append((Object) v0.g0(c()));
            sb.append("..");
            sb.append((Object) v0.g0(g()));
            sb.append(" step ");
            j4 = this.f55825c;
        } else {
            sb = new StringBuilder();
            sb.append((Object) v0.g0(c()));
            sb.append(" downTo ");
            sb.append((Object) v0.g0(g()));
            sb.append(" step ");
            j4 = -this.f55825c;
        }
        sb.append(j4);
        return sb.toString();
    }
}
