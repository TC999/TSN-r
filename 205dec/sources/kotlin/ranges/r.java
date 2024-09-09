package kotlin.ranges;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.g1;
import kotlin.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: UIntRange.kt */
@SinceKotlin(version = "1.5")
@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0017\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB$\b\u0000\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0086\u0002\u00f8\u0001\u0000J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0013\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u001d\u0010\u0012\u001a\u00020\u00028\u0006\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0015\u001a\u00020\u00028\u0006\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u001d"}, d2 = {"Lkotlin/ranges/r;", "", "Lkotlin/r0;", "", "iterator", "", "isEmpty", "", "other", "equals", "", "hashCode", "", "toString", "a", "I", "c", "()I", "first", "b", "g", "last", "k", "step", CampaignEx.JSON_NATIVE_VIDEO_START, "endInclusive", "<init>", "(IIILkotlin/jvm/internal/u;)V", "d", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class r implements Iterable<r0>, e2.a {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final a f55812d = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final int f55813a;

    /* renamed from: b  reason: collision with root package name */
    private final int f55814b;

    /* renamed from: c  reason: collision with root package name */
    private final int f55815c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: UIntRange.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lkotlin/ranges/r$a;", "", "Lkotlin/r0;", "rangeStart", "rangeEnd", "", "step", "Lkotlin/ranges/r;", "a", "(III)Lkotlin/ranges/r;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @NotNull
        public final r a(int i4, int i5, int i6) {
            return new r(i4, i5, i6, null);
        }
    }

    private r(int i4, int i5, int i6) {
        if (i6 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i6 != Integer.MIN_VALUE) {
            this.f55813a = i4;
            this.f55814b = kotlin.internal.d.d(i4, i5, i6);
            this.f55815c = i6;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    }

    public /* synthetic */ r(int i4, int i5, int i6, kotlin.jvm.internal.u uVar) {
        this(i4, i5, i6);
    }

    public final int c() {
        return this.f55813a;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof r) {
            if (!isEmpty() || !((r) obj).isEmpty()) {
                r rVar = (r) obj;
                if (c() != rVar.c() || g() != rVar.g() || this.f55815c != rVar.f55815c) {
                }
            }
            return true;
        }
        return false;
    }

    public final int g() {
        return this.f55814b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((c() * 31) + g()) * 31) + this.f55815c;
    }

    public boolean isEmpty() {
        if (this.f55815c > 0) {
            if (g1.c(c(), g()) > 0) {
                return true;
            }
        } else if (g1.c(c(), g()) < 0) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    @NotNull
    public final Iterator<r0> iterator() {
        return new s(c(), g(), this.f55815c, null);
    }

    public final int k() {
        return this.f55815c;
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        int i4;
        if (this.f55815c > 0) {
            sb = new StringBuilder();
            sb.append((Object) r0.g0(c()));
            sb.append("..");
            sb.append((Object) r0.g0(g()));
            sb.append(" step ");
            i4 = this.f55815c;
        } else {
            sb = new StringBuilder();
            sb.append((Object) r0.g0(c()));
            sb.append(" downTo ");
            sb.append((Object) r0.g0(g()));
            sb.append(" step ");
            i4 = -this.f55815c;
        }
        sb.append(i4);
        return sb.toString();
    }
}
