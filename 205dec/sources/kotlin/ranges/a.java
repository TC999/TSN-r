package kotlin.ranges;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Progressions.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0016\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB!\b\u0000\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\n\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0013\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0019\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001f"}, d2 = {"Lkotlin/ranges/a;", "", "", "Lkotlin/collections/u;", "l", "", "isEmpty", "", "other", "equals", "", "hashCode", "", "toString", "a", "C", "c", "()C", "first", "b", "g", "last", "I", "k", "()I", "step", CampaignEx.JSON_NATIVE_VIDEO_START, "endInclusive", "<init>", "(CCI)V", "d", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class a implements Iterable<Character>, e2.a {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final C1104a f55776d = new C1104a(null);

    /* renamed from: a  reason: collision with root package name */
    private final char f55777a;

    /* renamed from: b  reason: collision with root package name */
    private final char f55778b;

    /* renamed from: c  reason: collision with root package name */
    private final int f55779c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Progressions.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\u000b"}, d2 = {"Lkotlin/ranges/a$a;", "", "", "rangeStart", "rangeEnd", "", "step", "Lkotlin/ranges/a;", "a", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* renamed from: kotlin.ranges.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1104a {
        private C1104a() {
        }

        public /* synthetic */ C1104a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @NotNull
        public final a a(char c4, char c5, int i4) {
            return new a(c4, c5, i4);
        }
    }

    public a(char c4, char c5, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i4 != Integer.MIN_VALUE) {
            this.f55777a = c4;
            this.f55778b = (char) kotlin.internal.c.c(c4, c5, i4);
            this.f55779c = i4;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    }

    public final char c() {
        return this.f55777a;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (this.f55777a != aVar.f55777a || this.f55778b != aVar.f55778b || this.f55779c != aVar.f55779c) {
                }
            }
            return true;
        }
        return false;
    }

    public final char g() {
        return this.f55778b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f55777a * 31) + this.f55778b) * 31) + this.f55779c;
    }

    public boolean isEmpty() {
        if (this.f55779c > 0) {
            if (f0.t(this.f55777a, this.f55778b) > 0) {
                return true;
            }
        } else if (f0.t(this.f55777a, this.f55778b) < 0) {
            return true;
        }
        return false;
    }

    public final int k() {
        return this.f55779c;
    }

    @Override // java.lang.Iterable
    @NotNull
    /* renamed from: l */
    public kotlin.collections.u iterator() {
        return new b(this.f55777a, this.f55778b, this.f55779c);
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        int i4;
        if (this.f55779c > 0) {
            sb = new StringBuilder();
            sb.append(this.f55777a);
            sb.append("..");
            sb.append(this.f55778b);
            sb.append(" step ");
            i4 = this.f55779c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f55777a);
            sb.append(" downTo ");
            sb.append(this.f55778b);
            sb.append(" step ");
            i4 = -this.f55779c;
        }
        sb.append(i4);
        return sb.toString();
    }
}
